package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class zau implements zabt {
  private zau(zas paramzas) {}
  
  public final void zab(int paramInt, boolean paramBoolean) {
    zas.zaa(this.zaep).lock();
    try {
      if (zas.zac(this.zaep) || zas.zad(this.zaep) == null || !zas.zad(this.zaep).isSuccess()) {
        zas.zaa(this.zaep, false);
        zas.zaa(this.zaep, paramInt, paramBoolean);
        return;
      } 
      zas.zaa(this.zaep, true);
      zas.zae(this.zaep).onConnectionSuspended(paramInt);
      return;
    } finally {
      zas.zaa(this.zaep).unlock();
    } 
  }
  
  public final void zab(@Nullable Bundle paramBundle) {
    zas.zaa(this.zaep).lock();
    try {
      zas.zaa(this.zaep, paramBundle);
      zas.zaa(this.zaep, ConnectionResult.RESULT_SUCCESS);
      zas.zab(this.zaep);
      return;
    } finally {
      zas.zaa(this.zaep).unlock();
    } 
  }
  
  public final void zac(@NonNull ConnectionResult paramConnectionResult) {
    zas.zaa(this.zaep).lock();
    try {
      zas.zaa(this.zaep, paramConnectionResult);
      zas.zab(this.zaep);
      return;
    } finally {
      zas.zaa(this.zaep).unlock();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */