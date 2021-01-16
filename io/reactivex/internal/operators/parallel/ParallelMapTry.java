package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {
  final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
  
  final Function<? super T, ? extends R> mapper;
  
  final ParallelFlowable<T> source;
  
  public ParallelMapTry(ParallelFlowable<T> paramParallelFlowable, Function<? super T, ? extends R> paramFunction, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction) {
    this.source = paramParallelFlowable;
    this.mapper = paramFunction;
    this.errorHandler = paramBiFunction;
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
        arrayOfSubscriber[b] = (Subscriber)new ParallelMapTryConditionalSubscriber<T, R>((ConditionalSubscriber<? super R>)subscriber, this.mapper, this.errorHandler);
      } else {
        arrayOfSubscriber[b] = (Subscriber)new ParallelMapTrySubscriber<T, R>(subscriber, this.mapper, this.errorHandler);
      } 
    } 
    this.source.subscribe(arrayOfSubscriber);
  }
  
  static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
    final ConditionalSubscriber<? super R> actual;
    
    boolean done;
    
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    
    final Function<? super T, ? extends R> mapper;
    
    Subscription s;
    
    ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> param1ConditionalSubscriber, Function<? super T, ? extends R> param1Function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> param1BiFunction) {
      this.actual = param1ConditionalSubscriber;
      this.mapper = param1Function;
      this.errorHandler = param1BiFunction;
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
      if (!tryOnNext(param1T) && !this.done)
        this.s.request(1L); 
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
      long l = 0L;
      while (true) {
        try {
          Object object = ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null value");
          return this.actual.tryOnNext(object);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          try {
            BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction = this.errorHandler;
            l++;
            ParallelFailureHandling parallelFailureHandling = (ParallelFailureHandling)ObjectHelper.requireNonNull(biFunction.apply(Long.valueOf(l), throwable), "The errorHandler returned a null item");
            switch (parallelFailureHandling) {
              case RETRY:
                continue;
              default:
                cancel();
                onError(throwable);
                return false;
              case STOP:
                cancel();
                onComplete();
                return false;
              case SKIP:
                break;
            } 
            return false;
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            cancel();
            onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
            return false;
          } 
        } 
      } 
    }
  }
  
  static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
    final Subscriber<? super R> actual;
    
    boolean done;
    
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    
    final Function<? super T, ? extends R> mapper;
    
    Subscription s;
    
    ParallelMapTrySubscriber(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends R> param1Function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> param1BiFunction) {
      this.actual = param1Subscriber;
      this.mapper = param1Function;
      this.errorHandler = param1BiFunction;
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
      if (!tryOnNext(param1T) && !this.done)
        this.s.request(1L); 
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
      long l = 0L;
      while (true) {
        try {
          Object object = ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null value");
          this.actual.onNext(object);
          return true;
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          try {
            BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction = this.errorHandler;
            l++;
            ParallelFailureHandling parallelFailureHandling = (ParallelFailureHandling)ObjectHelper.requireNonNull(biFunction.apply(Long.valueOf(l), throwable), "The errorHandler returned a null item");
            switch (parallelFailureHandling) {
              case RETRY:
                continue;
              default:
                cancel();
                onError(throwable);
                return false;
              case STOP:
                cancel();
                onComplete();
                return false;
              case SKIP:
                break;
            } 
            return false;
          } catch (Throwable throwable1) {
            Exceptions.throwIfFatal(throwable1);
            cancel();
            onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
            return false;
          } 
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelMapTry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */