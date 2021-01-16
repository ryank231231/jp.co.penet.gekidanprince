package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public class zzfu<M extends zzfu<M>> extends zzfz {
  protected zzfw zzrj;
  
  public void zza(zzfs paramzzfs) throws IOException {
    if (this.zzrj == null)
      return; 
    for (byte b = 0; b < this.zzrj.size(); b++)
      this.zzrj.zzaq(b).zza(paramzzfs); 
  }
  
  protected int zzen() {
    if (this.zzrj != null)
      for (byte b = 0; b < this.zzrj.size(); b++)
        this.zzrj.zzaq(b).zzen();  
    return 0;
  }
  
  public M zzeo() throws CloneNotSupportedException {
    zzfu zzfu1 = (zzfu)super.zzep();
    zzfy.zza(this, zzfu1);
    return (M)zzfu1;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */