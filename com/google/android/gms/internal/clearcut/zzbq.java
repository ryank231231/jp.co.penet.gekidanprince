package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbq extends zzav<Double> implements zzcn<Double>, RandomAccess {
  private static final zzbq zzgj;
  
  private int size;
  
  private double[] zzgk;
  
  static {
    zzbq zzbq1 = new zzbq();
    zzgj = zzbq1;
    zzbq1.zzv();
  }
  
  zzbq() {
    this(new double[10], 0);
  }
  
  private zzbq(double[] paramArrayOfdouble, int paramInt) {
    this.zzgk = paramArrayOfdouble;
    this.size = paramInt;
  }
  
  private final void zzc(int paramInt, double paramDouble) {
    zzw();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        double[] arrayOfDouble = this.zzgk;
        if (i < arrayOfDouble.length) {
          System.arraycopy(arrayOfDouble, paramInt, arrayOfDouble, paramInt + 1, i - paramInt);
        } else {
          double[] arrayOfDouble1 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble, 0, arrayOfDouble1, 0, paramInt);
          System.arraycopy(this.zzgk, paramInt, arrayOfDouble1, paramInt + 1, this.size - paramInt);
          this.zzgk = arrayOfDouble1;
        } 
        this.zzgk[paramInt] = paramDouble;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  private final void zzg(int paramInt) {
    if (paramInt >= 0 && paramInt < this.size)
      return; 
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  private final String zzh(int paramInt) {
    int i = this.size;
    StringBuilder stringBuilder = new StringBuilder(35);
    stringBuilder.append("Index:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", Size:");
    stringBuilder.append(i);
    return stringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Double> paramCollection) {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzbq))
      return super.addAll(paramCollection); 
    zzbq zzbq1 = (zzbq)paramCollection;
    int i = zzbq1.size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      j += i;
      double[] arrayOfDouble = this.zzgk;
      if (j > arrayOfDouble.length)
        this.zzgk = Arrays.copyOf(arrayOfDouble, j); 
      System.arraycopy(zzbq1.zzgk, 0, this.zzgk, this.size, zzbq1.size);
      this.size = j;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzbq))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzbq)paramObject).size)
      return false; 
    paramObject = ((zzbq)paramObject).zzgk;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzgk[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + zzci.zzl(Double.doubleToLongBits(this.zzgk[b])); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzw();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Double.valueOf(this.zzgk[b]))) {
        paramObject = this.zzgk;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2) {
    zzw();
    if (paramInt2 >= paramInt1) {
      double[] arrayOfDouble = this.zzgk;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size() {
    return this.size;
  }
  
  public final void zzc(double paramDouble) {
    zzc(this.size, paramDouble);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */