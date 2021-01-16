package dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

public final class MapFactory<K, V> implements Factory<Map<K, V>> {
  private static final Provider<Map<Object, Object>> EMPTY = InstanceFactory.create(Collections.emptyMap());
  
  private final Map<K, Provider<V>> contributingMap;
  
  private MapFactory(Map<K, Provider<V>> paramMap) {
    this.contributingMap = Collections.unmodifiableMap(paramMap);
  }
  
  public static <K, V> Builder<K, V> builder(int paramInt) {
    return new Builder<K, V>(paramInt);
  }
  
  public static <K, V> Provider<Map<K, V>> emptyMapProvider() {
    return (Provider)EMPTY;
  }
  
  public Map<K, V> get() {
    LinkedHashMap<?, ?> linkedHashMap = DaggerCollections.newLinkedHashMapWithExpectedSize(this.contributingMap.size());
    for (Map.Entry<K, Provider<V>> entry : this.contributingMap.entrySet())
      linkedHashMap.put(entry.getKey(), ((Provider)entry.getValue()).get()); 
    return Collections.unmodifiableMap((Map)linkedHashMap);
  }
  
  public static final class Builder<K, V> {
    private final LinkedHashMap<K, Provider<V>> map;
    
    private Builder(int param1Int) {
      this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(param1Int);
    }
    
    public MapFactory<K, V> build() {
      return new MapFactory<K, V>(this.map);
    }
    
    public Builder<K, V> put(K param1K, Provider<V> param1Provider) {
      this.map.put(Preconditions.checkNotNull(param1K, "key"), Preconditions.checkNotNull(param1Provider, "provider"));
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\MapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */