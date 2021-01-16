package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean add(E paramE) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean addAll(Collection<? extends E> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> asList() {
    switch (size()) {
      default:
        return new RegularImmutableAsList<E>(this, toArray());
      case 1:
        return ImmutableList.of(iterator().next());
      case 0:
        break;
    } 
    return ImmutableList.of();
  }
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@Nullable Object paramObject);
  
  @CanIgnoreReturnValue
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    Iterator iterator = iterator();
    while (iterator.hasNext()) {
      paramArrayOfObject[paramInt] = iterator.next();
      paramInt++;
    } 
    return paramInt;
  }
  
  abstract boolean isPartialView();
  
  public abstract UnmodifiableIterator<E> iterator();
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean removeAll(Collection<?> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean retainAll(Collection<?> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray() {
    int i = size();
    if (i == 0)
      return ObjectArrays.EMPTY_ARRAY; 
    Object[] arrayOfObject = new Object[i];
    copyIntoArray(arrayOfObject, 0);
    return arrayOfObject;
  }
  
  @CanIgnoreReturnValue
  public final <T> T[] toArray(T[] paramArrayOfT) {
    T[] arrayOfT;
    Preconditions.checkNotNull(paramArrayOfT);
    int i = size();
    if (paramArrayOfT.length < i) {
      Object[] arrayOfObject = ObjectArrays.newArray((Object[])paramArrayOfT, i);
    } else {
      arrayOfT = paramArrayOfT;
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
        arrayOfT = paramArrayOfT;
      } 
    } 
    copyIntoArray((Object[])arrayOfT, 0);
    return arrayOfT;
  }
  
  Object writeReplace() {
    return new ImmutableList.SerializedForm(toArray());
  }
  
  static abstract class ArrayBasedBuilder<E> extends Builder<E> {
    Object[] contents;
    
    int size;
    
    ArrayBasedBuilder(int param1Int) {
      CollectPreconditions.checkNonnegative(param1Int, "initialCapacity");
      this.contents = new Object[param1Int];
      this.size = 0;
    }
    
    private void ensureCapacity(int param1Int) {
      Object[] arrayOfObject = this.contents;
      if (arrayOfObject.length < param1Int)
        this.contents = ObjectArrays.arraysCopyOf(arrayOfObject, expandedCapacity(arrayOfObject.length, param1Int)); 
    }
    
    @CanIgnoreReturnValue
    public ArrayBasedBuilder<E> add(E param1E) {
      Preconditions.checkNotNull(param1E);
      ensureCapacity(this.size + 1);
      Object[] arrayOfObject = this.contents;
      int i = this.size;
      this.size = i + 1;
      arrayOfObject[i] = param1E;
      return this;
    }
    
    @CanIgnoreReturnValue
    public ImmutableCollection.Builder<E> add(E... param1VarArgs) {
      ObjectArrays.checkElementsNotNull((Object[])param1VarArgs);
      ensureCapacity(this.size + param1VarArgs.length);
      System.arraycopy(param1VarArgs, 0, this.contents, this.size, param1VarArgs.length);
      this.size += param1VarArgs.length;
      return this;
    }
    
    @CanIgnoreReturnValue
    public ImmutableCollection.Builder<E> addAll(Iterable<? extends E> param1Iterable) {
      if (param1Iterable instanceof Collection) {
        Collection collection = (Collection)param1Iterable;
        ensureCapacity(this.size + collection.size());
      } 
      super.addAll(param1Iterable);
      return this;
    }
  }
  
  public static abstract class Builder<E> {
    static final int DEFAULT_INITIAL_CAPACITY = 4;
    
    static int expandedCapacity(int param1Int1, int param1Int2) {
      if (param1Int2 >= 0) {
        int i = param1Int1 + (param1Int1 >> 1) + 1;
        param1Int1 = i;
        if (i < param1Int2)
          param1Int1 = Integer.highestOneBit(param1Int2 - 1) << 1; 
        param1Int2 = param1Int1;
        if (param1Int1 < 0)
          param1Int2 = Integer.MAX_VALUE; 
        return param1Int2;
      } 
      throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
    
    @CanIgnoreReturnValue
    public abstract Builder<E> add(E param1E);
    
    @CanIgnoreReturnValue
    public Builder<E> add(E... param1VarArgs) {
      int i = param1VarArgs.length;
      for (byte b = 0; b < i; b++)
        add(param1VarArgs[b]); 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterable<? extends E> param1Iterable) {
      Iterator<? extends E> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        add(iterator.next()); 
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterator<? extends E> param1Iterator) {
      while (param1Iterator.hasNext())
        add(param1Iterator.next()); 
      return this;
    }
    
    public abstract ImmutableCollection<E> build();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */