package io.opencensus.common;

public final class Functions {
  private static final Function<Object, Void> RETURN_NULL = new Function<Object, Void>() {
      public Void apply(Object param1Object) {
        return null;
      }
    };
  
  private static final Function<Object, Void> THROW_ASSERTION_ERROR;
  
  private static final Function<Object, Void> THROW_ILLEGAL_ARGUMENT_EXCEPTION = new Function<Object, Void>() {
      public Void apply(Object param1Object) {
        throw new IllegalArgumentException();
      }
    };
  
  static {
    THROW_ASSERTION_ERROR = new Function<Object, Void>() {
        public Void apply(Object param1Object) {
          throw new AssertionError();
        }
      };
  }
  
  public static <T> Function<Object, T> returnConstant(final T constant) {
    return new Function<Object, T>() {
        public T apply(Object param1Object) {
          return (T)constant;
        }
      };
  }
  
  public static <T> Function<Object, T> returnNull() {
    return (Function)RETURN_NULL;
  }
  
  public static <T> Function<Object, T> throwAssertionError() {
    return (Function)THROW_ASSERTION_ERROR;
  }
  
  public static <T> Function<Object, T> throwIllegalArgumentException() {
    return (Function)THROW_ILLEGAL_ARGUMENT_EXCEPTION;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\common\Functions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */