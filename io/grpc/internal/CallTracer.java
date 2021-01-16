package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;

final class CallTracer {
  static final Factory DEFAULT_FACTORY;
  
  static final TimeProvider SYSTEM_TIME_PROVIDER = new TimeProvider() {
      public long currentTimeMillis() {
        return System.currentTimeMillis();
      }
    };
  
  private final LongCounter callsFailed = LongCounterFactory.create();
  
  private final LongCounter callsStarted = LongCounterFactory.create();
  
  private final LongCounter callsSucceeded = LongCounterFactory.create();
  
  private volatile long lastCallStartedMillis;
  
  private final TimeProvider timeProvider;
  
  static {
    DEFAULT_FACTORY = new Factory() {
        public CallTracer create() {
          return new CallTracer(CallTracer.SYSTEM_TIME_PROVIDER);
        }
      };
  }
  
  CallTracer(TimeProvider paramTimeProvider) {
    this.timeProvider = paramTimeProvider;
  }
  
  public static Factory getDefaultFactory() {
    return DEFAULT_FACTORY;
  }
  
  public void reportCallEnded(boolean paramBoolean) {
    if (paramBoolean) {
      this.callsSucceeded.add(1L);
    } else {
      this.callsFailed.add(1L);
    } 
  }
  
  public void reportCallStarted() {
    this.callsStarted.add(1L);
    this.lastCallStartedMillis = this.timeProvider.currentTimeMillis();
  }
  
  void updateBuilder(Channelz.ChannelStats.Builder paramBuilder) {
    paramBuilder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedMillis(this.lastCallStartedMillis);
  }
  
  void updateBuilder(Channelz.ServerStats.Builder paramBuilder) {
    paramBuilder.setCallsStarted(this.callsStarted.value()).setCallsSucceeded(this.callsSucceeded.value()).setCallsFailed(this.callsFailed.value()).setLastCallStartedMillis(this.lastCallStartedMillis);
  }
  
  public static interface Factory {
    CallTracer create();
  }
  
  @VisibleForTesting
  static interface TimeProvider {
    long currentTimeMillis();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\CallTracer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */