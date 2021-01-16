package com.google.android.gms.internal.measurement;

public final class zzir implements Cloneable {
  private static final zzis zzanf = new zzis();
  
  private int mSize;
  
  private boolean zzang = false;
  
  private int[] zzanh;
  
  private zzis[] zzani;
  
  zzir() {
    this(10);
  }
  
  private zzir(int paramInt) {
    paramInt = idealIntArraySize(paramInt);
    this.zzanh = new int[paramInt];
    this.zzani = new zzis[paramInt];
    this.mSize = 0;
  }
  
  private static int idealIntArraySize(int paramInt) {
    int j;
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
    return j / 4;
  }
  
  private final int zzbo(int paramInt) {
    int i = this.mSize - 1;
    int j = 0;
    while (j <= i) {
      int k = j + i >>> 1;
      int m = this.zzanh[k];
      if (m < paramInt) {
        j = k + 1;
        continue;
      } 
      if (m > paramInt) {
        i = k - 1;
        continue;
      } 
      return k;
    } 
    return j ^ 0xFFFFFFFF;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof zzir))
      return false; 
    paramObject = paramObject;
    int i = this.mSize;
    if (i != ((zzir)paramObject).mSize)
      return false; 
    int[] arrayOfInt1 = this.zzanh;
    int[] arrayOfInt2 = ((zzir)paramObject).zzanh;
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
      zzis[] arrayOfZzis = this.zzani;
      paramObject = ((zzir)paramObject).zzani;
      i = this.mSize;
      b = 0;
      while (true) {
        if (b < i) {
          if (!arrayOfZzis[b].equals(paramObject[b])) {
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
      i = (i * 31 + this.zzanh[b]) * 31 + this.zzani[b].hashCode(); 
    return i;
  }
  
  public final boolean isEmpty() {
    return (this.mSize == 0);
  }
  
  final int size() {
    return this.mSize;
  }
  
  final void zza(int paramInt, zzis paramzzis) {
    int i = zzbo(paramInt);
    if (i >= 0) {
      this.zzani[i] = paramzzis;
      return;
    } 
    i ^= 0xFFFFFFFF;
    if (i < this.mSize) {
      zzis[] arrayOfZzis = this.zzani;
      if (arrayOfZzis[i] == zzanf) {
        this.zzanh[i] = paramInt;
        arrayOfZzis[i] = paramzzis;
        return;
      } 
    } 
    int j = this.mSize;
    if (j >= this.zzanh.length) {
      j = idealIntArraySize(j + 1);
      int[] arrayOfInt1 = new int[j];
      zzis[] arrayOfZzis1 = new zzis[j];
      int[] arrayOfInt2 = this.zzanh;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      zzis[] arrayOfZzis2 = this.zzani;
      System.arraycopy(arrayOfZzis2, 0, arrayOfZzis1, 0, arrayOfZzis2.length);
      this.zzanh = arrayOfInt1;
      this.zzani = arrayOfZzis1;
    } 
    j = this.mSize;
    if (j - i != 0) {
      int[] arrayOfInt = this.zzanh;
      int k = i + 1;
      System.arraycopy(arrayOfInt, i, arrayOfInt, k, j - i);
      zzis[] arrayOfZzis = this.zzani;
      System.arraycopy(arrayOfZzis, i, arrayOfZzis, k, this.mSize - i);
    } 
    this.zzanh[i] = paramInt;
    this.zzani[i] = paramzzis;
    this.mSize++;
  }
  
  final zzis zzbm(int paramInt) {
    paramInt = zzbo(paramInt);
    if (paramInt >= 0) {
      zzis[] arrayOfZzis = this.zzani;
      if (arrayOfZzis[paramInt] != zzanf)
        return arrayOfZzis[paramInt]; 
    } 
    return null;
  }
  
  final zzis zzbn(int paramInt) {
    return this.zzani[paramInt];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzir.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */