package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzcw extends zzav<String> implements zzcx, RandomAccess {
  private static final zzcw zzlq;
  
  private static final zzcx zzlr = zzlq;
  
  private final List<Object> zzls;
  
  public zzcw() {
    this(10);
  }
  
  public zzcw(int paramInt) {
    this(new ArrayList(paramInt));
  }
  
  private zzcw(ArrayList<Object> paramArrayList) {
    this.zzls = paramArrayList;
  }
  
  private static String zze(Object paramObject) {
    return (paramObject instanceof String) ? (String)paramObject : ((paramObject instanceof zzbb) ? ((zzbb)paramObject).zzz() : zzci.zzf((byte[])paramObject));
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection) {
    zzw();
    Collection<? extends String> collection = paramCollection;
    if (paramCollection instanceof zzcx)
      collection = (Collection)((zzcx)paramCollection).zzbt(); 
    boolean bool = this.zzls.addAll(paramInt, collection);
    this.modCount++;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection) {
    return super.addAll(size(), paramCollection);
  }
  
  public final void clear() {
    zzw();
    this.zzls.clear();
    this.modCount++;
  }
  
  public final Object getRaw(int paramInt) {
    return this.zzls.get(paramInt);
  }
  
  public final int size() {
    return this.zzls.size();
  }
  
  public final List<?> zzbt() {
    return Collections.unmodifiableList(this.zzls);
  }
  
  public final zzcx zzbu() {
    return (zzcx)(super.zzu() ? new zzfa(this) : this);
  }
  
  static {
    zzcw zzcw1 = new zzcw();
    zzlq = zzcw1;
    zzcw1.zzv();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzcw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */