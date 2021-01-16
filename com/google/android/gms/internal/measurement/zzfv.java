package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfv extends zzdj<Long> implements zzff, zzgt, RandomAccess {
  private static final zzfv zzain;
  
  private int size;
  
  private long[] zzaio;
  
  static {
    zzfv zzfv1 = new zzfv(new long[0], 0);
    zzain = zzfv1;
    zzfv1.zzjz();
  }
  
  zzfv() {
    this(new long[10], 0);
  }
  
  private zzfv(long[] paramArrayOflong, int paramInt) {
    this.zzaio = paramArrayOflong;
    this.size = paramInt;
  }
  
  private final void zzk(int paramInt, long paramLong) {
    zzka();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        long[] arrayOfLong = this.zzaio;
        if (i < arrayOfLong.length) {
          System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, i - paramInt);
        } else {
          long[] arrayOfLong1 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong, 0, arrayOfLong1, 0, paramInt);
          System.arraycopy(this.zzaio, paramInt, arrayOfLong1, paramInt + 1, this.size - paramInt);
          this.zzaio = arrayOfLong1;
        } 
        this.zzaio[paramInt] = paramLong;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(zzp(paramInt));
  }
  
  public static zzfv zznk() {
    return zzain;
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
  
  public final boolean addAll(Collection<? extends Long> paramCollection) {
    zzka();
    zzfb.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzfv))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((zzfv)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      long[] arrayOfLong = this.zzaio;
      if (i > arrayOfLong.length)
        this.zzaio = Arrays.copyOf(arrayOfLong, i); 
      System.arraycopy(((zzfv)paramCollection).zzaio, 0, this.zzaio, this.size, ((zzfv)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzfv))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzfv)paramObject).size)
      return false; 
    paramObject = ((zzfv)paramObject).zzaio;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzaio[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final long getLong(int paramInt) {
    zzo(paramInt);
    return this.zzaio[paramInt];
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + zzfb.zzba(this.zzaio[b]); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzka();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Long.valueOf(this.zzaio[b]))) {
        paramObject = this.zzaio;
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
      long[] arrayOfLong = this.zzaio;
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
  
  public final zzff zzav(int paramInt) {
    if (paramInt >= this.size)
      return new zzfv(Arrays.copyOf(this.zzaio, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public final void zzbb(long paramLong) {
    zzk(this.size, paramLong);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */