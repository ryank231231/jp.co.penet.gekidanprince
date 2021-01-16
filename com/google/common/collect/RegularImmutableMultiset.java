package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
  static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset(ImmutableList.of());
  
  @LazyInit
  private transient ImmutableSet<E> elementSet;
  
  private final transient Multisets.ImmutableEntry<E>[] entries;
  
  private final transient int hashCode;
  
  private final transient Multisets.ImmutableEntry<E>[] hashTable;
  
  private final transient int size;
  
  RegularImmutableMultiset(Collection<? extends Multiset.Entry<? extends E>> paramCollection) {
    int i = paramCollection.size();
    Multisets.ImmutableEntry[] arrayOfImmutableEntry = new Multisets.ImmutableEntry[i];
    if (i == 0) {
      this.entries = (Multisets.ImmutableEntry<E>[])arrayOfImmutableEntry;
      this.hashTable = null;
      this.size = 0;
      this.hashCode = 0;
      this.elementSet = ImmutableSet.of();
    } else {
      int j = Hashing.closedTableSize(i, 1.0D);
      Multisets.ImmutableEntry[] arrayOfImmutableEntry1 = new Multisets.ImmutableEntry[j];
      long l = 0L;
      Iterator<? extends Multiset.Entry<? extends E>> iterator = paramCollection.iterator();
      int k = 0;
      for (i = 0; iterator.hasNext(); i++) {
        Multiset.Entry entry = iterator.next();
        Object object = Preconditions.checkNotNull(entry.getElement());
        int m = entry.getCount();
        int n = object.hashCode();
        int i1 = Hashing.smear(n) & j - 1;
        Multisets.ImmutableEntry immutableEntry = arrayOfImmutableEntry1[i1];
        if (immutableEntry == null) {
          boolean bool;
          if (entry instanceof Multisets.ImmutableEntry && !(entry instanceof NonTerminalEntry)) {
            bool = true;
          } else {
            bool = false;
          } 
          if (bool) {
            entry = entry;
          } else {
            entry = new Multisets.ImmutableEntry(object, m);
          } 
        } else {
          entry = new NonTerminalEntry(object, m, immutableEntry);
        } 
        k += n ^ m;
        arrayOfImmutableEntry[i] = (Multisets.ImmutableEntry)entry;
        arrayOfImmutableEntry1[i1] = (Multisets.ImmutableEntry)entry;
        l += m;
      } 
      this.entries = (Multisets.ImmutableEntry<E>[])arrayOfImmutableEntry;
      this.hashTable = (Multisets.ImmutableEntry<E>[])arrayOfImmutableEntry1;
      this.size = Ints.saturatedCast(l);
      this.hashCode = k;
    } 
  }
  
  public int count(@Nullable Object paramObject) {
    Multisets.ImmutableEntry<E>[] arrayOfImmutableEntry = this.hashTable;
    if (paramObject == null || arrayOfImmutableEntry == null)
      return 0; 
    for (Multisets.ImmutableEntry<E> immutableEntry = arrayOfImmutableEntry[Hashing.smearedHash(paramObject) & arrayOfImmutableEntry.length - 1]; immutableEntry != null; immutableEntry = immutableEntry.nextInBucket()) {
      if (Objects.equal(paramObject, immutableEntry.getElement()))
        return immutableEntry.getCount(); 
    } 
    return 0;
  }
  
  public ImmutableSet<E> elementSet() {
    ImmutableSet<E> immutableSet1 = this.elementSet;
    ImmutableSet<E> immutableSet2 = immutableSet1;
    if (immutableSet1 == null) {
      immutableSet2 = new ElementSet();
      this.elementSet = immutableSet2;
    } 
    return immutableSet2;
  }
  
  Multiset.Entry<E> getEntry(int paramInt) {
    return this.entries[paramInt];
  }
  
  public int hashCode() {
    return this.hashCode;
  }
  
  boolean isPartialView() {
    return false;
  }
  
  public int size() {
    return this.size;
  }
  
  private final class ElementSet extends ImmutableSet.Indexed<E> {
    private ElementSet() {}
    
    public boolean contains(@Nullable Object param1Object) {
      return RegularImmutableMultiset.this.contains(param1Object);
    }
    
    E get(int param1Int) {
      return RegularImmutableMultiset.this.entries[param1Int].getElement();
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return RegularImmutableMultiset.this.entries.length;
    }
  }
  
  private static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
    private final Multisets.ImmutableEntry<E> nextInBucket;
    
    NonTerminalEntry(E param1E, int param1Int, Multisets.ImmutableEntry<E> param1ImmutableEntry) {
      super(param1E, param1Int);
      this.nextInBucket = param1ImmutableEntry;
    }
    
    public Multisets.ImmutableEntry<E> nextInBucket() {
      return this.nextInBucket;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\RegularImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */