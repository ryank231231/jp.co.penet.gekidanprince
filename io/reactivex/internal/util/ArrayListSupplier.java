package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public enum ArrayListSupplier implements Callable<List<Object>>, Function<Object, List<Object>> {
  INSTANCE;
  
  static {
    $VALUES = new ArrayListSupplier[] { INSTANCE };
  }
  
  public static <T> Callable<List<T>> asCallable() {
    return INSTANCE;
  }
  
  public static <T, O> Function<O, List<T>> asFunction() {
    return INSTANCE;
  }
  
  public List<Object> apply(Object paramObject) throws Exception {
    return new ArrayList();
  }
  
  public List<Object> call() throws Exception {
    return new ArrayList();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\ArrayListSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */