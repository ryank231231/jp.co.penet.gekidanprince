package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
  public void onError(Throwable paramThrowable) {
    if (this.value == null) {
      this.error = paramThrowable;
    } else {
      RxJavaPlugins.onError(paramThrowable);
    } 
    countDown();
  }
  
  public void onNext(T paramT) {
    if (this.value == null) {
      this.value = paramT;
      this.s.cancel();
      countDown();
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\BlockingFirstSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */