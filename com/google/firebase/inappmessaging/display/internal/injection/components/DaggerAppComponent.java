package com.google.firebase.inappmessaging.display.internal.injection.components;

import android.app.Application;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay_Factory;
import com.google.firebase.inappmessaging.display.internal.BindingWrapperFactory;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator;
import com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader_Factory;
import com.google.firebase.inappmessaging.display.internal.FiamWindowManager;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener_Factory;
import com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.PicassoModule_ProvidesFiamControllerFactory;
import com.squareup.picasso.Picasso;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.inject.Provider;

public final class DaggerAppComponent implements AppComponent {
  private Provider<FiamAnimator> fiamAnimatorProvider;
  
  private Provider<FiamImageLoader> fiamImageLoaderProvider;
  
  private Provider<FiamWindowManager> fiamWindowManagerProvider;
  
  private Provider<FirebaseInAppMessagingDisplay> firebaseInAppMessagingDisplayProvider;
  
  private Provider<BindingWrapperFactory> inflaterClientProvider;
  
  private Provider<Map<String, Provider<InAppMessageLayoutConfig>>> myKeyStringMapProvider;
  
  private Provider<PicassoErrorListener> picassoErrorListenerProvider;
  
  private Provider<Application> providesApplicationProvider;
  
  private Provider<Picasso> providesFiamControllerProvider;
  
  private Provider<FirebaseInAppMessaging> providesHeadlesssSingletonProvider;
  
  private DaggerAppComponent(Builder paramBuilder) {
    initialize(paramBuilder);
  }
  
  public static Builder builder() {
    return new Builder();
  }
  
  private void initialize(Builder paramBuilder) {
    this.providesHeadlesssSingletonProvider = DoubleCheck.provider((Provider)HeadlessInAppMessagingModule_ProvidesHeadlesssSingletonFactory.create(paramBuilder.headlessInAppMessagingModule));
    this.myKeyStringMapProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap(paramBuilder.universalComponent);
    this.providesApplicationProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication(paramBuilder.universalComponent);
    this.picassoErrorListenerProvider = DoubleCheck.provider((Provider)PicassoErrorListener_Factory.create());
    this.providesFiamControllerProvider = DoubleCheck.provider((Provider)PicassoModule_ProvidesFiamControllerFactory.create(paramBuilder.picassoModule, this.providesApplicationProvider, this.picassoErrorListenerProvider));
    this.fiamImageLoaderProvider = DoubleCheck.provider((Provider)FiamImageLoader_Factory.create(this.providesFiamControllerProvider));
    this.fiamWindowManagerProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager(paramBuilder.universalComponent);
    this.inflaterClientProvider = new com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient(paramBuilder.universalComponent);
    this.fiamAnimatorProvider = DoubleCheck.provider((Provider)FiamAnimator_Factory.create());
    this.firebaseInAppMessagingDisplayProvider = DoubleCheck.provider((Provider)FirebaseInAppMessagingDisplay_Factory.create(this.providesHeadlesssSingletonProvider, this.myKeyStringMapProvider, this.fiamImageLoaderProvider, (Provider)RenewableTimer_Factory.create(), this.fiamWindowManagerProvider, this.providesApplicationProvider, this.inflaterClientProvider, this.fiamAnimatorProvider));
  }
  
  public FiamImageLoader fiamImageLoader() {
    return (FiamImageLoader)this.fiamImageLoaderProvider.get();
  }
  
  public PicassoErrorListener picassoErrorListener() {
    return (PicassoErrorListener)this.picassoErrorListenerProvider.get();
  }
  
  public FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI() {
    return (FirebaseInAppMessagingDisplay)this.firebaseInAppMessagingDisplayProvider.get();
  }
  
  public static final class Builder {
    private HeadlessInAppMessagingModule headlessInAppMessagingModule;
    
    private PicassoModule picassoModule;
    
    private UniversalComponent universalComponent;
    
    private Builder() {}
    
    public AppComponent build() {
      if (this.headlessInAppMessagingModule != null) {
        if (this.picassoModule == null)
          this.picassoModule = new PicassoModule(); 
        if (this.universalComponent != null)
          return new DaggerAppComponent(this); 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(UniversalComponent.class.getCanonicalName());
        stringBuilder1.append(" must be set");
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(HeadlessInAppMessagingModule.class.getCanonicalName());
      stringBuilder.append(" must be set");
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public Builder headlessInAppMessagingModule(HeadlessInAppMessagingModule param1HeadlessInAppMessagingModule) {
      this.headlessInAppMessagingModule = (HeadlessInAppMessagingModule)Preconditions.checkNotNull(param1HeadlessInAppMessagingModule);
      return this;
    }
    
    public Builder picassoModule(PicassoModule param1PicassoModule) {
      this.picassoModule = (PicassoModule)Preconditions.checkNotNull(param1PicassoModule);
      return this;
    }
    
    public Builder universalComponent(UniversalComponent param1UniversalComponent) {
      this.universalComponent = (UniversalComponent)Preconditions.checkNotNull(param1UniversalComponent);
      return this;
    }
  }
  
  private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager implements Provider<FiamWindowManager> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_fiamWindowManager(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public FiamWindowManager get() {
      return (FiamWindowManager)Preconditions.checkNotNull(this.universalComponent.fiamWindowManager(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient implements Provider<BindingWrapperFactory> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_inflaterClient(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public BindingWrapperFactory get() {
      return (BindingWrapperFactory)Preconditions.checkNotNull(this.universalComponent.inflaterClient(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap implements Provider<Map<String, Provider<InAppMessageLayoutConfig>>> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_myKeyStringMap(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Map<String, Provider<InAppMessageLayoutConfig>> get() {
      return (Map<String, Provider<InAppMessageLayoutConfig>>)Preconditions.checkNotNull(this.universalComponent.myKeyStringMap(), "Cannot return null from a non-@Nullable component method");
    }
  }
  
  private static class com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication implements Provider<Application> {
    private final UniversalComponent universalComponent;
    
    com_google_firebase_inappmessaging_display_internal_injection_components_UniversalComponent_providesApplication(UniversalComponent param1UniversalComponent) {
      this.universalComponent = param1UniversalComponent;
    }
    
    public Application get() {
      return (Application)Preconditions.checkNotNull(this.universalComponent.providesApplication(), "Cannot return null from a non-@Nullable component method");
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\components\DaggerAppComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */