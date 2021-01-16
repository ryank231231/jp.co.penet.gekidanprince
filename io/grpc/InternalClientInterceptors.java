package io.grpc;

@Internal
public class InternalClientInterceptors {
  public static <WReqT, WRespT> ClientInterceptor wrapClientInterceptor(ClientInterceptor paramClientInterceptor, MethodDescriptor$Marshaller<WReqT> paramMethodDescriptor$Marshaller, MethodDescriptor$Marshaller<WRespT> paramMethodDescriptor$Marshaller1) {
    return ClientInterceptors.wrapClientInterceptor(paramClientInterceptor, paramMethodDescriptor$Marshaller, paramMethodDescriptor$Marshaller1);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\InternalClientInterceptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */