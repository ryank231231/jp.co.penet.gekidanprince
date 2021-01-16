package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class zzct<K> implements Map.Entry<K, Object> {
  private Map.Entry<K, zzcr> zzll;
  
  private zzct(Map.Entry<K, zzcr> paramEntry) {
    this.zzll = paramEntry;
  }
  
  public final K getKey() {
    return this.zzll.getKey();
  }
  
  public final Object getValue() {
    return ((zzcr)this.zzll.getValue() == null) ? null : zzcr.zzbr();
  }
  
  public final Object setValue(Object paramObject) {
    if (paramObject instanceof zzdo)
      return ((zzcr)this.zzll.getValue()).zzi((zzdo)paramObject); 
    throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
  }
  
  public final zzcr zzbs() {
    return this.zzll.getValue();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */