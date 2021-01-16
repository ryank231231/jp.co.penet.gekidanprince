package io.reactivex.internal.subscribers;

public interface InnerQueuedSubscriberSupport<T> {
  void drain();
  
  void innerComplete(InnerQueuedSubscriber<T> paramInnerQueuedSubscriber);
  
  void innerError(InnerQueuedSubscriber<T> paramInnerQueuedSubscriber, Throwable paramThrowable);
  
  void innerNext(InnerQueuedSubscriber<T> paramInnerQueuedSubscriber, T paramT);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\InnerQueuedSubscriberSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */