package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

public final class zzaq extends zzf {
  private final zzar zzjj = new zzar(this, super.getContext(), "google_app_measurement_local.db");
  
  private boolean zzjk;
  
  zzaq(zzby paramzzby) {
    super(paramzzby);
  }
  
  @WorkerThread
  @VisibleForTesting
  private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
    if (this.zzjk)
      return null; 
    SQLiteDatabase sQLiteDatabase = this.zzjj.getWritableDatabase();
    if (sQLiteDatabase == null) {
      this.zzjk = true;
      return null;
    } 
    return sQLiteDatabase;
  }
  
  @WorkerThread
  private final boolean zza(int paramInt, byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual zzo : ()V
    //   4: aload_0
    //   5: invokevirtual zzq : ()V
    //   8: aload_0
    //   9: getfield zzjk : Z
    //   12: ifeq -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: new android/content/ContentValues
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore_3
    //   25: aload_3
    //   26: ldc 'type'
    //   28: iload_1
    //   29: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   32: invokevirtual put : (Ljava/lang/String;Ljava/lang/Integer;)V
    //   35: aload_3
    //   36: ldc 'entry'
    //   38: aload_2
    //   39: invokevirtual put : (Ljava/lang/String;[B)V
    //   42: iconst_0
    //   43: istore #4
    //   45: iconst_5
    //   46: istore #5
    //   48: iload #4
    //   50: iconst_5
    //   51: if_icmpge -> 585
    //   54: aconst_null
    //   55: astore #6
    //   57: aconst_null
    //   58: astore #7
    //   60: aconst_null
    //   61: astore #8
    //   63: aconst_null
    //   64: astore #9
    //   66: aload_0
    //   67: invokespecial getWritableDatabase : ()Landroid/database/sqlite/SQLiteDatabase;
    //   70: astore_2
    //   71: aload_2
    //   72: ifnonnull -> 97
    //   75: aload #8
    //   77: astore #9
    //   79: aload_2
    //   80: astore #10
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield zzjk : Z
    //   87: aload_2
    //   88: ifnull -> 95
    //   91: aload_2
    //   92: invokevirtual close : ()V
    //   95: iconst_0
    //   96: ireturn
    //   97: aload #8
    //   99: astore #9
    //   101: aload_2
    //   102: astore #10
    //   104: aload_2
    //   105: invokevirtual beginTransaction : ()V
    //   108: lconst_0
    //   109: lstore #11
    //   111: aload #8
    //   113: astore #9
    //   115: aload_2
    //   116: astore #10
    //   118: aload_2
    //   119: ldc 'select count(1) from messages'
    //   121: aconst_null
    //   122: invokevirtual rawQuery : (Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   125: astore #8
    //   127: lload #11
    //   129: lstore #13
    //   131: aload #8
    //   133: ifnull -> 186
    //   136: lload #11
    //   138: lstore #13
    //   140: aload #8
    //   142: invokeinterface moveToFirst : ()Z
    //   147: ifeq -> 186
    //   150: aload #8
    //   152: iconst_0
    //   153: invokeinterface getLong : (I)J
    //   158: lstore #13
    //   160: goto -> 186
    //   163: astore #10
    //   165: goto -> 562
    //   168: astore #10
    //   170: goto -> 327
    //   173: astore #10
    //   175: aload #8
    //   177: astore #7
    //   179: aload #10
    //   181: astore #8
    //   183: goto -> 481
    //   186: lload #13
    //   188: ldc2_w 100000
    //   191: lcmp
    //   192: iflt -> 278
    //   195: aload_0
    //   196: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   199: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   202: ldc 'Data loss, local db full'
    //   204: invokevirtual zzaq : (Ljava/lang/String;)V
    //   207: ldc2_w 100000
    //   210: lload #13
    //   212: lsub
    //   213: lconst_1
    //   214: ladd
    //   215: lstore #11
    //   217: aload_2
    //   218: ldc 'messages'
    //   220: ldc 'rowid in (select rowid from messages order by rowid asc limit ?)'
    //   222: iconst_1
    //   223: anewarray java/lang/String
    //   226: dup
    //   227: iconst_0
    //   228: lload #11
    //   230: invokestatic toString : (J)Ljava/lang/String;
    //   233: aastore
    //   234: invokevirtual delete : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   237: i2l
    //   238: lstore #13
    //   240: lload #13
    //   242: lload #11
    //   244: lcmp
    //   245: ifeq -> 278
    //   248: aload_0
    //   249: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   252: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   255: ldc 'Different delete count than expected in local db. expected, received, difference'
    //   257: lload #11
    //   259: invokestatic valueOf : (J)Ljava/lang/Long;
    //   262: lload #13
    //   264: invokestatic valueOf : (J)Ljava/lang/Long;
    //   267: lload #11
    //   269: lload #13
    //   271: lsub
    //   272: invokestatic valueOf : (J)Ljava/lang/Long;
    //   275: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   278: aload_2
    //   279: ldc 'messages'
    //   281: aconst_null
    //   282: aload_3
    //   283: invokevirtual insertOrThrow : (Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   286: pop2
    //   287: aload_2
    //   288: invokevirtual setTransactionSuccessful : ()V
    //   291: aload_2
    //   292: invokevirtual endTransaction : ()V
    //   295: aload #8
    //   297: ifnull -> 307
    //   300: aload #8
    //   302: invokeinterface close : ()V
    //   307: aload_2
    //   308: ifnull -> 315
    //   311: aload_2
    //   312: invokevirtual close : ()V
    //   315: iconst_1
    //   316: ireturn
    //   317: astore #10
    //   319: goto -> 428
    //   322: astore #10
    //   324: aconst_null
    //   325: astore #8
    //   327: goto -> 353
    //   330: astore #8
    //   332: goto -> 481
    //   335: astore #10
    //   337: aconst_null
    //   338: astore_2
    //   339: aload_2
    //   340: astore #8
    //   342: goto -> 562
    //   345: astore #10
    //   347: aconst_null
    //   348: astore #8
    //   350: aload #9
    //   352: astore_2
    //   353: aload_2
    //   354: ifnull -> 368
    //   357: aload_2
    //   358: invokevirtual inTransaction : ()Z
    //   361: ifeq -> 368
    //   364: aload_2
    //   365: invokevirtual endTransaction : ()V
    //   368: aload_0
    //   369: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   372: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   375: ldc 'Error writing entry to local database'
    //   377: aload #10
    //   379: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   382: aload_0
    //   383: iconst_1
    //   384: putfield zzjk : Z
    //   387: aload #8
    //   389: ifnull -> 399
    //   392: aload #8
    //   394: invokeinterface close : ()V
    //   399: iload #5
    //   401: istore_1
    //   402: aload_2
    //   403: ifnull -> 540
    //   406: aload_2
    //   407: invokevirtual close : ()V
    //   410: iload #5
    //   412: istore_1
    //   413: goto -> 540
    //   416: astore #10
    //   418: goto -> 562
    //   421: astore_2
    //   422: aconst_null
    //   423: astore_2
    //   424: aload #6
    //   426: astore #8
    //   428: iload #5
    //   430: i2l
    //   431: lstore #13
    //   433: aload #8
    //   435: astore #9
    //   437: aload_2
    //   438: astore #10
    //   440: lload #13
    //   442: invokestatic sleep : (J)V
    //   445: iinc #5, 20
    //   448: aload #8
    //   450: ifnull -> 460
    //   453: aload #8
    //   455: invokeinterface close : ()V
    //   460: iload #5
    //   462: istore_1
    //   463: aload_2
    //   464: ifnull -> 540
    //   467: aload_2
    //   468: invokevirtual close : ()V
    //   471: iload #5
    //   473: istore_1
    //   474: goto -> 540
    //   477: astore #8
    //   479: aconst_null
    //   480: astore_2
    //   481: aload #7
    //   483: astore #9
    //   485: aload_2
    //   486: astore #10
    //   488: aload_0
    //   489: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   492: invokevirtual zzda : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   495: ldc 'Error writing entry to local database'
    //   497: aload #8
    //   499: invokevirtual zza : (Ljava/lang/String;Ljava/lang/Object;)V
    //   502: aload #7
    //   504: astore #9
    //   506: aload_2
    //   507: astore #10
    //   509: aload_0
    //   510: iconst_1
    //   511: putfield zzjk : Z
    //   514: aload #7
    //   516: ifnull -> 526
    //   519: aload #7
    //   521: invokeinterface close : ()V
    //   526: iload #5
    //   528: istore_1
    //   529: aload_2
    //   530: ifnull -> 540
    //   533: aload_2
    //   534: invokevirtual close : ()V
    //   537: iload #5
    //   539: istore_1
    //   540: iinc #4, 1
    //   543: iload_1
    //   544: istore #5
    //   546: goto -> 48
    //   549: astore #7
    //   551: aload #9
    //   553: astore #8
    //   555: aload #10
    //   557: astore_2
    //   558: aload #7
    //   560: astore #10
    //   562: aload #8
    //   564: ifnull -> 574
    //   567: aload #8
    //   569: invokeinterface close : ()V
    //   574: aload_2
    //   575: ifnull -> 582
    //   578: aload_2
    //   579: invokevirtual close : ()V
    //   582: aload #10
    //   584: athrow
    //   585: aload_0
    //   586: invokevirtual zzad : ()Lcom/google/android/gms/measurement/internal/zzau;
    //   589: invokevirtual zzdd : ()Lcom/google/android/gms/measurement/internal/zzaw;
    //   592: ldc 'Failed to write entry to local database'
    //   594: invokevirtual zzaq : (Ljava/lang/String;)V
    //   597: iconst_0
    //   598: ireturn
    //   599: astore #10
    //   601: aload #6
    //   603: astore #8
    //   605: goto -> 428
    // Exception table:
    //   from	to	target	type
    //   66	71	477	android/database/sqlite/SQLiteFullException
    //   66	71	421	android/database/sqlite/SQLiteDatabaseLockedException
    //   66	71	345	android/database/sqlite/SQLiteException
    //   66	71	335	finally
    //   82	87	330	android/database/sqlite/SQLiteFullException
    //   82	87	599	android/database/sqlite/SQLiteDatabaseLockedException
    //   82	87	322	android/database/sqlite/SQLiteException
    //   82	87	549	finally
    //   104	108	330	android/database/sqlite/SQLiteFullException
    //   104	108	599	android/database/sqlite/SQLiteDatabaseLockedException
    //   104	108	322	android/database/sqlite/SQLiteException
    //   104	108	549	finally
    //   118	127	330	android/database/sqlite/SQLiteFullException
    //   118	127	599	android/database/sqlite/SQLiteDatabaseLockedException
    //   118	127	322	android/database/sqlite/SQLiteException
    //   118	127	549	finally
    //   140	160	173	android/database/sqlite/SQLiteFullException
    //   140	160	317	android/database/sqlite/SQLiteDatabaseLockedException
    //   140	160	168	android/database/sqlite/SQLiteException
    //   140	160	163	finally
    //   195	207	173	android/database/sqlite/SQLiteFullException
    //   195	207	317	android/database/sqlite/SQLiteDatabaseLockedException
    //   195	207	168	android/database/sqlite/SQLiteException
    //   195	207	163	finally
    //   217	240	173	android/database/sqlite/SQLiteFullException
    //   217	240	317	android/database/sqlite/SQLiteDatabaseLockedException
    //   217	240	168	android/database/sqlite/SQLiteException
    //   217	240	163	finally
    //   248	278	173	android/database/sqlite/SQLiteFullException
    //   248	278	317	android/database/sqlite/SQLiteDatabaseLockedException
    //   248	278	168	android/database/sqlite/SQLiteException
    //   248	278	163	finally
    //   278	295	173	android/database/sqlite/SQLiteFullException
    //   278	295	317	android/database/sqlite/SQLiteDatabaseLockedException
    //   278	295	168	android/database/sqlite/SQLiteException
    //   278	295	163	finally
    //   357	368	416	finally
    //   368	387	416	finally
    //   440	445	549	finally
    //   488	502	549	finally
    //   509	514	549	finally
  }
  
  @WorkerThread
  public final void resetAnalyticsData() {
    super.zzo();
    super.zzq();
    try {
      int i = getWritableDatabase().delete("messages", null, null) + 0;
      if (i > 0)
        super.zzad().zzdi().zza("Reset local analytics data. records", Integer.valueOf(i)); 
      return;
    } catch (SQLiteException sQLiteException) {
      super.zzad().zzda().zza("Error resetting local analytics data. error", sQLiteException);
      return;
    } 
  }
  
  public final boolean zza(zzaj paramzzaj) {
    Parcel parcel = Parcel.obtain();
    paramzzaj.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    if (arrayOfByte.length > 131072) {
      super.zzad().zzdd().zzaq("Event is too long for local database. Sending event directly to service");
      return false;
    } 
    return zza(0, arrayOfByte);
  }
  
  public final boolean zza(zzga paramzzga) {
    Parcel parcel = Parcel.obtain();
    paramzzga.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    if (arrayOfByte.length > 131072) {
      super.zzad().zzdd().zzaq("User property too long for local database. Sending directly to service");
      return false;
    } 
    return zza(1, arrayOfByte);
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  public final List<AbstractSafeParcelable> zzc(int paramInt) {
    super.zzq();
    super.zzo();
    if (this.zzjk)
      return null; 
    ArrayList<AbstractSafeParcelable> arrayList = new ArrayList();
    if (!super.getContext().getDatabasePath("google_app_measurement_local.db").exists())
      return arrayList; 
    byte b = 0;
    paramInt = 5;
    label186: while (true) {
      Parcel parcel = null;
      SQLiteFullException sQLiteFullException = null;
      if (b < 5)
        try {
          String str1;
          String str3;
          SQLiteDatabase sQLiteDatabase1 = getWritableDatabase();
          SQLiteDatabase sQLiteDatabase3 = sQLiteDatabase1;
          if (sQLiteDatabase3 == null) {
            SQLiteFullException sQLiteFullException2;
            SQLiteDatabase sQLiteDatabase = sQLiteDatabase3;
            try {
              return null;
            } catch (SQLiteFullException sQLiteFullException1) {
            
            } catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
            
            } catch (SQLiteException sQLiteException) {
              sQLiteFullException1 = null;
            } finally {
              sQLiteFullException = null;
              SQLiteException sQLiteException1 = sQLiteException;
              sQLiteDatabase3 = sQLiteDatabase;
            } 
          } 
          try {
            Cursor cursor;
            String str5;
            sQLiteDatabase3.beginTransaction();
            String str6 = Integer.toString(100);
            SQLiteDatabase sQLiteDatabase = sQLiteDatabase3;
            try {
              break;
            } catch (SQLiteFullException sQLiteFullException1) {
            
            } catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
            
            } catch (SQLiteException sQLiteException2) {
            
            } finally {
              cursor = null;
              SQLiteDatabaseLockedException sQLiteDatabaseLockedException1 = sQLiteDatabaseLockedException;
              str6 = null;
              Cursor cursor1 = cursor;
              str5 = str6;
            } 
            str3 = str5;
            sQLiteDatabaseLockedException = null;
            continue;
          } catch (SQLiteFullException sQLiteFullException1) {
          
          } catch (SQLiteException sQLiteException) {
            str1 = str3;
          } finally {}
        } catch (SQLiteFullException sQLiteFullException1) {
        
        } catch (SQLiteDatabaseLockedException sQLiteDatabaseLockedException) {
        
        } catch (SQLiteException sQLiteException2) {
        
        } finally {
          Exception exception2 = null;
          Object object = null;
          Exception exception3 = null;
          Exception exception1 = exception2;
          exception2 = exception3;
        }  
      super.zzad().zzdd().zzaq("Failed to read events from database in reasonable time");
      return null;
    } 
  }
  
  public final boolean zzc(zzr paramzzr) {
    super.zzab();
    byte[] arrayOfByte = zzgd.zza((Parcelable)paramzzr);
    if (arrayOfByte.length > 131072) {
      super.zzad().zzdd().zzaq("Conditional user property too long for local database. Sending directly to service");
      return false;
    } 
    return zza(2, arrayOfByte);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */