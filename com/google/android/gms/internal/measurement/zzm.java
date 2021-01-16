package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class zzm extends zzr {
  private final AtomicReference<Bundle> zzr = new AtomicReference<Bundle>();
  
  private boolean zzs;
  
  static <T> T zza(Bundle paramBundle, Class<T> paramClass) {
    if (paramBundle != null) {
      Object object = paramBundle.get("r");
      if (object != null)
        try {
          return paramClass.cast(object);
        } catch (ClassCastException classCastException) {
          String str = paramClass.getCanonicalName();
          object = object.getClass().getCanonicalName();
          Log.w("AM", String.format(String.valueOf("Unexpected object type. Expected, Received").concat(": %s, %s"), new Object[] { str, object }), classCastException);
          throw classCastException;
        }  
      return null;
    } 
    return null;
  }
  
  final String zza(long paramLong) {
    return zza(zzb(paramLong), String.class);
  }
  
  final Bundle zzb(long paramLong) {
    synchronized (this.zzr) {
      boolean bool = this.zzs;
      if (!bool)
        try {
          this.zzr.wait(paramLong);
        } catch (InterruptedException interruptedException) {
          return null;
        }  
      return this.zzr.get();
    } 
  }
  
  public final void zzb(Bundle paramBundle) {
    AtomicReference<Bundle> atomicReference = this.zzr;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/atomic/AtomicReference<ObjectType{android/os/Bundle}>}, name=null} */
    try {
      this.zzr.set(paramBundle);
      this.zzs = true;
    } finally {
      this.zzr.notify();
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/atomic/AtomicReference<ObjectType{android/os/Bundle}>}, name=null} */
    throw paramBundle;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */