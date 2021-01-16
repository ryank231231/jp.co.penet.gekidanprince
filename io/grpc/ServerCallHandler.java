package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ServerCallHandler<RequestT, ResponseT> {
  ServerCall.Listener<RequestT> startCall(ServerCall<RequestT, ResponseT> paramServerCall, Metadata paramMetadata);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerCallHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */