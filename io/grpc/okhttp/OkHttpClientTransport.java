package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.http.StatusLine;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.internal.Channelz;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.LogId;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.ProxyParameters;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;

class OkHttpClientTransport implements ConnectionClientTransport {
  private static final OkHttpClientStream[] EMPTY_STREAM_ARRAY;
  
  private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
  
  private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
  
  private final InetSocketAddress address = null;
  
  private Attributes attributes = Attributes.EMPTY;
  
  private ClientFrameHandler clientFrameHandler;
  
  SettableFuture<Void> connectedFuture;
  
  Runnable connectingCallback;
  
  private final ConnectionSpec connectionSpec;
  
  private int connectionUnacknowledgedBytesRead;
  
  private final String defaultAuthority;
  
  private boolean enableKeepAlive;
  
  private final Executor executor;
  
  private AsyncFrameWriter frameWriter;
  
  @GuardedBy("lock")
  private boolean goAwaySent;
  
  @GuardedBy("lock")
  private Status goAwayStatus;
  
  private HostnameVerifier hostnameVerifier;
  
  @GuardedBy("lock")
  private boolean inUse;
  
  private KeepAliveManager keepAliveManager;
  
  private long keepAliveTimeNanos;
  
  private long keepAliveTimeoutNanos;
  
  private boolean keepAliveWithoutCalls;
  
  private ManagedClientTransport.Listener listener;
  
  private final Object lock = new Object();
  
  private final LogId logId = LogId.allocate(getClass().getName());
  
  @GuardedBy("lock")
  private int maxConcurrentStreams = 0;
  
  private final int maxMessageSize;
  
  @GuardedBy("lock")
  private int nextStreamId;
  
  private OutboundFlowController outboundFlow;
  
  @GuardedBy("lock")
  private LinkedList<OkHttpClientStream> pendingStreams = new LinkedList<OkHttpClientStream>();
  
  @GuardedBy("lock")
  private Http2Ping ping;
  
  @Nullable
  @VisibleForTesting
  final ProxyParameters proxy;
  
  private final Random random = new Random();
  
  private ScheduledExecutorService scheduler;
  
  private final SerializingExecutor serializingExecutor;
  
  private Socket socket;
  
  private SSLSocketFactory sslSocketFactory;
  
  @GuardedBy("lock")
  private boolean stopped;
  
  private final Supplier<Stopwatch> stopwatchFactory;
  
  @GuardedBy("lock")
  private final Map<Integer, OkHttpClientStream> streams = new HashMap<Integer, OkHttpClientStream>();
  
  private FrameReader testFrameReader;
  
  private FrameWriter testFrameWriter;
  
  private final Runnable tooManyPingsRunnable;
  
  @GuardedBy("lock")
  private final TransportTracer transportTracer;
  
  private final String userAgent;
  
  static {
    EMPTY_STREAM_ARRAY = new OkHttpClientStream[0];
  }
  
  @VisibleForTesting
  OkHttpClientTransport(String paramString, Executor paramExecutor, FrameReader paramFrameReader, FrameWriter paramFrameWriter, int paramInt1, Socket paramSocket, Supplier<Stopwatch> paramSupplier, @Nullable Runnable paramRunnable1, SettableFuture<Void> paramSettableFuture, int paramInt2, Runnable paramRunnable2, TransportTracer paramTransportTracer) {
    this.maxMessageSize = paramInt2;
    this.defaultAuthority = "notarealauthority:80";
    this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", paramString);
    this.executor = (Executor)Preconditions.checkNotNull(paramExecutor, "executor");
    this.serializingExecutor = new SerializingExecutor(paramExecutor);
    this.testFrameReader = (FrameReader)Preconditions.checkNotNull(paramFrameReader, "frameReader");
    this.testFrameWriter = (FrameWriter)Preconditions.checkNotNull(paramFrameWriter, "testFrameWriter");
    this.socket = (Socket)Preconditions.checkNotNull(paramSocket, "socket");
    this.nextStreamId = paramInt1;
    this.stopwatchFactory = paramSupplier;
    this.connectionSpec = null;
    this.connectingCallback = paramRunnable1;
    this.connectedFuture = (SettableFuture<Void>)Preconditions.checkNotNull(paramSettableFuture, "connectedFuture");
    this.proxy = null;
    this.tooManyPingsRunnable = (Runnable)Preconditions.checkNotNull(paramRunnable2, "tooManyPingsRunnable");
    this.transportTracer = (TransportTracer)Preconditions.checkNotNull(paramTransportTracer, "transportTracer");
    initTransportTracer();
  }
  
  OkHttpClientTransport(InetSocketAddress paramInetSocketAddress, String paramString1, @Nullable String paramString2, Executor paramExecutor, @Nullable SSLSocketFactory paramSSLSocketFactory, @Nullable HostnameVerifier paramHostnameVerifier, ConnectionSpec paramConnectionSpec, int paramInt, @Nullable ProxyParameters paramProxyParameters, Runnable paramRunnable, TransportTracer paramTransportTracer) {
    this.defaultAuthority = paramString1;
    this.maxMessageSize = paramInt;
    this.executor = (Executor)Preconditions.checkNotNull(paramExecutor, "executor");
    this.serializingExecutor = new SerializingExecutor(paramExecutor);
    this.nextStreamId = 3;
    this.sslSocketFactory = paramSSLSocketFactory;
    this.hostnameVerifier = paramHostnameVerifier;
    this.connectionSpec = (ConnectionSpec)Preconditions.checkNotNull(paramConnectionSpec, "connectionSpec");
    this.stopwatchFactory = GrpcUtil.STOPWATCH_SUPPLIER;
    this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", paramString2);
    this.proxy = paramProxyParameters;
    this.tooManyPingsRunnable = (Runnable)Preconditions.checkNotNull(paramRunnable, "tooManyPingsRunnable");
    this.transportTracer = (TransportTracer)Preconditions.checkNotNull(paramTransportTracer);
    initTransportTracer();
  }
  
  private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
    EnumMap<ErrorCode, Object> enumMap = new EnumMap<ErrorCode, Object>(ErrorCode.class);
    enumMap.put(ErrorCode.NO_ERROR, Status.INTERNAL.withDescription("No error: A GRPC status of OK should have been sent"));
    enumMap.put(ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("Protocol error"));
    enumMap.put(ErrorCode.INTERNAL_ERROR, Status.INTERNAL.withDescription("Internal error"));
    enumMap.put(ErrorCode.FLOW_CONTROL_ERROR, Status.INTERNAL.withDescription("Flow control error"));
    enumMap.put(ErrorCode.STREAM_CLOSED, Status.INTERNAL.withDescription("Stream closed"));
    enumMap.put(ErrorCode.FRAME_TOO_LARGE, Status.INTERNAL.withDescription("Frame too large"));
    enumMap.put(ErrorCode.REFUSED_STREAM, Status.UNAVAILABLE.withDescription("Refused stream"));
    enumMap.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription("Cancelled"));
    enumMap.put(ErrorCode.COMPRESSION_ERROR, Status.INTERNAL.withDescription("Compression error"));
    enumMap.put(ErrorCode.CONNECT_ERROR, Status.INTERNAL.withDescription("Connect error"));
    enumMap.put(ErrorCode.ENHANCE_YOUR_CALM, Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
    enumMap.put(ErrorCode.INADEQUATE_SECURITY, Status.PERMISSION_DENIED.withDescription("Inadequate security"));
    return (Map)Collections.unmodifiableMap(enumMap);
  }
  
  private Request createHttpProxyRequest(InetSocketAddress paramInetSocketAddress, String paramString1, String paramString2) {
    HttpUrl httpUrl = (new HttpUrl.Builder()).scheme("https").host(paramInetSocketAddress.getHostName()).port(paramInetSocketAddress.getPort()).build();
    Request.Builder builder2 = (new Request.Builder()).url(httpUrl);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(httpUrl.host());
    stringBuilder.append(":");
    stringBuilder.append(httpUrl.port());
    Request.Builder builder1 = builder2.header("Host", stringBuilder.toString()).header("User-Agent", this.userAgent);
    if (paramString1 != null && paramString2 != null)
      builder1.header("Proxy-Authorization", Credentials.basic(paramString1, paramString2)); 
    return builder1.build();
  }
  
  private Socket createHttpProxySocket(InetSocketAddress paramInetSocketAddress1, InetSocketAddress paramInetSocketAddress2, String paramString1, String paramString2) throws IOException, StatusException {
    try {
      Socket socket;
      if (paramInetSocketAddress2.getAddress() != null) {
        Socket socket1 = new Socket();
        this(paramInetSocketAddress2.getAddress(), paramInetSocketAddress2.getPort());
        socket = socket1;
      } else {
        socket = new Socket(socket.getHostName(), socket.getPort());
      } 
      socket.setTcpNoDelay(true);
      Source source = Okio.source(socket);
      BufferedSink bufferedSink = Okio.buffer(Okio.sink(socket));
      Request request = createHttpProxyRequest(paramInetSocketAddress1, paramString1, paramString2);
      HttpUrl httpUrl = request.httpUrl();
      bufferedSink.writeUtf8(String.format("CONNECT %s:%d HTTP/1.1", new Object[] { httpUrl.host(), Integer.valueOf(httpUrl.port()) })).writeUtf8("\r\n");
      int i = request.headers().size();
      for (byte b = 0; b < i; b++)
        bufferedSink.writeUtf8(request.headers().name(b)).writeUtf8(": ").writeUtf8(request.headers().value(b)).writeUtf8("\r\n"); 
      bufferedSink.writeUtf8("\r\n");
      bufferedSink.flush();
      StatusLine statusLine = StatusLine.parse(readUtf8LineStrictUnbuffered(source));
      while (!readUtf8LineStrictUnbuffered(source).equals(""));
      if (statusLine.code >= 200 && statusLine.code < 300)
        return socket; 
      Buffer buffer = new Buffer();
      this();
      try {
        socket.shutdownOutput();
        source.read(buffer, 1024L);
      } catch (IOException iOException) {
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Unable to read body: ");
        stringBuilder.append(iOException.toString());
        buffer.writeUtf8(stringBuilder.toString());
      } 
      try {
        socket.close();
      } catch (IOException iOException) {}
    } catch (IOException iOException) {
      throw Status.UNAVAILABLE.withDescription("Failed trying to connect with proxy").withCause(iOException).asException();
    } 
  }
  
  private Throwable getPingFailure() {
    synchronized (this.lock) {
      if (this.goAwayStatus != null)
        return (Throwable)this.goAwayStatus.asException(); 
      return (Throwable)Status.UNAVAILABLE.withDescription("Connection closed").asException();
    } 
  }
  
  private void initTransportTracer() {
    synchronized (this.lock) {
      TransportTracer transportTracer = this.transportTracer;
      TransportTracer.FlowControlReader flowControlReader = new TransportTracer.FlowControlReader() {
          public TransportTracer.FlowControlWindows read() {
            synchronized (OkHttpClientTransport.this.lock) {
              long l;
              if (OkHttpClientTransport.this.outboundFlow == null) {
                l = -1L;
              } else {
                l = OkHttpClientTransport.this.outboundFlow.windowUpdate(null, 0);
              } 
              TransportTracer.FlowControlWindows flowControlWindows = new TransportTracer.FlowControlWindows();
              this(-1L, l);
              return flowControlWindows;
            } 
          }
        };
      super(this);
      transportTracer.setFlowControlWindowReader(flowControlReader);
      return;
    } 
  }
  
  private boolean isForTest() {
    boolean bool;
    if (this.address == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @GuardedBy("lock")
  private void maybeClearInUse() {
    if (this.inUse && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
      this.inUse = false;
      this.listener.transportInUse(false);
      KeepAliveManager keepAliveManager = this.keepAliveManager;
      if (keepAliveManager != null)
        keepAliveManager.onTransportIdle(); 
    } 
  }
  
  private void onError(ErrorCode paramErrorCode, String paramString) {
    startGoAway(0, paramErrorCode, toGrpcStatus(paramErrorCode).augmentDescription(paramString));
  }
  
  private static String readUtf8LineStrictUnbuffered(Source paramSource) throws IOException {
    Buffer buffer = new Buffer();
    while (paramSource.read(buffer, 1L) != -1L) {
      if (buffer.getByte(buffer.size() - 1L) == 10)
        return buffer.readUtf8LineStrict(); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\\n not found: ");
    stringBuilder.append(buffer.readByteString().hex());
    throw new EOFException(stringBuilder.toString());
  }
  
  @GuardedBy("lock")
  private void setInUse() {
    if (!this.inUse) {
      this.inUse = true;
      this.listener.transportInUse(true);
      KeepAliveManager keepAliveManager = this.keepAliveManager;
      if (keepAliveManager != null)
        keepAliveManager.onTransportActive(); 
    } 
  }
  
  private void startGoAway(int paramInt, ErrorCode paramErrorCode, Status paramStatus) {
    synchronized (this.lock) {
      if (this.goAwayStatus == null) {
        this.goAwayStatus = paramStatus;
        this.listener.transportShutdown(paramStatus);
      } 
      if (paramErrorCode != null && !this.goAwaySent) {
        this.goAwaySent = true;
        this.frameWriter.goAway(0, paramErrorCode, new byte[0]);
      } 
      Iterator<Map.Entry> iterator = this.streams.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (((Integer)entry.getKey()).intValue() > paramInt) {
          iterator.remove();
          OkHttpClientStream.TransportState transportState = ((OkHttpClientStream)entry.getValue()).transportState();
          ClientStreamListener.RpcProgress rpcProgress = ClientStreamListener.RpcProgress.REFUSED;
          Metadata metadata = new Metadata();
          this();
          transportState.transportReportStatus(paramStatus, rpcProgress, false, metadata);
        } 
      } 
      Iterator<OkHttpClientStream> iterator1 = this.pendingStreams.iterator();
      while (iterator1.hasNext()) {
        OkHttpClientStream.TransportState transportState = ((OkHttpClientStream)iterator1.next()).transportState();
        ClientStreamListener.RpcProgress rpcProgress = ClientStreamListener.RpcProgress.REFUSED;
        Metadata metadata = new Metadata();
        this();
        transportState.transportReportStatus(paramStatus, rpcProgress, true, metadata);
      } 
      this.pendingStreams.clear();
      maybeClearInUse();
      stopIfNecessary();
      return;
    } 
  }
  
  @GuardedBy("lock")
  private boolean startPendingStreams() {
    boolean bool;
    for (bool = false; !this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams; bool = true)
      startStream(this.pendingStreams.poll()); 
    return bool;
  }
  
  @GuardedBy("lock")
  private void startStream(OkHttpClientStream paramOkHttpClientStream) {
    boolean bool;
    if (paramOkHttpClientStream.id() == -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "StreamId already assigned");
    this.streams.put(Integer.valueOf(this.nextStreamId), paramOkHttpClientStream);
    setInUse();
    paramOkHttpClientStream.transportState().start(this.nextStreamId);
    if ((paramOkHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY && paramOkHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) || paramOkHttpClientStream.useGet())
      this.frameWriter.flush(); 
    int i = this.nextStreamId;
    if (i >= 2147483645) {
      this.nextStreamId = Integer.MAX_VALUE;
      startGoAway(2147483647, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
    } else {
      this.nextStreamId = i + 2;
    } 
  }
  
  @GuardedBy("lock")
  private void stopIfNecessary() {
    if (this.goAwayStatus == null || !this.streams.isEmpty() || !this.pendingStreams.isEmpty())
      return; 
    if (this.stopped)
      return; 
    this.stopped = true;
    KeepAliveManager keepAliveManager = this.keepAliveManager;
    if (keepAliveManager != null) {
      keepAliveManager.onTransportTermination();
      this.scheduler = (ScheduledExecutorService)SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.scheduler);
    } 
    Http2Ping http2Ping = this.ping;
    if (http2Ping != null) {
      http2Ping.failed(getPingFailure());
      this.ping = null;
    } 
    if (!this.goAwaySent) {
      this.goAwaySent = true;
      this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
    } 
    this.frameWriter.close();
  }
  
  @VisibleForTesting
  static Status toGrpcStatus(ErrorCode paramErrorCode) {
    Status status1;
    Status status2 = ERROR_CODE_TO_STATUS.get(paramErrorCode);
    if (status2 != null) {
      status1 = status2;
    } else {
      Status status = Status.UNKNOWN;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown http2 error code: ");
      stringBuilder.append(((ErrorCode)status1).httpCode);
      status1 = status.withDescription(stringBuilder.toString());
    } 
    return status1;
  }
  
  void enableKeepAlive(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2) {
    this.enableKeepAlive = paramBoolean1;
    this.keepAliveTimeNanos = paramLong1;
    this.keepAliveTimeoutNanos = paramLong2;
    this.keepAliveWithoutCalls = paramBoolean2;
  }
  
  void finishStream(int paramInt, @Nullable Status paramStatus, ClientStreamListener.RpcProgress paramRpcProgress, boolean paramBoolean, @Nullable ErrorCode paramErrorCode, @Nullable Metadata paramMetadata) {
    synchronized (this.lock) {
      OkHttpClientStream okHttpClientStream = this.streams.remove(Integer.valueOf(paramInt));
      if (okHttpClientStream != null) {
        if (paramErrorCode != null)
          this.frameWriter.rstStream(paramInt, ErrorCode.CANCEL); 
        if (paramStatus != null) {
          OkHttpClientStream.TransportState transportState = okHttpClientStream.transportState();
          if (paramMetadata == null)
            paramMetadata = new Metadata(); 
          transportState.transportReportStatus(paramStatus, paramRpcProgress, paramBoolean, paramMetadata);
        } 
        if (!startPendingStreams()) {
          stopIfNecessary();
          maybeClearInUse();
        } 
      } 
      return;
    } 
  }
  
  OkHttpClientStream[] getActiveStreams() {
    synchronized (this.lock) {
      return (OkHttpClientStream[])this.streams.values().toArray((Object[])EMPTY_STREAM_ARRAY);
    } 
  }
  
  public Attributes getAttributes() {
    return this.attributes;
  }
  
  @VisibleForTesting
  ClientFrameHandler getHandler() {
    return this.clientFrameHandler;
  }
  
  public LogId getLogId() {
    return this.logId;
  }
  
  @VisibleForTesting
  String getOverridenHost() {
    URI uRI = GrpcUtil.authorityToUri(this.defaultAuthority);
    return (uRI.getHost() != null) ? uRI.getHost() : this.defaultAuthority;
  }
  
  @VisibleForTesting
  int getOverridenPort() {
    URI uRI = GrpcUtil.authorityToUri(this.defaultAuthority);
    return (uRI.getPort() != -1) ? uRI.getPort() : this.address.getPort();
  }
  
  @VisibleForTesting
  int getPendingStreamSize() {
    synchronized (this.lock) {
      return this.pendingStreams.size();
    } 
  }
  
  public ListenableFuture<Channelz.SocketStats> getStats() {
    synchronized (this.lock) {
      SettableFuture settableFuture = SettableFuture.create();
      Channelz.SocketStats socketStats = new Channelz.SocketStats();
      Channelz.TransportStats transportStats = this.transportTracer.getStats();
      SocketAddress socketAddress1 = this.socket.getLocalSocketAddress();
      SocketAddress socketAddress2 = this.socket.getRemoteSocketAddress();
      Channelz.SocketOptions socketOptions = Utils.getSocketOptions(this.socket);
      Channelz.Security security = new Channelz.Security();
      this();
      this(transportStats, socketAddress1, socketAddress2, socketOptions, security);
      settableFuture.set(socketStats);
      return (ListenableFuture<Channelz.SocketStats>)settableFuture;
    } 
  }
  
  OkHttpClientStream getStream(int paramInt) {
    synchronized (this.lock) {
      return this.streams.get(Integer.valueOf(paramInt));
    } 
  }
  
  boolean mayHaveCreatedStream(int paramInt) {
    synchronized (this.lock) {
      int i = this.nextStreamId;
      boolean bool = true;
      if (paramInt >= i || (paramInt & 0x1) != 1)
        bool = false; 
      return bool;
    } 
  }
  
  public OkHttpClientStream newStream(MethodDescriptor<?, ?> paramMethodDescriptor, Metadata paramMetadata, CallOptions paramCallOptions) {
    Preconditions.checkNotNull(paramMethodDescriptor, "method");
    Preconditions.checkNotNull(paramMetadata, "headers");
    StatsTraceContext statsTraceContext = StatsTraceContext.newClientContext(paramCallOptions, paramMetadata);
    return new OkHttpClientStream(paramMethodDescriptor, paramMetadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.defaultAuthority, this.userAgent, statsTraceContext, this.transportTracer);
  }
  
  void onException(Throwable paramThrowable) {
    Preconditions.checkNotNull(paramThrowable, "failureCause");
    Status status = Status.UNAVAILABLE.withCause(paramThrowable);
    startGoAway(0, ErrorCode.INTERNAL_ERROR, status);
  }
  
  public void ping(ClientTransport.PingCallback paramPingCallback, Executor paramExecutor) {
    boolean bool2;
    AsyncFrameWriter asyncFrameWriter = this.frameWriter;
    boolean bool1 = true;
    if (asyncFrameWriter != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    Preconditions.checkState(bool2);
    long l = 0L;
    synchronized (this.lock) {
      Http2Ping http2Ping;
      if (this.stopped) {
        Http2Ping.notifyFailed(paramPingCallback, paramExecutor, getPingFailure());
        return;
      } 
      if (this.ping != null) {
        http2Ping = this.ping;
        bool1 = false;
      } else {
        l = this.random.nextLong();
        Stopwatch stopwatch = (Stopwatch)this.stopwatchFactory.get();
        stopwatch.start();
        http2Ping = new Http2Ping();
        this(l, stopwatch);
        this.ping = http2Ping;
        this.transportTracer.reportKeepAliveSent();
      } 
      if (bool1)
        this.frameWriter.ping(false, (int)(l >>> 32L), (int)l); 
      http2Ping.addCallback(paramPingCallback, paramExecutor);
      return;
    } 
  }
  
  @GuardedBy("lock")
  void removePendingStream(OkHttpClientStream paramOkHttpClientStream) {
    this.pendingStreams.remove(paramOkHttpClientStream);
    maybeClearInUse();
  }
  
  public void shutdown(Status paramStatus) {
    synchronized (this.lock) {
      if (this.goAwayStatus != null)
        return; 
      this.goAwayStatus = paramStatus;
      this.listener.transportShutdown(this.goAwayStatus);
      stopIfNecessary();
      return;
    } 
  }
  
  public void shutdownNow(Status paramStatus) {
    shutdown(paramStatus);
    synchronized (this.lock) {
      Iterator<Map.Entry> iterator = this.streams.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        iterator.remove();
        OkHttpClientStream.TransportState transportState = ((OkHttpClientStream)entry.getValue()).transportState();
        Metadata metadata = new Metadata();
        this();
        transportState.transportReportStatus(paramStatus, false, metadata);
      } 
      Iterator<OkHttpClientStream> iterator1 = this.pendingStreams.iterator();
      while (iterator1.hasNext()) {
        OkHttpClientStream.TransportState transportState = ((OkHttpClientStream)iterator1.next()).transportState();
        Metadata metadata = new Metadata();
        this();
        transportState.transportReportStatus(paramStatus, true, metadata);
      } 
      this.pendingStreams.clear();
      maybeClearInUse();
      stopIfNecessary();
      return;
    } 
  }
  
  public Runnable start(ManagedClientTransport.Listener paramListener) {
    this.listener = (ManagedClientTransport.Listener)Preconditions.checkNotNull(paramListener, "listener");
    if (this.enableKeepAlive) {
      this.scheduler = (ScheduledExecutorService)SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE);
      this.keepAliveManager = new KeepAliveManager((KeepAliveManager.KeepAlivePinger)new KeepAliveManager.ClientKeepAlivePinger(this), this.scheduler, this.keepAliveTimeNanos, this.keepAliveTimeoutNanos, this.keepAliveWithoutCalls);
      this.keepAliveManager.onTransportStarted();
    } 
    this.frameWriter = new AsyncFrameWriter(this, this.serializingExecutor);
    this.outboundFlow = new OutboundFlowController(this, this.frameWriter);
    this.serializingExecutor.execute(new Runnable() {
          public void run() {
            OkHttpClientTransport okHttpClientTransport1;
            if (OkHttpClientTransport.this.isForTest()) {
              if (OkHttpClientTransport.this.connectingCallback != null)
                OkHttpClientTransport.this.connectingCallback.run(); 
              null = OkHttpClientTransport.this;
              OkHttpClientTransport.access$302(null, new OkHttpClientTransport.ClientFrameHandler(null.testFrameReader));
              OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
              synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.access$602(OkHttpClientTransport.this, 2147483647);
                OkHttpClientTransport.this.startPendingStreams();
                OkHttpClientTransport.this.frameWriter.becomeConnected(OkHttpClientTransport.this.testFrameWriter, OkHttpClientTransport.this.socket);
                OkHttpClientTransport.this.connectedFuture.set(null);
                return;
              } 
            } 
            BufferedSource bufferedSource3 = Okio.buffer(new Source() {
                  public void close() {}
                  
                  public long read(Buffer param2Buffer, long param2Long) {
                    return -1L;
                  }
                  
                  public Timeout timeout() {
                    return Timeout.NONE;
                  }
                });
            Http2 http2 = new Http2();
            BufferedSource bufferedSource1 = bufferedSource3;
            BufferedSource bufferedSource4 = bufferedSource3;
            BufferedSource bufferedSource2 = bufferedSource3;
            try {
              Socket socket1;
              if (OkHttpClientTransport.this.proxy == null) {
                bufferedSource1 = bufferedSource3;
                bufferedSource4 = bufferedSource3;
                bufferedSource2 = bufferedSource3;
                socket1 = new Socket();
                bufferedSource1 = bufferedSource3;
                bufferedSource4 = bufferedSource3;
                bufferedSource2 = bufferedSource3;
                this(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
              } else {
                bufferedSource1 = bufferedSource3;
                bufferedSource4 = bufferedSource3;
                bufferedSource2 = bufferedSource3;
                socket1 = OkHttpClientTransport.this.createHttpProxySocket(OkHttpClientTransport.this.address, OkHttpClientTransport.this.proxy.proxyAddress, OkHttpClientTransport.this.proxy.username, OkHttpClientTransport.this.proxy.password);
              } 
              Socket socket2 = socket1;
              bufferedSource1 = bufferedSource3;
              bufferedSource4 = bufferedSource3;
              bufferedSource2 = bufferedSource3;
              if (OkHttpClientTransport.this.sslSocketFactory != null) {
                bufferedSource1 = bufferedSource3;
                bufferedSource4 = bufferedSource3;
                bufferedSource2 = bufferedSource3;
                socket2 = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, OkHttpClientTransport.this.hostnameVerifier, socket1, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
              } 
              bufferedSource1 = bufferedSource3;
              bufferedSource4 = bufferedSource3;
              bufferedSource2 = bufferedSource3;
              socket2.setTcpNoDelay(true);
              bufferedSource1 = bufferedSource3;
              bufferedSource4 = bufferedSource3;
              bufferedSource2 = bufferedSource3;
              bufferedSource3 = Okio.buffer(Okio.source(socket2));
              bufferedSource1 = bufferedSource3;
              bufferedSource4 = bufferedSource3;
              bufferedSource2 = bufferedSource3;
              BufferedSink bufferedSink = Okio.buffer(Okio.sink(socket2));
              bufferedSource1 = bufferedSource3;
              bufferedSource4 = bufferedSource3;
              bufferedSource2 = bufferedSource3;
              OkHttpClientTransport.access$1602(OkHttpClientTransport.this, Attributes.newBuilder().set(Grpc.TRANSPORT_ATTR_REMOTE_ADDR, socket2.getRemoteSocketAddress()).build());
              okHttpClientTransport1 = OkHttpClientTransport.this;
              OkHttpClientTransport.access$302(okHttpClientTransport1, new OkHttpClientTransport.ClientFrameHandler(http2.newReader(bufferedSource3, true)));
              OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
              synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientTransport.access$902(OkHttpClientTransport.this, socket2);
                OkHttpClientTransport.access$602(OkHttpClientTransport.this, 2147483647);
                OkHttpClientTransport.this.startPendingStreams();
                null = http2.newWriter(bufferedSink, true);
                OkHttpClientTransport.this.frameWriter.becomeConnected((FrameWriter)null, OkHttpClientTransport.this.socket);
                try {
                  null.connectionPreface();
                  Settings settings = new Settings();
                  this();
                  null.settings(settings);
                  return;
                } catch (Exception null) {
                  OkHttpClientTransport.this.onException((Throwable)null);
                  return;
                } 
              } 
            } catch (StatusException statusException) {
              bufferedSource1 = bufferedSource2;
              OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, statusException.getStatus());
              okHttpClientTransport1 = OkHttpClientTransport.this;
              OkHttpClientTransport.access$302(okHttpClientTransport1, new OkHttpClientTransport.ClientFrameHandler(http2.newReader(bufferedSource2, true)));
              OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
              return;
            } catch (Exception exception) {
              StatusException statusException1 = statusException;
              OkHttpClientTransport.this.onException(exception);
              okHttpClientTransport1 = OkHttpClientTransport.this;
              OkHttpClientTransport.access$302(okHttpClientTransport1, new OkHttpClientTransport.ClientFrameHandler(http2.newReader((BufferedSource)statusException, true)));
              OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
              return;
            } finally {}
            OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
            OkHttpClientTransport.access$302(okHttpClientTransport2, new OkHttpClientTransport.ClientFrameHandler(http2.newReader((BufferedSource)okHttpClientTransport1, true)));
            OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
            throw bufferedSource2;
          }
        });
    return null;
  }
  
  @GuardedBy("lock")
  void streamReadyToStart(OkHttpClientStream paramOkHttpClientStream) {
    synchronized (this.lock) {
      OkHttpClientStream.TransportState transportState;
      if (this.goAwayStatus != null) {
        transportState = paramOkHttpClientStream.transportState();
        Status status = this.goAwayStatus;
        Metadata metadata = new Metadata();
        this();
        transportState.transportReportStatus(status, true, metadata);
      } else if (this.streams.size() >= this.maxConcurrentStreams) {
        this.pendingStreams.add(transportState);
        setInUse();
      } else {
        startStream((OkHttpClientStream)transportState);
      } 
      return;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getLogId());
    stringBuilder.append("(");
    stringBuilder.append(this.address);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  @VisibleForTesting
  class ClientFrameHandler implements FrameReader.Handler, Runnable {
    boolean firstSettings = true;
    
    FrameReader frameReader;
    
    ClientFrameHandler(FrameReader param1FrameReader) {
      this.frameReader = param1FrameReader;
    }
    
    public void ackSettings() {}
    
    public void alternateService(int param1Int1, String param1String1, ByteString param1ByteString, String param1String2, int param1Int2, long param1Long) {}
    
    public void data(boolean param1Boolean, int param1Int1, BufferedSource param1BufferedSource, int param1Int2) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   4: iload_2
      //   5: invokevirtual getStream : (I)Lio/grpc/okhttp/OkHttpClientStream;
      //   8: astore #5
      //   10: aload #5
      //   12: ifnonnull -> 96
      //   15: aload_0
      //   16: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   19: iload_2
      //   20: invokevirtual mayHaveCreatedStream : (I)Z
      //   23: ifeq -> 52
      //   26: aload_0
      //   27: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   30: invokestatic access$1000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/AsyncFrameWriter;
      //   33: iload_2
      //   34: getstatic io/grpc/okhttp/internal/framed/ErrorCode.INVALID_STREAM : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   37: invokevirtual rstStream : (ILio/grpc/okhttp/internal/framed/ErrorCode;)V
      //   40: aload_3
      //   41: iload #4
      //   43: i2l
      //   44: invokeinterface skip : (J)V
      //   49: goto -> 154
      //   52: aload_0
      //   53: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   56: astore #5
      //   58: getstatic io/grpc/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   61: astore #6
      //   63: new java/lang/StringBuilder
      //   66: dup
      //   67: invokespecial <init> : ()V
      //   70: astore_3
      //   71: aload_3
      //   72: ldc 'Received data for unknown stream: '
      //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: pop
      //   78: aload_3
      //   79: iload_2
      //   80: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   83: pop
      //   84: aload #5
      //   86: aload #6
      //   88: aload_3
      //   89: invokevirtual toString : ()Ljava/lang/String;
      //   92: invokestatic access$2100 : (Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/ErrorCode;Ljava/lang/String;)V
      //   95: return
      //   96: iload #4
      //   98: i2l
      //   99: lstore #7
      //   101: aload_3
      //   102: lload #7
      //   104: invokeinterface require : (J)V
      //   109: new okio/Buffer
      //   112: dup
      //   113: invokespecial <init> : ()V
      //   116: astore #6
      //   118: aload #6
      //   120: aload_3
      //   121: invokeinterface buffer : ()Lokio/Buffer;
      //   126: lload #7
      //   128: invokevirtual write : (Lokio/Buffer;J)V
      //   131: aload_0
      //   132: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   135: invokestatic access$000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/lang/Object;
      //   138: astore_3
      //   139: aload_3
      //   140: monitorenter
      //   141: aload #5
      //   143: invokevirtual transportState : ()Lio/grpc/okhttp/OkHttpClientStream$TransportState;
      //   146: aload #6
      //   148: iload_1
      //   149: invokevirtual transportDataReceived : (Lokio/Buffer;Z)V
      //   152: aload_3
      //   153: monitorexit
      //   154: aload_0
      //   155: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   158: iload #4
      //   160: invokestatic access$2212 : (Lio/grpc/okhttp/OkHttpClientTransport;I)I
      //   163: pop
      //   164: aload_0
      //   165: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   168: invokestatic access$2200 : (Lio/grpc/okhttp/OkHttpClientTransport;)I
      //   171: sipush #32767
      //   174: if_icmplt -> 205
      //   177: aload_0
      //   178: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   181: invokestatic access$1000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/AsyncFrameWriter;
      //   184: iconst_0
      //   185: aload_0
      //   186: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   189: invokestatic access$2200 : (Lio/grpc/okhttp/OkHttpClientTransport;)I
      //   192: i2l
      //   193: invokevirtual windowUpdate : (IJ)V
      //   196: aload_0
      //   197: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   200: iconst_0
      //   201: invokestatic access$2202 : (Lio/grpc/okhttp/OkHttpClientTransport;I)I
      //   204: pop
      //   205: return
      //   206: astore #6
      //   208: aload_3
      //   209: monitorexit
      //   210: aload #6
      //   212: athrow
      // Exception table:
      //   from	to	target	type
      //   141	154	206	finally
      //   208	210	206	finally
    }
    
    public void goAway(int param1Int, ErrorCode param1ErrorCode, ByteString param1ByteString) {
      if (param1ErrorCode == ErrorCode.ENHANCE_YOUR_CALM) {
        String str = param1ByteString.utf8();
        OkHttpClientTransport.log.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", new Object[] { this, str }));
        if ("too_many_pings".equals(str))
          OkHttpClientTransport.this.tooManyPingsRunnable.run(); 
      } 
      Status status2 = GrpcUtil.Http2Error.statusForCode(param1ErrorCode.httpCode).augmentDescription("Received Goaway");
      Status status1 = status2;
      if (param1ByteString.size() > 0)
        status1 = status2.augmentDescription(param1ByteString.utf8()); 
      OkHttpClientTransport.this.startGoAway(param1Int, null, status1);
    }
    
    public void headers(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List, HeadersMode param1HeadersMode) {
      synchronized (OkHttpClientTransport.this.lock) {
        OkHttpClientStream okHttpClientStream = (OkHttpClientStream)OkHttpClientTransport.this.streams.get(Integer.valueOf(param1Int1));
        if (okHttpClientStream == null) {
          if (OkHttpClientTransport.this.mayHaveCreatedStream(param1Int1)) {
            OkHttpClientTransport.this.frameWriter.rstStream(param1Int1, ErrorCode.INVALID_STREAM);
          } else {
            param1Int2 = 1;
          } 
        } else {
          okHttpClientStream.transportState().transportHeadersReceived(param1List, param1Boolean2);
        } 
        param1Int2 = 0;
      } 
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) {
      if (!param1Boolean) {
        OkHttpClientTransport.this.frameWriter.ping(true, param1Int1, param1Int2);
      } else {
        long l = param1Int1 << 32L | param1Int2 & 0xFFFFFFFFL;
        synchronized (OkHttpClientTransport.this.lock) {
          Http2Ping http2Ping;
          if (OkHttpClientTransport.this.ping != null) {
            if (OkHttpClientTransport.this.ping.payload() == l) {
              http2Ping = OkHttpClientTransport.this.ping;
              OkHttpClientTransport.access$2402(OkHttpClientTransport.this, null);
            } else {
              OkHttpClientTransport.log.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", new Object[] { Long.valueOf(OkHttpClientTransport.access$2400(this.this$0).payload()), Long.valueOf(l) }));
              http2Ping = null;
            } 
          } else {
            OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
            http2Ping = null;
          } 
          if (http2Ping != null)
            http2Ping.complete(); 
          return;
        } 
      } 
    }
    
    public void priority(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {}
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) throws IOException {
      OkHttpClientTransport.this.frameWriter.rstStream(param1Int1, ErrorCode.PROTOCOL_ERROR);
    }
    
    public void rstStream(int param1Int, ErrorCode param1ErrorCode) {
      ClientStreamListener.RpcProgress rpcProgress;
      boolean bool;
      Status status = OkHttpClientTransport.toGrpcStatus(param1ErrorCode).augmentDescription("Rst Stream");
      if (status.getCode() == Status.Code.CANCELLED || status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
        bool = true;
      } else {
        bool = false;
      } 
      OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
      if (param1ErrorCode == ErrorCode.REFUSED_STREAM) {
        rpcProgress = ClientStreamListener.RpcProgress.REFUSED;
      } else {
        rpcProgress = ClientStreamListener.RpcProgress.PROCESSED;
      } 
      okHttpClientTransport.finishStream(param1Int, status, rpcProgress, bool, null, null);
    }
    
    public void run() {
      // Byte code:
      //   0: invokestatic currentThread : ()Ljava/lang/Thread;
      //   3: invokevirtual getName : ()Ljava/lang/String;
      //   6: astore_1
      //   7: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
      //   10: ifne -> 22
      //   13: invokestatic currentThread : ()Ljava/lang/Thread;
      //   16: ldc_w 'OkHttpClientTransport'
      //   19: invokevirtual setName : (Ljava/lang/String;)V
      //   22: aload_0
      //   23: getfield frameReader : Lio/grpc/okhttp/internal/framed/FrameReader;
      //   26: aload_0
      //   27: invokeinterface nextFrame : (Lio/grpc/okhttp/internal/framed/FrameReader$Handler;)Z
      //   32: ifeq -> 58
      //   35: aload_0
      //   36: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   39: invokestatic access$1800 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/internal/KeepAliveManager;
      //   42: ifnull -> 22
      //   45: aload_0
      //   46: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   49: invokestatic access$1800 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/internal/KeepAliveManager;
      //   52: invokevirtual onDataReceived : ()V
      //   55: goto -> 22
      //   58: aload_0
      //   59: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   62: iconst_0
      //   63: getstatic io/grpc/okhttp/internal/framed/ErrorCode.INTERNAL_ERROR : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   66: getstatic io/grpc/Status.UNAVAILABLE : Lio/grpc/Status;
      //   69: ldc_w 'End of stream or IOException'
      //   72: invokevirtual withDescription : (Ljava/lang/String;)Lio/grpc/Status;
      //   75: invokestatic access$1700 : (Lio/grpc/okhttp/OkHttpClientTransport;ILio/grpc/okhttp/internal/framed/ErrorCode;Lio/grpc/Status;)V
      //   78: aload_0
      //   79: getfield frameReader : Lio/grpc/okhttp/internal/framed/FrameReader;
      //   82: invokeinterface close : ()V
      //   87: goto -> 104
      //   90: astore_2
      //   91: invokestatic access$1900 : ()Ljava/util/logging/Logger;
      //   94: getstatic java/util/logging/Level.INFO : Ljava/util/logging/Level;
      //   97: ldc_w 'Exception closing frame reader'
      //   100: aload_2
      //   101: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   104: aload_0
      //   105: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   108: invokestatic access$2000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/internal/ManagedClientTransport$Listener;
      //   111: invokeinterface transportTerminated : ()V
      //   116: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
      //   119: ifne -> 205
      //   122: goto -> 198
      //   125: astore_3
      //   126: goto -> 206
      //   129: astore_2
      //   130: aload_0
      //   131: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   134: iconst_0
      //   135: getstatic io/grpc/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   138: getstatic io/grpc/Status.UNAVAILABLE : Lio/grpc/Status;
      //   141: ldc_w 'error in frame handler'
      //   144: invokevirtual withDescription : (Ljava/lang/String;)Lio/grpc/Status;
      //   147: aload_2
      //   148: invokevirtual withCause : (Ljava/lang/Throwable;)Lio/grpc/Status;
      //   151: invokestatic access$1700 : (Lio/grpc/okhttp/OkHttpClientTransport;ILio/grpc/okhttp/internal/framed/ErrorCode;Lio/grpc/Status;)V
      //   154: aload_0
      //   155: getfield frameReader : Lio/grpc/okhttp/internal/framed/FrameReader;
      //   158: invokeinterface close : ()V
      //   163: goto -> 180
      //   166: astore_2
      //   167: invokestatic access$1900 : ()Ljava/util/logging/Logger;
      //   170: getstatic java/util/logging/Level.INFO : Ljava/util/logging/Level;
      //   173: ldc_w 'Exception closing frame reader'
      //   176: aload_2
      //   177: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   180: aload_0
      //   181: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   184: invokestatic access$2000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/internal/ManagedClientTransport$Listener;
      //   187: invokeinterface transportTerminated : ()V
      //   192: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
      //   195: ifne -> 205
      //   198: invokestatic currentThread : ()Ljava/lang/Thread;
      //   201: aload_1
      //   202: invokevirtual setName : (Ljava/lang/String;)V
      //   205: return
      //   206: aload_0
      //   207: getfield frameReader : Lio/grpc/okhttp/internal/framed/FrameReader;
      //   210: invokeinterface close : ()V
      //   215: goto -> 232
      //   218: astore_2
      //   219: invokestatic access$1900 : ()Ljava/util/logging/Logger;
      //   222: getstatic java/util/logging/Level.INFO : Ljava/util/logging/Level;
      //   225: ldc_w 'Exception closing frame reader'
      //   228: aload_2
      //   229: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   232: aload_0
      //   233: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   236: invokestatic access$2000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/internal/ManagedClientTransport$Listener;
      //   239: invokeinterface transportTerminated : ()V
      //   244: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
      //   247: ifne -> 257
      //   250: invokestatic currentThread : ()Ljava/lang/Thread;
      //   253: aload_1
      //   254: invokevirtual setName : (Ljava/lang/String;)V
      //   257: aload_3
      //   258: athrow
      // Exception table:
      //   from	to	target	type
      //   22	55	129	java/lang/Throwable
      //   22	55	125	finally
      //   58	78	129	java/lang/Throwable
      //   58	78	125	finally
      //   78	87	90	java/io/IOException
      //   130	154	125	finally
      //   154	163	166	java/io/IOException
      //   206	215	218	java/io/IOException
    }
    
    public void settings(boolean param1Boolean, Settings param1Settings) {
      synchronized (OkHttpClientTransport.this.lock) {
        if (OkHttpSettingsUtil.isSet(param1Settings, 4)) {
          int i = OkHttpSettingsUtil.get(param1Settings, 4);
          OkHttpClientTransport.access$602(OkHttpClientTransport.this, i);
        } 
        if (OkHttpSettingsUtil.isSet(param1Settings, 7)) {
          int i = OkHttpSettingsUtil.get(param1Settings, 7);
          OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(i);
        } 
        if (this.firstSettings) {
          OkHttpClientTransport.this.listener.transportReady();
          this.firstSettings = false;
        } 
        OkHttpClientTransport.this.startPendingStreams();
        OkHttpClientTransport.this.frameWriter.ackSettings(param1Settings);
        return;
      } 
    }
    
    public void windowUpdate(int param1Int, long param1Long) {
      // Byte code:
      //   0: lload_2
      //   1: lconst_0
      //   2: lcmp
      //   3: ifne -> 52
      //   6: iload_1
      //   7: ifne -> 26
      //   10: aload_0
      //   11: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   14: getstatic io/grpc/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   17: ldc_w 'Received 0 flow control window increment.'
      //   20: invokestatic access$2100 : (Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/ErrorCode;Ljava/lang/String;)V
      //   23: goto -> 51
      //   26: aload_0
      //   27: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   30: iload_1
      //   31: getstatic io/grpc/Status.INTERNAL : Lio/grpc/Status;
      //   34: ldc_w 'Received 0 flow control window increment.'
      //   37: invokevirtual withDescription : (Ljava/lang/String;)Lio/grpc/Status;
      //   40: getstatic io/grpc/internal/ClientStreamListener$RpcProgress.PROCESSED : Lio/grpc/internal/ClientStreamListener$RpcProgress;
      //   43: iconst_0
      //   44: getstatic io/grpc/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   47: aconst_null
      //   48: invokevirtual finishStream : (ILio/grpc/Status;Lio/grpc/internal/ClientStreamListener$RpcProgress;ZLio/grpc/okhttp/internal/framed/ErrorCode;Lio/grpc/Metadata;)V
      //   51: return
      //   52: iconst_0
      //   53: istore #4
      //   55: aload_0
      //   56: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   59: invokestatic access$000 : (Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/lang/Object;
      //   62: astore #5
      //   64: aload #5
      //   66: monitorenter
      //   67: iload_1
      //   68: ifne -> 89
      //   71: aload_0
      //   72: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   75: invokestatic access$100 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OutboundFlowController;
      //   78: aconst_null
      //   79: lload_2
      //   80: l2i
      //   81: invokevirtual windowUpdate : (Lio/grpc/okhttp/OkHttpClientStream;I)I
      //   84: pop
      //   85: aload #5
      //   87: monitorexit
      //   88: return
      //   89: aload_0
      //   90: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   93: invokestatic access$2300 : (Lio/grpc/okhttp/OkHttpClientTransport;)Ljava/util/Map;
      //   96: iload_1
      //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   100: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   105: checkcast io/grpc/okhttp/OkHttpClientStream
      //   108: astore #6
      //   110: aload #6
      //   112: ifnull -> 133
      //   115: aload_0
      //   116: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   119: invokestatic access$100 : (Lio/grpc/okhttp/OkHttpClientTransport;)Lio/grpc/okhttp/OutboundFlowController;
      //   122: aload #6
      //   124: lload_2
      //   125: l2i
      //   126: invokevirtual windowUpdate : (Lio/grpc/okhttp/OkHttpClientStream;I)I
      //   129: pop
      //   130: goto -> 147
      //   133: aload_0
      //   134: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   137: iload_1
      //   138: invokevirtual mayHaveCreatedStream : (I)Z
      //   141: ifne -> 147
      //   144: iconst_1
      //   145: istore #4
      //   147: aload #5
      //   149: monitorexit
      //   150: iload #4
      //   152: ifeq -> 203
      //   155: aload_0
      //   156: getfield this$0 : Lio/grpc/okhttp/OkHttpClientTransport;
      //   159: astore #5
      //   161: getstatic io/grpc/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lio/grpc/okhttp/internal/framed/ErrorCode;
      //   164: astore #7
      //   166: new java/lang/StringBuilder
      //   169: dup
      //   170: invokespecial <init> : ()V
      //   173: astore #6
      //   175: aload #6
      //   177: ldc_w 'Received window_update for unknown stream: '
      //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   183: pop
      //   184: aload #6
      //   186: iload_1
      //   187: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   190: pop
      //   191: aload #5
      //   193: aload #7
      //   195: aload #6
      //   197: invokevirtual toString : ()Ljava/lang/String;
      //   200: invokestatic access$2100 : (Lio/grpc/okhttp/OkHttpClientTransport;Lio/grpc/okhttp/internal/framed/ErrorCode;Ljava/lang/String;)V
      //   203: return
      //   204: astore #6
      //   206: aload #5
      //   208: monitorexit
      //   209: aload #6
      //   211: athrow
      // Exception table:
      //   from	to	target	type
      //   71	88	204	finally
      //   89	110	204	finally
      //   115	130	204	finally
      //   133	144	204	finally
      //   147	150	204	finally
      //   206	209	204	finally
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OkHttpClientTransport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */