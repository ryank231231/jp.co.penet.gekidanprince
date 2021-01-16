package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Http2xStream implements HttpStream {
  private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
  
  private static final ByteString ENCODING;
  
  private static final ByteString HOST = ByteString.encodeUtf8("host");
  
  private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS;
  
  private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS;
  
  private static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
  
  private static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
  
  private static final List<ByteString> SPDY_3_SKIPPED_REQUEST_HEADERS;
  
  private static final List<ByteString> SPDY_3_SKIPPED_RESPONSE_HEADERS;
  
  private static final ByteString TE;
  
  private static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
  
  private static final ByteString UPGRADE;
  
  private final FramedConnection framedConnection;
  
  private HttpEngine httpEngine;
  
  private FramedStream stream;
  
  private final StreamAllocation streamAllocation;
  
  static {
    TE = ByteString.encodeUtf8("te");
    ENCODING = ByteString.encodeUtf8("encoding");
    UPGRADE = ByteString.encodeUtf8("upgrade");
    SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList((Object[])new ByteString[] { 
          CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, 
          Header.VERSION });
    SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList((Object[])new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING });
    HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((Object[])new ByteString[] { 
          CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, 
          Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION });
    HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((Object[])new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE });
  }
  
  public Http2xStream(StreamAllocation paramStreamAllocation, FramedConnection paramFramedConnection) {
    this.streamAllocation = paramStreamAllocation;
    this.framedConnection = paramFramedConnection;
  }
  
  public static List<Header> http2HeadersList(Request paramRequest) {
    Headers headers = paramRequest.headers();
    ArrayList<Header> arrayList = new ArrayList(headers.size() + 4);
    arrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.httpUrl())));
    arrayList.add(new Header(Header.TARGET_AUTHORITY, Util.hostHeader(paramRequest.httpUrl())));
    arrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.httpUrl().scheme()));
    int i = headers.size();
    for (byte b = 0; b < i; b++) {
      ByteString byteString = ByteString.encodeUtf8(headers.name(b).toLowerCase(Locale.US));
      if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(byteString))
        arrayList.add(new Header(byteString, headers.value(b))); 
    } 
    return arrayList;
  }
  
  private static String joinOnNull(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder(paramString1);
    stringBuilder.append(false);
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  public static Response.Builder readHttp2HeadersList(List<Header> paramList) throws IOException {
    Headers.Builder builder = new Headers.Builder();
    int i = paramList.size();
    String str = null;
    byte b = 0;
    while (b < i) {
      String str2;
      ByteString byteString = ((Header)paramList.get(b)).name;
      String str1 = ((Header)paramList.get(b)).value.utf8();
      if (byteString.equals(Header.RESPONSE_STATUS)) {
        str2 = str1;
      } else {
        str2 = str;
        if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
          builder.add(byteString.utf8(), str1);
          str2 = str;
        } 
      } 
      b++;
      str = str2;
    } 
    if (str != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("HTTP/1.1 ");
      stringBuilder.append(str);
      StatusLine statusLine = StatusLine.parse(stringBuilder.toString());
      return (new Response.Builder()).protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(builder.build());
    } 
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static Response.Builder readSpdy3HeadersList(List<Header> paramList) throws IOException {
    Headers.Builder builder = new Headers.Builder();
    int i = paramList.size();
    String str1 = null;
    String str2 = "HTTP/1.1";
    byte b = 0;
    while (b < i) {
      ByteString byteString = ((Header)paramList.get(b)).name;
      String str3 = ((Header)paramList.get(b)).value.utf8();
      String str4 = str1;
      int j = 0;
      str1 = str2;
      str2 = str4;
      while (j < str3.length()) {
        String str6;
        int k = str3.indexOf(false, j);
        int m = k;
        if (k == -1)
          m = str3.length(); 
        String str5 = str3.substring(j, m);
        if (byteString.equals(Header.RESPONSE_STATUS)) {
          str4 = str5;
          str6 = str1;
        } else if (byteString.equals(Header.VERSION)) {
          str6 = str5;
          str4 = str2;
        } else {
          str4 = str2;
          str6 = str1;
          if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(byteString)) {
            builder.add(byteString.utf8(), str5);
            str6 = str1;
            str4 = str2;
          } 
        } 
        j = m + 1;
        str2 = str4;
        str1 = str6;
      } 
      b++;
      str4 = str1;
      str1 = str2;
      str2 = str4;
    } 
    if (str1 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append(" ");
      stringBuilder.append(str1);
      StatusLine statusLine = StatusLine.parse(stringBuilder.toString());
      return (new Response.Builder()).protocol(Protocol.SPDY_3).code(statusLine.code).message(statusLine.message).headers(builder.build());
    } 
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static List<Header> spdy3HeadersList(Request paramRequest) {
    Headers headers = paramRequest.headers();
    ArrayList<Header> arrayList = new ArrayList(headers.size() + 5);
    arrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.httpUrl())));
    arrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
    arrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(paramRequest.httpUrl())));
    arrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.httpUrl().scheme()));
    LinkedHashSet<ByteString> linkedHashSet = new LinkedHashSet();
    int i = headers.size();
    for (byte b = 0; b < i; b++) {
      ByteString byteString = ByteString.encodeUtf8(headers.name(b).toLowerCase(Locale.US));
      if (!SPDY_3_SKIPPED_REQUEST_HEADERS.contains(byteString)) {
        String str = headers.value(b);
        if (linkedHashSet.add(byteString)) {
          arrayList.add(new Header(byteString, str));
        } else {
          for (byte b1 = 0; b1 < arrayList.size(); b1++) {
            if (((Header)arrayList.get(b1)).name.equals(byteString)) {
              arrayList.set(b1, new Header(byteString, joinOnNull(((Header)arrayList.get(b1)).value.utf8(), str)));
              break;
            } 
          } 
        } 
      } 
    } 
    return arrayList;
  }
  
  public void cancel() {
    FramedStream framedStream = this.stream;
    if (framedStream != null)
      framedStream.closeLater(ErrorCode.CANCEL); 
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong) throws IOException {
    return this.stream.getSink();
  }
  
  public void finishRequest() throws IOException {
    this.stream.getSink().close();
  }
  
  public ResponseBody openResponseBody(Response paramResponse) throws IOException {
    StreamFinishingSource streamFinishingSource = new StreamFinishingSource(this.stream.getSource());
    return new RealResponseBody(paramResponse.headers(), Okio.buffer((Source)streamFinishingSource));
  }
  
  public Response.Builder readResponseHeaders() throws IOException {
    Response.Builder builder;
    if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
      builder = readHttp2HeadersList(this.stream.getResponseHeaders());
    } else {
      builder = readSpdy3HeadersList(this.stream.getResponseHeaders());
    } 
    return builder;
  }
  
  public void setHttpEngine(HttpEngine paramHttpEngine) {
    this.httpEngine = paramHttpEngine;
  }
  
  public void writeRequestBody(RetryableSink paramRetryableSink) throws IOException {
    paramRetryableSink.writeToSocket(this.stream.getSink());
  }
  
  public void writeRequestHeaders(Request paramRequest) throws IOException {
    List<Header> list;
    if (this.stream != null)
      return; 
    this.httpEngine.writingRequestHeaders();
    boolean bool = this.httpEngine.permitsRequestBody(paramRequest);
    if (this.framedConnection.getProtocol() == Protocol.HTTP_2) {
      list = http2HeadersList(paramRequest);
    } else {
      list = spdy3HeadersList((Request)list);
    } 
    this.stream = this.framedConnection.newStream(list, bool, true);
    this.stream.readTimeout().timeout(this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
    this.stream.writeTimeout().timeout(this.httpEngine.client.getWriteTimeout(), TimeUnit.MILLISECONDS);
  }
  
  class StreamFinishingSource extends ForwardingSource {
    public StreamFinishingSource(Source param1Source) {
      super(param1Source);
    }
    
    public void close() throws IOException {
      Http2xStream.this.streamAllocation.streamFinished(Http2xStream.this);
      super.close();
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\Http2xStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */