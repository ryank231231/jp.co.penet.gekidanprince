package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleFragment;

public abstract class DialogRedirect implements DialogInterface.OnClickListener {
  public static DialogRedirect getInstance(Activity paramActivity, Intent paramIntent, int paramInt) {
    return new zac(paramIntent, paramActivity, paramInt);
  }
  
  public static DialogRedirect getInstance(@NonNull Fragment paramFragment, Intent paramIntent, int paramInt) {
    return new zad(paramIntent, paramFragment, paramInt);
  }
  
  public static DialogRedirect getInstance(@NonNull LifecycleFragment paramLifecycleFragment, Intent paramIntent, int paramInt) {
    return new zae(paramIntent, paramLifecycleFragment, paramInt);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt) {
    Exception exception;
    try {
      redirect();
      paramDialogInterface.dismiss();
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.e("DialogRedirect", "Failed to start resolution intent", (Throwable)activityNotFoundException);
      paramDialogInterface.dismiss();
      return;
    } finally {}
    paramDialogInterface.dismiss();
    throw exception;
  }
  
  protected abstract void redirect();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\DialogRedirect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */