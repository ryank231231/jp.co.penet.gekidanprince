package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

@Beta
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
  private final ImmutableMap<TypeToken<? extends B>, B> delegate;
  
  private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> paramImmutableMap) {
    this.delegate = paramImmutableMap;
  }
  
  public static <B> Builder<B> builder() {
    return new Builder<B>();
  }
  
  public static <B> ImmutableTypeToInstanceMap<B> of() {
    return new ImmutableTypeToInstanceMap<B>(ImmutableMap.of());
  }
  
  private <T extends B> T trustedGet(TypeToken<T> paramTypeToken) {
    return (T)this.delegate.get(paramTypeToken);
  }
  
  protected Map<TypeToken<? extends B>, B> delegate() {
    return (Map<TypeToken<? extends B>, B>)this.delegate;
  }
  
  public <T extends B> T getInstance(TypeToken<T> paramTypeToken) {
    return trustedGet(paramTypeToken.rejectTypeVariables());
  }
  
  public <T extends B> T getInstance(Class<T> paramClass) {
    return trustedGet(TypeToken.of(paramClass));
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public B put(TypeToken<? extends B> paramTypeToken, B paramB) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(TypeToken<T> paramTypeToken, T paramT) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @CanIgnoreReturnValue
  public <T extends B> T putInstance(Class<T> paramClass, T paramT) {
    throw new UnsupportedOperationException();
  }
  
  @Beta
  public static final class Builder<B> {
    private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder = ImmutableMap.builder();
    
    private Builder() {}
    
    public ImmutableTypeToInstanceMap<B> build() {
      return new ImmutableTypeToInstanceMap<B>(this.mapBuilder.build());
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> put(TypeToken<T> param1TypeToken, T param1T) {
      this.mapBuilder.put(param1TypeToken.rejectTypeVariables(), param1T);
      return this;
    }
    
    @CanIgnoreReturnValue
    public <T extends B> Builder<B> put(Class<T> param1Class, T param1T) {
      this.mapBuilder.put(TypeToken.of(param1Class), param1T);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\ImmutableTypeToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */