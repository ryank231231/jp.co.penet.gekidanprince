package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
  final int bufferSize;
  
  final long maxSize;
  
  final boolean restartTimerOnMaxSize;
  
  final Scheduler scheduler;
  
  final long timeskip;
  
  final long timespan;
  
  final TimeUnit unit;
  
  public FlowableWindowTimed(Flowable<T> paramFlowable, long paramLong1, long paramLong2, TimeUnit paramTimeUnit, Scheduler paramScheduler, long paramLong3, int paramInt, boolean paramBoolean) {
    super(paramFlowable);
    this.timespan = paramLong1;
    this.timeskip = paramLong2;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.maxSize = paramLong3;
    this.bufferSize = paramInt;
    this.restartTimerOnMaxSize = paramBoolean;
  }
  
  protected void subscribeActual(Subscriber<? super Flowable<T>> paramSubscriber) {
    SerializedSubscriber serializedSubscriber = new SerializedSubscriber(paramSubscriber);
    if (this.timespan == this.timeskip) {
      if (this.maxSize == Long.MAX_VALUE) {
        this.source.subscribe(new WindowExactUnboundedSubscriber((Subscriber<? super Flowable<?>>)serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
        return;
      } 
      this.source.subscribe((FlowableSubscriber)new WindowExactBoundedSubscriber((Subscriber<? super Flowable<?>>)serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
      return;
    } 
    this.source.subscribe((FlowableSubscriber)new WindowSkipSubscriber((Subscriber<? super Flowable<?>>)serializedSubscriber, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
  }
  
  static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
    final int bufferSize;
    
    long count;
    
    final long maxSize;
    
    long producerIndex;
    
    final boolean restartTimerOnMaxSize;
    
    Subscription s;
    
    final Scheduler scheduler;
    
    volatile boolean terminated;
    
    final SequentialDisposable timer = new SequentialDisposable();
    
    final long timespan;
    
    final TimeUnit unit;
    
    UnicastProcessor<T> window;
    
    final Scheduler.Worker worker;
    
    WindowExactBoundedSubscriber(Subscriber<? super Flowable<T>> param1Subscriber, long param1Long1, TimeUnit param1TimeUnit, Scheduler param1Scheduler, int param1Int, long param1Long2, boolean param1Boolean) {
      super(param1Subscriber, (SimplePlainQueue)new MpscLinkedQueue());
      this.timespan = param1Long1;
      this.unit = param1TimeUnit;
      this.scheduler = param1Scheduler;
      this.bufferSize = param1Int;
      this.maxSize = param1Long2;
      this.restartTimerOnMaxSize = param1Boolean;
      if (param1Boolean) {
        this.worker = param1Scheduler.createWorker();
      } else {
        this.worker = null;
      } 
    }
    
    public void cancel() {
      this.cancelled = true;
    }
    
    public void dispose() {
      DisposableHelper.dispose((AtomicReference)this.timer);
      Scheduler.Worker worker = this.worker;
      if (worker != null)
        worker.dispose(); 
    }
    
    void drainLoop() {
      SimplePlainQueue simplePlainQueue = this.queue;
      Subscriber subscriber = this.actual;
      UnicastProcessor<T> unicastProcessor = this.window;
      int i = 1;
      while (true) {
        int j;
        if (this.terminated) {
          this.s.cancel();
          simplePlainQueue.clear();
          dispose();
          return;
        } 
        boolean bool1 = this.done;
        Object object = simplePlainQueue.poll();
        if (object == null) {
          j = 1;
        } else {
          j = 0;
        } 
        boolean bool2 = object instanceof ConsumerIndexHolder;
        if (bool1 && (j || bool2)) {
          this.window = null;
          simplePlainQueue.clear();
          Throwable throwable = this.error;
          if (throwable != null) {
            unicastProcessor.onError(throwable);
          } else {
            unicastProcessor.onComplete();
          } 
          dispose();
          return;
        } 
        if (j) {
          j = leave(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
        if (bool2) {
          object = object;
          if (this.restartTimerOnMaxSize || this.producerIndex == ((ConsumerIndexHolder)object).index) {
            unicastProcessor.onComplete();
            this.count = 0L;
            unicastProcessor = UnicastProcessor.create(this.bufferSize);
            this.window = unicastProcessor;
            long l1 = requested();
            if (l1 != 0L) {
              subscriber.onNext(unicastProcessor);
              if (l1 != Long.MAX_VALUE)
                produced(1L); 
              continue;
            } 
            this.window = null;
            this.queue.clear();
            this.s.cancel();
            subscriber.onError((Throwable)new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            dispose();
            return;
          } 
          continue;
        } 
        unicastProcessor.onNext(NotificationLite.getValue(object));
        long l = this.count + 1L;
        if (l >= this.maxSize) {
          this.producerIndex++;
          this.count = 0L;
          unicastProcessor.onComplete();
          l = requested();
          if (l != 0L) {
            unicastProcessor = UnicastProcessor.create(this.bufferSize);
            this.window = unicastProcessor;
            this.actual.onNext(unicastProcessor);
            if (l != Long.MAX_VALUE)
              produced(1L); 
            if (this.restartTimerOnMaxSize) {
              ((Disposable)this.timer.get()).dispose();
              object = this.worker;
              ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
              l = this.timespan;
              object = object.schedulePeriodically(consumerIndexHolder, l, l, this.unit);
              this.timer.replace((Disposable)object);
            } 
            continue;
          } 
          this.window = null;
          this.s.cancel();
          this.actual.onError((Throwable)new MissingBackpressureException("Could not deliver window due to lack of requests"));
          dispose();
          return;
        } 
        this.count = l;
      } 
    }
    
    public void onComplete() {
      this.done = true;
      if (enter())
        drainLoop(); 
      this.actual.onComplete();
      dispose();
    }
    
    public void onError(Throwable param1Throwable) {
      this.error = param1Throwable;
      this.done = true;
      if (enter())
        drainLoop(); 
      this.actual.onError(param1Throwable);
      dispose();
    }
    
    public void onNext(T param1T) {
      Disposable disposable;
      if (this.terminated)
        return; 
      if (fastEnter()) {
        UnicastProcessor<T> unicastProcessor = this.window;
        unicastProcessor.onNext(param1T);
        long l = this.count + 1L;
        if (l >= this.maxSize) {
          this.producerIndex++;
          this.count = 0L;
          unicastProcessor.onComplete();
          l = requested();
          if (l != 0L) {
            UnicastProcessor<T> unicastProcessor1 = UnicastProcessor.create(this.bufferSize);
            this.window = unicastProcessor1;
            this.actual.onNext(unicastProcessor1);
            if (l != Long.MAX_VALUE)
              produced(1L); 
            if (this.restartTimerOnMaxSize) {
              ((Disposable)this.timer.get()).dispose();
              Scheduler.Worker worker = this.worker;
              ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
              l = this.timespan;
              disposable = worker.schedulePeriodically(consumerIndexHolder, l, l, this.unit);
              this.timer.replace(disposable);
            } 
          } else {
            this.window = null;
            this.s.cancel();
            this.actual.onError((Throwable)new MissingBackpressureException("Could not deliver window due to lack of requests"));
            dispose();
            return;
          } 
        } else {
          this.count = l;
        } 
        if (leave(-1) == 0)
          return; 
      } else {
        this.queue.offer(NotificationLite.next(disposable));
        if (!enter())
          return; 
      } 
      drainLoop();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        Scheduler scheduler;
        this.s = param1Subscription;
        Subscriber subscriber = this.actual;
        subscriber.onSubscribe(this);
        if (this.cancelled)
          return; 
        UnicastProcessor<T> unicastProcessor = UnicastProcessor.create(this.bufferSize);
        this.window = unicastProcessor;
        long l = requested();
        if (l != 0L) {
          Disposable disposable;
          subscriber.onNext(unicastProcessor);
          if (l != Long.MAX_VALUE)
            produced(1L); 
          ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.producerIndex, this);
          if (this.restartTimerOnMaxSize) {
            Scheduler.Worker worker = this.worker;
            l = this.timespan;
            disposable = worker.schedulePeriodically(consumerIndexHolder, l, l, this.unit);
          } else {
            scheduler = this.scheduler;
            l = this.timespan;
            disposable = scheduler.schedulePeriodicallyDirect((Runnable)disposable, l, l, this.unit);
          } 
          if (this.timer.replace(disposable))
            param1Subscription.request(Long.MAX_VALUE); 
        } else {
          this.cancelled = true;
          param1Subscription.cancel();
          scheduler.onError((Throwable)new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
          return;
        } 
      } 
    }
    
    public void request(long param1Long) {
      requested(param1Long);
    }
    
    static final class ConsumerIndexHolder implements Runnable {
      final long index;
      
      final FlowableWindowTimed.WindowExactBoundedSubscriber<?> parent;
      
      ConsumerIndexHolder(long param2Long, FlowableWindowTimed.WindowExactBoundedSubscriber<?> param2WindowExactBoundedSubscriber) {
        this.index = param2Long;
        this.parent = param2WindowExactBoundedSubscriber;
      }
      
      public void run() {
        FlowableWindowTimed.WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
        if (!windowExactBoundedSubscriber.cancelled) {
          windowExactBoundedSubscriber.queue.offer(this);
        } else {
          windowExactBoundedSubscriber.terminated = true;
          windowExactBoundedSubscriber.dispose();
        } 
        if (windowExactBoundedSubscriber.enter())
          windowExactBoundedSubscriber.drainLoop(); 
      }
    }
  }
  
  static final class ConsumerIndexHolder implements Runnable {
    final long index;
    
    final FlowableWindowTimed.WindowExactBoundedSubscriber<?> parent;
    
    ConsumerIndexHolder(long param1Long, FlowableWindowTimed.WindowExactBoundedSubscriber<?> param1WindowExactBoundedSubscriber) {
      this.index = param1Long;
      this.parent = param1WindowExactBoundedSubscriber;
    }
    
    public void run() {
      FlowableWindowTimed.WindowExactBoundedSubscriber<?> windowExactBoundedSubscriber = this.parent;
      if (!windowExactBoundedSubscriber.cancelled) {
        windowExactBoundedSubscriber.queue.offer(this);
      } else {
        windowExactBoundedSubscriber.terminated = true;
        windowExactBoundedSubscriber.dispose();
      } 
      if (windowExactBoundedSubscriber.enter())
        windowExactBoundedSubscriber.drainLoop(); 
    }
  }
  
  static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {
    static final Object NEXT = new Object();
    
    final int bufferSize;
    
    Subscription s;
    
    final Scheduler scheduler;
    
    volatile boolean terminated;
    
    final SequentialDisposable timer = new SequentialDisposable();
    
    final long timespan;
    
    final TimeUnit unit;
    
    UnicastProcessor<T> window;
    
    WindowExactUnboundedSubscriber(Subscriber<? super Flowable<T>> param1Subscriber, long param1Long, TimeUnit param1TimeUnit, Scheduler param1Scheduler, int param1Int) {
      super(param1Subscriber, (SimplePlainQueue)new MpscLinkedQueue());
      this.timespan = param1Long;
      this.unit = param1TimeUnit;
      this.scheduler = param1Scheduler;
      this.bufferSize = param1Int;
    }
    
    public void cancel() {
      this.cancelled = true;
    }
    
    public void dispose() {
      DisposableHelper.dispose((AtomicReference)this.timer);
    }
    
    void drainLoop() {
      SimplePlainQueue simplePlainQueue = this.queue;
      Subscriber subscriber = this.actual;
      UnicastProcessor<T> unicastProcessor = this.window;
      int i = 1;
      while (true) {
        Object object1;
        boolean bool1 = this.terminated;
        boolean bool2 = this.done;
        Object object2 = simplePlainQueue.poll();
        if (bool2 && (object2 == null || object2 == NEXT)) {
          this.window = null;
          simplePlainQueue.clear();
          dispose();
          object2 = this.error;
          if (object2 != null) {
            unicastProcessor.onError((Throwable)object2);
          } else {
            unicastProcessor.onComplete();
          } 
          return;
        } 
        if (object2 == null) {
          int j = leave(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
        if (object2 == NEXT) {
          unicastProcessor.onComplete();
          if (!bool1) {
            object2 = UnicastProcessor.create(this.bufferSize);
            this.window = (UnicastProcessor<T>)object2;
            long l = requested();
            if (l != 0L) {
              subscriber.onNext(object2);
              object1 = object2;
              if (l != Long.MAX_VALUE) {
                produced(1L);
                object1 = object2;
              } 
              continue;
            } 
            this.window = null;
            this.queue.clear();
            this.s.cancel();
            dispose();
            subscriber.onError((Throwable)new MissingBackpressureException("Could not deliver first window due to lack of requests."));
            return;
          } 
          this.s.cancel();
          continue;
        } 
        object1.onNext(NotificationLite.getValue(object2));
      } 
    }
    
    public void onComplete() {
      this.done = true;
      if (enter())
        drainLoop(); 
      this.actual.onComplete();
      dispose();
    }
    
    public void onError(Throwable param1Throwable) {
      this.error = param1Throwable;
      this.done = true;
      if (enter())
        drainLoop(); 
      this.actual.onError(param1Throwable);
      dispose();
    }
    
    public void onNext(T param1T) {
      if (this.terminated)
        return; 
      if (fastEnter()) {
        this.window.onNext(param1T);
        if (leave(-1) == 0)
          return; 
      } else {
        this.queue.offer(NotificationLite.next(param1T));
        if (!enter())
          return; 
      } 
      drainLoop();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        Scheduler scheduler;
        this.s = param1Subscription;
        this.window = UnicastProcessor.create(this.bufferSize);
        Subscriber subscriber = this.actual;
        subscriber.onSubscribe(this);
        long l = requested();
        if (l != 0L) {
          subscriber.onNext(this.window);
          if (l != Long.MAX_VALUE)
            produced(1L); 
          if (!this.cancelled) {
            SequentialDisposable sequentialDisposable = this.timer;
            scheduler = this.scheduler;
            l = this.timespan;
            if (sequentialDisposable.replace(scheduler.schedulePeriodicallyDirect(this, l, l, this.unit)))
              param1Subscription.request(Long.MAX_VALUE); 
          } 
        } else {
          this.cancelled = true;
          param1Subscription.cancel();
          scheduler.onError((Throwable)new MissingBackpressureException("Could not deliver first window due to lack of requests."));
          return;
        } 
      } 
    }
    
    public void request(long param1Long) {
      requested(param1Long);
    }
    
    public void run() {
      if (this.cancelled) {
        this.terminated = true;
        dispose();
      } 
      this.queue.offer(NEXT);
      if (enter())
        drainLoop(); 
    }
  }
  
  static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {
    final int bufferSize;
    
    Subscription s;
    
    volatile boolean terminated;
    
    final long timeskip;
    
    final long timespan;
    
    final TimeUnit unit;
    
    final List<UnicastProcessor<T>> windows;
    
    final Scheduler.Worker worker;
    
    WindowSkipSubscriber(Subscriber<? super Flowable<T>> param1Subscriber, long param1Long1, long param1Long2, TimeUnit param1TimeUnit, Scheduler.Worker param1Worker, int param1Int) {
      super(param1Subscriber, (SimplePlainQueue)new MpscLinkedQueue());
      this.timespan = param1Long1;
      this.timeskip = param1Long2;
      this.unit = param1TimeUnit;
      this.worker = param1Worker;
      this.bufferSize = param1Int;
      this.windows = new LinkedList<UnicastProcessor<T>>();
    }
    
    public void cancel() {
      this.cancelled = true;
    }
    
    void complete(UnicastProcessor<T> param1UnicastProcessor) {
      this.queue.offer(new SubjectWork<T>(param1UnicastProcessor, false));
      if (enter())
        drainLoop(); 
    }
    
    public void dispose() {
      this.worker.dispose();
    }
    
    void drainLoop() {
      SimplePlainQueue simplePlainQueue = this.queue;
      Subscriber subscriber = this.actual;
      List<UnicastProcessor<T>> list = this.windows;
      int i = 1;
      while (true) {
        Iterator<UnicastProcessor<T>> iterator1;
        int j;
        if (this.terminated) {
          this.s.cancel();
          dispose();
          simplePlainQueue.clear();
          list.clear();
          return;
        } 
        boolean bool1 = this.done;
        Object object = simplePlainQueue.poll();
        if (object == null) {
          j = 1;
        } else {
          j = 0;
        } 
        boolean bool2 = object instanceof SubjectWork;
        if (bool1 && (j || bool2)) {
          simplePlainQueue.clear();
          Throwable throwable = this.error;
          if (throwable != null) {
            Iterator<UnicastProcessor<T>> iterator = list.iterator();
            while (iterator.hasNext())
              ((UnicastProcessor)iterator.next()).onError(throwable); 
          } else {
            iterator1 = list.iterator();
            while (iterator1.hasNext())
              ((UnicastProcessor)iterator1.next()).onComplete(); 
          } 
          list.clear();
          dispose();
          return;
        } 
        if (j) {
          j = leave(-i);
          i = j;
          if (j == 0)
            return; 
          continue;
        } 
        if (bool2) {
          UnicastProcessor<T> unicastProcessor;
          SubjectWork subjectWork = (SubjectWork)object;
          if (subjectWork.open) {
            if (this.cancelled)
              continue; 
            long l = requested();
            if (l != 0L) {
              unicastProcessor = UnicastProcessor.create(this.bufferSize);
              list.add(unicastProcessor);
              iterator1.onNext(unicastProcessor);
              if (l != Long.MAX_VALUE)
                produced(1L); 
              this.worker.schedule(new Completion(unicastProcessor), this.timespan, this.unit);
              continue;
            } 
            iterator1.onError((Throwable)new MissingBackpressureException("Can't emit window due to lack of requests"));
            continue;
          } 
          list.remove(((SubjectWork)unicastProcessor).w);
          ((SubjectWork)unicastProcessor).w.onComplete();
          if (list.isEmpty() && this.cancelled)
            this.terminated = true; 
          continue;
        } 
        Iterator<UnicastProcessor<T>> iterator2 = list.iterator();
        while (iterator2.hasNext())
          ((UnicastProcessor)iterator2.next()).onNext(object); 
      } 
    }
    
    public void onComplete() {
      this.done = true;
      if (enter())
        drainLoop(); 
      this.actual.onComplete();
      dispose();
    }
    
    public void onError(Throwable param1Throwable) {
      this.error = param1Throwable;
      this.done = true;
      if (enter())
        drainLoop(); 
      this.actual.onError(param1Throwable);
      dispose();
    }
    
    public void onNext(T param1T) {
      if (fastEnter()) {
        Iterator<UnicastProcessor<T>> iterator = this.windows.iterator();
        while (iterator.hasNext())
          ((UnicastProcessor)iterator.next()).onNext(param1T); 
        if (leave(-1) == 0)
          return; 
      } else {
        this.queue.offer(param1T);
        if (!enter())
          return; 
      } 
      drainLoop();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        if (this.cancelled)
          return; 
        long l = requested();
        if (l != 0L) {
          UnicastProcessor<T> unicastProcessor = UnicastProcessor.create(this.bufferSize);
          this.windows.add(unicastProcessor);
          this.actual.onNext(unicastProcessor);
          if (l != Long.MAX_VALUE)
            produced(1L); 
          this.worker.schedule(new Completion(unicastProcessor), this.timespan, this.unit);
          Scheduler.Worker worker = this.worker;
          l = this.timeskip;
          worker.schedulePeriodically(this, l, l, this.unit);
          param1Subscription.request(Long.MAX_VALUE);
        } else {
          param1Subscription.cancel();
          this.actual.onError((Throwable)new MissingBackpressureException("Could not emit the first window due to lack of requests"));
        } 
      } 
    }
    
    public void request(long param1Long) {
      requested(param1Long);
    }
    
    public void run() {
      SubjectWork subjectWork = new SubjectWork(UnicastProcessor.create(this.bufferSize), true);
      if (!this.cancelled)
        this.queue.offer(subjectWork); 
      if (enter())
        drainLoop(); 
    }
    
    final class Completion implements Runnable {
      private final UnicastProcessor<T> processor;
      
      Completion(UnicastProcessor<T> param2UnicastProcessor) {
        this.processor = param2UnicastProcessor;
      }
      
      public void run() {
        FlowableWindowTimed.WindowSkipSubscriber.this.complete(this.processor);
      }
    }
    
    static final class SubjectWork<T> {
      final boolean open;
      
      final UnicastProcessor<T> w;
      
      SubjectWork(UnicastProcessor<T> param2UnicastProcessor, boolean param2Boolean) {
        this.w = param2UnicastProcessor;
        this.open = param2Boolean;
      }
    }
  }
  
  final class Completion implements Runnable {
    private final UnicastProcessor<T> processor;
    
    Completion(UnicastProcessor<T> param1UnicastProcessor) {
      this.processor = param1UnicastProcessor;
    }
    
    public void run() {
      this.this$0.complete(this.processor);
    }
  }
  
  static final class SubjectWork<T> {
    final boolean open;
    
    final UnicastProcessor<T> w;
    
    SubjectWork(UnicastProcessor<T> param1UnicastProcessor, boolean param1Boolean) {
      this.w = param1UnicastProcessor;
      this.open = param1Boolean;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableWindowTimed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */