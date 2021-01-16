package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICustomTabsCallback extends IInterface {
  void extraCallback(String paramString, Bundle paramBundle) throws RemoteException;
  
  void onMessageChannelReady(Bundle paramBundle) throws RemoteException;
  
  void onNavigationEvent(int paramInt, Bundle paramBundle) throws RemoteException;
  
  void onPostMessage(String paramString, Bundle paramBundle) throws RemoteException;
  
  void onRelationshipValidationResult(int paramInt, Uri paramUri, boolean paramBoolean, Bundle paramBundle) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ICustomTabsCallback {
    private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";
    
    static final int TRANSACTION_extraCallback = 3;
    
    static final int TRANSACTION_onMessageChannelReady = 4;
    
    static final int TRANSACTION_onNavigationEvent = 2;
    
    static final int TRANSACTION_onPostMessage = 5;
    
    static final int TRANSACTION_onRelationshipValidationResult = 6;
    
    public Stub() {
      attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
    }
    
    public static ICustomTabsCallback asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
      return (iInterface != null && iInterface instanceof ICustomTabsCallback) ? (ICustomTabsCallback)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        String str;
        boolean bool;
        Uri uri = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        Bundle bundle4 = null;
        Bundle bundle5 = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 6:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            param1Int1 = param1Parcel1.readInt();
            if (param1Parcel1.readInt() != 0) {
              uri = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1);
            } else {
              uri = null;
            } 
            if (param1Parcel1.readInt() != 0) {
              bool = true;
            } else {
              bool = false;
            } 
            if (param1Parcel1.readInt() != 0)
              bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            onRelationshipValidationResult(param1Int1, uri, bool, bundle5);
            param1Parcel2.writeNoException();
            return true;
          case 5:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            str = param1Parcel1.readString();
            if (param1Parcel1.readInt() != 0)
              bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            onPostMessage(str, bundle1);
            param1Parcel2.writeNoException();
            return true;
          case 4:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            bundle1 = bundle2;
            if (param1Parcel1.readInt() != 0)
              bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            onMessageChannelReady(bundle1);
            param1Parcel2.writeNoException();
            return true;
          case 3:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
            str = param1Parcel1.readString();
            bundle1 = bundle3;
            if (param1Parcel1.readInt() != 0)
              bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            extraCallback(str, bundle1);
            param1Parcel2.writeNoException();
            return true;
          case 2:
            break;
        } 
        param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsCallback");
        param1Int1 = param1Parcel1.readInt();
        Bundle bundle1 = bundle4;
        if (param1Parcel1.readInt() != 0)
          bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
        onNavigationEvent(param1Int1, bundle1);
        param1Parcel2.writeNoException();
        return true;
      } 
      param1Parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
      return true;
    }
    
    private static class Proxy implements ICustomTabsCallback {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void extraCallback(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
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
      
      public String getInterfaceDescriptor() {
        return "android.support.customtabs.ICustomTabsCallback";
      }
      
      public void onMessageChannelReady(Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onNavigationEvent(int param2Int, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          parcel1.writeInt(param2Int);
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
      
      public void onPostMessage(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void onRelationshipValidationResult(int param2Int, Uri param2Uri, boolean param2Boolean, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
          parcel1.writeInt(param2Int);
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Boolean) {
            param2Int = 1;
          } else {
            param2Int = 0;
          } 
          parcel1.writeInt(param2Int);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements ICustomTabsCallback {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void extraCallback(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
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
    
    public String getInterfaceDescriptor() {
      return "android.support.customtabs.ICustomTabsCallback";
    }
    
    public void onMessageChannelReady(Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onNavigationEvent(int param1Int, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        parcel1.writeInt(param1Int);
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
    
    public void onPostMessage(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void onRelationshipValidationResult(int param1Int, Uri param1Uri, boolean param1Boolean, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
        parcel1.writeInt(param1Int);
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Boolean) {
          param1Int = 1;
        } else {
          param1Int = 0;
        } 
        parcel1.writeInt(param1Int);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\ICustomTabsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */