package io.grpc;

import java.nio.charset.Charset;

@Internal
public final class InternalMetadata {
  @Internal
  public static final Charset US_ASCII = Charset.forName("US-ASCII");
  
  @Internal
  public static int headerCount(Metadata paramMetadata) {
    return paramMetadata.headerCount();
  }
  
  @Internal
  public static <T> Metadata.Key<T> keyOf(String paramString, TrustedAsciiMarshaller<T> paramTrustedAsciiMarshaller) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      bool2 = bool1;
      if (!paramString.isEmpty()) {
        bool2 = bool1;
        if (paramString.charAt(0) == ':')
          bool2 = true; 
      } 
    } 
    return Metadata.Key.of(paramString, bool2, paramTrustedAsciiMarshaller);
  }
  
  @Internal
  public static <T> Metadata.Key<T> keyOf(String paramString, Metadata.AsciiMarshaller<T> paramAsciiMarshaller) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString != null) {
      bool2 = bool1;
      if (!paramString.isEmpty()) {
        bool2 = bool1;
        if (paramString.charAt(0) == ':')
          bool2 = true; 
      } 
    } 
    return Metadata.Key.of(paramString, bool2, paramAsciiMarshaller);
  }
  
  @Internal
  public static Metadata newMetadata(int paramInt, byte[]... paramVarArgs) {
    return new Metadata(paramInt, paramVarArgs);
  }
  
  @Internal
  public static Metadata newMetadata(byte[]... paramVarArgs) {
    return new Metadata(paramVarArgs);
  }
  
  @Internal
  public static byte[][] serialize(Metadata paramMetadata) {
    return paramMetadata.serialize();
  }
  
  @Internal
  public static interface TrustedAsciiMarshaller<T> extends Metadata.TrustedAsciiMarshaller<T> {}
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\InternalMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */