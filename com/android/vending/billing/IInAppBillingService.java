package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IInAppBillingService extends IInterface {
  int consumePurchase(int paramInt, String paramString1, String paramString2) throws RemoteException;
  
  Bundle getBuyIntent(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) throws RemoteException;
  
  Bundle getPurchases(int paramInt, String paramString1, String paramString2, String paramString3) throws RemoteException;
  
  Bundle getSkuDetails(int paramInt, String paramString1, String paramString2, Bundle paramBundle) throws RemoteException;
  
  int isBillingSupported(int paramInt, String paramString1, String paramString2) throws RemoteException;
  
  public static abstract class Stub extends Binder implements IInAppBillingService {
    private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
    
    static final int TRANSACTION_consumePurchase = 5;
    
    static final int TRANSACTION_getBuyIntent = 3;
    
    static final int TRANSACTION_getPurchases = 4;
    
    static final int TRANSACTION_getSkuDetails = 2;
    
    static final int TRANSACTION_isBillingSupported = 1;
    
    public Stub() {
      attachInterface(this, "com.android.vending.billing.IInAppBillingService");
    }
    
    public static IInAppBillingService asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
      return (iInterface != null && iInterface instanceof IInAppBillingService) ? (IInAppBillingService)iInterface : new Proxy(param1IBinder);
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      if (param1Int1 != 1598968902) {
        Bundle bundle;
        String str1;
        String str2;
        switch (param1Int1) {
          default:
            return super.onTransact(param1Int1, param1Parcel1, param1Parcel2, param1Int2);
          case 5:
            param1Parcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
            param1Int1 = consumePurchase(param1Parcel1.readInt(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            param1Parcel2.writeInt(param1Int1);
            return true;
          case 4:
            param1Parcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
            bundle = getPurchases(param1Parcel1.readInt(), param1Parcel1.readString(), param1Parcel1.readString(), param1Parcel1.readString());
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
            } else {
              param1Parcel2.writeInt(0);
            } 
            return true;
          case 3:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            bundle = getBuyIntent(bundle.readInt(), bundle.readString(), bundle.readString(), bundle.readString(), bundle.readString());
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
            } else {
              param1Parcel2.writeInt(0);
            } 
            return true;
          case 2:
            bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
            param1Int1 = bundle.readInt();
            str1 = bundle.readString();
            str2 = bundle.readString();
            if (bundle.readInt() != 0) {
              bundle = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)bundle);
            } else {
              bundle = null;
            } 
            bundle = getSkuDetails(param1Int1, str1, str2, bundle);
            param1Parcel2.writeNoException();
            if (bundle != null) {
              param1Parcel2.writeInt(1);
              bundle.writeToParcel(param1Parcel2, 1);
            } else {
              param1Parcel2.writeInt(0);
            } 
            return true;
          case 1:
            break;
        } 
        bundle.enforceInterface("com.android.vending.billing.IInAppBillingService");
        param1Int1 = isBillingSupported(bundle.readInt(), bundle.readString(), bundle.readString());
        param1Parcel2.writeNoException();
        param1Parcel2.writeInt(param1Int1);
        return true;
      } 
      param1Parcel2.writeString("com.android.vending.billing.IInAppBillingService");
      return true;
    }
    
    private static class Proxy implements IInAppBillingService {
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public int consumePurchase(int param2Int, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.mRemote.transact(5, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle getBuyIntent(int param2Int, String param2String1, String param2String2, String param2String3, String param2String4) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          parcel1.writeString(param2String4);
          this.mRemote.transact(3, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Bundle)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return "com.android.vending.billing.IInAppBillingService";
      }
      
      public Bundle getPurchases(int param2Int, String param2String1, String param2String2, String param2String3) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          parcel1.writeString(param2String3);
          this.mRemote.transact(4, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Bundle)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle getSkuDetails(int param2Int, String param2String1, String param2String2, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          this.mRemote.transact(2, parcel1, parcel2, 0);
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            param2String1 = null;
          } 
          return (Bundle)param2String1;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int isBillingSupported(int param2Int, String param2String1, String param2String2) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
          parcel1.writeInt(param2Int);
          parcel1.writeString(param2String1);
          parcel1.writeString(param2String2);
          this.mRemote.transact(1, parcel1, parcel2, 0);
          parcel2.readException();
          param2Int = parcel2.readInt();
          return param2Int;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IInAppBillingService {
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public int consumePurchase(int param1Int, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.mRemote.transact(5, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle getBuyIntent(int param1Int, String param1String1, String param1String2, String param1String3, String param1String4) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        parcel1.writeString(param1String4);
        this.mRemote.transact(3, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Bundle)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return "com.android.vending.billing.IInAppBillingService";
    }
    
    public Bundle getPurchases(int param1Int, String param1String1, String param1String2, String param1String3) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        parcel1.writeString(param1String3);
        this.mRemote.transact(4, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Bundle)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle getSkuDetails(int param1Int, String param1String1, String param1String2, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        this.mRemote.transact(2, parcel1, parcel2, 0);
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          param1String1 = null;
        } 
        return (Bundle)param1String1;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int isBillingSupported(int param1Int, String param1String1, String param1String2) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
        parcel1.writeInt(param1Int);
        parcel1.writeString(param1String1);
        parcel1.writeString(param1String2);
        this.mRemote.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
        param1Int = parcel2.readInt();
        return param1Int;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\android\vending\billing\IInAppBillingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */