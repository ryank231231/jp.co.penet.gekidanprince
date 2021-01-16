package com.google.firebase.inappmessaging.internal.vendored;

import dagger.internal.Factory;

public final class SystemClock_Factory implements Factory<SystemClock> {
  private static final SystemClock_Factory INSTANCE = new SystemClock_Factory();
  
  public static Factory<SystemClock> create() {
    return INSTANCE;
  }
  
  public SystemClock get() {
    return new SystemClock();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\vendored\SystemClock_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */