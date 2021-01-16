package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.components.DaggerInAppMessageComponent;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BindingWrapperFactory {
  private final Application application;
  
  @Inject
  BindingWrapperFactory(Application paramApplication) {
    this.application = paramApplication;
  }
  
  public BindingWrapper createBannerBindingWrapper(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, InAppMessage paramInAppMessage) {
    return (BindingWrapper)DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(paramInAppMessage, paramInAppMessageLayoutConfig, this.application)).build().bannerBindingWrapper();
  }
  
  public BindingWrapper createImageBindingWrapper(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, InAppMessage paramInAppMessage) {
    return (BindingWrapper)DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(paramInAppMessage, paramInAppMessageLayoutConfig, this.application)).build().imageBindingWrapper();
  }
  
  public BindingWrapper createModalBindingWrapper(InAppMessageLayoutConfig paramInAppMessageLayoutConfig, InAppMessage paramInAppMessage) {
    return (BindingWrapper)DaggerInAppMessageComponent.builder().inflaterModule(new InflaterModule(paramInAppMessage, paramInAppMessageLayoutConfig, this.application)).build().modalBindingWrapper();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\BindingWrapperFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */