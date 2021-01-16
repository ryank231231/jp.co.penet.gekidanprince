package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
  private static final long serialVersionUID = 1811839108042568751L;
  
  public ScheduledDirectTask(Runnable paramRunnable) {
    super(paramRunnable);
  }
  
  public Void call() throws Exception {
    this.runner = Thread.currentThread();
    try {
      this.runnable.run();
      return null;
    } finally {
      lazySet(FINISHED);
      this.runner = null;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\ScheduledDirectTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */