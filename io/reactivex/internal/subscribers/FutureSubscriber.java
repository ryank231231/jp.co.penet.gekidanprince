package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
  Throwable error;
  
  final AtomicReference<Subscription> s = new AtomicReference<Subscription>();
  
  T value;
  
  public FutureSubscriber() {
    super(1);
  }
  
  public void cancel() {}
  
  public boolean cancel(boolean paramBoolean) {
    while (true) {
      Subscription subscription = this.s.get();
      if (subscription == this || subscription == SubscriptionHelper.CANCELLED)
        break; 
      if (this.s.compareAndSet(subscription, SubscriptionHelper.CANCELLED)) {
        if (subscription != null)
          subscription.cancel(); 
        countDown();
        return true;
      } 
    } 
    return false;
  }
  
  public T get() throws InterruptedException, ExecutionException {
    if (getCount() != 0L) {
      BlockingHelper.verifyNonBlocking();
      await();
    } 
    if (!isCancelled()) {
      Throwable throwable = this.error;
      if (throwable == null)
        return this.value; 
      throw new ExecutionException(throwable);
    } 
    throw new CancellationException();
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException, ExecutionException, TimeoutException {
    if (getCount() != 0L) {
      BlockingHelper.verifyNonBlocking();
      if (!await(paramLong, paramTimeUnit))
        throw new TimeoutException(); 
    } 
    if (!isCancelled()) {
      Throwable throwable = this.error;
      if (throwable == null)
        return this.value; 
      throw new ExecutionException(throwable);
    } 
    throw new CancellationException();
  }
  
  public boolean isCancelled() {
    return SubscriptionHelper.isCancelled(this.s.get());
  }
  
  public boolean isDone() {
    boolean bool;
    if (getCount() == 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onComplete() {
    if (this.value == null) {
      onError(new NoSuchElementException("The source is empty"));
      return;
    } 
    while (true) {
      Subscription subscription = this.s.get();
      if (subscription == this || subscription == SubscriptionHelper.CANCELLED)
        break; 
      if (this.s.compareAndSet(subscription, this)) {
        countDown();
        return;
      } 
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    while (true) {
      Subscription subscription = this.s.get();
      if (subscription == this || subscription == SubscriptionHelper.CANCELLED)
        break; 
      this.error = paramThrowable;
      if (this.s.compareAndSet(subscription, this)) {
        countDown();
        return;
      } 
    } 
    RxJavaPlugins.onError(paramThrowable);
  }
  
  public void onNext(T paramT) {
    if (this.value != null) {
      ((Subscription)this.s.get()).cancel();
      onError(new IndexOutOfBoundsException("More than one element received"));
      return;
    } 
    this.value = paramT;
  }
  
  public void onSubscribe(Subscription paramSubscription) {
    SubscriptionHelper.setOnce(this.s, paramSubscription, Long.MAX_VALUE);
  }
  
  public void request(long paramLong) {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\FutureSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */