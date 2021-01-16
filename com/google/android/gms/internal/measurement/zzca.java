package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzca extends zzip<zzca> {
  public zzbl.zza.zzb zzwk = null;
  
  public Boolean zzwl = null;
  
  public String zzwm = null;
  
  public String zzwn = null;
  
  public String zzwo = null;
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzca))
      return false; 
    paramObject = paramObject;
    zzbl.zza.zzb zzb1 = this.zzwk;
    if (zzb1 == null) {
      if (((zzca)paramObject).zzwk != null)
        return false; 
    } else if (!zzb1.equals(((zzca)paramObject).zzwk)) {
      return false;
    } 
    Boolean bool = this.zzwl;
    if (bool == null) {
      if (((zzca)paramObject).zzwl != null)
        return false; 
    } else if (!bool.equals(((zzca)paramObject).zzwl)) {
      return false;
    } 
    String str = this.zzwm;
    if (str == null) {
      if (((zzca)paramObject).zzwm != null)
        return false; 
    } else if (!str.equals(((zzca)paramObject).zzwm)) {
      return false;
    } 
    str = this.zzwn;
    if (str == null) {
      if (((zzca)paramObject).zzwn != null)
        return false; 
    } else if (!str.equals(((zzca)paramObject).zzwn)) {
      return false;
    } 
    str = this.zzwo;
    if (str == null) {
      if (((zzca)paramObject).zzwo != null)
        return false; 
    } else if (!str.equals(((zzca)paramObject).zzwo)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzca)paramObject).zzand == null || ((zzca)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzca)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i = getClass().getName().hashCode();
    zzbl.zza.zzb zzb1 = this.zzwk;
    byte b = 0;
    if (zzb1 == null) {
      j = 0;
    } else {
      j = zzb1.hashCode();
    } 
    Boolean bool = this.zzwl;
    if (bool == null) {
      k = 0;
    } else {
      k = bool.hashCode();
    } 
    String str = this.zzwm;
    if (str == null) {
      m = 0;
    } else {
      m = str.hashCode();
    } 
    str = this.zzwn;
    if (str == null) {
      n = 0;
    } else {
      n = str.hashCode();
    } 
    str = this.zzwo;
    if (str == null) {
      i1 = 0;
    } else {
      i1 = str.hashCode();
    } 
    int i2 = b;
    if (this.zzand != null)
      if (this.zzand.isEmpty()) {
        i2 = b;
      } else {
        i2 = this.zzand.hashCode();
      }  
    return ((((((i + 527) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    zzbl.zza.zzb zzb1 = this.zzwk;
    if (zzb1 != null && zzb1 != null)
      paramzzin.zzc(1, zzb1.zzgp()); 
    Boolean bool = this.zzwl;
    if (bool != null)
      paramzzin.zzb(2, bool.booleanValue()); 
    String str = this.zzwm;
    if (str != null)
      paramzzin.zzb(3, str); 
    str = this.zzwn;
    if (str != null)
      paramzzin.zzb(4, str); 
    str = this.zzwo;
    if (str != null)
      paramzzin.zzb(5, str); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    zzbl.zza.zzb zzb1 = this.zzwk;
    int j = i;
    if (zzb1 != null) {
      j = i;
      if (zzb1 != null)
        j = i + zzin.zzg(1, zzb1.zzgp()); 
    } 
    Boolean bool = this.zzwl;
    i = j;
    if (bool != null) {
      bool.booleanValue();
      i = j + zzin.zzaj(2) + 1;
    } 
    String str = this.zzwm;
    j = i;
    if (str != null)
      j = i + zzin.zzc(3, str); 
    str = this.zzwn;
    i = j;
    if (str != null)
      i = j + zzin.zzc(4, str); 
    str = this.zzwo;
    j = i;
    if (str != null)
      j = i + zzin.zzc(5, str); 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */