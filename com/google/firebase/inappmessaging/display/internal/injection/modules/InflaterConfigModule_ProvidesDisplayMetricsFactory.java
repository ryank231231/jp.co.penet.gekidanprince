package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InflaterConfigModule_ProvidesDisplayMetricsFactory implements Factory<DisplayMetrics> {
  private final Provider<Application> applicationProvider;
  
  private final InflaterConfigModule module;
  
  public InflaterConfigModule_ProvidesDisplayMetricsFactory(InflaterConfigModule paramInflaterConfigModule, Provider<Application> paramProvider) {
    this.module = paramInflaterConfigModule;
    this.applicationProvider = paramProvider;
  }
  
  public static Factory<DisplayMetrics> create(InflaterConfigModule paramInflaterConfigModule, Provider<Application> paramProvider) {
    return new InflaterConfigModule_ProvidesDisplayMetricsFactory(paramInflaterConfigModule, paramProvider);
  }
  
  public static DisplayMetrics proxyProvidesDisplayMetrics(InflaterConfigModule paramInflaterConfigModule, Application paramApplication) {
    return paramInflaterConfigModule.providesDisplayMetrics(paramApplication);
  }
  
  public DisplayMetrics get() {
    return (DisplayMetrics)Preconditions.checkNotNull(this.module.providesDisplayMetrics((Application)this.applicationProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterConfigModule_ProvidesDisplayMetricsFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */