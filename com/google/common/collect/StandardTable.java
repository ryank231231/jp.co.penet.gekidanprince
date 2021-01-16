package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  @GwtTransient
  final Map<R, Map<C, V>> backingMap;
  
  private transient Set<C> columnKeySet;
  
  private transient ColumnMap columnMap;
  
  @GwtTransient
  final Supplier<? extends Map<C, V>> factory;
  
  private transient Map<R, Map<C, V>> rowMap;
  
  StandardTable(Map<R, Map<C, V>> paramMap, Supplier<? extends Map<C, V>> paramSupplier) {
    this.backingMap = paramMap;
    this.factory = paramSupplier;
  }
  
  private boolean containsMapping(Object paramObject1, Object paramObject2, Object paramObject3) {
    boolean bool;
    if (paramObject3 != null && paramObject3.equals(get(paramObject1, paramObject2))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private Map<C, V> getOrCreate(R paramR) {
    Map<C, V> map1 = this.backingMap.get(paramR);
    Map<C, V> map2 = map1;
    if (map1 == null) {
      map2 = (Map)this.factory.get();
      this.backingMap.put(paramR, map2);
    } 
    return map2;
  }
  
  @CanIgnoreReturnValue
  private Map<R, V> removeColumn(Object paramObject) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    Iterator<Map.Entry> iterator = this.backingMap.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      Object object = ((Map)entry.getValue()).remove(paramObject);
      if (object != null) {
        linkedHashMap.put(entry.getKey(), object);
        if (((Map)entry.getValue()).isEmpty())
          iterator.remove(); 
      } 
    } 
    return (Map)linkedHashMap;
  }
  
  private boolean removeMapping(Object paramObject1, Object paramObject2, Object paramObject3) {
    if (containsMapping(paramObject1, paramObject2, paramObject3)) {
      remove(paramObject1, paramObject2);
      return true;
    } 
    return false;
  }
  
  Iterator<Table.Cell<R, C, V>> cellIterator() {
    return new CellIterator();
  }
  
  public Set<Table.Cell<R, C, V>> cellSet() {
    return super.cellSet();
  }
  
  public void clear() {
    this.backingMap.clear();
  }
  
  public Map<R, V> column(C paramC) {
    return new Column(paramC);
  }
  
  public Set<C> columnKeySet() {
    Set<C> set1 = this.columnKeySet;
    Set<C> set2 = set1;
    if (set1 == null) {
      set2 = new ColumnKeySet();
      this.columnKeySet = set2;
    } 
    return set2;
  }
  
  public Map<C, Map<R, V>> columnMap() {
    ColumnMap columnMap1 = this.columnMap;
    ColumnMap columnMap2 = columnMap1;
    if (columnMap1 == null) {
      columnMap2 = new ColumnMap();
      this.columnMap = columnMap2;
    } 
    return columnMap2;
  }
  
  public boolean contains(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    boolean bool;
    if (paramObject1 != null && paramObject2 != null && super.contains(paramObject1, paramObject2)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsColumn(@Nullable Object paramObject) {
    if (paramObject == null)
      return false; 
    Iterator<Map<?, ?>> iterator = this.backingMap.values().iterator();
    while (iterator.hasNext()) {
      if (Maps.safeContainsKey(iterator.next(), paramObject))
        return true; 
    } 
    return false;
  }
  
  public boolean containsRow(@Nullable Object paramObject) {
    boolean bool;
    if (paramObject != null && Maps.safeContainsKey(this.backingMap, paramObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    boolean bool;
    if (paramObject != null && super.containsValue(paramObject)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  Iterator<C> createColumnKeyIterator() {
    return new ColumnKeyIterator();
  }
  
  Map<R, Map<C, V>> createRowMap() {
    return new RowMap();
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return (paramObject1 == null || paramObject2 == null) ? null : super.get(paramObject1, paramObject2);
  }
  
  public boolean isEmpty() {
    return this.backingMap.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public V put(R paramR, C paramC, V paramV) {
    Preconditions.checkNotNull(paramR);
    Preconditions.checkNotNull(paramC);
    Preconditions.checkNotNull(paramV);
    return getOrCreate(paramR).put(paramC, paramV);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramObject1 == null || paramObject2 == null)
      return null; 
    Map map = Maps.<Map>safeGet((Map)this.backingMap, paramObject1);
    if (map == null)
      return null; 
    paramObject2 = map.remove(paramObject2);
    if (map.isEmpty())
      this.backingMap.remove(paramObject1); 
    return (V)paramObject2;
  }
  
  public Map<C, V> row(R paramR) {
    return new Row(paramR);
  }
  
  public Set<R> rowKeySet() {
    return rowMap().keySet();
  }
  
  public Map<R, Map<C, V>> rowMap() {
    Map<R, Map<C, V>> map1 = this.rowMap;
    Map<R, Map<C, V>> map2 = map1;
    if (map1 == null) {
      map2 = createRowMap();
      this.rowMap = map2;
    } 
    return map2;
  }
  
  public int size() {
    Iterator<Map> iterator = this.backingMap.values().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += ((Map)iterator.next()).size());
    return i;
  }
  
  public Collection<V> values() {
    return super.values();
  }
  
  private class CellIterator implements Iterator<Table.Cell<R, C, V>> {
    Iterator<Map.Entry<C, V>> columnIterator = Iterators.emptyModifiableIterator();
    
    Map.Entry<R, Map<C, V>> rowEntry;
    
    final Iterator<Map.Entry<R, Map<C, V>>> rowIterator = StandardTable.this.backingMap.entrySet().iterator();
    
    private CellIterator() {}
    
    public boolean hasNext() {
      return (this.rowIterator.hasNext() || this.columnIterator.hasNext());
    }
    
    public Table.Cell<R, C, V> next() {
      if (!this.columnIterator.hasNext()) {
        this.rowEntry = this.rowIterator.next();
        this.columnIterator = ((Map<C, V>)this.rowEntry.getValue()).entrySet().iterator();
      } 
      Map.Entry entry = this.columnIterator.next();
      return Tables.immutableCell(this.rowEntry.getKey(), (C)entry.getKey(), (V)entry.getValue());
    }
    
    public void remove() {
      this.columnIterator.remove();
      if (((Map)this.rowEntry.getValue()).isEmpty())
        this.rowIterator.remove(); 
    }
  }
  
  private class Column extends Maps.ViewCachingAbstractMap<R, V> {
    final C columnKey;
    
    Column(C param1C) {
      this.columnKey = (C)Preconditions.checkNotNull(param1C);
    }
    
    public boolean containsKey(Object param1Object) {
      return StandardTable.this.contains(param1Object, this.columnKey);
    }
    
    Set<Map.Entry<R, V>> createEntrySet() {
      return new EntrySet();
    }
    
    Set<R> createKeySet() {
      return new KeySet();
    }
    
    Collection<V> createValues() {
      return new Values();
    }
    
    public V get(Object param1Object) {
      return (V)StandardTable.this.get(param1Object, this.columnKey);
    }
    
    public V put(R param1R, V param1V) {
      return StandardTable.this.put(param1R, this.columnKey, param1V);
    }
    
    public V remove(Object param1Object) {
      return (V)StandardTable.this.remove(param1Object, this.columnKey);
    }
    
    @CanIgnoreReturnValue
    boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> param1Predicate) {
      Iterator<Map.Entry> iterator = StandardTable.this.backingMap.entrySet().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        Map map = (Map)entry.getValue();
        Object object = map.get(this.columnKey);
        if (object != null && param1Predicate.apply(Maps.immutableEntry(entry.getKey(), object))) {
          map.remove(this.columnKey);
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    private class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
      private EntrySet() {}
      
      public void clear() {
        StandardTable.Column.this.removeFromColumnIf(Predicates.alwaysTrue());
      }
      
      public boolean contains(Object param2Object) {
        if (param2Object instanceof Map.Entry) {
          param2Object = param2Object;
          return StandardTable.this.containsMapping(param2Object.getKey(), StandardTable.Column.this.columnKey, param2Object.getValue());
        } 
        return false;
      }
      
      public boolean isEmpty() {
        return StandardTable.this.containsColumn(StandardTable.Column.this.columnKey) ^ true;
      }
      
      public Iterator<Map.Entry<R, V>> iterator() {
        return new StandardTable.Column.EntrySetIterator();
      }
      
      public boolean remove(Object param2Object) {
        if (param2Object instanceof Map.Entry) {
          param2Object = param2Object;
          return StandardTable.this.removeMapping(param2Object.getKey(), StandardTable.Column.this.columnKey, param2Object.getValue());
        } 
        return false;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return StandardTable.Column.this.removeFromColumnIf(Predicates.not(Predicates.in(param2Collection)));
      }
      
      public int size() {
        Iterator<Map> iterator = StandardTable.this.backingMap.values().iterator();
        byte b = 0;
        while (iterator.hasNext()) {
          if (((Map)iterator.next()).containsKey(StandardTable.Column.this.columnKey))
            b++; 
        } 
        return b;
      }
    }
    
    private class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
      final Iterator<Map.Entry<R, Map<C, V>>> iterator = StandardTable.this.backingMap.entrySet().iterator();
      
      private EntrySetIterator() {}
      
      protected Map.Entry<R, V> computeNext() {
        while (this.iterator.hasNext()) {
          final Map.Entry entry = this.iterator.next();
          if (((Map)entry.getValue()).containsKey(StandardTable.Column.this.columnKey)) {
            class EntryImpl extends AbstractMapEntry<R, V> {
              public R getKey() {
                return (R)entry.getKey();
              }
              
              public V getValue() {
                return (V)((Map)entry.getValue()).get(StandardTable.Column.this.columnKey);
              }
              
              public V setValue(V param3V) {
                return ((Map<C, V>)entry.getValue()).put(StandardTable.Column.this.columnKey, (V)Preconditions.checkNotNull(param3V));
              }
            };
            return new EntryImpl();
          } 
        } 
        return endOfData();
      }
    }
    
    class EntryImpl extends AbstractMapEntry<R, V> {
      public R getKey() {
        return (R)entry.getKey();
      }
      
      public V getValue() {
        return (V)((Map)entry.getValue()).get(StandardTable.Column.this.columnKey);
      }
      
      public V setValue(V param2V) {
        return ((Map<C, V>)entry.getValue()).put(StandardTable.Column.this.columnKey, (V)Preconditions.checkNotNull(param2V));
      }
    }
    
    private class KeySet extends Maps.KeySet<R, V> {
      KeySet() {
        super(StandardTable.Column.this);
      }
      
      public boolean contains(Object param2Object) {
        return StandardTable.this.contains(param2Object, StandardTable.Column.this.columnKey);
      }
      
      public boolean remove(Object param2Object) {
        boolean bool;
        if (StandardTable.this.remove(param2Object, StandardTable.Column.this.columnKey) != null) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return StandardTable.Column.this.removeFromColumnIf((Predicate)Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(param2Collection))));
      }
    }
    
    private class Values extends Maps.Values<R, V> {
      Values() {
        super(StandardTable.Column.this);
      }
      
      public boolean remove(Object param2Object) {
        boolean bool;
        if (param2Object != null && StandardTable.Column.this.removeFromColumnIf((Predicate)Maps.valuePredicateOnEntries(Predicates.equalTo(param2Object)))) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        return StandardTable.Column.this.removeFromColumnIf((Predicate)Maps.valuePredicateOnEntries(Predicates.in(param2Collection)));
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        return StandardTable.Column.this.removeFromColumnIf((Predicate)Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(param2Collection))));
      }
    }
  }
  
  private class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
    private EntrySet() {}
    
    public void clear() {
      StandardTable.Column.this.removeFromColumnIf(Predicates.alwaysTrue());
    }
    
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return StandardTable.this.containsMapping(param1Object.getKey(), StandardTable.Column.this.columnKey, param1Object.getValue());
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return StandardTable.this.containsColumn(StandardTable.Column.this.columnKey) ^ true;
    }
    
    public Iterator<Map.Entry<R, V>> iterator() {
      return new StandardTable.Column.EntrySetIterator();
    }
    
    public boolean remove(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return StandardTable.this.removeMapping(param1Object.getKey(), StandardTable.Column.this.columnKey, param1Object.getValue());
      } 
      return false;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return StandardTable.Column.this.removeFromColumnIf(Predicates.not(Predicates.in(param1Collection)));
    }
    
    public int size() {
      Iterator<Map> iterator = StandardTable.this.backingMap.values().iterator();
      byte b = 0;
      while (iterator.hasNext()) {
        if (((Map)iterator.next()).containsKey(StandardTable.Column.this.columnKey))
          b++; 
      } 
      return b;
    }
  }
  
  private class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {
    final Iterator<Map.Entry<R, Map<C, V>>> iterator = StandardTable.this.backingMap.entrySet().iterator();
    
    private EntrySetIterator() {}
    
    protected Map.Entry<R, V> computeNext() {
      while (this.iterator.hasNext()) {
        final Map.Entry entry = this.iterator.next();
        if (((Map)entry.getValue()).containsKey(StandardTable.Column.this.columnKey)) {
          class EntryImpl extends AbstractMapEntry<R, V> {
            public R getKey() {
              return (R)entry.getKey();
            }
            
            public V getValue() {
              return (V)((Map)entry.getValue()).get(this.this$2.this$1.columnKey);
            }
            
            public V setValue(V param3V) {
              return ((Map<C, V>)entry.getValue()).put(this.this$2.this$1.columnKey, (V)Preconditions.checkNotNull(param3V));
            }
          };
          return new EntryImpl();
        } 
      } 
      return endOfData();
    }
  }
  
  class EntryImpl extends AbstractMapEntry<R, V> {
    public R getKey() {
      return (R)entry.getKey();
    }
    
    public V getValue() {
      return (V)((Map)entry.getValue()).get(this.this$2.this$1.columnKey);
    }
    
    public V setValue(V param1V) {
      return ((Map<C, V>)entry.getValue()).put(this.this$2.this$1.columnKey, (V)Preconditions.checkNotNull(param1V));
    }
  }
  
  private class KeySet extends Maps.KeySet<R, V> {
    KeySet() {
      super((Map<R, V>)StandardTable.this);
    }
    
    public boolean contains(Object param1Object) {
      return StandardTable.this.contains(param1Object, this.this$1.columnKey);
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (StandardTable.this.remove(param1Object, this.this$1.columnKey) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.this$1.removeFromColumnIf((Predicate)Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(param1Collection))));
    }
  }
  
  private class Values extends Maps.Values<R, V> {
    Values() {
      super((Map<R, V>)StandardTable.this);
    }
    
    public boolean remove(Object param1Object) {
      boolean bool;
      if (param1Object != null && this.this$1.removeFromColumnIf((Predicate)Maps.valuePredicateOnEntries(Predicates.equalTo(param1Object)))) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      return this.this$1.removeFromColumnIf((Predicate)Maps.valuePredicateOnEntries(Predicates.in(param1Collection)));
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return this.this$1.removeFromColumnIf((Predicate)Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(param1Collection))));
    }
  }
  
  private class ColumnKeyIterator extends AbstractIterator<C> {
    Iterator<Map.Entry<C, V>> entryIterator = Iterators.emptyIterator();
    
    final Iterator<Map<C, V>> mapIterator = StandardTable.this.backingMap.values().iterator();
    
    final Map<C, V> seen = (Map<C, V>)StandardTable.this.factory.get();
    
    private ColumnKeyIterator() {}
    
    protected C computeNext() {
      while (true) {
        while (this.entryIterator.hasNext()) {
          Map.Entry entry = this.entryIterator.next();
          if (!this.seen.containsKey(entry.getKey())) {
            this.seen.put((C)entry.getKey(), (V)entry.getValue());
            return (C)entry.getKey();
          } 
        } 
        if (this.mapIterator.hasNext()) {
          this.entryIterator = ((Map<C, V>)this.mapIterator.next()).entrySet().iterator();
          continue;
        } 
        return endOfData();
      } 
    }
  }
  
  private class ColumnKeySet extends TableSet<C> {
    private ColumnKeySet() {}
    
    public boolean contains(Object param1Object) {
      return StandardTable.this.containsColumn(param1Object);
    }
    
    public Iterator<C> iterator() {
      return StandardTable.this.createColumnKeyIterator();
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = false;
      if (param1Object == null)
        return false; 
      Iterator<Map> iterator = StandardTable.this.backingMap.values().iterator();
      while (iterator.hasNext()) {
        Map map = iterator.next();
        if (map.keySet().remove(param1Object)) {
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      Iterator<Map> iterator = StandardTable.this.backingMap.values().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map map = iterator.next();
        if (Iterators.removeAll(map.keySet().iterator(), param1Collection)) {
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      Iterator<Map> iterator = StandardTable.this.backingMap.values().iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Map map = iterator.next();
        if (map.keySet().retainAll(param1Collection)) {
          boolean bool1 = true;
          bool = bool1;
          if (map.isEmpty()) {
            iterator.remove();
            bool = bool1;
          } 
        } 
      } 
      return bool;
    }
    
    public int size() {
      return Iterators.size(iterator());
    }
  }
  
  private class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {
    private ColumnMap() {}
    
    public boolean containsKey(Object param1Object) {
      return StandardTable.this.containsColumn(param1Object);
    }
    
    public Set<Map.Entry<C, Map<R, V>>> createEntrySet() {
      return new ColumnMapEntrySet();
    }
    
    Collection<Map<R, V>> createValues() {
      return new ColumnMapValues();
    }
    
    public Map<R, V> get(Object param1Object) {
      if (StandardTable.this.containsColumn(param1Object)) {
        param1Object = StandardTable.this.column(param1Object);
      } else {
        param1Object = null;
      } 
      return (Map<R, V>)param1Object;
    }
    
    public Set<C> keySet() {
      return StandardTable.this.columnKeySet();
    }
    
    public Map<R, V> remove(Object param1Object) {
      if (StandardTable.this.containsColumn(param1Object)) {
        param1Object = StandardTable.this.removeColumn(param1Object);
      } else {
        param1Object = null;
      } 
      return (Map<R, V>)param1Object;
    }
    
    class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
      public boolean contains(Object param2Object) {
        if (param2Object instanceof Map.Entry) {
          param2Object = param2Object;
          if (StandardTable.this.containsColumn(param2Object.getKey())) {
            Object object = param2Object.getKey();
            return StandardTable.ColumnMap.this.get(object).equals(param2Object.getValue());
          } 
        } 
        return false;
      }
      
      public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
        return Maps.asMapEntryIterator(StandardTable.this.columnKeySet(), new Function<C, Map<R, V>>() {
              public Map<R, V> apply(C param3C) {
                return StandardTable.this.column(param3C);
              }
            });
      }
      
      public boolean remove(Object param2Object) {
        if (contains(param2Object)) {
          param2Object = param2Object;
          StandardTable.this.removeColumn(param2Object.getKey());
          return true;
        } 
        return false;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        Preconditions.checkNotNull(param2Collection);
        return Sets.removeAllImpl(this, param2Collection.iterator());
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        Preconditions.checkNotNull(param2Collection);
        Iterator<Object> iterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
        boolean bool = false;
        while (iterator.hasNext()) {
          Object object = iterator.next();
          if (!param2Collection.contains(Maps.immutableEntry(object, StandardTable.this.column(object)))) {
            StandardTable.this.removeColumn(object);
            bool = true;
          } 
        } 
        return bool;
      }
      
      public int size() {
        return StandardTable.this.columnKeySet().size();
      }
    }
    
    class null implements Function<C, Map<R, V>> {
      public Map<R, V> apply(C param2C) {
        return StandardTable.this.column(param2C);
      }
    }
    
    private class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
      ColumnMapValues() {
        super(StandardTable.ColumnMap.this);
      }
      
      public boolean remove(Object param2Object) {
        for (Map.Entry<C, Map<R, V>> entry : StandardTable.ColumnMap.this.entrySet()) {
          if (((Map)entry.getValue()).equals(param2Object)) {
            StandardTable.this.removeColumn(entry.getKey());
            return true;
          } 
        } 
        return false;
      }
      
      public boolean removeAll(Collection<?> param2Collection) {
        Preconditions.checkNotNull(param2Collection);
        Iterator<Object> iterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
        boolean bool = false;
        while (iterator.hasNext()) {
          Object object = iterator.next();
          if (param2Collection.contains(StandardTable.this.column(object))) {
            StandardTable.this.removeColumn(object);
            bool = true;
          } 
        } 
        return bool;
      }
      
      public boolean retainAll(Collection<?> param2Collection) {
        Preconditions.checkNotNull(param2Collection);
        Iterator<Object> iterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
        boolean bool = false;
        while (iterator.hasNext()) {
          Object object = iterator.next();
          if (!param2Collection.contains(StandardTable.this.column(object))) {
            StandardTable.this.removeColumn(object);
            bool = true;
          } 
        } 
        return bool;
      }
    }
  }
  
  class ColumnMapEntrySet extends TableSet<Map.Entry<C, Map<R, V>>> {
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        if (StandardTable.this.containsColumn(param1Object.getKey())) {
          Object object = param1Object.getKey();
          return this.this$1.get(object).equals(param1Object.getValue());
        } 
      } 
      return false;
    }
    
    public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
      return Maps.asMapEntryIterator(StandardTable.this.columnKeySet(), new Function<C, Map<R, V>>() {
            public Map<R, V> apply(C param3C) {
              return StandardTable.this.column(param3C);
            }
          });
    }
    
    public boolean remove(Object param1Object) {
      if (contains(param1Object)) {
        param1Object = param1Object;
        StandardTable.this.removeColumn(param1Object.getKey());
        return true;
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      return Sets.removeAllImpl(this, param1Collection.iterator());
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      Iterator<Object> iterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (!param1Collection.contains(Maps.immutableEntry(object, StandardTable.this.column(object)))) {
          StandardTable.this.removeColumn(object);
          bool = true;
        } 
      } 
      return bool;
    }
    
    public int size() {
      return StandardTable.this.columnKeySet().size();
    }
  }
  
  class null implements Function<C, Map<R, V>> {
    public Map<R, V> apply(C param1C) {
      return StandardTable.this.column(param1C);
    }
  }
  
  private class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
    ColumnMapValues() {
      super((Map<C, Map<R, V>>)StandardTable.this);
    }
    
    public boolean remove(Object param1Object) {
      for (Map.Entry<C, Map<R, V>> entry : this.this$1.entrySet()) {
        if (((Map)entry.getValue()).equals(param1Object)) {
          StandardTable.this.removeColumn(entry.getKey());
          return true;
        } 
      } 
      return false;
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      Iterator<Object> iterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (param1Collection.contains(StandardTable.this.column(object))) {
          StandardTable.this.removeColumn(object);
          bool = true;
        } 
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Preconditions.checkNotNull(param1Collection);
      Iterator<Object> iterator = Lists.newArrayList(StandardTable.this.columnKeySet().iterator()).iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        Object object = iterator.next();
        if (!param1Collection.contains(StandardTable.this.column(object))) {
          StandardTable.this.removeColumn(object);
          bool = true;
        } 
      } 
      return bool;
    }
  }
  
  class Row extends Maps.IteratorBasedAbstractMap<C, V> {
    Map<C, V> backingRowMap;
    
    final R rowKey;
    
    Row(R param1R) {
      this.rowKey = (R)Preconditions.checkNotNull(param1R);
    }
    
    Map<C, V> backingRowMap() {
      null = this.backingRowMap;
      if (null == null || (null.isEmpty() && StandardTable.this.backingMap.containsKey(this.rowKey))) {
        null = computeBackingRowMap();
        this.backingRowMap = null;
        return null;
      } 
      return this.backingRowMap;
    }
    
    public void clear() {
      Map<C, V> map = backingRowMap();
      if (map != null)
        map.clear(); 
      maintainEmptyInvariant();
    }
    
    Map<C, V> computeBackingRowMap() {
      return (Map<C, V>)StandardTable.this.backingMap.get(this.rowKey);
    }
    
    public boolean containsKey(Object param1Object) {
      boolean bool;
      Map<C, V> map = backingRowMap();
      if (param1Object != null && map != null && Maps.safeContainsKey(map, param1Object)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    Iterator<Map.Entry<C, V>> entryIterator() {
      Map<C, V> map = backingRowMap();
      return (map == null) ? Iterators.emptyModifiableIterator() : new Iterator<Map.Entry<C, V>>() {
          public boolean hasNext() {
            return iterator.hasNext();
          }
          
          public Map.Entry<C, V> next() {
            return new ForwardingMapEntry<C, V>() {
                protected Map.Entry<C, V> delegate() {
                  return entry;
                }
                
                public boolean equals(Object param3Object) {
                  return standardEquals(param3Object);
                }
                
                public V setValue(V param3V) {
                  return super.setValue((V)Preconditions.checkNotNull(param3V));
                }
              };
          }
          
          public void remove() {
            iterator.remove();
            StandardTable.Row.this.maintainEmptyInvariant();
          }
        };
    }
    
    public V get(Object param1Object) {
      Map<C, V> map = backingRowMap();
      if (param1Object != null && map != null) {
        param1Object = Maps.safeGet(map, param1Object);
      } else {
        param1Object = null;
      } 
      return (V)param1Object;
    }
    
    void maintainEmptyInvariant() {
      if (backingRowMap() != null && this.backingRowMap.isEmpty()) {
        StandardTable.this.backingMap.remove(this.rowKey);
        this.backingRowMap = null;
      } 
    }
    
    public V put(C param1C, V param1V) {
      Preconditions.checkNotNull(param1C);
      Preconditions.checkNotNull(param1V);
      Map<C, V> map = this.backingRowMap;
      return (map != null && !map.isEmpty()) ? this.backingRowMap.put(param1C, param1V) : StandardTable.this.put(this.rowKey, param1C, param1V);
    }
    
    public V remove(Object param1Object) {
      Map<C, V> map = backingRowMap();
      if (map == null)
        return null; 
      param1Object = Maps.safeRemove(map, param1Object);
      maintainEmptyInvariant();
      return (V)param1Object;
    }
    
    public int size() {
      int i;
      Map<C, V> map = backingRowMap();
      if (map == null) {
        i = 0;
      } else {
        i = map.size();
      } 
      return i;
    }
  }
  
  class null implements Iterator<Map.Entry<C, V>> {
    public boolean hasNext() {
      return iterator.hasNext();
    }
    
    public Map.Entry<C, V> next() {
      return new ForwardingMapEntry<C, V>() {
          protected Map.Entry<C, V> delegate() {
            return entry;
          }
          
          public boolean equals(Object param3Object) {
            return standardEquals(param3Object);
          }
          
          public V setValue(V param3V) {
            return super.setValue((V)Preconditions.checkNotNull(param3V));
          }
        };
    }
    
    public void remove() {
      iterator.remove();
      this.this$1.maintainEmptyInvariant();
    }
  }
  
  class null extends ForwardingMapEntry<C, V> {
    protected Map.Entry<C, V> delegate() {
      return entry;
    }
    
    public boolean equals(Object param1Object) {
      return standardEquals(param1Object);
    }
    
    public V setValue(V param1V) {
      return super.setValue((V)Preconditions.checkNotNull(param1V));
    }
  }
  
  class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {
    public boolean containsKey(Object param1Object) {
      return StandardTable.this.containsRow(param1Object);
    }
    
    protected Set<Map.Entry<R, Map<C, V>>> createEntrySet() {
      return new EntrySet();
    }
    
    public Map<C, V> get(Object param1Object) {
      if (StandardTable.this.containsRow(param1Object)) {
        param1Object = StandardTable.this.row(param1Object);
      } else {
        param1Object = null;
      } 
      return (Map<C, V>)param1Object;
    }
    
    public Map<C, V> remove(Object param1Object) {
      if (param1Object == null) {
        param1Object = null;
      } else {
        param1Object = StandardTable.this.backingMap.remove(param1Object);
      } 
      return (Map<C, V>)param1Object;
    }
    
    class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
      public boolean contains(Object param2Object) {
        boolean bool = param2Object instanceof Map.Entry;
        boolean bool1 = false;
        if (bool) {
          param2Object = param2Object;
          bool = bool1;
          if (param2Object.getKey() != null) {
            bool = bool1;
            if (param2Object.getValue() instanceof Map) {
              bool = bool1;
              if (Collections2.safeContains(StandardTable.this.backingMap.entrySet(), param2Object))
                bool = true; 
            } 
          } 
          return bool;
        } 
        return false;
      }
      
      public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
        return Maps.asMapEntryIterator(StandardTable.this.backingMap.keySet(), new Function<R, Map<C, V>>() {
              public Map<C, V> apply(R param3R) {
                return StandardTable.this.row(param3R);
              }
            });
      }
      
      public boolean remove(Object param2Object) {
        boolean bool = param2Object instanceof Map.Entry;
        boolean bool1 = false;
        if (bool) {
          param2Object = param2Object;
          bool = bool1;
          if (param2Object.getKey() != null) {
            bool = bool1;
            if (param2Object.getValue() instanceof Map) {
              bool = bool1;
              if (StandardTable.this.backingMap.entrySet().remove(param2Object))
                bool = true; 
            } 
          } 
          return bool;
        } 
        return false;
      }
      
      public int size() {
        return StandardTable.this.backingMap.size();
      }
    }
    
    class null implements Function<R, Map<C, V>> {
      public Map<C, V> apply(R param2R) {
        return StandardTable.this.row(param2R);
      }
    }
  }
  
  class EntrySet extends TableSet<Map.Entry<R, Map<C, V>>> {
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (param1Object.getKey() != null) {
          bool = bool1;
          if (param1Object.getValue() instanceof Map) {
            bool = bool1;
            if (Collections2.safeContains(StandardTable.this.backingMap.entrySet(), param1Object))
              bool = true; 
          } 
        } 
        return bool;
      } 
      return false;
    }
    
    public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
      return Maps.asMapEntryIterator(StandardTable.this.backingMap.keySet(), new Function<R, Map<C, V>>() {
            public Map<C, V> apply(R param3R) {
              return StandardTable.this.row(param3R);
            }
          });
    }
    
    public boolean remove(Object param1Object) {
      boolean bool = param1Object instanceof Map.Entry;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (param1Object.getKey() != null) {
          bool = bool1;
          if (param1Object.getValue() instanceof Map) {
            bool = bool1;
            if (StandardTable.this.backingMap.entrySet().remove(param1Object))
              bool = true; 
          } 
        } 
        return bool;
      } 
      return false;
    }
    
    public int size() {
      return StandardTable.this.backingMap.size();
    }
  }
  
  class null implements Function<R, Map<C, V>> {
    public Map<C, V> apply(R param1R) {
      return StandardTable.this.row(param1R);
    }
  }
  
  private abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
    private TableSet() {}
    
    public void clear() {
      StandardTable.this.backingMap.clear();
    }
    
    public boolean isEmpty() {
      return StandardTable.this.backingMap.isEmpty();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\StandardTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */