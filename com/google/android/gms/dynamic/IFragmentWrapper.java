package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IFragmentWrapper extends IInterface {
  Bundle getArguments() throws RemoteException;
  
  int getId() throws RemoteException;
  
  boolean getRetainInstance() throws RemoteException;
  
  String getTag() throws RemoteException;
  
  int getTargetRequestCode() throws RemoteException;
  
  boolean getUserVisibleHint() throws RemoteException;
  
  boolean isAdded() throws RemoteException;
  
  boolean isDetached() throws RemoteException;
  
  boolean isHidden() throws RemoteException;
  
  boolean isInLayout() throws RemoteException;
  
  boolean isRemoving() throws RemoteException;
  
  boolean isResumed() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void setHasOptionsMenu(boolean paramBoolean) throws RemoteException;
  
  void setMenuVisibility(boolean paramBoolean) throws RemoteException;
  
  void setRetainInstance(boolean paramBoolean) throws RemoteException;
  
  void setUserVisibleHint(boolean paramBoolean) throws RemoteException;
  
  void startActivity(Intent paramIntent) throws RemoteException;
  
  void startActivityForResult(Intent paramIntent, int paramInt) throws RemoteException;
  
  void zza(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  IObjectWrapper zzae() throws RemoteException;
  
  IFragmentWrapper zzaf() throws RemoteException;
  
  IObjectWrapper zzag() throws RemoteException;
  
  IFragmentWrapper zzah() throws RemoteException;
  
  IObjectWrapper zzai() throws RemoteException;
  
  void zzb(IObjectWrapper paramIObjectWrapper) throws RemoteException;
  
  public static abstract class Stub extends zzb implements IFragmentWrapper {
    public Stub() {
      super("com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public static IFragmentWrapper asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
      return (iInterface instanceof IFragmentWrapper) ? (IFragmentWrapper)iInterface : new zza(param1IBinder);
    }
    
    protected final boolean zza(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      IObjectWrapper iObjectWrapper3;
      IFragmentWrapper iFragmentWrapper2;
      String str;
      IObjectWrapper iObjectWrapper2;
      IFragmentWrapper iFragmentWrapper1;
      Bundle bundle;
      boolean bool;
      switch (param1Int1) {
        default:
          return false;
        case 27:
          zzb(IObjectWrapper.Stub.asInterface(param1Parcel1.readStrongBinder()));
          param1Parcel2.writeNoException();
          return true;
        case 26:
          startActivityForResult((Intent)zzc.zza(param1Parcel1, Intent.CREATOR), param1Parcel1.readInt());
          param1Parcel2.writeNoException();
          return true;
        case 25:
          startActivity((Intent)zzc.zza(param1Parcel1, Intent.CREATOR));
          param1Parcel2.writeNoException();
          return true;
        case 24:
          setUserVisibleHint(zzc.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 23:
          setRetainInstance(zzc.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 22:
          setMenuVisibility(zzc.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 21:
          setHasOptionsMenu(zzc.zza(param1Parcel1));
          param1Parcel2.writeNoException();
          return true;
        case 20:
          zza(IObjectWrapper.Stub.asInterface(param1Parcel1.readStrongBinder()));
          param1Parcel2.writeNoException();
          return true;
        case 19:
          bool = isVisible();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 18:
          bool = isResumed();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 17:
          bool = isRemoving();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 16:
          bool = isInLayout();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 15:
          bool = isHidden();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 14:
          bool = isDetached();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 13:
          bool = isAdded();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 12:
          iObjectWrapper3 = zzai();
          param1Parcel2.writeNoException();
          zzc.zza(param1Parcel2, iObjectWrapper3);
          return true;
        case 11:
          bool = getUserVisibleHint();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 10:
          param1Int1 = getTargetRequestCode();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 9:
          iFragmentWrapper2 = zzah();
          param1Parcel2.writeNoException();
          zzc.zza(param1Parcel2, iFragmentWrapper2);
          return true;
        case 8:
          str = getTag();
          param1Parcel2.writeNoException();
          param1Parcel2.writeString(str);
          return true;
        case 7:
          bool = getRetainInstance();
          param1Parcel2.writeNoException();
          zzc.writeBoolean(param1Parcel2, bool);
          return true;
        case 6:
          iObjectWrapper2 = zzag();
          param1Parcel2.writeNoException();
          zzc.zza(param1Parcel2, iObjectWrapper2);
          return true;
        case 5:
          iFragmentWrapper1 = zzaf();
          param1Parcel2.writeNoException();
          zzc.zza(param1Parcel2, iFragmentWrapper1);
          return true;
        case 4:
          param1Int1 = getId();
          param1Parcel2.writeNoException();
          param1Parcel2.writeInt(param1Int1);
          return true;
        case 3:
          bundle = getArguments();
          param1Parcel2.writeNoException();
          zzc.zzb(param1Parcel2, (Parcelable)bundle);
          return true;
        case 2:
          break;
      } 
      IObjectWrapper iObjectWrapper1 = zzae();
      param1Parcel2.writeNoException();
      zzc.zza(param1Parcel2, iObjectWrapper1);
      return true;
    }
    
    public static final class zza extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
      zza(IBinder param2IBinder) {
        super(param2IBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
      }
      
      public final Bundle getArguments() throws RemoteException {
        Parcel parcel = zza(3, zza());
        Bundle bundle = (Bundle)zzc.zza(parcel, Bundle.CREATOR);
        parcel.recycle();
        return bundle;
      }
      
      public final int getId() throws RemoteException {
        Parcel parcel = zza(4, zza());
        int i = parcel.readInt();
        parcel.recycle();
        return i;
      }
      
      public final boolean getRetainInstance() throws RemoteException {
        Parcel parcel = zza(7, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final String getTag() throws RemoteException {
        Parcel parcel = zza(8, zza());
        String str = parcel.readString();
        parcel.recycle();
        return str;
      }
      
      public final int getTargetRequestCode() throws RemoteException {
        Parcel parcel = zza(10, zza());
        int i = parcel.readInt();
        parcel.recycle();
        return i;
      }
      
      public final boolean getUserVisibleHint() throws RemoteException {
        Parcel parcel = zza(11, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isAdded() throws RemoteException {
        Parcel parcel = zza(13, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isDetached() throws RemoteException {
        Parcel parcel = zza(14, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isHidden() throws RemoteException {
        Parcel parcel = zza(15, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isInLayout() throws RemoteException {
        Parcel parcel = zza(16, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isRemoving() throws RemoteException {
        Parcel parcel = zza(17, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isResumed() throws RemoteException {
        Parcel parcel = zza(18, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final boolean isVisible() throws RemoteException {
        Parcel parcel = zza(19, zza());
        boolean bool = zzc.zza(parcel);
        parcel.recycle();
        return bool;
      }
      
      public final void setHasOptionsMenu(boolean param2Boolean) throws RemoteException {
        Parcel parcel = zza();
        zzc.writeBoolean(parcel, param2Boolean);
        zzb(21, parcel);
      }
      
      public final void setMenuVisibility(boolean param2Boolean) throws RemoteException {
        Parcel parcel = zza();
        zzc.writeBoolean(parcel, param2Boolean);
        zzb(22, parcel);
      }
      
      public final void setRetainInstance(boolean param2Boolean) throws RemoteException {
        Parcel parcel = zza();
        zzc.writeBoolean(parcel, param2Boolean);
        zzb(23, parcel);
      }
      
      public final void setUserVisibleHint(boolean param2Boolean) throws RemoteException {
        Parcel parcel = zza();
        zzc.writeBoolean(parcel, param2Boolean);
        zzb(24, parcel);
      }
      
      public final void startActivity(Intent param2Intent) throws RemoteException {
        Parcel parcel = zza();
        zzc.zza(parcel, (Parcelable)param2Intent);
        zzb(25, parcel);
      }
      
      public final void startActivityForResult(Intent param2Intent, int param2Int) throws RemoteException {
        Parcel parcel = zza();
        zzc.zza(parcel, (Parcelable)param2Intent);
        parcel.writeInt(param2Int);
        zzb(26, parcel);
      }
      
      public final void zza(IObjectWrapper param2IObjectWrapper) throws RemoteException {
        Parcel parcel = zza();
        zzc.zza(parcel, param2IObjectWrapper);
        zzb(20, parcel);
      }
      
      public final IObjectWrapper zzae() throws RemoteException {
        Parcel parcel = zza(2, zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
      }
      
      public final IFragmentWrapper zzaf() throws RemoteException {
        Parcel parcel = zza(5, zza());
        IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iFragmentWrapper;
      }
      
      public final IObjectWrapper zzag() throws RemoteException {
        Parcel parcel = zza(6, zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
      }
      
      public final IFragmentWrapper zzah() throws RemoteException {
        Parcel parcel = zza(9, zza());
        IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iFragmentWrapper;
      }
      
      public final IObjectWrapper zzai() throws RemoteException {
        Parcel parcel = zza(12, zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
      }
      
      public final void zzb(IObjectWrapper param2IObjectWrapper) throws RemoteException {
        Parcel parcel = zza();
        zzc.zza(parcel, param2IObjectWrapper);
        zzb(27, parcel);
      }
    }
  }
  
  public static final class zza extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
    zza(IBinder param1IBinder) {
      super(param1IBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
    }
    
    public final Bundle getArguments() throws RemoteException {
      Parcel parcel = zza(3, zza());
      Bundle bundle = (Bundle)zzc.zza(parcel, Bundle.CREATOR);
      parcel.recycle();
      return bundle;
    }
    
    public final int getId() throws RemoteException {
      Parcel parcel = zza(4, zza());
      int i = parcel.readInt();
      parcel.recycle();
      return i;
    }
    
    public final boolean getRetainInstance() throws RemoteException {
      Parcel parcel = zza(7, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final String getTag() throws RemoteException {
      Parcel parcel = zza(8, zza());
      String str = parcel.readString();
      parcel.recycle();
      return str;
    }
    
    public final int getTargetRequestCode() throws RemoteException {
      Parcel parcel = zza(10, zza());
      int i = parcel.readInt();
      parcel.recycle();
      return i;
    }
    
    public final boolean getUserVisibleHint() throws RemoteException {
      Parcel parcel = zza(11, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isAdded() throws RemoteException {
      Parcel parcel = zza(13, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isDetached() throws RemoteException {
      Parcel parcel = zza(14, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isHidden() throws RemoteException {
      Parcel parcel = zza(15, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isInLayout() throws RemoteException {
      Parcel parcel = zza(16, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isRemoving() throws RemoteException {
      Parcel parcel = zza(17, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isResumed() throws RemoteException {
      Parcel parcel = zza(18, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final boolean isVisible() throws RemoteException {
      Parcel parcel = zza(19, zza());
      boolean bool = zzc.zza(parcel);
      parcel.recycle();
      return bool;
    }
    
    public final void setHasOptionsMenu(boolean param1Boolean) throws RemoteException {
      Parcel parcel = zza();
      zzc.writeBoolean(parcel, param1Boolean);
      zzb(21, parcel);
    }
    
    public final void setMenuVisibility(boolean param1Boolean) throws RemoteException {
      Parcel parcel = zza();
      zzc.writeBoolean(parcel, param1Boolean);
      zzb(22, parcel);
    }
    
    public final void setRetainInstance(boolean param1Boolean) throws RemoteException {
      Parcel parcel = zza();
      zzc.writeBoolean(parcel, param1Boolean);
      zzb(23, parcel);
    }
    
    public final void setUserVisibleHint(boolean param1Boolean) throws RemoteException {
      Parcel parcel = zza();
      zzc.writeBoolean(parcel, param1Boolean);
      zzb(24, parcel);
    }
    
    public final void startActivity(Intent param1Intent) throws RemoteException {
      Parcel parcel = zza();
      zzc.zza(parcel, (Parcelable)param1Intent);
      zzb(25, parcel);
    }
    
    public final void startActivityForResult(Intent param1Intent, int param1Int) throws RemoteException {
      Parcel parcel = zza();
      zzc.zza(parcel, (Parcelable)param1Intent);
      parcel.writeInt(param1Int);
      zzb(26, parcel);
    }
    
    public final void zza(IObjectWrapper param1IObjectWrapper) throws RemoteException {
      Parcel parcel = zza();
      zzc.zza(parcel, param1IObjectWrapper);
      zzb(20, parcel);
    }
    
    public final IObjectWrapper zzae() throws RemoteException {
      Parcel parcel = zza(2, zza());
      IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iObjectWrapper;
    }
    
    public final IFragmentWrapper zzaf() throws RemoteException {
      Parcel parcel = zza(5, zza());
      IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iFragmentWrapper;
    }
    
    public final IObjectWrapper zzag() throws RemoteException {
      Parcel parcel = zza(6, zza());
      IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iObjectWrapper;
    }
    
    public final IFragmentWrapper zzah() throws RemoteException {
      Parcel parcel = zza(9, zza());
      IFragmentWrapper iFragmentWrapper = IFragmentWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iFragmentWrapper;
    }
    
    public final IObjectWrapper zzai() throws RemoteException {
      Parcel parcel = zza(12, zza());
      IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
      parcel.recycle();
      return iObjectWrapper;
    }
    
    public final void zzb(IObjectWrapper param1IObjectWrapper) throws RemoteException {
      Parcel parcel = zza();
      zzc.zza(parcel, param1IObjectWrapper);
      zzb(27, parcel);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\dynamic\IFragmentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */