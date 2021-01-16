package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
  static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
  
  private static final long serialVersionUID = 0L;
  
  private Object readResolve() {
    return INSTANCE;
  }
  
  public int compare(Comparable paramComparable1, Comparable<Comparable> paramComparable2) {
    Preconditions.checkNotNull(paramComparable1);
    return (paramComparable1 == paramComparable2) ? 0 : paramComparable2.compareTo(paramComparable1);
  }
  
  public <E extends Comparable> E max(E paramE1, E paramE2) {
    return (E)NaturalOrdering.INSTANCE.min(paramE1, paramE2);
  }
  
  public <E extends Comparable> E max(E paramE1, E paramE2, E paramE3, E... paramVarArgs) {
    return (E)NaturalOrdering.INSTANCE.min(paramE1, paramE2, paramE3, (Object[])paramVarArgs);
  }
  
  public <E extends Comparable> E max(Iterable<E> paramIterable) {
    return (E)NaturalOrdering.INSTANCE.min(paramIterable);
  }
  
  public <E extends Comparable> E max(Iterator<E> paramIterator) {
    return (E)NaturalOrdering.INSTANCE.min(paramIterator);
  }
  
  public <E extends Comparable> E min(E paramE1, E paramE2) {
    return (E)NaturalOrdering.INSTANCE.max(paramE1, paramE2);
  }
  
  public <E extends Comparable> E min(E paramE1, E paramE2, E paramE3, E... paramVarArgs) {
    return (E)NaturalOrdering.INSTANCE.max(paramE1, paramE2, paramE3, (Object[])paramVarArgs);
  }
  
  public <E extends Comparable> E min(Iterable<E> paramIterable) {
    return (E)NaturalOrdering.INSTANCE.max(paramIterable);
  }
  
  public <E extends Comparable> E min(Iterator<E> paramIterator) {
    return (E)NaturalOrdering.INSTANCE.max(paramIterator);
  }
  
  public <S extends Comparable> Ordering<S> reverse() {
    return Ordering.natural();
  }
  
  public String toString() {
    return "Ordering.natural().reverse()";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ReverseNaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */