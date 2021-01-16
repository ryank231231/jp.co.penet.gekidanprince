package android.support.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {
  private final ICustomTabsService mService;
  
  private final ComponentName mServiceComponentName;
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  CustomTabsClient(ICustomTabsService paramICustomTabsService, ComponentName paramComponentName) {
    this.mService = paramICustomTabsService;
    this.mServiceComponentName = paramComponentName;
  }
  
  public static boolean bindCustomTabsService(Context paramContext, String paramString, CustomTabsServiceConnection paramCustomTabsServiceConnection) {
    Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
    if (!TextUtils.isEmpty(paramString))
      intent.setPackage(paramString); 
    return paramContext.bindService(intent, paramCustomTabsServiceConnection, 33);
  }
  
  public static boolean connectAndInitialize(final Context applicationContext, String paramString) {
    if (paramString == null)
      return false; 
    applicationContext = applicationContext.getApplicationContext();
    CustomTabsServiceConnection customTabsServiceConnection = new CustomTabsServiceConnection() {
        public final void onCustomTabsServiceConnected(ComponentName param1ComponentName, CustomTabsClient param1CustomTabsClient) {
          param1CustomTabsClient.warmup(0L);
          applicationContext.unbindService(this);
        }
        
        public final void onServiceDisconnected(ComponentName param1ComponentName) {}
      };
    try {
      return bindCustomTabsService(applicationContext, paramString, customTabsServiceConnection);
    } catch (SecurityException securityException) {
      return false;
    } 
  }
  
  public static String getPackageName(Context paramContext, @Nullable List<String> paramList) {
    return getPackageName(paramContext, paramList, false);
  }
  
  public static String getPackageName(Context paramContext, @Nullable List<String> paramList, boolean paramBoolean) {
    List<String> list1;
    PackageManager packageManager = paramContext.getPackageManager();
    if (paramList == null) {
      list1 = new ArrayList();
    } else {
      list1 = paramList;
    } 
    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
    List<String> list2 = list1;
    if (!paramBoolean) {
      ResolveInfo resolveInfo = packageManager.resolveActivity(intent2, 0);
      list2 = list1;
      if (resolveInfo != null) {
        String str = resolveInfo.activityInfo.packageName;
        list2 = new ArrayList<String>(list1.size() + 1);
        list2.add(str);
        if (paramList != null)
          list2.addAll(paramList); 
      } 
    } 
    Intent intent1 = new Intent("android.support.customtabs.action.CustomTabsService");
    for (String str : list2) {
      intent1.setPackage(str);
      if (packageManager.resolveService(intent1, 0) != null)
        return str; 
    } 
    return null;
  }
  
  public Bundle extraCommand(String paramString, Bundle paramBundle) {
    try {
      return this.mService.extraCommand(paramString, paramBundle);
    } catch (RemoteException remoteException) {
      return null;
    } 
  }
  
  public CustomTabsSession newSession(final CustomTabsCallback callback) {
    ICustomTabsCallback.Stub stub = new ICustomTabsCallback.Stub() {
        private Handler mHandler = new Handler(Looper.getMainLooper());
        
        public void extraCallback(final String callbackName, final Bundle args) throws RemoteException {
          if (callback == null)
            return; 
          this.mHandler.post(new Runnable() {
                public void run() {
                  callback.extraCallback(callbackName, args);
                }
              });
        }
        
        public void onMessageChannelReady(final Bundle extras) throws RemoteException {
          if (callback == null)
            return; 
          this.mHandler.post(new Runnable() {
                public void run() {
                  callback.onMessageChannelReady(extras);
                }
              });
        }
        
        public void onNavigationEvent(final int navigationEvent, final Bundle extras) {
          if (callback == null)
            return; 
          this.mHandler.post(new Runnable() {
                public void run() {
                  callback.onNavigationEvent(navigationEvent, extras);
                }
              });
        }
        
        public void onPostMessage(final String message, final Bundle extras) throws RemoteException {
          if (callback == null)
            return; 
          this.mHandler.post(new Runnable() {
                public void run() {
                  callback.onPostMessage(message, extras);
                }
              });
        }
        
        public void onRelationshipValidationResult(final int relation, final Uri requestedOrigin, final boolean result, @Nullable final Bundle extras) throws RemoteException {
          if (callback == null)
            return; 
          this.mHandler.post(new Runnable() {
                public void run() {
                  callback.onRelationshipValidationResult(relation, requestedOrigin, result, extras);
                }
              });
        }
      };
    try {
      boolean bool = this.mService.newSession(stub);
      return !bool ? null : new CustomTabsSession(this.mService, stub, this.mServiceComponentName);
    } catch (RemoteException remoteException) {
      return null;
    } 
  }
  
  public boolean warmup(long paramLong) {
    try {
      return this.mService.warmup(paramLong);
    } catch (RemoteException remoteException) {
      return false;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\CustomTabsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */