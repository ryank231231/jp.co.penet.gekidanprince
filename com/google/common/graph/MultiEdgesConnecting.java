package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {
  private final Map<E, ?> outEdgeToNode;
  
  private final Object targetNode;
  
  MultiEdgesConnecting(Map<E, ?> paramMap, Object paramObject) {
    this.outEdgeToNode = (Map<E, ?>)Preconditions.checkNotNull(paramMap);
    this.targetNode = Preconditions.checkNotNull(paramObject);
  }
  
  public boolean contains(@Nullable Object paramObject) {
    return this.targetNode.equals(this.outEdgeToNode.get(paramObject));
  }
  
  public UnmodifiableIterator<E> iterator() {
    return (UnmodifiableIterator<E>)new AbstractIterator<E>() {
        protected E computeNext() {
          while (entries.hasNext()) {
            Map.Entry entry = entries.next();
            if (MultiEdgesConnecting.this.targetNode.equals(entry.getValue()))
              return (E)entry.getKey(); 
          } 
          return (E)endOfData();
        }
      };
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\MultiEdgesConnecting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */