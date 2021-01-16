package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.model.InAppMessage;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ModalBindingWrapper_Factory implements Factory<ModalBindingWrapper> {
  private final Provider<InAppMessageLayoutConfig> configProvider;
  
  private final Provider<LayoutInflater> inflaterProvider;
  
  private final Provider<InAppMessage> messageProvider;
  
  public ModalBindingWrapper_Factory(Provider<InAppMessageLayoutConfig> paramProvider, Provider<LayoutInflater> paramProvider1, Provider<InAppMessage> paramProvider2) {
    this.configProvider = paramProvider;
    this.inflaterProvider = paramProvider1;
    this.messageProvider = paramProvider2;
  }
  
  public static Factory<ModalBindingWrapper> create(Provider<InAppMessageLayoutConfig> paramProvider, Provider<LayoutInflater> paramProvider1, Provider<InAppMessage> paramProvider2) {
    return new ModalBindingWrapper_Factory(paramProvider, paramProvider1, paramProvider2);
  }
  
  public ModalBindingWrapper get() {
    return new ModalBindingWrapper((InAppMessageLayoutConfig)this.configProvider.get(), (LayoutInflater)this.inflaterProvider.get(), (InAppMessage)this.messageProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\bindingwrappers\ModalBindingWrapper_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */