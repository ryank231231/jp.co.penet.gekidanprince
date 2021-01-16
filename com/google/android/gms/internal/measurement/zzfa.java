package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfa extends zzdj<Integer> implements zzfg<Integer>, zzgt, RandomAccess {
  private static final zzfa zzahi;
  
  private int size;
  
  private int[] zzahj;
  
  static {
    zzfa zzfa1 = new zzfa(new int[0], 0);
    zzahi = zzfa1;
    zzfa1.zzjz();
  }
  
  zzfa() {
    this(new int[10], 0);
  }
  
  private zzfa(int[] paramArrayOfint, int paramInt) {
    this.zzahj = paramArrayOfint;
    this.size = paramInt;
  }
  
  private final void zzo(int paramInt) {
    if (paramInt >= 0 && paramInt < this.size)
      return; 
    throw new IndexOutOfBoundsException(zzp(paramInt));
  }
  
  private final void zzo(int paramInt1, int paramInt2) {
    zzka();
    if (paramInt1 >= 0) {
      int i = this.size;
      if (paramInt1 <= i) {
        int[] arrayOfInt = this.zzahj;
        if (i < arrayOfInt.length) {
          System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, i - paramInt1);
        } else {
          int[] arrayOfInt1 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, paramInt1);
          System.arraycopy(this.zzahj, paramInt1, arrayOfInt1, paramInt1 + 1, this.size - paramInt1);
          this.zzahj = arrayOfInt1;
        } 
        this.zzahj[paramInt1] = paramInt2;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(zzp(paramInt1));
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
  
  public final boolean addAll(Collection<? extends Integer> paramCollection) {
    zzka();
    zzfb.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzfa))
      return super.addAll(paramCollection); 
    zzfa zzfa1 = (zzfa)paramCollection;
    int i = zzfa1.size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      int[] arrayOfInt = this.zzahj;
      if (i > arrayOfInt.length)
        this.zzahj = Arrays.copyOf(arrayOfInt, i); 
      System.arraycopy(zzfa1.zzahj, 0, this.zzahj, this.size, zzfa1.size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzfa))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzfa)paramObject).size)
      return false; 
    paramObject = ((zzfa)paramObject).zzahj;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzahj[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final int getInt(int paramInt) {
    zzo(paramInt);
    return this.zzahj[paramInt];
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + this.zzahj[b]; 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzka();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Integer.valueOf(this.zzahj[b]))) {
        paramObject = this.zzahj;
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
      int[] arrayOfInt = this.zzahj;
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
  
  public final void zzau(int paramInt) {
    zzo(this.size, paramInt);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */