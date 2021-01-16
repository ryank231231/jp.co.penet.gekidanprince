package dagger.internal;

import dagger.Lazy;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

public final class MapProviderFactory<K, V> implements Factory<Map<K, Provider<V>>>, Lazy<Map<K, Provider<V>>> {
  private final Map<K, Provider<V>> contributingMap;
  
  private MapProviderFactory(Map<K, Provider<V>> paramMap) {
    this.contributingMap = Collections.unmodifiableMap(paramMap);
  }
  
  public static <K, V> Builder<K, V> builder(int paramInt) {
    return new Builder<K, V>(paramInt);
  }
  
  public Map<K, Provider<V>> get() {
    return this.contributingMap;
  }
  
  public static final class Builder<K, V> {
    private final LinkedHashMap<K, Provider<V>> map;
    
    private Builder(int param1Int) {
      this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(param1Int);
    }
    
    public MapProviderFactory<K, V> build() {
      return new MapProviderFactory<K, V>(this.map);
    }
    
    public Builder<K, V> put(K param1K, Provider<V> param1Provider) {
      this.map.put(Preconditions.checkNotNull(param1K, "key"), Preconditions.checkNotNull(param1Provider, "provider"));
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\MapProviderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */