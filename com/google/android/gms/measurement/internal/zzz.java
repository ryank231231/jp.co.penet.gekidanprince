package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzz extends SQLiteOpenHelper {
  zzz(zzw paramzzw, Context paramContext, String paramString) {
    super(paramContext, paramString, null, 1);
  }
  
  @WorkerThread
  public final SQLiteDatabase getWritableDatabase() {
    if (zzw.zza(this.zzeq).zzae(3600000L))
      try {
        return super.getWritableDatabase();
      } catch (SQLiteException sQLiteException) {
        zzw.zza(this.zzeq).start();
        this.zzeq.zzad().zzda().zzaq("Opening the database failed, dropping and recreating it");
        if (!this.zzeq.getContext().getDatabasePath("google_app_measurement.db").delete())
          this.zzeq.zzad().zzda().zza("Failed to delete corrupted db file", "google_app_measurement.db"); 
        try {
          SQLiteDatabase sQLiteDatabase = super.getWritableDatabase();
          zzw.zza(this.zzeq).clear();
          return sQLiteDatabase;
        } catch (SQLiteException sQLiteException1) {
          this.zzeq.zzad().zzda().zza("Failed to open freshly created database", sQLiteException1);
          throw sQLiteException1;
        } 
      }  
    throw new SQLiteException("Database open failed");
  }
  
  @WorkerThread
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase);
  }
  
  @WorkerThread
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  @WorkerThread
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase) {
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzw.zzch());
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzw.zzci());
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzw.zzcj());
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzw.zzck());
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzw.zzcl());
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", null);
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", null);
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzw.zzcm());
    zzaa.zza(this.zzeq.zzad(), paramSQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
  }
  
  @WorkerThread
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */