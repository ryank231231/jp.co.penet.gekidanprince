package okio;

import java.io.Closeable;
import java.io.IOException;

public interface Source extends Closeable {
  void close() throws IOException;
  
  long read(Buffer paramBuffer, long paramLong) throws IOException;
  
  Timeout timeout();
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\Source.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */