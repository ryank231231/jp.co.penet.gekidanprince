package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzch extends zzav<Integer> implements zzcn<Integer>, RandomAccess {
  private static final zzch zzkr;
  
  private int size;
  
  private int[] zzks;
  
  static {
    zzch zzch1 = new zzch();
    zzkr = zzch1;
    zzch1.zzv();
  }
  
  zzch() {
    this(new int[10], 0);
  }
  
  private zzch(int[] paramArrayOfint, int paramInt) {
    this.zzks = paramArrayOfint;
    this.size = paramInt;
  }
  
  public static zzch zzbk() {
    return zzkr;
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
  
  private final void zzo(int paramInt1, int paramInt2) {
    zzw();
    if (paramInt1 >= 0) {
      int i = this.size;
      if (paramInt1 <= i) {
        int[] arrayOfInt = this.zzks;
        if (i < arrayOfInt.length) {
          System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, i - paramInt1);
        } else {
          int[] arrayOfInt1 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, paramInt1);
          System.arraycopy(this.zzks, paramInt1, arrayOfInt1, paramInt1 + 1, this.size - paramInt1);
          this.zzks = arrayOfInt1;
        } 
        this.zzks[paramInt1] = paramInt2;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(zzh(paramInt1));
  }
  
  public final boolean addAll(Collection<? extends Integer> paramCollection) {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzch))
      return super.addAll(paramCollection); 
    zzch zzch1 = (zzch)paramCollection;
    int i = zzch1.size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      int[] arrayOfInt = this.zzks;
      if (i > arrayOfInt.length)
        this.zzks = Arrays.copyOf(arrayOfInt, i); 
      System.arraycopy(zzch1.zzks, 0, this.zzks, this.size, zzch1.size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzch))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzch)paramObject).size)
      return false; 
    paramObject = ((zzch)paramObject).zzks;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzks[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final int getInt(int paramInt) {
    zzg(paramInt);
    return this.zzks[paramInt];
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + this.zzks[b]; 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzw();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Integer.valueOf(this.zzks[b]))) {
        paramObject = this.zzks;
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
      int[] arrayOfInt = this.zzks;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size() {
    return this.size;
  }
  
  public final void zzac(int paramInt) {
    zzo(this.size, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */