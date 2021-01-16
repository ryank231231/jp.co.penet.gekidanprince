package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;

@Beta
public abstract class AbstractValueGraph<N, V> extends AbstractGraph<N> implements ValueGraph<N, V> {
  private Map<EndpointPair<N>, V> edgeValueMap() {
    Function<EndpointPair<N>, V> function = new Function<EndpointPair<N>, V>() {
        public V apply(EndpointPair<N> param1EndpointPair) {
          return (V)AbstractValueGraph.this.edgeValue(param1EndpointPair.nodeU(), param1EndpointPair.nodeV());
        }
      };
    return Maps.asMap(edges(), function);
  }
  
  public V edgeValue(Object paramObject1, Object paramObject2) {
    V v = edgeValueOrDefault(paramObject1, paramObject2, null);
    if (v != null)
      return v; 
    Preconditions.checkArgument(nodes().contains(paramObject1), "Node %s is not an element of this graph.", paramObject1);
    Preconditions.checkArgument(nodes().contains(paramObject2), "Node %s is not an element of this graph.", paramObject2);
    throw new IllegalArgumentException(String.format("Edge connecting %s to %s is not present in this graph.", new Object[] { paramObject1, paramObject2 }));
  }
  
  public String toString() {
    return String.format("%s, nodes: %s, edges: %s", new Object[] { String.format("isDirected: %s, allowsSelfLoops: %s", new Object[] { Boolean.valueOf(isDirected()), Boolean.valueOf(allowsSelfLoops()) }), nodes(), edgeValueMap() });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\AbstractValueGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */