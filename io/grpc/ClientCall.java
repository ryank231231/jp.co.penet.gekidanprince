package io.grpc;

import com.google.errorprone.annotations.DoNotMock;
import javax.annotation.Nullable;

@DoNotMock("Use InProcessServerBuilder and make a test server instead")
public abstract class ClientCall<ReqT, RespT> {
  public abstract void cancel(@Nullable String paramString, @Nullable Throwable paramThrowable);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2607")
  public Attributes getAttributes() {
    return Attributes.EMPTY;
  }
  
  public abstract void halfClose();
  
  public boolean isReady() {
    return true;
  }
  
  public abstract void request(int paramInt);
  
  public abstract void sendMessage(ReqT paramReqT);
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1703")
  public void setMessageCompression(boolean paramBoolean) {}
  
  public abstract void start(Listener<RespT> paramListener, Metadata paramMetadata);
  
  public static abstract class Listener<T> {
    public void onClose(Status param1Status, Metadata param1Metadata) {}
    
    public void onHeaders(Metadata param1Metadata) {}
    
    public void onMessage(T param1T) {}
    
    public void onReady() {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ClientCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */