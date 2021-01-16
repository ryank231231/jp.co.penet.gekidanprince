package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Collection;

abstract class zzav<E> extends AbstractList<E> implements zzcn<E> {
  private boolean zzfa = true;
  
  public void add(int paramInt, E paramE) {
    zzw();
    super.add(paramInt, paramE);
  }
  
  public boolean add(E paramE) {
    zzw();
    return super.add(paramE);
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
    zzw();
    return super.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    zzw();
    return super.addAll(paramCollection);
  }
  
  public void clear() {
    zzw();
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
    zzw();
    return super.remove(paramInt);
  }
  
  public boolean remove(Object paramObject) {
    zzw();
    return super.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    zzw();
    return super.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    zzw();
    return super.retainAll(paramCollection);
  }
  
  public E set(int paramInt, E paramE) {
    zzw();
    return super.set(paramInt, paramE);
  }
  
  public boolean zzu() {
    return this.zzfa;
  }
  
  public final void zzv() {
    this.zzfa = false;
  }
  
  protected final void zzw() {
    if (this.zzfa)
      return; 
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */