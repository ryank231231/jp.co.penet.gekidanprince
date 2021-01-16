package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzcd extends zzip<zzcd> {
  private static volatile zzcd[] zzww;
  
  public String name = null;
  
  public Boolean zzwx = null;
  
  public Boolean zzwy = null;
  
  public Integer zzwz = null;
  
  public static zzcd[] zzje() {
    if (zzww == null)
      synchronized (zzit.zzanl) {
        if (zzww == null)
          zzww = new zzcd[0]; 
      }  
    return zzww;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzcd))
      return false; 
    paramObject = paramObject;
    String str = this.name;
    if (str == null) {
      if (((zzcd)paramObject).name != null)
        return false; 
    } else if (!str.equals(((zzcd)paramObject).name)) {
      return false;
    } 
    Boolean bool = this.zzwx;
    if (bool == null) {
      if (((zzcd)paramObject).zzwx != null)
        return false; 
    } else if (!bool.equals(((zzcd)paramObject).zzwx)) {
      return false;
    } 
    bool = this.zzwy;
    if (bool == null) {
      if (((zzcd)paramObject).zzwy != null)
        return false; 
    } else if (!bool.equals(((zzcd)paramObject).zzwy)) {
      return false;
    } 
    Integer integer = this.zzwz;
    if (integer == null) {
      if (((zzcd)paramObject).zzwz != null)
        return false; 
    } else if (!integer.equals(((zzcd)paramObject).zzwz)) {
      return false;
    } 
    return (this.zzand == null || this.zzand.isEmpty()) ? ((((zzcd)paramObject).zzand == null || ((zzcd)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzcd)paramObject).zzand);
  }
  
  public final int hashCode() {
    int j;
    int k;
    int m;
    int n;
    int i = getClass().getName().hashCode();
    String str = this.name;
    byte b = 0;
    if (str == null) {
      j = 0;
    } else {
      j = str.hashCode();
    } 
    Boolean bool = this.zzwx;
    if (bool == null) {
      k = 0;
    } else {
      k = bool.hashCode();
    } 
    bool = this.zzwy;
    if (bool == null) {
      m = 0;
    } else {
      m = bool.hashCode();
    } 
    Integer integer = this.zzwz;
    if (integer == null) {
      n = 0;
    } else {
      n = integer.hashCode();
    } 
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
    String str = this.name;
    if (str != null)
      paramzzin.zzb(1, str); 
    Boolean bool = this.zzwx;
    if (bool != null)
      paramzzin.zzb(2, bool.booleanValue()); 
    bool = this.zzwy;
    if (bool != null)
      paramzzin.zzb(3, bool.booleanValue()); 
    Integer integer = this.zzwz;
    if (integer != null)
      paramzzin.zzc(4, integer.intValue()); 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    String str = this.name;
    int j = i;
    if (str != null)
      j = i + zzin.zzc(1, str); 
    Boolean bool = this.zzwx;
    i = j;
    if (bool != null) {
      bool.booleanValue();
      i = j + zzin.zzaj(2) + 1;
    } 
    bool = this.zzwy;
    j = i;
    if (bool != null) {
      bool.booleanValue();
      j = i + zzin.zzaj(3) + 1;
    } 
    Integer integer = this.zzwz;
    i = j;
    if (integer != null)
      i = j + zzin.zzg(4, integer.intValue()); 
    return i;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */