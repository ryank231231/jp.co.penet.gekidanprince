package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbt;
import com.google.android.gms.internal.measurement.zzbx;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcb;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzch;
import com.google.android.gms.internal.measurement.zziv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzw extends zzfs {
  private static final String[] zzed = new String[] { "last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;" };
  
  private static final String[] zzee = new String[] { "origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;" };
  
  private static final String[] zzef = new String[] { 
      "app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", 
      "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", 
      "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", 
      "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", 
      "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;" };
  
  private static final String[] zzeg = new String[] { "realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;" };
  
  private static final String[] zzeh = new String[] { "has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;" };
  
  private static final String[] zzei = new String[] { "previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;" };
  
  private final zzz zzej = new zzz(this, getContext(), "google_app_measurement.db");
  
  private final zzfo zzek = new zzfo(zzz());
  
  zzw(zzft paramzzft) {
    super(paramzzft);
  }
  
  @WorkerThread
  private final long zza(String paramString, String[] paramArrayOfString) {
    SQLiteDatabase sQLiteDatabase = getWritableDatabase();
    Cursor cursor1 = null;
    Cursor cursor2 = null;
    try {
      Cursor cursor = sQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      cursor2 = cursor;
      cursor1 = cursor;
      if (cursor.moveToFirst()) {
        cursor2 = cursor;
        cursor1 = cursor;
        long l = cursor.getLong(0);
        if (cursor != null)
          cursor.close(); 
        return l;
      } 
      cursor2 = cursor;
      cursor1 = cursor;
      SQLiteException sQLiteException = new SQLiteException();
      cursor2 = cursor;
      cursor1 = cursor;
      this("Database returned empty set");
      cursor2 = cursor;
      cursor1 = cursor;
      throw sQLiteException;
    } catch (SQLiteException sQLiteException) {
      cursor2 = cursor1;
      zzad().zzda().zza("Database error", paramString, sQLiteException);
      cursor2 = cursor1;
      throw sQLiteException;
    } finally {}
    if (cursor2 != null)
      cursor2.close(); 
    throw paramString;
  }
  
  @WorkerThread
  private final long zza(String paramString, String[] paramArrayOfString, long paramLong) {
    SQLiteDatabase sQLiteDatabase = getWritableDatabase();
    Cursor cursor1 = null;
    Cursor cursor2 = null;
    try {
      Cursor cursor = sQLiteDatabase.rawQuery(paramString, paramArrayOfString);
      cursor2 = cursor;
      cursor1 = cursor;
      if (cursor.moveToFirst()) {
        cursor2 = cursor;
        cursor1 = cursor;
        paramLong = cursor.getLong(0);
        if (cursor != null)
          cursor.close(); 
        return paramLong;
      } 
      if (cursor != null)
        cursor.close(); 
      return paramLong;
    } catch (SQLiteException sQLiteException) {
      cursor2 = cursor1;
      zzad().zzda().zza("Database error", paramString, sQLiteException);
      cursor2 = cursor1;
      throw sQLiteException;
    } finally {}
    if (cursor2 != null)
      cursor2.close(); 
    throw paramString;
  }
  
  @WorkerThread
  @VisibleForTesting
  private final Object zza(Cursor paramCursor, int paramInt) {
    int i = paramCursor.getType(paramInt);
    switch (i) {
      default:
        zzad().zzda().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(i));
        return null;
      case 4:
        zzad().zzda().zzaq("Loaded invalid blob type value, ignoring it");
        return null;
      case 3:
        return paramCursor.getString(paramInt);
      case 2:
        return Double.valueOf(paramCursor.getDouble(paramInt));
      case 1:
        return Long.valueOf(paramCursor.getLong(paramInt));
      case 0:
        break;
    } 
    zzad().zzda().zzaq("Loaded invalid null value from database");
    return null;
  }
  
  @WorkerThread
  private static void zza(ContentValues paramContentValues, String paramString, Object paramObject) {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramObject);
    if (paramObject instanceof String) {
      paramContentValues.put(paramString, (String)paramObject);
      return;
    } 
    if (paramObject instanceof Long) {
      paramContentValues.put(paramString, (Long)paramObject);
      return;
    } 
    if (paramObject instanceof Double) {
      paramContentValues.put(paramString, (Double)paramObject);
      return;
    } 
    throw new IllegalArgumentException("Invalid value type");
  }
  
  @WorkerThread
  private final boolean zza(String paramString, int paramInt, zzby paramzzby) {
    zzah();
    zzq();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzby);
    if (TextUtils.isEmpty(paramzzby.zzwb)) {
      zzad().zzdd().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzau.zzao(paramString), Integer.valueOf(paramInt), String.valueOf(paramzzby.zzwa));
      return false;
    } 
    byte[] arrayOfByte = zziv.zzb((zziv)paramzzby);
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramString);
    contentValues.put("audience_id", Integer.valueOf(paramInt));
    contentValues.put("filter_id", paramzzby.zzwa);
    contentValues.put("event_name", paramzzby.zzwb);
    contentValues.put("data", arrayOfByte);
    try {
      if (getWritableDatabase().insertWithOnConflict("event_filters", null, contentValues, 5) == -1L)
        zzad().zzda().zza("Failed to insert event filter (got -1). appId", zzau.zzao(paramString)); 
      return true;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing event filter. appId", zzau.zzao(paramString), sQLiteException);
      return false;
    } 
  }
  
  @WorkerThread
  private final boolean zza(String paramString, int paramInt, zzcb paramzzcb) {
    zzah();
    zzq();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzcb);
    if (TextUtils.isEmpty(paramzzcb.zzwq)) {
      zzad().zzdd().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzau.zzao(paramString), Integer.valueOf(paramInt), String.valueOf(paramzzcb.zzwa));
      return false;
    } 
    byte[] arrayOfByte = zziv.zzb((zziv)paramzzcb);
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramString);
    contentValues.put("audience_id", Integer.valueOf(paramInt));
    contentValues.put("filter_id", paramzzcb.zzwa);
    contentValues.put("property_name", paramzzcb.zzwq);
    contentValues.put("data", arrayOfByte);
    try {
      if (getWritableDatabase().insertWithOnConflict("property_filters", null, contentValues, 5) == -1L) {
        zzad().zzda().zza("Failed to insert property filter (got -1). appId", zzau.zzao(paramString));
        return false;
      } 
      return true;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing property filter. appId", zzau.zzao(paramString), sQLiteException);
      return false;
    } 
  }
  
  private final boolean zza(String paramString, List<Integer> paramList) {
    Preconditions.checkNotEmpty(paramString);
    zzah();
    zzq();
    SQLiteDatabase sQLiteDatabase = getWritableDatabase();
    try {
      long l = zza("select count(1) from audience_filter_values where app_id=?", new String[] { paramString });
      int i = Math.max(0, Math.min(2000, zzaf().zzb(paramString, zzal.zzhi)));
      if (l <= i)
        return false; 
      ArrayList<String> arrayList = new ArrayList();
      for (byte b = 0; b < paramList.size(); b++) {
        Integer integer = paramList.get(b);
        if (integer == null || !(integer instanceof Integer))
          return false; 
        arrayList.add(Integer.toString(integer.intValue()));
      } 
      String str2 = TextUtils.join(",", arrayList);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str2).length() + 2);
      stringBuilder1.append("(");
      stringBuilder1.append(str2);
      stringBuilder1.append(")");
      String str1 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(str1).length() + 140);
      stringBuilder2.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
      stringBuilder2.append(str1);
      stringBuilder2.append(" order by rowid desc limit -1 offset ?)");
      return (sQLiteDatabase.delete("audience_filter_values", stringBuilder2.toString(), new String[] { paramString, Integer.toString(i) }) > 0);
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Database error querying filters. appId", zzau.zzao(paramString), sQLiteException);
      return false;
    } 
  }
  
  private final boolean zzcg() {
    return getContext().getDatabasePath("google_app_measurement.db").exists();
  }
  
  @WorkerThread
  public final void beginTransaction() {
    zzah();
    getWritableDatabase().beginTransaction();
  }
  
  @WorkerThread
  public final void endTransaction() {
    zzah();
    getWritableDatabase().endTransaction();
  }
  
  @WorkerThread
  @VisibleForTesting
  final SQLiteDatabase getWritableDatabase() {
    zzq();
    try {
      return this.zzej.getWritableDatabase();
    } catch (SQLiteException sQLiteException) {
      zzad().zzdd().zza("Error opening database", sQLiteException);
      throw sQLiteException;
    } 
  }
  
  @WorkerThread
  public final void setTransactionSuccessful() {
    zzah();
    getWritableDatabase().setTransactionSuccessful();
  }
  
  public final long zza(zzch paramzzch) throws IOException {
    zzq();
    zzah();
    Preconditions.checkNotNull(paramzzch);
    Preconditions.checkNotEmpty(paramzzch.zzcf);
    byte[] arrayOfByte = zziv.zzb((zziv)paramzzch);
    long l = zzdm().zza(arrayOfByte);
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramzzch.zzcf);
    contentValues.put("metadata_fingerprint", Long.valueOf(l));
    contentValues.put("metadata", arrayOfByte);
    try {
      getWritableDatabase().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
      return l;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing raw event metadata. appId", zzau.zzao(paramzzch.zzcf), sQLiteException);
      throw sQLiteException;
    } 
  }
  
  public final Pair<zzcf, Long> zza(String paramString, Long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzq : ()V
    //   4: aload_0
    //   5: invokevirtual zzah : ()V
    //   8: aload_0
    //   9: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   12: ldc_w 'select main_event, children_to_process from main_event_params where app_id=? and event_id=?'
    //   15: iconst_2
    //   16: anewarray java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload_2
    //   26: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   29: aastore
    //   30: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_3
    //   34: aload_3
    //   35: astore #4
    //   37: aload_3
    //   38: invokeinterface moveToFirst : ()Z
    //   43: ifne -> 74
    //   46: aload_3
    //   47: astore #4
    //   49: aload_0
    //   50: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   53: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   56: ldc_w 'Main event not found'
    //   59: invokevirtual zzaq : (Ljava/lang/String;)V
    //   62: aload_3
    //   63: ifnull -> 72
    //   66: aload_3
    //   67: invokeinterface close : ()V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_3
    //   75: astore #4
    //   77: aload_3
    //   78: iconst_0
    //   79: invokeinterface getBlob : (I)[B
    //   84: astore #5
    //   86: aload_3
    //   87: astore #4
    //   89: aload_3
    //   90: iconst_1
    //   91: invokeinterface getLong : (I)J
    //   96: lstore #6
    //   98: aload_3
    //   99: astore #4
    //   101: aload #5
    //   103: invokestatic zze : ([B)Lcom/google/android/gms/internal/measurement/zzcf;
    //   106: astore #5
    //   108: aload_3
    //   109: astore #4
    //   111: aload #5
    //   113: lload #6
    //   115: invokestatic valueOf : (J)Ljava/lang/Long;
    //   118: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   121: astore_1
    //   122: aload_3
    //   123: ifnull -> 132
    //   126: aload_3
    //   127: invokeinterface close : ()V
    //   132: aload_1
    //   133: areturn
    //   134: astore #5
    //   136: aload_3
    //   137: astore #4
    //   139: aload_0
    //   140: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   143: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   146: ldc_w 'Failed to merge main event. appId, eventId'
    //   149: aload_1
    //   150: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   153: aload_2
    //   154: aload #5
    //   156: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   159: aload_3
    //   160: ifnull -> 169
    //   163: aload_3
    //   164: invokeinterface close : ()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_2
    //   172: aload_3
    //   173: astore_1
    //   174: goto -> 187
    //   177: astore_1
    //   178: aconst_null
    //   179: astore #4
    //   181: goto -> 217
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: astore #4
    //   190: aload_0
    //   191: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   194: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   197: ldc_w 'Error selecting main event'
    //   200: aload_2
    //   201: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   204: aload_1
    //   205: ifnull -> 214
    //   208: aload_1
    //   209: invokeinterface close : ()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore_1
    //   217: aload #4
    //   219: ifnull -> 229
    //   222: aload #4
    //   224: invokeinterface close : ()V
    //   229: aload_1
    //   230: athrow
    // Exception table:
    //   from	to	target	type
    //   8	34	184	android/database/sqlite/SQLiteException
    //   8	34	177	finally
    //   37	46	171	android/database/sqlite/SQLiteException
    //   37	46	216	finally
    //   49	62	171	android/database/sqlite/SQLiteException
    //   49	62	216	finally
    //   77	86	171	android/database/sqlite/SQLiteException
    //   77	86	216	finally
    //   89	98	171	android/database/sqlite/SQLiteException
    //   89	98	216	finally
    //   101	108	134	java/io/IOException
    //   101	108	171	android/database/sqlite/SQLiteException
    //   101	108	216	finally
    //   111	122	171	android/database/sqlite/SQLiteException
    //   111	122	216	finally
    //   139	159	171	android/database/sqlite/SQLiteException
    //   139	159	216	finally
    //   190	204	216	finally
  }
  
  @WorkerThread
  public final zzx zza(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
    Cursor cursor;
    Preconditions.checkNotEmpty(paramString);
    zzq();
    zzah();
    zzx zzx = new zzx();
    try {
      SQLiteDatabase sQLiteDatabase = getWritableDatabase();
      cursor = sQLiteDatabase.query("apps", new String[] { "day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count" }, "app_id=?", new String[] { paramString }, null, null, null);
    } catch (SQLiteException sQLiteException) {
    
    } finally {
      paramString = null;
    } 
    try {
      zzad().zzda().zza("Error updating daily counts. appId", zzau.zzao(paramString), sQLiteException);
      if (cursor != null)
        cursor.close(); 
      return zzx;
    } finally {}
    if (cursor != null)
      cursor.close(); 
    throw paramString;
  }
  
  @WorkerThread
  public final List<Pair<zzch, Long>> zza(String paramString, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzq : ()V
    //   4: aload_0
    //   5: invokevirtual zzah : ()V
    //   8: iload_2
    //   9: ifle -> 18
    //   12: iconst_1
    //   13: istore #4
    //   15: goto -> 21
    //   18: iconst_0
    //   19: istore #4
    //   21: iload #4
    //   23: invokestatic checkArgument : (Z)V
    //   26: iload_3
    //   27: ifle -> 36
    //   30: iconst_1
    //   31: istore #4
    //   33: goto -> 39
    //   36: iconst_0
    //   37: istore #4
    //   39: iload #4
    //   41: invokestatic checkArgument : (Z)V
    //   44: aload_1
    //   45: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   48: pop
    //   49: aconst_null
    //   50: astore #5
    //   52: aconst_null
    //   53: astore #6
    //   55: aload_0
    //   56: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   59: ldc_w 'queue'
    //   62: iconst_3
    //   63: anewarray java/lang/String
    //   66: dup
    //   67: iconst_0
    //   68: ldc_w 'rowid'
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: ldc_w 'data'
    //   77: aastore
    //   78: dup
    //   79: iconst_2
    //   80: ldc 'retry_count'
    //   82: aastore
    //   83: ldc_w 'app_id=?'
    //   86: iconst_1
    //   87: anewarray java/lang/String
    //   90: dup
    //   91: iconst_0
    //   92: aload_1
    //   93: aastore
    //   94: aconst_null
    //   95: aconst_null
    //   96: ldc_w 'rowid'
    //   99: iload_2
    //   100: invokestatic valueOf : (I)Ljava/lang/String;
    //   103: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore #7
    //   108: aload #7
    //   110: astore #6
    //   112: aload #7
    //   114: astore #5
    //   116: aload #7
    //   118: invokeinterface moveToFirst : ()Z
    //   123: ifne -> 154
    //   126: aload #7
    //   128: astore #6
    //   130: aload #7
    //   132: astore #5
    //   134: invokestatic emptyList : ()Ljava/util/List;
    //   137: astore #8
    //   139: aload #7
    //   141: ifnull -> 151
    //   144: aload #7
    //   146: invokeinterface close : ()V
    //   151: aload #8
    //   153: areturn
    //   154: aload #7
    //   156: astore #6
    //   158: aload #7
    //   160: astore #5
    //   162: new java/util/ArrayList
    //   165: astore #8
    //   167: aload #7
    //   169: astore #6
    //   171: aload #7
    //   173: astore #5
    //   175: aload #8
    //   177: invokespecial <init> : ()V
    //   180: iconst_0
    //   181: istore_2
    //   182: aload #7
    //   184: astore #6
    //   186: aload #7
    //   188: astore #5
    //   190: aload #7
    //   192: iconst_0
    //   193: invokeinterface getLong : (I)J
    //   198: lstore #9
    //   200: aload #7
    //   202: astore #6
    //   204: aload #7
    //   206: astore #5
    //   208: aload #7
    //   210: iconst_1
    //   211: invokeinterface getBlob : (I)[B
    //   216: astore #11
    //   218: aload #7
    //   220: astore #6
    //   222: aload #7
    //   224: astore #5
    //   226: aload_0
    //   227: invokevirtual zzdm : ()Lcom/google/android/gms/measurement/internal/zzfz;
    //   230: aload #11
    //   232: invokevirtual zzb : ([B)[B
    //   235: astore #11
    //   237: aload #7
    //   239: astore #6
    //   241: aload #7
    //   243: astore #5
    //   245: aload #8
    //   247: invokeinterface isEmpty : ()Z
    //   252: ifne -> 276
    //   255: aload #7
    //   257: astore #6
    //   259: aload #7
    //   261: astore #5
    //   263: aload #11
    //   265: arraylength
    //   266: istore #12
    //   268: iload #12
    //   270: iload_2
    //   271: iadd
    //   272: iload_3
    //   273: if_icmpgt -> 476
    //   276: aload #7
    //   278: astore #6
    //   280: aload #7
    //   282: astore #5
    //   284: aload #11
    //   286: invokestatic zzf : ([B)Lcom/google/android/gms/internal/measurement/zzch;
    //   289: astore #13
    //   291: aload #7
    //   293: astore #6
    //   295: aload #7
    //   297: astore #5
    //   299: aload #7
    //   301: iconst_2
    //   302: invokeinterface isNull : (I)Z
    //   307: ifne -> 334
    //   310: aload #7
    //   312: astore #6
    //   314: aload #7
    //   316: astore #5
    //   318: aload #13
    //   320: aload #7
    //   322: iconst_2
    //   323: invokeinterface getInt : (I)I
    //   328: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   331: putfield zzyp : Ljava/lang/Integer;
    //   334: aload #7
    //   336: astore #6
    //   338: aload #7
    //   340: astore #5
    //   342: iload_2
    //   343: aload #11
    //   345: arraylength
    //   346: iadd
    //   347: istore #12
    //   349: aload #7
    //   351: astore #6
    //   353: aload #7
    //   355: astore #5
    //   357: aload #8
    //   359: aload #13
    //   361: lload #9
    //   363: invokestatic valueOf : (J)Ljava/lang/Long;
    //   366: invokestatic create : (Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   369: invokeinterface add : (Ljava/lang/Object;)Z
    //   374: pop
    //   375: goto -> 445
    //   378: astore #11
    //   380: aload #7
    //   382: astore #6
    //   384: aload #7
    //   386: astore #5
    //   388: aload_0
    //   389: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   392: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   395: ldc_w 'Failed to merge queued bundle. appId'
    //   398: aload_1
    //   399: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   402: aload #11
    //   404: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   407: iload_2
    //   408: istore #12
    //   410: goto -> 445
    //   413: astore #11
    //   415: aload #7
    //   417: astore #6
    //   419: aload #7
    //   421: astore #5
    //   423: aload_0
    //   424: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   427: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   430: ldc_w 'Failed to unzip queued bundle. appId'
    //   433: aload_1
    //   434: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   437: aload #11
    //   439: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   442: iload_2
    //   443: istore #12
    //   445: aload #7
    //   447: astore #6
    //   449: aload #7
    //   451: astore #5
    //   453: aload #7
    //   455: invokeinterface moveToNext : ()Z
    //   460: istore #4
    //   462: iload #4
    //   464: ifeq -> 476
    //   467: iload #12
    //   469: istore_2
    //   470: iload #12
    //   472: iload_3
    //   473: if_icmple -> 182
    //   476: aload #7
    //   478: ifnull -> 488
    //   481: aload #7
    //   483: invokeinterface close : ()V
    //   488: aload #8
    //   490: areturn
    //   491: astore_1
    //   492: goto -> 542
    //   495: astore #7
    //   497: aload #5
    //   499: astore #6
    //   501: aload_0
    //   502: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   505: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   508: ldc_w 'Error querying bundles. appId'
    //   511: aload_1
    //   512: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   515: aload #7
    //   517: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   520: aload #5
    //   522: astore #6
    //   524: invokestatic emptyList : ()Ljava/util/List;
    //   527: astore_1
    //   528: aload #5
    //   530: ifnull -> 540
    //   533: aload #5
    //   535: invokeinterface close : ()V
    //   540: aload_1
    //   541: areturn
    //   542: aload #6
    //   544: ifnull -> 554
    //   547: aload #6
    //   549: invokeinterface close : ()V
    //   554: aload_1
    //   555: athrow
    // Exception table:
    //   from	to	target	type
    //   55	108	495	android/database/sqlite/SQLiteException
    //   55	108	491	finally
    //   116	126	495	android/database/sqlite/SQLiteException
    //   116	126	491	finally
    //   134	139	495	android/database/sqlite/SQLiteException
    //   134	139	491	finally
    //   162	167	495	android/database/sqlite/SQLiteException
    //   162	167	491	finally
    //   175	180	495	android/database/sqlite/SQLiteException
    //   175	180	491	finally
    //   190	200	495	android/database/sqlite/SQLiteException
    //   190	200	491	finally
    //   208	218	413	java/io/IOException
    //   208	218	495	android/database/sqlite/SQLiteException
    //   208	218	491	finally
    //   226	237	413	java/io/IOException
    //   226	237	495	android/database/sqlite/SQLiteException
    //   226	237	491	finally
    //   245	255	495	android/database/sqlite/SQLiteException
    //   245	255	491	finally
    //   263	268	495	android/database/sqlite/SQLiteException
    //   263	268	491	finally
    //   284	291	378	java/io/IOException
    //   284	291	495	android/database/sqlite/SQLiteException
    //   284	291	491	finally
    //   299	310	495	android/database/sqlite/SQLiteException
    //   299	310	491	finally
    //   318	334	495	android/database/sqlite/SQLiteException
    //   318	334	491	finally
    //   342	349	495	android/database/sqlite/SQLiteException
    //   342	349	491	finally
    //   357	375	495	android/database/sqlite/SQLiteException
    //   357	375	491	finally
    //   388	407	495	android/database/sqlite/SQLiteException
    //   388	407	491	finally
    //   423	442	495	android/database/sqlite/SQLiteException
    //   423	442	491	finally
    //   453	462	495	android/database/sqlite/SQLiteException
    //   453	462	491	finally
    //   501	520	491	finally
    //   524	528	491	finally
  }
  
  @WorkerThread
  public final List<zzgc> zza(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual zzq : ()V
    //   9: aload_0
    //   10: invokevirtual zzah : ()V
    //   13: new java/util/ArrayList
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: aconst_null
    //   23: astore #5
    //   25: new java/util/ArrayList
    //   28: astore #6
    //   30: aload #6
    //   32: iconst_3
    //   33: invokespecial <init> : (I)V
    //   36: aload #6
    //   38: aload_1
    //   39: invokeinterface add : (Ljava/lang/Object;)Z
    //   44: pop
    //   45: new java/lang/StringBuilder
    //   48: astore #7
    //   50: aload #7
    //   52: ldc_w 'app_id=?'
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: aload_2
    //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   62: istore #8
    //   64: iload #8
    //   66: ifne -> 90
    //   69: aload #6
    //   71: aload_2
    //   72: invokeinterface add : (Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload #7
    //   80: ldc_w ' and origin=?'
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: goto -> 90
    //   90: aload_2
    //   91: astore #9
    //   93: aload_3
    //   94: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   97: ifne -> 127
    //   100: aload #6
    //   102: aload_3
    //   103: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   106: ldc_w '*'
    //   109: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   112: invokeinterface add : (Ljava/lang/Object;)Z
    //   117: pop
    //   118: aload #7
    //   120: ldc_w ' and name glob ?'
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload #6
    //   129: aload #6
    //   131: invokeinterface size : ()I
    //   136: anewarray java/lang/String
    //   139: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   144: checkcast [Ljava/lang/String;
    //   147: astore #10
    //   149: aload_0
    //   150: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   153: astore #6
    //   155: aload #7
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: astore #7
    //   162: aload #6
    //   164: ldc_w 'user_attributes'
    //   167: iconst_4
    //   168: anewarray java/lang/String
    //   171: dup
    //   172: iconst_0
    //   173: ldc_w 'name'
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: ldc_w 'set_timestamp'
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: ldc_w 'value'
    //   188: aastore
    //   189: dup
    //   190: iconst_3
    //   191: ldc 'origin'
    //   193: aastore
    //   194: aload #7
    //   196: aload #10
    //   198: aconst_null
    //   199: aconst_null
    //   200: ldc_w 'rowid'
    //   203: ldc_w '1001'
    //   206: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   209: astore #7
    //   211: aload #9
    //   213: astore #5
    //   215: aload #7
    //   217: invokeinterface moveToFirst : ()Z
    //   222: istore #8
    //   224: iload #8
    //   226: ifne -> 244
    //   229: aload #7
    //   231: ifnull -> 241
    //   234: aload #7
    //   236: invokeinterface close : ()V
    //   241: aload #4
    //   243: areturn
    //   244: aload #9
    //   246: astore #5
    //   248: aload #4
    //   250: invokeinterface size : ()I
    //   255: sipush #1000
    //   258: if_icmplt -> 287
    //   261: aload #9
    //   263: astore #5
    //   265: aload_0
    //   266: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   269: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   272: ldc_w 'Read more than the max allowed user properties, ignoring excess'
    //   275: sipush #1000
    //   278: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   281: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   284: goto -> 440
    //   287: aload #9
    //   289: astore #5
    //   291: aload #7
    //   293: iconst_0
    //   294: invokeinterface getString : (I)Ljava/lang/String;
    //   299: astore #6
    //   301: aload #9
    //   303: astore #5
    //   305: aload #7
    //   307: iconst_1
    //   308: invokeinterface getLong : (I)J
    //   313: lstore #11
    //   315: aload #7
    //   317: astore #5
    //   319: aload_0
    //   320: aload #7
    //   322: iconst_2
    //   323: invokespecial zza : (Landroid/database/Cursor;I)Ljava/lang/Object;
    //   326: astore #10
    //   328: aload #7
    //   330: astore #5
    //   332: aload #7
    //   334: iconst_3
    //   335: invokeinterface getString : (I)Ljava/lang/String;
    //   340: astore_2
    //   341: aload #10
    //   343: ifnonnull -> 382
    //   346: aload #7
    //   348: astore #5
    //   350: aload_0
    //   351: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   354: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   357: ldc_w '(2)Read invalid user property value, ignoring it'
    //   360: aload_1
    //   361: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   364: aload_2
    //   365: aload_3
    //   366: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   369: goto -> 422
    //   372: astore #9
    //   374: aload_2
    //   375: astore_3
    //   376: aload #9
    //   378: astore_2
    //   379: goto -> 522
    //   382: aload #7
    //   384: astore #5
    //   386: new com/google/android/gms/measurement/internal/zzgc
    //   389: astore #9
    //   391: aload #7
    //   393: astore #5
    //   395: aload #9
    //   397: aload_1
    //   398: aload_2
    //   399: aload #6
    //   401: lload #11
    //   403: aload #10
    //   405: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   408: aload #7
    //   410: astore #5
    //   412: aload #4
    //   414: aload #9
    //   416: invokeinterface add : (Ljava/lang/Object;)Z
    //   421: pop
    //   422: aload #7
    //   424: astore #5
    //   426: aload #7
    //   428: invokeinterface moveToNext : ()Z
    //   433: istore #8
    //   435: iload #8
    //   437: ifne -> 455
    //   440: aload #7
    //   442: ifnull -> 452
    //   445: aload #7
    //   447: invokeinterface close : ()V
    //   452: aload #4
    //   454: areturn
    //   455: aload_2
    //   456: astore #9
    //   458: goto -> 244
    //   461: astore_3
    //   462: goto -> 466
    //   465: astore_3
    //   466: aload_2
    //   467: astore #9
    //   469: aload_3
    //   470: astore_2
    //   471: aload #9
    //   473: astore_3
    //   474: goto -> 522
    //   477: astore_2
    //   478: aload #9
    //   480: astore_3
    //   481: goto -> 522
    //   484: astore_1
    //   485: goto -> 564
    //   488: astore_2
    //   489: aload #5
    //   491: astore_3
    //   492: goto -> 522
    //   495: astore #9
    //   497: goto -> 514
    //   500: astore #9
    //   502: goto -> 514
    //   505: astore_1
    //   506: aload #5
    //   508: astore_2
    //   509: goto -> 567
    //   512: astore #9
    //   514: aconst_null
    //   515: astore #7
    //   517: aload_2
    //   518: astore_3
    //   519: aload #9
    //   521: astore_2
    //   522: aload #7
    //   524: astore #5
    //   526: aload_0
    //   527: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   530: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   533: ldc_w '(2)Error querying user properties'
    //   536: aload_1
    //   537: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   540: aload_3
    //   541: aload_2
    //   542: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   545: aload #7
    //   547: ifnull -> 557
    //   550: aload #7
    //   552: invokeinterface close : ()V
    //   557: aconst_null
    //   558: areturn
    //   559: astore_1
    //   560: aload #5
    //   562: astore #7
    //   564: aload #7
    //   566: astore_2
    //   567: aload_2
    //   568: ifnull -> 577
    //   571: aload_2
    //   572: invokeinterface close : ()V
    //   577: aload_1
    //   578: athrow
    // Exception table:
    //   from	to	target	type
    //   25	36	512	android/database/sqlite/SQLiteException
    //   25	36	505	finally
    //   36	64	500	android/database/sqlite/SQLiteException
    //   36	64	505	finally
    //   69	87	495	android/database/sqlite/SQLiteException
    //   69	87	505	finally
    //   93	127	495	android/database/sqlite/SQLiteException
    //   93	127	505	finally
    //   127	211	495	android/database/sqlite/SQLiteException
    //   127	211	505	finally
    //   215	224	488	android/database/sqlite/SQLiteException
    //   215	224	484	finally
    //   248	261	488	android/database/sqlite/SQLiteException
    //   248	261	484	finally
    //   265	284	488	android/database/sqlite/SQLiteException
    //   265	284	484	finally
    //   291	301	488	android/database/sqlite/SQLiteException
    //   291	301	484	finally
    //   305	315	488	android/database/sqlite/SQLiteException
    //   305	315	484	finally
    //   319	328	477	android/database/sqlite/SQLiteException
    //   319	328	559	finally
    //   332	341	477	android/database/sqlite/SQLiteException
    //   332	341	559	finally
    //   350	369	372	android/database/sqlite/SQLiteException
    //   350	369	559	finally
    //   386	391	465	android/database/sqlite/SQLiteException
    //   386	391	559	finally
    //   395	408	461	android/database/sqlite/SQLiteException
    //   395	408	559	finally
    //   412	422	461	android/database/sqlite/SQLiteException
    //   412	422	559	finally
    //   426	435	461	android/database/sqlite/SQLiteException
    //   426	435	559	finally
    //   526	545	559	finally
  }
  
  @WorkerThread
  public final void zza(zzaf paramzzaf) {
    Long long_;
    Preconditions.checkNotNull(paramzzaf);
    zzq();
    zzah();
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramzzaf.zzcf);
    contentValues.put("name", paramzzaf.name);
    contentValues.put("lifetime_count", Long.valueOf(paramzzaf.zzfe));
    contentValues.put("current_bundle_count", Long.valueOf(paramzzaf.zzff));
    contentValues.put("last_fire_timestamp", Long.valueOf(paramzzaf.zzfg));
    contentValues.put("last_bundled_timestamp", Long.valueOf(paramzzaf.zzfh));
    contentValues.put("last_bundled_day", paramzzaf.zzfi);
    contentValues.put("last_sampled_complex_event_id", paramzzaf.zzfj);
    contentValues.put("last_sampling_rate", paramzzaf.zzfk);
    if (paramzzaf.zzfl != null && paramzzaf.zzfl.booleanValue()) {
      long_ = Long.valueOf(1L);
    } else {
      long_ = null;
    } 
    contentValues.put("last_exempt_from_sampling", long_);
    try {
      if (getWritableDatabase().insertWithOnConflict("events", null, contentValues, 5) == -1L)
        zzad().zzda().zza("Failed to insert/update event aggregates (got -1). appId", zzau.zzao(paramzzaf.zzcf)); 
      return;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing event aggregates. appId", zzau.zzao(paramzzaf.zzcf), sQLiteException);
      return;
    } 
  }
  
  @WorkerThread
  public final void zza(zzg paramzzg) {
    Preconditions.checkNotNull(paramzzg);
    zzq();
    zzah();
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramzzg.zzan());
    contentValues.put("app_instance_id", paramzzg.getAppInstanceId());
    contentValues.put("gmp_app_id", paramzzg.getGmpAppId());
    contentValues.put("resettable_device_id_hash", paramzzg.zzap());
    contentValues.put("last_bundle_index", Long.valueOf(paramzzg.zzay()));
    contentValues.put("last_bundle_start_timestamp", Long.valueOf(paramzzg.zzaq()));
    contentValues.put("last_bundle_end_timestamp", Long.valueOf(paramzzg.zzar()));
    contentValues.put("app_version", paramzzg.zzas());
    contentValues.put("app_store", paramzzg.zzau());
    contentValues.put("gmp_version", Long.valueOf(paramzzg.zzav()));
    contentValues.put("dev_cert_hash", Long.valueOf(paramzzg.zzaw()));
    contentValues.put("measurement_enabled", Boolean.valueOf(paramzzg.isMeasurementEnabled()));
    contentValues.put("day", Long.valueOf(paramzzg.zzbc()));
    contentValues.put("daily_public_events_count", Long.valueOf(paramzzg.zzbd()));
    contentValues.put("daily_events_count", Long.valueOf(paramzzg.zzbe()));
    contentValues.put("daily_conversions_count", Long.valueOf(paramzzg.zzbf()));
    contentValues.put("config_fetched_time", Long.valueOf(paramzzg.zzaz()));
    contentValues.put("failed_config_fetch_time", Long.valueOf(paramzzg.zzba()));
    contentValues.put("app_version_int", Long.valueOf(paramzzg.zzat()));
    contentValues.put("firebase_instance_id", paramzzg.getFirebaseInstanceId());
    contentValues.put("daily_error_events_count", Long.valueOf(paramzzg.zzbh()));
    contentValues.put("daily_realtime_events_count", Long.valueOf(paramzzg.zzbg()));
    contentValues.put("health_monitor_sample", paramzzg.zzbi());
    contentValues.put("android_id", Long.valueOf(paramzzg.zzbk()));
    contentValues.put("adid_reporting_enabled", Boolean.valueOf(paramzzg.zzbl()));
    contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(paramzzg.zzbm()));
    contentValues.put("admob_app_id", paramzzg.zzao());
    contentValues.put("dynamite_version", Long.valueOf(paramzzg.zzax()));
    try {
      SQLiteDatabase sQLiteDatabase = getWritableDatabase();
      if (sQLiteDatabase.update("apps", contentValues, "app_id = ?", new String[] { paramzzg.zzan() }) == 0L && sQLiteDatabase.insertWithOnConflict("apps", null, contentValues, 5) == -1L)
        zzad().zzda().zza("Failed to insert/update app (got -1). appId", zzau.zzao(paramzzg.zzan())); 
      return;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing app. appId", zzau.zzao(paramzzg.zzan()), sQLiteException);
      return;
    } 
  }
  
  @WorkerThread
  final void zza(String paramString, zzbx[] paramArrayOfzzbx) {
    zzah();
    zzq();
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramArrayOfzzbx);
    SQLiteDatabase sQLiteDatabase = getWritableDatabase();
    sQLiteDatabase.beginTransaction();
    try {
      zzah();
      zzq();
      Preconditions.checkNotEmpty(paramString);
      SQLiteDatabase sQLiteDatabase1 = getWritableDatabase();
      byte b1 = 0;
      sQLiteDatabase1.delete("property_filters", "app_id=?", new String[] { paramString });
      sQLiteDatabase1.delete("event_filters", "app_id=?", new String[] { paramString });
      int i = paramArrayOfzzbx.length;
      int j;
      label61: for (j = 0; j < i; j++) {
        zzbx zzbx1 = paramArrayOfzzbx[j];
        zzah();
        zzq();
        Preconditions.checkNotEmpty(paramString);
        Preconditions.checkNotNull(zzbx1);
        Preconditions.checkNotNull(zzbx1.zzvw);
        Preconditions.checkNotNull(zzbx1.zzvv);
        if (zzbx1.zzvu == null) {
          zzad().zzdd().zza("Audience with no ID. appId", zzau.zzao(paramString));
        } else {
          int k = zzbx1.zzvu.intValue();
          zzby[] arrayOfZzby2 = zzbx1.zzvw;
          int m = arrayOfZzby2.length;
          byte b;
          for (b = 0; b < m; b++) {
            if ((arrayOfZzby2[b]).zzwa == null) {
              zzad().zzdd().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzau.zzao(paramString), zzbx1.zzvu);
              continue label61;
            } 
          } 
          zzcb[] arrayOfZzcb = zzbx1.zzvv;
          m = arrayOfZzcb.length;
          for (b = 0; b < m; b++) {
            if ((arrayOfZzcb[b]).zzwa == null) {
              zzad().zzdd().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzau.zzao(paramString), zzbx1.zzvu);
              continue label61;
            } 
          } 
          zzby[] arrayOfZzby1 = zzbx1.zzvw;
          m = arrayOfZzby1.length;
          b = 0;
          while (true) {
            if (b < m) {
              if (!zza(paramString, k, arrayOfZzby1[b])) {
                b = 0;
                break;
              } 
              b++;
              continue;
            } 
            b = 1;
            break;
          } 
          m = b;
          if (b != 0) {
            zzcb[] arrayOfZzcb1 = zzbx1.zzvv;
            int n = arrayOfZzcb1.length;
            byte b3 = 0;
            while (true) {
              m = b;
              if (b3 < n) {
                if (!zza(paramString, k, arrayOfZzcb1[b3])) {
                  m = 0;
                  break;
                } 
                b3++;
                continue;
              } 
              break;
            } 
          } 
          if (m == 0) {
            zzah();
            zzq();
            Preconditions.checkNotEmpty(paramString);
            SQLiteDatabase sQLiteDatabase2 = getWritableDatabase();
            sQLiteDatabase2.delete("property_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(k) });
            sQLiteDatabase2.delete("event_filters", "app_id=? and audience_id=?", new String[] { paramString, String.valueOf(k) });
          } 
        } 
      } 
      ArrayList<Integer> arrayList = new ArrayList();
      this();
      j = paramArrayOfzzbx.length;
      for (byte b2 = b1; b2 < j; b2++)
        arrayList.add((paramArrayOfzzbx[b2]).zzvu); 
      zza(paramString, arrayList);
      sQLiteDatabase.setTransactionSuccessful();
      return;
    } finally {
      sQLiteDatabase.endTransaction();
    } 
  }
  
  @WorkerThread
  @VisibleForTesting
  final void zza(List<Long> paramList) {
    zzq();
    zzah();
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotZero(paramList.size());
    if (!zzcg())
      return; 
    String str = TextUtils.join(",", paramList);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 2);
    stringBuilder.append("(");
    stringBuilder.append(str);
    stringBuilder.append(")");
    str = stringBuilder.toString();
    stringBuilder = new StringBuilder(String.valueOf(str).length() + 80);
    stringBuilder.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
    stringBuilder.append(str);
    stringBuilder.append(" AND retry_count =  2147483647 LIMIT 1");
    if (zza(stringBuilder.toString(), (String[])null) > 0L)
      zzad().zzdd().zzaq("The number of upload retries exceeds the limit. Will remain unchanged."); 
    try {
      SQLiteDatabase sQLiteDatabase = getWritableDatabase();
      int i = String.valueOf(str).length();
      stringBuilder = new StringBuilder();
      this(i + 127);
      stringBuilder.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
      stringBuilder.append(str);
      stringBuilder.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
      sQLiteDatabase.execSQL(stringBuilder.toString());
      return;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error incrementing retry count. error", sQLiteException);
      return;
    } 
  }
  
  @WorkerThread
  public final boolean zza(zzch paramzzch, boolean paramBoolean) {
    zzq();
    zzah();
    Preconditions.checkNotNull(paramzzch);
    Preconditions.checkNotEmpty(paramzzch.zzcf);
    Preconditions.checkNotNull(paramzzch.zzxs);
    zzca();
    long l = zzz().currentTimeMillis();
    if (paramzzch.zzxs.longValue() < l - zzt.zzbs() || paramzzch.zzxs.longValue() > zzt.zzbs() + l)
      zzad().zzdd().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzau.zzao(paramzzch.zzcf), Long.valueOf(l), paramzzch.zzxs); 
    byte[] arrayOfByte = zziv.zzb((zziv)paramzzch);
    try {
      arrayOfByte = zzdm().zzc(arrayOfByte);
      zzad().zzdi().zza("Saving bundle, size", Integer.valueOf(arrayOfByte.length));
      ContentValues contentValues = new ContentValues();
      contentValues.put("app_id", paramzzch.zzcf);
      contentValues.put("bundle_end_timestamp", paramzzch.zzxs);
      contentValues.put("data", arrayOfByte);
      contentValues.put("has_realtime", Integer.valueOf(paramBoolean));
      if (paramzzch.zzyp != null)
        contentValues.put("retry_count", paramzzch.zzyp); 
      try {
        if (getWritableDatabase().insert("queue", null, contentValues) == -1L) {
          zzad().zzda().zza("Failed to insert bundle (got -1). appId", zzau.zzao(paramzzch.zzcf));
          return false;
        } 
        return true;
      } catch (SQLiteException sQLiteException) {
        zzad().zzda().zza("Error storing bundle. appId", zzau.zzao(paramzzch.zzcf), sQLiteException);
        return false;
      } 
    } catch (IOException iOException) {
      zzad().zzda().zza("Data loss. Failed to serialize bundle. appId", zzau.zzao(paramzzch.zzcf), iOException);
      return false;
    } 
  }
  
  public final boolean zza(zzae paramzzae, long paramLong, boolean paramBoolean) {
    zzq();
    zzah();
    Preconditions.checkNotNull(paramzzae);
    Preconditions.checkNotEmpty(paramzzae.zzcf);
    zzcf zzcf = new zzcf();
    zzcf.zzxk = Long.valueOf(paramzzae.zzfc);
    zzcf.zzxi = new zzbt.zzd[paramzzae.zzfd.size()];
    Iterator<String> iterator = paramzzae.zzfd.iterator();
    for (byte b = 0; iterator.hasNext(); b++) {
      String str = iterator.next();
      zzbt.zzd.zza zza = zzbt.zzd.zzht().zzbw(str);
      Object object = paramzzae.zzfd.get(str);
      zzdm().zza(zza, object);
      zzcf.zzxi[b] = (zzbt.zzd)zza.zzmr();
    } 
    byte[] arrayOfByte = zziv.zzb((zziv)zzcf);
    zzad().zzdi().zza("Saving event, name, data size", zzaa().zzal(paramzzae.name), Integer.valueOf(arrayOfByte.length));
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramzzae.zzcf);
    contentValues.put("name", paramzzae.name);
    contentValues.put("timestamp", Long.valueOf(paramzzae.timestamp));
    contentValues.put("metadata_fingerprint", Long.valueOf(paramLong));
    contentValues.put("data", arrayOfByte);
    contentValues.put("realtime", Integer.valueOf(paramBoolean));
    try {
      if (getWritableDatabase().insert("raw_events", null, contentValues) == -1L) {
        zzad().zzda().zza("Failed to insert raw event (got -1). appId", zzau.zzao(paramzzae.zzcf));
        return false;
      } 
      return true;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing raw event. appId", zzau.zzao(paramzzae.zzcf), sQLiteException);
      return false;
    } 
  }
  
  @WorkerThread
  public final boolean zza(zzgc paramzzgc) {
    Preconditions.checkNotNull(paramzzgc);
    zzq();
    zzah();
    if (zze(paramzzgc.zzcf, paramzzgc.name) == null)
      if (zzgd.zzbm(paramzzgc.name)) {
        if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[] { paramzzgc.zzcf }) >= 25L)
          return false; 
      } else if (zzaf().zze(paramzzgc.zzcf, zzal.zzin)) {
        if (!"_npa".equals(paramzzgc.name) && zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { paramzzgc.zzcf, paramzzgc.origin }) >= 25L)
          return false; 
      } else if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[] { paramzzgc.zzcf, paramzzgc.origin }) >= 25L) {
        return false;
      }  
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramzzgc.zzcf);
    contentValues.put("origin", paramzzgc.origin);
    contentValues.put("name", paramzzgc.name);
    contentValues.put("set_timestamp", Long.valueOf(paramzzgc.zzsx));
    zza(contentValues, "value", paramzzgc.value);
    try {
      if (getWritableDatabase().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1L)
        zzad().zzda().zza("Failed to insert/update user property (got -1). appId", zzau.zzao(paramzzgc.zzcf)); 
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing user property. appId", zzau.zzao(paramzzgc.zzcf), sQLiteException);
    } 
    return true;
  }
  
  @WorkerThread
  public final boolean zza(zzr paramzzr) {
    Preconditions.checkNotNull(paramzzr);
    zzq();
    zzah();
    if (zze(paramzzr.packageName, paramzzr.zzdv.name) == null && zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[] { paramzzr.packageName }) >= 1000L)
      return false; 
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramzzr.packageName);
    contentValues.put("origin", paramzzr.origin);
    contentValues.put("name", paramzzr.zzdv.name);
    zza(contentValues, "value", paramzzr.zzdv.getValue());
    contentValues.put("active", Boolean.valueOf(paramzzr.active));
    contentValues.put("trigger_event_name", paramzzr.triggerEventName);
    contentValues.put("trigger_timeout", Long.valueOf(paramzzr.triggerTimeout));
    zzab();
    contentValues.put("timed_out_event", zzgd.zza((Parcelable)paramzzr.zzdw));
    contentValues.put("creation_timestamp", Long.valueOf(paramzzr.creationTimestamp));
    zzab();
    contentValues.put("triggered_event", zzgd.zza((Parcelable)paramzzr.zzdx));
    contentValues.put("triggered_timestamp", Long.valueOf(paramzzr.zzdv.zzsx));
    contentValues.put("time_to_live", Long.valueOf(paramzzr.timeToLive));
    zzab();
    contentValues.put("expired_event", zzgd.zza((Parcelable)paramzzr.zzdy));
    try {
      if (getWritableDatabase().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1L)
        zzad().zzda().zza("Failed to insert/update conditional user property (got -1)", zzau.zzao(paramzzr.packageName)); 
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing conditional user property", zzau.zzao(paramzzr.packageName), sQLiteException);
    } 
    return true;
  }
  
  public final boolean zza(String paramString, Long paramLong, long paramLong1, zzcf paramzzcf) {
    zzq();
    zzah();
    Preconditions.checkNotNull(paramzzcf);
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramLong);
    byte[] arrayOfByte = zziv.zzb((zziv)paramzzcf);
    zzad().zzdi().zza("Saving complex main event, appId, data size", zzaa().zzal(paramString), Integer.valueOf(arrayOfByte.length));
    ContentValues contentValues = new ContentValues();
    contentValues.put("app_id", paramString);
    contentValues.put("event_id", paramLong);
    contentValues.put("children_to_process", Long.valueOf(paramLong1));
    contentValues.put("main_event", arrayOfByte);
    try {
      if (getWritableDatabase().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1L) {
        zzad().zzda().zza("Failed to insert complex main event (got -1). appId", zzau.zzao(paramString));
        return false;
      } 
      return true;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error storing complex main event. appId", zzau.zzao(paramString), sQLiteException);
      return false;
    } 
  }
  
  @WorkerThread
  public final List<zzgc> zzad(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual zzq : ()V
    //   9: aload_0
    //   10: invokevirtual zzah : ()V
    //   13: new java/util/ArrayList
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore_2
    //   21: aload_0
    //   22: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc_w 'user_attributes'
    //   28: iconst_4
    //   29: anewarray java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc_w 'name'
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 'origin'
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc_w 'set_timestamp'
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: ldc_w 'value'
    //   54: aastore
    //   55: ldc_w 'app_id=?'
    //   58: iconst_1
    //   59: anewarray java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: aload_1
    //   65: aastore
    //   66: aconst_null
    //   67: aconst_null
    //   68: ldc_w 'rowid'
    //   71: ldc_w '1000'
    //   74: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   77: astore_3
    //   78: aload_3
    //   79: invokeinterface moveToFirst : ()Z
    //   84: istore #4
    //   86: iload #4
    //   88: ifne -> 103
    //   91: aload_3
    //   92: ifnull -> 101
    //   95: aload_3
    //   96: invokeinterface close : ()V
    //   101: aload_2
    //   102: areturn
    //   103: aload_3
    //   104: iconst_0
    //   105: invokeinterface getString : (I)Ljava/lang/String;
    //   110: astore #5
    //   112: aload_3
    //   113: iconst_1
    //   114: invokeinterface getString : (I)Ljava/lang/String;
    //   119: astore #6
    //   121: aload #6
    //   123: ifnonnull -> 134
    //   126: ldc_w ''
    //   129: astore #6
    //   131: goto -> 134
    //   134: aload_3
    //   135: iconst_2
    //   136: invokeinterface getLong : (I)J
    //   141: lstore #7
    //   143: aload_3
    //   144: astore #9
    //   146: aload_0
    //   147: aload_3
    //   148: iconst_3
    //   149: invokespecial zza : (Landroid/database/Cursor;I)Ljava/lang/Object;
    //   152: astore #10
    //   154: aload #10
    //   156: ifnonnull -> 182
    //   159: aload_3
    //   160: astore #9
    //   162: aload_0
    //   163: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   166: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   169: ldc_w 'Read invalid user property value, ignoring it. appId'
    //   172: aload_1
    //   173: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   176: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   179: goto -> 219
    //   182: aload_3
    //   183: astore #9
    //   185: new com/google/android/gms/measurement/internal/zzgc
    //   188: astore #11
    //   190: aload_3
    //   191: astore #9
    //   193: aload #11
    //   195: aload_1
    //   196: aload #6
    //   198: aload #5
    //   200: lload #7
    //   202: aload #10
    //   204: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   207: aload_3
    //   208: astore #9
    //   210: aload_2
    //   211: aload #11
    //   213: invokeinterface add : (Ljava/lang/Object;)Z
    //   218: pop
    //   219: aload_3
    //   220: astore #9
    //   222: aload_3
    //   223: invokeinterface moveToNext : ()Z
    //   228: istore #4
    //   230: iload #4
    //   232: ifne -> 103
    //   235: aload_3
    //   236: ifnull -> 245
    //   239: aload_3
    //   240: invokeinterface close : ()V
    //   245: aload_2
    //   246: areturn
    //   247: astore #6
    //   249: goto -> 271
    //   252: astore_1
    //   253: goto -> 309
    //   256: astore #6
    //   258: goto -> 271
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_3
    //   264: goto -> 309
    //   267: astore #6
    //   269: aconst_null
    //   270: astore_3
    //   271: aload_3
    //   272: astore #9
    //   274: aload_0
    //   275: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   278: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   281: ldc_w 'Error querying user properties. appId'
    //   284: aload_1
    //   285: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   288: aload #6
    //   290: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   293: aload_3
    //   294: ifnull -> 303
    //   297: aload_3
    //   298: invokeinterface close : ()V
    //   303: aconst_null
    //   304: areturn
    //   305: astore_1
    //   306: aload #9
    //   308: astore_3
    //   309: aload_3
    //   310: ifnull -> 319
    //   313: aload_3
    //   314: invokeinterface close : ()V
    //   319: aload_1
    //   320: athrow
    // Exception table:
    //   from	to	target	type
    //   21	78	267	android/database/sqlite/SQLiteException
    //   21	78	261	finally
    //   78	86	256	android/database/sqlite/SQLiteException
    //   78	86	252	finally
    //   103	121	256	android/database/sqlite/SQLiteException
    //   103	121	252	finally
    //   134	143	256	android/database/sqlite/SQLiteException
    //   134	143	252	finally
    //   146	154	247	android/database/sqlite/SQLiteException
    //   146	154	305	finally
    //   162	179	247	android/database/sqlite/SQLiteException
    //   162	179	305	finally
    //   185	190	247	android/database/sqlite/SQLiteException
    //   185	190	305	finally
    //   193	207	247	android/database/sqlite/SQLiteException
    //   193	207	305	finally
    //   210	219	247	android/database/sqlite/SQLiteException
    //   210	219	305	finally
    //   222	230	247	android/database/sqlite/SQLiteException
    //   222	230	305	finally
    //   274	293	305	finally
  }
  
  @WorkerThread
  public final zzg zzae(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual zzq : ()V
    //   9: aload_0
    //   10: invokevirtual zzah : ()V
    //   13: aload_0
    //   14: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_2
    //   18: iconst_0
    //   19: istore_3
    //   20: aload_2
    //   21: ldc_w 'apps'
    //   24: bipush #27
    //   26: anewarray java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 'app_instance_id'
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc_w 'gmp_app_id'
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc_w 'resettable_device_id_hash'
    //   46: aastore
    //   47: dup
    //   48: iconst_3
    //   49: ldc_w 'last_bundle_index'
    //   52: aastore
    //   53: dup
    //   54: iconst_4
    //   55: ldc 'last_bundle_start_timestamp'
    //   57: aastore
    //   58: dup
    //   59: iconst_5
    //   60: ldc_w 'last_bundle_end_timestamp'
    //   63: aastore
    //   64: dup
    //   65: bipush #6
    //   67: ldc 'app_version'
    //   69: aastore
    //   70: dup
    //   71: bipush #7
    //   73: ldc 'app_store'
    //   75: aastore
    //   76: dup
    //   77: bipush #8
    //   79: ldc 'gmp_version'
    //   81: aastore
    //   82: dup
    //   83: bipush #9
    //   85: ldc 'dev_cert_hash'
    //   87: aastore
    //   88: dup
    //   89: bipush #10
    //   91: ldc 'measurement_enabled'
    //   93: aastore
    //   94: dup
    //   95: bipush #11
    //   97: ldc 'day'
    //   99: aastore
    //   100: dup
    //   101: bipush #12
    //   103: ldc 'daily_public_events_count'
    //   105: aastore
    //   106: dup
    //   107: bipush #13
    //   109: ldc 'daily_events_count'
    //   111: aastore
    //   112: dup
    //   113: bipush #14
    //   115: ldc 'daily_conversions_count'
    //   117: aastore
    //   118: dup
    //   119: bipush #15
    //   121: ldc 'config_fetched_time'
    //   123: aastore
    //   124: dup
    //   125: bipush #16
    //   127: ldc 'failed_config_fetch_time'
    //   129: aastore
    //   130: dup
    //   131: bipush #17
    //   133: ldc 'app_version_int'
    //   135: aastore
    //   136: dup
    //   137: bipush #18
    //   139: ldc 'firebase_instance_id'
    //   141: aastore
    //   142: dup
    //   143: bipush #19
    //   145: ldc 'daily_error_events_count'
    //   147: aastore
    //   148: dup
    //   149: bipush #20
    //   151: ldc 'daily_realtime_events_count'
    //   153: aastore
    //   154: dup
    //   155: bipush #21
    //   157: ldc 'health_monitor_sample'
    //   159: aastore
    //   160: dup
    //   161: bipush #22
    //   163: ldc 'android_id'
    //   165: aastore
    //   166: dup
    //   167: bipush #23
    //   169: ldc 'adid_reporting_enabled'
    //   171: aastore
    //   172: dup
    //   173: bipush #24
    //   175: ldc 'ssaid_reporting_enabled'
    //   177: aastore
    //   178: dup
    //   179: bipush #25
    //   181: ldc 'admob_app_id'
    //   183: aastore
    //   184: dup
    //   185: bipush #26
    //   187: ldc 'dynamite_version'
    //   189: aastore
    //   190: ldc_w 'app_id=?'
    //   193: iconst_1
    //   194: anewarray java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: aload_1
    //   200: aastore
    //   201: aconst_null
    //   202: aconst_null
    //   203: aconst_null
    //   204: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   207: astore_2
    //   208: aload_2
    //   209: invokeinterface moveToFirst : ()Z
    //   214: istore #4
    //   216: iload #4
    //   218: ifne -> 233
    //   221: aload_2
    //   222: ifnull -> 231
    //   225: aload_2
    //   226: invokeinterface close : ()V
    //   231: aconst_null
    //   232: areturn
    //   233: new com/google/android/gms/measurement/internal/zzg
    //   236: astore #5
    //   238: aload_2
    //   239: astore #6
    //   241: aload #5
    //   243: aload_0
    //   244: getfield zzkt : Lcom/google/android/gms/measurement/internal/zzft;
    //   247: invokevirtual zzgi : ()Lcom/google/android/gms/measurement/internal/zzby;
    //   250: aload_1
    //   251: invokespecial <init> : (Lcom/google/android/gms/measurement/internal/zzby;Ljava/lang/String;)V
    //   254: aload_2
    //   255: astore #6
    //   257: aload #5
    //   259: aload_2
    //   260: iconst_0
    //   261: invokeinterface getString : (I)Ljava/lang/String;
    //   266: invokevirtual zza : (Ljava/lang/String;)V
    //   269: aload_2
    //   270: astore #6
    //   272: aload #5
    //   274: aload_2
    //   275: iconst_1
    //   276: invokeinterface getString : (I)Ljava/lang/String;
    //   281: invokevirtual zzb : (Ljava/lang/String;)V
    //   284: aload_2
    //   285: astore #6
    //   287: aload #5
    //   289: aload_2
    //   290: iconst_2
    //   291: invokeinterface getString : (I)Ljava/lang/String;
    //   296: invokevirtual zzd : (Ljava/lang/String;)V
    //   299: aload_2
    //   300: astore #6
    //   302: aload #5
    //   304: aload_2
    //   305: iconst_3
    //   306: invokeinterface getLong : (I)J
    //   311: invokevirtual zzk : (J)V
    //   314: aload_2
    //   315: astore #6
    //   317: aload #5
    //   319: aload_2
    //   320: iconst_4
    //   321: invokeinterface getLong : (I)J
    //   326: invokevirtual zze : (J)V
    //   329: aload_2
    //   330: astore #6
    //   332: aload #5
    //   334: aload_2
    //   335: iconst_5
    //   336: invokeinterface getLong : (I)J
    //   341: invokevirtual zzf : (J)V
    //   344: aload_2
    //   345: astore #6
    //   347: aload #5
    //   349: aload_2
    //   350: bipush #6
    //   352: invokeinterface getString : (I)Ljava/lang/String;
    //   357: invokevirtual zzf : (Ljava/lang/String;)V
    //   360: aload_2
    //   361: astore #6
    //   363: aload #5
    //   365: aload_2
    //   366: bipush #7
    //   368: invokeinterface getString : (I)Ljava/lang/String;
    //   373: invokevirtual zzg : (Ljava/lang/String;)V
    //   376: aload_2
    //   377: astore #6
    //   379: aload #5
    //   381: aload_2
    //   382: bipush #8
    //   384: invokeinterface getLong : (I)J
    //   389: invokevirtual zzh : (J)V
    //   392: aload_2
    //   393: astore #6
    //   395: aload #5
    //   397: aload_2
    //   398: bipush #9
    //   400: invokeinterface getLong : (I)J
    //   405: invokevirtual zzi : (J)V
    //   408: aload_2
    //   409: astore #6
    //   411: aload_2
    //   412: bipush #10
    //   414: invokeinterface isNull : (I)Z
    //   419: ifne -> 445
    //   422: aload_2
    //   423: astore #6
    //   425: aload_2
    //   426: bipush #10
    //   428: invokeinterface getInt : (I)I
    //   433: ifeq -> 439
    //   436: goto -> 445
    //   439: iconst_0
    //   440: istore #4
    //   442: goto -> 448
    //   445: iconst_1
    //   446: istore #4
    //   448: aload_2
    //   449: astore #6
    //   451: aload #5
    //   453: iload #4
    //   455: invokevirtual setMeasurementEnabled : (Z)V
    //   458: aload_2
    //   459: astore #6
    //   461: aload #5
    //   463: aload_2
    //   464: bipush #11
    //   466: invokeinterface getLong : (I)J
    //   471: invokevirtual zzn : (J)V
    //   474: aload_2
    //   475: astore #6
    //   477: aload #5
    //   479: aload_2
    //   480: bipush #12
    //   482: invokeinterface getLong : (I)J
    //   487: invokevirtual zzo : (J)V
    //   490: aload_2
    //   491: astore #6
    //   493: aload #5
    //   495: aload_2
    //   496: bipush #13
    //   498: invokeinterface getLong : (I)J
    //   503: invokevirtual zzp : (J)V
    //   506: aload_2
    //   507: astore #6
    //   509: aload #5
    //   511: aload_2
    //   512: bipush #14
    //   514: invokeinterface getLong : (I)J
    //   519: invokevirtual zzq : (J)V
    //   522: aload_2
    //   523: astore #6
    //   525: aload #5
    //   527: aload_2
    //   528: bipush #15
    //   530: invokeinterface getLong : (I)J
    //   535: invokevirtual zzl : (J)V
    //   538: aload_2
    //   539: astore #6
    //   541: aload #5
    //   543: aload_2
    //   544: bipush #16
    //   546: invokeinterface getLong : (I)J
    //   551: invokevirtual zzm : (J)V
    //   554: aload_2
    //   555: astore #6
    //   557: aload_2
    //   558: bipush #17
    //   560: invokeinterface isNull : (I)Z
    //   565: ifeq -> 576
    //   568: ldc2_w -2147483648
    //   571: lstore #7
    //   573: goto -> 590
    //   576: aload_2
    //   577: astore #6
    //   579: aload_2
    //   580: bipush #17
    //   582: invokeinterface getInt : (I)I
    //   587: i2l
    //   588: lstore #7
    //   590: aload_2
    //   591: astore #6
    //   593: aload #5
    //   595: lload #7
    //   597: invokevirtual zzg : (J)V
    //   600: aload_2
    //   601: astore #6
    //   603: aload #5
    //   605: aload_2
    //   606: bipush #18
    //   608: invokeinterface getString : (I)Ljava/lang/String;
    //   613: invokevirtual zze : (Ljava/lang/String;)V
    //   616: aload_2
    //   617: astore #6
    //   619: aload #5
    //   621: aload_2
    //   622: bipush #19
    //   624: invokeinterface getLong : (I)J
    //   629: invokevirtual zzs : (J)V
    //   632: aload_2
    //   633: astore #6
    //   635: aload #5
    //   637: aload_2
    //   638: bipush #20
    //   640: invokeinterface getLong : (I)J
    //   645: invokevirtual zzr : (J)V
    //   648: aload_2
    //   649: astore #6
    //   651: aload #5
    //   653: aload_2
    //   654: bipush #21
    //   656: invokeinterface getString : (I)Ljava/lang/String;
    //   661: invokevirtual zzh : (Ljava/lang/String;)V
    //   664: aload_2
    //   665: astore #6
    //   667: aload_2
    //   668: bipush #22
    //   670: invokeinterface isNull : (I)Z
    //   675: ifeq -> 684
    //   678: lconst_0
    //   679: lstore #7
    //   681: goto -> 697
    //   684: aload_2
    //   685: astore #6
    //   687: aload_2
    //   688: bipush #22
    //   690: invokeinterface getLong : (I)J
    //   695: lstore #7
    //   697: aload_2
    //   698: astore #6
    //   700: aload #5
    //   702: lload #7
    //   704: invokevirtual zzt : (J)V
    //   707: aload_2
    //   708: astore #6
    //   710: aload_2
    //   711: bipush #23
    //   713: invokeinterface isNull : (I)Z
    //   718: ifne -> 744
    //   721: aload_2
    //   722: astore #6
    //   724: aload_2
    //   725: bipush #23
    //   727: invokeinterface getInt : (I)I
    //   732: ifeq -> 738
    //   735: goto -> 744
    //   738: iconst_0
    //   739: istore #4
    //   741: goto -> 747
    //   744: iconst_1
    //   745: istore #4
    //   747: aload_2
    //   748: astore #6
    //   750: aload #5
    //   752: iload #4
    //   754: invokevirtual zzb : (Z)V
    //   757: aload_2
    //   758: astore #6
    //   760: aload_2
    //   761: bipush #24
    //   763: invokeinterface isNull : (I)Z
    //   768: ifne -> 788
    //   771: iload_3
    //   772: istore #4
    //   774: aload_2
    //   775: astore #6
    //   777: aload_2
    //   778: bipush #24
    //   780: invokeinterface getInt : (I)I
    //   785: ifeq -> 791
    //   788: iconst_1
    //   789: istore #4
    //   791: aload_2
    //   792: astore #6
    //   794: aload #5
    //   796: iload #4
    //   798: invokevirtual zzc : (Z)V
    //   801: aload_2
    //   802: astore #6
    //   804: aload #5
    //   806: aload_2
    //   807: bipush #25
    //   809: invokeinterface getString : (I)Ljava/lang/String;
    //   814: invokevirtual zzc : (Ljava/lang/String;)V
    //   817: aload_2
    //   818: astore #6
    //   820: aload_2
    //   821: bipush #26
    //   823: invokeinterface isNull : (I)Z
    //   828: ifeq -> 837
    //   831: lconst_0
    //   832: lstore #7
    //   834: goto -> 850
    //   837: aload_2
    //   838: astore #6
    //   840: aload_2
    //   841: bipush #26
    //   843: invokeinterface getLong : (I)J
    //   848: lstore #7
    //   850: aload_2
    //   851: astore #6
    //   853: aload #5
    //   855: lload #7
    //   857: invokevirtual zzj : (J)V
    //   860: aload_2
    //   861: astore #6
    //   863: aload #5
    //   865: invokevirtual zzam : ()V
    //   868: aload_2
    //   869: astore #6
    //   871: aload_2
    //   872: invokeinterface moveToNext : ()Z
    //   877: ifeq -> 900
    //   880: aload_2
    //   881: astore #6
    //   883: aload_0
    //   884: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   887: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   890: ldc_w 'Got multiple records for app, expected one. appId'
    //   893: aload_1
    //   894: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   897: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   900: aload_2
    //   901: ifnull -> 910
    //   904: aload_2
    //   905: invokeinterface close : ()V
    //   910: aload #5
    //   912: areturn
    //   913: astore #5
    //   915: goto -> 937
    //   918: astore_1
    //   919: goto -> 975
    //   922: astore #5
    //   924: goto -> 937
    //   927: astore_1
    //   928: aconst_null
    //   929: astore_2
    //   930: goto -> 975
    //   933: astore #5
    //   935: aconst_null
    //   936: astore_2
    //   937: aload_2
    //   938: astore #6
    //   940: aload_0
    //   941: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   944: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   947: ldc_w 'Error querying app. appId'
    //   950: aload_1
    //   951: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   954: aload #5
    //   956: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   959: aload_2
    //   960: ifnull -> 969
    //   963: aload_2
    //   964: invokeinterface close : ()V
    //   969: aconst_null
    //   970: areturn
    //   971: astore_1
    //   972: aload #6
    //   974: astore_2
    //   975: aload_2
    //   976: ifnull -> 985
    //   979: aload_2
    //   980: invokeinterface close : ()V
    //   985: aload_1
    //   986: athrow
    // Exception table:
    //   from	to	target	type
    //   13	18	933	android/database/sqlite/SQLiteException
    //   13	18	927	finally
    //   20	208	933	android/database/sqlite/SQLiteException
    //   20	208	927	finally
    //   208	216	922	android/database/sqlite/SQLiteException
    //   208	216	918	finally
    //   233	238	922	android/database/sqlite/SQLiteException
    //   233	238	918	finally
    //   241	254	913	android/database/sqlite/SQLiteException
    //   241	254	971	finally
    //   257	269	913	android/database/sqlite/SQLiteException
    //   257	269	971	finally
    //   272	284	913	android/database/sqlite/SQLiteException
    //   272	284	971	finally
    //   287	299	913	android/database/sqlite/SQLiteException
    //   287	299	971	finally
    //   302	314	913	android/database/sqlite/SQLiteException
    //   302	314	971	finally
    //   317	329	913	android/database/sqlite/SQLiteException
    //   317	329	971	finally
    //   332	344	913	android/database/sqlite/SQLiteException
    //   332	344	971	finally
    //   347	360	913	android/database/sqlite/SQLiteException
    //   347	360	971	finally
    //   363	376	913	android/database/sqlite/SQLiteException
    //   363	376	971	finally
    //   379	392	913	android/database/sqlite/SQLiteException
    //   379	392	971	finally
    //   395	408	913	android/database/sqlite/SQLiteException
    //   395	408	971	finally
    //   411	422	913	android/database/sqlite/SQLiteException
    //   411	422	971	finally
    //   425	436	913	android/database/sqlite/SQLiteException
    //   425	436	971	finally
    //   451	458	913	android/database/sqlite/SQLiteException
    //   451	458	971	finally
    //   461	474	913	android/database/sqlite/SQLiteException
    //   461	474	971	finally
    //   477	490	913	android/database/sqlite/SQLiteException
    //   477	490	971	finally
    //   493	506	913	android/database/sqlite/SQLiteException
    //   493	506	971	finally
    //   509	522	913	android/database/sqlite/SQLiteException
    //   509	522	971	finally
    //   525	538	913	android/database/sqlite/SQLiteException
    //   525	538	971	finally
    //   541	554	913	android/database/sqlite/SQLiteException
    //   541	554	971	finally
    //   557	568	913	android/database/sqlite/SQLiteException
    //   557	568	971	finally
    //   579	590	913	android/database/sqlite/SQLiteException
    //   579	590	971	finally
    //   593	600	913	android/database/sqlite/SQLiteException
    //   593	600	971	finally
    //   603	616	913	android/database/sqlite/SQLiteException
    //   603	616	971	finally
    //   619	632	913	android/database/sqlite/SQLiteException
    //   619	632	971	finally
    //   635	648	913	android/database/sqlite/SQLiteException
    //   635	648	971	finally
    //   651	664	913	android/database/sqlite/SQLiteException
    //   651	664	971	finally
    //   667	678	913	android/database/sqlite/SQLiteException
    //   667	678	971	finally
    //   687	697	913	android/database/sqlite/SQLiteException
    //   687	697	971	finally
    //   700	707	913	android/database/sqlite/SQLiteException
    //   700	707	971	finally
    //   710	721	913	android/database/sqlite/SQLiteException
    //   710	721	971	finally
    //   724	735	913	android/database/sqlite/SQLiteException
    //   724	735	971	finally
    //   750	757	913	android/database/sqlite/SQLiteException
    //   750	757	971	finally
    //   760	771	913	android/database/sqlite/SQLiteException
    //   760	771	971	finally
    //   777	788	913	android/database/sqlite/SQLiteException
    //   777	788	971	finally
    //   794	801	913	android/database/sqlite/SQLiteException
    //   794	801	971	finally
    //   804	817	913	android/database/sqlite/SQLiteException
    //   804	817	971	finally
    //   820	831	913	android/database/sqlite/SQLiteException
    //   820	831	971	finally
    //   840	850	913	android/database/sqlite/SQLiteException
    //   840	850	971	finally
    //   853	860	913	android/database/sqlite/SQLiteException
    //   853	860	971	finally
    //   863	868	913	android/database/sqlite/SQLiteException
    //   863	868	971	finally
    //   871	880	913	android/database/sqlite/SQLiteException
    //   871	880	971	finally
    //   883	900	913	android/database/sqlite/SQLiteException
    //   883	900	971	finally
    //   940	959	971	finally
  }
  
  public final long zzaf(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    zzq();
    zzah();
    try {
      int i = getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[] { paramString, String.valueOf(Math.max(0, Math.min(1000000, zzaf().zzb(paramString, zzal.zzgs)))) });
      return i;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error deleting over the limit events. appId", zzau.zzao(paramString), sQLiteException);
      return 0L;
    } 
  }
  
  @WorkerThread
  public final byte[] zzag(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual zzq : ()V
    //   9: aload_0
    //   10: invokevirtual zzah : ()V
    //   13: aload_0
    //   14: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   17: ldc_w 'apps'
    //   20: iconst_1
    //   21: anewarray java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 'remote_config'
    //   28: aastore
    //   29: ldc_w 'app_id=?'
    //   32: iconst_1
    //   33: anewarray java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   46: astore_2
    //   47: aload_2
    //   48: astore_3
    //   49: aload_2
    //   50: invokeinterface moveToFirst : ()Z
    //   55: istore #4
    //   57: iload #4
    //   59: ifne -> 74
    //   62: aload_2
    //   63: ifnull -> 72
    //   66: aload_2
    //   67: invokeinterface close : ()V
    //   72: aconst_null
    //   73: areturn
    //   74: aload_2
    //   75: astore_3
    //   76: aload_2
    //   77: iconst_0
    //   78: invokeinterface getBlob : (I)[B
    //   83: astore #5
    //   85: aload_2
    //   86: astore_3
    //   87: aload_2
    //   88: invokeinterface moveToNext : ()Z
    //   93: ifeq -> 115
    //   96: aload_2
    //   97: astore_3
    //   98: aload_0
    //   99: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   102: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   105: ldc_w 'Got multiple records for app config, expected one. appId'
    //   108: aload_1
    //   109: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   112: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   115: aload_2
    //   116: ifnull -> 125
    //   119: aload_2
    //   120: invokeinterface close : ()V
    //   125: aload #5
    //   127: areturn
    //   128: astore #5
    //   130: goto -> 143
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_3
    //   136: goto -> 177
    //   139: astore #5
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: astore_3
    //   145: aload_0
    //   146: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   149: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   152: ldc_w 'Error querying remote config. appId'
    //   155: aload_1
    //   156: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   159: aload #5
    //   161: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   164: aload_2
    //   165: ifnull -> 174
    //   168: aload_2
    //   169: invokeinterface close : ()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_1
    //   177: aload_3
    //   178: ifnull -> 187
    //   181: aload_3
    //   182: invokeinterface close : ()V
    //   187: aload_1
    //   188: athrow
    // Exception table:
    //   from	to	target	type
    //   13	47	139	android/database/sqlite/SQLiteException
    //   13	47	133	finally
    //   49	57	128	android/database/sqlite/SQLiteException
    //   49	57	176	finally
    //   76	85	128	android/database/sqlite/SQLiteException
    //   76	85	176	finally
    //   87	96	128	android/database/sqlite/SQLiteException
    //   87	96	176	finally
    //   98	115	128	android/database/sqlite/SQLiteException
    //   98	115	176	finally
    //   145	164	176	finally
  }
  
  final Map<Integer, zzbt.zzf> zzah(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzah : ()V
    //   4: aload_0
    //   5: invokevirtual zzq : ()V
    //   8: aload_1
    //   9: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_0
    //   14: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_2
    //   18: aload_2
    //   19: ldc_w 'audience_filter_values'
    //   22: iconst_2
    //   23: anewarray java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc_w 'audience_id'
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: ldc_w 'current_results'
    //   37: aastore
    //   38: ldc_w 'app_id=?'
    //   41: iconst_1
    //   42: anewarray java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore_3
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: invokeinterface moveToFirst : ()Z
    //   64: istore #4
    //   66: iload #4
    //   68: ifne -> 83
    //   71: aload_3
    //   72: ifnull -> 81
    //   75: aload_3
    //   76: invokeinterface close : ()V
    //   81: aconst_null
    //   82: areturn
    //   83: aload_3
    //   84: astore_2
    //   85: new android/support/v4/util/ArrayMap
    //   88: astore #5
    //   90: aload_3
    //   91: astore_2
    //   92: aload #5
    //   94: invokespecial <init> : ()V
    //   97: aload_3
    //   98: astore_2
    //   99: aload_3
    //   100: iconst_0
    //   101: invokeinterface getInt : (I)I
    //   106: istore #6
    //   108: aload_3
    //   109: astore_2
    //   110: aload_3
    //   111: iconst_1
    //   112: invokeinterface getBlob : (I)[B
    //   117: astore #7
    //   119: aload_3
    //   120: astore_2
    //   121: aload #7
    //   123: invokestatic zzlt : ()Lcom/google/android/gms/internal/measurement/zzem;
    //   126: invokestatic zza : ([BLcom/google/android/gms/internal/measurement/zzem;)Lcom/google/android/gms/internal/measurement/zzbt$zzf;
    //   129: astore #7
    //   131: aload_3
    //   132: astore_2
    //   133: aload #5
    //   135: iload #6
    //   137: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   140: aload #7
    //   142: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: goto -> 179
    //   151: astore #7
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   159: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   162: ldc_w 'Failed to merge filter results. appId, audienceId, error'
    //   165: aload_1
    //   166: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   169: iload #6
    //   171: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   174: aload #7
    //   176: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   179: aload_3
    //   180: astore_2
    //   181: aload_3
    //   182: invokeinterface moveToNext : ()Z
    //   187: istore #4
    //   189: iload #4
    //   191: ifne -> 97
    //   194: aload_3
    //   195: ifnull -> 204
    //   198: aload_3
    //   199: invokeinterface close : ()V
    //   204: aload #5
    //   206: areturn
    //   207: astore #5
    //   209: goto -> 222
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_2
    //   215: goto -> 256
    //   218: astore #5
    //   220: aconst_null
    //   221: astore_3
    //   222: aload_3
    //   223: astore_2
    //   224: aload_0
    //   225: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   228: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   231: ldc_w 'Database error querying filter results. appId'
    //   234: aload_1
    //   235: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   238: aload #5
    //   240: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   243: aload_3
    //   244: ifnull -> 253
    //   247: aload_3
    //   248: invokeinterface close : ()V
    //   253: aconst_null
    //   254: areturn
    //   255: astore_1
    //   256: aload_2
    //   257: ifnull -> 266
    //   260: aload_2
    //   261: invokeinterface close : ()V
    //   266: aload_1
    //   267: athrow
    // Exception table:
    //   from	to	target	type
    //   18	56	218	android/database/sqlite/SQLiteException
    //   18	56	212	finally
    //   58	66	207	android/database/sqlite/SQLiteException
    //   58	66	255	finally
    //   85	90	207	android/database/sqlite/SQLiteException
    //   85	90	255	finally
    //   92	97	207	android/database/sqlite/SQLiteException
    //   92	97	255	finally
    //   99	108	207	android/database/sqlite/SQLiteException
    //   99	108	255	finally
    //   110	119	207	android/database/sqlite/SQLiteException
    //   110	119	255	finally
    //   121	131	151	java/io/IOException
    //   121	131	207	android/database/sqlite/SQLiteException
    //   121	131	255	finally
    //   133	148	207	android/database/sqlite/SQLiteException
    //   133	148	255	finally
    //   155	179	207	android/database/sqlite/SQLiteException
    //   155	179	255	finally
    //   181	189	207	android/database/sqlite/SQLiteException
    //   181	189	255	finally
    //   224	243	255	finally
  }
  
  public final long zzai(String paramString) {
    Preconditions.checkNotEmpty(paramString);
    return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[] { paramString }, 0L);
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  @WorkerThread
  public final List<zzr> zzb(String paramString1, String paramString2, String paramString3) {
    Preconditions.checkNotEmpty(paramString1);
    zzq();
    zzah();
    ArrayList<String> arrayList = new ArrayList(3);
    arrayList.add(paramString1);
    StringBuilder stringBuilder = new StringBuilder("app_id=?");
    if (!TextUtils.isEmpty(paramString2)) {
      arrayList.add(paramString2);
      stringBuilder.append(" and origin=?");
    } 
    if (!TextUtils.isEmpty(paramString3)) {
      arrayList.add(String.valueOf(paramString3).concat("*"));
      stringBuilder.append(" and name glob ?");
    } 
    String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
    return zzb(stringBuilder.toString(), arrayOfString);
  }
  
  public final List<zzr> zzb(String paramString, String[] paramArrayOfString) {
    ArrayList<zzr> arrayList1;
    String str;
    zzq();
    zzah();
    ArrayList<zzr> arrayList2 = new ArrayList();
    try {
      Cursor cursor = getWritableDatabase().query("conditional_properties", new String[] { 
            "app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", 
            "triggered_timestamp", "time_to_live", "expired_event" }, paramString, paramArrayOfString, null, null, "rowid", "1001");
    } catch (SQLiteException sQLiteException) {
    
    } finally {
      paramString = null;
    } 
    try {
      zzad().zzda().zza("Error querying conditional user property value", paramArrayOfString);
      return (List)list;
    } finally {
      arrayList2 = null;
      str = paramString;
    } 
    if (str != null)
      str.close(); 
    throw arrayList1;
  }
  
  @WorkerThread
  public final String zzby() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore_1
    //   5: aload_1
    //   6: ldc_w 'select app_id from queue order by has_realtime desc, rowid asc limit 1;'
    //   9: aconst_null
    //   10: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_2
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: invokeinterface moveToFirst : ()Z
    //   22: ifeq -> 47
    //   25: aload_2
    //   26: astore_1
    //   27: aload_2
    //   28: iconst_0
    //   29: invokeinterface getString : (I)Ljava/lang/String;
    //   34: astore_3
    //   35: aload_2
    //   36: ifnull -> 45
    //   39: aload_2
    //   40: invokeinterface close : ()V
    //   45: aload_3
    //   46: areturn
    //   47: aload_2
    //   48: ifnull -> 57
    //   51: aload_2
    //   52: invokeinterface close : ()V
    //   57: aconst_null
    //   58: areturn
    //   59: astore_3
    //   60: goto -> 74
    //   63: astore_1
    //   64: aconst_null
    //   65: astore_2
    //   66: aload_1
    //   67: astore_3
    //   68: goto -> 105
    //   71: astore_3
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_1
    //   76: aload_0
    //   77: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   80: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   83: ldc_w 'Database error getting next bundle app id'
    //   86: aload_3
    //   87: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   90: aload_2
    //   91: ifnull -> 100
    //   94: aload_2
    //   95: invokeinterface close : ()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_3
    //   103: aload_1
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull -> 115
    //   109: aload_2
    //   110: invokeinterface close : ()V
    //   115: aload_3
    //   116: athrow
    // Exception table:
    //   from	to	target	type
    //   5	14	71	android/database/sqlite/SQLiteException
    //   5	14	63	finally
    //   16	25	59	android/database/sqlite/SQLiteException
    //   16	25	102	finally
    //   27	35	59	android/database/sqlite/SQLiteException
    //   27	35	102	finally
    //   76	90	102	finally
  }
  
  public final boolean zzbz() {
    return (zza("select count(1) > 0 from queue where has_realtime = 1", (String[])null) != 0L);
  }
  
  @WorkerThread
  public final zzaf zzc(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual zzq : ()V
    //   14: aload_0
    //   15: invokevirtual zzah : ()V
    //   18: aload_0
    //   19: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: iconst_0
    //   24: istore #4
    //   26: aload_3
    //   27: ldc_w 'events'
    //   30: bipush #8
    //   32: anewarray java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc_w 'lifetime_count'
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc_w 'current_bundle_count'
    //   46: aastore
    //   47: dup
    //   48: iconst_2
    //   49: ldc_w 'last_fire_timestamp'
    //   52: aastore
    //   53: dup
    //   54: iconst_3
    //   55: ldc 'last_bundled_timestamp'
    //   57: aastore
    //   58: dup
    //   59: iconst_4
    //   60: ldc 'last_bundled_day'
    //   62: aastore
    //   63: dup
    //   64: iconst_5
    //   65: ldc 'last_sampled_complex_event_id'
    //   67: aastore
    //   68: dup
    //   69: bipush #6
    //   71: ldc 'last_sampling_rate'
    //   73: aastore
    //   74: dup
    //   75: bipush #7
    //   77: ldc 'last_exempt_from_sampling'
    //   79: aastore
    //   80: ldc_w 'app_id=? and name=?'
    //   83: iconst_2
    //   84: anewarray java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_2
    //   94: aastore
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore_3
    //   102: aload_3
    //   103: invokeinterface moveToFirst : ()Z
    //   108: istore #5
    //   110: iload #5
    //   112: ifne -> 127
    //   115: aload_3
    //   116: ifnull -> 125
    //   119: aload_3
    //   120: invokeinterface close : ()V
    //   125: aconst_null
    //   126: areturn
    //   127: aload_3
    //   128: iconst_0
    //   129: invokeinterface getLong : (I)J
    //   134: lstore #6
    //   136: aload_3
    //   137: iconst_1
    //   138: invokeinterface getLong : (I)J
    //   143: lstore #8
    //   145: aload_3
    //   146: iconst_2
    //   147: invokeinterface getLong : (I)J
    //   152: lstore #10
    //   154: aload_3
    //   155: iconst_3
    //   156: invokeinterface isNull : (I)Z
    //   161: ifeq -> 170
    //   164: lconst_0
    //   165: lstore #12
    //   167: goto -> 179
    //   170: aload_3
    //   171: iconst_3
    //   172: invokeinterface getLong : (I)J
    //   177: lstore #12
    //   179: aload_3
    //   180: iconst_4
    //   181: invokeinterface isNull : (I)Z
    //   186: ifeq -> 195
    //   189: aconst_null
    //   190: astore #14
    //   192: goto -> 207
    //   195: aload_3
    //   196: iconst_4
    //   197: invokeinterface getLong : (I)J
    //   202: invokestatic valueOf : (J)Ljava/lang/Long;
    //   205: astore #14
    //   207: aload_3
    //   208: iconst_5
    //   209: invokeinterface isNull : (I)Z
    //   214: ifeq -> 223
    //   217: aconst_null
    //   218: astore #15
    //   220: goto -> 235
    //   223: aload_3
    //   224: iconst_5
    //   225: invokeinterface getLong : (I)J
    //   230: invokestatic valueOf : (J)Ljava/lang/Long;
    //   233: astore #15
    //   235: aload_3
    //   236: bipush #6
    //   238: invokeinterface isNull : (I)Z
    //   243: ifeq -> 252
    //   246: aconst_null
    //   247: astore #16
    //   249: goto -> 268
    //   252: aload_3
    //   253: bipush #6
    //   255: invokeinterface getLong : (I)J
    //   260: invokestatic valueOf : (J)Ljava/lang/Long;
    //   263: astore #16
    //   265: goto -> 249
    //   268: aload_3
    //   269: bipush #7
    //   271: invokeinterface isNull : (I)Z
    //   276: ifne -> 305
    //   279: aload_3
    //   280: bipush #7
    //   282: invokeinterface getLong : (I)J
    //   287: lconst_1
    //   288: lcmp
    //   289: ifne -> 295
    //   292: iconst_1
    //   293: istore #4
    //   295: iload #4
    //   297: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   300: astore #17
    //   302: goto -> 308
    //   305: aconst_null
    //   306: astore #17
    //   308: new com/google/android/gms/measurement/internal/zzaf
    //   311: astore #18
    //   313: aload_3
    //   314: astore #19
    //   316: aload #18
    //   318: aload_1
    //   319: aload_2
    //   320: lload #6
    //   322: lload #8
    //   324: lload #10
    //   326: lload #12
    //   328: aload #14
    //   330: aload #15
    //   332: aload #16
    //   334: aload #17
    //   336: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;JJJJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V
    //   339: aload_3
    //   340: astore #19
    //   342: aload_3
    //   343: invokeinterface moveToNext : ()Z
    //   348: ifeq -> 371
    //   351: aload_3
    //   352: astore #19
    //   354: aload_0
    //   355: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   358: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   361: ldc_w 'Got multiple records for event aggregates, expected one. appId'
    //   364: aload_1
    //   365: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   368: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   371: aload_3
    //   372: ifnull -> 381
    //   375: aload_3
    //   376: invokeinterface close : ()V
    //   381: aload #18
    //   383: areturn
    //   384: astore #14
    //   386: goto -> 412
    //   389: astore_1
    //   390: aload_3
    //   391: astore #19
    //   393: goto -> 455
    //   396: astore #14
    //   398: goto -> 412
    //   401: astore_1
    //   402: aconst_null
    //   403: astore #19
    //   405: goto -> 455
    //   408: astore #14
    //   410: aconst_null
    //   411: astore_3
    //   412: aload_3
    //   413: astore #19
    //   415: aload_0
    //   416: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   419: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   422: ldc_w 'Error querying events. appId'
    //   425: aload_1
    //   426: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   429: aload_0
    //   430: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   433: aload_2
    //   434: invokevirtual zzal : (Ljava/lang/String;)Ljava/lang/String;
    //   437: aload #14
    //   439: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   442: aload_3
    //   443: ifnull -> 452
    //   446: aload_3
    //   447: invokeinterface close : ()V
    //   452: aconst_null
    //   453: areturn
    //   454: astore_1
    //   455: aload #19
    //   457: ifnull -> 467
    //   460: aload #19
    //   462: invokeinterface close : ()V
    //   467: aload_1
    //   468: athrow
    // Exception table:
    //   from	to	target	type
    //   18	23	408	android/database/sqlite/SQLiteException
    //   18	23	401	finally
    //   26	102	408	android/database/sqlite/SQLiteException
    //   26	102	401	finally
    //   102	110	396	android/database/sqlite/SQLiteException
    //   102	110	389	finally
    //   127	164	396	android/database/sqlite/SQLiteException
    //   127	164	389	finally
    //   170	179	396	android/database/sqlite/SQLiteException
    //   170	179	389	finally
    //   179	189	396	android/database/sqlite/SQLiteException
    //   179	189	389	finally
    //   195	207	396	android/database/sqlite/SQLiteException
    //   195	207	389	finally
    //   207	217	396	android/database/sqlite/SQLiteException
    //   207	217	389	finally
    //   223	235	396	android/database/sqlite/SQLiteException
    //   223	235	389	finally
    //   235	246	396	android/database/sqlite/SQLiteException
    //   235	246	389	finally
    //   252	265	396	android/database/sqlite/SQLiteException
    //   252	265	389	finally
    //   268	279	396	android/database/sqlite/SQLiteException
    //   268	279	389	finally
    //   279	292	396	android/database/sqlite/SQLiteException
    //   279	292	389	finally
    //   295	302	396	android/database/sqlite/SQLiteException
    //   295	302	389	finally
    //   308	313	396	android/database/sqlite/SQLiteException
    //   308	313	389	finally
    //   316	339	384	android/database/sqlite/SQLiteException
    //   316	339	454	finally
    //   342	351	384	android/database/sqlite/SQLiteException
    //   342	351	454	finally
    //   354	371	384	android/database/sqlite/SQLiteException
    //   354	371	454	finally
    //   415	442	454	finally
  }
  
  @WorkerThread
  final void zzca() {
    zzq();
    zzah();
    if (!zzcg())
      return; 
    long l1 = (zzae()).zzle.get();
    long l2 = zzz().elapsedRealtime();
    if (Math.abs(l2 - l1) > ((Long)zzal.zzhb.get(null)).longValue()) {
      (zzae()).zzle.set(l2);
      zzq();
      zzah();
      if (zzcg()) {
        int i = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[] { String.valueOf(zzz().currentTimeMillis()), String.valueOf(zzt.zzbs()) });
        if (i > 0)
          zzad().zzdi().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(i)); 
      } 
    } 
  }
  
  @WorkerThread
  public final long zzcb() {
    return zza("select max(bundle_end_timestamp) from queue", (String[])null, 0L);
  }
  
  @WorkerThread
  public final long zzcc() {
    return zza("select max(timestamp) from raw_events", (String[])null, 0L);
  }
  
  public final boolean zzcd() {
    return (zza("select count(1) > 0 from raw_events", (String[])null) != 0L);
  }
  
  public final boolean zzce() {
    return (zza("select count(1) > 0 from raw_events where realtime = 1", (String[])null) != 0L);
  }
  
  public final long zzcf() {
    Cursor cursor1 = null;
    Cursor cursor2 = null;
    try {
      Cursor cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
      cursor2 = cursor;
      cursor1 = cursor;
      boolean bool = cursor.moveToFirst();
      if (!bool) {
        if (cursor != null)
          cursor.close(); 
        return -1L;
      } 
      cursor2 = cursor;
      cursor1 = cursor;
      long l = cursor.getLong(0);
      if (cursor != null)
        cursor.close(); 
      return l;
    } catch (SQLiteException sQLiteException) {
      cursor2 = cursor1;
      zzad().zzda().zza("Error querying raw events", sQLiteException);
      if (cursor1 != null)
        cursor1.close(); 
      return -1L;
    } finally {}
    if (cursor2 != null)
      cursor2.close(); 
    throw cursor1;
  }
  
  @WorkerThread
  public final void zzd(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzq();
    zzah();
    try {
      int i = getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[] { paramString1, paramString2 });
      zzad().zzdi().zza("Deleted user attribute rows", Integer.valueOf(i));
      return;
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error deleting user attribute. appId", zzau.zzao(paramString1), zzaa().zzan(paramString2), sQLiteException);
      return;
    } 
  }
  
  @WorkerThread
  public final zzgc zze(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual zzq : ()V
    //   14: aload_0
    //   15: invokevirtual zzah : ()V
    //   18: aload_0
    //   19: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc_w 'user_attributes'
    //   25: iconst_3
    //   26: anewarray java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: ldc_w 'set_timestamp'
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc_w 'value'
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 'origin'
    //   45: aastore
    //   46: ldc_w 'app_id=? and name=?'
    //   49: iconst_2
    //   50: anewarray java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_2
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_3
    //   68: aload_3
    //   69: invokeinterface moveToFirst : ()Z
    //   74: istore #4
    //   76: iload #4
    //   78: ifne -> 93
    //   81: aload_3
    //   82: ifnull -> 91
    //   85: aload_3
    //   86: invokeinterface close : ()V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_3
    //   94: iconst_0
    //   95: invokeinterface getLong : (I)J
    //   100: lstore #5
    //   102: aload_3
    //   103: astore #7
    //   105: aload_0
    //   106: aload_3
    //   107: iconst_1
    //   108: invokespecial zza : (Landroid/database/Cursor;I)Ljava/lang/Object;
    //   111: astore #8
    //   113: aload_3
    //   114: astore #7
    //   116: aload_3
    //   117: iconst_2
    //   118: invokeinterface getString : (I)Ljava/lang/String;
    //   123: astore #9
    //   125: aload_3
    //   126: astore #7
    //   128: new com/google/android/gms/measurement/internal/zzgc
    //   131: astore #10
    //   133: aload_3
    //   134: astore #7
    //   136: aload #10
    //   138: aload_1
    //   139: aload #9
    //   141: aload_2
    //   142: lload #5
    //   144: aload #8
    //   146: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V
    //   149: aload_3
    //   150: astore #7
    //   152: aload_3
    //   153: invokeinterface moveToNext : ()Z
    //   158: ifeq -> 181
    //   161: aload_3
    //   162: astore #7
    //   164: aload_0
    //   165: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   168: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   171: ldc_w 'Got multiple records for user property, expected one. appId'
    //   174: aload_1
    //   175: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   178: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   181: aload_3
    //   182: ifnull -> 191
    //   185: aload_3
    //   186: invokeinterface close : ()V
    //   191: aload #10
    //   193: areturn
    //   194: astore #9
    //   196: goto -> 218
    //   199: astore_1
    //   200: goto -> 264
    //   203: astore #9
    //   205: goto -> 218
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_3
    //   211: goto -> 264
    //   214: astore #9
    //   216: aconst_null
    //   217: astore_3
    //   218: aload_3
    //   219: astore #7
    //   221: aload_0
    //   222: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   225: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   228: ldc_w 'Error querying user property. appId'
    //   231: aload_1
    //   232: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   235: aload_0
    //   236: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   239: aload_2
    //   240: invokevirtual zzan : (Ljava/lang/String;)Ljava/lang/String;
    //   243: aload #9
    //   245: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   248: aload_3
    //   249: ifnull -> 258
    //   252: aload_3
    //   253: invokeinterface close : ()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore_1
    //   261: aload #7
    //   263: astore_3
    //   264: aload_3
    //   265: ifnull -> 274
    //   268: aload_3
    //   269: invokeinterface close : ()V
    //   274: aload_1
    //   275: athrow
    // Exception table:
    //   from	to	target	type
    //   18	68	214	android/database/sqlite/SQLiteException
    //   18	68	208	finally
    //   68	76	203	android/database/sqlite/SQLiteException
    //   68	76	199	finally
    //   93	102	203	android/database/sqlite/SQLiteException
    //   93	102	199	finally
    //   105	113	194	android/database/sqlite/SQLiteException
    //   105	113	260	finally
    //   116	125	194	android/database/sqlite/SQLiteException
    //   116	125	260	finally
    //   128	133	194	android/database/sqlite/SQLiteException
    //   128	133	260	finally
    //   136	149	194	android/database/sqlite/SQLiteException
    //   136	149	260	finally
    //   152	161	194	android/database/sqlite/SQLiteException
    //   152	161	260	finally
    //   164	181	194	android/database/sqlite/SQLiteException
    //   164	181	260	finally
    //   221	248	260	finally
  }
  
  @WorkerThread
  public final zzr zzf(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   4: pop
    //   5: aload_2
    //   6: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   9: pop
    //   10: aload_0
    //   11: invokevirtual zzq : ()V
    //   14: aload_0
    //   15: invokevirtual zzah : ()V
    //   18: aload_0
    //   19: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc_w 'conditional_properties'
    //   25: bipush #11
    //   27: anewarray java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: ldc 'origin'
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: ldc_w 'value'
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc_w 'active'
    //   46: aastore
    //   47: dup
    //   48: iconst_3
    //   49: ldc_w 'trigger_event_name'
    //   52: aastore
    //   53: dup
    //   54: iconst_4
    //   55: ldc_w 'trigger_timeout'
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: ldc_w 'timed_out_event'
    //   64: aastore
    //   65: dup
    //   66: bipush #6
    //   68: ldc_w 'creation_timestamp'
    //   71: aastore
    //   72: dup
    //   73: bipush #7
    //   75: ldc_w 'triggered_event'
    //   78: aastore
    //   79: dup
    //   80: bipush #8
    //   82: ldc_w 'triggered_timestamp'
    //   85: aastore
    //   86: dup
    //   87: bipush #9
    //   89: ldc_w 'time_to_live'
    //   92: aastore
    //   93: dup
    //   94: bipush #10
    //   96: ldc_w 'expired_event'
    //   99: aastore
    //   100: ldc_w 'app_id=? and name=?'
    //   103: iconst_2
    //   104: anewarray java/lang/String
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_2
    //   114: aastore
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   121: astore_3
    //   122: aload_3
    //   123: invokeinterface moveToFirst : ()Z
    //   128: istore #4
    //   130: iload #4
    //   132: ifne -> 147
    //   135: aload_3
    //   136: ifnull -> 145
    //   139: aload_3
    //   140: invokeinterface close : ()V
    //   145: aconst_null
    //   146: areturn
    //   147: aload_3
    //   148: iconst_0
    //   149: invokeinterface getString : (I)Ljava/lang/String;
    //   154: astore #5
    //   156: aload_3
    //   157: astore #6
    //   159: aload_0
    //   160: aload_3
    //   161: iconst_1
    //   162: invokespecial zza : (Landroid/database/Cursor;I)Ljava/lang/Object;
    //   165: astore #7
    //   167: aload_3
    //   168: astore #6
    //   170: aload_3
    //   171: iconst_2
    //   172: invokeinterface getInt : (I)I
    //   177: ifeq -> 186
    //   180: iconst_1
    //   181: istore #4
    //   183: goto -> 189
    //   186: iconst_0
    //   187: istore #4
    //   189: aload_3
    //   190: astore #6
    //   192: aload_3
    //   193: iconst_3
    //   194: invokeinterface getString : (I)Ljava/lang/String;
    //   199: astore #8
    //   201: aload_3
    //   202: astore #6
    //   204: aload_3
    //   205: iconst_4
    //   206: invokeinterface getLong : (I)J
    //   211: lstore #9
    //   213: aload_3
    //   214: astore #6
    //   216: aload_0
    //   217: invokevirtual zzdm : ()Lcom/google/android/gms/measurement/internal/zzfz;
    //   220: aload_3
    //   221: iconst_5
    //   222: invokeinterface getBlob : (I)[B
    //   227: getstatic com/google/android/gms/measurement/internal/zzaj.CREATOR : Landroid/os/Parcelable$Creator;
    //   230: invokevirtual zza : ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   233: checkcast com/google/android/gms/measurement/internal/zzaj
    //   236: astore #11
    //   238: aload_3
    //   239: astore #6
    //   241: aload_3
    //   242: bipush #6
    //   244: invokeinterface getLong : (I)J
    //   249: lstore #12
    //   251: aload_3
    //   252: astore #6
    //   254: aload_0
    //   255: invokevirtual zzdm : ()Lcom/google/android/gms/measurement/internal/zzfz;
    //   258: aload_3
    //   259: bipush #7
    //   261: invokeinterface getBlob : (I)[B
    //   266: getstatic com/google/android/gms/measurement/internal/zzaj.CREATOR : Landroid/os/Parcelable$Creator;
    //   269: invokevirtual zza : ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   272: checkcast com/google/android/gms/measurement/internal/zzaj
    //   275: astore #14
    //   277: aload_3
    //   278: astore #6
    //   280: aload_3
    //   281: bipush #8
    //   283: invokeinterface getLong : (I)J
    //   288: lstore #15
    //   290: aload_3
    //   291: astore #6
    //   293: aload_3
    //   294: bipush #9
    //   296: invokeinterface getLong : (I)J
    //   301: lstore #17
    //   303: aload_3
    //   304: astore #6
    //   306: aload_0
    //   307: invokevirtual zzdm : ()Lcom/google/android/gms/measurement/internal/zzfz;
    //   310: aload_3
    //   311: bipush #10
    //   313: invokeinterface getBlob : (I)[B
    //   318: getstatic com/google/android/gms/measurement/internal/zzaj.CREATOR : Landroid/os/Parcelable$Creator;
    //   321: invokevirtual zza : ([BLandroid/os/Parcelable$Creator;)Landroid/os/Parcelable;
    //   324: checkcast com/google/android/gms/measurement/internal/zzaj
    //   327: astore #19
    //   329: aload_3
    //   330: astore #6
    //   332: new com/google/android/gms/measurement/internal/zzga
    //   335: astore #20
    //   337: aload_3
    //   338: astore #6
    //   340: aload #20
    //   342: aload_2
    //   343: lload #15
    //   345: aload #7
    //   347: aload #5
    //   349: invokespecial <init> : (Ljava/lang/String;JLjava/lang/Object;Ljava/lang/String;)V
    //   352: aload_3
    //   353: astore #6
    //   355: new com/google/android/gms/measurement/internal/zzr
    //   358: astore #7
    //   360: aload_3
    //   361: astore #6
    //   363: aload #7
    //   365: aload_1
    //   366: aload #5
    //   368: aload #20
    //   370: lload #12
    //   372: iload #4
    //   374: aload #8
    //   376: aload #11
    //   378: lload #9
    //   380: aload #14
    //   382: lload #17
    //   384: aload #19
    //   386: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/measurement/internal/zzga;JZLjava/lang/String;Lcom/google/android/gms/measurement/internal/zzaj;JLcom/google/android/gms/measurement/internal/zzaj;JLcom/google/android/gms/measurement/internal/zzaj;)V
    //   389: aload_3
    //   390: astore #6
    //   392: aload_3
    //   393: invokeinterface moveToNext : ()Z
    //   398: ifeq -> 429
    //   401: aload_3
    //   402: astore #6
    //   404: aload_0
    //   405: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   408: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   411: ldc_w 'Got multiple records for conditional property, expected one'
    //   414: aload_1
    //   415: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   418: aload_0
    //   419: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   422: aload_2
    //   423: invokevirtual zzan : (Ljava/lang/String;)Ljava/lang/String;
    //   426: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   429: aload_3
    //   430: ifnull -> 439
    //   433: aload_3
    //   434: invokeinterface close : ()V
    //   439: aload #7
    //   441: areturn
    //   442: astore #19
    //   444: goto -> 466
    //   447: astore_1
    //   448: goto -> 512
    //   451: astore #19
    //   453: goto -> 466
    //   456: astore_1
    //   457: aconst_null
    //   458: astore_3
    //   459: goto -> 512
    //   462: astore #19
    //   464: aconst_null
    //   465: astore_3
    //   466: aload_3
    //   467: astore #6
    //   469: aload_0
    //   470: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   473: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   476: ldc_w 'Error querying conditional property'
    //   479: aload_1
    //   480: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   483: aload_0
    //   484: invokevirtual zzaa : ()Lcom/google/android/gms/measurement/internal/zzas;
    //   487: aload_2
    //   488: invokevirtual zzan : (Ljava/lang/String;)Ljava/lang/String;
    //   491: aload #19
    //   493: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   496: aload_3
    //   497: ifnull -> 506
    //   500: aload_3
    //   501: invokeinterface close : ()V
    //   506: aconst_null
    //   507: areturn
    //   508: astore_1
    //   509: aload #6
    //   511: astore_3
    //   512: aload_3
    //   513: ifnull -> 522
    //   516: aload_3
    //   517: invokeinterface close : ()V
    //   522: aload_1
    //   523: athrow
    // Exception table:
    //   from	to	target	type
    //   18	122	462	android/database/sqlite/SQLiteException
    //   18	122	456	finally
    //   122	130	451	android/database/sqlite/SQLiteException
    //   122	130	447	finally
    //   147	156	451	android/database/sqlite/SQLiteException
    //   147	156	447	finally
    //   159	167	442	android/database/sqlite/SQLiteException
    //   159	167	508	finally
    //   170	180	442	android/database/sqlite/SQLiteException
    //   170	180	508	finally
    //   192	201	442	android/database/sqlite/SQLiteException
    //   192	201	508	finally
    //   204	213	442	android/database/sqlite/SQLiteException
    //   204	213	508	finally
    //   216	238	442	android/database/sqlite/SQLiteException
    //   216	238	508	finally
    //   241	251	442	android/database/sqlite/SQLiteException
    //   241	251	508	finally
    //   254	277	442	android/database/sqlite/SQLiteException
    //   254	277	508	finally
    //   280	290	442	android/database/sqlite/SQLiteException
    //   280	290	508	finally
    //   293	303	442	android/database/sqlite/SQLiteException
    //   293	303	508	finally
    //   306	329	442	android/database/sqlite/SQLiteException
    //   306	329	508	finally
    //   332	337	442	android/database/sqlite/SQLiteException
    //   332	337	508	finally
    //   340	352	442	android/database/sqlite/SQLiteException
    //   340	352	508	finally
    //   355	360	442	android/database/sqlite/SQLiteException
    //   355	360	508	finally
    //   363	389	442	android/database/sqlite/SQLiteException
    //   363	389	508	finally
    //   392	401	442	android/database/sqlite/SQLiteException
    //   392	401	508	finally
    //   404	429	442	android/database/sqlite/SQLiteException
    //   404	429	508	finally
    //   469	496	508	finally
  }
  
  @WorkerThread
  public final int zzg(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzq();
    zzah();
    try {
      return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[] { paramString1, paramString2 });
    } catch (SQLiteException sQLiteException) {
      zzad().zzda().zza("Error deleting conditional property", zzau.zzao(paramString1), zzaa().zzan(paramString2), sQLiteException);
      return 0;
    } 
  }
  
  final Map<Integer, List<zzby>> zzh(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzah : ()V
    //   4: aload_0
    //   5: invokevirtual zzq : ()V
    //   8: aload_1
    //   9: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_2
    //   14: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new android/support/v4/util/ArrayMap
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_3
    //   26: aload_0
    //   27: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore #4
    //   32: aload #4
    //   34: ldc_w 'event_filters'
    //   37: iconst_2
    //   38: anewarray java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc_w 'audience_id'
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc_w 'data'
    //   52: aastore
    //   53: ldc_w 'app_id=? AND event_name=?'
    //   56: iconst_2
    //   57: anewarray java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_2
    //   67: aastore
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore #4
    //   76: aload #4
    //   78: astore_2
    //   79: aload #4
    //   81: invokeinterface moveToFirst : ()Z
    //   86: ifne -> 112
    //   89: aload #4
    //   91: astore_2
    //   92: invokestatic emptyMap : ()Ljava/util/Map;
    //   95: astore #5
    //   97: aload #4
    //   99: ifnull -> 109
    //   102: aload #4
    //   104: invokeinterface close : ()V
    //   109: aload #5
    //   111: areturn
    //   112: aload #4
    //   114: astore_2
    //   115: aload #4
    //   117: iconst_1
    //   118: invokeinterface getBlob : (I)[B
    //   123: astore #5
    //   125: aload #4
    //   127: astore_2
    //   128: new com/google/android/gms/internal/measurement/zzby
    //   131: astore #6
    //   133: aload #4
    //   135: astore_2
    //   136: aload #6
    //   138: invokespecial <init> : ()V
    //   141: aload #4
    //   143: astore_2
    //   144: aload #6
    //   146: aload #5
    //   148: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zziv;[B)Lcom/google/android/gms/internal/measurement/zziv;
    //   151: checkcast com/google/android/gms/internal/measurement/zzby
    //   154: astore #7
    //   156: aload #4
    //   158: astore_2
    //   159: aload #4
    //   161: iconst_0
    //   162: invokeinterface getInt : (I)I
    //   167: istore #8
    //   169: aload #4
    //   171: astore_2
    //   172: aload_3
    //   173: iload #8
    //   175: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   178: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast java/util/List
    //   186: astore #6
    //   188: aload #6
    //   190: astore #5
    //   192: aload #6
    //   194: ifnonnull -> 230
    //   197: aload #4
    //   199: astore_2
    //   200: new java/util/ArrayList
    //   203: astore #5
    //   205: aload #4
    //   207: astore_2
    //   208: aload #5
    //   210: invokespecial <init> : ()V
    //   213: aload #4
    //   215: astore_2
    //   216: aload_3
    //   217: iload #8
    //   219: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   222: aload #5
    //   224: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload #4
    //   232: astore_2
    //   233: aload #5
    //   235: aload #7
    //   237: invokeinterface add : (Ljava/lang/Object;)Z
    //   242: pop
    //   243: goto -> 270
    //   246: astore #5
    //   248: aload #4
    //   250: astore_2
    //   251: aload_0
    //   252: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   255: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   258: ldc_w 'Failed to merge filter. appId'
    //   261: aload_1
    //   262: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   265: aload #5
    //   267: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   270: aload #4
    //   272: astore_2
    //   273: aload #4
    //   275: invokeinterface moveToNext : ()Z
    //   280: istore #9
    //   282: iload #9
    //   284: ifne -> 112
    //   287: aload #4
    //   289: ifnull -> 299
    //   292: aload #4
    //   294: invokeinterface close : ()V
    //   299: aload_3
    //   300: areturn
    //   301: astore #5
    //   303: goto -> 317
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_2
    //   309: goto -> 354
    //   312: astore #5
    //   314: aconst_null
    //   315: astore #4
    //   317: aload #4
    //   319: astore_2
    //   320: aload_0
    //   321: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   324: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   327: ldc_w 'Database error querying filters. appId'
    //   330: aload_1
    //   331: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   334: aload #5
    //   336: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   339: aload #4
    //   341: ifnull -> 351
    //   344: aload #4
    //   346: invokeinterface close : ()V
    //   351: aconst_null
    //   352: areturn
    //   353: astore_1
    //   354: aload_2
    //   355: ifnull -> 364
    //   358: aload_2
    //   359: invokeinterface close : ()V
    //   364: aload_1
    //   365: athrow
    // Exception table:
    //   from	to	target	type
    //   32	76	312	android/database/sqlite/SQLiteException
    //   32	76	306	finally
    //   79	89	301	android/database/sqlite/SQLiteException
    //   79	89	353	finally
    //   92	97	301	android/database/sqlite/SQLiteException
    //   92	97	353	finally
    //   115	125	301	android/database/sqlite/SQLiteException
    //   115	125	353	finally
    //   128	133	246	java/io/IOException
    //   128	133	301	android/database/sqlite/SQLiteException
    //   128	133	353	finally
    //   136	141	246	java/io/IOException
    //   136	141	301	android/database/sqlite/SQLiteException
    //   136	141	353	finally
    //   144	156	246	java/io/IOException
    //   144	156	301	android/database/sqlite/SQLiteException
    //   144	156	353	finally
    //   159	169	301	android/database/sqlite/SQLiteException
    //   159	169	353	finally
    //   172	188	301	android/database/sqlite/SQLiteException
    //   172	188	353	finally
    //   200	205	301	android/database/sqlite/SQLiteException
    //   200	205	353	finally
    //   208	213	301	android/database/sqlite/SQLiteException
    //   208	213	353	finally
    //   216	230	301	android/database/sqlite/SQLiteException
    //   216	230	353	finally
    //   233	243	301	android/database/sqlite/SQLiteException
    //   233	243	353	finally
    //   251	270	301	android/database/sqlite/SQLiteException
    //   251	270	353	finally
    //   273	282	301	android/database/sqlite/SQLiteException
    //   273	282	353	finally
    //   320	339	353	finally
  }
  
  final Map<Integer, List<zzcb>> zzi(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzah : ()V
    //   4: aload_0
    //   5: invokevirtual zzq : ()V
    //   8: aload_1
    //   9: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: aload_2
    //   14: invokestatic checkNotEmpty : (Ljava/lang/String;)Ljava/lang/String;
    //   17: pop
    //   18: new android/support/v4/util/ArrayMap
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_3
    //   26: aload_0
    //   27: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   30: astore #4
    //   32: aload #4
    //   34: ldc_w 'property_filters'
    //   37: iconst_2
    //   38: anewarray java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc_w 'audience_id'
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc_w 'data'
    //   52: aastore
    //   53: ldc_w 'app_id=? AND property_name=?'
    //   56: iconst_2
    //   57: anewarray java/lang/String
    //   60: dup
    //   61: iconst_0
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_2
    //   67: aastore
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: invokevirtual query : (Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   74: astore #4
    //   76: aload #4
    //   78: astore_2
    //   79: aload #4
    //   81: invokeinterface moveToFirst : ()Z
    //   86: ifne -> 112
    //   89: aload #4
    //   91: astore_2
    //   92: invokestatic emptyMap : ()Ljava/util/Map;
    //   95: astore #5
    //   97: aload #4
    //   99: ifnull -> 109
    //   102: aload #4
    //   104: invokeinterface close : ()V
    //   109: aload #5
    //   111: areturn
    //   112: aload #4
    //   114: astore_2
    //   115: aload #4
    //   117: iconst_1
    //   118: invokeinterface getBlob : (I)[B
    //   123: astore #6
    //   125: aload #4
    //   127: astore_2
    //   128: new com/google/android/gms/internal/measurement/zzcb
    //   131: astore #5
    //   133: aload #4
    //   135: astore_2
    //   136: aload #5
    //   138: invokespecial <init> : ()V
    //   141: aload #4
    //   143: astore_2
    //   144: aload #5
    //   146: aload #6
    //   148: invokestatic zza : (Lcom/google/android/gms/internal/measurement/zziv;[B)Lcom/google/android/gms/internal/measurement/zziv;
    //   151: checkcast com/google/android/gms/internal/measurement/zzcb
    //   154: astore #7
    //   156: aload #4
    //   158: astore_2
    //   159: aload #4
    //   161: iconst_0
    //   162: invokeinterface getInt : (I)I
    //   167: istore #8
    //   169: aload #4
    //   171: astore_2
    //   172: aload_3
    //   173: iload #8
    //   175: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   178: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast java/util/List
    //   186: astore #6
    //   188: aload #6
    //   190: astore #5
    //   192: aload #6
    //   194: ifnonnull -> 230
    //   197: aload #4
    //   199: astore_2
    //   200: new java/util/ArrayList
    //   203: astore #5
    //   205: aload #4
    //   207: astore_2
    //   208: aload #5
    //   210: invokespecial <init> : ()V
    //   213: aload #4
    //   215: astore_2
    //   216: aload_3
    //   217: iload #8
    //   219: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   222: aload #5
    //   224: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload #4
    //   232: astore_2
    //   233: aload #5
    //   235: aload #7
    //   237: invokeinterface add : (Ljava/lang/Object;)Z
    //   242: pop
    //   243: goto -> 270
    //   246: astore #5
    //   248: aload #4
    //   250: astore_2
    //   251: aload_0
    //   252: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   255: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   258: ldc_w 'Failed to merge filter'
    //   261: aload_1
    //   262: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   265: aload #5
    //   267: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   270: aload #4
    //   272: astore_2
    //   273: aload #4
    //   275: invokeinterface moveToNext : ()Z
    //   280: istore #9
    //   282: iload #9
    //   284: ifne -> 112
    //   287: aload #4
    //   289: ifnull -> 299
    //   292: aload #4
    //   294: invokeinterface close : ()V
    //   299: aload_3
    //   300: areturn
    //   301: astore #5
    //   303: goto -> 317
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_2
    //   309: goto -> 354
    //   312: astore #5
    //   314: aconst_null
    //   315: astore #4
    //   317: aload #4
    //   319: astore_2
    //   320: aload_0
    //   321: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   324: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   327: ldc_w 'Database error querying filters. appId'
    //   330: aload_1
    //   331: invokestatic zzao : (Ljava/lang/String;)Ljava/lang/Object;
    //   334: aload #5
    //   336: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   339: aload #4
    //   341: ifnull -> 351
    //   344: aload #4
    //   346: invokeinterface close : ()V
    //   351: aconst_null
    //   352: areturn
    //   353: astore_1
    //   354: aload_2
    //   355: ifnull -> 364
    //   358: aload_2
    //   359: invokeinterface close : ()V
    //   364: aload_1
    //   365: athrow
    // Exception table:
    //   from	to	target	type
    //   32	76	312	android/database/sqlite/SQLiteException
    //   32	76	306	finally
    //   79	89	301	android/database/sqlite/SQLiteException
    //   79	89	353	finally
    //   92	97	301	android/database/sqlite/SQLiteException
    //   92	97	353	finally
    //   115	125	301	android/database/sqlite/SQLiteException
    //   115	125	353	finally
    //   128	133	246	java/io/IOException
    //   128	133	301	android/database/sqlite/SQLiteException
    //   128	133	353	finally
    //   136	141	246	java/io/IOException
    //   136	141	301	android/database/sqlite/SQLiteException
    //   136	141	353	finally
    //   144	156	246	java/io/IOException
    //   144	156	301	android/database/sqlite/SQLiteException
    //   144	156	353	finally
    //   159	169	301	android/database/sqlite/SQLiteException
    //   159	169	353	finally
    //   172	188	301	android/database/sqlite/SQLiteException
    //   172	188	353	finally
    //   200	205	301	android/database/sqlite/SQLiteException
    //   200	205	353	finally
    //   208	213	301	android/database/sqlite/SQLiteException
    //   208	213	353	finally
    //   216	230	301	android/database/sqlite/SQLiteException
    //   216	230	353	finally
    //   233	243	301	android/database/sqlite/SQLiteException
    //   233	243	353	finally
    //   251	270	301	android/database/sqlite/SQLiteException
    //   251	270	353	finally
    //   273	282	301	android/database/sqlite/SQLiteException
    //   273	282	353	finally
    //   320	339	353	finally
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final long zzj(String paramString1, String paramString2) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    zzq();
    zzah();
    SQLiteDatabase sQLiteDatabase = getWritableDatabase();
    sQLiteDatabase.beginTransaction();
    try {
      int i = String.valueOf(paramString2).length();
      StringBuilder stringBuilder = new StringBuilder();
      this(i + 32);
      stringBuilder.append("select ");
      stringBuilder.append(paramString2);
      stringBuilder.append(" from app2 where app_id=?");
      long l1 = zza(stringBuilder.toString(), new String[] { paramString1 }, -1L);
      long l2 = l1;
      if (l1 == -1L) {
        ContentValues contentValues = new ContentValues();
        this();
        contentValues.put("app_id", paramString1);
        contentValues.put("first_open_count", Integer.valueOf(0));
        contentValues.put("previous_install_count", Integer.valueOf(0));
        if (sQLiteDatabase.insertWithOnConflict("app2", null, contentValues, 5) == -1L) {
          zzad().zzda().zza("Failed to insert column (got -1). appId", zzau.zzao(paramString1), paramString2);
          sQLiteDatabase.endTransaction();
          return -1L;
        } 
        l2 = 0L;
      } 
      try {
        ContentValues contentValues = new ContentValues();
        this();
        contentValues.put("app_id", paramString1);
        contentValues.put(paramString2, Long.valueOf(1L + l2));
        if (sQLiteDatabase.update("app2", contentValues, "app_id = ?", new String[] { paramString1 }) == 0L) {
          zzad().zzda().zza("Failed to update column (got 0). appId", zzau.zzao(paramString1), paramString2);
          sQLiteDatabase.endTransaction();
          return -1L;
        } 
        sQLiteDatabase.setTransactionSuccessful();
        sQLiteDatabase.endTransaction();
      } catch (SQLiteException null) {}
    } catch (SQLiteException sQLiteException) {
      long l = 0L;
    } finally {}
    zzad().zzda().zza("Error inserting column. appId", zzau.zzao(paramString1), paramString2, sQLiteException);
    sQLiteDatabase.endTransaction();
  }
  
  public final String zzu(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzq : ()V
    //   4: aload_0
    //   5: invokevirtual zzah : ()V
    //   8: aload_0
    //   9: invokevirtual getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   12: ldc_w 'select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;'
    //   15: iconst_1
    //   16: anewarray java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: lload_1
    //   22: invokestatic valueOf : (J)Ljava/lang/String;
    //   25: aastore
    //   26: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_3
    //   30: aload_3
    //   31: astore #4
    //   33: aload_3
    //   34: invokeinterface moveToFirst : ()Z
    //   39: ifne -> 70
    //   42: aload_3
    //   43: astore #4
    //   45: aload_0
    //   46: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   49: invokevirtual zzdi : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   52: ldc_w 'No expired configs for apps with pending events'
    //   55: invokevirtual zzaq : (Ljava/lang/String;)V
    //   58: aload_3
    //   59: ifnull -> 68
    //   62: aload_3
    //   63: invokeinterface close : ()V
    //   68: aconst_null
    //   69: areturn
    //   70: aload_3
    //   71: astore #4
    //   73: aload_3
    //   74: iconst_0
    //   75: invokeinterface getString : (I)Ljava/lang/String;
    //   80: astore #5
    //   82: aload_3
    //   83: ifnull -> 92
    //   86: aload_3
    //   87: invokeinterface close : ()V
    //   92: aload #5
    //   94: areturn
    //   95: astore #5
    //   97: goto -> 115
    //   100: astore #4
    //   102: aconst_null
    //   103: astore #5
    //   105: aload #4
    //   107: astore_3
    //   108: goto -> 150
    //   111: astore #5
    //   113: aconst_null
    //   114: astore_3
    //   115: aload_3
    //   116: astore #4
    //   118: aload_0
    //   119: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   122: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   125: ldc_w 'Error selecting expired configs'
    //   128: aload #5
    //   130: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   133: aload_3
    //   134: ifnull -> 143
    //   137: aload_3
    //   138: invokeinterface close : ()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_3
    //   146: aload #4
    //   148: astore #5
    //   150: aload #5
    //   152: ifnull -> 162
    //   155: aload #5
    //   157: invokeinterface close : ()V
    //   162: aload_3
    //   163: athrow
    // Exception table:
    //   from	to	target	type
    //   8	30	111	android/database/sqlite/SQLiteException
    //   8	30	100	finally
    //   33	42	95	android/database/sqlite/SQLiteException
    //   33	42	145	finally
    //   45	58	95	android/database/sqlite/SQLiteException
    //   45	58	145	finally
    //   73	82	95	android/database/sqlite/SQLiteException
    //   73	82	145	finally
    //   118	133	145	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */