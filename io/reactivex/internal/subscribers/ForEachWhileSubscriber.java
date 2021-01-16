package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
  private static final long serialVersionUID = -4403180040475402120L;
  
  boolean done;
  
  final Action onComplete;
  
  final Consumer<? super Throwable> onError;
  
  final Predicate<? super T> onNext;
  
  public ForEachWhileSubscriber(Predicate<? super T> paramPredicate, Consumer<? super Throwable> paramConsumer, Action paramAction) {
    this.onNext = paramPredicate;
    this.onError = paramConsumer;
    this.onComplete = paramAction;
  }
  
  public void dispose() {
    SubscriptionHelper.cancel(this);
  }
  
  public boolean isDisposed() {
    return SubscriptionHelper.isCancelled(get());
  }
  
  public void onComplete() {
    if (this.done)
      return; 
    this.done = true;
    try {
      this.onComplete.run();
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError(throwable);
    } 
  }
  
  public void onError(Throwable paramThrowable) {
    if (this.done) {
      RxJavaPlugins.onError(paramThrowable);
      return;
    } 
    this.done = true;
    try {
      this.onError.accept(paramThrowable);
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[] { paramThrowable, throwable }));
    } 
  }
  
  public void onNext(T paramT) {
    if (this.done)
      return; 
    try {
      boolean bool = this.onNext.test(paramT);
      if (!bool) {
        dispose();
        onComplete();
      } 
      return;
    } catch (Throwable throwable) {
      Exceptions.throwIfFatal(throwable);
      dispose();
      onError(throwable);
      return;
    } 
  }
  
  public void onSubscribe(Subscription paramSubscription) {
    SubscriptionHelper.setOnce(this, paramSubscription, Long.MAX_VALUE);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\subscribers\ForEachWhileSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */