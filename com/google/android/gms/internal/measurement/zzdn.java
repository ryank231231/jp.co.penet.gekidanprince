package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdn extends zzdj<Boolean> implements zzfg<Boolean>, zzgt, RandomAccess {
  private static final zzdn zzabw;
  
  private int size;
  
  private boolean[] zzabx;
  
  static {
    zzdn zzdn1 = new zzdn(new boolean[0], 0);
    zzabw = zzdn1;
    zzdn1.zzjz();
  }
  
  zzdn() {
    this(new boolean[10], 0);
  }
  
  private zzdn(boolean[] paramArrayOfboolean, int paramInt) {
    this.zzabx = paramArrayOfboolean;
    this.size = paramInt;
  }
  
  private final void zza(int paramInt, boolean paramBoolean) {
    zzka();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        boolean[] arrayOfBoolean = this.zzabx;
        if (i < arrayOfBoolean.length) {
          System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, i - paramInt);
        } else {
          boolean[] arrayOfBoolean1 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean, 0, arrayOfBoolean1, 0, paramInt);
          System.arraycopy(this.zzabx, paramInt, arrayOfBoolean1, paramInt + 1, this.size - paramInt);
          this.zzabx = arrayOfBoolean1;
        } 
        this.zzabx[paramInt] = paramBoolean;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection) {
    zzka();
    zzfb.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzdn))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((zzdn)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      boolean[] arrayOfBoolean = this.zzabx;
      if (i > arrayOfBoolean.length)
        this.zzabx = Arrays.copyOf(arrayOfBoolean, i); 
      System.arraycopy(((zzdn)paramCollection).zzabx, 0, this.zzabx, this.size, ((zzdn)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final void addBoolean(boolean paramBoolean) {
    zza(this.size, paramBoolean);
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzdn))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzdn)paramObject).size)
      return false; 
    paramObject = ((zzdn)paramObject).zzabx;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzabx[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + zzfb.zzo(this.zzabx[b]); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzka();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Boolean.valueOf(this.zzabx[b]))) {
        paramObject = this.zzabx;
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
      boolean[] arrayOfBoolean = this.zzabx;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size() {
    return this.size;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */