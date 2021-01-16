package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import io.grpc.Status;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

@Immutable
final class RetryPolicy {
  static final RetryPolicy DEFAULT = new RetryPolicy(1, 0L, 0L, 1.0D, Collections.emptySet());
  
  final double backoffMultiplier;
  
  final long initialBackoffNanos;
  
  final int maxAttempts;
  
  final long maxBackoffNanos;
  
  final Set<Status.Code> retryableStatusCodes;
  
  RetryPolicy(int paramInt, long paramLong1, long paramLong2, double paramDouble, @Nonnull Set<Status.Code> paramSet) {
    this.maxAttempts = paramInt;
    this.initialBackoffNanos = paramLong1;
    this.maxBackoffNanos = paramLong2;
    this.backoffMultiplier = paramDouble;
    this.retryableStatusCodes = (Set<Status.Code>)ImmutableSet.copyOf(paramSet);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof RetryPolicy;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (this.maxAttempts == ((RetryPolicy)paramObject).maxAttempts) {
      bool = bool1;
      if (this.initialBackoffNanos == ((RetryPolicy)paramObject).initialBackoffNanos) {
        bool = bool1;
        if (this.maxBackoffNanos == ((RetryPolicy)paramObject).maxBackoffNanos) {
          bool = bool1;
          if (Double.compare(this.backoffMultiplier, ((RetryPolicy)paramObject).backoffMultiplier) == 0) {
            bool = bool1;
            if (Objects.equal(this.retryableStatusCodes, ((RetryPolicy)paramObject).retryableStatusCodes))
              bool = true; 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.maxAttempts), Long.valueOf(this.initialBackoffNanos), Long.valueOf(this.maxBackoffNanos), Double.valueOf(this.backoffMultiplier), this.retryableStatusCodes });
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("maxAttempts", this.maxAttempts).add("initialBackoffNanos", this.initialBackoffNanos).add("maxBackoffNanos", this.maxBackoffNanos).add("backoffMultiplier", this.backoffMultiplier).add("retryableStatusCodes", this.retryableStatusCodes).toString();
  }
  
  static interface Provider {
    @Nonnull
    RetryPolicy get();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\RetryPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */