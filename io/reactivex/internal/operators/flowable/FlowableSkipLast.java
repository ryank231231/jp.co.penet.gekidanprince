package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {
  final int skip;
  
  public FlowableSkipLast(Flowable<T> paramFlowable, int paramInt) {
    super(paramFlowable);
    this.skip = paramInt;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new SkipLastSubscriber<T>(paramSubscriber, this.skip));
  }
  
  static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -3807491841935125653L;
    
    final Subscriber<? super T> actual;
    
    Subscription s;
    
    final int skip;
    
    SkipLastSubscriber(Subscriber<? super T> param1Subscriber, int param1Int) {
      super(param1Int);
      this.actual = param1Subscriber;
      this.skip = param1Int;
    }
    
    public void cancel() {
      this.s.cancel();
    }
    
    public void onComplete() {
      this.actual.onComplete();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onNext(T param1T) {
      if (this.skip == size()) {
        this.actual.onNext(poll());
      } else {
        this.s.request(1L);
      } 
      offer(param1T);
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


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableSkipLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */