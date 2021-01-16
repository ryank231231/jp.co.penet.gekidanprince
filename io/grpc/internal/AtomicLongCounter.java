package io.grpc.internal;

import java.util.concurrent.atomic.AtomicLong;

final class AtomicLongCounter implements LongCounter {
  private final AtomicLong counter = new AtomicLong();
  
  public void add(long paramLong) {
    this.counter.getAndAdd(paramLong);
  }
  
  public long value() {
    return this.counter.get();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AtomicLongCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */