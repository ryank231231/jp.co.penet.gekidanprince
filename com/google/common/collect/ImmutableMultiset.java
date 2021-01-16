package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E> {
  @LazyInit
  private transient ImmutableList<E> asList;
  
  @LazyInit
  private transient ImmutableSet<Multiset.Entry<E>> entrySet;
  
  public static <E> Builder<E> builder() {
    return new Builder<E>();
  }
  
  private static <E> ImmutableMultiset<E> copyFromElements(E... paramVarArgs) {
    LinkedHashMultiset<?> linkedHashMultiset = LinkedHashMultiset.create();
    Collections.addAll(linkedHashMultiset, (Object[])paramVarArgs);
    return copyFromEntries((Collection)linkedHashMultiset.entrySet());
  }
  
  static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> paramCollection) {
    return paramCollection.isEmpty() ? of() : new RegularImmutableMultiset<E>(paramCollection);
  }
  
  public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof ImmutableMultiset) {
      ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset)paramIterable;
      if (!immutableMultiset.isPartialView())
        return immutableMultiset; 
    } 
    if (paramIterable instanceof Multiset) {
      paramIterable = Multisets.cast(paramIterable);
    } else {
      paramIterable = LinkedHashMultiset.create(paramIterable);
    } 
    return copyFromEntries(paramIterable.entrySet());
  }
  
  public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> paramIterator) {
    LinkedHashMultiset<?> linkedHashMultiset = LinkedHashMultiset.create();
    Iterators.addAll(linkedHashMultiset, paramIterator);
    return copyFromEntries((Collection)linkedHashMultiset.entrySet());
  }
  
  public static <E> ImmutableMultiset<E> copyOf(E[] paramArrayOfE) {
    return copyFromElements(paramArrayOfE);
  }
  
  private final ImmutableSet<Multiset.Entry<E>> createEntrySet() {
    ImmutableSet<?> immutableSet;
    if (isEmpty()) {
      immutableSet = ImmutableSet.of();
    } else {
      immutableSet = new EntrySet();
    } 
    return (ImmutableSet)immutableSet;
  }
  
  public static <E> ImmutableMultiset<E> of() {
    return RegularImmutableMultiset.EMPTY;
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE) {
    return copyFromElements((E[])new Object[] { paramE });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2) {
    return copyFromElements((E[])new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3) {
    return copyFromElements((E[])new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4) {
    return copyFromElements((E[])new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
    return copyFromElements((E[])new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
    return (new Builder<E>()).add(paramE1).add(paramE2).add(paramE3).add(paramE4).add(paramE5).add(paramE6).add(paramVarArgs).build();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final int add(E paramE, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList() {
    ImmutableList<E> immutableList1 = this.asList;
    ImmutableList<E> immutableList2 = immutableList1;
    if (immutableList1 == null) {
      immutableList2 = createAsList();
      this.asList = immutableList2;
    } 
    return immutableList2;
  }
  
  public boolean contains(@Nullable Object paramObject) {
    boolean bool;
    if (count(paramObject) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @GwtIncompatible
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    for (Multiset.Entry<E> entry : entrySet()) {
      Arrays.fill(paramArrayOfObject, paramInt, entry.getCount() + paramInt, entry.getElement());
      paramInt += entry.getCount();
    } 
    return paramInt;
  }
  
  ImmutableList<E> createAsList() {
    return isEmpty() ? ImmutableList.of() : new RegularImmutableAsList<E>(this, toArray());
  }
  
  public ImmutableSet<Multiset.Entry<E>> entrySet() {
    ImmutableSet<Multiset.Entry<E>> immutableSet1 = this.entrySet;
    ImmutableSet<Multiset.Entry<E>> immutableSet2 = immutableSet1;
    if (immutableSet1 == null) {
      immutableSet2 = createEntrySet();
      this.entrySet = immutableSet2;
    } 
    return immutableSet2;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return Multisets.equalsImpl(this, paramObject);
  }
  
  abstract Multiset.Entry<E> getEntry(int paramInt);
  
  public int hashCode() {
    return Sets.hashCodeImpl(entrySet());
  }
  
  public UnmodifiableIterator<E> iterator() {
    return new UnmodifiableIterator<E>() {
        E element;
        
        int remaining;
        
        public boolean hasNext() {
          return (this.remaining > 0 || entryIterator.hasNext());
        }
        
        public E next() {
          if (this.remaining <= 0) {
            Multiset.Entry<E> entry = entryIterator.next();
            this.element = entry.getElement();
            this.remaining = entry.getCount();
          } 
          this.remaining--;
          return this.element;
        }
      };
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final int remove(Object paramObject, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final int setCount(E paramE, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean setCount(E paramE, int paramInt1, int paramInt2) {
    throw new UnsupportedOperationException();
  }
  
  public String toString() {
    return entrySet().toString();
  }
  
  Object writeReplace() {
    return new SerializedForm(this);
  }
  
  public static class Builder<E> extends ImmutableCollection.Builder<E> {
    final Multiset<E> contents;
    
    public Builder() {
      this(LinkedHashMultiset.create());
    }
    
    Builder(Multiset<E> param1Multiset) {
      this.contents = param1Multiset;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E param1E) {
      this.contents.add((E)Preconditions.checkNotNull(param1E));
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E... param1VarArgs) {
      super.add(param1VarArgs);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterable<? extends E> param1Iterable) {
      if (param1Iterable instanceof Multiset) {
        for (Multiset.Entry<E> entry : (Iterable<Multiset.Entry<E>>)Multisets.<E>cast(param1Iterable).entrySet())
          addCopies(entry.getElement(), entry.getCount()); 
      } else {
        super.addAll(param1Iterable);
      } 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterator<? extends E> param1Iterator) {
      super.addAll(param1Iterator);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addCopies(E param1E, int param1Int) {
      this.contents.add((E)Preconditions.checkNotNull(param1E), param1Int);
      return this;
    }
    
    public ImmutableMultiset<E> build() {
      return ImmutableMultiset.copyOf(this.contents);
    }
    
    @CanIgnoreReturnValue
    public Builder<E> setCount(E param1E, int param1Int) {
      this.contents.setCount((E)Preconditions.checkNotNull(param1E), param1Int);
      return this;
    }
  }
  
  private final class EntrySet extends ImmutableSet.Indexed<Multiset.Entry<E>> {
    private static final long serialVersionUID = 0L;
    
    private EntrySet() {}
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        if (param1Object.getCount() <= 0)
          return false; 
        if (ImmutableMultiset.this.count(param1Object.getElement()) == param1Object.getCount())
          bool1 = true; 
        return bool1;
      } 
      return false;
    }
    
    Multiset.Entry<E> get(int param1Int) {
      return ImmutableMultiset.this.getEntry(param1Int);
    }
    
    public int hashCode() {
      return ImmutableMultiset.this.hashCode();
    }
    
    boolean isPartialView() {
      return ImmutableMultiset.this.isPartialView();
    }
    
    public int size() {
      return ImmutableMultiset.this.elementSet().size();
    }
    
    Object writeReplace() {
      return new ImmutableMultiset.EntrySetSerializedForm(ImmutableMultiset.this);
    }
  }
  
  static class EntrySetSerializedForm<E> implements Serializable {
    final ImmutableMultiset<E> multiset;
    
    EntrySetSerializedForm(ImmutableMultiset<E> param1ImmutableMultiset) {
      this.multiset = param1ImmutableMultiset;
    }
    
    Object readResolve() {
      return this.multiset.entrySet();
    }
  }
  
  private static class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final int[] counts;
    
    final Object[] elements;
    
    SerializedForm(Multiset<?> param1Multiset) {
      int i = param1Multiset.entrySet().size();
      this.elements = new Object[i];
      this.counts = new int[i];
      Iterator<Multiset.Entry> iterator = param1Multiset.entrySet().iterator();
      for (i = 0; iterator.hasNext(); i++) {
        Multiset.Entry entry = iterator.next();
        this.elements[i] = entry.getElement();
        this.counts[i] = entry.getCount();
      } 
    }
    
    Object readResolve() {
      LinkedHashMultiset<?> linkedHashMultiset = LinkedHashMultiset.create(this.elements.length);
      byte b = 0;
      while (true) {
        Object[] arrayOfObject = this.elements;
        if (b < arrayOfObject.length) {
          linkedHashMultiset.add(arrayOfObject[b], this.counts[b]);
          b++;
          continue;
        } 
        return ImmutableMultiset.copyOf(linkedHashMultiset);
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */