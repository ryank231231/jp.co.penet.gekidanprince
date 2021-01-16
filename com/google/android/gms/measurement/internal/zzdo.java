package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzdo implements Runnable {
  zzdo(zzdd paramzzdd, AtomicReference paramAtomicReference) {}
  
  public final void run() {
    AtomicReference atomicReference = this.zzpl;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/atomic/AtomicReference}, name=null} */
    try {
      this.zzpl.set(this.zzpm.zzaf().zzq(this.zzpm.zzt().zzan()));
    } finally {
      this.zzpl.notify();
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/concurrent/atomic/AtomicReference}, name=null} */
    throw SYNTHETIC_LOCAL_VARIABLE_2;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */