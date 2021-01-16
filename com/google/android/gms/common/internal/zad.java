package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

final class zad extends DialogRedirect {
  zad(Intent paramIntent) {}
  
  public final void redirect() {
    Intent intent = this.zaog;
    if (intent != null)
      fragment.startActivityForResult(intent, requestCode); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */