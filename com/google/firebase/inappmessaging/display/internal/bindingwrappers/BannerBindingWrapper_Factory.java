package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BannerBindingWrapper_Factory implements Factory<BannerBindingWrapper> {
  private final Provider<InAppMessageLayoutConfig> configProvider;
  
  private final Provider<LayoutInflater> inflaterProvider;
  
  private final Provider<InAppMessage> messageProvider;
  
  public BannerBindingWrapper_Factory(Provider<InAppMessage> paramProvider, Provider<LayoutInflater> paramProvider1, Provider<InAppMessageLayoutConfig> paramProvider2) {
    this.messageProvider = paramProvider;
    this.inflaterProvider = paramProvider1;
    this.configProvider = paramProvider2;
  }
  
  public static Factory<BannerBindingWrapper> create(Provider<InAppMessage> paramProvider, Provider<LayoutInflater> paramProvider1, Provider<InAppMessageLayoutConfig> paramProvider2) {
    return new BannerBindingWrapper_Factory(paramProvider, paramProvider1, paramProvider2);
  }
  
  public BannerBindingWrapper get() {
    return new BannerBindingWrapper((InAppMessage)this.messageProvider.get(), (LayoutInflater)this.inflaterProvider.get(), (InAppMessageLayoutConfig)this.configProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\bindingwrappers\BannerBindingWrapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */