package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableScalarXMap {
  private FlowableScalarXMap() {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T, U> Flowable<U> scalarXMap(T paramT, Function<? super T, ? extends Publisher<? extends U>> paramFunction) {
    return RxJavaPlugins.onAssembly(new ScalarXMapFlowable<T, U>(paramT, paramFunction));
  }
  
  public static <T, R> boolean tryScalarXMapSubscribe(Publisher<T> paramPublisher, Subscriber<? super R> paramSubscriber, Function<? super T, ? extends Publisher<? extends R>> paramFunction) {
    if (paramPublisher instanceof Callable)
      try {
        paramPublisher = ((Callable)paramPublisher).call();
        if (paramPublisher == null) {
          EmptySubscription.complete(paramSubscriber);
          return true;
        } 
        try {
          paramPublisher = (Publisher<T>)ObjectHelper.requireNonNull(paramFunction.apply(paramPublisher), "The mapper returned a null Publisher");
          if (paramPublisher instanceof Callable) {
            try {
              paramPublisher = ((Callable)paramPublisher).call();
              if (paramPublisher == null) {
                EmptySubscription.complete(paramSubscriber);
                return true;
              } 
              paramSubscriber.onSubscribe((Subscription)new ScalarSubscription(paramSubscriber, paramPublisher));
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              EmptySubscription.error(throwable, paramSubscriber);
              return true;
            } 
          } else {
            throwable.subscribe(paramSubscriber);
          } 
          return true;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          EmptySubscription.error(throwable, paramSubscriber);
          return true;
        } 
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptySubscription.error(throwable, paramSubscriber);
        return true;
      }  
    return false;
  }
  
  static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    
    final T value;
    
    ScalarXMapFlowable(T param1T, Function<? super T, ? extends Publisher<? extends R>> param1Function) {
      this.value = param1T;
      this.mapper = param1Function;
    }
    
    public void subscribeActual(Subscriber<? super R> param1Subscriber) {
      try {
        Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.mapper.apply(this.value), "The mapper returned a null Publisher");
        if (publisher instanceof Callable) {
          try {
            publisher = ((Callable<Publisher>)publisher).call();
            if (publisher == null) {
              EmptySubscription.complete(param1Subscriber);
              return;
            } 
            param1Subscriber.onSubscribe((Subscription)new ScalarSubscription(param1Subscriber, publisher));
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            EmptySubscription.error(throwable, param1Subscriber);
            return;
          } 
        } else {
          throwable.subscribe(param1Subscriber);
        } 
        return;
      } catch (Throwable throwable) {
        EmptySubscription.error(throwable, param1Subscriber);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableScalarXMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */