package android.support.customtabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.app.BundleCompat;
import android.util.Log;

public class CustomTabsSessionToken {
  private static final String TAG = "CustomTabsSessionToken";
  
  private final CustomTabsCallback mCallback;
  
  private final ICustomTabsCallback mCallbackBinder;
  
  CustomTabsSessionToken(ICustomTabsCallback paramICustomTabsCallback) {
    this.mCallbackBinder = paramICustomTabsCallback;
    this.mCallback = new CustomTabsCallback() {
        public void extraCallback(String param1String, Bundle param1Bundle) {
          try {
            CustomTabsSessionToken.this.mCallbackBinder.extraCallback(param1String, param1Bundle);
          } catch (RemoteException remoteException) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
          } 
        }
        
        public void onMessageChannelReady(Bundle param1Bundle) {
          try {
            CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(param1Bundle);
          } catch (RemoteException remoteException) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
          } 
        }
        
        public void onNavigationEvent(int param1Int, Bundle param1Bundle) {
          try {
            CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(param1Int, param1Bundle);
          } catch (RemoteException remoteException) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
          } 
        }
        
        public void onPostMessage(String param1String, Bundle param1Bundle) {
          try {
            CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(param1String, param1Bundle);
          } catch (RemoteException remoteException) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
          } 
        }
        
        public void onRelationshipValidationResult(int param1Int, Uri param1Uri, boolean param1Boolean, Bundle param1Bundle) {
          try {
            CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(param1Int, param1Uri, param1Boolean, param1Bundle);
          } catch (RemoteException remoteException) {
            Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
          } 
        }
      };
  }
  
  @NonNull
  public static CustomTabsSessionToken createMockSessionTokenForTesting() {
    return new CustomTabsSessionToken(new MockCallback());
  }
  
  public static CustomTabsSessionToken getSessionTokenFromIntent(Intent paramIntent) {
    IBinder iBinder = BundleCompat.getBinder(paramIntent.getExtras(), "android.support.customtabs.extra.SESSION");
    return (iBinder == null) ? null : new CustomTabsSessionToken(ICustomTabsCallback.Stub.asInterface(iBinder));
  }
  
  public boolean equals(Object paramObject) {
    return !(paramObject instanceof CustomTabsSessionToken) ? false : ((CustomTabsSessionToken)paramObject).getCallbackBinder().equals(this.mCallbackBinder.asBinder());
  }
  
  public CustomTabsCallback getCallback() {
    return this.mCallback;
  }
  
  IBinder getCallbackBinder() {
    return this.mCallbackBinder.asBinder();
  }
  
  public int hashCode() {
    return getCallbackBinder().hashCode();
  }
  
  public boolean isAssociatedWith(CustomTabsSession paramCustomTabsSession) {
    return paramCustomTabsSession.getBinder().equals(this.mCallbackBinder);
  }
  
  static class MockCallback extends ICustomTabsCallback.Stub {
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public void extraCallback(String param1String, Bundle param1Bundle) {}
    
    public void onMessageChannelReady(Bundle param1Bundle) {}
    
    public void onNavigationEvent(int param1Int, Bundle param1Bundle) {}
    
    public void onPostMessage(String param1String, Bundle param1Bundle) {}
    
    public void onRelationshipValidationResult(int param1Int, Uri param1Uri, boolean param1Boolean, Bundle param1Bundle) {}
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\CustomTabsSessionToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */