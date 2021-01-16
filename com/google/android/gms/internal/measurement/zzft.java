package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzft extends zzfr {
  private static final Class<?> zzaim = Collections.unmodifiableList(Collections.emptyList()).getClass();
  
  private zzft() {
    super(null);
  }
  
  private static <L> List<L> zza(Object paramObject, long paramLong, int paramInt) {
    List<?> list2;
    List<?> list1 = zzc(paramObject, paramLong);
    if (list1.isEmpty()) {
      if (list1 instanceof zzfq) {
        zzfp zzfp = new zzfp(paramInt);
      } else if (list1 instanceof zzgt && list1 instanceof zzfg) {
        zzfg zzfg = ((zzfg)list1).zzq(paramInt);
      } else {
        list2 = new ArrayList(paramInt);
      } 
      zzhw.zza(paramObject, paramLong, list2);
    } else if (zzaim.isAssignableFrom(list1.getClass())) {
      list2 = new ArrayList(list1.size() + paramInt);
      list2.addAll(list1);
      zzhw.zza(paramObject, paramLong, list2);
    } else if (list1 instanceof zzht) {
      list2 = new zzfp(list1.size() + paramInt);
      list2.addAll(list1);
      zzhw.zza(paramObject, paramLong, list2);
    } else {
      list2 = list1;
      if (list1 instanceof zzgt) {
        list2 = list1;
        if (list1 instanceof zzfg) {
          zzfg<?> zzfg = (zzfg)list1;
          list2 = list1;
          if (!zzfg.zzjy()) {
            list2 = zzfg.zzq(list1.size() + paramInt);
            zzhw.zza(paramObject, paramLong, list2);
          } 
        } 
      } 
    } 
    return (List)list2;
  }
  
  private static <E> List<E> zzc(Object paramObject, long paramLong) {
    return (List<E>)zzhw.zzp(paramObject, paramLong);
  }
  
  final <L> List<L> zza(Object paramObject, long paramLong) {
    return zza(paramObject, paramLong, 10);
  }
  
  final <E> void zza(Object paramObject1, Object<?> paramObject2, long paramLong) {
    paramObject2 = zzc(paramObject2, paramLong);
    List<?> list = zza(paramObject1, paramLong, paramObject2.size());
    int i = list.size();
    int j = paramObject2.size();
    if (i > 0 && j > 0)
      list.addAll((Collection<?>)paramObject2); 
    if (i > 0)
      paramObject2 = (Object<?>)list; 
    zzhw.zza(paramObject1, paramLong, paramObject2);
  }
  
  final void zzb(Object paramObject, long paramLong) {
    List<?> list = (List)zzhw.zzp(paramObject, paramLong);
    if (list instanceof zzfq) {
      list = ((zzfq)list).zznh();
    } else {
      if (zzaim.isAssignableFrom(list.getClass()))
        return; 
      if (list instanceof zzgt && list instanceof zzfg) {
        paramObject = list;
        if (paramObject.zzjy())
          paramObject.zzjz(); 
        return;
      } 
      list = Collections.unmodifiableList(list);
    } 
    zzhw.zza(paramObject, paramLong, list);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */