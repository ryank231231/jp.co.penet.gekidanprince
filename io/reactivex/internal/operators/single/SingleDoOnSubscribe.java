package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoOnSubscribe<T> extends Single<T> {
  final Consumer<? super Disposable> onSubscribe;
  
  final SingleSource<T> source;
  
  public SingleDoOnSubscribe(SingleSource<T> paramSingleSource, Consumer<? super Disposable> paramConsumer) {
    this.source = paramSingleSource;
    this.onSubscribe = paramConsumer;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new DoOnSubscribeSingleObserver<T>(paramSingleObserver, this.onSubscribe));
  }
  
  static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {
    final SingleObserver<? super T> actual;
    
    boolean done;
    
    final Consumer<? super Disposable> onSubscribe;
    
    DoOnSubscribeSingleObserver(SingleObserver<? super T> param1SingleObserver, Consumer<? super Disposable> param1Consumer) {
      this.actual = param1SingleObserver;
      this.onSubscribe = param1Consumer;
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      try {
        this.onSubscribe.accept(param1Disposable);
        this.actual.onSubscribe(param1Disposable);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.done = true;
        param1Disposable.dispose();
        EmptyDisposable.error(throwable, this.actual);
        return;
      } 
    }
    
    public void onSuccess(T param1T) {
      if (this.done)
        return; 
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleDoOnSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */