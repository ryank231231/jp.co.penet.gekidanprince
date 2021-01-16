package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public final class zzp extends zza implements zzn {
  zzp(IBinder paramIBinder) {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }
  
  public final void beginAdUnitExposure(String paramString, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString);
    parcel.writeLong(paramLong);
    zza(23, parcel);
  }
  
  public final void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.zza(parcel, (Parcelable)paramBundle);
    zza(9, parcel);
  }
  
  public final void endAdUnitExposure(String paramString, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString);
    parcel.writeLong(paramLong);
    zza(24, parcel);
  }
  
  public final void generateEventId(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(22, parcel);
  }
  
  public final void getAppInstanceId(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(20, parcel);
  }
  
  public final void getCachedAppInstanceId(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(19, parcel);
  }
  
  public final void getConditionalUserProperties(String paramString1, String paramString2, zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.zza(parcel, paramzzq);
    zza(10, parcel);
  }
  
  public final void getCurrentScreenClass(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(17, parcel);
  }
  
  public final void getCurrentScreenName(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(16, parcel);
  }
  
  public final void getGmpAppId(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(21, parcel);
  }
  
  public final void getMaxUserProperties(String paramString, zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString);
    zzc.zza(parcel, paramzzq);
    zza(6, parcel);
  }
  
  public final void getTestFlag(zzq paramzzq, int paramInt) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    parcel.writeInt(paramInt);
    zza(38, parcel);
  }
  
  public final void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.writeBoolean(parcel, paramBoolean);
    zzc.zza(parcel, paramzzq);
    zza(5, parcel);
  }
  
  public final void initForTests(Map paramMap) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeMap(paramMap);
    zza(37, parcel);
  }
  
  public final void initialize(IObjectWrapper paramIObjectWrapper, zzy paramzzy, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzc.zza(parcel, (Parcelable)paramzzy);
    parcel.writeLong(paramLong);
    zza(1, parcel);
  }
  
  public final void isDataCollectionEnabled(zzq paramzzq) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzq);
    zza(40, parcel);
  }
  
  public final void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzc.writeBoolean(parcel, paramBoolean1);
    zzc.writeBoolean(parcel, paramBoolean2);
    parcel.writeLong(paramLong);
    zza(2, parcel);
  }
  
  public final void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzq paramzzq, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzc.zza(parcel, paramzzq);
    parcel.writeLong(paramLong);
    zza(3, parcel);
  }
  
  public final void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeInt(paramInt);
    parcel.writeString(paramString);
    zzc.zza(parcel, (IInterface)paramIObjectWrapper1);
    zzc.zza(parcel, (IInterface)paramIObjectWrapper2);
    zzc.zza(parcel, (IInterface)paramIObjectWrapper3);
    zza(33, parcel);
  }
  
  public final void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzc.zza(parcel, (Parcelable)paramBundle);
    parcel.writeLong(paramLong);
    zza(27, parcel);
  }
  
  public final void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeLong(paramLong);
    zza(28, parcel);
  }
  
  public final void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeLong(paramLong);
    zza(29, parcel);
  }
  
  public final void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeLong(paramLong);
    zza(30, parcel);
  }
  
  public final void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzq paramzzq, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzc.zza(parcel, paramzzq);
    parcel.writeLong(paramLong);
    zza(31, parcel);
  }
  
  public final void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeLong(paramLong);
    zza(25, parcel);
  }
  
  public final void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeLong(paramLong);
    zza(26, parcel);
  }
  
  public final void performAction(Bundle paramBundle, zzq paramzzq, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramBundle);
    zzc.zza(parcel, paramzzq);
    parcel.writeLong(paramLong);
    zza(32, parcel);
  }
  
  public final void registerOnMeasurementEventListener(zzt paramzzt) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzt);
    zza(35, parcel);
  }
  
  public final void resetAnalyticsData(long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeLong(paramLong);
    zza(12, parcel);
  }
  
  public final void setConditionalUserProperty(Bundle paramBundle, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (Parcelable)paramBundle);
    parcel.writeLong(paramLong);
    zza(8, parcel);
  }
  
  public final void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    parcel.writeLong(paramLong);
    zza(15, parcel);
  }
  
  public final void setDataCollectionEnabled(boolean paramBoolean) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.writeBoolean(parcel, paramBoolean);
    zza(39, parcel);
  }
  
  public final void setEventInterceptor(zzt paramzzt) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzt);
    zza(34, parcel);
  }
  
  public final void setInstanceIdProvider(zzw paramzzw) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzw);
    zza(18, parcel);
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.writeBoolean(parcel, paramBoolean);
    parcel.writeLong(paramLong);
    zza(11, parcel);
  }
  
  public final void setMinimumSessionDuration(long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeLong(paramLong);
    zza(13, parcel);
  }
  
  public final void setSessionTimeoutDuration(long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeLong(paramLong);
    zza(14, parcel);
  }
  
  public final void setUserId(String paramString, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString);
    parcel.writeLong(paramLong);
    zza(7, parcel);
  }
  
  public final void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    parcel.writeString(paramString1);
    parcel.writeString(paramString2);
    zzc.zza(parcel, (IInterface)paramIObjectWrapper);
    zzc.writeBoolean(parcel, paramBoolean);
    parcel.writeLong(paramLong);
    zza(4, parcel);
  }
  
  public final void unregisterOnMeasurementEventListener(zzt paramzzt) throws RemoteException {
    Parcel parcel = obtainAndWriteInterfaceToken();
    zzc.zza(parcel, paramzzt);
    zza(36, parcel);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */