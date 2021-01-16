package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ConnectivityState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
final class ConnectivityStateManager {
  private ArrayList<Listener> listeners = new ArrayList<Listener>();
  
  private volatile ConnectivityState state = ConnectivityState.IDLE;
  
  ConnectivityState getState() {
    ConnectivityState connectivityState = this.state;
    if (connectivityState != null)
      return connectivityState; 
    throw new UnsupportedOperationException("Channel state API is not implemented");
  }
  
  void gotoState(@Nonnull ConnectivityState paramConnectivityState) {
    Preconditions.checkNotNull(paramConnectivityState, "newState");
    if (this.state != paramConnectivityState && this.state != ConnectivityState.SHUTDOWN) {
      this.state = paramConnectivityState;
      if (this.listeners.isEmpty())
        return; 
      ArrayList<Listener> arrayList = this.listeners;
      this.listeners = new ArrayList<Listener>();
      Iterator<Listener> iterator = arrayList.iterator();
      while (iterator.hasNext())
        ((Listener)iterator.next()).runInExecutor(); 
    } 
  }
  
  void notifyWhenStateChanged(Runnable paramRunnable, Executor paramExecutor, ConnectivityState paramConnectivityState) {
    Preconditions.checkNotNull(paramRunnable, "callback");
    Preconditions.checkNotNull(paramExecutor, "executor");
    Preconditions.checkNotNull(paramConnectivityState, "source");
    Listener listener = new Listener(paramRunnable, paramExecutor);
    if (this.state != paramConnectivityState) {
      listener.runInExecutor();
    } else {
      this.listeners.add(listener);
    } 
  }
  
  class ConnectivityStateManager {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ConnectivityStateManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */