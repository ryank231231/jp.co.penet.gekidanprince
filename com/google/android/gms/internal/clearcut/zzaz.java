package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzaz extends zzav<Boolean> implements zzcn<Boolean>, RandomAccess {
  private static final zzaz zzfg;
  
  private int size;
  
  private boolean[] zzfh;
  
  static {
    zzaz zzaz1 = new zzaz();
    zzfg = zzaz1;
    zzaz1.zzv();
  }
  
  zzaz() {
    this(new boolean[10], 0);
  }
  
  private zzaz(boolean[] paramArrayOfboolean, int paramInt) {
    this.zzfh = paramArrayOfboolean;
    this.size = paramInt;
  }
  
  private final void zza(int paramInt, boolean paramBoolean) {
    zzw();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        boolean[] arrayOfBoolean = this.zzfh;
        if (i < arrayOfBoolean.length) {
          System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, i - paramInt);
        } else {
          boolean[] arrayOfBoolean1 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean, 0, arrayOfBoolean1, 0, paramInt);
          System.arraycopy(this.zzfh, paramInt, arrayOfBoolean1, paramInt + 1, this.size - paramInt);
          this.zzfh = arrayOfBoolean1;
        } 
        this.zzfh[paramInt] = paramBoolean;
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
  
  public final boolean addAll(Collection<? extends Boolean> paramCollection) {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzaz))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((zzaz)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      j += i;
      boolean[] arrayOfBoolean = this.zzfh;
      if (j > arrayOfBoolean.length)
        this.zzfh = Arrays.copyOf(arrayOfBoolean, j); 
      System.arraycopy(((zzaz)paramCollection).zzfh, 0, this.zzfh, this.size, ((zzaz)paramCollection).size);
      this.size = j;
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
    if (!(paramObject instanceof zzaz))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzaz)paramObject).size)
      return false; 
    paramObject = ((zzaz)paramObject).zzfh;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzfh[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + zzci.zzc(this.zzfh[b]); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzw();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Boolean.valueOf(this.zzfh[b]))) {
        paramObject = this.zzfh;
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
      boolean[] arrayOfBoolean = this.zzfh;
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */