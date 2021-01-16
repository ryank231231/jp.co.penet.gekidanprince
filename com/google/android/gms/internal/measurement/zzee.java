package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzee implements zzgx {
  private int tag;
  
  private final zzeb zzacr;
  
  private int zzacs;
  
  private int zzact = 0;
  
  private zzee(zzeb paramzzeb) {
    this.zzacr = zzfb.<zzeb>zza(paramzzeb, "input");
    this.zzacr.zzack = this;
  }
  
  public static zzee zza(zzeb paramzzeb) {
    return (paramzzeb.zzack != null) ? paramzzeb.zzack : new zzee(paramzzeb);
  }
  
  private final Object zza(zzif paramzzif, Class<?> paramClass, zzem paramzzem) throws IOException {
    switch (zzef.zzacu[paramzzif.ordinal()]) {
      default:
        throw new RuntimeException("unsupported field type.");
      case 17:
        return Long.valueOf(zzkk());
      case 16:
        return Integer.valueOf(zzks());
      case 15:
        return zzkq();
      case 14:
        return Long.valueOf(zzkx());
      case 13:
        return Integer.valueOf(zzkw());
      case 12:
        return Long.valueOf(zzkv());
      case 11:
        return Integer.valueOf(zzku());
      case 10:
        zzab(2);
        return zzc(zzgu.zznz().zzf(paramClass), paramzzem);
      case 9:
        return Long.valueOf(zzkl());
      case 8:
        return Integer.valueOf(zzkm());
      case 7:
        return Float.valueOf(readFloat());
      case 6:
        return Long.valueOf(zzkn());
      case 5:
        return Integer.valueOf(zzko());
      case 4:
        return Integer.valueOf(zzkt());
      case 3:
        return Double.valueOf(readDouble());
      case 2:
        return zzkr();
      case 1:
        break;
    } 
    return Boolean.valueOf(zzkp());
  }
  
  private final void zza(List<String> paramList, boolean paramBoolean) throws IOException {
    if ((this.tag & 0x7) == 2) {
      if (paramList instanceof zzfq && !paramBoolean) {
        paramList = paramList;
        while (true) {
          paramList.zzc(zzkr());
          if (this.zzacr.zzkz())
            return; 
          int i = this.zzacr.zzkj();
          if (i != this.tag) {
            this.zzact = i;
            return;
          } 
        } 
      } 
      while (true) {
        String str;
        if (paramBoolean) {
          str = zzkq();
        } else {
          str = readString();
        } 
        paramList.add(str);
        if (this.zzacr.zzkz())
          return; 
        int i = this.zzacr.zzkj();
        if (i != this.tag) {
          this.zzact = i;
          return;
        } 
      } 
    } 
    throw zzfh.zzmz();
  }
  
  private final void zzab(int paramInt) throws IOException {
    if ((this.tag & 0x7) == paramInt)
      return; 
    throw zzfh.zzmz();
  }
  
  private static void zzac(int paramInt) throws IOException {
    if ((paramInt & 0x7) == 0)
      return; 
    throw zzfh.zznb();
  }
  
  private static void zzad(int paramInt) throws IOException {
    if ((paramInt & 0x3) == 0)
      return; 
    throw zzfh.zznb();
  }
  
  private final void zzae(int paramInt) throws IOException {
    if (this.zzacr.zzla() == paramInt)
      return; 
    throw zzfh.zzmu();
  }
  
  private final <T> T zzc(zzgy<T> paramzzgy, zzem paramzzem) throws IOException {
    int i = this.zzacr.zzks();
    if (this.zzacr.zzach < this.zzacr.zzaci) {
      i = this.zzacr.zzx(i);
      T t = paramzzgy.newInstance();
      zzeb zzeb2 = this.zzacr;
      zzeb2.zzach++;
      paramzzgy.zza(t, this, paramzzem);
      paramzzgy.zzi(t);
      this.zzacr.zzu(0);
      zzeb zzeb1 = this.zzacr;
      zzeb1.zzach--;
      this.zzacr.zzy(i);
      return t;
    } 
    throw zzfh.zzna();
  }
  
  private final <T> T zzd(zzgy<T> paramzzgy, zzem paramzzem) throws IOException {
    int i = this.zzacs;
    this.zzacs = this.tag >>> 3 << 3 | 0x4;
    try {
      T t = paramzzgy.newInstance();
      paramzzgy.zza(t, this, paramzzem);
      paramzzgy.zzi(t);
      int j = this.tag;
      int k = this.zzacs;
      if (j == k)
        return t; 
      throw zzfh.zznb();
    } finally {
      this.zzacs = i;
    } 
  }
  
  public final int getTag() {
    return this.tag;
  }
  
  public final double readDouble() throws IOException {
    zzab(1);
    return this.zzacr.readDouble();
  }
  
  public final float readFloat() throws IOException {
    zzab(5);
    return this.zzacr.readFloat();
  }
  
  public final String readString() throws IOException {
    zzab(2);
    return this.zzacr.readString();
  }
  
  public final void readStringList(List<String> paramList) throws IOException {
    zza(paramList, false);
  }
  
  public final <T> T zza(zzgy<T> paramzzgy, zzem paramzzem) throws IOException {
    zzab(2);
    return zzc(paramzzgy, paramzzem);
  }
  
  public final <T> void zza(List<T> paramList, zzgy<T> paramzzgy, zzem paramzzem) throws IOException {
    int i = this.tag;
    if ((i & 0x7) == 2) {
      while (true) {
        paramList.add(zzc(paramzzgy, paramzzem));
        if (this.zzacr.zzkz() || this.zzact != 0)
          break; 
        int j = this.zzacr.zzkj();
        if (j != i) {
          this.zzact = j;
          return;
        } 
      } 
      return;
    } 
    throw zzfh.zzmz();
  }
  
  public final <K, V> void zza(Map<K, V> paramMap, zzga<K, V> paramzzga, zzem paramzzem) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: invokespecial zzab : (I)V
    //   5: aload_0
    //   6: getfield zzacr : Lcom/google/android/gms/internal/measurement/zzeb;
    //   9: invokevirtual zzks : ()I
    //   12: istore #4
    //   14: aload_0
    //   15: getfield zzacr : Lcom/google/android/gms/internal/measurement/zzeb;
    //   18: iload #4
    //   20: invokevirtual zzx : (I)I
    //   23: istore #4
    //   25: aload_2
    //   26: getfield zzait : Ljava/lang/Object;
    //   29: astore #5
    //   31: aload_2
    //   32: getfield zzzw : Ljava/lang/Object;
    //   35: astore #6
    //   37: aload_0
    //   38: invokevirtual zzlh : ()I
    //   41: istore #7
    //   43: iload #7
    //   45: ldc_w 2147483647
    //   48: if_icmpeq -> 190
    //   51: aload_0
    //   52: getfield zzacr : Lcom/google/android/gms/internal/measurement/zzeb;
    //   55: invokevirtual zzkz : ()Z
    //   58: istore #8
    //   60: iload #8
    //   62: ifne -> 190
    //   65: iload #7
    //   67: tableswitch default -> 88, 1 -> 122, 2 -> 97
    //   88: aload_0
    //   89: invokevirtual zzli : ()Z
    //   92: istore #8
    //   94: goto -> 141
    //   97: aload_0
    //   98: aload_2
    //   99: getfield zzaiu : Lcom/google/android/gms/internal/measurement/zzif;
    //   102: aload_2
    //   103: getfield zzzw : Ljava/lang/Object;
    //   106: invokevirtual getClass : ()Ljava/lang/Class;
    //   109: aload_3
    //   110: invokespecial zza : (Lcom/google/android/gms/internal/measurement/zzif;Ljava/lang/Class;Lcom/google/android/gms/internal/measurement/zzem;)Ljava/lang/Object;
    //   113: astore #9
    //   115: aload #9
    //   117: astore #6
    //   119: goto -> 37
    //   122: aload_0
    //   123: aload_2
    //   124: getfield zzais : Lcom/google/android/gms/internal/measurement/zzif;
    //   127: aconst_null
    //   128: aconst_null
    //   129: invokespecial zza : (Lcom/google/android/gms/internal/measurement/zzif;Ljava/lang/Class;Lcom/google/android/gms/internal/measurement/zzem;)Ljava/lang/Object;
    //   132: astore #9
    //   134: aload #9
    //   136: astore #5
    //   138: goto -> 37
    //   141: iload #8
    //   143: ifeq -> 149
    //   146: goto -> 37
    //   149: new com/google/android/gms/internal/measurement/zzfh
    //   152: astore #9
    //   154: aload #9
    //   156: ldc_w 'Unable to parse map entry.'
    //   159: invokespecial <init> : (Ljava/lang/String;)V
    //   162: aload #9
    //   164: athrow
    //   165: astore #9
    //   167: aload_0
    //   168: invokevirtual zzli : ()Z
    //   171: ifeq -> 177
    //   174: goto -> 37
    //   177: new com/google/android/gms/internal/measurement/zzfh
    //   180: astore_1
    //   181: aload_1
    //   182: ldc_w 'Unable to parse map entry.'
    //   185: invokespecial <init> : (Ljava/lang/String;)V
    //   188: aload_1
    //   189: athrow
    //   190: aload_1
    //   191: aload #5
    //   193: aload #6
    //   195: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_0
    //   202: getfield zzacr : Lcom/google/android/gms/internal/measurement/zzeb;
    //   205: iload #4
    //   207: invokevirtual zzy : (I)V
    //   210: return
    //   211: astore_1
    //   212: aload_0
    //   213: getfield zzacr : Lcom/google/android/gms/internal/measurement/zzeb;
    //   216: iload #4
    //   218: invokevirtual zzy : (I)V
    //   221: aload_1
    //   222: athrow
    // Exception table:
    //   from	to	target	type
    //   37	43	211	finally
    //   51	60	211	finally
    //   88	94	165	com/google/android/gms/internal/measurement/zzfi
    //   88	94	211	finally
    //   97	115	165	com/google/android/gms/internal/measurement/zzfi
    //   97	115	211	finally
    //   122	134	165	com/google/android/gms/internal/measurement/zzfi
    //   122	134	211	finally
    //   149	165	165	com/google/android/gms/internal/measurement/zzfi
    //   149	165	211	finally
    //   167	174	211	finally
    //   177	190	211	finally
    //   190	201	211	finally
  }
  
  public final <T> T zzb(zzgy<T> paramzzgy, zzem paramzzem) throws IOException {
    zzab(3);
    return zzd(paramzzgy, paramzzem);
  }
  
  public final <T> void zzb(List<T> paramList, zzgy<T> paramzzgy, zzem paramzzem) throws IOException {
    int i = this.tag;
    if ((i & 0x7) == 3) {
      while (true) {
        paramList.add(zzd(paramzzgy, paramzzem));
        if (this.zzacr.zzkz() || this.zzact != 0)
          break; 
        int j = this.zzacr.zzkj();
        if (j != i) {
          this.zzact = j;
          return;
        } 
      } 
      return;
    } 
    throw zzfh.zzmz();
  }
  
  public final void zzd(List<Double> paramList) throws IOException {
    int i;
    int j;
    if (paramList instanceof zzej) {
      int k;
      int m;
      paramList = paramList;
      switch (this.tag & 0x7) {
        default:
          throw zzfh.zzmz();
        case 2:
          k = this.zzacr.zzks();
          zzac(k);
          m = this.zzacr.zzla();
          do {
            paramList.zzf(this.zzacr.readDouble());
          } while (this.zzacr.zzla() < m + k);
          return;
        case 1:
          break;
      } 
      while (true) {
        paramList.zzf(this.zzacr.readDouble());
        if (this.zzacr.zzkz())
          return; 
        m = this.zzacr.zzkj();
        if (m != this.tag) {
          this.zzact = m;
          return;
        } 
      } 
    } 
    switch (this.tag & 0x7) {
      default:
        throw zzfh.zzmz();
      case 2:
        j = this.zzacr.zzks();
        zzac(j);
        i = this.zzacr.zzla();
        do {
          paramList.add(Double.valueOf(this.zzacr.readDouble()));
        } while (this.zzacr.zzla() < i + j);
        return;
      case 1:
        break;
    } 
    while (true) {
      paramList.add(Double.valueOf(this.zzacr.readDouble()));
      if (this.zzacr.zzkz())
        return; 
      j = this.zzacr.zzkj();
      if (j != this.tag) {
        this.zzact = j;
        return;
      } 
    } 
  }
  
  public final void zze(List<Float> paramList) throws IOException {
    if (paramList instanceof zzew) {
      paramList = paramList;
      int k = this.tag & 0x7;
      if (k != 2) {
        if (k == 5)
          while (true) {
            paramList.zzc(this.zzacr.readFloat());
            if (this.zzacr.zzkz())
              return; 
            k = this.zzacr.zzkj();
            if (k != this.tag) {
              this.zzact = k;
              return;
            } 
          }  
        throw zzfh.zzmz();
      } 
      int m = this.zzacr.zzks();
      zzad(m);
      k = this.zzacr.zzla();
      do {
        paramList.zzc(this.zzacr.readFloat());
      } while (this.zzacr.zzla() < k + m);
      return;
    } 
    int i = this.tag & 0x7;
    if (i != 2) {
      if (i == 5)
        while (true) {
          paramList.add(Float.valueOf(this.zzacr.readFloat()));
          if (this.zzacr.zzkz())
            return; 
          i = this.zzacr.zzkj();
          if (i != this.tag) {
            this.zzact = i;
            return;
          } 
        }  
      throw zzfh.zzmz();
    } 
    i = this.zzacr.zzks();
    zzad(i);
    int j = this.zzacr.zzla();
    do {
      paramList.add(Float.valueOf(this.zzacr.readFloat()));
    } while (this.zzacr.zzla() < j + i);
  }
  
  public final void zzf(List<Long> paramList) throws IOException {
    if (paramList instanceof zzfv) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzbb(this.zzacr.zzkk());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzbb(this.zzacr.zzkk());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Long.valueOf(this.zzacr.zzkk()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.zzacr.zzkk()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final void zzg(List<Long> paramList) throws IOException {
    if (paramList instanceof zzfv) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzbb(this.zzacr.zzkl());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzbb(this.zzacr.zzkl());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Long.valueOf(this.zzacr.zzkl()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.zzacr.zzkl()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final void zzh(List<Integer> paramList) throws IOException {
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzau(this.zzacr.zzkm());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzau(this.zzacr.zzkm());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.zzacr.zzkm()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.zzacr.zzkm()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final void zzi(List<Long> paramList) throws IOException {
    int i;
    int j;
    if (paramList instanceof zzfv) {
      int k;
      int m;
      paramList = paramList;
      switch (this.tag & 0x7) {
        default:
          throw zzfh.zzmz();
        case 2:
          k = this.zzacr.zzks();
          zzac(k);
          m = this.zzacr.zzla();
          do {
            paramList.zzbb(this.zzacr.zzkn());
          } while (this.zzacr.zzla() < m + k);
          return;
        case 1:
          break;
      } 
      while (true) {
        paramList.zzbb(this.zzacr.zzkn());
        if (this.zzacr.zzkz())
          return; 
        m = this.zzacr.zzkj();
        if (m != this.tag) {
          this.zzact = m;
          return;
        } 
      } 
    } 
    switch (this.tag & 0x7) {
      default:
        throw zzfh.zzmz();
      case 2:
        i = this.zzacr.zzks();
        zzac(i);
        j = this.zzacr.zzla();
        do {
          paramList.add(Long.valueOf(this.zzacr.zzkn()));
        } while (this.zzacr.zzla() < j + i);
        return;
      case 1:
        break;
    } 
    while (true) {
      paramList.add(Long.valueOf(this.zzacr.zzkn()));
      if (this.zzacr.zzkz())
        return; 
      j = this.zzacr.zzkj();
      if (j != this.tag) {
        this.zzact = j;
        return;
      } 
    } 
  }
  
  public final void zzj(List<Integer> paramList) throws IOException {
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int k = this.tag & 0x7;
      if (k != 2) {
        if (k == 5)
          while (true) {
            paramList.zzau(this.zzacr.zzko());
            if (this.zzacr.zzkz())
              return; 
            k = this.zzacr.zzkj();
            if (k != this.tag) {
              this.zzact = k;
              return;
            } 
          }  
        throw zzfh.zzmz();
      } 
      int m = this.zzacr.zzks();
      zzad(m);
      k = this.zzacr.zzla();
      do {
        paramList.zzau(this.zzacr.zzko());
      } while (this.zzacr.zzla() < k + m);
      return;
    } 
    int i = this.tag & 0x7;
    if (i != 2) {
      if (i == 5)
        while (true) {
          paramList.add(Integer.valueOf(this.zzacr.zzko()));
          if (this.zzacr.zzkz())
            return; 
          i = this.zzacr.zzkj();
          if (i != this.tag) {
            this.zzact = i;
            return;
          } 
        }  
      throw zzfh.zzmz();
    } 
    int j = this.zzacr.zzks();
    zzad(j);
    i = this.zzacr.zzla();
    do {
      paramList.add(Integer.valueOf(this.zzacr.zzko()));
    } while (this.zzacr.zzla() < i + j);
  }
  
  public final void zzk(List<Boolean> paramList) throws IOException {
    if (paramList instanceof zzdn) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.addBoolean(this.zzacr.zzkp());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.addBoolean(this.zzacr.zzkp());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Boolean.valueOf(this.zzacr.zzkp()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Boolean.valueOf(this.zzacr.zzkp()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final long zzkk() throws IOException {
    zzab(0);
    return this.zzacr.zzkk();
  }
  
  public final long zzkl() throws IOException {
    zzab(0);
    return this.zzacr.zzkl();
  }
  
  public final int zzkm() throws IOException {
    zzab(0);
    return this.zzacr.zzkm();
  }
  
  public final long zzkn() throws IOException {
    zzab(1);
    return this.zzacr.zzkn();
  }
  
  public final int zzko() throws IOException {
    zzab(5);
    return this.zzacr.zzko();
  }
  
  public final boolean zzkp() throws IOException {
    zzab(0);
    return this.zzacr.zzkp();
  }
  
  public final String zzkq() throws IOException {
    zzab(2);
    return this.zzacr.zzkq();
  }
  
  public final zzdp zzkr() throws IOException {
    zzab(2);
    return this.zzacr.zzkr();
  }
  
  public final int zzks() throws IOException {
    zzab(0);
    return this.zzacr.zzks();
  }
  
  public final int zzkt() throws IOException {
    zzab(0);
    return this.zzacr.zzkt();
  }
  
  public final int zzku() throws IOException {
    zzab(5);
    return this.zzacr.zzku();
  }
  
  public final long zzkv() throws IOException {
    zzab(1);
    return this.zzacr.zzkv();
  }
  
  public final int zzkw() throws IOException {
    zzab(0);
    return this.zzacr.zzkw();
  }
  
  public final long zzkx() throws IOException {
    zzab(0);
    return this.zzacr.zzkx();
  }
  
  public final void zzl(List<String> paramList) throws IOException {
    zza(paramList, true);
  }
  
  public final int zzlh() throws IOException {
    int i = this.zzact;
    if (i != 0) {
      this.tag = i;
      this.zzact = 0;
    } else {
      this.tag = this.zzacr.zzkj();
    } 
    i = this.tag;
    return (i == 0 || i == this.zzacs) ? Integer.MAX_VALUE : (i >>> 3);
  }
  
  public final boolean zzli() throws IOException {
    if (!this.zzacr.zzkz()) {
      int i = this.tag;
      if (i != this.zzacs)
        return this.zzacr.zzv(i); 
    } 
    return false;
  }
  
  public final void zzm(List<zzdp> paramList) throws IOException {
    if ((this.tag & 0x7) == 2)
      while (true) {
        paramList.add(zzkr());
        if (this.zzacr.zzkz())
          return; 
        int i = this.zzacr.zzkj();
        if (i != this.tag) {
          this.zzact = i;
          return;
        } 
      }  
    throw zzfh.zzmz();
  }
  
  public final void zzn(List<Integer> paramList) throws IOException {
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzau(this.zzacr.zzks());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzau(this.zzacr.zzks());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.zzacr.zzks()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.zzacr.zzks()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final void zzo(List<Integer> paramList) throws IOException {
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzau(this.zzacr.zzkt());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzau(this.zzacr.zzkt());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.zzacr.zzkt()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.zzacr.zzkt()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final void zzp(List<Integer> paramList) throws IOException {
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int k = this.tag & 0x7;
      if (k != 2) {
        if (k == 5)
          while (true) {
            paramList.zzau(this.zzacr.zzku());
            if (this.zzacr.zzkz())
              return; 
            k = this.zzacr.zzkj();
            if (k != this.tag) {
              this.zzact = k;
              return;
            } 
          }  
        throw zzfh.zzmz();
      } 
      k = this.zzacr.zzks();
      zzad(k);
      int m = this.zzacr.zzla();
      do {
        paramList.zzau(this.zzacr.zzku());
      } while (this.zzacr.zzla() < m + k);
      return;
    } 
    int i = this.tag & 0x7;
    if (i != 2) {
      if (i == 5)
        while (true) {
          paramList.add(Integer.valueOf(this.zzacr.zzku()));
          if (this.zzacr.zzkz())
            return; 
          i = this.zzacr.zzkj();
          if (i != this.tag) {
            this.zzact = i;
            return;
          } 
        }  
      throw zzfh.zzmz();
    } 
    i = this.zzacr.zzks();
    zzad(i);
    int j = this.zzacr.zzla();
    do {
      paramList.add(Integer.valueOf(this.zzacr.zzku()));
    } while (this.zzacr.zzla() < j + i);
  }
  
  public final void zzq(List<Long> paramList) throws IOException {
    int i;
    int j;
    if (paramList instanceof zzfv) {
      int k;
      int m;
      paramList = paramList;
      switch (this.tag & 0x7) {
        default:
          throw zzfh.zzmz();
        case 2:
          k = this.zzacr.zzks();
          zzac(k);
          m = this.zzacr.zzla();
          do {
            paramList.zzbb(this.zzacr.zzkv());
          } while (this.zzacr.zzla() < m + k);
          return;
        case 1:
          break;
      } 
      while (true) {
        paramList.zzbb(this.zzacr.zzkv());
        if (this.zzacr.zzkz())
          return; 
        m = this.zzacr.zzkj();
        if (m != this.tag) {
          this.zzact = m;
          return;
        } 
      } 
    } 
    switch (this.tag & 0x7) {
      default:
        throw zzfh.zzmz();
      case 2:
        i = this.zzacr.zzks();
        zzac(i);
        j = this.zzacr.zzla();
        do {
          paramList.add(Long.valueOf(this.zzacr.zzkv()));
        } while (this.zzacr.zzla() < j + i);
        return;
      case 1:
        break;
    } 
    while (true) {
      paramList.add(Long.valueOf(this.zzacr.zzkv()));
      if (this.zzacr.zzkz())
        return; 
      j = this.zzacr.zzkj();
      if (j != this.tag) {
        this.zzact = j;
        return;
      } 
    } 
  }
  
  public final void zzr(List<Integer> paramList) throws IOException {
    if (paramList instanceof zzfa) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzau(this.zzacr.zzkw());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzau(this.zzacr.zzkw());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Integer.valueOf(this.zzacr.zzkw()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Integer.valueOf(this.zzacr.zzkw()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
  
  public final void zzs(List<Long> paramList) throws IOException {
    if (paramList instanceof zzfv) {
      paramList = paramList;
      int j = this.tag & 0x7;
      if (j != 0) {
        if (j == 2) {
          j = this.zzacr.zzks();
          j = this.zzacr.zzla() + j;
          while (true) {
            paramList.zzbb(this.zzacr.zzkx());
            if (this.zzacr.zzla() >= j) {
              zzae(j);
              return;
            } 
          } 
        } 
        throw zzfh.zzmz();
      } 
      while (true) {
        paramList.zzbb(this.zzacr.zzkx());
        if (this.zzacr.zzkz())
          return; 
        j = this.zzacr.zzkj();
        if (j != this.tag) {
          this.zzact = j;
          return;
        } 
      } 
    } 
    int i = this.tag & 0x7;
    if (i != 0) {
      if (i == 2) {
        i = this.zzacr.zzks();
        i = this.zzacr.zzla() + i;
        while (true) {
          paramList.add(Long.valueOf(this.zzacr.zzkx()));
          if (this.zzacr.zzla() >= i) {
            zzae(i);
            return;
          } 
        } 
      } 
      throw zzfh.zzmz();
    } 
    while (true) {
      paramList.add(Long.valueOf(this.zzacr.zzkx()));
      if (this.zzacr.zzkz())
        return; 
      i = this.zzacr.zzkj();
      if (i != this.tag) {
        this.zzact = i;
        return;
      } 
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */