package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.BlockingIgnoringReceiver;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableBlockingSubscribe {
  private FlowableBlockingSubscribe() {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher) {
    BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
    LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.emptyConsumer(), (Consumer)blockingIgnoringReceiver, (Action)blockingIgnoringReceiver, Functions.REQUEST_MAX);
    paramPublisher.subscribe((Subscriber)lambdaSubscriber);
    BlockingHelper.awaitForComplete((CountDownLatch)blockingIgnoringReceiver, (Disposable)lambdaSubscriber);
    Throwable throwable = blockingIgnoringReceiver.error;
    if (throwable == null)
      return; 
    throw ExceptionHelper.wrapOrThrow(throwable);
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher, Consumer<? super T> paramConsumer, Consumer<? super Throwable> paramConsumer1, Action paramAction) {
    ObjectHelper.requireNonNull(paramConsumer, "onNext is null");
    ObjectHelper.requireNonNull(paramConsumer1, "onError is null");
    ObjectHelper.requireNonNull(paramAction, "onComplete is null");
    subscribe(paramPublisher, (Subscriber<? super T>)new LambdaSubscriber(paramConsumer, paramConsumer1, paramAction, Functions.REQUEST_MAX));
  }
  
  public static <T> void subscribe(Publisher<? extends T> paramPublisher, Subscriber<? super T> paramSubscriber) {
    LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue();
    BlockingSubscriber blockingSubscriber = new BlockingSubscriber(linkedBlockingQueue);
    paramPublisher.subscribe((Subscriber)blockingSubscriber);
    try {
      while (!blockingSubscriber.isCancelled()) {
        Object object1 = linkedBlockingQueue.poll();
        Object object2 = object1;
        if (object1 == null) {
          if (blockingSubscriber.isCancelled())
            break; 
          BlockingHelper.verifyNonBlocking();
          object2 = linkedBlockingQueue.take();
        } 
        if (!blockingSubscriber.isCancelled() && paramPublisher != BlockingSubscriber.TERMINATED) {
          boolean bool = NotificationLite.acceptFull(object2, paramSubscriber);
          if (bool)
            break; 
          continue;
        } 
        break;
      } 
    } catch (InterruptedException interruptedException) {
      blockingSubscriber.cancel();
      paramSubscriber.onError(interruptedException);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableBlockingSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */