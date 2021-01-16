package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

public enum zzet {
  zzadv(0, zzev.zzagd, zzfj.zzahs),
  zzadw(1, zzev.zzagd, zzfj.zzahr),
  zzadx(2, zzev.zzagd, zzfj.zzahq),
  zzady(3, zzev.zzagd, zzfj.zzahq),
  zzadz(4, zzev.zzagd, zzfj.zzahp),
  zzaea(5, zzev.zzagd, zzfj.zzahq),
  zzaeb(6, zzev.zzagd, zzfj.zzahp),
  zzaec(7, zzev.zzagd, zzfj.zzaht),
  zzaed(8, zzev.zzagd, zzfj.zzahu),
  zzaee(9, zzev.zzagd, zzfj.zzahx),
  zzaef(10, zzev.zzagd, zzfj.zzahv),
  zzaeg(11, zzev.zzagd, zzfj.zzahp),
  zzaeh(12, zzev.zzagd, zzfj.zzahw),
  zzaei(13, zzev.zzagd, zzfj.zzahp),
  zzaej(14, zzev.zzagd, zzfj.zzahq),
  zzaek(15, zzev.zzagd, zzfj.zzahp),
  zzael(16, zzev.zzagd, zzfj.zzahq),
  zzaem(17, zzev.zzagd, zzfj.zzahx),
  zzaen(18, zzev.zzage, zzfj.zzahs),
  zzaeo(19, zzev.zzage, zzfj.zzahr),
  zzaep(20, zzev.zzage, zzfj.zzahq),
  zzaeq(21, zzev.zzage, zzfj.zzahq),
  zzaer(22, zzev.zzage, zzfj.zzahp),
  zzaes(23, zzev.zzage, zzfj.zzahq),
  zzaet(24, zzev.zzage, zzfj.zzahp),
  zzaeu(25, zzev.zzage, zzfj.zzaht),
  zzaev(26, zzev.zzage, zzfj.zzahu),
  zzaew(27, zzev.zzage, zzfj.zzahx),
  zzaex(28, zzev.zzage, zzfj.zzahv),
  zzaey(29, zzev.zzage, zzfj.zzahp),
  zzaez(30, zzev.zzage, zzfj.zzahw),
  zzafa(31, zzev.zzage, zzfj.zzahp),
  zzafb(32, zzev.zzage, zzfj.zzahq),
  zzafc(33, zzev.zzage, zzfj.zzahp),
  zzafd(34, zzev.zzage, zzfj.zzahq),
  zzafe(35, zzev.zzagf, zzfj.zzahs),
  zzaff(36, zzev.zzagf, zzfj.zzahr),
  zzafg(37, zzev.zzagf, zzfj.zzahq),
  zzafh(38, zzev.zzagf, zzfj.zzahq),
  zzafi(39, zzev.zzagf, zzfj.zzahp),
  zzafj(40, zzev.zzagf, zzfj.zzahq),
  zzafk(41, zzev.zzagf, zzfj.zzahp),
  zzafl(42, zzev.zzagf, zzfj.zzaht),
  zzafm(43, zzev.zzagf, zzfj.zzahp),
  zzafn(44, zzev.zzagf, zzfj.zzahw),
  zzafo(45, zzev.zzagf, zzfj.zzahp),
  zzafp(46, zzev.zzagf, zzfj.zzahq),
  zzafq(47, zzev.zzagf, zzfj.zzahp),
  zzafr(48, zzev.zzagf, zzfj.zzahq),
  zzafs(49, zzev.zzage, zzfj.zzahx),
  zzaft(50, zzev.zzagg, zzfj.zzaho);
  
  private static final zzet[] zzafy;
  
  private static final Type[] zzafz;
  
  private final int id;
  
  private final zzfj zzafu;
  
  private final zzev zzafv;
  
  private final Class<?> zzafw;
  
  private final boolean zzafx;
  
  static {
    zzet zzet1 = zzadv;
    byte b = 0;
    zzaga = new zzet[] { 
        zzet1, zzadw, zzadx, zzady, zzadz, zzaea, zzaeb, zzaec, zzaed, zzaee, 
        zzaef, zzaeg, zzaeh, zzaei, zzaej, zzaek, zzael, zzaem, zzaen, zzaeo, 
        zzaep, zzaeq, zzaer, zzaes, zzaet, zzaeu, zzaev, zzaew, zzaex, zzaey, 
        zzaez, zzafa, zzafb, zzafc, zzafd, zzafe, zzaff, zzafg, zzafh, zzafi, 
        zzafj, zzafk, zzafl, zzafm, zzafn, zzafo, zzafp, zzafq, zzafr, zzafs, 
        zzaft };
    zzafz = new Type[0];
    zzet[] arrayOfZzet = values();
    zzafy = new zzet[arrayOfZzet.length];
    int i = arrayOfZzet.length;
    while (b < i) {
      zzet zzet2 = arrayOfZzet[b];
      zzafy[zzet2.id] = zzet2;
      b++;
    } 
  }
  
  zzet(int paramInt1, zzev paramzzev, zzfj paramzzfj) {
    this.id = paramInt1;
    this.zzafv = paramzzev;
    this.zzafu = paramzzfj;
    switch (zzeu.zzagb[paramzzev.ordinal()]) {
      default:
        this.zzafw = null;
        break;
      case 2:
        this.zzafw = paramzzfj.zznd();
        break;
      case 1:
        this.zzafw = paramzzfj.zznd();
        break;
    } 
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramzzev == zzev.zzagd) {
      bool2 = bool1;
      switch (zzeu.zzagc[paramzzfj.ordinal()]) {
        default:
          bool2 = true;
          break;
        case 1:
        case 2:
        case 3:
          break;
      } 
    } 
    this.zzafx = bool2;
  }
  
  public final int id() {
    return this.id;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */