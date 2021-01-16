package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class zzdz extends zzdy {
  protected final byte[] zzacg;
  
  zzdz(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      this.zzacg = paramArrayOfbyte;
      return;
    } 
    throw new NullPointerException();
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzdp))
      return false; 
    if (super.size() != ((zzdp)paramObject).size())
      return false; 
    if (super.size() == 0)
      return true; 
    if (paramObject instanceof zzdz) {
      paramObject = paramObject;
      int i = zzkf();
      int j = paramObject.zzkf();
      return (i != 0 && j != 0 && i != j) ? false : super.zza((zzdp)paramObject, 0, super.size());
    } 
    return paramObject.equals(this);
  }
  
  public int size() {
    return this.zzacg.length;
  }
  
  protected final int zza(int paramInt1, int paramInt2, int paramInt3) {
    return zzfb.zza(paramInt1, this.zzacg, zzkg(), paramInt3);
  }
  
  public final zzdp zza(int paramInt1, int paramInt2) {
    paramInt1 = zzb(0, paramInt2, super.size());
    return (paramInt1 == 0) ? zzdp.zzaby : new zzdu(this.zzacg, zzkg(), paramInt1);
  }
  
  protected final String zza(Charset paramCharset) {
    return new String(this.zzacg, zzkg(), super.size(), paramCharset);
  }
  
  final void zza(zzdo paramzzdo) throws IOException {
    paramzzdo.zza(this.zzacg, zzkg(), super.size());
  }
  
  final boolean zza(zzdp paramzzdp, int paramInt1, int paramInt2) {
    if (paramInt2 <= paramzzdp.size()) {
      byte[] arrayOfByte;
      if (paramInt2 <= paramzzdp.size()) {
        if (paramzzdp instanceof zzdz) {
          zzdz zzdz1 = (zzdz)paramzzdp;
          byte[] arrayOfByte1 = this.zzacg;
          arrayOfByte = zzdz1.zzacg;
          int i = zzkg();
          int j = zzkg();
          for (paramInt1 = zzdz1.zzkg(); j < i + paramInt2; paramInt1++) {
            if (arrayOfByte1[j] != arrayOfByte[paramInt1])
              return false; 
            j++;
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
  
  public final boolean zzke() {
    int i = zzkg();
    return zzhy.zzf(this.zzacg, i, super.size() + i);
  }
  
  protected int zzkg() {
    return 0;
  }
  
  public byte zzr(int paramInt) {
    return this.zzacg[paramInt];
  }
  
  byte zzs(int paramInt) {
    return this.zzacg[paramInt];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */