package com.google.android.gms.phenotype;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zza {
  private static final ConcurrentHashMap<Uri, zza> zzg = new ConcurrentHashMap<Uri, zza>();
  
  private static final String[] zzl = new String[] { "key", "value" };
  
  private final Uri uri;
  
  private final ContentResolver zzh;
  
  private final ContentObserver zzi;
  
  private final Object zzj = new Object();
  
  private volatile Map<String, String> zzk;
  
  private zza(ContentResolver paramContentResolver, Uri paramUri) {
    this.zzh = paramContentResolver;
    this.uri = paramUri;
    this.zzi = new zzb(this, null);
  }
  
  public static zza zza(ContentResolver paramContentResolver, Uri paramUri) {
    zza zza1 = zzg.get(paramUri);
    zza zza2 = zza1;
    if (zza1 == null) {
      zza2 = new zza(paramContentResolver, paramUri);
      zza zza3 = zzg.putIfAbsent(paramUri, zza2);
      if (zza3 == null) {
        zza2.zzh.registerContentObserver(zza2.uri, false, zza2.zzi);
      } else {
        zza2 = zza3;
      } 
    } 
    return zza2;
  }
  
  private final Map<String, String> zzc() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Cursor cursor = this.zzh.query(this.uri, zzl, null, null, null);
    if (cursor != null)
      try {
        while (cursor.moveToNext())
          hashMap.put(cursor.getString(0), cursor.getString(1)); 
      } finally {
        cursor.close();
      }  
    return (Map)hashMap;
  }
  
  public final Map<String, String> zza() {
    Map<String, String> map1;
    if (PhenotypeFlag.zza("gms:phenotype:phenotype_flag:debug_disable_caching", false)) {
      map1 = zzc();
    } else {
      map1 = this.zzk;
    } 
    Map<String, String> map2 = map1;
    if (map1 == null)
      synchronized (this.zzj) {
        map2 = this.zzk;
        map1 = map2;
        if (map2 == null) {
          map1 = zzc();
          this.zzk = map1;
        } 
        map2 = map1;
      }  
    return map2;
  }
  
  public final void zzb() {
    synchronized (this.zzj) {
      this.zzk = null;
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\phenotype\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */