package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

final class EdgesConnecting<E> extends AbstractSet<E> {
  private final Map<?, E> nodeToOutEdge;
  
  private final Object targetNode;
  
  EdgesConnecting(Map<?, E> paramMap, Object paramObject) {
    this.nodeToOutEdge = (Map<?, E>)Preconditions.checkNotNull(paramMap);
    this.targetNode = Preconditions.checkNotNull(paramObject);
  }
  
  @Nullable
  private E getConnectingEdge() {
    return this.nodeToOutEdge.get(this.targetNode);
  }
  
  public boolean contains(@Nullable Object paramObject) {
    boolean bool;
    E e = getConnectingEdge();
    if (e != null && e.equals(paramObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public UnmodifiableIterator<E> iterator() {
    UnmodifiableIterator<E> unmodifiableIterator;
    E e = getConnectingEdge();
    if (e == null) {
      unmodifiableIterator = ImmutableSet.of().iterator();
    } else {
      unmodifiableIterator = Iterators.singletonIterator(unmodifiableIterator);
    } 
    return unmodifiableIterator;
  }
  
  public int size() {
    boolean bool;
    if (getConnectingEdge() == null) {
      bool = false;
    } else {
      bool = true;
    } 
    return bool;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\EdgesConnecting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */