package com.google.firebase.events;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

@KeepForSdk
public interface Subscriber {
  @KeepForSdk
  <T> void subscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler);
  
  @KeepForSdk
  <T> void subscribe(Class<T> paramClass, Executor paramExecutor, EventHandler<? super T> paramEventHandler);
  
  @KeepForSdk
  <T> void unsubscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler);
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\events\Subscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */