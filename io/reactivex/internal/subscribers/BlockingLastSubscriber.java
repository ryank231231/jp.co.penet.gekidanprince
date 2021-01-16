package io.reactivex.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
  public void onError(Throwable paramThrowable) {
    this.value = null;
    this.error = paramThrowable;
    countDown();
  }
  
  public void onNext(T paramT) {
    this.value = paramT;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\BlockingLastSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */