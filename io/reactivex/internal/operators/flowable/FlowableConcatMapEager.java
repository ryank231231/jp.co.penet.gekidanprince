package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
  final ErrorMode errorMode;
  
  final Function<? super T, ? extends Publisher<? extends R>> mapper;
  
  final int maxConcurrency;
  
  final int prefetch;
  
  public FlowableConcatMapEager(Flowable<T> paramFlowable, Function<? super T, ? extends Publisher<? extends R>> paramFunction, int paramInt1, int paramInt2, ErrorMode paramErrorMode) {
    super(paramFlowable);
    this.mapper = paramFunction;
    this.maxConcurrency = paramInt1;
    this.prefetch = paramInt2;
    this.errorMode = paramErrorMode;
  }
  
  protected void subscribeActual(Subscriber<? super R> paramSubscriber) {
    this.source.subscribe(new ConcatMapEagerDelayErrorSubscriber<T, R>(paramSubscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
  }
  
  static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
    private static final long serialVersionUID = -4255299542215038287L;
    
    final Subscriber<? super R> actual;
    
    volatile boolean cancelled;
    
    volatile InnerQueuedSubscriber<R> current;
    
    volatile boolean done;
    
    final ErrorMode errorMode;
    
    final AtomicThrowable errors;
    
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    
    final int maxConcurrency;
    
    final int prefetch;
    
    final AtomicLong requested;
    
    Subscription s;
    
    final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
    
    ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> param1Subscriber, Function<? super T, ? extends Publisher<? extends R>> param1Function, int param1Int1, int param1Int2, ErrorMode param1ErrorMode) {
      this.actual = param1Subscriber;
      this.mapper = param1Function;
      this.maxConcurrency = param1Int1;
      this.prefetch = param1Int2;
      this.errorMode = param1ErrorMode;
      this.subscribers = new SpscLinkedArrayQueue(Math.min(param1Int2, param1Int1));
      this.errors = new AtomicThrowable();
      this.requested = new AtomicLong();
    }
    
    public void cancel() {
      if (this.cancelled)
        return; 
      this.cancelled = true;
      this.s.cancel();
      drainAndCancel();
    }
    
    void cancelAll() {
      while (true) {
        InnerQueuedSubscriber innerQueuedSubscriber = (InnerQueuedSubscriber)this.subscribers.poll();
        if (innerQueuedSubscriber != null) {
          innerQueuedSubscriber.cancel();
          continue;
        } 
        break;
      } 
    }
    
    public void drain() {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual getAndIncrement : ()I
      //   4: ifeq -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   12: astore_1
      //   13: aload_0
      //   14: getfield actual : Lorg/reactivestreams/Subscriber;
      //   17: astore_2
      //   18: aload_0
      //   19: getfield errorMode : Lio/reactivex/internal/util/ErrorMode;
      //   22: astore_3
      //   23: iconst_1
      //   24: istore #4
      //   26: aload_0
      //   27: getfield requested : Ljava/util/concurrent/atomic/AtomicLong;
      //   30: invokevirtual get : ()J
      //   33: lstore #5
      //   35: aload_1
      //   36: ifnonnull -> 154
      //   39: aload_3
      //   40: getstatic io/reactivex/internal/util/ErrorMode.END : Lio/reactivex/internal/util/ErrorMode;
      //   43: if_acmpeq -> 77
      //   46: aload_0
      //   47: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   50: invokevirtual get : ()Ljava/lang/Object;
      //   53: checkcast java/lang/Throwable
      //   56: ifnull -> 77
      //   59: aload_0
      //   60: invokevirtual cancelAll : ()V
      //   63: aload_2
      //   64: aload_0
      //   65: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   68: invokevirtual terminate : ()Ljava/lang/Throwable;
      //   71: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   76: return
      //   77: aload_0
      //   78: getfield done : Z
      //   81: istore #7
      //   83: aload_0
      //   84: getfield subscribers : Lio/reactivex/internal/queue/SpscLinkedArrayQueue;
      //   87: invokevirtual poll : ()Ljava/lang/Object;
      //   90: checkcast io/reactivex/internal/subscribers/InnerQueuedSubscriber
      //   93: astore #8
      //   95: iload #7
      //   97: ifeq -> 134
      //   100: aload #8
      //   102: ifnonnull -> 134
      //   105: aload_0
      //   106: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   109: invokevirtual terminate : ()Ljava/lang/Throwable;
      //   112: astore_1
      //   113: aload_1
      //   114: ifnull -> 127
      //   117: aload_2
      //   118: aload_1
      //   119: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   124: goto -> 133
      //   127: aload_2
      //   128: invokeinterface onComplete : ()V
      //   133: return
      //   134: aload #8
      //   136: astore_1
      //   137: aload #8
      //   139: ifnull -> 154
      //   142: aload_0
      //   143: aload #8
      //   145: putfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   148: aload #8
      //   150: astore_1
      //   151: goto -> 154
      //   154: aload_1
      //   155: ifnull -> 483
      //   158: aload_1
      //   159: invokevirtual queue : ()Lio/reactivex/internal/fuseable/SimpleQueue;
      //   162: astore #8
      //   164: aload #8
      //   166: ifnull -> 480
      //   169: lconst_0
      //   170: lstore #9
      //   172: lload #9
      //   174: lload #5
      //   176: lcmp
      //   177: ifeq -> 359
      //   180: aload_0
      //   181: getfield cancelled : Z
      //   184: ifeq -> 192
      //   187: aload_0
      //   188: invokevirtual cancelAll : ()V
      //   191: return
      //   192: aload_3
      //   193: getstatic io/reactivex/internal/util/ErrorMode.IMMEDIATE : Lio/reactivex/internal/util/ErrorMode;
      //   196: if_acmpne -> 239
      //   199: aload_0
      //   200: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   203: invokevirtual get : ()Ljava/lang/Object;
      //   206: checkcast java/lang/Throwable
      //   209: ifnull -> 239
      //   212: aload_0
      //   213: aconst_null
      //   214: putfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   217: aload_1
      //   218: invokevirtual cancel : ()V
      //   221: aload_0
      //   222: invokevirtual cancelAll : ()V
      //   225: aload_2
      //   226: aload_0
      //   227: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   230: invokevirtual terminate : ()Ljava/lang/Throwable;
      //   233: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   238: return
      //   239: aload_1
      //   240: invokevirtual isDone : ()Z
      //   243: istore #7
      //   245: aload #8
      //   247: invokeinterface poll : ()Ljava/lang/Object;
      //   252: astore #11
      //   254: aload #11
      //   256: ifnonnull -> 265
      //   259: iconst_1
      //   260: istore #12
      //   262: goto -> 268
      //   265: iconst_0
      //   266: istore #12
      //   268: iload #7
      //   270: ifeq -> 301
      //   273: iload #12
      //   275: ifeq -> 301
      //   278: aload_0
      //   279: aconst_null
      //   280: putfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   283: aload_0
      //   284: getfield s : Lorg/reactivestreams/Subscription;
      //   287: lconst_1
      //   288: invokeinterface request : (J)V
      //   293: aconst_null
      //   294: astore_1
      //   295: iconst_1
      //   296: istore #12
      //   298: goto -> 362
      //   301: iload #12
      //   303: ifeq -> 309
      //   306: goto -> 359
      //   309: aload_2
      //   310: aload #11
      //   312: invokeinterface onNext : (Ljava/lang/Object;)V
      //   317: lload #9
      //   319: lconst_1
      //   320: ladd
      //   321: lstore #9
      //   323: aload_1
      //   324: invokevirtual requestOne : ()V
      //   327: goto -> 172
      //   330: astore #8
      //   332: aload #8
      //   334: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   337: aload_0
      //   338: aconst_null
      //   339: putfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   342: aload_1
      //   343: invokevirtual cancel : ()V
      //   346: aload_0
      //   347: invokevirtual cancelAll : ()V
      //   350: aload_2
      //   351: aload #8
      //   353: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   358: return
      //   359: iconst_0
      //   360: istore #12
      //   362: lload #9
      //   364: lload #5
      //   366: lcmp
      //   367: ifne -> 477
      //   370: aload_0
      //   371: getfield cancelled : Z
      //   374: ifeq -> 382
      //   377: aload_0
      //   378: invokevirtual cancelAll : ()V
      //   381: return
      //   382: aload_3
      //   383: getstatic io/reactivex/internal/util/ErrorMode.IMMEDIATE : Lio/reactivex/internal/util/ErrorMode;
      //   386: if_acmpne -> 429
      //   389: aload_0
      //   390: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   393: invokevirtual get : ()Ljava/lang/Object;
      //   396: checkcast java/lang/Throwable
      //   399: ifnull -> 429
      //   402: aload_0
      //   403: aconst_null
      //   404: putfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   407: aload_1
      //   408: invokevirtual cancel : ()V
      //   411: aload_0
      //   412: invokevirtual cancelAll : ()V
      //   415: aload_2
      //   416: aload_0
      //   417: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   420: invokevirtual terminate : ()Ljava/lang/Throwable;
      //   423: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   428: return
      //   429: aload_1
      //   430: invokevirtual isDone : ()Z
      //   433: istore #7
      //   435: aload #8
      //   437: invokeinterface isEmpty : ()Z
      //   442: istore #13
      //   444: iload #7
      //   446: ifeq -> 477
      //   449: iload #13
      //   451: ifeq -> 477
      //   454: aload_0
      //   455: aconst_null
      //   456: putfield current : Lio/reactivex/internal/subscribers/InnerQueuedSubscriber;
      //   459: aload_0
      //   460: getfield s : Lorg/reactivestreams/Subscription;
      //   463: lconst_1
      //   464: invokeinterface request : (J)V
      //   469: aconst_null
      //   470: astore_1
      //   471: iconst_1
      //   472: istore #12
      //   474: goto -> 489
      //   477: goto -> 489
      //   480: goto -> 483
      //   483: lconst_0
      //   484: lstore #9
      //   486: iconst_0
      //   487: istore #12
      //   489: lload #9
      //   491: lconst_0
      //   492: lcmp
      //   493: ifeq -> 516
      //   496: lload #5
      //   498: ldc2_w 9223372036854775807
      //   501: lcmp
      //   502: ifeq -> 516
      //   505: aload_0
      //   506: getfield requested : Ljava/util/concurrent/atomic/AtomicLong;
      //   509: lload #9
      //   511: lneg
      //   512: invokevirtual addAndGet : (J)J
      //   515: pop2
      //   516: iload #12
      //   518: ifeq -> 524
      //   521: goto -> 26
      //   524: aload_0
      //   525: iload #4
      //   527: ineg
      //   528: invokevirtual addAndGet : (I)I
      //   531: istore #12
      //   533: iload #12
      //   535: istore #4
      //   537: iload #12
      //   539: ifne -> 26
      //   542: return
      // Exception table:
      //   from	to	target	type
      //   245	254	330	java/lang/Throwable
    }
    
    void drainAndCancel() {
      if (getAndIncrement() == 0)
        do {
          cancelAll();
        } while (decrementAndGet() != 0); 
    }
    
    public void innerComplete(InnerQueuedSubscriber<R> param1InnerQueuedSubscriber) {
      param1InnerQueuedSubscriber.setDone();
      drain();
    }
    
    public void innerError(InnerQueuedSubscriber<R> param1InnerQueuedSubscriber, Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        param1InnerQueuedSubscriber.setDone();
        if (this.errorMode != ErrorMode.END)
          this.s.cancel(); 
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void innerNext(InnerQueuedSubscriber<R> param1InnerQueuedSubscriber, R param1R) {
      if (param1InnerQueuedSubscriber.queue().offer(param1R)) {
        drain();
      } else {
        param1InnerQueuedSubscriber.cancel();
        innerError(param1InnerQueuedSubscriber, (Throwable)new MissingBackpressureException());
      } 
    }
    
    public void onComplete() {
      this.done = true;
      drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.errors.addThrowable(param1Throwable)) {
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      try {
        Publisher publisher = (Publisher)ObjectHelper.requireNonNull(this.mapper.apply(param1T), "The mapper returned a null Publisher");
        InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.prefetch);
        if (this.cancelled)
          return; 
        this.subscribers.offer(innerQueuedSubscriber);
        publisher.subscribe((Subscriber)innerQueuedSubscriber);
        if (this.cancelled) {
          innerQueuedSubscriber.cancel();
          drainAndCancel();
        } 
        return;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.s.cancel();
        onError(throwable);
        return;
      } 
    }
    
    public void onSubscribe(Subscription param1Subscription) {
      if (SubscriptionHelper.validate(this.s, param1Subscription)) {
        long l;
        this.s = param1Subscription;
        this.actual.onSubscribe(this);
        int i = this.maxConcurrency;
        if (i == Integer.MAX_VALUE) {
          l = Long.MAX_VALUE;
        } else {
          l = i;
        } 
        param1Subscription.request(l);
      } 
    }
    
    public void request(long param1Long) {
      if (SubscriptionHelper.validate(param1Long)) {
        BackpressureHelper.add(this.requested, param1Long);
        drain();
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\flowable\FlowableConcatMapEager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */