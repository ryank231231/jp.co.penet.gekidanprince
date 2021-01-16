package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzcg extends zzip<zzcg> {
  public zzch[] zzxl = zzch.zzjg();
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzcg))
      return false; 
    paramObject = paramObject;
    return !zzit.equals((Object[])this.zzxl, (Object[])((zzcg)paramObject).zzxl) ? false : ((this.zzand == null || this.zzand.isEmpty()) ? ((((zzcg)paramObject).zzand == null || ((zzcg)paramObject).zzand.isEmpty())) : this.zzand.equals(((zzcg)paramObject).zzand));
  }
  
  public final int hashCode() {
    int i = getClass().getName().hashCode();
    int j = zzit.hashCode((Object[])this.zzxl);
    if (this.zzand == null || this.zzand.isEmpty()) {
      byte b = 0;
      return ((i + 527) * 31 + j) * 31 + b;
    } 
    int k = this.zzand.hashCode();
    return ((i + 527) * 31 + j) * 31 + k;
  }
  
  public final void zza(zzin paramzzin) throws IOException {
    zzch[] arrayOfZzch = this.zzxl;
    if (arrayOfZzch != null && arrayOfZzch.length > 0) {
      byte b = 0;
      while (true) {
        arrayOfZzch = this.zzxl;
        if (b < arrayOfZzch.length) {
          zzch zzch1 = arrayOfZzch[b];
          if (zzch1 != null)
            paramzzin.zza(1, zzch1); 
          b++;
          continue;
        } 
        break;
      } 
    } 
    super.zza(paramzzin);
  }
  
  protected final int zzja() {
    int i = super.zzja();
    zzch[] arrayOfZzch = this.zzxl;
    int j = i;
    if (arrayOfZzch != null) {
      j = i;
      if (arrayOfZzch.length > 0) {
        byte b = 0;
        while (true) {
          arrayOfZzch = this.zzxl;
          j = i;
          if (b < arrayOfZzch.length) {
            zzch zzch1 = arrayOfZzch[b];
            j = i;
            if (zzch1 != null)
              j = i + zzin.zzb(1, zzch1); 
            b++;
            i = j;
            continue;
          } 
          break;
        } 
      } 
    } 
    return j;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */