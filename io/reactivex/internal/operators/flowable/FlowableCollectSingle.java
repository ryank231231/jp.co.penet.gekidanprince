package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {
  final BiConsumer<? super U, ? super T> collector;
  
  final Callable<? extends U> initialSupplier;
  
  final Flowable<T> source;
  
  public FlowableCollectSingle(Flowable<T> paramFlowable, Callable<? extends U> paramCallable, BiConsumer<? super U, ? super T> paramBiConsumer) {
    this.source = paramFlowable;
    this.initialSupplier = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  public Flowable<U> fuseToFlowable() {
    return RxJavaPlugins.onAssembly(new FlowableCollect<T, U>(this.source, this.initialSupplier, this.collector));
  }
  
  protected void subscribeActual(SingleObserver<? super U> paramSingleObserver) {
    try {
      Object object = ObjectHelper.requireNonNull(this.initialSupplier.call(), "The initialSupplier returned a null value");
      this.source.subscribe(new CollectSubscriber<T, U>(paramSingleObserver, (U)object, this.collector));
      return;
    } catch (Throwable throwable) {
      EmptyDisposable.error(throwable, paramSingleObserver);
      return;
    } 
  }
  
  static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {
    final SingleObserver<? super U> actual;
    
    final BiConsumer<? super U, ? super T> collector;
    
    boolean done;
    
    Subscription s;
    
    final U u;
    
    CollectSubscriber(SingleObserver<? super U> param1SingleObserver, U param1U, BiConsumer<? super U, ? super T> param1BiConsumer) {
      this.actual = param1SingleObserver;
      this.collector = param1BiConsumer;
      this.u = param1U;
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
      if (this.done)
        return; 
      this.done = true;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onSuccess(this.u);
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.s = (Subscription)SubscriptionHelper.CANCELLED;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        this.collector.accept(this.u, param1T);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.cancel();
        onError(throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCollectSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */