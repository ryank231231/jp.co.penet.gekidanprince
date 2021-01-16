package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Compressor;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

class DelayedStream implements ClientStream {
  @GuardedBy("this")
  private DelayedStreamListener delayedListener;
  
  @GuardedBy("this")
  private Status error;
  
  private ClientStreamListener listener;
  
  private volatile boolean passThrough;
  
  @GuardedBy("this")
  private List<Runnable> pendingCalls = new ArrayList<Runnable>();
  
  private ClientStream realStream;
  
  private void delayOrExecute(Runnable paramRunnable) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield passThrough : Z
    //   6: ifne -> 23
    //   9: aload_0
    //   10: getfield pendingCalls : Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface add : (Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: invokeinterface run : ()V
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	32	finally
    //   23	25	32	finally
    //   33	35	32	finally
  }
  
  private void drainPendingCalls() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield pendingCalls : Ljava/util/List;
    //   14: invokeinterface isEmpty : ()Z
    //   19: ifeq -> 48
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield pendingCalls : Ljava/util/List;
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield passThrough : Z
    //   32: aload_0
    //   33: getfield delayedListener : Lio/grpc/internal/DelayedStream$DelayedStreamListener;
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: ifnull -> 47
    //   43: aload_1
    //   44: invokevirtual drainPendingCallbacks : ()V
    //   47: return
    //   48: aload_0
    //   49: getfield pendingCalls : Ljava/util/List;
    //   52: astore_2
    //   53: aload_0
    //   54: aload_1
    //   55: putfield pendingCalls : Ljava/util/List;
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: invokeinterface iterator : ()Ljava/util/Iterator;
    //   66: astore_1
    //   67: aload_1
    //   68: invokeinterface hasNext : ()Z
    //   73: ifeq -> 93
    //   76: aload_1
    //   77: invokeinterface next : ()Ljava/lang/Object;
    //   82: checkcast java/lang/Runnable
    //   85: invokeinterface run : ()V
    //   90: goto -> 67
    //   93: aload_2
    //   94: invokeinterface clear : ()V
    //   99: aload_2
    //   100: astore_1
    //   101: goto -> 8
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Exception table:
    //   from	to	target	type
    //   10	39	104	finally
    //   48	60	104	finally
    //   105	107	104	finally
  }
  
  public void cancel(Status paramStatus) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'reason'
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield realStream : Lio/grpc/internal/ClientStream;
    //   13: ifnonnull -> 38
    //   16: aload_0
    //   17: getstatic io/grpc/internal/NoopClientStream.INSTANCE : Lio/grpc/internal/NoopClientStream;
    //   20: putfield realStream : Lio/grpc/internal/ClientStream;
    //   23: iconst_0
    //   24: istore_2
    //   25: aload_0
    //   26: getfield listener : Lio/grpc/internal/ClientStreamListener;
    //   29: astore_3
    //   30: aload_0
    //   31: aload_1
    //   32: putfield error : Lio/grpc/Status;
    //   35: goto -> 42
    //   38: iconst_1
    //   39: istore_2
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_0
    //   43: monitorexit
    //   44: iload_2
    //   45: ifeq -> 64
    //   48: aload_0
    //   49: new io/grpc/internal/DelayedStream$7
    //   52: dup
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial <init> : (Lio/grpc/internal/DelayedStream;Lio/grpc/Status;)V
    //   58: invokespecial delayOrExecute : (Ljava/lang/Runnable;)V
    //   61: goto -> 86
    //   64: aload_3
    //   65: ifnull -> 82
    //   68: aload_3
    //   69: aload_1
    //   70: new io/grpc/Metadata
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: invokeinterface closed : (Lio/grpc/Status;Lio/grpc/Metadata;)V
    //   82: aload_0
    //   83: invokespecial drainPendingCalls : ()V
    //   86: return
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Exception table:
    //   from	to	target	type
    //   9	23	87	finally
    //   25	35	87	finally
    //   42	44	87	finally
    //   88	90	87	finally
  }
  
  public void flush() {
    if (this.passThrough) {
      this.realStream.flush();
    } else {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.this.realStream.flush();
            }
          });
    } 
  }
  
  public Attributes getAttributes() {
    Preconditions.checkState(this.passThrough, "Called getAttributes before attributes are ready");
    return this.realStream.getAttributes();
  }
  
  @VisibleForTesting
  ClientStream getRealStream() {
    return this.realStream;
  }
  
  public void halfClose() {
    delayOrExecute(new Runnable() {
          public void run() {
            DelayedStream.this.realStream.halfClose();
          }
        });
  }
  
  public boolean isReady() {
    return this.passThrough ? this.realStream.isReady() : false;
  }
  
  public void request(final int numMessages) {
    if (this.passThrough) {
      this.realStream.request(numMessages);
    } else {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.this.realStream.request(numMessages);
            }
          });
    } 
  }
  
  public void setAuthority(final String authority) {
    boolean bool;
    if (this.listener == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "May only be called before start");
    Preconditions.checkNotNull(authority, "authority");
    delayOrExecute(new Runnable() {
          public void run() {
            DelayedStream.this.realStream.setAuthority(authority);
          }
        });
  }
  
  public void setCompressor(final Compressor compressor) {
    Preconditions.checkNotNull(compressor, "compressor");
    delayOrExecute(new Runnable() {
          public void run() {
            DelayedStream.this.realStream.setCompressor(compressor);
          }
        });
  }
  
  public void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
    Preconditions.checkNotNull(decompressorRegistry, "decompressorRegistry");
    delayOrExecute(new Runnable() {
          public void run() {
            DelayedStream.this.realStream.setDecompressorRegistry(decompressorRegistry);
          }
        });
  }
  
  public void setFullStreamDecompression(final boolean fullStreamDecompression) {
    delayOrExecute(new Runnable() {
          public void run() {
            DelayedStream.this.realStream.setFullStreamDecompression(fullStreamDecompression);
          }
        });
  }
  
  public void setMaxInboundMessageSize(final int maxSize) {
    if (this.passThrough) {
      this.realStream.setMaxInboundMessageSize(maxSize);
    } else {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.this.realStream.setMaxInboundMessageSize(maxSize);
            }
          });
    } 
  }
  
  public void setMaxOutboundMessageSize(final int maxSize) {
    if (this.passThrough) {
      this.realStream.setMaxOutboundMessageSize(maxSize);
    } else {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.this.realStream.setMaxOutboundMessageSize(maxSize);
            }
          });
    } 
  }
  
  public void setMessageCompression(final boolean enable) {
    if (this.passThrough) {
      this.realStream.setMessageCompression(enable);
    } else {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.this.realStream.setMessageCompression(enable);
            }
          });
    } 
  }
  
  final void setStream(ClientStream paramClientStream) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield realStream : Lio/grpc/internal/ClientStream;
    //   6: ifnull -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: aload_1
    //   14: ldc 'stream'
    //   16: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast io/grpc/internal/ClientStream
    //   22: putfield realStream : Lio/grpc/internal/ClientStream;
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_0
    //   28: invokespecial drainPendingCalls : ()V
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	32	finally
    //   12	27	32	finally
    //   33	35	32	finally
  }
  
  public void start(ClientStreamListener paramClientStreamListener) {
    // Byte code:
    //   0: aload_0
    //   1: getfield listener : Lio/grpc/internal/ClientStreamListener;
    //   4: ifnonnull -> 12
    //   7: iconst_1
    //   8: istore_2
    //   9: goto -> 14
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: ldc 'already started'
    //   17: invokestatic checkState : (ZLjava/lang/Object;)V
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: aload_1
    //   24: ldc 'listener'
    //   26: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast io/grpc/internal/ClientStreamListener
    //   32: putfield listener : Lio/grpc/internal/ClientStreamListener;
    //   35: aload_0
    //   36: getfield error : Lio/grpc/Status;
    //   39: astore_3
    //   40: aload_0
    //   41: getfield passThrough : Z
    //   44: istore_2
    //   45: aload_1
    //   46: astore #4
    //   48: iload_2
    //   49: ifne -> 69
    //   52: new io/grpc/internal/DelayedStream$DelayedStreamListener
    //   55: astore #4
    //   57: aload #4
    //   59: aload_1
    //   60: invokespecial <init> : (Lio/grpc/internal/ClientStreamListener;)V
    //   63: aload_0
    //   64: aload #4
    //   66: putfield delayedListener : Lio/grpc/internal/DelayedStream$DelayedStreamListener;
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: ifnull -> 91
    //   75: aload #4
    //   77: aload_3
    //   78: new io/grpc/Metadata
    //   81: dup
    //   82: invokespecial <init> : ()V
    //   85: invokeinterface closed : (Lio/grpc/Status;Lio/grpc/Metadata;)V
    //   90: return
    //   91: iload_2
    //   92: ifeq -> 109
    //   95: aload_0
    //   96: getfield realStream : Lio/grpc/internal/ClientStream;
    //   99: aload #4
    //   101: invokeinterface start : (Lio/grpc/internal/ClientStreamListener;)V
    //   106: goto -> 123
    //   109: aload_0
    //   110: new io/grpc/internal/DelayedStream$4
    //   113: dup
    //   114: aload_0
    //   115: aload #4
    //   117: invokespecial <init> : (Lio/grpc/internal/DelayedStream;Lio/grpc/internal/ClientStreamListener;)V
    //   120: invokespecial delayOrExecute : (Ljava/lang/Runnable;)V
    //   123: return
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    // Exception table:
    //   from	to	target	type
    //   22	45	124	finally
    //   52	69	124	finally
    //   69	71	124	finally
    //   125	127	124	finally
  }
  
  public void writeMessage(final InputStream message) {
    Preconditions.checkNotNull(message, "message");
    if (this.passThrough) {
      this.realStream.writeMessage(message);
    } else {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.this.realStream.writeMessage(message);
            }
          });
    } 
  }
  
  private static class DelayedStreamListener implements ClientStreamListener {
    private volatile boolean passThrough;
    
    @GuardedBy("this")
    private List<Runnable> pendingCallbacks = new ArrayList<Runnable>();
    
    private final ClientStreamListener realListener;
    
    public DelayedStreamListener(ClientStreamListener param1ClientStreamListener) {
      this.realListener = param1ClientStreamListener;
    }
    
    private void delayOrExecute(Runnable param1Runnable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield passThrough : Z
      //   6: ifne -> 23
      //   9: aload_0
      //   10: getfield pendingCallbacks : Ljava/util/List;
      //   13: aload_1
      //   14: invokeinterface add : (Ljava/lang/Object;)Z
      //   19: pop
      //   20: aload_0
      //   21: monitorexit
      //   22: return
      //   23: aload_0
      //   24: monitorexit
      //   25: aload_1
      //   26: invokeinterface run : ()V
      //   31: return
      //   32: astore_1
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_1
      //   36: athrow
      // Exception table:
      //   from	to	target	type
      //   2	22	32	finally
      //   23	25	32	finally
      //   33	35	32	finally
    }
    
    public void closed(final Status status, final Metadata trailers) {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.DelayedStreamListener.this.realListener.closed(status, trailers);
            }
          });
    }
    
    public void closed(final Status status, final ClientStreamListener.RpcProgress rpcProgress, final Metadata trailers) {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.DelayedStreamListener.this.realListener.closed(status, rpcProgress, trailers);
            }
          });
    }
    
    public void drainPendingCallbacks() {
      // Byte code:
      //   0: new java/util/ArrayList
      //   3: dup
      //   4: invokespecial <init> : ()V
      //   7: astore_1
      //   8: aload_0
      //   9: monitorenter
      //   10: aload_0
      //   11: getfield pendingCallbacks : Ljava/util/List;
      //   14: invokeinterface isEmpty : ()Z
      //   19: ifeq -> 35
      //   22: aload_0
      //   23: aconst_null
      //   24: putfield pendingCallbacks : Ljava/util/List;
      //   27: aload_0
      //   28: iconst_1
      //   29: putfield passThrough : Z
      //   32: aload_0
      //   33: monitorexit
      //   34: return
      //   35: aload_0
      //   36: getfield pendingCallbacks : Ljava/util/List;
      //   39: astore_2
      //   40: aload_0
      //   41: aload_1
      //   42: putfield pendingCallbacks : Ljava/util/List;
      //   45: aload_0
      //   46: monitorexit
      //   47: aload_2
      //   48: invokeinterface iterator : ()Ljava/util/Iterator;
      //   53: astore_1
      //   54: aload_1
      //   55: invokeinterface hasNext : ()Z
      //   60: ifeq -> 80
      //   63: aload_1
      //   64: invokeinterface next : ()Ljava/lang/Object;
      //   69: checkcast java/lang/Runnable
      //   72: invokeinterface run : ()V
      //   77: goto -> 54
      //   80: aload_2
      //   81: invokeinterface clear : ()V
      //   86: aload_2
      //   87: astore_1
      //   88: goto -> 8
      //   91: astore_1
      //   92: aload_0
      //   93: monitorexit
      //   94: aload_1
      //   95: athrow
      // Exception table:
      //   from	to	target	type
      //   10	34	91	finally
      //   35	47	91	finally
      //   92	94	91	finally
    }
    
    public void headersRead(final Metadata headers) {
      delayOrExecute(new Runnable() {
            public void run() {
              DelayedStream.DelayedStreamListener.this.realListener.headersRead(headers);
            }
          });
    }
    
    public void messagesAvailable(final StreamListener.MessageProducer producer) {
      if (this.passThrough) {
        this.realListener.messagesAvailable(producer);
      } else {
        delayOrExecute(new Runnable() {
              public void run() {
                DelayedStream.DelayedStreamListener.this.realListener.messagesAvailable(producer);
              }
            });
      } 
    }
    
    public void onReady() {
      if (this.passThrough) {
        this.realListener.onReady();
      } else {
        delayOrExecute(new Runnable() {
              public void run() {
                DelayedStream.DelayedStreamListener.this.realListener.onReady();
              }
            });
      } 
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.realListener.messagesAvailable(producer);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.realListener.onReady();
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.realListener.headersRead(headers);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.realListener.closed(status, trailers);
    }
  }
  
  class null implements Runnable {
    public void run() {
      this.this$0.realListener.closed(status, rpcProgress, trailers);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\DelayedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */