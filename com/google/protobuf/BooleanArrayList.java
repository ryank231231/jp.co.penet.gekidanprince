package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess {
  private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList();
  
  private boolean[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  BooleanArrayList() {
    this(new boolean[10], 0);
  }
  
  private BooleanArrayList(boolean[] paramArrayOfboolean, int paramInt) {
    this.array = paramArrayOfboolean;
    this.size = paramInt;
  }
  
  private void addBoolean(int paramInt, boolean paramBoolean) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        boolean[] arrayOfBoolean = this.array;
        if (i < arrayOfBoolean.length) {
          System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, i - paramInt);
        } else {
          boolean[] arrayOfBoolean1 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean, 0, arrayOfBoolean1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfBoolean1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfBoolean1;
        } 
        this.array[paramInt] = paramBoolean;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static BooleanArrayList emptyList() {
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
  
  public void add(int paramInt, Boolean paramBoolean) {
    addBoolean(paramInt, paramBoolean.booleanValue());
  }
  
  public boolean addAll(Collection<? extends Boolean> paramCollection) {
    ensureIsMutable();
    if (paramCollection != null) {
      if (!(paramCollection instanceof BooleanArrayList))
        return super.addAll(paramCollection); 
      BooleanArrayList booleanArrayList = (BooleanArrayList)paramCollection;
      int i = booleanArrayList.size;
      if (i == 0)
        return false; 
      int j = this.size;
      if (Integer.MAX_VALUE - j >= i) {
        i = j + i;
        boolean[] arrayOfBoolean = this.array;
        if (i > arrayOfBoolean.length)
          this.array = Arrays.copyOf(arrayOfBoolean, i); 
        System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
        this.size = i;
        this.modCount++;
        return true;
      } 
      throw new OutOfMemoryError();
    } 
    throw new NullPointerException();
  }
  
  public void addBoolean(boolean paramBoolean) {
    addBoolean(this.size, paramBoolean);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof BooleanArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((BooleanArrayList)paramObject).size)
      return false; 
    paramObject = ((BooleanArrayList)paramObject).array;
    for (byte b = 0; b < this.size; b++) {
      if (this.array[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public Boolean get(int paramInt) {
    return Boolean.valueOf(getBoolean(paramInt));
  }
  
  public boolean getBoolean(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + Internal.hashBoolean(this.array[b]); 
    return i;
  }
  
  public Internal.BooleanList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new BooleanArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Boolean remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    boolean[] arrayOfBoolean = this.array;
    boolean bool = arrayOfBoolean[paramInt];
    System.arraycopy(arrayOfBoolean, paramInt + 1, arrayOfBoolean, paramInt, this.size - paramInt);
    this.size--;
    this.modCount++;
    return Boolean.valueOf(bool);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Boolean.valueOf(this.array[b]))) {
        paramObject = this.array;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  public Boolean set(int paramInt, Boolean paramBoolean) {
    return Boolean.valueOf(setBoolean(paramInt, paramBoolean.booleanValue()));
  }
  
  public boolean setBoolean(int paramInt, boolean paramBoolean) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    boolean[] arrayOfBoolean = this.array;
    boolean bool = arrayOfBoolean[paramInt];
    arrayOfBoolean[paramInt] = paramBoolean;
    return bool;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\BooleanArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */