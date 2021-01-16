package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzew extends zzdj<Float> implements zzfg<Float>, zzgt, RandomAccess {
  private static final zzew zzagj;
  
  private int size;
  
  private float[] zzagk;
  
  static {
    zzew zzew1 = new zzew(new float[0], 0);
    zzagj = zzew1;
    zzew1.zzjz();
  }
  
  zzew() {
    this(new float[10], 0);
  }
  
  private zzew(float[] paramArrayOffloat, int paramInt) {
    this.zzagk = paramArrayOffloat;
    this.size = paramInt;
  }
  
  private final void zzc(int paramInt, float paramFloat) {
    zzka();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        float[] arrayOfFloat = this.zzagk;
        if (i < arrayOfFloat.length) {
          System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, i - paramInt);
        } else {
          float[] arrayOfFloat1 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat, 0, arrayOfFloat1, 0, paramInt);
          System.arraycopy(this.zzagk, paramInt, arrayOfFloat1, paramInt + 1, this.size - paramInt);
          this.zzagk = arrayOfFloat1;
        } 
        this.zzagk[paramInt] = paramFloat;
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
  
  public final boolean addAll(Collection<? extends Float> paramCollection) {
    zzka();
    zzfb.checkNotNull(paramCollection);
    if (!(paramCollection instanceof zzew))
      return super.addAll(paramCollection); 
    zzew zzew1 = (zzew)paramCollection;
    int i = zzew1.size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      j += i;
      float[] arrayOfFloat = this.zzagk;
      if (j > arrayOfFloat.length)
        this.zzagk = Arrays.copyOf(arrayOfFloat, j); 
      System.arraycopy(zzew1.zzagk, 0, this.zzagk, this.size, zzew1.size);
      this.size = j;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public final boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof zzew))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((zzew)paramObject).size)
      return false; 
    paramObject = ((zzew)paramObject).zzagk;
    for (byte b = 0; b < this.size; b++) {
      if (Float.floatToIntBits(this.zzagk[b]) != Float.floatToIntBits(paramObject[b]))
        return false; 
    } 
    return true;
  }
  
  public final int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + Float.floatToIntBits(this.zzagk[b]); 
    return i;
  }
  
  public final boolean remove(Object paramObject) {
    zzka();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Float.valueOf(this.zzagk[b]))) {
        paramObject = this.zzagk;
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
      float[] arrayOfFloat = this.zzagk;
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */