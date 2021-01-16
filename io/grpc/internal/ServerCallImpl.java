package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.Status;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ServerCallImpl<ReqT, RespT> extends ServerCall<ReqT, RespT> {
  @VisibleForTesting
  static final String MISSING_RESPONSE = "Completed without a response";
  
  @VisibleForTesting
  static final String TOO_MANY_RESPONSES = "Too many responses";
  
  private static final Logger log = Logger.getLogger(ServerCallImpl.class.getName());
  
  private volatile boolean cancelled;
  
  private boolean closeCalled;
  
  private Compressor compressor;
  
  private final CompressorRegistry compressorRegistry;
  
  private final Context.CancellableContext context;
  
  private final DecompressorRegistry decompressorRegistry;
  
  private final byte[] messageAcceptEncoding;
  
  private boolean messageSent;
  
  private final MethodDescriptor<ReqT, RespT> method;
  
  private boolean sendHeadersCalled;
  
  private CallTracer serverCallTracer;
  
  private final ServerStream stream;
  
  ServerCallImpl(ServerStream paramServerStream, MethodDescriptor<ReqT, RespT> paramMethodDescriptor, Metadata paramMetadata, Context.CancellableContext paramCancellableContext, DecompressorRegistry paramDecompressorRegistry, CompressorRegistry paramCompressorRegistry, CallTracer paramCallTracer) {
    this.stream = paramServerStream;
    this.method = paramMethodDescriptor;
    this.context = paramCancellableContext;
    this.messageAcceptEncoding = (byte[])paramMetadata.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
    this.decompressorRegistry = paramDecompressorRegistry;
    this.compressorRegistry = paramCompressorRegistry;
    this.serverCallTracer = paramCallTracer;
    this.serverCallTracer.reportCallStarted();
  }
  
  private void internalClose(Status paramStatus) {
    log.log(Level.WARNING, "Cancelling the stream with status {0}", new Object[] { paramStatus });
    this.stream.cancel(paramStatus);
    this.serverCallTracer.reportCallEnded(paramStatus.isOk());
  }
  
  public void close(Status paramStatus, Metadata paramMetadata) {
    Preconditions.checkState(this.closeCalled ^ true, "call already closed");
    try {
      this.closeCalled = true;
      if (paramStatus.isOk() && this.method.getType().serverSendsOneMessage() && !this.messageSent) {
        internalClose(Status.INTERNAL.withDescription("Completed without a response"));
        return;
      } 
      this.stream.close(paramStatus, paramMetadata);
      return;
    } finally {
      this.serverCallTracer.reportCallEnded(paramStatus.isOk());
    } 
  }
  
  public Attributes getAttributes() {
    return this.stream.getAttributes();
  }
  
  public String getAuthority() {
    return this.stream.getAuthority();
  }
  
  public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
    return this.method;
  }
  
  public boolean isCancelled() {
    return this.cancelled;
  }
  
  public boolean isReady() {
    return this.stream.isReady();
  }
  
  ServerStreamListener newServerStreamListener(ServerCall.Listener<ReqT> paramListener) {
    return new ServerStreamListenerImpl<ReqT>(this, paramListener, this.context);
  }
  
  public void request(int paramInt) {
    this.stream.request(paramInt);
  }
  
  public void sendHeaders(Metadata paramMetadata) {
    Preconditions.checkState(this.sendHeadersCalled ^ true, "sendHeaders has already been called");
    Preconditions.checkState(this.closeCalled ^ true, "call is closed");
    paramMetadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
    if (this.compressor == null) {
      this.compressor = (Compressor)Codec.Identity.NONE;
    } else if (this.messageAcceptEncoding != null) {
      if (!GrpcUtil.iterableContains(GrpcUtil.ACCEPT_ENCODING_SPLITTER.split(new String(this.messageAcceptEncoding, GrpcUtil.US_ASCII)), this.compressor.getMessageEncoding()))
        this.compressor = (Compressor)Codec.Identity.NONE; 
    } else {
      this.compressor = (Compressor)Codec.Identity.NONE;
    } 
    paramMetadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, this.compressor.getMessageEncoding());
    this.stream.setCompressor(this.compressor);
    paramMetadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
    byte[] arrayOfByte = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(this.decompressorRegistry);
    if (arrayOfByte.length != 0)
      paramMetadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, arrayOfByte); 
    this.sendHeadersCalled = true;
    this.stream.writeHeaders(paramMetadata);
  }
  
  public void sendMessage(RespT paramRespT) {
    Preconditions.checkState(this.sendHeadersCalled, "sendHeaders has not been called");
    Preconditions.checkState(this.closeCalled ^ true, "call is closed");
    if (this.method.getType().serverSendsOneMessage() && this.messageSent) {
      internalClose(Status.INTERNAL.withDescription("Too many responses"));
      return;
    } 
    this.messageSent = true;
    try {
      InputStream inputStream = this.method.streamResponse(paramRespT);
      this.stream.writeMessage(inputStream);
      this.stream.flush();
    } catch (RuntimeException runtimeException) {
      close(Status.fromThrowable(runtimeException), new Metadata());
    } catch (Error error) {
      close(Status.CANCELLED.withDescription("Server sendMessage() failed with Error"), new Metadata());
      throw error;
    } 
  }
  
  public void setCompression(String paramString) {
    boolean bool = this.sendHeadersCalled;
    boolean bool1 = true;
    Preconditions.checkState(bool ^ true, "sendHeaders has been called");
    this.compressor = this.compressorRegistry.lookupCompressor(paramString);
    if (this.compressor == null)
      bool1 = false; 
    Preconditions.checkArgument(bool1, "Unable to find compressor by name %s", paramString);
  }
  
  public void setMessageCompression(boolean paramBoolean) {
    this.stream.setMessageCompression(paramBoolean);
  }
  
  @VisibleForTesting
  static final class ServerStreamListenerImpl<ReqT> implements ServerStreamListener {
    private final ServerCallImpl<ReqT, ?> call;
    
    private final Context.CancellableContext context;
    
    private final ServerCall.Listener<ReqT> listener;
    
    public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> param1ServerCallImpl, ServerCall.Listener<ReqT> param1Listener, Context.CancellableContext param1CancellableContext) {
      this.call = (ServerCallImpl<ReqT, ?>)Preconditions.checkNotNull(param1ServerCallImpl, "call");
      this.listener = (ServerCall.Listener<ReqT>)Preconditions.checkNotNull(param1Listener, "listener must not be null");
      this.context = (Context.CancellableContext)Preconditions.checkNotNull(param1CancellableContext, "context");
      this.context.addListener(new Context.CancellationListener() {
            public void cancelled(Context param2Context) {
              ServerCallImpl.access$102(ServerCallImpl.ServerStreamListenerImpl.this.call, true);
            }
          }MoreExecutors.directExecutor());
    }
    
    public void closed(Status param1Status) {
      try {
        if (param1Status.isOk()) {
          this.listener.onComplete();
        } else {
          ServerCallImpl.access$102(this.call, true);
          this.listener.onCancel();
        } 
        return;
      } finally {
        this.context.cancel(null);
      } 
    }
    
    public void halfClosed() {
      if (this.call.cancelled)
        return; 
      this.listener.onHalfClose();
    }
    
    public void messagesAvailable(StreamListener.MessageProducer param1MessageProducer) {
      if (this.call.cancelled) {
        GrpcUtil.closeQuietly(param1MessageProducer);
        return;
      } 
      try {
        while (true) {
          InputStream inputStream = param1MessageProducer.next();
          if (inputStream != null) {
            try {
              this.listener.onMessage(this.call.method.parseRequest(inputStream));
              inputStream.close();
            } catch (Throwable throwable) {
              GrpcUtil.closeQuietly(inputStream);
              throw throwable;
            } 
            continue;
          } 
          break;
        } 
        return;
      } catch (Throwable throwable) {
        GrpcUtil.closeQuietly(param1MessageProducer);
        MoreThrowables.throwIfUnchecked(throwable);
        throw new RuntimeException(throwable);
      } 
    }
    
    public void onReady() {
      if (this.call.cancelled)
        return; 
      this.listener.onReady();
    }
  }
  
  class null implements Context.CancellationListener {
    public void cancelled(Context param1Context) {
      ServerCallImpl.access$102(this.this$0.call, true);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerCallImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */