package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

public final class ObservableBlockingSubscribe {
  private ObservableBlockingSubscribe() {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> void subscribe(ObservableSource<? extends T> paramObservableSource) {
    BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
    LambdaObserver lambdaObserver = new LambdaObserver(Functions.emptyConsumer(), (Consumer)blockingIgnoringReceiver, (Action)blockingIgnoringReceiver, Functions.emptyConsumer());
    paramObservableSource.subscribe((Observer)lambdaObserver);
    BlockingHelper.awaitForComplete((CountDownLatch)blockingIgnoringReceiver, (Disposable)lambdaObserver);
    Throwable throwable = blockingIgnoringReceiver.error;
    if (throwable == null)
      return; 
    throw ExceptionHelper.wrapOrThrow(throwable);
  }
  
  public static <T> void subscribe(ObservableSource<? extends T> paramObservableSource, Observer<? super T> paramObserver) {
    LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue();
    BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
    paramObserver.onSubscribe((Disposable)blockingObserver);
    paramObservableSource.subscribe((Observer)blockingObserver);
    while (!blockingObserver.isDisposed()) {
      Object object1 = linkedBlockingQueue.poll();
      Object object2 = object1;
      if (object1 == null)
        try {
          object2 = linkedBlockingQueue.take();
        } catch (InterruptedException interruptedException) {
          blockingObserver.dispose();
          paramObserver.onError(interruptedException);
          return;
        }  
      if (blockingObserver.isDisposed() || interruptedException == BlockingObserver.TERMINATED || NotificationLite.acceptFull(object2, paramObserver))
        break; 
    } 
  }
  
  public static <T> void subscribe(ObservableSource<? extends T> paramObservableSource, Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction) {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    ObjectHelper.requireNonNull(paramConsumer1, "onError is null");
    ObjectHelper.requireNonNull(paramAction, "onComplete is null");
    subscribe(paramObservableSource, (Observer<? super T>)new LambdaObserver(paramConsumer, paramConsumer1, paramAction, Functions.emptyConsumer()));
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableBlockingSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */