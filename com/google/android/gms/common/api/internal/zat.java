package com.google.android.gms.common.api.internal;

final class zat implements Runnable {
  zat(zas paramzas) {}
  
  public final void run() {
    zas.zaa(this.zaep).lock();
    try {
      zas.zab(this.zaep);
      return;
    } finally {
      zas.zaa(this.zaep).unlock();
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */