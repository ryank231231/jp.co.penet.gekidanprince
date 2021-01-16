package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

@Experimental
public final class SingleDoAfterSuccess<T> extends Single<T> {
  final Consumer<? super T> onAfterSuccess;
  
  final SingleSource<T> source;
  
  public SingleDoAfterSuccess(SingleSource<T> paramSingleSource, Consumer<? super T> paramConsumer) {
    this.source = paramSingleSource;
    this.onAfterSuccess = paramConsumer;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoAfterObserver<T>(paramSingleObserver, this.onAfterSuccess));
  }
  
  static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {
    final SingleObserver<? super T> actual;
    
    Disposable d;
    
    final Consumer<? super T> onAfterSuccess;
    
    DoAfterObserver(SingleObserver<? super T> param1SingleObserver, Consumer<? super T> param1Consumer) {
      this.actual = param1SingleObserver;
      this.onAfterSuccess = param1Consumer;
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
      try {
        this.onAfterSuccess.accept(param1T);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoAfterSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */