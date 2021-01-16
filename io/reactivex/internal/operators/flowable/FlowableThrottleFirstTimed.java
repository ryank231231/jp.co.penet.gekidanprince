package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {
  final Scheduler scheduler;
  
  final long timeout;
  
  final TimeUnit unit;
  
  public FlowableThrottleFirstTimed(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    super(paramFlowable);
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new DebounceTimedSubscriber((Subscriber<?>)new SerializedSubscriber(paramSubscriber), this.timeout, this.unit, this.scheduler.createWorker()));
  }
  
  static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = -9102637559663639004L;
    
    final Subscriber<? super T> actual;
    
    boolean done;
    
    volatile boolean gate;
    
    Subscription s;
    
    final long timeout;
    
    final SequentialDisposable timer = new SequentialDisposable();
    
    final TimeUnit unit;
    
    final Scheduler.Worker worker;
    
    DebounceTimedSubscriber(Subscriber<? super T> param1Subscriber, long param1Long, TimeUnit param1TimeUnit, Scheduler.Worker param1Worker) {
      this.actual = param1Subscriber;
      this.timeout = param1Long;
      this.unit = param1TimeUnit;
      this.worker = param1Worker;
    }
    
    public void cancel() {
      this.s.cancel();
      this.worker.dispose();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      this.actual.onComplete();
      this.worker.dispose();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.actual.onError(param1Throwable);
      this.worker.dispose();
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      if (!this.gate) {
        this.gate = true;
        if (get() != 0L) {
          this.actual.onNext(param1T);
          BackpressureHelper.produced(this, 1L);
          Disposable disposable = (Disposable)this.timer.get();
          if (disposable != null)
            disposable.dispose(); 
          this.timer.replace(this.worker.schedule(this, this.timeout, this.unit));
        } else {
          this.done = true;
          cancel();
          this.actual.onError((Throwable)new MissingBackpressureException("Could not deliver value due to lack of requests"));
          return;
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
    
    public void run() {
      this.gate = false;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableThrottleFirstTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */