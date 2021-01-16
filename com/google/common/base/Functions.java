package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public final class Functions {
  public static <A, B, C> Function<A, C> compose(Function<B, C> paramFunction, Function<A, ? extends B> paramFunction1) {
    return new FunctionComposition<A, B, C>(paramFunction, paramFunction1);
  }
  
  public static <E> Function<Object, E> constant(@Nullable E paramE) {
    return new ConstantFunction<E>(paramE);
  }
  
  public static <K, V> Function<K, V> forMap(Map<K, V> paramMap) {
    return new FunctionForMapNoDefault<K, V>(paramMap);
  }
  
  public static <K, V> Function<K, V> forMap(Map<K, ? extends V> paramMap, @Nullable V paramV) {
    return new ForMapWithDefault<K, V>(paramMap, paramV);
  }
  
  public static <T> Function<T, Boolean> forPredicate(Predicate<T> paramPredicate) {
    return new PredicateFunction<T>(paramPredicate);
  }
  
  public static <T> Function<Object, T> forSupplier(Supplier<T> paramSupplier) {
    return new SupplierFunction<T>(paramSupplier);
  }
  
  public static <E> Function<E, E> identity() {
    return IdentityFunction.INSTANCE;
  }
  
  public static Function<Object, String> toStringFunction() {
    return ToStringFunction.INSTANCE;
  }
  
  private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final E value;
    
    public ConstantFunction(@Nullable E param1E) {
      this.value = param1E;
    }
    
    public E apply(@Nullable Object param1Object) {
      return this.value;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof ConstantFunction) {
        param1Object = param1Object;
        return Objects.equal(this.value, ((ConstantFunction)param1Object).value);
      } 
      return false;
    }
    
    public int hashCode() {
      int i;
      E e = this.value;
      if (e == null) {
        i = 0;
      } else {
        i = e.hashCode();
      } 
      return i;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.constant(");
      stringBuilder.append(this.value);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final V defaultValue;
    
    final Map<K, ? extends V> map;
    
    ForMapWithDefault(Map<K, ? extends V> param1Map, @Nullable V param1V) {
      this.map = Preconditions.<Map<K, ? extends V>>checkNotNull(param1Map);
      this.defaultValue = param1V;
    }
    
    public V apply(@Nullable K param1K) {
      V v1 = this.map.get(param1K);
      V v2 = v1;
      if (v1 == null)
        if (this.map.containsKey(param1K)) {
          V v = v1;
        } else {
          v2 = this.defaultValue;
        }  
      return v2;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof ForMapWithDefault;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.map.equals(((ForMapWithDefault)param1Object).map)) {
          bool = bool1;
          if (Objects.equal(this.defaultValue, ((ForMapWithDefault)param1Object).defaultValue))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.map, this.defaultValue });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forMap(");
      stringBuilder.append(this.map);
      stringBuilder.append(", defaultValue=");
      stringBuilder.append(this.defaultValue);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Function<A, ? extends B> f;
    
    private final Function<B, C> g;
    
    public FunctionComposition(Function<B, C> param1Function, Function<A, ? extends B> param1Function1) {
      this.g = Preconditions.<Function<B, C>>checkNotNull(param1Function);
      this.f = Preconditions.<Function<A, ? extends B>>checkNotNull(param1Function1);
    }
    
    public C apply(@Nullable A param1A) {
      return this.g.apply(this.f.apply(param1A));
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof FunctionComposition;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.f.equals(((FunctionComposition)param1Object).f)) {
          bool = bool1;
          if (this.g.equals(((FunctionComposition)param1Object).g))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.f.hashCode() ^ this.g.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.g);
      stringBuilder.append("(");
      stringBuilder.append(this.f);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Map<K, V> map;
    
    FunctionForMapNoDefault(Map<K, V> param1Map) {
      this.map = Preconditions.<Map<K, V>>checkNotNull(param1Map);
    }
    
    public V apply(@Nullable K param1K) {
      V v = this.map.get(param1K);
      if (v != null || this.map.containsKey(param1K)) {
        boolean bool1 = true;
        Preconditions.checkArgument(bool1, "Key '%s' not present in map", param1K);
        return v;
      } 
      boolean bool = false;
      Preconditions.checkArgument(bool, "Key '%s' not present in map", param1K);
      return v;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof FunctionForMapNoDefault) {
        param1Object = param1Object;
        return this.map.equals(((FunctionForMapNoDefault)param1Object).map);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.map.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forMap(");
      stringBuilder.append(this.map);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private enum IdentityFunction implements Function<Object, Object> {
    INSTANCE;
    
    static {
    
    }
    
    @Nullable
    public Object apply(@Nullable Object param1Object) {
      return param1Object;
    }
    
    public String toString() {
      return "Functions.identity()";
    }
  }
  
  private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Predicate<T> predicate;
    
    private PredicateFunction(Predicate<T> param1Predicate) {
      this.predicate = Preconditions.<Predicate<T>>checkNotNull(param1Predicate);
    }
    
    public Boolean apply(@Nullable T param1T) {
      return Boolean.valueOf(this.predicate.apply(param1T));
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof PredicateFunction) {
        param1Object = param1Object;
        return this.predicate.equals(((PredicateFunction)param1Object).predicate);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.predicate.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forPredicate(");
      stringBuilder.append(this.predicate);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class SupplierFunction<T> implements Function<Object, T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Supplier<T> supplier;
    
    private SupplierFunction(Supplier<T> param1Supplier) {
      this.supplier = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
    }
    
    public T apply(@Nullable Object param1Object) {
      return this.supplier.get();
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof SupplierFunction) {
        param1Object = param1Object;
        return this.supplier.equals(((SupplierFunction)param1Object).supplier);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.supplier.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Functions.forSupplier(");
      stringBuilder.append(this.supplier);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private enum ToStringFunction implements Function<Object, String> {
    INSTANCE;
    
    static {
    
    }
    
    public String apply(Object param1Object) {
      Preconditions.checkNotNull(param1Object);
      return param1Object.toString();
    }
    
    public String toString() {
      return "Functions.toStringFunction()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Functions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */