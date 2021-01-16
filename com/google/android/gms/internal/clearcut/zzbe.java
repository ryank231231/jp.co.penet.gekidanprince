package com.google.android.gms.internal.clearcut;

final class zzbe extends zzbi {
  private final int zzfm;
  
  private final int zzfn;
  
  zzbe(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    super(paramArrayOfbyte);
    zzb(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    this.zzfm = paramInt1;
    this.zzfn = paramInt2;
  }
  
  public final int size() {
    return this.zzfn;
  }
  
  protected final int zzac() {
    return this.zzfm;
  }
  
  public final byte zzj(int paramInt) {
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
    return this.zzfp[this.zzfm + paramInt];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */