package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {
  final Callable<U> collectionSupplier;
  
  final Flowable<T> source;
  
  public FlowableToListSingle(Flowable<T> paramFlowable) {
    this(paramFlowable, ArrayListSupplier.asCallable());
  }
  
  public FlowableToListSingle(Flowable<T> paramFlowable, Callable<U> paramCallable) {
    this.source = paramFlowable;
    this.collectionSupplier = paramCallable;
  }
  
  public Flowable<U> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableToList<T, U>(this.source, this.collectionSupplier));
  }
  
  protected void subscribeActual(SingleObserver<? super U> paramSingleObserver) {
    try {
      Collection collection = (Collection)ObjectHelper.requireNonNull(this.collectionSupplier.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
      this.source.subscribe(new ToListSubscriber<Object, U>(paramSingleObserver, (U)collection));
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
  
  static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super U> actual;
    
    Subscription s;
    
    U value;
    
    ToListSubscriber(SingleObserver<? super U> param1SingleObserver, U param1U) {
      this.actual = param1SingleObserver;
      this.value = param1U;
    }
    
    public void dispose() {
      this.s.cancel();
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (this.s == SubscriptionHelper.CANCELLED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onSuccess(this.value);
    }
    
    public void onError(Throwable param1Throwable) {
      this.value = null;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.value.add(param1T);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableToListSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */