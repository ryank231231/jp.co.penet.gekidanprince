package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
  final Subscriber<? super T> actual;
  
  boolean done;
  
  Subscription s;
  
  public SafeSubscriber(Subscriber<? super T> paramSubscriber) {
    this.actual = paramSubscriber;
  }
  
  public void cancel() {
    try {
      this.s.cancel();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
  
  public void onComplete() {
    if (this.done)
      return; 
    this.done = true;
    if (this.s == null) {
      onCompleteNoSubscription();
      return;
    } 
    try {
      this.actual.onComplete();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
  
  void onCompleteNoSubscription() {
    NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
    try {
      this.actual.onSubscribe((Subscription)EmptySubscription.INSTANCE);
      try {
        this.actual.onError(nullPointerException);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      return;
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    if (this.done) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.done = true;
    if (this.s == null) {
      NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
      try {
        this.actual.onSubscribe((Subscription)EmptySubscription.INSTANCE);
        try {
          Subscriber<? super T> subscriber = this.actual;
          CompositeException compositeException = new CompositeException();
          this(new Throwable[] { paramThrowable, nullPointerException });
          subscriber.onError((Throwable)compositeException);
        } catch (Throwable throwable1) {
          Exceptions.throwIfFatal(throwable1);
          RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, nullPointerException, throwable1 }));
        } 
        return;
      } catch (Throwable throwable1) {
        Exceptions.throwIfFatal(throwable1);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, nullPointerException, throwable1 }));
        return;
      } 
    } 
    Throwable throwable = paramThrowable;
    if (paramThrowable == null)
      throwable = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."); 
    try {
      this.actual.onError(throwable);
    } catch (Throwable throwable1) {
      Exceptions.throwIfFatal(throwable1);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
    } 
  }
  
  public void onNext(T paramT) {
    NullPointerException nullPointerException;
    if (this.done)
      return; 
    if (this.s == null) {
      onNextNoSubscription();
      return;
    } 
    if (paramT == null) {
      nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
      try {
        this.s.cancel();
        onError(nullPointerException);
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
        return;
      } 
    } 
    try {
      this.actual.onNext(nullPointerException);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      try {
        this.s.cancel();
        onError(throwable);
        return;
      } catch (Throwable throwable1) {
        Exceptions.throwIfFatal(throwable1);
        onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
        return;
      } 
    } 
  }
  
  void onNextNoSubscription() {
    this.done = true;
    NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
    try {
      this.actual.onSubscribe((Subscription)EmptySubscription.INSTANCE);
      try {
        this.actual.onError(nullPointerException);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { nullPointerException, throwable }));
      return;
    } 
  }
  
  public void onSubscribe(Subscription paramSubscription) {
    if (SubscriptionHelper.validate(this.s, paramSubscription)) {
      this.s = paramSubscription;
      try {
        this.actual.onSubscribe(this);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.done = true;
        try {
          paramSubscription.cancel();
          RxJavaPlugins.onError(throwable);
        } catch (Throwable throwable1) {
          Exceptions.throwIfFatal(throwable1);
          RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
          return;
        } 
      } 
    } 
  }
  
  public void request(long paramLong) {
    try {
      this.s.request(paramLong);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      try {
        this.s.cancel();
        RxJavaPlugins.onError(throwable);
        return;
      } catch (Throwable throwable1) {
        Exceptions.throwIfFatal(throwable1);
        RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }));
        return;
      } 
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\subscribers\SafeSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */