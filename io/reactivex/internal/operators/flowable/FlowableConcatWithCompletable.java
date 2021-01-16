package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
  final CompletableSource other;
  
  public FlowableConcatWithCompletable(Flowable<T> paramFlowable, CompletableSource paramCompletableSource) {
    super(paramFlowable);
    this.other = paramCompletableSource;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new ConcatWithSubscriber<T>(paramSubscriber, this.other));
  }
  
  static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
    private static final long serialVersionUID = -7346385463600070225L;
    
    final Subscriber<? super T> actual;
    
    boolean inCompletable;
    
    CompletableSource other;
    
    Subscription upstream;
    
    ConcatWithSubscriber(Subscriber<? super T> param1Subscriber, CompletableSource param1CompletableSource) {
      this.actual = param1Subscriber;
      this.other = param1CompletableSource;
    }
    
    public void cancel() {
      this.upstream.cancel();
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      if (this.inCompletable) {
        this.actual.onComplete();
      } else {
        this.inCompletable = true;
        this.upstream = (Subscription)SubscriptionHelper.CANCELLED;
        CompletableSource completableSource = this.other;
        this.other = null;
        completableSource.subscribe(this);
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      DisposableHelper.setOnce(this, param1Disposable);
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.upstream, param1Subscription)) {
        this.upstream = param1Subscription;
        this.actual.onSubscribe(this);
      } 
    }
    
    public void request(long param1Long) {
      this.upstream.request(param1Long);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatWithCompletable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */