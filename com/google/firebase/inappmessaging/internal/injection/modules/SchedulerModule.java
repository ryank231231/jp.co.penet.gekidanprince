package com.google.firebase.inappmessaging.internal.injection.modules;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class SchedulerModule {
  @Provides
  @Named("compute")
  @Singleton
  public Scheduler providesComputeScheduler() {
    return Schedulers.computation();
  }
  
  @Provides
  @Named("io")
  @Singleton
  public Scheduler providesIOScheduler() {
    return Schedulers.io();
  }
  
  @Provides
  @Named("main")
  @Singleton
  public Scheduler providesMainThreadScheduler() {
    return AndroidSchedulers.mainThread();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\SchedulerModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */