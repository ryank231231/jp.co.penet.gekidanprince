package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounce<T, U> extends AbstractFlowableWithUpstream<T, T> {
  final Function<? super T, ? extends Publisher<U>> debounceSelector;
  
  public FlowableDebounce(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<U>> paramFunction) {
    super(paramFlowable);
    this.debounceSelector = paramFunction;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new DebounceSubscriber<T, U>((Subscriber<? super T>)new SerializedSubscriber(paramSubscriber), this.debounceSelector));
  }
  
  static final class DebounceSubscriber<T, U> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 6725975399620862591L;
    
    final Subscriber<? super T> actual;
    
    final Function<? super T, ? extends Publisher<U>> debounceSelector;
    
    final AtomicReference<Disposable> debouncer = new AtomicReference<Disposable>();
    
    boolean done;
    
    volatile long index;
    
    Subscription s;
    
    DebounceSubscriber(Subscriber<? super T> param1Subscriber, Function<? super T, ? extends Publisher<U>> param1Function) {
      this.actual = param1Subscriber;
      this.debounceSelector = param1Function;
    }
    
    public void cancel() {
      this.s.cancel();
      DisposableHelper.dispose(this.debouncer);
    }
    
    void emit(long param1Long, T param1T) {
      if (param1Long == this.index)
        if (get() != 0L) {
          this.actual.onNext(param1T);
          BackpressureHelper.produced(this, 1L);
        } else {
          cancel();
          this.actual.onError((Throwable)new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }  
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      Disposable disposable = this.debouncer.get();
      if (!DisposableHelper.isDisposed(disposable)) {
        ((DebounceInnerSubscriber)disposable).emit();
        DisposableHelper.dispose(this.debouncer);
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      DisposableHelper.dispose(this.debouncer);
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      long l = this.index + 1L;
      this.index = l;
      Disposable disposable = this.debouncer.get();
      if (disposable != null)
        disposable.dispose(); 
      try {
        Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.debounceSelector.apply(param1T), "The publisher supplied is null");
        DebounceInnerSubscriber<T, Object> debounceInnerSubscriber = new DebounceInnerSubscriber<T, Object>(this, l, param1T);
        if (this.debouncer.compareAndSet(disposable, debounceInnerSubscriber))
          publisher.subscribe((Subscriber)debounceInnerSubscriber); 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        cancel();
        this.actual.onError(throwable);
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
      if (SubscriptionHelper.validate(param1Long))
        BackpressureHelper.add(this, param1Long); 
    }
    
    static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
      boolean done;
      
      final long index;
      
      final AtomicBoolean once = new AtomicBoolean();
      
      final FlowableDebounce.DebounceSubscriber<T, U> parent;
      
      final T value;
      
      DebounceInnerSubscriber(FlowableDebounce.DebounceSubscriber<T, U> param2DebounceSubscriber, long param2Long, T param2T) {
        this.parent = param2DebounceSubscriber;
        this.index = param2Long;
        this.value = param2T;
      }
      
      void emit() {
        if (this.once.compareAndSet(false, true))
          this.parent.emit(this.index, this.value); 
      }
      
      public void onComplete() {
        if (this.done)
          return; 
        this.done = true;
        emit();
      }
      
      public void onError(Throwable param2Throwable) {
        if (this.done) {
          RxJavaPlugins.onError(param2Throwable);
          return;
        } 
        this.done = true;
        this.parent.onError(param2Throwable);
      }
      
      public void onNext(U param2U) {
        if (this.done)
          return; 
        this.done = true;
        cancel();
        emit();
      }
    }
  }
  
  static final class DebounceInnerSubscriber<T, U> extends DisposableSubscriber<U> {
    boolean done;
    
    final long index;
    
    final AtomicBoolean once = new AtomicBoolean();
    
    final FlowableDebounce.DebounceSubscriber<T, U> parent;
    
    final T value;
    
    DebounceInnerSubscriber(FlowableDebounce.DebounceSubscriber<T, U> param1DebounceSubscriber, long param1Long, T param1T) {
      this.parent = param1DebounceSubscriber;
      this.index = param1Long;
      this.value = param1T;
    }
    
    void emit() {
      if (this.once.compareAndSet(false, true))
        this.parent.emit(this.index, this.value); 
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      emit();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.parent.onError(param1Throwable);
    }
    
    public void onNext(U param1U) {
      if (this.done)
        return; 
      this.done = true;
      cancel();
      emit();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableDebounce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */