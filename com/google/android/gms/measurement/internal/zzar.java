package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzar extends SQLiteOpenHelper {
  zzar(zzaq paramzzaq, Context paramContext, String paramString) {
    super(paramContext, paramString, null, 1);
  }
  
  @WorkerThread
  public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
    try {
      return super.getWritableDatabase();
    } catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
      throw sQLiteDatabaseLockedException;
    } catch (SQLiteException sQLiteException) {
      this.zzjl.zzad().zzda().zzaq("Opening the local database failed, dropping and recreating it");
      if (!this.zzjl.getContext().getDatabasePath("google_app_measurement_local.db").delete())
        this.zzjl.zzad().zzda().zza("Failed to delete corrupted local db file", "google_app_measurement_local.db"); 
      try {
        return super.getWritableDatabase();
      } catch (SQLiteException sQLiteException1) {
        this.zzjl.zzad().zzda().zza("Failed to open local database. Events will bypass local storage", sQLiteException1);
        return null;
      } 
    } 
  }
  
  @WorkerThread
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase) {
    zzaa.zza(this.zzjl.zzad(), paramSQLiteDatabase);
  }
  
  @WorkerThread
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  @WorkerThread
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase) {
    if (Build.VERSION.SDK_INT < 15) {
      Cursor cursor = null;
      try {
        Cursor cursor1 = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
        cursor = cursor1;
        cursor1.moveToFirst();
      } finally {
        if (cursor != null)
          cursor.close(); 
      } 
    } 
    zzaa.zza(this.zzjl.zzad(), paramSQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
  }
  
  @WorkerThread
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */