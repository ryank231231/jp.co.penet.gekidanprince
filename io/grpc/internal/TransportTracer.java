package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

public final class TransportTracer {
  private static final Factory DEFAULT_FACTORY;
  
  private static final TimeProvider SYSTEM_TIME_PROVIDER = new TimeProvider() {
      public long currentTimeMillis() {
        return System.currentTimeMillis();
      }
    };
  
  private FlowControlReader flowControlWindowReader;
  
  private long keepAlivesSent;
  
  private long lastLocalStreamCreatedTimeNanos;
  
  private volatile long lastMessageReceivedTimeNanos;
  
  private long lastMessageSentTimeNanos;
  
  private long lastRemoteStreamCreatedTimeNanos;
  
  private final LongCounter messagesReceived = LongCounterFactory.create();
  
  private long messagesSent;
  
  private long streamsFailed;
  
  private long streamsStarted;
  
  private long streamsSucceeded;
  
  private final TimeProvider timeProvider = SYSTEM_TIME_PROVIDER;
  
  static {
    DEFAULT_FACTORY = new Factory(SYSTEM_TIME_PROVIDER);
  }
  
  public TransportTracer() {}
  
  private TransportTracer(TimeProvider paramTimeProvider) {}
  
  private long currentTimeNanos() {
    return TimeUnit.MILLISECONDS.toNanos(this.timeProvider.currentTimeMillis());
  }
  
  public static Factory getDefaultFactory() {
    return DEFAULT_FACTORY;
  }
  
  public Channelz.TransportStats getStats() {
    long l2;
    FlowControlReader flowControlReader = this.flowControlWindowReader;
    long l1 = -1L;
    if (flowControlReader == null) {
      l2 = -1L;
    } else {
      l2 = (flowControlReader.read()).localBytes;
    } 
    flowControlReader = this.flowControlWindowReader;
    if (flowControlReader != null)
      l1 = (flowControlReader.read()).remoteBytes; 
    return new Channelz.TransportStats(this.streamsStarted, this.lastLocalStreamCreatedTimeNanos, this.lastRemoteStreamCreatedTimeNanos, this.streamsSucceeded, this.streamsFailed, this.messagesSent, this.messagesReceived.value(), this.keepAlivesSent, this.lastMessageSentTimeNanos, this.lastMessageReceivedTimeNanos, l2, l1);
  }
  
  public void reportKeepAliveSent() {
    this.keepAlivesSent++;
  }
  
  public void reportLocalStreamStarted() {
    this.streamsStarted++;
    this.lastLocalStreamCreatedTimeNanos = currentTimeNanos();
  }
  
  public void reportMessageReceived() {
    this.messagesReceived.add(1L);
    this.lastMessageReceivedTimeNanos = currentTimeNanos();
  }
  
  public void reportMessageSent(int paramInt) {
    if (paramInt == 0)
      return; 
    this.messagesSent += paramInt;
    this.lastMessageSentTimeNanos = currentTimeNanos();
  }
  
  public void reportRemoteStreamStarted() {
    this.streamsStarted++;
    this.lastRemoteStreamCreatedTimeNanos = currentTimeNanos();
  }
  
  public void reportStreamClosed(boolean paramBoolean) {
    if (paramBoolean) {
      this.streamsSucceeded++;
    } else {
      this.streamsFailed++;
    } 
  }
  
  public void setFlowControlWindowReader(FlowControlReader paramFlowControlReader) {
    this.flowControlWindowReader = (FlowControlReader)Preconditions.checkNotNull(paramFlowControlReader);
  }
  
  public static final class Factory {
    private TransportTracer.TimeProvider timeProvider;
    
    @VisibleForTesting
    public Factory(TransportTracer.TimeProvider param1TimeProvider) {
      this.timeProvider = param1TimeProvider;
    }
    
    public TransportTracer create() {
      return new TransportTracer(this.timeProvider);
    }
  }
  
  public static interface FlowControlReader {
    TransportTracer.FlowControlWindows read();
  }
  
  public static final class FlowControlWindows {
    public final long localBytes;
    
    public final long remoteBytes;
    
    public FlowControlWindows(long param1Long1, long param1Long2) {
      this.localBytes = param1Long1;
      this.remoteBytes = param1Long2;
    }
  }
  
  @VisibleForTesting
  public static interface TimeProvider {
    long currentTimeMillis();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\TransportTracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */