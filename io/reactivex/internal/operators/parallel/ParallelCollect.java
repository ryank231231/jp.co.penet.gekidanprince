package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelCollect<T, C> extends ParallelFlowable<C> {
  final BiConsumer<? super C, ? super T> collector;
  
  final Callable<? extends C> initialCollection;
  
  final ParallelFlowable<? extends T> source;
  
  public ParallelCollect(ParallelFlowable<? extends T> paramParallelFlowable, Callable<? extends C> paramCallable, BiConsumer<? super C, ? super T> paramBiConsumer) {
    this.source = paramParallelFlowable;
    this.initialCollection = paramCallable;
    this.collector = paramBiConsumer;
  }
  
  public int parallelism() {
    return this.source.parallelism();
  }
  
  void reportError(Subscriber<?>[] paramArrayOfSubscriber, Throwable paramThrowable) {
    int i = paramArrayOfSubscriber.length;
    for (byte b = 0; b < i; b++)
      EmptySubscription.error(paramThrowable, paramArrayOfSubscriber[b]); 
  }
  
  public void subscribe(Subscriber<? super C>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    int i = paramArrayOfSubscriber.length;
    Subscriber[] arrayOfSubscriber = new Subscriber[i];
    byte b = 0;
    while (b < i) {
      try {
        Object object = ObjectHelper.requireNonNull(this.initialCollection.call(), "The initialSupplier returned a null value");
        arrayOfSubscriber[b] = (Subscriber)new ParallelCollectSubscriber<T, C>(paramArrayOfSubscriber[b], (C)object, this.collector);
        b++;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        reportError((Subscriber<?>[])paramArrayOfSubscriber, throwable);
        return;
      } 
    } 
    this.source.subscribe(arrayOfSubscriber);
  }
  
  static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
    private static final long serialVersionUID = -4767392946044436228L;
    
    C collection;
    
    final BiConsumer<? super C, ? super T> collector;
    
    boolean done;
    
    ParallelCollectSubscriber(Subscriber<? super C> param1Subscriber, C param1C, BiConsumer<? super C, ? super T> param1BiConsumer) {
      super(param1Subscriber);
      this.collection = param1C;
      this.collector = param1BiConsumer;
    }
    
    public void cancel() {
      super.cancel();
      this.s.cancel();
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      C c = this.collection;
      this.collection = null;
      complete(c);
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      this.done = true;
      this.collection = null;
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        this.collector.accept(this.collection, param1T);
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        cancel();
        onError(throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */