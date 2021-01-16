package com.google.firebase.inappmessaging.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.internal.ForegroundNotifier;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.flowables.ConnectableFlowable;
import javax.inject.Provider;

public final class ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory implements Factory<ConnectableFlowable<String>> {
  private final Provider<Application> applicationProvider;
  
  private final Provider<ForegroundNotifier> foregroundProvider;
  
  private final ForegroundFlowableModule module;
  
  public ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(ForegroundFlowableModule paramForegroundFlowableModule, Provider<Application> paramProvider, Provider<ForegroundNotifier> paramProvider1) {
    this.module = paramForegroundFlowableModule;
    this.applicationProvider = paramProvider;
    this.foregroundProvider = paramProvider1;
  }
  
  public static Factory<ConnectableFlowable<String>> create(ForegroundFlowableModule paramForegroundFlowableModule, Provider<Application> paramProvider, Provider<ForegroundNotifier> paramProvider1) {
    return new ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory(paramForegroundFlowableModule, paramProvider, paramProvider1);
  }
  
  public ConnectableFlowable<String> get() {
    return (ConnectableFlowable<String>)Preconditions.checkNotNull(this.module.providesAppForegroundEventStream((Application)this.applicationProvider.get(), (ForegroundNotifier)this.foregroundProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\internal\injection\modules\ForegroundFlowableModule_ProvidesAppForegroundEventStreamFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */