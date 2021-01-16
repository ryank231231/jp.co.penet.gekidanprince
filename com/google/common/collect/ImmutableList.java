package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
  static <E> ImmutableList<E> asImmutableList(Object[] paramArrayOfObject) {
    return asImmutableList(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  static <E> ImmutableList<E> asImmutableList(Object[] paramArrayOfObject, int paramInt) {
    Object[] arrayOfObject;
    switch (paramInt) {
      default:
        arrayOfObject = paramArrayOfObject;
        if (paramInt < paramArrayOfObject.length)
          arrayOfObject = ObjectArrays.arraysCopyOf(paramArrayOfObject, paramInt); 
        return new RegularImmutableList<E>(arrayOfObject);
      case 1:
        return new SingletonImmutableList<E>((E)paramArrayOfObject[0]);
      case 0:
        break;
    } 
    return of();
  }
  
  public static <E> Builder<E> builder() {
    return new Builder<E>();
  }
  
  private static <E> ImmutableList<E> construct(Object... paramVarArgs) {
    return asImmutableList(ObjectArrays.checkElementsNotNull(paramVarArgs));
  }
  
  public static <E> ImmutableList<E> copyOf(Iterable<? extends E> paramIterable) {
    Preconditions.checkNotNull(paramIterable);
    if (paramIterable instanceof Collection) {
      paramIterable = copyOf((Collection<? extends E>)paramIterable);
    } else {
      paramIterable = copyOf(paramIterable.iterator());
    } 
    return (ImmutableList)paramIterable;
  }
  
  public static <E> ImmutableList<E> copyOf(Collection<? extends E> paramCollection) {
    if (paramCollection instanceof ImmutableCollection) {
      ImmutableList<? extends E> immutableList = ((ImmutableCollection)paramCollection).asList();
      paramCollection = immutableList;
      if (immutableList.isPartialView())
        paramCollection = asImmutableList(immutableList.toArray()); 
      return (ImmutableList)paramCollection;
    } 
    return construct(paramCollection.toArray());
  }
  
  public static <E> ImmutableList<E> copyOf(Iterator<? extends E> paramIterator) {
    if (!paramIterator.hasNext())
      return of(); 
    E e = paramIterator.next();
    return !paramIterator.hasNext() ? of(e) : (new Builder<E>()).add(e).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableList<E> copyOf(E[] paramArrayOfE) {
    switch (paramArrayOfE.length) {
      default:
        return new RegularImmutableList<E>(ObjectArrays.checkElementsNotNull((Object[])paramArrayOfE.clone()));
      case 1:
        return new SingletonImmutableList<E>(paramArrayOfE[0]);
      case 0:
        break;
    } 
    return of();
  }
  
  public static <E> ImmutableList<E> of() {
    return (ImmutableList)RegularImmutableList.EMPTY;
  }
  
  public static <E> ImmutableList<E> of(E paramE) {
    return new SingletonImmutableList<E>(paramE);
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2) {
    return construct(new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3) {
    return construct(new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10) {
    return construct(new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10 });
  }
  
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11) {
    return construct(new Object[] { 
          paramE1, paramE2, paramE3, paramE4, paramE5, paramE6, paramE7, paramE8, paramE9, paramE10, 
          paramE11 });
  }
  
  @SafeVarargs
  public static <E> ImmutableList<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E paramE7, E paramE8, E paramE9, E paramE10, E paramE11, E paramE12, E... paramVarArgs) {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 12];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    arrayOfObject[6] = paramE7;
    arrayOfObject[7] = paramE8;
    arrayOfObject[8] = paramE9;
    arrayOfObject[9] = paramE10;
    arrayOfObject[10] = paramE11;
    arrayOfObject[11] = paramE12;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 12, paramVarArgs.length);
    return construct(arrayOfObject);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream) throws InvalidObjectException {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final ImmutableList<E> asList() {
    return this;
  }
  
  public boolean contains(@Nullable Object paramObject) {
    boolean bool;
    if (indexOf(paramObject) >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt) {
    int i = size();
    for (byte b = 0; b < i; b++)
      paramArrayOfObject[paramInt + b] = get(b); 
    return paramInt + i;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return Lists.equalsImpl(this, paramObject);
  }
  
  public int hashCode() {
    int i = size();
    int j = 1;
    for (byte b = 0; b < i; b++)
      j = j * 31 + get(b).hashCode() ^ 0xFFFFFFFF ^ 0xFFFFFFFF; 
    return j;
  }
  
  public int indexOf(@Nullable Object paramObject) {
    int i;
    if (paramObject == null) {
      i = -1;
    } else {
      i = Lists.indexOfImpl(this, paramObject);
    } 
    return i;
  }
  
  public UnmodifiableIterator<E> iterator() {
    return listIterator();
  }
  
  public int lastIndexOf(@Nullable Object paramObject) {
    int i;
    if (paramObject == null) {
      i = -1;
    } else {
      i = Lists.lastIndexOfImpl(this, paramObject);
    } 
    return i;
  }
  
  public UnmodifiableListIterator<E> listIterator() {
    return listIterator(0);
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt) {
    return new AbstractIndexedListIterator<E>(size(), paramInt) {
        protected E get(int param1Int) {
          return ImmutableList.this.get(param1Int);
        }
      };
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final E remove(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> reverse() {
    ImmutableList<E> immutableList;
    if (size() <= 1) {
      immutableList = this;
    } else {
      immutableList = new ReverseImmutableList(this);
    } 
    return immutableList;
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public final E set(int paramInt, E paramE) {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableList<E> subList(int paramInt1, int paramInt2) {
    Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
    int i = paramInt2 - paramInt1;
    if (i == size())
      return this; 
    switch (i) {
      default:
        return subListUnchecked(paramInt1, paramInt2);
      case 1:
        return of(get(paramInt1));
      case 0:
        break;
    } 
    return of();
  }
  
  ImmutableList<E> subListUnchecked(int paramInt1, int paramInt2) {
    return new SubList(paramInt1, paramInt2 - paramInt1);
  }
  
  Object writeReplace() {
    return new SerializedForm(toArray());
  }
  
  public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
    public Builder() {
      this(4);
    }
    
    Builder(int param1Int) {
      super(param1Int);
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E param1E) {
      super.add(param1E);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E... param1VarArgs) {
      super.add(param1VarArgs);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterable<? extends E> param1Iterable) {
      super.addAll(param1Iterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterator<? extends E> param1Iterator) {
      super.addAll(param1Iterator);
      return this;
    }
    
    public ImmutableList<E> build() {
      return ImmutableList.asImmutableList(this.contents, this.size);
    }
  }
  
  private static class ReverseImmutableList<E> extends ImmutableList<E> {
    private final transient ImmutableList<E> forwardList;
    
    ReverseImmutableList(ImmutableList<E> param1ImmutableList) {
      this.forwardList = param1ImmutableList;
    }
    
    private int reverseIndex(int param1Int) {
      return size() - 1 - param1Int;
    }
    
    private int reversePosition(int param1Int) {
      return size() - param1Int;
    }
    
    public boolean contains(@Nullable Object param1Object) {
      return this.forwardList.contains(param1Object);
    }
    
    public E get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, size());
      return this.forwardList.get(reverseIndex(param1Int));
    }
    
    public int indexOf(@Nullable Object param1Object) {
      int i = this.forwardList.lastIndexOf(param1Object);
      if (i >= 0) {
        i = reverseIndex(i);
      } else {
        i = -1;
      } 
      return i;
    }
    
    boolean isPartialView() {
      return this.forwardList.isPartialView();
    }
    
    public int lastIndexOf(@Nullable Object param1Object) {
      int i = this.forwardList.indexOf(param1Object);
      if (i >= 0) {
        i = reverseIndex(i);
      } else {
        i = -1;
      } 
      return i;
    }
    
    public ImmutableList<E> reverse() {
      return this.forwardList;
    }
    
    public int size() {
      return this.forwardList.size();
    }
    
    public ImmutableList<E> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, size());
      return this.forwardList.subList(reversePosition(param1Int2), reversePosition(param1Int1)).reverse();
    }
  }
  
  static class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Object[] elements;
    
    SerializedForm(Object[] param1ArrayOfObject) {
      this.elements = param1ArrayOfObject;
    }
    
    Object readResolve() {
      return ImmutableList.copyOf(this.elements);
    }
  }
  
  class SubList extends ImmutableList<E> {
    final transient int length;
    
    final transient int offset;
    
    SubList(int param1Int1, int param1Int2) {
      this.offset = param1Int1;
      this.length = param1Int2;
    }
    
    public E get(int param1Int) {
      Preconditions.checkElementIndex(param1Int, this.length);
      return ImmutableList.this.get(param1Int + this.offset);
    }
    
    boolean isPartialView() {
      return true;
    }
    
    public int size() {
      return this.length;
    }
    
    public ImmutableList<E> subList(int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, this.length);
      ImmutableList<E> immutableList = ImmutableList.this;
      int i = this.offset;
      return immutableList.subList(param1Int1 + i, param1Int2 + i);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */