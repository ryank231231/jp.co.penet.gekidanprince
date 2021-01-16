package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess {
  private static final LongArrayList EMPTY_LIST = new LongArrayList();
  
  private long[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  LongArrayList() {
    this(new long[10], 0);
  }
  
  private LongArrayList(long[] paramArrayOflong, int paramInt) {
    this.array = paramArrayOflong;
    this.size = paramInt;
  }
  
  private void addLong(int paramInt, long paramLong) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        long[] arrayOfLong = this.array;
        if (i < arrayOfLong.length) {
          System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, i - paramInt);
        } else {
          long[] arrayOfLong1 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong, 0, arrayOfLong1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfLong1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfLong1;
        } 
        this.array[paramInt] = paramLong;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static LongArrayList emptyList() {
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
  
  public void add(int paramInt, Long paramLong) {
    addLong(paramInt, paramLong.longValue());
  }
  
  public boolean addAll(Collection<? extends Long> paramCollection) {
    ensureIsMutable();
    if (paramCollection != null) {
      if (!(paramCollection instanceof LongArrayList))
        return super.addAll(paramCollection); 
      paramCollection = paramCollection;
      int i = ((LongArrayList)paramCollection).size;
      if (i == 0)
        return false; 
      int j = this.size;
      if (Integer.MAX_VALUE - j >= i) {
        j += i;
        long[] arrayOfLong = this.array;
        if (j > arrayOfLong.length)
          this.array = Arrays.copyOf(arrayOfLong, j); 
        System.arraycopy(((LongArrayList)paramCollection).array, 0, this.array, this.size, ((LongArrayList)paramCollection).size);
        this.size = j;
        this.modCount++;
        return true;
      } 
      throw new OutOfMemoryError();
    } 
    throw new NullPointerException();
  }
  
  public void addLong(long paramLong) {
    addLong(this.size, paramLong);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LongArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((LongArrayList)paramObject).size)
      return false; 
    paramObject = ((LongArrayList)paramObject).array;
    for (byte b = 0; b < this.size; b++) {
      if (this.array[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public Long get(int paramInt) {
    return Long.valueOf(getLong(paramInt));
  }
  
  public long getLong(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + Internal.hashLong(this.array[b]); 
    return i;
  }
  
  public Internal.LongList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new LongArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Long remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long[] arrayOfLong = this.array;
    long l = arrayOfLong[paramInt];
    System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, this.size - paramInt);
    this.size--;
    this.modCount++;
    return Long.valueOf(l);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Long.valueOf(this.array[b]))) {
        paramObject = this.array;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  public Long set(int paramInt, Long paramLong) {
    return Long.valueOf(setLong(paramInt, paramLong.longValue()));
  }
  
  public long setLong(int paramInt, long paramLong) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long[] arrayOfLong = this.array;
    long l = arrayOfLong[paramInt];
    arrayOfLong[paramInt] = paramLong;
    return l;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\LongArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */