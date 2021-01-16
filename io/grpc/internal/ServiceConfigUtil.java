package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@VisibleForTesting
public final class ServiceConfigUtil {
  private static final long DURATION_SECONDS_MAX = 315576000000L;
  
  private static final long DURATION_SECONDS_MIN = -315576000000L;
  
  private static final String METHOD_CONFIG_MAX_REQUEST_MESSAGE_BYTES_KEY = "maxRequestMessageBytes";
  
  private static final String METHOD_CONFIG_MAX_RESPONSE_MESSAGE_BYTES_KEY = "maxResponseMessageBytes";
  
  private static final String METHOD_CONFIG_NAME_KEY = "name";
  
  private static final String METHOD_CONFIG_RETRY_POLICY_KEY = "retryPolicy";
  
  private static final String METHOD_CONFIG_TIMEOUT_KEY = "timeout";
  
  private static final String METHOD_CONFIG_WAIT_FOR_READY_KEY = "waitForReady";
  
  private static final String NAME_METHOD_KEY = "method";
  
  private static final String NAME_SERVICE_KEY = "service";
  
  private static final long NANOS_PER_SECOND = TimeUnit.SECONDS.toNanos(1L);
  
  private static final String RETRY_POLICY_BACKOFF_MULTIPLIER_KEY = "backoffMultiplier";
  
  private static final String RETRY_POLICY_INITIAL_BACKOFF_KEY = "initialBackoff";
  
  private static final String RETRY_POLICY_MAX_ATTEMPTS_KEY = "maxAttempts";
  
  private static final String RETRY_POLICY_MAX_BACKOFF_KEY = "maxBackoff";
  
  private static final String RETRY_POLICY_RETRYABLE_STATUS_CODES_KEY = "retryableStatusCodes";
  
  private static final String SERVICE_CONFIG_LOAD_BALANCING_POLICY_KEY = "loadBalancingPolicy";
  
  private static final String SERVICE_CONFIG_METHOD_CONFIG_KEY = "methodConfig";
  
  private static List<Map<String, Object>> checkObjectList(List<Object> paramList) {
    byte b = 0;
    while (b < paramList.size()) {
      if (paramList.get(b) instanceof Map) {
        b++;
        continue;
      } 
      throw new ClassCastException(String.format("value %s for idx %d in %s is not object", new Object[] { paramList.get(b), Integer.valueOf(b), paramList }));
    } 
    return (List)paramList;
  }
  
  static List<String> checkStringList(List<Object> paramList) {
    byte b = 0;
    while (b < paramList.size()) {
      if (paramList.get(b) instanceof String) {
        b++;
        continue;
      } 
      throw new ClassCastException(String.format("value %s for idx %d in %s is not string", new Object[] { paramList.get(b), Integer.valueOf(b), paramList }));
    } 
    return (List)paramList;
  }
  
  private static boolean durationIsValid(long paramLong, int paramInt) {
    if (paramLong < -315576000000L || paramLong > 315576000000L)
      return false; 
    long l = paramInt;
    return (l < -999999999L || l >= NANOS_PER_SECOND) ? false : (!((paramLong < 0L || paramInt < 0) && (paramLong > 0L || paramInt > 0)));
  }
  
  @Nullable
  static Double getBackoffMultiplierFromRetryPolicy(Map<String, Object> paramMap) {
    return !paramMap.containsKey("backoffMultiplier") ? null : getDouble(paramMap, "backoffMultiplier");
  }
  
  static Boolean getBoolean(Map<String, Object> paramMap, String paramString) {
    Object object = Preconditions.checkNotNull(paramMap.get(paramString), "no such key %s", paramString);
    if (object instanceof Boolean)
      return (Boolean)object; 
    throw new ClassCastException(String.format("value %s for key %s in %s is not Boolean", new Object[] { object, paramString, paramMap }));
  }
  
  static Double getDouble(Map<String, Object> paramMap, String paramString) {
    Object object = Preconditions.checkNotNull(paramMap.get(paramString), "no such key %s", paramString);
    if (object instanceof Double)
      return (Double)object; 
    throw new ClassCastException(String.format("value %s for key %s in %s is not Double", new Object[] { object, paramString, paramMap }));
  }
  
  @Nullable
  static Long getInitialBackoffNanosFromRetryPolicy(Map<String, Object> paramMap) {
    if (!paramMap.containsKey("initialBackoff"))
      return null; 
    String str = getString(paramMap, "initialBackoff");
    try {
      long l = parseDuration(str);
      return Long.valueOf(l);
    } catch (ParseException parseException) {
      throw new RuntimeException(parseException);
    } 
  }
  
  static List<Object> getList(Map<String, Object> paramMap, String paramString) {
    Object object = Preconditions.checkNotNull(paramMap.get(paramString), "no such key %s", paramString);
    if (object instanceof List)
      return (List<Object>)object; 
    throw new ClassCastException(String.format("value %s for key %s in %s is not List", new Object[] { object, paramString, paramMap }));
  }
  
  @Nullable
  @VisibleForTesting
  public static String getLoadBalancingPolicyFromServiceConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("loadBalancingPolicy") ? null : getString(paramMap, "loadBalancingPolicy");
  }
  
  @Nullable
  static Integer getMaxAttemptsFromRetryPolicy(Map<String, Object> paramMap) {
    return !paramMap.containsKey("maxAttempts") ? null : Integer.valueOf(getDouble(paramMap, "maxAttempts").intValue());
  }
  
  @Nullable
  static Long getMaxBackoffNanosFromRetryPolicy(Map<String, Object> paramMap) {
    if (!paramMap.containsKey("maxBackoff"))
      return null; 
    String str = getString(paramMap, "maxBackoff");
    try {
      long l = parseDuration(str);
      return Long.valueOf(l);
    } catch (ParseException parseException) {
      throw new RuntimeException(parseException);
    } 
  }
  
  @Nullable
  static Integer getMaxRequestMessageBytesFromMethodConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("maxRequestMessageBytes") ? null : Integer.valueOf(getDouble(paramMap, "maxRequestMessageBytes").intValue());
  }
  
  @Nullable
  static Integer getMaxResponseMessageBytesFromMethodConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("maxResponseMessageBytes") ? null : Integer.valueOf(getDouble(paramMap, "maxResponseMessageBytes").intValue());
  }
  
  @Nullable
  static List<Map<String, Object>> getMethodConfigFromServiceConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("methodConfig") ? null : checkObjectList(getList(paramMap, "methodConfig"));
  }
  
  @Nullable
  static String getMethodFromName(Map<String, Object> paramMap) {
    return !paramMap.containsKey("method") ? null : getString(paramMap, "method");
  }
  
  @Nullable
  static List<Map<String, Object>> getNameListFromMethodConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("name") ? null : checkObjectList(getList(paramMap, "name"));
  }
  
  private static Map<String, Object> getObject(List<Object> paramList, int paramInt) {
    Object object = Preconditions.checkNotNull(paramList.get(paramInt), "idx %s in %s is null", paramInt, paramList);
    if (object instanceof Map)
      return (Map<String, Object>)object; 
    throw new ClassCastException(String.format("value %s for idx %d in %s is not a map", new Object[] { object, Integer.valueOf(paramInt), paramList }));
  }
  
  static Map<String, Object> getObject(Map<String, Object> paramMap, String paramString) {
    Object object = Preconditions.checkNotNull(paramMap.get(paramString), "no such key %s", paramString);
    if (object instanceof Map)
      return (Map<String, Object>)object; 
    throw new ClassCastException(String.format("value %s for key %s in %s is not object", new Object[] { object, paramString, paramMap }));
  }
  
  @Nullable
  static Map<String, Object> getRetryPolicyFromMethodConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("retryPolicy") ? null : getObject(paramMap, "retryPolicy");
  }
  
  @Nullable
  static List<String> getRetryableStatusCodesFromRetryPolicy(Map<String, Object> paramMap) {
    return !paramMap.containsKey("retryableStatusCodes") ? null : checkStringList(getList(paramMap, "retryableStatusCodes"));
  }
  
  @Nullable
  static String getServiceFromName(Map<String, Object> paramMap) {
    return !paramMap.containsKey("service") ? null : getString(paramMap, "service");
  }
  
  static String getString(List<Object> paramList, int paramInt) {
    Object object = Preconditions.checkNotNull(paramList.get(paramInt), "idx %s in %s is null", paramInt, paramList);
    if (object instanceof String)
      return (String)object; 
    throw new ClassCastException(String.format("value %s for idx %d in %s is not String", new Object[] { object, Integer.valueOf(paramInt), paramList }));
  }
  
  static String getString(Map<String, Object> paramMap, String paramString) {
    Object object = Preconditions.checkNotNull(paramMap.get(paramString), "no such key %s", paramString);
    if (object instanceof String)
      return (String)object; 
    throw new ClassCastException(String.format("value %s for key %s in %s is not String", new Object[] { object, paramString, paramMap }));
  }
  
  @Nullable
  static RetriableStream$Throttle getThrottlePolicy(@Nullable Map<String, Object> paramMap) {
    boolean bool2;
    if (paramMap == null || !paramMap.containsKey("retryThrottling"))
      return null; 
    paramMap = getObject(paramMap, "retryThrottling");
    float f1 = getDouble(paramMap, "maxTokens").floatValue();
    float f2 = getDouble(paramMap, "tokenRatio").floatValue();
    boolean bool1 = true;
    if (f1 > 0.0F) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "maxToken should be greater than zero");
    if (f2 > 0.0F) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2, "tokenRatio should be greater than zero");
    return new RetriableStream$Throttle(f1, f2);
  }
  
  @Nullable
  static Long getTimeoutFromMethodConfig(Map<String, Object> paramMap) {
    if (!paramMap.containsKey("timeout"))
      return null; 
    String str = getString(paramMap, "timeout");
    try {
      long l = parseDuration(str);
      return Long.valueOf(l);
    } catch (ParseException parseException) {
      throw new RuntimeException(parseException);
    } 
  }
  
  @Nullable
  static Boolean getWaitForReadyFromMethodConfig(Map<String, Object> paramMap) {
    return !paramMap.containsKey("waitForReady") ? null : getBoolean(paramMap, "waitForReady");
  }
  
  private static long normalizedDuration(long paramLong, int paramInt) {
    // Byte code:
    //   0: iload_2
    //   1: i2l
    //   2: lstore_3
    //   3: getstatic io/grpc/internal/ServiceConfigUtil.NANOS_PER_SECOND : J
    //   6: lstore #5
    //   8: lload_3
    //   9: lload #5
    //   11: lneg
    //   12: lcmp
    //   13: ifle -> 29
    //   16: lload_0
    //   17: lstore #7
    //   19: iload_2
    //   20: istore #9
    //   22: lload_3
    //   23: lload #5
    //   25: lcmp
    //   26: iflt -> 48
    //   29: lload_0
    //   30: lload_3
    //   31: getstatic io/grpc/internal/ServiceConfigUtil.NANOS_PER_SECOND : J
    //   34: ldiv
    //   35: invokestatic checkedAdd : (JJ)J
    //   38: lstore #7
    //   40: lload_3
    //   41: getstatic io/grpc/internal/ServiceConfigUtil.NANOS_PER_SECOND : J
    //   44: lrem
    //   45: l2i
    //   46: istore #9
    //   48: lload #7
    //   50: lstore_0
    //   51: iload #9
    //   53: istore_2
    //   54: lload #7
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle -> 86
    //   61: lload #7
    //   63: lstore_0
    //   64: iload #9
    //   66: istore_2
    //   67: iload #9
    //   69: ifge -> 86
    //   72: iload #9
    //   74: i2l
    //   75: getstatic io/grpc/internal/ServiceConfigUtil.NANOS_PER_SECOND : J
    //   78: ladd
    //   79: l2i
    //   80: istore_2
    //   81: lload #7
    //   83: lconst_1
    //   84: lsub
    //   85: lstore_0
    //   86: lload_0
    //   87: lstore #7
    //   89: iload_2
    //   90: istore #9
    //   92: lload_0
    //   93: lconst_0
    //   94: lcmp
    //   95: ifge -> 122
    //   98: lload_0
    //   99: lstore #7
    //   101: iload_2
    //   102: istore #9
    //   104: iload_2
    //   105: ifle -> 122
    //   108: iload_2
    //   109: i2l
    //   110: getstatic io/grpc/internal/ServiceConfigUtil.NANOS_PER_SECOND : J
    //   113: lsub
    //   114: l2i
    //   115: istore #9
    //   117: lload_0
    //   118: lconst_1
    //   119: ladd
    //   120: lstore #7
    //   122: lload #7
    //   124: iload #9
    //   126: invokestatic durationIsValid : (JI)Z
    //   129: ifeq -> 147
    //   132: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   135: lload #7
    //   137: invokevirtual toNanos : (J)J
    //   140: iload #9
    //   142: i2l
    //   143: invokestatic saturatedAdd : (JJ)J
    //   146: lreturn
    //   147: new java/lang/IllegalArgumentException
    //   150: dup
    //   151: ldc_w 'Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds'
    //   154: iconst_2
    //   155: anewarray java/lang/Object
    //   158: dup
    //   159: iconst_0
    //   160: lload #7
    //   162: invokestatic valueOf : (J)Ljava/lang/Long;
    //   165: aastore
    //   166: dup
    //   167: iconst_1
    //   168: iload #9
    //   170: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   173: aastore
    //   174: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   177: invokespecial <init> : (Ljava/lang/String;)V
    //   180: athrow
  }
  
  private static long parseDuration(String paramString) throws ParseException {
    if (!paramString.isEmpty() && paramString.charAt(paramString.length() - 1) == 's') {
      boolean bool;
      if (paramString.charAt(0) == '-') {
        paramString = paramString.substring(1);
        bool = true;
      } else {
        bool = false;
      } 
      String str1 = paramString.substring(0, paramString.length() - 1);
      String str2 = "";
      int i = str1.indexOf('.');
      String str3 = str1;
      if (i != -1) {
        str2 = str1.substring(i + 1);
        str3 = str1.substring(0, i);
      } 
      long l = Long.parseLong(str3);
      if (str2.isEmpty()) {
        i = 0;
      } else {
        i = parseNanos(str2);
      } 
      if (l >= 0L) {
        int j = i;
        long l1 = l;
        if (bool) {
          l1 = -l;
          j = -i;
        } 
        try {
          return normalizedDuration(l1, j);
        } catch (IllegalArgumentException illegalArgumentException) {
          throw new ParseException("Duration value is out of range.", 0);
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid duration string: ");
      stringBuilder1.append((String)illegalArgumentException);
      throw new ParseException(stringBuilder1.toString(), 0);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid duration string: ");
    stringBuilder.append((String)illegalArgumentException);
    throw new ParseException(stringBuilder.toString(), 0);
  }
  
  private static int parseNanos(String paramString) throws ParseException {
    byte b = 0;
    int i = 0;
    while (b < 9) {
      int j = i * 10;
      i = j;
      if (b < paramString.length())
        if (paramString.charAt(b) >= '0' && paramString.charAt(b) <= '9') {
          i = j + paramString.charAt(b) - 48;
        } else {
          throw new ParseException("Invalid nanoseconds.", 0);
        }  
      b++;
    } 
    return i;
  }
  
  private static long saturatedAdd(long paramLong1, long paramLong2) {
    boolean bool2;
    long l = paramLong1 + paramLong2;
    boolean bool1 = true;
    if ((paramLong2 ^ paramLong1) < 0L) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if ((paramLong1 ^ l) < 0L)
      bool1 = false; 
    return ((bool2 | bool1) != 0) ? l : ((l >>> 63L ^ 0x1L) + Long.MAX_VALUE);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServiceConfigUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */