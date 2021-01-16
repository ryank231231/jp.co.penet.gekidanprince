package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMap<T, R> extends ParallelFlowable<R> {
  final Function<? super T, ? extends R> mapper;
  
  final ParallelFlowable<T> source;
  
  public ParallelMap(ParallelFlowable<T> paramParallelFlowable, Function<? super T, ? extends R> paramFunction) {
    this.source = paramParallelFlowable;
    this.mapper = paramFunction;
  }
  
  public int parallelism() {
    return this.source.parallelism();
  }
  
  public void subscribe(Subscriber<? super R>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    int i = paramArrayOfSubscriber.length;
    Subscriber[] arrayOfSubscriber = new Subscriber[i];
    for (byte b = 0; b < i; b++) {
      Subscriber<? super R> subscriber = paramArrayOfSubscriber[b];
      if (subscriber instanceof ConditionalSubscriber) {
        arrayOfSubscriber[b] = (Subscriber)new ParallelMapConditionalSubscriber<T, R>((ConditionalSubscriber<? super R>)subscriber, this.mapper);
      } else {
        arrayOfSubscriber[b] = (Subscriber)new ParallelMapSubscriber<T, R>(subscriber, this.mapper);
      } 
    } 
    this.source.subscribe(arrayOfSubscriber);
  }
  
  static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
    final ConditionalSubscriber<? super R> actual;
    
    boolean done;
    
    final Function<? super T, ? extends R> mapper;
    
    Subscription s;
    
    ParallelMapConditionalSubscriber(ConditionalSubscriber<? super R> param1ConditionalSubscriber, Function<? super T, ? extends R> param1Function) {
      this.actual = param1ConditionalSubscriber;
      this.mapper = param1Function;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
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
      if (this.done)
        return; 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null value");
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        cancel();
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
      this.s.request(param1Long);
    }
    
    public boolean tryOnNext(T param1T) {
      if (this.done)
        return false; 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null value");
        return this.actual.tryOnNext(param1T);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        cancel();
        onError(throwable);
        return false;
      } 
    }
  }
  
  static final class ParallelMapSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super R> actual;
    
    boolean done;
    
    final Function<? super T, ? extends R> mapper;
    
    Subscription s;
    
    ParallelMapSubscriber(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends R> param1Function) {
      this.actual = param1Subscriber;
      this.mapper = param1Function;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
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
      if (this.done)
        return; 
      try {
        param1T = (T)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null value");
        this.actual.onNext(param1T);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        cancel();
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
      this.s.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */