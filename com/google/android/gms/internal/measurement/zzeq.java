package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzeq<FieldDescriptorType extends zzes<FieldDescriptorType>> {
  private static final zzeq zzadt = new zzeq(true);
  
  private final zzhb<FieldDescriptorType, Object> zzadq = zzhb.zzbe(16);
  
  private boolean zzadr;
  
  private boolean zzads = false;
  
  private zzeq() {}
  
  private zzeq(boolean paramBoolean) {
    zzjz();
  }
  
  static int zza(zzif paramzzif, int paramInt, Object paramObject) {
    int i = zzeg.zzaj(paramInt);
    paramInt = i;
    if (paramzzif == zzif.zzama) {
      zzfb.zzf((zzgh)paramObject);
      paramInt = i << 1;
    } 
    return paramInt + zzb(paramzzif, paramObject);
  }
  
  private final Object zza(FieldDescriptorType paramFieldDescriptorType) {
    paramFieldDescriptorType = (FieldDescriptorType)this.zzadq.get(paramFieldDescriptorType);
    return (paramFieldDescriptorType instanceof zzfk) ? zzfk.zzne() : (Object)paramFieldDescriptorType;
  }
  
  static void zza(zzeg paramzzeg, zzif paramzzif, int paramInt, Object paramObject) throws IOException {
    zzgh zzgh;
    byte[] arrayOfByte;
    if (paramzzif == zzif.zzama) {
      zzgh = (zzgh)paramObject;
      zzfb.zzf(zzgh);
      paramzzeg.zzb(paramInt, 3);
      zzgh.zzb(paramzzeg);
      paramzzeg.zzb(paramInt, 4);
      return;
    } 
    paramzzeg.zzb(paramInt, zzgh.zzpc());
    switch (zzer.zzacu[zzgh.ordinal()]) {
      default:
        return;
      case 18:
        if (paramObject instanceof zzfc) {
          paramzzeg.zzaf(((zzfc)paramObject).zzgp());
          return;
        } 
        paramzzeg.zzaf(((Integer)paramObject).intValue());
      case 17:
        paramzzeg.zzar(((Long)paramObject).longValue());
        return;
      case 16:
        paramzzeg.zzah(((Integer)paramObject).intValue());
        return;
      case 15:
        paramzzeg.zzas(((Long)paramObject).longValue());
        return;
      case 14:
        paramzzeg.zzai(((Integer)paramObject).intValue());
        return;
      case 13:
        paramzzeg.zzag(((Integer)paramObject).intValue());
        return;
      case 12:
        if (paramObject instanceof zzdp) {
          paramzzeg.zza((zzdp)paramObject);
          return;
        } 
        arrayOfByte = (byte[])paramObject;
        paramzzeg.zze(arrayOfByte, 0, arrayOfByte.length);
        return;
      case 11:
        if (paramObject instanceof zzdp) {
          paramzzeg.zza((zzdp)paramObject);
          return;
        } 
        paramzzeg.zzco((String)paramObject);
        return;
      case 10:
        paramzzeg.zzb((zzgh)paramObject);
        return;
      case 9:
        ((zzgh)paramObject).zzb(paramzzeg);
        return;
      case 8:
        paramzzeg.zzm(((Boolean)paramObject).booleanValue());
        return;
      case 7:
        paramzzeg.zzai(((Integer)paramObject).intValue());
        return;
      case 6:
        paramzzeg.zzas(((Long)paramObject).longValue());
        return;
      case 5:
        paramzzeg.zzaf(((Integer)paramObject).intValue());
        return;
      case 4:
        paramzzeg.zzaq(((Long)paramObject).longValue());
        return;
      case 3:
        paramzzeg.zzaq(((Long)paramObject).longValue());
        return;
      case 2:
        paramzzeg.zza(((Float)paramObject).floatValue());
        return;
      case 1:
        break;
    } 
    paramzzeg.zzd(((Double)paramObject).doubleValue());
  }
  
  private final void zza(FieldDescriptorType paramFieldDescriptorType, Object paramObject) {
    if (paramFieldDescriptorType.zzmc()) {
      if (paramObject instanceof List) {
        ArrayList arrayList1 = new ArrayList();
        arrayList1.addAll((List)paramObject);
        ArrayList arrayList2 = arrayList1;
        int i = arrayList2.size();
        byte b = 0;
        while (b < i) {
          paramObject = arrayList2.get(b);
          b++;
          zza(paramFieldDescriptorType.zzma(), paramObject);
        } 
        paramObject = arrayList1;
      } else {
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      } 
    } else {
      zza(paramFieldDescriptorType.zzma(), paramObject);
    } 
    if (paramObject instanceof zzfk)
      this.zzads = true; 
    this.zzadq.zza(paramFieldDescriptorType, paramObject);
  }
  
  private static void zza(zzif paramzzif, Object paramObject) {
    zzfb.checkNotNull(paramObject);
    int i = zzer.zzadu[paramzzif.zzpb().ordinal()];
    boolean bool = false;
    switch (i) {
      case 9:
        if (paramObject instanceof zzgh || paramObject instanceof zzfk)
          bool = true; 
        break;
      case 8:
        if (paramObject instanceof Integer || paramObject instanceof zzfc)
          bool = true; 
        break;
      case 7:
        if (paramObject instanceof zzdp || paramObject instanceof byte[])
          bool = true; 
        break;
      case 6:
        bool = paramObject instanceof String;
        break;
      case 5:
        bool = paramObject instanceof Boolean;
        break;
      case 4:
        bool = paramObject instanceof Double;
        break;
      case 3:
        bool = paramObject instanceof Float;
        break;
      case 2:
        bool = paramObject instanceof Long;
        break;
      case 1:
        bool = paramObject instanceof Integer;
        break;
    } 
    if (bool)
      return; 
    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
  }
  
  private static int zzb(zzes<?> paramzzes, Object paramObject) {
    zzif zzif = paramzzes.zzma();
    int i = paramzzes.zzgp();
    if (paramzzes.zzmc()) {
      boolean bool = paramzzes.zzmd();
      boolean bool1 = false;
      int j = 0;
      if (bool) {
        Iterator iterator1 = ((List)paramObject).iterator();
        while (iterator1.hasNext())
          j += zzb(zzif, iterator1.next()); 
        return zzeg.zzaj(i) + j + zzeg.zzar(j);
      } 
      Iterator iterator = ((List)paramObject).iterator();
      for (j = bool1; iterator.hasNext(); j += zza(zzif, i, iterator.next()));
      return j;
    } 
    return zza(zzif, i, paramObject);
  }
  
  private static int zzb(zzif paramzzif, Object paramObject) {
    switch (zzer.zzacu[paramzzif.ordinal()]) {
      default:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      case 18:
        return (paramObject instanceof zzfc) ? zzeg.zzap(((zzfc)paramObject).zzgp()) : zzeg.zzap(((Integer)paramObject).intValue());
      case 17:
        return zzeg.zzav(((Long)paramObject).longValue());
      case 16:
        return zzeg.zzam(((Integer)paramObject).intValue());
      case 15:
        return zzeg.zzax(((Long)paramObject).longValue());
      case 14:
        return zzeg.zzao(((Integer)paramObject).intValue());
      case 13:
        return zzeg.zzal(((Integer)paramObject).intValue());
      case 12:
        return (paramObject instanceof zzdp) ? zzeg.zzb((zzdp)paramObject) : zzeg.zzi((byte[])paramObject);
      case 11:
        return (paramObject instanceof zzdp) ? zzeg.zzb((zzdp)paramObject) : zzeg.zzcp((String)paramObject);
      case 10:
        return (paramObject instanceof zzfk) ? zzeg.zza((zzfk)paramObject) : zzeg.zzc((zzgh)paramObject);
      case 9:
        return zzeg.zzd((zzgh)paramObject);
      case 8:
        return zzeg.zzn(((Boolean)paramObject).booleanValue());
      case 7:
        return zzeg.zzan(((Integer)paramObject).intValue());
      case 6:
        return zzeg.zzaw(((Long)paramObject).longValue());
      case 5:
        return zzeg.zzak(((Integer)paramObject).intValue());
      case 4:
        return zzeg.zzau(((Long)paramObject).longValue());
      case 3:
        return zzeg.zzat(((Long)paramObject).longValue());
      case 2:
        return zzeg.zzb(((Float)paramObject).floatValue());
      case 1:
        break;
    } 
    return zzeg.zze(((Double)paramObject).doubleValue());
  }
  
  private static boolean zzb(Map.Entry<FieldDescriptorType, Object> paramEntry) {
    zzes zzes = (zzes)paramEntry.getKey();
    if (zzes.zzmb() == zzik.zzamu) {
      Iterator<zzgh> iterator;
      if (zzes.zzmc()) {
        iterator = ((List)paramEntry.getValue()).iterator();
        while (iterator.hasNext()) {
          if (!((zzgh)iterator.next()).isInitialized())
            return false; 
        } 
      } else {
        iterator = iterator.getValue();
        if (iterator instanceof zzgh) {
          if (!((zzgh)iterator).isInitialized())
            return false; 
        } else {
          if (iterator instanceof zzfk)
            return true; 
          throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } 
      } 
    } 
    return true;
  }
  
  private final void zzc(Map.Entry<FieldDescriptorType, Object> paramEntry) {
    zzes zzes = (zzes)paramEntry.getKey();
    Object object2 = paramEntry.getValue();
    object1 = object2;
    if (object2 instanceof zzfk)
      object1 = zzfk.zzne(); 
    if (zzes.zzmc()) {
      null = zza((FieldDescriptorType)zzes);
      object2 = null;
      if (null == null)
        object2 = new ArrayList(); 
      for (Object object1 : object1)
        ((List<Object>)object2).add(zzj(object1)); 
      this.zzadq.zza((FieldDescriptorType)zzes, object2);
      return;
    } 
    if (zzes.zzmb() == zzik.zzamu) {
      object2 = zza((FieldDescriptorType)zzes);
      if (object2 == null) {
        this.zzadq.zza((FieldDescriptorType)zzes, zzj(object1));
        return;
      } 
      if (object2 instanceof zzgo) {
        object1 = zzes.zza((zzgo)object2, (zzgo)object1);
      } else {
        object1 = zzes.zza(((zzgh)object2).zzmk(), (zzgh)object1).zzmr();
      } 
      this.zzadq.zza((FieldDescriptorType)zzes, object1);
      return;
    } 
    this.zzadq.zza((FieldDescriptorType)zzes, zzj(object1));
  }
  
  private static int zzd(Map.Entry<FieldDescriptorType, Object> paramEntry) {
    zzes<?> zzes = (zzes)paramEntry.getKey();
    Object object = paramEntry.getValue();
    return (zzes.zzmb() == zzik.zzamu && !zzes.zzmc() && !zzes.zzmd()) ? ((object instanceof zzfk) ? zzeg.zzb(((zzes)paramEntry.getKey()).zzgp(), (zzfk)object) : zzeg.zzd(((zzes)paramEntry.getKey()).zzgp(), (zzgh)object)) : zzb(zzes, object);
  }
  
  private static Object zzj(Object paramObject) {
    if (paramObject instanceof zzgo)
      return ((zzgo)paramObject).zznv(); 
    if (paramObject instanceof byte[]) {
      byte[] arrayOfByte = (byte[])paramObject;
      paramObject = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, paramObject, 0, arrayOfByte.length);
      return paramObject;
    } 
    return paramObject;
  }
  
  public static <T extends zzes<T>> zzeq<T> zzlx() {
    return zzadt;
  }
  
  final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
    return this.zzads ? new zzfn<FieldDescriptorType>(this.zzadq.zzok().iterator()) : this.zzadq.zzok().iterator();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzeq))
      return false; 
    paramObject = paramObject;
    return this.zzadq.equals(((zzeq)paramObject).zzadq);
  }
  
  public final int hashCode() {
    return this.zzadq.hashCode();
  }
  
  final boolean isEmpty() {
    return this.zzadq.isEmpty();
  }
  
  public final boolean isImmutable() {
    return this.zzadr;
  }
  
  public final boolean isInitialized() {
    for (byte b = 0; b < this.zzadq.zzoi(); b++) {
      if (!zzb(this.zzadq.zzbf(b)))
        return false; 
    } 
    Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = this.zzadq.zzoj().iterator();
    while (iterator.hasNext()) {
      if (!zzb(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
    return this.zzads ? new zzfn<FieldDescriptorType>(this.zzadq.entrySet().iterator()) : this.zzadq.entrySet().iterator();
  }
  
  public final void zza(zzeq<FieldDescriptorType> paramzzeq) {
    for (byte b = 0; b < paramzzeq.zzadq.zzoi(); b++)
      zzc(paramzzeq.zzadq.zzbf(b)); 
    Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = paramzzeq.zzadq.zzoj().iterator();
    while (iterator.hasNext())
      zzc(iterator.next()); 
  }
  
  public final void zzjz() {
    if (this.zzadr)
      return; 
    this.zzadq.zzjz();
    this.zzadr = true;
  }
  
  public final int zzly() {
    byte b = 0;
    int i = 0;
    while (b < this.zzadq.zzoi()) {
      Map.Entry<FieldDescriptorType, Object> entry = this.zzadq.zzbf(b);
      i += zzb((zzes)entry.getKey(), entry.getValue());
      b++;
    } 
    for (Map.Entry<FieldDescriptorType, Object> entry : this.zzadq.zzoj())
      i += zzb((zzes)entry.getKey(), entry.getValue()); 
    return i;
  }
  
  public final int zzlz() {
    byte b = 0;
    int i = 0;
    while (b < this.zzadq.zzoi()) {
      i += zzd(this.zzadq.zzbf(b));
      b++;
    } 
    Iterator<Map.Entry<FieldDescriptorType, Object>> iterator = this.zzadq.zzoj().iterator();
    while (iterator.hasNext())
      i += zzd(iterator.next()); 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */