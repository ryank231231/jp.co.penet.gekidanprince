package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
  final int bufferSize;
  
  final boolean delayErrors;
  
  final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
  
  final int maxConcurrency;
  
  public ObservableFlatMap(ObservableSource<T> paramObservableSource, Function<? super T, ? extends ObservableSource<? extends U>> paramFunction, boolean paramBoolean, int paramInt1, int paramInt2) {
    super(paramObservableSource);
    this.mapper = paramFunction;
    this.delayErrors = paramBoolean;
    this.maxConcurrency = paramInt1;
    this.bufferSize = paramInt2;
  }
  
  public void subscribeActual(Observer<? super U> paramObserver) {
    if (ObservableScalarXMap.tryScalarXMapSubscribe(this.source, paramObserver, this.mapper))
      return; 
    this.source.subscribe(new MergeObserver<T, U>(paramObserver, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
  }
  
  static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
    private static final long serialVersionUID = -4606175640614850599L;
    
    volatile boolean done;
    
    int fusionMode;
    
    final long id;
    
    final ObservableFlatMap.MergeObserver<T, U> parent;
    
    volatile SimpleQueue<U> queue;
    
    InnerObserver(ObservableFlatMap.MergeObserver<T, U> param1MergeObserver, long param1Long) {
      this.id = param1Long;
      this.parent = param1MergeObserver;
    }
    
    public void dispose() {
      DisposableHelper.dispose(this);
    }
    
    public void onComplete() {
      this.done = true;
      this.parent.drain();
    }
    
    public void onError(Throwable param1Throwable) {
      if (this.parent.errors.addThrowable(param1Throwable)) {
        if (!this.parent.delayErrors)
          this.parent.disposeAll(); 
        this.done = true;
        this.parent.drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(U param1U) {
      if (this.fusionMode == 0) {
        this.parent.tryEmit(param1U, this);
      } else {
        this.parent.drain();
      } 
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.setOnce(this, param1Disposable) && param1Disposable instanceof QueueDisposable) {
        QueueDisposable queueDisposable = (QueueDisposable)param1Disposable;
        int i = queueDisposable.requestFusion(7);
        if (i == 1) {
          this.fusionMode = i;
          this.queue = (SimpleQueue<U>)queueDisposable;
          this.done = true;
          this.parent.drain();
          return;
        } 
        if (i == 2) {
          this.fusionMode = i;
          this.queue = (SimpleQueue<U>)queueDisposable;
        } 
      } 
    }
  }
  
  static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
    static final ObservableFlatMap.InnerObserver<?, ?>[] CANCELLED = (ObservableFlatMap.InnerObserver<?, ?>[])new ObservableFlatMap.InnerObserver[0];
    
    static final ObservableFlatMap.InnerObserver<?, ?>[] EMPTY = (ObservableFlatMap.InnerObserver<?, ?>[])new ObservableFlatMap.InnerObserver[0];
    
    private static final long serialVersionUID = -2117620485640801370L;
    
    final Observer<? super U> actual;
    
    final int bufferSize;
    
    volatile boolean cancelled;
    
    final boolean delayErrors;
    
    volatile boolean done;
    
    final AtomicThrowable errors = new AtomicThrowable();
    
    long lastId;
    
    int lastIndex;
    
    final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    
    final int maxConcurrency;
    
    final AtomicReference<ObservableFlatMap.InnerObserver<?, ?>[]> observers;
    
    volatile SimplePlainQueue<U> queue;
    
    Disposable s;
    
    Queue<ObservableSource<? extends U>> sources;
    
    long uniqueId;
    
    int wip;
    
    static {
    
    }
    
    MergeObserver(Observer<? super U> param1Observer, Function<? super T, ? extends ObservableSource<? extends U>> param1Function, boolean param1Boolean, int param1Int1, int param1Int2) {
      this.actual = param1Observer;
      this.mapper = param1Function;
      this.delayErrors = param1Boolean;
      this.maxConcurrency = param1Int1;
      this.bufferSize = param1Int2;
      if (param1Int1 != Integer.MAX_VALUE)
        this.sources = new ArrayDeque<ObservableSource<? extends U>>(param1Int1); 
      this.observers = (AtomicReference)new AtomicReference<ObservableFlatMap.InnerObserver<?, ?>>(EMPTY);
    }
    
    boolean addInner(ObservableFlatMap.InnerObserver<T, U> param1InnerObserver) {
      while (true) {
        ObservableFlatMap.InnerObserver[] arrayOfInnerObserver1 = (ObservableFlatMap.InnerObserver[])this.observers.get();
        if (arrayOfInnerObserver1 == CANCELLED) {
          param1InnerObserver.dispose();
          return false;
        } 
        int i = arrayOfInnerObserver1.length;
        ObservableFlatMap.InnerObserver[] arrayOfInnerObserver2 = new ObservableFlatMap.InnerObserver[i + 1];
        System.arraycopy(arrayOfInnerObserver1, 0, arrayOfInnerObserver2, 0, i);
        arrayOfInnerObserver2[i] = param1InnerObserver;
        if (this.observers.compareAndSet(arrayOfInnerObserver1, arrayOfInnerObserver2))
          return true; 
      } 
    }
    
    boolean checkTerminate() {
      if (this.cancelled)
        return true; 
      Throwable throwable = (Throwable)this.errors.get();
      if (!this.delayErrors && throwable != null) {
        disposeAll();
        throwable = this.errors.terminate();
        if (throwable != ExceptionHelper.TERMINATED)
          this.actual.onError(throwable); 
        return true;
      } 
      return false;
    }
    
    public void dispose() {
      if (!this.cancelled) {
        this.cancelled = true;
        if (disposeAll()) {
          Throwable throwable = this.errors.terminate();
          if (throwable != null && throwable != ExceptionHelper.TERMINATED)
            RxJavaPlugins.onError(throwable); 
        } 
      } 
    }
    
    boolean disposeAll() {
      this.s.dispose();
      ObservableFlatMap.InnerObserver[] arrayOfInnerObserver = (ObservableFlatMap.InnerObserver[])this.observers.get();
      ObservableFlatMap.InnerObserver<?, ?>[] arrayOfInnerObserver1 = CANCELLED;
      byte b = 0;
      if (arrayOfInnerObserver != arrayOfInnerObserver1) {
        arrayOfInnerObserver = (ObservableFlatMap.InnerObserver[])this.observers.getAndSet(arrayOfInnerObserver1);
        if (arrayOfInnerObserver != CANCELLED) {
          int i = arrayOfInnerObserver.length;
          while (b < i) {
            arrayOfInnerObserver[b].dispose();
            b++;
          } 
          return true;
        } 
      } 
      return false;
    }
    
    void drain() {
      if (getAndIncrement() == 0)
        drainLoop(); 
    }
    
    void drainLoop() {
      // Byte code:
      //   0: aload_0
      //   1: getfield actual : Lio/reactivex/Observer;
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
      //   20: aload_3
      //   21: ifnull -> 64
      //   24: aload_0
      //   25: invokevirtual checkTerminate : ()Z
      //   28: ifeq -> 32
      //   31: return
      //   32: aload_3
      //   33: invokeinterface poll : ()Ljava/lang/Object;
      //   38: astore #4
      //   40: aload #4
      //   42: ifnonnull -> 53
      //   45: aload #4
      //   47: ifnonnull -> 24
      //   50: goto -> 64
      //   53: aload_1
      //   54: aload #4
      //   56: invokeinterface onNext : (Ljava/lang/Object;)V
      //   61: goto -> 24
      //   64: aload_0
      //   65: getfield done : Z
      //   68: istore #5
      //   70: aload_0
      //   71: getfield queue : Lio/reactivex/internal/fuseable/SimplePlainQueue;
      //   74: astore #4
      //   76: aload_0
      //   77: getfield observers : Ljava/util/concurrent/atomic/AtomicReference;
      //   80: invokevirtual get : ()Ljava/lang/Object;
      //   83: checkcast [Lio/reactivex/internal/operators/observable/ObservableFlatMap$InnerObserver;
      //   86: astore_3
      //   87: aload_3
      //   88: arraylength
      //   89: istore #6
      //   91: aload_0
      //   92: getfield maxConcurrency : I
      //   95: ldc 2147483647
      //   97: if_icmpeq -> 123
      //   100: aload_0
      //   101: monitorenter
      //   102: aload_0
      //   103: getfield sources : Ljava/util/Queue;
      //   106: invokeinterface size : ()I
      //   111: istore #7
      //   113: aload_0
      //   114: monitorexit
      //   115: goto -> 126
      //   118: astore_1
      //   119: aload_0
      //   120: monitorexit
      //   121: aload_1
      //   122: athrow
      //   123: iconst_0
      //   124: istore #7
      //   126: iload #5
      //   128: ifeq -> 192
      //   131: aload #4
      //   133: ifnull -> 146
      //   136: aload #4
      //   138: invokeinterface isEmpty : ()Z
      //   143: ifeq -> 192
      //   146: iload #6
      //   148: ifne -> 192
      //   151: iload #7
      //   153: ifne -> 192
      //   156: aload_0
      //   157: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   160: invokevirtual terminate : ()Ljava/lang/Throwable;
      //   163: astore_3
      //   164: aload_3
      //   165: getstatic io/reactivex/internal/util/ExceptionHelper.TERMINATED : Ljava/lang/Throwable;
      //   168: if_acmpeq -> 191
      //   171: aload_3
      //   172: ifnonnull -> 184
      //   175: aload_1
      //   176: invokeinterface onComplete : ()V
      //   181: goto -> 191
      //   184: aload_1
      //   185: aload_3
      //   186: invokeinterface onError : (Ljava/lang/Throwable;)V
      //   191: return
      //   192: iload #6
      //   194: ifeq -> 581
      //   197: aload_0
      //   198: getfield lastId : J
      //   201: lstore #8
      //   203: aload_0
      //   204: getfield lastIndex : I
      //   207: istore #10
      //   209: iload #6
      //   211: iload #10
      //   213: if_icmple -> 233
      //   216: iload #10
      //   218: istore #7
      //   220: aload_3
      //   221: iload #10
      //   223: aaload
      //   224: getfield id : J
      //   227: lload #8
      //   229: lcmp
      //   230: ifeq -> 316
      //   233: iload #10
      //   235: istore #7
      //   237: iload #6
      //   239: iload #10
      //   241: if_icmpgt -> 247
      //   244: iconst_0
      //   245: istore #7
      //   247: iconst_0
      //   248: istore #10
      //   250: iload #10
      //   252: iload #6
      //   254: if_icmpge -> 299
      //   257: aload_3
      //   258: iload #7
      //   260: aaload
      //   261: getfield id : J
      //   264: lload #8
      //   266: lcmp
      //   267: ifne -> 273
      //   270: goto -> 299
      //   273: iload #7
      //   275: iconst_1
      //   276: iadd
      //   277: istore #11
      //   279: iload #11
      //   281: istore #7
      //   283: iload #11
      //   285: iload #6
      //   287: if_icmpne -> 293
      //   290: iconst_0
      //   291: istore #7
      //   293: iinc #10, 1
      //   296: goto -> 250
      //   299: aload_0
      //   300: iload #7
      //   302: putfield lastIndex : I
      //   305: aload_0
      //   306: aload_3
      //   307: iload #7
      //   309: aaload
      //   310: getfield id : J
      //   313: putfield lastId : J
      //   316: iconst_0
      //   317: istore #10
      //   319: iconst_0
      //   320: istore #12
      //   322: iload #7
      //   324: istore #11
      //   326: iload #12
      //   328: istore #7
      //   330: iload #10
      //   332: iload #6
      //   334: if_icmpge -> 561
      //   337: aload_0
      //   338: invokevirtual checkTerminate : ()Z
      //   341: ifeq -> 345
      //   344: return
      //   345: aload_3
      //   346: iload #11
      //   348: aaload
      //   349: astore #4
      //   351: aload_0
      //   352: invokevirtual checkTerminate : ()Z
      //   355: ifeq -> 359
      //   358: return
      //   359: aload #4
      //   361: getfield queue : Lio/reactivex/internal/fuseable/SimpleQueue;
      //   364: astore #13
      //   366: aload #13
      //   368: ifnonnull -> 374
      //   371: goto -> 393
      //   374: aload #13
      //   376: invokeinterface poll : ()Ljava/lang/Object;
      //   381: astore #14
      //   383: aload #14
      //   385: ifnonnull -> 491
      //   388: aload #14
      //   390: ifnonnull -> 351
      //   393: aload #4
      //   395: getfield done : Z
      //   398: istore #5
      //   400: aload #4
      //   402: getfield queue : Lio/reactivex/internal/fuseable/SimpleQueue;
      //   405: astore #14
      //   407: iload #7
      //   409: istore #12
      //   411: iload #5
      //   413: ifeq -> 452
      //   416: aload #14
      //   418: ifnull -> 435
      //   421: iload #7
      //   423: istore #12
      //   425: aload #14
      //   427: invokeinterface isEmpty : ()Z
      //   432: ifeq -> 452
      //   435: aload_0
      //   436: aload #4
      //   438: invokevirtual removeInner : (Lio/reactivex/internal/operators/observable/ObservableFlatMap$InnerObserver;)V
      //   441: aload_0
      //   442: invokevirtual checkTerminate : ()Z
      //   445: ifeq -> 449
      //   448: return
      //   449: iconst_1
      //   450: istore #12
      //   452: iload #11
      //   454: iconst_1
      //   455: iadd
      //   456: istore #15
      //   458: iload #10
      //   460: istore #16
      //   462: iload #12
      //   464: istore #7
      //   466: iload #15
      //   468: istore #11
      //   470: iload #15
      //   472: iload #6
      //   474: if_icmpne -> 552
      //   477: iconst_0
      //   478: istore #11
      //   480: iload #10
      //   482: istore #16
      //   484: iload #12
      //   486: istore #7
      //   488: goto -> 552
      //   491: aload_1
      //   492: aload #14
      //   494: invokeinterface onNext : (Ljava/lang/Object;)V
      //   499: aload_0
      //   500: invokevirtual checkTerminate : ()Z
      //   503: ifeq -> 374
      //   506: return
      //   507: astore #14
      //   509: aload #14
      //   511: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   514: aload #4
      //   516: invokevirtual dispose : ()V
      //   519: aload_0
      //   520: getfield errors : Lio/reactivex/internal/util/AtomicThrowable;
      //   523: aload #14
      //   525: invokevirtual addThrowable : (Ljava/lang/Throwable;)Z
      //   528: pop
      //   529: aload_0
      //   530: invokevirtual checkTerminate : ()Z
      //   533: ifeq -> 537
      //   536: return
      //   537: aload_0
      //   538: aload #4
      //   540: invokevirtual removeInner : (Lio/reactivex/internal/operators/observable/ObservableFlatMap$InnerObserver;)V
      //   543: iload #10
      //   545: iconst_1
      //   546: iadd
      //   547: istore #16
      //   549: iconst_1
      //   550: istore #7
      //   552: iload #16
      //   554: iconst_1
      //   555: iadd
      //   556: istore #10
      //   558: goto -> 330
      //   561: aload_0
      //   562: iload #11
      //   564: putfield lastIndex : I
      //   567: aload_0
      //   568: aload_3
      //   569: iload #11
      //   571: aaload
      //   572: getfield id : J
      //   575: putfield lastId : J
      //   578: goto -> 584
      //   581: iconst_0
      //   582: istore #7
      //   584: iload #7
      //   586: ifeq -> 647
      //   589: aload_0
      //   590: getfield maxConcurrency : I
      //   593: ldc 2147483647
      //   595: if_icmpeq -> 7
      //   598: aload_0
      //   599: monitorenter
      //   600: aload_0
      //   601: getfield sources : Ljava/util/Queue;
      //   604: invokeinterface poll : ()Ljava/lang/Object;
      //   609: checkcast io/reactivex/ObservableSource
      //   612: astore_3
      //   613: aload_3
      //   614: ifnonnull -> 632
      //   617: aload_0
      //   618: aload_0
      //   619: getfield wip : I
      //   622: iconst_1
      //   623: isub
      //   624: putfield wip : I
      //   627: aload_0
      //   628: monitorexit
      //   629: goto -> 7
      //   632: aload_0
      //   633: monitorexit
      //   634: aload_0
      //   635: aload_3
      //   636: invokevirtual subscribeInner : (Lio/reactivex/ObservableSource;)V
      //   639: goto -> 7
      //   642: astore_1
      //   643: aload_0
      //   644: monitorexit
      //   645: aload_1
      //   646: athrow
      //   647: aload_0
      //   648: iload_2
      //   649: ineg
      //   650: invokevirtual addAndGet : (I)I
      //   653: istore #7
      //   655: iload #7
      //   657: istore_2
      //   658: iload #7
      //   660: ifne -> 7
      //   663: return
      // Exception table:
      //   from	to	target	type
      //   102	115	118	finally
      //   119	121	118	finally
      //   374	383	507	java/lang/Throwable
      //   600	613	642	finally
      //   617	629	642	finally
      //   632	634	642	finally
      //   643	645	642	finally
    }
    
    public boolean isDisposed() {
      return this.cancelled;
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
      if (this.errors.addThrowable(param1Throwable)) {
        this.done = true;
        drain();
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      // Byte code:
      //   0: aload_0
      //   1: getfield done : Z
      //   4: ifeq -> 8
      //   7: return
      //   8: aload_0
      //   9: getfield mapper : Lio/reactivex/functions/Function;
      //   12: aload_1
      //   13: invokeinterface apply : (Ljava/lang/Object;)Ljava/lang/Object;
      //   18: ldc 'The mapper returned a null ObservableSource'
      //   20: invokestatic requireNonNull : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
      //   23: checkcast io/reactivex/ObservableSource
      //   26: astore_1
      //   27: aload_0
      //   28: getfield maxConcurrency : I
      //   31: ldc 2147483647
      //   33: if_icmpeq -> 83
      //   36: aload_0
      //   37: monitorenter
      //   38: aload_0
      //   39: getfield wip : I
      //   42: aload_0
      //   43: getfield maxConcurrency : I
      //   46: if_icmpne -> 63
      //   49: aload_0
      //   50: getfield sources : Ljava/util/Queue;
      //   53: aload_1
      //   54: invokeinterface offer : (Ljava/lang/Object;)Z
      //   59: pop
      //   60: aload_0
      //   61: monitorexit
      //   62: return
      //   63: aload_0
      //   64: aload_0
      //   65: getfield wip : I
      //   68: iconst_1
      //   69: iadd
      //   70: putfield wip : I
      //   73: aload_0
      //   74: monitorexit
      //   75: goto -> 83
      //   78: astore_1
      //   79: aload_0
      //   80: monitorexit
      //   81: aload_1
      //   82: athrow
      //   83: aload_0
      //   84: aload_1
      //   85: invokevirtual subscribeInner : (Lio/reactivex/ObservableSource;)V
      //   88: return
      //   89: astore_1
      //   90: aload_1
      //   91: invokestatic throwIfFatal : (Ljava/lang/Throwable;)V
      //   94: aload_0
      //   95: getfield s : Lio/reactivex/disposables/Disposable;
      //   98: invokeinterface dispose : ()V
      //   103: aload_0
      //   104: aload_1
      //   105: invokevirtual onError : (Ljava/lang/Throwable;)V
      //   108: return
      // Exception table:
      //   from	to	target	type
      //   8	27	89	java/lang/Throwable
      //   38	62	78	finally
      //   63	75	78	finally
      //   79	81	78	finally
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.s, param1Disposable)) {
        this.s = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
    
    void removeInner(ObservableFlatMap.InnerObserver<T, U> param1InnerObserver) {
      ObservableFlatMap.InnerObserver[] arrayOfInnerObserver1;
      ObservableFlatMap.InnerObserver[] arrayOfInnerObserver2;
      do {
        byte b2;
        arrayOfInnerObserver1 = (ObservableFlatMap.InnerObserver[])this.observers.get();
        int i = arrayOfInnerObserver1.length;
        if (i == 0)
          return; 
        byte b1 = -1;
        byte b = 0;
        while (true) {
          b2 = b1;
          if (b < i) {
            if (arrayOfInnerObserver1[b] == param1InnerObserver) {
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
          ObservableFlatMap.InnerObserver<?, ?>[] arrayOfInnerObserver = EMPTY;
        } else {
          arrayOfInnerObserver2 = new ObservableFlatMap.InnerObserver[i - 1];
          System.arraycopy(arrayOfInnerObserver1, 0, arrayOfInnerObserver2, 0, b2);
          System.arraycopy(arrayOfInnerObserver1, b2 + 1, arrayOfInnerObserver2, b2, i - b2 - 1);
        } 
      } while (!this.observers.compareAndSet(arrayOfInnerObserver1, arrayOfInnerObserver2));
    }
    
    void subscribeInner(ObservableSource<? extends U> param1ObservableSource) {
      // Byte code:
      //   0: aload_1
      //   1: instanceof java/util/concurrent/Callable
      //   4: ifeq -> 81
      //   7: aload_0
      //   8: aload_1
      //   9: checkcast java/util/concurrent/Callable
      //   12: invokevirtual tryEmitScalar : (Ljava/util/concurrent/Callable;)Z
      //   15: ifeq -> 121
      //   18: aload_0
      //   19: getfield maxConcurrency : I
      //   22: ldc 2147483647
      //   24: if_icmpeq -> 121
      //   27: iconst_0
      //   28: istore_2
      //   29: aload_0
      //   30: monitorenter
      //   31: aload_0
      //   32: getfield sources : Ljava/util/Queue;
      //   35: invokeinterface poll : ()Ljava/lang/Object;
      //   40: checkcast io/reactivex/ObservableSource
      //   43: astore_1
      //   44: aload_1
      //   45: ifnonnull -> 60
      //   48: aload_0
      //   49: aload_0
      //   50: getfield wip : I
      //   53: iconst_1
      //   54: isub
      //   55: putfield wip : I
      //   58: iconst_1
      //   59: istore_2
      //   60: aload_0
      //   61: monitorexit
      //   62: iload_2
      //   63: ifeq -> 73
      //   66: aload_0
      //   67: invokevirtual drain : ()V
      //   70: goto -> 121
      //   73: goto -> 0
      //   76: astore_1
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      //   81: aload_0
      //   82: getfield uniqueId : J
      //   85: lstore_3
      //   86: aload_0
      //   87: lconst_1
      //   88: lload_3
      //   89: ladd
      //   90: putfield uniqueId : J
      //   93: new io/reactivex/internal/operators/observable/ObservableFlatMap$InnerObserver
      //   96: dup
      //   97: aload_0
      //   98: lload_3
      //   99: invokespecial <init> : (Lio/reactivex/internal/operators/observable/ObservableFlatMap$MergeObserver;J)V
      //   102: astore #5
      //   104: aload_0
      //   105: aload #5
      //   107: invokevirtual addInner : (Lio/reactivex/internal/operators/observable/ObservableFlatMap$InnerObserver;)Z
      //   110: ifeq -> 121
      //   113: aload_1
      //   114: aload #5
      //   116: invokeinterface subscribe : (Lio/reactivex/Observer;)V
      //   121: return
      // Exception table:
      //   from	to	target	type
      //   31	44	76	finally
      //   48	58	76	finally
      //   60	62	76	finally
      //   77	79	76	finally
    }
    
    void tryEmit(U param1U, ObservableFlatMap.InnerObserver<T, U> param1InnerObserver) {
      if (get() == 0 && compareAndSet(0, 1)) {
        this.actual.onNext(param1U);
        if (decrementAndGet() == 0)
          return; 
      } else {
        SpscLinkedArrayQueue spscLinkedArrayQueue;
        SimpleQueue<U> simpleQueue1 = param1InnerObserver.queue;
        SimpleQueue<U> simpleQueue2 = simpleQueue1;
        if (simpleQueue1 == null) {
          spscLinkedArrayQueue = new SpscLinkedArrayQueue(this.bufferSize);
          param1InnerObserver.queue = (SimpleQueue<U>)spscLinkedArrayQueue;
        } 
        spscLinkedArrayQueue.offer(param1U);
        if (getAndIncrement() != 0)
          return; 
      } 
      drainLoop();
    }
    
    boolean tryEmitScalar(Callable<? extends U> param1Callable) {
      try {
        U u = param1Callable.call();
        if (u == null)
          return true; 
        if (get() == 0 && compareAndSet(0, 1)) {
          this.actual.onNext(u);
          if (decrementAndGet() == 0)
            return true; 
        } else {
          SpscArrayQueue spscArrayQueue;
          SimplePlainQueue<U> simplePlainQueue2 = this.queue;
          SimplePlainQueue<U> simplePlainQueue1 = simplePlainQueue2;
          if (simplePlainQueue2 == null) {
            int i = this.maxConcurrency;
            if (i == Integer.MAX_VALUE) {
              SpscLinkedArrayQueue spscLinkedArrayQueue = new SpscLinkedArrayQueue(this.bufferSize);
            } else {
              spscArrayQueue = new SpscArrayQueue(i);
            } 
            this.queue = (SimplePlainQueue<U>)spscArrayQueue;
          } 
          if (!spscArrayQueue.offer(u)) {
            onError(new IllegalStateException("Scalar queue full?!"));
            return true;
          } 
          if (getAndIncrement() != 0)
            return false; 
        } 
        drainLoop();
        return true;
      } catch (Throwable throwable) {
        Exceptions.throwIfFatal(throwable);
        this.errors.addThrowable(throwable);
        drain();
        return true;
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableFlatMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */