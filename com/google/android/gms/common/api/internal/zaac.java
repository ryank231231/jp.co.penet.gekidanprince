package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zaac implements PendingResult.StatusListener {
  zaac(zaab paramzaab, BasePendingResult paramBasePendingResult) {}
  
  public final void onComplete(Status paramStatus) {
    zaab.zaa(this.zafm).remove(this.zafl);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */