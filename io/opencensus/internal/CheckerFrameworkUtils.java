package io.opencensus.internal;

import io.opencensus.common.Function;

public final class CheckerFrameworkUtils {
  public static <A, B> Function<A, B> removeSuperFromFunctionParameterType(Function<? super A, B> paramFunction) {
    return (Function)paramFunction;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\internal\CheckerFrameworkUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */