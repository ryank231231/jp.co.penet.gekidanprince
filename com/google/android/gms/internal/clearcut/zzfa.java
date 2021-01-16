package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzfa extends AbstractList<String> implements zzcx, RandomAccess {
  private final zzcx zzpb;
  
  public zzfa(zzcx paramzzcx) {
    this.zzpb = paramzzcx;
  }
  
  public final Object getRaw(int paramInt) {
    return this.zzpb.getRaw(paramInt);
  }
  
  public final Iterator<String> iterator() {
    return new zzfc(this);
  }
  
  public final ListIterator<String> listIterator(int paramInt) {
    return new zzfb(this, paramInt);
  }
  
  public final int size() {
    return this.zzpb.size();
  }
  
  public final List<?> zzbt() {
    return this.zzpb.zzbt();
  }
  
  public final zzcx zzbu() {
    return this;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */