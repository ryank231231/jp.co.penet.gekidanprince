package com.google.android.gms.internal.clearcut;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzei<K extends Comparable<K>, V> extends AbstractMap<K, V> {
  private boolean zzgu;
  
  private final int zzol;
  
  private List<zzep> zzom;
  
  private Map<K, V> zzon;
  
  private volatile zzer zzoo;
  
  private Map<K, V> zzop;
  
  private volatile zzel zzoq;
  
  private zzei(int paramInt) {
    this.zzol = paramInt;
    this.zzom = Collections.emptyList();
    this.zzon = Collections.emptyMap();
    this.zzop = Collections.emptyMap();
  }
  
  private final int zza(K paramK) {
    int i = this.zzom.size() - 1;
    if (i >= 0) {
      int k = paramK.compareTo((Comparable)((zzep)this.zzom.get(i)).getKey());
      if (k > 0)
        return -(i + 2); 
      if (k == 0)
        return i; 
    } 
    int j = 0;
    while (j <= i) {
      int k = (j + i) / 2;
      int m = paramK.compareTo((Comparable)((zzep)this.zzom.get(k)).getKey());
      if (m < 0) {
        i = k - 1;
        continue;
      } 
      if (m > 0) {
        j = k + 1;
        continue;
      } 
      return k;
    } 
    return -(j + 1);
  }
  
  static <FieldDescriptorType extends zzca<FieldDescriptorType>> zzei<FieldDescriptorType, Object> zzaj(int paramInt) {
    return new zzej(paramInt);
  }
  
  private final V zzal(int paramInt) {
    zzdu();
    V v = ((zzep)this.zzom.remove(paramInt)).getValue();
    if (!this.zzon.isEmpty()) {
      Iterator<Map.Entry<K, V>> iterator = zzdv().entrySet().iterator();
      this.zzom.add(new zzep(this, iterator.next()));
      iterator.remove();
    } 
    return v;
  }
  
  private final void zzdu() {
    if (!this.zzgu)
      return; 
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzdv() {
    zzdu();
    if (this.zzon.isEmpty() && !(this.zzon instanceof TreeMap)) {
      this.zzon = new TreeMap<K, V>();
      this.zzop = ((TreeMap<K, V>)this.zzon).descendingMap();
    } 
    return (SortedMap<K, V>)this.zzon;
  }
  
  public void clear() {
    zzdu();
    if (!this.zzom.isEmpty())
      this.zzom.clear(); 
    if (!this.zzon.isEmpty())
      this.zzon.clear(); 
  }
  
  public boolean containsKey(Object paramObject) {
    paramObject = paramObject;
    return (zza((K)paramObject) >= 0 || this.zzon.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    if (this.zzoo == null)
      this.zzoo = new zzer(this, null); 
    return this.zzoo;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzei))
      return super.equals(paramObject); 
    paramObject = paramObject;
    int i = size();
    if (i != paramObject.size())
      return false; 
    int j = zzdr();
    if (j != paramObject.zzdr())
      return entrySet().equals(paramObject.entrySet()); 
    for (byte b = 0; b < j; b++) {
      if (!zzak(b).equals(paramObject.zzak(b)))
        return false; 
    } 
    return (j != i) ? this.zzon.equals(((zzei)paramObject).zzon) : true;
  }
  
  public V get(Object paramObject) {
    paramObject = paramObject;
    int i = zza((K)paramObject);
    return (i >= 0) ? ((zzep)this.zzom.get(i)).getValue() : this.zzon.get(paramObject);
  }
  
  public int hashCode() {
    int i = zzdr();
    int j = 0;
    int k = 0;
    while (j < i) {
      k += ((zzep)this.zzom.get(j)).hashCode();
      j++;
    } 
    j = k;
    if (this.zzon.size() > 0)
      j = k + this.zzon.hashCode(); 
    return j;
  }
  
  public final boolean isImmutable() {
    return this.zzgu;
  }
  
  public V remove(Object paramObject) {
    zzdu();
    paramObject = paramObject;
    int i = zza((K)paramObject);
    return (i >= 0) ? zzal(i) : (this.zzon.isEmpty() ? null : this.zzon.remove(paramObject));
  }
  
  public int size() {
    return this.zzom.size() + this.zzon.size();
  }
  
  public final V zza(K paramK, V paramV) {
    zzdu();
    int i = zza(paramK);
    if (i >= 0)
      return ((zzep)this.zzom.get(i)).setValue(paramV); 
    zzdu();
    if (this.zzom.isEmpty() && !(this.zzom instanceof ArrayList))
      this.zzom = new ArrayList<zzep>(this.zzol); 
    int j = -(i + 1);
    if (j >= this.zzol)
      return zzdv().put(paramK, paramV); 
    i = this.zzom.size();
    int k = this.zzol;
    if (i == k) {
      zzep zzep = this.zzom.remove(k - 1);
      zzdv().put((K)zzep.getKey(), zzep.getValue());
    } 
    this.zzom.add(j, new zzep(this, paramK, paramV));
    return null;
  }
  
  public final Map.Entry<K, V> zzak(int paramInt) {
    return this.zzom.get(paramInt);
  }
  
  public final int zzdr() {
    return this.zzom.size();
  }
  
  public final Iterable<Map.Entry<K, V>> zzds() {
    return this.zzon.isEmpty() ? zzem.zzdx() : this.zzon.entrySet();
  }
  
  final Set<Map.Entry<K, V>> zzdt() {
    if (this.zzoq == null)
      this.zzoq = new zzel(this, null); 
    return this.zzoq;
  }
  
  public void zzv() {
    if (!this.zzgu) {
      Map<?, ?> map;
      if (this.zzon.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.zzon);
      } 
      this.zzon = (Map)map;
      if (this.zzop.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.zzop);
      } 
      this.zzop = (Map)map;
      this.zzgu = true;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */