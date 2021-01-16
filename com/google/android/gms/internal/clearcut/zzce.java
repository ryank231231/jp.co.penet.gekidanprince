package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzce extends zzav<Float> implements zzcn<Float>, RandomAccess {
  private static final zzce zzjm;
  
  private int size;
  
  private float[] zzjn;
  
  static {
    zzce zzce1 = new zzce();
    zzjm = zzce1;
    zzce1.zzv();
  }
  
  zzce() {
    this(new float[10], 0);
  }
  
  private zzce(float[] paramArrayOffloat, int paramInt) {
    this.zzjn = paramArrayOffloat;
    this.size = paramInt;
  }
  
  private final void zzc(int paramInt, float paramFloat) {
    zzw();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        float[] arrayOfFloat = this.zzjn;
        if (i < arrayOfFloat.length) {
          System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, i - paramInt);
        } else {
          float[] arrayOfFloat1 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat, 0, arrayOfFloat1, 0, paramInt);
          System.arraycopy(this.zzjn, paramInt, arrayOfFloat1, paramInt + 1, this.size - paramInt);
          this.zzjn = arrayOfFloat1;
        } 
        this.zzjn[paramInt] = paramFloat;
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
  
  public final boolean addAll(Collection<? extends Float> paramCollection) {
    zzw();
    zzci.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzce))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((zzce)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      float[] arrayOfFloat = this.zzjn;
      if (i > arrayOfFloat.length)
        this.zzjn = Arrays.copyOf(arrayOfFloat, i); 
      System.arraycopy(((zzce)paramCollection).zzjn, 0, this.zzjn, this.size, ((zzce)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzce))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzce)paramObject).size)
      return false; 
    paramObject = ((zzce)paramObject).zzjn;
    for (byte b = 0; b < this.size; b++) {
      if (this.zzjn[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + Float.floatToIntBits(this.zzjn[b]); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzw();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Float.valueOf(this.zzjn[b]))) {
        paramObject = this.zzjn;
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
      float[] arrayOfFloat = this.zzjn;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public final int size() {
    return this.size;
  }
  
  public final void zzc(float paramFloat) {
    zzc(this.size, paramFloat);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */