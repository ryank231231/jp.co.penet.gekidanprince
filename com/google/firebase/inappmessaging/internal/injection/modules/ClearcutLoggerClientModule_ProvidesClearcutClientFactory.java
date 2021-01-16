package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.android.gms.clearcut.ClearcutLogger;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ClearcutLoggerClientModule_ProvidesClearcutClientFactory implements Factory<ClearcutLogger> {
  private final Provider<Application> applicationProvider;
  
  private final ClearcutLoggerClientModule module;
  
  public ClearcutLoggerClientModule_ProvidesClearcutClientFactory(ClearcutLoggerClientModule paramClearcutLoggerClientModule, Provider<Application> paramProvider) {
    this.module = paramClearcutLoggerClientModule;
    this.applicationProvider = paramProvider;
  }
  
  public static Factory<ClearcutLogger> create(ClearcutLoggerClientModule paramClearcutLoggerClientModule, Provider<Application> paramProvider) {
    return new ClearcutLoggerClientModule_ProvidesClearcutClientFactory(paramClearcutLoggerClientModule, paramProvider);
  }
  
  public ClearcutLogger get() {
    return (ClearcutLogger)Preconditions.checkNotNull(this.module.providesClearcutClient((Application)this.applicationProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ClearcutLoggerClientModule_ProvidesClearcutClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */