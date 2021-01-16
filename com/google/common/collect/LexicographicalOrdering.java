package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final Comparator<? super T> elementOrder;
  
  LexicographicalOrdering(Comparator<? super T> paramComparator) {
    this.elementOrder = paramComparator;
  }
  
  public int compare(Iterable<T> paramIterable1, Iterable<T> paramIterable2) {
    Iterator<T> iterator1 = paramIterable1.iterator();
    Iterator<T> iterator2 = paramIterable2.iterator();
    while (iterator1.hasNext()) {
      if (!iterator2.hasNext())
        return 1; 
      int i = this.elementOrder.compare(iterator1.next(), iterator2.next());
      if (i != 0)
        return i; 
    } 
    return iterator2.hasNext() ? -1 : 0;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof LexicographicalOrdering) {
      paramObject = paramObject;
      return this.elementOrder.equals(((LexicographicalOrdering)paramObject).elementOrder);
    } 
    return false;
  }
  
  public int hashCode() {
    return this.elementOrder.hashCode() ^ 0x7BB78CF5;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.elementOrder);
    stringBuilder.append(".lexicographical()");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\LexicographicalOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */