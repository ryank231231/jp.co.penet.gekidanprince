package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {
  final boolean emitLast;
  
  final long period;
  
  final Scheduler scheduler;
  
  final TimeUnit unit;
  
  public FlowableSampleTimed(Flowable<T> paramFlowable, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, boolean paramBoolean) {
    super(paramFlowable);
    this.period = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.emitLast = paramBoolean;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    SerializedSubscriber serializedSubscriber = new SerializedSubscriber(paramSubscriber);
    if (this.emitLast) {
      this.source.subscribe(new SampleTimedEmitLast((Subscriber<?>)serializedSubscriber, this.period, this.unit, this.scheduler));
    } else {
      this.source.subscribe(new SampleTimedNoLast((Subscriber<?>)serializedSubscriber, this.period, this.unit, this.scheduler));
    } 
  }
  
  static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    
    final AtomicInteger wip = new AtomicInteger(1);
    
    SampleTimedEmitLast(Subscriber<? super T> param1Subscriber, long param1Long, TimeUnit param1TimeUnit, Scheduler param1Scheduler) {
      super(param1Subscriber, param1Long, param1TimeUnit, param1Scheduler);
    }
    
    void complete() {
      emit();
      if (this.wip.decrementAndGet() == 0)
        this.actual.onComplete(); 
    }
    
    public void run() {
      if (this.wip.incrementAndGet() == 2) {
        emit();
        if (this.wip.decrementAndGet() == 0)
          this.actual.onComplete(); 
      } 
    }
  }
  
  static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    
    SampleTimedNoLast(Subscriber<? super T> param1Subscriber, long param1Long, TimeUnit param1TimeUnit, Scheduler param1Scheduler) {
      super(param1Subscriber, param1Long, param1TimeUnit, param1Scheduler);
    }
    
    void complete() {
      this.actual.onComplete();
    }
    
    public void run() {
      emit();
    }
  }
  
  static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = -3517602651313910099L;
    
    final Subscriber<? super T> actual;
    
    final long period;
    
    final AtomicLong requested = new AtomicLong();
    
    Subscription s;
    
    final Scheduler scheduler;
    
    final SequentialDisposable timer = new SequentialDisposable();
    
    final TimeUnit unit;
    
    SampleTimedSubscriber(Subscriber<? super T> param1Subscriber, long param1Long, TimeUnit param1TimeUnit, Scheduler param1Scheduler) {
      this.actual = param1Subscriber;
      this.period = param1Long;
      this.unit = param1TimeUnit;
      this.scheduler = param1Scheduler;
    }
    
    public void cancel() {
      cancelTimer();
      this.s.cancel();
    }
    
    void cancelTimer() {
      DisposableHelper.dispose((AtomicReference)this.timer);
    }
    
    abstract void complete();
    
    void emit() {
      T t = getAndSet(null);
      if (t != null)
        if (this.requested.get() != 0L) {
          this.actual.onNext(t);
          BackpressureHelper.produced(this.requested, 1L);
        } else {
          cancel();
          this.actual.onError((Throwable)new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
        }  
    }
    
    public void onComplete() {
      cancelTimer();
      complete();
    }
    
    public void onError(Throwable param1Throwable) {
      cancelTimer();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      lazySet(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        SequentialDisposable sequentialDisposable = this.timer;
        Scheduler scheduler = this.scheduler;
        long l = this.period;
        sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, l, l, this.unit));
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long))
        BackpressureHelper.add(this.requested, param1Long); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSampleTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */