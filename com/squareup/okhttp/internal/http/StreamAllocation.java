package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.io.RealConnection;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okio.Sink;

public final class StreamAllocation {
  public final Address address;
  
  private boolean canceled;
  
  private RealConnection connection;
  
  private final ConnectionPool connectionPool;
  
  private boolean released;
  
  private RouteSelector routeSelector;
  
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress) {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
  }
  
  private void connectionFailed(IOException paramIOException) {
    synchronized (this.connectionPool) {
      if (this.routeSelector != null)
        if (this.connection.streamCount == 0) {
          Route route = this.connection.getRoute();
          this.routeSelector.connectFailed(route, paramIOException);
        } else {
          this.routeSelector = null;
        }  
      connectionFailed();
      return;
    } 
  }
  
  private void deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield connectionPool : Lcom/squareup/okhttp/ConnectionPool;
    //   4: astore #4
    //   6: aload #4
    //   8: monitorenter
    //   9: iload_3
    //   10: ifeq -> 26
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   18: goto -> 26
    //   21: astore #5
    //   23: goto -> 183
    //   26: iload_2
    //   27: ifeq -> 35
    //   30: aload_0
    //   31: iconst_1
    //   32: putfield released : Z
    //   35: aload_0
    //   36: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   39: ifnull -> 163
    //   42: iload_1
    //   43: ifeq -> 54
    //   46: aload_0
    //   47: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   50: iconst_1
    //   51: putfield noNewStreams : Z
    //   54: aload_0
    //   55: getfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   58: ifnonnull -> 163
    //   61: aload_0
    //   62: getfield released : Z
    //   65: ifne -> 78
    //   68: aload_0
    //   69: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   72: getfield noNewStreams : Z
    //   75: ifeq -> 163
    //   78: aload_0
    //   79: aload_0
    //   80: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   83: invokespecial release : (Lcom/squareup/okhttp/internal/io/RealConnection;)V
    //   86: aload_0
    //   87: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   90: getfield streamCount : I
    //   93: ifle -> 101
    //   96: aload_0
    //   97: aconst_null
    //   98: putfield routeSelector : Lcom/squareup/okhttp/internal/http/RouteSelector;
    //   101: aload_0
    //   102: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   105: getfield allocations : Ljava/util/List;
    //   108: invokeinterface isEmpty : ()Z
    //   113: ifeq -> 152
    //   116: aload_0
    //   117: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   120: invokestatic nanoTime : ()J
    //   123: putfield idleAtNanos : J
    //   126: getstatic com/squareup/okhttp/internal/Internal.instance : Lcom/squareup/okhttp/internal/Internal;
    //   129: aload_0
    //   130: getfield connectionPool : Lcom/squareup/okhttp/ConnectionPool;
    //   133: aload_0
    //   134: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   137: invokevirtual connectionBecameIdle : (Lcom/squareup/okhttp/ConnectionPool;Lcom/squareup/okhttp/internal/io/RealConnection;)Z
    //   140: ifeq -> 152
    //   143: aload_0
    //   144: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   147: astore #5
    //   149: goto -> 155
    //   152: aconst_null
    //   153: astore #5
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   160: goto -> 166
    //   163: aconst_null
    //   164: astore #5
    //   166: aload #4
    //   168: monitorexit
    //   169: aload #5
    //   171: ifnull -> 182
    //   174: aload #5
    //   176: invokevirtual getSocket : ()Ljava/net/Socket;
    //   179: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   182: return
    //   183: aload #4
    //   185: monitorexit
    //   186: aload #5
    //   188: athrow
    // Exception table:
    //   from	to	target	type
    //   13	18	21	finally
    //   30	35	21	finally
    //   35	42	21	finally
    //   46	54	21	finally
    //   54	78	21	finally
    //   78	101	21	finally
    //   101	149	21	finally
    //   155	160	21	finally
    //   166	169	21	finally
    //   183	186	21	finally
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) throws IOException, RouteException {
    synchronized (this.connectionPool) {
      if (!this.released) {
        if (this.stream == null) {
          if (!this.canceled) {
            null = this.connection;
            if (null != null && !null.noNewStreams)
              return null; 
            null = Internal.instance.get(this.connectionPool, this.address, this);
            if (null != null) {
              this.connection = null;
              return null;
            } 
            if (this.routeSelector == null) {
              RouteSelector routeSelector = new RouteSelector();
              this(this.address, routeDatabase());
              this.routeSelector = routeSelector;
            } 
            null = new RealConnection(this.routeSelector.next());
            acquire(null);
            synchronized (this.connectionPool) {
              Internal.instance.put(this.connectionPool, null);
              this.connection = null;
              if (!this.canceled) {
                null.connect(paramInt1, paramInt2, paramInt3, this.address.getConnectionSpecs(), paramBoolean);
                routeDatabase().connected(null.getRoute());
                return null;
              } 
              IOException iOException1 = new IOException();
              this("Canceled");
              throw iOException1;
            } 
          } 
          IOException iOException = new IOException();
          this("Canceled");
          throw iOException;
        } 
        IllegalStateException illegalStateException1 = new IllegalStateException();
        this("stream != null");
        throw illegalStateException1;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      this("released");
      throw illegalStateException;
    } 
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws IOException, RouteException {
    while (true) {
      null = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.connectionPool) {
        if (null.streamCount == 0)
          return null; 
        if (null.isHealthy(paramBoolean2))
          return null; 
        connectionFailed();
      } 
    } 
  }
  
  private boolean isRecoverable(RouteException paramRouteException) {
    IOException iOException = paramRouteException.getLastConnectException();
    return (iOException instanceof java.net.ProtocolException) ? false : ((iOException instanceof java.io.InterruptedIOException) ? (iOException instanceof java.net.SocketTimeoutException) : ((iOException instanceof javax.net.ssl.SSLHandshakeException && iOException.getCause() instanceof java.security.cert.CertificateException) ? false : (!(iOException instanceof javax.net.ssl.SSLPeerUnverifiedException))));
  }
  
  private boolean isRecoverable(IOException paramIOException) {
    return (paramIOException instanceof java.net.ProtocolException) ? false : (!(paramIOException instanceof java.io.InterruptedIOException));
  }
  
  private void release(RealConnection paramRealConnection) {
    int i = paramRealConnection.allocations.size();
    for (byte b = 0; b < i; b++) {
      if (((Reference<StreamAllocation>)paramRealConnection.allocations.get(b)).get() == this) {
        paramRealConnection.allocations.remove(b);
        return;
      } 
    } 
    throw new IllegalStateException();
  }
  
  private RouteDatabase routeDatabase() {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection) {
    paramRealConnection.allocations.add(new WeakReference<StreamAllocation>(this));
  }
  
  public void cancel() {
    synchronized (this.connectionPool) {
      this.canceled = true;
      HttpStream httpStream = this.stream;
      RealConnection realConnection = this.connection;
      if (httpStream != null) {
        httpStream.cancel();
      } else if (realConnection != null) {
        realConnection.cancel();
      } 
      return;
    } 
  }
  
  public RealConnection connection() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connection : Lcom/squareup/okhttp/internal/io/RealConnection;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void connectionFailed() {
    deallocate(true, false, true);
  }
  
  public HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws RouteException, IOException {
    try {
      RealConnection realConnection = findHealthyConnection(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      if (realConnection.framedConnection != null) {
        Http2xStream http2xStream = new Http2xStream();
        this(this, realConnection.framedConnection);
      } else {
        realConnection.getSocket().setSoTimeout(paramInt2);
        realConnection.source.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
        realConnection.sink.timeout().timeout(paramInt3, TimeUnit.MILLISECONDS);
        null = new Http1xStream(this, realConnection.source, realConnection.sink);
      } 
      synchronized (this.connectionPool) {
        realConnection.streamCount++;
        this.stream = null;
        return null;
      } 
    } catch (IOException iOException) {
      throw new RouteException(iOException);
    } 
  }
  
  public void noNewStreams() {
    deallocate(true, false, false);
  }
  
  public boolean recover(RouteException paramRouteException) {
    if (this.connection != null)
      connectionFailed(paramRouteException.getLastConnectException()); 
    RouteSelector routeSelector = this.routeSelector;
    return !((routeSelector != null && !routeSelector.hasNext()) || !isRecoverable(paramRouteException));
  }
  
  public boolean recover(IOException paramIOException, Sink paramSink) {
    boolean bool;
    RealConnection realConnection = this.connection;
    if (realConnection != null) {
      bool = realConnection.streamCount;
      connectionFailed(paramIOException);
      if (bool == true)
        return false; 
    } 
    if (paramSink == null || paramSink instanceof RetryableSink) {
      bool = true;
    } else {
      bool = false;
    } 
    RouteSelector routeSelector = this.routeSelector;
    return !((routeSelector != null && !routeSelector.hasNext()) || !isRecoverable(paramIOException) || !bool);
  }
  
  public void release() {
    deallocate(false, true, false);
  }
  
  public HttpStream stream() {
    synchronized (this.connectionPool) {
      return this.stream;
    } 
  }
  
  public void streamFinished(HttpStream paramHttpStream) {
    // Byte code:
    //   0: aload_0
    //   1: getfield connectionPool : Lcom/squareup/okhttp/ConnectionPool;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull -> 29
    //   11: aload_1
    //   12: aload_0
    //   13: getfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   16: if_acmpne -> 29
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_0
    //   22: iconst_0
    //   23: iconst_0
    //   24: iconst_1
    //   25: invokespecial deallocate : (ZZZ)V
    //   28: return
    //   29: new java/lang/IllegalStateException
    //   32: astore_3
    //   33: new java/lang/StringBuilder
    //   36: astore #4
    //   38: aload #4
    //   40: invokespecial <init> : ()V
    //   43: aload #4
    //   45: ldc_w 'expected '
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload #4
    //   54: aload_0
    //   55: getfield stream : Lcom/squareup/okhttp/internal/http/HttpStream;
    //   58: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload #4
    //   64: ldc_w ' but was '
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #4
    //   73: aload_1
    //   74: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: aload #4
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokespecial <init> : (Ljava/lang/String;)V
    //   87: aload_3
    //   88: athrow
    //   89: astore_1
    //   90: aload_2
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   11	21	89	finally
    //   29	89	89	finally
    //   90	92	89	finally
  }
  
  public String toString() {
    return this.address.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\StreamAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */