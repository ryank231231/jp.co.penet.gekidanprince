package io.reactivex.disposables;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

public final class Disposables {
  private Disposables() {
    throw new IllegalStateException("No instances!");
  }
  
  @NonNull
  public static Disposable disposed() {
    return (Disposable)EmptyDisposable.INSTANCE;
  }
  
  @NonNull
  public static Disposable empty() {
    return fromRunnable(Functions.EMPTY_RUNNABLE);
  }
  
  @NonNull
  public static Disposable fromAction(@NonNull Action paramAction) {
    ObjectHelper.requireNonNull(paramAction, "run is null");
    return new ActionDisposable(paramAction);
  }
  
  @NonNull
  public static Disposable fromFuture(@NonNull Future<?> paramFuture) {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    return fromFuture(paramFuture, true);
  }
  
  @NonNull
  public static Disposable fromFuture(@NonNull Future<?> paramFuture, boolean paramBoolean) {
    ObjectHelper.requireNonNull(paramFuture, "future is null");
    return new FutureDisposable(paramFuture, paramBoolean);
  }
  
  @NonNull
  public static Disposable fromRunnable(@NonNull Runnable paramRunnable) {
    ObjectHelper.requireNonNull(paramRunnable, "run is null");
    return new RunnableDisposable(paramRunnable);
  }
  
  @NonNull
  public static Disposable fromSubscription(@NonNull Subscription paramSubscription) {
    ObjectHelper.requireNonNull(paramSubscription, "subscription is null");
    return new SubscriptionDisposable(paramSubscription);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\disposables\Disposables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */