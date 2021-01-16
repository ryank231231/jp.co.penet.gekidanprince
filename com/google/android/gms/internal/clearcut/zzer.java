package com.google.android.gms.internal.clearcut;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzer extends AbstractSet<Map.Entry<K, V>> {
  private zzer(zzei paramzzei) {}
  
  public void clear() {
    this.zzos.clear();
  }
  
  public boolean contains(Object paramObject) {
    Map.Entry entry = (Map.Entry)paramObject;
    paramObject = this.zzos.get(entry.getKey());
    entry = (Map.Entry)entry.getValue();
    return (paramObject == entry || (paramObject != null && paramObject.equals(entry)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator() {
    return new zzeq(this.zzos, null);
  }
  
  public boolean remove(Object paramObject) {
    paramObject = paramObject;
    if (contains(paramObject)) {
      this.zzos.remove(paramObject.getKey());
      return true;
    } 
    return false;
  }
  
  public int size() {
    return this.zzos.size();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */