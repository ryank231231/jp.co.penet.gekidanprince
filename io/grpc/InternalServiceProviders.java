package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.List;

@Internal
public final class InternalServiceProviders {
  @VisibleForTesting
  public static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> paramClass, Iterable<Class<?>> paramIterable) {
    return ServiceProviders.getCandidatesViaHardCoded(paramClass, paramIterable);
  }
  
  @VisibleForTesting
  public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> paramClass, ClassLoader paramClassLoader) {
    return ServiceProviders.getCandidatesViaServiceLoader(paramClass, paramClassLoader);
  }
  
  public static boolean isAndroid(ClassLoader paramClassLoader) {
    return ServiceProviders.isAndroid(paramClassLoader);
  }
  
  public static <T> T load(Class<T> paramClass, Iterable<Class<?>> paramIterable, ClassLoader paramClassLoader, PriorityAccessor<T> paramPriorityAccessor) {
    return ServiceProviders.load(paramClass, paramIterable, paramClassLoader, paramPriorityAccessor);
  }
  
  public static <T> List<T> loadAll(Class<T> paramClass, Iterable<Class<?>> paramIterable, ClassLoader paramClassLoader, PriorityAccessor<T> paramPriorityAccessor) {
    return ServiceProviders.loadAll(paramClass, paramIterable, paramClassLoader, paramPriorityAccessor);
  }
  
  public static interface PriorityAccessor<T> extends ServiceProviders.PriorityAccessor<T> {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\InternalServiceProviders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */