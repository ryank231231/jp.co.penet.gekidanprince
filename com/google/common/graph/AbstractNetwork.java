package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractNetwork<N, E> implements Network<N, E> {
  private Map<E, EndpointPair<N>> edgeIncidentNodesMap() {
    Function<E, EndpointPair<N>> function = new Function<E, EndpointPair<N>>() {
        public EndpointPair<N> apply(E param1E) {
          return AbstractNetwork.this.incidentNodes(param1E);
        }
      };
    return Maps.asMap(edges(), function);
  }
  
  public Set<E> adjacentEdges(Object paramObject) {
    EndpointPair<N> endpointPair = incidentNodes(paramObject);
    return (Set<E>)Sets.difference((Set)Sets.union(incidentEdges(endpointPair.nodeU()), incidentEdges(endpointPair.nodeV())), (Set)ImmutableSet.of(paramObject));
  }
  
  public Graph<N> asGraph() {
    return new AbstractGraph<N>() {
        public Set<N> adjacentNodes(Object param1Object) {
          return AbstractNetwork.this.adjacentNodes(param1Object);
        }
        
        public boolean allowsSelfLoops() {
          return AbstractNetwork.this.allowsSelfLoops();
        }
        
        public Set<EndpointPair<N>> edges() {
          return AbstractNetwork.this.allowsParallelEdges() ? super.edges() : new AbstractSet<EndpointPair<N>>() {
              public boolean contains(@Nullable Object param2Object) {
                boolean bool = param2Object instanceof EndpointPair;
                boolean bool1 = false;
                if (!bool)
                  return false; 
                param2Object = param2Object;
                bool = bool1;
                if (AbstractNetwork.null.this.isDirected() == param2Object.isOrdered()) {
                  bool = bool1;
                  if (AbstractNetwork.null.this.nodes().contains(param2Object.nodeU())) {
                    bool = bool1;
                    if (AbstractNetwork.null.this.successors(param2Object.nodeU()).contains(param2Object.nodeV()))
                      bool = true; 
                  } 
                } 
                return bool;
              }
              
              public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function<E, EndpointPair<N>>() {
                      public EndpointPair<N> apply(E param3E) {
                        return AbstractNetwork.this.incidentNodes(param3E);
                      }
                    });
              }
              
              public int size() {
                return AbstractNetwork.this.edges().size();
              }
            };
        }
        
        public boolean isDirected() {
          return AbstractNetwork.this.isDirected();
        }
        
        public ElementOrder<N> nodeOrder() {
          return AbstractNetwork.this.nodeOrder();
        }
        
        public Set<N> nodes() {
          return AbstractNetwork.this.nodes();
        }
        
        public Set<N> predecessors(Object param1Object) {
          return AbstractNetwork.this.predecessors(param1Object);
        }
        
        public Set<N> successors(Object param1Object) {
          return AbstractNetwork.this.successors(param1Object);
        }
      };
  }
  
  public int degree(Object paramObject) {
    return isDirected() ? IntMath.saturatedAdd(inEdges(paramObject).size(), outEdges(paramObject).size()) : IntMath.saturatedAdd(incidentEdges(paramObject).size(), edgesConnecting(paramObject, paramObject).size());
  }
  
  public int inDegree(Object paramObject) {
    int i;
    if (isDirected()) {
      i = inEdges(paramObject).size();
    } else {
      i = degree(paramObject);
    } 
    return i;
  }
  
  public int outDegree(Object paramObject) {
    int i;
    if (isDirected()) {
      i = outEdges(paramObject).size();
    } else {
      i = degree(paramObject);
    } 
    return i;
  }
  
  public String toString() {
    return String.format("%s, nodes: %s, edges: %s", new Object[] { String.format("isDirected: %s, allowsParallelEdges: %s, allowsSelfLoops: %s", new Object[] { Boolean.valueOf(isDirected()), Boolean.valueOf(allowsParallelEdges()), Boolean.valueOf(allowsSelfLoops()) }), nodes(), edgeIncidentNodesMap() });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\AbstractNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */