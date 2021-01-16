package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzj extends WeakReference<Throwable> {
  private final int zzi;
  
  public zzj(Throwable paramThrowable, ReferenceQueue<Throwable> paramReferenceQueue) {
    super(paramThrowable, paramReferenceQueue);
    if (paramThrowable != null) {
      this.zzi = System.identityHashCode(paramThrowable);
      return;
    } 
    throw new NullPointerException("The referent cannot be null");
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null || paramObject.getClass() != getClass())
      return false; 
    if (this == paramObject)
      return true; 
    paramObject = paramObject;
    return (this.zzi == ((zzj)paramObject).zzi && get() == paramObject.get());
  }
  
  public final int hashCode() {
    return this.zzi;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */