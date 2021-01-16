package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzht extends AbstractList<String> implements zzfq, RandomAccess {
  private final zzfq zzakr;
  
  public zzht(zzfq paramzzfq) {
    this.zzakr = paramzzfq;
  }
  
  public final Iterator<String> iterator() {
    return new zzhv(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt) {
    return new zzhu(this, paramInt);
  }
  
  public final int size() {
    return this.zzakr.size();
  }
  
  public final Object zzaw(int paramInt) {
    return this.zzakr.zzaw(paramInt);
  }
  
  public final void zzc(zzdp paramzzdp) {
    throw new UnsupportedOperationException();
  }
  
  public final List<?> zzng() {
    return this.zzakr.zzng();
  }
  
  public final zzfq zznh() {
    return this;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */