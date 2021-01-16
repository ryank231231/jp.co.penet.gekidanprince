package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
  private int bufferBytesHeldByInflater;
  
  private boolean closed;
  
  private final Inflater inflater;
  
  private final BufferedSource source;
  
  InflaterSource(BufferedSource paramBufferedSource, Inflater paramInflater) {
    if (paramBufferedSource != null) {
      if (paramInflater != null) {
        this.source = paramBufferedSource;
        this.inflater = paramInflater;
        return;
      } 
      throw new IllegalArgumentException("inflater == null");
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public InflaterSource(Source paramSource, Inflater paramInflater) {
    this(Okio.buffer(paramSource), paramInflater);
  }
  
  private void releaseInflatedBytes() throws IOException {
    int i = this.bufferBytesHeldByInflater;
    if (i == 0)
      return; 
    i -= this.inflater.getRemaining();
    this.bufferBytesHeldByInflater -= i;
    this.source.skip(i);
  }
  
  public void close() throws IOException {
    if (this.closed)
      return; 
    this.inflater.end();
    this.closed = true;
    this.source.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong) throws IOException {
    if (paramLong >= 0L) {
      if (!this.closed) {
        if (paramLong == 0L)
          return 0L; 
        while (true) {
          boolean bool = refill();
          try {
            Segment segment = paramBuffer.writableSegment(1);
            int i = this.inflater.inflate(segment.data, segment.limit, 8192 - segment.limit);
            if (i > 0) {
              segment.limit += i;
              long l = paramBuffer.size;
              paramLong = i;
              paramBuffer.size = l + paramLong;
              return paramLong;
            } 
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
              releaseInflatedBytes();
              if (segment.pos == segment.limit) {
                paramBuffer.head = segment.pop();
                SegmentPool.recycle(segment);
              } 
              return -1L;
            } 
            if (!bool)
              continue; 
            EOFException eOFException = new EOFException();
            this("source exhausted prematurely");
            throw eOFException;
          } catch (DataFormatException dataFormatException) {
            throw new IOException(dataFormatException);
          } 
        } 
      } 
      throw new IllegalStateException("closed");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("byteCount < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean refill() throws IOException {
    if (!this.inflater.needsInput())
      return false; 
    releaseInflatedBytes();
    if (this.inflater.getRemaining() == 0) {
      if (this.source.exhausted())
        return true; 
      Segment segment = (this.source.buffer()).head;
      this.bufferBytesHeldByInflater = segment.limit - segment.pos;
      this.inflater.setInput(segment.data, segment.pos, this.bufferBytesHeldByInflater);
      return false;
    } 
    throw new IllegalStateException("?");
  }
  
  public Timeout timeout() {
    return this.source.timeout();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\InflaterSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */