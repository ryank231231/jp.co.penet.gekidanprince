package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  
  private static final Object lock;
  
  private static final GoogleApiAvailabilityLight zziv = GoogleApiAvailabilityLight.getInstance();
  
  private static Method zziw;
  
  static {
    lock = new Object();
    zziw = null;
  }
  
  public static void installIfNeeded(Context paramContext) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    zziv.verifyGooglePlayServicesIsAvailable(paramContext, 11925000);
    Context context1 = zzk(paramContext);
    Context context2 = context1;
    if (context1 == null)
      context2 = zzl(paramContext); 
    if (context2 != null) {
      Object object = lock;
      /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      try {
        if (zziw == null)
          zziw = context2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[] { Context.class }); 
        zziw.invoke(null, new Object[] { context2 });
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
        return;
      } catch (Exception null) {
        Throwable throwable1;
        Throwable throwable2 = throwable1.getCause();
        if (Log.isLoggable("ProviderInstaller", 6)) {
          if (throwable2 == null) {
            str = throwable1.getMessage();
          } else {
            str = throwable2.getMessage();
          } 
          String str = String.valueOf(str);
          if (str.length() != 0) {
            str = "Failed to install provider: ".concat(str);
          } else {
            str = new String("Failed to install provider: ");
          } 
          Log.e("ProviderInstaller", str);
        } 
        if (throwable2 != null)
          throwable1 = throwable2; 
        CrashUtils.addDynamiteErrorToDropBox(paramContext, throwable1);
        GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException = new GooglePlayServicesNotAvailableException();
        this(8);
        throw googlePlayServicesNotAvailableException;
      } finally {}
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      throw paramContext;
    } 
    Log.e("ProviderInstaller", "Failed to get remote context");
    throw new GooglePlayServicesNotAvailableException(8);
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener) {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    (new zza(paramContext, paramProviderInstallListener)).execute((Object[])new Void[0]);
  }
  
  @Nullable
  private static Context zzk(Context paramContext) {
    try {
      return DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
    } catch (com.google.android.gms.dynamite.DynamiteModule.LoadingException loadingException) {
      String str = String.valueOf(loadingException.getMessage());
      if (str.length() != 0) {
        str = "Failed to load providerinstaller module: ".concat(str);
      } else {
        str = new String("Failed to load providerinstaller module: ");
      } 
      Log.w("ProviderInstaller", str);
      return null;
    } 
  }
  
  @Nullable
  private static Context zzl(Context paramContext) {
    try {
      return GooglePlayServicesUtilLight.getRemoteContext(paramContext);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      String str = String.valueOf(notFoundException.getMessage());
      if (str.length() != 0) {
        str = "Failed to load GMS Core context for providerinstaller: ".concat(str);
      } else {
        str = new String("Failed to load GMS Core context for providerinstaller: ");
      } 
      Log.w("ProviderInstaller", str);
      CrashUtils.addDynamiteErrorToDropBox(paramContext, (Throwable)notFoundException);
      return null;
    } 
  }
  
  public static interface ProviderInstallListener {
    void onProviderInstallFailed(int param1Int, Intent param1Intent);
    
    void onProviderInstalled();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\security\ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */