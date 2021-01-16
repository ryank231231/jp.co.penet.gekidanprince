package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Type;

public enum zzcb {
  zzgy(0, zzcd.zzjg, zzcq.zzlb),
  zzgz(1, zzcd.zzjg, zzcq.zzla),
  zzha(2, zzcd.zzjg, zzcq.zzkz),
  zzhb(3, zzcd.zzjg, zzcq.zzkz),
  zzhc(4, zzcd.zzjg, zzcq.zzky),
  zzhd(5, zzcd.zzjg, zzcq.zzkz),
  zzhe(6, zzcd.zzjg, zzcq.zzky),
  zzhf(7, zzcd.zzjg, zzcq.zzlc),
  zzhg(8, zzcd.zzjg, zzcq.zzld),
  zzhh(9, zzcd.zzjg, zzcq.zzlg),
  zzhi(10, zzcd.zzjg, zzcq.zzle),
  zzhj(11, zzcd.zzjg, zzcq.zzky),
  zzhk(12, zzcd.zzjg, zzcq.zzlf),
  zzhl(13, zzcd.zzjg, zzcq.zzky),
  zzhm(14, zzcd.zzjg, zzcq.zzkz),
  zzhn(15, zzcd.zzjg, zzcq.zzky),
  zzho(16, zzcd.zzjg, zzcq.zzkz),
  zzhp(17, zzcd.zzjg, zzcq.zzlg),
  zzhq(18, zzcd.zzjh, zzcq.zzlb),
  zzhr(19, zzcd.zzjh, zzcq.zzla),
  zzhs(20, zzcd.zzjh, zzcq.zzkz),
  zzht(21, zzcd.zzjh, zzcq.zzkz),
  zzhu(22, zzcd.zzjh, zzcq.zzky),
  zzhv(23, zzcd.zzjh, zzcq.zzkz),
  zzhw(24, zzcd.zzjh, zzcq.zzky),
  zzhx(25, zzcd.zzjh, zzcq.zzlc),
  zzhy(26, zzcd.zzjh, zzcq.zzld),
  zzhz(27, zzcd.zzjh, zzcq.zzlg),
  zzia(28, zzcd.zzjh, zzcq.zzle),
  zzib(29, zzcd.zzjh, zzcq.zzky),
  zzic(30, zzcd.zzjh, zzcq.zzlf),
  zzid(31, zzcd.zzjh, zzcq.zzky),
  zzie(32, zzcd.zzjh, zzcq.zzkz),
  zzif(33, zzcd.zzjh, zzcq.zzky),
  zzig(34, zzcd.zzjh, zzcq.zzkz),
  zzih(35, zzcd.zzji, zzcq.zzlb),
  zzii(36, zzcd.zzji, zzcq.zzla),
  zzij(37, zzcd.zzji, zzcq.zzkz),
  zzik(38, zzcd.zzji, zzcq.zzkz),
  zzil(39, zzcd.zzji, zzcq.zzky),
  zzim(40, zzcd.zzji, zzcq.zzkz),
  zzin(41, zzcd.zzji, zzcq.zzky),
  zzio(42, zzcd.zzji, zzcq.zzlc),
  zzip(43, zzcd.zzji, zzcq.zzky),
  zziq(44, zzcd.zzji, zzcq.zzlf),
  zzir(45, zzcd.zzji, zzcq.zzky),
  zzis(46, zzcd.zzji, zzcq.zzkz),
  zzit(47, zzcd.zzji, zzcq.zzky),
  zziu(48, zzcd.zzji, zzcq.zzkz),
  zziv(49, zzcd.zzjh, zzcq.zzlg),
  zziw(50, zzcd.zzjj, zzcq.zzkx);
  
  private static final zzcb[] zzjb;
  
  private static final Type[] zzjc;
  
  private final int id;
  
  private final zzcq zzix;
  
  private final zzcd zziy;
  
  private final Class<?> zziz;
  
  private final boolean zzja;
  
  static {
    zzcb zzcb1 = zzgy;
    byte b = 0;
    zzjd = new zzcb[] { 
        zzcb1, zzgz, zzha, zzhb, zzhc, zzhd, zzhe, zzhf, zzhg, zzhh, 
        zzhi, zzhj, zzhk, zzhl, zzhm, zzhn, zzho, zzhp, zzhq, zzhr, 
        zzhs, zzht, zzhu, zzhv, zzhw, zzhx, zzhy, zzhz, zzia, zzib, 
        zzic, zzid, zzie, zzif, zzig, zzih, zzii, zzij, zzik, zzil, 
        zzim, zzin, zzio, zzip, zziq, zzir, zzis, zzit, zziu, zziv, 
        zziw };
    zzjc = new Type[0];
    zzcb[] arrayOfZzcb = values();
    zzjb = new zzcb[arrayOfZzcb.length];
    int i = arrayOfZzcb.length;
    while (b < i) {
      zzcb1 = arrayOfZzcb[b];
      zzjb[zzcb1.id] = zzcb1;
      b++;
    } 
  }
  
  zzcb(int paramInt1, zzcd paramzzcd, zzcq paramzzcq) {
    Class<?> clazz;
    this.id = paramInt1;
    this.zziy = paramzzcd;
    this.zzix = paramzzcq;
    switch (zzcc.zzje[paramzzcd.ordinal()]) {
      default:
        this$enum$name = null;
        this.zziz = (Class<?>)this$enum$name;
        break;
      case 1:
      case 2:
        clazz = paramzzcq.zzbq();
        this.zziz = clazz;
        break;
    } 
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramzzcd == zzcd.zzjg) {
      bool2 = bool1;
      switch (zzcc.zzjf[paramzzcq.ordinal()]) {
        default:
          bool2 = true;
          break;
        case 1:
        case 2:
        case 3:
          break;
      } 
    } 
    this.zzja = bool2;
  }
  
  public final int id() {
    return this.id;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */