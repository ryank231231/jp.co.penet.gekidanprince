package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ServerInterceptor {
  <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> paramServerCall, Metadata paramMetadata, ServerCallHandler<ReqT, RespT> paramServerCallHandler);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */