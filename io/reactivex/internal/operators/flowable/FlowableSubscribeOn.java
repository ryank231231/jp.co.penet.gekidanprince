package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {
  final boolean nonScheduledRequests;
  
  final Scheduler scheduler;
  
  public FlowableSubscribeOn(Flowable<T> paramFlowable, Scheduler paramScheduler, boolean paramBoolean) {
    super(paramFlowable);
    this.scheduler = paramScheduler;
    this.nonScheduledRequests = paramBoolean;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    Scheduler.Worker worker = this.scheduler.createWorker();
    SubscribeOnSubscriber<T> subscribeOnSubscriber = new SubscribeOnSubscriber<T>(paramSubscriber, worker, (Publisher<T>)this.source, this.nonScheduledRequests);
    paramSubscriber.onSubscribe(subscribeOnSubscriber);
    worker.schedule(subscribeOnSubscriber);
  }
  
  static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    
    final Subscriber<? super T> actual;
    
    final boolean nonScheduledRequests;
    
    final AtomicLong requested;
    
    final AtomicReference<Subscription> s;
    
    Publisher<T> source;
    
    final Scheduler.Worker worker;
    
    SubscribeOnSubscriber(Subscriber<? super T> param1Subscriber, Scheduler.Worker param1Worker, Publisher<T> param1Publisher, boolean param1Boolean) {
      this.actual = param1Subscriber;
      this.worker = param1Worker;
      this.source = param1Publisher;
      this.s = new AtomicReference<Subscription>();
      this.requested = new AtomicLong();
      this.nonScheduledRequests = param1Boolean ^ true;
    }
    
    public void cancel() {
      SubscriptionHelper.cancel(this.s);
      this.worker.dispose();
    }
    
    public void onComplete() {
      this.actual.onComplete();
      this.worker.dispose();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
      this.worker.dispose();
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.setOnce(this.s, param1Subscription)) {
        long l = this.requested.getAndSet(0L);
        if (l != 0L)
          requestUpstream(l, param1Subscription); 
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        Subscription subscription = this.s.get();
        if (subscription != null) {
          requestUpstream(param1Long, subscription);
        } else {
          BackpressureHelper.add(this.requested, param1Long);
          subscription = this.s.get();
          if (subscription != null) {
            param1Long = this.requested.getAndSet(0L);
            if (param1Long != 0L)
              requestUpstream(param1Long, subscription); 
          } 
        } 
      } 
    }
    
    void requestUpstream(long param1Long, Subscription param1Subscription) {
      if (this.nonScheduledRequests || Thread.currentThread() == get()) {
        param1Subscription.request(param1Long);
        return;
      } 
      this.worker.schedule(new Request(param1Subscription, param1Long));
    }
    
    public void run() {
      lazySet(Thread.currentThread());
      Publisher<T> publisher = this.source;
      this.source = null;
      publisher.subscribe((Subscriber)this);
    }
    
    static final class Request implements Runnable {
      private final long n;
      
      private final Subscription s;
      
      Request(Subscription param2Subscription, long param2Long) {
        this.s = param2Subscription;
        this.n = param2Long;
      }
      
      public void run() {
        this.s.request(this.n);
      }
    }
  }
  
  static final class Request implements Runnable {
    private final long n;
    
    private final Subscription s;
    
    Request(Subscription param1Subscription, long param1Long) {
      this.s = param1Subscription;
      this.n = param1Long;
    }
    
    public void run() {
      this.s.request(this.n);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSubscribeOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */