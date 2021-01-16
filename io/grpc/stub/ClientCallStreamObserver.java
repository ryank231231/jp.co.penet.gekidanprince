package io.grpc.stub;

import com.google.errorprone.annotations.DoNotMock;
import io.grpc.ExperimentalApi;
import javax.annotation.Nullable;

@DoNotMock
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1788")
public abstract class ClientCallStreamObserver<V> extends CallStreamObserver<V> {
  public abstract void cancel(@Nullable String paramString, @Nullable Throwable paramThrowable);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\ClientCallStreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */