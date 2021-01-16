package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
  private final transient ImmutableList<List<E>> axes;
  
  private final transient int[] axesSizeProduct;
  
  CartesianList(ImmutableList<List<E>> paramImmutableList) {
    this.axes = paramImmutableList;
    int[] arrayOfInt = new int[paramImmutableList.size() + 1];
    arrayOfInt[paramImmutableList.size()] = 1;
    try {
      for (int i = paramImmutableList.size() - 1; i >= 0; i--)
        arrayOfInt[i] = IntMath.checkedMultiply(arrayOfInt[i + 1], ((List)paramImmutableList.get(i)).size()); 
      this.axesSizeProduct = arrayOfInt;
      return;
    } catch (ArithmeticException arithmeticException) {
      throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
    } 
  }
  
  static <E> List<List<E>> create(List<? extends List<? extends E>> paramList) {
    ImmutableList.Builder<ImmutableList<?>> builder = new ImmutableList.Builder(paramList.size());
    Iterator<? extends List<? extends E>> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      ImmutableList<?> immutableList = ImmutableList.copyOf(iterator.next());
      if (immutableList.isEmpty())
        return ImmutableList.of(); 
      builder.add(immutableList);
    } 
    return new CartesianList<E>((ImmutableList)builder.build());
  }
  
  private int getAxisIndexForProductIndex(int paramInt1, int paramInt2) {
    return paramInt1 / this.axesSizeProduct[paramInt2 + 1] % ((List)this.axes.get(paramInt2)).size();
  }
  
  public boolean contains(@Nullable Object paramObject) {
    if (!(paramObject instanceof List))
      return false; 
    paramObject = paramObject;
    if (paramObject.size() != this.axes.size())
      return false; 
    paramObject = paramObject.listIterator();
    while (paramObject.hasNext()) {
      int i = paramObject.nextIndex();
      if (!((List)this.axes.get(i)).contains(paramObject.next()))
        return false; 
    } 
    return true;
  }
  
  public ImmutableList<E> get(final int index) {
    Preconditions.checkElementIndex(index, size());
    return new ImmutableList<E>() {
        public E get(int param1Int) {
          Preconditions.checkElementIndex(param1Int, size());
          int i = CartesianList.this.getAxisIndexForProductIndex(index, param1Int);
          return ((List<E>)CartesianList.this.axes.get(param1Int)).get(i);
        }
        
        boolean isPartialView() {
          return true;
        }
        
        public int size() {
          return CartesianList.this.axes.size();
        }
      };
  }
  
  public int size() {
    return this.axesSizeProduct[0];
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\CartesianList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */