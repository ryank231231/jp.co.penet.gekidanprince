package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.Nullable;

@GwtIncompatible
class ImmutableMapEntry<K, V> extends ImmutableEntry<K, V> {
  ImmutableMapEntry(ImmutableMapEntry<K, V> paramImmutableMapEntry) {
    super(paramImmutableMapEntry.getKey(), paramImmutableMapEntry.getValue());
  }
  
  ImmutableMapEntry(K paramK, V paramV) {
    super(paramK, paramV);
    CollectPreconditions.checkEntryNotNull(paramK, paramV);
  }
  
  static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int paramInt) {
    return (ImmutableMapEntry<K, V>[])new ImmutableMapEntry[paramInt];
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInKeyBucket() {
    return null;
  }
  
  @Nullable
  ImmutableMapEntry<K, V> getNextInValueBucket() {
    return null;
  }
  
  boolean isReusable() {
    return true;
  }
  
  static final class NonTerminalImmutableBiMapEntry<K, V> extends NonTerminalImmutableMapEntry<K, V> {
    private final transient ImmutableMapEntry<K, V> nextInValueBucket;
    
    NonTerminalImmutableBiMapEntry(K param1K, V param1V, ImmutableMapEntry<K, V> param1ImmutableMapEntry1, ImmutableMapEntry<K, V> param1ImmutableMapEntry2) {
      super(param1K, param1V, param1ImmutableMapEntry1);
      this.nextInValueBucket = param1ImmutableMapEntry2;
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInValueBucket() {
      return this.nextInValueBucket;
    }
  }
  
  static class NonTerminalImmutableMapEntry<K, V> extends ImmutableMapEntry<K, V> {
    private final transient ImmutableMapEntry<K, V> nextInKeyBucket;
    
    NonTerminalImmutableMapEntry(K param1K, V param1V, ImmutableMapEntry<K, V> param1ImmutableMapEntry) {
      super(param1K, param1V);
      this.nextInKeyBucket = param1ImmutableMapEntry;
    }
    
    @Nullable
    final ImmutableMapEntry<K, V> getNextInKeyBucket() {
      return this.nextInKeyBucket;
    }
    
    final boolean isReusable() {
      return false;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ImmutableMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */