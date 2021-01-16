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

final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
  @LazyInit
  private transient Reference<Multiset<N>> predecessorsReference;
  
  @LazyInit
  private transient Reference<Multiset<N>> successorsReference;
  
  private DirectedMultiNetworkConnections(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
    super(paramMap1, paramMap2, paramInt);
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
  
  static <N, E> DirectedMultiNetworkConnections<N, E> of() {
    return new DirectedMultiNetworkConnections<N, E>(new HashMap<E, N>(2, 1.0F), new HashMap<E, N>(2, 1.0F), 0);
  }
  
  static <N, E> DirectedMultiNetworkConnections<N, E> ofImmutable(Map<E, N> paramMap1, Map<E, N> paramMap2, int paramInt) {
    return new DirectedMultiNetworkConnections<N, E>((Map<E, N>)ImmutableMap.copyOf(paramMap1), (Map<E, N>)ImmutableMap.copyOf(paramMap2), paramInt);
  }
  
  private Multiset<N> predecessorsMultiset() {
    HashMultiset hashMultiset;
    Multiset multiset1 = getReference((Reference)this.predecessorsReference);
    Multiset multiset2 = multiset1;
    if (multiset1 == null) {
      hashMultiset = HashMultiset.create(this.inEdgeMap.values());
      this.predecessorsReference = new SoftReference(hashMultiset);
    } 
    return (Multiset<N>)hashMultiset;
  }
  
  private Multiset<N> successorsMultiset() {
    HashMultiset hashMultiset;
    Multiset multiset1 = getReference((Reference)this.successorsReference);
    Multiset multiset2 = multiset1;
    if (multiset1 == null) {
      hashMultiset = HashMultiset.create(this.outEdgeMap.values());
      this.successorsReference = new SoftReference(hashMultiset);
    } 
    return (Multiset<N>)hashMultiset;
  }
  
  public void addInEdge(E paramE, N paramN, boolean paramBoolean) {
    super.addInEdge(paramE, paramN, paramBoolean);
    Multiset multiset = getReference((Reference)this.predecessorsReference);
    if (multiset != null)
      Preconditions.checkState(multiset.add(paramN)); 
  }
  
  public void addOutEdge(E paramE, N paramN) {
    super.addOutEdge(paramE, paramN);
    Multiset multiset = getReference((Reference)this.successorsReference);
    if (multiset != null)
      Preconditions.checkState(multiset.add(paramN)); 
  }
  
  public Set<E> edgesConnecting(final Object node) {
    return new MultiEdgesConnecting<E>(this.outEdgeMap, node) {
        public int size() {
          return DirectedMultiNetworkConnections.this.successorsMultiset().count(node);
        }
      };
  }
  
  public Set<N> predecessors() {
    return Collections.unmodifiableSet(predecessorsMultiset().elementSet());
  }
  
  public N removeInEdge(Object paramObject, boolean paramBoolean) {
    N n = super.removeInEdge(paramObject, paramBoolean);
    paramObject = getReference((Reference)this.predecessorsReference);
    if (paramObject != null)
      Preconditions.checkState(paramObject.remove(n)); 
    return n;
  }
  
  public N removeOutEdge(Object paramObject) {
    N n = super.removeOutEdge(paramObject);
    paramObject = getReference((Reference)this.successorsReference);
    if (paramObject != null)
      Preconditions.checkState(paramObject.remove(n)); 
    return n;
  }
  
  public Set<N> successors() {
    return Collections.unmodifiableSet(successorsMultiset().elementSet());
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\DirectedMultiNetworkConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */