package io.grpc.stub;

import com.google.errorprone.annotations.DoNotMock;
import io.grpc.ExperimentalApi;

@DoNotMock
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1788")
public abstract class ServerCallStreamObserver<V> extends CallStreamObserver<V> {
  public abstract boolean isCancelled();
  
  public abstract void setCompression(String paramString);
  
  public abstract void setOnCancelHandler(Runnable paramRunnable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\ServerCallStreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */