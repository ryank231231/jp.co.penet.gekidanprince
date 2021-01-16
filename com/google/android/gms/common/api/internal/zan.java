package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

final class zan implements Runnable {
  private final zam zadi;
  
  zan(zal paramzal, zam paramzam) {
    this.zadi = paramzam;
  }
  
  @MainThread
  public final void run() {
    Dialog dialog;
    if (!this.zadj.mStarted)
      return; 
    ConnectionResult connectionResult = this.zadi.getConnectionResult();
    if (connectionResult.hasResolution()) {
      this.zadj.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa((Context)this.zadj.getActivity(), connectionResult.getResolution(), this.zadi.zar(), false), 1);
      return;
    } 
    if (this.zadj.zacc.isUserResolvableError(connectionResult.getErrorCode())) {
      this.zadj.zacc.zaa(this.zadj.getActivity(), this.zadj.mLifecycleFragment, connectionResult.getErrorCode(), 2, this.zadj);
      return;
    } 
    if (connectionResult.getErrorCode() == 18) {
      dialog = GoogleApiAvailability.zaa(this.zadj.getActivity(), this.zadj);
      this.zadj.zacc.zaa(this.zadj.getActivity().getApplicationContext(), new zao(this, dialog));
      return;
    } 
    this.zadj.zaa((ConnectionResult)dialog, this.zadi.zar());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */