package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nullable;

@Beta
public final class ElementOrder<T> {
  @Nullable
  private final Comparator<T> comparator;
  
  private final Type type;
  
  private ElementOrder(Type paramType, @Nullable Comparator<T> paramComparator) {
    boolean bool2;
    boolean bool3;
    this.type = (Type)Preconditions.checkNotNull(paramType);
    this.comparator = paramComparator;
    Type type = Type.SORTED;
    boolean bool1 = true;
    if (paramType == type) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramComparator != null) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool2 != bool3)
      bool1 = false; 
    Preconditions.checkState(bool1);
  }
  
  public static <S> ElementOrder<S> insertion() {
    return new ElementOrder<S>(Type.INSERTION, null);
  }
  
  public static <S extends Comparable<? super S>> ElementOrder<S> natural() {
    return new ElementOrder<S>(Type.SORTED, (Comparator<S>)Ordering.natural());
  }
  
  public static <S> ElementOrder<S> sorted(Comparator<S> paramComparator) {
    return new ElementOrder<S>(Type.SORTED, paramComparator);
  }
  
  public static <S> ElementOrder<S> unordered() {
    return new ElementOrder<S>(Type.UNORDERED, null);
  }
  
  <T1 extends T> ElementOrder<T1> cast() {
    return this;
  }
  
  public Comparator<T> comparator() {
    Comparator<T> comparator = this.comparator;
    if (comparator != null)
      return comparator; 
    throw new UnsupportedOperationException("This ordering does not define a comparator.");
  }
  
  <K extends T, V> Map<K, V> createMap(int paramInt) {
    switch (this.type) {
      default:
        throw new AssertionError();
      case SORTED:
        return Maps.newTreeMap(comparator());
      case INSERTION:
        return Maps.newLinkedHashMapWithExpectedSize(paramInt);
      case UNORDERED:
        break;
    } 
    return Maps.newHashMapWithExpectedSize(paramInt);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ElementOrder))
      return false; 
    paramObject = paramObject;
    if (this.type != ((ElementOrder)paramObject).type || !Objects.equal(this.comparator, ((ElementOrder)paramObject).comparator))
      bool = false; 
    return bool;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.type, this.comparator });
  }
  
  public String toString() {
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this).add("type", this.type);
    Comparator<T> comparator = this.comparator;
    if (comparator != null)
      toStringHelper.add("comparator", comparator); 
    return toStringHelper.toString();
  }
  
  public Type type() {
    return this.type;
  }
  
  public enum Type {
    INSERTION, SORTED, UNORDERED;
    
    static {
      $VALUES = new Type[] { UNORDERED, INSERTION, SORTED };
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\ElementOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */