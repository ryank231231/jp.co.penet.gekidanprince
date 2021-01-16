package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

public final class RenewableTimer_Factory implements Factory<RenewableTimer> {
  private static final RenewableTimer_Factory INSTANCE = new RenewableTimer_Factory();
  
  public static Factory<RenewableTimer> create() {
    return INSTANCE;
  }
  
  public static RenewableTimer newRenewableTimer() {
    return new RenewableTimer();
  }
  
  public RenewableTimer get() {
    return new RenewableTimer();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\RenewableTimer_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */