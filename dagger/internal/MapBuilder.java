package dagger.internal;

import java.util.Collections;
import java.util.Map;

public final class MapBuilder<K, V> {
  private final Map<K, V> contributions;
  
  private MapBuilder(int paramInt) {
    this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(paramInt);
  }
  
  public static <K, V> MapBuilder<K, V> newMapBuilder(int paramInt) {
    return new MapBuilder<K, V>(paramInt);
  }
  
  public Map<K, V> build() {
    return (this.contributions.size() != 0) ? Collections.unmodifiableMap(this.contributions) : Collections.emptyMap();
  }
  
  public MapBuilder<K, V> put(K paramK, V paramV) {
    this.contributions.put(paramK, paramV);
    return this;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\MapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */