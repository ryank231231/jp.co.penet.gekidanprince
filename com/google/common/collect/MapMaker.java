package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible(emulated = true)
public final class MapMaker {
  private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  
  static final int UNSET_INT = -1;
  
  int concurrencyLevel = -1;
  
  int initialCapacity = -1;
  
  Equivalence<Object> keyEquivalence;
  
  MapMakerInternalMap.Strength keyStrength;
  
  boolean useCustomMap;
  
  MapMakerInternalMap.Strength valueStrength;
  
  @CanIgnoreReturnValue
  public MapMaker concurrencyLevel(int paramInt) {
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
  
  int getConcurrencyLevel() {
    int i = this.concurrencyLevel;
    int j = i;
    if (i == -1)
      j = 4; 
    return j;
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
  
  MapMakerInternalMap.Strength getKeyStrength() {
    return (MapMakerInternalMap.Strength)MoreObjects.firstNonNull(this.keyStrength, MapMakerInternalMap.Strength.STRONG);
  }
  
  MapMakerInternalMap.Strength getValueStrength() {
    return (MapMakerInternalMap.Strength)MoreObjects.firstNonNull(this.valueStrength, MapMakerInternalMap.Strength.STRONG);
  }
  
  @CanIgnoreReturnValue
  public MapMaker initialCapacity(int paramInt) {
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
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  MapMaker keyEquivalence(Equivalence<Object> paramEquivalence) {
    boolean bool;
    if (this.keyEquivalence == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "key equivalence was already set to %s", this.keyEquivalence);
    this.keyEquivalence = (Equivalence<Object>)Preconditions.checkNotNull(paramEquivalence);
    this.useCustomMap = true;
    return this;
  }
  
  @GwtIncompatible
  <K, V> MapMakerInternalMap<K, V, ?, ?> makeCustomMap() {
    return MapMakerInternalMap.create(this);
  }
  
  public <K, V> ConcurrentMap<K, V> makeMap() {
    return (ConcurrentMap<K, V>)(!this.useCustomMap ? new ConcurrentHashMap<K, V>(getInitialCapacity(), 0.75F, getConcurrencyLevel()) : MapMakerInternalMap.create(this));
  }
  
  MapMaker setKeyStrength(MapMakerInternalMap.Strength paramStrength) {
    boolean bool;
    if (this.keyStrength == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Key strength was already set to %s", this.keyStrength);
    this.keyStrength = (MapMakerInternalMap.Strength)Preconditions.checkNotNull(paramStrength);
    if (paramStrength != MapMakerInternalMap.Strength.STRONG)
      this.useCustomMap = true; 
    return this;
  }
  
  MapMaker setValueStrength(MapMakerInternalMap.Strength paramStrength) {
    boolean bool;
    if (this.valueStrength == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Value strength was already set to %s", this.valueStrength);
    this.valueStrength = (MapMakerInternalMap.Strength)Preconditions.checkNotNull(paramStrength);
    if (paramStrength != MapMakerInternalMap.Strength.STRONG)
      this.useCustomMap = true; 
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
    MapMakerInternalMap.Strength strength = this.keyStrength;
    if (strength != null)
      toStringHelper.add("keyStrength", Ascii.toLowerCase(strength.toString())); 
    strength = this.valueStrength;
    if (strength != null)
      toStringHelper.add("valueStrength", Ascii.toLowerCase(strength.toString())); 
    if (this.keyEquivalence != null)
      toStringHelper.addValue("keyEquivalence"); 
    return toStringHelper.toString();
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public MapMaker weakKeys() {
    return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
  }
  
  @GwtIncompatible
  @CanIgnoreReturnValue
  public MapMaker weakValues() {
    return setValueStrength(MapMakerInternalMap.Strength.WEAK);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MapMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */