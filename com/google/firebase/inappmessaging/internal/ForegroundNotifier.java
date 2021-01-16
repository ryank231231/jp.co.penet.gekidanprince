package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;

public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {
  public static final long DELAY_MILLIS = 1000L;
  
  private Runnable check;
  
  private boolean foreground = false;
  
  private final Handler handler = new Handler();
  
  private Listener listener;
  
  private boolean paused = true;
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {
    this.paused = true;
    Runnable runnable = this.check;
    if (runnable != null)
      this.handler.removeCallbacks(runnable); 
    Handler handler = this.handler;
    runnable = ForegroundNotifier$$Lambda$1.lambdaFactory$(this);
    this.check = runnable;
    handler.postDelayed(runnable, 1000L);
  }
  
  public void onActivityResumed(Activity paramActivity) {
    this.paused = false;
    boolean bool = this.foreground;
    this.foreground = true;
    Runnable runnable = this.check;
    if (runnable != null)
      this.handler.removeCallbacks(runnable); 
    if ((bool ^ true) != 0) {
      Logging.logi("went foreground");
      this.listener.onForeground();
    } 
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void removeListener(Listener paramListener) {
    this.listener = null;
  }
  
  public void setListener(Listener paramListener) {
    this.listener = paramListener;
  }
  
  public static interface Listener {
    void onForeground();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\ForegroundNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */