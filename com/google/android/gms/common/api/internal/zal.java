package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {
  protected volatile boolean mStarted;
  
  protected final GoogleApiAvailability zacc;
  
  protected final AtomicReference<zam> zade = new AtomicReference<zam>(null);
  
  private final Handler zadf = (Handler)new com.google.android.gms.internal.base.zal(Looper.getMainLooper());
  
  protected zal(LifecycleFragment paramLifecycleFragment) {
    this(paramLifecycleFragment, GoogleApiAvailability.getInstance());
  }
  
  @VisibleForTesting
  private zal(LifecycleFragment paramLifecycleFragment, GoogleApiAvailability paramGoogleApiAvailability) {
    super(paramLifecycleFragment);
    this.zacc = paramGoogleApiAvailability;
  }
  
  private static int zaa(@Nullable zam paramzam) {
    return (paramzam == null) ? -1 : paramzam.zar();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    zam zam1;
    zam zam2 = this.zade.get();
    int i = 1;
    boolean bool = true;
    switch (paramInt1) {
      default:
        paramInt1 = 0;
        zam1 = zam2;
        break;
      case 2:
        i = this.zacc.isGooglePlayServicesAvailable((Context)getActivity());
        if (i == 0) {
          paramInt2 = bool;
        } else {
          paramInt2 = 0;
        } 
        if (zam2 == null)
          return; 
        zam1 = zam2;
        paramInt1 = paramInt2;
        if (zam2.getConnectionResult().getErrorCode() == 18) {
          zam1 = zam2;
          paramInt1 = paramInt2;
          if (i == 18)
            return; 
        } 
        break;
      case 1:
        if (paramInt2 == -1) {
          zam1 = zam2;
          paramInt1 = i;
          break;
        } 
        if (paramInt2 == 0) {
          paramInt1 = 13;
          if (zam1 != null)
            paramInt1 = zam1.getIntExtra("<<ResolutionFailureErrorDetail>>", 13); 
          zam1 = new zam(new ConnectionResult(paramInt1, null), zaa(zam2));
          this.zade.set(zam1);
          paramInt1 = 0;
          break;
        } 
    } 
    if (paramInt1 != 0) {
      zaq();
      return;
    } 
    if (zam1 != null)
      zaa(zam1.getConnectionResult(), zam1.zar()); 
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {
    zaa(new ConnectionResult(13, null), zaa(this.zade.get()));
    zaq();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      AtomicReference<zam> atomicReference = this.zade;
      if (paramBundle.getBoolean("resolving_error", false)) {
        zam zam = new zam(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1));
      } else {
        paramBundle = null;
      } 
      atomicReference.set(paramBundle);
    } 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    zam zam = this.zade.get();
    if (zam != null) {
      paramBundle.putBoolean("resolving_error", true);
      paramBundle.putInt("failed_client_id", zam.zar());
      paramBundle.putInt("failed_status", zam.getConnectionResult().getErrorCode());
      paramBundle.putParcelable("failed_resolution", (Parcelable)zam.getConnectionResult().getResolution());
    } 
  }
  
  public void onStart() {
    super.onStart();
    this.mStarted = true;
  }
  
  public void onStop() {
    super.onStop();
    this.mStarted = false;
  }
  
  protected abstract void zaa(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void zab(ConnectionResult paramConnectionResult, int paramInt) {
    zam zam = new zam(paramConnectionResult, paramInt);
    if (this.zade.compareAndSet(null, zam))
      this.zadf.post(new zan(this, zam)); 
  }
  
  protected abstract void zao();
  
  protected final void zaq() {
    this.zade.set(null);
    zao();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */