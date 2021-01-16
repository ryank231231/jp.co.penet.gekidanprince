package io.grpc;

import com.google.common.base.MoreObjects;

abstract class PartialForwardingServerCallListener<ReqT> extends ServerCall.Listener<ReqT> {
  protected abstract ServerCall.Listener<?> delegate();
  
  public void onCancel() {
    delegate().onCancel();
  }
  
  public void onComplete() {
    delegate().onComplete();
  }
  
  public void onHalfClose() {
    delegate().onHalfClose();
  }
  
  public void onReady() {
    delegate().onReady();
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\PartialForwardingServerCallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */