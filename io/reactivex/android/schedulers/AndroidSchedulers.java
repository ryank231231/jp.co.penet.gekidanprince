package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import java.util.concurrent.Callable;

public final class AndroidSchedulers {
  private static final Scheduler MAIN_THREAD = RxAndroidPlugins.initMainThreadScheduler(new Callable<Scheduler>() {
        public Scheduler call() throws Exception {
          return AndroidSchedulers.MainHolder.DEFAULT;
        }
      });
  
  private AndroidSchedulers() {
    throw new AssertionError("No instances.");
  }
  
  public static Scheduler from(Looper paramLooper) {
    if (paramLooper != null)
      return new HandlerScheduler(new Handler(paramLooper)); 
    throw new NullPointerException("looper == null");
  }
  
  public static Scheduler mainThread() {
    return RxAndroidPlugins.onMainThreadScheduler(MAIN_THREAD);
  }
  
  private static final class MainHolder {
    static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()));
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\android\schedulers\AndroidSchedulers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */