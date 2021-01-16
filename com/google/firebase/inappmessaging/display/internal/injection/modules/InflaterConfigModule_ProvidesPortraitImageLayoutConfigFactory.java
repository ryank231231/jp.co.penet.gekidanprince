package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
  private final Provider<DisplayMetrics> displayMetricsProvider;
  
  private final InflaterConfigModule module;
  
  public InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(InflaterConfigModule paramInflaterConfigModule, Provider<DisplayMetrics> paramProvider) {
    this.module = paramInflaterConfigModule;
    this.displayMetricsProvider = paramProvider;
  }
  
  public static Factory<InAppMessageLayoutConfig> create(InflaterConfigModule paramInflaterConfigModule, Provider<DisplayMetrics> paramProvider) {
    return new InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory(paramInflaterConfigModule, paramProvider);
  }
  
  public static InAppMessageLayoutConfig proxyProvidesPortraitImageLayoutConfig(InflaterConfigModule paramInflaterConfigModule, DisplayMetrics paramDisplayMetrics) {
    return paramInflaterConfigModule.providesPortraitImageLayoutConfig(paramDisplayMetrics);
  }
  
  public InAppMessageLayoutConfig get() {
    return (InAppMessageLayoutConfig)Preconditions.checkNotNull(this.module.providesPortraitImageLayoutConfig((DisplayMetrics)this.displayMetricsProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */