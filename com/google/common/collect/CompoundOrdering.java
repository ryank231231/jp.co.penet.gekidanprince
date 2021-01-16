package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible(serializable = true)
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final ImmutableList<Comparator<? super T>> comparators;
  
  CompoundOrdering(Iterable<? extends Comparator<? super T>> paramIterable) {
    this.comparators = ImmutableList.copyOf(paramIterable);
  }
  
  CompoundOrdering(Comparator<? super T> paramComparator1, Comparator<? super T> paramComparator2) {
    this.comparators = ImmutableList.of(paramComparator1, paramComparator2);
  }
  
  public int compare(T paramT1, T paramT2) {
    int i = this.comparators.size();
    for (byte b = 0; b < i; b++) {
      int j = ((Comparator<T>)this.comparators.get(b)).compare(paramT1, paramT2);
      if (j != 0)
        return j; 
    } 
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof CompoundOrdering) {
      paramObject = paramObject;
      return this.comparators.equals(((CompoundOrdering)paramObject).comparators);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.comparators.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Ordering.compound(");
    stringBuilder.append(this.comparators);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\CompoundOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */