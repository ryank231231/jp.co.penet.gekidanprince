package com.google.android.gms.internal.clearcut;

final class zzbg {
  private final byte[] buffer;
  
  private final zzbn zzfo;
  
  private zzbg(int paramInt) {
    this.buffer = new byte[paramInt];
    this.zzfo = zzbn.zzc(this.buffer);
  }
  
  public final zzbb zzad() {
    if (this.zzfo.zzag() == 0)
      return new zzbi(this.buffer); 
    throw new IllegalStateException("Did not write as much data as expected.");
  }
  
  public final zzbn zzae() {
    return this.zzfo;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */