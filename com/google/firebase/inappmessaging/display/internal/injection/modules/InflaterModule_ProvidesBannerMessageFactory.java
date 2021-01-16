package com.google.firebase.inappmessaging.display.internal.injection.modules;

import com.google.firebase.inappmessaging.model.InAppMessage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class InflaterModule_ProvidesBannerMessageFactory implements Factory<InAppMessage> {
  private final InflaterModule module;
  
  public InflaterModule_ProvidesBannerMessageFactory(InflaterModule paramInflaterModule) {
    this.module = paramInflaterModule;
  }
  
  public static Factory<InAppMessage> create(InflaterModule paramInflaterModule) {
    return new InflaterModule_ProvidesBannerMessageFactory(paramInflaterModule);
  }
  
  public static InAppMessage proxyProvidesBannerMessage(InflaterModule paramInflaterModule) {
    return paramInflaterModule.providesBannerMessage();
  }
  
  public InAppMessage get() {
    return (InAppMessage)Preconditions.checkNotNull(this.module.providesBannerMessage(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterModule_ProvidesBannerMessageFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */