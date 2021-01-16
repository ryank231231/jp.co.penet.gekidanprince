package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
  protected final Map<E, N> inEdgeMap;
  
  protected final Map<E, N> outEdgeMap;
  
  private int selfLoopCount;
  
  protected AbstractDirectedNetworkConnections(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
    boolean bool;
    this.inEdgeMap = (Map<E, N>)Preconditions.checkNotNull(paramMap1);
    this.outEdgeMap = (Map<E, N>)Preconditions.checkNotNull(paramMap2);
    this.selfLoopCount = Graphs.checkNonNegative(paramInt);
    if (paramInt <= paramMap1.size() && paramInt <= paramMap2.size()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean) {
    boolean bool = true;
    if (paramBoolean) {
      int i = this.selfLoopCount + 1;
      this.selfLoopCount = i;
      Graphs.checkPositive(i);
    } 
    if (this.inEdgeMap.put(paramE, paramN) == null) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    } 
    Preconditions.checkState(paramBoolean);
  }
  
  public void addOutEdge(E paramE, N paramN) {
    boolean bool;
    if (this.outEdgeMap.put(paramE, paramN) == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
  }
  
  public Set<N> adjacentNodes() {
    return (Set<N>)Sets.union(predecessors(), successors());
  }
  
  public Set<E> inEdges() {
    return Collections.unmodifiableSet(this.inEdgeMap.keySet());
  }
  
  public Set<E> incidentEdges() {
    return new AbstractSet<E>() {
        public boolean contains(@Nullable Object param1Object) {
          return (AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(param1Object) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(param1Object));
        }
        
        public UnmodifiableIterator<E> iterator() {
          Sets.SetView setView;
          if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
            Iterable iterable = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
          } else {
            setView = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
          } 
          return Iterators.unmodifiableIterator(setView.iterator());
        }
        
        public int size() {
          return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
        }
      };
  }
  
  public N oppositeNode(Object paramObject) {
    return (N)Preconditions.checkNotNull(this.outEdgeMap.get(paramObject));
  }
  
  public Set<E> outEdges() {
    return Collections.unmodifiableSet(this.outEdgeMap.keySet());
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean) {
    if (paramBoolean) {
      int i = this.selfLoopCount - 1;
      this.selfLoopCount = i;
      Graphs.checkNonNegative(i);
    } 
    return (N)Preconditions.checkNotNull(this.inEdgeMap.remove(paramObject));
  }
  
  public N removeOutEdge(Object paramObject) {
    return (N)Preconditions.checkNotNull(this.outEdgeMap.remove(paramObject));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\AbstractDirectedNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */