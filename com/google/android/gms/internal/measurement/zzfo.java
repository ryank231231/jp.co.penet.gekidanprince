package com.google.android.gms.internal.measurement;

public class zzfo {
  private static final zzem zzabo = zzem.zzls();
  
  private zzdp zzaie;
  
  private volatile zzgh zzaif;
  
  private volatile zzdp zzaig;
  
  private final zzgh zzh(zzgh paramzzgh) {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   4: ifnonnull -> 59
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   13: ifnull -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: goto -> 59
    //   21: aload_0
    //   22: aload_1
    //   23: putfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   26: aload_0
    //   27: getstatic com/google/android/gms/internal/measurement/zzdp.zzaby : Lcom/google/android/gms/internal/measurement/zzdp;
    //   30: putfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   33: goto -> 49
    //   36: astore_2
    //   37: aload_0
    //   38: aload_1
    //   39: putfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   42: aload_0
    //   43: getstatic com/google/android/gms/internal/measurement/zzdp.zzaby : Lcom/google/android/gms/internal/measurement/zzdp;
    //   46: putfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   49: aload_0
    //   50: monitorexit
    //   51: goto -> 59
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: aload_0
    //   60: getfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   63: areturn
    // Exception table:
    //   from	to	target	type
    //   9	18	54	finally
    //   21	33	36	com/google/android/gms/internal/measurement/zzfh
    //   21	33	54	finally
    //   37	49	54	finally
    //   49	51	54	finally
    //   55	57	54	finally
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzfo))
      return false; 
    paramObject = paramObject;
    zzgh zzgh1 = this.zzaif;
    zzgh zzgh2 = ((zzfo)paramObject).zzaif;
    return (zzgh1 == null && zzgh2 == null) ? zzjv().equals(paramObject.zzjv()) : ((zzgh1 != null && zzgh2 != null) ? zzgh1.equals(zzgh2) : ((zzgh1 != null) ? zzgh1.equals(paramObject.zzh(zzgh1.zzmm())) : zzh(zzgh2.zzmm()).equals(zzgh2)));
  }
  
  public int hashCode() {
    return 1;
  }
  
  public final zzgh zzi(zzgh paramzzgh) {
    zzgh zzgh1 = this.zzaif;
    this.zzaie = null;
    this.zzaig = null;
    this.zzaif = paramzzgh;
    return zzgh1;
  }
  
  public final zzdp zzjv() {
    // Byte code:
    //   0: aload_0
    //   1: getfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   4: ifnull -> 12
    //   7: aload_0
    //   8: getfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   11: areturn
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   18: ifnull -> 30
    //   21: aload_0
    //   22: getfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: getfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   34: ifnonnull -> 47
    //   37: aload_0
    //   38: getstatic com/google/android/gms/internal/measurement/zzdp.zzaby : Lcom/google/android/gms/internal/measurement/zzdp;
    //   41: putfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   44: goto -> 60
    //   47: aload_0
    //   48: aload_0
    //   49: getfield zzaif : Lcom/google/android/gms/internal/measurement/zzgh;
    //   52: invokeinterface zzjv : ()Lcom/google/android/gms/internal/measurement/zzdp;
    //   57: putfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   60: aload_0
    //   61: getfield zzaig : Lcom/google/android/gms/internal/measurement/zzdp;
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   14	28	69	finally
    //   30	44	69	finally
    //   47	60	69	finally
    //   60	67	69	finally
    //   70	72	69	finally
  }
  
  public final int zzly() {
    return (this.zzaig != null) ? this.zzaig.size() : ((this.zzaif != null) ? this.zzaif.zzly() : 0);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */