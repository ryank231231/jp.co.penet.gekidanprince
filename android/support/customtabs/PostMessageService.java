package android.support.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public class PostMessageService extends Service {
  private IPostMessageService.Stub mBinder = new IPostMessageService.Stub() {
      public void onMessageChannelReady(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
        param1ICustomTabsCallback.onMessageChannelReady(param1Bundle);
      }
      
      public void onPostMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {
        param1ICustomTabsCallback.onPostMessage(param1String, param1Bundle);
      }
    };
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)this.mBinder;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\PostMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */