package com.google.android.gms.internal.clearcut;

public class zzcv {
  private static final zzbt zzez = zzbt.zzan();
  
  private zzbb zzln;
  
  private volatile zzdo zzlo;
  
  private volatile zzbb zzlp;
  
  private final zzdo zzh(zzdo paramzzdo) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   4: ifnonnull -> 57
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   13: ifnull -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: goto -> 57
    //   21: aload_0
    //   22: aload_1
    //   23: putfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   26: aload_0
    //   27: getstatic com/google/android/gms/internal/clearcut/zzbb.zzfi : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   30: putfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   33: goto -> 16
    //   36: astore_2
    //   37: aload_0
    //   38: aload_1
    //   39: putfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   42: aload_0
    //   43: getstatic com/google/android/gms/internal/clearcut/zzbb.zzfi : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   46: putfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   49: goto -> 16
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: getfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   61: areturn
    // Exception table:
    //   from	to	target	type
    //   9	16	52	finally
    //   16	18	52	finally
    //   21	33	36	com/google/android/gms/internal/clearcut/zzco
    //   21	33	52	finally
    //   37	49	52	finally
    //   53	55	52	finally
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzcv))
      return false; 
    zzcv zzcv1 = (zzcv)paramObject;
    paramObject = this.zzlo;
    zzdo zzdo1 = zzcv1.zzlo;
    return (paramObject == null && zzdo1 == null) ? zzr().equals(zzcv1.zzr()) : ((paramObject != null && zzdo1 != null) ? paramObject.equals(zzdo1) : ((paramObject != null) ? paramObject.equals(zzcv1.zzh(paramObject.zzbe())) : zzh(zzdo1.zzbe()).equals(zzdo1)));
  }
  
  public int hashCode() {
    return 1;
  }
  
  public final int zzas() {
    return (this.zzlp != null) ? this.zzlp.size() : ((this.zzlo != null) ? this.zzlo.zzas() : 0);
  }
  
  public final zzdo zzi(zzdo paramzzdo) {
    zzdo zzdo1 = this.zzlo;
    this.zzln = null;
    this.zzlp = null;
    this.zzlo = paramzzdo;
    return zzdo1;
  }
  
  public final zzbb zzr() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   4: ifnull -> 12
    //   7: aload_0
    //   8: getfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   11: areturn
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   18: ifnull -> 30
    //   21: aload_0
    //   22: getfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   34: ifnonnull -> 49
    //   37: getstatic com/google/android/gms/internal/clearcut/zzbb.zzfi : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   40: astore_1
    //   41: aload_0
    //   42: aload_1
    //   43: putfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   46: goto -> 62
    //   49: aload_0
    //   50: getfield zzlo : Lcom/google/android/gms/internal/clearcut/zzdo;
    //   53: invokeinterface zzr : ()Lcom/google/android/gms/internal/clearcut/zzbb;
    //   58: astore_1
    //   59: goto -> 41
    //   62: aload_0
    //   63: getfield zzlp : Lcom/google/android/gms/internal/clearcut/zzbb;
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   14	28	71	finally
    //   30	41	71	finally
    //   41	46	71	finally
    //   49	59	71	finally
    //   62	69	71	finally
    //   72	74	71	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzcv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */