package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface Sink extends Closeable, Flushable {
  void close() throws IOException;
  
  void flush() throws IOException;
  
  Timeout timeout();
  
  void write(Buffer paramBuffer, long paramLong) throws IOException;
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\Sink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */