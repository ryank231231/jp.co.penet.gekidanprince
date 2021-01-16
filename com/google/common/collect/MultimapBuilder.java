package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@Beta
@GwtCompatible
public abstract class MultimapBuilder<K0, V0> {
  private static final int DEFAULT_EXPECTED_KEYS = 8;
  
  private MultimapBuilder() {}
  
  public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(final Class<K0> keyClass) {
    Preconditions.checkNotNull(keyClass);
    return new MultimapBuilderWithKeys<K0>() {
        <K extends K0, V> Map<K, Collection<V>> createMap() {
          return (Map)new EnumMap<Enum, Collection<V>>(keyClass);
        }
      };
  }
  
  public static MultimapBuilderWithKeys<Object> hashKeys() {
    return hashKeys(8);
  }
  
  public static MultimapBuilderWithKeys<Object> hashKeys(final int expectedKeys) {
    CollectPreconditions.checkNonnegative(expectedKeys, "expectedKeys");
    return new MultimapBuilderWithKeys() {
        <K, V> Map<K, Collection<V>> createMap() {
          return Maps.newHashMapWithExpectedSize(expectedKeys);
        }
      };
  }
  
  public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
    return linkedHashKeys(8);
  }
  
  public static MultimapBuilderWithKeys<Object> linkedHashKeys(final int expectedKeys) {
    CollectPreconditions.checkNonnegative(expectedKeys, "expectedKeys");
    return new MultimapBuilderWithKeys() {
        <K, V> Map<K, Collection<V>> createMap() {
          return Maps.newLinkedHashMapWithExpectedSize(expectedKeys);
        }
      };
  }
  
  public static MultimapBuilderWithKeys<Comparable> treeKeys() {
    return treeKeys(Ordering.natural());
  }
  
  public static <K0> MultimapBuilderWithKeys<K0> treeKeys(final Comparator<K0> comparator) {
    Preconditions.checkNotNull(comparator);
    return new MultimapBuilderWithKeys<K0>() {
        <K extends K0, V> Map<K, Collection<V>> createMap() {
          return new TreeMap<K, Collection<V>>(comparator);
        }
      };
  }
  
  public abstract <K extends K0, V extends V0> Multimap<K, V> build();
  
  public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> paramMultimap) {
    Multimap<Object, Object> multimap = build();
    multimap.putAll(paramMultimap);
    return (Multimap)multimap;
  }
  
  private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
    private final int expectedValuesPerKey;
    
    ArrayListSupplier(int param1Int) {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(param1Int, "expectedValuesPerKey");
    }
    
    public List<V> get() {
      return new ArrayList<V>(this.expectedValuesPerKey);
    }
  }
  
  private static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
    private final Class<V> clazz;
    
    EnumSetSupplier(Class<V> param1Class) {
      this.clazz = (Class<V>)Preconditions.checkNotNull(param1Class);
    }
    
    public Set<V> get() {
      return EnumSet.noneOf(this.clazz);
    }
  }
  
  private static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
    private final int expectedValuesPerKey;
    
    HashSetSupplier(int param1Int) {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(param1Int, "expectedValuesPerKey");
    }
    
    public Set<V> get() {
      return Sets.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
  }
  
  private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
    private final int expectedValuesPerKey;
    
    LinkedHashSetSupplier(int param1Int) {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(param1Int, "expectedValuesPerKey");
    }
    
    public Set<V> get() {
      return Sets.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
    }
  }
  
  private enum LinkedListSupplier implements Supplier<List<Object>> {
    INSTANCE;
    
    static {
    
    }
    
    public static <V> Supplier<List<V>> instance() {
      return INSTANCE;
    }
    
    public List<Object> get() {
      return new LinkedList();
    }
  }
  
  public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
    public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();
    
    public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> param1Multimap) {
      return (ListMultimap<K, V>)super.<K, V>build(param1Multimap);
    }
  }
  
  public static abstract class MultimapBuilderWithKeys<K0> {
    private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues() {
      return arrayListValues(2);
    }
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> arrayListValues(final int expectedValuesPerKey) {
      CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
      return new MultimapBuilder.ListMultimapBuilder<K0, Object>() {
          public <K extends K0, V> ListMultimap<K, V> build() {
            return Multimaps.newListMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.ArrayListSupplier(expectedValuesPerKey));
          }
        };
    }
    
    abstract <K extends K0, V> Map<K, Collection<V>> createMap();
    
    public <V0 extends Enum<V0>> MultimapBuilder.SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> valueClass) {
      Preconditions.checkNotNull(valueClass, "valueClass");
      return new MultimapBuilder.SetMultimapBuilder<K0, V0>() {
          public <K extends K0, V extends V0> SetMultimap<K, V> build() {
            MultimapBuilder.EnumSetSupplier<Enum> enumSetSupplier = new MultimapBuilder.EnumSetSupplier<Enum>(valueClass);
            return Multimaps.newSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), (Supplier)enumSetSupplier);
          }
        };
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues() {
      return hashSetValues(2);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> hashSetValues(final int expectedValuesPerKey) {
      CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
      return new MultimapBuilder.SetMultimapBuilder<K0, Object>() {
          public <K extends K0, V> SetMultimap<K, V> build() {
            return Multimaps.newSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.HashSetSupplier(expectedValuesPerKey));
          }
        };
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues() {
      return linkedHashSetValues(2);
    }
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> linkedHashSetValues(final int expectedValuesPerKey) {
      CollectPreconditions.checkNonnegative(expectedValuesPerKey, "expectedValuesPerKey");
      return new MultimapBuilder.SetMultimapBuilder<K0, Object>() {
          public <K extends K0, V> SetMultimap<K, V> build() {
            return Multimaps.newSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.LinkedHashSetSupplier(expectedValuesPerKey));
          }
        };
    }
    
    public MultimapBuilder.ListMultimapBuilder<K0, Object> linkedListValues() {
      return new MultimapBuilder.ListMultimapBuilder<K0, Object>() {
          public <K extends K0, V> ListMultimap<K, V> build() {
            return Multimaps.newListMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), (Supplier)MultimapBuilder.LinkedListSupplier.instance());
          }
        };
    }
    
    public MultimapBuilder.SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
      return treeSetValues(Ordering.natural());
    }
    
    public <V0> MultimapBuilder.SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> comparator) {
      Preconditions.checkNotNull(comparator, "comparator");
      return new MultimapBuilder.SortedSetMultimapBuilder<K0, V0>() {
          public <K extends K0, V extends V0> SortedSetMultimap<K, V> build() {
            return Multimaps.newSortedSetMultimap(MultimapBuilder.MultimapBuilderWithKeys.this.createMap(), new MultimapBuilder.TreeSetSupplier(comparator));
          }
        };
    }
  }
  
  class null extends ListMultimapBuilder<K0, Object> {
    public <K extends K0, V> ListMultimap<K, V> build() {
      return Multimaps.newListMultimap(this.this$0.createMap(), new MultimapBuilder.ArrayListSupplier(expectedValuesPerKey));
    }
  }
  
  class null extends ListMultimapBuilder<K0, Object> {
    public <K extends K0, V> ListMultimap<K, V> build() {
      return Multimaps.newListMultimap(this.this$0.createMap(), (Supplier)MultimapBuilder.LinkedListSupplier.instance());
    }
  }
  
  class null extends SetMultimapBuilder<K0, Object> {
    public <K extends K0, V> SetMultimap<K, V> build() {
      return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder.HashSetSupplier(expectedValuesPerKey));
    }
  }
  
  class null extends SetMultimapBuilder<K0, Object> {
    public <K extends K0, V> SetMultimap<K, V> build() {
      return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder.LinkedHashSetSupplier(expectedValuesPerKey));
    }
  }
  
  class null extends SortedSetMultimapBuilder<K0, V0> {
    public <K extends K0, V extends V0> SortedSetMultimap<K, V> build() {
      return Multimaps.newSortedSetMultimap(this.this$0.createMap(), new MultimapBuilder.TreeSetSupplier(comparator));
    }
  }
  
  class null extends SetMultimapBuilder<K0, V0> {
    public <K extends K0, V extends V0> SetMultimap<K, V> build() {
      MultimapBuilder.EnumSetSupplier<Enum> enumSetSupplier = new MultimapBuilder.EnumSetSupplier<Enum>(valueClass);
      return Multimaps.newSetMultimap(this.this$0.createMap(), (Supplier)enumSetSupplier);
    }
  }
  
  public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
    public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();
    
    public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> param1Multimap) {
      return (SetMultimap<K, V>)super.<K, V>build(param1Multimap);
    }
  }
  
  public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
    public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();
    
    public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> param1Multimap) {
      return (SortedSetMultimap<K, V>)super.<K, V>build(param1Multimap);
    }
  }
  
  private static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
    private final Comparator<? super V> comparator;
    
    TreeSetSupplier(Comparator<? super V> param1Comparator) {
      this.comparator = (Comparator<? super V>)Preconditions.checkNotNull(param1Comparator);
    }
    
    public SortedSet<V> get() {
      return new TreeSet<V>(this.comparator);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\MultimapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */