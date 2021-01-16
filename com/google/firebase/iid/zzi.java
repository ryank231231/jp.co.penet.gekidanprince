package com.google.firebase.iid;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzi {
  private static final Executor zzaf = zzk.zzah;
  
  static Executor zzf() {
    return zzaf;
  }
  
  static Executor zzg() {
    return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), zzj.zzag);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */