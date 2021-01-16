package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.LinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> {
  final AtomicBoolean once;
  
  final CacheState<T> state;
  
  public FlowableCache(Flowable<T> paramFlowable, int paramInt) {
    super(paramFlowable);
    this.state = new CacheState<T>(paramFlowable, paramInt);
    this.once = new AtomicBoolean();
  }
  
  int cachedEventCount() {
    return this.state.size();
  }
  
  boolean hasSubscribers() {
    boolean bool;
    if (((ReplaySubscription[])this.state.subscribers.get()).length != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  boolean isConnected() {
    return this.state.isConnected;
  }
  
  protected void subscribeActual(Subscriber<? super T> paramSubscriber) {
    boolean bool;
    ReplaySubscription<T> replaySubscription = new ReplaySubscription<T>(paramSubscriber, this.state);
    paramSubscriber.onSubscribe(replaySubscription);
    if (this.state.addChild(replaySubscription) && replaySubscription.requested.get() == Long.MIN_VALUE) {
      this.state.removeChild(replaySubscription);
      bool = false;
    } else {
      bool = true;
    } 
    if (!this.once.get() && this.once.compareAndSet(false, true))
      this.state.connect(); 
    if (bool)
      replaySubscription.replay(); 
  }
  
  static final class CacheState<T> extends LinkedArrayList implements FlowableSubscriber<T> {
    static final FlowableCache.ReplaySubscription[] EMPTY = new FlowableCache.ReplaySubscription[0];
    
    static final FlowableCache.ReplaySubscription[] TERMINATED = new FlowableCache.ReplaySubscription[0];
    
    final AtomicReference<Subscription> connection = new AtomicReference<Subscription>();
    
    volatile boolean isConnected;
    
    final Flowable<T> source;
    
    boolean sourceDone;
    
    final AtomicReference<FlowableCache.ReplaySubscription<T>[]> subscribers;
    
    CacheState(Flowable<T> param1Flowable, int param1Int) {
      super(param1Int);
      this.source = param1Flowable;
      this.subscribers = new AtomicReference(EMPTY);
    }
    
    public boolean addChild(FlowableCache.ReplaySubscription<T> param1ReplaySubscription) {
      while (true) {
        FlowableCache.ReplaySubscription[] arrayOfReplaySubscription1 = (FlowableCache.ReplaySubscription[])this.subscribers.get();
        if (arrayOfReplaySubscription1 == TERMINATED)
          return false; 
        int i = arrayOfReplaySubscription1.length;
        FlowableCache.ReplaySubscription[] arrayOfReplaySubscription2 = new FlowableCache.ReplaySubscription[i + 1];
        System.arraycopy(arrayOfReplaySubscription1, 0, arrayOfReplaySubscription2, 0, i);
        arrayOfReplaySubscription2[i] = param1ReplaySubscription;
        if (this.subscribers.compareAndSet(arrayOfReplaySubscription1, arrayOfReplaySubscription2))
          return true; 
      } 
    }
    
    public void connect() {
      this.source.subscribe(this);
      this.isConnected = true;
    }
    
    public void onComplete() {
      if (!this.sourceDone) {
        this.sourceDone = true;
        add(NotificationLite.complete());
        SubscriptionHelper.cancel(this.connection);
        FlowableCache.ReplaySubscription[] arrayOfReplaySubscription = (FlowableCache.ReplaySubscription[])this.subscribers.getAndSet(TERMINATED);
        int i = arrayOfReplaySubscription.length;
        for (byte b = 0; b < i; b++)
          arrayOfReplaySubscription[b].replay(); 
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      FlowableCache.ReplaySubscription[] arrayOfReplaySubscription;
      if (!this.sourceDone) {
        this.sourceDone = true;
        add(NotificationLite.error(param1Throwable));
        SubscriptionHelper.cancel(this.connection);
        arrayOfReplaySubscription = (FlowableCache.ReplaySubscription[])this.subscribers.getAndSet(TERMINATED);
        int i = arrayOfReplaySubscription.length;
        for (byte b = 0; b < i; b++)
          arrayOfReplaySubscription[b].replay(); 
      } else {
        RxJavaPlugins.onError((Throwable)arrayOfReplaySubscription);
      } 
    }
    
    public void onNext(T param1T) {
      if (!this.sourceDone) {
        add(NotificationLite.next(param1T));
        FlowableCache.ReplaySubscription[] arrayOfReplaySubscription = (FlowableCache.ReplaySubscription[])this.subscribers.get();
        int i = arrayOfReplaySubscription.length;
        for (byte b = 0; b < i; b++)
          arrayOfReplaySubscription[b].replay(); 
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      SubscriptionHelper.setOnce(this.connection, param1Subscription, Long.MAX_VALUE);
    }
    
    public void removeChild(FlowableCache.ReplaySubscription<T> param1ReplaySubscription) {
      FlowableCache.ReplaySubscription[] arrayOfReplaySubscription1;
      FlowableCache.ReplaySubscription[] arrayOfReplaySubscription2;
      do {
        byte b2;
        arrayOfReplaySubscription1 = (FlowableCache.ReplaySubscription[])this.subscribers.get();
        int i = arrayOfReplaySubscription1.length;
        if (i == 0)
          return; 
        byte b1 = -1;
        byte b = 0;
        while (true) {
          b2 = b1;
          if (b < i) {
            if (arrayOfReplaySubscription1[b].equals(param1ReplaySubscription)) {
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
          arrayOfReplaySubscription2 = EMPTY;
        } else {
          arrayOfReplaySubscription2 = new FlowableCache.ReplaySubscription[i - 1];
          System.arraycopy(arrayOfReplaySubscription1, 0, arrayOfReplaySubscription2, 0, b2);
          System.arraycopy(arrayOfReplaySubscription1, b2 + 1, arrayOfReplaySubscription2, b2, i - b2 - 1);
        } 
      } while (!this.subscribers.compareAndSet(arrayOfReplaySubscription1, arrayOfReplaySubscription2));
    }
  }
  
  static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
    private static final long CANCELLED = -9223372036854775808L;
    
    private static final long serialVersionUID = -2557562030197141021L;
    
    final Subscriber<? super T> child;
    
    Object[] currentBuffer;
    
    int currentIndexInBuffer;
    
    long emitted;
    
    int index;
    
    final AtomicLong requested;
    
    final FlowableCache.CacheState<T> state;
    
    ReplaySubscription(Subscriber<? super T> param1Subscriber, FlowableCache.CacheState<T> param1CacheState) {
      this.child = param1Subscriber;
      this.state = param1CacheState;
      this.requested = new AtomicLong();
    }
    
    public void cancel() {
      if (this.requested.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE)
        this.state.removeChild(this); 
    }
    
    public void replay() {
      if (getAndIncrement() != 0)
        return; 
      Subscriber<? super T> subscriber = this.child;
      AtomicLong atomicLong = this.requested;
      long l = this.emitted;
      int i = 1;
      while (true) {
        long l1 = atomicLong.get();
        if (l1 == Long.MIN_VALUE)
          return; 
        int j = this.state.size();
        long l2 = l;
        if (j != 0) {
          Object[] arrayOfObject1 = this.currentBuffer;
          Object[] arrayOfObject2 = arrayOfObject1;
          if (arrayOfObject1 == null) {
            arrayOfObject2 = this.state.head();
            this.currentBuffer = arrayOfObject2;
          } 
          int k = arrayOfObject2.length - 1;
          int m = this.index;
          int n = this.currentIndexInBuffer;
          while (m < j && l != l1) {
            if (atomicLong.get() == Long.MIN_VALUE)
              return; 
            arrayOfObject1 = arrayOfObject2;
            int i1 = n;
            if (n == k) {
              arrayOfObject1 = (Object[])arrayOfObject2[k];
              i1 = 0;
            } 
            if (NotificationLite.accept(arrayOfObject1[i1], subscriber))
              return; 
            n = i1 + 1;
            m++;
            l++;
            arrayOfObject2 = arrayOfObject1;
          } 
          if (atomicLong.get() == Long.MIN_VALUE)
            return; 
          if (l1 == l) {
            Object object = arrayOfObject2[n];
            if (NotificationLite.isComplete(object)) {
              subscriber.onComplete();
              return;
            } 
            if (NotificationLite.isError(object)) {
              subscriber.onError(NotificationLite.getError(object));
              return;
            } 
          } 
          this.index = m;
          this.currentIndexInBuffer = n;
          this.currentBuffer = arrayOfObject2;
          l2 = l;
        } 
        this.emitted = l2;
        i = addAndGet(-i);
        if (i == 0)
          return; 
        l = l2;
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.addCancel(this.requested, param1Long);
        replay();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */