package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public interface zzn extends IInterface {
  void beginAdUnitExposure(String paramString, long paramLong) throws RemoteException;
  
  void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) throws RemoteException;
  
  void endAdUnitExposure(String paramString, long paramLong) throws RemoteException;
  
  void generateEventId(zzq paramzzq) throws RemoteException;
  
  void getAppInstanceId(zzq paramzzq) throws RemoteException;
  
  void getCachedAppInstanceId(zzq paramzzq) throws RemoteException;
  
  void getConditionalUserProperties(String paramString1, String paramString2, zzq paramzzq) throws RemoteException;
  
  void getCurrentScreenClass(zzq paramzzq) throws RemoteException;
  
  void getCurrentScreenName(zzq paramzzq) throws RemoteException;
  
  void getGmpAppId(zzq paramzzq) throws RemoteException;
  
  void getMaxUserProperties(String paramString, zzq paramzzq) throws RemoteException;
  
  void getTestFlag(zzq paramzzq, int paramInt) throws RemoteException;
  
  void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzq paramzzq) throws RemoteException;
  
  void initForTests(Map paramMap) throws RemoteException;
  
  void initialize(IObjectWrapper paramIObjectWrapper, zzy paramzzy, long paramLong) throws RemoteException;
  
  void isDataCollectionEnabled(zzq paramzzq) throws RemoteException;
  
  void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong) throws RemoteException;
  
  void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzq paramzzq, long paramLong) throws RemoteException;
  
  void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3) throws RemoteException;
  
  void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong) throws RemoteException;
  
  void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException;
  
  void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException;
  
  void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException;
  
  void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzq paramzzq, long paramLong) throws RemoteException;
  
  void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException;
  
  void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException;
  
  void performAction(Bundle paramBundle, zzq paramzzq, long paramLong) throws RemoteException;
  
  void registerOnMeasurementEventListener(zzt paramzzt) throws RemoteException;
  
  void resetAnalyticsData(long paramLong) throws RemoteException;
  
  void setConditionalUserProperty(Bundle paramBundle, long paramLong) throws RemoteException;
  
  void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong) throws RemoteException;
  
  void setDataCollectionEnabled(boolean paramBoolean) throws RemoteException;
  
  void setEventInterceptor(zzt paramzzt) throws RemoteException;
  
  void setInstanceIdProvider(zzw paramzzw) throws RemoteException;
  
  void setMeasurementEnabled(boolean paramBoolean, long paramLong) throws RemoteException;
  
  void setMinimumSessionDuration(long paramLong) throws RemoteException;
  
  void setSessionTimeoutDuration(long paramLong) throws RemoteException;
  
  void setUserId(String paramString, long paramLong) throws RemoteException;
  
  void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong) throws RemoteException;
  
  void unregisterOnMeasurementEventListener(zzt paramzzt) throws RemoteException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */