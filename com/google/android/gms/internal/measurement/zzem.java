package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;

public class zzem {
  private static volatile boolean zzadj = false;
  
  private static final Class<?> zzadk = zzlr();
  
  private static volatile zzem zzadl;
  
  static final zzem zzadm = new zzem(true);
  
  private final Map<zza, zzez.zzd<?, ?>> zzadn = new HashMap<zza, zzez.zzd<?, ?>>();
  
  zzem() {}
  
  private zzem(boolean paramBoolean) {}
  
  static zzem zzlq() {
    return zzex.zza(zzem.class);
  }
  
  private static Class<?> zzlr() {
    try {
      return Class.forName("com.google.protobuf.Extension");
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  public static zzem zzls() {
    return zzel.zzlp();
  }
  
  public static zzem zzlt() {
    // Byte code:
    //   0: getstatic com/google/android/gms/internal/measurement/zzem.zzadl : Lcom/google/android/gms/internal/measurement/zzem;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 43
    //   10: ldc com/google/android/gms/internal/measurement/zzem
    //   12: monitorenter
    //   13: getstatic com/google/android/gms/internal/measurement/zzem.zzadl : Lcom/google/android/gms/internal/measurement/zzem;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 31
    //   23: invokestatic zzlq : ()Lcom/google/android/gms/internal/measurement/zzem;
    //   26: astore_1
    //   27: aload_1
    //   28: putstatic com/google/android/gms/internal/measurement/zzem.zzadl : Lcom/google/android/gms/internal/measurement/zzem;
    //   31: ldc com/google/android/gms/internal/measurement/zzem
    //   33: monitorexit
    //   34: goto -> 43
    //   37: astore_1
    //   38: ldc com/google/android/gms/internal/measurement/zzem
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    //   43: aload_1
    //   44: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	37	finally
    //   23	31	37	finally
    //   31	34	37	finally
    //   38	41	37	finally
  }
  
  public final <ContainingType extends zzgh> zzez.zzd<ContainingType, ?> zza(ContainingType paramContainingType, int paramInt) {
    return (zzez.zzd<ContainingType, ?>)this.zzadn.get(new zza(paramContainingType, paramInt));
  }
  
  static final class zza {
    private final int number;
    
    private final Object object;
    
    zza(Object param1Object, int param1Int) {
      this.object = param1Object;
      this.number = param1Int;
    }
    
    public final boolean equals(Object param1Object) {
      if (!(param1Object instanceof zza))
        return false; 
      param1Object = param1Object;
      return (this.object == ((zza)param1Object).object && this.number == ((zza)param1Object).number);
    }
    
    public final int hashCode() {
      return System.identityHashCode(this.object) * 65535 + this.number;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */