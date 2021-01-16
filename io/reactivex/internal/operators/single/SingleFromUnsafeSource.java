package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;

public final class SingleFromUnsafeSource<T> extends Single<T> {
  final SingleSource<T> source;
  
  public SingleFromUnsafeSource(SingleSource<T> paramSingleSource) {
    this.source = paramSingleSource;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(paramSingleObserver);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleFromUnsafeSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */