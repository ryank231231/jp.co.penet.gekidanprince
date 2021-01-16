package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
  private final int[] cellColumnIndices;
  
  private final int[] cellRowIndices;
  
  private final int[] columnCounts;
  
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  
  private final ImmutableMap<C, Map<R, V>> columnMap;
  
  private final int[] rowCounts;
  
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  
  private final ImmutableMap<R, Map<C, V>> rowMap;
  
  private final V[][] values;
  
  DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> paramImmutableList, ImmutableSet<R> paramImmutableSet, ImmutableSet<C> paramImmutableSet1) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aload_2
    //   6: invokevirtual size : ()I
    //   9: aload_3
    //   10: invokevirtual size : ()I
    //   13: multianewarray[[Ljava/lang/Object; 2
    //   17: putfield values : [[Ljava/lang/Object;
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic indexMap : (Ljava/util/Collection;)Lcom/google/common/collect/ImmutableMap;
    //   25: putfield rowKeyToIndex : Lcom/google/common/collect/ImmutableMap;
    //   28: aload_0
    //   29: aload_3
    //   30: invokestatic indexMap : (Ljava/util/Collection;)Lcom/google/common/collect/ImmutableMap;
    //   33: putfield columnKeyToIndex : Lcom/google/common/collect/ImmutableMap;
    //   36: aload_0
    //   37: aload_0
    //   38: getfield rowKeyToIndex : Lcom/google/common/collect/ImmutableMap;
    //   41: invokevirtual size : ()I
    //   44: newarray int
    //   46: putfield rowCounts : [I
    //   49: aload_0
    //   50: aload_0
    //   51: getfield columnKeyToIndex : Lcom/google/common/collect/ImmutableMap;
    //   54: invokevirtual size : ()I
    //   57: newarray int
    //   59: putfield columnCounts : [I
    //   62: aload_1
    //   63: invokevirtual size : ()I
    //   66: newarray int
    //   68: astore_2
    //   69: aload_1
    //   70: invokevirtual size : ()I
    //   73: newarray int
    //   75: astore_3
    //   76: iconst_0
    //   77: istore #4
    //   79: iload #4
    //   81: aload_1
    //   82: invokevirtual size : ()I
    //   85: if_icmpge -> 255
    //   88: aload_1
    //   89: iload #4
    //   91: invokevirtual get : (I)Ljava/lang/Object;
    //   94: checkcast com/google/common/collect/Table$Cell
    //   97: astore #5
    //   99: aload #5
    //   101: invokeinterface getRowKey : ()Ljava/lang/Object;
    //   106: astore #6
    //   108: aload #5
    //   110: invokeinterface getColumnKey : ()Ljava/lang/Object;
    //   115: astore #7
    //   117: aload_0
    //   118: getfield rowKeyToIndex : Lcom/google/common/collect/ImmutableMap;
    //   121: aload #6
    //   123: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   126: checkcast java/lang/Integer
    //   129: invokevirtual intValue : ()I
    //   132: istore #8
    //   134: aload_0
    //   135: getfield columnKeyToIndex : Lcom/google/common/collect/ImmutableMap;
    //   138: aload #7
    //   140: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   143: checkcast java/lang/Integer
    //   146: invokevirtual intValue : ()I
    //   149: istore #9
    //   151: aload_0
    //   152: getfield values : [[Ljava/lang/Object;
    //   155: iload #8
    //   157: aaload
    //   158: iload #9
    //   160: aaload
    //   161: ifnonnull -> 170
    //   164: iconst_1
    //   165: istore #10
    //   167: goto -> 173
    //   170: iconst_0
    //   171: istore #10
    //   173: iload #10
    //   175: ldc 'duplicate key: (%s, %s)'
    //   177: aload #6
    //   179: aload #7
    //   181: invokestatic checkArgument : (ZLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   184: aload_0
    //   185: getfield values : [[Ljava/lang/Object;
    //   188: iload #8
    //   190: aaload
    //   191: iload #9
    //   193: aload #5
    //   195: invokeinterface getValue : ()Ljava/lang/Object;
    //   200: aastore
    //   201: aload_0
    //   202: getfield rowCounts : [I
    //   205: astore #7
    //   207: aload #7
    //   209: iload #8
    //   211: aload #7
    //   213: iload #8
    //   215: iaload
    //   216: iconst_1
    //   217: iadd
    //   218: iastore
    //   219: aload_0
    //   220: getfield columnCounts : [I
    //   223: astore #7
    //   225: aload #7
    //   227: iload #9
    //   229: aload #7
    //   231: iload #9
    //   233: iaload
    //   234: iconst_1
    //   235: iadd
    //   236: iastore
    //   237: aload_2
    //   238: iload #4
    //   240: iload #8
    //   242: iastore
    //   243: aload_3
    //   244: iload #4
    //   246: iload #9
    //   248: iastore
    //   249: iinc #4, 1
    //   252: goto -> 79
    //   255: aload_0
    //   256: aload_2
    //   257: putfield cellRowIndices : [I
    //   260: aload_0
    //   261: aload_3
    //   262: putfield cellColumnIndices : [I
    //   265: aload_0
    //   266: new com/google/common/collect/DenseImmutableTable$RowMap
    //   269: dup
    //   270: aload_0
    //   271: aconst_null
    //   272: invokespecial <init> : (Lcom/google/common/collect/DenseImmutableTable;Lcom/google/common/collect/DenseImmutableTable$1;)V
    //   275: putfield rowMap : Lcom/google/common/collect/ImmutableMap;
    //   278: aload_0
    //   279: new com/google/common/collect/DenseImmutableTable$ColumnMap
    //   282: dup
    //   283: aload_0
    //   284: aconst_null
    //   285: invokespecial <init> : (Lcom/google/common/collect/DenseImmutableTable;Lcom/google/common/collect/DenseImmutableTable$1;)V
    //   288: putfield columnMap : Lcom/google/common/collect/ImmutableMap;
    //   291: return
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap() {
    return this.columnMap;
  }
  
  ImmutableTable.SerializedForm createSerializedForm() {
    return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
  }
  
  public V get(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    paramObject1 = this.rowKeyToIndex.get(paramObject1);
    paramObject2 = this.columnKeyToIndex.get(paramObject2);
    return (paramObject1 == null || paramObject2 == null) ? null : this.values[paramObject1.intValue()][paramObject2.intValue()];
  }
  
  Table.Cell<R, C, V> getCell(int paramInt) {
    int i = this.cellRowIndices[paramInt];
    paramInt = this.cellColumnIndices[paramInt];
    return cellOf(rowKeySet().asList().get(i), columnKeySet().asList().get(paramInt), this.values[i][paramInt]);
  }
  
  V getValue(int paramInt) {
    return this.values[this.cellRowIndices[paramInt]][this.cellColumnIndices[paramInt]];
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap() {
    return this.rowMap;
  }
  
  public int size() {
    return this.cellRowIndices.length;
  }
  
  private final class Column extends ImmutableArrayMap<R, V> {
    private final int columnIndex;
    
    Column(int param1Int) {
      super(DenseImmutableTable.this.columnCounts[param1Int]);
      this.columnIndex = param1Int;
    }
    
    V getValue(int param1Int) {
      return (V)DenseImmutableTable.this.values[param1Int][this.columnIndex];
    }
    
    boolean isPartialView() {
      return true;
    }
    
    ImmutableMap<R, Integer> keyToIndex() {
      return DenseImmutableTable.this.rowKeyToIndex;
    }
  }
  
  private final class ColumnMap extends ImmutableArrayMap<C, Map<R, V>> {
    private ColumnMap() {
      super(DenseImmutableTable.this.columnCounts.length);
    }
    
    Map<R, V> getValue(int param1Int) {
      return new DenseImmutableTable.Column(param1Int);
    }
    
    boolean isPartialView() {
      return false;
    }
    
    ImmutableMap<C, Integer> keyToIndex() {
      return DenseImmutableTable.this.columnKeyToIndex;
    }
  }
  
  private static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final int size;
    
    ImmutableArrayMap(int param1Int) {
      this.size = param1Int;
    }
    
    private boolean isFull() {
      boolean bool;
      if (this.size == keyToIndex().size()) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    ImmutableSet<K> createKeySet() {
      ImmutableSet<K> immutableSet;
      if (isFull()) {
        immutableSet = keyToIndex().keySet();
      } else {
        immutableSet = super.createKeySet();
      } 
      return immutableSet;
    }
    
    UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
      return new AbstractIterator<Map.Entry<K, V>>() {
          private int index = -1;
          
          private final int maxIndex = DenseImmutableTable.ImmutableArrayMap.this.keyToIndex().size();
          
          protected Map.Entry<K, V> computeNext() {
            int i = this.index;
            while (true) {
              this.index = i + 1;
              i = this.index;
              if (i < this.maxIndex) {
                Object object = DenseImmutableTable.ImmutableArrayMap.this.getValue(i);
                if (object != null)
                  return Maps.immutableEntry((K)DenseImmutableTable.ImmutableArrayMap.this.getKey(this.index), (V)object); 
                i = this.index;
                continue;
              } 
              return endOfData();
            } 
          }
        };
    }
    
    public V get(@Nullable Object param1Object) {
      param1Object = keyToIndex().get(param1Object);
      if (param1Object == null) {
        param1Object = null;
      } else {
        param1Object = getValue(param1Object.intValue());
      } 
      return (V)param1Object;
    }
    
    K getKey(int param1Int) {
      return keyToIndex().keySet().asList().get(param1Int);
    }
    
    @Nullable
    abstract V getValue(int param1Int);
    
    abstract ImmutableMap<K, Integer> keyToIndex();
    
    public int size() {
      return this.size;
    }
  }
  
  class null extends AbstractIterator<Map.Entry<K, V>> {
    private int index = -1;
    
    private final int maxIndex = this.this$0.keyToIndex().size();
    
    protected Map.Entry<K, V> computeNext() {
      int i = this.index;
      while (true) {
        this.index = i + 1;
        i = this.index;
        if (i < this.maxIndex) {
          Object object = this.this$0.getValue(i);
          if (object != null)
            return Maps.immutableEntry((K)this.this$0.getKey(this.index), (V)object); 
          i = this.index;
          continue;
        } 
        return endOfData();
      } 
    }
  }
  
  private final class Row extends ImmutableArrayMap<C, V> {
    private final int rowIndex;
    
    Row(int param1Int) {
      super(DenseImmutableTable.this.rowCounts[param1Int]);
      this.rowIndex = param1Int;
    }
    
    V getValue(int param1Int) {
      return (V)DenseImmutableTable.this.values[this.rowIndex][param1Int];
    }
    
    boolean isPartialView() {
      return true;
    }
    
    ImmutableMap<C, Integer> keyToIndex() {
      return DenseImmutableTable.this.columnKeyToIndex;
    }
  }
  
  private final class RowMap extends ImmutableArrayMap<R, Map<C, V>> {
    private RowMap() {
      super(DenseImmutableTable.this.rowCounts.length);
    }
    
    Map<C, V> getValue(int param1Int) {
      return new DenseImmutableTable.Row(param1Int);
    }
    
    boolean isPartialView() {
      return false;
    }
    
    ImmutableMap<R, Integer> keyToIndex() {
      return DenseImmutableTable.this.rowKeyToIndex;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\DenseImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */