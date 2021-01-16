package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
final class Hashing {
  private static final int C1 = -862048943;
  
  private static final int C2 = 461845907;
  
  private static final int MAX_TABLE_SIZE = 1073741824;
  
  static int closedTableSize(int paramInt, double paramDouble) {
    int i = Math.max(paramInt, 2);
    paramInt = Integer.highestOneBit(i);
    double d = paramInt;
    Double.isNaN(d);
    if (i > (int)(paramDouble * d)) {
      paramInt <<= 1;
      if (paramInt <= 0)
        paramInt = 1073741824; 
      return paramInt;
    } 
    return paramInt;
  }
  
  static boolean needsResizing(int paramInt1, int paramInt2, double paramDouble) {
    boolean bool;
    double d1 = paramInt1;
    double d2 = paramInt2;
    Double.isNaN(d2);
    if (d1 > paramDouble * d2 && paramInt2 < 1073741824) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static int smear(int paramInt) {
    return Integer.rotateLeft(paramInt * -862048943, 15) * 461845907;
  }
  
  static int smearedHash(@Nullable Object paramObject) {
    int i;
    if (paramObject == null) {
      i = 0;
    } else {
      i = paramObject.hashCode();
    } 
    return smear(i);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Hashing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */