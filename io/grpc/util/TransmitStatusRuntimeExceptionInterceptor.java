package io.grpc.util;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.Attributes;
import io.grpc.ExperimentalApi;
import io.grpc.ForwardingServerCall;
import io.grpc.ForwardingServerCallListener;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.internal.SerializingExecutor;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2189")
public final class TransmitStatusRuntimeExceptionInterceptor implements ServerInterceptor {
  public static ServerInterceptor instance() {
    return new TransmitStatusRuntimeExceptionInterceptor();
  }
  
  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> paramServerCall, Metadata paramMetadata, ServerCallHandler<ReqT, RespT> paramServerCallHandler) {
    final SerializingServerCall<ReqT, RespT> serverCall = new SerializingServerCall<ReqT, RespT>(paramServerCall);
    return (ServerCall.Listener<ReqT>)new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(paramServerCallHandler.startCall((ServerCall)serializingServerCall, paramMetadata)) {
        private void closeWithException(StatusRuntimeException param1StatusRuntimeException) {
          Metadata metadata1 = param1StatusRuntimeException.getTrailers();
          Metadata metadata2 = metadata1;
          if (metadata1 == null)
            metadata2 = new Metadata(); 
          serverCall.close(param1StatusRuntimeException.getStatus(), metadata2);
        }
        
        public void onCancel() {
          try {
            super.onCancel();
          } catch (StatusRuntimeException statusRuntimeException) {
            closeWithException(statusRuntimeException);
          } 
        }
        
        public void onComplete() {
          try {
            super.onComplete();
          } catch (StatusRuntimeException statusRuntimeException) {
            closeWithException(statusRuntimeException);
          } 
        }
        
        public void onHalfClose() {
          try {
            super.onHalfClose();
          } catch (StatusRuntimeException statusRuntimeException) {
            closeWithException(statusRuntimeException);
          } 
        }
        
        public void onMessage(ReqT param1ReqT) {
          try {
            super.onMessage(param1ReqT);
          } catch (StatusRuntimeException statusRuntimeException) {
            closeWithException(statusRuntimeException);
          } 
        }
        
        public void onReady() {
          try {
            super.onReady();
          } catch (StatusRuntimeException statusRuntimeException) {
            closeWithException(statusRuntimeException);
          } 
        }
      };
  }
  
  private static class SerializingServerCall<ReqT, RespT> extends ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT> {
    private static final String ERROR_MSG = "Encountered error during serialized access";
    
    private final SerializingExecutor serializingExecutor = new SerializingExecutor(MoreExecutors.directExecutor());
    
    SerializingServerCall(ServerCall<ReqT, RespT> param1ServerCall) {
      super(param1ServerCall);
    }
    
    public void close(final Status status, final Metadata trailers) {
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.close(status, trailers);
            }
          });
    }
    
    public Attributes getAttributes() {
      final SettableFuture retVal = SettableFuture.create();
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              retVal.set(TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.getAttributes());
            }
          });
      try {
        return (Attributes)settableFuture.get();
      } catch (InterruptedException interruptedException) {
        throw new RuntimeException("Encountered error during serialized access", interruptedException);
      } catch (ExecutionException executionException) {
        throw new RuntimeException("Encountered error during serialized access", executionException);
      } 
    }
    
    @Nullable
    public String getAuthority() {
      final SettableFuture retVal = SettableFuture.create();
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              retVal.set(TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.getAuthority());
            }
          });
      try {
        return (String)settableFuture.get();
      } catch (InterruptedException interruptedException) {
        throw new RuntimeException("Encountered error during serialized access", interruptedException);
      } catch (ExecutionException executionException) {
        throw new RuntimeException("Encountered error during serialized access", executionException);
      } 
    }
    
    public boolean isCancelled() {
      final SettableFuture retVal = SettableFuture.create();
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              retVal.set(Boolean.valueOf(TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.isCancelled()));
            }
          });
      try {
        return ((Boolean)settableFuture.get()).booleanValue();
      } catch (InterruptedException interruptedException) {
        throw new RuntimeException("Encountered error during serialized access", interruptedException);
      } catch (ExecutionException executionException) {
        throw new RuntimeException("Encountered error during serialized access", executionException);
      } 
    }
    
    public boolean isReady() {
      final SettableFuture retVal = SettableFuture.create();
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              retVal.set(Boolean.valueOf(TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.isReady()));
            }
          });
      try {
        return ((Boolean)settableFuture.get()).booleanValue();
      } catch (InterruptedException interruptedException) {
        throw new RuntimeException("Encountered error during serialized access", interruptedException);
      } catch (ExecutionException executionException) {
        throw new RuntimeException("Encountered error during serialized access", executionException);
      } 
    }
    
    public void request(final int numMessages) {
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.request(numMessages);
            }
          });
    }
    
    public void sendHeaders(final Metadata headers) {
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.sendHeaders(headers);
            }
          });
    }
    
    public void sendMessage(final RespT message) {
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.sendMessage(message);
            }
          });
    }
    
    public void setCompression(final String compressor) {
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.setCompression(compressor);
            }
          });
    }
    
    public void setMessageCompression(final boolean enabled) {
      this.serializingExecutor.execute(new Runnable() {
            public void run() {
              TransmitStatusRuntimeExceptionInterceptor.SerializingServerCall.this.setMessageCompression(enabled);
            }
          });
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.sendMessage(message);
    }
  }
  
  class null implements Runnable {
    public void run() {
      retVal.set(this.this$0.getAuthority());
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.request(numMessages);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.sendHeaders(headers);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.close(status, trailers);
    }
  }
  
  class null implements Runnable {
    public void run() {
      retVal.set(Boolean.valueOf(this.this$0.isReady()));
    }
  }
  
  class null implements Runnable {
    public void run() {
      retVal.set(Boolean.valueOf(this.this$0.isCancelled()));
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.setMessageCompression(enabled);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.setCompression(compressor);
    }
  }
  
  class null implements Runnable {
    public void run() {
      retVal.set(this.this$0.getAttributes());
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grp\\util\TransmitStatusRuntimeExceptionInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */