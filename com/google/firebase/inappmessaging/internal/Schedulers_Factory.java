package com.google.firebase.inappmessaging.internal;

import dagger.internal.Factory;
import io.reactivex.Scheduler;
import javax.inject.Provider;

public final class Schedulers_Factory implements Factory<Schedulers> {
  private final Provider<Scheduler> computeSchedulerProvider;
  
  private final Provider<Scheduler> ioSchedulerProvider;
  
  private final Provider<Scheduler> mainThreadSchedulerProvider;
  
  public Schedulers_Factory(Provider<Scheduler> paramProvider1, Provider<Scheduler> paramProvider2, Provider<Scheduler> paramProvider3) {
    this.ioSchedulerProvider = paramProvider1;
    this.computeSchedulerProvider = paramProvider2;
    this.mainThreadSchedulerProvider = paramProvider3;
  }
  
  public static Factory<Schedulers> create(Provider<Scheduler> paramProvider1, Provider<Scheduler> paramProvider2, Provider<Scheduler> paramProvider3) {
    return new Schedulers_Factory(paramProvider1, paramProvider2, paramProvider3);
  }
  
  public static Schedulers newSchedulers(Scheduler paramScheduler1, Scheduler paramScheduler2, Scheduler paramScheduler3) {
    return new Schedulers(paramScheduler1, paramScheduler2, paramScheduler3);
  }
  
  public Schedulers get() {
    return new Schedulers((Scheduler)this.ioSchedulerProvider.get(), (Scheduler)this.computeSchedulerProvider.get(), (Scheduler)this.mainThreadSchedulerProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\Schedulers_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */