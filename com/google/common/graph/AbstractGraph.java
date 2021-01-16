package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractGraph<N> implements Graph<N> {
  public int degree(Object paramObject) {
    boolean bool;
    if (isDirected())
      return IntMath.saturatedAdd(predecessors(paramObject).size(), successors(paramObject).size()); 
    Set<N> set = adjacentNodes(paramObject);
    if (allowsSelfLoops() && set.contains(paramObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return IntMath.saturatedAdd(set.size(), bool);
  }
  
  protected long edgeCount() {
    boolean bool;
    Iterator<N> iterator = nodes().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += degree(iterator.next()));
    if ((0x1L & l) == 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    return l >>> 1L;
  }
  
  public Set<EndpointPair<N>> edges() {
    return new AbstractSet<EndpointPair<N>>() {
        public boolean contains(@Nullable Object param1Object) {
          boolean bool = param1Object instanceof EndpointPair;
          boolean bool1 = false;
          if (!bool)
            return false; 
          param1Object = param1Object;
          bool = bool1;
          if (AbstractGraph.this.isDirected() == param1Object.isOrdered()) {
            bool = bool1;
            if (AbstractGraph.this.nodes().contains(param1Object.nodeU())) {
              bool = bool1;
              if (AbstractGraph.this.successors(param1Object.nodeU()).contains(param1Object.nodeV()))
                bool = true; 
            } 
          } 
          return bool;
        }
        
        public UnmodifiableIterator<EndpointPair<N>> iterator() {
          return (UnmodifiableIterator)EndpointPairIterator.of(AbstractGraph.this);
        }
        
        public int size() {
          return Ints.saturatedCast(AbstractGraph.this.edgeCount());
        }
      };
  }
  
  public int inDegree(Object paramObject) {
    int i;
    if (isDirected()) {
      i = predecessors(paramObject).size();
    } else {
      i = degree(paramObject);
    } 
    return i;
  }
  
  public int outDegree(Object paramObject) {
    int i;
    if (isDirected()) {
      i = successors(paramObject).size();
    } else {
      i = degree(paramObject);
    } 
    return i;
  }
  
  public String toString() {
    return String.format("%s, nodes: %s, edges: %s", new Object[] { String.format("isDirected: %s, allowsSelfLoops: %s", new Object[] { Boolean.valueOf(isDirected()), Boolean.valueOf(allowsSelfLoops()) }), nodes(), edges() });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\AbstractGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */