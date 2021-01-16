package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzby<FieldDescriptorType extends zzca<FieldDescriptorType>> {
  private static final zzby zzgw = new zzby(true);
  
  private final zzei<FieldDescriptorType, Object> zzgt = zzei.zzaj(16);
  
  private boolean zzgu;
  
  private boolean zzgv = false;
  
  private zzby() {}
  
  private zzby(boolean paramBoolean) {
    zzv();
  }
  
  static int zza(zzfl paramzzfl, int paramInt, Object paramObject) {
    int i = zzbn.zzr(paramInt);
    paramInt = i;
    if (paramzzfl == zzfl.zzql) {
      zzci.zzf((zzdo)paramObject);
      paramInt = i << 1;
    } 
    return paramInt + zzb(paramzzfl, paramObject);
  }
  
  private final Object zza(FieldDescriptorType paramFieldDescriptorType) {
    zzdo zzdo;
    Object object = this.zzgt.get(paramFieldDescriptorType);
    paramFieldDescriptorType = (FieldDescriptorType)object;
    if (object instanceof zzcr)
      zzdo = zzcr.zzbr(); 
    return zzdo;
  }
  
  static void zza(zzbn paramzzbn, zzfl paramzzfl, int paramInt, Object paramObject) throws IOException {
    zzdo zzdo;
    byte[] arrayOfByte;
    if (paramzzfl == zzfl.zzql) {
      zzdo = (zzdo)paramObject;
      zzci.zzf(zzdo);
      paramzzbn.zzb(paramInt, 3);
      zzdo.zzb(paramzzbn);
      paramzzbn.zzb(paramInt, 4);
      return;
    } 
    paramzzbn.zzb(paramInt, zzdo.zzel());
    switch (zzbz.zzgq[zzdo.ordinal()]) {
      default:
        return;
      case 18:
        if (paramObject instanceof zzcj) {
          paramzzbn.zzn(((zzcj)paramObject).zzc());
          return;
        } 
        paramzzbn.zzn(((Integer)paramObject).intValue());
      case 17:
        paramzzbn.zzc(((Long)paramObject).longValue());
        return;
      case 16:
        paramzzbn.zzp(((Integer)paramObject).intValue());
        return;
      case 15:
        paramzzbn.zzd(((Long)paramObject).longValue());
        return;
      case 14:
        paramzzbn.zzq(((Integer)paramObject).intValue());
        return;
      case 13:
        paramzzbn.zzo(((Integer)paramObject).intValue());
        return;
      case 12:
        if (paramObject instanceof zzbb) {
          paramzzbn.zza((zzbb)paramObject);
          return;
        } 
        arrayOfByte = (byte[])paramObject;
        paramzzbn.zzd(arrayOfByte, 0, arrayOfByte.length);
        return;
      case 11:
        if (paramObject instanceof zzbb) {
          paramzzbn.zza((zzbb)paramObject);
          return;
        } 
        paramzzbn.zzg((String)paramObject);
        return;
      case 10:
        paramzzbn.zzb((zzdo)paramObject);
        return;
      case 9:
        ((zzdo)paramObject).zzb(paramzzbn);
        return;
      case 8:
        paramzzbn.zza(((Boolean)paramObject).booleanValue());
        return;
      case 7:
        paramzzbn.zzq(((Integer)paramObject).intValue());
        return;
      case 6:
        paramzzbn.zzd(((Long)paramObject).longValue());
        return;
      case 5:
        paramzzbn.zzn(((Integer)paramObject).intValue());
        return;
      case 4:
        paramzzbn.zzb(((Long)paramObject).longValue());
        return;
      case 3:
        paramzzbn.zzb(((Long)paramObject).longValue());
        return;
      case 2:
        paramzzbn.zza(((Float)paramObject).floatValue());
        return;
      case 1:
        break;
    } 
    paramzzbn.zza(((Double)paramObject).doubleValue());
  }
  
  private final void zza(FieldDescriptorType paramFieldDescriptorType, Object paramObject) {
    if (paramFieldDescriptorType.zzaw()) {
      if (paramObject instanceof List) {
        ArrayList arrayList1 = new ArrayList();
        arrayList1.addAll((List)paramObject);
        ArrayList arrayList2 = arrayList1;
        int i = arrayList2.size();
        byte b = 0;
        while (b < i) {
          paramObject = arrayList2.get(b);
          b++;
          zza(paramFieldDescriptorType.zzau(), paramObject);
        } 
        paramObject = arrayList1;
      } else {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      } 
    } else {
      zza(paramFieldDescriptorType.zzau(), paramObject);
    } 
    if (paramObject instanceof zzcr)
      this.zzgv = true; 
    this.zzgt.zza(paramFieldDescriptorType, paramObject);
  }
  
  private static void zza(zzfl paramzzfl, Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: getstatic com/google/android/gms/internal/clearcut/zzbz.zzgx : [I
    //   8: aload_0
    //   9: invokevirtual zzek : ()Lcom/google/android/gms/internal/clearcut/zzfq;
    //   12: invokevirtual ordinal : ()I
    //   15: iaload
    //   16: istore_2
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_2
    //   20: tableswitch default -> 72, 1 -> 168, 2 -> 160, 3 -> 152, 4 -> 144, 5 -> 136, 6 -> 128, 7 -> 111, 8 -> 92, 9 -> 75
    //   72: goto -> 173
    //   75: aload_1
    //   76: instanceof com/google/android/gms/internal/clearcut/zzdo
    //   79: ifne -> 106
    //   82: aload_1
    //   83: instanceof com/google/android/gms/internal/clearcut/zzcr
    //   86: ifeq -> 173
    //   89: goto -> 106
    //   92: aload_1
    //   93: instanceof java/lang/Integer
    //   96: ifne -> 106
    //   99: aload_1
    //   100: instanceof com/google/android/gms/internal/clearcut/zzcj
    //   103: ifeq -> 173
    //   106: iconst_1
    //   107: istore_3
    //   108: goto -> 173
    //   111: aload_1
    //   112: instanceof com/google/android/gms/internal/clearcut/zzbb
    //   115: ifne -> 106
    //   118: aload_1
    //   119: instanceof [B
    //   122: ifeq -> 173
    //   125: goto -> 106
    //   128: aload_1
    //   129: instanceof java/lang/String
    //   132: istore_3
    //   133: goto -> 173
    //   136: aload_1
    //   137: instanceof java/lang/Boolean
    //   140: istore_3
    //   141: goto -> 173
    //   144: aload_1
    //   145: instanceof java/lang/Double
    //   148: istore_3
    //   149: goto -> 173
    //   152: aload_1
    //   153: instanceof java/lang/Float
    //   156: istore_3
    //   157: goto -> 173
    //   160: aload_1
    //   161: instanceof java/lang/Long
    //   164: istore_3
    //   165: goto -> 173
    //   168: aload_1
    //   169: instanceof java/lang/Integer
    //   172: istore_3
    //   173: iload_3
    //   174: ifeq -> 178
    //   177: return
    //   178: new java/lang/IllegalArgumentException
    //   181: dup
    //   182: ldc 'Wrong object type used with protocol message reflection.'
    //   184: invokespecial <init> : (Ljava/lang/String;)V
    //   187: athrow
  }
  
  public static <T extends zzca<T>> zzby<T> zzar() {
    return zzgw;
  }
  
  private static int zzb(zzca<?> paramzzca, Object paramObject) {
    zzfl zzfl = paramzzca.zzau();
    int i = paramzzca.zzc();
    if (paramzzca.zzaw()) {
      boolean bool = paramzzca.zzax();
      boolean bool1 = false;
      int j = 0;
      if (bool) {
        Iterator iterator1 = ((List)paramObject).iterator();
        while (iterator1.hasNext())
          j += zzb(zzfl, iterator1.next()); 
        return zzbn.zzr(i) + j + zzbn.zzz(j);
      } 
      Iterator iterator = ((List)paramObject).iterator();
      for (j = bool1; iterator.hasNext(); j += zza(zzfl, i, iterator.next()));
      return j;
    } 
    return zza(zzfl, i, paramObject);
  }
  
  private static int zzb(zzfl paramzzfl, Object paramObject) {
    switch (zzbz.zzgq[paramzzfl.ordinal()]) {
      default:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      case 18:
        return (paramObject instanceof zzcj) ? zzbn.zzx(((zzcj)paramObject).zzc()) : zzbn.zzx(((Integer)paramObject).intValue());
      case 17:
        return zzbn.zzg(((Long)paramObject).longValue());
      case 16:
        return zzbn.zzu(((Integer)paramObject).intValue());
      case 15:
        return zzbn.zzi(((Long)paramObject).longValue());
      case 14:
        return zzbn.zzw(((Integer)paramObject).intValue());
      case 13:
        return zzbn.zzt(((Integer)paramObject).intValue());
      case 12:
        return (paramObject instanceof zzbb) ? zzbn.zzb((zzbb)paramObject) : zzbn.zzd((byte[])paramObject);
      case 11:
        return (paramObject instanceof zzbb) ? zzbn.zzb((zzbb)paramObject) : zzbn.zzh((String)paramObject);
      case 10:
        return (paramObject instanceof zzcr) ? zzbn.zza((zzcr)paramObject) : zzbn.zzc((zzdo)paramObject);
      case 9:
        return zzbn.zzd((zzdo)paramObject);
      case 8:
        return zzbn.zzb(((Boolean)paramObject).booleanValue());
      case 7:
        return zzbn.zzv(((Integer)paramObject).intValue());
      case 6:
        return zzbn.zzh(((Long)paramObject).longValue());
      case 5:
        return zzbn.zzs(((Integer)paramObject).intValue());
      case 4:
        return zzbn.zzf(((Long)paramObject).longValue());
      case 3:
        return zzbn.zze(((Long)paramObject).longValue());
      case 2:
        return zzbn.zzb(((Float)paramObject).floatValue());
      case 1:
        break;
    } 
    return zzbn.zzb(((Double)paramObject).doubleValue());
  }
  
  private static boolean zzb(Map.Entry<FieldDescriptorType, Object> paramEntry) {
    zzca zzca = (zzca)paramEntry.getKey();
    if (zzca.zzav() == zzfq.zzrf) {
      Iterator<zzdo> iterator;
      if (zzca.zzaw()) {
        iterator = ((List)paramEntry.getValue()).iterator();
        while (iterator.hasNext()) {
          if (!((zzdo)iterator.next()).isInitialized())
            return false; 
        } 
      } else {
        iterator = iterator.getValue();
        if (iterator instanceof zzdo) {
          if (!((zzdo)iterator).isInitialized())
            return false; 
        } else {
          if (iterator instanceof zzcr)
            return true; 
          throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } 
      } 
    } 
    return true;
  }
  
  private final void zzc(Map.Entry<FieldDescriptorType, Object> paramEntry) {
    zzca zzca = (zzca)paramEntry.getKey();
    Object object2 = paramEntry.getValue();
    Object object1 = object2;
    if (object2 instanceof zzcr)
      object1 = zzcr.zzbr(); 
    if (zzca.zzaw()) {
      object = zza((FieldDescriptorType)zzca);
      object2 = object;
      if (object == null)
        object2 = new ArrayList(); 
      for (Object object : object1)
        ((List<Object>)object2).add(zzd(object)); 
      this.zzgt.zza((FieldDescriptorType)zzca, object2);
      return;
    } 
    if (zzca.zzav() == zzfq.zzrf) {
      object2 = zza((FieldDescriptorType)zzca);
      if (object2 == null) {
        this.zzgt.zza((FieldDescriptorType)zzca, zzd(object1));
        return;
      } 
      if (object2 instanceof zzdv) {
        object1 = zzca.zza((zzdv)object2, (zzdv)object1);
      } else {
        object1 = zzca.zza(((zzdo)object2).zzbc(), (zzdo)object1).zzbj();
      } 
      this.zzgt.zza((FieldDescriptorType)zzca, object1);
      return;
    } 
    this.zzgt.zza((FieldDescriptorType)zzca, zzd(object1));
  }
  
  private static int zzd(Map.Entry<FieldDescriptorType, Object> paramEntry) {
    zzca<?> zzca = (zzca)paramEntry.getKey();
    Object object = paramEntry.getValue();
    return (zzca.zzav() == zzfq.zzrf && !zzca.zzaw() && !zzca.zzax()) ? ((object instanceof zzcr) ? zzbn.zzb(((zzca)paramEntry.getKey()).zzc(), (zzcr)object) : zzbn.zzd(((zzca)paramEntry.getKey()).zzc(), (zzdo)object)) : zzb(zzca, object);
  }
  
  private static Object zzd(Object paramObject) {
    if (paramObject instanceof zzdv)
      return ((zzdv)paramObject).zzci(); 
    if (paramObject instanceof byte[]) {
      byte[] arrayOfByte = (byte[])paramObject;
      paramObject = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, paramObject, 0, arrayOfByte.length);
      return paramObject;
    } 
    return paramObject;
  }
  
  final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
    return this.zzgv ? new zzcu<FieldDescriptorType>(this.zzgt.zzdt().iterator()) : this.zzgt.zzdt().iterator();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzby))
      return false; 
    paramObject = paramObject;
    return this.zzgt.equals(((zzby)paramObject).zzgt);
  }
  
  public final int hashCode() {
    return this.zzgt.hashCode();
  }
  
  final boolean isEmpty() {
    return this.zzgt.isEmpty();
  }
  
  public final boolean isImmutable() {
    return this.zzgu;
  }
  
  public final boolean isInitialized() {
    for (byte b = 0; b < this.zzgt.zzdr(); b++) {
      if (!zzb(this.zzgt.zzak(b)))
        return false; 
    } 
    Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = this.zzgt.zzds().iterator();
    while (iterator.hasNext()) {
      if (!zzb(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
    return this.zzgv ? new zzcu<FieldDescriptorType>(this.zzgt.entrySet().iterator()) : this.zzgt.entrySet().iterator();
  }
  
  public final void zza(zzby<FieldDescriptorType> paramzzby) {
    for (byte b = 0; b < paramzzby.zzgt.zzdr(); b++)
      zzc(paramzzby.zzgt.zzak(b)); 
    Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = paramzzby.zzgt.zzds().iterator();
    while (iterator.hasNext())
      zzc(iterator.next()); 
  }
  
  public final int zzas() {
    byte b = 0;
    int i = 0;
    while (b < this.zzgt.zzdr()) {
      Map.Entry<FieldDescriptorType, Object> entry = this.zzgt.zzak(b);
      i += zzb((zzca)entry.getKey(), entry.getValue());
      b++;
    } 
    for (Map.Entry<FieldDescriptorType, Object> entry : this.zzgt.zzds())
      i += zzb((zzca)entry.getKey(), entry.getValue()); 
    return i;
  }
  
  public final int zzat() {
    byte b = 0;
    int i = 0;
    while (b < this.zzgt.zzdr()) {
      i += zzd(this.zzgt.zzak(b));
      b++;
    } 
    Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = this.zzgt.zzds().iterator();
    while (iterator.hasNext())
      i += zzd(iterator.next()); 
    return i;
  }
  
  public final void zzv() {
    if (this.zzgu)
      return; 
    this.zzgt.zzv();
    this.zzgu = true;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */