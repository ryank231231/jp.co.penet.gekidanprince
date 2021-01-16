package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

final class SubscriberRegistry {
  private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> flattenHierarchyCache;
  
  private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableList<Method>>() {
        public ImmutableList<Method> load(Class<?> param1Class) throws Exception {
          return SubscriberRegistry.getAnnotatedMethodsNotCached(param1Class);
        }
      });
  
  @Weak
  private final EventBus bus;
  
  private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers = Maps.newConcurrentMap();
  
  static {
    flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableSet<Class<?>>>() {
          public ImmutableSet<Class<?>> load(Class<?> param1Class) {
            return ImmutableSet.copyOf(TypeToken.of(param1Class).getTypes().rawTypes());
          }
        });
  }
  
  SubscriberRegistry(EventBus paramEventBus) {
    this.bus = (EventBus)Preconditions.checkNotNull(paramEventBus);
  }
  
  private Multimap<Class<?>, Subscriber> findAllSubscribers(Object paramObject) {
    HashMultimap hashMultimap = HashMultimap.create();
    for (Method method : getAnnotatedMethods(paramObject.getClass()))
      hashMultimap.put(method.getParameterTypes()[0], Subscriber.create(this.bus, paramObject, method)); 
    return (Multimap<Class<?>, Subscriber>)hashMultimap;
  }
  
  @VisibleForTesting
  static ImmutableSet<Class<?>> flattenHierarchy(Class<?> paramClass) {
    try {
      return (ImmutableSet)flattenHierarchyCache.getUnchecked(paramClass);
    } catch (UncheckedExecutionException uncheckedExecutionException) {
      throw Throwables.propagate(uncheckedExecutionException.getCause());
    } 
  }
  
  private static ImmutableList<Method> getAnnotatedMethods(Class<?> paramClass) {
    return (ImmutableList<Method>)subscriberMethodsCache.getUnchecked(paramClass);
  }
  
  private static ImmutableList<Method> getAnnotatedMethodsNotCached(Class<?> paramClass) {
    Set set = TypeToken.of(paramClass).getTypes().rawTypes();
    HashMap<MethodIdentifier, Method> hashMap = Maps.newHashMap();
    Iterator<Class<?>> iterator = set.iterator();
    while (iterator.hasNext()) {
      for (Method method : ((Class)iterator.next()).getDeclaredMethods()) {
        if (method.isAnnotationPresent((Class)Subscribe.class) && !method.isSynthetic()) {
          Class[] arrayOfClass = method.getParameterTypes();
          int i = arrayOfClass.length;
          boolean bool = true;
          if (i != 1)
            bool = false; 
          Preconditions.checkArgument(bool, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", method, arrayOfClass.length);
          MethodIdentifier methodIdentifier = new MethodIdentifier(method);
          if (!hashMap.containsKey(methodIdentifier))
            hashMap.put(methodIdentifier, method); 
        } 
      } 
    } 
    return ImmutableList.copyOf(hashMap.values());
  }
  
  Iterator<Subscriber> getSubscribers(Object paramObject) {
    ImmutableSet<Class<?>> immutableSet = flattenHierarchy(paramObject.getClass());
    paramObject = Lists.newArrayListWithCapacity(immutableSet.size());
    for (Class<?> clazz : immutableSet) {
      CopyOnWriteArraySet copyOnWriteArraySet = this.subscribers.get(clazz);
      if (copyOnWriteArraySet != null)
        paramObject.add(copyOnWriteArraySet.iterator()); 
    } 
    return Iterators.concat(paramObject.iterator());
  }
  
  @VisibleForTesting
  Set<Subscriber> getSubscribersForTesting(Class<?> paramClass) {
    return (Set<Subscriber>)MoreObjects.firstNonNull(this.subscribers.get(paramClass), ImmutableSet.of());
  }
  
  void register(Object paramObject) {
    for (Object paramObject : findAllSubscribers(paramObject).asMap().entrySet()) {
      Class<?> clazz = (Class)paramObject.getKey();
      Collection collection = (Collection)paramObject.getValue();
      CopyOnWriteArraySet copyOnWriteArraySet = this.subscribers.get(clazz);
      paramObject = copyOnWriteArraySet;
      if (copyOnWriteArraySet == null) {
        paramObject = new CopyOnWriteArraySet();
        paramObject = MoreObjects.firstNonNull(this.subscribers.putIfAbsent(clazz, paramObject), paramObject);
      } 
      paramObject.addAll(collection);
    } 
  }
  
  void unregister(Object paramObject) {
    Iterator<Map.Entry> iterator = findAllSubscribers(paramObject).asMap().entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Class clazz = (Class)entry.getKey();
      Collection<?> collection = (Collection)entry.getValue();
      CopyOnWriteArraySet copyOnWriteArraySet = this.subscribers.get(clazz);
      if (copyOnWriteArraySet != null && copyOnWriteArraySet.removeAll(collection))
        continue; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("missing event subscriber for an annotated method. Is ");
      stringBuilder.append(paramObject);
      stringBuilder.append(" registered?");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  private static final class MethodIdentifier {
    private final String name;
    
    private final List<Class<?>> parameterTypes;
    
    MethodIdentifier(Method param1Method) {
      this.name = param1Method.getName();
      this.parameterTypes = Arrays.asList(param1Method.getParameterTypes());
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof MethodIdentifier;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.name.equals(((MethodIdentifier)param1Object).name)) {
          bool = bool1;
          if (this.parameterTypes.equals(((MethodIdentifier)param1Object).parameterTypes))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.name, this.parameterTypes });
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\eventbus\SubscriberRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */