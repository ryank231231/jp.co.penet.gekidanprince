package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {
  final Function<? super Throwable, ? extends T> valueSupplier;
  
  public FlowableOnErrorReturn(Flowable<T> paramFlowable, Function<? super Throwable, ? extends T> paramFunction) {
    super(paramFlowable);
    this.valueSupplier = paramFunction;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe((FlowableSubscriber)new OnErrorReturnSubscriber<T>(paramSubscriber, this.valueSupplier));
  }
  
  static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    private static final long serialVersionUID = -3740826063558713822L;
    
    final Function<? super Throwable, ? extends T> valueSupplier;
    
    OnErrorReturnSubscriber(Subscriber<? super T> param1Subscriber, Function<? super Throwable, ? extends T> param1Function) {
      super(param1Subscriber);
      this.valueSupplier = param1Function;
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        Object object = ObjectHelper.requireNonNull(this.valueSupplier.apply(param1Throwable), "The valueSupplier returned a null value");
        complete(object);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onNext(T param1T) {
      this.produced++;
      this.actual.onNext(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnErrorReturn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */