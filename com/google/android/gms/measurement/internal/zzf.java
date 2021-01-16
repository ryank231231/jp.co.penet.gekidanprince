package com.google.android.gms.measurement.internal;

abstract class zzf extends zze {
  private boolean zzce;
  
  zzf(zzby paramzzby) {
    super(paramzzby);
    this.zzl.zzb(this);
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
      if (!zzak()) {
        this.zzl.zzes();
        this.zzce = true;
      } 
      return;
    } 
    throw new IllegalStateException("Can't initialize twice");
  }
  
  public final void zzaj() {
    if (!this.zzce) {
      zzal();
      this.zzl.zzes();
      this.zzce = true;
      return;
    } 
    throw new IllegalStateException("Can't initialize twice");
  }
  
  protected abstract boolean zzak();
  
  protected void zzal() {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */