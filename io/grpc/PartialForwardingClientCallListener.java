package io.grpc;

import com.google.common.base.MoreObjects;

abstract class PartialForwardingClientCallListener<RespT> extends ClientCall.Listener<RespT> {
  protected abstract ClientCall.Listener<?> delegate();
  
  public void onClose(Status paramStatus, Metadata paramMetadata) {
    delegate().onClose(paramStatus, paramMetadata);
  }
  
  public void onHeaders(Metadata paramMetadata) {
    delegate().onHeaders(paramMetadata);
  }
  
  public void onReady() {
    delegate().onReady();
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\PartialForwardingClientCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */