package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.ProtocolException;

public final class StatusLine {
  public static final int HTTP_CONTINUE = 100;
  
  public static final int HTTP_PERM_REDIRECT = 308;
  
  public static final int HTTP_TEMP_REDIRECT = 307;
  
  public final int code;
  
  public final String message;
  
  public final Protocol protocol;
  
  public StatusLine(Protocol paramProtocol, int paramInt, String paramString) {
    this.protocol = paramProtocol;
    this.code = paramInt;
    this.message = paramString;
  }
  
  public static StatusLine get(Response paramResponse) {
    return new StatusLine(paramResponse.protocol(), paramResponse.code(), paramResponse.message());
  }
  
  public static StatusLine parse(String paramString) throws IOException {
    boolean bool = paramString.startsWith("HTTP/1.");
    byte b = 9;
    if (bool) {
      if (paramString.length() >= 9 && paramString.charAt(8) == ' ') {
        int k = paramString.charAt(7) - 48;
        if (k == 0) {
          Protocol protocol = Protocol.HTTP_1_0;
        } else if (k == 1) {
          Protocol protocol = Protocol.HTTP_1_1;
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unexpected status line: ");
          stringBuilder1.append(paramString);
          throw new ProtocolException(stringBuilder1.toString());
        } 
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected status line: ");
        stringBuilder1.append(paramString);
        throw new ProtocolException(stringBuilder1.toString());
      } 
    } else if (paramString.startsWith("ICY ")) {
      Protocol protocol = Protocol.HTTP_1_0;
      b = 4;
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Unexpected status line: ");
      stringBuilder1.append(paramString);
      throw new ProtocolException(stringBuilder1.toString());
    } 
    int j = paramString.length();
    int i = b + 3;
    if (j >= i)
      try {
        StringBuilder stringBuilder1;
        j = Integer.parseInt(paramString.substring(b, i));
        String str = "";
        if (paramString.length() > i)
          if (paramString.charAt(i) == ' ') {
            str = paramString.substring(b + 4);
          } else {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Unexpected status line: ");
            stringBuilder1.append(paramString);
            throw new ProtocolException(stringBuilder1.toString());
          }  
        return new StatusLine((Protocol)stringBuilder1, j, str);
      } catch (NumberFormatException numberFormatException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unexpected status line: ");
        stringBuilder1.append(paramString);
        throw new ProtocolException(stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unexpected status line: ");
    stringBuilder.append(paramString);
    throw new ProtocolException(stringBuilder.toString());
  }
  
  public String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.protocol == Protocol.HTTP_1_0) {
      str = "HTTP/1.0";
    } else {
      str = "HTTP/1.1";
    } 
    stringBuilder.append(str);
    stringBuilder.append(' ');
    stringBuilder.append(this.code);
    if (this.message != null) {
      stringBuilder.append(' ');
      stringBuilder.append(this.message);
    } 
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\http\StatusLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */