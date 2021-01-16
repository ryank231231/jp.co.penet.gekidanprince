package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;

@GwtCompatible(serializable = true)
final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
  static final NaturalOrdering INSTANCE = new NaturalOrdering();
  
  private static final long serialVersionUID = 0L;
  
  private transient Ordering<Comparable> nullsFirst;
  
  private transient Ordering<Comparable> nullsLast;
  
  private Object readResolve() {
    return INSTANCE;
  }
  
  public int compare(Comparable<Comparable> paramComparable1, Comparable paramComparable2) {
    Preconditions.checkNotNull(paramComparable1);
    Preconditions.checkNotNull(paramComparable2);
    return paramComparable1.compareTo(paramComparable2);
  }
  
  public <S extends Comparable> Ordering<S> nullsFirst() {
    Ordering<Comparable> ordering1 = this.nullsFirst;
    Ordering<Comparable> ordering2 = ordering1;
    if (ordering1 == null) {
      ordering2 = super.nullsFirst();
      this.nullsFirst = ordering2;
    } 
    return (Ordering)ordering2;
  }
  
  public <S extends Comparable> Ordering<S> nullsLast() {
    Ordering<Comparable> ordering1 = this.nullsLast;
    Ordering<Comparable> ordering2 = ordering1;
    if (ordering1 == null) {
      ordering2 = super.nullsLast();
      this.nullsLast = ordering2;
    } 
    return (Ordering)ordering2;
  }
  
  public <S extends Comparable> Ordering<S> reverse() {
    return ReverseNaturalOrdering.INSTANCE;
  }
  
  public String toString() {
    return "Ordering.natural()";
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\NaturalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */