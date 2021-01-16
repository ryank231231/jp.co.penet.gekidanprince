package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

@GwtIncompatible
final class TimeoutFuture<V> extends AbstractFuture.TrustedFuture<V> {
  @Nullable
  private ListenableFuture<V> delegateRef;
  
  @Nullable
  private Future<?> timer;
  
  private TimeoutFuture(ListenableFuture<V> paramListenableFuture) {
    this.delegateRef = (ListenableFuture<V>)Preconditions.checkNotNull(paramListenableFuture);
  }
  
  static <V> ListenableFuture<V> create(ListenableFuture<V> paramListenableFuture, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService) {
    TimeoutFuture<V> timeoutFuture = new TimeoutFuture<V>(paramListenableFuture);
    Fire<V> fire = new Fire<V>(timeoutFuture);
    timeoutFuture.timer = paramScheduledExecutorService.schedule(fire, paramLong, paramTimeUnit);
    paramListenableFuture.addListener(fire, MoreExecutors.directExecutor());
    return timeoutFuture;
  }
  
  protected void afterDone() {
    maybePropagateCancellation(this.delegateRef);
    Future<?> future = this.timer;
    if (future != null)
      future.cancel(false); 
    this.delegateRef = null;
    this.timer = null;
  }
  
  private static final class Fire<V> implements Runnable {
    @Nullable
    TimeoutFuture<V> timeoutFutureRef;
    
    Fire(TimeoutFuture<V> param1TimeoutFuture) {
      this.timeoutFutureRef = param1TimeoutFuture;
    }
    
    public void run() {
      TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
      if (timeoutFuture == null)
        return; 
      ListenableFuture<? extends V> listenableFuture = timeoutFuture.delegateRef;
      if (listenableFuture == null)
        return; 
      this.timeoutFutureRef = null;
      if (listenableFuture.isDone()) {
        timeoutFuture.setFuture(listenableFuture);
      } else {
        try {
          TimeoutException timeoutException = new TimeoutException();
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Future timed out: ");
          stringBuilder.append(listenableFuture);
          this(stringBuilder.toString());
          timeoutFuture.setException(timeoutException);
          return;
        } finally {
          listenableFuture.cancel(true);
        } 
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\TimeoutFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */