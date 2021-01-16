package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

final class zae extends DialogRedirect {
  zae(Intent paramIntent, LifecycleFragment paramLifecycleFragment) {}
  
  public final void redirect() {
    Intent intent = this.zaog;
    if (intent != null)
      this.zaoh.startActivityForResult(intent, requestCode); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */