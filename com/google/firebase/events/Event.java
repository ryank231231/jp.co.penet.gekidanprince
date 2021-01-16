package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public class Event<T> {
  private final T payload;
  
  private final Class<T> type;
  
  @KeepForSdk
  public Event(Class<T> paramClass, T paramT) {
    this.type = (Class<T>)Preconditions.checkNotNull(paramClass);
    this.payload = (T)Preconditions.checkNotNull(paramT);
  }
  
  @KeepForSdk
  public T getPayload() {
    return this.payload;
  }
  
  @KeepForSdk
  public Class<T> getType() {
    return this.type;
  }
  
  public String toString() {
    return String.format("Event{type: %s, payload: %s}", new Object[] { this.type, this.payload });
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\events\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */