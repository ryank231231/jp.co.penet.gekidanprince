package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class RestrictedComponentContainer extends AbstractComponentContainer {
  private final Set<Class<?>> allowedDirectInterfaces;
  
  private final Set<Class<?>> allowedProviderInterfaces;
  
  private final Set<Class<?>> allowedPublishedEvents;
  
  private final Set<Class<?>> allowedSetDirectInterfaces;
  
  private final Set<Class<?>> allowedSetProviderInterfaces;
  
  private final ComponentContainer delegateContainer;
  
  RestrictedComponentContainer(Component<?> paramComponent, ComponentContainer paramComponentContainer) {
    HashSet<Class<?>> hashSet1 = new HashSet();
    HashSet<Class<?>> hashSet2 = new HashSet();
    HashSet<Class<?>> hashSet3 = new HashSet();
    HashSet<Class<?>> hashSet4 = new HashSet();
    for (Dependency dependency : paramComponent.getDependencies()) {
      if (dependency.isDirectInjection()) {
        if (dependency.isSet()) {
          hashSet3.add(dependency.getInterface());
          continue;
        } 
        hashSet1.add(dependency.getInterface());
        continue;
      } 
      if (dependency.isSet()) {
        hashSet4.add(dependency.getInterface());
        continue;
      } 
      hashSet2.add(dependency.getInterface());
    } 
    if (!paramComponent.getPublishedEvents().isEmpty())
      hashSet1.add(Publisher.class); 
    this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet1);
    this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
    this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet3);
    this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet4);
    this.allowedPublishedEvents = paramComponent.getPublishedEvents();
    this.delegateContainer = paramComponentContainer;
  }
  
  public <T> T get(Class<T> paramClass) {
    if (this.allowedDirectInterfaces.contains(paramClass)) {
      T t = (T)this.delegateContainer.get((Class)paramClass);
      return (T)(!paramClass.equals(Publisher.class) ? (Object)t : new RestrictedPublisher(this.allowedPublishedEvents, (Publisher)t));
    } 
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", new Object[] { paramClass }));
  }
  
  public <T> Provider<T> getProvider(Class<T> paramClass) {
    if (this.allowedProviderInterfaces.contains(paramClass))
      return this.delegateContainer.getProvider(paramClass); 
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Set<T> setOf(Class<T> paramClass) {
    if (this.allowedSetDirectInterfaces.contains(paramClass))
      return this.delegateContainer.setOf(paramClass); 
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", new Object[] { paramClass }));
  }
  
  public <T> Provider<Set<T>> setOfProvider(Class<T> paramClass) {
    if (this.allowedSetProviderInterfaces.contains(paramClass))
      return this.delegateContainer.setOfProvider(paramClass); 
    throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", new Object[] { paramClass }));
  }
  
  private static class RestrictedPublisher implements Publisher {
    private final Set<Class<?>> allowedPublishedEvents;
    
    private final Publisher delegate;
    
    public RestrictedPublisher(Set<Class<?>> param1Set, Publisher param1Publisher) {
      this.allowedPublishedEvents = param1Set;
      this.delegate = param1Publisher;
    }
    
    public void publish(Event<?> param1Event) {
      if (this.allowedPublishedEvents.contains(param1Event.getType())) {
        this.delegate.publish(param1Event);
        return;
      } 
      throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", new Object[] { param1Event }));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\RestrictedComponentContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */