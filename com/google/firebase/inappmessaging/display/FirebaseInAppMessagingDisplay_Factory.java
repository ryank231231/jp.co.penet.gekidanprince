package com.google.firebase.inappmessaging.display;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class FirebaseInAppMessagingDisplay_Factory implements Factory<FirebaseInAppMessagingDisplay> {
  private final Provider<FiamAnimator> animatorProvider;
  
  private final Provider<Application> applicationProvider;
  
  private final Provider<RenewableTimer> autoDismissTimerAndImpressionTimerProvider;
  
  private final Provider<BindingWrapperFactory> bindingWrapperFactoryProvider;
  
  private final Provider<FirebaseInAppMessaging> headlessInAppMessagingProvider;
  
  private final Provider<FiamImageLoader> imageLoaderProvider;
  
  private final Provider<Map<String, Provider<InAppMessageLayoutConfig>>> layoutConfigsProvider;
  
  private final Provider<FiamWindowManager> windowManagerProvider;
  
  public FirebaseInAppMessagingDisplay_Factory(Provider<FirebaseInAppMessaging> paramProvider, Provider<Map<String, Provider<InAppMessageLayoutConfig>>> paramProvider1, Provider<FiamImageLoader> paramProvider2, Provider<RenewableTimer> paramProvider3, Provider<FiamWindowManager> paramProvider4, Provider<Application> paramProvider5, Provider<BindingWrapperFactory> paramProvider6, Provider<FiamAnimator> paramProvider7) {
    this.headlessInAppMessagingProvider = paramProvider;
    this.layoutConfigsProvider = paramProvider1;
    this.imageLoaderProvider = paramProvider2;
    this.autoDismissTimerAndImpressionTimerProvider = paramProvider3;
    this.windowManagerProvider = paramProvider4;
    this.applicationProvider = paramProvider5;
    this.bindingWrapperFactoryProvider = paramProvider6;
    this.animatorProvider = paramProvider7;
  }
  
  public static Factory<FirebaseInAppMessagingDisplay> create(Provider<FirebaseInAppMessaging> paramProvider, Provider<Map<String, Provider<InAppMessageLayoutConfig>>> paramProvider1, Provider<FiamImageLoader> paramProvider2, Provider<RenewableTimer> paramProvider3, Provider<FiamWindowManager> paramProvider4, Provider<Application> paramProvider5, Provider<BindingWrapperFactory> paramProvider6, Provider<FiamAnimator> paramProvider7) {
    return new FirebaseInAppMessagingDisplay_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7);
  }
  
  public static FirebaseInAppMessagingDisplay newFirebaseInAppMessagingDisplay(FirebaseInAppMessaging paramFirebaseInAppMessaging, Map<String, Provider<InAppMessageLayoutConfig>> paramMap, FiamImageLoader paramFiamImageLoader, RenewableTimer paramRenewableTimer1, RenewableTimer paramRenewableTimer2, FiamWindowManager paramFiamWindowManager, Application paramApplication, BindingWrapperFactory paramBindingWrapperFactory, FiamAnimator paramFiamAnimator) {
    return new FirebaseInAppMessagingDisplay(paramFirebaseInAppMessaging, paramMap, paramFiamImageLoader, paramRenewableTimer1, paramRenewableTimer2, paramFiamWindowManager, paramApplication, paramBindingWrapperFactory, paramFiamAnimator);
  }
  
  public FirebaseInAppMessagingDisplay get() {
    return new FirebaseInAppMessagingDisplay((FirebaseInAppMessaging)this.headlessInAppMessagingProvider.get(), (Map<String, Provider<InAppMessageLayoutConfig>>)this.layoutConfigsProvider.get(), (FiamImageLoader)this.imageLoaderProvider.get(), (RenewableTimer)this.autoDismissTimerAndImpressionTimerProvider.get(), (RenewableTimer)this.autoDismissTimerAndImpressionTimerProvider.get(), (FiamWindowManager)this.windowManagerProvider.get(), (Application)this.applicationProvider.get(), (BindingWrapperFactory)this.bindingWrapperFactoryProvider.get(), (FiamAnimator)this.animatorProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\FirebaseInAppMessagingDisplay_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */