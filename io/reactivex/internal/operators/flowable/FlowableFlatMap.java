package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {
  final int bufferSize;
  
  final boolean delayErrors;
  
  final Function<? super T, ? extends Publisher<? extends U>> mapper;
  
  final int maxConcurrency;
  
  public FlowableFlatMap(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2) {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
    this.maxConcurrency = paramInt1;
    this.bufferSize = paramInt2;
  }
  
  public static <T, U> FlowableSubscriber<T> subscribe(Subscriber<? super U> paramSubscriber, Function<? super T, ? extends Publisher<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2) {
    return new MergeSubscriber<T, U>(paramSubscriber, paramFunction, paramBoolean, paramInt1, paramInt2);
  }
  
  protected void subscribeActual(Subscriber<? super U> paramSubscriber) {
    if (FlowableScalarXMap.tryScalarXMapSubscribe((Publisher<T>)this.source, paramSubscriber, this.mapper))
      return; 
    this.source.subscribe(subscribe(paramSubscriber, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
  }
  
  static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
    private static final long serialVersionUID = -4606175640614850599L;
    
    final int bufferSize;
    
    volatile boolean done;
    
    int fusionMode;
    
    final long id;
    
    final int limit;
    
    final FlowableFlatMap.MergeSubscriber<T, U> parent;
    
    long produced;
    
    volatile SimpleQueue<U> queue;
    
    InnerSubscriber(FlowableFlatMap.MergeSubscriber<T, U> param1MergeSubscriber, long param1Long) {
      this.id = param1Long;
      this.parent = param1MergeSubscriber;
      this.bufferSize = param1MergeSubscriber.bufferSize;
      this.limit = this.bufferSize >> 2;
    }
    
    public void dispose() {
      SubscriptionHelper.cancel(this);
    }
    
    public boolean isDisposed() {
      boolean bool;
      if (get() == SubscriptionHelper.CANCELLED) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public void onComplete() {
      this.done = true;
      this.parent.drain();
    }
    
    public void onError(Throwable param1Throwable) {
      lazySet((Subscription)SubscriptionHelper.CANCELLED);
      this.parent.innerError(this, param1Throwable);
    }
    
    public void onNext(U param1U) {
      if (this.fusionMode != 2) {
        this.parent.tryEmit(param1U, this);
      } else {
        this.parent.drain();
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.setOnce(this, param1Subscription)) {
        if (param1Subscription instanceof QueueSubscription) {
          QueueSubscription queueSubscription = (QueueSubscription)param1Subscription;
          int i = queueSubscription.requestFusion(7);
          if (i == 1) {
            this.fusionMode = i;
            this.queue = (SimpleQueue<U>)queueSubscription;
            this.done = true;
            this.parent.drain();
            return;
          } 
          if (i == 2) {
            this.fusionMode = i;
            this.queue = (SimpleQueue<U>)queueSubscription;
          } 
        } 
        param1Subscription.request(this.bufferSize);
      } 
    }
    
    void requestMore(long param1Long) {
      if (this.fusionMode != 1) {
        param1Long = this.produced + param1Long;
        if (param1Long >= this.limit) {
          this.produced = 0L;
          get().request(param1Long);
        } else {
          this.produced = param1Long;
        } 
      } 
    }
  }
  
  static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    static final FlowableFlatMap.InnerSubscriber<?, ?>[] CANCELLED = (FlowableFlatMap.InnerSubscriber<?, ?>[])new FlowableFlatMap.InnerSubscriber[0];
    
    static final FlowableFlatMap.InnerSubscriber<?, ?>[] EMPTY = (FlowableFlatMap.InnerSubscriber<?, ?>[])new FlowableFlatMap.InnerSubscriber[0];
    
    private static final long serialVersionUID = -2117620485640801370L;
    
    final Subscriber<? super U> actual;
    
    final int bufferSize;
    
    volatile boolean cancelled;
    
    final boolean delayErrors;
    
    volatile boolean done;
    
    final AtomicThrowable errs = new AtomicThrowable();
    
    long lastId;
    
    int lastIndex;
    
    final Function<? super T, ? extends Publisher<? extends U>> mapper;
    
    final int maxConcurrency;
    
    volatile SimplePlainQueue<U> queue;
    
    final AtomicLong requested = new AtomicLong();
    
    int scalarEmitted;
    
    final int scalarLimit;
    
    final AtomicReference<FlowableFlatMap.InnerSubscriber<?, ?>[]> subscribers = (AtomicReference)new AtomicReference<FlowableFlatMap.InnerSubscriber<?, ?>>();
    
    long uniqueId;
    
    Subscription upstream;
    
    static {
    
    }
    
    MergeSubscriber(Subscriber<? super U> param1Subscriber, Function<? super T, ? extends Publisher<? extends U>> param1Function, boolean param1Boolean, int param1Int1, int param1Int2) {
      this.actual = param1Subscriber;
      this.mapper = param1Function;
      this.delayErrors = param1Boolean;
      this.maxConcurrency = param1Int1;
      this.bufferSize = param1Int2;
      this.scalarLimit = Math.max(1, param1Int1 >> 1);
      this.subscribers.lazySet(EMPTY);
    }
    
    boolean addInner(FlowableFlatMap.InnerSubscriber<T, U> param1InnerSubscriber) {
      while (true) {
        FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber1 = (FlowableFlatMap.InnerSubscriber[])this.subscribers.get();
        if (arrayOfInnerSubscriber1 == CANCELLED) {
          param1InnerSubscriber.dispose();
          return false;
        } 
        int i = arrayOfInnerSubscriber1.length;
        FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber2 = new FlowableFlatMap.InnerSubscriber[i + 1];
        System.arraycopy(arrayOfInnerSubscriber1, 0, arrayOfInnerSubscriber2, 0, i);
        arrayOfInnerSubscriber2[i] = param1InnerSubscriber;
        if (this.subscribers.compareAndSet(arrayOfInnerSubscriber1, arrayOfInnerSubscriber2))
          return true; 
      } 
    }
    
    public void cancel() {
      if (!this.cancelled) {
        this.cancelled = true;
        this.upstream.cancel();
        disposeAll();
        if (getAndIncrement() == 0) {
          SimplePlainQueue<U> simplePlainQueue = this.queue;
          if (simplePlainQueue != null)
            simplePlainQueue.clear(); 
        } 
      } 
    }
    
    boolean checkTerminate() {
      if (this.cancelled) {
        clearScalarQueue();
        return true;
      } 
      if (!this.delayErrors && this.errs.get() != null) {
        clearScalarQueue();
        Throwable throwable = this.errs.terminate();
        if (throwable != ExceptionHelper.TERMINATED)
          this.actual.onError(throwable); 
        return true;
      } 
      return false;
    }
    
    void clearScalarQueue() {
      SimplePlainQueue<U> simplePlainQueue = this.queue;
      if (simplePlainQueue != null)
        simplePlainQueue.clear(); 
    }
    
    void disposeAll() {
      FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber = (FlowableFlatMap.InnerSubscriber[])this.subscribers.get();
      FlowableFlatMap.InnerSubscriber<?, ?>[] arrayOfInnerSubscriber1 = CANCELLED;
      if (arrayOfInnerSubscriber != arrayOfInnerSubscriber1) {
        FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber2 = (FlowableFlatMap.InnerSubscriber[])this.subscribers.getAndSet(arrayOfInnerSubscriber1);
        if (arrayOfInnerSubscriber2 != CANCELLED) {
          int i = arrayOfInnerSubscriber2.length;
          for (byte b = 0; b < i; b++)
            arrayOfInnerSubscriber2[b].dispose(); 
          Throwable throwable = this.errs.terminate();
          if (throwable != null && throwable != ExceptionHelper.TERMINATED)
            RxJavaPlugins.onError(throwable); 
        } 
      } 
    }
    
    void drain() {
      if (getAndIncrement() == 0)
        drainLoop(); 
    }
    
    void drainLoop() {
      // Byte code:
      //   0: aload_0
      //   1: getfield actual : Lorg/reactivestreams/Subscriber;
      //   4: astore_1
      //   5: iconst_1
      //   6: istore_2
      //   7: aload_0
      //   8: invokevirtual checkTerminate : ()Z
      //   11: ifeq -> 15
      //   14: return
      //   15: aload_0
      //   16: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   19: astore_3
      //   20: aload_0
      //   21: getfield requested : Ljava/util/concurrent/atomic/AtomicLong;
      //   24: invokevirtual get : ()J
      //   27: lstore #4
      //   29: lload #4
      //   31: ldc2_w 9223372036854775807
      //   34: lcmp
      //   35: ifne -> 44
      //   38: iconst_1
      //   39: istore #6
      //   41: goto -> 47
      //   44: iconst_0
      //   45: istore #6
      //   47: aload_3
      //   48: ifnull -> 186
      //   51: lconst_0
      //   52: lstore #7
      //   54: lconst_0
      //   55: lstore #9
      //   57: aconst_null
      //   58: astore #11
      //   60: lload #4
      //   62: lconst_0
      //   63: lcmp
      //   64: ifeq -> 120
      //   67: aload_3
      //   68: invokeinterface poll : ()Ljava/lang/Object;
      //   73: astore #11
      //   75: aload_0
      //   76: invokevirtual checkTerminate : ()Z
      //   79: ifeq -> 83
      //   82: return
      //   83: aload #11
      //   85: ifnonnull -> 91
      //   88: goto -> 120
      //   91: aload_1
      //   92: aload #11
      //   94: invokeinterface onNext : (Ljava/lang/Object;)V
      //   99: lload #7
      //   101: lconst_1
      //   102: ladd
      //   103: lstore #7
      //   105: lload #9
      //   107: lconst_1
      //   108: ladd
      //   109: lstore #9
      //   111: lload #4
      //   113: lconst_1
      //   114: lsub
      //   115: lstore #4
      //   117: goto -> 60
      //   120: lload #9
      //   122: lconst_0
      //   123: lcmp
      //   124: ifeq -> 152
      //   127: iload #6
      //   129: ifeq -> 140
      //   132: ldc2_w 9223372036854775807
      //   135: lstore #4
      //   137: goto -> 152
      //   140: aload_0
      //   141: getfield requested : Ljava/util/concurrent/atomic/AtomicLong;
      //   144: lload #9
      //   146: lneg
      //   147: invokevirtual addAndGet : (J)J
      //   150: lstore #4
      //   152: lload #4
      //   154: lstore #12
      //   156: lload #7
      //   158: lstore #9
      //   160: lload #4
      //   162: lconst_0
      //   163: lcmp
      //   164: ifeq -> 193
      //   167: aload #11
      //   169: ifnonnull -> 183
      //   172: lload #4
      //   174: lstore #12
      //   176: lload #7
      //   178: lstore #9
      //   180: goto -> 193
      //   183: goto -> 54
      //   186: lconst_0
      //   187: lstore #9
      //   189: lload #4
      //   191: lstore #12
      //   193: aload_0
      //   194: getfield done : Z
      //   197: istore #14
      //   199: aload_0
      //   200: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   203: astore_3
      //   204: aload_0
      //   205: getfield subscribers : Ljava/util/concurrent/atomic/AtomicReference;
      //   208: invokevirtual get : ()Ljava/lang/Object;
      //   211: checkcast [Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;
      //   214: astore #11
      //   216: aload #11
      //   218: arraylength
      //   219: istore #15
      //   221: iload #14
      //   223: ifeq -> 284
      //   226: aload_3
      //   227: ifnull -> 239
      //   230: aload_3
      //   231: invokeinterface isEmpty : ()Z
      //   236: ifeq -> 284
      //   239: iload #15
      //   241: ifne -> 284
      //   244: aload_0
      //   245: getfield errs : Lio/reactivex/internal/util/AtomicThrowable;
      //   248: invokevirtual terminate : ()Ljava/lang/Throwable;
      //   251: astore #11
      //   253: aload #11
      //   255: getstatic io/reactivex/internal/util/ExceptionHelper.TERMINATED : Ljava/lang/Throwable;
      //   258: if_acmpeq -> 283
      //   261: aload #11
      //   263: ifnonnull -> 275
      //   266: aload_1
      //   267: invokeinterface onComplete : ()V
      //   272: goto -> 283
      //   275: aload_1
      //   276: aload #11
      //   278: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   283: return
      //   284: iload #15
      //   286: ifeq -> 802
      //   289: aload_0
      //   290: getfield lastId : J
      //   293: lstore #4
      //   295: aload_0
      //   296: getfield lastIndex : I
      //   299: istore #16
      //   301: iload #15
      //   303: iload #16
      //   305: if_icmple -> 326
      //   308: iload #16
      //   310: istore #17
      //   312: aload #11
      //   314: iload #16
      //   316: aaload
      //   317: getfield id : J
      //   320: lload #4
      //   322: lcmp
      //   323: ifeq -> 411
      //   326: iload #16
      //   328: istore #17
      //   330: iload #15
      //   332: iload #16
      //   334: if_icmpgt -> 340
      //   337: iconst_0
      //   338: istore #17
      //   340: iconst_0
      //   341: istore #16
      //   343: iload #16
      //   345: iload #15
      //   347: if_icmpge -> 393
      //   350: aload #11
      //   352: iload #17
      //   354: aaload
      //   355: getfield id : J
      //   358: lload #4
      //   360: lcmp
      //   361: ifne -> 367
      //   364: goto -> 393
      //   367: iload #17
      //   369: iconst_1
      //   370: iadd
      //   371: istore #18
      //   373: iload #18
      //   375: istore #17
      //   377: iload #18
      //   379: iload #15
      //   381: if_icmpne -> 387
      //   384: iconst_0
      //   385: istore #17
      //   387: iinc #16, 1
      //   390: goto -> 343
      //   393: aload_0
      //   394: iload #17
      //   396: putfield lastIndex : I
      //   399: aload_0
      //   400: aload #11
      //   402: iload #17
      //   404: aaload
      //   405: getfield id : J
      //   408: putfield lastId : J
      //   411: iconst_0
      //   412: istore #19
      //   414: iconst_0
      //   415: istore #16
      //   417: lload #9
      //   419: lstore #4
      //   421: lload #12
      //   423: lstore #9
      //   425: iload #17
      //   427: istore #18
      //   429: iload #19
      //   431: istore #17
      //   433: iload #16
      //   435: iload #15
      //   437: if_icmpge -> 777
      //   440: aload_0
      //   441: invokevirtual checkTerminate : ()Z
      //   444: ifeq -> 448
      //   447: return
      //   448: aload #11
      //   450: iload #18
      //   452: aaload
      //   453: astore #20
      //   455: aconst_null
      //   456: astore_3
      //   457: aload_0
      //   458: invokevirtual checkTerminate : ()Z
      //   461: ifeq -> 465
      //   464: return
      //   465: aload #20
      //   467: getfield queue : Lio/reactivex/internal/fuseable/SimpleQueue;
      //   470: astore #21
      //   472: aload #21
      //   474: ifnonnull -> 484
      //   477: lload #9
      //   479: lstore #7
      //   481: goto -> 671
      //   484: lconst_0
      //   485: lstore #7
      //   487: lload #9
      //   489: lconst_0
      //   490: lcmp
      //   491: ifeq -> 597
      //   494: aload #21
      //   496: invokeinterface poll : ()Ljava/lang/Object;
      //   501: astore_3
      //   502: aload_3
      //   503: ifnonnull -> 509
      //   506: goto -> 597
      //   509: aload_1
      //   510: aload_3
      //   511: invokeinterface onNext : (Ljava/lang/Object;)V
      //   516: aload_0
      //   517: invokevirtual checkTerminate : ()Z
      //   520: ifeq -> 524
      //   523: return
      //   524: lload #9
      //   526: lconst_1
      //   527: lsub
      //   528: lstore #9
      //   530: lload #7
      //   532: lconst_1
      //   533: ladd
      //   534: lstore #7
      //   536: goto -> 487
      //   539: astore_3
      //   540: aload_3
      //   541: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   544: aload #20
      //   546: invokevirtual dispose : ()V
      //   549: aload_0
      //   550: getfield errs : Lio/reactivex/internal/util/AtomicThrowable;
      //   553: aload_3
      //   554: invokevirtual addThrowable : (Ljava/lang/Throwable;)Z
      //   557: pop
      //   558: aload_0
      //   559: getfield delayErrors : Z
      //   562: ifne -> 574
      //   565: aload_0
      //   566: getfield upstream : Lorg/reactivestreams/Subscription;
      //   569: invokeinterface cancel : ()V
      //   574: aload_0
      //   575: invokevirtual checkTerminate : ()Z
      //   578: ifeq -> 582
      //   581: return
      //   582: aload_0
      //   583: aload #20
      //   585: invokevirtual removeInner : (Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;)V
      //   588: iinc #16, 1
      //   591: iconst_1
      //   592: istore #17
      //   594: goto -> 771
      //   597: lload #7
      //   599: lconst_0
      //   600: lcmp
      //   601: ifeq -> 642
      //   604: iload #6
      //   606: ifne -> 624
      //   609: aload_0
      //   610: getfield requested : Ljava/util/concurrent/atomic/AtomicLong;
      //   613: lload #7
      //   615: lneg
      //   616: invokevirtual addAndGet : (J)J
      //   619: lstore #9
      //   621: goto -> 629
      //   624: ldc2_w 9223372036854775807
      //   627: lstore #9
      //   629: aload #20
      //   631: lload #7
      //   633: invokevirtual requestMore : (J)V
      //   636: lconst_0
      //   637: lstore #12
      //   639: goto -> 645
      //   642: lconst_0
      //   643: lstore #12
      //   645: lload #9
      //   647: lstore #7
      //   649: lload #9
      //   651: lload #12
      //   653: lcmp
      //   654: ifeq -> 671
      //   657: aload_3
      //   658: ifnonnull -> 668
      //   661: lload #9
      //   663: lstore #7
      //   665: goto -> 671
      //   668: goto -> 457
      //   671: aload #11
      //   673: astore_3
      //   674: aload #20
      //   676: getfield done : Z
      //   679: istore #14
      //   681: aload #20
      //   683: getfield queue : Lio/reactivex/internal/fuseable/SimpleQueue;
      //   686: astore #21
      //   688: iload #14
      //   690: ifeq -> 734
      //   693: aload #21
      //   695: ifnull -> 708
      //   698: aload #21
      //   700: invokeinterface isEmpty : ()Z
      //   705: ifeq -> 734
      //   708: aload_0
      //   709: aload #20
      //   711: invokevirtual removeInner : (Lio/reactivex/internal/operators/flowable/FlowableFlatMap$InnerSubscriber;)V
      //   714: aload_0
      //   715: invokevirtual checkTerminate : ()Z
      //   718: ifeq -> 722
      //   721: return
      //   722: lload #4
      //   724: lconst_1
      //   725: ladd
      //   726: lstore #4
      //   728: iconst_1
      //   729: istore #17
      //   731: goto -> 734
      //   734: lload #7
      //   736: lconst_0
      //   737: lcmp
      //   738: ifne -> 747
      //   741: aload_3
      //   742: astore #11
      //   744: goto -> 777
      //   747: iinc #18, 1
      //   750: iload #18
      //   752: iload #15
      //   754: if_icmpne -> 767
      //   757: iconst_0
      //   758: istore #18
      //   760: lload #7
      //   762: lstore #9
      //   764: goto -> 771
      //   767: lload #7
      //   769: lstore #9
      //   771: iinc #16, 1
      //   774: goto -> 433
      //   777: aload_0
      //   778: iload #18
      //   780: putfield lastIndex : I
      //   783: aload_0
      //   784: aload #11
      //   786: iload #18
      //   788: aaload
      //   789: getfield id : J
      //   792: putfield lastId : J
      //   795: lload #4
      //   797: lstore #9
      //   799: goto -> 805
      //   802: iconst_0
      //   803: istore #17
      //   805: lload #9
      //   807: lconst_0
      //   808: lcmp
      //   809: ifeq -> 830
      //   812: aload_0
      //   813: getfield cancelled : Z
      //   816: ifne -> 830
      //   819: aload_0
      //   820: getfield upstream : Lorg/reactivestreams/Subscription;
      //   823: lload #9
      //   825: invokeinterface request : (J)V
      //   830: iload #17
      //   832: ifeq -> 838
      //   835: goto -> 7
      //   838: aload_0
      //   839: iload_2
      //   840: ineg
      //   841: invokevirtual addAndGet : (I)I
      //   844: istore #17
      //   846: iload #17
      //   848: istore_2
      //   849: iload #17
      //   851: ifne -> 7
      //   854: return
      // Exception table:
      //   from	to	target	type
      //   494	502	539	java/lang/Throwable
    }
    
    SimpleQueue<U> getInnerQueue(FlowableFlatMap.InnerSubscriber<T, U> param1InnerSubscriber) {
      SpscArrayQueue spscArrayQueue;
      SimpleQueue<U> simpleQueue1 = param1InnerSubscriber.queue;
      SimpleQueue<U> simpleQueue2 = simpleQueue1;
      if (simpleQueue1 == null) {
        spscArrayQueue = new SpscArrayQueue(this.bufferSize);
        param1InnerSubscriber.queue = (SimpleQueue<U>)spscArrayQueue;
      } 
      return (SimpleQueue<U>)spscArrayQueue;
    }
    
    SimpleQueue<U> getMainQueue() {
      SpscArrayQueue spscArrayQueue;
      SimplePlainQueue<U> simplePlainQueue1 = this.queue;
      SimplePlainQueue<U> simplePlainQueue2 = simplePlainQueue1;
      if (simplePlainQueue1 == null) {
        int i = this.maxConcurrency;
        if (i == Integer.MAX_VALUE) {
          SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(this.bufferSize);
        } else {
          spscArrayQueue = new SpscArrayQueue(i);
        } 
        this.queue = (SimplePlainQueue<U>)spscArrayQueue;
      } 
      return (SimpleQueue<U>)spscArrayQueue;
    }
    
    void innerError(FlowableFlatMap.InnerSubscriber<T, U> param1InnerSubscriber, Throwable param1Throwable) {
      if (this.errs.addThrowable(param1Throwable)) {
        param1InnerSubscriber.done = true;
        if (!this.delayErrors) {
          this.upstream.cancel();
          FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber = (FlowableFlatMap.InnerSubscriber[])this.subscribers.getAndSet(CANCELLED);
          int i = arrayOfInnerSubscriber.length;
          for (byte b = 0; b < i; b++)
            arrayOfInnerSubscriber[b].dispose(); 
        } 
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onComplete() {
      if (this.done)
        return; 
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.done) {
        RxJavaPlugins.onError(param1Throwable);
        return;
      } 
      if (this.errs.addThrowable(param1Throwable)) {
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      if (this.done)
        return; 
      try {
        Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null Publisher");
        if (publisher instanceof Callable) {
          try {
            param1T = ((Callable<T>)publisher).call();
            if (param1T != null) {
              tryEmitScalar((U)param1T);
            } else if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
              int i = this.scalarEmitted + 1;
              this.scalarEmitted = i;
              int j = this.scalarLimit;
              if (i == j) {
                this.scalarEmitted = 0;
                this.upstream.request(j);
              } 
            } 
          } catch (Throwable throwable) {
            Exceptions.throwIfFatal(throwable);
            this.errs.addThrowable(throwable);
            drain();
            return;
          } 
        } else {
          long l = this.uniqueId;
          this.uniqueId = 1L + l;
          FlowableFlatMap.InnerSubscriber<Object, Object> innerSubscriber = new FlowableFlatMap.InnerSubscriber<Object, Object>(this, l);
          if (addInner((FlowableFlatMap.InnerSubscriber)innerSubscriber))
            publisher.subscribe((Subscriber)innerSubscriber); 
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.upstream.cancel();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.upstream, param1Subscription)) {
        this.upstream = param1Subscription;
        this.actual.onSubscribe(this);
        if (!this.cancelled) {
          int i = this.maxConcurrency;
          if (i == Integer.MAX_VALUE) {
            param1Subscription.request(Long.MAX_VALUE);
          } else {
            param1Subscription.request(i);
          } 
        } 
      } 
    }
    
    void removeInner(FlowableFlatMap.InnerSubscriber<T, U> param1InnerSubscriber) {
      FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber1;
      FlowableFlatMap.InnerSubscriber[] arrayOfInnerSubscriber2;
      do {
        byte b2;
        arrayOfInnerSubscriber1 = (FlowableFlatMap.InnerSubscriber[])this.subscribers.get();
        int i = arrayOfInnerSubscriber1.length;
        if (i == 0)
          return; 
        byte b1 = -1;
        byte b = 0;
        while (true) {
          b2 = b1;
          if (b < i) {
            if (arrayOfInnerSubscriber1[b] == param1InnerSubscriber) {
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
          FlowableFlatMap.InnerSubscriber<?, ?>[] arrayOfInnerSubscriber = EMPTY;
        } else {
          arrayOfInnerSubscriber2 = new FlowableFlatMap.InnerSubscriber[i - 1];
          System.arraycopy(arrayOfInnerSubscriber1, 0, arrayOfInnerSubscriber2, 0, b2);
          System.arraycopy(arrayOfInnerSubscriber1, b2 + 1, arrayOfInnerSubscriber2, b2, i - b2 - 1);
        } 
      } while (!this.subscribers.compareAndSet(arrayOfInnerSubscriber1, arrayOfInnerSubscriber2));
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.add(this.requested, param1Long);
        drain();
      } 
    }
    
    void tryEmit(U param1U, FlowableFlatMap.InnerSubscriber<T, U> param1InnerSubscriber) {
      if (get() == 0 && compareAndSet(0, 1)) {
        long l = this.requested.get();
        SimpleQueue<U> simpleQueue = param1InnerSubscriber.queue;
        if (l != 0L && (simpleQueue == null || simpleQueue.isEmpty())) {
          this.actual.onNext(param1U);
          if (l != Long.MAX_VALUE)
            this.requested.decrementAndGet(); 
          param1InnerSubscriber.requestMore(1L);
        } else {
          SimpleQueue<U> simpleQueue1 = simpleQueue;
          if (simpleQueue == null)
            simpleQueue1 = getInnerQueue(param1InnerSubscriber); 
          if (!simpleQueue1.offer(param1U)) {
            onError((Throwable)new MissingBackpressureException("Inner queue full?!"));
            return;
          } 
        } 
        if (decrementAndGet() == 0)
          return; 
      } else {
        SpscArrayQueue spscArrayQueue;
        SimpleQueue<U> simpleQueue1 = param1InnerSubscriber.queue;
        SimpleQueue<U> simpleQueue2 = simpleQueue1;
        if (simpleQueue1 == null) {
          spscArrayQueue = new SpscArrayQueue(this.bufferSize);
          param1InnerSubscriber.queue = (SimpleQueue<U>)spscArrayQueue;
        } 
        if (!spscArrayQueue.offer(param1U)) {
          onError((Throwable)new MissingBackpressureException("Inner queue full?!"));
          return;
        } 
        if (getAndIncrement() != 0)
          return; 
      } 
      drainLoop();
    }
    
    void tryEmitScalar(U param1U) {
      if (get() == 0 && compareAndSet(0, 1)) {
        long l = this.requested.get();
        SimplePlainQueue<U> simplePlainQueue = this.queue;
        if (l != 0L && (simplePlainQueue == null || simplePlainQueue.isEmpty())) {
          this.actual.onNext(param1U);
          if (l != Long.MAX_VALUE)
            this.requested.decrementAndGet(); 
          if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
            int i = this.scalarEmitted + 1;
            this.scalarEmitted = i;
            int j = this.scalarLimit;
            if (i == j) {
              this.scalarEmitted = 0;
              this.upstream.request(j);
            } 
          } 
        } else {
          SimpleQueue<U> simpleQueue;
          SimplePlainQueue<U> simplePlainQueue1 = simplePlainQueue;
          if (simplePlainQueue == null)
            simpleQueue = getMainQueue(); 
          if (!simpleQueue.offer(param1U)) {
            onError(new IllegalStateException("Scalar queue full?!"));
            return;
          } 
        } 
        if (decrementAndGet() == 0)
          return; 
      } else {
        if (!getMainQueue().offer(param1U)) {
          onError(new IllegalStateException("Scalar queue full?!"));
          return;
        } 
        if (getAndIncrement() != 0)
          return; 
      } 
      drainLoop();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableFlatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */