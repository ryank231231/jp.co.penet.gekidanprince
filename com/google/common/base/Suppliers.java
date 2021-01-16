package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible
public final class Suppliers {
  public static <F, T> Supplier<T> compose(Function<? super F, T> paramFunction, Supplier<F> paramSupplier) {
    Preconditions.checkNotNull(paramFunction);
    Preconditions.checkNotNull(paramSupplier);
    return new SupplierComposition<F, T>(paramFunction, paramSupplier);
  }
  
  public static <T> Supplier<T> memoize(Supplier<T> paramSupplier) {
    if (!(paramSupplier instanceof MemoizingSupplier))
      paramSupplier = new MemoizingSupplier<T>(Preconditions.<Supplier<T>>checkNotNull(paramSupplier)); 
    return paramSupplier;
  }
  
  public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> paramSupplier, long paramLong, TimeUnit paramTimeUnit) {
    return new ExpiringMemoizingSupplier<T>(paramSupplier, paramLong, paramTimeUnit);
  }
  
  public static <T> Supplier<T> ofInstance(@Nullable T paramT) {
    return new SupplierOfInstance<T>(paramT);
  }
  
  public static <T> Function<Supplier<T>, T> supplierFunction() {
    return SupplierFunctionImpl.INSTANCE;
  }
  
  public static <T> Supplier<T> synchronizedSupplier(Supplier<T> paramSupplier) {
    return new ThreadSafeSupplier<T>(Preconditions.<Supplier<T>>checkNotNull(paramSupplier));
  }
  
  @VisibleForTesting
  static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Supplier<T> delegate;
    
    final long durationNanos;
    
    volatile transient long expirationNanos;
    
    volatile transient T value;
    
    ExpiringMemoizingSupplier(Supplier<T> param1Supplier, long param1Long, TimeUnit param1TimeUnit) {
      boolean bool;
      this.delegate = Preconditions.<Supplier<T>>checkNotNull(param1Supplier);
      this.durationNanos = param1TimeUnit.toNanos(param1Long);
      if (param1Long > 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
    }
    
    public T get() {
      // Byte code:
      //   0: aload_0
      //   1: getfield expirationNanos : J
      //   4: lstore_1
      //   5: invokestatic systemNanoTime : ()J
      //   8: lstore_3
      //   9: lload_1
      //   10: lconst_0
      //   11: lcmp
      //   12: ifeq -> 23
      //   15: lload_3
      //   16: lload_1
      //   17: lsub
      //   18: lconst_0
      //   19: lcmp
      //   20: iflt -> 80
      //   23: aload_0
      //   24: monitorenter
      //   25: lload_1
      //   26: aload_0
      //   27: getfield expirationNanos : J
      //   30: lcmp
      //   31: ifne -> 78
      //   34: aload_0
      //   35: getfield delegate : Lcom/google/common/base/Supplier;
      //   38: invokeinterface get : ()Ljava/lang/Object;
      //   43: astore #5
      //   45: aload_0
      //   46: aload #5
      //   48: putfield value : Ljava/lang/Object;
      //   51: lload_3
      //   52: aload_0
      //   53: getfield durationNanos : J
      //   56: ladd
      //   57: lstore_3
      //   58: lload_3
      //   59: lstore_1
      //   60: lload_3
      //   61: lconst_0
      //   62: lcmp
      //   63: ifne -> 68
      //   66: lconst_1
      //   67: lstore_1
      //   68: aload_0
      //   69: lload_1
      //   70: putfield expirationNanos : J
      //   73: aload_0
      //   74: monitorexit
      //   75: aload #5
      //   77: areturn
      //   78: aload_0
      //   79: monitorexit
      //   80: aload_0
      //   81: getfield value : Ljava/lang/Object;
      //   84: areturn
      //   85: astore #5
      //   87: aload_0
      //   88: monitorexit
      //   89: aload #5
      //   91: athrow
      // Exception table:
      //   from	to	target	type
      //   25	58	85	finally
      //   68	75	85	finally
      //   78	80	85	finally
      //   87	89	85	finally
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.memoizeWithExpiration(");
      stringBuilder.append(this.delegate);
      stringBuilder.append(", ");
      stringBuilder.append(this.durationNanos);
      stringBuilder.append(", NANOS)");
      return stringBuilder.toString();
    }
  }
  
  @VisibleForTesting
  static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Supplier<T> delegate;
    
    volatile transient boolean initialized;
    
    transient T value;
    
    MemoizingSupplier(Supplier<T> param1Supplier) {
      this.delegate = param1Supplier;
    }
    
    public T get() {
      // Byte code:
      //   0: aload_0
      //   1: getfield initialized : Z
      //   4: ifne -> 50
      //   7: aload_0
      //   8: monitorenter
      //   9: aload_0
      //   10: getfield initialized : Z
      //   13: ifne -> 40
      //   16: aload_0
      //   17: getfield delegate : Lcom/google/common/base/Supplier;
      //   20: invokeinterface get : ()Ljava/lang/Object;
      //   25: astore_1
      //   26: aload_0
      //   27: aload_1
      //   28: putfield value : Ljava/lang/Object;
      //   31: aload_0
      //   32: iconst_1
      //   33: putfield initialized : Z
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: areturn
      //   40: aload_0
      //   41: monitorexit
      //   42: goto -> 50
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      //   50: aload_0
      //   51: getfield value : Ljava/lang/Object;
      //   54: areturn
      // Exception table:
      //   from	to	target	type
      //   9	38	45	finally
      //   40	42	45	finally
      //   46	48	45	finally
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.memoize(");
      stringBuilder.append(this.delegate);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Function<? super F, T> function;
    
    final Supplier<F> supplier;
    
    SupplierComposition(Function<? super F, T> param1Function, Supplier<F> param1Supplier) {
      this.function = param1Function;
      this.supplier = param1Supplier;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof SupplierComposition;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.function.equals(((SupplierComposition)param1Object).function)) {
          bool = bool1;
          if (this.supplier.equals(((SupplierComposition)param1Object).supplier))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public T get() {
      return this.function.apply(this.supplier.get());
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.function, this.supplier });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.compose(");
      stringBuilder.append(this.function);
      stringBuilder.append(", ");
      stringBuilder.append(this.supplier);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static interface SupplierFunction<T> extends Function<Supplier<T>, T> {}
  
  private enum SupplierFunctionImpl implements SupplierFunction<Object> {
    INSTANCE;
    
    static {
    
    }
    
    public Object apply(Supplier<Object> param1Supplier) {
      return param1Supplier.get();
    }
    
    public String toString() {
      return "Suppliers.supplierFunction()";
    }
  }
  
  private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final T instance;
    
    SupplierOfInstance(@Nullable T param1T) {
      this.instance = param1T;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof SupplierOfInstance) {
        param1Object = param1Object;
        return Objects.equal(this.instance, ((SupplierOfInstance)param1Object).instance);
      } 
      return false;
    }
    
    public T get() {
      return this.instance;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.instance });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.ofInstance(");
      stringBuilder.append(this.instance);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Supplier<T> delegate;
    
    ThreadSafeSupplier(Supplier<T> param1Supplier) {
      this.delegate = param1Supplier;
    }
    
    public T get() {
      synchronized (this.delegate) {
        return this.delegate.get();
      } 
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Suppliers.synchronizedSupplier(");
      stringBuilder.append(this.delegate);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Suppliers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */