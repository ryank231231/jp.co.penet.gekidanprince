package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {
  final BiFunction<T, T, T> reducer;
  
  final Flowable<T> source;
  
  public FlowableReduceMaybe(Flowable<T> paramFlowable, BiFunction<T, T, T> paramBiFunction) {
    this.source = paramFlowable;
    this.reducer = paramBiFunction;
  }
  
  public Flowable<T> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableReduce<T>(this.source, this.reducer));
  }
  
  public Publisher<T> source() {
    return (Publisher<T>)this.source;
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver) {
    this.source.subscribe(new ReduceSubscriber<T>(paramMaybeObserver, this.reducer));
  }
  
  static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {
    final MaybeObserver<? super T> actual;
    
    boolean done;
    
    final BiFunction<T, T, T> reducer;
    
    Subscription s;
    
    T value;
    
    ReduceSubscriber(MaybeObserver<? super T> param1MaybeObserver, BiFunction<T, T, T> param1BiFunction) {
      this.actual = param1MaybeObserver;
      this.reducer = param1BiFunction;
    }
    
    public void dispose() {
      this.s.cancel();
      this.done = true;
    }
    
    public boolean isDisposed() {
      return this.done;
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      T t = this.value;
      if (t != null) {
        this.actual.onSuccess(t);
      } else {
        this.actual.onComplete();
      } 
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
      if (this.done)
        return; 
      T t = this.value;
      if (t == null) {
        this.value = param1T;
      } else {
        try {
          this.value = (T)ObjectHelper.requireNonNull(this.reducer.apply(t, param1T), "The reducer returned a null value");
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.s.cancel();
          onError(throwable);
        } 
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableReduceMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */