package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
  private static final int CUTOFF = 751619276;
  
  private static final double DESIRED_LOAD_FACTOR = 0.7D;
  
  static final int MAX_TABLE_SIZE = 1073741824;
  
  @LazyInit
  private transient ImmutableList<E> asList;
  
  public static <E> Builder<E> builder() {
    return new Builder<E>();
  }
  
  @VisibleForTesting
  static int chooseTableSize(int paramInt) {
    boolean bool = true;
    if (paramInt < 751619276) {
      int i = Integer.highestOneBit(paramInt - 1) << 1;
      while (true) {
        double d = i;
        Double.isNaN(d);
        if (d * 0.7D < paramInt) {
          i <<= 1;
          continue;
        } 
        return i;
      } 
    } 
    if (paramInt >= 1073741824)
      bool = false; 
    Preconditions.checkArgument(bool, "collection too large");
    return 1073741824;
  }
  
  private static <E> ImmutableSet<E> construct(int paramInt, Object... paramVarArgs) {
    int i;
    Object[] arrayOfObject1;
    int j;
    byte b1;
    byte b2;
    int k;
    switch (paramInt) {
      default:
        i = chooseTableSize(paramInt);
        arrayOfObject1 = new Object[i];
        j = i - 1;
        b1 = 0;
        b2 = 0;
        k = 0;
        break;
      case 1:
        return of((E)paramVarArgs[0]);
      case 0:
        return of();
    } 
    label28: while (b1 < paramInt) {
      Object object = ObjectArrays.checkElementNotNull(paramVarArgs[b1], b1);
      int m = object.hashCode();
      int n = Hashing.smear(m);
      while (true) {
        int i1 = n & j;
        Object object1 = arrayOfObject1[i1];
        if (object1 == null) {
          paramVarArgs[b2] = object;
          arrayOfObject1[i1] = object;
          k += m;
          b2++;
        } else if (!object1.equals(object)) {
          n++;
          continue;
        } 
        b1++;
        continue label28;
      } 
    } 
    Arrays.fill(paramVarArgs, b2, paramInt, (Object)null);
    if (b2 == 1)
      return new SingletonImmutableSet<E>((E)paramVarArgs[0], k); 
    if (i != chooseTableSize(b2))
      return construct(b2, paramVarArgs); 
    Object[] arrayOfObject2 = paramVarArgs;
    if (b2 < paramVarArgs.length)
      arrayOfObject2 = ObjectArrays.arraysCopyOf(paramVarArgs, b2); 
    return new RegularImmutableSet<E>(arrayOfObject2, k, arrayOfObject1, j);
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection) {
      paramIterable = copyOf((Collection<? extends E>)paramIterable);
    } else {
      paramIterable = copyOf(paramIterable.iterator());
    } 
    return (ImmutableSet)paramIterable;
  }
  
  public static <E> ImmutableSet<E> copyOf(Collection<? extends E> paramCollection) {
    if (paramCollection instanceof ImmutableSet && !(paramCollection instanceof ImmutableSortedSet)) {
      ImmutableSet<E> immutableSet = (ImmutableSet)paramCollection;
      if (!immutableSet.isPartialView())
        return immutableSet; 
    } else if (paramCollection instanceof EnumSet) {
      return copyOfEnumSet((EnumSet)paramCollection);
    } 
    Object[] arrayOfObject = paramCollection.toArray();
    return construct(arrayOfObject.length, arrayOfObject);
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> paramIterator) {
    if (!paramIterator.hasNext())
      return of(); 
    E e = paramIterator.next();
    return !paramIterator.hasNext() ? of(e) : (new Builder<E>()).add(e).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableSet<E> copyOf(E[] paramArrayOfE) {
    switch (paramArrayOfE.length) {
      default:
        return construct(paramArrayOfE.length, (Object[])paramArrayOfE.clone());
      case 1:
        return of(paramArrayOfE[0]);
      case 0:
        break;
    } 
    return of();
  }
  
  private static ImmutableSet copyOfEnumSet(EnumSet<Enum> paramEnumSet) {
    return ImmutableEnumSet.asImmutable(EnumSet.copyOf(paramEnumSet));
  }
  
  public static <E> ImmutableSet<E> of() {
    return RegularImmutableSet.EMPTY;
  }
  
  public static <E> ImmutableSet<E> of(E paramE) {
    return new SingletonImmutableSet<E>(paramE);
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2) {
    return construct(2, new Object[] { paramE1, paramE2 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3) {
    return construct(3, new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4) {
    return construct(4, new Object[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5) {
    return construct(5, new Object[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  @SafeVarargs
  public static <E> ImmutableSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs) {
    Object[] arrayOfObject = new Object[paramVarArgs.length + 6];
    arrayOfObject[0] = paramE1;
    arrayOfObject[1] = paramE2;
    arrayOfObject[2] = paramE3;
    arrayOfObject[3] = paramE4;
    arrayOfObject[4] = paramE5;
    arrayOfObject[5] = paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfObject, 6, paramVarArgs.length);
    return construct(arrayOfObject.length, arrayOfObject);
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
  
  ImmutableList<E> createAsList() {
    return new RegularImmutableAsList<E>(this, toArray());
  }
  
  public boolean equals(@Nullable Object paramObject) {
    return (paramObject == this) ? true : ((paramObject instanceof ImmutableSet && isHashCodeFast() && ((ImmutableSet)paramObject).isHashCodeFast() && hashCode() != paramObject.hashCode()) ? false : Sets.equalsImpl(this, paramObject));
  }
  
  public int hashCode() {
    return Sets.hashCodeImpl(this);
  }
  
  boolean isHashCodeFast() {
    return false;
  }
  
  public abstract UnmodifiableIterator<E> iterator();
  
  Object writeReplace() {
    return new SerializedForm(toArray());
  }
  
  public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
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
    
    public ImmutableSet<E> build() {
      ImmutableSet<E> immutableSet = ImmutableSet.construct(this.size, this.contents);
      this.size = immutableSet.size();
      return immutableSet;
    }
  }
  
  static abstract class Indexed<E> extends ImmutableSet<E> {
    ImmutableList<E> createAsList() {
      return new ImmutableAsList<E>() {
          ImmutableSet.Indexed<E> delegateCollection() {
            return ImmutableSet.Indexed.this;
          }
          
          public E get(int param2Int) {
            return ImmutableSet.Indexed.this.get(param2Int);
          }
        };
    }
    
    abstract E get(int param1Int);
    
    public UnmodifiableIterator<E> iterator() {
      return asList().iterator();
    }
  }
  
  class null extends ImmutableAsList<E> {
    ImmutableSet.Indexed<E> delegateCollection() {
      return this.this$0;
    }
    
    public E get(int param1Int) {
      return this.this$0.get(param1Int);
    }
  }
  
  private static class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Object[] elements;
    
    SerializedForm(Object[] param1ArrayOfObject) {
      this.elements = param1ArrayOfObject;
    }
    
    Object readResolve() {
      return ImmutableSet.copyOf(this.elements);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */