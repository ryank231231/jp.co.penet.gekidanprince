package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdc extends zzav<Long> implements zzcn<Long>, RandomAccess {
  private static final zzdc zzlw;
  
  private int size;
  
  private long[] zzlx;
  
  static {
    zzdc zzdc1 = new zzdc();
    zzlw = zzdc1;
    zzdc1.zzv();
  }
  
  zzdc() {
    this(new long[10], 0);
  }
  
  private zzdc(long[] paramArrayOflong, int paramInt) {
    this.zzlx = paramArrayOflong;
    this.size = paramInt;
  }
  
  public static zzdc zzbx() {
    return zzlw;
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
  
  private final void zzk(int paramInt, long paramLong) {
    zzw();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        long[] arrayOfLong = this.zzlx;
        if (i < arrayOfLong.length) {
          System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, i - paramInt);
        } else {
          long[] arrayOfLong1 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong, 0, arrayOfLong1, 0, paramInt);
          System.arraycopy(this.zzlx, paramInt, arrayOfLong1, paramInt + 1, this.size - paramInt);
          this.zzlx = arrayOfLong1;
        } 
        this.zzlx[paramInt] = paramLong;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(zzh(paramInt));
  }
  
  public final boolean addAll(Collection<? extends Long> paramCollection) {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzdc))
      return super.addAll(paramCollection); 
    zzdc zzdc1 = (zzdc)paramCollection;
    int i = zzdc1.size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      j += i;
      long[] arrayOfLong = this.zzlx;
      if (j > arrayOfLong.length)
        this.zzlx = Arrays.copyOf(arrayOfLong, j); 
      System.arraycopy(zzdc1.zzlx, 0, this.zzlx, this.size, zzdc1.size);
      this.size = j;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzdc))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzdc)paramObject).size)
      return false; 
    paramObject = ((zzdc)paramObject).zzlx;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzlx[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final long getLong(int paramInt) {
    zzg(paramInt);
    return this.zzlx[paramInt];
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + zzci.zzl(this.zzlx[b]); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzw();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Long.valueOf(this.zzlx[b]))) {
        paramObject = this.zzlx;
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
      long[] arrayOfLong = this.zzlx;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size() {
    return this.size;
  }
  
  public final void zzm(long paramLong) {
    zzk(this.size, paramLong);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */