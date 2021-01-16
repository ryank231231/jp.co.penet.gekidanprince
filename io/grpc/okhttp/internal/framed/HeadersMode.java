package io.grpc.okhttp.internal.framed;

public enum HeadersMode {
  HTTP_20_HEADERS, SPDY_HEADERS, SPDY_REPLY, SPDY_SYN_STREAM;
  
  static {
    SPDY_REPLY = new HeadersMode("SPDY_REPLY", 1);
    SPDY_HEADERS = new HeadersMode("SPDY_HEADERS", 2);
    HTTP_20_HEADERS = new HeadersMode("HTTP_20_HEADERS", 3);
    $VALUES = new HeadersMode[] { SPDY_SYN_STREAM, SPDY_REPLY, SPDY_HEADERS, HTTP_20_HEADERS };
  }
  
  public boolean failIfHeadersAbsent() {
    boolean bool;
    if (this == SPDY_HEADERS) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean failIfHeadersPresent() {
    boolean bool;
    if (this == SPDY_REPLY) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean failIfStreamAbsent() {
    return (this == SPDY_REPLY || this == SPDY_HEADERS);
  }
  
  public boolean failIfStreamPresent() {
    boolean bool;
    if (this == SPDY_SYN_STREAM) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\internal\framed\HeadersMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */