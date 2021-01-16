package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

@GwtCompatible(emulated = true)
public final class CacheBuilder<K, V> {
  static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER;
  
  private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  
  private static final int DEFAULT_EXPIRATION_NANOS = 0;
  
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  
  private static final int DEFAULT_REFRESH_NANOS = 0;
  
  static final CacheStats EMPTY_STATS;
  
  static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {
        public void recordEviction() {}
        
        public void recordHits(int param1Int) {}
        
        public void recordLoadException(long param1Long) {}
        
        public void recordLoadSuccess(long param1Long) {}
        
        public void recordMisses(int param1Int) {}
        
        public CacheStats snapshot() {
          return CacheBuilder.EMPTY_STATS;
        }
      });
  
  static final Ticker NULL_TICKER;
  
  static final int UNSET_INT = -1;
  
  private static final Logger logger;
  
  int concurrencyLevel = -1;
  
  long expireAfterAccessNanos = -1L;
  
  long expireAfterWriteNanos = -1L;
  
  int initialCapacity = -1;
  
  Equivalence<Object> keyEquivalence;
  
  LocalCache.Strength keyStrength;
  
  long maximumSize = -1L;
  
  long maximumWeight = -1L;
  
  long refreshNanos = -1L;
  
  RemovalListener<? super K, ? super V> removalListener;
  
  Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
  
  boolean strictParsing = true;
  
  Ticker ticker;
  
  Equivalence<Object> valueEquivalence;
  
  LocalCache.Strength valueStrength;
  
  Weigher<? super K, ? super V> weigher;
  
  static {
    EMPTY_STATS = new CacheStats(0L, 0L, 0L, 0L, 0L, 0L);
    CACHE_STATS_COUNTER = new Supplier<AbstractCache.StatsCounter>() {
        public AbstractCache.StatsCounter get() {
          return new AbstractCache.SimpleStatsCounter();
        }
      };
    NULL_TICKER = new Ticker() {
        public long read() {
          return 0L;
        }
      };
    logger = Logger.getLogger(CacheBuilder.class.getName());
  }
  
  private void checkNonLoadingCache() {
    boolean bool;
    if (this.refreshNanos == -1L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "refreshAfterWrite requires a LoadingCache");
  }
  
  private void checkWeightWithWeigher() {
    Weigher<? super K, ? super V> weigher = this.weigher;
    boolean bool1 = true;
    boolean bool2 = true;
    if (weigher == null) {
      if (this.maximumWeight != -1L)
        bool2 = false; 
      Preconditions.checkState(bool2, "maximumWeight requires weigher");
    } else if (this.strictParsing) {
      if (this.maximumWeight != -1L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "weigher requires maximumWeight");
    } else if (this.maximumWeight == -1L) {
      logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
    } 
  }
  
  @GwtIncompatible
  public static CacheBuilder<Object, Object> from(CacheBuilderSpec paramCacheBuilderSpec) {
    return paramCacheBuilderSpec.toCacheBuilder().lenientParsing();
  }
  
  @GwtIncompatible
  public static CacheBuilder<Object, Object> from(String paramString) {
    return from(CacheBuilderSpec.parse(paramString));
  }
  
  public static CacheBuilder<Object, Object> newBuilder() {
    return new CacheBuilder<Object, Object>();
  }
  
  public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
    checkWeightWithWeigher();
    checkNonLoadingCache();
    return new LocalCache.LocalManualCache<K1, V1>(this);
  }
  
  public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> paramCacheLoader) {
    checkWeightWithWeigher();
    return new LocalCache.LocalLoadingCache<K1, V1>(this, paramCacheLoader);
  }
  
  public CacheBuilder<K, V> concurrencyLevel(int paramInt) {
    boolean bool2;
    int i = this.concurrencyLevel;
    boolean bool1 = true;
    if (i == -1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "concurrency level was already set to %s", this.concurrencyLevel);
    if (paramInt > 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    this.concurrencyLevel = paramInt;
    return this;
  }
  
  public CacheBuilder<K, V> expireAfterAccess(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool2;
    long l = this.expireAfterAccessNanos;
    boolean bool1 = true;
    if (l == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
    if (paramLong >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "duration cannot be negative: %s %s", paramLong, paramTimeUnit);
    this.expireAfterAccessNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public CacheBuilder<K, V> expireAfterWrite(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool2;
    long l = this.expireAfterWriteNanos;
    boolean bool1 = true;
    if (l == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
    if (paramLong >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "duration cannot be negative: %s %s", paramLong, paramTimeUnit);
    this.expireAfterWriteNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  int getConcurrencyLevel() {
    int i = this.concurrencyLevel;
    int j = i;
    if (i == -1)
      j = 4; 
    return j;
  }
  
  long getExpireAfterAccessNanos() {
    long l1 = this.expireAfterAccessNanos;
    long l2 = l1;
    if (l1 == -1L)
      l2 = 0L; 
    return l2;
  }
  
  long getExpireAfterWriteNanos() {
    long l1 = this.expireAfterWriteNanos;
    long l2 = l1;
    if (l1 == -1L)
      l2 = 0L; 
    return l2;
  }
  
  int getInitialCapacity() {
    int i = this.initialCapacity;
    int j = i;
    if (i == -1)
      j = 16; 
    return j;
  }
  
  Equivalence<Object> getKeyEquivalence() {
    return (Equivalence<Object>)MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
  }
  
  LocalCache.Strength getKeyStrength() {
    return (LocalCache.Strength)MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
  }
  
  long getMaximumWeight() {
    long l;
    if (this.expireAfterWriteNanos == 0L || this.expireAfterAccessNanos == 0L)
      return 0L; 
    if (this.weigher == null) {
      l = this.maximumSize;
    } else {
      l = this.maximumWeight;
    } 
    return l;
  }
  
  long getRefreshNanos() {
    long l1 = this.refreshNanos;
    long l2 = l1;
    if (l1 == -1L)
      l2 = 0L; 
    return l2;
  }
  
  <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
    return (RemovalListener<K1, V1>)MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
  }
  
  Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
    return this.statsCounterSupplier;
  }
  
  Ticker getTicker(boolean paramBoolean) {
    Ticker ticker = this.ticker;
    if (ticker != null)
      return ticker; 
    if (paramBoolean) {
      ticker = Ticker.systemTicker();
    } else {
      ticker = NULL_TICKER;
    } 
    return ticker;
  }
  
  Equivalence<Object> getValueEquivalence() {
    return (Equivalence<Object>)MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
  }
  
  LocalCache.Strength getValueStrength() {
    return (LocalCache.Strength)MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
  }
  
  <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
    return (Weigher<K1, V1>)MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
  }
  
  public CacheBuilder<K, V> initialCapacity(int paramInt) {
    boolean bool2;
    int i = this.initialCapacity;
    boolean bool1 = true;
    if (i == -1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "initial capacity was already set to %s", this.initialCapacity);
    if (paramInt >= 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2);
    this.initialCapacity = paramInt;
    return this;
  }
  
  boolean isRecordingStats() {
    boolean bool;
    if (this.statsCounterSupplier == CACHE_STATS_COUNTER) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @GwtIncompatible
  CacheBuilder<K, V> keyEquivalence(Equivalence<Object> paramEquivalence) {
    boolean bool;
    if (this.keyEquivalence == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "key equivalence was already set to %s", this.keyEquivalence);
    this.keyEquivalence = (Equivalence<Object>)Preconditions.checkNotNull(paramEquivalence);
    return this;
  }
  
  @GwtIncompatible
  CacheBuilder<K, V> lenientParsing() {
    this.strictParsing = false;
    return this;
  }
  
  public CacheBuilder<K, V> maximumSize(long paramLong) {
    boolean bool2;
    long l = this.maximumSize;
    boolean bool1 = true;
    if (l == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "maximum size was already set to %s", this.maximumSize);
    if (this.maximumWeight == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "maximum weight was already set to %s", this.maximumWeight);
    if (this.weigher == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "maximum size can not be combined with weigher");
    if (paramLong >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "maximum size must not be negative");
    this.maximumSize = paramLong;
    return this;
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> maximumWeight(long paramLong) {
    boolean bool2;
    long l = this.maximumWeight;
    boolean bool1 = true;
    if (l == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "maximum weight was already set to %s", this.maximumWeight);
    if (this.maximumSize == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "maximum size was already set to %s", this.maximumSize);
    this.maximumWeight = paramLong;
    if (paramLong >= 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "maximum weight must not be negative");
    return this;
  }
  
  public CacheBuilder<K, V> recordStats() {
    this.statsCounterSupplier = CACHE_STATS_COUNTER;
    return this;
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> refreshAfterWrite(long paramLong, TimeUnit paramTimeUnit) {
    boolean bool2;
    Preconditions.checkNotNull(paramTimeUnit);
    long l = this.refreshNanos;
    boolean bool1 = true;
    if (l == -1L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "refresh was already set to %s ns", this.refreshNanos);
    if (paramLong > 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "duration must be positive: %s %s", paramLong, paramTimeUnit);
    this.refreshNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  @CheckReturnValue
  public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> paramRemovalListener) {
    boolean bool;
    if (this.removalListener == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    this.removalListener = (RemovalListener<? super K, ? super V>)Preconditions.checkNotNull(paramRemovalListener);
    return this;
  }
  
  CacheBuilder<K, V> setKeyStrength(LocalCache.Strength paramStrength) {
    boolean bool;
    if (this.keyStrength == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Key strength was already set to %s", this.keyStrength);
    this.keyStrength = (LocalCache.Strength)Preconditions.checkNotNull(paramStrength);
    return this;
  }
  
  CacheBuilder<K, V> setValueStrength(LocalCache.Strength paramStrength) {
    boolean bool;
    if (this.valueStrength == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Value strength was already set to %s", this.valueStrength);
    this.valueStrength = (LocalCache.Strength)Preconditions.checkNotNull(paramStrength);
    return this;
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> softValues() {
    return setValueStrength(LocalCache.Strength.SOFT);
  }
  
  public CacheBuilder<K, V> ticker(Ticker paramTicker) {
    boolean bool;
    if (this.ticker == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    this.ticker = (Ticker)Preconditions.checkNotNull(paramTicker);
    return this;
  }
  
  public String toString() {
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    int i = this.initialCapacity;
    if (i != -1)
      toStringHelper.add("initialCapacity", i); 
    i = this.concurrencyLevel;
    if (i != -1)
      toStringHelper.add("concurrencyLevel", i); 
    long l = this.maximumSize;
    if (l != -1L)
      toStringHelper.add("maximumSize", l); 
    l = this.maximumWeight;
    if (l != -1L)
      toStringHelper.add("maximumWeight", l); 
    if (this.expireAfterWriteNanos != -1L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.expireAfterWriteNanos);
      stringBuilder.append("ns");
      toStringHelper.add("expireAfterWrite", stringBuilder.toString());
    } 
    if (this.expireAfterAccessNanos != -1L) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.expireAfterAccessNanos);
      stringBuilder.append("ns");
      toStringHelper.add("expireAfterAccess", stringBuilder.toString());
    } 
    LocalCache.Strength strength = this.keyStrength;
    if (strength != null)
      toStringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString())); 
    strength = this.valueStrength;
    if (strength != null)
      toStringHelper.add("valueStrength", Ascii.toLowerCase(strength.toString())); 
    if (this.keyEquivalence != null)
      toStringHelper.addValue("keyEquivalence"); 
    if (this.valueEquivalence != null)
      toStringHelper.addValue("valueEquivalence"); 
    if (this.removalListener != null)
      toStringHelper.addValue("removalListener"); 
    return toStringHelper.toString();
  }
  
  @GwtIncompatible
  CacheBuilder<K, V> valueEquivalence(Equivalence<Object> paramEquivalence) {
    boolean bool;
    if (this.valueEquivalence == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "value equivalence was already set to %s", this.valueEquivalence);
    this.valueEquivalence = (Equivalence<Object>)Preconditions.checkNotNull(paramEquivalence);
    return this;
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> weakKeys() {
    return setKeyStrength(LocalCache.Strength.WEAK);
  }
  
  @GwtIncompatible
  public CacheBuilder<K, V> weakValues() {
    return setValueStrength(LocalCache.Strength.WEAK);
  }
  
  @GwtIncompatible
  public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> paramWeigher) {
    boolean bool2;
    Weigher<? super K, ? super V> weigher = this.weigher;
    boolean bool1 = true;
    if (weigher == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    if (this.strictParsing) {
      if (this.maximumSize == -1L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkState(bool2, "weigher can not be combined with maximum size", this.maximumSize);
    } 
    this.weigher = (Weigher<? super K, ? super V>)Preconditions.checkNotNull(paramWeigher);
    return this;
  }
  
  enum NullListener implements RemovalListener<Object, Object> {
    INSTANCE;
    
    static {
    
    }
    
    public void onRemoval(RemovalNotification<Object, Object> param1RemovalNotification) {}
  }
  
  enum OneWeigher implements Weigher<Object, Object> {
    INSTANCE;
    
    static {
    
    }
    
    public int weigh(Object param1Object1, Object param1Object2) {
      return 1;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\CacheBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */