package io.opencensus.internal;

import io.opencensus.common.Scope;

public final class NoopScope implements Scope {
  private static final Scope INSTANCE = new NoopScope();
  
  public static Scope getInstance() {
    return INSTANCE;
  }
  
  public void close() {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\internal\NoopScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */