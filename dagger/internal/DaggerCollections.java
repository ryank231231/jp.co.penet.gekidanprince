package dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class DaggerCollections {
  private static final int MAX_POWER_OF_TWO = 1073741824;
  
  private static int calculateInitialCapacity(int paramInt) {
    return (paramInt < 3) ? (paramInt + 1) : ((paramInt < 1073741824) ? (int)(paramInt / 0.75F + 1.0F) : Integer.MAX_VALUE);
  }
  
  public static boolean hasDuplicates(List<?> paramList) {
    int i = paramList.size();
    boolean bool = false;
    if (i < 2)
      return false; 
    HashSet hashSet = new HashSet(paramList);
    if (paramList.size() != hashSet.size())
      bool = true; 
    return bool;
  }
  
  static <T> HashSet<T> newHashSetWithExpectedSize(int paramInt) {
    return new HashSet<T>(calculateInitialCapacity(paramInt));
  }
  
  static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int paramInt) {
    return new LinkedHashMap<K, V>(calculateInitialCapacity(paramInt));
  }
  
  public static <T> List<T> presizedList(int paramInt) {
    return (paramInt == 0) ? Collections.emptyList() : new ArrayList<T>(paramInt);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\DaggerCollections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */