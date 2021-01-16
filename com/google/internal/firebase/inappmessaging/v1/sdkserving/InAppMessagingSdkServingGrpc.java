package com.google.internal.firebase.inappmessaging.v1.sdkserving;

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.BindableService;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ExperimentalApi;
import io.grpc.MethodDescriptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServiceDescriptor;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;

public final class InAppMessagingSdkServingGrpc {
  private static final int METHODID_FETCH_ELIGIBLE_CAMPAIGNS = 0;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> METHOD_FETCH_ELIGIBLE_CAMPAIGNS = getFetchEligibleCampaignsMethodHelper();
  
  public static final String SERVICE_NAME = "google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing";
  
  private static volatile MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethod() {
    return getFetchEligibleCampaignsMethodHelper();
  }
  
  private static MethodDescriptor<FetchEligibleCampaignsRequest, FetchEligibleCampaignsResponse> getFetchEligibleCampaignsMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing'
    //   34: ldc 'FetchEligibleCampaigns'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/sdkserving/FetchEligibleCampaignsResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	78	finally
    //   23	72	78	finally
    //   72	75	78	finally
    //   79	82	78	finally
  }
  
  public static ServiceDescriptor getServiceDescriptor() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 54
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 42
    //   23: ldc 'google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServing'
    //   25: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   28: invokestatic getFetchEligibleCampaignsMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   31: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   34: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   37: astore_1
    //   38: aload_1
    //   39: putstatic com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   42: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc
    //   44: monitorexit
    //   45: goto -> 54
    //   48: astore_1
    //   49: ldc com/google/internal/firebase/inappmessaging/v1/sdkserving/InAppMessagingSdkServingGrpc
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    //   54: aload_1
    //   55: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	48	finally
    //   23	42	48	finally
    //   42	45	48	finally
    //   49	52	48	finally
  }
  
  public static InAppMessagingSdkServingBlockingStub newBlockingStub(Channel paramChannel) {
    return new InAppMessagingSdkServingBlockingStub(paramChannel);
  }
  
  public static InAppMessagingSdkServingFutureStub newFutureStub(Channel paramChannel) {
    return new InAppMessagingSdkServingFutureStub(paramChannel);
  }
  
  public static InAppMessagingSdkServingStub newStub(Channel paramChannel) {
    return new InAppMessagingSdkServingStub(paramChannel);
  }
  
  public static final class InAppMessagingSdkServingBlockingStub extends AbstractStub<InAppMessagingSdkServingBlockingStub> {
    private InAppMessagingSdkServingBlockingStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private InAppMessagingSdkServingBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected InAppMessagingSdkServingBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new InAppMessagingSdkServingBlockingStub(param1Channel, param1CallOptions);
    }
    
    public FetchEligibleCampaignsResponse fetchEligibleCampaigns(FetchEligibleCampaignsRequest param1FetchEligibleCampaignsRequest) {
      return (FetchEligibleCampaignsResponse)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethodHelper(), getCallOptions(), param1FetchEligibleCampaignsRequest);
    }
  }
  
  public static final class InAppMessagingSdkServingFutureStub extends AbstractStub<InAppMessagingSdkServingFutureStub> {
    private InAppMessagingSdkServingFutureStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private InAppMessagingSdkServingFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected InAppMessagingSdkServingFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new InAppMessagingSdkServingFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<FetchEligibleCampaignsResponse> fetchEligibleCampaigns(FetchEligibleCampaignsRequest param1FetchEligibleCampaignsRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethodHelper(), getCallOptions()), param1FetchEligibleCampaignsRequest);
    }
  }
  
  public static abstract class InAppMessagingSdkServingImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(InAppMessagingSdkServingGrpc.getServiceDescriptor()).addMethod(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingSdkServingGrpc.MethodHandlers<Object, Object>(this, 0))).build();
    }
    
    public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest param1FetchEligibleCampaignsRequest, StreamObserver<FetchEligibleCampaignsResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethodHelper(), param1StreamObserver);
    }
  }
  
  public static final class InAppMessagingSdkServingStub extends AbstractStub<InAppMessagingSdkServingStub> {
    private InAppMessagingSdkServingStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private InAppMessagingSdkServingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected InAppMessagingSdkServingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new InAppMessagingSdkServingStub(param1Channel, param1CallOptions);
    }
    
    public void fetchEligibleCampaigns(FetchEligibleCampaignsRequest param1FetchEligibleCampaignsRequest, StreamObserver<FetchEligibleCampaignsResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingSdkServingGrpc.getFetchEligibleCampaignsMethodHelper(), getCallOptions()), param1FetchEligibleCampaignsRequest, param1StreamObserver);
    }
  }
  
  private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final int methodId;
    
    private final InAppMessagingSdkServingGrpc.InAppMessagingSdkServingImplBase serviceImpl;
    
    MethodHandlers(InAppMessagingSdkServingGrpc.InAppMessagingSdkServingImplBase param1InAppMessagingSdkServingImplBase, int param1Int) {
      this.serviceImpl = param1InAppMessagingSdkServingImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      if (this.methodId == 0) {
        this.serviceImpl.fetchEligibleCampaigns((FetchEligibleCampaignsRequest)param1Req, (StreamObserver)param1StreamObserver);
        return;
      } 
      throw new AssertionError();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\sdkserving\InAppMessagingSdkServingGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */