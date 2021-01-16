package io.grpc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Codec extends Compressor, Decompressor {
  public static final class Gzip implements Codec {
    public OutputStream compress(OutputStream param1OutputStream) throws IOException {
      return new GZIPOutputStream(param1OutputStream);
    }
    
    public InputStream decompress(InputStream param1InputStream) throws IOException {
      return new GZIPInputStream(param1InputStream);
    }
    
    public String getMessageEncoding() {
      return "gzip";
    }
  }
  
  public static final class Identity implements Codec {
    public static final Codec NONE = new Identity();
    
    public OutputStream compress(OutputStream param1OutputStream) throws IOException {
      return param1OutputStream;
    }
    
    public InputStream decompress(InputStream param1InputStream) throws IOException {
      return param1InputStream;
    }
    
    public String getMessageEncoding() {
      return "identity";
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Codec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */