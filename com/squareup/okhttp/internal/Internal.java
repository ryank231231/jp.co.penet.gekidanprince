package com.squareup.okhttp.internal;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public abstract class Internal {
  public static Internal instance;
  
  public static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
  
  public static void initializeInstanceForTests() {
    new OkHttpClient();
  }
  
  public abstract void addLenient(Headers.Builder paramBuilder, String paramString);
  
  public abstract void addLenient(Headers.Builder paramBuilder, String paramString1, String paramString2);
  
  public abstract void apply(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract StreamAllocation callEngineGetStreamAllocation(Call paramCall);
  
  public abstract void callEnqueue(Call paramCall, Callback paramCallback, boolean paramBoolean);
  
  public abstract boolean connectionBecameIdle(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract RealConnection get(ConnectionPool paramConnectionPool, Address paramAddress, StreamAllocation paramStreamAllocation);
  
  public abstract HttpUrl getHttpUrlChecked(String paramString) throws MalformedURLException, UnknownHostException;
  
  public abstract InternalCache internalCache(OkHttpClient paramOkHttpClient);
  
  public abstract void put(ConnectionPool paramConnectionPool, RealConnection paramRealConnection);
  
  public abstract RouteDatabase routeDatabase(ConnectionPool paramConnectionPool);
  
  public abstract void setCache(OkHttpClient paramOkHttpClient, InternalCache paramInternalCache);
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */