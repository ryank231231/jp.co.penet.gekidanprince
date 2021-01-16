package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
  static final ThreadLocal<Boolean> zadm = new zap();
  
  @KeepName
  private zaa mResultGuardian;
  
  private Status mStatus;
  
  private R zaci;
  
  private final Object zadn;
  
  private final CallbackHandler<R> zado;
  
  private final WeakReference<GoogleApiClient> zadp;
  
  private final CountDownLatch zadq;
  
  private final ArrayList<PendingResult.StatusListener> zadr;
  
  private ResultCallback<? super R> zads;
  
  private final AtomicReference<zacs> zadt;
  
  private volatile boolean zadu;
  
  private boolean zadv;
  
  private boolean zadw;
  
  private ICancelToken zadx;
  
  private volatile zacm<R> zady;
  
  private boolean zadz;
  
  @Deprecated
  BasePendingResult() {
    this.zadn = new Object();
    this.zadq = new CountDownLatch(1);
    this.zadr = new ArrayList<PendingResult.StatusListener>();
    this.zadt = new AtomicReference<zacs>();
    this.zadz = false;
    this.zado = new CallbackHandler<R>(Looper.getMainLooper());
    this.zadp = new WeakReference<GoogleApiClient>(null);
  }
  
  @Deprecated
  @KeepForSdk
  protected BasePendingResult(Looper paramLooper) {
    this.zadn = new Object();
    this.zadq = new CountDownLatch(1);
    this.zadr = new ArrayList<PendingResult.StatusListener>();
    this.zadt = new AtomicReference<zacs>();
    this.zadz = false;
    this.zado = new CallbackHandler<R>(paramLooper);
    this.zadp = new WeakReference<GoogleApiClient>(null);
  }
  
  @KeepForSdk
  protected BasePendingResult(GoogleApiClient paramGoogleApiClient) {
    Looper looper;
    this.zadn = new Object();
    this.zadq = new CountDownLatch(1);
    this.zadr = new ArrayList<PendingResult.StatusListener>();
    this.zadt = new AtomicReference<zacs>();
    this.zadz = false;
    if (paramGoogleApiClient != null) {
      looper = paramGoogleApiClient.getLooper();
    } else {
      looper = Looper.getMainLooper();
    } 
    this.zado = new CallbackHandler<R>(looper);
    this.zadp = new WeakReference<GoogleApiClient>(paramGoogleApiClient);
  }
  
  @KeepForSdk
  @VisibleForTesting
  protected BasePendingResult(@NonNull CallbackHandler<R> paramCallbackHandler) {
    this.zadn = new Object();
    this.zadq = new CountDownLatch(1);
    this.zadr = new ArrayList<PendingResult.StatusListener>();
    this.zadt = new AtomicReference<zacs>();
    this.zadz = false;
    this.zado = (CallbackHandler<R>)Preconditions.checkNotNull(paramCallbackHandler, "CallbackHandler must not be null");
    this.zadp = new WeakReference<GoogleApiClient>(null);
  }
  
  private final R get() {
    synchronized (this.zadn) {
      boolean bool;
      if (!this.zadu) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Result has already been consumed.");
      Preconditions.checkState(isReady(), "Result is not ready.");
      R r = this.zaci;
      this.zaci = null;
      this.zads = null;
      this.zadu = true;
      null = this.zadt.getAndSet(null);
      if (null != null)
        null.zac(this); 
      return r;
    } 
  }
  
  private final void zaa(R paramR) {
    this.zaci = paramR;
    this.zadx = null;
    this.zadq.countDown();
    this.mStatus = this.zaci.getStatus();
    if (this.zadv) {
      this.zads = null;
    } else if (this.zads == null) {
      if (this.zaci instanceof Releasable)
        this.mResultGuardian = new zaa(null); 
    } else {
      this.zado.removeMessages(2);
      this.zado.zaa(this.zads, get());
    } 
    ArrayList<PendingResult.StatusListener> arrayList = this.zadr;
    int i = arrayList.size();
    byte b = 0;
    while (b < i) {
      PendingResult.StatusListener statusListener = (PendingResult.StatusListener)arrayList.get(b);
      b++;
      ((PendingResult.StatusListener)statusListener).onComplete(this.mStatus);
    } 
    this.zadr.clear();
  }
  
  public static void zab(Result paramResult) {
    if (paramResult instanceof Releasable)
      try {
        ((Releasable)paramResult).release();
        return;
      } catch (RuntimeException runtimeException) {
        String str = String.valueOf(paramResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 18);
        stringBuilder.append("Unable to release ");
        stringBuilder.append(str);
        Log.w("BasePendingResult", stringBuilder.toString(), runtimeException);
      }  
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener) {
    boolean bool;
    if (paramStatusListener != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Callback cannot be null.");
    synchronized (this.zadn) {
      if (isReady()) {
        paramStatusListener.onComplete(this.mStatus);
      } else {
        this.zadr.add(paramStatusListener);
      } 
      return;
    } 
  }
  
  public final R await() {
    Preconditions.checkNotMainThread("await must not be called on the UI thread");
    boolean bool = this.zadu;
    boolean bool1 = true;
    Preconditions.checkState(bool ^ true, "Result has already been consumed");
    if (this.zady != null)
      bool1 = false; 
    Preconditions.checkState(bool1, "Cannot await if then() has been called.");
    try {
      this.zadq.await();
    } catch (InterruptedException interruptedException) {
      zab(Status.RESULT_INTERRUPTED);
    } 
    Preconditions.checkState(isReady(), "Result is not ready.");
    return get();
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit) {
    if (paramLong > 0L)
      Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero."); 
    boolean bool = this.zadu;
    boolean bool1 = true;
    Preconditions.checkState(bool ^ true, "Result has already been consumed.");
    if (this.zady != null)
      bool1 = false; 
    Preconditions.checkState(bool1, "Cannot await if then() has been called.");
    try {
      if (!this.zadq.await(paramLong, paramTimeUnit))
        zab(Status.RESULT_TIMEOUT); 
    } catch (InterruptedException interruptedException) {
      zab(Status.RESULT_INTERRUPTED);
    } 
    Preconditions.checkState(isReady(), "Result is not ready.");
    return get();
  }
  
  @KeepForSdk
  public void cancel() {
    synchronized (this.zadn) {
      if (this.zadv || this.zadu)
        return; 
      ICancelToken iCancelToken = this.zadx;
      if (iCancelToken != null)
        try {
          this.zadx.cancel();
        } catch (RemoteException remoteException) {} 
      zab((Result)this.zaci);
      this.zadv = true;
      zaa(createFailedResult(Status.RESULT_CANCELED));
      return;
    } 
  }
  
  @NonNull
  @KeepForSdk
  protected abstract R createFailedResult(Status paramStatus);
  
  public boolean isCanceled() {
    synchronized (this.zadn) {
      return this.zadv;
    } 
  }
  
  @KeepForSdk
  public final boolean isReady() {
    return (this.zadq.getCount() == 0L);
  }
  
  @KeepForSdk
  protected final void setCancelToken(ICancelToken paramICancelToken) {
    synchronized (this.zadn) {
      this.zadx = paramICancelToken;
      return;
    } 
  }
  
  @KeepForSdk
  public final void setResult(R paramR) {
    synchronized (this.zadn) {
      if (!this.zadw && !this.zadv) {
        isReady();
        boolean bool = isReady();
        boolean bool1 = true;
        if (!bool) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "Results have already been set");
        if (!this.zadu) {
          bool = bool1;
        } else {
          bool = false;
        } 
        Preconditions.checkState(bool, "Result has already been consumed");
        zaa(paramR);
        return;
      } 
      zab((Result)paramR);
      return;
    } 
  }
  
  @KeepForSdk
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zadn : Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull -> 19
    //   11: aload_0
    //   12: aconst_null
    //   13: putfield zads : Lcom/google/android/gms/common/api/ResultCallback;
    //   16: aload_2
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield zadu : Z
    //   23: istore_3
    //   24: iconst_1
    //   25: istore #4
    //   27: iload_3
    //   28: ifne -> 36
    //   31: iconst_1
    //   32: istore_3
    //   33: goto -> 38
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ldc 'Result has already been consumed.'
    //   41: invokestatic checkState : (ZLjava/lang/Object;)V
    //   44: aload_0
    //   45: getfield zady : Lcom/google/android/gms/common/api/internal/zacm;
    //   48: ifnonnull -> 57
    //   51: iload #4
    //   53: istore_3
    //   54: goto -> 59
    //   57: iconst_0
    //   58: istore_3
    //   59: iload_3
    //   60: ldc_w 'Cannot set callbacks if then() has been called.'
    //   63: invokestatic checkState : (ZLjava/lang/Object;)V
    //   66: aload_0
    //   67: invokevirtual isCanceled : ()Z
    //   70: ifeq -> 76
    //   73: aload_2
    //   74: monitorexit
    //   75: return
    //   76: aload_0
    //   77: invokevirtual isReady : ()Z
    //   80: ifeq -> 98
    //   83: aload_0
    //   84: getfield zado : Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler;
    //   87: aload_1
    //   88: aload_0
    //   89: invokespecial get : ()Lcom/google/android/gms/common/api/Result;
    //   92: invokevirtual zaa : (Lcom/google/android/gms/common/api/ResultCallback;Lcom/google/android/gms/common/api/Result;)V
    //   95: goto -> 103
    //   98: aload_0
    //   99: aload_1
    //   100: putfield zads : Lcom/google/android/gms/common/api/ResultCallback;
    //   103: aload_2
    //   104: monitorexit
    //   105: return
    //   106: astore_1
    //   107: aload_2
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Exception table:
    //   from	to	target	type
    //   11	18	106	finally
    //   19	24	106	finally
    //   38	51	106	finally
    //   59	75	106	finally
    //   76	95	106	finally
    //   98	103	106	finally
    //   103	105	106	finally
    //   107	109	106	finally
  }
  
  @KeepForSdk
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zadn : Ljava/lang/Object;
    //   4: astore #5
    //   6: aload #5
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull -> 22
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield zads : Lcom/google/android/gms/common/api/ResultCallback;
    //   18: aload #5
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield zadu : Z
    //   26: istore #6
    //   28: iconst_1
    //   29: istore #7
    //   31: iload #6
    //   33: ifne -> 42
    //   36: iconst_1
    //   37: istore #6
    //   39: goto -> 45
    //   42: iconst_0
    //   43: istore #6
    //   45: iload #6
    //   47: ldc 'Result has already been consumed.'
    //   49: invokestatic checkState : (ZLjava/lang/Object;)V
    //   52: aload_0
    //   53: getfield zady : Lcom/google/android/gms/common/api/internal/zacm;
    //   56: ifnonnull -> 66
    //   59: iload #7
    //   61: istore #6
    //   63: goto -> 69
    //   66: iconst_0
    //   67: istore #6
    //   69: iload #6
    //   71: ldc_w 'Cannot set callbacks if then() has been called.'
    //   74: invokestatic checkState : (ZLjava/lang/Object;)V
    //   77: aload_0
    //   78: invokevirtual isCanceled : ()Z
    //   81: ifeq -> 88
    //   84: aload #5
    //   86: monitorexit
    //   87: return
    //   88: aload_0
    //   89: invokevirtual isReady : ()Z
    //   92: ifeq -> 110
    //   95: aload_0
    //   96: getfield zado : Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler;
    //   99: aload_1
    //   100: aload_0
    //   101: invokespecial get : ()Lcom/google/android/gms/common/api/Result;
    //   104: invokevirtual zaa : (Lcom/google/android/gms/common/api/ResultCallback;Lcom/google/android/gms/common/api/Result;)V
    //   107: goto -> 139
    //   110: aload_0
    //   111: aload_1
    //   112: putfield zads : Lcom/google/android/gms/common/api/ResultCallback;
    //   115: aload_0
    //   116: getfield zado : Lcom/google/android/gms/common/api/internal/BasePendingResult$CallbackHandler;
    //   119: astore_1
    //   120: aload #4
    //   122: lload_2
    //   123: invokevirtual toMillis : (J)J
    //   126: lstore_2
    //   127: aload_1
    //   128: aload_1
    //   129: iconst_2
    //   130: aload_0
    //   131: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   134: lload_2
    //   135: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
    //   138: pop
    //   139: aload #5
    //   141: monitorexit
    //   142: return
    //   143: astore_1
    //   144: aload #5
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Exception table:
    //   from	to	target	type
    //   13	21	143	finally
    //   22	28	143	finally
    //   45	59	143	finally
    //   69	87	143	finally
    //   88	107	143	finally
    //   110	139	143	finally
    //   139	142	143	finally
    //   144	147	143	finally
  }
  
  public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform) {
    Preconditions.checkState(this.zadu ^ true, "Result has already been consumed.");
    synchronized (this.zadn) {
      zacm<R> zacm1 = this.zady;
      boolean bool1 = false;
      if (zacm1 == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "Cannot call then() twice.");
      if (this.zads == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "Cannot call then() if callbacks are set.");
      boolean bool2 = bool1;
      if (!this.zadv)
        bool2 = true; 
      Preconditions.checkState(bool2, "Cannot call then() if result was canceled.");
      this.zadz = true;
      zacm1 = new zacm<R>();
      this(this.zadp);
      this.zady = zacm1;
      TransformedResult<S> transformedResult = this.zady.then(paramResultTransform);
      if (isReady()) {
        this.zado.zaa(this.zady, get());
      } else {
        this.zads = this.zady;
      } 
      return transformedResult;
    } 
  }
  
  public final void zaa(zacs paramzacs) {
    this.zadt.set(paramzacs);
  }
  
  public final void zab(Status paramStatus) {
    synchronized (this.zadn) {
      if (!isReady()) {
        setResult(createFailedResult(paramStatus));
        this.zadw = true;
      } 
      return;
    } 
  }
  
  public final Integer zam() {
    return null;
  }
  
  public final boolean zat() {
    synchronized (this.zadn) {
      if ((GoogleApiClient)this.zadp.get() == null || !this.zadz)
        super.cancel(); 
      return super.isCanceled();
    } 
  }
  
  public final void zau() {
    boolean bool;
    if (this.zadz || ((Boolean)zadm.get()).booleanValue()) {
      bool = true;
    } else {
      bool = false;
    } 
    this.zadz = bool;
  }
  
  @VisibleForTesting
  public static class CallbackHandler<R extends Result> extends zal {
    public CallbackHandler() {
      this(Looper.getMainLooper());
    }
    
    public CallbackHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder;
      int i;
      switch (param1Message.what) {
        default:
          i = param1Message.what;
          stringBuilder = new StringBuilder(45);
          stringBuilder.append("Don't know how to handle message: ");
          stringBuilder.append(i);
          Log.wtf("BasePendingResult", stringBuilder.toString(), new Exception());
          return;
        case 2:
          ((BasePendingResult)((Message)stringBuilder).obj).zab(Status.RESULT_TIMEOUT);
          return;
        case 1:
          break;
      } 
      Pair pair = (Pair)((Message)stringBuilder).obj;
      ResultCallback resultCallback = (ResultCallback)pair.first;
      Result result = (Result)pair.second;
      try {
        resultCallback.onResult(result);
        return;
      } catch (RuntimeException runtimeException) {
        BasePendingResult.zab(result);
        throw runtimeException;
      } 
    }
    
    public final void zaa(ResultCallback<? super R> param1ResultCallback, R param1R) {
      sendMessage(obtainMessage(1, new Pair(param1ResultCallback, param1R)));
    }
  }
  
  private final class zaa {
    private zaa(BasePendingResult this$0) {}
    
    protected final void finalize() throws Throwable {
      BasePendingResult.zab(BasePendingResult.zaa(this.zaea));
      super.finalize();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\BasePendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */