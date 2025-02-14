package com.squareup.okhttp.internal.http;

public final class HttpMethod {
  public static boolean invalidatesCache(String paramString) {
    return (paramString.equals("POST") || paramString.equals("PATCH") || paramString.equals("PUT") || paramString.equals("DELETE") || paramString.equals("MOVE"));
  }
  
  public static boolean permitsRequestBody(String paramString) {
    return (requiresRequestBody(paramString) || paramString.equals("OPTIONS") || paramString.equals("DELETE") || paramString.equals("PROPFIND") || paramString.equals("MKCOL") || paramString.equals("LOCK"));
  }
  
  public static boolean redirectsToGet(String paramString) {
    return paramString.equals("PROPFIND") ^ true;
  }
  
  public static boolean requiresRequestBody(String paramString) {
    return (paramString.equals("POST") || paramString.equals("PUT") || paramString.equals("PATCH") || paramString.equals("PROPPATCH") || paramString.equals("REPORT"));
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\HttpMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */