package io.grpc;

import com.google.common.base.Preconditions;

public final class Contexts {
  public static <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(Context paramContext, ServerCall<ReqT, RespT> paramServerCall, Metadata paramMetadata, ServerCallHandler<ReqT, RespT> paramServerCallHandler) {
    Context context = paramContext.attach();
    try {
      return new ContextualizedServerCallListener(paramServerCallHandler.startCall(paramServerCall, paramMetadata), paramContext);
    } finally {
      paramContext.detach(context);
    } 
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1975")
  public static Status statusFromCancelled(Context paramContext) {
    Preconditions.checkNotNull(paramContext, "context must not be null");
    if (!paramContext.isCancelled())
      return null; 
    Throwable throwable = paramContext.cancellationCause();
    if (throwable == null)
      return Status.CANCELLED.withDescription("io.grpc.Context was cancelled without error"); 
    if (throwable instanceof java.util.concurrent.TimeoutException)
      return Status.DEADLINE_EXCEEDED.withDescription(throwable.getMessage()).withCause(throwable); 
    Status status = Status.fromThrowable(throwable);
    return (Status.Code.UNKNOWN.equals(status.getCode()) && status.getCause() == throwable) ? Status.CANCELLED.withDescription("Context cancelled").withCause(throwable) : status.withCause(throwable);
  }
  
  private static class ContextualizedServerCallListener<ReqT> extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
    private final Context context;
    
    public ContextualizedServerCallListener(ServerCall.Listener<ReqT> param1Listener, Context param1Context) {
      super(param1Listener);
      this.context = param1Context;
    }
    
    public void onCancel() {
      Context context = this.context.attach();
      try {
        super.onCancel();
        return;
      } finally {
        this.context.detach(context);
      } 
    }
    
    public void onComplete() {
      Context context = this.context.attach();
      try {
        super.onComplete();
        return;
      } finally {
        this.context.detach(context);
      } 
    }
    
    public void onHalfClose() {
      Context context = this.context.attach();
      try {
        super.onHalfClose();
        return;
      } finally {
        this.context.detach(context);
      } 
    }
    
    public void onMessage(ReqT param1ReqT) {
      Context context = this.context.attach();
      try {
        super.onMessage(param1ReqT);
        return;
      } finally {
        this.context.detach(context);
      } 
    }
    
    public void onReady() {
      Context context = this.context.attach();
      try {
        super.onReady();
        return;
      } finally {
        this.context.detach(context);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Contexts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */