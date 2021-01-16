package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.MethodDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

final class ServiceConfigInterceptor implements ClientInterceptor {
  static final CallOptions.Key<RetryPolicy.Provider> RETRY_POLICY_KEY;
  
  private static final Logger logger = Logger.getLogger(ServiceConfigInterceptor.class.getName());
  
  private final int maxRetryAttemptsLimit;
  
  private volatile boolean nameResolveComplete;
  
  private final boolean retryEnabled;
  
  @VisibleForTesting
  final AtomicReference<Map<String, MethodInfo>> serviceMap = new AtomicReference<Map<String, MethodInfo>>();
  
  @VisibleForTesting
  final AtomicReference<Map<String, MethodInfo>> serviceMethodMap = new AtomicReference<Map<String, MethodInfo>>();
  
  static {
    RETRY_POLICY_KEY = CallOptions.Key.of("internal-retry-policy", null);
  }
  
  ServiceConfigInterceptor(boolean paramBoolean, int paramInt) {
    this.retryEnabled = paramBoolean;
    this.maxRetryAttemptsLimit = paramInt;
  }
  
  @CheckForNull
  private MethodInfo getMethodInfo(MethodDescriptor<?, ?> paramMethodDescriptor) {
    MethodInfo methodInfo;
    Map map1 = this.serviceMethodMap.get();
    if (map1 != null) {
      MethodInfo methodInfo1 = (MethodInfo)map1.get(paramMethodDescriptor.getFullMethodName());
    } else {
      map1 = null;
    } 
    Map map2 = map1;
    if (map1 == null) {
      Map map = this.serviceMap.get();
      map2 = map1;
      if (map != null)
        methodInfo = (MethodInfo)map.get(MethodDescriptor.extractFullServiceName(paramMethodDescriptor.getFullMethodName())); 
    } 
    return methodInfo;
  }
  
  @VisibleForTesting
  RetryPolicy getRetryPolicyFromConfig(MethodDescriptor<?, ?> paramMethodDescriptor) {
    MethodInfo methodInfo = getMethodInfo(paramMethodDescriptor);
    return (methodInfo == null || methodInfo.retryPolicy == null) ? RetryPolicy.DEFAULT : methodInfo.retryPolicy;
  }
  
  void handleUpdate(@Nonnull Map<String, Object> paramMap) {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    List list = ServiceConfigUtil.getMethodConfigFromServiceConfig(paramMap);
    if (list == null) {
      logger.log(Level.FINE, "No method configs found, skipping");
      this.nameResolveComplete = true;
      return;
    } 
    for (Map map : list) {
      boolean bool;
      MethodInfo methodInfo = new MethodInfo(map, this.retryEnabled, this.maxRetryAttemptsLimit);
      List list1 = ServiceConfigUtil.getNameListFromMethodConfig(map);
      if (list1 != null && !list1.isEmpty()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "no names in method config %s", map);
      for (Map map1 : list1) {
        String str1 = ServiceConfigUtil.getServiceFromName(map1);
        Preconditions.checkArgument(Strings.isNullOrEmpty(str1) ^ true, "missing service name");
        String str2 = ServiceConfigUtil.getMethodFromName(map1);
        if (Strings.isNullOrEmpty(str2)) {
          Preconditions.checkArgument(hashMap2.containsKey(str1) ^ true, "Duplicate service %s", str1);
          hashMap2.put(str1, methodInfo);
          continue;
        } 
        str1 = MethodDescriptor.generateFullMethodName(str1, str2);
        Preconditions.checkArgument(hashMap1.containsKey(str1) ^ true, "Duplicate method name %s", str1);
        hashMap1.put(str1, methodInfo);
      } 
    } 
    this.serviceMethodMap.set((Map)Collections.unmodifiableMap(hashMap1));
    this.serviceMap.set((Map)Collections.unmodifiableMap(hashMap2));
    this.nameResolveComplete = true;
  }
  
  public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, Channel paramChannel) {
    // Byte code:
    //   0: aload_2
    //   1: astore #4
    //   3: aload_0
    //   4: getfield retryEnabled : Z
    //   7: ifeq -> 64
    //   10: aload_0
    //   11: getfield nameResolveComplete : Z
    //   14: ifeq -> 46
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual getRetryPolicyFromConfig : (Lio/grpc/MethodDescriptor;)Lio/grpc/internal/RetryPolicy;
    //   22: astore #4
    //   24: aload_2
    //   25: getstatic io/grpc/internal/ServiceConfigInterceptor.RETRY_POLICY_KEY : Lio/grpc/CallOptions$Key;
    //   28: new io/grpc/internal/ServiceConfigInterceptor$1ImmediateRetryPolicyProvider
    //   31: dup
    //   32: aload_0
    //   33: aload #4
    //   35: invokespecial <init> : (Lio/grpc/internal/ServiceConfigInterceptor;Lio/grpc/internal/RetryPolicy;)V
    //   38: invokevirtual withOption : (Lio/grpc/CallOptions$Key;Ljava/lang/Object;)Lio/grpc/CallOptions;
    //   41: astore #4
    //   43: goto -> 64
    //   46: aload_2
    //   47: getstatic io/grpc/internal/ServiceConfigInterceptor.RETRY_POLICY_KEY : Lio/grpc/CallOptions$Key;
    //   50: new io/grpc/internal/ServiceConfigInterceptor$1DelayedRetryPolicyProvider
    //   53: dup
    //   54: aload_0
    //   55: aload_1
    //   56: invokespecial <init> : (Lio/grpc/internal/ServiceConfigInterceptor;Lio/grpc/MethodDescriptor;)V
    //   59: invokevirtual withOption : (Lio/grpc/CallOptions$Key;Ljava/lang/Object;)Lio/grpc/CallOptions;
    //   62: astore #4
    //   64: aload_0
    //   65: aload_1
    //   66: invokespecial getMethodInfo : (Lio/grpc/MethodDescriptor;)Lio/grpc/internal/ServiceConfigInterceptor$MethodInfo;
    //   69: astore #5
    //   71: aload #5
    //   73: ifnonnull -> 84
    //   76: aload_3
    //   77: aload_1
    //   78: aload #4
    //   80: invokevirtual newCall : (Lio/grpc/MethodDescriptor;Lio/grpc/CallOptions;)Lio/grpc/ClientCall;
    //   83: areturn
    //   84: aload #4
    //   86: astore #6
    //   88: aload #5
    //   90: getfield timeoutNanos : Ljava/lang/Long;
    //   93: ifnull -> 144
    //   96: aload #5
    //   98: getfield timeoutNanos : Ljava/lang/Long;
    //   101: invokevirtual longValue : ()J
    //   104: getstatic java/util/concurrent/TimeUnit.NANOSECONDS : Ljava/util/concurrent/TimeUnit;
    //   107: invokestatic after : (JLjava/util/concurrent/TimeUnit;)Lio/grpc/Deadline;
    //   110: astore_2
    //   111: aload #4
    //   113: invokevirtual getDeadline : ()Lio/grpc/Deadline;
    //   116: astore #7
    //   118: aload #7
    //   120: ifnull -> 136
    //   123: aload #4
    //   125: astore #6
    //   127: aload_2
    //   128: aload #7
    //   130: invokevirtual compareTo : (Lio/grpc/Deadline;)I
    //   133: ifge -> 144
    //   136: aload #4
    //   138: aload_2
    //   139: invokevirtual withDeadline : (Lio/grpc/Deadline;)Lio/grpc/CallOptions;
    //   142: astore #6
    //   144: aload #6
    //   146: astore_2
    //   147: aload #5
    //   149: getfield waitForReady : Ljava/lang/Boolean;
    //   152: ifnull -> 181
    //   155: aload #5
    //   157: getfield waitForReady : Ljava/lang/Boolean;
    //   160: invokevirtual booleanValue : ()Z
    //   163: ifeq -> 175
    //   166: aload #6
    //   168: invokevirtual withWaitForReady : ()Lio/grpc/CallOptions;
    //   171: astore_2
    //   172: goto -> 181
    //   175: aload #6
    //   177: invokevirtual withoutWaitForReady : ()Lio/grpc/CallOptions;
    //   180: astore_2
    //   181: aload_2
    //   182: astore #4
    //   184: aload #5
    //   186: getfield maxInboundMessageSize : Ljava/lang/Integer;
    //   189: ifnull -> 242
    //   192: aload_2
    //   193: invokevirtual getMaxInboundMessageSize : ()Ljava/lang/Integer;
    //   196: astore #4
    //   198: aload #4
    //   200: ifnull -> 228
    //   203: aload_2
    //   204: aload #4
    //   206: invokevirtual intValue : ()I
    //   209: aload #5
    //   211: getfield maxInboundMessageSize : Ljava/lang/Integer;
    //   214: invokevirtual intValue : ()I
    //   217: invokestatic min : (II)I
    //   220: invokevirtual withMaxInboundMessageSize : (I)Lio/grpc/CallOptions;
    //   223: astore #4
    //   225: goto -> 242
    //   228: aload_2
    //   229: aload #5
    //   231: getfield maxInboundMessageSize : Ljava/lang/Integer;
    //   234: invokevirtual intValue : ()I
    //   237: invokevirtual withMaxInboundMessageSize : (I)Lio/grpc/CallOptions;
    //   240: astore #4
    //   242: aload #4
    //   244: astore_2
    //   245: aload #5
    //   247: getfield maxOutboundMessageSize : Ljava/lang/Integer;
    //   250: ifnull -> 301
    //   253: aload #4
    //   255: invokevirtual getMaxOutboundMessageSize : ()Ljava/lang/Integer;
    //   258: astore_2
    //   259: aload_2
    //   260: ifnull -> 287
    //   263: aload #4
    //   265: aload_2
    //   266: invokevirtual intValue : ()I
    //   269: aload #5
    //   271: getfield maxOutboundMessageSize : Ljava/lang/Integer;
    //   274: invokevirtual intValue : ()I
    //   277: invokestatic min : (II)I
    //   280: invokevirtual withMaxOutboundMessageSize : (I)Lio/grpc/CallOptions;
    //   283: astore_2
    //   284: goto -> 301
    //   287: aload #4
    //   289: aload #5
    //   291: getfield maxOutboundMessageSize : Ljava/lang/Integer;
    //   294: invokevirtual intValue : ()I
    //   297: invokevirtual withMaxOutboundMessageSize : (I)Lio/grpc/CallOptions;
    //   300: astore_2
    //   301: aload_3
    //   302: aload_1
    //   303: aload_2
    //   304: invokevirtual newCall : (Lio/grpc/MethodDescriptor;Lio/grpc/CallOptions;)Lio/grpc/ClientCall;
    //   307: areturn
  }
  
  class ServiceConfigInterceptor {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\internal\ServiceConfigInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */