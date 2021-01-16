package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public final class ArrayListMultimap<K, V> extends AbstractListMultimap<K, V> {
  private static final int DEFAULT_VALUES_PER_KEY = 3;
  
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  @VisibleForTesting
  transient int expectedValuesPerKey;
  
  private ArrayListMultimap() {
    super(new HashMap<K, Collection<V>>());
    this.expectedValuesPerKey = 3;
  }
  
  private ArrayListMultimap(int paramInt1, int paramInt2) {
    super(Maps.newHashMapWithExpectedSize(paramInt1));
    CollectPreconditions.checkNonnegative(paramInt2, "expectedValuesPerKey");
    this.expectedValuesPerKey = paramInt2;
  }
  
  private ArrayListMultimap(Multimap<? extends K, ? extends V> paramMultimap) {
    this(i, b);
    byte b;
    putAll(paramMultimap);
  }
  
  public static <K, V> ArrayListMultimap<K, V> create() {
    return new ArrayListMultimap<K, V>();
  }
  
  public static <K, V> ArrayListMultimap<K, V> create(int paramInt1, int paramInt2) {
    return new ArrayListMultimap<K, V>(paramInt1, paramInt2);
  }
  
  public static <K, V> ArrayListMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap) {
    return new ArrayListMultimap<K, V>(paramMultimap);
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.expectedValuesPerKey = 3;
    int i = Serialization.readCount(paramObjectInputStream);
    setMap(Maps.newHashMap());
    Serialization.populateMultimap(this, paramObjectInputStream, i);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultimap(this, paramObjectOutputStream);
  }
  
  List<V> createCollection() {
    return new ArrayList<V>(this.expectedValuesPerKey);
  }
  
  public void trimToSize() {
    Iterator<ArrayList> iterator = backingMap().values().iterator();
    while (iterator.hasNext())
      ((ArrayList)iterator.next()).trimToSize(); 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ArrayListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */