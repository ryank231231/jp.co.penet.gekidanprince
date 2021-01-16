package com.google.android.gms.internal.measurement;

final class zzdu extends zzdz {
  private final int zzacd;
  
  private final int zzace;
  
  zzdu(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    super(paramArrayOfbyte);
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    this.zzacd = paramInt1;
    this.zzace = paramInt2;
  }
  
  public final int size() {
    return this.zzace;
  }
  
  protected final int zzkg() {
    return this.zzacd;
  }
  
  public final byte zzr(int paramInt) {
    int i = super.size();
    if ((i - paramInt + 1 | paramInt) < 0) {
      if (paramInt < 0) {
        StringBuilder stringBuilder1 = new StringBuilder(22);
        stringBuilder1.append("Index < 0: ");
        stringBuilder1.append(paramInt);
        throw new ArrayIndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder(40);
      stringBuilder.append("Index > length: ");
      stringBuilder.append(paramInt);
      stringBuilder.append(", ");
      stringBuilder.append(i);
      throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    } 
    return this.zzacg[this.zzacd + paramInt];
  }
  
  final byte zzs(int paramInt) {
    return this.zzacg[this.zzacd + paramInt];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */