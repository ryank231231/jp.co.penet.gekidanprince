package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

@Experimental
public final class SingleDetach<T> extends Single<T> {
  final SingleSource<T> source;
  
  public SingleDetach(SingleSource<T> paramSingleSource) {
    this.source = paramSingleSource;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DetachSingleObserver<T>(paramSingleObserver));
  }
  
  static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
    SingleObserver<? super T> actual;
    
    Disposable d;
    
    DetachSingleObserver(SingleObserver<? super T> param1SingleObserver) {
      this.actual = param1SingleObserver;
    }
    
    public void dispose() {
      this.actual = null;
      this.d.dispose();
      this.d = (Disposable)DisposableHelper.DISPOSED;
    }
    
    public boolean isDisposed() {
      return this.d.isDisposed();
    }
    
    public void onError(Throwable param1Throwable) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      SingleObserver<? super T> singleObserver = this.actual;
      if (singleObserver != null) {
        this.actual = null;
        singleObserver.onError(param1Throwable);
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void onSuccess(T param1T) {
      this.d = (Disposable)DisposableHelper.DISPOSED;
      SingleObserver<? super T> singleObserver = this.actual;
      if (singleObserver != null) {
        this.actual = null;
        singleObserver.onSuccess(param1T);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDetach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */