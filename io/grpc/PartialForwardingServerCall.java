package io.grpc;

import com.google.common.base.MoreObjects;

abstract class PartialForwardingServerCall<ReqT, RespT> extends ServerCall<ReqT, RespT> {
  public void close(Status paramStatus, Metadata paramMetadata) {
    delegate().close(paramStatus, paramMetadata);
  }
  
  protected abstract ServerCall<?, ?> delegate();
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
  public Attributes getAttributes() {
    return delegate().getAttributes();
  }
  
  public String getAuthority() {
    return delegate().getAuthority();
  }
  
  public boolean isCancelled() {
    return delegate().isCancelled();
  }
  
  public boolean isReady() {
    return delegate().isReady();
  }
  
  public void request(int paramInt) {
    delegate().request(paramInt);
  }
  
  public void sendHeaders(Metadata paramMetadata) {
    delegate().sendHeaders(paramMetadata);
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public void setCompression(String paramString) {
    delegate().setCompression(paramString);
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
  public void setMessageCompression(boolean paramBoolean) {
    delegate().setMessageCompression(paramBoolean);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\PartialForwardingServerCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */