package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory implements Factory<InAppMessageLayoutConfig> {
  private final Provider<DisplayMetrics> displayMetricsProvider;
  
  private final InflaterConfigModule module;
  
  public InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory(InflaterConfigModule paramInflaterConfigModule, Provider<DisplayMetrics> paramProvider) {
    this.module = paramInflaterConfigModule;
    this.displayMetricsProvider = paramProvider;
  }
  
  public static Factory<InAppMessageLayoutConfig> create(InflaterConfigModule paramInflaterConfigModule, Provider<DisplayMetrics> paramProvider) {
    return new InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory(paramInflaterConfigModule, paramProvider);
  }
  
  public static InAppMessageLayoutConfig proxyProvidesBannerLandscapeLayoutConfig(InflaterConfigModule paramInflaterConfigModule, DisplayMetrics paramDisplayMetrics) {
    return paramInflaterConfigModule.providesBannerLandscapeLayoutConfig(paramDisplayMetrics);
  }
  
  public InAppMessageLayoutConfig get() {
    return (InAppMessageLayoutConfig)Preconditions.checkNotNull(this.module.providesBannerLandscapeLayoutConfig((DisplayMetrics)this.displayMetricsProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */