package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtIncompatible
public final class CacheBuilderSpec {
  private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
  
  private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
  
  private static final ImmutableMap<String, ValueParser> VALUE_PARSERS = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser()).put("weakKeys", new KeyStrengthParser(LocalCache.Strength.WEAK)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(LocalCache.Strength.WEAK)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
  
  @VisibleForTesting
  long accessExpirationDuration;
  
  @VisibleForTesting
  TimeUnit accessExpirationTimeUnit;
  
  @VisibleForTesting
  Integer concurrencyLevel;
  
  @VisibleForTesting
  Integer initialCapacity;
  
  @VisibleForTesting
  LocalCache.Strength keyStrength;
  
  @VisibleForTesting
  Long maximumSize;
  
  @VisibleForTesting
  Long maximumWeight;
  
  @VisibleForTesting
  Boolean recordStats;
  
  @VisibleForTesting
  long refreshDuration;
  
  @VisibleForTesting
  TimeUnit refreshTimeUnit;
  
  private final String specification;
  
  @VisibleForTesting
  LocalCache.Strength valueStrength;
  
  @VisibleForTesting
  long writeExpirationDuration;
  
  @VisibleForTesting
  TimeUnit writeExpirationTimeUnit;
  
  private CacheBuilderSpec(String paramString) {
    this.specification = paramString;
  }
  
  public static CacheBuilderSpec disableCaching() {
    return parse("maximumSize=0");
  }
  
  @Nullable
  private static Long durationInNanos(long paramLong, @Nullable TimeUnit paramTimeUnit) {
    Long long_;
    if (paramTimeUnit == null) {
      paramTimeUnit = null;
    } else {
      long_ = Long.valueOf(paramTimeUnit.toNanos(paramLong));
    } 
    return long_;
  }
  
  private static String format(String paramString, Object... paramVarArgs) {
    return String.format(Locale.ROOT, paramString, paramVarArgs);
  }
  
  public static CacheBuilderSpec parse(String paramString) {
    CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(paramString);
    if (!paramString.isEmpty())
      for (String str2 : KEYS_SPLITTER.split(paramString)) {
        String str1;
        ImmutableList<String> immutableList = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(str2));
        Preconditions.checkArgument(immutableList.isEmpty() ^ true, "blank key-value pair");
        int i = immutableList.size();
        boolean bool1 = false;
        if (i <= 2) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        Preconditions.checkArgument(bool2, "key-value pair %s with more than one equals sign", str2);
        str2 = immutableList.get(0);
        ValueParser valueParser = (ValueParser)VALUE_PARSERS.get(str2);
        boolean bool2 = bool1;
        if (valueParser != null)
          bool2 = true; 
        Preconditions.checkArgument(bool2, "unknown key %s", str2);
        if (immutableList.size() == 1) {
          immutableList = null;
        } else {
          str1 = immutableList.get(1);
        } 
        valueParser.parse(cacheBuilderSpec, str2, str1);
      }  
    return cacheBuilderSpec;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof CacheBuilderSpec))
      return false; 
    paramObject = paramObject;
    if (!Objects.equal(this.initialCapacity, ((CacheBuilderSpec)paramObject).initialCapacity) || !Objects.equal(this.maximumSize, ((CacheBuilderSpec)paramObject).maximumSize) || !Objects.equal(this.maximumWeight, ((CacheBuilderSpec)paramObject).maximumWeight) || !Objects.equal(this.concurrencyLevel, ((CacheBuilderSpec)paramObject).concurrencyLevel) || !Objects.equal(this.keyStrength, ((CacheBuilderSpec)paramObject).keyStrength) || !Objects.equal(this.valueStrength, ((CacheBuilderSpec)paramObject).valueStrength) || !Objects.equal(this.recordStats, ((CacheBuilderSpec)paramObject).recordStats) || !Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(((CacheBuilderSpec)paramObject).writeExpirationDuration, ((CacheBuilderSpec)paramObject).writeExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(((CacheBuilderSpec)paramObject).accessExpirationDuration, ((CacheBuilderSpec)paramObject).accessExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(((CacheBuilderSpec)paramObject).refreshDuration, ((CacheBuilderSpec)paramObject).refreshTimeUnit)))
      bool = false; 
    return bool;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit) });
  }
  
  CacheBuilder<Object, Object> toCacheBuilder() {
    CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder();
    Integer integer2 = this.initialCapacity;
    if (integer2 != null)
      cacheBuilder.initialCapacity(integer2.intValue()); 
    Long long_ = this.maximumSize;
    if (long_ != null)
      cacheBuilder.maximumSize(long_.longValue()); 
    long_ = this.maximumWeight;
    if (long_ != null)
      cacheBuilder.maximumWeight(long_.longValue()); 
    Integer integer1 = this.concurrencyLevel;
    if (integer1 != null)
      cacheBuilder.concurrencyLevel(integer1.intValue()); 
    if (this.keyStrength != null)
      if (null.$SwitchMap$com$google$common$cache$LocalCache$Strength[this.keyStrength.ordinal()] == 1) {
        cacheBuilder.weakKeys();
      } else {
        throw new AssertionError();
      }  
    if (this.valueStrength != null)
      switch (this.valueStrength) {
        default:
          throw new AssertionError();
        case SOFT:
          cacheBuilder.softValues();
          break;
        case WEAK:
          cacheBuilder.weakValues();
          break;
      }  
    Boolean bool = this.recordStats;
    if (bool != null && bool.booleanValue())
      cacheBuilder.recordStats(); 
    TimeUnit timeUnit = this.writeExpirationTimeUnit;
    if (timeUnit != null)
      cacheBuilder.expireAfterWrite(this.writeExpirationDuration, timeUnit); 
    timeUnit = this.accessExpirationTimeUnit;
    if (timeUnit != null)
      cacheBuilder.expireAfterAccess(this.accessExpirationDuration, timeUnit); 
    timeUnit = this.refreshTimeUnit;
    if (timeUnit != null)
      cacheBuilder.refreshAfterWrite(this.refreshDuration, timeUnit); 
    return cacheBuilder;
  }
  
  public String toParsableString() {
    return this.specification;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).addValue(toParsableString()).toString();
  }
  
  static class AccessDurationParser extends DurationParser {
    protected void parseDuration(CacheBuilderSpec param1CacheBuilderSpec, long param1Long, TimeUnit param1TimeUnit) {
      boolean bool;
      if (param1CacheBuilderSpec.accessExpirationTimeUnit == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "expireAfterAccess already set");
      param1CacheBuilderSpec.accessExpirationDuration = param1Long;
      param1CacheBuilderSpec.accessExpirationTimeUnit = param1TimeUnit;
    }
  }
  
  static class ConcurrencyLevelParser extends IntegerParser {
    protected void parseInteger(CacheBuilderSpec param1CacheBuilderSpec, int param1Int) {
      boolean bool;
      if (param1CacheBuilderSpec.concurrencyLevel == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "concurrency level was already set to ", param1CacheBuilderSpec.concurrencyLevel);
      param1CacheBuilderSpec.concurrencyLevel = Integer.valueOf(param1Int);
    }
  }
  
  static abstract class DurationParser implements ValueParser {
    public void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, String param1String2) {
      boolean bool;
      if (param1String2 != null && !param1String2.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "value of key %s omitted", param1String1);
      try {
        IllegalArgumentException illegalArgumentException;
        TimeUnit timeUnit;
        char c = param1String2.charAt(param1String2.length() - 1);
        if (c != 'd') {
          if (c != 'h') {
            if (c != 'm') {
              if (c == 's') {
                timeUnit = TimeUnit.SECONDS;
              } else {
                illegalArgumentException = new IllegalArgumentException();
                this(CacheBuilderSpec.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", new Object[] { param1String1, param1String2 }));
                throw illegalArgumentException;
              } 
            } else {
              timeUnit = TimeUnit.MINUTES;
            } 
          } else {
            timeUnit = TimeUnit.HOURS;
          } 
        } else {
          timeUnit = TimeUnit.DAYS;
        } 
        parseDuration((CacheBuilderSpec)illegalArgumentException, Long.parseLong(param1String2.substring(0, param1String2.length() - 1)), timeUnit);
        return;
      } catch (NumberFormatException numberFormatException) {
        throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { param1String1, param1String2 }));
      } 
    }
    
    protected abstract void parseDuration(CacheBuilderSpec param1CacheBuilderSpec, long param1Long, TimeUnit param1TimeUnit);
  }
  
  static class InitialCapacityParser extends IntegerParser {
    protected void parseInteger(CacheBuilderSpec param1CacheBuilderSpec, int param1Int) {
      boolean bool;
      if (param1CacheBuilderSpec.initialCapacity == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "initial capacity was already set to ", param1CacheBuilderSpec.initialCapacity);
      param1CacheBuilderSpec.initialCapacity = Integer.valueOf(param1Int);
    }
  }
  
  static abstract class IntegerParser implements ValueParser {
    public void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, String param1String2) {
      boolean bool;
      if (param1String2 != null && !param1String2.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "value of key %s omitted", param1String1);
      try {
        parseInteger(param1CacheBuilderSpec, Integer.parseInt(param1String2));
        return;
      } catch (NumberFormatException numberFormatException) {
        throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { param1String1, param1String2 }), numberFormatException);
      } 
    }
    
    protected abstract void parseInteger(CacheBuilderSpec param1CacheBuilderSpec, int param1Int);
  }
  
  static class KeyStrengthParser implements ValueParser {
    private final LocalCache.Strength strength;
    
    public KeyStrengthParser(LocalCache.Strength param1Strength) {
      this.strength = param1Strength;
    }
    
    public void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, @Nullable String param1String2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1String2 == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "key %s does not take values", param1String1);
      if (param1CacheBuilderSpec.keyStrength == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "%s was already set to %s", param1String1, param1CacheBuilderSpec.keyStrength);
      param1CacheBuilderSpec.keyStrength = this.strength;
    }
  }
  
  static abstract class LongParser implements ValueParser {
    public void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, String param1String2) {
      boolean bool;
      if (param1String2 != null && !param1String2.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "value of key %s omitted", param1String1);
      try {
        parseLong(param1CacheBuilderSpec, Long.parseLong(param1String2));
        return;
      } catch (NumberFormatException numberFormatException) {
        throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", new Object[] { param1String1, param1String2 }), numberFormatException);
      } 
    }
    
    protected abstract void parseLong(CacheBuilderSpec param1CacheBuilderSpec, long param1Long);
  }
  
  static class MaximumSizeParser extends LongParser {
    protected void parseLong(CacheBuilderSpec param1CacheBuilderSpec, long param1Long) {
      boolean bool2;
      Long long_ = param1CacheBuilderSpec.maximumSize;
      boolean bool1 = true;
      if (long_ == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maximum size was already set to ", param1CacheBuilderSpec.maximumSize);
      if (param1CacheBuilderSpec.maximumWeight == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maximum weight was already set to ", param1CacheBuilderSpec.maximumWeight);
      param1CacheBuilderSpec.maximumSize = Long.valueOf(param1Long);
    }
  }
  
  static class MaximumWeightParser extends LongParser {
    protected void parseLong(CacheBuilderSpec param1CacheBuilderSpec, long param1Long) {
      boolean bool2;
      Long long_ = param1CacheBuilderSpec.maximumWeight;
      boolean bool1 = true;
      if (long_ == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maximum weight was already set to ", param1CacheBuilderSpec.maximumWeight);
      if (param1CacheBuilderSpec.maximumSize == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "maximum size was already set to ", param1CacheBuilderSpec.maximumSize);
      param1CacheBuilderSpec.maximumWeight = Long.valueOf(param1Long);
    }
  }
  
  static class RecordStatsParser implements ValueParser {
    public void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, @Nullable String param1String2) {
      boolean bool1 = false;
      if (param1String2 == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "recordStats does not take values");
      boolean bool2 = bool1;
      if (param1CacheBuilderSpec.recordStats == null)
        bool2 = true; 
      Preconditions.checkArgument(bool2, "recordStats already set");
      param1CacheBuilderSpec.recordStats = Boolean.valueOf(true);
    }
  }
  
  static class RefreshDurationParser extends DurationParser {
    protected void parseDuration(CacheBuilderSpec param1CacheBuilderSpec, long param1Long, TimeUnit param1TimeUnit) {
      boolean bool;
      if (param1CacheBuilderSpec.refreshTimeUnit == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "refreshAfterWrite already set");
      param1CacheBuilderSpec.refreshDuration = param1Long;
      param1CacheBuilderSpec.refreshTimeUnit = param1TimeUnit;
    }
  }
  
  private static interface ValueParser {
    void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, @Nullable String param1String2);
  }
  
  static class ValueStrengthParser implements ValueParser {
    private final LocalCache.Strength strength;
    
    public ValueStrengthParser(LocalCache.Strength param1Strength) {
      this.strength = param1Strength;
    }
    
    public void parse(CacheBuilderSpec param1CacheBuilderSpec, String param1String1, @Nullable String param1String2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1String2 == null) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "key %s does not take values", param1String1);
      if (param1CacheBuilderSpec.valueStrength == null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "%s was already set to %s", param1String1, param1CacheBuilderSpec.valueStrength);
      param1CacheBuilderSpec.valueStrength = this.strength;
    }
  }
  
  static class WriteDurationParser extends DurationParser {
    protected void parseDuration(CacheBuilderSpec param1CacheBuilderSpec, long param1Long, TimeUnit param1TimeUnit) {
      boolean bool;
      if (param1CacheBuilderSpec.writeExpirationTimeUnit == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "expireAfterWrite already set");
      param1CacheBuilderSpec.writeExpirationDuration = param1Long;
      param1CacheBuilderSpec.writeExpirationTimeUnit = param1TimeUnit;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\CacheBuilderSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */