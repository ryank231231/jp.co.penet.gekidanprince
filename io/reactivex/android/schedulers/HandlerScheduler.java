package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
  private final Handler handler;
  
  HandlerScheduler(Handler paramHandler) {
    this.handler = paramHandler;
  }
  
  public Scheduler.Worker createWorker() {
    return new HandlerWorker(this.handler);
  }
  
  public Disposable scheduleDirect(Runnable paramRunnable, long paramLong, TimeUnit paramTimeUnit) {
    if (paramRunnable != null) {
      if (paramTimeUnit != null) {
        paramRunnable = RxJavaPlugins.onSchedule(paramRunnable);
        paramRunnable = new ScheduledRunnable(this.handler, paramRunnable);
        this.handler.postDelayed(paramRunnable, paramTimeUnit.toMillis(paramLong));
        return (Disposable)paramRunnable;
      } 
      throw new NullPointerException("unit == null");
    } 
    throw new NullPointerException("run == null");
  }
  
  private static final class HandlerWorker extends Scheduler.Worker {
    private volatile boolean disposed;
    
    private final Handler handler;
    
    HandlerWorker(Handler param1Handler) {
      this.handler = param1Handler;
    }
    
    public void dispose() {
      this.disposed = true;
      this.handler.removeCallbacksAndMessages(this);
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public Disposable schedule(Runnable param1Runnable, long param1Long, TimeUnit param1TimeUnit) {
      if (param1Runnable != null) {
        if (param1TimeUnit != null) {
          if (this.disposed)
            return Disposables.disposed(); 
          param1Runnable = RxJavaPlugins.onSchedule(param1Runnable);
          HandlerScheduler.ScheduledRunnable scheduledRunnable = new HandlerScheduler.ScheduledRunnable(this.handler, param1Runnable);
          Message message = Message.obtain(this.handler, scheduledRunnable);
          message.obj = this;
          this.handler.sendMessageDelayed(message, param1TimeUnit.toMillis(param1Long));
          if (this.disposed) {
            this.handler.removeCallbacks(scheduledRunnable);
            return Disposables.disposed();
          } 
          return scheduledRunnable;
        } 
        throw new NullPointerException("unit == null");
      } 
      throw new NullPointerException("run == null");
    }
  }
  
  private static final class ScheduledRunnable implements Runnable, Disposable {
    private final Runnable delegate;
    
    private volatile boolean disposed;
    
    private final Handler handler;
    
    ScheduledRunnable(Handler param1Handler, Runnable param1Runnable) {
      this.handler = param1Handler;
      this.delegate = param1Runnable;
    }
    
    public void dispose() {
      this.disposed = true;
      this.handler.removeCallbacks(this);
    }
    
    public boolean isDisposed() {
      return this.disposed;
    }
    
    public void run() {
      try {
        this.delegate.run();
      } catch (Throwable throwable) {
        RxJavaPlugins.onError(throwable);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\android\schedulers\HandlerScheduler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */