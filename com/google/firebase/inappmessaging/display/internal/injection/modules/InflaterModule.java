package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.view.LayoutInflater;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import dagger.Module;
import dagger.Provides;

@Module
public class InflaterModule {
  private final Application application;
  
  private final InAppMessage inAppMessage;
  
  private final InAppMessageLayoutConfig inAppMessageLayoutConfig;
  
  public InflaterModule(InAppMessage paramInAppMessage, InAppMessageLayoutConfig paramInAppMessageLayoutConfig, Application paramApplication) {
    this.inAppMessage = paramInAppMessage;
    this.inAppMessageLayoutConfig = paramInAppMessageLayoutConfig;
    this.application = paramApplication;
  }
  
  @Provides
  @InAppMessageScope
  InAppMessageLayoutConfig inAppMessageLayoutConfig() {
    return this.inAppMessageLayoutConfig;
  }
  
  @Provides
  InAppMessage providesBannerMessage() {
    return this.inAppMessage;
  }
  
  @Provides
  @InAppMessageScope
  public LayoutInflater providesInflaterservice() {
    return (LayoutInflater)this.application.getSystemService("layout_inflater");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\InflaterModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */