package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Decompressor;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.InternalServerInterceptors;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import io.grpc.ServerTransportFilter;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class ServerImpl extends Server implements Instrumented<Channelz.ServerStats> {
  private static final ServerStreamListener NOOP_LISTENER;
  
  private static final Logger log = Logger.getLogger(ServerImpl.class.getName());
  
  private final BinaryLogProvider binlogProvider;
  
  private final Channelz channelz;
  
  private final CompressorRegistry compressorRegistry;
  
  private final DecompressorRegistry decompressorRegistry;
  
  private Executor executor;
  
  private final ObjectPool<? extends Executor> executorPool;
  
  private final HandlerRegistry fallbackRegistry;
  
  private final long handshakeTimeoutMillis;
  
  private final ServerInterceptor[] interceptors;
  
  private final Object lock = new Object();
  
  private final LogId logId = LogId.allocate(getClass().getName());
  
  private final InternalHandlerRegistry registry;
  
  private final Context rootContext;
  
  private final CallTracer serverCallTracer;
  
  @GuardedBy("lock")
  private boolean serverShutdownCallbackInvoked;
  
  @GuardedBy("lock")
  private boolean shutdown;
  
  @GuardedBy("lock")
  private Status shutdownNowStatus;
  
  @GuardedBy("lock")
  private boolean started;
  
  @GuardedBy("lock")
  private boolean terminated;
  
  private final List<ServerTransportFilter> transportFilters;
  
  private final InternalServer transportServer;
  
  @GuardedBy("lock")
  private boolean transportServerTerminated;
  
  @GuardedBy("lock")
  private final Collection<ServerTransport> transports = new HashSet<ServerTransport>();
  
  static {
    NOOP_LISTENER = new NoopListener();
  }
  
  ServerImpl(AbstractServerImplBuilder<?> paramAbstractServerImplBuilder, InternalServer paramInternalServer, Context paramContext) {
    this.executorPool = (ObjectPool<? extends Executor>)Preconditions.checkNotNull(paramAbstractServerImplBuilder.executorPool, "executorPool");
    this.registry = (InternalHandlerRegistry)Preconditions.checkNotNull(paramAbstractServerImplBuilder.registryBuilder.build(), "registryBuilder");
    this.fallbackRegistry = (HandlerRegistry)Preconditions.checkNotNull(paramAbstractServerImplBuilder.fallbackRegistry, "fallbackRegistry");
    this.transportServer = (InternalServer)Preconditions.checkNotNull(paramInternalServer, "transportServer");
    this.rootContext = ((Context)Preconditions.checkNotNull(paramContext, "rootContext")).fork();
    this.decompressorRegistry = paramAbstractServerImplBuilder.decompressorRegistry;
    this.compressorRegistry = paramAbstractServerImplBuilder.compressorRegistry;
    this.transportFilters = Collections.unmodifiableList(new ArrayList<ServerTransportFilter>(paramAbstractServerImplBuilder.transportFilters));
    this.interceptors = paramAbstractServerImplBuilder.interceptors.<ServerInterceptor>toArray(new ServerInterceptor[paramAbstractServerImplBuilder.interceptors.size()]);
    this.handshakeTimeoutMillis = paramAbstractServerImplBuilder.handshakeTimeoutMillis;
    this.binlogProvider = paramAbstractServerImplBuilder.binlogProvider;
    this.channelz = paramAbstractServerImplBuilder.channelz;
    this.serverCallTracer = paramAbstractServerImplBuilder.callTracerFactory.create();
    this.channelz.addServer(this);
  }
  
  private void checkForTermination() {
    synchronized (this.lock) {
      if (this.shutdown && this.transports.isEmpty() && this.transportServerTerminated)
        if (!this.terminated) {
          this.terminated = true;
          this.channelz.removeServer(this);
          if (this.executor != null)
            this.executor = this.executorPool.returnObject(this.executor); 
          this.lock.notifyAll();
        } else {
          AssertionError assertionError = new AssertionError();
          this("Server already terminated");
          throw assertionError;
        }  
      return;
    } 
  }
  
  private void transportClosed(ServerTransport paramServerTransport) {
    synchronized (this.lock) {
      if (this.transports.remove(paramServerTransport)) {
        this.channelz.removeServerSocket(this, (Instrumented<Channelz.SocketStats>)paramServerTransport);
        checkForTermination();
        return;
      } 
      AssertionError assertionError = new AssertionError();
      this("Transport already removed");
      throw assertionError;
    } 
  }
  
  public void awaitTermination() throws InterruptedException {
    synchronized (this.lock) {
      while (!this.terminated)
        this.lock.wait(); 
      return;
    } 
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    synchronized (this.lock) {
      long l = paramTimeUnit.toNanos(paramLong);
      paramLong = System.nanoTime();
      while (!this.terminated) {
        long l1 = paramLong + l - System.nanoTime();
        if (l1 > 0L)
          TimeUnit.NANOSECONDS.timedWait(this.lock, l1); 
      } 
      return this.terminated;
    } 
  }
  
  public List<ServerServiceDefinition> getImmutableServices() {
    return this.registry.getServices();
  }
  
  public LogId getLogId() {
    return this.logId;
  }
  
  public List<ServerServiceDefinition> getMutableServices() {
    return Collections.unmodifiableList(this.fallbackRegistry.getServices());
  }
  
  public int getPort() {
    synchronized (this.lock) {
      boolean bool;
      Preconditions.checkState(this.started, "Not started");
      if (!this.terminated) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Already terminated");
      return this.transportServer.getPort();
    } 
  }
  
  public List<ServerServiceDefinition> getServices() {
    List<? extends ServerServiceDefinition> list = this.fallbackRegistry.getServices();
    if (list.isEmpty())
      return this.registry.getServices(); 
    List<ServerServiceDefinition> list1 = this.registry.getServices();
    ArrayList<ServerServiceDefinition> arrayList = new ArrayList(list1.size() + list.size());
    arrayList.addAll(list1);
    arrayList.addAll(list);
    return Collections.unmodifiableList(arrayList);
  }
  
  public ListenableFuture<Channelz.ServerStats> getStats() {
    Channelz.ServerStats.Builder builder = (new Channelz.ServerStats.Builder()).setListenSockets(this.transportServer.getListenSockets());
    this.serverCallTracer.updateBuilder(builder);
    SettableFuture settableFuture = SettableFuture.create();
    settableFuture.set(builder.build());
    return (ListenableFuture<Channelz.ServerStats>)settableFuture;
  }
  
  public boolean isShutdown() {
    synchronized (this.lock) {
      return this.shutdown;
    } 
  }
  
  public boolean isTerminated() {
    synchronized (this.lock) {
      return this.terminated;
    } 
  }
  
  public ServerImpl shutdown() {
    synchronized (this.lock) {
      if (this.shutdown)
        return this; 
      this.shutdown = true;
      boolean bool = this.started;
      if (!bool) {
        this.transportServerTerminated = true;
        checkForTermination();
      } 
      if (bool)
        this.transportServer.shutdown(); 
      return this;
    } 
  }
  
  public ServerImpl shutdownNow() {
    shutdown();
    null = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
    synchronized (this.lock) {
      if (this.shutdownNowStatus != null)
        return this; 
      this.shutdownNowStatus = null;
      ArrayList arrayList = new ArrayList();
      this((Collection)this.transports);
      boolean bool = this.serverShutdownCallbackInvoked;
      if (bool) {
        null = arrayList.iterator();
        while (null.hasNext())
          ((ServerTransport)null.next()).shutdownNow(null); 
      } 
      return this;
    } 
  }
  
  public ServerImpl start() throws IOException {
    synchronized (this.lock) {
      boolean bool = this.started;
      boolean bool1 = false;
      if (!bool) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Already started");
      bool = bool1;
      if (!this.shutdown)
        bool = true; 
      Preconditions.checkState(bool, "Shutting down");
      InternalServer internalServer = this.transportServer;
      ServerListenerImpl serverListenerImpl = new ServerListenerImpl();
      this(this);
      internalServer.start(serverListenerImpl);
      this.executor = (Executor)Preconditions.checkNotNull(this.executorPool.getObject(), "executor");
      this.started = true;
      return this;
    } 
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("logId", this.logId).add("transportServer", this.transportServer).toString();
  }
  
  @VisibleForTesting
  static final class ContextCloser implements Runnable {
    private final Throwable cause;
    
    private final Context.CancellableContext context;
    
    ContextCloser(Context.CancellableContext param1CancellableContext, Throwable param1Throwable) {
      this.context = param1CancellableContext;
      this.cause = param1Throwable;
    }
    
    public void run() {
      this.context.cancel(this.cause);
    }
  }
  
  @VisibleForTesting
  static final class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
    private final Executor callExecutor;
    
    private final Executor cancelExecutor;
    
    private final Context.CancellableContext context;
    
    private ServerStreamListener listener;
    
    private final ServerStream stream;
    
    public JumpToApplicationThreadServerStreamListener(Executor param1Executor1, Executor param1Executor2, ServerStream param1ServerStream, Context.CancellableContext param1CancellableContext) {
      this.callExecutor = param1Executor1;
      this.cancelExecutor = param1Executor2;
      this.stream = param1ServerStream;
      this.context = param1CancellableContext;
    }
    
    private ServerStreamListener getListener() {
      ServerStreamListener serverStreamListener = this.listener;
      if (serverStreamListener != null)
        return serverStreamListener; 
      throw new IllegalStateException("listener unset");
    }
    
    private void internalClose() {
      this.stream.close(Status.UNKNOWN, new Metadata());
    }
    
    public void closed(final Status status) {
      if (!status.isOk())
        this.cancelExecutor.execute(new ServerImpl.ContextCloser(this.context, status.getCause())); 
      final class Closed extends ContextRunnable {
        Closed() {
          super((Context)ServerImpl.JumpToApplicationThreadServerStreamListener.this.context);
        }
        
        public void runInContext() {
          ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
        }
      };
      this.callExecutor.execute(new Closed());
    }
    
    public void halfClosed() {
      final class HalfClosed extends ContextRunnable {
        HalfClosed() {
          super((Context)ServerImpl.JumpToApplicationThreadServerStreamListener.this.context);
        }
        
        public void runInContext() {
          try {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
            return;
          } catch (RuntimeException runtimeException) {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose();
            throw runtimeException;
          } catch (Error error) {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose();
            throw error;
          } 
        }
      };
      this.callExecutor.execute(new HalfClosed());
    }
    
    public void messagesAvailable(final StreamListener.MessageProducer producer) {
      final class MessagesAvailable extends ContextRunnable {
        MessagesAvailable() {
          super((Context)ServerImpl.JumpToApplicationThreadServerStreamListener.this.context);
        }
        
        public void runInContext() {
          try {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().messagesAvailable(producer);
            return;
          } catch (RuntimeException runtimeException) {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose();
            throw runtimeException;
          } catch (Error error) {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose();
            throw error;
          } 
        }
      };
      this.callExecutor.execute(new MessagesAvailable());
    }
    
    public void onReady() {
      final class OnReady extends ContextRunnable {
        OnReady() {
          super((Context)ServerImpl.JumpToApplicationThreadServerStreamListener.this.context);
        }
        
        public void runInContext() {
          try {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
            return;
          } catch (RuntimeException runtimeException) {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose();
            throw runtimeException;
          } catch (Error error) {
            ServerImpl.JumpToApplicationThreadServerStreamListener.this.internalClose();
            throw error;
          } 
        }
      };
      this.callExecutor.execute(new OnReady());
    }
    
    @VisibleForTesting
    void setListener(ServerStreamListener param1ServerStreamListener) {
      boolean bool;
      Preconditions.checkNotNull(param1ServerStreamListener, "listener must not be null");
      if (this.listener == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Listener already set");
      this.listener = param1ServerStreamListener;
    }
  }
  
  final class Closed extends ContextRunnable {
    Closed() {
      super((Context)((ServerImpl.JumpToApplicationThreadServerStreamListener)ServerImpl.this).context);
    }
    
    public void runInContext() {
      this.this$0.getListener().closed(status);
    }
  }
  
  final class HalfClosed extends ContextRunnable {
    HalfClosed() {
      super((Context)((ServerImpl.JumpToApplicationThreadServerStreamListener)ServerImpl.this).context);
    }
    
    public void runInContext() {
      try {
        this.this$0.getListener().halfClosed();
        return;
      } catch (RuntimeException runtimeException) {
        this.this$0.internalClose();
        throw runtimeException;
      } catch (Error error) {
        this.this$0.internalClose();
        throw error;
      } 
    }
  }
  
  final class MessagesAvailable extends ContextRunnable {
    MessagesAvailable() {
      super((Context)((ServerImpl.JumpToApplicationThreadServerStreamListener)ServerImpl.this).context);
    }
    
    public void runInContext() {
      try {
        this.this$0.getListener().messagesAvailable(producer);
        return;
      } catch (RuntimeException runtimeException) {
        this.this$0.internalClose();
        throw runtimeException;
      } catch (Error error) {
        this.this$0.internalClose();
        throw error;
      } 
    }
  }
  
  final class OnReady extends ContextRunnable {
    OnReady() {
      super((Context)((ServerImpl.JumpToApplicationThreadServerStreamListener)ServerImpl.this).context);
    }
    
    public void runInContext() {
      try {
        this.this$0.getListener().onReady();
        return;
      } catch (RuntimeException runtimeException) {
        this.this$0.internalClose();
        throw runtimeException;
      } catch (Error error) {
        this.this$0.internalClose();
        throw error;
      } 
    }
  }
  
  private static final class NoopListener implements ServerStreamListener {
    private NoopListener() {}
    
    public void closed(Status param1Status) {}
    
    public void halfClosed() {}
    
    public void messagesAvailable(StreamListener.MessageProducer param1MessageProducer) {
      while (true) {
        InputStream inputStream = param1MessageProducer.next();
        if (inputStream != null) {
          try {
            inputStream.close();
          } catch (IOException iOException) {
            continue;
          } 
          continue;
        } 
        break;
      } 
    }
    
    public void onReady() {}
  }
  
  private final class ServerListenerImpl implements ServerListener {
    private ServerListenerImpl() {}
    
    public void serverShutdown() {
      synchronized (ServerImpl.this.lock) {
        ArrayList arrayList = new ArrayList();
        this((Collection)ServerImpl.this.transports);
        Status status = ServerImpl.this.shutdownNowStatus;
        ServerImpl.access$502(ServerImpl.this, true);
        for (ServerTransport serverTransport : arrayList) {
          if (status == null) {
            serverTransport.shutdown();
            continue;
          } 
          serverTransport.shutdownNow(status);
        } 
        synchronized (ServerImpl.this.lock) {
          ServerImpl.access$602(ServerImpl.this, true);
          ServerImpl.this.checkForTermination();
          return;
        } 
      } 
    }
    
    public ServerTransportListener transportCreated(ServerTransport param1ServerTransport) {
      synchronized (ServerImpl.this.lock) {
        ServerImpl.this.transports.add(param1ServerTransport);
        ServerImpl.ServerTransportListenerImpl serverTransportListenerImpl = new ServerImpl.ServerTransportListenerImpl(param1ServerTransport);
        serverTransportListenerImpl.init();
        return serverTransportListenerImpl;
      } 
    }
  }
  
  private final class ServerTransportListenerImpl implements ServerTransportListener {
    private Attributes attributes;
    
    private Future<?> handshakeTimeoutFuture;
    
    private final ServerTransport transport;
    
    ServerTransportListenerImpl(ServerTransport param1ServerTransport) {
      this.transport = param1ServerTransport;
    }
    
    private Context.CancellableContext createContext(final ServerStream stream, Metadata param1Metadata, StatsTraceContext param1StatsTraceContext) {
      Long long_ = (Long)param1Metadata.get(GrpcUtil.TIMEOUT_KEY);
      Context context = param1StatsTraceContext.serverFilterContext(ServerImpl.this.rootContext);
      if (long_ == null)
        return context.withCancellation(); 
      Context.CancellableContext cancellableContext = context.withDeadlineAfter(long_.longValue(), TimeUnit.NANOSECONDS, this.transport.getScheduledExecutorService());
      final class ServerStreamCancellationListener implements Context.CancellationListener {
        public void cancelled(Context param2Context) {
          Status status = Contexts.statusFromCancelled(param2Context);
          if (Status.DEADLINE_EXCEEDED.getCode().equals(status.getCode()))
            stream.cancel(status); 
        }
      };
      cancellableContext.addListener(new ServerStreamCancellationListener(), MoreExecutors.directExecutor());
      return cancellableContext;
    }
    
    private <ReqT, RespT> ServerStreamListener startCall(ServerStream param1ServerStream, String param1String, ServerMethodDefinition<ReqT, RespT> param1ServerMethodDefinition, Metadata param1Metadata, Context.CancellableContext param1CancellableContext, StatsTraceContext param1StatsTraceContext) {
      param1StatsTraceContext.serverCallStarted(new ServerCallInfoImpl<Object, Object>(param1ServerMethodDefinition.getMethodDescriptor(), param1ServerStream.getAttributes(), param1ServerStream.getAuthority()));
      ServerCallHandler serverCallHandler = param1ServerMethodDefinition.getServerCallHandler();
      ServerInterceptor[] arrayOfServerInterceptor = ServerImpl.this.interceptors;
      int i = arrayOfServerInterceptor.length;
      for (byte b = 0; b < i; b++)
        serverCallHandler = InternalServerInterceptors.interceptCallHandler(arrayOfServerInterceptor[b], serverCallHandler); 
      param1ServerMethodDefinition = param1ServerMethodDefinition.withServerCallHandler(serverCallHandler);
      if (ServerImpl.this.binlogProvider != null)
        param1ServerMethodDefinition = ServerImpl.this.binlogProvider.wrapMethodDefinition(param1ServerMethodDefinition); 
      return startWrappedCall(param1String, param1ServerMethodDefinition, param1ServerStream, param1Metadata, param1CancellableContext);
    }
    
    private <WReqT, WRespT> ServerStreamListener startWrappedCall(String param1String, ServerMethodDefinition<WReqT, WRespT> param1ServerMethodDefinition, ServerStream param1ServerStream, Metadata param1Metadata, Context.CancellableContext param1CancellableContext) {
      ServerCallImpl<Object, Object> serverCallImpl = new ServerCallImpl<Object, Object>(param1ServerStream, param1ServerMethodDefinition.getMethodDescriptor(), param1Metadata, param1CancellableContext, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry, ServerImpl.this.serverCallTracer);
      ServerCall.Listener listener = param1ServerMethodDefinition.getServerCallHandler().startCall(serverCallImpl, param1Metadata);
      if (listener != null)
        return serverCallImpl.newServerStreamListener(listener); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("startCall() returned a null listener for method ");
      stringBuilder.append(param1String);
      throw new NullPointerException(stringBuilder.toString());
    }
    
    public void init() {
      if (ServerImpl.this.handshakeTimeoutMillis != Long.MAX_VALUE) {
        class TransportShutdownNow implements Runnable {
          public void run() {
            ServerImpl.ServerTransportListenerImpl.this.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
          }
        };
        this.handshakeTimeoutFuture = this.transport.getScheduledExecutorService().schedule(new TransportShutdownNow(), ServerImpl.this.handshakeTimeoutMillis, TimeUnit.MILLISECONDS);
      } else {
        this.handshakeTimeoutFuture = new FutureTask(new Runnable() {
              public void run() {}
            },  null);
      } 
      ServerImpl.this.channelz.addServerSocket(ServerImpl.this, (Instrumented<Channelz.SocketStats>)this.transport);
    }
    
    public void streamCreated(final ServerStream stream, final String methodName, final Metadata headers) {
      SerializingExecutor serializingExecutor;
      if (headers.containsKey(GrpcUtil.MESSAGE_ENCODING_KEY)) {
        String str = (String)headers.get(GrpcUtil.MESSAGE_ENCODING_KEY);
        Decompressor decompressor = ServerImpl.this.decompressorRegistry.lookupDecompressor(str);
        if (decompressor == null) {
          stream.close(Status.UNIMPLEMENTED.withDescription(String.format("Can't find decompressor for %s", new Object[] { str })), new Metadata());
          return;
        } 
        stream.setDecompressor(decompressor);
      } 
      final StatsTraceContext statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(stream.statsTraceContext(), "statsTraceCtx not present from stream");
      final Context.CancellableContext context = createContext(stream, headers, statsTraceContext);
      if (ServerImpl.this.executor == MoreExecutors.directExecutor()) {
        SerializeReentrantCallsDirectExecutor serializeReentrantCallsDirectExecutor = new SerializeReentrantCallsDirectExecutor();
      } else {
        serializingExecutor = new SerializingExecutor(ServerImpl.this.executor);
      } 
      final ServerImpl.JumpToApplicationThreadServerStreamListener jumpListener = new ServerImpl.JumpToApplicationThreadServerStreamListener(serializingExecutor, ServerImpl.this.executor, stream, cancellableContext);
      stream.setListener(jumpToApplicationThreadServerStreamListener);
      final class StreamCreated extends ContextRunnable {
        StreamCreated() {
          super((Context)param2CancellableContext);
        }
        
        public void runInContext() {
          Exception exception;
          ServerStreamListener serverStreamListener = ServerImpl.NOOP_LISTENER;
          try {
            Status status;
            ServerMethodDefinition<?, ?> serverMethodDefinition = ServerImpl.this.registry.lookupMethod(methodName);
            if (serverMethodDefinition == null)
              serverMethodDefinition = ServerImpl.this.fallbackRegistry.lookupMethod(methodName, stream.getAuthority()); 
            if (serverMethodDefinition == null) {
              status = Status.UNIMPLEMENTED;
              StringBuilder stringBuilder = new StringBuilder();
              this();
              stringBuilder.append("Method not found: ");
              stringBuilder.append(methodName);
              status = status.withDescription(stringBuilder.toString());
              ServerStream serverStream = stream;
              Metadata metadata = new Metadata();
              this();
              serverStream.close(status, metadata);
              context.cancel(null);
              jumpListener.setListener(serverStreamListener);
              return;
            } 
            ServerStreamListener serverStreamListener1 = ServerImpl.ServerTransportListenerImpl.this.startCall(stream, methodName, (ServerMethodDefinition<ReqT, RespT>)status, headers, context, statsTraceCtx);
            jumpListener.setListener(serverStreamListener1);
            return;
          } catch (RuntimeException null) {
            ServerStream serverStream = stream;
            Status status = Status.fromThrowable(exception);
            Metadata metadata = new Metadata();
            this();
            serverStream.close(status, metadata);
            context.cancel(null);
            throw exception;
          } catch (Error error) {
            ServerStream serverStream = stream;
            Status status = Status.fromThrowable(error);
            Metadata metadata = new Metadata();
            this();
            serverStream.close(status, metadata);
            context.cancel(null);
            throw error;
          } finally {}
          jumpListener.setListener(serverStreamListener);
          throw exception;
        }
      };
      serializingExecutor.execute(new StreamCreated());
    }
    
    public Attributes transportReady(Attributes param1Attributes) {
      this.handshakeTimeoutFuture.cancel(false);
      this.handshakeTimeoutFuture = null;
      for (ServerTransportFilter serverTransportFilter : ServerImpl.this.transportFilters)
        param1Attributes = (Attributes)Preconditions.checkNotNull(serverTransportFilter.transportReady(param1Attributes), "Filter %s returned null", serverTransportFilter); 
      this.attributes = param1Attributes;
      return param1Attributes;
    }
    
    public void transportTerminated() {
      Future<?> future = this.handshakeTimeoutFuture;
      if (future != null) {
        future.cancel(false);
        this.handshakeTimeoutFuture = null;
      } 
      Iterator<ServerTransportFilter> iterator = ServerImpl.this.transportFilters.iterator();
      while (iterator.hasNext())
        ((ServerTransportFilter)iterator.next()).transportTerminated(this.attributes); 
      ServerImpl.this.transportClosed(this.transport);
    }
  }
  
  class null implements Runnable {
    public void run() {}
  }
  
  final class ServerStreamCancellationListener implements Context.CancellationListener {
    public void cancelled(Context param1Context) {
      Status status = Contexts.statusFromCancelled(param1Context);
      if (Status.DEADLINE_EXCEEDED.getCode().equals(status.getCode()))
        stream.cancel(status); 
    }
  }
  
  final class StreamCreated extends ContextRunnable {
    StreamCreated() {
      super((Context)param1CancellableContext);
    }
    
    public void runInContext() {
      Exception exception;
      ServerStreamListener serverStreamListener = ServerImpl.NOOP_LISTENER;
      try {
        Status status;
        ServerMethodDefinition<?, ?> serverMethodDefinition = ServerImpl.this.registry.lookupMethod(methodName);
        if (serverMethodDefinition == null)
          serverMethodDefinition = ServerImpl.this.fallbackRegistry.lookupMethod(methodName, stream.getAuthority()); 
        if (serverMethodDefinition == null) {
          status = Status.UNIMPLEMENTED;
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Method not found: ");
          stringBuilder.append(methodName);
          status = status.withDescription(stringBuilder.toString());
          ServerStream serverStream = stream;
          Metadata metadata = new Metadata();
          this();
          serverStream.close(status, metadata);
          context.cancel(null);
          jumpListener.setListener(serverStreamListener);
          return;
        } 
        ServerStreamListener serverStreamListener1 = this.this$1.startCall(stream, methodName, (ServerMethodDefinition<ReqT, RespT>)status, headers, context, statsTraceCtx);
        jumpListener.setListener(serverStreamListener1);
        return;
      } catch (RuntimeException null) {
        ServerStream serverStream = stream;
        Status status = Status.fromThrowable(exception);
        Metadata metadata = new Metadata();
        this();
        serverStream.close(status, metadata);
        context.cancel(null);
        throw exception;
      } catch (Error error) {
        ServerStream serverStream = stream;
        Status status = Status.fromThrowable(error);
        Metadata metadata = new Metadata();
        this();
        serverStream.close(status, metadata);
        context.cancel(null);
        throw error;
      } finally {}
      jumpListener.setListener(serverStreamListener);
      throw exception;
    }
  }
  
  class TransportShutdownNow implements Runnable {
    public void run() {
      this.this$1.transport.shutdownNow(Status.CANCELLED.withDescription("Handshake timeout exceeded"));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */