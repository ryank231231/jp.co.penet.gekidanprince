package io.opencensus.trace.unsafe;

import io.grpc.Context;
import io.opencensus.trace.Span;

public final class ContextUtils {
  public static final Context.Key<Span> CONTEXT_SPAN_KEY = Context.key("opencensus-trace-span-key");
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trac\\unsafe\ContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */