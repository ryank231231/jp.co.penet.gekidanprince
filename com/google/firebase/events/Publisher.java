package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface Publisher {
  @KeepForSdk
  void publish(Event<?> paramEvent);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\events\Publisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */