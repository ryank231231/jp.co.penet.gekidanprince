package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class CycleDetector {
  static void detect(List<Component<?>> paramList) {
    Set<ComponentNode> set1 = toGraph(paramList);
    Set<ComponentNode> set2 = getRoots(set1);
    int i = 0;
    label23: while (!set2.isEmpty()) {
      ComponentNode componentNode = set2.iterator().next();
      set2.remove(componentNode);
      int j = i + 1;
      Iterator<ComponentNode> iterator = componentNode.getDependencies().iterator();
      while (true) {
        i = j;
        if (iterator.hasNext()) {
          ComponentNode componentNode1 = iterator.next();
          componentNode1.removeDependent(componentNode);
          if (componentNode1.isRoot())
            set2.add(componentNode1); 
          continue;
        } 
        continue label23;
      } 
    } 
    if (i == paramList.size())
      return; 
    paramList = new ArrayList<Component<?>>();
    for (ComponentNode componentNode : set1) {
      if (!componentNode.isRoot() && !componentNode.isLeaf())
        paramList.add(componentNode.getComponent()); 
    } 
    throw new DependencyCycleException(paramList);
  }
  
  private static Set<ComponentNode> getRoots(Set<ComponentNode> paramSet) {
    HashSet<ComponentNode> hashSet = new HashSet();
    for (ComponentNode componentNode : paramSet) {
      if (componentNode.isRoot())
        hashSet.add(componentNode); 
    } 
    return hashSet;
  }
  
  private static Set<ComponentNode> toGraph(List<Component<?>> paramList) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(paramList.size());
    for (Component<?> component : paramList) {
      ComponentNode componentNode = new ComponentNode(component);
      for (Class<?> clazz : component.getProvidedInterfaces()) {
        Dep dep = new Dep(clazz, component.isValue() ^ true);
        if (!hashMap.containsKey(dep))
          hashMap.put(dep, new HashSet()); 
        Set<ComponentNode> set = (Set)hashMap.get(dep);
        if (set.isEmpty() || dep.set) {
          set.add(componentNode);
          continue;
        } 
        throw new IllegalArgumentException(String.format("Multiple components provide %s.", new Object[] { clazz }));
      } 
    } 
    Iterator<Set> iterator1 = hashMap.values().iterator();
    while (iterator1.hasNext()) {
      for (ComponentNode componentNode : iterator1.next()) {
        for (Dependency dependency : componentNode.getComponent().getDependencies()) {
          if (!dependency.isDirectInjection())
            continue; 
          Set set = (Set)hashMap.get(new Dep(dependency.getInterface(), dependency.isSet()));
          if (set == null)
            continue; 
          for (ComponentNode componentNode1 : set) {
            componentNode.addDependency(componentNode1);
            componentNode1.addDependent(componentNode);
          } 
        } 
      } 
    } 
    HashSet<ComponentNode> hashSet = new HashSet();
    Iterator<Set> iterator2 = hashMap.values().iterator();
    while (iterator2.hasNext())
      hashSet.addAll(iterator2.next()); 
    return hashSet;
  }
  
  private static class ComponentNode {
    private final Component<?> component;
    
    private final Set<ComponentNode> dependencies = new HashSet<ComponentNode>();
    
    private final Set<ComponentNode> dependents = new HashSet<ComponentNode>();
    
    ComponentNode(Component<?> param1Component) {
      this.component = param1Component;
    }
    
    void addDependency(ComponentNode param1ComponentNode) {
      this.dependencies.add(param1ComponentNode);
    }
    
    void addDependent(ComponentNode param1ComponentNode) {
      this.dependents.add(param1ComponentNode);
    }
    
    Component<?> getComponent() {
      return this.component;
    }
    
    Set<ComponentNode> getDependencies() {
      return this.dependencies;
    }
    
    boolean isLeaf() {
      return this.dependencies.isEmpty();
    }
    
    boolean isRoot() {
      return this.dependents.isEmpty();
    }
    
    void removeDependent(ComponentNode param1ComponentNode) {
      this.dependents.remove(param1ComponentNode);
    }
  }
  
  private static class Dep {
    private final Class<?> anInterface;
    
    private final boolean set;
    
    private Dep(Class<?> param1Class, boolean param1Boolean) {
      this.anInterface = param1Class;
      this.set = param1Boolean;
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof Dep;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (((Dep)param1Object).anInterface.equals(this.anInterface)) {
          bool = bool1;
          if (((Dep)param1Object).set == this.set)
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return (this.anInterface.hashCode() ^ 0xF4243) * 1000003 ^ Boolean.valueOf(this.set).hashCode();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\CycleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */