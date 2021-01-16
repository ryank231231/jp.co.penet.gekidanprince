package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableRefCount<T> extends Observable<T> {
  RefConnection connection;
  
  final int n;
  
  final Scheduler scheduler;
  
  final ConnectableObservable<T> source;
  
  final long timeout;
  
  final TimeUnit unit;
  
  public ObservableRefCount(ConnectableObservable<T> paramConnectableObservable) {
    this(paramConnectableObservable, 1, 0L, TimeUnit.NANOSECONDS, Schedulers.trampoline());
  }
  
  public ObservableRefCount(ConnectableObservable<T> paramConnectableObservable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {
    this.source = paramConnectableObservable;
    this.n = paramInt;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  void cancel(RefConnection paramRefConnection) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   6: ifnonnull -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_1
    //   13: getfield subscriberCount : J
    //   16: lconst_1
    //   17: lsub
    //   18: lstore_2
    //   19: aload_1
    //   20: lload_2
    //   21: putfield subscriberCount : J
    //   24: lload_2
    //   25: lconst_0
    //   26: lcmp
    //   27: ifne -> 98
    //   30: aload_1
    //   31: getfield connected : Z
    //   34: ifne -> 40
    //   37: goto -> 98
    //   40: aload_0
    //   41: getfield timeout : J
    //   44: lconst_0
    //   45: lcmp
    //   46: ifne -> 57
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual timeout : (Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: new io/reactivex/internal/disposables/SequentialDisposable
    //   60: astore #4
    //   62: aload #4
    //   64: invokespecial <init> : ()V
    //   67: aload_1
    //   68: aload #4
    //   70: putfield timer : Lio/reactivex/disposables/Disposable;
    //   73: aload_0
    //   74: monitorexit
    //   75: aload #4
    //   77: aload_0
    //   78: getfield scheduler : Lio/reactivex/Scheduler;
    //   81: aload_1
    //   82: aload_0
    //   83: getfield timeout : J
    //   86: aload_0
    //   87: getfield unit : Ljava/util/concurrent/TimeUnit;
    //   90: invokevirtual scheduleDirect : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;
    //   93: invokevirtual replace : (Lio/reactivex/disposables/Disposable;)Z
    //   96: pop
    //   97: return
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	101	finally
    //   12	24	101	finally
    //   30	37	101	finally
    //   40	56	101	finally
    //   57	75	101	finally
    //   98	100	101	finally
    //   102	104	101	finally
  }
  
  protected void subscribeActual(Observer<? super T> paramObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: aload_2
    //   10: ifnonnull -> 27
    //   13: new io/reactivex/internal/operators/observable/ObservableRefCount$RefConnection
    //   16: astore_3
    //   17: aload_3
    //   18: aload_0
    //   19: invokespecial <init> : (Lio/reactivex/internal/operators/observable/ObservableRefCount;)V
    //   22: aload_0
    //   23: aload_3
    //   24: putfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   27: aload_3
    //   28: getfield subscriberCount : J
    //   31: lstore #4
    //   33: lload #4
    //   35: lconst_0
    //   36: lcmp
    //   37: ifne -> 56
    //   40: aload_3
    //   41: getfield timer : Lio/reactivex/disposables/Disposable;
    //   44: ifnull -> 56
    //   47: aload_3
    //   48: getfield timer : Lio/reactivex/disposables/Disposable;
    //   51: invokeinterface dispose : ()V
    //   56: lload #4
    //   58: lconst_1
    //   59: ladd
    //   60: lstore #4
    //   62: aload_3
    //   63: lload #4
    //   65: putfield subscriberCount : J
    //   68: aload_3
    //   69: getfield connected : Z
    //   72: istore #6
    //   74: iconst_1
    //   75: istore #7
    //   77: iload #6
    //   79: ifne -> 101
    //   82: lload #4
    //   84: aload_0
    //   85: getfield n : I
    //   88: i2l
    //   89: lcmp
    //   90: ifne -> 101
    //   93: aload_3
    //   94: iconst_1
    //   95: putfield connected : Z
    //   98: goto -> 104
    //   101: iconst_0
    //   102: istore #7
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_0
    //   107: getfield source : Lio/reactivex/observables/ConnectableObservable;
    //   110: new io/reactivex/internal/operators/observable/ObservableRefCount$RefCountObserver
    //   113: dup
    //   114: aload_1
    //   115: aload_0
    //   116: aload_3
    //   117: invokespecial <init> : (Lio/reactivex/Observer;Lio/reactivex/internal/operators/observable/ObservableRefCount;Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;)V
    //   120: invokevirtual subscribe : (Lio/reactivex/Observer;)V
    //   123: iload #7
    //   125: ifeq -> 136
    //   128: aload_0
    //   129: getfield source : Lio/reactivex/observables/ConnectableObservable;
    //   132: aload_3
    //   133: invokevirtual connect : (Lio/reactivex/functions/Consumer;)V
    //   136: return
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	137	finally
    //   13	27	137	finally
    //   27	33	137	finally
    //   40	56	137	finally
    //   62	74	137	finally
    //   82	98	137	finally
    //   104	106	137	finally
    //   138	140	137	finally
  }
  
  void terminated(RefConnection paramRefConnection) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   6: ifnull -> 52
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   14: aload_1
    //   15: getfield timer : Lio/reactivex/disposables/Disposable;
    //   18: ifnull -> 30
    //   21: aload_1
    //   22: getfield timer : Lio/reactivex/disposables/Disposable;
    //   25: invokeinterface dispose : ()V
    //   30: aload_0
    //   31: getfield source : Lio/reactivex/observables/ConnectableObservable;
    //   34: instanceof io/reactivex/disposables/Disposable
    //   37: ifeq -> 52
    //   40: aload_0
    //   41: getfield source : Lio/reactivex/observables/ConnectableObservable;
    //   44: checkcast io/reactivex/disposables/Disposable
    //   47: invokeinterface dispose : ()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	55	finally
    //   30	52	55	finally
    //   52	54	55	finally
    //   56	58	55	finally
  }
  
  void timeout(RefConnection paramRefConnection) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield subscriberCount : J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne -> 51
    //   11: aload_1
    //   12: aload_0
    //   13: getfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   16: if_acmpne -> 51
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield connection : Lio/reactivex/internal/operators/observable/ObservableRefCount$RefConnection;
    //   24: aload_1
    //   25: invokestatic dispose : (Ljava/util/concurrent/atomic/AtomicReference;)Z
    //   28: pop
    //   29: aload_0
    //   30: getfield source : Lio/reactivex/observables/ConnectableObservable;
    //   33: instanceof io/reactivex/disposables/Disposable
    //   36: ifeq -> 51
    //   39: aload_0
    //   40: getfield source : Lio/reactivex/observables/ConnectableObservable;
    //   43: checkcast io/reactivex/disposables/Disposable
    //   46: invokeinterface dispose : ()V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	54	finally
    //   51	53	54	finally
    //   55	57	54	finally
  }
  
  static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
    private static final long serialVersionUID = -4552101107598366241L;
    
    boolean connected;
    
    final ObservableRefCount<?> parent;
    
    long subscriberCount;
    
    Disposable timer;
    
    RefConnection(ObservableRefCount<?> param1ObservableRefCount) {
      this.parent = param1ObservableRefCount;
    }
    
    public void accept(Disposable param1Disposable) throws Exception {
      DisposableHelper.replace(this, param1Disposable);
    }
    
    public void run() {
      this.parent.timeout(this);
    }
  }
  
  static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
    private static final long serialVersionUID = -7419642935409022375L;
    
    final Observer<? super T> actual;
    
    final ObservableRefCount.RefConnection connection;
    
    final ObservableRefCount<T> parent;
    
    Disposable upstream;
    
    RefCountObserver(Observer<? super T> param1Observer, ObservableRefCount<T> param1ObservableRefCount, ObservableRefCount.RefConnection param1RefConnection) {
      this.actual = param1Observer;
      this.parent = param1ObservableRefCount;
      this.connection = param1RefConnection;
    }
    
    public void dispose() {
      this.upstream.dispose();
      if (compareAndSet(false, true))
        this.parent.cancel(this.connection); 
    }
    
    public boolean isDisposed() {
      return this.upstream.isDisposed();
    }
    
    public void onComplete() {
      if (compareAndSet(false, true)) {
        this.parent.terminated(this.connection);
        this.actual.onComplete();
      } 
    }
    
    public void onError(Throwable param1Throwable) {
      if (compareAndSet(false, true)) {
        this.parent.terminated(this.connection);
        this.actual.onError(param1Throwable);
      } else {
        RxJavaPlugins.onError(param1Throwable);
      } 
    }
    
    public void onNext(T param1T) {
      this.actual.onNext(param1T);
    }
    
    public void onSubscribe(Disposable param1Disposable) {
      if (DisposableHelper.validate(this.upstream, param1Disposable)) {
        this.upstream = param1Disposable;
        this.actual.onSubscribe(this);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableRefCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */