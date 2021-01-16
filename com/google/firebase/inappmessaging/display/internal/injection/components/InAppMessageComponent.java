package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BannerBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ImageBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import dagger.Component;

@Component(modules = {InflaterModule.class})
@InAppMessageScope
public interface InAppMessageComponent {
  @InAppMessageScope
  BannerBindingWrapper bannerBindingWrapper();
  
  @InAppMessageScope
  ImageBindingWrapper imageBindingWrapper();
  
  @InAppMessageScope
  ModalBindingWrapper modalBindingWrapper();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\components\InAppMessageComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */