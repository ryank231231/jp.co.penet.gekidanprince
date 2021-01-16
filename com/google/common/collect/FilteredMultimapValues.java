package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredMultimapValues<K, V> extends AbstractCollection<V> {
  @Weak
  private final FilteredMultimap<K, V> multimap;
  
  FilteredMultimapValues(FilteredMultimap<K, V> paramFilteredMultimap) {
    this.multimap = (FilteredMultimap<K, V>)Preconditions.checkNotNull(paramFilteredMultimap);
  }
  
  public void clear() {
    this.multimap.clear();
  }
  
  public boolean contains(@Nullable Object paramObject) {
    return this.multimap.containsValue(paramObject);
  }
  
  public Iterator<V> iterator() {
    return Maps.valueIterator(this.multimap.entries().iterator());
  }
  
  public boolean remove(@Nullable Object paramObject) {
    Predicate<? super Map.Entry<K, V>> predicate = this.multimap.entryPredicate();
    Iterator<Map.Entry> iterator = this.multimap.unfiltered().entries().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (predicate.apply(entry) && Objects.equal(entry.getValue(), paramObject)) {
        iterator.remove();
        return true;
      } 
    } 
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.in(paramCollection))));
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    return Iterables.removeIf(this.multimap.unfiltered().entries(), Predicates.and(this.multimap.entryPredicate(), Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(paramCollection)))));
  }
  
  public int size() {
    return this.multimap.size();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\FilteredMultimapValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */