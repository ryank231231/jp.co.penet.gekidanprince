package io.grpc.stub;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ClientCalls {
  private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());
  
  public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver) {
    return asyncStreamingRequestCall(paramClientCall, paramStreamObserver, true);
  }
  
  public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver) {
    return asyncStreamingRequestCall(paramClientCall, paramStreamObserver, false);
  }
  
  public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, StreamObserver<RespT> paramStreamObserver) {
    asyncUnaryRequestCall(paramClientCall, paramReqT, paramStreamObserver, true);
  }
  
  private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> paramClientCall, StreamObserver<RespT> paramStreamObserver, boolean paramBoolean) {
    CallToStreamObserverAdapter<ReqT> callToStreamObserverAdapter = new CallToStreamObserverAdapter<ReqT>(paramClientCall);
    startCall(paramClientCall, new StreamObserverToCallListenerAdapter<ReqT, RespT>(paramStreamObserver, callToStreamObserverAdapter, paramBoolean), paramBoolean);
    return callToStreamObserverAdapter;
  }
  
  public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, StreamObserver<RespT> paramStreamObserver) {
    asyncUnaryRequestCall(paramClientCall, paramReqT, paramStreamObserver, false);
  }
  
  private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, ClientCall.Listener<RespT> paramListener, boolean paramBoolean) {
    startCall(paramClientCall, paramListener, paramBoolean);
    try {
      paramClientCall.sendMessage(paramReqT);
      paramClientCall.halfClose();
      return;
    } catch (RuntimeException runtimeException) {
      throw cancelThrow(paramClientCall, runtimeException);
    } catch (Error error) {
      throw cancelThrow(paramClientCall, error);
    } 
  }
  
  private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT, StreamObserver<RespT> paramStreamObserver, boolean paramBoolean) {
    asyncUnaryRequestCall(paramClientCall, paramReqT, new StreamObserverToCallListenerAdapter<Object, RespT>(paramStreamObserver, new CallToStreamObserverAdapter(paramClientCall), paramBoolean), paramBoolean);
  }
  
  public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel paramChannel, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, ReqT paramReqT) {
    ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
    ClientCall<?, ?> clientCall = paramChannel.newCall(paramMethodDescriptor, paramCallOptions.withExecutor(threadlessExecutor));
    BlockingResponseStream<?> blockingResponseStream = new BlockingResponseStream(clientCall, threadlessExecutor);
    asyncUnaryRequestCall(clientCall, paramReqT, blockingResponseStream.listener(), true);
    return (Iterator)blockingResponseStream;
  }
  
  public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT) {
    BlockingResponseStream<RespT> blockingResponseStream = new BlockingResponseStream<RespT>(paramClientCall);
    asyncUnaryRequestCall(paramClientCall, paramReqT, blockingResponseStream.listener(), true);
    return blockingResponseStream;
  }
  
  public static <ReqT, RespT> RespT blockingUnaryCall(Channel paramChannel, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, CallOptions paramCallOptions, ReqT paramReqT) {
    ThreadlessExecutor threadlessExecutor = new ThreadlessExecutor();
    ClientCall<ReqT, ?> clientCall = paramChannel.newCall(paramMethodDescriptor, paramCallOptions.withExecutor(threadlessExecutor));
    try {
      ListenableFuture<?> listenableFuture = futureUnaryCall(clientCall, paramReqT);
      while (true) {
        boolean bool = listenableFuture.isDone();
        if (!bool) {
          try {
            threadlessExecutor.waitAndDrain();
          } catch (InterruptedException null) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Call was interrupted").withCause(null).asRuntimeException();
          } 
          continue;
        } 
        return (RespT)getUnchecked((Future<InterruptedException>)null);
      } 
    } catch (RuntimeException runtimeException) {
      throw cancelThrow(clientCall, runtimeException);
    } catch (Error error) {
      throw cancelThrow(clientCall, error);
    } 
  }
  
  public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT) {
    try {
      return (RespT)getUnchecked((Future<ReqT>)futureUnaryCall(paramClientCall, paramReqT));
    } catch (RuntimeException runtimeException) {
      throw cancelThrow(paramClientCall, runtimeException);
    } catch (Error error) {
      throw cancelThrow(paramClientCall, error);
    } 
  }
  
  private static RuntimeException cancelThrow(ClientCall<?, ?> paramClientCall, Throwable paramThrowable) {
    try {
      paramClientCall.cancel(null, paramThrowable);
    } catch (Throwable throwable) {
      logger.log(Level.SEVERE, "RuntimeException encountered while closing call", throwable);
    } 
    if (!(paramThrowable instanceof RuntimeException)) {
      if (paramThrowable instanceof Error)
        throw (Error)paramThrowable; 
      throw new AssertionError(paramThrowable);
    } 
    throw (RuntimeException)paramThrowable;
  }
  
  public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> paramClientCall, ReqT paramReqT) {
    GrpcFuture<RespT> grpcFuture = new GrpcFuture<RespT>(paramClientCall);
    asyncUnaryRequestCall(paramClientCall, paramReqT, new UnaryStreamToFuture<RespT>(grpcFuture), false);
    return (ListenableFuture<RespT>)grpcFuture;
  }
  
  private static <V> V getUnchecked(Future<V> paramFuture) {
    try {
      return paramFuture.get();
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw Status.CANCELLED.withDescription("Call was interrupted").withCause(interruptedException).asRuntimeException();
    } catch (ExecutionException executionException) {
      throw toStatusRuntimeException(executionException.getCause());
    } 
  }
  
  private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> paramClientCall, ClientCall.Listener<RespT> paramListener, boolean paramBoolean) {
    paramClientCall.start(paramListener, new Metadata());
    if (paramBoolean) {
      paramClientCall.request(1);
    } else {
      paramClientCall.request(2);
    } 
  }
  
  private static StatusRuntimeException toStatusRuntimeException(Throwable paramThrowable) {
    StatusRuntimeException statusRuntimeException;
    for (Throwable throwable = (Throwable)Preconditions.checkNotNull(paramThrowable, "t"); throwable != null; throwable = throwable.getCause()) {
      if (throwable instanceof StatusException) {
        StatusException statusException = (StatusException)throwable;
        return new StatusRuntimeException(statusException.getStatus(), statusException.getTrailers());
      } 
      if (throwable instanceof StatusRuntimeException) {
        statusRuntimeException = (StatusRuntimeException)throwable;
        return new StatusRuntimeException(statusRuntimeException.getStatus(), statusRuntimeException.getTrailers());
      } 
    } 
    return Status.UNKNOWN.withDescription("unexpected exception").withCause((Throwable)statusRuntimeException).asRuntimeException();
  }
  
  private static final class BlockingResponseStream<T> implements Iterator<T> {
    private final BlockingQueue<Object> buffer = new ArrayBlockingQueue(2);
    
    private final ClientCall<?, T> call;
    
    private Object last;
    
    private final ClientCall.Listener<T> listener = new QueuingListener();
    
    private final ClientCalls.ThreadlessExecutor threadless;
    
    BlockingResponseStream(ClientCall<?, T> param1ClientCall) {
      this(param1ClientCall, null);
    }
    
    BlockingResponseStream(ClientCall<?, T> param1ClientCall, ClientCalls.ThreadlessExecutor param1ThreadlessExecutor) {
      this.call = param1ClientCall;
      this.threadless = param1ThreadlessExecutor;
    }
    
    private Object waitForNext() throws InterruptedException {
      if (this.threadless == null)
        return this.buffer.take(); 
      Object object;
      for (object = this.buffer.poll(); object == null; object = this.buffer.poll())
        this.threadless.waitAndDrain(); 
      return object;
    }
    
    public boolean hasNext() {
      if (this.last == null)
        try {
          this.last = waitForNext();
        } catch (InterruptedException interruptedException) {
          Thread.currentThread().interrupt();
          throw Status.CANCELLED.withDescription("interrupted").withCause(interruptedException).asRuntimeException();
        }  
      Object object = this.last;
      if (!(object instanceof StatusRuntimeException)) {
        boolean bool;
        if (object != this) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      } 
      object = object;
      throw object.getStatus().asRuntimeException(object.getTrailers());
    }
    
    ClientCall.Listener<T> listener() {
      return this.listener;
    }
    
    public T next() {
      if (hasNext())
        try {
          this.call.request(1);
          return (T)this.last;
        } finally {
          this.last = null;
        }  
      throw new NoSuchElementException();
    }
    
    public void remove() {
      throw new UnsupportedOperationException();
    }
    
    private final class QueuingListener extends ClientCall.Listener<T> {
      private boolean done = false;
      
      public void onClose(Status param2Status, Metadata param2Metadata) {
        Preconditions.checkState(this.done ^ true, "ClientCall already closed");
        if (param2Status.isOk()) {
          ClientCalls.BlockingResponseStream.this.buffer.add(ClientCalls.BlockingResponseStream.this);
        } else {
          ClientCalls.BlockingResponseStream.this.buffer.add(param2Status.asRuntimeException(param2Metadata));
        } 
        this.done = true;
      }
      
      public void onHeaders(Metadata param2Metadata) {}
      
      public void onMessage(T param2T) {
        Preconditions.checkState(this.done ^ true, "ClientCall already closed");
        ClientCalls.BlockingResponseStream.this.buffer.add(param2T);
      }
    }
  }
  
  private final class QueuingListener extends ClientCall.Listener<T> {
    private boolean done = false;
    
    public void onClose(Status param1Status, Metadata param1Metadata) {
      Preconditions.checkState(this.done ^ true, "ClientCall already closed");
      if (param1Status.isOk()) {
        this.this$0.buffer.add(this.this$0);
      } else {
        this.this$0.buffer.add(param1Status.asRuntimeException(param1Metadata));
      } 
      this.done = true;
    }
    
    public void onHeaders(Metadata param1Metadata) {}
    
    public void onMessage(T param1T) {
      Preconditions.checkState(this.done ^ true, "ClientCall already closed");
      this.this$0.buffer.add(param1T);
    }
  }
  
  private static final class CallToStreamObserverAdapter<T> extends ClientCallStreamObserver<T> {
    private boolean autoFlowControlEnabled = true;
    
    private final ClientCall<T, ?> call;
    
    private boolean frozen;
    
    private Runnable onReadyHandler;
    
    CallToStreamObserverAdapter(ClientCall<T, ?> param1ClientCall) {
      this.call = param1ClientCall;
    }
    
    private void freeze() {
      this.frozen = true;
    }
    
    public void cancel(@Nullable String param1String, @Nullable Throwable param1Throwable) {
      this.call.cancel(param1String, param1Throwable);
    }
    
    public void disableAutoInboundFlowControl() {
      if (!this.frozen) {
        this.autoFlowControlEnabled = false;
        return;
      } 
      throw new IllegalStateException("Cannot disable auto flow control call started");
    }
    
    public boolean isReady() {
      return this.call.isReady();
    }
    
    public void onCompleted() {
      this.call.halfClose();
    }
    
    public void onError(Throwable param1Throwable) {
      this.call.cancel("Cancelled by client with StreamObserver.onError()", param1Throwable);
    }
    
    public void onNext(T param1T) {
      this.call.sendMessage(param1T);
    }
    
    public void request(int param1Int) {
      this.call.request(param1Int);
    }
    
    public void setMessageCompression(boolean param1Boolean) {
      this.call.setMessageCompression(param1Boolean);
    }
    
    public void setOnReadyHandler(Runnable param1Runnable) {
      if (!this.frozen) {
        this.onReadyHandler = param1Runnable;
        return;
      } 
      throw new IllegalStateException("Cannot alter onReadyHandler after call started");
    }
  }
  
  private static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
    private final ClientCall<?, RespT> call;
    
    GrpcFuture(ClientCall<?, RespT> param1ClientCall) {
      this.call = param1ClientCall;
    }
    
    protected void interruptTask() {
      this.call.cancel("GrpcFuture was cancelled", null);
    }
    
    protected boolean set(@Nullable RespT param1RespT) {
      return super.set(param1RespT);
    }
    
    protected boolean setException(Throwable param1Throwable) {
      return super.setException(param1Throwable);
    }
  }
  
  private static final class StreamObserverToCallListenerAdapter<ReqT, RespT> extends ClientCall.Listener<RespT> {
    private final ClientCalls.CallToStreamObserverAdapter<ReqT> adapter;
    
    private boolean firstResponseReceived;
    
    private final StreamObserver<RespT> observer;
    
    private final boolean streamingResponse;
    
    StreamObserverToCallListenerAdapter(StreamObserver<RespT> param1StreamObserver, ClientCalls.CallToStreamObserverAdapter<ReqT> param1CallToStreamObserverAdapter, boolean param1Boolean) {
      this.observer = param1StreamObserver;
      this.streamingResponse = param1Boolean;
      this.adapter = param1CallToStreamObserverAdapter;
      if (param1StreamObserver instanceof ClientResponseObserver)
        ((ClientResponseObserver)param1StreamObserver).beforeStart(param1CallToStreamObserverAdapter); 
      param1CallToStreamObserverAdapter.freeze();
    }
    
    public void onClose(Status param1Status, Metadata param1Metadata) {
      if (param1Status.isOk()) {
        this.observer.onCompleted();
      } else {
        this.observer.onError((Throwable)param1Status.asRuntimeException(param1Metadata));
      } 
    }
    
    public void onHeaders(Metadata param1Metadata) {}
    
    public void onMessage(RespT param1RespT) {
      if (!this.firstResponseReceived || this.streamingResponse) {
        this.firstResponseReceived = true;
        this.observer.onNext(param1RespT);
        if (this.streamingResponse && this.adapter.autoFlowControlEnabled)
          this.adapter.request(1); 
        return;
      } 
      throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
    }
    
    public void onReady() {
      if (this.adapter.onReadyHandler != null)
        this.adapter.onReadyHandler.run(); 
    }
  }
  
  private static final class ThreadlessExecutor implements Executor {
    private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
    
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
    
    public void execute(Runnable param1Runnable) {
      this.queue.add(param1Runnable);
    }
    
    public void waitAndDrain() throws InterruptedException {
      for (Runnable runnable = this.queue.take(); runnable != null; runnable = this.queue.poll()) {
        try {
          runnable.run();
        } catch (Throwable throwable) {
          log.log(Level.WARNING, "Runnable threw exception", throwable);
        } 
      } 
    }
  }
  
  private static final class UnaryStreamToFuture<RespT> extends ClientCall.Listener<RespT> {
    private final ClientCalls.GrpcFuture<RespT> responseFuture;
    
    private RespT value;
    
    UnaryStreamToFuture(ClientCalls.GrpcFuture<RespT> param1GrpcFuture) {
      this.responseFuture = param1GrpcFuture;
    }
    
    public void onClose(Status param1Status, Metadata param1Metadata) {
      if (param1Status.isOk()) {
        if (this.value == null)
          this.responseFuture.setException((Throwable)Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(param1Metadata)); 
        this.responseFuture.set(this.value);
      } else {
        this.responseFuture.setException((Throwable)param1Status.asRuntimeException(param1Metadata));
      } 
    }
    
    public void onHeaders(Metadata param1Metadata) {}
    
    public void onMessage(RespT param1RespT) {
      if (this.value == null) {
        this.value = param1RespT;
        return;
      } 
      throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\ClientCalls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */