package com.google.android.gms.measurement.internal;

final class zzav implements Runnable {
  zzav(zzau paramzzau, int paramInt, String paramString, Object paramObject1, Object paramObject2, Object paramObject3) {}
  
  public final void run() {
    zzbf zzbf = this.zzkf.zzl.zzae();
    if (zzbf.isInitialized()) {
      if (zzau.zza(this.zzkf) == '\000')
        if (this.zzkf.zzaf().zzbp()) {
          zzau zzau1 = this.zzkf;
          zzau1.zzag();
          zzau.zza(zzau1, 'C');
        } else {
          zzau zzau1 = this.zzkf;
          zzau1.zzag();
          zzau.zza(zzau1, 'c');
        }  
      if (zzau.zzb(this.zzkf) < 0L) {
        zzau zzau1 = this.zzkf;
        zzau.zza(zzau1, zzau1.zzaf().zzav());
      } 
      char c1 = "01VDIWEA?".charAt(this.zzka);
      char c2 = zzau.zza(this.zzkf);
      long l = zzau.zzb(this.zzkf);
      String str1 = zzau.zza(true, this.zzkb, this.zzkc, this.zzkd, this.zzke);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 24);
      stringBuilder.append("2");
      stringBuilder.append(c1);
      stringBuilder.append(c2);
      stringBuilder.append(l);
      stringBuilder.append(":");
      stringBuilder.append(str1);
      String str2 = stringBuilder.toString();
      str1 = str2;
      if (str2.length() > 1024)
        str1 = this.zzkb.substring(0, 1024); 
      zzbf.zzla.zzc(str1, 1L);
      return;
    } 
    this.zzkf.zza(6, "Persisted config not initialized. Not logging error/warn");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\measurement\internal\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */