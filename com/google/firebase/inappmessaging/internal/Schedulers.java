package com.google.firebase.inappmessaging.internal;

import io.reactivex.Scheduler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Schedulers {
  private final Scheduler computeScheduler;
  
  private final Scheduler ioScheduler;
  
  private final Scheduler mainThreadScheduler;
  
  @Inject
  Schedulers(@Named("io") Scheduler paramScheduler1, @Named("compute") Scheduler paramScheduler2, @Named("main") Scheduler paramScheduler3) {
    this.ioScheduler = paramScheduler1;
    this.computeScheduler = paramScheduler2;
    this.mainThreadScheduler = paramScheduler3;
  }
  
  public Scheduler computation() {
    return this.computeScheduler;
  }
  
  public Scheduler io() {
    return this.ioScheduler;
  }
  
  public Scheduler mainThread() {
    return this.mainThreadScheduler;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\Schedulers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */