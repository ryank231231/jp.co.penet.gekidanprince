package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public abstract class RemoteCreator<T> {
  private final String zzic;
  
  private T zzid;
  
  @KeepForSdk
  protected RemoteCreator(String paramString) {
    this.zzic = paramString;
  }
  
  @KeepForSdk
  protected abstract T getRemoteCreator(IBinder paramIBinder);
  
  @KeepForSdk
  protected final T getRemoteCreatorInstance(Context paramContext) throws RemoteCreatorException {
    if (this.zzid == null) {
      Preconditions.checkNotNull(paramContext);
      paramContext = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      if (paramContext != null) {
        ClassLoader classLoader = paramContext.getClassLoader();
        try {
          this.zzid = getRemoteCreator((IBinder)classLoader.loadClass(this.zzic).newInstance());
        } catch (ClassNotFoundException classNotFoundException) {
          throw new RemoteCreatorException("Could not load creator class.", classNotFoundException);
        } catch (InstantiationException instantiationException) {
          throw new RemoteCreatorException("Could not instantiate creator.", instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          throw new RemoteCreatorException("Could not access creator.", illegalAccessException);
        } 
      } else {
        throw new RemoteCreatorException("Could not get remote context.");
      } 
    } 
    return this.zzid;
  }
  
  @KeepForSdk
  public static class RemoteCreatorException extends Exception {
    public RemoteCreatorException(String param1String) {
      super(param1String);
    }
    
    public RemoteCreatorException(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\dynamic\RemoteCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */