package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
  public final V apply(K paramK) {
    return getUnchecked(paramK);
  }
  
  public ImmutableMap<K, V> getAll(Iterable<? extends K> paramIterable) throws ExecutionException {
    // Byte code:
    //   0: invokestatic newLinkedHashMap : ()Ljava/util/LinkedHashMap;
    //   3: astore_2
    //   4: aload_1
    //   5: invokeinterface iterator : ()Ljava/util/Iterator;
    //   10: astore_1
    //   11: aload_1
    //   12: invokeinterface hasNext : ()Z
    //   17: ifeq -> 53
    //   20: aload_1
    //   21: invokeinterface next : ()Ljava/lang/Object;
    //   26: astore_3
    //   27: aload_2
    //   28: aload_3
    //   29: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   34: ifne -> 11
    //   37: aload_2
    //   38: aload_3
    //   39: aload_0
    //   40: aload_3
    //   41: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   44: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: goto -> 11
    //   53: aload_2
    //   54: invokestatic copyOf : (Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;
    //   57: areturn
  }
  
  public V getUnchecked(K paramK) {
    try {
      return get(paramK);
    } catch (ExecutionException executionException) {
      throw new UncheckedExecutionException(executionException.getCause());
    } 
  }
  
  public void refresh(K paramK) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\AbstractLoadingCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */