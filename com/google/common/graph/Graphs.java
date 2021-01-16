package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class Graphs {
  private static boolean canTraverseWithoutReusingEdge(Graph<?> paramGraph, Object paramObject1, @Nullable Object paramObject2) {
    return (paramGraph.isDirected() || !Objects.equal(paramObject2, paramObject1));
  }
  
  @CanIgnoreReturnValue
  static int checkNonNegative(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Not true that %s is non-negative.", paramInt);
    return paramInt;
  }
  
  @CanIgnoreReturnValue
  static long checkNonNegative(long paramLong) {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Not true that %s is non-negative.", paramLong);
    return paramLong;
  }
  
  @CanIgnoreReturnValue
  static int checkPositive(int paramInt) {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Not true that %s is positive.", paramInt);
    return paramInt;
  }
  
  @CanIgnoreReturnValue
  static long checkPositive(long paramLong) {
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Not true that %s is positive.", paramLong);
    return paramLong;
  }
  
  public static <N> MutableGraph<N> copyOf(Graph<N> paramGraph) {
    MutableGraph<N> mutableGraph = GraphBuilder.<N>from(paramGraph).expectedNodeCount(paramGraph.nodes().size()).build();
    null = paramGraph.nodes().iterator();
    while (null.hasNext())
      mutableGraph.addNode(null.next()); 
    for (EndpointPair<N> endpointPair : paramGraph.edges())
      mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV()); 
    return mutableGraph;
  }
  
  public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> paramNetwork) {
    MutableNetwork<N, E> mutableNetwork = NetworkBuilder.<N, E>from(paramNetwork).expectedNodeCount(paramNetwork.nodes().size()).expectedEdgeCount(paramNetwork.edges().size()).build();
    Iterator iterator = paramNetwork.nodes().iterator();
    while (iterator.hasNext())
      mutableNetwork.addNode(iterator.next()); 
    for (E e : paramNetwork.edges()) {
      EndpointPair<N> endpointPair = paramNetwork.incidentNodes(e);
      mutableNetwork.addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e);
    } 
    return mutableNetwork;
  }
  
  public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> paramValueGraph) {
    MutableValueGraph<N, V> mutableValueGraph = ValueGraphBuilder.<N>from(paramValueGraph).expectedNodeCount(paramValueGraph.nodes().size()).build();
    null = paramValueGraph.nodes().iterator();
    while (null.hasNext())
      mutableValueGraph.addNode(null.next()); 
    for (EndpointPair<N> endpointPair : paramValueGraph.edges())
      mutableValueGraph.putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), paramValueGraph.edgeValue(endpointPair.nodeU(), endpointPair.nodeV())); 
    return mutableValueGraph;
  }
  
  public static boolean equivalent(@Nullable Graph<?> paramGraph1, @Nullable Graph<?> paramGraph2) {
    boolean bool = true;
    if (paramGraph1 == paramGraph2)
      return true; 
    if (paramGraph1 == null || paramGraph2 == null)
      return false; 
    if (paramGraph1.isDirected() != paramGraph2.isDirected() || !paramGraph1.nodes().equals(paramGraph2.nodes()) || !paramGraph1.edges().equals(paramGraph2.edges()))
      bool = false; 
    return bool;
  }
  
  public static boolean equivalent(@Nullable Network<?, ?> paramNetwork1, @Nullable Network<?, ?> paramNetwork2) {
    if (paramNetwork1 == paramNetwork2)
      return true; 
    if (paramNetwork1 == null || paramNetwork2 == null)
      return false; 
    if (paramNetwork1.isDirected() != paramNetwork2.isDirected() || !paramNetwork1.nodes().equals(paramNetwork2.nodes()) || !paramNetwork1.edges().equals(paramNetwork2.edges()))
      return false; 
    for (Object object : paramNetwork1.edges()) {
      if (!paramNetwork1.incidentNodes(object).equals(paramNetwork2.incidentNodes(object)))
        return false; 
    } 
    return true;
  }
  
  public static boolean equivalent(@Nullable ValueGraph<?, ?> paramValueGraph1, @Nullable ValueGraph<?, ?> paramValueGraph2) {
    if (paramValueGraph1 == paramValueGraph2)
      return true; 
    if (paramValueGraph1 == null || paramValueGraph2 == null)
      return false; 
    if (paramValueGraph1.isDirected() != paramValueGraph2.isDirected() || !paramValueGraph1.nodes().equals(paramValueGraph2.nodes()) || !paramValueGraph1.edges().equals(paramValueGraph2.edges()))
      return false; 
    for (EndpointPair<?> endpointPair : paramValueGraph1.edges()) {
      if (!paramValueGraph1.edgeValue(endpointPair.nodeU(), endpointPair.nodeV()).equals(paramValueGraph2.edgeValue(endpointPair.nodeU(), endpointPair.nodeV())))
        return false; 
    } 
    return true;
  }
  
  public static boolean hasCycle(Graph<?> paramGraph) {
    int i = paramGraph.edges().size();
    if (i == 0)
      return false; 
    if (!paramGraph.isDirected() && i >= paramGraph.nodes().size())
      return true; 
    HashMap<Object, NodeVisitState> hashMap = Maps.newHashMapWithExpectedSize(paramGraph.nodes().size());
    Iterator iterator = paramGraph.nodes().iterator();
    while (iterator.hasNext()) {
      if (subgraphHasCycle(paramGraph, hashMap, iterator.next(), null))
        return true; 
    } 
    return false;
  }
  
  public static boolean hasCycle(Network<?, ?> paramNetwork) {
    return (!paramNetwork.isDirected() && paramNetwork.allowsParallelEdges() && paramNetwork.edges().size() > paramNetwork.asGraph().edges().size()) ? true : hasCycle(paramNetwork.asGraph());
  }
  
  public static <N> MutableGraph<N> inducedSubgraph(Graph<N> paramGraph, Iterable<? extends N> paramIterable) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic from : (Lcom/google/common/graph/Graph;)Lcom/google/common/graph/GraphBuilder;
    //   4: invokevirtual build : ()Lcom/google/common/graph/MutableGraph;
    //   7: astore_2
    //   8: aload_1
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_1
    //   15: aload_1
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 40
    //   24: aload_2
    //   25: aload_1
    //   26: invokeinterface next : ()Ljava/lang/Object;
    //   31: invokeinterface addNode : (Ljava/lang/Object;)Z
    //   36: pop
    //   37: goto -> 15
    //   40: aload_2
    //   41: invokeinterface nodes : ()Ljava/util/Set;
    //   46: invokeinterface iterator : ()Ljava/util/Iterator;
    //   51: astore_3
    //   52: aload_3
    //   53: invokeinterface hasNext : ()Z
    //   58: ifeq -> 130
    //   61: aload_3
    //   62: invokeinterface next : ()Ljava/lang/Object;
    //   67: astore #4
    //   69: aload_0
    //   70: aload #4
    //   72: invokeinterface successors : (Ljava/lang/Object;)Ljava/util/Set;
    //   77: invokeinterface iterator : ()Ljava/util/Iterator;
    //   82: astore_1
    //   83: aload_1
    //   84: invokeinterface hasNext : ()Z
    //   89: ifeq -> 52
    //   92: aload_1
    //   93: invokeinterface next : ()Ljava/lang/Object;
    //   98: astore #5
    //   100: aload_2
    //   101: invokeinterface nodes : ()Ljava/util/Set;
    //   106: aload #5
    //   108: invokeinterface contains : (Ljava/lang/Object;)Z
    //   113: ifeq -> 83
    //   116: aload_2
    //   117: aload #4
    //   119: aload #5
    //   121: invokeinterface putEdge : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   126: pop
    //   127: goto -> 83
    //   130: aload_2
    //   131: areturn
  }
  
  public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> paramNetwork, Iterable<? extends N> paramIterable) {
    MutableNetwork<N, E> mutableNetwork = NetworkBuilder.<N, E>from(paramNetwork).build();
    Iterator<? extends N> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      mutableNetwork.addNode(iterator.next()); 
    for (Object object : mutableNetwork.nodes()) {
      for (E e : paramNetwork.outEdges(object)) {
        iterator = paramNetwork.incidentNodes(e).adjacentNode(object);
        if (mutableNetwork.nodes().contains(iterator))
          mutableNetwork.addEdge(object, iterator, e); 
      } 
    } 
    return mutableNetwork;
  }
  
  public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> paramValueGraph, Iterable<? extends N> paramIterable) {
    MutableValueGraph<N, V> mutableValueGraph = ValueGraphBuilder.<N>from(paramValueGraph).build();
    iterator = paramIterable.iterator();
    while (iterator.hasNext())
      mutableValueGraph.addNode(iterator.next()); 
    for (Iterator<? extends N> iterator : (Iterable<Iterator<? extends N>>)mutableValueGraph.nodes()) {
      for (N n : paramValueGraph.successors(iterator)) {
        if (mutableValueGraph.nodes().contains(n))
          mutableValueGraph.putEdgeValue(iterator, n, paramValueGraph.edgeValue(iterator, n)); 
      } 
    } 
    return mutableValueGraph;
  }
  
  public static <N> Set<N> reachableNodes(Graph<N> paramGraph, Object paramObject) {
    Preconditions.checkArgument(paramGraph.nodes().contains(paramObject), "Node %s is not an element of this graph.", paramObject);
    LinkedHashSet<Object> linkedHashSet = new LinkedHashSet();
    ArrayDeque<Object> arrayDeque = new ArrayDeque();
    linkedHashSet.add(paramObject);
    arrayDeque.add(paramObject);
    while (!arrayDeque.isEmpty()) {
      paramObject = paramGraph.successors(arrayDeque.remove()).iterator();
      while (paramObject.hasNext()) {
        Object object = paramObject.next();
        if (linkedHashSet.add(object))
          arrayDeque.add(object); 
      } 
    } 
    return Collections.unmodifiableSet(linkedHashSet);
  }
  
  private static boolean subgraphHasCycle(Graph<?> paramGraph, Map<Object, NodeVisitState> paramMap, Object paramObject1, @Nullable Object paramObject2) {
    NodeVisitState nodeVisitState = paramMap.get(paramObject1);
    if (nodeVisitState == NodeVisitState.COMPLETE)
      return false; 
    if (nodeVisitState == NodeVisitState.PENDING)
      return true; 
    paramMap.put(paramObject1, NodeVisitState.PENDING);
    for (Object object : paramGraph.successors(paramObject1)) {
      if (canTraverseWithoutReusingEdge(paramGraph, object, paramObject2) && subgraphHasCycle(paramGraph, paramMap, object, paramObject1))
        return true; 
    } 
    paramMap.put(paramObject1, NodeVisitState.COMPLETE);
    return false;
  }
  
  public static <N> Graph<N> transitiveClosure(Graph<N> paramGraph) {
    MutableGraph<N> mutableGraph = GraphBuilder.<N>from(paramGraph).allowsSelfLoops(true).build();
    if (paramGraph.isDirected()) {
      for (N n : paramGraph.nodes()) {
        Iterator iterator = reachableNodes(paramGraph, n).iterator();
        while (iterator.hasNext())
          mutableGraph.putEdge(n, iterator.next()); 
      } 
    } else {
      HashSet<N> hashSet = new HashSet();
      for (Iterator<N> iterator : paramGraph.nodes()) {
        if (!hashSet.contains(iterator)) {
          Set<N> set = reachableNodes(paramGraph, iterator);
          hashSet.addAll(set);
          iterator = set.iterator();
          for (byte b = 1; iterator.hasNext(); b++) {
            N n = iterator.next();
            Iterator<N> iterator1 = Iterables.limit(set, b).iterator();
            while (iterator1.hasNext())
              mutableGraph.putEdge(n, iterator1.next()); 
          } 
        } 
      } 
    } 
    return mutableGraph;
  }
  
  public static <N> Graph<N> transpose(Graph<N> paramGraph) {
    return !paramGraph.isDirected() ? paramGraph : ((paramGraph instanceof TransposedGraph) ? ((TransposedGraph)paramGraph).graph : new TransposedGraph<N>(paramGraph));
  }
  
  public static <N, E> Network<N, E> transpose(Network<N, E> paramNetwork) {
    return !paramNetwork.isDirected() ? paramNetwork : ((paramNetwork instanceof TransposedNetwork) ? ((TransposedNetwork)paramNetwork).network : new TransposedNetwork<N, E>(paramNetwork));
  }
  
  public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> paramValueGraph) {
    return !paramValueGraph.isDirected() ? paramValueGraph : ((paramValueGraph instanceof TransposedValueGraph) ? ((TransposedValueGraph)paramValueGraph).graph : new TransposedValueGraph<N, V>(paramValueGraph));
  }
  
  private enum NodeVisitState {
    COMPLETE, PENDING;
    
    static {
      $VALUES = new NodeVisitState[] { PENDING, COMPLETE };
    }
  }
  
  private static class TransposedGraph<N> extends AbstractGraph<N> {
    private final Graph<N> graph;
    
    TransposedGraph(Graph<N> param1Graph) {
      this.graph = param1Graph;
    }
    
    public Set<N> adjacentNodes(Object param1Object) {
      return this.graph.adjacentNodes(param1Object);
    }
    
    public boolean allowsSelfLoops() {
      return this.graph.allowsSelfLoops();
    }
    
    protected long edgeCount() {
      return this.graph.edges().size();
    }
    
    public boolean isDirected() {
      return this.graph.isDirected();
    }
    
    public ElementOrder<N> nodeOrder() {
      return this.graph.nodeOrder();
    }
    
    public Set<N> nodes() {
      return this.graph.nodes();
    }
    
    public Set<N> predecessors(Object param1Object) {
      return this.graph.successors(param1Object);
    }
    
    public Set<N> successors(Object param1Object) {
      return this.graph.predecessors(param1Object);
    }
  }
  
  private static class TransposedNetwork<N, E> extends AbstractNetwork<N, E> {
    private final Network<N, E> network;
    
    TransposedNetwork(Network<N, E> param1Network) {
      this.network = param1Network;
    }
    
    public Set<E> adjacentEdges(Object param1Object) {
      return this.network.adjacentEdges(param1Object);
    }
    
    public Set<N> adjacentNodes(Object param1Object) {
      return this.network.adjacentNodes(param1Object);
    }
    
    public boolean allowsParallelEdges() {
      return this.network.allowsParallelEdges();
    }
    
    public boolean allowsSelfLoops() {
      return this.network.allowsSelfLoops();
    }
    
    public ElementOrder<E> edgeOrder() {
      return this.network.edgeOrder();
    }
    
    public Set<E> edges() {
      return this.network.edges();
    }
    
    public Set<E> edgesConnecting(Object param1Object1, Object param1Object2) {
      return this.network.edgesConnecting(param1Object2, param1Object1);
    }
    
    public Set<E> inEdges(Object param1Object) {
      return this.network.outEdges(param1Object);
    }
    
    public Set<E> incidentEdges(Object param1Object) {
      return this.network.incidentEdges(param1Object);
    }
    
    public EndpointPair<N> incidentNodes(Object<N> param1Object) {
      param1Object = (Object<N>)this.network.incidentNodes(param1Object);
      return EndpointPair.of(this.network, param1Object.nodeV(), param1Object.nodeU());
    }
    
    public boolean isDirected() {
      return this.network.isDirected();
    }
    
    public ElementOrder<N> nodeOrder() {
      return this.network.nodeOrder();
    }
    
    public Set<N> nodes() {
      return this.network.nodes();
    }
    
    public Set<E> outEdges(Object param1Object) {
      return this.network.inEdges(param1Object);
    }
    
    public Set<N> predecessors(Object param1Object) {
      return this.network.successors(param1Object);
    }
    
    public Set<N> successors(Object param1Object) {
      return this.network.predecessors(param1Object);
    }
  }
  
  private static class TransposedValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final ValueGraph<N, V> graph;
    
    TransposedValueGraph(ValueGraph<N, V> param1ValueGraph) {
      this.graph = param1ValueGraph;
    }
    
    public Set<N> adjacentNodes(Object param1Object) {
      return this.graph.adjacentNodes(param1Object);
    }
    
    public boolean allowsSelfLoops() {
      return this.graph.allowsSelfLoops();
    }
    
    protected long edgeCount() {
      return this.graph.edges().size();
    }
    
    public V edgeValue(Object param1Object1, Object param1Object2) {
      return this.graph.edgeValue(param1Object2, param1Object1);
    }
    
    public V edgeValueOrDefault(Object param1Object1, Object param1Object2, @Nullable V param1V) {
      return this.graph.edgeValueOrDefault(param1Object2, param1Object1, param1V);
    }
    
    public boolean isDirected() {
      return this.graph.isDirected();
    }
    
    public ElementOrder<N> nodeOrder() {
      return this.graph.nodeOrder();
    }
    
    public Set<N> nodes() {
      return this.graph.nodes();
    }
    
    public Set<N> predecessors(Object param1Object) {
      return this.graph.successors(param1Object);
    }
    
    public Set<N> successors(Object param1Object) {
      return this.graph.predecessors(param1Object);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\Graphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */