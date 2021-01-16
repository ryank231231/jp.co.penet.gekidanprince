package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import java.net.Proxy;

public final class RequestLine {
  static String get(Request paramRequest, Proxy.Type paramType) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramRequest.method());
    stringBuilder.append(' ');
    if (includeAuthorityInRequestLine(paramRequest, paramType)) {
      stringBuilder.append(paramRequest.httpUrl());
    } else {
      stringBuilder.append(requestPath(paramRequest.httpUrl()));
    } 
    stringBuilder.append(" HTTP/1.1");
    return stringBuilder.toString();
  }
  
  private static boolean includeAuthorityInRequestLine(Request paramRequest, Proxy.Type paramType) {
    boolean bool;
    if (!paramRequest.isHttps() && paramType == Proxy.Type.HTTP) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static String requestPath(HttpUrl paramHttpUrl) {
    String str2 = paramHttpUrl.encodedPath();
    String str3 = paramHttpUrl.encodedQuery();
    String str1 = str2;
    if (str3 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append('?');
      stringBuilder.append(str3);
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\RequestLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */