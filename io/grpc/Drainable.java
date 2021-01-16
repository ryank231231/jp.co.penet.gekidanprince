package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

public interface Drainable {
  int drainTo(OutputStream paramOutputStream) throws IOException;
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Drainable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */