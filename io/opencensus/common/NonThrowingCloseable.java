package io.opencensus.common;

import java.io.Closeable;

@Deprecated
public interface NonThrowingCloseable extends Closeable {
  void close();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\common\NonThrowingCloseable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */