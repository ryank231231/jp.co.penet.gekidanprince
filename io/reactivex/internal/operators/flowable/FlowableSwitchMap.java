package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {
  final int bufferSize;
  
  final boolean delayErrors;
  
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  
  public FlowableSwitchMap(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt, boolean paramBoolean) {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.bufferSize = paramInt;
    this.delayErrors = paramBoolean;
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    if (FlowableScalarXMap.tryScalarXMapSubscribe((Publisher<T>)this.source, paramSubscriber, this.mapper))
      return; 
    this.source.subscribe(new SwitchMapSubscriber<T, R>(paramSubscriber, this.mapper, this.bufferSize, this.delayErrors));
  }
  
  static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    
    final int bufferSize;
    
    volatile boolean done;
    
    int fusionMode;
    
    final long index;
    
    final FlowableSwitchMap.SwitchMapSubscriber<T, R> parent;
    
    volatile SimpleQueue<R> queue;
    
    SwitchMapInnerSubscriber(FlowableSwitchMap.SwitchMapSubscriber<T, R> param1SwitchMapSubscriber, long param1Long, int param1Int) {
      this.parent = param1SwitchMapSubscriber;
      this.index = param1Long;
      this.bufferSize = param1Int;
    }
    
    public void cancel() {
      SubscriptionHelper.cancel(this);
    }
    
    public void onComplete() {
      FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
      if (this.index == switchMapSubscriber.unique) {
        this.done = true;
        switchMapSubscriber.drain();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
      if (this.index == switchMapSubscriber.unique && switchMapSubscriber.error.addThrowable(param1Throwable)) {
        if (!switchMapSubscriber.delayErrors)
          switchMapSubscriber.s.cancel(); 
        this.done = true;
        switchMapSubscriber.drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(R param1R) {
      FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
      if (this.index == switchMapSubscriber.unique) {
        if (this.fusionMode == 0 && !this.queue.offer(param1R)) {
          onError((Throwable)new MissingBackpressureException("Queue full?!"));
          return;
        } 
        switchMapSubscriber.drain();
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.setOnce(this, param1Subscription)) {
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(7);
          if (i == 1) {
            this.fusionMode = i;
            this.queue = (SimpleQueue<R>)queueSubscription;
            this.done = true;
            this.parent.drain();
            return;
          } 
          if (i == 2) {
            this.fusionMode = i;
            this.queue = (SimpleQueue<R>)queueSubscription;
            param1Subscription.request(this.bufferSize);
            return;
          } 
        } 
        this.queue = (SimpleQueue<R>)new SpscArrayQueue(this.bufferSize);
        param1Subscription.request(this.bufferSize);
      } 
    }
  }
  
  static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> CANCELLED = new FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object>(null, -1L, 1);
    
    private static final long serialVersionUID = -3491074160481096299L;
    
    final AtomicReference<FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>> active = new AtomicReference<FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>>();
    
    final Subscriber<? super R> actual;
    
    final int bufferSize;
    
    volatile boolean cancelled;
    
    final boolean delayErrors;
    
    volatile boolean done;
    
    final AtomicThrowable error;
    
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    
    final AtomicLong requested = new AtomicLong();
    
    Subscription s;
    
    volatile long unique;
    
    static {
      CANCELLED.cancel();
    }
    
    SwitchMapSubscriber(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends Publisher<? extends R>> param1Function, int param1Int, boolean param1Boolean) {
      this.actual = param1Subscriber;
      this.mapper = param1Function;
      this.bufferSize = param1Int;
      this.delayErrors = param1Boolean;
      this.error = new AtomicThrowable();
    }
    
    public void cancel() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.s.cancel();
        disposeInner();
      } 
    }
    
    void disposeInner() {
      FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber1 = (FlowableSwitchMap.SwitchMapInnerSubscriber)this.active.get();
      FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = CANCELLED;
      if (switchMapInnerSubscriber1 != switchMapInnerSubscriber2) {
        switchMapInnerSubscriber1 = (FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object>)this.active.getAndSet(switchMapInnerSubscriber2);
        if (switchMapInnerSubscriber1 != CANCELLED && switchMapInnerSubscriber1 != null)
          switchMapInnerSubscriber1.cancel(); 
      } 
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      Subscriber<? super R> subscriber = this.actual;
      int i = 1;
      while (true) {
        SimpleQueue simpleQueue;
        if (this.cancelled) {
          this.active.lazySet(null);
          return;
        } 
        if (this.done)
          if (this.delayErrors) {
            if (this.active.get() == null) {
              if ((Throwable)this.error.get() != null) {
                subscriber.onError(this.error.terminate());
              } else {
                subscriber.onComplete();
              } 
              return;
            } 
          } else {
            if ((Throwable)this.error.get() != null) {
              disposeInner();
              subscriber.onError(this.error.terminate());
              return;
            } 
            if (this.active.get() == null) {
              subscriber.onComplete();
              return;
            } 
          }  
        FlowableSwitchMap.SwitchMapInnerSubscriber<T, R> switchMapInnerSubscriber = this.active.get();
        if (switchMapInnerSubscriber != null) {
          simpleQueue = switchMapInnerSubscriber.queue;
        } else {
          simpleQueue = null;
        } 
        if (simpleQueue != null) {
          boolean bool;
          if (switchMapInnerSubscriber.done)
            if (!this.delayErrors) {
              if ((Throwable)this.error.get() != null) {
                disposeInner();
                subscriber.onError(this.error.terminate());
                return;
              } 
              if (simpleQueue.isEmpty()) {
                this.active.compareAndSet(switchMapInnerSubscriber, null);
                continue;
              } 
            } else if (simpleQueue.isEmpty()) {
              this.active.compareAndSet(switchMapInnerSubscriber, null);
              continue;
            }  
          long l1 = this.requested.get();
          long l2 = 0L;
          while (true) {
            boolean bool1 = false;
            bool = bool1;
            if (l2 != l1) {
              if (this.cancelled)
                return; 
              boolean bool2 = switchMapInnerSubscriber.done;
              try {
                object = simpleQueue.poll();
              } catch (Throwable object) {
                Exceptions.throwIfFatal((Throwable)object);
                switchMapInnerSubscriber.cancel();
                this.error.addThrowable((Throwable)object);
                object = null;
                bool2 = true;
              } 
              if (object == null) {
                bool = true;
              } else {
                bool = false;
              } 
              if (switchMapInnerSubscriber != this.active.get()) {
                bool = true;
                break;
              } 
              if (bool2)
                if (!this.delayErrors) {
                  if ((Throwable)this.error.get() != null) {
                    subscriber.onError(this.error.terminate());
                    return;
                  } 
                  if (bool) {
                    this.active.compareAndSet(switchMapInnerSubscriber, null);
                    bool = true;
                    break;
                  } 
                } else if (bool) {
                  this.active.compareAndSet(switchMapInnerSubscriber, null);
                  bool = true;
                  break;
                }  
              if (bool) {
                bool = bool1;
                break;
              } 
              subscriber.onNext(object);
              l2++;
              continue;
            } 
            break;
          } 
          if (l2 != 0L && !this.cancelled) {
            if (l1 != Long.MAX_VALUE)
              this.requested.addAndGet(-l2); 
            switchMapInnerSubscriber.get().request(l2);
          } 
          if (bool)
            continue; 
        } 
        int j = addAndGet(-i);
        i = j;
        if (j == 0)
          break; 
      } 
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (!this.done && this.error.addThrowable(param1Throwable)) {
        if (!this.delayErrors)
          disposeInner(); 
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      long l = this.unique + 1L;
      this.unique = l;
      FlowableSwitchMap.SwitchMapInnerSubscriber switchMapInnerSubscriber = this.active.get();
      if (switchMapInnerSubscriber != null)
        switchMapInnerSubscriber.cancel(); 
      try {
        Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The publisher returned is null");
        FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber1 = new FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object>(this, l, this.bufferSize);
        while (true) {
          FlowableSwitchMap.SwitchMapInnerSubscriber<Object, Object> switchMapInnerSubscriber2 = (FlowableSwitchMap.SwitchMapInnerSubscriber)this.active.get();
          if (switchMapInnerSubscriber2 == CANCELLED)
            break; 
          if (this.active.compareAndSet(switchMapInnerSubscriber2, switchMapInnerSubscriber1)) {
            publisher.subscribe((Subscriber)switchMapInnerSubscriber1);
            break;
          } 
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.cancel();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.add(this.requested, param1Long);
        if (this.unique == 0L) {
          this.s.request(Long.MAX_VALUE);
        } else {
          drain();
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSwitchMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */