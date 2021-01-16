package io.grpc;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1764")
@Immutable
public final class Attributes {
  public static final Attributes EMPTY = new Attributes(Collections.emptyMap());
  
  private final Map<Key<?>, Object> data;
  
  private Attributes(Map<Key<?>, Object> paramMap) {
    this.data = paramMap;
  }
  
  public static Builder newBuilder() {
    return new Builder(EMPTY);
  }
  
  public static Builder newBuilder(Attributes paramAttributes) {
    Preconditions.checkNotNull(paramAttributes, "base");
    return new Builder(paramAttributes);
  }
  
  public boolean equals(Map.Entry<Key<?>, Object> paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    Attributes attributes = (Attributes)paramObject;
    if (this.data.size() != attributes.data.size())
      return false; 
    for (Map.Entry<Key<?>, Object> paramObject : this.data.entrySet()) {
      if (!attributes.data.containsKey(paramObject.getKey()))
        return false; 
      if (!Objects.equal(paramObject.getValue(), attributes.data.get(paramObject.getKey())))
        return false; 
    } 
    return true;
  }
  
  @Nullable
  public <T> T get(Key<T> paramKey) {
    return (T)this.data.get(paramKey);
  }
  
  public int hashCode() {
    return this.data.hashCode();
  }
  
  public Set<Key<?>> keys() {
    return Collections.unmodifiableSet(this.data.keySet());
  }
  
  public String toString() {
    return this.data.toString();
  }
  
  public static final class Builder {
    private Attributes base;
    
    private Map<Attributes.Key<?>, Object> newdata;
    
    private Builder(Attributes param1Attributes) {
      this.base = param1Attributes;
    }
    
    private Map<Attributes.Key<?>, Object> data(int param1Int) {
      if (this.newdata == null)
        this.newdata = new IdentityHashMap<Attributes.Key<?>, Object>(param1Int); 
      return this.newdata;
    }
    
    public Attributes build() {
      if (this.newdata != null) {
        for (Map.Entry entry : this.base.data.entrySet()) {
          if (!this.newdata.containsKey(entry.getKey()))
            this.newdata.put((Attributes.Key<?>)entry.getKey(), entry.getValue()); 
        } 
        this.base = new Attributes(this.newdata);
        this.newdata = null;
      } 
      return this.base;
    }
    
    public <T> Builder set(Attributes.Key<T> param1Key, T param1T) {
      data(1).put(param1Key, param1T);
      return this;
    }
    
    public <T> Builder setAll(Attributes param1Attributes) {
      data(param1Attributes.data.size()).putAll(param1Attributes.data);
      return this;
    }
  }
  
  @Immutable
  public static final class Key<T> {
    private final String name;
    
    private Key(String param1String) {
      this.name = param1String;
    }
    
    public static <T> Key<T> of(String param1String) {
      return new Key<T>(param1String);
    }
    
    public String toString() {
      return this.name;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Attributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */