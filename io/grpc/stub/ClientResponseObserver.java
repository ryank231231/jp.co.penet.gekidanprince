package io.grpc.stub;

import io.grpc.ExperimentalApi;

@ExperimentalApi
public interface ClientResponseObserver<ReqT, RespT> extends StreamObserver<RespT> {
  void beforeStart(ClientCallStreamObserver<ReqT> paramClientCallStreamObserver);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\ClientResponseObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */