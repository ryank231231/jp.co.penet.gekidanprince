package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

final class zacr implements IBinder.DeathRecipient, zacs {
  private final WeakReference<BasePendingResult<?>> zalb;
  
  private final WeakReference<zac> zalc;
  
  private final WeakReference<IBinder> zald;
  
  private zacr(BasePendingResult<?> paramBasePendingResult, zac paramzac, IBinder paramIBinder) {
    this.zalc = new WeakReference<zac>(paramzac);
    this.zalb = new WeakReference<BasePendingResult<?>>(paramBasePendingResult);
    this.zald = new WeakReference<IBinder>(paramIBinder);
  }
  
  private final void zaby() {
    BasePendingResult basePendingResult = this.zalb.get();
    zac zac = this.zalc.get();
    if (zac != null && basePendingResult != null)
      zac.remove(basePendingResult.zam().intValue()); 
    IBinder iBinder = this.zald.get();
    if (iBinder != null)
      try {
        iBinder.unlinkToDeath(this, 0);
        return;
      } catch (NoSuchElementException noSuchElementException) {} 
  }
  
  public final void binderDied() {
    zaby();
  }
  
  public final void zac(BasePendingResult<?> paramBasePendingResult) {
    zaby();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zacr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */