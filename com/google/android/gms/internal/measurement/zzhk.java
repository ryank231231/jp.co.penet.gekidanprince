package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzhk extends AbstractSet<Map.Entry<K, V>> {
  private zzhk(zzhb paramzzhb) {}
  
  public void clear() {
    this.zzaki.clear();
  }
  
  public boolean contains(Object paramObject) {
    Map.Entry entry = (Map.Entry)paramObject;
    paramObject = this.zzaki.get(entry.getKey());
    entry = (Map.Entry)entry.getValue();
    return (paramObject == entry || (paramObject != null && paramObject.equals(entry)));
  }
  
  public Iterator<Map.Entry<K, V>> iterator() {
    return new zzhj(this.zzaki, null);
  }
  
  public boolean remove(Object paramObject) {
    paramObject = paramObject;
    if (contains(paramObject)) {
      this.zzaki.remove(paramObject.getKey());
      return true;
    } 
    return false;
  }
  
  public int size() {
    return this.zzaki.size();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */