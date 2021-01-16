package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

final class zzha {
  private static final Class<?> zzajx = zzog();
  
  private static final zzhq<?, ?> zzajy = zzp(false);
  
  private static final zzhq<?, ?> zzajz = zzp(true);
  
  private static final zzhq<?, ?> zzaka = new zzhs();
  
  static <UT, UB> UB zza(int paramInt1, int paramInt2, UB paramUB, zzhq<UT, UB> paramzzhq) {
    UB uB = paramUB;
    if (paramUB == null)
      uB = paramzzhq.zzoq(); 
    paramzzhq.zza(uB, paramInt1, paramInt2);
    return uB;
  }
  
  static <UT, UB> UB zza(int paramInt, List<Integer> paramList, zzfe paramzzfe, UB paramUB, zzhq<UT, UB> paramzzhq) {
    UB uB;
    if (paramzzfe == null)
      return paramUB; 
    if (paramList instanceof java.util.RandomAccess) {
      int i = paramList.size();
      byte b1 = 0;
      byte b2 = 0;
      while (b1 < i) {
        int j = ((Integer)paramList.get(b1)).intValue();
        if (paramzzfe.zzf(j)) {
          if (b1 != b2)
            paramList.set(b2, Integer.valueOf(j)); 
          b2++;
        } else {
          paramUB = zza(paramInt, j, paramUB, paramzzhq);
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
      UB uB1 = paramUB;
      while (true) {
        uB = uB1;
        if (iterator.hasNext()) {
          int i = ((Integer)iterator.next()).intValue();
          if (!paramzzfe.zzf(i)) {
            uB1 = zza(paramInt, i, uB1, paramzzhq);
            iterator.remove();
          } 
          continue;
        } 
        break;
      } 
    } 
    return uB;
  }
  
  public static void zza(int paramInt, List<String> paramList, zzil paramzzil) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zza(paramInt, paramList); 
  }
  
  public static void zza(int paramInt, List<?> paramList, zzil paramzzil, zzgy paramzzgy) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zza(paramInt, paramList, paramzzgy); 
  }
  
  public static void zza(int paramInt, List<Double> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzg(paramInt, paramList, paramBoolean); 
  }
  
  static <T, FT extends zzes<FT>> void zza(zzen<FT> paramzzen, T paramT1, T paramT2) {
    zzeq<FT> zzeq = paramzzen.zzg(paramT2);
    if (!zzeq.isEmpty())
      paramzzen.zzh(paramT1).zza(zzeq); 
  }
  
  static <T> void zza(zzgc paramzzgc, T paramT1, T paramT2, long paramLong) {
    zzhw.zza(paramT1, paramLong, paramzzgc.zzb(zzhw.zzp(paramT1, paramLong), zzhw.zzp(paramT2, paramLong)));
  }
  
  static <T, UT, UB> void zza(zzhq<UT, UB> paramzzhq, T paramT1, T paramT2) {
    paramzzhq.zze(paramT1, paramzzhq.zzg(paramzzhq.zzw(paramT1), paramzzhq.zzw(paramT2)));
  }
  
  static int zzaa(List<?> paramList) {
    return paramList.size() << 2;
  }
  
  static int zzab(List<?> paramList) {
    return paramList.size() << 3;
  }
  
  static int zzac(List<?> paramList) {
    return paramList.size();
  }
  
  public static void zzb(int paramInt, List<zzdp> paramList, zzil paramzzil) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzb(paramInt, paramList); 
  }
  
  public static void zzb(int paramInt, List<?> paramList, zzil paramzzil, zzgy paramzzgy) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzb(paramInt, paramList, paramzzgy); 
  }
  
  public static void zzb(int paramInt, List<Float> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzf(paramInt, paramList, paramBoolean); 
  }
  
  static int zzc(int paramInt, Object paramObject, zzgy paramzzgy) {
    return (paramObject instanceof zzfo) ? zzeg.zza(paramInt, (zzfo)paramObject) : zzeg.zzb(paramInt, (zzgh)paramObject, paramzzgy);
  }
  
  static int zzc(int paramInt, List<?> paramList) {
    Object object;
    int i = paramList.size();
    byte b1 = 0;
    byte b2 = 0;
    if (i == 0)
      return 0; 
    int j = zzeg.zzaj(paramInt) * i;
    paramInt = j;
    if (paramList instanceof zzfq) {
      zzfq zzfq = (zzfq)paramList;
      paramInt = j;
      b1 = b2;
      while (true) {
        j = paramInt;
        if (b1 < i) {
          object = zzfq.zzaw(b1);
          if (object instanceof zzdp) {
            paramInt += zzeg.zzb((zzdp)object);
          } else {
            paramInt += zzeg.zzcp((String)object);
          } 
          b1++;
          continue;
        } 
        break;
      } 
    } else {
      while (true) {
        j = paramInt;
        if (b1 < i) {
          zzdp zzdp = (zzdp)object.get(b1);
          if (zzdp instanceof zzdp) {
            paramInt += zzeg.zzb(zzdp);
          } else {
            paramInt += zzeg.zzcp((String)zzdp);
          } 
          b1++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzc(int paramInt, List<?> paramList, zzgy paramzzgy) {
    int i = paramList.size();
    byte b = 0;
    if (i == 0)
      return 0; 
    paramInt = zzeg.zzaj(paramInt) * i;
    while (b < i) {
      Object object = paramList.get(b);
      if (object instanceof zzfo) {
        paramInt += zzeg.zza((zzfo)object);
      } else {
        paramInt += zzeg.zzb((zzgh)object, paramzzgy);
      } 
      b++;
    } 
    return paramInt;
  }
  
  public static void zzc(int paramInt, List<Long> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzc(paramInt, paramList, paramBoolean); 
  }
  
  static int zzd(int paramInt, List<zzdp> paramList) {
    int i = paramList.size();
    int j = 0;
    if (i == 0)
      return 0; 
    i *= zzeg.zzaj(paramInt);
    paramInt = j;
    j = i;
    while (paramInt < paramList.size()) {
      j += zzeg.zzb(paramList.get(paramInt));
      paramInt++;
    } 
    return j;
  }
  
  static int zzd(int paramInt, List<zzgh> paramList, zzgy paramzzgy) {
    int i = paramList.size();
    byte b = 0;
    if (i == 0)
      return 0; 
    int j = 0;
    while (b < i) {
      j += zzeg.zzc(paramInt, paramList.get(b), paramzzgy);
      b++;
    } 
    return j;
  }
  
  public static void zzd(int paramInt, List<Long> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzd(paramInt, paramList, paramBoolean); 
  }
  
  static boolean zzd(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static void zze(int paramInt, List<Long> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzn(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzf(int paramInt, List<Long> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zze(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzg(int paramInt, List<Long> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzl(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzg(Class<?> paramClass) {
    if (!zzez.class.isAssignableFrom(paramClass)) {
      Class<?> clazz = zzajx;
      if (clazz != null && !clazz.isAssignableFrom(paramClass))
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite"); 
    } 
  }
  
  public static void zzh(int paramInt, List<Integer> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zza(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzi(int paramInt, List<Integer> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzj(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzj(int paramInt, List<Integer> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzm(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzk(int paramInt, List<Integer> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzb(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzl(int paramInt, List<Integer> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzk(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzm(int paramInt, List<Integer> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzh(paramInt, paramList, paramBoolean); 
  }
  
  public static void zzn(int paramInt, List<Boolean> paramList, zzil paramzzil, boolean paramBoolean) throws IOException {
    if (paramList != null && !paramList.isEmpty())
      paramzzil.zzi(paramInt, paramList, paramBoolean); 
  }
  
  static int zzo(int paramInt, List<Long> paramList, boolean paramBoolean) {
    return (paramList.size() == 0) ? 0 : (zzt(paramList) + paramList.size() * zzeg.zzaj(paramInt));
  }
  
  public static zzhq<?, ?> zzod() {
    return zzajy;
  }
  
  public static zzhq<?, ?> zzoe() {
    return zzajz;
  }
  
  public static zzhq<?, ?> zzof() {
    return zzaka;
  }
  
  private static Class<?> zzog() {
    try {
      return Class.forName("com.google.protobuf.GeneratedMessage");
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  private static Class<?> zzoh() {
    try {
      return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static int zzp(int paramInt, List<Long> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzu(paramList) + i * zzeg.zzaj(paramInt));
  }
  
  private static zzhq<?, ?> zzp(boolean paramBoolean) {
    try {
      Class<?> clazz = zzoh();
      return (clazz == null) ? null : clazz.getConstructor(new Class[] { boolean.class }).newInstance(new Object[] { Boolean.valueOf(paramBoolean) });
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static int zzq(int paramInt, List<Long> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzv(paramList) + i * zzeg.zzaj(paramInt));
  }
  
  static int zzr(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzw(paramList) + i * zzeg.zzaj(paramInt));
  }
  
  static int zzs(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzx(paramList) + i * zzeg.zzaj(paramInt));
  }
  
  static int zzt(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzy(paramList) + i * zzeg.zzaj(paramInt));
  }
  
  static int zzt(List<Long> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfv) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzat(paramList.getLong(k));
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
          m += zzeg.zzat(((Long)paramList.get(k)).longValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzu(int paramInt, List<Integer> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (zzz(paramList) + i * zzeg.zzaj(paramInt));
  }
  
  static int zzu(List<Long> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfv) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzau(paramList.getLong(k));
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
          m += zzeg.zzau(((Long)paramList.get(k)).longValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzv(int paramInt, List<?> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (i * zzeg.zzj(paramInt, 0));
  }
  
  static int zzv(List<Long> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfv) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzav(paramList.getLong(k));
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
          m += zzeg.zzav(((Long)paramList.get(k)).longValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzw(int paramInt, List<?> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (i * zzeg.zzg(paramInt, 0L));
  }
  
  static int zzw(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzap(paramList.getInt(k));
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
          m += zzeg.zzap(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzx(int paramInt, List<?> paramList, boolean paramBoolean) {
    int i = paramList.size();
    return (i == 0) ? 0 : (i * zzeg.zzc(paramInt, true));
  }
  
  static int zzx(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzak(paramList.getInt(k));
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
          m += zzeg.zzak(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzy(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzal(paramList.getInt(k));
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
          m += zzeg.zzal(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
  
  static int zzz(List<Integer> paramList) {
    int i = paramList.size();
    int j = 0;
    int k = 0;
    if (i == 0)
      return 0; 
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int m = 0;
      while (true) {
        j = m;
        if (k < i) {
          m += zzeg.zzam(paramList.getInt(k));
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
          m += zzeg.zzam(((Integer)paramList.get(k)).intValue());
          k++;
          continue;
        } 
        break;
      } 
    } 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */