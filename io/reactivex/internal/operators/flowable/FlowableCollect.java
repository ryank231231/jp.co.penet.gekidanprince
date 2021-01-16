package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {
  final BiConsumer<? super U, ? super T> collector;
  
  final Callable<? extends U> initialSupplier;
  
  public FlowableCollect(Flowable<T> paramFlowable, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer) {
    super(paramFlowable);
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  protected void subscribeActual(Subscriber<? super U> paramSubscriber) {
    try {
      Object object = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initial value supplied is null");
      this.source.subscribe(new CollectSubscriber<T, U>(paramSubscriber, (U)object, this.collector));
      return;
    } catch (Throwable throwable) {
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
  
  static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -3589550218733891694L;
    
    final BiConsumer<? super U, ? super T> collector;
    
    boolean done;
    
    Subscription s;
    
    final U u;
    
    CollectSubscriber(Subscriber<? super U> param1Subscriber, U param1U, BiConsumer<? super U, ? super T> param1BiConsumer) {
      super(param1Subscriber);
      this.collector = param1BiConsumer;
      this.u = param1U;
    }
    
    public void cancel() {
      super.cancel();
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      complete(this.u);
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        this.collector.accept(this.u, param1T);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.cancel();
        onError(throwable);
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe((Subscription)this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */