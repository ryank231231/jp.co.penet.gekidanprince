package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess {
  private static final FloatArrayList EMPTY_LIST = new FloatArrayList();
  
  private float[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  FloatArrayList() {
    this(new float[10], 0);
  }
  
  private FloatArrayList(float[] paramArrayOffloat, int paramInt) {
    this.array = paramArrayOffloat;
    this.size = paramInt;
  }
  
  private void addFloat(int paramInt, float paramFloat) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        float[] arrayOfFloat = this.array;
        if (i < arrayOfFloat.length) {
          System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, i - paramInt);
        } else {
          float[] arrayOfFloat1 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat, 0, arrayOfFloat1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfFloat1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfFloat1;
        } 
        this.array[paramInt] = paramFloat;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static FloatArrayList emptyList() {
    return EMPTY_LIST;
  }
  
  private void ensureIndexInRange(int paramInt) {
    if (paramInt >= 0 && paramInt < this.size)
      return; 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  private String makeOutOfBoundsExceptionMessage(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Index:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", Size:");
    stringBuilder.append(this.size);
    return stringBuilder.toString();
  }
  
  public void add(int paramInt, Float paramFloat) {
    addFloat(paramInt, paramFloat.floatValue());
  }
  
  public boolean addAll(Collection<? extends Float> paramCollection) {
    ensureIsMutable();
    if (paramCollection != null) {
      if (!(paramCollection instanceof FloatArrayList))
        return super.addAll(paramCollection); 
      paramCollection = paramCollection;
      int i = ((FloatArrayList)paramCollection).size;
      if (i == 0)
        return false; 
      int j = this.size;
      if (Integer.MAX_VALUE - j >= i) {
        i = j + i;
        float[] arrayOfFloat = this.array;
        if (i > arrayOfFloat.length)
          this.array = Arrays.copyOf(arrayOfFloat, i); 
        System.arraycopy(((FloatArrayList)paramCollection).array, 0, this.array, this.size, ((FloatArrayList)paramCollection).size);
        this.size = i;
        this.modCount++;
        return true;
      } 
      throw new OutOfMemoryError();
    } 
    throw new NullPointerException();
  }
  
  public void addFloat(float paramFloat) {
    addFloat(this.size, paramFloat);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof FloatArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((FloatArrayList)paramObject).size)
      return false; 
    paramObject = ((FloatArrayList)paramObject).array;
    for (byte b = 0; b < this.size; b++) {
      if (this.array[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public Float get(int paramInt) {
    return Float.valueOf(getFloat(paramInt));
  }
  
  public float getFloat(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + Float.floatToIntBits(this.array[b]); 
    return i;
  }
  
  public Internal.FloatList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new FloatArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Float remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float[] arrayOfFloat = this.array;
    float f = arrayOfFloat[paramInt];
    System.arraycopy(arrayOfFloat, paramInt + 1, arrayOfFloat, paramInt, this.size - paramInt);
    this.size--;
    this.modCount++;
    return Float.valueOf(f);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Float.valueOf(this.array[b]))) {
        paramObject = this.array;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  public Float set(int paramInt, Float paramFloat) {
    return Float.valueOf(setFloat(paramInt, paramFloat.floatValue()));
  }
  
  public float setFloat(int paramInt, float paramFloat) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float[] arrayOfFloat = this.array;
    float f = arrayOfFloat[paramInt];
    arrayOfFloat[paramInt] = paramFloat;
    return f;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\FloatArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */