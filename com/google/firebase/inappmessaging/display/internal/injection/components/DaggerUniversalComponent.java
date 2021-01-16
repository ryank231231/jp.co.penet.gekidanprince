package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule_ProvidesApplicationFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesDisplayMetricsFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalLandscapeConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesModalPortraitConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

public final class DaggerUniversalComponent implements UniversalComponent {
  private Provider<BindingWrapperFactory> bindingWrapperFactoryProvider;
  
  private Provider<FiamWindowManager> fiamWindowManagerProvider;
  
  private InflaterConfigModule inflaterConfigModule;
  
  private Provider<Application> providesApplicationProvider;
  
  private Provider<InAppMessageLayoutConfig> providesBannerLandscapeLayoutConfigProvider;
  
  private Provider<InAppMessageLayoutConfig> providesBannerPortraitLayoutConfigProvider;
  
  private Provider<DisplayMetrics> providesDisplayMetricsProvider;
  
  private Provider<InAppMessageLayoutConfig> providesLandscapeImageLayoutConfigProvider;
  
  private Provider<InAppMessageLayoutConfig> providesModalLandscapeConfigProvider;
  
  private Provider<InAppMessageLayoutConfig> providesModalPortraitConfigProvider;
  
  private Provider<InAppMessageLayoutConfig> providesPortraitImageLayoutConfigProvider;
  
  private DaggerUniversalComponent(Builder paramBuilder) {
    initialize(paramBuilder);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private void initialize(Builder paramBuilder) {
    this.providesApplicationProvider = DoubleCheck.provider((Provider)ApplicationModule_ProvidesApplicationFactory.create(paramBuilder.applicationModule));
    this.inflaterConfigModule = paramBuilder.inflaterConfigModule;
    this.fiamWindowManagerProvider = DoubleCheck.provider((Provider)FiamWindowManager_Factory.create());
    this.bindingWrapperFactoryProvider = DoubleCheck.provider((Provider)BindingWrapperFactory_Factory.create(this.providesApplicationProvider));
    this.providesDisplayMetricsProvider = (Provider<DisplayMetrics>)InflaterConfigModule_ProvidesDisplayMetricsFactory.create(paramBuilder.inflaterConfigModule, this.providesApplicationProvider);
    this.providesPortraitImageLayoutConfigProvider = (Provider<InAppMessageLayoutConfig>)InflaterConfigModule_ProvidesPortraitImageLayoutConfigFactory.create(paramBuilder.inflaterConfigModule, this.providesDisplayMetricsProvider);
    this.providesLandscapeImageLayoutConfigProvider = (Provider<InAppMessageLayoutConfig>)InflaterConfigModule_ProvidesLandscapeImageLayoutConfigFactory.create(paramBuilder.inflaterConfigModule, this.providesDisplayMetricsProvider);
    this.providesModalLandscapeConfigProvider = (Provider<InAppMessageLayoutConfig>)InflaterConfigModule_ProvidesModalLandscapeConfigFactory.create(paramBuilder.inflaterConfigModule, this.providesDisplayMetricsProvider);
    this.providesModalPortraitConfigProvider = (Provider<InAppMessageLayoutConfig>)InflaterConfigModule_ProvidesModalPortraitConfigFactory.create(paramBuilder.inflaterConfigModule, this.providesDisplayMetricsProvider);
    this.providesBannerPortraitLayoutConfigProvider = (Provider<InAppMessageLayoutConfig>)InflaterConfigModule_ProvidesBannerPortraitLayoutConfigFactory.create(paramBuilder.inflaterConfigModule, this.providesDisplayMetricsProvider);
    this.providesBannerLandscapeLayoutConfigProvider = (Provider<InAppMessageLayoutConfig>)InflaterConfigModule_ProvidesBannerLandscapeLayoutConfigFactory.create(paramBuilder.inflaterConfigModule, this.providesDisplayMetricsProvider);
  }
  
  public DisplayMetrics displayMetrics() {
    return (DisplayMetrics)Preconditions.checkNotNull(InflaterConfigModule_ProvidesDisplayMetricsFactory.proxyProvidesDisplayMetrics(this.inflaterConfigModule, (Application)this.providesApplicationProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
  
  public FiamWindowManager fiamWindowManager() {
    return (FiamWindowManager)this.fiamWindowManagerProvider.get();
  }
  
  public BindingWrapperFactory inflaterClient() {
    return (BindingWrapperFactory)this.bindingWrapperFactoryProvider.get();
  }
  
  public Map<String, Provider<InAppMessageLayoutConfig>> myKeyStringMap() {
    return MapBuilder.newMapBuilder(6).put("IMAGE_ONLY_PORTRAIT", this.providesPortraitImageLayoutConfigProvider).put("IMAGE_ONLY_LANDSCAPE", this.providesLandscapeImageLayoutConfigProvider).put("MODAL_LANDSCAPE", this.providesModalLandscapeConfigProvider).put("MODAL_PORTRAIT", this.providesModalPortraitConfigProvider).put("BANNER_PORTRAIT", this.providesBannerPortraitLayoutConfigProvider).put("BANNER_LANDSCAPE", this.providesBannerLandscapeLayoutConfigProvider).build();
  }
  
  public Application providesApplication() {
    return (Application)this.providesApplicationProvider.get();
  }
  
  public static final class Builder {
    private ApplicationModule applicationModule;
    
    private InflaterConfigModule inflaterConfigModule;
    
    private Builder() {}
    
    public Builder applicationModule(ApplicationModule param1ApplicationModule) {
      this.applicationModule = (ApplicationModule)Preconditions.checkNotNull(param1ApplicationModule);
      return this;
    }
    
    public UniversalComponent build() {
      if (this.applicationModule != null) {
        if (this.inflaterConfigModule == null)
          this.inflaterConfigModule = new InflaterConfigModule(); 
        return new DaggerUniversalComponent(this);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ApplicationModule.class.getCanonicalName());
      stringBuilder.append(" must be set");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public Builder inflaterConfigModule(InflaterConfigModule param1InflaterConfigModule) {
      this.inflaterConfigModule = (InflaterConfigModule)Preconditions.checkNotNull(param1InflaterConfigModule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\components\DaggerUniversalComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */