package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import android.util.DisplayMetrics;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.modules.ApplicationModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.InflaterConfigModule;
import dagger.Component;
import java.util.Map;
import javax.inject.Provider;
import javax.inject.Singleton;

@Component(modules = {ApplicationModule.class, InflaterConfigModule.class})
@Singleton
public interface UniversalComponent {
  DisplayMetrics displayMetrics();
  
  FiamWindowManager fiamWindowManager();
  
  BindingWrapperFactory inflaterClient();
  
  Map<String, Provider<InAppMessageLayoutConfig>> myKeyStringMap();
  
  Application providesApplication();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\components\UniversalComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */