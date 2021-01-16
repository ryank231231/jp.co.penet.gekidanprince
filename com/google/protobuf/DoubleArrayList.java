package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess {
  private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList();
  
  private double[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  DoubleArrayList() {
    this(new double[10], 0);
  }
  
  private DoubleArrayList(double[] paramArrayOfdouble, int paramInt) {
    this.array = paramArrayOfdouble;
    this.size = paramInt;
  }
  
  private void addDouble(int paramInt, double paramDouble) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        double[] arrayOfDouble = this.array;
        if (i < arrayOfDouble.length) {
          System.arraycopy(arrayOfDouble, paramInt, arrayOfDouble, paramInt + 1, i - paramInt);
        } else {
          double[] arrayOfDouble1 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble, 0, arrayOfDouble1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfDouble1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfDouble1;
        } 
        this.array[paramInt] = paramDouble;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static DoubleArrayList emptyList() {
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
  
  public void add(int paramInt, Double paramDouble) {
    addDouble(paramInt, paramDouble.doubleValue());
  }
  
  public boolean addAll(Collection<? extends Double> paramCollection) {
    ensureIsMutable();
    if (paramCollection != null) {
      if (!(paramCollection instanceof DoubleArrayList))
        return super.addAll(paramCollection); 
      paramCollection = paramCollection;
      int i = ((DoubleArrayList)paramCollection).size;
      if (i == 0)
        return false; 
      int j = this.size;
      if (Integer.MAX_VALUE - j >= i) {
        i = j + i;
        double[] arrayOfDouble = this.array;
        if (i > arrayOfDouble.length)
          this.array = Arrays.copyOf(arrayOfDouble, i); 
        System.arraycopy(((DoubleArrayList)paramCollection).array, 0, this.array, this.size, ((DoubleArrayList)paramCollection).size);
        this.size = i;
        this.modCount++;
        return true;
      } 
      throw new OutOfMemoryError();
    } 
    throw new NullPointerException();
  }
  
  public void addDouble(double paramDouble) {
    addDouble(this.size, paramDouble);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof DoubleArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((DoubleArrayList)paramObject).size)
      return false; 
    paramObject = ((DoubleArrayList)paramObject).array;
    for (byte b = 0; b < this.size; b++) {
      if (this.array[b] != paramObject[b])
        return false; 
    } 
    return true;
  }
  
  public Double get(int paramInt) {
    return Double.valueOf(getDouble(paramInt));
  }
  
  public double getDouble(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int i = 1;
    for (byte b = 0; b < this.size; b++)
      i = i * 31 + Internal.hashLong(Double.doubleToLongBits(this.array[b])); 
    return i;
  }
  
  public Internal.DoubleList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new DoubleArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Double remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double[] arrayOfDouble = this.array;
    double d = arrayOfDouble[paramInt];
    System.arraycopy(arrayOfDouble, paramInt + 1, arrayOfDouble, paramInt, this.size - paramInt);
    this.size--;
    this.modCount++;
    return Double.valueOf(d);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (byte b = 0; b < this.size; b++) {
      if (paramObject.equals(Double.valueOf(this.array[b]))) {
        paramObject = this.array;
        System.arraycopy(paramObject, b + 1, paramObject, b, this.size - b);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  public Double set(int paramInt, Double paramDouble) {
    return Double.valueOf(setDouble(paramInt, paramDouble.doubleValue()));
  }
  
  public double setDouble(int paramInt, double paramDouble) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double[] arrayOfDouble = this.array;
    double d = arrayOfDouble[paramInt];
    arrayOfDouble[paramInt] = paramDouble;
    return d;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\DoubleArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */