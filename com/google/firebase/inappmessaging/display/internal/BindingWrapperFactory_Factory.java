package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BindingWrapperFactory_Factory implements Factory<BindingWrapperFactory> {
  private final Provider<Application> applicationProvider;
  
  public BindingWrapperFactory_Factory(Provider<Application> paramProvider) {
    this.applicationProvider = paramProvider;
  }
  
  public static Factory<BindingWrapperFactory> create(Provider<Application> paramProvider) {
    return new BindingWrapperFactory_Factory(paramProvider);
  }
  
  public static BindingWrapperFactory newBindingWrapperFactory(Application paramApplication) {
    return new BindingWrapperFactory(paramApplication);
  }
  
  public BindingWrapperFactory get() {
    return new BindingWrapperFactory((Application)this.applicationProvider.get());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\BindingWrapperFactory_Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */