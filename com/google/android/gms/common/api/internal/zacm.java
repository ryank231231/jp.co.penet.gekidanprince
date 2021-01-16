package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zacm<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
  private final Object zadn;
  
  private final WeakReference<GoogleApiClient> zadp;
  
  private ResultTransform<? super R, ? extends Result> zakn;
  
  private zacm<? extends Result> zako;
  
  private volatile ResultCallbacks<? super R> zakp;
  
  private PendingResult<R> zakq;
  
  private Status zakr;
  
  private final zaco zaks;
  
  private boolean zakt;
  
  public zacm(WeakReference<GoogleApiClient> paramWeakReference) {
    Looper looper;
    this.zakn = null;
    this.zako = null;
    this.zakp = null;
    this.zakq = null;
    this.zadn = new Object();
    this.zakr = null;
    this.zakt = false;
    Preconditions.checkNotNull(paramWeakReference, "GoogleApiClient reference must not be null");
    this.zadp = paramWeakReference;
    GoogleApiClient googleApiClient = this.zadp.get();
    if (googleApiClient != null) {
      looper = googleApiClient.getLooper();
    } else {
      looper = Looper.getMainLooper();
    } 
    this.zaks = new zaco(this, looper);
  }
  
  private static void zab(Result paramResult) {
    if (paramResult instanceof Releasable)
      try {
        ((Releasable)paramResult).release();
        return;
      } catch (RuntimeException runtimeException) {
        String str = String.valueOf(paramResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 18);
        stringBuilder.append("Unable to release ");
        stringBuilder.append(str);
        Log.w("TransformedResultImpl", stringBuilder.toString(), runtimeException);
      }  
  }
  
  @GuardedBy("mSyncToken")
  private final void zabu() {
    if (this.zakn == null && this.zakp == null)
      return; 
    GoogleApiClient googleApiClient = this.zadp.get();
    if (!this.zakt && this.zakn != null && googleApiClient != null) {
      googleApiClient.zaa(this);
      this.zakt = true;
    } 
    Status status = this.zakr;
    if (status != null) {
      zae(status);
      return;
    } 
    PendingResult<R> pendingResult = this.zakq;
    if (pendingResult != null)
      pendingResult.setResultCallback(this); 
  }
  
  @GuardedBy("mSyncToken")
  private final boolean zabw() {
    GoogleApiClient googleApiClient = this.zadp.get();
    return (this.zakp != null && googleApiClient != null);
  }
  
  private final void zad(Status paramStatus) {
    synchronized (this.zadn) {
      this.zakr = paramStatus;
      zae(this.zakr);
      return;
    } 
  }
  
  private final void zae(Status paramStatus) {
    synchronized (this.zadn) {
      if (this.zakn != null) {
        paramStatus = this.zakn.onFailure(paramStatus);
        Preconditions.checkNotNull(paramStatus, "onFailure must not return null");
        this.zako.zad(paramStatus);
      } else if (zabw()) {
        this.zakp.onFailure(paramStatus);
      } 
      return;
    } 
  }
  
  public final void andFinally(@NonNull ResultCallbacks<? super R> paramResultCallbacks) {
    synchronized (this.zadn) {
      boolean bool2;
      ResultCallbacks<? super R> resultCallbacks = this.zakp;
      boolean bool1 = true;
      if (resultCallbacks == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "Cannot call andFinally() twice.");
      if (this.zakn == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "Cannot call then() and andFinally() on the same TransformedResult.");
      this.zakp = paramResultCallbacks;
      zabu();
      return;
    } 
  }
  
  public final void onResult(R paramR) {
    synchronized (this.zadn) {
      if (paramR.getStatus().isSuccess()) {
        if (this.zakn != null) {
          ExecutorService executorService = zacc.zabb();
          zacn zacn = new zacn();
          this(this, (Result)paramR);
          executorService.submit(zacn);
        } else if (zabw()) {
          this.zakp.onSuccess((Result)paramR);
        } 
      } else {
        zad(paramR.getStatus());
        zab((Result)paramR);
      } 
      return;
    } 
  }
  
  @NonNull
  public final <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> paramResultTransform) {
    synchronized (this.zadn) {
      boolean bool2;
      ResultTransform<? super R, ? extends Result> resultTransform = this.zakn;
      boolean bool1 = true;
      if (resultTransform == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "Cannot call then() twice.");
      if (this.zakp == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "Cannot call then() and andFinally() on the same TransformedResult.");
      this.zakn = paramResultTransform;
      zacm<? extends Result> zacm1 = new zacm();
      this(this.zadp);
      this.zako = zacm1;
      zabu();
      return (TransformedResult)zacm1;
    } 
  }
  
  public final void zaa(PendingResult<?> paramPendingResult) {
    synchronized (this.zadn) {
      this.zakq = (PendingResult)paramPendingResult;
      zabu();
      return;
    } 
  }
  
  final void zabv() {
    this.zakp = null;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zacm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */