package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible
public final class CacheStats {
  private final long evictionCount;
  
  private final long hitCount;
  
  private final long loadExceptionCount;
  
  private final long loadSuccessCount;
  
  private final long missCount;
  
  private final long totalLoadTime;
  
  public CacheStats(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
    boolean bool2;
    boolean bool1 = true;
    if (paramLong1 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong2 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong3 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong4 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong5 >= 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    if (paramLong6 >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    this.hitCount = paramLong1;
    this.missCount = paramLong2;
    this.loadSuccessCount = paramLong3;
    this.loadExceptionCount = paramLong4;
    this.totalLoadTime = paramLong5;
    this.evictionCount = paramLong6;
  }
  
  public double averageLoadPenalty() {
    double d;
    long l = this.loadSuccessCount + this.loadExceptionCount;
    if (l == 0L) {
      d = 0.0D;
    } else {
      double d1 = this.totalLoadTime;
      d = l;
      Double.isNaN(d1);
      Double.isNaN(d);
      d = d1 / d;
    } 
    return d;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof CacheStats;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.hitCount == ((CacheStats)paramObject).hitCount) {
        bool = bool1;
        if (this.missCount == ((CacheStats)paramObject).missCount) {
          bool = bool1;
          if (this.loadSuccessCount == ((CacheStats)paramObject).loadSuccessCount) {
            bool = bool1;
            if (this.loadExceptionCount == ((CacheStats)paramObject).loadExceptionCount) {
              bool = bool1;
              if (this.totalLoadTime == ((CacheStats)paramObject).totalLoadTime) {
                bool = bool1;
                if (this.evictionCount == ((CacheStats)paramObject).evictionCount)
                  bool = true; 
              } 
            } 
          } 
        } 
      } 
      return bool;
    } 
    return false;
  }
  
  public long evictionCount() {
    return this.evictionCount;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Long.valueOf(this.hitCount), Long.valueOf(this.missCount), Long.valueOf(this.loadSuccessCount), Long.valueOf(this.loadExceptionCount), Long.valueOf(this.totalLoadTime), Long.valueOf(this.evictionCount) });
  }
  
  public long hitCount() {
    return this.hitCount;
  }
  
  public double hitRate() {
    double d;
    long l = requestCount();
    if (l == 0L) {
      d = 1.0D;
    } else {
      double d1 = this.hitCount;
      d = l;
      Double.isNaN(d1);
      Double.isNaN(d);
      d = d1 / d;
    } 
    return d;
  }
  
  public long loadCount() {
    return this.loadSuccessCount + this.loadExceptionCount;
  }
  
  public long loadExceptionCount() {
    return this.loadExceptionCount;
  }
  
  public double loadExceptionRate() {
    double d;
    long l1 = this.loadSuccessCount;
    long l2 = this.loadExceptionCount;
    l1 += l2;
    if (l1 == 0L) {
      d = 0.0D;
    } else {
      d = l2;
      double d1 = l1;
      Double.isNaN(d);
      Double.isNaN(d1);
      d /= d1;
    } 
    return d;
  }
  
  public long loadSuccessCount() {
    return this.loadSuccessCount;
  }
  
  public CacheStats minus(CacheStats paramCacheStats) {
    return new CacheStats(Math.max(0L, this.hitCount - paramCacheStats.hitCount), Math.max(0L, this.missCount - paramCacheStats.missCount), Math.max(0L, this.loadSuccessCount - paramCacheStats.loadSuccessCount), Math.max(0L, this.loadExceptionCount - paramCacheStats.loadExceptionCount), Math.max(0L, this.totalLoadTime - paramCacheStats.totalLoadTime), Math.max(0L, this.evictionCount - paramCacheStats.evictionCount));
  }
  
  public long missCount() {
    return this.missCount;
  }
  
  public double missRate() {
    double d;
    long l = requestCount();
    if (l == 0L) {
      d = 0.0D;
    } else {
      double d1 = this.missCount;
      d = l;
      Double.isNaN(d1);
      Double.isNaN(d);
      d = d1 / d;
    } 
    return d;
  }
  
  public CacheStats plus(CacheStats paramCacheStats) {
    return new CacheStats(this.hitCount + paramCacheStats.hitCount, this.missCount + paramCacheStats.missCount, this.loadSuccessCount + paramCacheStats.loadSuccessCount, this.loadExceptionCount + paramCacheStats.loadExceptionCount, this.totalLoadTime + paramCacheStats.totalLoadTime, this.evictionCount + paramCacheStats.evictionCount);
  }
  
  public long requestCount() {
    return this.hitCount + this.missCount;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
  }
  
  public long totalLoadTime() {
    return this.totalLoadTime;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\CacheStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */