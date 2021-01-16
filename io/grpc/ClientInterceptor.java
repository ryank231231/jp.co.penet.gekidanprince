package io.grpc;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ClientInterceptor {
  <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, Channel paramChannel);
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\ClientInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */