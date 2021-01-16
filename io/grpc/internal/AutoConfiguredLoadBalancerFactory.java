package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.LoadBalancer;
import io.grpc.PickFirstBalancerFactory;
import io.grpc.Status;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class AutoConfiguredLoadBalancerFactory extends LoadBalancer.Factory {
  @VisibleForTesting
  static final String GRPCLB_LOAD_BALANCER_FACTORY_NAME = "io.grpc.grpclb.GrpclbLoadBalancerFactory";
  
  @VisibleForTesting
  static final String ROUND_ROUND_LOAD_BALANCER_FACTORY_NAME = "io.grpc.util.RoundRobinLoadBalancerFactory";
  
  public LoadBalancer newLoadBalancer(LoadBalancer.Helper paramHelper) {
    return new AutoConfiguredLoadBalancer(paramHelper);
  }
  
  @VisibleForTesting
  static final class AutoConfiguredLoadBalancer extends LoadBalancer {
    private LoadBalancer delegate;
    
    private LoadBalancer.Factory delegateFactory;
    
    private final LoadBalancer.Helper helper;
    
    AutoConfiguredLoadBalancer(LoadBalancer.Helper param1Helper) {
      this.helper = param1Helper;
      setDelegateFactory((LoadBalancer.Factory)PickFirstBalancerFactory.getInstance());
      setDelegate(getDelegateFactory().newLoadBalancer(param1Helper));
    }
    
    @Nullable
    @VisibleForTesting
    static LoadBalancer.Factory decideLoadBalancerFactory(List<EquivalentAddressGroup> param1List, Map<String, Object> param1Map) {
      // Byte code:
      //   0: aload_0
      //   1: invokeinterface iterator : ()Ljava/util/Iterator;
      //   6: astore_0
      //   7: aload_0
      //   8: invokeinterface hasNext : ()Z
      //   13: ifeq -> 42
      //   16: aload_0
      //   17: invokeinterface next : ()Ljava/lang/Object;
      //   22: checkcast io/grpc/EquivalentAddressGroup
      //   25: invokevirtual getAttributes : ()Lio/grpc/Attributes;
      //   28: getstatic io/grpc/internal/GrpcAttributes.ATTR_LB_ADDR_AUTHORITY : Lio/grpc/Attributes$Key;
      //   31: invokevirtual get : (Lio/grpc/Attributes$Key;)Ljava/lang/Object;
      //   34: ifnull -> 7
      //   37: iconst_1
      //   38: istore_2
      //   39: goto -> 44
      //   42: iconst_0
      //   43: istore_2
      //   44: iload_2
      //   45: ifeq -> 91
      //   48: ldc 'io.grpc.grpclb.GrpclbLoadBalancerFactory'
      //   50: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
      //   53: ldc 'getInstance'
      //   55: iconst_0
      //   56: anewarray java/lang/Class
      //   59: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   62: aconst_null
      //   63: iconst_0
      //   64: anewarray java/lang/Object
      //   67: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   70: checkcast io/grpc/LoadBalancer$Factory
      //   73: astore_0
      //   74: aload_0
      //   75: areturn
      //   76: astore_0
      //   77: new java/lang/RuntimeException
      //   80: dup
      //   81: ldc 'Can't get GRPCLB, but balancer addresses were present'
      //   83: aload_0
      //   84: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
      //   87: athrow
      //   88: astore_0
      //   89: aload_0
      //   90: athrow
      //   91: aload_1
      //   92: invokestatic getLoadBalancingPolicyFromServiceConfig : (Ljava/util/Map;)Ljava/lang/String;
      //   95: astore_1
      //   96: aload_1
      //   97: ifnull -> 191
      //   100: aload_1
      //   101: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
      //   104: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
      //   107: ldc 'ROUND_ROBIN'
      //   109: invokevirtual equals : (Ljava/lang/Object;)Z
      //   112: ifeq -> 158
      //   115: ldc 'io.grpc.util.RoundRobinLoadBalancerFactory'
      //   117: invokestatic forName : (Ljava/lang/String;)Ljava/lang/Class;
      //   120: ldc 'getInstance'
      //   122: iconst_0
      //   123: anewarray java/lang/Class
      //   126: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   129: aconst_null
      //   130: iconst_0
      //   131: anewarray java/lang/Object
      //   134: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   137: checkcast io/grpc/LoadBalancer$Factory
      //   140: astore_0
      //   141: aload_0
      //   142: areturn
      //   143: astore_0
      //   144: new java/lang/RuntimeException
      //   147: dup
      //   148: ldc 'Can't get Round Robin LB'
      //   150: aload_0
      //   151: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
      //   154: athrow
      //   155: astore_0
      //   156: aload_0
      //   157: athrow
      //   158: new java/lang/StringBuilder
      //   161: dup
      //   162: invokespecial <init> : ()V
      //   165: astore_0
      //   166: aload_0
      //   167: ldc 'Unknown service config policy: '
      //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   172: pop
      //   173: aload_0
      //   174: aload_1
      //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: pop
      //   179: new java/lang/IllegalArgumentException
      //   182: dup
      //   183: aload_0
      //   184: invokevirtual toString : ()Ljava/lang/String;
      //   187: invokespecial <init> : (Ljava/lang/String;)V
      //   190: athrow
      //   191: invokestatic getInstance : ()Lio/grpc/PickFirstBalancerFactory;
      //   194: areturn
      // Exception table:
      //   from	to	target	type
      //   48	74	88	java/lang/RuntimeException
      //   48	74	76	java/lang/Exception
      //   115	141	155	java/lang/RuntimeException
      //   115	141	143	java/lang/Exception
    }
    
    @VisibleForTesting
    LoadBalancer getDelegate() {
      return this.delegate;
    }
    
    @VisibleForTesting
    LoadBalancer.Factory getDelegateFactory() {
      return this.delegateFactory;
    }
    
    public void handleNameResolutionError(Status param1Status) {
      getDelegate().handleNameResolutionError(param1Status);
    }
    
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> param1List, Attributes param1Attributes) {
      if (param1Attributes.keys().contains(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG)) {
        LoadBalancer.Factory factory = decideLoadBalancerFactory(param1List, (Map<String, Object>)param1Attributes.get(GrpcAttributes.NAME_RESOLVER_SERVICE_CONFIG));
        if (factory != null && factory != this.delegateFactory) {
          this.helper.updateBalancingState(ConnectivityState.CONNECTING, new AutoConfiguredLoadBalancerFactory.EmptySubchannelPicker());
          getDelegate().shutdown();
          setDelegateFactory(factory);
          setDelegate(getDelegateFactory().newLoadBalancer(this.helper));
        } 
      } 
      getDelegate().handleResolvedAddressGroups(param1List, param1Attributes);
    }
    
    public void handleSubchannelState(LoadBalancer.Subchannel param1Subchannel, ConnectivityStateInfo param1ConnectivityStateInfo) {
      getDelegate().handleSubchannelState(param1Subchannel, param1ConnectivityStateInfo);
    }
    
    @VisibleForTesting
    void setDelegate(LoadBalancer param1LoadBalancer) {
      this.delegate = param1LoadBalancer;
    }
    
    @VisibleForTesting
    void setDelegateFactory(LoadBalancer.Factory param1Factory) {
      this.delegateFactory = param1Factory;
    }
    
    public void shutdown() {
      getDelegate().shutdown();
      setDelegate(null);
    }
  }
  
  private static final class EmptySubchannelPicker extends LoadBalancer.SubchannelPicker {
    private EmptySubchannelPicker() {}
    
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
      return LoadBalancer.PickResult.withNoResult();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AutoConfiguredLoadBalancerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */