package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableUsing<T, D> extends Flowable<T> {
  final Consumer<? super D> disposer;
  
  final boolean eager;
  
  final Callable<? extends D> resourceSupplier;
  
  final Function<? super D, ? extends Publisher<? extends T>> sourceSupplier;
  
  public FlowableUsing(Callable<? extends D> paramCallable, Function<? super D, ? extends Publisher<? extends T>> paramFunction, Consumer<? super D> paramConsumer, boolean paramBoolean) {
    this.resourceSupplier = paramCallable;
    this.sourceSupplier = paramFunction;
    this.disposer = paramConsumer;
    this.eager = paramBoolean;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    try {
      D d = this.resourceSupplier.call();
      try {
        Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.sourceSupplier.apply(d), "The sourceSupplier returned a null Publisher");
        publisher.subscribe((Subscriber)new UsingSubscriber<T, D>(paramSubscriber, d, this.disposer, this.eager));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        try {
          this.disposer.accept(d);
          EmptySubscription.error(throwable, paramSubscriber);
          return;
        } catch (Throwable throwable1) {
          Exceptions.throwIfFatal(throwable1);
          EmptySubscription.error((Throwable)new CompositeException(new Throwable[] { throwable, throwable1 }, ), paramSubscriber);
          return;
        } 
      } 
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
  
  static final class UsingSubscriber<T, D> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 5904473792286235046L;
    
    final Subscriber<? super T> actual;
    
    final Consumer<? super D> disposer;
    
    final boolean eager;
    
    final D resource;
    
    Subscription s;
    
    UsingSubscriber(Subscriber<? super T> param1Subscriber, D param1D, Consumer<? super D> param1Consumer, boolean param1Boolean) {
      this.actual = param1Subscriber;
      this.resource = param1D;
      this.disposer = param1Consumer;
      this.eager = param1Boolean;
    }
    
    public void cancel() {
      disposeAfter();
      this.s.cancel();
    }
    
    void disposeAfter() {
      if (compareAndSet(false, true))
        try {
          this.disposer.accept(this.resource);
        } catch (Throwable throwable) {
          Exceptions.throwIfFatal(throwable);
          RxJavaPlugins.onError(throwable);
        }  
    }
    
    public void onComplete() {
      if (this.eager) {
        if (compareAndSet(false, true))
          try {
            this.disposer.accept(this.resource);
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.actual.onError(throwable);
            return;
          }  
        this.s.cancel();
        this.actual.onComplete();
      } else {
        this.actual.onComplete();
        this.s.cancel();
        disposeAfter();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.eager) {
        Object object = null;
        throwable = (Throwable)object;
        if (compareAndSet(false, true))
          try {
            this.disposer.accept(this.resource);
            throwable = (Throwable)object;
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
          }  
        this.s.cancel();
        if (throwable != null) {
          this.actual.onError((Throwable)new CompositeException(new Throwable[] { param1Throwable, throwable }));
        } else {
          this.actual.onError(param1Throwable);
        } 
      } else {
        this.actual.onError(param1Throwable);
        this.s.cancel();
        disposeAfter();
      } 
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */