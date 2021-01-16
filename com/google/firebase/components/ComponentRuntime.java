package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class ComponentRuntime extends AbstractComponentContainer {
  private static final Provider<Set<Object>> EMPTY_PROVIDER = ComponentRuntime$$Lambda$5.lambdaFactory$();
  
  private final Map<Component<?>, Lazy<?>> components = new HashMap<Component<?>, Lazy<?>>();
  
  private final EventBus eventBus;
  
  private final Map<Class<?>, Lazy<?>> lazyInstanceMap = new HashMap<Class<?>, Lazy<?>>();
  
  private final Map<Class<?>, Lazy<Set<?>>> lazySetMap = new HashMap<Class<?>, Lazy<Set<?>>>();
  
  public ComponentRuntime(Executor paramExecutor, Iterable<ComponentRegistrar> paramIterable, Component<?>... paramVarArgs) {
    this.eventBus = new EventBus(paramExecutor);
    ArrayList<Component<?>> arrayList = new ArrayList();
    arrayList.add(Component.of(this.eventBus, EventBus.class, (Class<? super EventBus>[])new Class[] { Subscriber.class, Publisher.class }));
    Iterator<ComponentRegistrar> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.addAll(((ComponentRegistrar)iterator.next()).getComponents()); 
    Collections.addAll(arrayList, paramVarArgs);
    CycleDetector.detect(arrayList);
    for (Component<?> component : arrayList) {
      Lazy<?> lazy = new Lazy(ComponentRuntime$$Lambda$1.lambdaFactory$(this, component));
      this.components.put(component, lazy);
    } 
    processInstanceComponents();
    processSetComponents();
  }
  
  private void processInstanceComponents() {
    for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
      Component component = (Component)entry.getKey();
      if (!component.isValue())
        continue; 
      Lazy<?> lazy = (Lazy)entry.getValue();
      for (Class<?> clazz : (Iterable<Class<?>>)component.getProvidedInterfaces())
        this.lazyInstanceMap.put(clazz, lazy); 
    } 
    validateDependencies();
  }
  
  private void processSetComponents() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
      Component component = (Component)entry.getKey();
      if (component.isValue())
        continue; 
      Lazy lazy = (Lazy)entry.getValue();
      for (Class clazz : component.getProvidedInterfaces()) {
        if (!hashMap.containsKey(clazz))
          hashMap.put(clazz, new HashSet()); 
        ((Set<Lazy>)hashMap.get(clazz)).add(lazy);
      } 
    } 
    for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
      Set set = (Set)entry.getValue();
      this.lazySetMap.put((Class)entry.getKey(), new Lazy<Set<?>>(ComponentRuntime$$Lambda$4.lambdaFactory$(set)));
    } 
  }
  
  private void validateDependencies() {
    for (Component<?> component : this.components.keySet()) {
      for (Dependency dependency : component.getDependencies()) {
        if (!dependency.isRequired() || this.lazyInstanceMap.containsKey(dependency.getInterface()))
          continue; 
        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[] { component, dependency.getInterface() }));
      } 
    } 
  }
  
  public <T> Provider<T> getProvider(Class<T> paramClass) {
    Preconditions.checkNotNull(paramClass, "Null interface requested.");
    return (Provider<T>)this.lazyInstanceMap.get(paramClass);
  }
  
  public void initializeEagerComponents(boolean paramBoolean) {
    for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
      Component component = (Component)entry.getKey();
      Lazy lazy = (Lazy)entry.getValue();
      if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && paramBoolean))
        lazy.get(); 
    } 
    this.eventBus.enablePublishingAndFlushPending();
  }
  
  public <T> Provider<Set<T>> setOfProvider(Class<T> paramClass) {
    Lazy<Set<T>> lazy = (Lazy)this.lazySetMap.get(paramClass);
    return (Provider<Set<T>>)((lazy != null) ? lazy : EMPTY_PROVIDER);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\ComponentRuntime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */