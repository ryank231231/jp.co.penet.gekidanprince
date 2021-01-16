package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class zabh {
  private static final ExecutorService zahv = Executors.newFixedThreadPool(2, (ThreadFactory)new NumberedThreadFactory("GAC_Executor"));
  
  public static ExecutorService zabb() {
    return zahv;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zabh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */