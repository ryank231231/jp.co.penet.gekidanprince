package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
  final boolean delayError;
  
  final int prefetch;
  
  final Scheduler scheduler;
  
  public FlowableObserveOn(Flowable<T> paramFlowable, Scheduler paramScheduler, boolean paramBoolean, int paramInt) {
    super(paramFlowable);
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
    this.prefetch = paramInt;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    Scheduler.Worker worker = this.scheduler.createWorker();
    if (paramSubscriber instanceof ConditionalSubscriber) {
      this.source.subscribe(new ObserveOnConditionalSubscriber((ConditionalSubscriber)paramSubscriber, worker, this.delayError, this.prefetch));
    } else {
      this.source.subscribe(new ObserveOnSubscriber<T>(paramSubscriber, worker, this.delayError, this.prefetch));
    } 
  }
  
  static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
    private static final long serialVersionUID = -8241002408341274697L;
    
    volatile boolean cancelled;
    
    final boolean delayError;
    
    volatile boolean done;
    
    Throwable error;
    
    final int limit;
    
    boolean outputFused;
    
    final int prefetch;
    
    long produced;
    
    SimpleQueue<T> queue;
    
    final AtomicLong requested;
    
    Subscription s;
    
    int sourceMode;
    
    final Scheduler.Worker worker;
    
    BaseObserveOnSubscriber(Scheduler.Worker param1Worker, boolean param1Boolean, int param1Int) {
      this.worker = param1Worker;
      this.delayError = param1Boolean;
      this.prefetch = param1Int;
      this.requested = new AtomicLong();
      this.limit = param1Int - (param1Int >> 2);
    }
    
    public final void cancel() {
      if (this.cancelled)
        return; 
      this.cancelled = true;
      this.s.cancel();
      this.worker.dispose();
      if (getAndIncrement() == 0)
        this.queue.clear(); 
    }
    
    final boolean checkTerminated(boolean param1Boolean1, boolean param1Boolean2, Subscriber<?> param1Subscriber) {
      if (this.cancelled) {
        clear();
        return true;
      } 
      if (param1Boolean1)
        if (this.delayError) {
          if (param1Boolean2) {
            Throwable throwable = this.error;
            if (throwable != null) {
              param1Subscriber.onError(throwable);
            } else {
              param1Subscriber.onComplete();
            } 
            this.worker.dispose();
            return true;
          } 
        } else {
          Throwable throwable = this.error;
          if (throwable != null) {
            clear();
            param1Subscriber.onError(throwable);
            this.worker.dispose();
            return true;
          } 
          if (param1Boolean2) {
            param1Subscriber.onComplete();
            this.worker.dispose();
            return true;
          } 
        }  
      return false;
    }
    
    public final void clear() {
      this.queue.clear();
    }
    
    public final boolean isEmpty() {
      return this.queue.isEmpty();
    }
    
    public final void onComplete() {
      if (!this.done) {
        this.done = true;
        trySchedule();
      } 
    }
    
    public final void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.error = param1Throwable;
      this.done = true;
      trySchedule();
    }
    
    public final void onNext(T param1T) {
      if (this.done)
        return; 
      if (this.sourceMode == 2) {
        trySchedule();
        return;
      } 
      if (!this.queue.offer(param1T)) {
        this.s.cancel();
        this.error = (Throwable)new MissingBackpressureException("Queue is full?!");
        this.done = true;
      } 
      trySchedule();
    }
    
    public final void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.add(this.requested, param1Long);
        trySchedule();
      } 
    }
    
    public final int requestFusion(int param1Int) {
      if ((param1Int & 0x2) != 0) {
        this.outputFused = true;
        return 2;
      } 
      return 0;
    }
    
    public final void run() {
      if (this.outputFused) {
        runBackfused();
      } else if (this.sourceMode == 1) {
        runSync();
      } else {
        runAsync();
      } 
    }
    
    abstract void runAsync();
    
    abstract void runBackfused();
    
    abstract void runSync();
    
    final void trySchedule() {
      if (getAndIncrement() != 0)
        return; 
      this.worker.schedule(this);
    }
  }
  
  static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
    private static final long serialVersionUID = 644624475404284533L;
    
    final ConditionalSubscriber<? super T> actual;
    
    long consumed;
    
    ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> param1ConditionalSubscriber, Scheduler.Worker param1Worker, boolean param1Boolean, int param1Int) {
      super(param1Worker, param1Boolean, param1Int);
      this.actual = param1ConditionalSubscriber;
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(7);
          if (i == 1) {
            this.sourceMode = 1;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.done = true;
            this.actual.onSubscribe((Subscription)this);
            return;
          } 
          if (i == 2) {
            this.sourceMode = 2;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.actual.onSubscribe((Subscription)this);
            param1Subscription.request(this.prefetch);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscArrayQueue(this.prefetch);
        this.actual.onSubscribe((Subscription)this);
        param1Subscription.request(this.prefetch);
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object = this.queue.poll();
      if (object != null && this.sourceMode != 1) {
        long l = this.consumed + 1L;
        if (l == this.limit) {
          this.consumed = 0L;
          this.s.request(l);
        } else {
          this.consumed = l;
        } 
      } 
      return (T)object;
    }
    
    void runAsync() {
      ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
      SimpleQueue<T> simpleQueue = this.queue;
      long l1 = this.produced;
      long l2 = this.consumed;
      int i;
      for (i = 1;; i = j) {
        long l = this.requested.get();
        while (l1 != l) {
          boolean bool = this.done;
          try {
            boolean bool1;
            Object object = simpleQueue.poll();
            if (object == null) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (checkTerminated(bool, bool1, (Subscriber<?>)conditionalSubscriber))
              return; 
            if (bool1)
              break; 
            long l3 = l1;
            if (conditionalSubscriber.tryOnNext(object))
              l3 = l1 + 1L; 
            long l4 = l2 + 1L;
            l1 = l3;
            l2 = l4;
            if (l4 == this.limit) {
              this.s.request(l4);
              l2 = 0L;
              l1 = l3;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.s.cancel();
            simpleQueue.clear();
            conditionalSubscriber.onError(throwable);
            this.worker.dispose();
            return;
          } 
        } 
        if (l1 == l && checkTerminated(this.done, simpleQueue.isEmpty(), (Subscriber<?>)conditionalSubscriber))
          return; 
        int j = get();
        if (i == j) {
          this.produced = l1;
          this.consumed = l2;
          j = addAndGet(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
      } 
    }
    
    void runBackfused() {
      int j;
      int i = 1;
      do {
        if (this.cancelled)
          return; 
        boolean bool = this.done;
        this.actual.onNext(null);
        if (bool) {
          Throwable throwable = this.error;
          if (throwable != null) {
            this.actual.onError(throwable);
          } else {
            this.actual.onComplete();
          } 
          this.worker.dispose();
          return;
        } 
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    void runSync() {
      ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
      SimpleQueue<T> simpleQueue = this.queue;
      long l = this.produced;
      int i;
      for (i = 1;; i = j) {
        long l1 = this.requested.get();
        while (l != l1) {
          try {
            Object object = simpleQueue.poll();
            if (this.cancelled)
              return; 
            if (object == null) {
              conditionalSubscriber.onComplete();
              this.worker.dispose();
              return;
            } 
            if (conditionalSubscriber.tryOnNext(object))
              l++; 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.s.cancel();
            conditionalSubscriber.onError(throwable);
            this.worker.dispose();
            return;
          } 
        } 
        if (this.cancelled)
          return; 
        if (simpleQueue.isEmpty()) {
          conditionalSubscriber.onComplete();
          this.worker.dispose();
          return;
        } 
        int j = get();
        if (i == j) {
          this.produced = l;
          j = addAndGet(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
      } 
    }
  }
  
  static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -4547113800637756442L;
    
    final Subscriber<? super T> actual;
    
    ObserveOnSubscriber(Subscriber<? super T> param1Subscriber, Scheduler.Worker param1Worker, boolean param1Boolean, int param1Int) {
      super(param1Worker, param1Boolean, param1Int);
      this.actual = param1Subscriber;
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(7);
          if (i == 1) {
            this.sourceMode = 1;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.done = true;
            this.actual.onSubscribe((Subscription)this);
            return;
          } 
          if (i == 2) {
            this.sourceMode = 2;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.actual.onSubscribe((Subscription)this);
            param1Subscription.request(this.prefetch);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscArrayQueue(this.prefetch);
        this.actual.onSubscribe((Subscription)this);
        param1Subscription.request(this.prefetch);
      } 
    }
    
    @Nullable
    public T poll() throws Exception {
      Object object = this.queue.poll();
      if (object != null && this.sourceMode != 1) {
        long l = this.produced + 1L;
        if (l == this.limit) {
          this.produced = 0L;
          this.s.request(l);
        } else {
          this.produced = l;
        } 
      } 
      return (T)object;
    }
    
    void runAsync() {
      Subscriber<? super T> subscriber = this.actual;
      SimpleQueue<T> simpleQueue = this.queue;
      long l = this.produced;
      int i;
      for (i = 1;; i = j) {
        long l1 = this.requested.get();
        while (l != l1) {
          boolean bool = this.done;
          try {
            boolean bool1;
            Object object = simpleQueue.poll();
            if (object == null) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (checkTerminated(bool, bool1, subscriber))
              return; 
            if (bool1)
              break; 
            subscriber.onNext(object);
            long l2 = l + 1L;
            l = l2;
            if (l2 == this.limit) {
              long l3 = l1;
              if (l1 != Long.MAX_VALUE)
                l3 = this.requested.addAndGet(-l2); 
              this.s.request(l2);
              l = 0L;
              l1 = l3;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.s.cancel();
            simpleQueue.clear();
            subscriber.onError(throwable);
            this.worker.dispose();
            return;
          } 
        } 
        if (l == l1 && checkTerminated(this.done, simpleQueue.isEmpty(), subscriber))
          return; 
        int j = get();
        if (i == j) {
          this.produced = l;
          j = addAndGet(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
      } 
    }
    
    void runBackfused() {
      int j;
      int i = 1;
      do {
        if (this.cancelled)
          return; 
        boolean bool = this.done;
        this.actual.onNext(null);
        if (bool) {
          Throwable throwable = this.error;
          if (throwable != null) {
            this.actual.onError(throwable);
          } else {
            this.actual.onComplete();
          } 
          this.worker.dispose();
          return;
        } 
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    void runSync() {
      Subscriber<? super T> subscriber = this.actual;
      SimpleQueue<T> simpleQueue = this.queue;
      long l = this.produced;
      int i;
      for (i = 1;; i = j) {
        long l1 = this.requested.get();
        while (l != l1) {
          try {
            Object object = simpleQueue.poll();
            if (this.cancelled)
              return; 
            if (object == null) {
              subscriber.onComplete();
              this.worker.dispose();
              return;
            } 
            subscriber.onNext(object);
            l++;
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.s.cancel();
            subscriber.onError(throwable);
            this.worker.dispose();
            return;
          } 
        } 
        if (this.cancelled)
          return; 
        if (throwable.isEmpty()) {
          subscriber.onComplete();
          this.worker.dispose();
          return;
        } 
        int j = get();
        if (i == j) {
          this.produced = l;
          j = addAndGet(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableObserveOn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */