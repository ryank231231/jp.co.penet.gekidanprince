package io.reactivex.internal.observers;

public interface InnerQueuedObserverSupport<T> {
  void drain();
  
  void innerComplete(InnerQueuedObserver<T> paramInnerQueuedObserver);
  
  void innerError(InnerQueuedObserver<T> paramInnerQueuedObserver, Throwable paramThrowable);
  
  void innerNext(InnerQueuedObserver<T> paramInnerQueuedObserver, T paramT);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\observers\InnerQueuedObserverSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */