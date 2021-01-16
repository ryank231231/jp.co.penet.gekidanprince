package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory implements ThreadFactory {
  private final String name;
  
  private final int priority;
  
  private final ThreadFactory zzhr = Executors.defaultThreadFactory();
  
  @KeepForSdk
  public NamedThreadFactory(String paramString) {
    this(paramString, 0);
  }
  
  private NamedThreadFactory(String paramString, int paramInt) {
    this.name = (String)Preconditions.checkNotNull(paramString, "Name must not be null");
    this.priority = 0;
  }
  
  public Thread newThread(Runnable paramRunnable) {
    paramRunnable = this.zzhr.newThread(new zza(paramRunnable, 0));
    paramRunnable.setName(this.name);
    return (Thread)paramRunnable;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\NamedThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */