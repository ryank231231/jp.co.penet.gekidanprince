package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class CustomTabsService extends Service {
  public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
  
  public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
  
  public static final int RELATION_HANDLE_ALL_URLS = 2;
  
  public static final int RELATION_USE_AS_ORIGIN = 1;
  
  public static final int RESULT_FAILURE_DISALLOWED = -1;
  
  public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
  
  public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
  
  public static final int RESULT_SUCCESS = 0;
  
  private ICustomTabsService.Stub mBinder = new ICustomTabsService.Stub() {
      public Bundle extraCommand(String param1String, Bundle param1Bundle) {
        return CustomTabsService.this.extraCommand(param1String, param1Bundle);
      }
      
      public boolean mayLaunchUrl(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, Bundle param1Bundle, List<Bundle> param1List) {
        return CustomTabsService.this.mayLaunchUrl(new CustomTabsSessionToken(param1ICustomTabsCallback), param1Uri, param1Bundle, param1List);
      }
      
      public boolean newSession(ICustomTabsCallback param1ICustomTabsCallback) {
        CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(param1ICustomTabsCallback);
        try {
          IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() {
              public void binderDied() {
                CustomTabsService.this.cleanUpSession(sessionToken);
              }
            };
          super(customTabsSessionToken);
          synchronized (CustomTabsService.this.mDeathRecipientMap) {
            param1ICustomTabsCallback.asBinder().linkToDeath(deathRecipient, 0);
            CustomTabsService.this.mDeathRecipientMap.put(param1ICustomTabsCallback.asBinder(), deathRecipient);
            return CustomTabsService.this.newSession(customTabsSessionToken);
          } 
        } catch (RemoteException remoteException) {
          return false;
        } 
      }
      
      public int postMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) {
        return CustomTabsService.this.postMessage(new CustomTabsSessionToken(param1ICustomTabsCallback), param1String, param1Bundle);
      }
      
      public boolean requestPostMessageChannel(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri) {
        return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(param1ICustomTabsCallback), param1Uri);
      }
      
      public boolean updateVisuals(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) {
        return CustomTabsService.this.updateVisuals(new CustomTabsSessionToken(param1ICustomTabsCallback), param1Bundle);
      }
      
      public boolean validateRelationship(ICustomTabsCallback param1ICustomTabsCallback, int param1Int, Uri param1Uri, Bundle param1Bundle) {
        return CustomTabsService.this.validateRelationship(new CustomTabsSessionToken(param1ICustomTabsCallback), param1Int, param1Uri, param1Bundle);
      }
      
      public boolean warmup(long param1Long) {
        return CustomTabsService.this.warmup(param1Long);
      }
    };
  
  private final Map<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = (Map<IBinder, IBinder.DeathRecipient>)new ArrayMap();
  
  protected boolean cleanUpSession(CustomTabsSessionToken paramCustomTabsSessionToken) {
    try {
      synchronized (this.mDeathRecipientMap) {
        IBinder iBinder = paramCustomTabsSessionToken.getCallbackBinder();
        iBinder.unlinkToDeath(this.mDeathRecipientMap.get(iBinder), 0);
        this.mDeathRecipientMap.remove(iBinder);
        return true;
      } 
    } catch (NoSuchElementException noSuchElementException) {
      return false;
    } 
  }
  
  protected abstract Bundle extraCommand(String paramString, Bundle paramBundle);
  
  protected abstract boolean mayLaunchUrl(CustomTabsSessionToken paramCustomTabsSessionToken, Uri paramUri, Bundle paramBundle, List<Bundle> paramList);
  
  protected abstract boolean newSession(CustomTabsSessionToken paramCustomTabsSessionToken);
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)this.mBinder;
  }
  
  protected abstract int postMessage(CustomTabsSessionToken paramCustomTabsSessionToken, String paramString, Bundle paramBundle);
  
  protected abstract boolean requestPostMessageChannel(CustomTabsSessionToken paramCustomTabsSessionToken, Uri paramUri);
  
  protected abstract boolean updateVisuals(CustomTabsSessionToken paramCustomTabsSessionToken, Bundle paramBundle);
  
  protected abstract boolean validateRelationship(CustomTabsSessionToken paramCustomTabsSessionToken, int paramInt, Uri paramUri, Bundle paramBundle);
  
  protected abstract boolean warmup(long paramLong);
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Relation {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Result {}
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\CustomTabsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */