package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
  final Callable<C> bufferSupplier;
  
  final int size;
  
  final int skip;
  
  public FlowableBuffer(Flowable<T> paramFlowable, int paramInt1, int paramInt2, Callable<C> paramCallable) {
    super(paramFlowable);
    this.size = paramInt1;
    this.skip = paramInt2;
    this.bufferSupplier = paramCallable;
  }
  
  public void subscribeActual(Subscriber<? super C> paramSubscriber) {
    int i = this.size;
    int j = this.skip;
    if (i == j) {
      this.source.subscribe(new PublisherBufferExactSubscriber<Object, C>(paramSubscriber, this.size, this.bufferSupplier));
    } else if (j > i) {
      this.source.subscribe(new PublisherBufferSkipSubscriber<Object, C>(paramSubscriber, this.size, this.skip, this.bufferSupplier));
    } else {
      this.source.subscribe(new PublisherBufferOverlappingSubscriber<Object, C>(paramSubscriber, this.size, this.skip, this.bufferSupplier));
    } 
  }
  
  static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super C> actual;
    
    C buffer;
    
    final Callable<C> bufferSupplier;
    
    boolean done;
    
    int index;
    
    Subscription s;
    
    final int size;
    
    PublisherBufferExactSubscriber(Subscriber<? super C> param1Subscriber, int param1Int, Callable<C> param1Callable) {
      this.actual = param1Subscriber;
      this.size = param1Int;
      this.bufferSupplier = param1Callable;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      C c = this.buffer;
      if (c != null && !c.isEmpty())
        this.actual.onNext(c); 
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
      Collection<Throwable> collection;
      if (this.done)
        return; 
      C c1 = this.buffer;
      C c2 = c1;
      if (c1 == null)
        try {
          collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
          this.buffer = (C)collection;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          cancel();
          onError(throwable);
          return;
        }  
      collection.add(throwable);
      int i = this.index + 1;
      if (i == this.size) {
        this.index = 0;
        this.buffer = null;
        this.actual.onNext(collection);
      } else {
        this.index = i;
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long))
        this.s.request(BackpressureHelper.multiplyCap(param1Long, this.size)); 
    }
  }
  
  static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
    private static final long serialVersionUID = -7370244972039324525L;
    
    final Subscriber<? super C> actual;
    
    final Callable<C> bufferSupplier;
    
    final ArrayDeque<C> buffers;
    
    volatile boolean cancelled;
    
    boolean done;
    
    int index;
    
    final AtomicBoolean once;
    
    long produced;
    
    Subscription s;
    
    final int size;
    
    final int skip;
    
    PublisherBufferOverlappingSubscriber(Subscriber<? super C> param1Subscriber, int param1Int1, int param1Int2, Callable<C> param1Callable) {
      this.actual = param1Subscriber;
      this.size = param1Int1;
      this.skip = param1Int2;
      this.bufferSupplier = param1Callable;
      this.once = new AtomicBoolean();
      this.buffers = new ArrayDeque<C>();
    }
    
    public void cancel() {
      this.cancelled = true;
      this.s.cancel();
    }
    
    public boolean getAsBoolean() {
      return this.cancelled;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      long l = this.produced;
      if (l != 0L)
        BackpressureHelper.produced(this, l); 
      QueueDrainHelper.postComplete(this.actual, this.buffers, this, this);
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.buffers.clear();
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      ArrayDeque<C> arrayDeque = this.buffers;
      int i = this.index;
      int j = i + 1;
      if (i == 0)
        try {
          Collection collection1 = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
          arrayDeque.offer((C)collection1);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          cancel();
          onError(throwable);
          return;
        }  
      Collection<Throwable> collection = (Collection)arrayDeque.peek();
      if (collection != null && collection.size() + 1 == this.size) {
        arrayDeque.poll();
        collection.add(throwable);
        this.produced++;
        this.actual.onNext(collection);
      } 
      Iterator<C> iterator = arrayDeque.iterator();
      while (iterator.hasNext())
        ((Collection<Throwable>)iterator.next()).add(throwable); 
      i = j;
      if (j == this.skip)
        i = 0; 
      this.index = i;
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        if (QueueDrainHelper.postCompleteRequest(param1Long, this.actual, this.buffers, this, this))
          return; 
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
          param1Long = BackpressureHelper.multiplyCap(this.skip, param1Long - 1L);
          param1Long = BackpressureHelper.addCap(this.size, param1Long);
          this.s.request(param1Long);
        } else {
          param1Long = BackpressureHelper.multiplyCap(this.skip, param1Long);
          this.s.request(param1Long);
        } 
      } 
    }
  }
  
  static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -5616169793639412593L;
    
    final Subscriber<? super C> actual;
    
    C buffer;
    
    final Callable<C> bufferSupplier;
    
    boolean done;
    
    int index;
    
    Subscription s;
    
    final int size;
    
    final int skip;
    
    PublisherBufferSkipSubscriber(Subscriber<? super C> param1Subscriber, int param1Int1, int param1Int2, Callable<C> param1Callable) {
      this.actual = param1Subscriber;
      this.size = param1Int1;
      this.skip = param1Int2;
      this.bufferSupplier = param1Callable;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      C c = this.buffer;
      this.buffer = null;
      if (c != null)
        this.actual.onNext(c); 
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.buffer = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      Collection<Throwable> collection;
      if (this.done)
        return; 
      C c = this.buffer;
      int i = this.index;
      int j = i + 1;
      if (i == 0)
        try {
          collection = (Collection)ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer");
          this.buffer = (C)collection;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          cancel();
          onError(throwable);
          return;
        }  
      if (collection != null) {
        collection.add(throwable);
        if (collection.size() == this.size) {
          this.buffer = null;
          this.actual.onNext(collection);
        } 
      } 
      i = j;
      if (j == this.skip)
        i = 0; 
      this.index = i;
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long))
        if (get() == 0 && compareAndSet(0, 1)) {
          long l = BackpressureHelper.multiplyCap(param1Long, this.size);
          param1Long = BackpressureHelper.multiplyCap((this.skip - this.size), param1Long - 1L);
          this.s.request(BackpressureHelper.addCap(l, param1Long));
        } else {
          this.s.request(BackpressureHelper.multiplyCap(this.skip, param1Long));
        }  
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */