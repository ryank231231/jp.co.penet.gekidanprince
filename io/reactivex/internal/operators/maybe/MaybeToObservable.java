package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {
  final MaybeSource<T> source;
  
  public MaybeToObservable(MaybeSource<T> paramMaybeSource) {
    this.source = paramMaybeSource;
  }
  
  @Experimental
  public static <T> MaybeObserver<T> create(Observer<? super T> paramObserver) {
    return new MaybeToObservableObserver<T>(paramObserver);
  }
  
  public MaybeSource<T> source() {
    return this.source;
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    this.source.subscribe(create(paramObserver));
  }
  
  static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
    private static final long serialVersionUID = 7603343402964826922L;
    
    Disposable d;
    
    MaybeToObservableObserver(Observer<? super T> param1Observer) {
      super(param1Observer);
    }
    
    public void dispose() {
      super.dispose();
      this.d.dispose();
    }
    
    public void onComplete() {
      complete();
    }
    
    public void onError(Throwable param1Throwable) {
      error(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe((Disposable)this);
      } 
    }
    
    public void onSuccess(T param1T) {
      complete(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeToObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */