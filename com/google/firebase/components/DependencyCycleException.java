package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
public class DependencyCycleException extends DependencyException {
  private final List<Component<?>> componentsInCycle;
  
  @KeepForSdk
  public DependencyCycleException(List<Component<?>> paramList) {
    super(stringBuilder.toString());
    this.componentsInCycle = paramList;
  }
  
  @KeepForSdk
  public List<Component<?>> getComponentsInCycle() {
    return this.componentsInCycle;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\DependencyCycleException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */