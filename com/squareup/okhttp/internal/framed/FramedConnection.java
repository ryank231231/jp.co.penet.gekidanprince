package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection implements Closeable {
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  
  private static final ExecutorService executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp FramedConnection", true));
  
  long bytesLeftInWriteWindow;
  
  final boolean client;
  
  private final Set<Integer> currentPushRequests = new LinkedHashSet<Integer>();
  
  final FrameWriter frameWriter;
  
  private final String hostName;
  
  private long idleStartTimeNs = System.nanoTime();
  
  private int lastGoodStreamId;
  
  private final Listener listener;
  
  private int nextPingId;
  
  private int nextStreamId;
  
  Settings okHttpSettings = new Settings();
  
  final Settings peerSettings = new Settings();
  
  private Map<Integer, Ping> pings;
  
  final Protocol protocol;
  
  private final ExecutorService pushExecutor;
  
  private final PushObserver pushObserver;
  
  final Reader readerRunnable;
  
  private boolean receivedInitialPeerSettings = false;
  
  private boolean shutdown;
  
  final Socket socket;
  
  private final Map<Integer, FramedStream> streams = new HashMap<Integer, FramedStream>();
  
  long unacknowledgedBytesRead = 0L;
  
  final Variant variant;
  
  private FramedConnection(Builder paramBuilder) throws IOException {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    boolean bool = paramBuilder.client;
    byte b1 = 2;
    if (bool) {
      b2 = 1;
    } else {
      b2 = 2;
    } 
    this.nextStreamId = b2;
    if (paramBuilder.client && this.protocol == Protocol.HTTP_2)
      this.nextStreamId += 2; 
    byte b2 = b1;
    if (paramBuilder.client)
      b2 = 1; 
    this.nextPingId = b2;
    if (paramBuilder.client)
      this.okHttpSettings.set(7, 0, 16777216); 
    this.hostName = paramBuilder.hostName;
    if (this.protocol == Protocol.HTTP_2) {
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[] { this.hostName }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    } else if (this.protocol == Protocol.SPDY_3) {
      this.variant = new Spdy3();
      this.pushExecutor = null;
    } else {
      throw new AssertionError(this.protocol);
    } 
    this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
    this.socket = paramBuilder.socket;
    this.frameWriter = this.variant.newWriter(paramBuilder.sink, this.client);
    this.readerRunnable = new Reader(this.variant.newReader(paramBuilder.source, this.client));
    (new Thread((Runnable)this.readerRunnable)).start();
  }
  
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual shutdown : (Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   7: aconst_null
    //   8: astore_1
    //   9: goto -> 13
    //   12: astore_1
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield streams : Ljava/util/Map;
    //   19: invokeinterface isEmpty : ()Z
    //   24: istore #4
    //   26: iconst_0
    //   27: istore #5
    //   29: iload #4
    //   31: ifne -> 82
    //   34: aload_0
    //   35: getfield streams : Ljava/util/Map;
    //   38: invokeinterface values : ()Ljava/util/Collection;
    //   43: aload_0
    //   44: getfield streams : Ljava/util/Map;
    //   47: invokeinterface size : ()I
    //   52: anewarray com/squareup/okhttp/internal/framed/FramedStream
    //   55: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   60: checkcast [Lcom/squareup/okhttp/internal/framed/FramedStream;
    //   63: astore #6
    //   65: aload_0
    //   66: getfield streams : Ljava/util/Map;
    //   69: invokeinterface clear : ()V
    //   74: aload_0
    //   75: iconst_0
    //   76: invokespecial setIdle : (Z)V
    //   79: goto -> 85
    //   82: aconst_null
    //   83: astore #6
    //   85: aload_0
    //   86: getfield pings : Ljava/util/Map;
    //   89: ifnull -> 127
    //   92: aload_0
    //   93: getfield pings : Ljava/util/Map;
    //   96: invokeinterface values : ()Ljava/util/Collection;
    //   101: aload_0
    //   102: getfield pings : Ljava/util/Map;
    //   105: invokeinterface size : ()I
    //   110: anewarray com/squareup/okhttp/internal/framed/Ping
    //   113: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   118: checkcast [Lcom/squareup/okhttp/internal/framed/Ping;
    //   121: astore_3
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield pings : Ljava/util/Map;
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: astore #7
    //   132: aload #6
    //   134: ifnull -> 196
    //   137: aload #6
    //   139: arraylength
    //   140: istore #8
    //   142: iconst_0
    //   143: istore #9
    //   145: iload #9
    //   147: iload #8
    //   149: if_icmpge -> 193
    //   152: aload #6
    //   154: iload #9
    //   156: aaload
    //   157: astore #7
    //   159: aload #7
    //   161: aload_2
    //   162: invokevirtual close : (Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   165: aload_1
    //   166: astore #7
    //   168: goto -> 184
    //   171: astore #10
    //   173: aload_1
    //   174: astore #7
    //   176: aload_1
    //   177: ifnull -> 184
    //   180: aload #10
    //   182: astore #7
    //   184: iinc #9, 1
    //   187: aload #7
    //   189: astore_1
    //   190: goto -> 145
    //   193: aload_1
    //   194: astore #7
    //   196: aload_3
    //   197: ifnull -> 228
    //   200: aload_3
    //   201: arraylength
    //   202: istore #8
    //   204: iload #5
    //   206: istore #9
    //   208: iload #9
    //   210: iload #8
    //   212: if_icmpge -> 228
    //   215: aload_3
    //   216: iload #9
    //   218: aaload
    //   219: invokevirtual cancel : ()V
    //   222: iinc #9, 1
    //   225: goto -> 208
    //   228: aload_0
    //   229: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   232: invokeinterface close : ()V
    //   237: aload #7
    //   239: astore_1
    //   240: goto -> 254
    //   243: astore_2
    //   244: aload #7
    //   246: astore_1
    //   247: aload #7
    //   249: ifnonnull -> 254
    //   252: aload_2
    //   253: astore_1
    //   254: aload_0
    //   255: getfield socket : Ljava/net/Socket;
    //   258: invokevirtual close : ()V
    //   261: goto -> 265
    //   264: astore_1
    //   265: aload_1
    //   266: ifnonnull -> 270
    //   269: return
    //   270: aload_1
    //   271: athrow
    //   272: astore_1
    //   273: aload_0
    //   274: monitorexit
    //   275: aload_1
    //   276: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	12	java/io/IOException
    //   15	26	272	finally
    //   34	79	272	finally
    //   85	127	272	finally
    //   127	129	272	finally
    //   159	165	171	java/io/IOException
    //   228	237	243	java/io/IOException
    //   254	261	264	java/io/IOException
    //   273	275	272	finally
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    // Byte code:
    //   0: iload_3
    //   1: iconst_1
    //   2: ixor
    //   3: istore #5
    //   5: iload #4
    //   7: iconst_1
    //   8: ixor
    //   9: istore #4
    //   11: aload_0
    //   12: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   15: astore #6
    //   17: aload #6
    //   19: monitorenter
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield shutdown : Z
    //   26: ifne -> 171
    //   29: aload_0
    //   30: getfield nextStreamId : I
    //   33: istore #7
    //   35: aload_0
    //   36: aload_0
    //   37: getfield nextStreamId : I
    //   40: iconst_2
    //   41: iadd
    //   42: putfield nextStreamId : I
    //   45: new com/squareup/okhttp/internal/framed/FramedStream
    //   48: astore #8
    //   50: aload #8
    //   52: iload #7
    //   54: aload_0
    //   55: iload #5
    //   57: iload #4
    //   59: aload_2
    //   60: invokespecial <init> : (ILcom/squareup/okhttp/internal/framed/FramedConnection;ZZLjava/util/List;)V
    //   63: aload #8
    //   65: invokevirtual isOpen : ()Z
    //   68: ifeq -> 93
    //   71: aload_0
    //   72: getfield streams : Ljava/util/Map;
    //   75: iload #7
    //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   80: aload #8
    //   82: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: aload_0
    //   89: iconst_0
    //   90: invokespecial setIdle : (Z)V
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_1
    //   96: ifne -> 119
    //   99: aload_0
    //   100: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   103: iload #5
    //   105: iload #4
    //   107: iload #7
    //   109: iload_1
    //   110: aload_2
    //   111: invokeinterface synStream : (ZZIILjava/util/List;)V
    //   116: goto -> 139
    //   119: aload_0
    //   120: getfield client : Z
    //   123: ifne -> 158
    //   126: aload_0
    //   127: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   130: iload_1
    //   131: iload #7
    //   133: aload_2
    //   134: invokeinterface pushPromise : (IILjava/util/List;)V
    //   139: aload #6
    //   141: monitorexit
    //   142: iload_3
    //   143: ifne -> 155
    //   146: aload_0
    //   147: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   150: invokeinterface flush : ()V
    //   155: aload #8
    //   157: areturn
    //   158: new java/lang/IllegalArgumentException
    //   161: astore_2
    //   162: aload_2
    //   163: ldc_w 'client streams shouldn't have associated stream IDs'
    //   166: invokespecial <init> : (Ljava/lang/String;)V
    //   169: aload_2
    //   170: athrow
    //   171: new java/io/IOException
    //   174: astore_2
    //   175: aload_2
    //   176: ldc_w 'shutdown'
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: aload_2
    //   183: athrow
    //   184: astore_2
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_2
    //   188: athrow
    //   189: astore_2
    //   190: aload #6
    //   192: monitorexit
    //   193: aload_2
    //   194: athrow
    // Exception table:
    //   from	to	target	type
    //   20	22	189	finally
    //   22	93	184	finally
    //   93	95	184	finally
    //   99	116	189	finally
    //   119	139	189	finally
    //   139	142	189	finally
    //   158	171	189	finally
    //   171	184	184	finally
    //   185	187	184	finally
    //   187	189	189	finally
    //   190	193	189	finally
  }
  
  private void pushDataLater(final int streamId, BufferedSource paramBufferedSource, final int byteCount, final boolean inFinished) throws IOException {
    final Buffer buffer = new Buffer();
    long l = byteCount;
    paramBufferedSource.require(l);
    paramBufferedSource.read(buffer, l);
    if (buffer.size() == l) {
      this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
            public void execute() {
              try {
                boolean bool = FramedConnection.this.pushObserver.onData(streamId, (BufferedSource)buffer, byteCount, inFinished);
                if (bool)
                  FramedConnection.this.frameWriter.rstStream(streamId, ErrorCode.CANCEL); 
                if (bool || inFinished)
                  synchronized (FramedConnection.this) {
                    FramedConnection.this.currentPushRequests.remove(Integer.valueOf(streamId));
                  }  
              } catch (IOException iOException) {}
            }
          });
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(buffer.size());
    stringBuilder.append(" != ");
    stringBuilder.append(byteCount);
    throw new IOException(stringBuilder.toString());
  }
  
  private void pushHeadersLater(final int streamId, final List<Header> requestHeaders, final boolean inFinished) {
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            // Byte code:
            //   0: aload_0
            //   1: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   4: invokestatic access$2700 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;)Lcom/squareup/okhttp/internal/framed/PushObserver;
            //   7: aload_0
            //   8: getfield val$streamId : I
            //   11: aload_0
            //   12: getfield val$requestHeaders : Ljava/util/List;
            //   15: aload_0
            //   16: getfield val$inFinished : Z
            //   19: invokeinterface onHeaders : (ILjava/util/List;Z)Z
            //   24: istore_1
            //   25: iload_1
            //   26: ifeq -> 48
            //   29: aload_0
            //   30: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   33: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
            //   36: aload_0
            //   37: getfield val$streamId : I
            //   40: getstatic com/squareup/okhttp/internal/framed/ErrorCode.CANCEL : Lcom/squareup/okhttp/internal/framed/ErrorCode;
            //   43: invokeinterface rstStream : (ILcom/squareup/okhttp/internal/framed/ErrorCode;)V
            //   48: iload_1
            //   49: ifne -> 59
            //   52: aload_0
            //   53: getfield val$inFinished : Z
            //   56: ifeq -> 96
            //   59: aload_0
            //   60: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   63: astore_2
            //   64: aload_2
            //   65: monitorenter
            //   66: aload_0
            //   67: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
            //   70: invokestatic access$2800 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;)Ljava/util/Set;
            //   73: aload_0
            //   74: getfield val$streamId : I
            //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   80: invokeinterface remove : (Ljava/lang/Object;)Z
            //   85: pop
            //   86: aload_2
            //   87: monitorexit
            //   88: goto -> 96
            //   91: astore_3
            //   92: aload_2
            //   93: monitorexit
            //   94: aload_3
            //   95: athrow
            //   96: return
            //   97: astore_2
            //   98: goto -> 96
            // Exception table:
            //   from	to	target	type
            //   29	48	97	java/io/IOException
            //   52	59	97	java/io/IOException
            //   59	66	97	java/io/IOException
            //   66	88	91	finally
            //   92	94	91	finally
            //   94	96	97	java/io/IOException
          }
        });
  }
  
  private void pushRequestLater(int paramInt, List<Header> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield currentPushRequests : Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface contains : (Ljava/lang/Object;)Z
    //   15: ifeq -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
    //   23: invokevirtual writeSynResetLater : (ILcom/squareup/okhttp/internal/framed/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield currentPushRequests : Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: invokeinterface add : (Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: getfield pushExecutor : Ljava/util/concurrent/ExecutorService;
    //   49: new com/squareup/okhttp/internal/framed/FramedConnection$4
    //   52: dup
    //   53: aload_0
    //   54: ldc_w 'OkHttp %s Push Request[%s]'
    //   57: iconst_2
    //   58: anewarray java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield hostName : Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload_1
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: aastore
    //   75: iload_1
    //   76: aload_2
    //   77: invokespecial <init> : (Lcom/squareup/okhttp/internal/framed/FramedConnection;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   80: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   85: return
    //   86: astore_2
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	86	finally
    //   29	45	86	finally
    //   87	89	86	finally
  }
  
  private void pushResetLater(final int streamId, final ErrorCode errorCode) {
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            FramedConnection.this.pushObserver.onReset(streamId, errorCode);
            synchronized (FramedConnection.this) {
              FramedConnection.this.currentPushRequests.remove(Integer.valueOf(streamId));
              return;
            } 
          }
        });
  }
  
  private boolean pushedStream(int paramInt) {
    Protocol protocol1 = this.protocol;
    Protocol protocol2 = Protocol.HTTP_2;
    boolean bool = true;
    if (protocol1 != protocol2 || paramInt == 0 || (paramInt & 0x1) != 0)
      bool = false; 
    return bool;
  }
  
  private Ping removePing(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield pings : Ljava/util/Map;
    //   6: ifnull -> 29
    //   9: aload_0
    //   10: getfield pings : Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   17: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast com/squareup/okhttp/internal/framed/Ping
    //   25: astore_2
    //   26: goto -> 31
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: areturn
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean) {
    long l;
    /* monitor enter ThisExpression{ObjectType{com/squareup/okhttp/internal/framed/FramedConnection}} */
    if (paramBoolean) {
      try {
        l = System.nanoTime();
      } finally {
        Exception exception;
      } 
    } else {
      l = Long.MAX_VALUE;
    } 
    this.idleStartTimeNs = l;
    /* monitor exit ThisExpression{ObjectType{com/squareup/okhttp/internal/framed/FramedConnection}} */
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   4: astore #5
    //   6: aload #5
    //   8: monitorenter
    //   9: aload #4
    //   11: ifnull -> 19
    //   14: aload #4
    //   16: invokevirtual send : ()V
    //   19: aload_0
    //   20: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   23: iload_1
    //   24: iload_2
    //   25: iload_3
    //   26: invokeinterface ping : (ZII)V
    //   31: aload #5
    //   33: monitorexit
    //   34: return
    //   35: astore #4
    //   37: aload #5
    //   39: monitorexit
    //   40: aload #4
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   14	19	35	finally
    //   19	34	35	finally
    //   37	40	35	finally
  }
  
  private void writePingLater(final boolean reply, final int payload1, final int payload2, final Ping ping) {
    executor.execute((Runnable)new NamedRunnable("OkHttp %s ping %08x%08x", new Object[] { this.hostName, Integer.valueOf(payload1), Integer.valueOf(payload2) }) {
          public void execute() {
            try {
              FramedConnection.this.writePing(reply, payload1, payload2, ping);
            } catch (IOException iOException) {}
          }
        });
  }
  
  void addBytesToWriteWindow(long paramLong) {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll(); 
  }
  
  public void close() throws IOException {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush() throws IOException {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield idleStartTimeNs : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public Protocol getProtocol() {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast com/squareup/okhttp/internal/framed/FramedStream
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	23	finally
  }
  
  public boolean isIdle() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield idleStartTimeNs : J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 9223372036854775807
    //   11: lcmp
    //   12: ifeq -> 20
    //   15: iconst_1
    //   16: istore_3
    //   17: goto -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: astore #4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload #4
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public int maxConcurrentStreams() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield peerSettings : Lcom/squareup/okhttp/internal/framed/Settings;
    //   6: ldc 2147483647
    //   8: invokevirtual getMaxConcurrentStreams : (I)I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public Ping ping() throws IOException {
    // Byte code:
    //   0: new com/squareup/okhttp/internal/framed/Ping
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield shutdown : Z
    //   14: ifne -> 81
    //   17: aload_0
    //   18: getfield nextPingId : I
    //   21: istore_2
    //   22: aload_0
    //   23: aload_0
    //   24: getfield nextPingId : I
    //   27: iconst_2
    //   28: iadd
    //   29: putfield nextPingId : I
    //   32: aload_0
    //   33: getfield pings : Ljava/util/Map;
    //   36: ifnonnull -> 52
    //   39: new java/util/HashMap
    //   42: astore_3
    //   43: aload_3
    //   44: invokespecial <init> : ()V
    //   47: aload_0
    //   48: aload_3
    //   49: putfield pings : Ljava/util/Map;
    //   52: aload_0
    //   53: getfield pings : Ljava/util/Map;
    //   56: iload_2
    //   57: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   60: aload_1
    //   61: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_0
    //   70: iconst_0
    //   71: iload_2
    //   72: ldc_w 1330343787
    //   75: aload_1
    //   76: invokespecial writePing : (ZIILcom/squareup/okhttp/internal/framed/Ping;)V
    //   79: aload_1
    //   80: areturn
    //   81: new java/io/IOException
    //   84: astore_1
    //   85: aload_1
    //   86: ldc_w 'shutdown'
    //   89: invokespecial <init> : (Ljava/lang/String;)V
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Exception table:
    //   from	to	target	type
    //   10	52	94	finally
    //   52	69	94	finally
    //   81	94	94	finally
    //   95	97	94	finally
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean) throws IOException {
    if (!this.client) {
      if (this.protocol == Protocol.HTTP_2)
        return newStream(paramInt, paramList, paramBoolean, false); 
      throw new IllegalStateException("protocol != HTTP_2");
    } 
    throw new IllegalStateException("Client cannot push requests.");
  }
  
  FramedStream removeStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast com/squareup/okhttp/internal/framed/FramedStream
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 40
    //   23: aload_0
    //   24: getfield streams : Ljava/util/Map;
    //   27: invokeinterface isEmpty : ()Z
    //   32: ifeq -> 40
    //   35: aload_0
    //   36: iconst_1
    //   37: invokespecial setIdle : (Z)V
    //   40: aload_0
    //   41: invokevirtual notifyAll : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	48	finally
    //   23	40	48	finally
    //   40	44	48	finally
  }
  
  public void sendConnectionPreface() throws IOException {
    this.frameWriter.connectionPreface();
    this.frameWriter.settings(this.okHttpSettings);
    int i = this.okHttpSettings.getInitialWindowSize(65536);
    if (i != 65536)
      this.frameWriter.windowUpdate(0, (i - 65536)); 
  }
  
  public void setSettings(Settings paramSettings) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield shutdown : Z
    //   13: ifne -> 39
    //   16: aload_0
    //   17: getfield okHttpSettings : Lcom/squareup/okhttp/internal/framed/Settings;
    //   20: aload_1
    //   21: invokevirtual merge : (Lcom/squareup/okhttp/internal/framed/Settings;)V
    //   24: aload_0
    //   25: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   28: aload_1
    //   29: invokeinterface settings : (Lcom/squareup/okhttp/internal/framed/Settings;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: monitorexit
    //   38: return
    //   39: new java/io/IOException
    //   42: astore_1
    //   43: aload_1
    //   44: ldc_w 'shutdown'
    //   47: invokespecial <init> : (Ljava/lang/String;)V
    //   50: aload_1
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: aload_2
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   7	9	57	finally
    //   9	36	52	finally
    //   36	38	57	finally
    //   39	52	52	finally
    //   53	55	52	finally
    //   55	57	57	finally
    //   58	60	57	finally
  }
  
  public void shutdown(ErrorCode paramErrorCode) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield shutdown : Z
    //   13: ifeq -> 21
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_2
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield shutdown : Z
    //   26: aload_0
    //   27: getfield lastGoodStreamId : I
    //   30: istore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield frameWriter : Lcom/squareup/okhttp/internal/framed/FrameWriter;
    //   37: iload_3
    //   38: aload_1
    //   39: getstatic com/squareup/okhttp/internal/Util.EMPTY_BYTE_ARRAY : [B
    //   42: invokeinterface goAway : (ILcom/squareup/okhttp/internal/framed/ErrorCode;[B)V
    //   47: aload_2
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_2
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   7	9	55	finally
    //   9	18	50	finally
    //   18	20	55	finally
    //   21	33	50	finally
    //   33	49	55	finally
    //   51	53	50	finally
    //   53	55	55	finally
    //   56	58	55	finally
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong) throws IOException {
    long l = paramLong;
    if (paramLong == 0L) {
      this.frameWriter.data(paramBoolean, paramInt, paramBuffer, 0);
      return;
    } 
    /* monitor enter ThisExpression{ObjectType{com/squareup/okhttp/internal/framed/FramedConnection}} */
    while (l > 0L) {
      try {
        IOException iOException;
        boolean bool;
        while (this.bytesLeftInWriteWindow <= 0L) {
          if (this.streams.containsKey(Integer.valueOf(paramInt))) {
            wait();
            continue;
          } 
          iOException = new IOException();
          this("stream closed");
          throw iOException;
        } 
        int i = Math.min((int)Math.min(l, this.bytesLeftInWriteWindow), this.frameWriter.maxDataLength());
        paramLong = this.bytesLeftInWriteWindow;
        long l1 = i;
        this.bytesLeftInWriteWindow = paramLong - l1;
        /* monitor exit ThisExpression{ObjectType{com/squareup/okhttp/internal/framed/FramedConnection}} */
        l -= l1;
        FrameWriter frameWriter = this.frameWriter;
        if (paramBoolean && l == 0L) {
          bool = true;
        } else {
          bool = false;
        } 
        frameWriter.data(bool, paramInt, (Buffer)iOException, i);
        continue;
      } catch (InterruptedException interruptedException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException();
        this();
        throw interruptedIOException;
      } finally {}
      /* monitor exit ThisExpression{ObjectType{com/squareup/okhttp/internal/framed/FramedConnection}} */
      throw paramBuffer;
    } 
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList) throws IOException {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode) throws IOException {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(final int streamId, final ErrorCode errorCode) {
    executor.submit((Runnable)new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              FramedConnection.this.writeSynReset(streamId, errorCode);
            } catch (IOException iOException) {}
          }
        });
  }
  
  void writeWindowUpdateLater(final int streamId, final long unacknowledgedBytesRead) {
    executor.execute((Runnable)new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostName, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              FramedConnection.this.frameWriter.windowUpdate(streamId, unacknowledgedBytesRead);
            } catch (IOException iOException) {}
          }
        });
  }
  
  public static class Builder {
    private boolean client;
    
    private String hostName;
    
    private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
    
    private Protocol protocol = Protocol.SPDY_3;
    
    private PushObserver pushObserver = PushObserver.CANCEL;
    
    private BufferedSink sink;
    
    private Socket socket;
    
    private BufferedSource source;
    
    public Builder(boolean param1Boolean) throws IOException {
      this.client = param1Boolean;
    }
    
    public FramedConnection build() throws IOException {
      return new FramedConnection(this);
    }
    
    public Builder listener(FramedConnection.Listener param1Listener) {
      this.listener = param1Listener;
      return this;
    }
    
    public Builder protocol(Protocol param1Protocol) {
      this.protocol = param1Protocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver param1PushObserver) {
      this.pushObserver = param1PushObserver;
      return this;
    }
    
    public Builder socket(Socket param1Socket) throws IOException {
      return socket(param1Socket, ((InetSocketAddress)param1Socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(param1Socket)), Okio.buffer(Okio.sink(param1Socket)));
    }
    
    public Builder socket(Socket param1Socket, String param1String, BufferedSource param1BufferedSource, BufferedSink param1BufferedSink) {
      this.socket = param1Socket;
      this.hostName = param1String;
      this.source = param1BufferedSource;
      this.sink = param1BufferedSink;
      return this;
    }
  }
  
  public static abstract class Listener {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
        public void onStream(FramedStream param2FramedStream) throws IOException {
          param2FramedStream.close(ErrorCode.REFUSED_STREAM);
        }
      };
    
    public void onSettings(FramedConnection param1FramedConnection) {}
    
    public abstract void onStream(FramedStream param1FramedStream) throws IOException;
  }
  
  static final class null extends Listener {
    public void onStream(FramedStream param1FramedStream) throws IOException {
      param1FramedStream.close(ErrorCode.REFUSED_STREAM);
    }
  }
  
  class Reader extends NamedRunnable implements FrameReader.Handler {
    final FrameReader frameReader;
    
    private Reader(FrameReader param1FrameReader) {
      super("OkHttp %s", new Object[] { FramedConnection.access$1100(this$0) });
      this.frameReader = param1FrameReader;
    }
    
    private void ackSettingsLater(final Settings peerSettings) {
      FramedConnection.executor.execute((Runnable)new NamedRunnable("OkHttp %s ACK Settings", new Object[] { FramedConnection.access$1100(this.this$0) }) {
            public void execute() {
              try {
                FramedConnection.this.frameWriter.ackSettings(peerSettings);
              } catch (IOException iOException) {}
            }
          });
    }
    
    public void ackSettings() {}
    
    public void alternateService(int param1Int1, String param1String1, ByteString param1ByteString, String param1String2, int param1Int2, long param1Long) {}
    
    public void data(boolean param1Boolean, int param1Int1, BufferedSource param1BufferedSource, int param1Int2) throws IOException {
      if (FramedConnection.this.pushedStream(param1Int1)) {
        FramedConnection.this.pushDataLater(param1Int1, param1BufferedSource, param1Int2, param1Boolean);
        return;
      } 
      FramedStream framedStream = FramedConnection.this.getStream(param1Int1);
      if (framedStream == null) {
        FramedConnection.this.writeSynResetLater(param1Int1, ErrorCode.INVALID_STREAM);
        param1BufferedSource.skip(param1Int2);
        return;
      } 
      framedStream.receiveData(param1BufferedSource, param1Int2);
      if (param1Boolean)
        framedStream.receiveFin(); 
    }
    
    protected void execute() {
      // Byte code:
      //   0: getstatic com/squareup/okhttp/internal/framed/ErrorCode.INTERNAL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   3: astore_1
      //   4: getstatic com/squareup/okhttp/internal/framed/ErrorCode.INTERNAL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   7: astore_2
      //   8: aload_1
      //   9: astore_3
      //   10: aload_1
      //   11: astore #4
      //   13: aload_0
      //   14: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   17: getfield client : Z
      //   20: ifne -> 37
      //   23: aload_1
      //   24: astore_3
      //   25: aload_1
      //   26: astore #4
      //   28: aload_0
      //   29: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   32: invokeinterface readConnectionPreface : ()V
      //   37: aload_1
      //   38: astore_3
      //   39: aload_1
      //   40: astore #4
      //   42: aload_0
      //   43: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   46: aload_0
      //   47: invokeinterface nextFrame : (Lcom/squareup/okhttp/internal/framed/FrameReader$Handler;)Z
      //   52: ifeq -> 58
      //   55: goto -> 37
      //   58: aload_1
      //   59: astore_3
      //   60: aload_1
      //   61: astore #4
      //   63: getstatic com/squareup/okhttp/internal/framed/ErrorCode.NO_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   66: astore_1
      //   67: aload_1
      //   68: astore_3
      //   69: aload_1
      //   70: astore #4
      //   72: getstatic com/squareup/okhttp/internal/framed/ErrorCode.CANCEL : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   75: astore #5
      //   77: aload_0
      //   78: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   81: astore_3
      //   82: aload_1
      //   83: astore #4
      //   85: aload #5
      //   87: astore_1
      //   88: goto -> 117
      //   91: astore #4
      //   93: goto -> 132
      //   96: astore_3
      //   97: aload #4
      //   99: astore_3
      //   100: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   103: astore #4
      //   105: aload #4
      //   107: astore_3
      //   108: getstatic com/squareup/okhttp/internal/framed/ErrorCode.PROTOCOL_ERROR : Lcom/squareup/okhttp/internal/framed/ErrorCode;
      //   111: astore_1
      //   112: aload_0
      //   113: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   116: astore_3
      //   117: aload_3
      //   118: aload #4
      //   120: aload_1
      //   121: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   124: aload_0
      //   125: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   128: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   131: return
      //   132: aload_0
      //   133: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   136: aload_3
      //   137: aload_2
      //   138: invokestatic access$1200 : (Lcom/squareup/okhttp/internal/framed/FramedConnection;Lcom/squareup/okhttp/internal/framed/ErrorCode;Lcom/squareup/okhttp/internal/framed/ErrorCode;)V
      //   141: aload_0
      //   142: getfield frameReader : Lcom/squareup/okhttp/internal/framed/FrameReader;
      //   145: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   148: aload #4
      //   150: athrow
      //   151: astore_3
      //   152: goto -> 124
      //   155: astore_3
      //   156: goto -> 141
      // Exception table:
      //   from	to	target	type
      //   13	23	96	java/io/IOException
      //   13	23	91	finally
      //   28	37	96	java/io/IOException
      //   28	37	91	finally
      //   42	55	96	java/io/IOException
      //   42	55	91	finally
      //   63	67	96	java/io/IOException
      //   63	67	91	finally
      //   72	77	96	java/io/IOException
      //   72	77	91	finally
      //   77	82	151	java/io/IOException
      //   100	105	91	finally
      //   108	112	91	finally
      //   112	117	151	java/io/IOException
      //   117	124	151	java/io/IOException
      //   132	141	155	java/io/IOException
    }
    
    public void goAway(int param1Int, ErrorCode param1ErrorCode, ByteString param1ByteString) {
      FramedConnection framedConnection;
      FramedStream framedStream;
      param1ByteString.size();
      synchronized (FramedConnection.this) {
        FramedStream[] arrayOfFramedStream = (FramedStream[])FramedConnection.this.streams.values().toArray((Object[])new FramedStream[FramedConnection.this.streams.size()]);
        FramedConnection.access$1602(FramedConnection.this, true);
        int i = arrayOfFramedStream.length;
        for (byte b = 0; b < i; b++) {
          framedStream = arrayOfFramedStream[b];
          if (framedStream.getId() > param1Int && framedStream.isLocallyInitiated()) {
            framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
            FramedConnection.this.removeStream(framedStream.getId());
          } 
        } 
        return;
      } 
    }
    
    public void headers(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List, HeadersMode param1HeadersMode) {
      if (FramedConnection.this.pushedStream(param1Int1)) {
        FramedConnection.this.pushHeadersLater(param1Int1, param1List, param1Boolean2);
        return;
      } 
      synchronized (FramedConnection.this) {
        ExecutorService executorService;
        FramedStream framedStream1;
        NamedRunnable namedRunnable;
        if (FramedConnection.this.shutdown)
          return; 
        FramedStream framedStream2 = FramedConnection.this.getStream(param1Int1);
        if (framedStream2 == null) {
          if (param1HeadersMode.failIfStreamAbsent()) {
            FramedConnection.this.writeSynResetLater(param1Int1, ErrorCode.INVALID_STREAM);
            return;
          } 
          if (param1Int1 <= FramedConnection.this.lastGoodStreamId)
            return; 
          if (param1Int1 % 2 == FramedConnection.this.nextStreamId % 2)
            return; 
          framedStream1 = new FramedStream();
          this(param1Int1, FramedConnection.this, param1Boolean1, param1Boolean2, param1List);
          FramedConnection.access$1702(FramedConnection.this, param1Int1);
          FramedConnection.this.streams.put(Integer.valueOf(param1Int1), framedStream1);
          executorService = FramedConnection.executor;
          namedRunnable = new NamedRunnable() {
              public void execute() {
                try {
                  FramedConnection.this.listener.onStream(newStream);
                } catch (IOException iOException) {
                  Logger logger = Internal.logger;
                  Level level = Level.INFO;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("FramedConnection.Listener failure for ");
                  stringBuilder.append(FramedConnection.this.hostName);
                  logger.log(level, stringBuilder.toString(), iOException);
                  try {
                    newStream.close(ErrorCode.PROTOCOL_ERROR);
                  } catch (IOException iOException1) {}
                } 
              }
            };
          super(this, "OkHttp %s stream %d", new Object[] { FramedConnection.access$1100(this.this$0), Integer.valueOf(param1Int1) }, framedStream1);
          executorService.execute((Runnable)namedRunnable);
          return;
        } 
        if (framedStream1.failIfStreamPresent()) {
          namedRunnable.closeLater(ErrorCode.PROTOCOL_ERROR);
          FramedConnection.this.removeStream(param1Int1);
          return;
        } 
        namedRunnable.receiveHeaders((List<Header>)executorService, (HeadersMode)framedStream1);
        if (param1Boolean2)
          namedRunnable.receiveFin(); 
        return;
      } 
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) {
      if (param1Boolean) {
        Ping ping = FramedConnection.this.removePing(param1Int1);
        if (ping != null)
          ping.receive(); 
      } else {
        FramedConnection.this.writePingLater(true, param1Int1, param1Int2, null);
      } 
    }
    
    public void priority(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {}
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) {
      FramedConnection.this.pushRequestLater(param1Int2, param1List);
    }
    
    public void rstStream(int param1Int, ErrorCode param1ErrorCode) {
      if (FramedConnection.this.pushedStream(param1Int)) {
        FramedConnection.this.pushResetLater(param1Int, param1ErrorCode);
        return;
      } 
      FramedStream framedStream = FramedConnection.this.removeStream(param1Int);
      if (framedStream != null)
        framedStream.receiveRstStream(param1ErrorCode); 
    }
    
    public void settings(boolean param1Boolean, Settings param1Settings) {
      synchronized (FramedConnection.this) {
        FramedStream[] arrayOfFramedStream;
        long l;
        int i = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
        if (param1Boolean)
          FramedConnection.this.peerSettings.clear(); 
        FramedConnection.this.peerSettings.merge(param1Settings);
        if (FramedConnection.this.getProtocol() == Protocol.HTTP_2)
          ackSettingsLater(param1Settings); 
        int j = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
        param1Settings = null;
        if (j != -1 && j != i) {
          long l1 = (j - i);
          if (!FramedConnection.this.receivedInitialPeerSettings) {
            FramedConnection.this.addBytesToWriteWindow(l1);
            FramedConnection.access$2302(FramedConnection.this, true);
          } 
          l = l1;
          if (!FramedConnection.this.streams.isEmpty()) {
            arrayOfFramedStream = (FramedStream[])FramedConnection.this.streams.values().toArray((Object[])new FramedStream[FramedConnection.this.streams.size()]);
            l = l1;
          } 
        } else {
          l = 0L;
        } 
        ExecutorService executorService = FramedConnection.executor;
        NamedRunnable namedRunnable = new NamedRunnable() {
            public void execute() {
              FramedConnection.this.listener.onSettings(FramedConnection.this);
            }
          };
        String str = FramedConnection.this.hostName;
        j = 0;
        super(this, "OkHttp %s settings", new Object[] { str });
        executorService.execute((Runnable)namedRunnable);
        if (arrayOfFramedStream != null && l != 0L) {
          i = arrayOfFramedStream.length;
          while (j < i) {
            synchronized (arrayOfFramedStream[j]) {
              null.addBytesToWriteWindow(l);
              j++;
            } 
          } 
        } 
        return;
      } 
    }
    
    public void windowUpdate(int param1Int, long param1Long) {
      // Byte code:
      //   0: iload_1
      //   1: ifne -> 52
      //   4: aload_0
      //   5: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   8: astore #4
      //   10: aload #4
      //   12: monitorenter
      //   13: aload_0
      //   14: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   17: astore #5
      //   19: aload #5
      //   21: aload #5
      //   23: getfield bytesLeftInWriteWindow : J
      //   26: lload_2
      //   27: ladd
      //   28: putfield bytesLeftInWriteWindow : J
      //   31: aload_0
      //   32: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   35: invokevirtual notifyAll : ()V
      //   38: aload #4
      //   40: monitorexit
      //   41: goto -> 90
      //   44: astore #5
      //   46: aload #4
      //   48: monitorexit
      //   49: aload #5
      //   51: athrow
      //   52: aload_0
      //   53: getfield this$0 : Lcom/squareup/okhttp/internal/framed/FramedConnection;
      //   56: iload_1
      //   57: invokevirtual getStream : (I)Lcom/squareup/okhttp/internal/framed/FramedStream;
      //   60: astore #5
      //   62: aload #5
      //   64: ifnull -> 90
      //   67: aload #5
      //   69: monitorenter
      //   70: aload #5
      //   72: lload_2
      //   73: invokevirtual addBytesToWriteWindow : (J)V
      //   76: aload #5
      //   78: monitorexit
      //   79: goto -> 90
      //   82: astore #4
      //   84: aload #5
      //   86: monitorexit
      //   87: aload #4
      //   89: athrow
      //   90: return
      // Exception table:
      //   from	to	target	type
      //   13	41	44	finally
      //   46	49	44	finally
      //   70	79	82	finally
      //   84	87	82	finally
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object[] param1ArrayOfObject) {
      super(param1String, param1ArrayOfObject);
    }
    
    public void execute() {
      try {
        FramedConnection.this.listener.onStream(newStream);
      } catch (IOException iOException) {
        Logger logger = Internal.logger;
        Level level = Level.INFO;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FramedConnection.Listener failure for ");
        stringBuilder.append(FramedConnection.this.hostName);
        logger.log(level, stringBuilder.toString(), iOException);
        try {
          newStream.close(ErrorCode.PROTOCOL_ERROR);
        } catch (IOException iOException1) {}
      } 
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object... param1VarArgs) {
      super(param1String, param1VarArgs);
    }
    
    public void execute() {
      FramedConnection.this.listener.onSettings(FramedConnection.this);
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object[] param1ArrayOfObject) {
      super(param1String, param1ArrayOfObject);
    }
    
    public void execute() {
      try {
        FramedConnection.this.frameWriter.ackSettings(peerSettings);
      } catch (IOException iOException) {}
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\framed\FramedConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */