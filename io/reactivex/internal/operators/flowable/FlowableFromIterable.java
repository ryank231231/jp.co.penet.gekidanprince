package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromIterable<T> extends Flowable<T> {
  final Iterable<? extends T> source;
  
  public FlowableFromIterable(Iterable<? extends T> paramIterable) {
    this.source = paramIterable;
  }
  
  public static <T> void subscribe(Subscriber<? super T> paramSubscriber, Iterator<? extends T> paramIterator) {
    try {
      boolean bool = paramIterator.hasNext();
      if (!bool) {
        EmptySubscription.complete(paramSubscriber);
        return;
      } 
      if (paramSubscriber instanceof ConditionalSubscriber) {
        paramSubscriber.onSubscribe((Subscription)new IteratorConditionalSubscription<T>((ConditionalSubscriber<? super T>)paramSubscriber, paramIterator));
      } else {
        paramSubscriber.onSubscribe((Subscription)new IteratorSubscription<T>(paramSubscriber, paramIterator));
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    try {
      Iterator<? extends T> iterator = this.source.iterator();
      subscribe(paramSubscriber, iterator);
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
  
  static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
    private static final long serialVersionUID = -2252972430506210021L;
    
    volatile boolean cancelled;
    
    Iterator<? extends T> it;
    
    boolean once;
    
    BaseRangeSubscription(Iterator<? extends T> param1Iterator) {
      this.it = param1Iterator;
    }
    
    public final void cancel() {
      this.cancelled = true;
    }
    
    public final void clear() {
      this.it = null;
    }
    
    abstract void fastPath();
    
    public final boolean isEmpty() {
      Iterator<? extends T> iterator = this.it;
      return (iterator == null || !iterator.hasNext());
    }
    
    @Nullable
    public final T poll() {
      Iterator<? extends T> iterator = this.it;
      if (iterator == null)
        return null; 
      if (!this.once) {
        this.once = true;
      } else if (!iterator.hasNext()) {
        return null;
      } 
      return (T)ObjectHelper.requireNonNull(this.it.next(), "Iterator.next() returned a null value");
    }
    
    public final void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long) && BackpressureHelper.add((AtomicLong)this, param1Long) == 0L)
        if (param1Long == Long.MAX_VALUE) {
          fastPath();
        } else {
          slowPath(param1Long);
        }  
    }
    
    public final int requestFusion(int param1Int) {
      return param1Int & 0x1;
    }
    
    abstract void slowPath(long param1Long);
  }
  
  static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    
    final ConditionalSubscriber<? super T> actual;
    
    IteratorConditionalSubscription(ConditionalSubscriber<? super T> param1ConditionalSubscriber, Iterator<? extends T> param1Iterator) {
      super(param1Iterator);
      this.actual = param1ConditionalSubscriber;
    }
    
    void fastPath() {
      Iterator<? extends T> iterator = this.it;
      ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
      while (true) {
        if (this.cancelled)
          return; 
        try {
          T t = iterator.next();
          if (this.cancelled)
            return; 
          if (t == null) {
            conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
          } 
          conditionalSubscriber.tryOnNext(t);
          if (this.cancelled)
            return; 
          try {
            boolean bool = iterator.hasNext();
            if (!bool) {
              if (!this.cancelled)
                conditionalSubscriber.onComplete(); 
              return;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            conditionalSubscriber.onError(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          conditionalSubscriber.onError(throwable);
          break;
        } 
      } 
    }
    
    void slowPath(long param1Long) {
      Iterator<? extends T> iterator = this.it;
      ConditionalSubscriber<? super T> conditionalSubscriber = this.actual;
      long l = 0L;
      while (true) {
        while (l != param1Long) {
          if (this.cancelled)
            return; 
          try {
            T t = iterator.next();
            if (this.cancelled)
              return; 
            if (t == null) {
              conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
              return;
            } 
            boolean bool = conditionalSubscriber.tryOnNext(t);
            if (this.cancelled)
              return; 
            try {
              boolean bool1 = iterator.hasNext();
              if (!bool1) {
                if (!this.cancelled)
                  conditionalSubscriber.onComplete(); 
                return;
              } 
              if (bool)
                l++; 
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              conditionalSubscriber.onError(throwable);
              return;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            conditionalSubscriber.onError(throwable);
            return;
          } 
        } 
        long l1 = get();
        param1Long = l1;
        if (l == l1) {
          param1Long = addAndGet(-l);
          if (param1Long == 0L)
            return; 
          l = 0L;
        } 
      } 
    }
  }
  
  static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    
    final Subscriber<? super T> actual;
    
    IteratorSubscription(Subscriber<? super T> param1Subscriber, Iterator<? extends T> param1Iterator) {
      super(param1Iterator);
      this.actual = param1Subscriber;
    }
    
    void fastPath() {
      Iterator<? extends T> iterator = this.it;
      Subscriber<? super T> subscriber = this.actual;
      while (true) {
        if (this.cancelled)
          return; 
        try {
          T t = iterator.next();
          if (this.cancelled)
            return; 
          if (t == null) {
            subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
            return;
          } 
          subscriber.onNext(t);
          if (this.cancelled)
            return; 
          try {
            boolean bool = iterator.hasNext();
            if (!bool) {
              if (!this.cancelled)
                subscriber.onComplete(); 
              return;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            subscriber.onError(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          subscriber.onError(throwable);
          break;
        } 
      } 
    }
    
    void slowPath(long param1Long) {
      Iterator<? extends T> iterator = this.it;
      Subscriber<? super T> subscriber = this.actual;
      long l = 0L;
      while (true) {
        while (l != param1Long) {
          if (this.cancelled)
            return; 
          try {
            T t = iterator.next();
            if (this.cancelled)
              return; 
            if (t == null) {
              subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
              return;
            } 
            subscriber.onNext(t);
            if (this.cancelled)
              return; 
            try {
              boolean bool = iterator.hasNext();
              if (!bool) {
                if (!this.cancelled)
                  subscriber.onComplete(); 
                return;
              } 
              l++;
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              subscriber.onError(throwable);
              return;
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            subscriber.onError(throwable);
            return;
          } 
        } 
        long l1 = get();
        param1Long = l1;
        if (l == l1) {
          param1Long = addAndGet(-l);
          if (param1Long == 0L)
            return; 
          l = 0L;
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFromIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */