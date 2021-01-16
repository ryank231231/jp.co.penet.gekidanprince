package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzgc {
  final String name;
  
  final String origin;
  
  final Object value;
  
  final String zzcf;
  
  final long zzsx;
  
  zzgc(String paramString1, String paramString2, String paramString3, long paramLong, Object paramObject) {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString3);
    Preconditions.checkNotNull(paramObject);
    this.zzcf = paramString1;
    this.origin = paramString2;
    this.name = paramString3;
    this.zzsx = paramLong;
    this.value = paramObject;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */