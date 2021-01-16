package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {
  final int parallelism;
  
  final int prefetch;
  
  final Publisher<? extends T> source;
  
  public ParallelFromPublisher(Publisher<? extends T> paramPublisher, int paramInt1, int paramInt2) {
    this.source = paramPublisher;
    this.parallelism = paramInt1;
    this.prefetch = paramInt2;
  }
  
  public int parallelism() {
    return this.parallelism;
  }
  
  public void subscribe(Subscriber<? super T>[] paramArrayOfSubscriber) {
    if (!validate((Subscriber[])paramArrayOfSubscriber))
      return; 
    this.source.subscribe((Subscriber)new ParallelDispatcher<T>(paramArrayOfSubscriber, this.prefetch));
  }
  
  static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -4470634016609963609L;
    
    volatile boolean cancelled;
    
    volatile boolean done;
    
    final long[] emissions;
    
    Throwable error;
    
    int index;
    
    final int limit;
    
    final int prefetch;
    
    int produced;
    
    SimpleQueue<T> queue;
    
    final AtomicLongArray requests;
    
    Subscription s;
    
    int sourceMode;
    
    final AtomicInteger subscriberCount = new AtomicInteger();
    
    final Subscriber<? super T>[] subscribers;
    
    ParallelDispatcher(Subscriber<? super T>[] param1ArrayOfSubscriber, int param1Int) {
      this.subscribers = param1ArrayOfSubscriber;
      this.prefetch = param1Int;
      this.limit = param1Int - (param1Int >> 2);
      param1Int = param1ArrayOfSubscriber.length;
      int i = param1Int + param1Int;
      this.requests = new AtomicLongArray(i + 1);
      this.requests.lazySet(i, param1Int);
      this.emissions = new long[param1Int];
    }
    
    void cancel(int param1Int) {
      if (this.requests.decrementAndGet(param1Int) == 0L) {
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0)
          this.queue.clear(); 
      } 
    }
    
    void drain() {
      if (getAndIncrement() != 0)
        return; 
      if (this.sourceMode == 1) {
        drainSync();
      } else {
        drainAsync();
      } 
    }
    
    void drainAsync() {
      // Byte code:
      //   0: aload_0
      //   1: getfield queue : Lio/reactivex/internal/fuseable/SimpleQueue;
      //   4: astore_1
      //   5: aload_0
      //   6: getfield subscribers : [Lorg/reactivestreams/Subscriber;
      //   9: astore_2
      //   10: aload_0
      //   11: getfield requests : Ljava/util/concurrent/atomic/AtomicLongArray;
      //   14: astore_3
      //   15: aload_0
      //   16: getfield emissions : [J
      //   19: astore #4
      //   21: aload #4
      //   23: arraylength
      //   24: istore #5
      //   26: aload_0
      //   27: getfield index : I
      //   30: istore #6
      //   32: aload_0
      //   33: getfield produced : I
      //   36: istore #7
      //   38: iconst_1
      //   39: istore #8
      //   41: iconst_0
      //   42: istore #9
      //   44: iconst_0
      //   45: istore #10
      //   47: iconst_0
      //   48: istore #11
      //   50: iconst_0
      //   51: istore #12
      //   53: iload #7
      //   55: istore #13
      //   57: aload_0
      //   58: getfield cancelled : Z
      //   61: ifeq -> 71
      //   64: aload_1
      //   65: invokeinterface clear : ()V
      //   70: return
      //   71: aload_0
      //   72: getfield done : Z
      //   75: istore #14
      //   77: iload #14
      //   79: ifeq -> 132
      //   82: aload_0
      //   83: getfield error : Ljava/lang/Throwable;
      //   86: astore #15
      //   88: aload #15
      //   90: ifnull -> 132
      //   93: aload_1
      //   94: invokeinterface clear : ()V
      //   99: aload_2
      //   100: arraylength
      //   101: istore #8
      //   103: iload #11
      //   105: istore #7
      //   107: iload #7
      //   109: iload #8
      //   111: if_icmpge -> 131
      //   114: aload_2
      //   115: iload #7
      //   117: aaload
      //   118: aload #15
      //   120: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   125: iinc #7, 1
      //   128: goto -> 107
      //   131: return
      //   132: aload_1
      //   133: invokeinterface isEmpty : ()Z
      //   138: istore #16
      //   140: iload #14
      //   142: ifeq -> 181
      //   145: iload #16
      //   147: ifeq -> 181
      //   150: aload_2
      //   151: arraylength
      //   152: istore #8
      //   154: iload #9
      //   156: istore #7
      //   158: iload #7
      //   160: iload #8
      //   162: if_icmpge -> 180
      //   165: aload_2
      //   166: iload #7
      //   168: aaload
      //   169: invokeinterface onComplete : ()V
      //   174: iinc #7, 1
      //   177: goto -> 158
      //   180: return
      //   181: iload #16
      //   183: ifeq -> 189
      //   186: goto -> 239
      //   189: aload_3
      //   190: iload #6
      //   192: invokevirtual get : (I)J
      //   195: lstore #17
      //   197: aload #4
      //   199: iload #6
      //   201: laload
      //   202: lstore #19
      //   204: lload #17
      //   206: lload #19
      //   208: lcmp
      //   209: ifeq -> 356
      //   212: aload_3
      //   213: iload #5
      //   215: iload #6
      //   217: iadd
      //   218: invokevirtual get : (I)J
      //   221: lconst_0
      //   222: lcmp
      //   223: ifne -> 356
      //   226: aload_1
      //   227: invokeinterface poll : ()Ljava/lang/Object;
      //   232: astore #15
      //   234: aload #15
      //   236: ifnonnull -> 246
      //   239: iload #6
      //   241: istore #7
      //   243: goto -> 406
      //   246: aload_2
      //   247: iload #6
      //   249: aaload
      //   250: aload #15
      //   252: invokeinterface onNext : (Ljava/lang/Object;)V
      //   257: aload #4
      //   259: iload #6
      //   261: lload #19
      //   263: lconst_1
      //   264: ladd
      //   265: lastore
      //   266: iinc #13, 1
      //   269: iload #13
      //   271: istore #7
      //   273: iload #13
      //   275: aload_0
      //   276: getfield limit : I
      //   279: if_icmpne -> 297
      //   282: aload_0
      //   283: getfield s : Lorg/reactivestreams/Subscription;
      //   286: iload #13
      //   288: i2l
      //   289: invokeinterface request : (J)V
      //   294: iconst_0
      //   295: istore #7
      //   297: iconst_0
      //   298: istore #21
      //   300: iload #7
      //   302: istore #22
      //   304: goto -> 366
      //   307: astore #4
      //   309: aload #4
      //   311: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   314: aload_0
      //   315: getfield s : Lorg/reactivestreams/Subscription;
      //   318: invokeinterface cancel : ()V
      //   323: aload_2
      //   324: arraylength
      //   325: istore #8
      //   327: iload #10
      //   329: istore #7
      //   331: iload #7
      //   333: iload #8
      //   335: if_icmpge -> 355
      //   338: aload_2
      //   339: iload #7
      //   341: aaload
      //   342: aload #4
      //   344: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   349: iinc #7, 1
      //   352: goto -> 331
      //   355: return
      //   356: iload #12
      //   358: iconst_1
      //   359: iadd
      //   360: istore #21
      //   362: iload #13
      //   364: istore #22
      //   366: iinc #6, 1
      //   369: iload #6
      //   371: istore #7
      //   373: iload #6
      //   375: iload #5
      //   377: if_icmpne -> 383
      //   380: iconst_0
      //   381: istore #7
      //   383: iload #7
      //   385: istore #6
      //   387: iload #21
      //   389: istore #12
      //   391: iload #22
      //   393: istore #13
      //   395: iload #21
      //   397: iload #5
      //   399: if_icmpne -> 57
      //   402: iload #22
      //   404: istore #13
      //   406: aload_0
      //   407: invokevirtual get : ()I
      //   410: istore #6
      //   412: iload #6
      //   414: iload #8
      //   416: if_icmpne -> 458
      //   419: aload_0
      //   420: iload #7
      //   422: putfield index : I
      //   425: aload_0
      //   426: iload #13
      //   428: putfield produced : I
      //   431: aload_0
      //   432: iload #8
      //   434: ineg
      //   435: invokevirtual addAndGet : (I)I
      //   438: istore #22
      //   440: iload #7
      //   442: istore #6
      //   444: iload #13
      //   446: istore #7
      //   448: iload #22
      //   450: istore #8
      //   452: iload #22
      //   454: ifne -> 41
      //   457: return
      //   458: iload #6
      //   460: istore #8
      //   462: iload #7
      //   464: istore #6
      //   466: iload #13
      //   468: istore #7
      //   470: goto -> 41
      // Exception table:
      //   from	to	target	type
      //   226	234	307	java/lang/Throwable
    }
    
    void drainSync() {
      SimpleQueue<T> simpleQueue = this.queue;
      Subscriber<? super T>[] arrayOfSubscriber = this.subscribers;
      AtomicLongArray atomicLongArray = this.requests;
      long[] arrayOfLong = this.emissions;
      int i = arrayOfLong.length;
      int j = this.index;
      int k;
      for (k = 1;; k = i1) {
        int i1;
        boolean bool1 = false;
        boolean bool2 = false;
        boolean bool3 = false;
        int m = 0;
        int n = j;
        while (true) {
          if (this.cancelled) {
            simpleQueue.clear();
            return;
          } 
          if (simpleQueue.isEmpty()) {
            k = arrayOfSubscriber.length;
            for (j = bool3; j < k; j++)
              arrayOfSubscriber[j].onComplete(); 
            return;
          } 
          long l1 = atomicLongArray.get(n);
          long l2 = arrayOfLong[n];
          if (l1 != l2 && atomicLongArray.get(i + n) == 0L) {
            try {
              Object object = simpleQueue.poll();
              if (object == null) {
                k = arrayOfSubscriber.length;
                for (j = bool1; j < k; j++)
                  arrayOfSubscriber[j].onComplete(); 
                return;
              } 
              arrayOfSubscriber[n].onNext(object);
              arrayOfLong[n] = l2 + 1L;
              i1 = 0;
            } catch (Throwable throwable) {
              Exceptions.throwIfFatal(throwable);
              this.s.cancel();
              k = arrayOfSubscriber.length;
              for (j = bool2; j < k; j++)
                arrayOfSubscriber[j].onError(throwable); 
              return;
            } 
          } else {
            i1 = m + 1;
          } 
          j = ++n;
          if (n == i)
            j = 0; 
          n = j;
          m = i1;
          if (i1 == i) {
            i1 = get();
            if (i1 == k) {
              this.index = j;
              i1 = addAndGet(-k);
              k = i1;
              if (i1 == 0)
                return; 
              continue;
            } 
            break;
          } 
        } 
      } 
    }
    
    public void onComplete() {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      this.error = param1Throwable;
      this.done = true;
      drain();
    }
    
    public void onNext(T param1T) {
      if (this.sourceMode == 0 && !this.queue.offer(param1T)) {
        this.s.cancel();
        onError((Throwable)new MissingBackpressureException("Queue is full?"));
        return;
      } 
      drain();
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        this.s = param1Subscription;
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(7);
          if (i == 1) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueSubscription;
            this.done = true;
            setupSubscribers();
            drain();
            return;
          } 
          if (i == 2) {
            this.sourceMode = i;
            this.queue = (SimpleQueue<T>)queueSubscription;
            setupSubscribers();
            param1Subscription.request(this.prefetch);
            return;
          } 
        } 
        this.queue = (SimpleQueue<T>)new SpscArrayQueue(this.prefetch);
        setupSubscribers();
        param1Subscription.request(this.prefetch);
      } 
    }
    
    void setupSubscribers() {
      Subscriber<? super T>[] arrayOfSubscriber = this.subscribers;
      int i = arrayOfSubscriber.length;
      for (int j = 0; j < i; j = k) {
        if (this.cancelled)
          return; 
        AtomicInteger atomicInteger = this.subscriberCount;
        int k = j + 1;
        atomicInteger.lazySet(k);
        arrayOfSubscriber[j].onSubscribe(new RailSubscription(j, i));
      } 
    }
    
    final class RailSubscription implements Subscription {
      final int j;
      
      final int m;
      
      RailSubscription(int param2Int1, int param2Int2) {
        this.j = param2Int1;
        this.m = param2Int2;
      }
      
      public void cancel() {
        AtomicLongArray atomicLongArray = ParallelFromPublisher.ParallelDispatcher.this.requests;
        int i = this.m;
        if (atomicLongArray.compareAndSet(this.j + i, 0L, 1L)) {
          ParallelFromPublisher.ParallelDispatcher parallelDispatcher = ParallelFromPublisher.ParallelDispatcher.this;
          i = this.m;
          parallelDispatcher.cancel(i + i);
        } 
      }
      
      public void request(long param2Long) {
        if (SubscriptionHelper.validate(param2Long)) {
          AtomicLongArray atomicLongArray = ParallelFromPublisher.ParallelDispatcher.this.requests;
          while (true) {
            long l1 = atomicLongArray.get(this.j);
            if (l1 == Long.MAX_VALUE)
              return; 
            long l2 = BackpressureHelper.addCap(l1, param2Long);
            if (atomicLongArray.compareAndSet(this.j, l1, l2)) {
              if (ParallelFromPublisher.ParallelDispatcher.this.subscriberCount.get() == this.m)
                ParallelFromPublisher.ParallelDispatcher.this.drain(); 
              break;
            } 
          } 
        } 
      }
    }
  }
  
  final class RailSubscription implements Subscription {
    final int j;
    
    final int m;
    
    RailSubscription(int param1Int1, int param1Int2) {
      this.j = param1Int1;
      this.m = param1Int2;
    }
    
    public void cancel() {
      AtomicLongArray atomicLongArray = this.this$0.requests;
      int i = this.m;
      if (atomicLongArray.compareAndSet(this.j + i, 0L, 1L)) {
        ParallelFromPublisher.ParallelDispatcher parallelDispatcher = this.this$0;
        i = this.m;
        parallelDispatcher.cancel(i + i);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        AtomicLongArray atomicLongArray = this.this$0.requests;
        while (true) {
          long l1 = atomicLongArray.get(this.j);
          if (l1 == Long.MAX_VALUE)
            return; 
          long l2 = BackpressureHelper.addCap(l1, param1Long);
          if (atomicLongArray.compareAndSet(this.j, l1, l2)) {
            if (this.this$0.subscriberCount.get() == this.m)
              this.this$0.drain(); 
            break;
          } 
        } 
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\parallel\ParallelFromPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */