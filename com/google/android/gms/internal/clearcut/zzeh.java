package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class zzeh {
  private static final Class<?> zzoh = zzdp();
  
  private static final zzex<?, ?> zzoi = zzd(false);
  
  private static final zzex<?, ?> zzoj = zzd(true);
  
  private static final zzex<?, ?> zzok = new zzez();
  
  static int zza(List<Long> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzdc) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zze(paramList.getLong(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zze(((Long)paramList.get(k)).longValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  private static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzex<UT, UB> paramzzex) {
    UB uB = paramUB;
    if (paramUB == null)
      uB = paramzzex.zzdz(); 
    paramzzex.zza(uB, paramInt1, paramInt2);
    return uB;
  }
  
  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzck<?> paramzzck, UB paramUB, zzex<UT, UB> paramzzex) {
    UB uB;
    if (paramzzck == null)
      return paramUB; 
    if (paramList instanceof java.util.RandomAccess) {
      int i = paramList.size();
      byte b1 = 0;
      byte b2 = 0;
      while (b1 < i) {
        int j = ((Integer)paramList.get(b1)).intValue();
        if (paramzzck.zzb(j) != null) {
          if (b1 != b2)
            paramList.set(b2, Integer.valueOf(j)); 
          b2++;
        } else {
          paramUB = zza(paramInt, j, paramUB, paramzzex);
        } 
        b1++;
      } 
      uB = paramUB;
      if (b2 != i) {
        paramList.subList(b2, i).clear();
        uB = paramUB;
      } 
    } else {
      Iterator<Integer> iterator = paramList.iterator();
      while (true) {
        uB = paramUB;
        if (iterator.hasNext()) {
          int i = ((Integer)iterator.next()).intValue();
          if (paramzzck.zzb(i) == null) {
            paramUB = zza(paramInt, i, paramUB, paramzzex);
            iterator.remove();
          } 
          continue;
        } 
        break;
      } 
    } 
    return uB;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzfr paramzzfr) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zza(paramInt, paramList); 
  }
  
  public static void zza(int paramInt, List<?> paramList, zzfr paramzzfr, zzef paramzzef) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zza(paramInt, paramList, paramzzef); 
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzg(paramInt, paramList, paramBoolean); 
  }
  
  static <T, FT extends zzca<FT>> void zza(zzbu<FT> paramzzbu, T paramT1, T paramT2) {
    zzby<FT> zzby = paramzzbu.zza(paramT2);
    if (!zzby.isEmpty())
      paramzzbu.zzb(paramT1).zza(zzby); 
  }
  
  static <T> void zza(zzdj paramzzdj, T paramT1, T paramT2, long paramLong) {
    zzfd.zza(paramT1, paramLong, paramzzdj.zzb(zzfd.zzo(paramT1, paramLong), zzfd.zzo(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzex<UT, UB> paramzzex, T paramT1, T paramT2) {
    paramzzex.zze(paramT1, paramzzex.zzg(paramzzex.zzq(paramT1), paramzzex.zzq(paramT2)));
  }
  
  static int zzb(List<Long> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzdc) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzf(paramList.getLong(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzf(((Long)paramList.get(k)).longValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  public static void zzb(int paramInt, List<zzbb> paramList, zzfr paramzzfr) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzb(paramInt, paramList); 
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzfr paramzzfr, zzef paramzzef) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzb(paramInt, paramList, paramzzef); 
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzf(paramInt, paramList, paramBoolean); 
  }
  
  static int zzc(int paramInt, Object paramObject, zzef paramzzef) {
    return (paramObject instanceof zzcv) ? zzbn.zza(paramInt, (zzcv)paramObject) : zzbn.zzb(paramInt, (zzdo)paramObject, paramzzef);
  }
  
  static int zzc(int paramInt, List<?> paramList) {
    int i = paramList.size();
    byte b1 = 0;
    byte b2 = 0;
    if (i == 0)
      return 0; 
    int j = zzbn.zzr(paramInt) * i;
    paramInt = j;
    if (paramList instanceof zzcx) {
      paramList = paramList;
      paramInt = j;
      b1 = b2;
      while (true) {
        j = paramInt;
        if (b1 < i) {
          Object object = paramList.getRaw(b1);
          if (object instanceof zzbb) {
            j = zzbn.zzb((zzbb)object);
          } else {
            j = zzbn.zzh((String)object);
          } 
          paramInt += j;
          b1++;
          continue;
        } 
        break;
      } 
    } else {
      while (true) {
        j = paramInt;
        if (b1 < i) {
          Object object = paramList.get(b1);
          if (object instanceof zzbb) {
            j = zzbn.zzb((zzbb)object);
          } else {
            j = zzbn.zzh((String)object);
          } 
          paramInt += j;
          b1++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzc(int paramInt, List<?> paramList, zzef paramzzef) {
    int i = paramList.size();
    int j = 0;
    if (i == 0)
      return 0; 
    int k = zzbn.zzr(paramInt) * i;
    for (paramInt = j; paramInt < i; paramInt++) {
      Object object = paramList.get(paramInt);
      if (object instanceof zzcv) {
        j = zzbn.zza((zzcv)object);
      } else {
        j = zzbn.zzb((zzdo)object, paramzzef);
      } 
      k += j;
    } 
    return k;
  }
  
  static int zzc(List<Long> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzdc) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzg(paramList.getLong(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzg(((Long)paramList.get(k)).longValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzc(paramInt, paramList, paramBoolean); 
  }
  
  public static boolean zzc(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 < 40)
      return true; 
    long l1 = paramInt2;
    long l2 = paramInt1;
    long l3 = paramInt3;
    return (l1 - l2 + 1L + 9L <= 2L * l3 + 3L + (l3 + 3L) * 3L);
  }
  
  static int zzd(int paramInt, List<zzbb> paramList) {
    int i = paramList.size();
    int j = 0;
    if (i == 0)
      return 0; 
    i *= zzbn.zzr(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size()) {
      j += zzbn.zzb(paramList.get(paramInt));
      paramInt++;
    } 
    return j;
  }
  
  static int zzd(int paramInt, List<zzdo> paramList, zzef paramzzef) {
    int i = paramList.size();
    byte b = 0;
    if (i == 0)
      return 0; 
    int j = 0;
    while (b < i) {
      j += zzbn.zzc(paramInt, paramList.get(b), paramzzef);
      b++;
    } 
    return j;
  }
  
  static int zzd(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzch) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzx(paramList.getInt(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzx(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  private static zzex<?, ?> zzd(boolean paramBoolean) {
    try {
      Class<?> clazz = zzdq();
      return (clazz == null) ? null : clazz.getConstructor(new Class[] { boolean.class }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  public static void zzd(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzd(paramInt, paramList, paramBoolean); 
  }
  
  static boolean zzd(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static zzex<?, ?> zzdm() {
    return zzoi;
  }
  
  public static zzex<?, ?> zzdn() {
    return zzoj;
  }
  
  public static zzex<?, ?> zzdo() {
    return zzok;
  }
  
  private static Class<?> zzdp() {
    try {
      return Class.forName("com.google.protobuf.GeneratedMessage");
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Class<?> zzdq() {
    try {
      return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static int zze(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzch) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzs(paramList.getInt(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzs(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  public static void zze(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzn(paramInt, paramList, paramBoolean); 
  }
  
  static int zzf(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzch) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzt(paramList.getInt(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzt(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zze(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzf(Class<?> paramClass) {
    if (!zzcg.class.isAssignableFrom(paramClass)) {
      Class<?> clazz = zzoh;
      if (clazz != null && !clazz.isAssignableFrom(paramClass))
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite"); 
    } 
  }
  
  static int zzg(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzch) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzu(paramList.getInt(k));
          k++;
          continue;
        } 
        break;
      } 
    } else {
      int m = 0;
      k = j;
      while (true) {
        j = m;
        if (k < i) {
          m += zzbn.zzu(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzl(paramInt, paramList, paramBoolean); 
  }
  
  static int zzh(List<?> paramList) {
    return paramList.size() << 2;
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zza(paramInt, paramList, paramBoolean); 
  }
  
  static int zzi(List<?> paramList) {
    return paramList.size() << 3;
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzj(paramInt, paramList, paramBoolean); 
  }
  
  static int zzj(List<?> paramList) {
    return paramList.size();
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzm(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzb(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzk(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzh(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzfr paramzzfr, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzfr.zzi(paramInt, paramList, paramBoolean); 
  }
  
  static int zzo(int paramInt, List<Long> paramList, boolean paramBoolean) {
    return (paramList.size() == 0) ? 0 : (zza(paramList) + paramList.size() * zzbn.zzr(paramInt));
  }
  
  static int zzp(int paramInt, List<Long> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzb(paramList) + i * zzbn.zzr(paramInt));
  }
  
  static int zzq(int paramInt, List<Long> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzc(paramList) + i * zzbn.zzr(paramInt));
  }
  
  static int zzr(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzd(paramList) + i * zzbn.zzr(paramInt));
  }
  
  static int zzs(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zze(paramList) + i * zzbn.zzr(paramInt));
  }
  
  static int zzt(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzf(paramList) + i * zzbn.zzr(paramInt));
  }
  
  static int zzu(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzg(paramList) + i * zzbn.zzr(paramInt));
  }
  
  static int zzv(int paramInt, List<?> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (i * zzbn.zzj(paramInt, 0));
  }
  
  static int zzw(int paramInt, List<?> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (i * zzbn.zzg(paramInt, 0L));
  }
  
  static int zzx(int paramInt, List<?> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (i * zzbn.zzc(paramInt, true));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzeh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */