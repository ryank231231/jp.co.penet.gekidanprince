package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import org.reactivestreams.Subscription;

final class SubscriptionDisposable extends ReferenceDisposable<Subscription> {
  private static final long serialVersionUID = -707001650852963139L;
  
  SubscriptionDisposable(Subscription paramSubscription) {
    super(paramSubscription);
  }
  
  protected void onDisposed(@NonNull Subscription paramSubscription) {
    paramSubscription.cancel();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\disposables\SubscriptionDisposable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */