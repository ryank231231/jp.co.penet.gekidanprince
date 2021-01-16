package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess {
  private static final IntArrayList EMPTY_LIST = new IntArrayList();
  
  private int[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  IntArrayList() {
    this(new int[10], 0);
  }
  
  private IntArrayList(int[] paramArrayOfint, int paramInt) {
    this.array = paramArrayOfint;
    this.size = paramInt;
  }
  
  private void addInt(int paramInt1, int paramInt2) {
    ensureIsMutable();
    if (paramInt1 >= 0) {
      int i = this.size;
      if (paramInt1 <= i) {
        int[] arrayOfInt = this.array;
        if (i < arrayOfInt.length) {
          System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, i - paramInt1);
        } else {
          int[] arrayOfInt1 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, paramInt1);
          System.arraycopy(this.array, paramInt1, arrayOfInt1, paramInt1 + 1, this.size - paramInt1);
          this.array = arrayOfInt1;
        } 
        this.array[paramInt1] = paramInt2;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt1));
  }
  
  public static IntArrayList emptyList() {
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
  
  public void add(int paramInt, Integer paramInteger) {
    addInt(paramInt, paramInteger.intValue());
  }
  
  public boolean addAll(Collection<? extends Integer> paramCollection) {
    ensureIsMutable();
    if (paramCollection != null) {
      if (!(paramCollection instanceof IntArrayList))
        return super.addAll(paramCollection); 
      IntArrayList intArrayList = (IntArrayList)paramCollection;
      int i = intArrayList.size;
      if (i == 0)
        return false; 
      int j = this.size;
      if (Integer.MAX_VALUE - j >= i) {
        j += i;
        int[] arrayOfInt = this.array;
        if (j > arrayOfInt.length)
          this.array = Arrays.copyOf(arrayOfInt, j); 
        System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
        this.size = j;
        this.modCount++;
        return true;
      } 
      throw new OutOfMemoryError();
    } 
    throw new NullPointerException();
  }
  
  public void addInt(int paramInt) {
    addInt(this.size, paramInt);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof IntArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((IntArrayList)paramObject).size)
      return false; 
    paramObject = ((IntArrayList)paramObject).array;
    for (byte b = 0; b < this.size; b++) {
      if (this.array[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public Integer get(int paramInt) {
    return Integer.valueOf(getInt(paramInt));
  }
  
  public int getInt(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + this.array[b]; 
    return i;
  }
  
  public Internal.IntList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new IntArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Integer remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    int[] arrayOfInt = this.array;
    int i = arrayOfInt[paramInt];
    System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, this.size - paramInt);
    this.size--;
    this.modCount++;
    return Integer.valueOf(i);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Integer.valueOf(this.array[b]))) {
        paramObject = this.array;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  public Integer set(int paramInt, Integer paramInteger) {
    return Integer.valueOf(setInt(paramInt, paramInteger.intValue()));
  }
  
  public int setInt(int paramInt1, int paramInt2) {
    ensureIsMutable();
    ensureIndexInRange(paramInt1);
    int[] arrayOfInt = this.array;
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = paramInt2;
    return i;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\IntArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */