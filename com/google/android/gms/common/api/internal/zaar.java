package com.google.android.gms.common.api.internal;

import android.support.annotation.BinderThread;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

final class zaar extends zac {
  private final WeakReference<zaak> zagj;
  
  zaar(zaak paramzaak) {
    this.zagj = new WeakReference<zaak>(paramzaak);
  }
  
  @BinderThread
  public final void zab(zaj paramzaj) {
    zaak zaak = this.zagj.get();
    if (zaak == null)
      return; 
    zaak.zad(zaak).zaa(new zaas(this, zaak, zaak, paramzaj));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */