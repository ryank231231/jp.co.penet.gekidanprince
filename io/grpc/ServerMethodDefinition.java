package io.grpc;

public final class ServerMethodDefinition<ReqT, RespT> {
  private final ServerCallHandler<ReqT, RespT> handler;
  
  private final MethodDescriptor<ReqT, RespT> method;
  
  private ServerMethodDefinition(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, ServerCallHandler<ReqT, RespT> paramServerCallHandler) {
    this.method = paramMethodDescriptor;
    this.handler = paramServerCallHandler;
  }
  
  public static <ReqT, RespT> ServerMethodDefinition<ReqT, RespT> create(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, ServerCallHandler<ReqT, RespT> paramServerCallHandler) {
    return new ServerMethodDefinition<ReqT, RespT>(paramMethodDescriptor, paramServerCallHandler);
  }
  
  public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
    return this.method;
  }
  
  public ServerCallHandler<ReqT, RespT> getServerCallHandler() {
    return this.handler;
  }
  
  public ServerMethodDefinition<ReqT, RespT> withServerCallHandler(ServerCallHandler<ReqT, RespT> paramServerCallHandler) {
    return new ServerMethodDefinition(this.method, paramServerCallHandler);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerMethodDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */