package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {
  final ObservableOperator<? extends R, ? super T> operator;
  
  public ObservableLift(ObservableSource<T> paramObservableSource, ObservableOperator<? extends R, ? super T> paramObservableOperator) {
    super(paramObservableSource);
    this.operator = paramObservableOperator;
  }
  
  public void subscribeActual(Observer<? super R> paramObserver) {
    try {
      Observer observer2 = this.operator.apply(paramObserver);
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Operator ");
      stringBuilder.append(this.operator);
      stringBuilder.append(" returned a null Observer");
      Observer observer1 = (Observer)ObjectHelper.requireNonNull(observer2, stringBuilder.toString());
      this.source.subscribe(observer1);
      return;
    } catch (NullPointerException nullPointerException) {
      throw nullPointerException;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
      NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
      nullPointerException.initCause(throwable);
      throw nullPointerException;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */