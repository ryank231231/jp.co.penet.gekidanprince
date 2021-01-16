package com.google.android.gms.internal.phenotype;

import android.database.ContentObserver;
import android.os.Handler;

final class zzg extends ContentObserver {
  zzg(Handler paramHandler) {
    super(null);
  }
  
  public final void onChange(boolean paramBoolean) {
    zzf.zzi().set(true);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\phenotype\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */