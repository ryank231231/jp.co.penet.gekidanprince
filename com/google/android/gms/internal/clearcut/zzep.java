package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class zzep implements Comparable<zzep>, Map.Entry<K, V> {
  private V value;
  
  private final K zzov;
  
  zzep(zzei paramzzei, K paramK, V paramV) {
    this.zzov = paramK;
    this.value = paramV;
  }
  
  zzep(zzei paramzzei, Map.Entry<K, V> paramEntry) {
    this(paramzzei, paramEntry.getKey(), paramEntry.getValue());
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
    return (equals(this.zzov, paramObject.getKey()) && equals(this.value, paramObject.getValue()));
  }
  
  public final V getValue() {
    return this.value;
  }
  
  public final int hashCode() {
    int j;
    K k = this.zzov;
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
    zzei.zza(this.zzos);
    V v = this.value;
    this.value = paramV;
    return v;
  }
  
  public final String toString() {
    String str1 = String.valueOf(this.zzov);
    String str2 = String.valueOf(this.value);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
    stringBuilder.append(str1);
    stringBuilder.append("=");
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */