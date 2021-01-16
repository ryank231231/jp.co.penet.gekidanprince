package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {
  final long bufferSize;
  
  final Action onOverflow;
  
  final BackpressureOverflowStrategy strategy;
  
  public FlowableOnBackpressureBufferStrategy(Flowable<T> paramFlowable, long paramLong, Action paramAction, BackpressureOverflowStrategy paramBackpressureOverflowStrategy) {
    super(paramFlowable);
    this.bufferSize = paramLong;
    this.onOverflow = paramAction;
    this.strategy = paramBackpressureOverflowStrategy;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new OnBackpressureBufferStrategySubscriber<T>(paramSubscriber, this.onOverflow, this.strategy, this.bufferSize));
  }
  
  static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 3240706908776709697L;
    
    final Subscriber<? super T> actual;
    
    final long bufferSize;
    
    volatile boolean cancelled;
    
    final Deque<T> deque;
    
    volatile boolean done;
    
    Throwable error;
    
    final Action onOverflow;
    
    final AtomicLong requested;
    
    Subscription s;
    
    final BackpressureOverflowStrategy strategy;
    
    OnBackpressureBufferStrategySubscriber(Subscriber<? super T> param1Subscriber, Action param1Action, BackpressureOverflowStrategy param1BackpressureOverflowStrategy, long param1Long) {
      this.actual = param1Subscriber;
      this.onOverflow = param1Action;
      this.strategy = param1BackpressureOverflowStrategy;
      this.bufferSize = param1Long;
      this.requested = new AtomicLong();
      this.deque = new ArrayDeque<T>();
    }
    
    public void cancel() {
      this.cancelled = true;
      this.s.cancel();
      if (getAndIncrement() == 0)
        clear(this.deque); 
    }
    
    void clear(Deque<T> param1Deque) {
      // Byte code:
      //   0: aload_1
      //   1: monitorenter
      //   2: aload_1
      //   3: invokeinterface clear : ()V
      //   8: aload_1
      //   9: monitorexit
      //   10: return
      //   11: astore_2
      //   12: aload_1
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	10	11	finally
      //   12	14	11	finally
    }
    
    void drain() {
      int j;
      if (getAndIncrement() != 0)
        return; 
      Deque<T> deque = this.deque;
      Subscriber<? super T> subscriber = this.actual;
      int i = 1;
      do {
        long l1 = this.requested.get();
        long l2 = 0L;
        while (l2 != l1) {
          if (this.cancelled) {
            clear(deque);
            return;
          } 
          synchronized (this.done) {
            boolean bool;
            T t = deque.poll();
            /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Deque<GenericType{T}>}, name=null} */
            if (t == null) {
              bool = true;
            } else {
              bool = false;
            } 
            if (null) {
              Throwable throwable = this.error;
              if (throwable != null) {
                clear(deque);
                subscriber.onError(throwable);
                return;
              } 
              if (bool) {
                subscriber.onComplete();
                return;
              } 
            } 
            if (bool)
              break; 
            subscriber.onNext(t);
            l2++;
          } 
        } 
        if (l2 == l1) {
          if (this.cancelled) {
            clear(deque);
            return;
          } 
          synchronized (this.done) {
            boolean bool = deque.isEmpty();
            /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/Deque<GenericType{T}>}, name=null} */
            if (null) {
              Throwable throwable = this.error;
              if (throwable != null) {
                clear(deque);
                subscriber.onError(throwable);
                return;
              } 
              if (bool) {
                subscriber.onComplete();
                return;
              } 
            } 
          } 
        } 
        if (l2 != 0L)
          BackpressureHelper.produced(this.requested, l2); 
        j = addAndGet(-i);
        i = j;
      } while (j != 0);
    }
    
    public void onComplete() {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.error = param1Throwable;
      this.done = true;
      drain();
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      synchronized (this.deque) {
        long l1 = null.size();
        long l2 = this.bufferSize;
        boolean bool1 = false;
        boolean bool2 = true;
        if (l1 == l2) {
          switch (this.strategy) {
            case DROP_OLDEST:
              null.poll();
              null.offer(param1T);
              bool1 = true;
              bool2 = false;
              break;
            case DROP_LATEST:
              null.pollLast();
              null.offer(param1T);
              bool1 = true;
              bool2 = false;
              break;
          } 
        } else {
          null.offer(param1T);
          bool2 = false;
        } 
        if (bool1) {
          Action action = this.onOverflow;
          if (action != null)
            try {
              action.run();
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              this.s.cancel();
              onError(throwable);
            }  
        } else if (bool2) {
          this.s.cancel();
          onError((Throwable)new MissingBackpressureException());
        } else {
          drain();
        } 
        return;
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
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.add(this.requested, param1Long);
        drain();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableOnBackpressureBufferStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */