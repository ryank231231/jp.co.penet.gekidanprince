package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
final class CollectPreconditions {
  static void checkEntryNotNull(Object paramObject1, Object paramObject2) {
    if (paramObject1 != null) {
      if (paramObject2 != null)
        return; 
      paramObject2 = new StringBuilder();
      paramObject2.append("null value in entry: ");
      paramObject2.append(paramObject1);
      paramObject2.append("=null");
      throw new NullPointerException(paramObject2.toString());
    } 
    paramObject1 = new StringBuilder();
    paramObject1.append("null key in entry: null=");
    paramObject1.append(paramObject2);
    throw new NullPointerException(paramObject1.toString());
  }
  
  @CanIgnoreReturnValue
  static int checkNonnegative(int paramInt, String paramString) {
    if (paramInt >= 0)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" cannot be negative but was: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static void checkPositive(int paramInt, String paramString) {
    if (paramInt > 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" must be positive but was: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static void checkRemove(boolean paramBoolean) {
    Preconditions.checkState(paramBoolean, "no calls to next() since the last call to remove()");
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\CollectPreconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */