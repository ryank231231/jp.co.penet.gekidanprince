package android.support.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

public abstract class PostMessageServiceConnection implements ServiceConnection {
  private final Object mLock = new Object();
  
  private IPostMessageService mService;
  
  private final ICustomTabsCallback mSessionBinder;
  
  public PostMessageServiceConnection(CustomTabsSessionToken paramCustomTabsSessionToken) {
    this.mSessionBinder = ICustomTabsCallback.Stub.asInterface(paramCustomTabsSessionToken.getCallbackBinder());
  }
  
  public boolean bindSessionToPostMessageService(Context paramContext, String paramString) {
    Intent intent = new Intent();
    intent.setClassName(paramString, PostMessageService.class.getName());
    return paramContext.bindService(intent, this, 1);
  }
  
  public final boolean notifyMessageChannelReady(Bundle paramBundle) {
    if (this.mService == null)
      return false; 
    Object object = this.mLock;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      this.mService.onMessageChannelReady(this.mSessionBinder, paramBundle);
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      return true;
    } catch (RemoteException remoteException) {
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      return false;
    } finally {}
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    throw paramBundle;
  }
  
  public void onPostMessageServiceConnected() {}
  
  public void onPostMessageServiceDisconnected() {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    this.mService = IPostMessageService.Stub.asInterface(paramIBinder);
    onPostMessageServiceConnected();
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    this.mService = null;
    onPostMessageServiceDisconnected();
  }
  
  public final boolean postMessage(String paramString, Bundle paramBundle) {
    if (this.mService == null)
      return false; 
    Object object = this.mLock;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      this.mService.onPostMessage(this.mSessionBinder, paramString, paramBundle);
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      return true;
    } catch (RemoteException remoteException) {
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
      return false;
    } finally {}
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    throw paramString;
  }
  
  public void unbindFromContext(Context paramContext) {
    paramContext.unbindService(this);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\PostMessageServiceConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */