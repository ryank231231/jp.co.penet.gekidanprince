package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private transient Class<K> keyType;
  
  private transient Class<V> valueType;
  
  private EnumBiMap(Class<K> paramClass, Class<V> paramClass1) {
    super(WellBehavedMap.wrap(new EnumMap<K, V>(paramClass)), WellBehavedMap.wrap((Map)new EnumMap<V, Object>(paramClass1)));
    this.keyType = paramClass;
    this.valueType = paramClass1;
  }
  
  public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> paramClass, Class<V> paramClass1) {
    return new EnumBiMap<K, V>(paramClass, paramClass1);
  }
  
  public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> paramMap) {
    EnumBiMap<Enum, Enum> enumBiMap = create(inferKeyType(paramMap), inferValueType(paramMap));
    enumBiMap.putAll(paramMap);
    return (EnumBiMap)enumBiMap;
  }
  
  static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> paramMap) {
    if (paramMap instanceof EnumBiMap)
      return ((EnumBiMap)paramMap).keyType(); 
    if (paramMap instanceof EnumHashBiMap)
      return ((EnumHashBiMap)paramMap).keyType(); 
    Preconditions.checkArgument(paramMap.isEmpty() ^ true);
    return ((Enum<K>)paramMap.keySet().iterator().next()).getDeclaringClass();
  }
  
  private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> paramMap) {
    if (paramMap instanceof EnumBiMap)
      return ((EnumBiMap)paramMap).valueType; 
    Preconditions.checkArgument(paramMap.isEmpty() ^ true);
    return ((Enum<V>)paramMap.values().iterator().next()).getDeclaringClass();
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.keyType = (Class<K>)paramObjectInputStream.readObject();
    this.valueType = (Class<V>)paramObjectInputStream.readObject();
    setDelegates(WellBehavedMap.wrap(new EnumMap<K, V>(this.keyType)), WellBehavedMap.wrap((Map)new EnumMap<V, Object>(this.valueType)));
    Serialization.populateMap(this, paramObjectInputStream);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.keyType);
    paramObjectOutputStream.writeObject(this.valueType);
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  K checkKey(K paramK) {
    return (K)Preconditions.checkNotNull(paramK);
  }
  
  V checkValue(V paramV) {
    return (V)Preconditions.checkNotNull(paramV);
  }
  
  public Class<K> keyType() {
    return this.keyType;
  }
  
  public Class<V> valueType() {
    return this.valueType;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\EnumBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */