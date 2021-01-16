package io.grpc;

import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;

abstract class PartialForwardingClientCall<ReqT, RespT> extends ClientCall<ReqT, RespT> {
  public void cancel(@Nullable String paramString, @Nullable Throwable paramThrowable) {
    delegate().cancel(paramString, paramThrowable);
  }
  
  protected abstract ClientCall<?, ?> delegate();
  
  public Attributes getAttributes() {
    return delegate().getAttributes();
  }
  
  public void halfClose() {
    delegate().halfClose();
  }
  
  public boolean isReady() {
    return delegate().isReady();
  }
  
  public void request(int paramInt) {
    delegate().request(paramInt);
  }
  
  public void setMessageCompression(boolean paramBoolean) {
    delegate().setMessageCompression(paramBoolean);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\PartialForwardingClientCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */