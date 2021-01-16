package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.view.LayoutInflater;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class InflaterModule_ProvidesInflaterserviceFactory implements Factory<LayoutInflater> {
  private final InflaterModule module;
  
  public InflaterModule_ProvidesInflaterserviceFactory(InflaterModule paramInflaterModule) {
    this.module = paramInflaterModule;
  }
  
  public static Factory<LayoutInflater> create(InflaterModule paramInflaterModule) {
    return new InflaterModule_ProvidesInflaterserviceFactory(paramInflaterModule);
  }
  
  public LayoutInflater get() {
    return (LayoutInflater)Preconditions.checkNotNull(this.module.providesInflaterservice(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterModule_ProvidesInflaterserviceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */