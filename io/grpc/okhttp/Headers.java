package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

class Headers {
  public static final Header CONTENT_TYPE_HEADER;
  
  public static final Header METHOD_GET_HEADER;
  
  public static final Header METHOD_HEADER;
  
  public static final Header SCHEME_HEADER = new Header(Header.TARGET_SCHEME, "https");
  
  public static final Header TE_HEADER;
  
  static {
    METHOD_HEADER = new Header(Header.TARGET_METHOD, "POST");
    METHOD_GET_HEADER = new Header(Header.TARGET_METHOD, "GET");
    CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), "application/grpc");
    TE_HEADER = new Header("te", "trailers");
  }
  
  public static List<Header> createRequestHeaders(Metadata paramMetadata, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    Preconditions.checkNotNull(paramMetadata, "headers");
    Preconditions.checkNotNull(paramString1, "defaultPath");
    Preconditions.checkNotNull(paramString2, "authority");
    paramMetadata.discardAll(GrpcUtil.CONTENT_TYPE_KEY);
    paramMetadata.discardAll(GrpcUtil.TE_HEADER);
    paramMetadata.discardAll(GrpcUtil.USER_AGENT_KEY);
    ArrayList<Header> arrayList = new ArrayList(InternalMetadata.headerCount(paramMetadata) + 7);
    arrayList.add(SCHEME_HEADER);
    if (paramBoolean) {
      arrayList.add(METHOD_GET_HEADER);
    } else {
      arrayList.add(METHOD_HEADER);
    } 
    arrayList.add(new Header(Header.TARGET_AUTHORITY, paramString2));
    arrayList.add(new Header(Header.TARGET_PATH, paramString1));
    arrayList.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), paramString3));
    arrayList.add(CONTENT_TYPE_HEADER);
    arrayList.add(TE_HEADER);
    byte[][] arrayOfByte = TransportFrameUtil.toHttp2Headers(paramMetadata);
    for (byte b = 0; b < arrayOfByte.length; b += 2) {
      ByteString byteString = ByteString.of(arrayOfByte[b]);
      if (isApplicationHeader(byteString.utf8()))
        arrayList.add(new Header(byteString, ByteString.of(arrayOfByte[b + 1]))); 
    } 
    return arrayList;
  }
  
  private static boolean isApplicationHeader(String paramString) {
    boolean bool;
    if (!paramString.startsWith(":") && !GrpcUtil.CONTENT_TYPE_KEY.name().equalsIgnoreCase(paramString) && !GrpcUtil.USER_AGENT_KEY.name().equalsIgnoreCase(paramString)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */