package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzhj implements Iterator<Map.Entry<K, V>> {
  private int pos = -1;
  
  private Iterator<Map.Entry<K, V>> zzakh;
  
  private boolean zzakm;
  
  private zzhj(zzhb paramzzhb) {}
  
  private final Iterator<Map.Entry<K, V>> zzon() {
    if (this.zzakh == null)
      this.zzakh = zzhb.zzc(this.zzaki).entrySet().iterator(); 
    return this.zzakh;
  }
  
  public final boolean hasNext() {
    return (this.pos + 1 < zzhb.zzb(this.zzaki).size() || (!zzhb.zzc(this.zzaki).isEmpty() && zzon().hasNext()));
  }
  
  public final void remove() {
    if (this.zzakm) {
      this.zzakm = false;
      zzhb.zza(this.zzaki);
      if (this.pos < zzhb.zzb(this.zzaki).size()) {
        zzhb zzhb1 = this.zzaki;
        int i = this.pos;
        this.pos = i - 1;
        zzhb.zza(zzhb1, i);
        return;
      } 
      zzon().remove();
      return;
    } 
    throw new IllegalStateException("remove() was called before next()");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */