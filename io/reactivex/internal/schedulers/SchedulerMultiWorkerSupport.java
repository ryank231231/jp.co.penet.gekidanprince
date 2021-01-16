package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface SchedulerMultiWorkerSupport {
  void createWorkers(int paramInt, @NonNull WorkerCallback paramWorkerCallback);
  
  public static interface WorkerCallback {
    void onWorker(int param1Int, @NonNull Scheduler.Worker param1Worker);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\internal\schedulers\SchedulerMultiWorkerSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */