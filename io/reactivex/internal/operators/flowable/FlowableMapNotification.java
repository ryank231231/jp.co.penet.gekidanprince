package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
  final Callable<? extends R> onCompleteSupplier;
  
  final Function<? super Throwable, ? extends R> onErrorMapper;
  
  final Function<? super T, ? extends R> onNextMapper;
  
  public FlowableMapNotification(Flowable<T> paramFlowable, Function<? super T, ? extends R> paramFunction, Function<? super Throwable, ? extends R> paramFunction1, Callable<? extends R> paramCallable) {
    super(paramFlowable);
    this.onNextMapper = paramFunction;
    this.onErrorMapper = paramFunction1;
    this.onCompleteSupplier = paramCallable;
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    this.source.subscribe((FlowableSubscriber)new MapNotificationSubscriber<T, R>(paramSubscriber, this.onNextMapper, this.onErrorMapper, this.onCompleteSupplier));
  }
  
  static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    private static final long serialVersionUID = 2757120512858778108L;
    
    final Callable<? extends R> onCompleteSupplier;
    
    final Function<? super Throwable, ? extends R> onErrorMapper;
    
    final Function<? super T, ? extends R> onNextMapper;
    
    MapNotificationSubscriber(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends R> param1Function, Function<? super Throwable, ? extends R> param1Function1, Callable<? extends R> param1Callable) {
      super(param1Subscriber);
      this.onNextMapper = param1Function;
      this.onErrorMapper = param1Function1;
      this.onCompleteSupplier = param1Callable;
    }
    
    public void onComplete() {
      try {
        Object object = ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onComplete publisher returned is null");
        complete(object);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      try {
        Object object = ObjectHelper.requireNonNull(this.onErrorMapper.apply(param1Throwable), "The onError publisher returned is null");
        complete(object);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        return;
      } 
    }
    
    public void onNext(T param1T) {
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.onNextMapper.apply(param1T), "The onNext publisher returned is null");
        this.produced++;
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.actual.onError(throwable);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableMapNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */