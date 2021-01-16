package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T> extends Single<T> {
  final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;
  
  final SingleSource<? extends T> source;
  
  public SingleResumeNext(SingleSource<? extends T> paramSingleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> paramFunction) {
    this.source = paramSingleSource;
    this.nextFunction = paramFunction;
  }
  
  protected void subscribeActual(SingleObserver<? super T> paramSingleObserver) {
    this.source.subscribe(new ResumeMainSingleObserver<T>(paramSingleObserver, this.nextFunction));
  }
  
  static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -5314538511045349925L;
    
    final SingleObserver<? super T> actual;
    
    final Function<? super Throwable, ? extends SingleSource<? extends T>> nextFunction;
    
    ResumeMainSingleObserver(SingleObserver<? super T> param1SingleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> param1Function) {
      this.actual = param1SingleObserver;
      this.nextFunction = param1Function;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(get());
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        SingleSource singleSource = (SingleSource)ObjectHelper.requireNonNull(this.nextFunction.apply(param1Throwable), "The nextFunction returned a null SingleSource.");
        singleSource.subscribe((SingleObserver)new ResumeSingleObserver(this, this.actual));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable))
        this.actual.onSubscribe(this); 
    }
    
    public void onSuccess(T param1T) {
      this.actual.onSuccess(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleResumeNext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */