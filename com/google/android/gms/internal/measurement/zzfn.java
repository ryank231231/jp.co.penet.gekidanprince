package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzfn<K> implements Iterator<Map.Entry<K, Object>> {
  private Iterator<Map.Entry<K, Object>> zzaid;
  
  public zzfn(Iterator<Map.Entry<K, Object>> paramIterator) {
    this.zzaid = paramIterator;
  }
  
  public final boolean hasNext() {
    return this.zzaid.hasNext();
  }
  
  public final void remove() {
    this.zzaid.remove();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */