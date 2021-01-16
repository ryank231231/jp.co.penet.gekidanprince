package com.google.android.gms.internal.measurement;

final class zzdx {
  private final byte[] buffer;
  
  private final zzeg zzacf;
  
  private zzdx(int paramInt) {
    this.buffer = new byte[paramInt];
    this.zzacf = zzeg.zzh(this.buffer);
  }
  
  public final zzdp zzkh() {
    this.zzacf.zzlk();
    return new zzdz(this.buffer);
  }
  
  public final zzeg zzki() {
    return this.zzacf;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */