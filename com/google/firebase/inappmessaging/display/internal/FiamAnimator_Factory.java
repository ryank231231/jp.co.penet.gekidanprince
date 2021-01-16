package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

public final class FiamAnimator_Factory implements Factory<FiamAnimator> {
  private static final FiamAnimator_Factory INSTANCE = new FiamAnimator_Factory();
  
  public static Factory<FiamAnimator> create() {
    return INSTANCE;
  }
  
  public static FiamAnimator newFiamAnimator() {
    return new FiamAnimator();
  }
  
  public FiamAnimator get() {
    return new FiamAnimator();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\FiamAnimator_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */