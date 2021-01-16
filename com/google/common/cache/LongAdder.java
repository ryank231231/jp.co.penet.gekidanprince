package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@GwtCompatible(emulated = true)
final class LongAdder extends Striped64 implements Serializable, LongAddable {
  private static final long serialVersionUID = 7249069246863182397L;
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.busy = 0;
    this.cells = null;
    this.base = paramObjectInputStream.readLong();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeLong(sum());
  }
  
  public void add(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield cells : [Lcom/google/common/cache/Striped64$Cell;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull -> 28
    //   9: aload_0
    //   10: getfield base : J
    //   13: lstore #4
    //   15: aload_0
    //   16: lload #4
    //   18: lload #4
    //   20: lload_1
    //   21: ladd
    //   22: invokevirtual casBase : (JJ)Z
    //   25: ifne -> 125
    //   28: getstatic com/google/common/cache/LongAdder.threadHashCode : Ljava/lang/ThreadLocal;
    //   31: invokevirtual get : ()Ljava/lang/Object;
    //   34: checkcast [I
    //   37: astore #6
    //   39: iconst_1
    //   40: istore #7
    //   42: iload #7
    //   44: istore #8
    //   46: aload #6
    //   48: ifnull -> 116
    //   51: iload #7
    //   53: istore #8
    //   55: aload_3
    //   56: ifnull -> 116
    //   59: aload_3
    //   60: arraylength
    //   61: istore #9
    //   63: iload #7
    //   65: istore #8
    //   67: iload #9
    //   69: iconst_1
    //   70: if_icmplt -> 116
    //   73: aload_3
    //   74: iload #9
    //   76: iconst_1
    //   77: isub
    //   78: aload #6
    //   80: iconst_0
    //   81: iaload
    //   82: iand
    //   83: aaload
    //   84: astore_3
    //   85: iload #7
    //   87: istore #8
    //   89: aload_3
    //   90: ifnull -> 116
    //   93: aload_3
    //   94: getfield value : J
    //   97: lstore #4
    //   99: aload_3
    //   100: lload #4
    //   102: lload #4
    //   104: lload_1
    //   105: ladd
    //   106: invokevirtual cas : (JJ)Z
    //   109: istore #8
    //   111: iload #8
    //   113: ifne -> 125
    //   116: aload_0
    //   117: lload_1
    //   118: aload #6
    //   120: iload #8
    //   122: invokevirtual retryUpdate : (J[IZ)V
    //   125: return
  }
  
  public void decrement() {
    add(-1L);
  }
  
  public double doubleValue() {
    return sum();
  }
  
  public float floatValue() {
    return (float)sum();
  }
  
  final long fn(long paramLong1, long paramLong2) {
    return paramLong1 + paramLong2;
  }
  
  public void increment() {
    add(1L);
  }
  
  public int intValue() {
    return (int)sum();
  }
  
  public long longValue() {
    return sum();
  }
  
  public void reset() {
    internalReset(0L);
  }
  
  public long sum() {
    long l1 = this.base;
    Striped64.Cell[] arrayOfCell = this.cells;
    long l2 = l1;
    if (arrayOfCell != null) {
      int i = arrayOfCell.length;
      byte b = 0;
      while (true) {
        l2 = l1;
        if (b < i) {
          Striped64.Cell cell = arrayOfCell[b];
          l2 = l1;
          if (cell != null)
            l2 = l1 + cell.value; 
          b++;
          l1 = l2;
          continue;
        } 
        break;
      } 
    } 
    return l2;
  }
  
  public long sumThenReset() {
    long l1 = this.base;
    Striped64.Cell[] arrayOfCell = this.cells;
    this.base = 0L;
    long l2 = l1;
    if (arrayOfCell != null) {
      int i = arrayOfCell.length;
      byte b = 0;
      while (true) {
        l2 = l1;
        if (b < i) {
          Striped64.Cell cell = arrayOfCell[b];
          l2 = l1;
          if (cell != null) {
            l2 = l1 + cell.value;
            cell.value = 0L;
          } 
          b++;
          l1 = l2;
          continue;
        } 
        break;
      } 
    } 
    return l2;
  }
  
  public String toString() {
    return Long.toString(sum());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\LongAdder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */