package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Arrays;

public final class zzha extends zzfu<zzha> implements Cloneable {
  private String tag = "";
  
  public long zzbjf = 0L;
  
  public long zzbjg = 0L;
  
  private long zzbjh = 0L;
  
  public int zzbji = 0;
  
  private String zzbjj = "";
  
  private int zzbjk = 0;
  
  private boolean zzbjl = false;
  
  private zzhb[] zzbjm = zzhb.zzge();
  
  private byte[] zzbjn = zzgb.zzse;
  
  private zzge.zzd zzbjo = null;
  
  public byte[] zzbjp = zzgb.zzse;
  
  private String zzbjq = "";
  
  private String zzbjr = "";
  
  private zzgy zzbjs = null;
  
  private String zzbjt = "";
  
  public long zzbju = 180000L;
  
  private zzgz zzbjv = null;
  
  public byte[] zzbjw = zzgb.zzse;
  
  private String zzbjx = "";
  
  private int zzbjy = 0;
  
  private int[] zzbjz = zzgb.zzrx;
  
  private long zzbka = 0L;
  
  private zzge.zzs zzbkb = null;
  
  public boolean zzbkc = false;
  
  private final zzha zzgd() {
    try {
      zzha zzha1 = super.zzeo();
      zzhb[] arrayOfZzhb = this.zzbjm;
      if (arrayOfZzhb != null && arrayOfZzhb.length > 0) {
        zzha1.zzbjm = new zzhb[arrayOfZzhb.length];
        byte b = 0;
        while (true) {
          arrayOfZzhb = this.zzbjm;
          if (b < arrayOfZzhb.length) {
            if (arrayOfZzhb[b] != null)
              zzha1.zzbjm[b] = (zzhb)arrayOfZzhb[b].clone(); 
            b++;
            continue;
          } 
          break;
        } 
      } 
      zzge.zzd zzd1 = this.zzbjo;
      if (zzd1 != null)
        zzha1.zzbjo = zzd1; 
      zzgy zzgy1 = this.zzbjs;
      if (zzgy1 != null)
        zzha1.zzbjs = (zzgy)zzgy1.clone(); 
      zzgz zzgz1 = this.zzbjv;
      if (zzgz1 != null)
        zzha1.zzbjv = (zzgz)zzgz1.clone(); 
      int[] arrayOfInt = this.zzbjz;
      if (arrayOfInt != null && arrayOfInt.length > 0)
        zzha1.zzbjz = (int[])arrayOfInt.clone(); 
      zzge.zzs zzs1 = this.zzbkb;
      if (zzs1 != null)
        zzha1.zzbkb = zzs1; 
      return zzha1;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzha))
      return false; 
    paramObject = paramObject;
    if (this.zzbjf != ((zzha)paramObject).zzbjf)
      return false; 
    if (this.zzbjg != ((zzha)paramObject).zzbjg)
      return false; 
    String str4 = this.tag;
    if (str4 == null) {
      if (((zzha)paramObject).tag != null)
        return false; 
    } else if (!str4.equals(((zzha)paramObject).tag)) {
      return false;
    } 
    if (this.zzbji != ((zzha)paramObject).zzbji)
      return false; 
    str4 = this.zzbjj;
    if (str4 == null) {
      if (((zzha)paramObject).zzbjj != null)
        return false; 
    } else if (!str4.equals(((zzha)paramObject).zzbjj)) {
      return false;
    } 
    if (!zzfy.equals((Object[])this.zzbjm, (Object[])((zzha)paramObject).zzbjm))
      return false; 
    if (!Arrays.equals(this.zzbjn, ((zzha)paramObject).zzbjn))
      return false; 
    zzge.zzd zzd1 = this.zzbjo;
    if (zzd1 == null) {
      if (((zzha)paramObject).zzbjo != null)
        return false; 
    } else if (!zzd1.equals(((zzha)paramObject).zzbjo)) {
      return false;
    } 
    if (!Arrays.equals(this.zzbjp, ((zzha)paramObject).zzbjp))
      return false; 
    String str3 = this.zzbjq;
    if (str3 == null) {
      if (((zzha)paramObject).zzbjq != null)
        return false; 
    } else if (!str3.equals(((zzha)paramObject).zzbjq)) {
      return false;
    } 
    str3 = this.zzbjr;
    if (str3 == null) {
      if (((zzha)paramObject).zzbjr != null)
        return false; 
    } else if (!str3.equals(((zzha)paramObject).zzbjr)) {
      return false;
    } 
    zzgy zzgy1 = this.zzbjs;
    if (zzgy1 == null) {
      if (((zzha)paramObject).zzbjs != null)
        return false; 
    } else if (!zzgy1.equals(((zzha)paramObject).zzbjs)) {
      return false;
    } 
    String str2 = this.zzbjt;
    if (str2 == null) {
      if (((zzha)paramObject).zzbjt != null)
        return false; 
    } else if (!str2.equals(((zzha)paramObject).zzbjt)) {
      return false;
    } 
    if (this.zzbju != ((zzha)paramObject).zzbju)
      return false; 
    zzgz zzgz1 = this.zzbjv;
    if (zzgz1 == null) {
      if (((zzha)paramObject).zzbjv != null)
        return false; 
    } else if (!zzgz1.equals(((zzha)paramObject).zzbjv)) {
      return false;
    } 
    if (!Arrays.equals(this.zzbjw, ((zzha)paramObject).zzbjw))
      return false; 
    String str1 = this.zzbjx;
    if (str1 == null) {
      if (((zzha)paramObject).zzbjx != null)
        return false; 
    } else if (!str1.equals(((zzha)paramObject).zzbjx)) {
      return false;
    } 
    if (!zzfy.equals(this.zzbjz, ((zzha)paramObject).zzbjz))
      return false; 
    zzge.zzs zzs1 = this.zzbkb;
    if (zzs1 == null) {
      if (((zzha)paramObject).zzbkb != null)
        return false; 
    } else if (!zzs1.equals(((zzha)paramObject).zzbkb)) {
      return false;
    } 
    return (this.zzbkc != ((zzha)paramObject).zzbkc) ? false : ((this.zzrj == null || this.zzrj.isEmpty()) ? ((((zzha)paramObject).zzrj == null || ((zzha)paramObject).zzrj.isEmpty())) : this.zzrj.equals(((zzha)paramObject).zzrj));
  }
  
  public final int hashCode() {
    int m;
    int i1;
    int i4;
    int i6;
    int i7;
    int i8;
    int i9;
    int i11;
    int i13;
    int i15;
    int i = getClass().getName().hashCode();
    long l = this.zzbjf;
    int j = (int)(l ^ l >>> 32L);
    l = this.zzbjg;
    int k = (int)(l ^ l >>> 32L);
    String str4 = this.tag;
    byte b = 0;
    if (str4 == null) {
      m = 0;
    } else {
      m = str4.hashCode();
    } 
    int n = this.zzbji;
    str4 = this.zzbjj;
    if (str4 == null) {
      i1 = 0;
    } else {
      i1 = str4.hashCode();
    } 
    char c = 'ӕ';
    int i2 = zzfy.hashCode((Object[])this.zzbjm);
    int i3 = Arrays.hashCode(this.zzbjn);
    zzge.zzd zzd1 = this.zzbjo;
    if (zzd1 == null) {
      i4 = 0;
    } else {
      i4 = zzd1.hashCode();
    } 
    int i5 = Arrays.hashCode(this.zzbjp);
    String str3 = this.zzbjq;
    if (str3 == null) {
      i6 = 0;
    } else {
      i6 = str3.hashCode();
    } 
    str3 = this.zzbjr;
    if (str3 == null) {
      i7 = 0;
    } else {
      i7 = str3.hashCode();
    } 
    zzgy zzgy1 = this.zzbjs;
    if (zzgy1 == null) {
      i8 = 0;
    } else {
      i8 = zzgy1.hashCode();
    } 
    String str2 = this.zzbjt;
    if (str2 == null) {
      i9 = 0;
    } else {
      i9 = str2.hashCode();
    } 
    l = this.zzbju;
    int i10 = (int)(l ^ l >>> 32L);
    zzgz zzgz1 = this.zzbjv;
    if (zzgz1 == null) {
      i11 = 0;
    } else {
      i11 = zzgz1.hashCode();
    } 
    int i12 = Arrays.hashCode(this.zzbjw);
    String str1 = this.zzbjx;
    if (str1 == null) {
      i13 = 0;
    } else {
      i13 = str1.hashCode();
    } 
    int i14 = zzfy.hashCode(this.zzbjz);
    zzge.zzs zzs1 = this.zzbkb;
    if (zzs1 == null) {
      i15 = 0;
    } else {
      i15 = zzs1.hashCode();
    } 
    if (this.zzbkc)
      c = 'ӏ'; 
    int i16 = b;
    if (this.zzrj != null)
      if (this.zzrj.isEmpty()) {
        i16 = b;
      } else {
        i16 = this.zzrj.hashCode();
      }  
    return ((((((((((((((((((((((i + 527) * 31 + j) * 31 + k) * 31 * 31 + m) * 31 + n) * 31 + i1) * 31 * 31 + 1237) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + i13) * 31 * 31 + i14) * 31 * 31 + i15) * 31 + c) * 31 + i16;
  }
  
  public final void zza(zzfs paramzzfs) throws IOException {
    long l = this.zzbjf;
    if (l != 0L)
      paramzzfs.zzi(1, l); 
    String str4 = this.tag;
    if (str4 != null && !str4.equals(""))
      paramzzfs.zza(2, this.tag); 
    zzhb[] arrayOfZzhb = this.zzbjm;
    boolean bool = false;
    if (arrayOfZzhb != null && arrayOfZzhb.length > 0) {
      byte b = 0;
      while (true) {
        arrayOfZzhb = this.zzbjm;
        if (b < arrayOfZzhb.length) {
          zzhb zzhb1 = arrayOfZzhb[b];
          if (zzhb1 != null)
            paramzzfs.zza(3, zzhb1); 
          b++;
          continue;
        } 
        break;
      } 
    } 
    if (!Arrays.equals(this.zzbjn, zzgb.zzse))
      paramzzfs.zza(4, this.zzbjn); 
    if (!Arrays.equals(this.zzbjp, zzgb.zzse))
      paramzzfs.zza(6, this.zzbjp); 
    zzgy zzgy1 = this.zzbjs;
    if (zzgy1 != null)
      paramzzfs.zza(7, zzgy1); 
    String str3 = this.zzbjq;
    if (str3 != null && !str3.equals(""))
      paramzzfs.zza(8, this.zzbjq); 
    zzge.zzd zzd1 = this.zzbjo;
    if (zzd1 != null)
      paramzzfs.zze(9, zzd1); 
    int i = this.zzbji;
    if (i != 0)
      paramzzfs.zzc(11, i); 
    String str2 = this.zzbjr;
    if (str2 != null && !str2.equals(""))
      paramzzfs.zza(13, this.zzbjr); 
    str2 = this.zzbjt;
    if (str2 != null && !str2.equals(""))
      paramzzfs.zza(14, this.zzbjt); 
    l = this.zzbju;
    if (l != 180000L) {
      paramzzfs.zzb(15, 0);
      paramzzfs.zzn(zzfs.zzj(l));
    } 
    zzgz zzgz1 = this.zzbjv;
    if (zzgz1 != null)
      paramzzfs.zza(16, zzgz1); 
    l = this.zzbjg;
    if (l != 0L)
      paramzzfs.zzi(17, l); 
    if (!Arrays.equals(this.zzbjw, zzgb.zzse))
      paramzzfs.zza(18, this.zzbjw); 
    int[] arrayOfInt = this.zzbjz;
    if (arrayOfInt != null && arrayOfInt.length > 0) {
      i = bool;
      while (true) {
        arrayOfInt = this.zzbjz;
        if (i < arrayOfInt.length) {
          paramzzfs.zzc(20, arrayOfInt[i]);
          i++;
          continue;
        } 
        break;
      } 
    } 
    zzge.zzs zzs1 = this.zzbkb;
    if (zzs1 != null)
      paramzzfs.zze(23, zzs1); 
    String str1 = this.zzbjx;
    if (str1 != null && !str1.equals(""))
      paramzzfs.zza(24, this.zzbjx); 
    boolean bool1 = this.zzbkc;
    if (bool1)
      paramzzfs.zzb(25, bool1); 
    str1 = this.zzbjj;
    if (str1 != null && !str1.equals(""))
      paramzzfs.zza(26, this.zzbjj); 
    super.zza(paramzzfs);
  }
  
  protected final int zzen() {
    int i = super.zzen();
    long l = this.zzbjf;
    int j = i;
    if (l != 0L)
      j = i + zzfs.zzd(1, l); 
    String str4 = this.tag;
    i = j;
    if (str4 != null) {
      i = j;
      if (!str4.equals(""))
        i = j + zzfs.zzb(2, this.tag); 
    } 
    zzhb[] arrayOfZzhb = this.zzbjm;
    boolean bool = false;
    j = i;
    if (arrayOfZzhb != null) {
      j = i;
      if (arrayOfZzhb.length > 0) {
        j = 0;
        while (true) {
          arrayOfZzhb = this.zzbjm;
          if (j < arrayOfZzhb.length) {
            zzhb zzhb1 = arrayOfZzhb[j];
            int m = i;
            if (zzhb1 != null)
              m = i + zzfs.zzb(3, zzhb1); 
            j++;
            i = m;
            continue;
          } 
          j = i;
          break;
        } 
      } 
    } 
    i = j;
    if (!Arrays.equals(this.zzbjn, zzgb.zzse))
      i = j + zzfs.zzb(4, this.zzbjn); 
    j = i;
    if (!Arrays.equals(this.zzbjp, zzgb.zzse))
      j = i + zzfs.zzb(6, this.zzbjp); 
    zzgy zzgy1 = this.zzbjs;
    i = j;
    if (zzgy1 != null)
      i = j + zzfs.zzb(7, zzgy1); 
    String str3 = this.zzbjq;
    int k = i;
    if (str3 != null) {
      k = i;
      if (!str3.equals(""))
        k = i + zzfs.zzb(8, this.zzbjq); 
    } 
    zzge.zzd zzd1 = this.zzbjo;
    j = k;
    if (zzd1 != null)
      j = k + zzbn.zzc(9, zzd1); 
    k = this.zzbji;
    i = j;
    if (k != 0)
      i = j + zzfs.zzr(11) + zzfs.zzs(k); 
    String str2 = this.zzbjr;
    j = i;
    if (str2 != null) {
      j = i;
      if (!str2.equals(""))
        j = i + zzfs.zzb(13, this.zzbjr); 
    } 
    str2 = this.zzbjt;
    i = j;
    if (str2 != null) {
      i = j;
      if (!str2.equals(""))
        i = j + zzfs.zzb(14, this.zzbjt); 
    } 
    l = this.zzbju;
    j = i;
    if (l != 180000L)
      j = i + zzfs.zzr(15) + zzfs.zzo(zzfs.zzj(l)); 
    zzgz zzgz1 = this.zzbjv;
    i = j;
    if (zzgz1 != null)
      i = j + zzfs.zzb(16, zzgz1); 
    l = this.zzbjg;
    j = i;
    if (l != 0L)
      j = i + zzfs.zzd(17, l); 
    i = j;
    if (!Arrays.equals(this.zzbjw, zzgb.zzse))
      i = j + zzfs.zzb(18, this.zzbjw); 
    int[] arrayOfInt = this.zzbjz;
    j = i;
    if (arrayOfInt != null) {
      j = i;
      if (arrayOfInt.length > 0) {
        k = 0;
        j = bool;
        while (true) {
          arrayOfInt = this.zzbjz;
          if (j < arrayOfInt.length) {
            k += zzfs.zzs(arrayOfInt[j]);
            j++;
            continue;
          } 
          j = i + k + arrayOfInt.length * 2;
          break;
        } 
      } 
    } 
    zzge.zzs zzs1 = this.zzbkb;
    i = j;
    if (zzs1 != null)
      i = j + zzbn.zzc(23, zzs1); 
    String str1 = this.zzbjx;
    j = i;
    if (str1 != null) {
      j = i;
      if (!str1.equals(""))
        j = i + zzfs.zzb(24, this.zzbjx); 
    } 
    i = j;
    if (this.zzbkc)
      i = j + zzfs.zzr(25) + 1; 
    str1 = this.zzbjj;
    j = i;
    if (str1 != null) {
      j = i;
      if (!str1.equals(""))
        j = i + zzfs.zzb(26, this.zzbjj); 
    } 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */