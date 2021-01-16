package io.reactivex.schedulers;

import io.reactivex.annotations.Experimental;
import io.reactivex.annotations.NonNull;

@Experimental
public interface SchedulerRunnableIntrospection {
  @NonNull
  Runnable getWrappedRunnable();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\schedulers\SchedulerRunnableIntrospection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */