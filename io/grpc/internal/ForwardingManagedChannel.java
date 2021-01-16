package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.concurrent.TimeUnit;

abstract class ForwardingManagedChannel extends ManagedChannel {
  private final ManagedChannel delegate;
  
  ForwardingManagedChannel(ManagedChannel paramManagedChannel) {
    this.delegate = paramManagedChannel;
  }
  
  public String authority() {
    return this.delegate.authority();
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.delegate.awaitTermination(paramLong, paramTimeUnit);
  }
  
  public void enterIdle() {
    this.delegate.enterIdle();
  }
  
  public ConnectivityState getState(boolean paramBoolean) {
    return this.delegate.getState(paramBoolean);
  }
  
  public boolean isShutdown() {
    return this.delegate.isShutdown();
  }
  
  public boolean isTerminated() {
    return this.delegate.isTerminated();
  }
  
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(MethodDescriptor<RequestT, ResponseT> paramMethodDescriptor, CallOptions paramCallOptions) {
    return this.delegate.newCall(paramMethodDescriptor, paramCallOptions);
  }
  
  public void notifyWhenStateChanged(ConnectivityState paramConnectivityState, Runnable paramRunnable) {
    this.delegate.notifyWhenStateChanged(paramConnectivityState, paramRunnable);
  }
  
  public void resetConnectBackoff() {
    this.delegate.resetConnectBackoff();
  }
  
  public ManagedChannel shutdown() {
    return this.delegate.shutdown();
  }
  
  public ManagedChannel shutdownNow() {
    return this.delegate.shutdownNow();
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", this.delegate).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ForwardingManagedChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */