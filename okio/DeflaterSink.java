package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

public final class DeflaterSink implements Sink {
  private boolean closed;
  
  private final Deflater deflater;
  
  private final BufferedSink sink;
  
  DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater) {
    if (paramBufferedSink != null) {
      if (paramDeflater != null) {
        this.sink = paramBufferedSink;
        this.deflater = paramDeflater;
        return;
      } 
      throw new IllegalArgumentException("inflater == null");
    } 
    throw new IllegalArgumentException("source == null");
  }
  
  public DeflaterSink(Sink paramSink, Deflater paramDeflater) {
    this(Okio.buffer(paramSink), paramDeflater);
  }
  
  @IgnoreJRERequirement
  private void deflate(boolean paramBoolean) throws IOException {
    Buffer buffer = this.sink.buffer();
    while (true) {
      int i;
      Segment segment = buffer.writableSegment(1);
      if (paramBoolean) {
        i = this.deflater.deflate(segment.data, segment.limit, 8192 - segment.limit, 2);
      } else {
        i = this.deflater.deflate(segment.data, segment.limit, 8192 - segment.limit);
      } 
      if (i > 0) {
        segment.limit += i;
        buffer.size += i;
        this.sink.emitCompleteSegments();
        continue;
      } 
      if (this.deflater.needsInput()) {
        if (segment.pos == segment.limit) {
          buffer.head = segment.pop();
          SegmentPool.recycle(segment);
        } 
        return;
      } 
    } 
  }
  
  public void close() throws IOException {
    Throwable throwable2;
    if (this.closed)
      return; 
    throwable1 = null;
    try {
      finishDeflate();
    } catch (Throwable throwable1) {}
    try {
      this.deflater.end();
      throwable2 = throwable1;
    } catch (Throwable throwable) {
      throwable2 = throwable1;
      if (throwable1 == null)
        throwable2 = throwable; 
    } 
    try {
      this.sink.close();
      throwable1 = throwable2;
    } catch (Throwable throwable) {
      throwable1 = throwable2;
      if (throwable2 == null)
        throwable1 = throwable; 
    } 
    this.closed = true;
    if (throwable1 != null)
      Util.sneakyRethrow(throwable1); 
  }
  
  void finishDeflate() throws IOException {
    this.deflater.finish();
    deflate(false);
  }
  
  public void flush() throws IOException {
    deflate(true);
    this.sink.flush();
  }
  
  public Timeout timeout() {
    return this.sink.timeout();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("DeflaterSink(");
    stringBuilder.append(this.sink);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong) throws IOException {
    Util.checkOffsetAndCount(paramBuffer.size, 0L, paramLong);
    while (paramLong > 0L) {
      Segment segment = paramBuffer.head;
      int i = (int)Math.min(paramLong, (segment.limit - segment.pos));
      this.deflater.setInput(segment.data, segment.pos, i);
      deflate(false);
      long l1 = paramBuffer.size;
      long l2 = i;
      paramBuffer.size = l1 - l2;
      segment.pos += i;
      if (segment.pos == segment.limit) {
        paramBuffer.head = segment.pop();
        SegmentPool.recycle(segment);
      } 
      paramLong -= l2;
    } 
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\DeflaterSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */