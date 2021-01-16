package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableOperator;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableLift<R, T> extends AbstractFlowableWithUpstream<T, R> {
  final FlowableOperator<? extends R, ? super T> operator;
  
  public FlowableLift(Flowable<T> paramFlowable, FlowableOperator<? extends R, ? super T> paramFlowableOperator) {
    super(paramFlowable);
    this.operator = paramFlowableOperator;
  }
  
  public void subscribeActual(Subscriber<? super R> paramSubscriber) {
    try {
      paramSubscriber = this.operator.apply(paramSubscriber);
      if (paramSubscriber != null) {
        this.source.subscribe(paramSubscriber);
        return;
      } 
      NullPointerException nullPointerException = new NullPointerException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Operator ");
      stringBuilder.append(this.operator);
      stringBuilder.append(" returned a null Subscriber");
      this(stringBuilder.toString());
      throw nullPointerException;
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableLift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */