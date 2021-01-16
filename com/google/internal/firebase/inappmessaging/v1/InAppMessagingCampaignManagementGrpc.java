package com.google.internal.firebase.inappmessaging.v1;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.Empty;
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

public final class InAppMessagingCampaignManagementGrpc {
  private static final int METHODID_CREATE_CAMPAIGN = 0;
  
  private static final int METHODID_DELETE_CAMPAIGN = 2;
  
  private static final int METHODID_GET_CONDITION_ESTIMATION = 5;
  
  private static final int METHODID_LIST_CAMPAIGNS = 3;
  
  private static final int METHODID_ROLLOUT_EXPERIMENTAL_CAMPAIGN = 4;
  
  private static final int METHODID_TEST_CAMPAIGN_ON_DEVICE = 6;
  
  private static final int METHODID_UPDATE_CAMPAIGN = 1;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> METHOD_CREATE_CAMPAIGN = getCreateCampaignMethodHelper();
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<DeleteCampaignRequest, Empty> METHOD_DELETE_CAMPAIGN;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> METHOD_GET_CONDITION_ESTIMATION;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> METHOD_LIST_CAMPAIGNS;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> METHOD_ROLLOUT_EXPERIMENTAL_CAMPAIGN;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<TestCampaignOnDeviceRequest, Empty> METHOD_TEST_CAMPAIGN_ON_DEVICE;
  
  @Deprecated
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> METHOD_UPDATE_CAMPAIGN = getUpdateCampaignMethodHelper();
  
  public static final String SERVICE_NAME = "google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement";
  
  private static volatile MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> getCreateCampaignMethod;
  
  private static volatile MethodDescriptor<DeleteCampaignRequest, Empty> getDeleteCampaignMethod;
  
  private static volatile MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> getGetConditionEstimationMethod;
  
  private static volatile MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> getListCampaignsMethod;
  
  private static volatile MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> getRolloutExperimentalCampaignMethod;
  
  private static volatile MethodDescriptor<TestCampaignOnDeviceRequest, Empty> getTestCampaignOnDeviceMethod;
  
  private static volatile MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> getUpdateCampaignMethod;
  
  private static volatile ServiceDescriptor serviceDescriptor;
  
  static {
    METHOD_DELETE_CAMPAIGN = getDeleteCampaignMethodHelper();
    METHOD_LIST_CAMPAIGNS = getListCampaignsMethodHelper();
    METHOD_ROLLOUT_EXPERIMENTAL_CAMPAIGN = getRolloutExperimentalCampaignMethodHelper();
    METHOD_GET_CONDITION_ESTIMATION = getGetConditionEstimationMethodHelper();
    METHOD_TEST_CAMPAIGN_ON_DEVICE = getTestCampaignOnDeviceMethodHelper();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> getCreateCampaignMethod() {
    return getCreateCampaignMethodHelper();
  }
  
  private static MethodDescriptor<CreateCampaignRequest, CampaignProto.Campaign> getCreateCampaignMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getCreateCampaignMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getCreateCampaignMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc 'CreateCampaign'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/CreateCampaignRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getCreateCampaignMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
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
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<DeleteCampaignRequest, Empty> getDeleteCampaignMethod() {
    return getDeleteCampaignMethodHelper();
  }
  
  private static MethodDescriptor<DeleteCampaignRequest, Empty> getDeleteCampaignMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc 'DeleteCampaign'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/DeleteCampaignRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/protobuf/Empty;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
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
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> getGetConditionEstimationMethod() {
    return getGetConditionEstimationMethodHelper();
  }
  
  private static MethodDescriptor<GetConditionEstimationRequest, GetConditionEstimationResponse> getGetConditionEstimationMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc 'GetConditionEstimation'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/GetConditionEstimationResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
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
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> getListCampaignsMethod() {
    return getListCampaignsMethodHelper();
  }
  
  private static MethodDescriptor<ListCampaignsRequest, ListCampaignsResponse> getListCampaignsMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getListCampaignsMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getListCampaignsMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc 'ListCampaigns'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/ListCampaignsResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getListCampaignsMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
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
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> getRolloutExperimentalCampaignMethod() {
    return getRolloutExperimentalCampaignMethodHelper();
  }
  
  private static MethodDescriptor<RolloutExperimentRequest, RolloutExperimentResponse> getRolloutExperimentalCampaignMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 84
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 72
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc 'RolloutExperimentalCampaign'
    //   36: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   42: iconst_1
    //   43: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   46: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentRequest;
    //   49: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   52: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   55: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/RolloutExperimentResponse;
    //   58: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   61: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   64: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   67: astore_1
    //   68: aload_1
    //   69: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethod : Lio/grpc/MethodDescriptor;
    //   72: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   74: monitorexit
    //   75: goto -> 84
    //   78: astore_1
    //   79: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
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
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 90
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 78
    //   23: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   25: invokestatic newBuilder : (Ljava/lang/String;)Lio/grpc/ServiceDescriptor$Builder;
    //   28: invokestatic getCreateCampaignMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   31: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   34: invokestatic getUpdateCampaignMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   37: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   40: invokestatic getDeleteCampaignMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   43: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   46: invokestatic getListCampaignsMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   49: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   52: invokestatic getRolloutExperimentalCampaignMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   55: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   58: invokestatic getGetConditionEstimationMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   61: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   64: invokestatic getTestCampaignOnDeviceMethodHelper : ()Lio/grpc/MethodDescriptor;
    //   67: invokevirtual addMethod : (Lio/grpc/MethodDescriptor;)Lio/grpc/ServiceDescriptor$Builder;
    //   70: invokevirtual build : ()Lio/grpc/ServiceDescriptor;
    //   73: astore_1
    //   74: aload_1
    //   75: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.serviceDescriptor : Lio/grpc/ServiceDescriptor;
    //   78: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   80: monitorexit
    //   81: goto -> 90
    //   84: astore_1
    //   85: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    //   90: aload_1
    //   91: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	84	finally
    //   23	78	84	finally
    //   78	81	84	finally
    //   85	88	84	finally
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<TestCampaignOnDeviceRequest, Empty> getTestCampaignOnDeviceMethod() {
    return getTestCampaignOnDeviceMethodHelper();
  }
  
  private static MethodDescriptor<TestCampaignOnDeviceRequest, Empty> getTestCampaignOnDeviceMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc_w 'TestCampaignOnDevice'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/TestCampaignOnDeviceRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/protobuf/Empty;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> getUpdateCampaignMethod() {
    return getUpdateCampaignMethodHelper();
  }
  
  private static MethodDescriptor<UpdateCampaignRequest, CampaignProto.Campaign> getUpdateCampaignMethodHelper() {
    // Byte code:
    //   0: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethod : Lio/grpc/MethodDescriptor;
    //   3: astore_0
    //   4: aload_0
    //   5: astore_1
    //   6: aload_0
    //   7: ifnonnull -> 85
    //   10: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   12: monitorenter
    //   13: getstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethod : Lio/grpc/MethodDescriptor;
    //   16: astore_0
    //   17: aload_0
    //   18: astore_1
    //   19: aload_0
    //   20: ifnonnull -> 73
    //   23: invokestatic newBuilder : ()Lio/grpc/MethodDescriptor$Builder;
    //   26: getstatic io/grpc/MethodDescriptor$MethodType.UNARY : Lio/grpc/MethodDescriptor$MethodType;
    //   29: invokevirtual setType : (Lio/grpc/MethodDescriptor$MethodType;)Lio/grpc/MethodDescriptor$Builder;
    //   32: ldc 'google.internal.firebase.inappmessaging.v1.InAppMessagingCampaignManagement'
    //   34: ldc_w 'UpdateCampaign'
    //   37: invokestatic generateFullMethodName : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   40: invokevirtual setFullMethodName : (Ljava/lang/String;)Lio/grpc/MethodDescriptor$Builder;
    //   43: iconst_1
    //   44: invokevirtual setSampledToLocalTracing : (Z)Lio/grpc/MethodDescriptor$Builder;
    //   47: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/UpdateCampaignRequest;
    //   50: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   53: invokevirtual setRequestMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   56: invokestatic getDefaultInstance : ()Lcom/google/internal/firebase/inappmessaging/v1/CampaignProto$Campaign;
    //   59: invokestatic marshaller : (Lcom/google/protobuf/MessageLite;)Lio/grpc/MethodDescriptor$Marshaller;
    //   62: invokevirtual setResponseMarshaller : (Lio/grpc/MethodDescriptor$Marshaller;)Lio/grpc/MethodDescriptor$Builder;
    //   65: invokevirtual build : ()Lio/grpc/MethodDescriptor;
    //   68: astore_1
    //   69: aload_1
    //   70: putstatic com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethod : Lio/grpc/MethodDescriptor;
    //   73: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   75: monitorexit
    //   76: goto -> 85
    //   79: astore_1
    //   80: ldc com/google/internal/firebase/inappmessaging/v1/InAppMessagingCampaignManagementGrpc
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: aload_1
    //   86: areturn
    // Exception table:
    //   from	to	target	type
    //   13	17	79	finally
    //   23	73	79	finally
    //   73	76	79	finally
    //   80	83	79	finally
  }
  
  public static InAppMessagingCampaignManagementBlockingStub newBlockingStub(Channel paramChannel) {
    return new InAppMessagingCampaignManagementBlockingStub(paramChannel);
  }
  
  public static InAppMessagingCampaignManagementFutureStub newFutureStub(Channel paramChannel) {
    return new InAppMessagingCampaignManagementFutureStub(paramChannel);
  }
  
  public static InAppMessagingCampaignManagementStub newStub(Channel paramChannel) {
    return new InAppMessagingCampaignManagementStub(paramChannel);
  }
  
  public static final class InAppMessagingCampaignManagementBlockingStub extends AbstractStub<InAppMessagingCampaignManagementBlockingStub> {
    private InAppMessagingCampaignManagementBlockingStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private InAppMessagingCampaignManagementBlockingStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected InAppMessagingCampaignManagementBlockingStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new InAppMessagingCampaignManagementBlockingStub(param1Channel, param1CallOptions);
    }
    
    public CampaignProto.Campaign createCampaign(CreateCampaignRequest param1CreateCampaignRequest) {
      return (CampaignProto.Campaign)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getCreateCampaignMethodHelper(), getCallOptions(), param1CreateCampaignRequest);
    }
    
    public Empty deleteCampaign(DeleteCampaignRequest param1DeleteCampaignRequest) {
      return (Empty)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethodHelper(), getCallOptions(), param1DeleteCampaignRequest);
    }
    
    public GetConditionEstimationResponse getConditionEstimation(GetConditionEstimationRequest param1GetConditionEstimationRequest) {
      return (GetConditionEstimationResponse)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethodHelper(), getCallOptions(), param1GetConditionEstimationRequest);
    }
    
    public ListCampaignsResponse listCampaigns(ListCampaignsRequest param1ListCampaignsRequest) {
      return (ListCampaignsResponse)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getListCampaignsMethodHelper(), getCallOptions(), param1ListCampaignsRequest);
    }
    
    public RolloutExperimentResponse rolloutExperimentalCampaign(RolloutExperimentRequest param1RolloutExperimentRequest) {
      return (RolloutExperimentResponse)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethodHelper(), getCallOptions(), param1RolloutExperimentRequest);
    }
    
    public Empty testCampaignOnDevice(TestCampaignOnDeviceRequest param1TestCampaignOnDeviceRequest) {
      return (Empty)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethodHelper(), getCallOptions(), param1TestCampaignOnDeviceRequest);
    }
    
    public CampaignProto.Campaign updateCampaign(UpdateCampaignRequest param1UpdateCampaignRequest) {
      return (CampaignProto.Campaign)ClientCalls.blockingUnaryCall(getChannel(), InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethodHelper(), getCallOptions(), param1UpdateCampaignRequest);
    }
  }
  
  public static final class InAppMessagingCampaignManagementFutureStub extends AbstractStub<InAppMessagingCampaignManagementFutureStub> {
    private InAppMessagingCampaignManagementFutureStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private InAppMessagingCampaignManagementFutureStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected InAppMessagingCampaignManagementFutureStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new InAppMessagingCampaignManagementFutureStub(param1Channel, param1CallOptions);
    }
    
    public ListenableFuture<CampaignProto.Campaign> createCampaign(CreateCampaignRequest param1CreateCampaignRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getCreateCampaignMethodHelper(), getCallOptions()), param1CreateCampaignRequest);
    }
    
    public ListenableFuture<Empty> deleteCampaign(DeleteCampaignRequest param1DeleteCampaignRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethodHelper(), getCallOptions()), param1DeleteCampaignRequest);
    }
    
    public ListenableFuture<GetConditionEstimationResponse> getConditionEstimation(GetConditionEstimationRequest param1GetConditionEstimationRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethodHelper(), getCallOptions()), param1GetConditionEstimationRequest);
    }
    
    public ListenableFuture<ListCampaignsResponse> listCampaigns(ListCampaignsRequest param1ListCampaignsRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getListCampaignsMethodHelper(), getCallOptions()), param1ListCampaignsRequest);
    }
    
    public ListenableFuture<RolloutExperimentResponse> rolloutExperimentalCampaign(RolloutExperimentRequest param1RolloutExperimentRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethodHelper(), getCallOptions()), param1RolloutExperimentRequest);
    }
    
    public ListenableFuture<Empty> testCampaignOnDevice(TestCampaignOnDeviceRequest param1TestCampaignOnDeviceRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethodHelper(), getCallOptions()), param1TestCampaignOnDeviceRequest);
    }
    
    public ListenableFuture<CampaignProto.Campaign> updateCampaign(UpdateCampaignRequest param1UpdateCampaignRequest) {
      return ClientCalls.futureUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethodHelper(), getCallOptions()), param1UpdateCampaignRequest);
    }
  }
  
  public static abstract class InAppMessagingCampaignManagementImplBase implements BindableService {
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(InAppMessagingCampaignManagementGrpc.getServiceDescriptor()).addMethod(InAppMessagingCampaignManagementGrpc.getCreateCampaignMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 0))).addMethod(InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 1))).addMethod(InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 2))).addMethod(InAppMessagingCampaignManagementGrpc.getListCampaignsMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 3))).addMethod(InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 4))).addMethod(InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 5))).addMethod(InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethodHelper(), ServerCalls.asyncUnaryCall(new InAppMessagingCampaignManagementGrpc.MethodHandlers<Object, Object>(this, 6))).build();
    }
    
    public void createCampaign(CreateCampaignRequest param1CreateCampaignRequest, StreamObserver<CampaignProto.Campaign> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getCreateCampaignMethodHelper(), param1StreamObserver);
    }
    
    public void deleteCampaign(DeleteCampaignRequest param1DeleteCampaignRequest, StreamObserver<Empty> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethodHelper(), param1StreamObserver);
    }
    
    public void getConditionEstimation(GetConditionEstimationRequest param1GetConditionEstimationRequest, StreamObserver<GetConditionEstimationResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethodHelper(), param1StreamObserver);
    }
    
    public void listCampaigns(ListCampaignsRequest param1ListCampaignsRequest, StreamObserver<ListCampaignsResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getListCampaignsMethodHelper(), param1StreamObserver);
    }
    
    public void rolloutExperimentalCampaign(RolloutExperimentRequest param1RolloutExperimentRequest, StreamObserver<RolloutExperimentResponse> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethodHelper(), param1StreamObserver);
    }
    
    public void testCampaignOnDevice(TestCampaignOnDeviceRequest param1TestCampaignOnDeviceRequest, StreamObserver<Empty> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethodHelper(), param1StreamObserver);
    }
    
    public void updateCampaign(UpdateCampaignRequest param1UpdateCampaignRequest, StreamObserver<CampaignProto.Campaign> param1StreamObserver) {
      ServerCalls.asyncUnimplementedUnaryCall(InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethodHelper(), param1StreamObserver);
    }
  }
  
  public static final class InAppMessagingCampaignManagementStub extends AbstractStub<InAppMessagingCampaignManagementStub> {
    private InAppMessagingCampaignManagementStub(Channel param1Channel) {
      super(param1Channel);
    }
    
    private InAppMessagingCampaignManagementStub(Channel param1Channel, CallOptions param1CallOptions) {
      super(param1Channel, param1CallOptions);
    }
    
    protected InAppMessagingCampaignManagementStub build(Channel param1Channel, CallOptions param1CallOptions) {
      return new InAppMessagingCampaignManagementStub(param1Channel, param1CallOptions);
    }
    
    public void createCampaign(CreateCampaignRequest param1CreateCampaignRequest, StreamObserver<CampaignProto.Campaign> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getCreateCampaignMethodHelper(), getCallOptions()), param1CreateCampaignRequest, param1StreamObserver);
    }
    
    public void deleteCampaign(DeleteCampaignRequest param1DeleteCampaignRequest, StreamObserver<Empty> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getDeleteCampaignMethodHelper(), getCallOptions()), param1DeleteCampaignRequest, param1StreamObserver);
    }
    
    public void getConditionEstimation(GetConditionEstimationRequest param1GetConditionEstimationRequest, StreamObserver<GetConditionEstimationResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getGetConditionEstimationMethodHelper(), getCallOptions()), param1GetConditionEstimationRequest, param1StreamObserver);
    }
    
    public void listCampaigns(ListCampaignsRequest param1ListCampaignsRequest, StreamObserver<ListCampaignsResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getListCampaignsMethodHelper(), getCallOptions()), param1ListCampaignsRequest, param1StreamObserver);
    }
    
    public void rolloutExperimentalCampaign(RolloutExperimentRequest param1RolloutExperimentRequest, StreamObserver<RolloutExperimentResponse> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getRolloutExperimentalCampaignMethodHelper(), getCallOptions()), param1RolloutExperimentRequest, param1StreamObserver);
    }
    
    public void testCampaignOnDevice(TestCampaignOnDeviceRequest param1TestCampaignOnDeviceRequest, StreamObserver<Empty> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getTestCampaignOnDeviceMethodHelper(), getCallOptions()), param1TestCampaignOnDeviceRequest, param1StreamObserver);
    }
    
    public void updateCampaign(UpdateCampaignRequest param1UpdateCampaignRequest, StreamObserver<CampaignProto.Campaign> param1StreamObserver) {
      ClientCalls.asyncUnaryCall(getChannel().newCall(InAppMessagingCampaignManagementGrpc.getUpdateCampaignMethodHelper(), getCallOptions()), param1UpdateCampaignRequest, param1StreamObserver);
    }
  }
  
  private static final class MethodHandlers<Req, Resp> implements ServerCalls.UnaryMethod<Req, Resp>, ServerCalls.ServerStreamingMethod<Req, Resp>, ServerCalls.ClientStreamingMethod<Req, Resp>, ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final int methodId;
    
    private final InAppMessagingCampaignManagementGrpc.InAppMessagingCampaignManagementImplBase serviceImpl;
    
    MethodHandlers(InAppMessagingCampaignManagementGrpc.InAppMessagingCampaignManagementImplBase param1InAppMessagingCampaignManagementImplBase, int param1Int) {
      this.serviceImpl = param1InAppMessagingCampaignManagementImplBase;
      this.methodId = param1Int;
    }
    
    public StreamObserver<Req> invoke(StreamObserver<Resp> param1StreamObserver) {
      int i = this.methodId;
      throw new AssertionError();
    }
    
    public void invoke(Req param1Req, StreamObserver<Resp> param1StreamObserver) {
      switch (this.methodId) {
        default:
          throw new AssertionError();
        case 6:
          this.serviceImpl.testCampaignOnDevice((TestCampaignOnDeviceRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 5:
          this.serviceImpl.getConditionEstimation((GetConditionEstimationRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 4:
          this.serviceImpl.rolloutExperimentalCampaign((RolloutExperimentRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 3:
          this.serviceImpl.listCampaigns((ListCampaignsRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 2:
          this.serviceImpl.deleteCampaign((DeleteCampaignRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 1:
          this.serviceImpl.updateCampaign((UpdateCampaignRequest)param1Req, (StreamObserver)param1StreamObserver);
          return;
        case 0:
          break;
      } 
      this.serviceImpl.createCampaign((CreateCampaignRequest)param1Req, (StreamObserver)param1StreamObserver);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\internal\firebase\inappmessaging\v1\InAppMessagingCampaignManagementGrpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */