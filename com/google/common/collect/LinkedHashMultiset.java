package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private LinkedHashMultiset() {
    super(new LinkedHashMap<E, Count>());
  }
  
  private LinkedHashMultiset(int paramInt) {
    super(Maps.newLinkedHashMapWithExpectedSize(paramInt));
  }
  
  public static <E> LinkedHashMultiset<E> create() {
    return new LinkedHashMultiset<E>();
  }
  
  public static <E> LinkedHashMultiset<E> create(int paramInt) {
    return new LinkedHashMultiset<E>(paramInt);
  }
  
  public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> paramIterable) {
    LinkedHashMultiset<?> linkedHashMultiset = create(Multisets.inferDistinctElements(paramIterable));
    Iterables.addAll(linkedHashMultiset, paramIterable);
    return (LinkedHashMultiset)linkedHashMultiset;
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    int i = Serialization.readCount(paramObjectInputStream);
    setBackingMap(new LinkedHashMap<E, Count>());
    Serialization.populateMultiset(this, paramObjectInputStream, i);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\LinkedHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */