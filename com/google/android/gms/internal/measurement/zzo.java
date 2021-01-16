package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzo extends zzb implements zzn {
  public zzo() {
    super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }
  
  public static zzn asInterface(IBinder paramIBinder) {
    if (paramIBinder == null)
      return null; 
    IInterface iInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    return (iInterface instanceof zzn) ? (zzn)iInterface : new zzp(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2) throws RemoteException {
    IBinder iBinder14;
    zzq zzq8;
    IBinder iBinder13;
    zzt zzt3;
    IBinder iBinder12;
    zzt zzt2;
    IBinder iBinder11;
    zzt zzt1;
    IBinder iBinder10;
    zzq zzq7;
    IBinder iBinder9;
    zzq zzq6;
    IBinder iBinder8;
    zzq zzq5;
    IBinder iBinder7;
    zzq zzq4;
    IBinder iBinder6;
    zzw zzw;
    IBinder iBinder5;
    zzq zzq3;
    IBinder iBinder4;
    zzq zzq2;
    IBinder iBinder3;
    IInterface iInterface2;
    IBinder iBinder2;
    zzq zzq1;
    IBinder iBinder1;
    IInterface iInterface1;
    String str1;
    String str2;
    IBinder iBinder31;
    zzq zzq9;
    IBinder iBinder30;
    IInterface iInterface5;
    IBinder iBinder29;
    IInterface iInterface4;
    String str3;
    IBinder iBinder28;
    IInterface iInterface3;
    Bundle bundle2;
    IObjectWrapper iObjectWrapper;
    String str4;
    IInterface iInterface7;
    Bundle bundle1;
    boolean bool;
    IBinder iBinder15 = null;
    IBinder iBinder16 = null;
    IBinder iBinder17 = null;
    IBinder iBinder18 = null;
    IBinder iBinder19 = null;
    IBinder iBinder20 = null;
    IBinder iBinder21 = null;
    IBinder iBinder22 = null;
    IBinder iBinder23 = null;
    IBinder iBinder24 = null;
    IBinder iBinder25 = null;
    IBinder iBinder26 = null;
    IBinder iBinder27 = null;
    IInterface iInterface6 = null;
    IBinder iBinder32 = null;
    IInterface iInterface8 = null;
    IBinder iBinder33 = null;
    switch (paramInt1) {
      default:
        return false;
      case 40:
        iBinder14 = paramParcel1.readStrongBinder();
        if (iBinder14 == null) {
          iBinder14 = iBinder33;
        } else {
          iInterface6 = iBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface6 instanceof zzq) {
            zzq8 = (zzq)iInterface6;
          } else {
            zzq8 = new zzs((IBinder)zzq8);
          } 
        } 
        isDataCollectionEnabled(zzq8);
        paramParcel2.writeNoException();
        return true;
      case 39:
        setDataCollectionEnabled(zzc.zza((Parcel)zzq8));
        paramParcel2.writeNoException();
        return true;
      case 38:
        iBinder31 = zzq8.readStrongBinder();
        if (iBinder31 == null) {
          iBinder31 = iBinder15;
        } else {
          iInterface8 = iBinder31.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface8 instanceof zzq) {
            zzq9 = (zzq)iInterface8;
          } else {
            zzq9 = new zzs((IBinder)zzq9);
          } 
        } 
        getTestFlag(zzq9, zzq8.readInt());
        paramParcel2.writeNoException();
        return true;
      case 37:
        initForTests(zzc.zzb((Parcel)zzq8));
        paramParcel2.writeNoException();
        return true;
      case 36:
        iBinder13 = zzq8.readStrongBinder();
        if (iBinder13 == null) {
          iBinder13 = iBinder16;
        } else {
          iInterface5 = iBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
          if (iInterface5 instanceof zzt) {
            zzt3 = (zzt)iInterface5;
          } else {
            zzt3 = new zzv((IBinder)zzt3);
          } 
        } 
        unregisterOnMeasurementEventListener(zzt3);
        paramParcel2.writeNoException();
        return true;
      case 35:
        iBinder12 = zzt3.readStrongBinder();
        if (iBinder12 == null) {
          iBinder12 = iBinder17;
        } else {
          iInterface5 = iBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
          if (iInterface5 instanceof zzt) {
            zzt2 = (zzt)iInterface5;
          } else {
            zzt2 = new zzv((IBinder)zzt2);
          } 
        } 
        registerOnMeasurementEventListener(zzt2);
        paramParcel2.writeNoException();
        return true;
      case 34:
        iBinder11 = zzt2.readStrongBinder();
        if (iBinder11 == null) {
          iBinder11 = iBinder18;
        } else {
          iInterface5 = iBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
          if (iInterface5 instanceof zzt) {
            zzt1 = (zzt)iInterface5;
          } else {
            zzt1 = new zzv((IBinder)zzt1);
          } 
        } 
        setEventInterceptor(zzt1);
        paramParcel2.writeNoException();
        return true;
      case 33:
        logHealthData(zzt1.readInt(), zzt1.readString(), IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32:
        bundle2 = zzc.<Bundle>zza((Parcel)zzt1, Bundle.CREATOR);
        iBinder30 = zzt1.readStrongBinder();
        if (iBinder30 == null) {
          iBinder30 = iBinder19;
        } else {
          IInterface iInterface = iBinder30.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface instanceof zzq) {
            iInterface5 = iInterface;
          } else {
            iInterface5 = new zzs((IBinder)iInterface5);
          } 
        } 
        performAction(bundle2, (zzq)iInterface5, zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 31:
        iObjectWrapper = IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder());
        iBinder29 = zzt1.readStrongBinder();
        if (iBinder29 == null) {
          iBinder29 = iBinder20;
        } else {
          IInterface iInterface = iBinder29.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface instanceof zzq) {
            iInterface4 = iInterface;
          } else {
            iInterface4 = new zzs((IBinder)iInterface4);
          } 
        } 
        onActivitySaveInstanceState(iObjectWrapper, (zzq)iInterface4, zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 30:
        onActivityResumed(IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 29:
        onActivityPaused(IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 28:
        onActivityDestroyed(IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 27:
        onActivityCreated(IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), zzc.<Bundle>zza((Parcel)zzt1, Bundle.CREATOR), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 26:
        onActivityStopped(IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 25:
        onActivityStarted(IObjectWrapper.Stub.asInterface(zzt1.readStrongBinder()), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 24:
        endAdUnitExposure(zzt1.readString(), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 23:
        beginAdUnitExposure(zzt1.readString(), zzt1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 22:
        iBinder10 = zzt1.readStrongBinder();
        if (iBinder10 == null) {
          iBinder10 = iBinder21;
        } else {
          iInterface3 = iBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface3 instanceof zzq) {
            zzq7 = (zzq)iInterface3;
          } else {
            zzq7 = new zzs((IBinder)zzq7);
          } 
        } 
        generateEventId(zzq7);
        paramParcel2.writeNoException();
        return true;
      case 21:
        iBinder9 = zzq7.readStrongBinder();
        if (iBinder9 == null) {
          iBinder9 = iBinder22;
        } else {
          iInterface3 = iBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface3 instanceof zzq) {
            zzq6 = (zzq)iInterface3;
          } else {
            zzq6 = new zzs((IBinder)zzq6);
          } 
        } 
        getGmpAppId(zzq6);
        paramParcel2.writeNoException();
        return true;
      case 20:
        iBinder8 = zzq6.readStrongBinder();
        if (iBinder8 == null) {
          iBinder8 = iBinder23;
        } else {
          iInterface3 = iBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface3 instanceof zzq) {
            zzq5 = (zzq)iInterface3;
          } else {
            zzq5 = new zzs((IBinder)zzq5);
          } 
        } 
        getAppInstanceId(zzq5);
        paramParcel2.writeNoException();
        return true;
      case 19:
        iBinder7 = zzq5.readStrongBinder();
        if (iBinder7 == null) {
          iBinder7 = iBinder24;
        } else {
          iInterface3 = iBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface3 instanceof zzq) {
            zzq4 = (zzq)iInterface3;
          } else {
            zzq4 = new zzs((IBinder)zzq4);
          } 
        } 
        getCachedAppInstanceId(zzq4);
        paramParcel2.writeNoException();
        return true;
      case 18:
        iBinder6 = zzq4.readStrongBinder();
        if (iBinder6 == null) {
          iBinder6 = iBinder25;
        } else {
          iInterface3 = iBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
          if (iInterface3 instanceof zzw) {
            zzw = (zzw)iInterface3;
          } else {
            zzw = new zzx((IBinder)zzw);
          } 
        } 
        setInstanceIdProvider(zzw);
        paramParcel2.writeNoException();
        return true;
      case 17:
        iBinder5 = zzw.readStrongBinder();
        if (iBinder5 == null) {
          iBinder5 = iBinder26;
        } else {
          iInterface3 = iBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface3 instanceof zzq) {
            zzq3 = (zzq)iInterface3;
          } else {
            zzq3 = new zzs((IBinder)zzq3);
          } 
        } 
        getCurrentScreenClass(zzq3);
        paramParcel2.writeNoException();
        return true;
      case 16:
        iBinder4 = zzq3.readStrongBinder();
        if (iBinder4 == null) {
          iBinder4 = iBinder27;
        } else {
          iInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface4 instanceof zzq) {
            zzq2 = (zzq)iInterface4;
          } else {
            zzq2 = new zzs((IBinder)zzq2);
          } 
        } 
        getCurrentScreenName(zzq2);
        paramParcel2.writeNoException();
        return true;
      case 15:
        setCurrentScreen(IObjectWrapper.Stub.asInterface(zzq2.readStrongBinder()), zzq2.readString(), zzq2.readString(), zzq2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 14:
        setSessionTimeoutDuration(zzq2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 13:
        setMinimumSessionDuration(zzq2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 12:
        resetAnalyticsData(zzq2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 11:
        setMeasurementEnabled(zzc.zza((Parcel)zzq2), zzq2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 10:
        str4 = zzq2.readString();
        str1 = zzq2.readString();
        iBinder3 = zzq2.readStrongBinder();
        if (iBinder3 == null) {
          iInterface2 = iInterface4;
        } else {
          iInterface4 = iInterface2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface4 instanceof zzq) {
            iInterface2 = iInterface4;
          } else {
            iInterface2 = new zzs((IBinder)iInterface2);
          } 
        } 
        getConditionalUserProperties(str4, str1, (zzq)iInterface2);
        paramParcel2.writeNoException();
        return true;
      case 9:
        clearConditionalUserProperty(iInterface2.readString(), iInterface2.readString(), zzc.<Bundle>zza((Parcel)iInterface2, Bundle.CREATOR));
        paramParcel2.writeNoException();
        return true;
      case 8:
        setConditionalUserProperty(zzc.<Bundle>zza((Parcel)iInterface2, Bundle.CREATOR), iInterface2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 7:
        setUserId(iInterface2.readString(), iInterface2.readLong());
        paramParcel2.writeNoException();
        return true;
      case 6:
        str3 = iInterface2.readString();
        iBinder2 = iInterface2.readStrongBinder();
        if (iBinder2 == null) {
          iBinder2 = iBinder32;
        } else {
          iInterface7 = iBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface7 instanceof zzq) {
            zzq1 = (zzq)iInterface7;
          } else {
            zzq1 = new zzs((IBinder)zzq1);
          } 
        } 
        getMaxUserProperties(str3, zzq1);
        paramParcel2.writeNoException();
        return true;
      case 5:
        str3 = zzq1.readString();
        str1 = zzq1.readString();
        bool = zzc.zza((Parcel)zzq1);
        iBinder1 = zzq1.readStrongBinder();
        if (iBinder1 == null) {
          iInterface1 = iInterface7;
        } else {
          iInterface7 = iInterface1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface7 instanceof zzq) {
            iInterface1 = iInterface7;
          } else {
            iInterface1 = new zzs((IBinder)iInterface1);
          } 
        } 
        getUserProperties(str3, str1, bool, (zzq)iInterface1);
        paramParcel2.writeNoException();
        return true;
      case 4:
        setUserProperty(iInterface1.readString(), iInterface1.readString(), IObjectWrapper.Stub.asInterface(iInterface1.readStrongBinder()), zzc.zza((Parcel)iInterface1), iInterface1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 3:
        str1 = iInterface1.readString();
        str2 = iInterface1.readString();
        bundle1 = zzc.<Bundle>zza((Parcel)iInterface1, Bundle.CREATOR);
        iBinder28 = iInterface1.readStrongBinder();
        if (iBinder28 == null) {
          iBinder28 = null;
        } else {
          IInterface iInterface = iBinder28.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
          if (iInterface instanceof zzq) {
            iInterface3 = iInterface;
          } else {
            iInterface3 = new zzs((IBinder)iInterface3);
          } 
        } 
        logEventAndBundle(str1, str2, bundle1, (zzq)iInterface3, iInterface1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 2:
        logEvent(iInterface1.readString(), iInterface1.readString(), zzc.<Bundle>zza((Parcel)iInterface1, Bundle.CREATOR), zzc.zza((Parcel)iInterface1), zzc.zza((Parcel)iInterface1), iInterface1.readLong());
        paramParcel2.writeNoException();
        return true;
      case 1:
        break;
    } 
    initialize(IObjectWrapper.Stub.asInterface(iInterface1.readStrongBinder()), zzc.<zzy>zza((Parcel)iInterface1, zzy.CREATOR), iInterface1.readLong());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */