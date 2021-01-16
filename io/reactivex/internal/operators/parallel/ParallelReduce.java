package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelReduce<T, R> extends ParallelFlowable<R> {
  final Callable<R> initialSupplier;
  
  final BiFunction<R, ? super T, R> reducer;
  
  final ParallelFlowable<? extends T> source;
  
  public ParallelReduce(ParallelFlowable<? extends T> paramParallelFlowable, Callable<R> paramCallable, BiFunction<R, ? super T, R> paramBiFunction) {
    this.source = paramParallelFlowable;
    this.initialSupplier = paramCallable;
    this.reducer = paramBiFunction;
  }
  
  public int parallelism() {
    return this.source.parallelism();
  }
  
  void reportError(Subscriber<?>[] paramArrayOfSubscriber, Throwable paramThrowable) {
    int i = paramArrayOfSubscriber.length;
    for (byte b = 0; b < i; b++)
      EmptySubscription.error(paramThrowable, paramArrayOfSubscriber[b]); 
  }
  
  public void subscribe(Subscriber<? super R>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    int i = paramArrayOfSubscriber.length;
    Subscriber[] arrayOfSubscriber = new Subscriber[i];
    byte b = 0;
    while (b < i) {
      try {
        Object object = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value");
        arrayOfSubscriber[b] = (Subscriber)new ParallelReduceSubscriber<T, R>(paramArrayOfSubscriber[b], (R)object, this.reducer);
        b++;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        reportError((Subscriber<?>[])paramArrayOfSubscriber, throwable);
        return;
      } 
    } 
    this.source.subscribe((Subscriber[])throwable);
  }
  
  static final class ParallelReduceSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
    private static final long serialVersionUID = 8200530050639449080L;
    
    R accumulator;
    
    boolean done;
    
    final BiFunction<R, ? super T, R> reducer;
    
    ParallelReduceSubscriber(Subscriber<? super R> param1Subscriber, R param1R, BiFunction<R, ? super T, R> param1BiFunction) {
      super(param1Subscriber);
      this.accumulator = param1R;
      this.reducer = param1BiFunction;
    }
    
    public void cancel() {
      super.cancel();
      this.s.cancel();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        R r = this.accumulator;
        this.accumulator = null;
        complete(r);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.accumulator = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (!this.done)
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.reducer.apply(this.accumulator, param1T), "The reducer returned a null value");
          this.accumulator = (R)param1T;
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
        this.actual.onSubscribe((Subscription)this);
        param1Subscription.request(Long.MAX_VALUE);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelReduce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */