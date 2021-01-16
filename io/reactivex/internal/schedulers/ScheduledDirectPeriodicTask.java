package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
  private static final long serialVersionUID = 1811839108042568751L;
  
  public ScheduledDirectPeriodicTask(Runnable paramRunnable) {
    super(paramRunnable);
  }
  
  public void run() {
    this.runner = Thread.currentThread();
    try {
      this.runnable.run();
      this.runner = null;
    } catch (Throwable throwable) {
      this.runner = null;
      lazySet(FINISHED);
      RxJavaPlugins.onError(throwable);
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\ScheduledDirectPeriodicTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */