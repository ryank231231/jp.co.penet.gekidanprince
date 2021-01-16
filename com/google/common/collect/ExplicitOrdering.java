package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final ImmutableMap<T, Integer> rankMap;
  
  ExplicitOrdering(ImmutableMap<T, Integer> paramImmutableMap) {
    this.rankMap = paramImmutableMap;
  }
  
  ExplicitOrdering(List<T> paramList) {
    this(Maps.indexMap(paramList));
  }
  
  private int rank(T paramT) {
    Integer integer = this.rankMap.get(paramT);
    if (integer != null)
      return integer.intValue(); 
    throw new Ordering.IncomparableValueException(paramT);
  }
  
  public int compare(T paramT1, T paramT2) {
    return rank(paramT1) - rank(paramT2);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof ExplicitOrdering) {
      paramObject = paramObject;
      return this.rankMap.equals(((ExplicitOrdering)paramObject).rankMap);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.rankMap.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ordering.explicit(");
    stringBuilder.append(this.rankMap.keySet());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ExplicitOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */