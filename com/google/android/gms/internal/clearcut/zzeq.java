package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

final class zzeq implements Iterator<Map.Entry<K, V>> {
  private int pos = -1;
  
  private Iterator<Map.Entry<K, V>> zzor;
  
  private boolean zzow;
  
  private zzeq(zzei paramzzei) {}
  
  private final Iterator<Map.Entry<K, V>> zzdw() {
    if (this.zzor == null)
      this.zzor = zzei.zzc(this.zzos).entrySet().iterator(); 
    return this.zzor;
  }
  
  public final boolean hasNext() {
    return (this.pos + 1 < zzei.zzb(this.zzos).size() || (!zzei.zzc(this.zzos).isEmpty() && zzdw().hasNext()));
  }
  
  public final void remove() {
    if (this.zzow) {
      this.zzow = false;
      zzei.zza(this.zzos);
      if (this.pos < zzei.zzb(this.zzos).size()) {
        zzei zzei1 = this.zzos;
        int i = this.pos;
        this.pos = i - 1;
        zzei.zza(zzei1, i);
        return;
      } 
      zzdw().remove();
      return;
    } 
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */