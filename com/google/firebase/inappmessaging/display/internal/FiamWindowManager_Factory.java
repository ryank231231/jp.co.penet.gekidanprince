package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

public final class FiamWindowManager_Factory implements Factory<FiamWindowManager> {
  private static final FiamWindowManager_Factory INSTANCE = new FiamWindowManager_Factory();
  
  public static Factory<FiamWindowManager> create() {
    return INSTANCE;
  }
  
  public static FiamWindowManager newFiamWindowManager() {
    return new FiamWindowManager();
  }
  
  public FiamWindowManager get() {
    return new FiamWindowManager();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FiamWindowManager_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */