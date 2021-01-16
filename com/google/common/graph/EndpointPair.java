package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import javax.annotation.Nullable;

@Beta
public abstract class EndpointPair<N> implements Iterable<N> {
  private final N nodeU;
  
  private final N nodeV;
  
  private EndpointPair(N paramN1, N paramN2) {
    this.nodeU = (N)Preconditions.checkNotNull(paramN1);
    this.nodeV = (N)Preconditions.checkNotNull(paramN2);
  }
  
  static <N> EndpointPair<N> of(Graph<?> paramGraph, N paramN1, N paramN2) {
    EndpointPair<N> endpointPair;
    if (paramGraph.isDirected()) {
      endpointPair = ordered(paramN1, paramN2);
    } else {
      endpointPair = unordered(paramN1, paramN2);
    } 
    return endpointPair;
  }
  
  static <N> EndpointPair<N> of(Network<?, ?> paramNetwork, N paramN1, N paramN2) {
    EndpointPair<N> endpointPair;
    if (paramNetwork.isDirected()) {
      endpointPair = ordered(paramN1, paramN2);
    } else {
      endpointPair = unordered(paramN1, paramN2);
    } 
    return endpointPair;
  }
  
  public static <N> EndpointPair<N> ordered(N paramN1, N paramN2) {
    return new Ordered<N>(paramN1, paramN2);
  }
  
  public static <N> EndpointPair<N> unordered(N paramN1, N paramN2) {
    return new Unordered<N>(paramN2, paramN1);
  }
  
  public final N adjacentNode(Object paramObject) {
    if (paramObject.equals(this.nodeU))
      return this.nodeV; 
    if (paramObject.equals(this.nodeV))
      return this.nodeU; 
    throw new IllegalArgumentException(String.format("EndpointPair %s does not contain node %s", new Object[] { this, paramObject }));
  }
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract boolean isOrdered();
  
  public final UnmodifiableIterator<N> iterator() {
    return Iterators.forArray(new Object[] { this.nodeU, this.nodeV });
  }
  
  public final N nodeU() {
    return this.nodeU;
  }
  
  public final N nodeV() {
    return this.nodeV;
  }
  
  public abstract N source();
  
  public abstract N target();
  
  private static final class Ordered<N> extends EndpointPair<N> {
    private Ordered(N param1N1, N param1N2) {
      super(param1N1, param1N2);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = true;
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof EndpointPair))
        return false; 
      param1Object = param1Object;
      if (isOrdered() != param1Object.isOrdered())
        return false; 
      if (!source().equals(param1Object.source()) || !target().equals(param1Object.target()))
        bool = false; 
      return bool;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { source(), target() });
    }
    
    public boolean isOrdered() {
      return true;
    }
    
    public N source() {
      return nodeU();
    }
    
    public N target() {
      return nodeV();
    }
    
    public String toString() {
      return String.format("<%s -> %s>", new Object[] { source(), target() });
    }
  }
  
  private static final class Unordered<N> extends EndpointPair<N> {
    private Unordered(N param1N1, N param1N2) {
      super(param1N1, param1N2);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = true;
      if (param1Object == this)
        return true; 
      if (!(param1Object instanceof EndpointPair))
        return false; 
      param1Object = param1Object;
      if (isOrdered() != param1Object.isOrdered())
        return false; 
      if (nodeU().equals(param1Object.nodeU()))
        return nodeV().equals(param1Object.nodeV()); 
      if (!nodeU().equals(param1Object.nodeV()) || !nodeV().equals(param1Object.nodeU()))
        bool = false; 
      return bool;
    }
    
    public int hashCode() {
      return nodeU().hashCode() + nodeV().hashCode();
    }
    
    public boolean isOrdered() {
      return false;
    }
    
    public N source() {
      throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
    }
    
    public N target() {
      throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
    }
    
    public String toString() {
      return String.format("[%s, %s]", new Object[] { nodeU(), nodeV() });
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\EndpointPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */