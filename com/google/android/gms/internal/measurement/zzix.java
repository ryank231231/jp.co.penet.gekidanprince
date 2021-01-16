package com.google.android.gms.internal.measurement;

import java.util.Arrays;

final class zzix {
  final int tag;
  
  final byte[] zzacg;
  
  zzix(int paramInt, byte[] paramArrayOfbyte) {
    this.tag = paramInt;
    this.zzacg = paramArrayOfbyte;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzix))
      return false; 
    paramObject = paramObject;
    return (this.tag == ((zzix)paramObject).tag && Arrays.equals(this.zzacg, ((zzix)paramObject).zzacg));
  }
  
  public final int hashCode() {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.zzacg);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */