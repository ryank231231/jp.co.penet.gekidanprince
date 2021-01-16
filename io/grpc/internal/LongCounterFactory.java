package io.grpc.internal;

final class LongCounterFactory {
  public static LongCounter create() {
    return (LongCounter)(ReflectionLongAdderCounter.isAvailable() ? new ReflectionLongAdderCounter() : new AtomicLongCounter());
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\LongCounterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */