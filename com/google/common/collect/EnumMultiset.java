package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends AbstractMapBasedMultiset<E> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private transient Class<E> type;
  
  private EnumMultiset(Class<E> paramClass) {
    super(WellBehavedMap.wrap(new EnumMap<E, Count>(paramClass)));
    this.type = paramClass;
  }
  
  public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> paramClass) {
    return new EnumMultiset<E>(paramClass);
  }
  
  public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> paramIterable) {
    Iterator<E> iterator = paramIterable.iterator();
    Preconditions.checkArgument(iterator.hasNext(), "EnumMultiset constructor passed empty Iterable");
    EnumMultiset<Enum> enumMultiset = new EnumMultiset<Enum>(((Enum<Enum>)iterator.next()).getDeclaringClass());
    Iterables.addAll(enumMultiset, paramIterable);
    return (EnumMultiset)enumMultiset;
  }
  
  public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> paramIterable, Class<E> paramClass) {
    EnumMultiset<E> enumMultiset = create(paramClass);
    Iterables.addAll(enumMultiset, paramIterable);
    return enumMultiset;
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.type = (Class<E>)paramObjectInputStream.readObject();
    setBackingMap(WellBehavedMap.wrap(new EnumMap<E, Count>(this.type)));
    Serialization.populateMultiset(this, paramObjectInputStream);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.type);
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\EnumMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */