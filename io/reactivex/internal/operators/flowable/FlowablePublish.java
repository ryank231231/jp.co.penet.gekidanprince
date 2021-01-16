package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {
  static final long CANCELLED = -9223372036854775808L;
  
  final int bufferSize;
  
  final AtomicReference<PublishSubscriber<T>> current;
  
  final Publisher<T> onSubscribe;
  
  final Flowable<T> source;
  
  private FlowablePublish(Publisher<T> paramPublisher, Flowable<T> paramFlowable, AtomicReference<PublishSubscriber<T>> paramAtomicReference, int paramInt) {
    this.onSubscribe = paramPublisher;
    this.source = paramFlowable;
    this.current = paramAtomicReference;
    this.bufferSize = paramInt;
  }
  
  public static <T> ConnectableFlowable<T> create(Flowable<T> paramFlowable, int paramInt) {
    AtomicReference<PublishSubscriber<T>> atomicReference = new AtomicReference();
    return RxJavaPlugins.onAssembly(new FlowablePublish<T>(new FlowablePublisher<T>(atomicReference, paramInt), paramFlowable, atomicReference, paramInt));
  }
  
  public void connect(Consumer<? super Disposable> paramConsumer) {
    // Byte code:
    //   0: aload_0
    //   1: getfield current : Ljava/util/concurrent/atomic/AtomicReference;
    //   4: invokevirtual get : ()Ljava/lang/Object;
    //   7: checkcast io/reactivex/internal/operators/flowable/FlowablePublish$PublishSubscriber
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull -> 24
    //   15: aload_2
    //   16: astore_3
    //   17: aload_2
    //   18: invokevirtual isDisposed : ()Z
    //   21: ifeq -> 55
    //   24: new io/reactivex/internal/operators/flowable/FlowablePublish$PublishSubscriber
    //   27: dup
    //   28: aload_0
    //   29: getfield current : Ljava/util/concurrent/atomic/AtomicReference;
    //   32: aload_0
    //   33: getfield bufferSize : I
    //   36: invokespecial <init> : (Ljava/util/concurrent/atomic/AtomicReference;I)V
    //   39: astore_3
    //   40: aload_0
    //   41: getfield current : Ljava/util/concurrent/atomic/AtomicReference;
    //   44: aload_2
    //   45: aload_3
    //   46: invokevirtual compareAndSet : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   49: ifne -> 55
    //   52: goto -> 0
    //   55: aload_3
    //   56: getfield shouldConnect : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   59: invokevirtual get : ()Z
    //   62: istore #4
    //   64: iconst_1
    //   65: istore #5
    //   67: iload #4
    //   69: ifne -> 87
    //   72: aload_3
    //   73: getfield shouldConnect : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   76: iconst_0
    //   77: iconst_1
    //   78: invokevirtual compareAndSet : (ZZ)Z
    //   81: ifeq -> 87
    //   84: goto -> 90
    //   87: iconst_0
    //   88: istore #5
    //   90: aload_1
    //   91: aload_3
    //   92: invokeinterface accept : (Ljava/lang/Object;)V
    //   97: iload #5
    //   99: ifeq -> 110
    //   102: aload_0
    //   103: getfield source : Lio/reactivex/Flowable;
    //   106: aload_3
    //   107: invokevirtual subscribe : (Lio/reactivex/FlowableSubscriber;)V
    //   110: return
    //   111: astore_1
    //   112: aload_1
    //   113: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
    //   116: aload_1
    //   117: invokestatic wrapOrThrow : (Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   120: athrow
    // Exception table:
    //   from	to	target	type
    //   90	97	111	java/lang/Throwable
  }
  
  public Publisher<T> source() {
    return (Publisher<T>)this.source;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    this.onSubscribe.subscribe(paramSubscriber);
  }
  
  static final class FlowablePublisher<T> implements Publisher<T> {
    private final int bufferSize;
    
    private final AtomicReference<FlowablePublish.PublishSubscriber<T>> curr;
    
    FlowablePublisher(AtomicReference<FlowablePublish.PublishSubscriber<T>> param1AtomicReference, int param1Int) {
      this.curr = param1AtomicReference;
      this.bufferSize = param1Int;
    }
    
    public void subscribe(Subscriber<? super T> param1Subscriber) {
      FlowablePublish.InnerSubscriber<T> innerSubscriber = new FlowablePublish.InnerSubscriber<T>(param1Subscriber);
      param1Subscriber.onSubscribe(innerSubscriber);
      while (true) {
        while (true) {
          FlowablePublish.PublishSubscriber publishSubscriber = this.curr.get();
          break;
        } 
        if (param1Subscriber.add(innerSubscriber)) {
          if (innerSubscriber.get() == Long.MIN_VALUE) {
            param1Subscriber.remove(innerSubscriber);
          } else {
            innerSubscriber.parent = (FlowablePublish.PublishSubscriber)param1Subscriber;
          } 
          param1Subscriber.dispatch();
          return;
        } 
      } 
    }
  }
  
  static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
    private static final long serialVersionUID = -4453897557930727610L;
    
    final Subscriber<? super T> child;
    
    long emitted;
    
    volatile FlowablePublish.PublishSubscriber<T> parent;
    
    InnerSubscriber(Subscriber<? super T> param1Subscriber) {
      this.child = param1Subscriber;
    }
    
    public void cancel() {
      if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
        FlowablePublish.PublishSubscriber<T> publishSubscriber = this.parent;
        if (publishSubscriber != null) {
          publishSubscriber.remove(this);
          publishSubscriber.dispatch();
        } 
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.addCancel(this, param1Long);
        FlowablePublish.PublishSubscriber<T> publishSubscriber = this.parent;
        if (publishSubscriber != null)
          publishSubscriber.dispatch(); 
      } 
    }
  }
  
  static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
    static final FlowablePublish.InnerSubscriber[] EMPTY = new FlowablePublish.InnerSubscriber[0];
    
    static final FlowablePublish.InnerSubscriber[] TERMINATED = new FlowablePublish.InnerSubscriber[0];
    
    private static final long serialVersionUID = -202316842419149694L;
    
    final int bufferSize;
    
    final AtomicReference<PublishSubscriber<T>> current;
    
    volatile SimpleQueue<T> queue;
    
    final AtomicReference<Subscription> s = new AtomicReference<Subscription>();
    
    final AtomicBoolean shouldConnect;
    
    int sourceMode;
    
    final AtomicReference<FlowablePublish.InnerSubscriber<T>[]> subscribers = new AtomicReference(EMPTY);
    
    volatile Object terminalEvent;
    
    PublishSubscriber(AtomicReference<PublishSubscriber<T>> param1AtomicReference, int param1Int) {
      this.current = param1AtomicReference;
      this.shouldConnect = new AtomicBoolean();
      this.bufferSize = param1Int;
    }
    
    boolean add(FlowablePublish.InnerSubscriber<T> param1InnerSubscriber) {
      while (true) {
        FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber1 = (FlowablePublish.InnerSubscriber[])this.subscribers.get();
        if (arrayOfInnerSubscriber1 == TERMINATED)
          return false; 
        int i = arrayOfInnerSubscriber1.length;
        FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber2 = new FlowablePublish.InnerSubscriber[i + 1];
        System.arraycopy(arrayOfInnerSubscriber1, 0, arrayOfInnerSubscriber2, 0, i);
        arrayOfInnerSubscriber2[i] = param1InnerSubscriber;
        if (this.subscribers.compareAndSet(arrayOfInnerSubscriber1, arrayOfInnerSubscriber2))
          return true; 
      } 
    }
    
    boolean checkTerminated(Object param1Object, boolean param1Boolean) {
      int i = 0;
      int j = 0;
      if (param1Object != null)
        if (NotificationLite.isComplete(param1Object)) {
          if (param1Boolean) {
            this.current.compareAndSet(this, null);
            param1Object = this.subscribers.getAndSet(TERMINATED);
            i = param1Object.length;
            while (j < i) {
              ((FlowablePublish.InnerSubscriber)param1Object[j]).child.onComplete();
              j++;
            } 
            return true;
          } 
        } else {
          Throwable throwable = NotificationLite.getError(param1Object);
          this.current.compareAndSet(this, null);
          param1Object = this.subscribers.getAndSet(TERMINATED);
          if (param1Object.length != 0) {
            int k = param1Object.length;
            for (j = i; j < k; j++)
              ((FlowablePublish.InnerSubscriber)param1Object[j]).child.onError(throwable); 
          } else {
            RxJavaPlugins.onError(throwable);
          } 
          return true;
        }  
      return false;
    }
    
    void dispatch() {
      if (getAndIncrement() != 0)
        return; 
      AtomicReference<FlowablePublish.InnerSubscriber<T>[]> atomicReference = this.subscribers;
      FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber = (FlowablePublish.InnerSubscriber[])atomicReference.get();
      int i = 1;
      while (true) {
        boolean bool;
        Object object = this.terminalEvent;
        SimpleQueue<T> simpleQueue = this.queue;
        if (simpleQueue == null || simpleQueue.isEmpty()) {
          bool = true;
        } else {
          bool = false;
        } 
        if (checkTerminated(object, bool))
          return; 
        if (!bool) {
          Object object1;
          long l2;
          int j = arrayOfInnerSubscriber.length;
          int k = arrayOfInnerSubscriber.length;
          byte b1 = 0;
          byte b2 = 0;
          long l1 = Long.MAX_VALUE;
          while (b1 < k) {
            object = arrayOfInnerSubscriber[b1];
            l2 = object.get();
            if (l2 != Long.MIN_VALUE) {
              l1 = Math.min(l1, l2 - ((FlowablePublish.InnerSubscriber)object).emitted);
            } else {
              b2++;
            } 
            b1++;
          } 
          if (j == b2) {
            Object object2 = this.terminalEvent;
            try {
              object = simpleQueue.poll();
              object1 = object2;
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              ((Subscription)this.s.get()).cancel();
              object1 = NotificationLite.error(throwable);
              this.terminalEvent = object1;
              object = null;
            } 
            if (object == null) {
              bool = true;
            } else {
              bool = false;
            } 
            if (checkTerminated(object1, bool))
              return; 
            if (this.sourceMode != 1)
              ((Subscription)this.s.get()).request(1L); 
            continue;
          } 
          b1 = 0;
          while (true) {
            l2 = b1;
            if (l2 < l1) {
              Object object4 = this.terminalEvent;
              try {
                object = object1.poll();
              } catch (Throwable throwable) {
                Exceptions.throwIfFatal(throwable);
                ((Subscription)this.s.get()).cancel();
                object4 = NotificationLite.error(throwable);
                this.terminalEvent = object4;
                throwable = null;
              } 
              if (throwable == null) {
                bool = true;
              } else {
                bool = false;
              } 
              if (checkTerminated(object4, bool))
                return; 
              if (bool)
                break; 
              Object object3 = NotificationLite.getValue(throwable);
              j = arrayOfInnerSubscriber.length;
              k = 0;
              b2 = 0;
              while (k < j) {
                object4 = arrayOfInnerSubscriber[k];
                l2 = object4.get();
                if (l2 != Long.MIN_VALUE) {
                  if (l2 != Long.MAX_VALUE)
                    ((FlowablePublish.InnerSubscriber)object4).emitted++; 
                  ((FlowablePublish.InnerSubscriber)object4).child.onNext(object3);
                } else {
                  b2 = 1;
                } 
                k++;
              } 
              b1++;
              object3 = atomicReference.get();
              if (b2 == 0) {
                if (object3 != arrayOfInnerSubscriber)
                  continue; 
                continue;
              } 
              Object object2 = object3;
              continue;
            } 
            break;
          } 
          if (b1 > 0 && this.sourceMode != 1)
            ((Subscription)this.s.get()).request(l2); 
          if (l1 != 0L && !bool)
            continue; 
        } 
        i = addAndGet(-i);
        if (i == 0)
          return; 
        arrayOfInnerSubscriber = (FlowablePublish.InnerSubscriber[])atomicReference.get();
      } 
    }
    
    public void dispose() {
      FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber1 = (FlowablePublish.InnerSubscriber[])this.subscribers.get();
      FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber2 = TERMINATED;
      if (arrayOfInnerSubscriber1 != arrayOfInnerSubscriber2 && (FlowablePublish.InnerSubscriber[])this.subscribers.getAndSet(arrayOfInnerSubscriber2) != TERMINATED) {
        this.current.compareAndSet(this, null);
        SubscriptionHelper.cancel(this.s);
      } 
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (this.subscribers.get() == TERMINATED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      if (this.terminalEvent == null) {
        this.terminalEvent = NotificationLite.complete();
        dispatch();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.terminalEvent == null) {
        this.terminalEvent = NotificationLite.error(param1Throwable);
        dispatch();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.sourceMode == 0 && !this.queue.offer(param1T)) {
        onError((Throwable)new MissingBackpressureException("Prefetch queue is full?!"));
        return;
      } 
      dispatch();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.setOnce(this.s, param1Subscription)) {
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(3);
          if (i == 1) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.terminalEvent = NotificationLite.complete();
            dispatch();
            return;
          } 
          if (i == 2) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueSubscription;
            param1Subscription.request(this.bufferSize);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscArrayQueue(this.bufferSize);
        param1Subscription.request(this.bufferSize);
      } 
    }
    
    void remove(FlowablePublish.InnerSubscriber<T> param1InnerSubscriber) {
      FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber1;
      FlowablePublish.InnerSubscriber[] arrayOfInnerSubscriber2;
      do {
        byte b2;
        arrayOfInnerSubscriber1 = (FlowablePublish.InnerSubscriber[])this.subscribers.get();
        int i = arrayOfInnerSubscriber1.length;
        if (i == 0)
          break; 
        byte b1 = -1;
        byte b = 0;
        while (true) {
          b2 = b1;
          if (b < i) {
            if (arrayOfInnerSubscriber1[b].equals(param1InnerSubscriber)) {
              b2 = b;
              break;
            } 
            b++;
            continue;
          } 
          break;
        } 
        if (b2 < 0)
          return; 
        if (i == 1) {
          arrayOfInnerSubscriber2 = EMPTY;
        } else {
          arrayOfInnerSubscriber2 = new FlowablePublish.InnerSubscriber[i - 1];
          System.arraycopy(arrayOfInnerSubscriber1, 0, arrayOfInnerSubscriber2, 0, b2);
          System.arraycopy(arrayOfInnerSubscriber1, b2 + 1, arrayOfInnerSubscriber2, b2, i - b2 - 1);
        } 
      } while (!this.subscribers.compareAndSet(arrayOfInnerSubscriber1, arrayOfInnerSubscriber2));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowablePublish.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */