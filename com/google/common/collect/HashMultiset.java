package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private HashMultiset() {
    super(new HashMap<E, Count>());
  }
  
  private HashMultiset(int paramInt) {
    super(Maps.newHashMapWithExpectedSize(paramInt));
  }
  
  public static <E> HashMultiset<E> create() {
    return new HashMultiset<E>();
  }
  
  public static <E> HashMultiset<E> create(int paramInt) {
    return new HashMultiset<E>(paramInt);
  }
  
  public static <E> HashMultiset<E> create(Iterable<? extends E> paramIterable) {
    HashMultiset<?> hashMultiset = create(Multisets.inferDistinctElements(paramIterable));
    Iterables.addAll(hashMultiset, paramIterable);
    return (HashMultiset)hashMultiset;
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    int i = Serialization.readCount(paramObjectInputStream);
    setBackingMap(Maps.newHashMap());
    Serialization.populateMultiset(this, paramObjectInputStream, i);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\HashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */