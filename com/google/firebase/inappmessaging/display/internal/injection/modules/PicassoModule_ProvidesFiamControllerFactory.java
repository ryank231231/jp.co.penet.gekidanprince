package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.squareup.picasso.Picasso;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PicassoModule_ProvidesFiamControllerFactory implements Factory<Picasso> {
  private final Provider<Application> applicationProvider;
  
  private final PicassoModule module;
  
  private final Provider<PicassoErrorListener> picassoErrorListenerProvider;
  
  public PicassoModule_ProvidesFiamControllerFactory(PicassoModule paramPicassoModule, Provider<Application> paramProvider, Provider<PicassoErrorListener> paramProvider1) {
    this.module = paramPicassoModule;
    this.applicationProvider = paramProvider;
    this.picassoErrorListenerProvider = paramProvider1;
  }
  
  public static Factory<Picasso> create(PicassoModule paramPicassoModule, Provider<Application> paramProvider, Provider<PicassoErrorListener> paramProvider1) {
    return new PicassoModule_ProvidesFiamControllerFactory(paramPicassoModule, paramProvider, paramProvider1);
  }
  
  public static Picasso proxyProvidesFiamController(PicassoModule paramPicassoModule, Application paramApplication, PicassoErrorListener paramPicassoErrorListener) {
    return paramPicassoModule.providesFiamController(paramApplication, paramPicassoErrorListener);
  }
  
  public Picasso get() {
    return (Picasso)Preconditions.checkNotNull(this.module.providesFiamController((Application)this.applicationProvider.get(), (PicassoErrorListener)this.picassoErrorListenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\inappmessaging\display\internal\injection\modules\PicassoModule_ProvidesFiamControllerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */