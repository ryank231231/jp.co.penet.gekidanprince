package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.grpc.CallOptions;
import io.grpc.ClientStreamTracer;
import io.grpc.InternalMetadata;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class GrpcUtil {
  static {
    US_ASCII = Charset.forName("US-ASCII");
    if (System.getProperty("com.google.appengine.runtime.environment") != null && "1.7".equals(System.getProperty("java.specification.version"))) {
      bool = true;
    } else {
      bool = false;
    } 
    IS_RESTRICTED_APPENGINE = bool;
    TIMEOUT_KEY = Metadata.Key.of("grpc-timeout", new TimeoutMarshaller());
    MESSAGE_ENCODING_KEY = Metadata.Key.of("grpc-encoding", Metadata.ASCII_STRING_MARSHALLER);
    MESSAGE_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf("grpc-accept-encoding", new AcceptEncodingMarshaller());
    CONTENT_ENCODING_KEY = Metadata.Key.of("content-encoding", Metadata.ASCII_STRING_MARSHALLER);
    CONTENT_ACCEPT_ENCODING_KEY = InternalMetadata.keyOf("accept-encoding", new AcceptEncodingMarshaller());
    CONTENT_TYPE_KEY = Metadata.Key.of("content-type", Metadata.ASCII_STRING_MARSHALLER);
    TE_HEADER = Metadata.Key.of("te", Metadata.ASCII_STRING_MARSHALLER);
    USER_AGENT_KEY = Metadata.Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER);
    ACCEPT_ENCODING_SPLITTER = Splitter.on(',').trimResults();
    DEFAULT_KEEPALIVE_TIME_NANOS = TimeUnit.MINUTES.toNanos(1L);
    DEFAULT_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.SECONDS.toNanos(20L);
    DEFAULT_SERVER_KEEPALIVE_TIME_NANOS = TimeUnit.HOURS.toNanos(2L);
    DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.SECONDS.toNanos(20L);
    DEFAULT_PROXY_DETECTOR = new ProxyDetectorImpl();
    NOOP_PROXY_DETECTOR = new ProxyDetector() {
        @Nullable
        public ProxyParameters proxyFor(SocketAddress param1SocketAddress) {
          return null;
        }
      };
    SHARED_CHANNEL_EXECUTOR = new SharedResourceHolder.Resource<ExecutorService>() {
        private static final String NAME = "grpc-default-executor";
        
        public void close(ExecutorService param1ExecutorService) {
          param1ExecutorService.shutdown();
        }
        
        public ExecutorService create() {
          return Executors.newCachedThreadPool(GrpcUtil.getThreadFactory("grpc-default-executor-%d", true));
        }
        
        public String toString() {
          return "grpc-default-executor";
        }
      };
    TIMER_SERVICE = new SharedResourceHolder.Resource<ScheduledExecutorService>() {
        public void close(ScheduledExecutorService param1ScheduledExecutorService) {
          param1ScheduledExecutorService.shutdown();
        }
        
        public ScheduledExecutorService create() {
          ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1, GrpcUtil.getThreadFactory("grpc-timer-%d", true));
          try {
            scheduledExecutorService.getClass().getMethod("setRemoveOnCancelPolicy", new Class[] { boolean.class }).invoke(scheduledExecutorService, new Object[] { Boolean.valueOf(true) });
          } catch (NoSuchMethodException noSuchMethodException) {
          
          } catch (RuntimeException null) {
            throw exception;
          } catch (Exception exception) {
            throw new RuntimeException(exception);
          } 
          return (ScheduledExecutorService)exception;
        }
      };
    STOPWATCH_SUPPLIER = new Supplier<Stopwatch>() {
        public Stopwatch get() {
          return Stopwatch.createUnstarted();
        }
      };
  }
  
  public static String authorityFromHostAndPort(String paramString, int paramInt) {
    try {
      URI uRI = new URI();
      this(null, null, paramString, paramInt, null, null, null);
      return uRI.getAuthority();
    } catch (URISyntaxException uRISyntaxException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid host or port: ");
      stringBuilder.append(paramString);
      stringBuilder.append(" ");
      stringBuilder.append(paramInt);
      throw new IllegalArgumentException(stringBuilder.toString(), uRISyntaxException);
    } 
  }
  
  public static URI authorityToUri(String paramString) {
    Preconditions.checkNotNull(paramString, "authority");
    try {
      return new URI(null, paramString, null, null, null);
    } catch (URISyntaxException uRISyntaxException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid authority: ");
      stringBuilder.append(paramString);
      throw new IllegalArgumentException(stringBuilder.toString(), uRISyntaxException);
    } 
  }
  
  public static String checkAuthority(String paramString) {
    boolean bool2;
    URI uRI = authorityToUri(paramString);
    String str = uRI.getHost();
    boolean bool1 = true;
    if (str != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "No host in authority '%s'", paramString);
    if (uRI.getUserInfo() == null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    } 
    Preconditions.checkArgument(bool2, "Userinfo must not be present on authority: '%s'", paramString);
    return paramString;
  }
  
  static void closeQuietly(StreamListener.MessageProducer paramMessageProducer) {
    while (true) {
      InputStream inputStream = paramMessageProducer.next();
      if (inputStream != null) {
        closeQuietly(inputStream);
        continue;
      } 
      break;
    } 
  }
  
  public static void closeQuietly(@Nullable InputStream paramInputStream) {
    if (paramInputStream == null)
      return; 
    try {
      paramInputStream.close();
    } catch (IOException iOException) {
      log.log(Level.WARNING, "exception caught in closeQuietly", iOException);
    } 
  }
  
  public static ProxyDetector getDefaultProxyDetector() {
    return IS_RESTRICTED_APPENGINE ? NOOP_PROXY_DETECTOR : DEFAULT_PROXY_DETECTOR;
  }
  
  public static String getGrpcUserAgent(String paramString1, @Nullable String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramString2 != null) {
      stringBuilder.append(paramString2);
      stringBuilder.append(' ');
    } 
    stringBuilder.append("grpc-java-");
    stringBuilder.append(paramString1);
    stringBuilder.append('/');
    stringBuilder.append("1.12.0");
    return stringBuilder.toString();
  }
  
  public static String getHost(InetSocketAddress paramInetSocketAddress) {
    try {
      return (String)InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(paramInetSocketAddress, new Object[0]);
    } catch (NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException noSuchMethodException) {
      return paramInetSocketAddress.getHostName();
    } 
  }
  
  public static ThreadFactory getThreadFactory(String paramString, boolean paramBoolean) {
    return IS_RESTRICTED_APPENGINE ? MoreExecutors.platformThreadFactory() : (new ThreadFactoryBuilder()).setDaemon(paramBoolean).setNameFormat(paramString).build();
  }
  
  @Nullable
  static ClientTransport getTransportFromPickResult(LoadBalancer.PickResult paramPickResult, boolean paramBoolean) {
    final ClientStreamTracer.Factory streamTracerFactory;
    final LoadBalancer.Subchannel transport = paramPickResult.getSubchannel();
    if (subchannel != null) {
      ClientTransport clientTransport = ((AbstractSubchannel)subchannel).obtainActiveTransport();
    } else {
      subchannel = null;
    } 
    if (subchannel != null) {
      factory = paramPickResult.getStreamTracerFactory();
      return (ClientTransport)((factory == null) ? subchannel : new ClientTransport() {
          public LogId getLogId() {
            return transport.getLogId();
          }
          
          public ListenableFuture<Channelz.SocketStats> getStats() {
            return transport.getStats();
          }
          
          public ClientStream newStream(MethodDescriptor<?, ?> param1MethodDescriptor, Metadata param1Metadata, CallOptions param1CallOptions) {
            return transport.newStream(param1MethodDescriptor, param1Metadata, param1CallOptions.withStreamTracerFactory(streamTracerFactory));
          }
          
          public void ping(ClientTransport.PingCallback param1PingCallback, Executor param1Executor) {
            transport.ping(param1PingCallback, param1Executor);
          }
        });
    } 
    if (!factory.getStatus().isOk()) {
      if (factory.isDrop())
        return new FailingClientTransport(factory.getStatus(), ClientStreamListener.RpcProgress.DROPPED); 
      if (!paramBoolean)
        return new FailingClientTransport(factory.getStatus(), ClientStreamListener.RpcProgress.PROCESSED); 
    } 
    return null;
  }
  
  private static Status.Code httpStatusToGrpcCode(int paramInt) {
    if (paramInt >= 100 && paramInt < 200)
      return Status.Code.INTERNAL; 
    switch (paramInt) {
      default:
        return Status.Code.UNKNOWN;
      case 429:
      case 502:
      case 503:
      case 504:
        return Status.Code.UNAVAILABLE;
      case 404:
        return Status.Code.UNIMPLEMENTED;
      case 403:
        return Status.Code.PERMISSION_DENIED;
      case 401:
        return Status.Code.UNAUTHENTICATED;
      case 400:
      case 431:
        break;
    } 
    return Status.Code.INTERNAL;
  }
  
  public static Status httpStatusToGrpcStatus(int paramInt) {
    Status status = httpStatusToGrpcCode(paramInt).toStatus();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HTTP status code ");
    stringBuilder.append(paramInt);
    return status.withDescription(stringBuilder.toString());
  }
  
  public static boolean isGrpcContentType(String paramString) {
    boolean bool = false;
    if (paramString == null)
      return false; 
    if (16 > paramString.length())
      return false; 
    paramString = paramString.toLowerCase();
    if (!paramString.startsWith("application/grpc"))
      return false; 
    if (paramString.length() == 16)
      return true; 
    char c = paramString.charAt(16);
    if (c == '+' || c == ';')
      bool = true; 
    return bool;
  }
  
  static <T> boolean iterableContains(Iterable<T> paramIterable, T paramT) {
    if (paramIterable instanceof java.util.Collection) {
      paramIterable = paramIterable;
      try {
        return paramIterable.contains(paramT);
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    } 
    Iterator iterator = classCastException.iterator();
    while (iterator.hasNext()) {
      if (Objects.equal(iterator.next(), paramT))
        return true; 
    } 
    return false;
  }
  
  static {
    boolean bool;
  }
  
  public static final Splitter ACCEPT_ENCODING_SPLITTER;
  
  public static final String CONTENT_ACCEPT_ENCODING = "accept-encoding";
  
  public static final Metadata.Key<byte[]> CONTENT_ACCEPT_ENCODING_KEY;
  
  public static final String CONTENT_ENCODING = "content-encoding";
  
  public static final Metadata.Key<String> CONTENT_ENCODING_KEY;
  
  public static final String CONTENT_TYPE_GRPC = "application/grpc";
  
  public static final Metadata.Key<String> CONTENT_TYPE_KEY;
  
  public static final long DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
  
  public static final long DEFAULT_KEEPALIVE_TIME_NANOS;
  
  public static final int DEFAULT_MAX_HEADER_LIST_SIZE = 8192;
  
  public static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
  
  public static final int DEFAULT_PORT_PLAINTEXT = 80;
  
  public static final int DEFAULT_PORT_SSL = 443;
  
  public static final ProxyDetector DEFAULT_PROXY_DETECTOR;
  
  public static final long DEFAULT_SERVER_KEEPALIVE_TIMEOUT_NANOS;
  
  public static final long DEFAULT_SERVER_KEEPALIVE_TIME_NANOS;
  
  public static final String HTTP_METHOD = "POST";
  
  private static final String IMPLEMENTATION_VERSION = "1.12.0";
  
  public static final boolean IS_RESTRICTED_APPENGINE;
  
  public static final long KEEPALIVE_TIME_NANOS_DISABLED = 9223372036854775807L;
  
  public static final String MESSAGE_ACCEPT_ENCODING = "grpc-accept-encoding";
  
  public static final Metadata.Key<byte[]> MESSAGE_ACCEPT_ENCODING_KEY;
  
  public static final String MESSAGE_ENCODING = "grpc-encoding";
  
  public static final Metadata.Key<String> MESSAGE_ENCODING_KEY;
  
  public static final ProxyDetector NOOP_PROXY_DETECTOR;
  
  public static final long SERVER_KEEPALIVE_TIME_NANOS_DISABLED = 9223372036854775807L;
  
  public static final SharedResourceHolder.Resource<ExecutorService> SHARED_CHANNEL_EXECUTOR;
  
  public static final Supplier<Stopwatch> STOPWATCH_SUPPLIER;
  
  public static final Metadata.Key<String> TE_HEADER;
  
  public static final String TE_TRAILERS = "trailers";
  
  public static final String TIMEOUT = "grpc-timeout";
  
  public static final Metadata.Key<Long> TIMEOUT_KEY;
  
  public static final SharedResourceHolder.Resource<ScheduledExecutorService> TIMER_SERVICE;
  
  public static final Metadata.Key<String> USER_AGENT_KEY;
  
  public static final Charset US_ASCII;
  
  private static final Logger log = Logger.getLogger(GrpcUtil.class.getName());
  
  private static final class AcceptEncodingMarshaller implements InternalMetadata.TrustedAsciiMarshaller<byte[]> {
    private AcceptEncodingMarshaller() {}
    
    public byte[] parseAsciiString(byte[] param1ArrayOfbyte) {
      return param1ArrayOfbyte;
    }
    
    public byte[] toAsciiString(byte[] param1ArrayOfbyte) {
      return param1ArrayOfbyte;
    }
  }
  
  public enum Http2Error {
    CANCEL,
    COMPRESSION_ERROR,
    CONNECT_ERROR,
    ENHANCE_YOUR_CALM,
    FLOW_CONTROL_ERROR,
    FRAME_SIZE_ERROR,
    HTTP_1_1_REQUIRED,
    INADEQUATE_SECURITY,
    INTERNAL_ERROR,
    NO_ERROR(0, Status.UNAVAILABLE),
    PROTOCOL_ERROR(1, Status.INTERNAL),
    REFUSED_STREAM(1, Status.INTERNAL),
    SETTINGS_TIMEOUT(1, Status.INTERNAL),
    STREAM_CLOSED(1, Status.INTERNAL);
    
    private static final Http2Error[] codeMap;
    
    private final int code;
    
    private final Status status;
    
    static {
      FLOW_CONTROL_ERROR = new Http2Error("FLOW_CONTROL_ERROR", 3, 3, Status.INTERNAL);
      SETTINGS_TIMEOUT = new Http2Error("SETTINGS_TIMEOUT", 4, 4, Status.INTERNAL);
      STREAM_CLOSED = new Http2Error("STREAM_CLOSED", 5, 5, Status.INTERNAL);
      FRAME_SIZE_ERROR = new Http2Error("FRAME_SIZE_ERROR", 6, 6, Status.INTERNAL);
      REFUSED_STREAM = new Http2Error("REFUSED_STREAM", 7, 7, Status.UNAVAILABLE);
      CANCEL = new Http2Error("CANCEL", 8, 8, Status.CANCELLED);
      COMPRESSION_ERROR = new Http2Error("COMPRESSION_ERROR", 9, 9, Status.INTERNAL);
      CONNECT_ERROR = new Http2Error("CONNECT_ERROR", 10, 10, Status.INTERNAL);
      ENHANCE_YOUR_CALM = new Http2Error("ENHANCE_YOUR_CALM", 11, 11, Status.RESOURCE_EXHAUSTED.withDescription("Bandwidth exhausted"));
      INADEQUATE_SECURITY = new Http2Error("INADEQUATE_SECURITY", 12, 12, Status.PERMISSION_DENIED.withDescription("Permission denied as protocol is not secure enough to call"));
      HTTP_1_1_REQUIRED = new Http2Error("HTTP_1_1_REQUIRED", 13, 13, Status.UNKNOWN);
      $VALUES = new Http2Error[] { 
          NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, SETTINGS_TIMEOUT, STREAM_CLOSED, FRAME_SIZE_ERROR, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, 
          CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, HTTP_1_1_REQUIRED };
      codeMap = buildHttp2CodeMap();
    }
    
    Http2Error(int param1Int1, Status param1Status) {
      this.code = param1Int1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("HTTP/2 error code: ");
      stringBuilder.append(name());
      this.status = param1Status.augmentDescription(stringBuilder.toString());
    }
    
    private static Http2Error[] buildHttp2CodeMap() {
      Http2Error[] arrayOfHttp2Error1 = values();
      Http2Error[] arrayOfHttp2Error2 = new Http2Error[(int)arrayOfHttp2Error1[arrayOfHttp2Error1.length - 1].code() + 1];
      int i = arrayOfHttp2Error1.length;
      for (byte b = 0; b < i; b++) {
        Http2Error http2Error = arrayOfHttp2Error1[b];
        arrayOfHttp2Error2[(int)http2Error.code()] = http2Error;
      } 
      return arrayOfHttp2Error2;
    }
    
    public static Http2Error forCode(long param1Long) {
      Http2Error[] arrayOfHttp2Error = codeMap;
      return (param1Long >= arrayOfHttp2Error.length || param1Long < 0L) ? null : arrayOfHttp2Error[(int)param1Long];
    }
    
    public static Status statusForCode(long param1Long) {
      Status status;
      Http2Error http2Error = forCode(param1Long);
      if (http2Error == null) {
        status = Status.fromCodeValue(INTERNAL_ERROR.status().getCode().value());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized HTTP/2 error code: ");
        stringBuilder.append(param1Long);
        return status.withDescription(stringBuilder.toString());
      } 
      return status.status();
    }
    
    public long code() {
      return this.code;
    }
    
    public Status status() {
      return this.status;
    }
  }
  
  @VisibleForTesting
  static class TimeoutMarshaller implements Metadata.AsciiMarshaller<Long> {
    public Long parseAsciiString(String param1String) {
      boolean bool;
      if (param1String.length() > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "empty timeout");
      if (param1String.length() <= 9) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "bad timeout format");
      long l = Long.parseLong(param1String.substring(0, param1String.length() - 1));
      char c = param1String.charAt(param1String.length() - 1);
      if (c != 'H') {
        if (c != 'M') {
          if (c != 'S') {
            if (c != 'u') {
              switch (c) {
                default:
                  throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", new Object[] { Character.valueOf(c) }));
                case 'n':
                  return Long.valueOf(l);
                case 'm':
                  break;
              } 
              return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(l));
            } 
            return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(l));
          } 
          return Long.valueOf(TimeUnit.SECONDS.toNanos(l));
        } 
        return Long.valueOf(TimeUnit.MINUTES.toNanos(l));
      } 
      return Long.valueOf(TimeUnit.HOURS.toNanos(l));
    }
    
    public String toAsciiString(Long param1Long) {
      TimeUnit timeUnit = TimeUnit.NANOSECONDS;
      if (param1Long.longValue() >= 0L) {
        StringBuilder stringBuilder1;
        if (param1Long.longValue() < 100000000L) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(param1Long);
          stringBuilder1.append("n");
          return stringBuilder1.toString();
        } 
        if (param1Long.longValue() < 100000000000L) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(stringBuilder1.toMicros(param1Long.longValue()));
          stringBuilder.append("u");
          return stringBuilder.toString();
        } 
        if (param1Long.longValue() < 100000000000000L) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(stringBuilder1.toMillis(param1Long.longValue()));
          stringBuilder.append("m");
          return stringBuilder.toString();
        } 
        if (param1Long.longValue() < 100000000000000000L) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(stringBuilder1.toSeconds(param1Long.longValue()));
          stringBuilder.append("S");
          return stringBuilder.toString();
        } 
        if (param1Long.longValue() < 6000000000000000000L) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(stringBuilder1.toMinutes(param1Long.longValue()));
          stringBuilder.append("M");
          return stringBuilder.toString();
        } 
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder1.toHours(param1Long.longValue()));
        stringBuilder2.append("H");
        return stringBuilder2.toString();
      } 
      throw new IllegalArgumentException("Timeout too small");
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\GrpcUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */