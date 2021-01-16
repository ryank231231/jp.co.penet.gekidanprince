package io.grpc;

@Internal
public final class InternalServerInterceptors {
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> interceptCallHandler(ServerInterceptor paramServerInterceptor, ServerCallHandler<ReqT, RespT> paramServerCallHandler) {
    return ServerInterceptors.InterceptCallHandler.create(paramServerInterceptor, paramServerCallHandler);
  }
  
  public static <ReqT, RespT> ServerMethodDefinition<ReqT, RespT> wrapMethod(ServerMethodDefinition<?, ?> paramServerMethodDefinition, MethodDescriptor<ReqT, RespT> paramMethodDescriptor) {
    return ServerInterceptors.wrapMethod(paramServerMethodDefinition, paramMethodDescriptor);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\InternalServerInterceptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */