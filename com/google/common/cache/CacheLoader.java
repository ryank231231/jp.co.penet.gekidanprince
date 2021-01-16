package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@GwtCompatible(emulated = true)
public abstract class CacheLoader<K, V> {
  @GwtIncompatible
  public static <K, V> CacheLoader<K, V> asyncReloading(final CacheLoader<K, V> loader, final Executor executor) {
    Preconditions.checkNotNull(loader);
    Preconditions.checkNotNull(executor);
    return new CacheLoader<K, V>() {
        public V load(K param1K) throws Exception {
          return loader.load(param1K);
        }
        
        public Map<K, V> loadAll(Iterable<? extends K> param1Iterable) throws Exception {
          return loader.loadAll(param1Iterable);
        }
        
        public ListenableFuture<V> reload(final K key, final V oldValue) throws Exception {
          ListenableFutureTask listenableFutureTask = ListenableFutureTask.create(new Callable<V>() {
                public V call() throws Exception {
                  return (V)loader.reload(key, (V)oldValue).get();
                }
              });
          executor.execute((Runnable)listenableFutureTask);
          return (ListenableFuture<V>)listenableFutureTask;
        }
      };
  }
  
  public static <K, V> CacheLoader<K, V> from(Function<K, V> paramFunction) {
    return new FunctionToCacheLoader<K, V>(paramFunction);
  }
  
  public static <V> CacheLoader<Object, V> from(Supplier<V> paramSupplier) {
    return new SupplierToCacheLoader<V>(paramSupplier);
  }
  
  public abstract V load(K paramK) throws Exception;
  
  public Map<K, V> loadAll(Iterable<? extends K> paramIterable) throws Exception {
    throw new UnsupportedLoadingOperationException();
  }
  
  @GwtIncompatible
  public ListenableFuture<V> reload(K paramK, V paramV) throws Exception {
    Preconditions.checkNotNull(paramK);
    Preconditions.checkNotNull(paramV);
    return Futures.immediateFuture(load(paramK));
  }
  
  private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Function<K, V> computingFunction;
    
    public FunctionToCacheLoader(Function<K, V> param1Function) {
      this.computingFunction = (Function<K, V>)Preconditions.checkNotNull(param1Function);
    }
    
    public V load(K param1K) {
      return (V)this.computingFunction.apply(Preconditions.checkNotNull(param1K));
    }
  }
  
  public static final class InvalidCacheLoadException extends RuntimeException {
    public InvalidCacheLoadException(String param1String) {
      super(param1String);
    }
  }
  
  private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Supplier<V> computingSupplier;
    
    public SupplierToCacheLoader(Supplier<V> param1Supplier) {
      this.computingSupplier = (Supplier<V>)Preconditions.checkNotNull(param1Supplier);
    }
    
    public V load(Object param1Object) {
      Preconditions.checkNotNull(param1Object);
      return (V)this.computingSupplier.get();
    }
  }
  
  public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\CacheLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */