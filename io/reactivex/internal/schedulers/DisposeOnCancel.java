package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class DisposeOnCancel implements Future<Object> {
  final Disposable d;
  
  DisposeOnCancel(Disposable paramDisposable) {
    this.d = paramDisposable;
  }
  
  public boolean cancel(boolean paramBoolean) {
    this.d.dispose();
    return false;
  }
  
  public Object get() throws InterruptedException, ExecutionException {
    return null;
  }
  
  public Object get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    return null;
  }
  
  public boolean isCancelled() {
    return false;
  }
  
  public boolean isDone() {
    return false;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\DisposeOnCancel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */