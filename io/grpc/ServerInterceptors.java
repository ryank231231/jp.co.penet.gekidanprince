package io.grpc;

import com.google.common.base.Preconditions;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ServerInterceptors {
  public static ServerServiceDefinition intercept(BindableService paramBindableService, List<? extends ServerInterceptor> paramList) {
    Preconditions.checkNotNull(paramBindableService, "bindableService");
    return intercept(paramBindableService.bindService(), paramList);
  }
  
  public static ServerServiceDefinition intercept(BindableService paramBindableService, ServerInterceptor... paramVarArgs) {
    Preconditions.checkNotNull(paramBindableService, "bindableService");
    return intercept(paramBindableService.bindService(), Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition intercept(ServerServiceDefinition paramServerServiceDefinition, List<? extends ServerInterceptor> paramList) {
    Preconditions.checkNotNull(paramServerServiceDefinition, "serviceDef");
    if (paramList.isEmpty())
      return paramServerServiceDefinition; 
    ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(paramServerServiceDefinition.getServiceDescriptor());
    Iterator<ServerMethodDefinition<?, ?>> iterator = paramServerServiceDefinition.getMethods().iterator();
    while (iterator.hasNext())
      wrapAndAddMethod(builder, iterator.next(), paramList); 
    return builder.build();
  }
  
  public static ServerServiceDefinition intercept(ServerServiceDefinition paramServerServiceDefinition, ServerInterceptor... paramVarArgs) {
    return intercept(paramServerServiceDefinition, Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition interceptForward(BindableService paramBindableService, List<? extends ServerInterceptor> paramList) {
    return interceptForward(paramBindableService.bindService(), paramList);
  }
  
  public static ServerServiceDefinition interceptForward(BindableService paramBindableService, ServerInterceptor... paramVarArgs) {
    return interceptForward(paramBindableService.bindService(), Arrays.asList(paramVarArgs));
  }
  
  public static ServerServiceDefinition interceptForward(ServerServiceDefinition paramServerServiceDefinition, List<? extends ServerInterceptor> paramList) {
    paramList = new ArrayList<ServerInterceptor>(paramList);
    Collections.reverse(paramList);
    return intercept(paramServerServiceDefinition, paramList);
  }
  
  public static ServerServiceDefinition interceptForward(ServerServiceDefinition paramServerServiceDefinition, ServerInterceptor... paramVarArgs) {
    return interceptForward(paramServerServiceDefinition, Arrays.asList(paramVarArgs));
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
  public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition paramServerServiceDefinition) {
    return useMarshalledMessages(paramServerServiceDefinition, new MethodDescriptor$Marshaller<InputStream>() {
          public InputStream parse(InputStream param1InputStream) {
            return param1InputStream.markSupported() ? param1InputStream : new BufferedInputStream(param1InputStream);
          }
          
          public InputStream stream(InputStream param1InputStream) {
            return param1InputStream;
          }
        });
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1712")
  public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition paramServerServiceDefinition, MethodDescriptor$Marshaller<T> paramMethodDescriptor$Marshaller) {
    ArrayList arrayList = new ArrayList();
    ArrayList<MethodDescriptor> arrayList1 = new ArrayList();
    for (ServerMethodDefinition<ReqT, RespT> serverMethodDefinition : paramServerServiceDefinition.getMethods()) {
      MethodDescriptor<?, ?> methodDescriptor = serverMethodDefinition.getMethodDescriptor().toBuilder(paramMethodDescriptor$Marshaller, paramMethodDescriptor$Marshaller).build();
      arrayList1.add(methodDescriptor);
      arrayList.add(wrapMethod(serverMethodDefinition, methodDescriptor));
    } 
    ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(new ServiceDescriptor(paramServerServiceDefinition.getServiceDescriptor().getName(), (Collection)arrayList1));
    Iterator<ServerMethodDefinition<?, ?>> iterator = arrayList.iterator();
    while (iterator.hasNext())
      builder.addMethod(iterator.next()); 
    return builder.build();
  }
  
  private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder paramBuilder, ServerMethodDefinition<ReqT, RespT> paramServerMethodDefinition, List<? extends ServerInterceptor> paramList) {
    ServerCallHandler<ReqT, RespT> serverCallHandler2 = paramServerMethodDefinition.getServerCallHandler();
    Iterator<? extends ServerInterceptor> iterator = paramList.iterator();
    ServerCallHandler<ReqT, RespT> serverCallHandler1;
    for (serverCallHandler1 = serverCallHandler2; iterator.hasNext(); serverCallHandler1 = InterceptCallHandler.create(iterator.next(), serverCallHandler1));
    paramBuilder.addMethod(paramServerMethodDefinition.withServerCallHandler(serverCallHandler1));
  }
  
  private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> originalHandler, final MethodDescriptor<OReqT, ORespT> originalMethod, final MethodDescriptor<WReqT, WRespT> wrappedMethod) {
    return new ServerCallHandler<WReqT, WRespT>() {
        public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> call, Metadata param1Metadata) {
          call = new PartialForwardingServerCall() {
              protected ServerCall<WReqT, WRespT> delegate() {
                return call;
              }
              
              public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                return originalMethod;
              }
              
              public void sendMessage(ORespT param2ORespT) {
                InputStream inputStream = originalMethod.streamResponse(param2ORespT);
                Object object = wrappedMethod.parseResponse(inputStream);
                delegate().sendMessage((WRespT)object);
              }
            };
          return new PartialForwardingServerCallListener() {
              protected ServerCall.Listener<OReqT> delegate() {
                return originalListener;
              }
              
              public void onMessage(WReqT param2WReqT) {
                InputStream inputStream = wrappedMethod.streamRequest(param2WReqT);
                Object object = originalMethod.parseRequest(inputStream);
                delegate().onMessage((OReqT)object);
              }
            };
        }
      };
  }
  
  static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> paramServerMethodDefinition, MethodDescriptor<WReqT, WRespT> paramMethodDescriptor) {
    return ServerMethodDefinition.create(paramMethodDescriptor, wrapHandler(paramServerMethodDefinition.getServerCallHandler(), paramServerMethodDefinition.getMethodDescriptor(), paramMethodDescriptor));
  }
  
  static final class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
    private final ServerCallHandler<ReqT, RespT> callHandler;
    
    private final ServerInterceptor interceptor;
    
    private InterceptCallHandler(ServerInterceptor param1ServerInterceptor, ServerCallHandler<ReqT, RespT> param1ServerCallHandler) {
      this.interceptor = (ServerInterceptor)Preconditions.checkNotNull(param1ServerInterceptor, "interceptor");
      this.callHandler = param1ServerCallHandler;
    }
    
    public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor param1ServerInterceptor, ServerCallHandler<ReqT, RespT> param1ServerCallHandler) {
      return new InterceptCallHandler<ReqT, RespT>(param1ServerInterceptor, param1ServerCallHandler);
    }
    
    public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> param1ServerCall, Metadata param1Metadata) {
      return this.interceptor.interceptCall(param1ServerCall, param1Metadata, this.callHandler);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerInterceptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */