package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzab {
  private static final ConcurrentHashMap<Uri, zzab> zzde = new ConcurrentHashMap<Uri, zzab>();
  
  private static final String[] zzdl = new String[] { "key", "value" };
  
  private final Uri uri;
  
  private final ContentResolver zzdf;
  
  private final ContentObserver zzdg;
  
  private final Object zzdh = new Object();
  
  private volatile Map<String, String> zzdi;
  
  private final Object zzdj = new Object();
  
  @GuardedBy("listenersLock")
  private final List<zzad> zzdk = new ArrayList<zzad>();
  
  private zzab(ContentResolver paramContentResolver, Uri paramUri) {
    this.zzdf = paramContentResolver;
    this.uri = paramUri;
    this.zzdg = new zzac(this, null);
  }
  
  public static zzab zza(ContentResolver paramContentResolver, Uri paramUri) {
    zzab zzab1 = zzde.get(paramUri);
    zzab zzab2 = zzab1;
    if (zzab1 == null) {
      zzab2 = new zzab(paramContentResolver, paramUri);
      zzab zzab3 = zzde.putIfAbsent(paramUri, zzab2);
      if (zzab3 == null) {
        zzab2.zzdf.registerContentObserver(zzab2.uri, false, zzab2.zzdg);
      } else {
        zzab2 = zzab3;
      } 
    } 
    return zzab2;
  }
  
  private final Map<String, String> zzi() {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      Cursor cursor = this.zzdf.query(this.uri, zzdl, null, null, null);
      if (cursor != null)
        try {
          while (cursor.moveToNext())
            hashMap.put(cursor.getString(0), cursor.getString(1)); 
        } finally {
          cursor.close();
        }  
      return (Map)hashMap;
    } catch (SecurityException|android.database.sqlite.SQLiteException securityException) {
      Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
      return null;
    } 
  }
  
  private final void zzj() {
    synchronized (this.zzdj) {
      Iterator<zzad> iterator = this.zzdk.iterator();
      while (iterator.hasNext())
        ((zzad)iterator.next()).zzk(); 
      return;
    } 
  }
  
  public final Map<String, String> zzg() {
    Map<String, String> map1;
    if (zzae.zza("gms:phenotype:phenotype_flag:debug_disable_caching", false)) {
      map1 = zzi();
    } else {
      map1 = this.zzdi;
    } 
    Map<String, String> map2 = map1;
    if (map1 == null)
      synchronized (this.zzdh) {
        map2 = this.zzdi;
        map1 = map2;
        if (map2 == null) {
          map1 = zzi();
          this.zzdi = map1;
        } 
        map2 = map1;
      }  
    return (map2 != null) ? map2 : Collections.emptyMap();
  }
  
  public final void zzh() {
    synchronized (this.zzdh) {
      this.zzdi = null;
      return;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */