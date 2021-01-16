package com.google.android.gms.internal.clearcut;

public final class zzfw implements Cloneable {
  private static final zzfx zzrl = new zzfx();
  
  private int mSize;
  
  private boolean zzrm;
  
  private int[] zzrn;
  
  private zzfx[] zzro;
  
  zzfw() {
    this(10);
  }
  
  private zzfw(int paramInt) {
    int j;
    this.zzrm = false;
    int i = paramInt << 2;
    paramInt = 4;
    while (true) {
      j = i;
      if (paramInt < 32) {
        j = (1 << paramInt) - 12;
        if (i <= j)
          break; 
        paramInt++;
        continue;
      } 
      break;
    } 
    paramInt = j / 4;
    this.zzrn = new int[paramInt];
    this.zzro = new zzfx[paramInt];
    this.mSize = 0;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzfw))
      return false; 
    paramObject = paramObject;
    int i = this.mSize;
    if (i != ((zzfw)paramObject).mSize)
      return false; 
    int[] arrayOfInt1 = this.zzrn;
    int[] arrayOfInt2 = ((zzfw)paramObject).zzrn;
    byte b = 0;
    while (true) {
      if (b < i) {
        if (arrayOfInt1[b] != arrayOfInt2[b]) {
          b = 0;
          break;
        } 
        b++;
        continue;
      } 
      b = 1;
      break;
    } 
    if (b != 0) {
      zzfx[] arrayOfZzfx = this.zzro;
      paramObject = ((zzfw)paramObject).zzro;
      i = this.mSize;
      b = 0;
      while (true) {
        if (b < i) {
          if (!arrayOfZzfx[b].equals(paramObject[b])) {
            b = 0;
            break;
          } 
          b++;
          continue;
        } 
        b = 1;
        break;
      } 
      if (b != 0)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    int i = 17;
    for (byte b = 0; b < this.mSize; b++)
      i = (i * 31 + this.zzrn[b]) * 31 + this.zzro[b].hashCode(); 
    return i;
  }
  
  public final boolean isEmpty() {
    return (this.mSize == 0);
  }
  
  final int size() {
    return this.mSize;
  }
  
  final zzfx zzaq(int paramInt) {
    return this.zzro[paramInt];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzfw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */