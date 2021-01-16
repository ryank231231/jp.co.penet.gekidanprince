package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface EventHandler<T> {
  @KeepForSdk
  void handle(Event<T> paramEvent);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\events\EventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */