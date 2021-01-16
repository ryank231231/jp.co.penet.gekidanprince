package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class PairwiseEquivalence<T> extends Equivalence<Iterable<T>> implements Serializable {
  private static final long serialVersionUID = 1L;
  
  final Equivalence<? super T> elementEquivalence;
  
  PairwiseEquivalence(Equivalence<? super T> paramEquivalence) {
    this.elementEquivalence = Preconditions.<Equivalence<? super T>>checkNotNull(paramEquivalence);
  }
  
  protected boolean doEquivalent(Iterable<T> paramIterable1, Iterable<T> paramIterable2) {
    boolean bool2;
    Iterator<T> iterator1 = paramIterable1.iterator();
    Iterator<T> iterator2 = paramIterable2.iterator();
    while (true) {
      boolean bool = iterator1.hasNext();
      bool2 = false;
      if (bool && iterator2.hasNext()) {
        if (!this.elementEquivalence.equivalent(iterator1.next(), iterator2.next()))
          return false; 
        continue;
      } 
      break;
    } 
    boolean bool1 = bool2;
    if (!iterator1.hasNext()) {
      bool1 = bool2;
      if (!iterator2.hasNext())
        bool1 = true; 
    } 
    return bool1;
  }
  
  protected int doHash(Iterable<T> paramIterable) {
    Iterator<T> iterator = paramIterable.iterator();
    int i;
    for (i = 78721; iterator.hasNext(); i = i * 24943 + this.elementEquivalence.hash((T)paramIterable))
      paramIterable = (Iterable<T>)iterator.next(); 
    return i;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof PairwiseEquivalence) {
      paramObject = paramObject;
      return this.elementEquivalence.equals(((PairwiseEquivalence)paramObject).elementEquivalence);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.elementEquivalence.hashCode() ^ 0x46A3EB07;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.elementEquivalence);
    stringBuilder.append(".pairwise()");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\PairwiseEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */