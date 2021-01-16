package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzhi implements Comparable<zzhi>, Map.Entry<K, V> {
  private V value;
  
  private final K zzakl;
  
  zzhi(zzhb paramzzhb, K paramK, V paramV) {
    this.zzakl = paramK;
    this.value = paramV;
  }
  
  zzhi(zzhb paramzzhb, Map.Entry<K, V> paramEntry) {
    this(paramzzhb, paramEntry.getKey(), paramEntry.getValue());
  }
  
  private static boolean equals(Object paramObject1, Object paramObject2) {
    return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof Map.Entry))
      return false; 
    paramObject = paramObject;
    return (equals(this.zzakl, paramObject.getKey()) && equals(this.value, paramObject.getValue()));
  }
  
  public final V getValue() {
    return this.value;
  }
  
  public final int hashCode() {
    int j;
    K k = this.zzakl;
    int i = 0;
    if (k == null) {
      j = 0;
    } else {
      j = k.hashCode();
    } 
    V v = this.value;
    if (v != null)
      i = v.hashCode(); 
    return j ^ i;
  }
  
  public final V setValue(V paramV) {
    zzhb.zza(this.zzaki);
    V v = this.value;
    this.value = paramV;
    return v;
  }
  
  public final String toString() {
    String str1 = String.valueOf(this.zzakl);
    String str2 = String.valueOf(this.value);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    stringBuilder.append(str1);
    stringBuilder.append("=");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */