package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;

public final class SchedulerModule_ProvidesMainThreadSchedulerFactory implements Factory<Scheduler> {
  private final SchedulerModule module;
  
  public SchedulerModule_ProvidesMainThreadSchedulerFactory(SchedulerModule paramSchedulerModule) {
    this.module = paramSchedulerModule;
  }
  
  public static Factory<Scheduler> create(SchedulerModule paramSchedulerModule) {
    return new SchedulerModule_ProvidesMainThreadSchedulerFactory(paramSchedulerModule);
  }
  
  public Scheduler get() {
    return (Scheduler)Preconditions.checkNotNull(this.module.providesMainThreadScheduler(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\SchedulerModule_ProvidesMainThreadSchedulerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */