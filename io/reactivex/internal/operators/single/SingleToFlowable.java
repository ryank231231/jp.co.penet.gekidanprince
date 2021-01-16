package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SingleToFlowable<T> extends Flowable<T> {
  final SingleSource<? extends T> source;
  
  public SingleToFlowable(SingleSource<? extends T> paramSingleSource) {
    this.source = paramSingleSource;
  }
  
  public void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.source.subscribe(new SingleToFlowableObserver<T>(paramSubscriber));
  }
  
  static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
    private static final long serialVersionUID = 187782011903685568L;
    
    Disposable d;
    
    SingleToFlowableObserver(Subscriber<? super T> param1Subscriber) {
      super(param1Subscriber);
    }
    
    public void cancel() {
      super.cancel();
      this.d.dispose();
    }
    
    public void onError(Throwable param1Throwable) {
      this.actual.onError(param1Throwable);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.d, param1Disposable)) {
        this.d = param1Disposable;
        this.actual.onSubscribe((Subscription)this);
      } 
    }
    
    public void onSuccess(T param1T) {
      complete(param1T);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\single\SingleToFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */