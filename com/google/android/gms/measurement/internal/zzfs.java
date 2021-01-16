package com.google.android.gms.measurement.internal;

abstract class zzfs extends zzfr {
  private boolean zzce;
  
  zzfs(zzft paramzzft) {
    super(paramzzft);
    this.zzkt.zzb(this);
  }
  
  final boolean isInitialized() {
    return this.zzce;
  }
  
  protected final void zzah() {
    if (isInitialized())
      return; 
    throw new IllegalStateException("Not initialized");
  }
  
  public final void zzai() {
    if (!this.zzce) {
      zzak();
      this.zzkt.zzgh();
      this.zzce = true;
      return;
    } 
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected abstract boolean zzak();
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */