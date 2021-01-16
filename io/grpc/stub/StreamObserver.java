package io.grpc.stub;

public interface StreamObserver<V> {
  void onCompleted();
  
  void onError(Throwable paramThrowable);
  
  void onNext(V paramV);
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\StreamObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */