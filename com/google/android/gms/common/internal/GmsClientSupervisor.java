package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class GmsClientSupervisor {
  private static final Object zzdp = new Object();
  
  private static GmsClientSupervisor zzdq;
  
  @KeepForSdk
  public static GmsClientSupervisor getInstance(Context paramContext) {
    synchronized (zzdp) {
      if (zzdq == null) {
        zze zze = new zze();
        this(paramContext.getApplicationContext());
        zzdq = zze;
      } 
      return zzdq;
    } 
  }
  
  @KeepForSdk
  public boolean bindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString) {
    return zza(new zza(paramComponentName, 129), paramServiceConnection, paramString);
  }
  
  @KeepForSdk
  public boolean bindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2) {
    return zza(new zza(paramString1, 129), paramServiceConnection, paramString2);
  }
  
  @KeepForSdk
  public void unbindService(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString) {
    zzb(new zza(paramComponentName, 129), paramServiceConnection, paramString);
  }
  
  @KeepForSdk
  public void unbindService(String paramString1, ServiceConnection paramServiceConnection, String paramString2) {
    zzb(new zza(paramString1, 129), paramServiceConnection, paramString2);
  }
  
  public final void zza(String paramString1, String paramString2, int paramInt, ServiceConnection paramServiceConnection, String paramString3) {
    zzb(new zza(paramString1, paramString2, paramInt), paramServiceConnection, paramString3);
  }
  
  protected abstract boolean zza(zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  protected abstract void zzb(zza paramzza, ServiceConnection paramServiceConnection, String paramString);
  
  protected static final class zza {
    private final ComponentName mComponentName;
    
    private final String zzdr = null;
    
    private final String zzds = null;
    
    private final int zzdt;
    
    public zza(ComponentName param1ComponentName, int param1Int) {
      this.mComponentName = Preconditions.<ComponentName>checkNotNull(param1ComponentName);
      this.zzdt = 129;
    }
    
    public zza(String param1String, int param1Int) {
      this.mComponentName = null;
      this.zzdt = 129;
    }
    
    public zza(String param1String1, String param1String2, int param1Int) {
      this.mComponentName = null;
      this.zzdt = param1Int;
    }
    
    public final boolean equals(Object param1Object) {
      if (this == param1Object)
        return true; 
      if (!(param1Object instanceof zza))
        return false; 
      param1Object = param1Object;
      return (Objects.equal(this.zzdr, ((zza)param1Object).zzdr) && Objects.equal(this.zzds, ((zza)param1Object).zzds) && Objects.equal(this.mComponentName, ((zza)param1Object).mComponentName) && this.zzdt == ((zza)param1Object).zzdt);
    }
    
    public final ComponentName getComponentName() {
      return this.mComponentName;
    }
    
    public final String getPackage() {
      return this.zzds;
    }
    
    public final int hashCode() {
      return Objects.hashCode(new Object[] { this.zzdr, this.zzds, this.mComponentName, Integer.valueOf(this.zzdt) });
    }
    
    public final String toString() {
      String str1 = this.zzdr;
      String str2 = str1;
      if (str1 == null)
        str2 = this.mComponentName.flattenToString(); 
      return str2;
    }
    
    public final Intent zzb(Context param1Context) {
      Intent intent;
      String str = this.zzdr;
      if (str != null) {
        intent = (new Intent(str)).setPackage(this.zzds);
      } else {
        intent = (new Intent()).setComponent(this.mComponentName);
      } 
      return intent;
    }
    
    public final int zzq() {
      return this.zzdt;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\GmsClientSupervisor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */