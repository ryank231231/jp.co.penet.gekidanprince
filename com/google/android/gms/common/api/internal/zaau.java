package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;

abstract class zaau implements Runnable {
  private zaau(zaak paramzaak) {}
  
  @WorkerThread
  public void run() {
    Exception exception;
    zaak.zac(this.zagi).lock();
    try {
      boolean bool = Thread.interrupted();
      if (bool) {
        zaak.zac(this.zagi).unlock();
        return;
      } 
      zaan();
      zaak.zac(this.zagi).unlock();
      return;
    } catch (RuntimeException null) {
      zaak.zad(this.zagi).zab((RuntimeException)exception);
      zaak.zac(this.zagi).unlock();
      return;
    } finally {}
    zaak.zac(this.zagi).unlock();
    throw exception;
  }
  
  @WorkerThread
  protected abstract void zaan();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */