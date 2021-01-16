package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class CacheStrategy {
  public final Response cacheResponse;
  
  public final Request networkRequest;
  
  private CacheStrategy(Request paramRequest, Response paramResponse) {
    this.networkRequest = paramRequest;
    this.cacheResponse = paramResponse;
  }
  
  public static boolean isCacheable(Response paramResponse, Request paramRequest) {
    int i = paramResponse.code();
    boolean bool1 = false;
    switch (i) {
      default:
        return false;
      case 302:
      case 307:
        if (paramResponse.header("Expires") != null || paramResponse.cacheControl().maxAgeSeconds() != -1 || paramResponse.cacheControl().isPublic() || paramResponse.cacheControl().isPrivate())
          break; 
      case 200:
      case 203:
      case 204:
      case 300:
      case 301:
      case 308:
      case 404:
      case 405:
      case 410:
      case 414:
      case 501:
        break;
    } 
    boolean bool2 = bool1;
    if (!paramResponse.cacheControl().noStore()) {
      bool2 = bool1;
      if (!paramRequest.cacheControl().noStore())
        bool2 = true; 
    } 
    return bool2;
  }
  
  public static class Factory {
    private int ageSeconds = -1;
    
    final Response cacheResponse;
    
    private String etag;
    
    private Date expires;
    
    private Date lastModified;
    
    private String lastModifiedString;
    
    final long nowMillis;
    
    private long receivedResponseMillis;
    
    final Request request;
    
    private long sentRequestMillis;
    
    private Date servedDate;
    
    private String servedDateString;
    
    public Factory(long param1Long, Request param1Request, Response param1Response) {
      this.nowMillis = param1Long;
      this.request = param1Request;
      this.cacheResponse = param1Response;
      if (param1Response != null) {
        Headers headers = param1Response.headers();
        byte b = 0;
        int i = headers.size();
        while (b < i) {
          String str2 = headers.name(b);
          String str1 = headers.value(b);
          if ("Date".equalsIgnoreCase(str2)) {
            this.servedDate = HttpDate.parse(str1);
            this.servedDateString = str1;
          } else if ("Expires".equalsIgnoreCase(str2)) {
            this.expires = HttpDate.parse(str1);
          } else if ("Last-Modified".equalsIgnoreCase(str2)) {
            this.lastModified = HttpDate.parse(str1);
            this.lastModifiedString = str1;
          } else if ("ETag".equalsIgnoreCase(str2)) {
            this.etag = str1;
          } else if ("Age".equalsIgnoreCase(str2)) {
            this.ageSeconds = HeaderParser.parseSeconds(str1, -1);
          } else if (OkHeaders.SENT_MILLIS.equalsIgnoreCase(str2)) {
            this.sentRequestMillis = Long.parseLong(str1);
          } else if (OkHeaders.RECEIVED_MILLIS.equalsIgnoreCase(str2)) {
            this.receivedResponseMillis = Long.parseLong(str1);
          } 
          b++;
        } 
      } 
    }
    
    private long cacheResponseAge() {
      Date date = this.servedDate;
      long l1 = 0L;
      if (date != null)
        l1 = Math.max(0L, this.receivedResponseMillis - date.getTime()); 
      long l2 = l1;
      if (this.ageSeconds != -1)
        l2 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.ageSeconds)); 
      l1 = this.receivedResponseMillis;
      return l2 + l1 - this.sentRequestMillis + this.nowMillis - l1;
    }
    
    private long computeFreshnessLifetime() {
      CacheControl cacheControl = this.cacheResponse.cacheControl();
      if (cacheControl.maxAgeSeconds() != -1)
        return TimeUnit.SECONDS.toMillis(cacheControl.maxAgeSeconds()); 
      Date date = this.expires;
      long l = 0L;
      if (date != null) {
        date = this.servedDate;
        if (date != null) {
          l1 = date.getTime();
        } else {
          l1 = this.receivedResponseMillis;
        } 
        long l1 = this.expires.getTime() - l1;
        if (l1 > 0L)
          l = l1; 
        return l;
      } 
      if (this.lastModified != null && this.cacheResponse.request().httpUrl().query() == null) {
        long l1;
        date = this.servedDate;
        if (date != null) {
          l1 = date.getTime();
        } else {
          l1 = this.sentRequestMillis;
        } 
        l1 -= this.lastModified.getTime();
        if (l1 > 0L)
          l = l1 / 10L; 
        return l;
      } 
      return 0L;
    }
    
    private CacheStrategy getCandidate() {
      long l5;
      CacheStrategy cacheStrategy;
      if (this.cacheResponse == null)
        return new CacheStrategy(this.request, null); 
      if (this.request.isHttps() && this.cacheResponse.handshake() == null)
        return new CacheStrategy(this.request, null); 
      if (!CacheStrategy.isCacheable(this.cacheResponse, this.request))
        return new CacheStrategy(this.request, null); 
      CacheControl cacheControl1 = this.request.cacheControl();
      if (cacheControl1.noCache() || hasConditions(this.request))
        return new CacheStrategy(this.request, null); 
      long l1 = cacheResponseAge();
      long l2 = computeFreshnessLifetime();
      long l3 = l2;
      if (cacheControl1.maxAgeSeconds() != -1)
        l3 = Math.min(l2, TimeUnit.SECONDS.toMillis(cacheControl1.maxAgeSeconds())); 
      int i = cacheControl1.minFreshSeconds();
      long l4 = 0L;
      if (i != -1) {
        l5 = TimeUnit.SECONDS.toMillis(cacheControl1.minFreshSeconds());
      } else {
        l5 = 0L;
      } 
      CacheControl cacheControl2 = this.cacheResponse.cacheControl();
      l2 = l4;
      if (!cacheControl2.mustRevalidate()) {
        l2 = l4;
        if (cacheControl1.maxStaleSeconds() != -1)
          l2 = TimeUnit.SECONDS.toMillis(cacheControl1.maxStaleSeconds()); 
      } 
      if (!cacheControl2.noCache()) {
        l5 += l1;
        if (l5 < l2 + l3) {
          Response.Builder builder1 = this.cacheResponse.newBuilder();
          if (l5 >= l3)
            builder1.addHeader("Warning", "110 HttpURLConnection \"Response is stale\""); 
          if (l1 > 86400000L && isFreshnessLifetimeHeuristic())
            builder1.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\""); 
          return new CacheStrategy(null, builder1.build());
        } 
      } 
      Request.Builder builder = this.request.newBuilder();
      String str = this.etag;
      if (str != null) {
        builder.header("If-None-Match", str);
      } else if (this.lastModified != null) {
        builder.header("If-Modified-Since", this.lastModifiedString);
      } else if (this.servedDate != null) {
        builder.header("If-Modified-Since", this.servedDateString);
      } 
      Request request = builder.build();
      if (hasConditions(request)) {
        cacheStrategy = new CacheStrategy(request, this.cacheResponse);
      } else {
        cacheStrategy = new CacheStrategy((Request)cacheStrategy, null);
      } 
      return cacheStrategy;
    }
    
    private static boolean hasConditions(Request param1Request) {
      return (param1Request.header("If-Modified-Since") != null || param1Request.header("If-None-Match") != null);
    }
    
    private boolean isFreshnessLifetimeHeuristic() {
      boolean bool;
      if (this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public CacheStrategy get() {
      CacheStrategy cacheStrategy = getCandidate();
      return (cacheStrategy.networkRequest != null && this.request.cacheControl().onlyIfCached()) ? new CacheStrategy(null, null) : cacheStrategy;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\CacheStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */