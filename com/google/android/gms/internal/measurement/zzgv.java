package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

final class zzgv<E> extends zzdj<E> {
  private static final zzgv<Object> zzajw;
  
  private final List<E> zzaij;
  
  static {
    zzgv<Object> zzgv1 = new zzgv(new ArrayList<E>(0));
    zzajw = zzgv1;
    zzgv1.zzjz();
  }
  
  zzgv() {
    this(new ArrayList<E>(10));
  }
  
  private zzgv(List<E> paramList) {
    this.zzaij = paramList;
  }
  
  public static <E> zzgv<E> zzoa() {
    return (zzgv)zzajw;
  }
  
  public final void add(int paramInt, E paramE) {
    zzka();
    this.zzaij.add(paramInt, paramE);
    this.modCount++;
  }
  
  public final E get(int paramInt) {
    return this.zzaij.get(paramInt);
  }
  
  public final E remove(int paramInt) {
    zzka();
    E e = this.zzaij.remove(paramInt);
    this.modCount++;
    return e;
  }
  
  public final E set(int paramInt, E paramE) {
    zzka();
    paramE = this.zzaij.set(paramInt, paramE);
    this.modCount++;
    return paramE;
  }
  
  public final int size() {
    return this.zzaij.size();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */