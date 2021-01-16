package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class InflaterModule_InAppMessageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
  private final InflaterModule module;
  
  public InflaterModule_InAppMessageLayoutConfigFactory(InflaterModule paramInflaterModule) {
    this.module = paramInflaterModule;
  }
  
  public static Factory<InAppMessageLayoutConfig> create(InflaterModule paramInflaterModule) {
    return new InflaterModule_InAppMessageLayoutConfigFactory(paramInflaterModule);
  }
  
  public static InAppMessageLayoutConfig proxyInAppMessageLayoutConfig(InflaterModule paramInflaterModule) {
    return paramInflaterModule.inAppMessageLayoutConfig();
  }
  
  public InAppMessageLayoutConfig get() {
    return (InAppMessageLayoutConfig)Preconditions.checkNotNull(this.module.inAppMessageLayoutConfig(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterModule_InAppMessageLayoutConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */