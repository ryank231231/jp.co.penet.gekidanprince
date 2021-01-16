package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
  private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS;
  
  private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
  
  private final Executor callExecutor;
  
  private final CallOptions callOptions;
  
  private boolean cancelCalled;
  
  private volatile boolean cancelListenersShouldBeRemoved;
  
  private final Context.CancellationListener cancellationListener;
  
  private final CallTracer channelCallsTracer;
  
  private final ClientTransportProvider clientTransportProvider;
  
  private CompressorRegistry compressorRegistry;
  
  private final Context context;
  
  private ScheduledExecutorService deadlineCancellationExecutor;
  
  private volatile ScheduledFuture<?> deadlineCancellationFuture;
  
  private DecompressorRegistry decompressorRegistry;
  
  private boolean fullStreamDecompression;
  
  private boolean halfCloseCalled;
  
  private final MethodDescriptor<ReqT, RespT> method;
  
  private final boolean retryEnabled;
  
  private ClientStream stream;
  
  private final boolean unaryRequest;
  
  static {
    FULL_STREAM_DECOMPRESSION_ENCODINGS = "gzip".getBytes(Charset.forName("US-ASCII"));
  }
  
  ClientCallImpl(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, Executor paramExecutor, CallOptions paramCallOptions, ClientTransportProvider paramClientTransportProvider, ScheduledExecutorService paramScheduledExecutorService, CallTracer paramCallTracer, boolean paramBoolean) {
    boolean bool;
    this.cancellationListener = new ContextCancellationListener();
    this.decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    this.compressorRegistry = CompressorRegistry.getDefaultInstance();
    this.method = paramMethodDescriptor;
    if (paramExecutor == MoreExecutors.directExecutor()) {
      paramExecutor = new SerializeReentrantCallsDirectExecutor();
    } else {
      paramExecutor = new SerializingExecutor(paramExecutor);
    } 
    this.callExecutor = paramExecutor;
    this.channelCallsTracer = paramCallTracer;
    this.context = Context.current();
    if (paramMethodDescriptor.getType() == MethodDescriptor.MethodType.UNARY || paramMethodDescriptor.getType() == MethodDescriptor.MethodType.SERVER_STREAMING) {
      bool = true;
    } else {
      bool = false;
    } 
    this.unaryRequest = bool;
    this.callOptions = paramCallOptions;
    this.clientTransportProvider = paramClientTransportProvider;
    this.deadlineCancellationExecutor = paramScheduledExecutorService;
    this.retryEnabled = paramBoolean;
  }
  
  private void closeObserver(ClientCall.Listener<RespT> paramListener, Status paramStatus, Metadata paramMetadata) {
    paramListener.onClose(paramStatus, paramMetadata);
  }
  
  @Nullable
  private Deadline effectiveDeadline() {
    return min(this.callOptions.getDeadline(), this.context.getDeadline());
  }
  
  private static void logIfContextNarrowedTimeout(long paramLong, Deadline paramDeadline1, @Nullable Deadline paramDeadline2, @Nullable Deadline paramDeadline3) {
    if (!log.isLoggable(Level.FINE) || paramDeadline2 != paramDeadline1)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(String.format("Call timeout set to '%d' ns, due to context deadline.", new Object[] { Long.valueOf(paramLong) }));
    if (paramDeadline3 == null) {
      stringBuilder.append(" Explicit call timeout was not set.");
    } else {
      stringBuilder.append(String.format(" Explicit call timeout was '%d' ns.", new Object[] { Long.valueOf(paramDeadline3.timeRemaining(TimeUnit.NANOSECONDS)) }));
    } 
    log.fine(stringBuilder.toString());
  }
  
  @Nullable
  private static Deadline min(@Nullable Deadline paramDeadline1, @Nullable Deadline paramDeadline2) {
    return (paramDeadline1 == null) ? paramDeadline2 : ((paramDeadline2 == null) ? paramDeadline1 : paramDeadline1.minimum(paramDeadline2));
  }
  
  @VisibleForTesting
  static void prepareHeaders(Metadata paramMetadata, DecompressorRegistry paramDecompressorRegistry, Compressor paramCompressor, boolean paramBoolean) {
    paramMetadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
    if (paramCompressor != Codec.Identity.NONE)
      paramMetadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, paramCompressor.getMessageEncoding()); 
    paramMetadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
    byte[] arrayOfByte = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(paramDecompressorRegistry);
    if (arrayOfByte.length != 0)
      paramMetadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, arrayOfByte); 
    paramMetadata.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
    paramMetadata.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
    if (paramBoolean)
      paramMetadata.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS); 
  }
  
  private void removeContextListenerAndCancelDeadlineFuture() {
    this.context.removeListener(this.cancellationListener);
    ScheduledFuture<?> scheduledFuture = this.deadlineCancellationFuture;
    if (scheduledFuture != null)
      scheduledFuture.cancel(false); 
  }
  
  private ScheduledFuture<?> startDeadlineTimer(Deadline paramDeadline) {
    long l = paramDeadline.timeRemaining(TimeUnit.NANOSECONDS);
    return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer(l)), l, TimeUnit.NANOSECONDS);
  }
  
  private static void updateTimeoutHeaders(@Nullable Deadline paramDeadline1, @Nullable Deadline paramDeadline2, @Nullable Deadline paramDeadline3, Metadata paramMetadata) {
    paramMetadata.discardAll(GrpcUtil.TIMEOUT_KEY);
    if (paramDeadline1 == null)
      return; 
    long l = Math.max(0L, paramDeadline1.timeRemaining(TimeUnit.NANOSECONDS));
    paramMetadata.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(l));
    logIfContextNarrowedTimeout(l, paramDeadline1, paramDeadline3, paramDeadline2);
  }
  
  public void cancel(@Nullable String paramString, @Nullable Throwable paramThrowable) {
    Throwable throwable = paramThrowable;
    if (paramString == null) {
      throwable = paramThrowable;
      if (paramThrowable == null) {
        throwable = new CancellationException("Cancelled without a message or cause");
        log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", throwable);
      } 
    } 
    if (this.cancelCalled)
      return; 
    this.cancelCalled = true;
    try {
      if (this.stream != null) {
        Status status1;
        Status status2 = Status.CANCELLED;
        if (paramString != null) {
          status1 = status2.withDescription(paramString);
        } else {
          status1 = status2.withDescription("Call cancelled without message");
        } 
        status2 = status1;
        if (throwable != null)
          status2 = status1.withCause(throwable); 
        this.stream.cancel(status2);
      } 
      return;
    } finally {
      removeContextListenerAndCancelDeadlineFuture();
    } 
  }
  
  public Attributes getAttributes() {
    ClientStream clientStream = this.stream;
    return (clientStream != null) ? clientStream.getAttributes() : Attributes.EMPTY;
  }
  
  public void halfClose() {
    boolean bool;
    if (this.stream != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Not started");
    Preconditions.checkState(this.cancelCalled ^ true, "call was cancelled");
    Preconditions.checkState(this.halfCloseCalled ^ true, "call already half-closed");
    this.halfCloseCalled = true;
    this.stream.halfClose();
  }
  
  public boolean isReady() {
    return this.stream.isReady();
  }
  
  public void request(int paramInt) {
    boolean bool2;
    ClientStream clientStream = this.stream;
    boolean bool1 = true;
    if (clientStream != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "Not started");
    if (paramInt >= 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Number requested must be non-negative");
    this.stream.request(paramInt);
  }
  
  public void sendMessage(ReqT paramReqT) {
    boolean bool;
    if (this.stream != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Not started");
    Preconditions.checkState(this.cancelCalled ^ true, "call was cancelled");
    Preconditions.checkState(this.halfCloseCalled ^ true, "call was half-closed");
    try {
      if (this.stream instanceof RetriableStream) {
        ((RetriableStream)this.stream).sendMessage(paramReqT);
      } else {
        this.stream.writeMessage(this.method.streamRequest(paramReqT));
      } 
      if (!this.unaryRequest)
        this.stream.flush(); 
      return;
    } catch (RuntimeException runtimeException) {
      this.stream.cancel(Status.CANCELLED.withCause(runtimeException).withDescription("Failed to stream message"));
      return;
    } catch (Error error) {
      this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
      throw error;
    } 
  }
  
  ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry paramCompressorRegistry) {
    this.compressorRegistry = paramCompressorRegistry;
    return this;
  }
  
  ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry paramDecompressorRegistry) {
    this.decompressorRegistry = paramDecompressorRegistry;
    return this;
  }
  
  ClientCallImpl<ReqT, RespT> setFullStreamDecompression(boolean paramBoolean) {
    this.fullStreamDecompression = paramBoolean;
    return this;
  }
  
  public void setMessageCompression(boolean paramBoolean) {
    boolean bool;
    if (this.stream != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Not started");
    this.stream.setMessageCompression(paramBoolean);
  }
  
  public void start(final ClientCall.Listener<RespT> observer, Metadata paramMetadata) {
    Codec codec;
    boolean bool2;
    ClientStream clientStream = this.stream;
    boolean bool1 = false;
    if (clientStream == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "Already started");
    Preconditions.checkState(this.cancelCalled ^ true, "call was cancelled");
    Preconditions.checkNotNull(observer, "observer");
    Preconditions.checkNotNull(paramMetadata, "headers");
    if (this.context.isCancelled()) {
      this.stream = NoopClientStream.INSTANCE;
      class ClosedByContext extends ContextRunnable {
        ClosedByContext() {
          super(ClientCallImpl.this.context);
        }
        
        public void runInContext() {
          ClientCallImpl clientCallImpl = ClientCallImpl.this;
          clientCallImpl.closeObserver(observer, Contexts.statusFromCancelled(clientCallImpl.context), new Metadata());
        }
      };
      this.callExecutor.execute(new ClosedByContext());
      return;
    } 
    final String compressorName = this.callOptions.getCompressor();
    if (str != null) {
      Compressor compressor2 = this.compressorRegistry.lookupCompressor(str);
      Compressor compressor1 = compressor2;
      if (compressor2 == null) {
        this.stream = NoopClientStream.INSTANCE;
        class ClosedByNotFoundCompressor extends ContextRunnable {
          ClosedByNotFoundCompressor() {
            super(ClientCallImpl.this.context);
          }
          
          public void runInContext() {
            ClientCallImpl.this.closeObserver(observer, Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", new Object[] { this.val$compressorName })), new Metadata());
          }
        };
        this.callExecutor.execute(new ClosedByNotFoundCompressor());
        return;
      } 
    } else {
      codec = Codec.Identity.NONE;
    } 
    prepareHeaders(paramMetadata, this.decompressorRegistry, (Compressor)codec, this.fullStreamDecompression);
    Deadline deadline = effectiveDeadline();
    boolean bool3 = bool1;
    if (deadline != null) {
      bool3 = bool1;
      if (deadline.isExpired())
        bool3 = true; 
    } 
    if (!bool3) {
      updateTimeoutHeaders(deadline, this.callOptions.getDeadline(), this.context.getDeadline(), paramMetadata);
      if (this.retryEnabled) {
        this.stream = this.clientTransportProvider.newRetriableStream(this.method, this.callOptions, paramMetadata, this.context);
      } else {
        ClientTransport clientTransport = this.clientTransportProvider.get(new PickSubchannelArgsImpl(this.method, paramMetadata, this.callOptions));
        Context context = this.context.attach();
        try {
          this.stream = clientTransport.newStream(this.method, paramMetadata, this.callOptions);
        } finally {
          this.context.detach(context);
        } 
      } 
    } else {
      Status status = Status.DEADLINE_EXCEEDED;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("deadline exceeded: ");
      stringBuilder.append(deadline);
      this.stream = new FailingClientStream(status.withDescription(stringBuilder.toString()));
    } 
    if (this.callOptions.getAuthority() != null)
      this.stream.setAuthority(this.callOptions.getAuthority()); 
    if (this.callOptions.getMaxInboundMessageSize() != null)
      this.stream.setMaxInboundMessageSize(this.callOptions.getMaxInboundMessageSize().intValue()); 
    if (this.callOptions.getMaxOutboundMessageSize() != null)
      this.stream.setMaxOutboundMessageSize(this.callOptions.getMaxOutboundMessageSize().intValue()); 
    this.stream.setCompressor((Compressor)codec);
    this.stream.setFullStreamDecompression(this.fullStreamDecompression);
    this.stream.setDecompressorRegistry(this.decompressorRegistry);
    this.channelCallsTracer.reportCallStarted();
    this.stream.start(new ClientStreamListenerImpl(observer));
    this.context.addListener(this.cancellationListener, MoreExecutors.directExecutor());
    if (deadline != null && this.context.getDeadline() != deadline && this.deadlineCancellationExecutor != null)
      this.deadlineCancellationFuture = startDeadlineTimer(deadline); 
    if (this.cancelListenersShouldBeRemoved)
      removeContextListenerAndCancelDeadlineFuture(); 
  }
  
  private class ClientStreamListenerImpl implements ClientStreamListener {
    private boolean closed;
    
    private final ClientCall.Listener<RespT> observer;
    
    public ClientStreamListenerImpl(ClientCall.Listener<RespT> param1Listener) {
      this.observer = (ClientCall.Listener<RespT>)Preconditions.checkNotNull(param1Listener, "observer");
    }
    
    private void close(Status param1Status, Metadata param1Metadata) {
      this.closed = true;
      ClientCallImpl.access$902(ClientCallImpl.this, true);
      try {
        ClientCallImpl.this.closeObserver(this.observer, param1Status, param1Metadata);
        return;
      } finally {
        ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
        ClientCallImpl.this.channelCallsTracer.reportCallEnded(param1Status.isOk());
      } 
    }
    
    public void closed(Status param1Status, Metadata param1Metadata) {
      closed(param1Status, ClientStreamListener.RpcProgress.PROCESSED, param1Metadata);
    }
    
    public void closed(Status param1Status, ClientStreamListener.RpcProgress param1RpcProgress, Metadata param1Metadata) {
      Deadline deadline = ClientCallImpl.this.effectiveDeadline();
      final Status savedStatus = param1Status;
      final Metadata savedTrailers = param1Metadata;
      if (param1Status.getCode() == Status.Code.CANCELLED) {
        status = param1Status;
        metadata = param1Metadata;
        if (deadline != null) {
          status = param1Status;
          metadata = param1Metadata;
          if (deadline.isExpired()) {
            status = Status.DEADLINE_EXCEEDED;
            metadata = new Metadata();
          } 
        } 
      } 
      class StreamClosed extends ContextRunnable {
        StreamClosed() {
          super(ClientCallImpl.this.context);
        }
        
        public final void runInContext() {
          if (ClientCallImpl.ClientStreamListenerImpl.this.closed)
            return; 
          ClientCallImpl.ClientStreamListenerImpl.this.close(savedStatus, savedTrailers);
        }
      };
      ClientCallImpl.this.callExecutor.execute(new StreamClosed());
    }
    
    public void headersRead(final Metadata headers) {
      class HeadersRead extends ContextRunnable {
        HeadersRead() {
          super(ClientCallImpl.this.context);
        }
        
        public final void runInContext() {
          try {
            if (ClientCallImpl.ClientStreamListenerImpl.this.closed)
              return; 
            ClientCallImpl.ClientStreamListenerImpl.this.observer.onHeaders(headers);
          } catch (Throwable throwable) {
            Status status = Status.CANCELLED.withCause(throwable).withDescription("Failed to read headers");
            ClientCallImpl.this.stream.cancel(status);
            ClientCallImpl.ClientStreamListenerImpl.this.close(status, new Metadata());
          } 
        }
      };
      ClientCallImpl.this.callExecutor.execute(new HeadersRead());
    }
    
    public void messagesAvailable(final StreamListener.MessageProducer producer) {
      class MessagesAvailable extends ContextRunnable {
        MessagesAvailable() {
          super(ClientCallImpl.this.context);
        }
        
        public final void runInContext() {
          if (ClientCallImpl.ClientStreamListenerImpl.this.closed) {
            GrpcUtil.closeQuietly(producer);
            return;
          } 
          try {
            while (true) {
              InputStream inputStream = producer.next();
              if (inputStream != null) {
                try {
                  ClientCallImpl.ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(inputStream));
                  inputStream.close();
                } catch (Throwable throwable) {
                  GrpcUtil.closeQuietly(inputStream);
                  throw throwable;
                } 
                continue;
              } 
              break;
            } 
          } catch (Throwable throwable) {
            GrpcUtil.closeQuietly(producer);
            Status status = Status.CANCELLED.withCause(throwable).withDescription("Failed to read message.");
            ClientCallImpl.this.stream.cancel(status);
            ClientCallImpl.ClientStreamListenerImpl.this.close(status, new Metadata());
          } 
        }
      };
      ClientCallImpl.this.callExecutor.execute(new MessagesAvailable());
    }
    
    public void onReady() {
      class StreamOnReady extends ContextRunnable {
        StreamOnReady() {
          super(ClientCallImpl.this.context);
        }
        
        public final void runInContext() {
          try {
            ClientCallImpl.ClientStreamListenerImpl.this.observer.onReady();
          } catch (Throwable throwable) {
            Status status = Status.CANCELLED.withCause(throwable).withDescription("Failed to call onReady.");
            ClientCallImpl.this.stream.cancel(status);
            ClientCallImpl.ClientStreamListenerImpl.this.close(status, new Metadata());
          } 
        }
      };
      ClientCallImpl.this.callExecutor.execute(new StreamOnReady());
    }
  }
  
  class HeadersRead extends ContextRunnable {
    HeadersRead() {
      super(ClientCallImpl.this.context);
    }
    
    public final void runInContext() {
      try {
        if (this.this$1.closed)
          return; 
        this.this$1.observer.onHeaders(headers);
      } catch (Throwable throwable) {
        Status status = Status.CANCELLED.withCause(throwable).withDescription("Failed to read headers");
        ClientCallImpl.this.stream.cancel(status);
        this.this$1.close(status, new Metadata());
      } 
    }
  }
  
  class MessagesAvailable extends ContextRunnable {
    MessagesAvailable() {
      super(ClientCallImpl.this.context);
    }
    
    public final void runInContext() {
      if (this.this$1.closed) {
        GrpcUtil.closeQuietly(producer);
        return;
      } 
      try {
        while (true) {
          InputStream inputStream = producer.next();
          if (inputStream != null) {
            try {
              this.this$1.observer.onMessage(ClientCallImpl.this.method.parseResponse(inputStream));
              inputStream.close();
            } catch (Throwable throwable) {
              GrpcUtil.closeQuietly(inputStream);
              throw throwable;
            } 
            continue;
          } 
          break;
        } 
      } catch (Throwable throwable) {
        GrpcUtil.closeQuietly(producer);
        Status status = Status.CANCELLED.withCause(throwable).withDescription("Failed to read message.");
        ClientCallImpl.this.stream.cancel(status);
        this.this$1.close(status, new Metadata());
      } 
    }
  }
  
  class StreamClosed extends ContextRunnable {
    StreamClosed() {
      super(ClientCallImpl.this.context);
    }
    
    public final void runInContext() {
      if (this.this$1.closed)
        return; 
      this.this$1.close(savedStatus, savedTrailers);
    }
  }
  
  class StreamOnReady extends ContextRunnable {
    StreamOnReady() {
      super(ClientCallImpl.this.context);
    }
    
    public final void runInContext() {
      try {
        this.this$1.observer.onReady();
      } catch (Throwable throwable) {
        Status status = Status.CANCELLED.withCause(throwable).withDescription("Failed to call onReady.");
        ClientCallImpl.this.stream.cancel(status);
        this.this$1.close(status, new Metadata());
      } 
    }
  }
  
  static interface ClientTransportProvider {
    ClientTransport get(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs);
    
    <ReqT> RetriableStream<ReqT> newRetriableStream(MethodDescriptor<ReqT, ?> param1MethodDescriptor, CallOptions param1CallOptions, Metadata param1Metadata, Context param1Context);
  }
  
  private final class ContextCancellationListener implements Context.CancellationListener {
    private ContextCancellationListener() {}
    
    public void cancelled(Context param1Context) {
      ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(param1Context));
    }
  }
  
  private class DeadlineTimer implements Runnable {
    private final long remainingNanos;
    
    DeadlineTimer(long param1Long) {
      this.remainingNanos = param1Long;
    }
    
    public void run() {
      ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED.augmentDescription(String.format("deadline exceeded after %dns", new Object[] { Long.valueOf(this.remainingNanos) })));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ClientCallImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */