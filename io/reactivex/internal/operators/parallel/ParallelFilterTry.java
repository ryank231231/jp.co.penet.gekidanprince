package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilterTry<T> extends ParallelFlowable<T> {
  final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
  
  final Predicate<? super T> predicate;
  
  final ParallelFlowable<T> source;
  
  public ParallelFilterTry(ParallelFlowable<T> paramParallelFlowable, Predicate<? super T> paramPredicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> paramBiFunction) {
    this.source = paramParallelFlowable;
    this.predicate = paramPredicate;
    this.errorHandler = paramBiFunction;
  }
  
  public int parallelism() {
    return this.source.parallelism();
  }
  
  public void subscribe(Subscriber<? super T>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    int i = paramArrayOfSubscriber.length;
    Subscriber[] arrayOfSubscriber = new Subscriber[i];
    for (byte b = 0; b < i; b++) {
      Subscriber<? super T> subscriber = paramArrayOfSubscriber[b];
      if (subscriber instanceof ConditionalSubscriber) {
        arrayOfSubscriber[b] = (Subscriber)new ParallelFilterConditionalSubscriber<T>((ConditionalSubscriber<? super T>)subscriber, this.predicate, this.errorHandler);
      } else {
        arrayOfSubscriber[b] = (Subscriber)new ParallelFilterSubscriber<T>(subscriber, this.predicate, this.errorHandler);
      } 
    } 
    this.source.subscribe(arrayOfSubscriber);
  }
  
  static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
    boolean done;
    
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    
    final Predicate<? super T> predicate;
    
    Subscription s;
    
    BaseFilterSubscriber(Predicate<? super T> param1Predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> param1BiFunction) {
      this.predicate = param1Predicate;
      this.errorHandler = param1BiFunction;
    }
    
    public final void cancel() {
      this.s.cancel();
    }
    
    public final void onNext(T param1T) {
      if (!tryOnNext(param1T) && !this.done)
        this.s.request(1L); 
    }
    
    public final void request(long param1Long) {
      this.s.request(param1Long);
    }
  }
  
  static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
    final ConditionalSubscriber<? super T> actual;
    
    ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> param1ConditionalSubscriber, Predicate<? super T> param1Predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> param1BiFunction) {
      super(param1Predicate, param1BiFunction);
      this.actual = param1ConditionalSubscriber;
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
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
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public boolean tryOnNext(T param1T) {
      if (!this.done) {
        long l = 0L;
        while (true) {
          boolean bool = true;
          try {
            boolean bool1 = this.predicate.test(param1T);
            if (!bool1 || !this.actual.tryOnNext(param1T))
              bool = false; 
            return bool;
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
      return false;
    }
  }
  
  static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
    final Subscriber<? super T> actual;
    
    ParallelFilterSubscriber(Subscriber<? super T> param1Subscriber, Predicate<? super T> param1Predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> param1BiFunction) {
      super(param1Predicate, param1BiFunction);
      this.actual = param1Subscriber;
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
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
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public boolean tryOnNext(T param1T) {
      if (!this.done) {
        long l = 0L;
        while (true) {
          try {
            boolean bool = this.predicate.test(param1T);
            if (bool) {
              this.actual.onNext(param1T);
              return true;
            } 
            return false;
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
      return false;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFilterTry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */