package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzce;
import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzin;
import java.io.IOException;
import java.util.Map;

public final class zzbs extends zzfs implements zzv {
  @VisibleForTesting
  private static int zzmp = 65535;
  
  @VisibleForTesting
  private static int zzmq = 2;
  
  private final Map<String, Map<String, String>> zzmr = (Map<String, Map<String, String>>)new ArrayMap();
  
  private final Map<String, Map<String, Boolean>> zzms = (Map<String, Map<String, Boolean>>)new ArrayMap();
  
  private final Map<String, Map<String, Boolean>> zzmt = (Map<String, Map<String, Boolean>>)new ArrayMap();
  
  private final Map<String, zzce> zzmu = (Map<String, zzce>)new ArrayMap();
  
  private final Map<String, Map<String, Integer>> zzmv = (Map<String, Map<String, Integer>>)new ArrayMap();
  
  private final Map<String, String> zzmw = (Map<String, String>)new ArrayMap();
  
  zzbs(zzft paramzzft) {
    super(paramzzft);
  }
  
  @WorkerThread
  private final zzce zza(String paramString, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return new zzce(); 
    zzim zzim = zzim.zzj(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    zzce zzce = new zzce();
    try {
      zzce.zza(zzim);
      super.zzad().zzdi().zza("Parsed config. version, gmp_app_id", zzce.zzxa, zzce.zzch);
      return zzce;
    } catch (IOException iOException) {
      super.zzad().zzdd().zza("Unable to merge remote config. appId", zzau.zzao(paramString), iOException);
      return new zzce();
    } 
  }
  
  private static Map<String, String> zza(zzce paramzzce) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (paramzzce != null && paramzzce.zzxc != null)
      for (zzbr.zza zza : paramzzce.zzxc) {
        if (zza != null)
          arrayMap.put(zza.getKey(), zza.getValue()); 
      }  
    return (Map<String, String>)arrayMap;
  }
  
  private final void zza(String paramString, zzce paramzzce) {
    ArrayMap<String, Boolean> arrayMap1 = new ArrayMap();
    ArrayMap<String, Boolean> arrayMap2 = new ArrayMap();
    ArrayMap<String, Integer> arrayMap = new ArrayMap();
    if (paramzzce != null && paramzzce.zzxd != null)
      for (zzcd zzcd : paramzzce.zzxd) {
        if (TextUtils.isEmpty(zzcd.name)) {
          super.zzad().zzdd().zzaq("EventConfig contained null event name");
        } else {
          String str = zzcx.zzbh(zzcd.name);
          if (!TextUtils.isEmpty(str))
            zzcd.name = str; 
          arrayMap1.put(zzcd.name, zzcd.zzwx);
          arrayMap2.put(zzcd.name, zzcd.zzwy);
          if (zzcd.zzwz != null)
            if (zzcd.zzwz.intValue() < zzmq || zzcd.zzwz.intValue() > zzmp) {
              super.zzad().zzdd().zza("Invalid sampling rate. Event name, sample rate", zzcd.name, zzcd.zzwz);
            } else {
              arrayMap.put(zzcd.name, zzcd.zzwz);
            }  
        } 
      }  
    this.zzms.put(paramString, arrayMap1);
    this.zzmt.put(paramString, arrayMap2);
    this.zzmv.put(paramString, arrayMap);
  }
  
  @WorkerThread
  private final void zzax(String paramString) {
    zzah();
    super.zzq();
    Preconditions.checkNotEmpty(paramString);
    if (this.zzmu.get(paramString) == null) {
      byte[] arrayOfByte = super.zzdo().zzag(paramString);
      if (arrayOfByte == null) {
        this.zzmr.put(paramString, null);
        this.zzms.put(paramString, null);
        this.zzmt.put(paramString, null);
        this.zzmu.put(paramString, null);
        this.zzmw.put(paramString, null);
        this.zzmv.put(paramString, null);
        return;
      } 
      zzce zzce = zza(paramString, arrayOfByte);
      this.zzmr.put(paramString, zza(zzce));
      zza(paramString, zzce);
      this.zzmu.put(paramString, zzce);
      this.zzmw.put(paramString, null);
    } 
  }
  
  @WorkerThread
  protected final boolean zza(String paramString1, byte[] paramArrayOfbyte, String paramString2) {
    zzah();
    super.zzq();
    Preconditions.checkNotEmpty(paramString1);
    zzce zzce = zza(paramString1, paramArrayOfbyte);
    if (zzce == null)
      return false; 
    zza(paramString1, zzce);
    this.zzmu.put(paramString1, zzce);
    this.zzmw.put(paramString1, paramString2);
    this.zzmr.put(paramString1, zza(zzce));
    zzo zzo = super.zzdn();
    zzbx[] arrayOfZzbx = zzce.zzxe;
    Preconditions.checkNotNull(arrayOfZzbx);
    int i = arrayOfZzbx.length;
    for (byte b = 0; b < i; b++) {
      zzbx zzbx = arrayOfZzbx[b];
      for (zzby zzby : zzbx.zzvw) {
        String str = zzcx.zzbh(zzby.zzwb);
        if (str != null)
          zzby.zzwb = str; 
        for (zzbz zzbz : zzby.zzwc) {
          str = zzcy.zzbh(zzbz.zzwj);
          if (str != null)
            zzbz.zzwj = str; 
        } 
      } 
      for (zzcb zzcb : zzbx.zzvv) {
        String str = zzcz.zzbh(zzcb.zzwq);
        if (str != null)
          zzcb.zzwq = str; 
      } 
    } 
    zzo.zzdo().zza(paramString1, arrayOfZzbx);
    try {
      zzce.zzxe = null;
      byte[] arrayOfByte = new byte[zzce.zzly()];
      zzce.zza(zzin.zzk(arrayOfByte, 0, arrayOfByte.length));
      paramArrayOfbyte = arrayOfByte;
    } catch (IOException iOException) {
      super.zzad().zzdd().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzau.zzao(paramString1), iOException);
    } 
    zzw zzw = super.zzdo();
    Preconditions.checkNotEmpty(paramString1);
    zzw.zzq();
    zzw.zzah();
    ContentValues contentValues = new ContentValues();
    contentValues.put("remote_config", paramArrayOfbyte);
    try {
      if (zzw.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[] { paramString1 }) == 0L)
        zzw.zzad().zzda().zza("Failed to update remote config (got 0). appId", zzau.zzao(paramString1)); 
    } catch (SQLiteException sQLiteException) {
      zzw.zzad().zzda().zza("Error storing remote config. appId", zzau.zzao(paramString1), sQLiteException);
    } 
    return true;
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  @WorkerThread
  protected final zzce zzay(String paramString) {
    zzah();
    super.zzq();
    Preconditions.checkNotEmpty(paramString);
    zzax(paramString);
    return this.zzmu.get(paramString);
  }
  
  @WorkerThread
  protected final String zzaz(String paramString) {
    super.zzq();
    return this.zzmw.get(paramString);
  }
  
  @WorkerThread
  public final String zzb(String paramString1, String paramString2) {
    super.zzq();
    zzax(paramString1);
    Map map = this.zzmr.get(paramString1);
    return (map != null) ? (String)map.get(paramString2) : null;
  }
  
  @WorkerThread
  protected final void zzba(String paramString) {
    super.zzq();
    this.zzmw.put(paramString, null);
  }
  
  @WorkerThread
  final void zzbb(String paramString) {
    super.zzq();
    this.zzmu.remove(paramString);
  }
  
  @WorkerThread
  final boolean zzbc(String paramString) {
    super.zzq();
    Boolean bool = (zzay(paramString)).zzxg;
    return (bool == null) ? false : bool.booleanValue();
  }
  
  @WorkerThread
  final long zzbd(String paramString) {
    String str = zzb(paramString, "measurement.account.time_zone_offset_minutes");
    if (!TextUtils.isEmpty(str))
      try {
        return Long.parseLong(str);
      } catch (NumberFormatException numberFormatException) {
        super.zzad().zzdd().zza("Unable to parse timezone offset. appId", zzau.zzao(paramString), numberFormatException);
      }  
    return 0L;
  }
  
  final boolean zzbe(String paramString) {
    return "1".equals(zzb(paramString, "measurement.upload.blacklist_internal"));
  }
  
  final boolean zzbf(String paramString) {
    return "1".equals(zzb(paramString, "measurement.upload.blacklist_public"));
  }
  
  @WorkerThread
  final boolean zzk(String paramString1, String paramString2) {
    super.zzq();
    zzax(paramString1);
    if (zzbe(paramString1) && zzgd.zzbs(paramString2))
      return true; 
    if (zzbf(paramString1) && zzgd.zzbm(paramString2))
      return true; 
    Map map = this.zzms.get(paramString1);
    if (map != null) {
      Boolean bool = (Boolean)map.get(paramString2);
      return (bool == null) ? false : bool.booleanValue();
    } 
    return false;
  }
  
  @WorkerThread
  final boolean zzl(String paramString1, String paramString2) {
    super.zzq();
    zzax(paramString1);
    if ("ecommerce_purchase".equals(paramString2))
      return true; 
    Map map = this.zzmt.get(paramString1);
    if (map != null) {
      Boolean bool = (Boolean)map.get(paramString2);
      return (bool == null) ? false : bool.booleanValue();
    } 
    return false;
  }
  
  @WorkerThread
  final int zzm(String paramString1, String paramString2) {
    super.zzq();
    zzax(paramString1);
    Map map = this.zzmv.get(paramString1);
    if (map != null) {
      Integer integer = (Integer)map.get(paramString2);
      return (integer == null) ? 1 : integer.intValue();
    } 
    return 1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */