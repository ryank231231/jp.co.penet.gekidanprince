package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@KeepForSdk
public final class Component<T> {
  private final Set<Dependency> dependencies;
  
  private final ComponentFactory<T> factory;
  
  private final int instantiation;
  
  private final Set<Class<? super T>> providedInterfaces;
  
  private final Set<Class<?>> publishedEvents;
  
  private final int type;
  
  private Component(Set<Class<? super T>> paramSet, Set<Dependency> paramSet1, int paramInt1, int paramInt2, ComponentFactory<T> paramComponentFactory, Set<Class<?>> paramSet2) {
    this.providedInterfaces = Collections.unmodifiableSet(paramSet);
    this.dependencies = Collections.unmodifiableSet(paramSet1);
    this.instantiation = paramInt1;
    this.type = paramInt2;
    this.factory = paramComponentFactory;
    this.publishedEvents = Collections.unmodifiableSet(paramSet2);
  }
  
  @KeepForSdk
  public static <T> Builder<T> builder(Class<T> paramClass) {
    return new Builder<T>(paramClass, new Class[0]);
  }
  
  @SafeVarargs
  @KeepForSdk
  public static <T> Builder<T> builder(Class<T> paramClass, Class<? super T>... paramVarArgs) {
    return new Builder<T>(paramClass, (Class[])paramVarArgs);
  }
  
  @KeepForSdk
  public static <T> Component<T> intoSet(T paramT, Class<T> paramClass) {
    return intoSetBuilder(paramClass).factory(Component$$Lambda$3.lambdaFactory$(paramT)).build();
  }
  
  @KeepForSdk
  public static <T> Builder<T> intoSetBuilder(Class<T> paramClass) {
    return builder(paramClass).intoSet();
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> Component<T> of(Class<T> paramClass, T paramT) {
    return builder(paramClass).factory(Component$$Lambda$1.lambdaFactory$(paramT)).build();
  }
  
  @SafeVarargs
  @KeepForSdk
  public static <T> Component<T> of(T paramT, Class<T> paramClass, Class<? super T>... paramVarArgs) {
    return builder(paramClass, paramVarArgs).factory(Component$$Lambda$2.lambdaFactory$(paramT)).build();
  }
  
  public Set<Dependency> getDependencies() {
    return this.dependencies;
  }
  
  public ComponentFactory<T> getFactory() {
    return this.factory;
  }
  
  public Set<Class<? super T>> getProvidedInterfaces() {
    return this.providedInterfaces;
  }
  
  public Set<Class<?>> getPublishedEvents() {
    return this.publishedEvents;
  }
  
  public boolean isAlwaysEager() {
    int i = this.instantiation;
    boolean bool = true;
    if (i != 1)
      bool = false; 
    return bool;
  }
  
  public boolean isEagerInDefaultApp() {
    boolean bool;
    if (this.instantiation == 2) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isLazy() {
    boolean bool;
    if (this.instantiation == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isValue() {
    boolean bool;
    if (this.type == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("Component<");
    stringBuilder.append(Arrays.toString(this.providedInterfaces.toArray()));
    stringBuilder.append(">{");
    stringBuilder.append(this.instantiation);
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", deps=");
    stringBuilder.append(Arrays.toString(this.dependencies.toArray()));
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  @KeepForSdk
  public static class Builder<T> {
    private final Set<Dependency> dependencies = new HashSet<Dependency>();
    
    private ComponentFactory<T> factory;
    
    private int instantiation;
    
    private final Set<Class<? super T>> providedInterfaces = new HashSet<Class<? super T>>();
    
    private Set<Class<?>> publishedEvents;
    
    private int type;
    
    @SafeVarargs
    private Builder(Class<T> param1Class, Class<? super T>... param1VarArgs) {
      byte b = 0;
      this.instantiation = 0;
      this.type = 0;
      this.publishedEvents = new HashSet<Class<?>>();
      Preconditions.checkNotNull(param1Class, "Null interface");
      this.providedInterfaces.add(param1Class);
      int i = param1VarArgs.length;
      while (b < i) {
        Preconditions.checkNotNull(param1VarArgs[b], "Null interface");
        b++;
      } 
      Collections.addAll(this.providedInterfaces, param1VarArgs);
    }
    
    private Builder<T> intoSet() {
      this.type = 1;
      return this;
    }
    
    private Builder<T> setInstantiation(int param1Int) {
      boolean bool;
      if (this.instantiation == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Instantiation type has already been set.");
      this.instantiation = param1Int;
      return this;
    }
    
    private void validateInterface(Class<?> param1Class) {
      Preconditions.checkArgument(this.providedInterfaces.contains(param1Class) ^ true, "Components are not allowed to depend on interfaces they themselves provide.");
    }
    
    @KeepForSdk
    public Builder<T> add(Dependency param1Dependency) {
      Preconditions.checkNotNull(param1Dependency, "Null dependency");
      validateInterface(param1Dependency.getInterface());
      this.dependencies.add(param1Dependency);
      return this;
    }
    
    @KeepForSdk
    public Builder<T> alwaysEager() {
      return setInstantiation(1);
    }
    
    @KeepForSdk
    public Component<T> build() {
      boolean bool;
      if (this.factory != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Missing required property: factory.");
      return new Component<T>(new HashSet<Class<? super T>>(this.providedInterfaces), new HashSet<Dependency>(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
    }
    
    @KeepForSdk
    public Builder<T> eagerInDefaultApp() {
      return setInstantiation(2);
    }
    
    @KeepForSdk
    public Builder<T> factory(ComponentFactory<T> param1ComponentFactory) {
      this.factory = (ComponentFactory<T>)Preconditions.checkNotNull(param1ComponentFactory, "Null factory");
      return this;
    }
    
    @KeepForSdk
    public Builder<T> publishes(Class<?> param1Class) {
      this.publishedEvents.add(param1Class);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\Component.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */