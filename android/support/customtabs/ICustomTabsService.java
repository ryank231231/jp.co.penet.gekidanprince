package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICustomTabsService extends IInterface {
  Bundle extraCommand(String paramString, Bundle paramBundle) throws RemoteException;
  
  boolean mayLaunchUrl(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri, Bundle paramBundle, List<Bundle> paramList) throws RemoteException;
  
  boolean newSession(ICustomTabsCallback paramICustomTabsCallback) throws RemoteException;
  
  int postMessage(ICustomTabsCallback paramICustomTabsCallback, String paramString, Bundle paramBundle) throws RemoteException;
  
  boolean requestPostMessageChannel(ICustomTabsCallback paramICustomTabsCallback, Uri paramUri) throws RemoteException;
  
  boolean updateVisuals(ICustomTabsCallback paramICustomTabsCallback, Bundle paramBundle) throws RemoteException;
  
  boolean validateRelationship(ICustomTabsCallback paramICustomTabsCallback, int paramInt, Uri paramUri, Bundle paramBundle) throws RemoteException;
  
  boolean warmup(long paramLong) throws RemoteException;
  
  public static abstract class Stub extends Binder implements ICustomTabsService {
    private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsService";
    
    static final int TRANSACTION_extraCommand = 5;
    
    static final int TRANSACTION_mayLaunchUrl = 4;
    
    static final int TRANSACTION_newSession = 3;
    
    static final int TRANSACTION_postMessage = 8;
    
    static final int TRANSACTION_requestPostMessageChannel = 7;
    
    static final int TRANSACTION_updateVisuals = 6;
    
    static final int TRANSACTION_validateRelationship = 9;
    
    static final int TRANSACTION_warmup = 2;
    
    public Stub() {
      attachInterface(this, "android.support.customtabs.ICustomTabsService");
    }
    
    public static ICustomTabsService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
      return (iInterface != null && iInterface instanceof ICustomTabsService) ? (ICustomTabsService)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        boolean bool2;
        int i;
        Bundle bundle1;
        Bundle bundle3;
        Uri uri1;
        Bundle bundle2;
        ICustomTabsCallback iCustomTabsCallback1;
        String str2;
        ICustomTabsCallback iCustomTabsCallback4;
        String str1;
        ICustomTabsCallback iCustomTabsCallback3;
        Bundle bundle6;
        Uri uri2 = null;
        Bundle bundle4 = null;
        Uri uri3 = null;
        Bundle bundle5 = null;
        ICustomTabsCallback iCustomTabsCallback2 = null;
        Bundle bundle7 = null;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 9:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            iCustomTabsCallback2 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
            param1Int1 = param1Parcel1.readInt();
            if (param1Parcel1.readInt() != 0) {
              uri2 = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1);
            } else {
              uri2 = null;
            } 
            if (param1Parcel1.readInt() != 0)
              bundle7 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            bool2 = validateRelationship(iCustomTabsCallback2, param1Int1, uri2, bundle7);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(bool2);
            return true;
          case 8:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            iCustomTabsCallback2 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
            str2 = param1Parcel1.readString();
            if (param1Parcel1.readInt() != 0)
              bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            i = postMessage(iCustomTabsCallback2, str2, bundle3);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(i);
            return true;
          case 7:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            iCustomTabsCallback4 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
            bundle3 = bundle4;
            if (param1Parcel1.readInt() != 0)
              uri1 = (Uri)Uri.CREATOR.createFromParcel(param1Parcel1); 
            bool1 = requestPostMessageChannel(iCustomTabsCallback4, uri1);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(bool1);
            return true;
          case 6:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            iCustomTabsCallback4 = ICustomTabsCallback.Stub.asInterface(param1Parcel1.readStrongBinder());
            uri1 = uri3;
            if (param1Parcel1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            bool1 = updateVisuals(iCustomTabsCallback4, bundle2);
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(bool1);
            return true;
          case 5:
            param1Parcel1.enforceInterface("android.support.customtabs.ICustomTabsService");
            str1 = param1Parcel1.readString();
            bundle2 = bundle5;
            if (param1Parcel1.readInt() != 0)
              bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(param1Parcel1); 
            bundle1 = extraCommand(str1, bundle2);
            param1Parcel2.writeNoException();
            if (bundle1 != null) {
              param1Parcel2.writeInt(1);
              bundle1.writeToParcel(param1Parcel2, 1);
            } else {
              param1Parcel2.writeInt(0);
            } 
            return true;
          case 4:
            bundle1.enforceInterface("android.support.customtabs.ICustomTabsService");
            iCustomTabsCallback1 = ICustomTabsCallback.Stub.asInterface(bundle1.readStrongBinder());
            if (bundle1.readInt() != 0) {
              Uri uri = (Uri)Uri.CREATOR.createFromParcel((Parcel)bundle1);
            } else {
              bundle2 = null;
            } 
            iCustomTabsCallback3 = iCustomTabsCallback2;
            if (bundle1.readInt() != 0)
              bundle6 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle1); 
            bool1 = mayLaunchUrl(iCustomTabsCallback1, (Uri)bundle2, bundle6, bundle1.createTypedArrayList(Bundle.CREATOR));
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(bool1);
            return true;
          case 3:
            bundle1.enforceInterface("android.support.customtabs.ICustomTabsService");
            bool1 = newSession(ICustomTabsCallback.Stub.asInterface(bundle1.readStrongBinder()));
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(bool1);
            return true;
          case 2:
            break;
        } 
        bundle1.enforceInterface("android.support.customtabs.ICustomTabsService");
        boolean bool1 = warmup(bundle1.readLong());
        param1Parcel2.writeNoException();
        param1Parcel2.writeInt(bool1);
        return true;
      } 
      param1Parcel2.writeString("android.support.customtabs.ICustomTabsService");
      return true;
    }
    
    private static class Proxy implements ICustomTabsService {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public Bundle extraCommand(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String = null;
          } 
          return (Bundle)param2String;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return "android.support.customtabs.ICustomTabsService";
      }
      
      public boolean mayLaunchUrl(ICustomTabsCallback param2ICustomTabsCallback, Uri param2Uri, Bundle param2Bundle, List<Bundle> param2List) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeTypedList(param2List);
          this.mRemote.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean newSession(ICustomTabsCallback param2ICustomTabsCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder1 = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          iBinder.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int postMessage(ICustomTabsCallback param2ICustomTabsCallback, String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
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
          this.mRemote.transact(8, parcel1, parcel2, 0);
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean requestPostMessageChannel(ICustomTabsCallback param2ICustomTabsCallback, Uri param2Uri) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(7, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean updateVisuals(ICustomTabsCallback param2ICustomTabsCallback, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          boolean bool = true;
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(6, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean validateRelationship(ICustomTabsCallback param2ICustomTabsCallback, int param2Int, Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          if (param2ICustomTabsCallback != null) {
            IBinder iBinder = param2ICustomTabsCallback.asBinder();
          } else {
            param2ICustomTabsCallback = null;
          } 
          parcel1.writeStrongBinder((IBinder)param2ICustomTabsCallback);
          parcel1.writeInt(param2Int);
          boolean bool = true;
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(9, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          if (param2Int == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean warmup(long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
          parcel1.writeLong(param2Long);
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          iBinder.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements ICustomTabsService {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public Bundle extraCommand(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String = null;
        } 
        return (Bundle)param1String;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "android.support.customtabs.ICustomTabsService";
    }
    
    public boolean mayLaunchUrl(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri, Bundle param1Bundle, List<Bundle> param1List) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeTypedList(param1List);
        this.mRemote.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean newSession(ICustomTabsCallback param1ICustomTabsCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder1 = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        iBinder.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int postMessage(ICustomTabsCallback param1ICustomTabsCallback, String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
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
        this.mRemote.transact(8, parcel1, parcel2, 0);
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean requestPostMessageChannel(ICustomTabsCallback param1ICustomTabsCallback, Uri param1Uri) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(7, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean updateVisuals(ICustomTabsCallback param1ICustomTabsCallback, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        boolean bool = true;
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(6, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean validateRelationship(ICustomTabsCallback param1ICustomTabsCallback, int param1Int, Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        if (param1ICustomTabsCallback != null) {
          IBinder iBinder = param1ICustomTabsCallback.asBinder();
        } else {
          param1ICustomTabsCallback = null;
        } 
        parcel1.writeStrongBinder((IBinder)param1ICustomTabsCallback);
        parcel1.writeInt(param1Int);
        boolean bool = true;
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(9, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        if (param1Int == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean warmup(long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
        parcel1.writeLong(param1Long);
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        iBinder.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\customtabs\ICustomTabsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */