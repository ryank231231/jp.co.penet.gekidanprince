package io.grpc;

import java.io.IOException;
import java.io.InputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Decompressor {
  InputStream decompress(InputStream paramInputStream) throws IOException;
  
  String getMessageEncoding();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Decompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */