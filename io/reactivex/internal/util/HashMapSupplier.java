package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public enum HashMapSupplier implements Callable<Map<Object, Object>> {
  INSTANCE;
  
  static {
    $VALUES = new HashMapSupplier[] { INSTANCE };
  }
  
  public static <K, V> Callable<Map<K, V>> asCallable() {
    return INSTANCE;
  }
  
  public Map<Object, Object> call() throws Exception {
    return new HashMap<Object, Object>();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\HashMapSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */