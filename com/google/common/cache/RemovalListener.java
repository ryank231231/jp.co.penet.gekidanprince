package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface RemovalListener<K, V> {
  void onRemoval(RemovalNotification<K, V> paramRemovalNotification);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\cache\RemovalListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */