package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

final class zae implements View.OnClickListener {
  zae(Context paramContext) {}
  
  public final void onClick(View paramView) {
    try {
      context.startActivity(this.zarn);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", (Throwable)activityNotFoundException);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\dynamic\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */