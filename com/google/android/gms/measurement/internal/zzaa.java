package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzaa {
  @WorkerThread
  private static Set<String> zza(SQLiteDatabase paramSQLiteDatabase, String paramString) {
    HashSet<? super String> hashSet = new HashSet();
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 22);
    stringBuilder.append("SELECT * FROM ");
    stringBuilder.append(paramString);
    stringBuilder.append(" LIMIT 0");
    Cursor cursor = paramSQLiteDatabase.rawQuery(stringBuilder.toString(), null);
    try {
      Collections.addAll(hashSet, cursor.getColumnNames());
      return (Set)hashSet;
    } finally {
      cursor.close();
    } 
  }
  
  static void zza(zzau paramzzau, SQLiteDatabase paramSQLiteDatabase) {
    if (paramzzau != null) {
      File file = new File(paramSQLiteDatabase.getPath());
      if (!file.setReadable(false, false))
        paramzzau.zzdd().zzaq("Failed to turn off database read permission"); 
      if (!file.setWritable(false, false))
        paramzzau.zzdd().zzaq("Failed to turn off database write permission"); 
      if (!file.setReadable(true, true))
        paramzzau.zzdd().zzaq("Failed to turn on database read permission for owner"); 
      if (!file.setWritable(true, true))
        paramzzau.zzdd().zzaq("Failed to turn on database write permission for owner"); 
      return;
    } 
    throw new IllegalArgumentException("Monitor must not be null");
  }
  
  @WorkerThread
  static void zza(zzau paramzzau, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) throws SQLiteException {
    if (paramzzau != null) {
      if (!zza(paramzzau, paramSQLiteDatabase, paramString1))
        paramSQLiteDatabase.execSQL(paramString2); 
      if (paramzzau != null)
        try {
          StringBuilder stringBuilder;
          Set<String> set = zza(paramSQLiteDatabase, paramString1);
          String[] arrayOfString = paramString3.split(",");
          int i = arrayOfString.length;
          int j = 0;
          int k = 0;
          while (k < i) {
            paramString2 = arrayOfString[k];
            if (set.remove(paramString2)) {
              k++;
              continue;
            } 
            SQLiteException sQLiteException = new SQLiteException();
            k = String.valueOf(paramString1).length();
            j = String.valueOf(paramString2).length();
            stringBuilder = new StringBuilder();
            this(k + 35 + j);
            stringBuilder.append("Table ");
            stringBuilder.append(paramString1);
            stringBuilder.append(" is missing required column: ");
            stringBuilder.append(paramString2);
            this(stringBuilder.toString());
            throw sQLiteException;
          } 
          if (paramArrayOfString != null)
            for (k = j; k < paramArrayOfString.length; k += 2) {
              if (!set.remove(paramArrayOfString[k]))
                stringBuilder.execSQL(paramArrayOfString[k + 1]); 
            }  
          if (!set.isEmpty())
            paramzzau.zzdd().zza("Table has extra columns. table, columns", paramString1, TextUtils.join(", ", set)); 
          return;
        } catch (SQLiteException sQLiteException) {
          paramzzau.zzda().zza("Failed to verify columns on table that was just created", paramString1);
          throw sQLiteException;
        }  
      IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
      this("Monitor must not be null");
      throw illegalArgumentException;
    } 
    throw new IllegalArgumentException("Monitor must not be null");
  }
  
  @WorkerThread
  private static boolean zza(zzau paramzzau, SQLiteDatabase paramSQLiteDatabase, String paramString) {
    if (paramzzau != null) {
      Cursor cursor1 = null;
      Cursor cursor2 = null;
      try {
        Cursor cursor = paramSQLiteDatabase.query("SQLITE_MASTER", new String[] { "name" }, "name=?", new String[] { paramString }, null, null, null);
        cursor2 = cursor;
        cursor1 = cursor;
        boolean bool = cursor.moveToFirst();
        if (cursor != null)
          cursor.close(); 
        return bool;
      } catch (SQLiteException sQLiteException) {
        cursor2 = cursor1;
        paramzzau.zzdd().zza("Error querying for table", paramString, sQLiteException);
        if (cursor1 != null)
          cursor1.close(); 
        return false;
      } finally {}
      if (cursor2 != null)
        cursor2.close(); 
      throw paramzzau;
    } 
    throw new IllegalArgumentException("Monitor must not be null");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */