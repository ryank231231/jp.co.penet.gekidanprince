package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzcc extends zzip<zzcc> {
  public zzbl.zzb.zzb zzws = null;
  
  public String zzwt = null;
  
  public Boolean zzwu = null;
  
  public String[] zzwv = zziy.zzanv;
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzcc))
      return false; 
    paramObject = paramObject;
    zzbl.zzb.zzb zzb1 = this.zzws;
    if (zzb1 == null) {
      if (((zzcc)paramObject).zzws != null)
        return false; 
    } else if (!zzb1.equals(((zzcc)paramObject).zzws)) {
      return false;
    } 
    String str = this.zzwt;
    if (str == null) {
      if (((zzcc)paramObject).zzwt != null)
        return false; 
    } else if (!str.equals(((zzcc)paramObject).zzwt)) {
      return false;
    } 
    Boolean bool = this.zzwu;
    if (bool == null) {
      if (((zzcc)paramObject).zzwu != null)
        return false; 
    } else if (!bool.equals(((zzcc)paramObject).zzwu)) {
      return false;
    } 
    return !zzit.equals((Object[])this.zzwv, (Object[])((zzcc)paramObject).zzwv) ? false : ((this.zzand == null || this.zzand.isEmpty()) ? ((((zzcc)paramObject).zzand == null || ((zzcc)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzcc)paramObject).zzand));
  }
  
  public final int hashCode() {
    int j;
    int k;
    int m;
    int i = getClass().getName().hashCode();
    zzbl.zzb.zzb zzb1 = this.zzws;
    byte b = 0;
    if (zzb1 == null) {
      j = 0;
    } else {
      j = zzb1.hashCode();
    } 
    String str = this.zzwt;
    if (str == null) {
      k = 0;
    } else {
      k = str.hashCode();
    } 
    Boolean bool = this.zzwu;
    if (bool == null) {
      m = 0;
    } else {
      m = bool.hashCode();
    } 
    int n = zzit.hashCode((Object[])this.zzwv);
    int i1 = b;
    if (this.zzand != null)
      if (this.zzand.isEmpty()) {
        i1 = b;
      } else {
        i1 = this.zzand.hashCode();
      }  
    return (((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    zzbl.zzb.zzb zzb1 = this.zzws;
    if (zzb1 != null && zzb1 != null)
      paramzzin.zzc(1, zzb1.zzgp()); 
    String str = this.zzwt;
    if (str != null)
      paramzzin.zzb(2, str); 
    Boolean bool = this.zzwu;
    if (bool != null)
      paramzzin.zzb(3, bool.booleanValue()); 
    String[] arrayOfString = this.zzwv;
    if (arrayOfString != null && arrayOfString.length > 0) {
      byte b = 0;
      while (true) {
        arrayOfString = this.zzwv;
        if (b < arrayOfString.length) {
          String str1 = arrayOfString[b];
          if (str1 != null)
            paramzzin.zzb(4, str1); 
          b++;
          continue;
        } 
        break;
      } 
    } 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    zzbl.zzb.zzb zzb1 = this.zzws;
    int j = i;
    if (zzb1 != null) {
      j = i;
      if (zzb1 != null)
        j = i + zzin.zzg(1, zzb1.zzgp()); 
    } 
    String str = this.zzwt;
    i = j;
    if (str != null)
      i = j + zzin.zzc(2, str); 
    Boolean bool = this.zzwu;
    j = i;
    if (bool != null) {
      bool.booleanValue();
      j = i + zzin.zzaj(3) + 1;
    } 
    String[] arrayOfString = this.zzwv;
    i = j;
    if (arrayOfString != null) {
      i = j;
      if (arrayOfString.length > 0) {
        i = 0;
        int k = 0;
        int m = 0;
        while (true) {
          arrayOfString = this.zzwv;
          if (i < arrayOfString.length) {
            String str1 = arrayOfString[i];
            int n = k;
            int i1 = m;
            if (str1 != null) {
              i1 = m + 1;
              n = k + zzin.zzcp(str1);
            } 
            i++;
            k = n;
            m = i1;
            continue;
          } 
          i = j + k + m * 1;
          break;
        } 
      } 
    } 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */