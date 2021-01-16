package io.grpc.internal;

import com.google.common.util.concurrent.ListenableFuture;

public interface Instrumented<T> extends WithLogId {
  ListenableFuture<T> getStats();
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\Instrumented.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */