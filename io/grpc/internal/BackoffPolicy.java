package io.grpc.internal;

interface BackoffPolicy {
  long nextBackoffNanos();
  
  public static interface Provider {
    BackoffPolicy get();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\BackoffPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */