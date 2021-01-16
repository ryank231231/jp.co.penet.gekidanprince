package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {
  final BiFunction<? super T, ? super U, ? extends R> combiner;
  
  final Publisher<? extends U> other;
  
  public FlowableWithLatestFrom(Flowable<T> paramFlowable, BiFunction<? super T, ? super U, ? extends R> paramBiFunction, Publisher<? extends U> paramPublisher) {
    super(paramFlowable);
    this.combiner = paramBiFunction;
    this.other = paramPublisher;
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    SerializedSubscriber serializedSubscriber = new SerializedSubscriber(paramSubscriber);
    WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber = new WithLatestFromSubscriber<T, U, R>((Subscriber<? super R>)serializedSubscriber, this.combiner);
    serializedSubscriber.onSubscribe(withLatestFromSubscriber);
    this.other.subscribe((Subscriber)new FlowableWithLatestSubscriber(withLatestFromSubscriber));
    this.source.subscribe((FlowableSubscriber)withLatestFromSubscriber);
  }
  
  final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {
    private final FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> wlf;
    
    FlowableWithLatestSubscriber(FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> param1WithLatestFromSubscriber) {
      this.wlf = param1WithLatestFromSubscriber;
    }
    
    public void onComplete() {}
    
    public void onError(Throwable param1Throwable) {
      this.wlf.otherError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      this.wlf.lazySet(param1U);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (this.wlf.setOther(param1Subscription))
        param1Subscription.request(Long.MAX_VALUE); 
    }
  }
  
  static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
    private static final long serialVersionUID = -312246233408980075L;
    
    final Subscriber<? super R> actual;
    
    final BiFunction<? super T, ? super U, ? extends R> combiner;
    
    final AtomicReference<Subscription> other = new AtomicReference<Subscription>();
    
    final AtomicLong requested = new AtomicLong();
    
    final AtomicReference<Subscription> s = new AtomicReference<Subscription>();
    
    WithLatestFromSubscriber(Subscriber<? super R> param1Subscriber, BiFunction<? super T, ? super U, ? extends R> param1BiFunction) {
      this.actual = param1Subscriber;
      this.combiner = param1BiFunction;
    }
    
    public void cancel() {
      SubscriptionHelper.cancel(this.s);
      SubscriptionHelper.cancel(this.other);
    }
    
    public void onComplete() {
      SubscriptionHelper.cancel(this.other);
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      SubscriptionHelper.cancel(this.other);
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (!tryOnNext(param1T))
        ((Subscription)this.s.get()).request(1L); 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      SubscriptionHelper.deferredSetOnce(this.s, this.requested, param1Subscription);
    }
    
    public void otherError(Throwable param1Throwable) {
      SubscriptionHelper.cancel(this.s);
      this.actual.onError(param1Throwable);
    }
    
    public void request(long param1Long) {
      SubscriptionHelper.deferredRequest(this.s, this.requested, param1Long);
    }
    
    public boolean setOther(Subscription param1Subscription) {
      return SubscriptionHelper.setOnce(this.other, param1Subscription);
    }
    
    public boolean tryOnNext(T param1T) {
      U u = get();
      if (u != null)
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.combiner.apply(param1T, u), "The combiner returned a null value");
          this.actual.onNext(param1T);
          return true;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          cancel();
          this.actual.onError(throwable);
          return false;
        }  
      return false;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWithLatestFrom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */