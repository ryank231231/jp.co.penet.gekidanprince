package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzi {
  private final ConcurrentHashMap<zzj, List<Throwable>> zzg = new ConcurrentHashMap<zzj, List<Throwable>>(16, 0.75F, 10);
  
  private final ReferenceQueue<Throwable> zzh = new ReferenceQueue<Throwable>();
  
  public final List<Throwable> zza(Throwable paramThrowable, boolean paramBoolean) {
    Reference<? extends Throwable> reference;
    for (reference = this.zzh.poll(); reference != null; reference = this.zzh.poll())
      this.zzg.remove(reference); 
    reference = new zzj(paramThrowable, null);
    List<Throwable> list2 = this.zzg.get(reference);
    if (list2 != null)
      return list2; 
    list2 = new Vector<Throwable>(2);
    List<Throwable> list1 = this.zzg.putIfAbsent(new zzj(paramThrowable, this.zzh), list2);
    return (list1 == null) ? list2 : list1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\firebase_messaging\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */