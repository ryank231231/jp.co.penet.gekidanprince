package com.google.firebase.inappmessaging.display.internal;

import dagger.internal.Factory;

public final class PicassoErrorListener_Factory implements Factory<PicassoErrorListener> {
  private static final PicassoErrorListener_Factory INSTANCE = new PicassoErrorListener_Factory();
  
  public static Factory<PicassoErrorListener> create() {
    return INSTANCE;
  }
  
  public static PicassoErrorListener newPicassoErrorListener() {
    return new PicassoErrorListener();
  }
  
  public PicassoErrorListener get() {
    return new PicassoErrorListener();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\PicassoErrorListener_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */