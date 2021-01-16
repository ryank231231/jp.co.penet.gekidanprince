package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

final class zzab extends zzaa.zza {
  zzab(zzaa paramzzaa, String paramString1, String paramString2, Context paramContext) {
    super(paramzzaa);
  }
  
  public final void zzl() {
    try {
      zzaa zzaa2;
      zzaa zzaa3;
      boolean bool;
      zzaa zzaa1 = this.zzar;
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      zzaa.zza(zzaa1, hashMap);
      if (zzaa.zza(this.zzar, this.zzao, this.zzap)) {
        String str2 = this.zzap;
        String str3 = this.zzao;
        String str1 = zzaa.zzb(this.zzar);
      } else {
        zzaa zzaa4 = null;
        zzaa1 = zzaa4;
        zzaa2 = zzaa1;
        zzaa3 = zzaa1;
        zzaa1 = zzaa4;
      } 
      zzaa.zzg(context);
      if (zzaa.zzk().booleanValue() || zzaa3 != null) {
        bool = true;
      } else {
        bool = false;
      } 
      zzaa.zza(this.zzar, this.zzar.zza(context, bool));
      if (zzaa.zzc(this.zzar) == null) {
        Log.w(zzaa.zzb(this.zzar), "Failed to connect to measurement client.");
        return;
      } 
      int i = zzaa.zzh(context);
      int j = zzaa.zzi(context);
      if (bool) {
        int k = Math.max(i, j);
        if (j < i) {
          bool = true;
        } else {
          bool = false;
        } 
        j = k;
      } else {
        if (i > 0)
          j = i; 
        if (i > 0) {
          bool = true;
        } else {
          bool = false;
        } 
      } 
      zzy zzy = new zzy();
      this(15300L, j, bool, (String)zzaa1, (String)zzaa3, (String)zzaa2, this.zzaq);
      zzaa.zzc(this.zzar).initialize(ObjectWrapper.wrap(context), zzy, this.timestamp);
      return;
    } catch (RemoteException remoteException) {
      zzaa.zza(this.zzar, (Exception)remoteException, true, false);
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */