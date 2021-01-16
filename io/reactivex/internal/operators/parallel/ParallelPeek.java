package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelPeek<T> extends ParallelFlowable<T> {
  final Consumer<? super T> onAfterNext;
  
  final Action onAfterTerminated;
  
  final Action onCancel;
  
  final Action onComplete;
  
  final Consumer<? super Throwable> onError;
  
  final Consumer<? super T> onNext;
  
  final LongConsumer onRequest;
  
  final Consumer<? super Subscription> onSubscribe;
  
  final ParallelFlowable<T> source;
  
  public ParallelPeek(ParallelFlowable<T> paramParallelFlowable, Consumer<? super T> paramConsumer1, Consumer<? super T> paramConsumer2, Consumer<? super Throwable> paramConsumer, Action paramAction1, Action paramAction2, Consumer<? super Subscription> paramConsumer3, LongConsumer paramLongConsumer, Action paramAction3) {
    this.source = paramParallelFlowable;
    this.onNext = (Consumer<? super T>)ObjectHelper.requireNonNull(paramConsumer1, "onNext is null");
    this.onAfterNext = (Consumer<? super T>)ObjectHelper.requireNonNull(paramConsumer2, "onAfterNext is null");
    this.onError = (Consumer<? super Throwable>)ObjectHelper.requireNonNull(paramConsumer, "onError is null");
    this.onComplete = (Action)ObjectHelper.requireNonNull(paramAction1, "onComplete is null");
    this.onAfterTerminated = (Action)ObjectHelper.requireNonNull(paramAction2, "onAfterTerminated is null");
    this.onSubscribe = (Consumer<? super Subscription>)ObjectHelper.requireNonNull(paramConsumer3, "onSubscribe is null");
    this.onRequest = (LongConsumer)ObjectHelper.requireNonNull(paramLongConsumer, "onRequest is null");
    this.onCancel = (Action)ObjectHelper.requireNonNull(paramAction3, "onCancel is null");
  }
  
  public int parallelism() {
    return this.source.parallelism();
  }
  
  public void subscribe(Subscriber<? super T>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    int i = paramArrayOfSubscriber.length;
    Subscriber[] arrayOfSubscriber = new Subscriber[i];
    for (byte b = 0; b < i; b++)
      arrayOfSubscriber[b] = (Subscriber)new ParallelPeekSubscriber<T>(paramArrayOfSubscriber[b], this); 
    this.source.subscribe(arrayOfSubscriber);
  }
  
  static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> actual;
    
    boolean done;
    
    final ParallelPeek<T> parent;
    
    Subscription s;
    
    ParallelPeekSubscriber(Subscriber<? super T> param1Subscriber, ParallelPeek<T> param1ParallelPeek) {
      this.actual = param1Subscriber;
      this.parent = param1ParallelPeek;
    }
    
    public void cancel() {
      try {
        this.parent.onCancel.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
      this.s.cancel();
    }
    
    public void onComplete() {
      if (!this.done) {
        this.done = true;
        try {
          this.parent.onComplete.run();
          this.actual.onComplete();
          try {
            this.parent.onAfterTerminated.run();
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            RxJavaPlugins.onError(throwable);
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          this.actual.onError(throwable);
          return;
        } 
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      CompositeException compositeException;
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      try {
        this.parent.onError.accept(param1Throwable);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        compositeException = new CompositeException(new Throwable[] { param1Throwable, throwable });
      } 
      this.actual.onError((Throwable)compositeException);
      try {
        this.parent.onAfterTerminated.run();
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (!this.done)
        try {
          this.parent.onNext.accept(param1T);
          this.actual.onNext(param1T);
          try {
            this.parent.onAfterNext.accept(param1T);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            onError(throwable);
          } 
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          onError(throwable);
          return;
        }  
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        try {
          this.parent.onSubscribe.accept(param1Subscription);
          this.actual.onSubscribe(this);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          param1Subscription.cancel();
          this.actual.onSubscribe((Subscription)EmptySubscription.INSTANCE);
          onError(throwable);
          return;
        } 
      } 
    }
    
    public void request(long param1Long) {
      try {
        this.parent.onRequest.accept(param1Long);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError(throwable);
      } 
      this.s.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelPeek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */