package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

abstract class RetriableStream<ReqT> implements ClientStream {
  private static final Status CANCELLED_BECAUSE_COMMITTED;
  
  @VisibleForTesting
  static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", Metadata.ASCII_STRING_MARSHALLER);
  
  @VisibleForTesting
  static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", Metadata.ASCII_STRING_MARSHALLER);
  
  private static Random random;
  
  private final Executor callExecutor;
  
  private final long channelBufferLimit;
  
  private final ChannelBufferMeter channelBufferUsed;
  
  private final Metadata headers;
  
  private final Object lock = new Object();
  
  private ClientStreamListener masterListener;
  
  private final MethodDescriptor<ReqT, ?> method;
  
  private long nextBackoffIntervalNanos;
  
  private boolean noMoreTransparentRetry;
  
  private final long perRpcBufferLimit;
  
  @GuardedBy("lock")
  private long perRpcBufferUsed;
  
  private RetryPolicy retryPolicy;
  
  private final RetryPolicy.Provider retryPolicyProvider;
  
  private final ScheduledExecutorService scheduledExecutorService;
  
  private Future<?> scheduledRetry;
  
  private volatile State state = new State(new ArrayList<BufferEntry>(8), Collections.emptyList(), null, false, false);
  
  @Nullable
  private final Throttle throttle;
  
  static {
    CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
    random = new Random();
  }
  
  RetriableStream(MethodDescriptor<ReqT, ?> paramMethodDescriptor, Metadata paramMetadata, ChannelBufferMeter paramChannelBufferMeter, long paramLong1, long paramLong2, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, RetryPolicy.Provider paramProvider, @Nullable Throttle paramThrottle) {
    this.method = paramMethodDescriptor;
    this.channelBufferUsed = paramChannelBufferMeter;
    this.perRpcBufferLimit = paramLong1;
    this.channelBufferLimit = paramLong2;
    this.callExecutor = paramExecutor;
    this.scheduledExecutorService = paramScheduledExecutorService;
    this.headers = paramMetadata;
    this.retryPolicyProvider = (RetryPolicy.Provider)Preconditions.checkNotNull(paramProvider, "retryPolicyProvider");
    this.throttle = paramThrottle;
  }
  
  @CheckReturnValue
  @Nullable
  private Runnable commit(Substream paramSubstream) {
    synchronized (this.lock) {
      if (this.state.winningSubstream != null)
        return null; 
      Collection<Substream> collection = this.state.drainedSubstreams;
      this.state = this.state.committed(paramSubstream);
      this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
      CommitTask commitTask = new CommitTask();
      this(this, collection, paramSubstream);
      return (Runnable)commitTask;
    } 
  }
  
  private void commitAndRun(Substream paramSubstream) {
    Runnable runnable = commit(paramSubstream);
    if (runnable != null)
      runnable.run(); 
  }
  
  private Substream createSubstream(int paramInt) {
    Substream substream = new Substream(paramInt);
    substream.stream = newSubstream((ClientStreamTracer.Factory)new Object(this, (ClientStreamTracer)new BufferSizeTracer(this, substream)), updateHeaders(this.headers, paramInt));
    return substream;
  }
  
  private void delayOrExecute(BufferEntry paramBufferEntry) {
    synchronized (this.lock) {
      if (!this.state.passThrough)
        this.state.buffer.add(paramBufferEntry); 
      Collection<Substream> collection = this.state.drainedSubstreams;
      null = (Object<Substream>)collection.iterator();
      while (null.hasNext())
        paramBufferEntry.runWith(null.next()); 
      return;
    } 
  }
  
  private void drain(Substream paramSubstream) {
    boolean bool = false;
    ArrayList arrayList = null;
    int i = 0;
    while (true) {
      synchronized (this.lock) {
        State state = this.state;
        if (state.winningSubstream != null && state.winningSubstream != paramSubstream) {
          paramSubstream.stream.cancel(CANCELLED_BECAUSE_COMMITTED);
          return;
        } 
        if (i == state.buffer.size()) {
          this.state = state.substreamDrained(paramSubstream);
          return;
        } 
        if (paramSubstream.closed)
          return; 
        int j = Math.min(i + 128, state.buffer.size());
        if (arrayList == null) {
          arrayList = new ArrayList();
          this(state.buffer.subList(i, j));
        } else {
          arrayList.clear();
          arrayList.addAll(state.buffer.subList(i, j));
        } 
        for (Object null : arrayList) {
          state = this.state;
          if (state.winningSubstream != null && state.winningSubstream != paramSubstream)
            break; 
          if (state.cancelled) {
            if (state.winningSubstream == paramSubstream)
              bool = true; 
            Preconditions.checkState(bool, "substream should be CANCELLED_BECAUSE_COMMITTED already");
            return;
          } 
          null.runWith(paramSubstream);
        } 
        i = j;
      } 
    } 
  }
  
  @VisibleForTesting
  static void setRandom(Random paramRandom) {
    random = paramRandom;
  }
  
  public final void cancel(Status paramStatus) {
    null = new Substream(0);
    null.stream = (ClientStream)new NoopClientStream();
    Runnable runnable = commit(null);
    if (runnable != null) {
      Future<?> future = this.scheduledRetry;
      if (future != null) {
        future.cancel(false);
        this.scheduledRetry = null;
      } 
      this.masterListener.closed(paramStatus, new Metadata());
      runnable.run();
      return;
    } 
    this.state.winningSubstream.stream.cancel(paramStatus);
    synchronized (this.lock) {
      this.state = this.state.cancelled();
      return;
    } 
  }
  
  public final void flush() {
    State state = this.state;
    if (state.passThrough) {
      state.winningSubstream.stream.flush();
      return;
    } 
    delayOrExecute((BufferEntry)new FlushEntry(this));
  }
  
  public final Attributes getAttributes() {
    return (this.state.winningSubstream != null) ? this.state.winningSubstream.stream.getAttributes() : Attributes.EMPTY;
  }
  
  public final void halfClose() {
    delayOrExecute((BufferEntry)new HalfCloseEntry(this));
  }
  
  boolean hasHedging() {
    return false;
  }
  
  public final boolean isReady() {
    Iterator<Substream> iterator = this.state.drainedSubstreams.iterator();
    while (iterator.hasNext()) {
      if (((Substream)iterator.next()).stream.isReady())
        return true; 
    } 
    return false;
  }
  
  abstract ClientStream newSubstream(ClientStreamTracer.Factory paramFactory, Metadata paramMetadata);
  
  abstract void postCommit();
  
  @CheckReturnValue
  @Nullable
  abstract Status prestart();
  
  public final void request(int paramInt) {
    State state = this.state;
    if (state.passThrough) {
      state.winningSubstream.stream.request(paramInt);
      return;
    } 
    delayOrExecute((BufferEntry)new RequestEntry(this, paramInt));
  }
  
  final void sendMessage(ReqT paramReqT) {
    State state = this.state;
    if (state.passThrough) {
      state.winningSubstream.stream.writeMessage(this.method.streamRequest(paramReqT));
      return;
    } 
    delayOrExecute((BufferEntry)new SendMessageEntry(this, paramReqT));
  }
  
  public final void setAuthority(String paramString) {
    delayOrExecute((BufferEntry)new AuthorityEntry(this, paramString));
  }
  
  public final void setCompressor(Compressor paramCompressor) {
    delayOrExecute((BufferEntry)new CompressorEntry(this, paramCompressor));
  }
  
  public final void setDecompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {
    delayOrExecute((BufferEntry)new DecompressorRegistryEntry(this, paramDecompressorRegistry));
  }
  
  public final void setFullStreamDecompression(boolean paramBoolean) {
    delayOrExecute((BufferEntry)new FullStreamDecompressionEntry(this, paramBoolean));
  }
  
  public final void setMaxInboundMessageSize(int paramInt) {
    delayOrExecute((BufferEntry)new MaxInboundMessageSizeEntry(this, paramInt));
  }
  
  public final void setMaxOutboundMessageSize(int paramInt) {
    delayOrExecute((BufferEntry)new MaxOutboundMessageSizeEntry(this, paramInt));
  }
  
  public final void setMessageCompression(boolean paramBoolean) {
    delayOrExecute((BufferEntry)new MessageCompressionEntry(this, paramBoolean));
  }
  
  public final void start(ClientStreamListener paramClientStreamListener) {
    this.masterListener = paramClientStreamListener;
    Status status = prestart();
    if (status != null) {
      cancel(status);
      return;
    } 
    synchronized (this.lock) {
      List<BufferEntry> list = this.state.buffer;
      StartEntry startEntry = new StartEntry();
      this(this);
      list.add(startEntry);
      drain(createSubstream(0));
      return;
    } 
  }
  
  @VisibleForTesting
  final Metadata updateHeaders(Metadata paramMetadata, int paramInt) {
    Metadata metadata = new Metadata();
    metadata.merge(paramMetadata);
    if (paramInt > 0)
      metadata.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(paramInt)); 
    return metadata;
  }
  
  public final void writeMessage(InputStream paramInputStream) {
    throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
  }
  
  class RetriableStream {}
  
  class RetriableStream {}
  
  class RetriableStream {}
  
  class RetriableStream {}
  
  private static final class State {
    @Nullable
    final List<RetriableStream.BufferEntry> buffer;
    
    final boolean cancelled;
    
    final Collection<RetriableStream.Substream> drainedSubstreams;
    
    final boolean passThrough;
    
    @Nullable
    final RetriableStream.Substream winningSubstream;
    
    State(@Nullable List<RetriableStream.BufferEntry> param1List, Collection<RetriableStream.Substream> param1Collection, @Nullable RetriableStream.Substream param1Substream, boolean param1Boolean1, boolean param1Boolean2) {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial <init> : ()V
      //   4: aload_0
      //   5: aload_1
      //   6: putfield buffer : Ljava/util/List;
      //   9: aload_0
      //   10: aload_2
      //   11: ldc 'drainedSubstreams'
      //   13: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   16: checkcast java/util/Collection
      //   19: putfield drainedSubstreams : Ljava/util/Collection;
      //   22: aload_0
      //   23: aload_3
      //   24: putfield winningSubstream : Lio/grpc/internal/RetriableStream$Substream;
      //   27: aload_0
      //   28: iload #4
      //   30: putfield cancelled : Z
      //   33: aload_0
      //   34: iload #5
      //   36: putfield passThrough : Z
      //   39: iconst_0
      //   40: istore #6
      //   42: iload #5
      //   44: ifeq -> 60
      //   47: aload_1
      //   48: ifnonnull -> 54
      //   51: goto -> 60
      //   54: iconst_0
      //   55: istore #7
      //   57: goto -> 63
      //   60: iconst_1
      //   61: istore #7
      //   63: iload #7
      //   65: ldc 'passThrough should imply buffer is null'
      //   67: invokestatic checkState : (ZLjava/lang/Object;)V
      //   70: iload #5
      //   72: ifeq -> 88
      //   75: aload_3
      //   76: ifnull -> 82
      //   79: goto -> 88
      //   82: iconst_0
      //   83: istore #7
      //   85: goto -> 91
      //   88: iconst_1
      //   89: istore #7
      //   91: iload #7
      //   93: ldc 'passThrough should imply winningSubstream != null'
      //   95: invokestatic checkState : (ZLjava/lang/Object;)V
      //   98: iload #5
      //   100: ifeq -> 148
      //   103: aload_2
      //   104: invokeinterface size : ()I
      //   109: iconst_1
      //   110: if_icmpne -> 123
      //   113: aload_2
      //   114: aload_3
      //   115: invokeinterface contains : (Ljava/lang/Object;)Z
      //   120: ifne -> 148
      //   123: aload_2
      //   124: invokeinterface size : ()I
      //   129: ifne -> 142
      //   132: aload_3
      //   133: getfield closed : Z
      //   136: ifeq -> 142
      //   139: goto -> 148
      //   142: iconst_0
      //   143: istore #5
      //   145: goto -> 151
      //   148: iconst_1
      //   149: istore #5
      //   151: iload #5
      //   153: ldc 'passThrough should imply winningSubstream is drained'
      //   155: invokestatic checkState : (ZLjava/lang/Object;)V
      //   158: iload #4
      //   160: ifeq -> 171
      //   163: iload #6
      //   165: istore #4
      //   167: aload_3
      //   168: ifnull -> 174
      //   171: iconst_1
      //   172: istore #4
      //   174: iload #4
      //   176: ldc 'cancelled should imply committed'
      //   178: invokestatic checkState : (ZLjava/lang/Object;)V
      //   181: return
    }
    
    @CheckReturnValue
    State cancelled() {
      return new State(this.buffer, this.drainedSubstreams, this.winningSubstream, true, this.passThrough);
    }
    
    @CheckReturnValue
    State committed(RetriableStream.Substream param1Substream) {
      boolean bool;
      List<?> list1;
      if (this.winningSubstream == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Already committed");
      List<RetriableStream.BufferEntry> list = this.buffer;
      if (this.drainedSubstreams.contains(param1Substream)) {
        Set<RetriableStream.Substream> set = Collections.singleton(param1Substream);
        list = null;
        bool = true;
      } else {
        list1 = Collections.emptyList();
        bool = false;
      } 
      return new State(list, (Collection)list1, param1Substream, this.cancelled, bool);
    }
    
    @CheckReturnValue
    State substreamClosed(RetriableStream.Substream param1Substream) {
      param1Substream.closed = true;
      if (this.drainedSubstreams.contains(param1Substream)) {
        ArrayList<RetriableStream.Substream> arrayList = new ArrayList<RetriableStream.Substream>(this.drainedSubstreams);
        arrayList.remove(param1Substream);
        Collection<RetriableStream.Substream> collection = Collections.unmodifiableCollection(arrayList);
        return new State(this.buffer, collection, this.winningSubstream, this.cancelled, this.passThrough);
      } 
      return this;
    }
    
    @CheckReturnValue
    State substreamDrained(RetriableStream.Substream param1Substream) {
      List<RetriableStream.BufferEntry> list1;
      Collection<RetriableStream.Substream> collection;
      boolean bool = this.passThrough;
      boolean bool1 = true;
      Preconditions.checkState(bool ^ true, "Already passThrough");
      if (param1Substream.closed) {
        collection = this.drainedSubstreams;
      } else if (this.drainedSubstreams.isEmpty()) {
        collection = Collections.singletonList(param1Substream);
      } else {
        ArrayList<RetriableStream.Substream> arrayList = new ArrayList<RetriableStream.Substream>(this.drainedSubstreams);
        arrayList.add(param1Substream);
        collection = Collections.unmodifiableCollection(arrayList);
      } 
      if (this.winningSubstream != null) {
        bool = true;
      } else {
        bool = false;
      } 
      List<RetriableStream.BufferEntry> list2 = this.buffer;
      if (bool) {
        if (this.winningSubstream != param1Substream)
          bool1 = false; 
        Preconditions.checkState(bool1, "Another RPC attempt has already committed");
        param1Substream = null;
      } else {
        list1 = list2;
      } 
      return new State(list1, collection, this.winningSubstream, this.cancelled, bool);
    }
  }
  
  class RetriableStream {}
  
  class RetriableStream {}
  
  class RetriableStream {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\RetriableStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */