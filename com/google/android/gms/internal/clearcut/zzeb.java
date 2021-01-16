package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.List;

final class zzeb<E> extends zzav<E> {
  private static final zzeb<Object> zznf;
  
  private final List<E> zzls;
  
  static {
    zzeb<Object> zzeb1 = new zzeb();
    zznf = zzeb1;
    zzeb1.zzv();
  }
  
  zzeb() {
    this(new ArrayList<E>(10));
  }
  
  private zzeb(List<E> paramList) {
    this.zzls = paramList;
  }
  
  public static <E> zzeb<E> zzcn() {
    return (zzeb)zznf;
  }
  
  public final void add(int paramInt, E paramE) {
    zzw();
    this.zzls.add(paramInt, paramE);
    this.modCount++;
  }
  
  public final E get(int paramInt) {
    return this.zzls.get(paramInt);
  }
  
  public final E remove(int paramInt) {
    zzw();
    E e = this.zzls.remove(paramInt);
    this.modCount++;
    return e;
  }
  
  public final E set(int paramInt, E paramE) {
    zzw();
    paramE = this.zzls.set(paramInt, paramE);
    this.modCount++;
    return paramE;
  }
  
  public final int size() {
    return this.zzls.size();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */