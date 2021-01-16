package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzo;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.internal.measurement.zzy;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzo {
  private Map<Integer, zzdb> zzad = (Map<Integer, zzdb>)new ArrayMap();
  
  @VisibleForTesting
  zzby zzl = null;
  
  private final void zza(zzq paramzzq, String paramString) {
    this.zzl.zzab().zzb(paramzzq, paramString);
  }
  
  private final void zzah() {
    if (this.zzl != null)
      return; 
    throw new IllegalStateException("Attempting to perform action before initialize.");
  }
  
  public void beginAdUnitExposure(String paramString, long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzr().beginAdUnitExposure(paramString, paramLong);
  }
  
  public void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle) throws RemoteException {
    zzah();
    this.zzl.zzs().clearConditionalUserProperty(paramString1, paramString2, paramBundle);
  }
  
  public void endAdUnitExposure(String paramString, long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzr().endAdUnitExposure(paramString, paramLong);
  }
  
  public void generateEventId(zzq paramzzq) throws RemoteException {
    zzah();
    long l = this.zzl.zzab().zzgk();
    this.zzl.zzab().zza(paramzzq, l);
  }
  
  public void getAppInstanceId(zzq paramzzq) throws RemoteException {
    zzah();
    this.zzl.zzac().zza(new zzh(this, paramzzq));
  }
  
  public void getCachedAppInstanceId(zzq paramzzq) throws RemoteException {
    zzah();
    zza(paramzzq, this.zzl.zzs().zzj());
  }
  
  public void getConditionalUserProperties(String paramString1, String paramString2, zzq paramzzq) throws RemoteException {
    zzah();
    this.zzl.zzac().zza(new zzk(this, paramzzq, paramString1, paramString2));
  }
  
  public void getCurrentScreenClass(zzq paramzzq) throws RemoteException {
    zzah();
    zza(paramzzq, this.zzl.zzs().getCurrentScreenClass());
  }
  
  public void getCurrentScreenName(zzq paramzzq) throws RemoteException {
    zzah();
    zza(paramzzq, this.zzl.zzs().getCurrentScreenName());
  }
  
  public void getGmpAppId(zzq paramzzq) throws RemoteException {
    zzah();
    zza(paramzzq, this.zzl.zzs().getGmpAppId());
  }
  
  public void getMaxUserProperties(String paramString, zzq paramzzq) throws RemoteException {
    zzah();
    this.zzl.zzs();
    Preconditions.checkNotEmpty(paramString);
    this.zzl.zzab().zza(paramzzq, 25);
  }
  
  public void getTestFlag(zzq paramzzq, int paramInt) throws RemoteException {
    zzgd zzgd;
    double d;
    Bundle bundle;
    zzah();
    switch (paramInt) {
      default:
        return;
      case 4:
        this.zzl.zzab().zza(paramzzq, this.zzl.zzs().zzev().booleanValue());
      case 3:
        this.zzl.zzab().zza(paramzzq, this.zzl.zzs().zzey().intValue());
        return;
      case 2:
        zzgd = this.zzl.zzab();
        d = this.zzl.zzs().zzez().doubleValue();
        bundle = new Bundle();
        bundle.putDouble("r", d);
        try {
          paramzzq.zzb(bundle);
          return;
        } catch (RemoteException remoteException) {
          zzgd.zzl.zzad().zzdd().zza("Error returning double value to wrapper", remoteException);
          return;
        } 
      case 1:
        this.zzl.zzab().zza((zzq)remoteException, this.zzl.zzs().zzex().longValue());
        return;
      case 0:
        break;
    } 
    this.zzl.zzab().zzb((zzq)remoteException, this.zzl.zzs().zzew());
  }
  
  public void getUserProperties(String paramString1, String paramString2, boolean paramBoolean, zzq paramzzq) throws RemoteException {
    zzah();
    this.zzl.zzac().zza(new zzj(this, paramzzq, paramString1, paramString2, paramBoolean));
  }
  
  public void initForTests(Map paramMap) throws RemoteException {
    zzah();
  }
  
  public void initialize(IObjectWrapper paramIObjectWrapper, zzy paramzzy, long paramLong) throws RemoteException {
    Context context = (Context)ObjectWrapper.unwrap(paramIObjectWrapper);
    zzby zzby1 = this.zzl;
    if (zzby1 == null) {
      this.zzl = zzby.zza(context, paramzzy);
      return;
    } 
    zzby1.zzad().zzdd().zzaq("Attempting to initialize multiple times");
  }
  
  public void isDataCollectionEnabled(zzq paramzzq) throws RemoteException {
    zzah();
    this.zzl.zzac().zza(new zzl(this, paramzzq));
  }
  
  public void logEvent(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzs().logEvent(paramString1, paramString2, paramBundle, paramBoolean1, paramBoolean2, paramLong);
  }
  
  public void logEventAndBundle(String paramString1, String paramString2, Bundle paramBundle, zzq paramzzq, long paramLong) throws RemoteException {
    Bundle bundle;
    zzah();
    Preconditions.checkNotEmpty(paramString2);
    if (paramBundle != null) {
      bundle = new Bundle(paramBundle);
    } else {
      bundle = new Bundle();
    } 
    bundle.putString("_o", "app");
    zzaj zzaj = new zzaj(paramString2, new zzag(paramBundle), "app", paramLong);
    this.zzl.zzac().zza(new zzi(this, paramzzq, zzaj, paramString1));
  }
  
  public void logHealthData(int paramInt, String paramString, IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3) throws RemoteException {
    Object object1;
    Object object2;
    Object object3;
    zzah();
    IObjectWrapper iObjectWrapper = null;
    if (paramIObjectWrapper1 == null) {
      paramIObjectWrapper1 = null;
    } else {
      object1 = ObjectWrapper.unwrap(paramIObjectWrapper1);
    } 
    if (paramIObjectWrapper2 == null) {
      paramIObjectWrapper2 = null;
    } else {
      object2 = ObjectWrapper.unwrap(paramIObjectWrapper2);
    } 
    if (paramIObjectWrapper3 == null) {
      paramIObjectWrapper3 = iObjectWrapper;
    } else {
      object3 = ObjectWrapper.unwrap(paramIObjectWrapper3);
    } 
    this.zzl.zzad().zza(paramInt, true, false, paramString, object1, object2, object3);
  }
  
  public void onActivityCreated(IObjectWrapper paramIObjectWrapper, Bundle paramBundle, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    this.zzl.zzad().zzdd().zzaq("Got on activity created");
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivityCreated((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramBundle);
    } 
  }
  
  public void onActivityDestroyed(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivityDestroyed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    } 
  }
  
  public void onActivityPaused(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivityPaused((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    } 
  }
  
  public void onActivityResumed(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivityResumed((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    } 
  }
  
  public void onActivitySaveInstanceState(IObjectWrapper paramIObjectWrapper, zzq paramzzq, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    Bundle bundle = new Bundle();
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivitySaveInstanceState((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), bundle);
    } 
    try {
      paramzzq.zzb(bundle);
      return;
    } catch (RemoteException remoteException) {
      this.zzl.zzad().zzdd().zza("Error returning bundle value to wrapper", remoteException);
      return;
    } 
  }
  
  public void onActivityStarted(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivityStarted((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    } 
  }
  
  public void onActivityStopped(IObjectWrapper paramIObjectWrapper, long paramLong) throws RemoteException {
    zzah();
    zzdx zzdx = (this.zzl.zzs()).zzpf;
    if (zzdx != null) {
      this.zzl.zzs().zzeu();
      zzdx.onActivityStopped((Activity)ObjectWrapper.unwrap(paramIObjectWrapper));
    } 
  }
  
  public void performAction(Bundle paramBundle, zzq paramzzq, long paramLong) throws RemoteException {
    zzah();
    paramzzq.zzb(null);
  }
  
  public void registerOnMeasurementEventListener(zzt paramzzt) throws RemoteException {
    zzah();
    zzdb zzdb1 = this.zzad.get(Integer.valueOf(paramzzt.id()));
    zzdb zzdb2 = zzdb1;
    if (zzdb1 == null) {
      zzdb2 = new zzb(this, paramzzt);
      this.zzad.put(Integer.valueOf(paramzzt.id()), zzdb2);
    } 
    this.zzl.zzs().zza(zzdb2);
  }
  
  public void resetAnalyticsData(long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzs().resetAnalyticsData(paramLong);
  }
  
  public void setConditionalUserProperty(Bundle paramBundle, long paramLong) throws RemoteException {
    zzah();
    if (paramBundle == null) {
      this.zzl.zzad().zzda().zzaq("Conditional user property must not be null");
      return;
    } 
    this.zzl.zzs().setConditionalUserProperty(paramBundle, paramLong);
  }
  
  public void setCurrentScreen(IObjectWrapper paramIObjectWrapper, String paramString1, String paramString2, long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzv().setCurrentScreen((Activity)ObjectWrapper.unwrap(paramIObjectWrapper), paramString1, paramString2);
  }
  
  public void setDataCollectionEnabled(boolean paramBoolean) throws RemoteException {
    zzah();
    this.zzl.zzs().zza(paramBoolean);
  }
  
  public void setEventInterceptor(zzt paramzzt) throws RemoteException {
    zzah();
    zzdd zzdd = this.zzl.zzs();
    zza zza = new zza(this, paramzzt);
    zzdd.zzo();
    zzdd.zzah();
    zzdd.zzac().zza(new zzdk(zzdd, zza));
  }
  
  public void setInstanceIdProvider(zzw paramzzw) throws RemoteException {
    zzah();
  }
  
  public void setMeasurementEnabled(boolean paramBoolean, long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzs().setMeasurementEnabled(paramBoolean);
  }
  
  public void setMinimumSessionDuration(long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzs().setMinimumSessionDuration(paramLong);
  }
  
  public void setSessionTimeoutDuration(long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzs().setSessionTimeoutDuration(paramLong);
  }
  
  public void setUserId(String paramString, long paramLong) throws RemoteException {
    zzah();
    this.zzl.zzs().zza(null, "_id", paramString, true, paramLong);
  }
  
  public void setUserProperty(String paramString1, String paramString2, IObjectWrapper paramIObjectWrapper, boolean paramBoolean, long paramLong) throws RemoteException {
    zzah();
    Object object = ObjectWrapper.unwrap(paramIObjectWrapper);
    this.zzl.zzs().zza(paramString1, paramString2, object, paramBoolean, paramLong);
  }
  
  public void unregisterOnMeasurementEventListener(zzt paramzzt) throws RemoteException {
    zzah();
    zzdb zzdb1 = this.zzad.remove(Integer.valueOf(paramzzt.id()));
    zzdb zzdb2 = zzdb1;
    if (zzdb1 == null)
      zzdb2 = new zzb(this, paramzzt); 
    this.zzl.zzs().zzb(zzdb2);
  }
  
  final class zza implements zzda {
    private zzt zzdm;
    
    zza(AppMeasurementDynamiteService this$0, zzt param1zzt) {
      this.zzdm = param1zzt;
    }
    
    public final void interceptEvent(String param1String1, String param1String2, Bundle param1Bundle, long param1Long) {
      try {
        this.zzdm.onEvent(param1String1, param1String2, param1Bundle, param1Long);
        return;
      } catch (RemoteException remoteException) {
        this.zzdi.zzl.zzad().zzdd().zza("Event interceptor threw exception", remoteException);
        return;
      } 
    }
  }
  
  final class zzb implements zzdb {
    private zzt zzdm;
    
    zzb(AppMeasurementDynamiteService this$0, zzt param1zzt) {
      this.zzdm = param1zzt;
    }
    
    public final void onEvent(String param1String1, String param1String2, Bundle param1Bundle, long param1Long) {
      try {
        this.zzdm.onEvent(param1String1, param1String2, param1Bundle, param1Long);
        return;
      } catch (RemoteException remoteException) {
        this.zzdi.zzl.zzad().zzdd().zza("Event listener threw exception", remoteException);
        return;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\AppMeasurementDynamiteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */