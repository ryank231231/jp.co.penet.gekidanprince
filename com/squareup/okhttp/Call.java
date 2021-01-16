package com.squareup.okhttp;

import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import java.io.IOException;
import java.net.ProtocolException;

public class Call {
  volatile boolean canceled;
  
  private final OkHttpClient client;
  
  HttpEngine engine;
  
  private boolean executed;
  
  Request originalRequest;
  
  protected Call(OkHttpClient paramOkHttpClient, Request paramRequest) {
    this.client = paramOkHttpClient.copyWithDefaults();
    this.originalRequest = paramRequest;
  }
  
  private Response getResponseWithInterceptorChain(boolean paramBoolean) throws IOException {
    return (new ApplicationInterceptorChain(0, this.originalRequest, paramBoolean)).proceed(this.originalRequest);
  }
  
  private String toLoggableString() {
    String str;
    if (this.canceled) {
      str = "canceled call";
    } else {
      str = "call";
    } 
    HttpUrl httpUrl = this.originalRequest.httpUrl().resolve("/...");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(" to ");
    stringBuilder.append(httpUrl);
    return stringBuilder.toString();
  }
  
  public void cancel() {
    this.canceled = true;
    HttpEngine httpEngine = this.engine;
    if (httpEngine != null)
      httpEngine.cancel(); 
  }
  
  public void enqueue(Callback paramCallback) {
    enqueue(paramCallback, false);
  }
  
  void enqueue(Callback paramCallback, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifne -> 38
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield executed : Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   20: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   23: new com/squareup/okhttp/Call$AsyncCall
    //   26: dup
    //   27: aload_0
    //   28: aload_1
    //   29: iload_2
    //   30: aconst_null
    //   31: invokespecial <init> : (Lcom/squareup/okhttp/Call;Lcom/squareup/okhttp/Callback;ZLcom/squareup/okhttp/Call$1;)V
    //   34: invokevirtual enqueue : (Lcom/squareup/okhttp/Call$AsyncCall;)V
    //   37: return
    //   38: new java/lang/IllegalStateException
    //   41: astore_1
    //   42: aload_1
    //   43: ldc 'Already Executed'
    //   45: invokespecial <init> : (Ljava/lang/String;)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	50	finally
    //   38	50	50	finally
    //   51	53	50	finally
  }
  
  public Response execute() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: ifne -> 76
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield executed : Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   20: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   23: aload_0
    //   24: invokevirtual executed : (Lcom/squareup/okhttp/Call;)V
    //   27: aload_0
    //   28: iconst_0
    //   29: invokespecial getResponseWithInterceptorChain : (Z)Lcom/squareup/okhttp/Response;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull -> 50
    //   37: aload_0
    //   38: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   41: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   44: aload_0
    //   45: invokevirtual finished : (Lcom/squareup/okhttp/Call;)V
    //   48: aload_1
    //   49: areturn
    //   50: new java/io/IOException
    //   53: astore_1
    //   54: aload_1
    //   55: ldc 'Canceled'
    //   57: invokespecial <init> : (Ljava/lang/String;)V
    //   60: aload_1
    //   61: athrow
    //   62: astore_1
    //   63: aload_0
    //   64: getfield client : Lcom/squareup/okhttp/OkHttpClient;
    //   67: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
    //   70: aload_0
    //   71: invokevirtual finished : (Lcom/squareup/okhttp/Call;)V
    //   74: aload_1
    //   75: athrow
    //   76: new java/lang/IllegalStateException
    //   79: astore_1
    //   80: aload_1
    //   81: ldc 'Already Executed'
    //   83: invokespecial <init> : (Ljava/lang/String;)V
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	88	finally
    //   16	33	62	finally
    //   50	62	62	finally
    //   76	88	88	finally
    //   89	91	88	finally
  }
  
  Response getResponse(Request paramRequest, boolean paramBoolean) throws IOException {
    Request request;
    RequestBody requestBody = paramRequest.body();
    if (requestBody != null) {
      Request.Builder builder = paramRequest.newBuilder();
      MediaType mediaType = requestBody.contentType();
      if (mediaType != null)
        builder.header("Content-Type", mediaType.toString()); 
      long l = requestBody.contentLength();
      if (l != -1L) {
        builder.header("Content-Length", Long.toString(l));
        builder.removeHeader("Transfer-Encoding");
      } else {
        builder.header("Transfer-Encoding", "chunked");
        builder.removeHeader("Content-Length");
      } 
      request = builder.build();
    } 
    this.engine = new HttpEngine(this.client, request, false, false, paramBoolean, null, null, null);
    byte b = 0;
    while (!this.canceled) {
      boolean bool = true;
      try {
        this.engine.sendRequest();
        this.engine.readResponse();
        Response response = this.engine.getResponse();
        Request request1 = this.engine.followUpRequest();
        if (request1 == null)
          return response; 
        StreamAllocation streamAllocation = this.engine.close();
        if (++b <= 20) {
          if (!this.engine.sameConnection(request1.httpUrl())) {
            streamAllocation.release();
            streamAllocation = null;
          } 
          this.engine = new HttpEngine(this.client, request1, false, false, paramBoolean, streamAllocation, null, response);
          continue;
        } 
        streamAllocation.release();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Too many follow-up requests: ");
        stringBuilder.append(b);
        throw new ProtocolException(stringBuilder.toString());
      } catch (RequestException requestException) {
        throw requestException.getCause();
      } catch (RouteException routeException) {
        HttpEngine httpEngine = this.engine.recover(routeException);
        if (httpEngine != null) {
          this.engine = httpEngine;
          continue;
        } 
        throw routeException.getLastConnectException();
      } catch (IOException iOException) {
        HttpEngine httpEngine = this.engine.recover(iOException, null);
      } finally {
        request = null;
      } 
      if (b != 0)
        this.engine.close().release(); 
      throw request;
    } 
    this.engine.releaseStreamAllocation();
    throw new IOException("Canceled");
  }
  
  public boolean isCanceled() {
    return this.canceled;
  }
  
  public boolean isExecuted() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executed : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  Object tag() {
    return this.originalRequest.tag();
  }
  
  class ApplicationInterceptorChain implements Interceptor.Chain {
    private final boolean forWebSocket;
    
    private final int index;
    
    private final Request request;
    
    ApplicationInterceptorChain(int param1Int, Request param1Request, boolean param1Boolean) {
      this.index = param1Int;
      this.request = param1Request;
      this.forWebSocket = param1Boolean;
    }
    
    public Connection connection() {
      return null;
    }
    
    public Response proceed(Request param1Request) throws IOException {
      Interceptor interceptor;
      if (this.index < Call.this.client.interceptors().size()) {
        ApplicationInterceptorChain applicationInterceptorChain = new ApplicationInterceptorChain(this.index + 1, param1Request, this.forWebSocket);
        interceptor = Call.this.client.interceptors().get(this.index);
        Response response = interceptor.intercept(applicationInterceptorChain);
        if (response != null)
          return response; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("application interceptor ");
        stringBuilder.append(interceptor);
        stringBuilder.append(" returned null");
        throw new NullPointerException(stringBuilder.toString());
      } 
      return Call.this.getResponse((Request)interceptor, this.forWebSocket);
    }
    
    public Request request() {
      return this.request;
    }
  }
  
  final class AsyncCall extends NamedRunnable {
    private final boolean forWebSocket;
    
    private final Callback responseCallback;
    
    private AsyncCall(Callback param1Callback, boolean param1Boolean) {
      super("OkHttp %s", new Object[] { this$0.originalRequest.urlString() });
      this.responseCallback = param1Callback;
      this.forWebSocket = param1Boolean;
    }
    
    void cancel() {
      Call.this.cancel();
    }
    
    protected void execute() {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   6: aload_0
      //   7: getfield forWebSocket : Z
      //   10: invokestatic access$100 : (Lcom/squareup/okhttp/Call;Z)Lcom/squareup/okhttp/Response;
      //   13: astore_2
      //   14: aload_0
      //   15: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   18: getfield canceled : Z
      //   21: istore_3
      //   22: iload_3
      //   23: ifeq -> 65
      //   26: aload_0
      //   27: getfield responseCallback : Lcom/squareup/okhttp/Callback;
      //   30: astore_2
      //   31: aload_0
      //   32: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   35: getfield originalRequest : Lcom/squareup/okhttp/Request;
      //   38: astore #4
      //   40: new java/io/IOException
      //   43: astore #5
      //   45: aload #5
      //   47: ldc 'Canceled'
      //   49: invokespecial <init> : (Ljava/lang/String;)V
      //   52: aload_2
      //   53: aload #4
      //   55: aload #5
      //   57: invokeinterface onFailure : (Lcom/squareup/okhttp/Request;Ljava/io/IOException;)V
      //   62: goto -> 75
      //   65: aload_0
      //   66: getfield responseCallback : Lcom/squareup/okhttp/Callback;
      //   69: aload_2
      //   70: invokeinterface onResponse : (Lcom/squareup/okhttp/Response;)V
      //   75: aload_0
      //   76: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   79: invokestatic access$300 : (Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   82: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
      //   85: aload_0
      //   86: invokevirtual finished : (Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   89: goto -> 213
      //   92: astore_2
      //   93: goto -> 103
      //   96: astore_2
      //   97: goto -> 214
      //   100: astore_2
      //   101: iconst_0
      //   102: istore_1
      //   103: iload_1
      //   104: ifeq -> 164
      //   107: getstatic com/squareup/okhttp/internal/Internal.logger : Ljava/util/logging/Logger;
      //   110: astore #4
      //   112: getstatic java/util/logging/Level.INFO : Ljava/util/logging/Level;
      //   115: astore #5
      //   117: new java/lang/StringBuilder
      //   120: astore #6
      //   122: aload #6
      //   124: invokespecial <init> : ()V
      //   127: aload #6
      //   129: ldc 'Callback failure for '
      //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   134: pop
      //   135: aload #6
      //   137: aload_0
      //   138: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   141: invokestatic access$200 : (Lcom/squareup/okhttp/Call;)Ljava/lang/String;
      //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: pop
      //   148: aload #4
      //   150: aload #5
      //   152: aload #6
      //   154: invokevirtual toString : ()Ljava/lang/String;
      //   157: aload_2
      //   158: invokevirtual log : (Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   161: goto -> 75
      //   164: aload_0
      //   165: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   168: getfield engine : Lcom/squareup/okhttp/internal/http/HttpEngine;
      //   171: ifnonnull -> 186
      //   174: aload_0
      //   175: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   178: getfield originalRequest : Lcom/squareup/okhttp/Request;
      //   181: astore #4
      //   183: goto -> 198
      //   186: aload_0
      //   187: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   190: getfield engine : Lcom/squareup/okhttp/internal/http/HttpEngine;
      //   193: invokevirtual getRequest : ()Lcom/squareup/okhttp/Request;
      //   196: astore #4
      //   198: aload_0
      //   199: getfield responseCallback : Lcom/squareup/okhttp/Callback;
      //   202: aload #4
      //   204: aload_2
      //   205: invokeinterface onFailure : (Lcom/squareup/okhttp/Request;Ljava/io/IOException;)V
      //   210: goto -> 75
      //   213: return
      //   214: aload_0
      //   215: getfield this$0 : Lcom/squareup/okhttp/Call;
      //   218: invokestatic access$300 : (Lcom/squareup/okhttp/Call;)Lcom/squareup/okhttp/OkHttpClient;
      //   221: invokevirtual getDispatcher : ()Lcom/squareup/okhttp/Dispatcher;
      //   224: aload_0
      //   225: invokevirtual finished : (Lcom/squareup/okhttp/Call$AsyncCall;)V
      //   228: aload_2
      //   229: athrow
      // Exception table:
      //   from	to	target	type
      //   2	22	100	java/io/IOException
      //   2	22	96	finally
      //   26	62	92	java/io/IOException
      //   26	62	96	finally
      //   65	75	92	java/io/IOException
      //   65	75	96	finally
      //   107	161	96	finally
      //   164	183	96	finally
      //   186	198	96	finally
      //   198	210	96	finally
    }
    
    Call get() {
      return Call.this;
    }
    
    String host() {
      return Call.this.originalRequest.httpUrl().host();
    }
    
    Request request() {
      return Call.this.originalRequest;
    }
    
    Object tag() {
      return Call.this.originalRequest.tag();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */