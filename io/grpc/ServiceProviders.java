package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

final class ServiceProviders {
  @VisibleForTesting
  static <T> T create(Class<T> paramClass, Class<?> paramClass1) {
    try {
      return (T)paramClass1.<Class<T>>asSubclass((Class)paramClass).getConstructor(new Class[0]).newInstance(new Object[0]);
    } catch (Throwable throwable) {
      throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", new Object[] { paramClass1.getName(), throwable }), throwable);
    } 
  }
  
  @VisibleForTesting
  static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> paramClass, Iterable<Class<?>> paramIterable) {
    ArrayList<T> arrayList = new ArrayList();
    Iterator<Class<?>> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(create(paramClass, iterator.next())); 
    return arrayList;
  }
  
  @VisibleForTesting
  public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> paramClass, ClassLoader paramClassLoader) {
    ServiceLoader<T> serviceLoader2 = ServiceLoader.load(paramClass, paramClassLoader);
    ServiceLoader<T> serviceLoader1 = serviceLoader2;
    if (!serviceLoader2.iterator().hasNext())
      serviceLoader1 = ServiceLoader.load(paramClass); 
    return serviceLoader1;
  }
  
  static boolean isAndroid(ClassLoader paramClassLoader) {
    try {
      Class.forName("android.app.Application", false, paramClassLoader);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static <T> T load(Class<T> paramClass, Iterable<Class<?>> paramIterable, ClassLoader paramClassLoader, PriorityAccessor<T> paramPriorityAccessor) {
    List<T> list = loadAll(paramClass, paramIterable, paramClassLoader, paramPriorityAccessor);
    return list.isEmpty() ? null : list.get(0);
  }
  
  public static <T> List<T> loadAll(Class<T> paramClass, Iterable<Class<?>> paramIterable, ClassLoader paramClassLoader, final PriorityAccessor<T> priorityAccessor) {
    Iterable<T> iterable;
    if (isAndroid(paramClassLoader)) {
      iterable = getCandidatesViaHardCoded(paramClass, paramIterable);
    } else {
      iterable = getCandidatesViaServiceLoader((Class<T>)iterable, paramClassLoader);
    } 
    paramIterable = new ArrayList<Class<?>>();
    for (ClassLoader paramClassLoader : iterable) {
      if (!priorityAccessor.isAvailable((T)paramClassLoader))
        continue; 
      paramIterable.add(paramClassLoader);
    } 
    Collections.sort((List<Class<?>>)paramIterable, Collections.reverseOrder((Comparator)new Comparator<T>() {
            public int compare(T param1T1, T param1T2) {
              return priorityAccessor.getPriority(param1T1) - priorityAccessor.getPriority(param1T2);
            }
          }));
    return Collections.unmodifiableList((List)paramIterable);
  }
  
  public static interface PriorityAccessor<T> {
    int getPriority(T param1T);
    
    boolean isAvailable(T param1T);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServiceProviders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */