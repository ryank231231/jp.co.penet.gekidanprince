package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

@GwtIncompatible
public class AtomicDoubleArray implements Serializable {
  private static final long serialVersionUID = 0L;
  
  private transient AtomicLongArray longs;
  
  public AtomicDoubleArray(int paramInt) {
    this.longs = new AtomicLongArray(paramInt);
  }
  
  public AtomicDoubleArray(double[] paramArrayOfdouble) {
    int i = paramArrayOfdouble.length;
    long[] arrayOfLong = new long[i];
    for (byte b = 0; b < i; b++)
      arrayOfLong[b] = Double.doubleToRawLongBits(paramArrayOfdouble[b]); 
    this.longs = new AtomicLongArray(arrayOfLong);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    this.longs = new AtomicLongArray(i);
    for (byte b = 0; b < i; b++)
      set(b, paramObjectInputStream.readDouble()); 
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    int i = length();
    paramObjectOutputStream.writeInt(i);
    for (byte b = 0; b < i; b++)
      paramObjectOutputStream.writeDouble(get(b)); 
  }
  
  @CanIgnoreReturnValue
  public double addAndGet(int paramInt, double paramDouble) {
    while (true) {
      long l1 = this.longs.get(paramInt);
      double d = Double.longBitsToDouble(l1) + paramDouble;
      long l2 = Double.doubleToRawLongBits(d);
      if (this.longs.compareAndSet(paramInt, l1, l2))
        return d; 
    } 
  }
  
  public final boolean compareAndSet(int paramInt, double paramDouble1, double paramDouble2) {
    return this.longs.compareAndSet(paramInt, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
  }
  
  public final double get(int paramInt) {
    return Double.longBitsToDouble(this.longs.get(paramInt));
  }
  
  @CanIgnoreReturnValue
  public final double getAndAdd(int paramInt, double paramDouble) {
    while (true) {
      long l1 = this.longs.get(paramInt);
      double d = Double.longBitsToDouble(l1);
      long l2 = Double.doubleToRawLongBits(d + paramDouble);
      if (this.longs.compareAndSet(paramInt, l1, l2))
        return d; 
    } 
  }
  
  public final double getAndSet(int paramInt, double paramDouble) {
    long l = Double.doubleToRawLongBits(paramDouble);
    return Double.longBitsToDouble(this.longs.getAndSet(paramInt, l));
  }
  
  public final void lazySet(int paramInt, double paramDouble) {
    set(paramInt, paramDouble);
  }
  
  public final int length() {
    return this.longs.length();
  }
  
  public final void set(int paramInt, double paramDouble) {
    long l = Double.doubleToRawLongBits(paramDouble);
    this.longs.set(paramInt, l);
  }
  
  public String toString() {
    int i = length() - 1;
    if (i == -1)
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder((i + 1) * 19);
    stringBuilder.append('[');
    for (int j = 0;; j++) {
      stringBuilder.append(Double.longBitsToDouble(this.longs.get(j)));
      if (j == i) {
        stringBuilder.append(']');
        return stringBuilder.toString();
      } 
      stringBuilder.append(',');
      stringBuilder.append(' ');
    } 
  }
  
  public final boolean weakCompareAndSet(int paramInt, double paramDouble1, double paramDouble2) {
    return this.longs.weakCompareAndSet(paramInt, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AtomicDoubleArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */