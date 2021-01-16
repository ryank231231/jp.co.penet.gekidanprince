package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleHide<T> extends Single<T> {
  final SingleSource<? extends T> source;
  
  public SingleHide(SingleSource<? extends T> paramSingleSource) {
    this.source = paramSingleSource;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new HideSingleObserver<T>(paramSingleObserver));
  }
  
  static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    Disposable d;
    
    HideSingleObserver(SingleObserver<? super T> param1SingleObserver) {
      this.actual = param1SingleObserver;
    }
    
    public void dispose() {
      this.d.dispose();
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleHide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */