package io.grpc.stub;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.Status;

public final class ServerCalls {
  @VisibleForTesting
  static final String MISSING_REQUEST = "Half-closed without a request";
  
  @VisibleForTesting
  static final String TOO_MANY_REQUESTS = "Too many requests";
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncBidiStreamingCall(BidiStreamingMethod<ReqT, RespT> paramBidiStreamingMethod) {
    return asyncStreamingRequestCall(paramBidiStreamingMethod);
  }
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncClientStreamingCall(ClientStreamingMethod<ReqT, RespT> paramClientStreamingMethod) {
    return asyncStreamingRequestCall(paramClientStreamingMethod);
  }
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncServerStreamingCall(ServerStreamingMethod<ReqT, RespT> paramServerStreamingMethod) {
    return asyncUnaryRequestCall(paramServerStreamingMethod);
  }
  
  private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncStreamingRequestCall(StreamingRequestMethod<ReqT, RespT> paramStreamingRequestMethod) {
    return new StreamingServerCallHandler<ReqT, RespT>(paramStreamingRequestMethod);
  }
  
  public static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryCall(UnaryMethod<ReqT, RespT> paramUnaryMethod) {
    return asyncUnaryRequestCall(paramUnaryMethod);
  }
  
  private static <ReqT, RespT> ServerCallHandler<ReqT, RespT> asyncUnaryRequestCall(UnaryRequestMethod<ReqT, RespT> paramUnaryRequestMethod) {
    return new UnaryServerCallHandler<ReqT, RespT>(paramUnaryRequestMethod);
  }
  
  public static <T> StreamObserver<T> asyncUnimplementedStreamingCall(MethodDescriptor<?, ?> paramMethodDescriptor, StreamObserver<?> paramStreamObserver) {
    asyncUnimplementedUnaryCall(paramMethodDescriptor, paramStreamObserver);
    return new NoopStreamObserver<T>();
  }
  
  public static void asyncUnimplementedUnaryCall(MethodDescriptor<?, ?> paramMethodDescriptor, StreamObserver<?> paramStreamObserver) {
    Preconditions.checkNotNull(paramMethodDescriptor, "methodDescriptor");
    Preconditions.checkNotNull(paramStreamObserver, "responseObserver");
    paramStreamObserver.onError((Throwable)Status.UNIMPLEMENTED.withDescription(String.format("Method %s is unimplemented", new Object[] { paramMethodDescriptor.getFullMethodName() })).asRuntimeException());
  }
  
  public static interface BidiStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {}
  
  public static interface ClientStreamingMethod<ReqT, RespT> extends StreamingRequestMethod<ReqT, RespT> {}
  
  static class NoopStreamObserver<V> implements StreamObserver<V> {
    public void onCompleted() {}
    
    public void onError(Throwable param1Throwable) {}
    
    public void onNext(V param1V) {}
  }
  
  private static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT> {
    private boolean autoFlowControlEnabled = true;
    
    final ServerCall<ReqT, RespT> call;
    
    volatile boolean cancelled;
    
    private boolean frozen;
    
    private Runnable onCancelHandler;
    
    private Runnable onReadyHandler;
    
    private boolean sentHeaders;
    
    ServerCallStreamObserverImpl(ServerCall<ReqT, RespT> param1ServerCall) {
      this.call = param1ServerCall;
    }
    
    private void freeze() {
      this.frozen = true;
    }
    
    public void disableAutoInboundFlowControl() {
      Preconditions.checkState(this.frozen ^ true, "Cannot disable auto flow control after initialization");
      this.autoFlowControlEnabled = false;
    }
    
    public boolean isCancelled() {
      return this.call.isCancelled();
    }
    
    public boolean isReady() {
      return this.call.isReady();
    }
    
    public void onCompleted() {
      if (!this.cancelled) {
        this.call.close(Status.OK, new Metadata());
        return;
      } 
      throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
    }
    
    public void onError(Throwable param1Throwable) {
      Metadata metadata1 = Status.trailersFromThrowable(param1Throwable);
      Metadata metadata2 = metadata1;
      if (metadata1 == null)
        metadata2 = new Metadata(); 
      this.call.close(Status.fromThrowable(param1Throwable), metadata2);
    }
    
    public void onNext(RespT param1RespT) {
      if (!this.cancelled) {
        if (!this.sentHeaders) {
          this.call.sendHeaders(new Metadata());
          this.sentHeaders = true;
        } 
        this.call.sendMessage(param1RespT);
        return;
      } 
      throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
    }
    
    public void request(int param1Int) {
      this.call.request(param1Int);
    }
    
    public void setCompression(String param1String) {
      this.call.setCompression(param1String);
    }
    
    public void setMessageCompression(boolean param1Boolean) {
      this.call.setMessageCompression(param1Boolean);
    }
    
    public void setOnCancelHandler(Runnable param1Runnable) {
      Preconditions.checkState(this.frozen ^ true, "Cannot alter onCancelHandler after initialization");
      this.onCancelHandler = param1Runnable;
    }
    
    public void setOnReadyHandler(Runnable param1Runnable) {
      Preconditions.checkState(this.frozen ^ true, "Cannot alter onReadyHandler after initialization");
      this.onReadyHandler = param1Runnable;
    }
  }
  
  public static interface ServerStreamingMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {}
  
  private static interface StreamingRequestMethod<ReqT, RespT> {
    StreamObserver<ReqT> invoke(StreamObserver<RespT> param1StreamObserver);
  }
  
  private static final class StreamingServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
    private final ServerCalls.StreamingRequestMethod<ReqT, RespT> method;
    
    StreamingServerCallHandler(ServerCalls.StreamingRequestMethod<ReqT, RespT> param1StreamingRequestMethod) {
      this.method = param1StreamingRequestMethod;
    }
    
    public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> param1ServerCall, Metadata param1Metadata) {
      ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = new ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT>(param1ServerCall);
      StreamObserver<ReqT> streamObserver = this.method.invoke(serverCallStreamObserverImpl);
      serverCallStreamObserverImpl.freeze();
      if (serverCallStreamObserverImpl.autoFlowControlEnabled)
        param1ServerCall.request(1); 
      return new StreamingServerCallListener(streamObserver, serverCallStreamObserverImpl, param1ServerCall);
    }
    
    private final class StreamingServerCallListener extends ServerCall.Listener<ReqT> {
      private final ServerCall<ReqT, RespT> call;
      
      private boolean halfClosed = false;
      
      private final StreamObserver<ReqT> requestObserver;
      
      private final ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
      
      StreamingServerCallListener(StreamObserver<ReqT> param2StreamObserver, ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> param2ServerCallStreamObserverImpl, ServerCall<ReqT, RespT> param2ServerCall) {
        this.requestObserver = param2StreamObserver;
        this.responseObserver = param2ServerCallStreamObserverImpl;
        this.call = param2ServerCall;
      }
      
      public void onCancel() {
        ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = this.responseObserver;
        serverCallStreamObserverImpl.cancelled = true;
        if (serverCallStreamObserverImpl.onCancelHandler != null)
          this.responseObserver.onCancelHandler.run(); 
        if (!this.halfClosed)
          this.requestObserver.onError((Throwable)Status.CANCELLED.withDescription("cancelled before receiving half close").asRuntimeException()); 
      }
      
      public void onHalfClose() {
        this.halfClosed = true;
        this.requestObserver.onCompleted();
      }
      
      public void onMessage(ReqT param2ReqT) {
        this.requestObserver.onNext(param2ReqT);
        if (this.responseObserver.autoFlowControlEnabled)
          this.call.request(1); 
      }
      
      public void onReady() {
        if (this.responseObserver.onReadyHandler != null)
          this.responseObserver.onReadyHandler.run(); 
      }
    }
  }
  
  private final class StreamingServerCallListener extends ServerCall.Listener<ReqT> {
    private final ServerCall<ReqT, RespT> call;
    
    private boolean halfClosed = false;
    
    private final StreamObserver<ReqT> requestObserver;
    
    private final ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
    
    StreamingServerCallListener(StreamObserver<ReqT> param1StreamObserver, ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> param1ServerCallStreamObserverImpl, ServerCall<ReqT, RespT> param1ServerCall) {
      this.requestObserver = param1StreamObserver;
      this.responseObserver = param1ServerCallStreamObserverImpl;
      this.call = param1ServerCall;
    }
    
    public void onCancel() {
      ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = this.responseObserver;
      serverCallStreamObserverImpl.cancelled = true;
      if (serverCallStreamObserverImpl.onCancelHandler != null)
        this.responseObserver.onCancelHandler.run(); 
      if (!this.halfClosed)
        this.requestObserver.onError((Throwable)Status.CANCELLED.withDescription("cancelled before receiving half close").asRuntimeException()); 
    }
    
    public void onHalfClose() {
      this.halfClosed = true;
      this.requestObserver.onCompleted();
    }
    
    public void onMessage(ReqT param1ReqT) {
      this.requestObserver.onNext(param1ReqT);
      if (this.responseObserver.autoFlowControlEnabled)
        this.call.request(1); 
    }
    
    public void onReady() {
      if (this.responseObserver.onReadyHandler != null)
        this.responseObserver.onReadyHandler.run(); 
    }
  }
  
  public static interface UnaryMethod<ReqT, RespT> extends UnaryRequestMethod<ReqT, RespT> {}
  
  private static interface UnaryRequestMethod<ReqT, RespT> {
    void invoke(ReqT param1ReqT, StreamObserver<RespT> param1StreamObserver);
  }
  
  private static final class UnaryServerCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
    private final ServerCalls.UnaryRequestMethod<ReqT, RespT> method;
    
    UnaryServerCallHandler(ServerCalls.UnaryRequestMethod<ReqT, RespT> param1UnaryRequestMethod) {
      this.method = param1UnaryRequestMethod;
    }
    
    public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> param1ServerCall, Metadata param1Metadata) {
      Preconditions.checkArgument(param1ServerCall.getMethodDescriptor().getType().clientSendsOneMessage(), "asyncUnaryRequestCall is only for clientSendsOneMessage methods");
      ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = new ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT>(param1ServerCall);
      param1ServerCall.request(2);
      return new UnaryServerCallListener(serverCallStreamObserverImpl, param1ServerCall);
    }
    
    private final class UnaryServerCallListener extends ServerCall.Listener<ReqT> {
      private final ServerCall<ReqT, RespT> call;
      
      private boolean canInvoke = true;
      
      private ReqT request;
      
      private final ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
      
      UnaryServerCallListener(ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> param2ServerCallStreamObserverImpl, ServerCall<ReqT, RespT> param2ServerCall) {
        this.call = param2ServerCall;
        this.responseObserver = param2ServerCallStreamObserverImpl;
      }
      
      public void onCancel() {
        ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = this.responseObserver;
        serverCallStreamObserverImpl.cancelled = true;
        if (serverCallStreamObserverImpl.onCancelHandler != null)
          this.responseObserver.onCancelHandler.run(); 
      }
      
      public void onHalfClose() {
        if (!this.canInvoke)
          return; 
        if (this.request == null) {
          this.call.close(Status.INTERNAL.withDescription("Half-closed without a request"), new Metadata());
          return;
        } 
        ServerCalls.UnaryServerCallHandler.this.method.invoke(this.request, this.responseObserver);
        this.responseObserver.freeze();
        if (this.call.isReady())
          onReady(); 
      }
      
      public void onMessage(ReqT param2ReqT) {
        if (this.request != null) {
          this.call.close(Status.INTERNAL.withDescription("Too many requests"), new Metadata());
          this.canInvoke = false;
          return;
        } 
        this.request = param2ReqT;
      }
      
      public void onReady() {
        if (this.responseObserver.onReadyHandler != null)
          this.responseObserver.onReadyHandler.run(); 
      }
    }
  }
  
  private final class UnaryServerCallListener extends ServerCall.Listener<ReqT> {
    private final ServerCall<ReqT, RespT> call;
    
    private boolean canInvoke = true;
    
    private ReqT request;
    
    private final ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> responseObserver;
    
    UnaryServerCallListener(ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> param1ServerCallStreamObserverImpl, ServerCall<ReqT, RespT> param1ServerCall) {
      this.call = param1ServerCall;
      this.responseObserver = param1ServerCallStreamObserverImpl;
    }
    
    public void onCancel() {
      ServerCalls.ServerCallStreamObserverImpl<ReqT, RespT> serverCallStreamObserverImpl = this.responseObserver;
      serverCallStreamObserverImpl.cancelled = true;
      if (serverCallStreamObserverImpl.onCancelHandler != null)
        this.responseObserver.onCancelHandler.run(); 
    }
    
    public void onHalfClose() {
      if (!this.canInvoke)
        return; 
      if (this.request == null) {
        this.call.close(Status.INTERNAL.withDescription("Half-closed without a request"), new Metadata());
        return;
      } 
      this.this$0.method.invoke(this.request, this.responseObserver);
      this.responseObserver.freeze();
      if (this.call.isReady())
        onReady(); 
    }
    
    public void onMessage(ReqT param1ReqT) {
      if (this.request != null) {
        this.call.close(Status.INTERNAL.withDescription("Too many requests"), new Metadata());
        this.canInvoke = false;
        return;
      } 
      this.request = param1ReqT;
    }
    
    public void onReady() {
      if (this.responseObserver.onReadyHandler != null)
        this.responseObserver.onReadyHandler.run(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\stub\ServerCalls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */