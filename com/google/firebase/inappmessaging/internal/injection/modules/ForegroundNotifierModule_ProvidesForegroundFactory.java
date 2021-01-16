package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ForegroundNotifierModule_ProvidesForegroundFactory implements Factory<ForegroundNotifier> {
  private final ForegroundNotifierModule module;
  
  public ForegroundNotifierModule_ProvidesForegroundFactory(ForegroundNotifierModule paramForegroundNotifierModule) {
    this.module = paramForegroundNotifierModule;
  }
  
  public static Factory<ForegroundNotifier> create(ForegroundNotifierModule paramForegroundNotifierModule) {
    return new ForegroundNotifierModule_ProvidesForegroundFactory(paramForegroundNotifierModule);
  }
  
  public ForegroundNotifier get() {
    return (ForegroundNotifier)Preconditions.checkNotNull(this.module.providesForeground(), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ForegroundNotifierModule_ProvidesForegroundFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */