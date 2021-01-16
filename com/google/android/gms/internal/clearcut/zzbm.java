package com.google.android.gms.internal.clearcut;

final class zzbm extends zzbk {
  private final byte[] buffer;
  
  private int limit;
  
  private int pos;
  
  private final boolean zzfu;
  
  private int zzfv;
  
  private int zzfw;
  
  private int zzfx = Integer.MAX_VALUE;
  
  private zzbm(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    super(null);
    this.buffer = paramArrayOfbyte;
    this.limit = paramInt2 + paramInt1;
    this.pos = paramInt1;
    this.zzfw = this.pos;
    this.zzfu = paramBoolean;
  }
  
  public final int zzaf() {
    return this.pos - this.zzfw;
  }
  
  public final int zzl(int paramInt) throws zzco {
    if (paramInt >= 0) {
      int i = paramInt + super.zzaf();
      paramInt = this.zzfx;
      if (i <= paramInt) {
        this.zzfx = i;
        this.limit += this.zzfv;
        int j = this.limit;
        int k = j - this.zzfw;
        i = this.zzfx;
        if (k > i) {
          this.zzfv = k - i;
          this.limit = j - this.zzfv;
        } else {
          this.zzfv = 0;
        } 
        return paramInt;
      } 
      throw zzco.zzbl();
    } 
    throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */