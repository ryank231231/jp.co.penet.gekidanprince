package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzhd implements Iterator<Map.Entry<K, V>> {
  private int pos = zzhb.zzb(this.zzaki).size();
  
  private Iterator<Map.Entry<K, V>> zzakh;
  
  private zzhd(zzhb paramzzhb) {}
  
  private final Iterator<Map.Entry<K, V>> zzon() {
    if (this.zzakh == null)
      this.zzakh = zzhb.zzd(this.zzaki).entrySet().iterator(); 
    return this.zzakh;
  }
  
  public final boolean hasNext() {
    int i = this.pos;
    return ((i > 0 && i <= zzhb.zzb(this.zzaki).size()) || zzon().hasNext());
  }
  
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */