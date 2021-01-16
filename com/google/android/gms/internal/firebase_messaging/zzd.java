package com.google.android.gms.internal.firebase_messaging;

import android.support.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zzd implements zza {
  private zzd() {}
  
  @NonNull
  public final ExecutorService zza(ThreadFactory paramThreadFactory, int paramInt) {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), paramThreadFactory);
    threadPoolExecutor.allowCoreThreadTimeOut(true);
    return Executors.unconfigurableExecutorService(threadPoolExecutor);
  }
  
  @NonNull
  public final ScheduledExecutorService zza(int paramInt1, ThreadFactory paramThreadFactory, int paramInt2) {
    return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, paramThreadFactory));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */