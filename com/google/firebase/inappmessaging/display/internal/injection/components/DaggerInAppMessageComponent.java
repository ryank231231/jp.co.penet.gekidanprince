package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_InAppMessageLayoutConfigFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesBannerMessageFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule_ProvidesInflaterserviceFactory;
import com.google.firebase.inappmessaging.model.InAppMessage;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerInAppMessageComponent implements InAppMessageComponent {
  private Provider<BannerBindingWrapper> bannerBindingWrapperProvider;
  
  private Provider<ImageBindingWrapper> imageBindingWrapperProvider;
  
  private Provider<InAppMessageLayoutConfig> inAppMessageLayoutConfigProvider;
  
  private Provider<ModalBindingWrapper> modalBindingWrapperProvider;
  
  private Provider<InAppMessage> providesBannerMessageProvider;
  
  private Provider<LayoutInflater> providesInflaterserviceProvider;
  
  private DaggerInAppMessageComponent(Builder paramBuilder) {
    initialize(paramBuilder);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private void initialize(Builder paramBuilder) {
    this.inAppMessageLayoutConfigProvider = DoubleCheck.provider((Provider)InflaterModule_InAppMessageLayoutConfigFactory.create(paramBuilder.inflaterModule));
    this.providesInflaterserviceProvider = DoubleCheck.provider((Provider)InflaterModule_ProvidesInflaterserviceFactory.create(paramBuilder.inflaterModule));
    this.providesBannerMessageProvider = (Provider<InAppMessage>)InflaterModule_ProvidesBannerMessageFactory.create(paramBuilder.inflaterModule);
    this.imageBindingWrapperProvider = DoubleCheck.provider((Provider)ImageBindingWrapper_Factory.create(this.inAppMessageLayoutConfigProvider, this.providesInflaterserviceProvider, this.providesBannerMessageProvider));
    this.modalBindingWrapperProvider = DoubleCheck.provider((Provider)ModalBindingWrapper_Factory.create(this.inAppMessageLayoutConfigProvider, this.providesInflaterserviceProvider, this.providesBannerMessageProvider));
    this.bannerBindingWrapperProvider = DoubleCheck.provider((Provider)BannerBindingWrapper_Factory.create(this.providesBannerMessageProvider, this.providesInflaterserviceProvider, this.inAppMessageLayoutConfigProvider));
  }
  
  public BannerBindingWrapper bannerBindingWrapper() {
    return (BannerBindingWrapper)this.bannerBindingWrapperProvider.get();
  }
  
  public ImageBindingWrapper imageBindingWrapper() {
    return (ImageBindingWrapper)this.imageBindingWrapperProvider.get();
  }
  
  public ModalBindingWrapper modalBindingWrapper() {
    return (ModalBindingWrapper)this.modalBindingWrapperProvider.get();
  }
  
  public static final class Builder {
    private InflaterModule inflaterModule;
    
    private Builder() {}
    
    public InAppMessageComponent build() {
      if (this.inflaterModule != null)
        return new DaggerInAppMessageComponent(this); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(InflaterModule.class.getCanonicalName());
      stringBuilder.append(" must be set");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public Builder inflaterModule(InflaterModule param1InflaterModule) {
      this.inflaterModule = (InflaterModule)Preconditions.checkNotNull(param1InflaterModule);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\components\DaggerInAppMessageComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */