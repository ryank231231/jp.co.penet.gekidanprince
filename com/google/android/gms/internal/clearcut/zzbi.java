package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

class zzbi extends zzbh {
  protected final byte[] zzfp;
  
  zzbi(byte[] paramArrayOfbyte) {
    this.zzfp = paramArrayOfbyte;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzbb))
      return false; 
    if (super.size() != ((zzbb)paramObject).size())
      return false; 
    if (super.size() == 0)
      return true; 
    if (paramObject instanceof zzbi) {
      paramObject = paramObject;
      int i = zzab();
      int j = paramObject.zzab();
      return (i != 0 && j != 0 && i != j) ? false : super.zza((zzbb)paramObject, 0, super.size());
    } 
    return paramObject.equals(this);
  }
  
  public int size() {
    return this.zzfp.length;
  }
  
  protected final int zza(int paramInt1, int paramInt2, int paramInt3) {
    return zzci.zza(paramInt1, this.zzfp, zzac(), paramInt3);
  }
  
  public final zzbb zza(int paramInt1, int paramInt2) {
    paramInt1 = zzb(0, paramInt2, super.size());
    return (paramInt1 == 0) ? zzbb.zzfi : new zzbe(this.zzfp, zzac(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset) {
    return new String(this.zzfp, zzac(), super.size(), paramCharset);
  }
  
  final void zza(zzba paramzzba) throws IOException {
    paramzzba.zza(this.zzfp, zzac(), super.size());
  }
  
  final boolean zza(zzbb paramzzbb, int paramInt1, int paramInt2) {
    if (paramInt2 <= paramzzbb.size()) {
      byte[] arrayOfByte;
      if (paramInt2 <= paramzzbb.size()) {
        if (paramzzbb instanceof zzbi) {
          zzbi zzbi1 = (zzbi)paramzzbb;
          arrayOfByte = this.zzfp;
          byte[] arrayOfByte1 = zzbi1.zzfp;
          int i = zzac();
          paramInt1 = zzac();
          for (int j = zzbi1.zzac(); paramInt1 < i + paramInt2; j++) {
            if (arrayOfByte[paramInt1] != arrayOfByte1[j])
              return false; 
            paramInt1++;
          } 
          return true;
        } 
        return arrayOfByte.zza(0, paramInt2).equals(super.zza(0, paramInt2));
      } 
      paramInt1 = arrayOfByte.size();
      StringBuilder stringBuilder1 = new StringBuilder(59);
      stringBuilder1.append("Ran off end of other: 0, ");
      stringBuilder1.append(paramInt2);
      stringBuilder1.append(", ");
      stringBuilder1.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    paramInt1 = super.size();
    StringBuilder stringBuilder = new StringBuilder(40);
    stringBuilder.append("Length too large: ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(paramInt1);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final boolean zzaa() {
    int i = zzac();
    return zzff.zze(this.zzfp, i, super.size() + i);
  }
  
  protected int zzac() {
    return 0;
  }
  
  public byte zzj(int paramInt) {
    return this.zzfp[paramInt];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */