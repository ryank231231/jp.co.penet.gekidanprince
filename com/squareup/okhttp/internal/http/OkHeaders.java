package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class OkHeaders {
  private static final Comparator<String> FIELD_NAME_COMPARATOR = new Comparator<String>() {
      public int compare(String param1String1, String param1String2) {
        return (param1String1 == param1String2) ? 0 : ((param1String1 == null) ? -1 : ((param1String2 == null) ? 1 : String.CASE_INSENSITIVE_ORDER.compare(param1String1, param1String2)));
      }
    };
  
  static final String PREFIX = Platform.get().getPrefix();
  
  public static final String RECEIVED_MILLIS;
  
  public static final String RESPONSE_SOURCE;
  
  public static final String SELECTED_PROTOCOL;
  
  public static final String SENT_MILLIS;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(PREFIX);
    stringBuilder.append("-Sent-Millis");
    SENT_MILLIS = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(PREFIX);
    stringBuilder.append("-Received-Millis");
    RECEIVED_MILLIS = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(PREFIX);
    stringBuilder.append("-Selected-Protocol");
    SELECTED_PROTOCOL = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(PREFIX);
    stringBuilder.append("-Response-Source");
    RESPONSE_SOURCE = stringBuilder.toString();
  }
  
  public static void addCookies(Request.Builder paramBuilder, Map<String, List<String>> paramMap) {
    for (Map.Entry<String, List<String>> entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      if (("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List)entry.getValue()).isEmpty())
        paramBuilder.addHeader(str, buildCookieHeader((List<String>)entry.getValue())); 
    } 
  }
  
  private static String buildCookieHeader(List<String> paramList) {
    int i = paramList.size();
    byte b = 0;
    if (i == 1)
      return paramList.get(0); 
    StringBuilder stringBuilder = new StringBuilder();
    i = paramList.size();
    while (b < i) {
      if (b > 0)
        stringBuilder.append("; "); 
      stringBuilder.append(paramList.get(b));
      b++;
    } 
    return stringBuilder.toString();
  }
  
  public static long contentLength(Headers paramHeaders) {
    return stringToLong(paramHeaders.get("Content-Length"));
  }
  
  public static long contentLength(Request paramRequest) {
    return contentLength(paramRequest.headers());
  }
  
  public static long contentLength(Response paramResponse) {
    return contentLength(paramResponse.headers());
  }
  
  public static boolean hasVaryAll(Headers paramHeaders) {
    return varyFields(paramHeaders).contains("*");
  }
  
  public static boolean hasVaryAll(Response paramResponse) {
    return hasVaryAll(paramResponse.headers());
  }
  
  static boolean isEndToEnd(String paramString) {
    boolean bool;
    if (!"Connection".equalsIgnoreCase(paramString) && !"Keep-Alive".equalsIgnoreCase(paramString) && !"Proxy-Authenticate".equalsIgnoreCase(paramString) && !"Proxy-Authorization".equalsIgnoreCase(paramString) && !"TE".equalsIgnoreCase(paramString) && !"Trailers".equalsIgnoreCase(paramString) && !"Transfer-Encoding".equalsIgnoreCase(paramString) && !"Upgrade".equalsIgnoreCase(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static List<Challenge> parseChallenges(Headers paramHeaders, String paramString) {
    ArrayList<Challenge> arrayList = new ArrayList();
    int i = paramHeaders.size();
    for (byte b = 0; b < i; b++) {
      if (paramString.equalsIgnoreCase(paramHeaders.name(b))) {
        String str = paramHeaders.value(b);
        int j = 0;
        while (j < str.length()) {
          int k = HeaderParser.skipUntil(str, j, " ");
          String str1 = str.substring(j, k).trim();
          j = HeaderParser.skipWhitespace(str, k);
          if (!str.regionMatches(true, j, "realm=\"", 0, 7))
            break; 
          k = j + 7;
          j = HeaderParser.skipUntil(str, k, "\"");
          String str2 = str.substring(k, j);
          j = HeaderParser.skipWhitespace(str, HeaderParser.skipUntil(str, j + 1, ",") + 1);
          arrayList.add(new Challenge(str1, str2));
        } 
      } 
    } 
    return arrayList;
  }
  
  public static Request processAuthHeader(Authenticator paramAuthenticator, Response paramResponse, Proxy paramProxy) throws IOException {
    Request request;
    if (paramResponse.code() == 407) {
      request = paramAuthenticator.authenticateProxy(paramProxy, paramResponse);
    } else {
      request = request.authenticate(paramProxy, paramResponse);
    } 
    return request;
  }
  
  private static long stringToLong(String paramString) {
    if (paramString == null)
      return -1L; 
    try {
      return Long.parseLong(paramString);
    } catch (NumberFormatException numberFormatException) {
      return -1L;
    } 
  }
  
  public static Map<String, List<String>> toMultimap(Headers paramHeaders, String paramString) {
    TreeMap<String, Object> treeMap = new TreeMap<String, Object>(FIELD_NAME_COMPARATOR);
    int i = paramHeaders.size();
    for (byte b = 0; b < i; b++) {
      String str1 = paramHeaders.name(b);
      String str2 = paramHeaders.value(b);
      ArrayList<String> arrayList = new ArrayList();
      List list = (List)treeMap.get(str1);
      if (list != null)
        arrayList.addAll(list); 
      arrayList.add(str2);
      treeMap.put(str1, Collections.unmodifiableList(arrayList));
    } 
    if (paramString != null)
      treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString))); 
    return (Map)Collections.unmodifiableMap(treeMap);
  }
  
  public static Set<String> varyFields(Headers paramHeaders) {
    Set<?> set = Collections.emptySet();
    int i = paramHeaders.size();
    for (byte b = 0; b < i; b++) {
      if ("Vary".equalsIgnoreCase(paramHeaders.name(b))) {
        String str = paramHeaders.value(b);
        Set<?> set1 = set;
        if (set.isEmpty())
          set1 = new TreeSet(String.CASE_INSENSITIVE_ORDER); 
        String[] arrayOfString = str.split(",");
        int j = arrayOfString.length;
        byte b1 = 0;
        while (true) {
          set = set1;
          if (b1 < j) {
            set1.add(arrayOfString[b1].trim());
            b1++;
            continue;
          } 
          break;
        } 
      } 
    } 
    return (Set)set;
  }
  
  private static Set<String> varyFields(Response paramResponse) {
    return varyFields(paramResponse.headers());
  }
  
  public static Headers varyHeaders(Headers paramHeaders1, Headers paramHeaders2) {
    Set<String> set = varyFields(paramHeaders2);
    if (set.isEmpty())
      return (new Headers.Builder()).build(); 
    Headers.Builder builder = new Headers.Builder();
    byte b = 0;
    int i = paramHeaders1.size();
    while (b < i) {
      String str = paramHeaders1.name(b);
      if (set.contains(str))
        builder.add(str, paramHeaders1.value(b)); 
      b++;
    } 
    return builder.build();
  }
  
  public static Headers varyHeaders(Response paramResponse) {
    return varyHeaders(paramResponse.networkResponse().request().headers(), paramResponse.headers());
  }
  
  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest) {
    for (String str : varyFields(paramResponse)) {
      if (!Util.equal(paramHeaders.values(str), paramRequest.headers(str)))
        return false; 
    } 
    return true;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\OkHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */