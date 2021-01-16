package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class CompletableConcat extends Completable {
  final int prefetch;
  
  final Publisher<? extends CompletableSource> sources;
  
  public CompletableConcat(Publisher<? extends CompletableSource> paramPublisher, int paramInt) {
    this.sources = paramPublisher;
    this.prefetch = paramInt;
  }
  
  public void subscribeActual(CompletableObserver paramCompletableObserver) {
    this.sources.subscribe((Subscriber)new CompletableConcatSubscriber(paramCompletableObserver, this.prefetch));
  }
  
  static final class CompletableConcatSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
    private static final long serialVersionUID = 9032184911934499404L;
    
    volatile boolean active;
    
    final CompletableObserver actual;
    
    int consumed;
    
    volatile boolean done;
    
    final ConcatInnerObserver inner;
    
    final int limit;
    
    final AtomicBoolean once;
    
    final int prefetch;
    
    SimpleQueue<CompletableSource> queue;
    
    Subscription s;
    
    int sourceFused;
    
    CompletableConcatSubscriber(CompletableObserver param1CompletableObserver, int param1Int) {
      this.actual = param1CompletableObserver;
      this.prefetch = param1Int;
      this.inner = new ConcatInnerObserver(this);
      this.once = new AtomicBoolean();
      this.limit = param1Int - (param1Int >> 2);
    }
    
    public void dispose() {
      this.s.cancel();
      DisposableHelper.dispose(this.inner);
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      do {
        if (isDisposed())
          return; 
        if (this.active)
          continue; 
        boolean bool = this.done;
        try {
          boolean bool1;
          CompletableSource completableSource = (CompletableSource)this.queue.poll();
          if (completableSource == null) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (bool && bool1) {
            if (this.once.compareAndSet(false, true))
              this.actual.onComplete(); 
            return;
          } 
          if (!bool1) {
            this.active = true;
            completableSource.subscribe(this.inner);
            request();
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          innerError(throwable);
          return;
        } 
      } while (decrementAndGet() != 0);
    }
    
    void innerComplete() {
      this.active = false;
      drain();
    }
    
    void innerError(Throwable param1Throwable) {
      if (this.once.compareAndSet(false, true)) {
        this.s.cancel();
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public boolean isDisposed() {
      return DisposableHelper.isDisposed(this.inner.get());
    }
    
    public void onComplete() {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.once.compareAndSet(false, true)) {
        DisposableHelper.dispose(this.inner);
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(CompletableSource param1CompletableSource) {
      if (this.sourceFused == 0 && !this.queue.offer(param1CompletableSource)) {
        onError((Throwable)new MissingBackpressureException());
        return;
      } 
      drain();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        long l;
        this.s = param1Subscription;
        int i = this.prefetch;
        if (i == Integer.MAX_VALUE) {
          l = Long.MAX_VALUE;
        } else {
          l = i;
        } 
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          i = queueSubscription.requestFusion(3);
          if (i == 1) {
            this.sourceFused = i;
            this.queue = (SimpleQueue<CompletableSource>)queueSubscription;
            this.done = true;
            this.actual.onSubscribe(this);
            drain();
            return;
          } 
          if (i == 2) {
            this.sourceFused = i;
            this.queue = (SimpleQueue<CompletableSource>)queueSubscription;
            this.actual.onSubscribe(this);
            param1Subscription.request(l);
            return;
          } 
        } 
        i = this.prefetch;
        if (i == Integer.MAX_VALUE) {
          this.queue = (SimpleQueue<CompletableSource>)new SpscLinkedArrayQueue(Flowable.bufferSize());
        } else {
          this.queue = (SimpleQueue<CompletableSource>)new SpscArrayQueue(i);
        } 
        this.actual.onSubscribe(this);
        param1Subscription.request(l);
      } 
    }
    
    void request() {
      if (this.sourceFused != 1) {
        int i = this.consumed + 1;
        if (i == this.limit) {
          this.consumed = 0;
          this.s.request(i);
        } else {
          this.consumed = i;
        } 
      } 
    }
    
    static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
      private static final long serialVersionUID = -5454794857847146511L;
      
      final CompletableConcat.CompletableConcatSubscriber parent;
      
      ConcatInnerObserver(CompletableConcat.CompletableConcatSubscriber param2CompletableConcatSubscriber) {
        this.parent = param2CompletableConcatSubscriber;
      }
      
      public void onComplete() {
        this.parent.innerComplete();
      }
      
      public void onError(Throwable param2Throwable) {
        this.parent.innerError(param2Throwable);
      }
      
      public void onSubscribe(Disposable param2Disposable) {
        DisposableHelper.replace(this, param2Disposable);
      }
    }
  }
  
  static final class ConcatInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
    private static final long serialVersionUID = -5454794857847146511L;
    
    final CompletableConcat.CompletableConcatSubscriber parent;
    
    ConcatInnerObserver(CompletableConcat.CompletableConcatSubscriber param1CompletableConcatSubscriber) {
      this.parent = param1CompletableConcatSubscriber;
    }
    
    public void onComplete() {
      this.parent.innerComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.parent.innerError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.replace(this, param1Disposable);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\completable\CompletableConcat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */