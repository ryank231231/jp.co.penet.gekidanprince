package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;

@GwtCompatible(emulated = true)
final class Platform {
  static <T> T[] newArray(T[] paramArrayOfT, int paramInt) {
    return (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
  }
  
  static MapMaker tryWeakKeys(MapMaker paramMapMaker) {
    return paramMapMaker.weakKeys();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */