package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzfm<K> implements Map.Entry<K, Object> {
  private Map.Entry<K, zzfk> zzaic;
  
  private zzfm(Map.Entry<K, zzfk> paramEntry) {
    this.zzaic = paramEntry;
  }
  
  public final K getKey() {
    return this.zzaic.getKey();
  }
  
  public final Object getValue() {
    return ((zzfk)this.zzaic.getValue() == null) ? null : zzfk.zzne();
  }
  
  public final Object setValue(Object paramObject) {
    if (paramObject instanceof zzgh)
      return ((zzfk)this.zzaic.getValue()).zzi((zzgh)paramObject); 
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzfk zznf() {
    return this.zzaic.getValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */