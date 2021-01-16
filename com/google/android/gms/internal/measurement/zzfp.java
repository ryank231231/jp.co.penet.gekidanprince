package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzfp extends zzdj<String> implements zzfq, RandomAccess {
  private static final zzfp zzaih;
  
  private static final zzfq zzaii = zzaih;
  
  private final List<Object> zzaij;
  
  public zzfp() {
    this(10);
  }
  
  public zzfp(int paramInt) {
    this(new ArrayList(paramInt));
  }
  
  private zzfp(ArrayList<Object> paramArrayList) {
    this.zzaij = paramArrayList;
  }
  
  private static String zzk(Object paramObject) {
    return (paramObject instanceof String) ? (String)paramObject : ((paramObject instanceof zzdp) ? ((zzdp)paramObject).zzkd() : zzfb.zzk((byte[])paramObject));
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection) {
    zzka();
    Collection<? extends String> collection = paramCollection;
    if (paramCollection instanceof zzfq)
      collection = (Collection)((zzfq)paramCollection).zzng(); 
    boolean bool = this.zzaij.addAll(paramInt, collection);
    this.modCount++;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection) {
    return super.addAll(size(), paramCollection);
  }
  
  public final void clear() {
    zzka();
    this.zzaij.clear();
    this.modCount++;
  }
  
  public final int size() {
    return this.zzaij.size();
  }
  
  public final Object zzaw(int paramInt) {
    return this.zzaij.get(paramInt);
  }
  
  public final void zzc(zzdp paramzzdp) {
    zzka();
    this.zzaij.add(paramzzdp);
    this.modCount++;
  }
  
  public final List<?> zzng() {
    return Collections.unmodifiableList(this.zzaij);
  }
  
  public final zzfq zznh() {
    return (zzfq)(super.zzjy() ? new zzht(this) : this);
  }
  
  static {
    zzfp zzfp1 = new zzfp();
    zzaih = zzfp1;
    zzfp1.zzjz();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */