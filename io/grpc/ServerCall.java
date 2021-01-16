package io.grpc;

import com.google.errorprone.annotations.DoNotMock;
import javax.annotation.Nullable;

@DoNotMock("Use InProcessTransport and make a fake server instead")
public abstract class ServerCall<ReqT, RespT> {
  public abstract void close(Status paramStatus, Metadata paramMetadata);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1779")
  public Attributes getAttributes() {
    return Attributes.EMPTY;
  }
  
  @Nullable
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2924")
  public String getAuthority() {
    return null;
  }
  
  public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();
  
  public abstract boolean isCancelled();
  
  public boolean isReady() {
    return true;
  }
  
  public abstract void request(int paramInt);
  
  public abstract void sendHeaders(Metadata paramMetadata);
  
  public abstract void sendMessage(RespT paramRespT);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public void setCompression(String paramString) {}
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public void setMessageCompression(boolean paramBoolean) {}
  
  public static abstract class Listener<ReqT> {
    public void onCancel() {}
    
    public void onComplete() {}
    
    public void onHalfClose() {}
    
    public void onMessage(ReqT param1ReqT) {}
    
    public void onReady() {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */