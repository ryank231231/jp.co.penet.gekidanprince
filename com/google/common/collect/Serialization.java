package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@GwtIncompatible
final class Serialization {
  static <T> FieldSetter<T> getFieldSetter(Class<T> paramClass, String paramString) {
    try {
      return new FieldSetter(paramClass.getDeclaredField(paramString));
    } catch (NoSuchFieldException noSuchFieldException) {
      throw new AssertionError(noSuchFieldException);
    } 
  }
  
  static <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    populateMap(paramMap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <K, V> void populateMap(Map<K, V> paramMap, ObjectInputStream paramObjectInputStream, int paramInt) throws IOException, ClassNotFoundException {
    for (byte b = 0; b < paramInt; b++)
      paramMap.put((K)paramObjectInputStream.readObject(), (V)paramObjectInputStream.readObject()); 
  }
  
  static <K, V> void populateMultimap(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    populateMultimap(paramMultimap, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <K, V> void populateMultimap(Multimap<K, V> paramMultimap, ObjectInputStream paramObjectInputStream, int paramInt) throws IOException, ClassNotFoundException {
    for (byte b = 0; b < paramInt; b++) {
      Collection<V> collection = paramMultimap.get((K)paramObjectInputStream.readObject());
      int i = paramObjectInputStream.readInt();
      for (byte b1 = 0; b1 < i; b1++)
        collection.add((V)paramObjectInputStream.readObject()); 
    } 
  }
  
  static <E> void populateMultiset(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    populateMultiset(paramMultiset, paramObjectInputStream, paramObjectInputStream.readInt());
  }
  
  static <E> void populateMultiset(Multiset<E> paramMultiset, ObjectInputStream paramObjectInputStream, int paramInt) throws IOException, ClassNotFoundException {
    for (byte b = 0; b < paramInt; b++)
      paramMultiset.add((E)paramObjectInputStream.readObject(), paramObjectInputStream.readInt()); 
  }
  
  static int readCount(ObjectInputStream paramObjectInputStream) throws IOException {
    return paramObjectInputStream.readInt();
  }
  
  static <K, V> void writeMap(Map<K, V> paramMap, ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.writeInt(paramMap.size());
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      paramObjectOutputStream.writeObject(entry.getKey());
      paramObjectOutputStream.writeObject(entry.getValue());
    } 
  }
  
  static <K, V> void writeMultimap(Multimap<K, V> paramMultimap, ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.writeInt(paramMultimap.asMap().size());
    for (Map.Entry entry : paramMultimap.asMap().entrySet()) {
      paramObjectOutputStream.writeObject(entry.getKey());
      paramObjectOutputStream.writeInt(((Collection)entry.getValue()).size());
      Iterator iterator = ((Collection)entry.getValue()).iterator();
      while (iterator.hasNext())
        paramObjectOutputStream.writeObject(iterator.next()); 
    } 
  }
  
  static <E> void writeMultiset(Multiset<E> paramMultiset, ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.writeInt(paramMultiset.entrySet().size());
    for (Multiset.Entry<E> entry : paramMultiset.entrySet()) {
      paramObjectOutputStream.writeObject(entry.getElement());
      paramObjectOutputStream.writeInt(entry.getCount());
    } 
  }
  
  static final class FieldSetter<T> {
    private final Field field;
    
    private FieldSetter(Field param1Field) {
      this.field = param1Field;
      param1Field.setAccessible(true);
    }
    
    void set(T param1T, int param1Int) {
      try {
        this.field.set(param1T, Integer.valueOf(param1Int));
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError(illegalAccessException);
      } 
    }
    
    void set(T param1T, Object param1Object) {
      try {
        this.field.set(param1T, param1Object);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        throw new AssertionError(illegalAccessException);
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Serialization.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */