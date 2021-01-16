package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;

abstract class zzdj<E> extends AbstractList<E> implements zzfg<E> {
  private boolean zzabp = true;
  
  public void add(int paramInt, E paramE) {
    zzka();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE) {
    zzka();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
    zzka();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    zzka();
    return super.addAll(paramCollection);
  }
  
  public void clear() {
    zzka();
    super.clear();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof java.util.List))
      return false; 
    if (!(paramObject instanceof java.util.RandomAccess))
      return super.equals(paramObject); 
    paramObject = paramObject;
    int i = size();
    if (i != paramObject.size())
      return false; 
    for (byte b = 0; b < i; b++) {
      if (!get(b).equals(paramObject.get(b)))
        return false; 
    } 
    return true;
  }
  
  public int hashCode() {
    int i = size();
    int j = 1;
    for (byte b = 0; b < i; b++)
      j = j * 31 + get(b).hashCode(); 
    return j;
  }
  
  public E remove(int paramInt) {
    zzka();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject) {
    zzka();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    zzka();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    zzka();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE) {
    zzka();
    return super.set(paramInt, paramE);
  }
  
  public boolean zzjy() {
    return this.zzabp;
  }
  
  public final void zzjz() {
    this.zzabp = false;
  }
  
  protected final void zzka() {
    if (this.zzabp)
      return; 
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */