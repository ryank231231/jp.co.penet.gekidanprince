package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzip<M extends zzip<M>> extends zziv {
  protected zzir zzand;
  
  public void zza(zzin paramzzin) throws IOException {
    if (this.zzand == null)
      return; 
    for (byte b = 0; b < this.zzand.size(); b++)
      this.zzand.zzbn(b).zza(paramzzin); 
  }
  
  protected final boolean zza(zzim paramzzim, int paramInt) throws IOException {
    zzis zzis1;
    int i = paramzzim.getPosition();
    if (!paramzzim.zzv(paramInt))
      return false; 
    int j = paramInt >>> 3;
    zzix zzix = new zzix(paramInt, paramzzim.zzt(i, paramzzim.getPosition() - i));
    paramzzim = null;
    zzir zzir1 = this.zzand;
    if (zzir1 == null) {
      this.zzand = new zzir();
    } else {
      zzis1 = zzir1.zzbm(j);
    } 
    zzis zzis2 = zzis1;
    if (zzis1 == null) {
      zzis2 = new zzis();
      this.zzand.zza(j, zzis2);
    } 
    zzis2.zza(zzix);
    return true;
  }
  
  protected int zzja() {
    boolean bool;
    zzir zzir1 = this.zzand;
    byte b = 0;
    if (zzir1 != null) {
      int i = 0;
      while (true) {
        bool = i;
        if (b < this.zzand.size()) {
          i += this.zzand.zzbn(b).zzja();
          b++;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */