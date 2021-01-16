package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

@Experimental
final class ScalarXMapZHelper {
  private ScalarXMapZHelper() {
    throw new IllegalStateException("No instances!");
  }
  
  static <T> boolean tryAsCompletable(Object paramObject, Function<? super T, ? extends CompletableSource> paramFunction, CompletableObserver paramCompletableObserver) {
    if (paramObject instanceof Callable) {
      Callable<Callable> callable = (Callable)paramObject;
      paramObject = null;
      try {
        callable = callable.call();
        if (callable != null)
          paramObject = ObjectHelper.requireNonNull(paramFunction.apply(callable), "The mapper returned a null CompletableSource"); 
        if (paramObject == null) {
          EmptyDisposable.complete(paramCompletableObserver);
        } else {
          paramObject.subscribe(paramCompletableObserver);
        } 
        return true;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramCompletableObserver);
        return true;
      } 
    } 
    return false;
  }
  
  static <T, R> boolean tryAsMaybe(Object paramObject, Function<? super T, ? extends MaybeSource<? extends R>> paramFunction, Observer<? super R> paramObserver) {
    if (paramObject instanceof Callable) {
      Callable<Callable> callable = (Callable)paramObject;
      paramObject = null;
      try {
        callable = callable.call();
        if (callable != null)
          paramObject = ObjectHelper.requireNonNull(paramFunction.apply(callable), "The mapper returned a null MaybeSource"); 
        if (paramObject == null) {
          EmptyDisposable.complete(paramObserver);
        } else {
          paramObject.subscribe(MaybeToObservable.create(paramObserver));
        } 
        return true;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramObserver);
        return true;
      } 
    } 
    return false;
  }
  
  static <T, R> boolean tryAsSingle(Object paramObject, Function<? super T, ? extends SingleSource<? extends R>> paramFunction, Observer<? super R> paramObserver) {
    if (paramObject instanceof Callable) {
      Callable<Callable> callable = (Callable)paramObject;
      paramObject = null;
      try {
        callable = callable.call();
        if (callable != null)
          paramObject = ObjectHelper.requireNonNull(paramFunction.apply(callable), "The mapper returned a null SingleSource"); 
        if (paramObject == null) {
          EmptyDisposable.complete(paramObserver);
        } else {
          paramObject.subscribe(SingleToObservable.create(paramObserver));
        } 
        return true;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptyDisposable.error(throwable, paramObserver);
        return true;
      } 
    } 
    return false;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\mixed\ScalarXMapZHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */