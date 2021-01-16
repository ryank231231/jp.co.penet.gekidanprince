package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.Nullable;

@GwtCompatible
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
  private static final long serialVersionUID = 0L;
  
  private final RemovalCause cause;
  
  private RemovalNotification(@Nullable K paramK, @Nullable V paramV, RemovalCause paramRemovalCause) {
    super(paramK, paramV);
    this.cause = (RemovalCause)Preconditions.checkNotNull(paramRemovalCause);
  }
  
  public static <K, V> RemovalNotification<K, V> create(@Nullable K paramK, @Nullable V paramV, RemovalCause paramRemovalCause) {
    return new RemovalNotification<K, V>(paramK, paramV, paramRemovalCause);
  }
  
  public RemovalCause getCause() {
    return this.cause;
  }
  
  public boolean wasEvicted() {
    return this.cause.wasEvicted();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\RemovalNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */