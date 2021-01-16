package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzaf {
  final String name;
  
  final String zzcf;
  
  final long zzfe;
  
  final long zzff;
  
  final long zzfg;
  
  final long zzfh;
  
  final Long zzfi;
  
  final Long zzfj;
  
  final Long zzfk;
  
  final Boolean zzfl;
  
  zzaf(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Long paramLong5, Long paramLong6, Long paramLong7, Boolean paramBoolean) {
    boolean bool2;
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    boolean bool1 = true;
    if (paramLong1 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong2 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong4 >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    this.zzcf = paramString1;
    this.name = paramString2;
    this.zzfe = paramLong1;
    this.zzff = paramLong2;
    this.zzfg = paramLong3;
    this.zzfh = paramLong4;
    this.zzfi = paramLong5;
    this.zzfj = paramLong6;
    this.zzfk = paramLong7;
    this.zzfl = paramBoolean;
  }
  
  final zzaf zza(long paramLong1, long paramLong2) {
    return new zzaf(this.zzcf, this.name, this.zzfe, this.zzff, this.zzfg, paramLong1, Long.valueOf(paramLong2), this.zzfj, this.zzfk, this.zzfl);
  }
  
  final zzaf zza(Long paramLong1, Long paramLong2, Boolean paramBoolean) {
    if (paramBoolean != null && !paramBoolean.booleanValue())
      paramBoolean = null; 
    return new zzaf(this.zzcf, this.name, this.zzfe, this.zzff, this.zzfg, this.zzfh, this.zzfi, paramLong1, paramLong2, paramBoolean);
  }
  
  final zzaf zzw(long paramLong) {
    return new zzaf(this.zzcf, this.name, this.zzfe, this.zzff, paramLong, this.zzfh, this.zzfi, this.zzfj, this.zzfk, this.zzfl);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */