package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

public abstract class AbstractStream implements Stream {
  protected final void endOfMessages() {
    framer().close();
  }
  
  public final void flush() {
    if (!framer().isClosed())
      framer().flush(); 
  }
  
  protected abstract Framer framer();
  
  public boolean isReady() {
    return framer().isClosed() ? false : transportState().isReady();
  }
  
  protected final void onSendingBytes(int paramInt) {
    transportState().onSendingBytes(paramInt);
  }
  
  public final void setCompressor(Compressor paramCompressor) {
    framer().setCompressor((Compressor)Preconditions.checkNotNull(paramCompressor, "compressor"));
  }
  
  public final void setMessageCompression(boolean paramBoolean) {
    framer().setMessageCompression(paramBoolean);
  }
  
  protected abstract TransportState transportState();
  
  public final void writeMessage(InputStream paramInputStream) {
    Preconditions.checkNotNull(paramInputStream, "message");
    try {
      if (!framer().isClosed())
        framer().writePayload(paramInputStream); 
      return;
    } finally {
      GrpcUtil.closeQuietly(paramInputStream);
    } 
  }
  
  public static abstract class TransportState implements ApplicationThreadDeframer.TransportExecutor, MessageDeframer.Listener {
    @VisibleForTesting
    public static final int DEFAULT_ONREADY_THRESHOLD = 32768;
    
    @GuardedBy("onReadyLock")
    private boolean allocated;
    
    @GuardedBy("onReadyLock")
    private boolean deallocated;
    
    private Deframer deframer;
    
    @GuardedBy("onReadyLock")
    private int numSentBytesQueued;
    
    private final Object onReadyLock = new Object();
    
    private final StatsTraceContext statsTraceCtx;
    
    private final TransportTracer transportTracer;
    
    protected TransportState(int param1Int, StatsTraceContext param1StatsTraceContext, TransportTracer param1TransportTracer) {
      this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(param1StatsTraceContext, "statsTraceCtx");
      this.transportTracer = (TransportTracer)Preconditions.checkNotNull(param1TransportTracer, "transportTracer");
      this.deframer = new MessageDeframer(this, (Decompressor)Codec.Identity.NONE, param1Int, param1StatsTraceContext, param1TransportTracer);
    }
    
    private boolean isReady() {
      synchronized (this.onReadyLock) {
        boolean bool;
        if (this.allocated && this.numSentBytesQueued < 32768 && !this.deallocated) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      } 
    }
    
    private void notifyIfReady() {
      synchronized (this.onReadyLock) {
        boolean bool = isReady();
        if (bool)
          listener().onReady(); 
        return;
      } 
    }
    
    private void onSendingBytes(int param1Int) {
      synchronized (this.onReadyLock) {
        this.numSentBytesQueued += param1Int;
        return;
      } 
    }
    
    protected final void closeDeframer(boolean param1Boolean) {
      if (param1Boolean) {
        this.deframer.close();
      } else {
        this.deframer.closeWhenComplete();
      } 
    }
    
    protected final void deframe(ReadableBuffer param1ReadableBuffer) {
      try {
        this.deframer.deframe(param1ReadableBuffer);
      } catch (Throwable throwable) {
        deframeFailed(throwable);
      } 
    }
    
    public final StatsTraceContext getStatsTraceContext() {
      return this.statsTraceCtx;
    }
    
    protected TransportTracer getTransportTracer() {
      return this.transportTracer;
    }
    
    protected abstract StreamListener listener();
    
    public void messagesAvailable(StreamListener.MessageProducer param1MessageProducer) {
      listener().messagesAvailable(param1MessageProducer);
    }
    
    public final void onSentBytes(int param1Int) {
      synchronized (this.onReadyLock) {
        Preconditions.checkState(this.allocated, "onStreamAllocated was not called, but it seems the stream is active");
        int i = this.numSentBytesQueued;
        boolean bool = true;
        if (i < 32768) {
          i = 1;
        } else {
          i = 0;
        } 
        this.numSentBytesQueued -= param1Int;
        if (this.numSentBytesQueued < 32768) {
          param1Int = 1;
        } else {
          param1Int = 0;
        } 
        if (i == 0 && param1Int != 0) {
          param1Int = bool;
        } else {
          param1Int = 0;
        } 
        if (param1Int != 0)
          notifyIfReady(); 
        return;
      } 
    }
    
    protected void onStreamAllocated() {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual listener : ()Lio/grpc/internal/StreamListener;
      //   4: astore_1
      //   5: iconst_0
      //   6: istore_2
      //   7: aload_1
      //   8: ifnull -> 16
      //   11: iconst_1
      //   12: istore_3
      //   13: goto -> 18
      //   16: iconst_0
      //   17: istore_3
      //   18: iload_3
      //   19: invokestatic checkState : (Z)V
      //   22: aload_0
      //   23: getfield onReadyLock : Ljava/lang/Object;
      //   26: astore #4
      //   28: aload #4
      //   30: monitorenter
      //   31: iload_2
      //   32: istore_3
      //   33: aload_0
      //   34: getfield allocated : Z
      //   37: ifne -> 42
      //   40: iconst_1
      //   41: istore_3
      //   42: iload_3
      //   43: ldc 'Already allocated'
      //   45: invokestatic checkState : (ZLjava/lang/Object;)V
      //   48: aload_0
      //   49: iconst_1
      //   50: putfield allocated : Z
      //   53: aload #4
      //   55: monitorexit
      //   56: aload_0
      //   57: invokespecial notifyIfReady : ()V
      //   60: return
      //   61: astore_1
      //   62: aload #4
      //   64: monitorexit
      //   65: aload_1
      //   66: athrow
      // Exception table:
      //   from	to	target	type
      //   33	40	61	finally
      //   42	56	61	finally
      //   62	65	61	finally
    }
    
    protected final void onStreamDeallocated() {
      synchronized (this.onReadyLock) {
        this.deallocated = true;
        return;
      } 
    }
    
    public final void requestMessagesFromDeframer(int param1Int) {
      try {
        this.deframer.request(param1Int);
      } catch (Throwable throwable) {
        deframeFailed(throwable);
      } 
    }
    
    protected final void setDecompressor(Decompressor param1Decompressor) {
      this.deframer.setDecompressor(param1Decompressor);
    }
    
    protected void setFullStreamDecompressor(GzipInflatingBuffer param1GzipInflatingBuffer) {
      this.deframer.setFullStreamDecompressor(param1GzipInflatingBuffer);
      this.deframer = new ApplicationThreadDeframer(this, this, (MessageDeframer)this.deframer);
    }
    
    final void setMaxInboundMessageSize(int param1Int) {
      this.deframer.setMaxInboundMessageSize(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AbstractStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */