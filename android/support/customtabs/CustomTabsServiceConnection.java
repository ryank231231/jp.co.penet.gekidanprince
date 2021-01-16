package android.support.customtabs;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public abstract class CustomTabsServiceConnection implements ServiceConnection {
  public abstract void onCustomTabsServiceConnected(ComponentName paramComponentName, CustomTabsClient paramCustomTabsClient);
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    onCustomTabsServiceConnected(paramComponentName, new CustomTabsClient(ICustomTabsService.Stub.asInterface(paramIBinder), paramComponentName) {
        
        });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\CustomTabsServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */