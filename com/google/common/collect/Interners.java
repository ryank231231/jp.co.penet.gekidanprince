package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

@Beta
@GwtIncompatible
public final class Interners {
  public static <E> Function<E, E> asFunction(Interner<E> paramInterner) {
    return new InternerFunction<E>((Interner<E>)Preconditions.checkNotNull(paramInterner));
  }
  
  public static <E> Interner<E> newStrongInterner() {
    return new Interner<E>((new MapMaker()).makeMap()) {
        public E intern(E param1E) {
          E e = (E)map.putIfAbsent(Preconditions.checkNotNull(param1E), (Object)param1E);
          if (e != null)
            param1E = e; 
          return param1E;
        }
      };
  }
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public static <E> Interner<E> newWeakInterner() {
    return new WeakInterner<E>();
  }
  
  private static class InternerFunction<E> implements Function<E, E> {
    private final Interner<E> interner;
    
    public InternerFunction(Interner<E> param1Interner) {
      this.interner = param1Interner;
    }
    
    public E apply(E param1E) {
      return this.interner.intern(param1E);
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof InternerFunction) {
        param1Object = param1Object;
        return this.interner.equals(((InternerFunction)param1Object).interner);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.interner.hashCode();
    }
  }
  
  private static class WeakInterner<E> implements Interner<E> {
    private final MapMakerInternalMap<E, Dummy, ?, ?> map = (new MapMaker()).weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();
    
    private WeakInterner() {}
    
    public E intern(E param1E) {
      while (true) {
        Object object = this.map.getEntry(param1E);
        if (object != null) {
          object = object.getKey();
          if (object != null)
            return (E)object; 
        } 
        if ((Dummy)this.map.putIfAbsent(param1E, Dummy.VALUE) == null)
          return param1E; 
      } 
    }
    
    private enum Dummy {
      VALUE;
      
      static {
      
      }
    }
  }
  
  private enum Dummy {
    VALUE;
    
    static {
    
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Interners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */