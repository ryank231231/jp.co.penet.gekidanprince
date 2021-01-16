package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzau extends zzcu {
  private char zzjp = (char)Character.MIN_VALUE;
  
  @GuardedBy("this")
  private String zzjq;
  
  private final zzaw zzjr = new zzaw(this, 6, false, false);
  
  private final zzaw zzjs = new zzaw(this, 6, true, false);
  
  private final zzaw zzjt = new zzaw(this, 6, false, true);
  
  private final zzaw zzju = new zzaw(this, 5, false, false);
  
  private final zzaw zzjv = new zzaw(this, 5, true, false);
  
  private final zzaw zzjw = new zzaw(this, 5, false, true);
  
  private final zzaw zzjx = new zzaw(this, 4, false, false);
  
  private final zzaw zzjy = new zzaw(this, 3, false, false);
  
  private final zzaw zzjz = new zzaw(this, 2, false, false);
  
  private long zzt = -1L;
  
  zzau(zzby paramzzby) {
    super(paramzzby);
  }
  
  @VisibleForTesting
  private static String zza(boolean paramBoolean, Object paramObject) {
    if (paramObject == null)
      return ""; 
    Object object = paramObject;
    if (paramObject instanceof Integer)
      object = Long.valueOf(((Integer)paramObject).intValue()); 
    boolean bool = object instanceof Long;
    byte b = 0;
    if (bool) {
      if (!paramBoolean)
        return String.valueOf(object); 
      Long long_ = (Long)object;
      if (Math.abs(long_.longValue()) < 100L)
        return String.valueOf(object); 
      if (String.valueOf(object).charAt(0) == '-') {
        paramObject = "-";
      } else {
        paramObject = "";
      } 
      object = String.valueOf(Math.abs(long_.longValue()));
      long l1 = Math.round(Math.pow(10.0D, (object.length() - 1)));
      long l2 = Math.round(Math.pow(10.0D, object.length()) - 1.0D);
      object = new StringBuilder(String.valueOf(paramObject).length() + 43 + String.valueOf(paramObject).length());
      object.append((String)paramObject);
      object.append(l1);
      object.append("...");
      object.append((String)paramObject);
      object.append(l2);
      return object.toString();
    } 
    if (object instanceof Boolean)
      return String.valueOf(object); 
    if (object instanceof Throwable) {
      object = object;
      if (paramBoolean) {
        paramObject = object.getClass().getName();
      } else {
        paramObject = object.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder((String)paramObject);
      paramObject = zzap(zzby.class.getCanonicalName());
      StackTraceElement[] arrayOfStackTraceElement = object.getStackTrace();
      int i = arrayOfStackTraceElement.length;
      while (b < i) {
        object = arrayOfStackTraceElement[b];
        if (!object.isNativeMethod()) {
          String str = object.getClassName();
          if (str != null && zzap(str).equals(paramObject)) {
            stringBuilder.append(": ");
            stringBuilder.append(object);
            break;
          } 
        } 
        b++;
      } 
      return stringBuilder.toString();
    } 
    return (object instanceof zzax) ? zzax.zza((zzax)object) : (paramBoolean ? "-" : String.valueOf(object));
  }
  
  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    String str1 = paramString;
    if (paramString == null)
      str1 = ""; 
    String str2 = zza(paramBoolean, paramObject1);
    String str3 = zza(paramBoolean, paramObject2);
    paramObject2 = zza(paramBoolean, paramObject3);
    paramObject3 = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1)) {
      paramObject3.append(str1);
      paramString = ": ";
    } 
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2)) {
      paramObject3.append(paramString);
      paramObject3.append(str2);
      paramObject1 = ", ";
    } 
    Object object = paramObject1;
    if (!TextUtils.isEmpty(str3)) {
      paramObject3.append((String)paramObject1);
      paramObject3.append(str3);
      object = ", ";
    } 
    if (!TextUtils.isEmpty((CharSequence)paramObject2)) {
      paramObject3.append((String)object);
      paramObject3.append((String)paramObject2);
    } 
    return paramObject3.toString();
  }
  
  protected static Object zzao(String paramString) {
    return (paramString == null) ? null : new zzax(paramString);
  }
  
  private static String zzap(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    int i = paramString.lastIndexOf('.');
    return (i == -1) ? paramString : paramString.substring(0, i);
  }
  
  @VisibleForTesting
  private final String zzdj() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzjq : Ljava/lang/String;
    //   6: ifnonnull -> 40
    //   9: aload_0
    //   10: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   13: invokevirtual zzeo : ()Ljava/lang/String;
    //   16: ifnull -> 33
    //   19: aload_0
    //   20: aload_0
    //   21: getfield zzl : Lcom/google/android/gms/measurement/internal/zzby;
    //   24: invokevirtual zzeo : ()Ljava/lang/String;
    //   27: putfield zzjq : Ljava/lang/String;
    //   30: goto -> 40
    //   33: aload_0
    //   34: invokestatic zzbo : ()Ljava/lang/String;
    //   37: putfield zzjq : Ljava/lang/String;
    //   40: aload_0
    //   41: getfield zzjq : Ljava/lang/String;
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	49	finally
    //   33	40	49	finally
    //   40	47	49	finally
    //   50	52	49	finally
  }
  
  @VisibleForTesting
  protected final boolean isLoggable(int paramInt) {
    return Log.isLoggable(zzdj(), paramInt);
  }
  
  @VisibleForTesting
  protected final void zza(int paramInt, String paramString) {
    Log.println(paramInt, zzdj(), paramString);
  }
  
  protected final void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {
    if (!paramBoolean1 && isLoggable(paramInt))
      zza(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3)); 
    if (!paramBoolean2 && paramInt >= 5) {
      Preconditions.checkNotNull(paramString);
      zzbt zzbt = this.zzl.zzek();
      if (zzbt == null) {
        zza(6, "Scheduler not set. Not logging error/warn");
        return;
      } 
      if (!zzbt.isInitialized()) {
        zza(6, "Scheduler not initialized. Not logging error/warn");
        return;
      } 
      int i = paramInt;
      if (paramInt < 0)
        i = 0; 
      if (i >= 9) {
        paramInt = 8;
      } else {
        paramInt = i;
      } 
      zzbt.zza(new zzav(this, paramInt, paramString, paramObject1, paramObject2, paramObject3));
    } 
  }
  
  protected final boolean zzak() {
    return false;
  }
  
  public final zzaw zzda() {
    return this.zzjr;
  }
  
  public final zzaw zzdb() {
    return this.zzjs;
  }
  
  public final zzaw zzdc() {
    return this.zzjt;
  }
  
  public final zzaw zzdd() {
    return this.zzju;
  }
  
  public final zzaw zzde() {
    return this.zzjv;
  }
  
  public final zzaw zzdf() {
    return this.zzjw;
  }
  
  public final zzaw zzdg() {
    return this.zzjx;
  }
  
  public final zzaw zzdh() {
    return this.zzjy;
  }
  
  public final zzaw zzdi() {
    return this.zzjz;
  }
  
  public final String zzdk() {
    Pair<String, Long> pair = (super.zzae()).zzla.zzeb();
    if (pair == null || pair == zzbf.zzky)
      return null; 
    String str1 = String.valueOf(pair.second);
    String str2 = (String)pair.first;
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    stringBuilder.append(str1);
    stringBuilder.append(":");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */