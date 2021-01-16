package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public abstract class zzcw<T> {
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzno;
  
  private static final Object zzzt = new Object();
  
  private static boolean zzzu;
  
  private static final AtomicInteger zzzx;
  
  private final String name;
  
  private volatile T zzje;
  
  private final zzdc zzzv;
  
  private final T zzzw;
  
  private volatile int zzzy = -1;
  
  static {
    zzno = null;
    zzzu = false;
    zzzx = new AtomicInteger();
  }
  
  private zzcw(zzdc paramzzdc, String paramString, T paramT) {
    if (zzdc.zza(paramzzdc) != null) {
      this.zzzv = paramzzdc;
      this.name = paramString;
      this.zzzw = paramT;
      return;
    } 
    throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
  }
  
  private static zzcw<Double> zza(zzdc paramzzdc, String paramString, double paramDouble) {
    return new zzda(paramzzdc, paramString, Double.valueOf(paramDouble));
  }
  
  private static zzcw<Integer> zza(zzdc paramzzdc, String paramString, int paramInt) {
    return new zzcy(paramzzdc, paramString, Integer.valueOf(paramInt));
  }
  
  private static zzcw<Long> zza(zzdc paramzzdc, String paramString, long paramLong) {
    return new zzcx(paramzzdc, paramString, Long.valueOf(paramLong));
  }
  
  private static zzcw<String> zza(zzdc paramzzdc, String paramString1, String paramString2) {
    return new zzdb(paramzzdc, paramString1, paramString2);
  }
  
  private static zzcw<Boolean> zza(zzdc paramzzdc, String paramString, boolean paramBoolean) {
    return new zzcz(paramzzdc, paramString, Boolean.valueOf(paramBoolean));
  }
  
  private final String zzce(String paramString) {
    if (paramString != null && paramString.isEmpty())
      return this.name; 
    String str = String.valueOf(paramString);
    paramString = String.valueOf(this.name);
    return (paramString.length() != 0) ? str.concat(paramString) : new String(str);
  }
  
  static void zzjp() {
    zzzx.incrementAndGet();
  }
  
  @Nullable
  private final T zzjr() {
    boolean bool;
    zzdc zzdc1 = this.zzzv;
    String str = (String)zzcs.zzp(zzno).zzca("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
    if (str != null && zzci.zzyv.matcher(str).matches()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool) {
      zzdd zzdd;
      if (zzdc.zza(this.zzzv) != null) {
        zzdc zzdc2 = this.zzzv;
        zzcl zzcl = zzcl.zza(zzno.getContentResolver(), zzdc.zza(this.zzzv));
      } else {
        Context context = zzno;
        zzdc zzdc2 = this.zzzv;
        zzdd = zzdd.zze(context, null);
      } 
      if (zzdd != null) {
        Object object = zzdd.zzca(zzjq());
        if (object != null)
          return zzc(object); 
      } 
    } else {
      str = String.valueOf(zzjq());
      if (str.length() != 0) {
        str = "Bypass reading Phenotype values for flag: ".concat(str);
      } else {
        str = new String("Bypass reading Phenotype values for flag: ");
      } 
      Log.w("PhenotypeFlag", str);
    } 
    return null;
  }
  
  @Nullable
  private final T zzjs() {
    zzdc zzdc1 = this.zzzv;
    Object object = zzcs.zzp(zzno).zzca(zzce(zzdc.zzc(this.zzzv)));
    return (object != null) ? zzc(object) : null;
  }
  
  public static void zzq(Context paramContext) {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/measurement/zzcw.zzzt : Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull -> 18
    //   15: goto -> 20
    //   18: aload_2
    //   19: astore_0
    //   20: getstatic com/google/android/gms/internal/measurement/zzcw.zzno : Landroid/content/Context;
    //   23: aload_0
    //   24: if_acmpeq -> 97
    //   27: ldc com/google/android/gms/internal/measurement/zzcl
    //   29: monitorenter
    //   30: getstatic com/google/android/gms/internal/measurement/zzcl.zzzi : Ljava/util/Map;
    //   33: invokeinterface clear : ()V
    //   38: ldc com/google/android/gms/internal/measurement/zzcl
    //   40: monitorexit
    //   41: ldc com/google/android/gms/internal/measurement/zzdd
    //   43: monitorenter
    //   44: getstatic com/google/android/gms/internal/measurement/zzdd.zzaai : Ljava/util/Map;
    //   47: invokeinterface clear : ()V
    //   52: ldc com/google/android/gms/internal/measurement/zzdd
    //   54: monitorexit
    //   55: ldc com/google/android/gms/internal/measurement/zzcs
    //   57: monitorenter
    //   58: aconst_null
    //   59: putstatic com/google/android/gms/internal/measurement/zzcs.zzzq : Lcom/google/android/gms/internal/measurement/zzcs;
    //   62: ldc com/google/android/gms/internal/measurement/zzcs
    //   64: monitorexit
    //   65: getstatic com/google/android/gms/internal/measurement/zzcw.zzzx : Ljava/util/concurrent/atomic/AtomicInteger;
    //   68: invokevirtual incrementAndGet : ()I
    //   71: pop
    //   72: aload_0
    //   73: putstatic com/google/android/gms/internal/measurement/zzcw.zzno : Landroid/content/Context;
    //   76: goto -> 97
    //   79: astore_0
    //   80: ldc com/google/android/gms/internal/measurement/zzcs
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: ldc com/google/android/gms/internal/measurement/zzdd
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: ldc com/google/android/gms/internal/measurement/zzcl
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    //   97: aload_1
    //   98: monitorexit
    //   99: return
    //   100: astore_0
    //   101: aload_1
    //   102: monitorexit
    //   103: aload_0
    //   104: athrow
    // Exception table:
    //   from	to	target	type
    //   6	11	100	finally
    //   20	30	100	finally
    //   30	41	91	finally
    //   41	44	100	finally
    //   44	55	85	finally
    //   55	58	100	finally
    //   58	65	79	finally
    //   65	76	100	finally
    //   80	83	79	finally
    //   83	85	100	finally
    //   86	89	85	finally
    //   89	91	100	finally
    //   92	95	91	finally
    //   95	97	100	finally
    //   97	99	100	finally
    //   101	103	100	finally
  }
  
  public final T get() {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/measurement/zzcw.zzzx : Ljava/util/concurrent/atomic/AtomicInteger;
    //   3: invokevirtual get : ()I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield zzzy : I
    //   11: iload_1
    //   12: if_icmpge -> 101
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield zzzy : I
    //   21: iload_1
    //   22: if_icmpge -> 91
    //   25: getstatic com/google/android/gms/internal/measurement/zzcw.zzno : Landroid/content/Context;
    //   28: ifnull -> 78
    //   31: aload_0
    //   32: getfield zzzv : Lcom/google/android/gms/internal/measurement/zzdc;
    //   35: astore_2
    //   36: aload_0
    //   37: invokespecial zzjr : ()Ljava/lang/Object;
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull -> 48
    //   45: goto -> 65
    //   48: aload_0
    //   49: invokespecial zzjs : ()Ljava/lang/Object;
    //   52: astore_2
    //   53: aload_2
    //   54: ifnull -> 60
    //   57: goto -> 65
    //   60: aload_0
    //   61: getfield zzzw : Ljava/lang/Object;
    //   64: astore_2
    //   65: aload_0
    //   66: aload_2
    //   67: putfield zzje : Ljava/lang/Object;
    //   70: aload_0
    //   71: iload_1
    //   72: putfield zzzy : I
    //   75: goto -> 91
    //   78: new java/lang/IllegalStateException
    //   81: astore_2
    //   82: aload_2
    //   83: ldc_w 'Must call PhenotypeFlag.init() first'
    //   86: invokespecial <init> : (Ljava/lang/String;)V
    //   89: aload_2
    //   90: athrow
    //   91: aload_0
    //   92: monitorexit
    //   93: goto -> 101
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    //   101: aload_0
    //   102: getfield zzje : Ljava/lang/Object;
    //   105: areturn
    // Exception table:
    //   from	to	target	type
    //   17	41	96	finally
    //   48	53	96	finally
    //   60	65	96	finally
    //   65	75	96	finally
    //   78	91	96	finally
    //   91	93	96	finally
    //   97	99	96	finally
  }
  
  public final T getDefaultValue() {
    return this.zzzw;
  }
  
  abstract T zzc(Object paramObject);
  
  public final String zzjq() {
    return zzce(zzdc.zzb(this.zzzv));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */