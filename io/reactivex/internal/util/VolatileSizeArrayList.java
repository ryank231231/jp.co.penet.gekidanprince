package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
  private static final long serialVersionUID = 3972397474470203923L;
  
  final ArrayList<T> list = new ArrayList<T>();
  
  public VolatileSizeArrayList() {}
  
  public VolatileSizeArrayList(int paramInt) {}
  
  public void add(int paramInt, T paramT) {
    this.list.add(paramInt, paramT);
    lazySet(this.list.size());
  }
  
  public boolean add(T paramT) {
    boolean bool = this.list.add(paramT);
    lazySet(this.list.size());
    return bool;
  }
  
  public boolean addAll(int paramInt, Collection<? extends T> paramCollection) {
    boolean bool = this.list.addAll(paramInt, paramCollection);
    lazySet(this.list.size());
    return bool;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection) {
    boolean bool = this.list.addAll(paramCollection);
    lazySet(this.list.size());
    return bool;
  }
  
  public void clear() {
    this.list.clear();
    lazySet(0);
  }
  
  public boolean contains(Object paramObject) {
    return this.list.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection) {
    return this.list.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof VolatileSizeArrayList) ? this.list.equals(((VolatileSizeArrayList)paramObject).list) : this.list.equals(paramObject);
  }
  
  public T get(int paramInt) {
    return this.list.get(paramInt);
  }
  
  public int hashCode() {
    return this.list.hashCode();
  }
  
  public int indexOf(Object paramObject) {
    return this.list.indexOf(paramObject);
  }
  
  public boolean isEmpty() {
    boolean bool;
    if (get() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Iterator<T> iterator() {
    return this.list.iterator();
  }
  
  public int lastIndexOf(Object paramObject) {
    return this.list.lastIndexOf(paramObject);
  }
  
  public ListIterator<T> listIterator() {
    return this.list.listIterator();
  }
  
  public ListIterator<T> listIterator(int paramInt) {
    return this.list.listIterator(paramInt);
  }
  
  public T remove(int paramInt) {
    T t = this.list.remove(paramInt);
    lazySet(this.list.size());
    return t;
  }
  
  public boolean remove(Object paramObject) {
    boolean bool = this.list.remove(paramObject);
    lazySet(this.list.size());
    return bool;
  }
  
  public boolean removeAll(Collection<?> paramCollection) {
    boolean bool = this.list.removeAll(paramCollection);
    lazySet(this.list.size());
    return bool;
  }
  
  public boolean retainAll(Collection<?> paramCollection) {
    boolean bool = this.list.retainAll(paramCollection);
    lazySet(this.list.size());
    return bool;
  }
  
  public T set(int paramInt, T paramT) {
    return this.list.set(paramInt, paramT);
  }
  
  public int size() {
    return get();
  }
  
  public List<T> subList(int paramInt1, int paramInt2) {
    return this.list.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray() {
    return this.list.toArray();
  }
  
  public <E> E[] toArray(E[] paramArrayOfE) {
    return this.list.toArray(paramArrayOfE);
  }
  
  public String toString() {
    return this.list.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\VolatileSizeArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */