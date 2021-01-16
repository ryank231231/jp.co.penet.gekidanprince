package io.grpc.internal;

import java.util.HashSet;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class InUseStateAggregator<T> {
  private final HashSet<T> inUseObjects = new HashSet<T>();
  
  abstract void handleInUse();
  
  abstract void handleNotInUse();
  
  final boolean isInUse() {
    return this.inUseObjects.isEmpty() ^ true;
  }
  
  final void updateObjectInUse(T paramT, boolean paramBoolean) {
    int i = this.inUseObjects.size();
    if (paramBoolean) {
      this.inUseObjects.add(paramT);
      if (i == 0)
        handleInUse(); 
    } else if (this.inUseObjects.remove(paramT) && i == 1) {
      handleNotInUse();
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\InUseStateAggregator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */