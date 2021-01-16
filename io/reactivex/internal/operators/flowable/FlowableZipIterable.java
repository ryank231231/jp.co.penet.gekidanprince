package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {
  final Iterable<U> other;
  
  final BiFunction<? super T, ? super U, ? extends V> zipper;
  
  public FlowableZipIterable(Flowable<T> paramFlowable, Iterable<U> paramIterable, BiFunction<? super T, ? super U, ? extends V> paramBiFunction) {
    super(paramFlowable);
    this.other = paramIterable;
    this.zipper = paramBiFunction;
  }
  
  public void subscribeActual(Subscriber<? super V> paramSubscriber) {
    try {
      Iterator<U> iterator = (Iterator)ObjectHelper.requireNonNull(this.other.iterator(), "The iterator returned by other is null");
      try {
        boolean bool = iterator.hasNext();
        if (!bool) {
          EmptySubscription.complete(paramSubscriber);
          return;
        } 
        this.source.subscribe(new ZipIterableSubscriber<T, U, V>(paramSubscriber, iterator, this.zipper));
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        EmptySubscription.error(throwable, paramSubscriber);
        return;
      } 
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      EmptySubscription.error(throwable, paramSubscriber);
      return;
    } 
  }
  
  static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super V> actual;
    
    boolean done;
    
    final Iterator<U> iterator;
    
    Subscription s;
    
    final BiFunction<? super T, ? super U, ? extends V> zipper;
    
    ZipIterableSubscriber(Subscriber<? super V> param1Subscriber, Iterator<U> param1Iterator, BiFunction<? super T, ? super U, ? extends V> param1BiFunction) {
      this.actual = param1Subscriber;
      this.iterator = param1Iterator;
      this.zipper = param1BiFunction;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    void error(Throwable param1Throwable) {
      Exceptions.throwIfFatal(param1Throwable);
      this.done = true;
      this.s.cancel();
      this.actual.onError(param1Throwable);
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
        Object object = ObjectHelper.requireNonNull(this.iterator.next(), "The iterator returned a null value");
        try {
          param1T = (T)ObjectHelper.requireNonNull(this.zipper.apply(param1T, object), "The zipper function returned a null value");
          this.actual.onNext(param1T);
          try {
            boolean bool = this.iterator.hasNext();
            if (!bool) {
              this.done = true;
              this.s.cancel();
              this.actual.onComplete();
            } 
            return;
          } catch (Throwable throwable) {
            error(throwable);
            return;
          } 
        } catch (Throwable throwable) {
          error(throwable);
          return;
        } 
      } catch (Throwable throwable) {
        error(throwable);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableZipIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */