package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzhb<K extends Comparable<K>, V> extends AbstractMap<K, V> {
  private boolean zzadr;
  
  private final int zzakb;
  
  private List<zzhi> zzakc;
  
  private Map<K, V> zzakd;
  
  private volatile zzhk zzake;
  
  private Map<K, V> zzakf;
  
  private volatile zzhe zzakg;
  
  private zzhb(int paramInt) {
    this.zzakb = paramInt;
    this.zzakc = Collections.emptyList();
    this.zzakd = Collections.emptyMap();
    this.zzakf = Collections.emptyMap();
  }
  
  private final int zza(K paramK) {
    int i = this.zzakc.size() - 1;
    if (i >= 0) {
      int k = paramK.compareTo((Comparable)((zzhi)this.zzakc.get(i)).getKey());
      if (k > 0)
        return -(i + 2); 
      if (k == 0)
        return i; 
    } 
    int j = 0;
    while (j <= i) {
      int k = (j + i) / 2;
      int m = paramK.compareTo((Comparable)((zzhi)this.zzakc.get(k)).getKey());
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
  
  static <FieldDescriptorType extends zzes<FieldDescriptorType>> zzhb<FieldDescriptorType, Object> zzbe(int paramInt) {
    return new zzhc(paramInt);
  }
  
  private final V zzbg(int paramInt) {
    zzol();
    V v = ((zzhi)this.zzakc.remove(paramInt)).getValue();
    if (!this.zzakd.isEmpty()) {
      Iterator<Map.Entry<K, V>> iterator = zzom().entrySet().iterator();
      this.zzakc.add(new zzhi(this, iterator.next()));
      iterator.remove();
    } 
    return v;
  }
  
  private final void zzol() {
    if (!this.zzadr)
      return; 
    throw new UnsupportedOperationException();
  }
  
  private final SortedMap<K, V> zzom() {
    zzol();
    if (this.zzakd.isEmpty() && !(this.zzakd instanceof TreeMap)) {
      this.zzakd = new TreeMap<K, V>();
      this.zzakf = ((TreeMap<K, V>)this.zzakd).descendingMap();
    } 
    return (SortedMap<K, V>)this.zzakd;
  }
  
  public void clear() {
    zzol();
    if (!this.zzakc.isEmpty())
      this.zzakc.clear(); 
    if (!this.zzakd.isEmpty())
      this.zzakd.clear(); 
  }
  
  public boolean containsKey(Object paramObject) {
    paramObject = paramObject;
    return (zza((K)paramObject) >= 0 || this.zzakd.containsKey(paramObject));
  }
  
  public Set<Map.Entry<K, V>> entrySet() {
    if (this.zzake == null)
      this.zzake = new zzhk(this, null); 
    return this.zzake;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzhb))
      return super.equals(paramObject); 
    paramObject = paramObject;
    int i = size();
    if (i != paramObject.size())
      return false; 
    int j = zzoi();
    if (j != paramObject.zzoi())
      return entrySet().equals(paramObject.entrySet()); 
    for (byte b = 0; b < j; b++) {
      if (!zzbf(b).equals(paramObject.zzbf(b)))
        return false; 
    } 
    return (j != i) ? this.zzakd.equals(((zzhb)paramObject).zzakd) : true;
  }
  
  public V get(Object paramObject) {
    paramObject = paramObject;
    int i = zza((K)paramObject);
    return (i >= 0) ? ((zzhi)this.zzakc.get(i)).getValue() : this.zzakd.get(paramObject);
  }
  
  public int hashCode() {
    int i = zzoi();
    int j = 0;
    int k = 0;
    while (j < i) {
      k += ((zzhi)this.zzakc.get(j)).hashCode();
      j++;
    } 
    j = k;
    if (this.zzakd.size() > 0)
      j = k + this.zzakd.hashCode(); 
    return j;
  }
  
  public final boolean isImmutable() {
    return this.zzadr;
  }
  
  public V remove(Object paramObject) {
    zzol();
    paramObject = paramObject;
    int i = zza((K)paramObject);
    return (i >= 0) ? zzbg(i) : (this.zzakd.isEmpty() ? null : this.zzakd.remove(paramObject));
  }
  
  public int size() {
    return this.zzakc.size() + this.zzakd.size();
  }
  
  public final V zza(K paramK, V paramV) {
    zzol();
    int i = zza(paramK);
    if (i >= 0)
      return ((zzhi)this.zzakc.get(i)).setValue(paramV); 
    zzol();
    if (this.zzakc.isEmpty() && !(this.zzakc instanceof ArrayList))
      this.zzakc = new ArrayList<zzhi>(this.zzakb); 
    int j = -(i + 1);
    if (j >= this.zzakb)
      return zzom().put(paramK, paramV); 
    int k = this.zzakc.size();
    i = this.zzakb;
    if (k == i) {
      zzhi zzhi = this.zzakc.remove(i - 1);
      zzom().put((K)zzhi.getKey(), zzhi.getValue());
    } 
    this.zzakc.add(j, new zzhi(this, paramK, paramV));
    return null;
  }
  
  public final Map.Entry<K, V> zzbf(int paramInt) {
    return this.zzakc.get(paramInt);
  }
  
  public void zzjz() {
    if (!this.zzadr) {
      Map<?, ?> map;
      if (this.zzakd.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.zzakd);
      } 
      this.zzakd = (Map)map;
      if (this.zzakf.isEmpty()) {
        map = Collections.emptyMap();
      } else {
        map = Collections.unmodifiableMap(this.zzakf);
      } 
      this.zzakf = (Map)map;
      this.zzadr = true;
    } 
  }
  
  public final int zzoi() {
    return this.zzakc.size();
  }
  
  public final Iterable<Map.Entry<K, V>> zzoj() {
    return this.zzakd.isEmpty() ? zzhf.zzoo() : this.zzakd.entrySet();
  }
  
  final Set<Map.Entry<K, V>> zzok() {
    if (this.zzakg == null)
      this.zzakg = new zzhe(this, null); 
    return this.zzakg;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */