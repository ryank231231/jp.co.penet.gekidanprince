package com.squareup.okhttp.internal.framed;

public enum ErrorCode {
  CANCEL,
  COMPRESSION_ERROR,
  CONNECT_ERROR,
  ENHANCE_YOUR_CALM,
  FLOW_CONTROL_ERROR,
  FRAME_TOO_LARGE,
  HTTP_1_1_REQUIRED,
  INADEQUATE_SECURITY,
  INTERNAL_ERROR,
  INVALID_CREDENTIALS,
  INVALID_STREAM,
  NO_ERROR(0, -1, 0),
  PROTOCOL_ERROR(1, 1, 1),
  REFUSED_STREAM(1, 1, 1),
  STREAM_ALREADY_CLOSED(1, 1, 1),
  STREAM_CLOSED(1, 1, 1),
  STREAM_IN_USE(1, 1, 1),
  UNSUPPORTED_VERSION(1, 1, 1);
  
  public final int httpCode;
  
  public final int spdyGoAwayCode;
  
  public final int spdyRstCode;
  
  static {
    INVALID_STREAM = new ErrorCode("INVALID_STREAM", 2, 1, 2, -1);
    UNSUPPORTED_VERSION = new ErrorCode("UNSUPPORTED_VERSION", 3, 1, 4, -1);
    STREAM_IN_USE = new ErrorCode("STREAM_IN_USE", 4, 1, 8, -1);
    STREAM_ALREADY_CLOSED = new ErrorCode("STREAM_ALREADY_CLOSED", 5, 1, 9, -1);
    INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 6, 2, 6, 2);
    FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 7, 3, 7, -1);
    STREAM_CLOSED = new ErrorCode("STREAM_CLOSED", 8, 5, -1, -1);
    FRAME_TOO_LARGE = new ErrorCode("FRAME_TOO_LARGE", 9, 6, 11, -1);
    REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 10, 7, 3, -1);
    CANCEL = new ErrorCode("CANCEL", 11, 8, 5, -1);
    COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 12, 9, -1, -1);
    CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 13, 10, -1, -1);
    ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 14, 11, -1, -1);
    INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 15, 12, -1, -1);
    HTTP_1_1_REQUIRED = new ErrorCode("HTTP_1_1_REQUIRED", 16, 13, -1, -1);
    INVALID_CREDENTIALS = new ErrorCode("INVALID_CREDENTIALS", 17, -1, 10, -1);
    $VALUES = new ErrorCode[] { 
        NO_ERROR, PROTOCOL_ERROR, INVALID_STREAM, UNSUPPORTED_VERSION, STREAM_IN_USE, STREAM_ALREADY_CLOSED, INTERNAL_ERROR, FLOW_CONTROL_ERROR, STREAM_CLOSED, FRAME_TOO_LARGE, 
        REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, HTTP_1_1_REQUIRED, INVALID_CREDENTIALS };
  }
  
  ErrorCode(int paramInt1, int paramInt2, int paramInt3) {
    this.httpCode = paramInt1;
    this.spdyRstCode = paramInt2;
    this.spdyGoAwayCode = paramInt3;
  }
  
  public static ErrorCode fromHttp2(int paramInt) {
    for (ErrorCode errorCode : values()) {
      if (errorCode.httpCode == paramInt)
        return errorCode; 
    } 
    return null;
  }
  
  public static ErrorCode fromSpdy3Rst(int paramInt) {
    for (ErrorCode errorCode : values()) {
      if (errorCode.spdyRstCode == paramInt)
        return errorCode; 
    } 
    return null;
  }
  
  public static ErrorCode fromSpdyGoAway(int paramInt) {
    for (ErrorCode errorCode : values()) {
      if (errorCode.spdyGoAwayCode == paramInt)
        return errorCode; 
    } 
    return null;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\internal\framed\ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */