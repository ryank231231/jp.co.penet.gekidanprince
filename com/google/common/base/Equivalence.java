package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Equivalence<T> {
  public static Equivalence<Object> equals() {
    return Equals.INSTANCE;
  }
  
  public static Equivalence<Object> identity() {
    return Identity.INSTANCE;
  }
  
  protected abstract boolean doEquivalent(T paramT1, T paramT2);
  
  protected abstract int doHash(T paramT);
  
  public final boolean equivalent(@Nullable T paramT1, @Nullable T paramT2) {
    return (paramT1 == paramT2) ? true : ((paramT1 == null || paramT2 == null) ? false : doEquivalent(paramT1, paramT2));
  }
  
  public final Predicate<T> equivalentTo(@Nullable T paramT) {
    return new EquivalentToPredicate<T>(this, paramT);
  }
  
  public final int hash(@Nullable T paramT) {
    return (paramT == null) ? 0 : doHash(paramT);
  }
  
  public final <F> Equivalence<F> onResultOf(Function<F, ? extends T> paramFunction) {
    return new FunctionalEquivalence<F, T>(paramFunction, this);
  }
  
  @GwtCompatible(serializable = true)
  public final <S extends T> Equivalence<Iterable<S>> pairwise() {
    return new PairwiseEquivalence<S>(this);
  }
  
  public final <S extends T> Wrapper<S> wrap(@Nullable S paramS) {
    return new Wrapper<S>(this, paramS);
  }
  
  static final class Equals extends Equivalence<Object> implements Serializable {
    static final Equals INSTANCE = new Equals();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected boolean doEquivalent(Object param1Object1, Object param1Object2) {
      return param1Object1.equals(param1Object2);
    }
    
    protected int doHash(Object param1Object) {
      return param1Object.hashCode();
    }
  }
  
  private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Equivalence<T> equivalence;
    
    @Nullable
    private final T target;
    
    EquivalentToPredicate(Equivalence<T> param1Equivalence, @Nullable T param1T) {
      this.equivalence = Preconditions.<Equivalence<T>>checkNotNull(param1Equivalence);
      this.target = param1T;
    }
    
    public boolean apply(@Nullable T param1T) {
      return this.equivalence.equivalent(param1T, this.target);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = true;
      if (this == param1Object)
        return true; 
      if (param1Object instanceof EquivalentToPredicate) {
        param1Object = param1Object;
        if (!this.equivalence.equals(((EquivalentToPredicate)param1Object).equivalence) || !Objects.equal(this.target, ((EquivalentToPredicate)param1Object).target))
          bool = false; 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.equivalence, this.target });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.equivalence);
      stringBuilder.append(".equivalentTo(");
      stringBuilder.append(this.target);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class Identity extends Equivalence<Object> implements Serializable {
    static final Identity INSTANCE = new Identity();
    
    private static final long serialVersionUID = 1L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    protected boolean doEquivalent(Object param1Object1, Object param1Object2) {
      return false;
    }
    
    protected int doHash(Object param1Object) {
      return System.identityHashCode(param1Object);
    }
  }
  
  public static final class Wrapper<T> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Equivalence<? super T> equivalence;
    
    @Nullable
    private final T reference;
    
    private Wrapper(Equivalence<? super T> param1Equivalence, @Nullable T param1T) {
      this.equivalence = Preconditions.<Equivalence<? super T>>checkNotNull(param1Equivalence);
      this.reference = param1T;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object == this)
        return true; 
      if (param1Object instanceof Wrapper) {
        param1Object = param1Object;
        if (this.equivalence.equals(((Wrapper)param1Object).equivalence))
          return this.equivalence.equivalent(this.reference, ((Wrapper)param1Object).reference); 
      } 
      return false;
    }
    
    @Nullable
    public T get() {
      return this.reference;
    }
    
    public int hashCode() {
      return this.equivalence.hash(this.reference);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.equivalence);
      stringBuilder.append(".wrap(");
      stringBuilder.append(this.reference);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Equivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */