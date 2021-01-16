package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
  protected final Subscriber<? super R> actual;
  
  protected boolean done;
  
  protected QueueSubscription<T> qs;
  
  protected Subscription s;
  
  protected int sourceMode;
  
  public BasicFuseableSubscriber(Subscriber<? super R> paramSubscriber) {
    this.actual = paramSubscriber;
  }
  
  protected void afterDownstream() {}
  
  protected boolean beforeDownstream() {
    return true;
  }
  
  public void cancel() {
    this.s.cancel();
  }
  
  public void clear() {
    this.qs.clear();
  }
  
  protected final void fail(Throwable paramThrowable) {
    Exceptions.throwIfFatal(paramThrowable);
    this.s.cancel();
    onError(paramThrowable);
  }
  
  public boolean isEmpty() {
    return this.qs.isEmpty();
  }
  
  public final boolean offer(R paramR) {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public final boolean offer(R paramR1, R paramR2) {
    throw new UnsupportedOperationException("Should not be called!");
  }
  
  public void onComplete() {
    if (this.done)
      return; 
    this.done = true;
    this.actual.onComplete();
  }
  
  public void onError(Throwable paramThrowable) {
    if (this.done) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.done = true;
    this.actual.onError(paramThrowable);
  }
  
  public final void onSubscribe(Subscription paramSubscription) {
    if (SubscriptionHelper.validate(this.s, paramSubscription)) {
      this.s = paramSubscription;
      if (paramSubscription instanceof QueueSubscription)
        this.qs = (QueueSubscription<T>)paramSubscription; 
      if (beforeDownstream()) {
        this.actual.onSubscribe((Subscription)this);
        afterDownstream();
      } 
    } 
  }
  
  public void request(long paramLong) {
    this.s.request(paramLong);
  }
  
  protected final int transitiveBoundaryFusion(int paramInt) {
    QueueSubscription<T> queueSubscription = this.qs;
    if (queueSubscription != null && (paramInt & 0x4) == 0) {
      paramInt = queueSubscription.requestFusion(paramInt);
      if (paramInt != 0)
        this.sourceMode = paramInt; 
      return paramInt;
    } 
    return 0;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\BasicFuseableSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */