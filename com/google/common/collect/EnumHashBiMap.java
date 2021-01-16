package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private transient Class<K> keyType;
  
  private EnumHashBiMap(Class<K> paramClass) {
    super(WellBehavedMap.wrap(new EnumMap<K, V>(paramClass)), Maps.newHashMapWithExpectedSize(((Enum[])paramClass.getEnumConstants()).length));
    this.keyType = paramClass;
  }
  
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> paramClass) {
    return new EnumHashBiMap<K, V>(paramClass);
  }
  
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> paramMap) {
    EnumHashBiMap<Enum, ?> enumHashBiMap = create(EnumBiMap.inferKeyType(paramMap));
    enumHashBiMap.putAll(paramMap);
    return (EnumHashBiMap)enumHashBiMap;
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.keyType = (Class<K>)paramObjectInputStream.readObject();
    setDelegates(WellBehavedMap.wrap(new EnumMap<K, V>(this.keyType)), new HashMap<V, K>(((Enum[])this.keyType.getEnumConstants()).length * 3 / 2));
    Serialization.populateMap(this, paramObjectInputStream);
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.keyType);
    Serialization.writeMap(this, paramObjectOutputStream);
  }
  
  K checkKey(K paramK) {
    return (K)Preconditions.checkNotNull(paramK);
  }
  
  @CanIgnoreReturnValue
  public V forcePut(K paramK, @Nullable V paramV) {
    return super.forcePut(paramK, paramV);
  }
  
  public Class<K> keyType() {
    return this.keyType;
  }
  
  @CanIgnoreReturnValue
  public V put(K paramK, @Nullable V paramV) {
    return super.put(paramK, paramV);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\EnumHashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */