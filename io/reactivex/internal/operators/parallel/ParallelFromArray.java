package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFromArray<T> extends ParallelFlowable<T> {
  final Publisher<T>[] sources;
  
  public ParallelFromArray(Publisher<T>[] paramArrayOfPublisher) {
    this.sources = paramArrayOfPublisher;
  }
  
  public int parallelism() {
    return this.sources.length;
  }
  
  public void subscribe(Subscriber<? super T>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    int i = paramArrayOfSubscriber.length;
    for (byte b = 0; b < i; b++)
      this.sources[b].subscribe(paramArrayOfSubscriber[b]); 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFromArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */