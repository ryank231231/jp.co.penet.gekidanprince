package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

@Experimental
public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {
  final Action onFinally;
  
  public FlowableDoFinally(Flowable<T> paramFlowable, Action paramAction) {
    super(paramFlowable);
    this.onFinally = paramAction;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    if (paramSubscriber instanceof ConditionalSubscriber) {
      this.source.subscribe((FlowableSubscriber)new DoFinallyConditionalSubscriber((ConditionalSubscriber)paramSubscriber, this.onFinally));
    } else {
      this.source.subscribe(new DoFinallySubscriber<T>(paramSubscriber, this.onFinally));
    } 
  }
  
  static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    
    final ConditionalSubscriber<? super T> actual;
    
    final Action onFinally;
    
    QueueSubscription<T> qs;
    
    Subscription s;
    
    boolean syncFused;
    
    DoFinallyConditionalSubscriber(ConditionalSubscriber<? super T> param1ConditionalSubscriber, Action param1Action) {
      this.actual = param1ConditionalSubscriber;
      this.onFinally = param1Action;
    }
    
    public void cancel() {
      this.s.cancel();
      runFinally();
    }
    
    public void clear() {
      this.qs.clear();
    }
    
    public boolean isEmpty() {
      return this.qs.isEmpty();
    }
    
    public void onComplete() {
      this.actual.onComplete();
      runFinally();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
      runFinally();
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        if (param1Subscription instanceof QueueSubscription)
          this.qs = (QueueSubscription<T>)param1Subscription; 
        this.actual.onSubscribe((Subscription)this);
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object = this.qs.poll();
      if (object == null && this.syncFused)
        runFinally(); 
      return (T)object;
    }
    
    public void request(long param1Long) {
      this.s.request(param1Long);
    }
    
    public int requestFusion(int param1Int) {
      QueueSubscription<T> queueSubscription = this.qs;
      if (queueSubscription != null && (param1Int & 0x4) == 0) {
        param1Int = queueSubscription.requestFusion(param1Int);
        if (param1Int != 0) {
          boolean bool = true;
          if (param1Int != 1)
            bool = false; 
          this.syncFused = bool;
        } 
        return param1Int;
      } 
      return 0;
    }
    
    void runFinally() {
      if (compareAndSet(0, 1))
        try {
          this.onFinally.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
    
    public boolean tryOnNext(T param1T) {
      return this.actual.tryOnNext(param1T);
    }
  }
  
  static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    
    final Subscriber<? super T> actual;
    
    final Action onFinally;
    
    QueueSubscription<T> qs;
    
    Subscription s;
    
    boolean syncFused;
    
    DoFinallySubscriber(Subscriber<? super T> param1Subscriber, Action param1Action) {
      this.actual = param1Subscriber;
      this.onFinally = param1Action;
    }
    
    public void cancel() {
      this.s.cancel();
      runFinally();
    }
    
    public void clear() {
      this.qs.clear();
    }
    
    public boolean isEmpty() {
      return this.qs.isEmpty();
    }
    
    public void onComplete() {
      this.actual.onComplete();
      runFinally();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
      runFinally();
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        if (param1Subscription instanceof QueueSubscription)
          this.qs = (QueueSubscription<T>)param1Subscription; 
        this.actual.onSubscribe((Subscription)this);
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object = this.qs.poll();
      if (object == null && this.syncFused)
        runFinally(); 
      return (T)object;
    }
    
    public void request(long param1Long) {
      this.s.request(param1Long);
    }
    
    public int requestFusion(int param1Int) {
      QueueSubscription<T> queueSubscription = this.qs;
      if (queueSubscription != null && (param1Int & 0x4) == 0) {
        param1Int = queueSubscription.requestFusion(param1Int);
        if (param1Int != 0) {
          boolean bool = true;
          if (param1Int != 1)
            bool = false; 
          this.syncFused = bool;
        } 
        return param1Int;
      } 
      return 0;
    }
    
    void runFinally() {
      if (compareAndSet(0, 1))
        try {
          this.onFinally.run();
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDoFinally.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */