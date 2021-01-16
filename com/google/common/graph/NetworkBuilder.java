package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@Beta
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {
  boolean allowsParallelEdges = false;
  
  ElementOrder<? super E> edgeOrder = ElementOrder.insertion();
  
  Optional<Integer> expectedEdgeCount = Optional.absent();
  
  private NetworkBuilder(boolean paramBoolean) {
    super(paramBoolean);
  }
  
  private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> cast() {
    return this;
  }
  
  public static NetworkBuilder<Object, Object> directed() {
    return new NetworkBuilder<Object, Object>(true);
  }
  
  public static <N, E> NetworkBuilder<N, E> from(Network<N, E> paramNetwork) {
    return (new NetworkBuilder<Object, Object>(paramNetwork.isDirected())).allowsParallelEdges(paramNetwork.allowsParallelEdges()).allowsSelfLoops(paramNetwork.allowsSelfLoops()).nodeOrder(paramNetwork.nodeOrder()).edgeOrder(paramNetwork.edgeOrder());
  }
  
  public static NetworkBuilder<Object, Object> undirected() {
    return new NetworkBuilder<Object, Object>(false);
  }
  
  public NetworkBuilder<N, E> allowsParallelEdges(boolean paramBoolean) {
    this.allowsParallelEdges = paramBoolean;
    return this;
  }
  
  public NetworkBuilder<N, E> allowsSelfLoops(boolean paramBoolean) {
    this.allowsSelfLoops = paramBoolean;
    return this;
  }
  
  public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
    return new ConfigurableMutableNetwork<N1, E1>(this);
  }
  
  public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> paramElementOrder) {
    NetworkBuilder<Object, Object> networkBuilder = cast();
    networkBuilder.edgeOrder = (ElementOrder<? super E>)Preconditions.checkNotNull(paramElementOrder);
    return (NetworkBuilder)networkBuilder;
  }
  
  public NetworkBuilder<N, E> expectedEdgeCount(int paramInt) {
    this.expectedEdgeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(paramInt)));
    return this;
  }
  
  public NetworkBuilder<N, E> expectedNodeCount(int paramInt) {
    this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(paramInt)));
    return this;
  }
  
  public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> paramElementOrder) {
    NetworkBuilder<Object, Object> networkBuilder = cast();
    networkBuilder.nodeOrder = (ElementOrder<N>)Preconditions.checkNotNull(paramElementOrder);
    return (NetworkBuilder)networkBuilder;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\NetworkBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */