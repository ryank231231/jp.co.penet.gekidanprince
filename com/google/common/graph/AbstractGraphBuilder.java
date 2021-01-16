package com.google.common.graph;

import com.google.common.base.Optional;

abstract class AbstractGraphBuilder<N> {
  boolean allowsSelfLoops = false;
  
  final boolean directed;
  
  Optional<Integer> expectedNodeCount = Optional.absent();
  
  ElementOrder<N> nodeOrder = ElementOrder.insertion();
  
  AbstractGraphBuilder(boolean paramBoolean) {
    this.directed = paramBoolean;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\AbstractGraphBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */