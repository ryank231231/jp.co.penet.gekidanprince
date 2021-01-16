package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
  @LazyInit
  private transient Reference<Multiset<N>> adjacentNodesReference;
  
  private UndirectedMultiNetworkConnections(Map<E, N> paramMap) {
    super(paramMap);
  }
  
  private Multiset<N> adjacentNodesMultiset() {
    HashMultiset hashMultiset;
    Multiset multiset1 = getReference((Reference)this.adjacentNodesReference);
    Multiset multiset2 = multiset1;
    if (multiset1 == null) {
      hashMultiset = HashMultiset.create(this.incidentEdgeMap.values());
      this.adjacentNodesReference = new SoftReference(hashMultiset);
    } 
    return (Multiset<N>)hashMultiset;
  }
  
  @Nullable
  private static <T> T getReference(@Nullable Reference<T> paramReference) {
    if (paramReference == null) {
      paramReference = null;
    } else {
      paramReference = (Reference<T>)paramReference.get();
    } 
    return (T)paramReference;
  }
  
  static <N, E> UndirectedMultiNetworkConnections<N, E> of() {
    return new UndirectedMultiNetworkConnections<N, E>(new HashMap<E, N>(2, 1.0F));
  }
  
  static <N, E> UndirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap) {
    return new UndirectedMultiNetworkConnections<N, E>((Map<E, N>)ImmutableMap.copyOf(paramMap));
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean) {
    if (!paramBoolean)
      addOutEdge(paramE, paramN); 
  }
  
  public void addOutEdge(E paramE, N paramN) {
    super.addOutEdge(paramE, paramN);
    Multiset multiset = getReference((Reference)this.adjacentNodesReference);
    if (multiset != null)
      Preconditions.checkState(multiset.add(paramN)); 
  }
  
  public Set<N> adjacentNodes() {
    return Collections.unmodifiableSet(adjacentNodesMultiset().elementSet());
  }
  
  public Set<E> edgesConnecting(final Object node) {
    return new MultiEdgesConnecting<E>(this.incidentEdgeMap, node) {
        public int size() {
          return UndirectedMultiNetworkConnections.this.adjacentNodesMultiset().count(node);
        }
      };
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean) {
    return !paramBoolean ? removeOutEdge(paramObject) : null;
  }
  
  public N removeOutEdge(Object paramObject) {
    paramObject = super.removeOutEdge(paramObject);
    Multiset multiset = getReference((Reference)this.adjacentNodesReference);
    if (multiset != null)
      Preconditions.checkState(multiset.remove(paramObject)); 
    return (N)paramObject;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\UndirectedMultiNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */