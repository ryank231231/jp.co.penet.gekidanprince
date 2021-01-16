package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Compressor {
  OutputStream compress(OutputStream paramOutputStream) throws IOException;
  
  String getMessageEncoding();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Compressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */