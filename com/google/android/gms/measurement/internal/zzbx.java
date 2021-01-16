package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzbx extends Thread {
  private final Object zznl;
  
  private final BlockingQueue<zzbw<?>> zznm;
  
  public zzbx(zzbt paramzzbt, String paramString, BlockingQueue<zzbw<?>> paramBlockingQueue) {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramBlockingQueue);
    this.zznl = new Object();
    this.zznm = paramBlockingQueue;
    setName(paramString);
  }
  
  private final void zza(InterruptedException paramInterruptedException) {
    this.zzni.zzad().zzdd().zza(String.valueOf(getName()).concat(" was interrupted"), paramInterruptedException);
  }
  
  public final void run() {
    int i = 0;
    while (!i) {
      try {
        zzbt.zza(this.zzni).acquire();
        i = 1;
      } catch (InterruptedException interruptedException) {
        zza(interruptedException);
      } 
    } 
    try {
      int j = Process.getThreadPriority(Process.myTid());
      while (true) {
        zzbw zzbw = this.zznm.poll();
        if (zzbw != null) {
          if (zzbw.zznk) {
            i = j;
          } else {
            i = 10;
          } 
          Process.setThreadPriority(i);
          zzbw.run();
          continue;
        } 
        synchronized (this.zznl) {
          if (this.zznm.peek() == null) {
            boolean bool = zzbt.zzb(this.zzni);
            if (!bool)
              try {
                this.zznl.wait(30000L);
              } catch (InterruptedException interruptedException) {
                zza(interruptedException);
              }  
          } 
          synchronized (zzbt.zzc(this.zzni)) {
            if (this.zznm.peek() == null)
              synchronized (zzbt.zzc(this.zzni)) {
                zzbt.zza(this.zzni).release();
                zzbt.zzc(this.zzni).notifyAll();
                return;
              }  
          } 
        } 
      } 
    } finally {
      null = null;
    } 
  }
  
  public final void zzeh() {
    synchronized (this.zznl) {
      this.zznl.notifyAll();
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */