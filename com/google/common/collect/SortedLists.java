package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
final class SortedLists {
  public static <E, K extends Comparable> int binarySearch(List<E> paramList, Function<? super E, K> paramFunction, @Nullable K paramK, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    return binarySearch(paramList, paramFunction, paramK, Ordering.natural(), paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }
  
  public static <E, K> int binarySearch(List<E> paramList, Function<? super E, K> paramFunction, @Nullable K paramK, Comparator<? super K> paramComparator, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    return binarySearch(Lists.transform(paramList, paramFunction), paramK, paramComparator, paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }
  
  public static <E extends Comparable> int binarySearch(List<? extends E> paramList, E paramE, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    Preconditions.checkNotNull(paramE);
    return binarySearch(paramList, paramE, Ordering.natural(), paramKeyPresentBehavior, paramKeyAbsentBehavior);
  }
  
  public static <E> int binarySearch(List<? extends E> paramList, @Nullable E paramE, Comparator<? super E> paramComparator, KeyPresentBehavior paramKeyPresentBehavior, KeyAbsentBehavior paramKeyAbsentBehavior) {
    Preconditions.checkNotNull(paramComparator);
    Preconditions.checkNotNull(paramList);
    Preconditions.checkNotNull(paramKeyPresentBehavior);
    Preconditions.checkNotNull(paramKeyAbsentBehavior);
    List<? extends E> list = paramList;
    if (!(paramList instanceof java.util.RandomAccess))
      list = Lists.newArrayList(paramList); 
    int i = 0;
    int j = list.size() - 1;
    while (i <= j) {
      int k = i + j >>> 1;
      int m = paramComparator.compare(paramE, list.get(k));
      if (m < 0) {
        j = k - 1;
        continue;
      } 
      if (m > 0) {
        i = k + 1;
        continue;
      } 
      return i + paramKeyPresentBehavior.<E>resultIndex(paramComparator, paramE, list.subList(i, j + 1), k - i);
    } 
    return paramKeyAbsentBehavior.resultIndex(i);
  }
  
  public enum KeyAbsentBehavior {
    INVERTED_INSERTION_INDEX,
    NEXT_HIGHER,
    NEXT_LOWER {
      int resultIndex(int param2Int) {
        return param2Int - 1;
      }
    };
    
    static {
      INVERTED_INSERTION_INDEX = new null("INVERTED_INSERTION_INDEX", 2);
      $VALUES = new KeyAbsentBehavior[] { NEXT_LOWER, NEXT_HIGHER, INVERTED_INSERTION_INDEX };
    }
    
    abstract int resultIndex(int param1Int);
  }
  
  enum null {
    int resultIndex(int param1Int) {
      return param1Int - 1;
    }
  }
  
  enum null {
    public int resultIndex(int param1Int) {
      return param1Int;
    }
  }
  
  enum null {
    public int resultIndex(int param1Int) {
      return param1Int ^ 0xFFFFFFFF;
    }
  }
  
  public enum KeyPresentBehavior {
    ANY_PRESENT {
      <E> int resultIndex(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        return param2Int;
      }
    },
    FIRST_AFTER,
    FIRST_PRESENT,
    LAST_BEFORE,
    LAST_PRESENT {
      <E> int resultIndex(Comparator<? super E> param2Comparator, E param2E, List<? extends E> param2List, int param2Int) {
        int i = param2List.size() - 1;
        while (param2Int < i) {
          int j = param2Int + i + 1 >>> 1;
          if (param2Comparator.compare(param2List.get(j), param2E) > 0) {
            i = j - 1;
            continue;
          } 
          param2Int = j;
        } 
        return param2Int;
      }
    };
    
    static {
      FIRST_AFTER = new null("FIRST_AFTER", 3);
      LAST_BEFORE = new null("LAST_BEFORE", 4);
      $VALUES = new KeyPresentBehavior[] { ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, LAST_BEFORE };
    }
    
    abstract <E> int resultIndex(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int);
  }
  
  enum null {
    <E> int resultIndex(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      return param1Int;
    }
  }
  
  enum null {
    <E> int resultIndex(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      int i = param1List.size() - 1;
      while (param1Int < i) {
        int j = param1Int + i + 1 >>> 1;
        if (param1Comparator.compare(param1List.get(j), param1E) > 0) {
          i = j - 1;
          continue;
        } 
        param1Int = j;
      } 
      return param1Int;
    }
  }
  
  enum null {
    <E> int resultIndex(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      int i = 0;
      while (i < param1Int) {
        int j = i + param1Int >>> 1;
        if (param1Comparator.compare(param1List.get(j), param1E) < 0) {
          i = j + 1;
          continue;
        } 
        param1Int = j;
      } 
      return i;
    }
  }
  
  enum null {
    public <E> int resultIndex(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      return LAST_PRESENT.<E>resultIndex(param1Comparator, param1E, param1List, param1Int) + 1;
    }
  }
  
  enum null {
    public <E> int resultIndex(Comparator<? super E> param1Comparator, E param1E, List<? extends E> param1List, int param1Int) {
      return FIRST_PRESENT.<E>resultIndex(param1Comparator, param1E, param1List, param1Int) - 1;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\SortedLists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */