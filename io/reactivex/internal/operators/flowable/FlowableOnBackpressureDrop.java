package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {
  final Consumer<? super T> onDrop = this;
  
  public FlowableOnBackpressureDrop(Flowable<T> paramFlowable) {
    super(paramFlowable);
  }
  
  public FlowableOnBackpressureDrop(Flowable<T> paramFlowable, Consumer<? super T> paramConsumer) {
    super(paramFlowable);
  }
  
  public void accept(T paramT) {}
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new BackpressureDropSubscriber<T>(paramSubscriber, this.onDrop));
  }
  
  static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -6246093802440953054L;
    
    final Subscriber<? super T> actual;
    
    boolean done;
    
    final Consumer<? super T> onDrop;
    
    Subscription s;
    
    BackpressureDropSubscriber(Subscriber<? super T> param1Subscriber, Consumer<? super T> param1Consumer) {
      this.actual = param1Subscriber;
      this.onDrop = param1Consumer;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onComplete();
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
      if (get() != 0L) {
        this.actual.onNext(param1T);
        BackpressureHelper.produced(this, 1L);
      } else {
        try {
          this.onDrop.accept(param1T);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          cancel();
          onError(throwable);
        } 
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long))
        BackpressureHelper.add(this, param1Long); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnBackpressureDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */