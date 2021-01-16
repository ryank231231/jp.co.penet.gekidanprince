package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPostMessageService extends IInterface {
  void onMessageChannelReady(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle) throws RemoteException;
  
  void onPostMessage(ICustomTabsCallback paramICustomTabsCallback, String paramString, Bundle paramBundle) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IPostMessageService {
    private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
    
    static final int TRANSACTION_onMessageChannelReady = 2;
    
    static final int TRANSACTION_onPostMessage = 3;
    
    public Stub() {
      attachInterface(this, "android.support.customtabs.IPostMessageService");
    }
    
    public static IPostMessageService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.customtabs.IPostMessageService");
      return (iInterface != null && iInterface instanceof IPostMessageService) ? (IPostMessageService)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        Bundle bundle1;
        String str;
        ICustomTabsCallback iCustomTabsCallback1 = null;
        Bundle bundle2 = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 3:
            param1Parcel1.enforceInterface("android.support.customtabs.IPostMessageService");
            iCustomTabsCallback1 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
            str = param1Parcel1.readString();
            if (param1Parcel1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            onPostMessage(iCustomTabsCallback1, str, bundle2);
            param1Parcel2.writeNoException();
            return true;
          case 2:
            break;
        } 
        param1Parcel1.enforceInterface("android.support.customtabs.IPostMessageService");
        ICustomTabsCallback iCustomTabsCallback3 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
        ICustomTabsCallback iCustomTabsCallback2 = iCustomTabsCallback1;
        if (param1Parcel1.readInt() != 0)
          bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
        onMessageChannelReady(iCustomTabsCallback3, bundle1);
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("android.support.customtabs.IPostMessageService");
      return true;
    }
    
    private static class Proxy implements IPostMessageService {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor() {
        return "android.support.customtabs.IPostMessageService";
      }
      
      public void onMessageChannelReady(ICustomTabsCallback param2ICustomTabsCallback, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.IPostMessageService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onPostMessage(ICustomTabsCallback param2ICustomTabsCallback, String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.IPostMessageService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IPostMessageService {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public String getInterfaceDescriptor() {
      return "android.support.customtabs.IPostMessageService";
    }
    
    public void onMessageChannelReady(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.IPostMessageService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onPostMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.IPostMessageService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\IPostMessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */