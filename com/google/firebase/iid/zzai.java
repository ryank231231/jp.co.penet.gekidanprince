package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

final class zzai {
  private final Messenger zzai;
  
  private final zzl zzcf;
  
  zzai(IBinder paramIBinder) throws RemoteException {
    String str2 = paramIBinder.getInterfaceDescriptor();
    if ("android.os.IMessenger".equals(str2)) {
      this.zzai = new Messenger(paramIBinder);
      this.zzcf = null;
      return;
    } 
    if ("com.google.android.gms.iid.IMessengerCompat".equals(str2)) {
      this.zzcf = new zzl(paramIBinder);
      this.zzai = null;
      return;
    } 
    String str1 = String.valueOf(str2);
    if (str1.length() != 0) {
      str1 = "Invalid interface descriptor: ".concat(str1);
    } else {
      str1 = new String("Invalid interface descriptor: ");
    } 
    Log.w("MessengerIpcClient", str1);
    throw new RemoteException();
  }
  
  final void send(Message paramMessage) throws RemoteException {
    Messenger messenger = this.zzai;
    if (messenger != null) {
      messenger.send(paramMessage);
      return;
    } 
    zzl zzl1 = this.zzcf;
    if (zzl1 != null) {
      zzl1.send(paramMessage);
      return;
    } 
    throw new IllegalStateException("Both messengers are null");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\iid\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */