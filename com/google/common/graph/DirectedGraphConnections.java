package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
  private static final Object PRED = new Object();
  
  private final Map<N, Object> adjacentNodeValues;
  
  private int predecessorCount;
  
  private int successorCount;
  
  private DirectedGraphConnections(Map<N, Object> paramMap, int paramInt1, int paramInt2) {
    boolean bool;
    this.adjacentNodeValues = (Map<N, Object>)Preconditions.checkNotNull(paramMap);
    this.predecessorCount = Graphs.checkNonNegative(paramInt1);
    this.successorCount = Graphs.checkNonNegative(paramInt2);
    if (paramInt1 <= paramMap.size() && paramInt2 <= paramMap.size()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
  }
  
  private static boolean isPredecessor(@Nullable Object paramObject) {
    return (paramObject == PRED || paramObject instanceof PredAndSucc);
  }
  
  private static boolean isSuccessor(@Nullable Object paramObject) {
    boolean bool;
    if (paramObject != PRED && paramObject != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  static <N, V> DirectedGraphConnections<N, V> of() {
    return new DirectedGraphConnections<N, V>(new HashMap<N, Object>(4, 1.0F), 0, 0);
  }
  
  static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> paramSet, Map<N, V> paramMap) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: invokeinterface putAll : (Ljava/util/Map;)V
    //   15: aload_0
    //   16: invokeinterface iterator : ()Ljava/util/Iterator;
    //   21: astore_3
    //   22: aload_3
    //   23: invokeinterface hasNext : ()Z
    //   28: ifeq -> 78
    //   31: aload_3
    //   32: invokeinterface next : ()Ljava/lang/Object;
    //   37: astore #4
    //   39: aload_2
    //   40: aload #4
    //   42: getstatic com/google/common/graph/DirectedGraphConnections.PRED : Ljava/lang/Object;
    //   45: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   50: astore #5
    //   52: aload #5
    //   54: ifnull -> 22
    //   57: aload_2
    //   58: aload #4
    //   60: new com/google/common/graph/DirectedGraphConnections$PredAndSucc
    //   63: dup
    //   64: aload #5
    //   66: invokespecial <init> : (Ljava/lang/Object;)V
    //   69: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: goto -> 22
    //   78: new com/google/common/graph/DirectedGraphConnections
    //   81: dup
    //   82: aload_2
    //   83: invokestatic copyOf : (Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;
    //   86: aload_0
    //   87: invokeinterface size : ()I
    //   92: aload_1
    //   93: invokeinterface size : ()I
    //   98: invokespecial <init> : (Ljava/util/Map;II)V
    //   101: areturn
  }
  
  public void addPredecessor(N paramN, V paramV) {
    paramV = (V)this.adjacentNodeValues.put(paramN, PRED);
    if (paramV == null) {
      int i = this.predecessorCount + 1;
      this.predecessorCount = i;
      Graphs.checkPositive(i);
    } else if (paramV instanceof PredAndSucc) {
      this.adjacentNodeValues.put(paramN, paramV);
    } else if (paramV != PRED) {
      this.adjacentNodeValues.put(paramN, new PredAndSucc(paramV));
      int i = this.predecessorCount + 1;
      this.predecessorCount = i;
      Graphs.checkPositive(i);
    } 
  }
  
  public V addSuccessor(N paramN, V paramV) {
    Object object = this.adjacentNodeValues.put(paramN, paramV);
    if (object == null) {
      int i = this.successorCount + 1;
      this.successorCount = i;
      Graphs.checkPositive(i);
      return null;
    } 
    if (object instanceof PredAndSucc) {
      this.adjacentNodeValues.put(paramN, new PredAndSucc(paramV));
      return (V)((PredAndSucc)object).successorValue;
    } 
    if (object == PRED) {
      this.adjacentNodeValues.put(paramN, new PredAndSucc(paramV));
      int i = this.successorCount + 1;
      this.successorCount = i;
      Graphs.checkPositive(i);
      return null;
    } 
    return (V)object;
  }
  
  public Set<N> adjacentNodes() {
    return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
  }
  
  public Set<N> predecessors() {
    return new AbstractSet<N>() {
        public boolean contains(@Nullable Object param1Object) {
          return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(param1Object));
        }
        
        public UnmodifiableIterator<N> iterator() {
          return (UnmodifiableIterator<N>)new AbstractIterator<N>() {
              protected N computeNext() {
                while (entries.hasNext()) {
                  Map.Entry entry = entries.next();
                  if (DirectedGraphConnections.isPredecessor(entry.getValue()))
                    return (N)entry.getKey(); 
                } 
                return (N)endOfData();
              }
            };
        }
        
        public int size() {
          return DirectedGraphConnections.this.predecessorCount;
        }
      };
  }
  
  public void removePredecessor(Object paramObject) {
    Object object = this.adjacentNodeValues.get(paramObject);
    if (object == PRED) {
      this.adjacentNodeValues.remove(paramObject);
      int i = this.predecessorCount - 1;
      this.predecessorCount = i;
      Graphs.checkNonNegative(i);
    } else if (object instanceof PredAndSucc) {
      this.adjacentNodeValues.put((N)paramObject, ((PredAndSucc)object).successorValue);
      int i = this.predecessorCount - 1;
      this.predecessorCount = i;
      Graphs.checkNonNegative(i);
    } 
  }
  
  public V removeSuccessor(Object paramObject) {
    Object object = this.adjacentNodeValues.get(paramObject);
    if (object != null) {
      Object object1 = PRED;
      if (object != object1) {
        if (object instanceof PredAndSucc) {
          this.adjacentNodeValues.put((N)paramObject, object1);
          int j = this.successorCount - 1;
          this.successorCount = j;
          Graphs.checkNonNegative(j);
          return (V)((PredAndSucc)object).successorValue;
        } 
        this.adjacentNodeValues.remove(paramObject);
        int i = this.successorCount - 1;
        this.successorCount = i;
        Graphs.checkNonNegative(i);
        return (V)object;
      } 
    } 
    return null;
  }
  
  public Set<N> successors() {
    return new AbstractSet<N>() {
        public boolean contains(@Nullable Object param1Object) {
          return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(param1Object));
        }
        
        public UnmodifiableIterator<N> iterator() {
          return (UnmodifiableIterator<N>)new AbstractIterator<N>() {
              protected N computeNext() {
                while (entries.hasNext()) {
                  Map.Entry entry = entries.next();
                  if (DirectedGraphConnections.isSuccessor(entry.getValue()))
                    return (N)entry.getKey(); 
                } 
                return (N)endOfData();
              }
            };
        }
        
        public int size() {
          return DirectedGraphConnections.this.successorCount;
        }
      };
  }
  
  public V value(Object paramObject) {
    paramObject = this.adjacentNodeValues.get(paramObject);
    return (V)((paramObject == PRED) ? null : ((paramObject instanceof PredAndSucc) ? ((PredAndSucc)paramObject).successorValue : paramObject));
  }
  
  private static final class PredAndSucc {
    private final Object successorValue;
    
    PredAndSucc(Object param1Object) {
      this.successorValue = param1Object;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\graph\DirectedGraphConnections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */