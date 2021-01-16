package io.grpc.stub;

import com.google.errorprone.annotations.DoNotMock;
import io.grpc.ExperimentalApi;

@DoNotMock
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1788")
public abstract class CallStreamObserver<V> implements StreamObserver<V> {
  public abstract void disableAutoInboundFlowControl();
  
  public abstract boolean isReady();
  
  public abstract void request(int paramInt);
  
  public abstract void setMessageCompression(boolean paramBoolean);
  
  public abstract void setOnReadyHandler(Runnable paramRunnable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\CallStreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */