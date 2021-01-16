package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzej extends zzdj<Double> implements zzfg<Double>, zzgt, RandomAccess {
  private static final zzej zzadg;
  
  private int size;
  
  private double[] zzadh;
  
  static {
    zzej zzej1 = new zzej(new double[0], 0);
    zzadg = zzej1;
    zzej1.zzjz();
  }
  
  zzej() {
    this(new double[10], 0);
  }
  
  private zzej(double[] paramArrayOfdouble, int paramInt) {
    this.zzadh = paramArrayOfdouble;
    this.size = paramInt;
  }
  
  private final void zzc(int paramInt, double paramDouble) {
    zzka();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        double[] arrayOfDouble = this.zzadh;
        if (i < arrayOfDouble.length) {
          System.arraycopy(arrayOfDouble, paramInt, arrayOfDouble, paramInt + 1, i - paramInt);
        } else {
          double[] arrayOfDouble1 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble, 0, arrayOfDouble1, 0, paramInt);
          System.arraycopy(this.zzadh, paramInt, arrayOfDouble1, paramInt + 1, this.size - paramInt);
          this.zzadh = arrayOfDouble1;
        } 
        this.zzadh[paramInt] = paramDouble;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(zzp(paramInt));
  }
  
  private final void zzo(int paramInt) {
    if (paramInt >= 0 && paramInt < this.size)
      return; 
    throw new IndexOutOfBoundsException(zzp(paramInt));
  }
  
  private final String zzp(int paramInt) {
    int i = this.size;
    StringBuilder stringBuilder = new StringBuilder(35);
    stringBuilder.append("Index:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", Size:");
    stringBuilder.append(i);
    return stringBuilder.toString();
  }
  
  public final boolean addAll(Collection<? extends Double> paramCollection) {
    zzka();
    zzfb.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzej))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((zzej)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      double[] arrayOfDouble = this.zzadh;
      if (i > arrayOfDouble.length)
        this.zzadh = Arrays.copyOf(arrayOfDouble, i); 
      System.arraycopy(((zzej)paramCollection).zzadh, 0, this.zzadh, this.size, ((zzej)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzej))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzej)paramObject).size)
      return false; 
    paramObject = ((zzej)paramObject).zzadh;
    for (byte b = 0; b < this.size; b++) {
      if (Double.doubleToLongBits(this.zzadh[b]) != Double.doubleToLongBits(paramObject[b]))
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + zzfb.zzba(Double.doubleToLongBits(this.zzadh[b])); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzka();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Double.valueOf(this.zzadh[b]))) {
        paramObject = this.zzadh;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b - 1);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  protected final void removeRange(int paramInt1, int paramInt2) {
    zzka();
    if (paramInt2 >= paramInt1) {
      double[] arrayOfDouble = this.zzadh;
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
  
  public final void zzf(double paramDouble) {
    zzc(this.size, paramDouble);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */