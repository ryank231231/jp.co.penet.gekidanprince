package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Drainable;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class MessageFramer implements Framer {
  private static final byte COMPRESSED = 1;
  
  private static final int HEADER_LENGTH = 5;
  
  private static final int NO_MAX_OUTBOUND_MESSAGE_SIZE = -1;
  
  private static final byte UNCOMPRESSED = 0;
  
  private WritableBuffer buffer;
  
  private final WritableBufferAllocator bufferAllocator;
  
  private boolean closed;
  
  private Compressor compressor = (Compressor)Codec.Identity.NONE;
  
  private int currentMessageSeqNo = -1;
  
  private long currentMessageWireSize;
  
  private final byte[] headerScratch = new byte[5];
  
  private int maxOutboundMessageSize = -1;
  
  private boolean messageCompression = true;
  
  private int messagesBuffered;
  
  private final OutputStreamAdapter outputStreamAdapter = new OutputStreamAdapter();
  
  private final Sink sink;
  
  private final StatsTraceContext statsTraceCtx;
  
  public MessageFramer(Sink paramSink, WritableBufferAllocator paramWritableBufferAllocator, StatsTraceContext paramStatsTraceContext) {
    this.sink = (Sink)Preconditions.checkNotNull(paramSink, "sink");
    this.bufferAllocator = (WritableBufferAllocator)Preconditions.checkNotNull(paramWritableBufferAllocator, "bufferAllocator");
    this.statsTraceCtx = (StatsTraceContext)Preconditions.checkNotNull(paramStatsTraceContext, "statsTraceCtx");
  }
  
  private void commitToSink(boolean paramBoolean1, boolean paramBoolean2) {
    WritableBuffer writableBuffer = this.buffer;
    this.buffer = null;
    this.sink.deliverFrame(writableBuffer, paramBoolean1, paramBoolean2, this.messagesBuffered);
    this.messagesBuffered = 0;
  }
  
  private int getKnownLength(InputStream paramInputStream) throws IOException {
    return (paramInputStream instanceof io.grpc.KnownLength || paramInputStream instanceof java.io.ByteArrayInputStream) ? paramInputStream.available() : -1;
  }
  
  private void releaseBuffer() {
    WritableBuffer writableBuffer = this.buffer;
    if (writableBuffer != null) {
      writableBuffer.release();
      this.buffer = null;
    } 
  }
  
  private void verifyNotClosed() {
    if (!isClosed())
      return; 
    throw new IllegalStateException("Framer already closed");
  }
  
  private void writeBufferChain(BufferChainOutputStream paramBufferChainOutputStream, boolean paramBoolean) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(this.headerScratch);
    byteBuffer.put(paramBoolean);
    int i = paramBufferChainOutputStream.readableBytes();
    byteBuffer.putInt(i);
    WritableBuffer writableBuffer = this.bufferAllocator.allocate(5);
    writableBuffer.write(this.headerScratch, 0, byteBuffer.position());
    if (i == 0) {
      this.buffer = writableBuffer;
      return;
    } 
    this.sink.deliverFrame(writableBuffer, false, false, this.messagesBuffered - 1);
    this.messagesBuffered = 1;
    List<WritableBuffer> list = paramBufferChainOutputStream.bufferList;
    for (byte b = 0; b < list.size() - 1; b++)
      this.sink.deliverFrame(list.get(b), false, false, 0); 
    this.buffer = list.get(list.size() - 1);
    this.currentMessageWireSize = i;
  }
  
  private int writeCompressed(InputStream paramInputStream, int paramInt) throws IOException {
    BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
    OutputStream outputStream = this.compressor.compress(bufferChainOutputStream);
    try {
      int i = writeToOutputStream(paramInputStream, outputStream);
      outputStream.close();
      paramInt = this.maxOutboundMessageSize;
      if (paramInt < 0 || i <= paramInt)
        return i; 
      throw Status.RESOURCE_EXHAUSTED.withDescription(String.format("message too large %d > %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.maxOutboundMessageSize) })).asRuntimeException();
    } finally {
      outputStream.close();
    } 
  }
  
  private int writeKnownLengthUncompressed(InputStream paramInputStream, int paramInt) throws IOException {
    int i = this.maxOutboundMessageSize;
    if (i < 0 || paramInt <= i) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(this.headerScratch);
      byteBuffer.put((byte)0);
      byteBuffer.putInt(paramInt);
      if (this.buffer == null)
        this.buffer = this.bufferAllocator.allocate(byteBuffer.position() + paramInt); 
      writeRaw(this.headerScratch, 0, byteBuffer.position());
      return writeToOutputStream(paramInputStream, this.outputStreamAdapter);
    } 
    throw Status.RESOURCE_EXHAUSTED.withDescription(String.format("message too large %d > %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.maxOutboundMessageSize) })).asRuntimeException();
  }
  
  private void writeRaw(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    while (paramInt2 > 0) {
      WritableBuffer writableBuffer = this.buffer;
      if (writableBuffer != null && writableBuffer.writableBytes() == 0)
        commitToSink(false, false); 
      if (this.buffer == null)
        this.buffer = this.bufferAllocator.allocate(paramInt2); 
      int i = Math.min(paramInt2, this.buffer.writableBytes());
      this.buffer.write(paramArrayOfbyte, paramInt1, i);
      paramInt1 += i;
      paramInt2 -= i;
    } 
  }
  
  private static int writeToOutputStream(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    boolean bool;
    if (paramInputStream instanceof Drainable)
      return ((Drainable)paramInputStream).drainTo(paramOutputStream); 
    long l = IoUtils.copy(paramInputStream, paramOutputStream);
    if (l <= 2147483647L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Message size overflow: %s", l);
    return (int)l;
  }
  
  private int writeUncompressed(InputStream paramInputStream, int paramInt) throws IOException {
    if (paramInt != -1) {
      this.currentMessageWireSize = paramInt;
      return writeKnownLengthUncompressed(paramInputStream, paramInt);
    } 
    BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
    int i = writeToOutputStream(paramInputStream, bufferChainOutputStream);
    paramInt = this.maxOutboundMessageSize;
    if (paramInt < 0 || i <= paramInt) {
      writeBufferChain(bufferChainOutputStream, false);
      return i;
    } 
    throw Status.RESOURCE_EXHAUSTED.withDescription(String.format("message too large %d > %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.maxOutboundMessageSize) })).asRuntimeException();
  }
  
  public void close() {
    if (!isClosed()) {
      this.closed = true;
      WritableBuffer writableBuffer = this.buffer;
      if (writableBuffer != null && writableBuffer.readableBytes() == 0)
        releaseBuffer(); 
      commitToSink(true, true);
    } 
  }
  
  public void dispose() {
    this.closed = true;
    releaseBuffer();
  }
  
  public void flush() {
    WritableBuffer writableBuffer = this.buffer;
    if (writableBuffer != null && writableBuffer.readableBytes() > 0)
      commitToSink(false, true); 
  }
  
  public boolean isClosed() {
    return this.closed;
  }
  
  public MessageFramer setCompressor(Compressor paramCompressor) {
    this.compressor = (Compressor)Preconditions.checkNotNull(paramCompressor, "Can't pass an empty compressor");
    return this;
  }
  
  public void setMaxOutboundMessageSize(int paramInt) {
    boolean bool;
    if (this.maxOutboundMessageSize == -1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "max size already set");
    this.maxOutboundMessageSize = paramInt;
  }
  
  public MessageFramer setMessageCompression(boolean paramBoolean) {
    this.messageCompression = paramBoolean;
    return this;
  }
  
  public void writePayload(InputStream paramInputStream) {
    int i;
    verifyNotClosed();
    this.messagesBuffered++;
    this.currentMessageSeqNo++;
    this.currentMessageWireSize = 0L;
    this.statsTraceCtx.outboundMessage(this.currentMessageSeqNo);
    if (this.messageCompression && this.compressor != Codec.Identity.NONE) {
      i = 1;
    } else {
      i = 0;
    } 
    try {
      int j = getKnownLength(paramInputStream);
      if (j != 0 && i) {
        i = writeCompressed(paramInputStream, j);
      } else {
        i = writeUncompressed(paramInputStream, j);
      } 
      if (j == -1 || i == j) {
        StatsTraceContext statsTraceContext = this.statsTraceCtx;
        long l = i;
        statsTraceContext.outboundUncompressedSize(l);
        this.statsTraceCtx.outboundWireSize(this.currentMessageWireSize);
        this.statsTraceCtx.outboundMessageSent(this.currentMessageSeqNo, this.currentMessageWireSize, l);
        return;
      } 
      String str = String.format("Message length inaccurate %s != %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      throw Status.INTERNAL.withDescription(str).asRuntimeException();
    } catch (IOException iOException) {
      throw Status.INTERNAL.withDescription("Failed to frame message").withCause(iOException).asRuntimeException();
    } catch (RuntimeException runtimeException) {
      throw Status.INTERNAL.withDescription("Failed to frame message").withCause(runtimeException).asRuntimeException();
    } 
  }
  
  private final class BufferChainOutputStream extends OutputStream {
    private final List<WritableBuffer> bufferList = new ArrayList<WritableBuffer>();
    
    private WritableBuffer current;
    
    private BufferChainOutputStream() {}
    
    private int readableBytes() {
      Iterator<WritableBuffer> iterator = this.bufferList.iterator();
      int i;
      for (i = 0; iterator.hasNext(); i += ((WritableBuffer)iterator.next()).readableBytes());
      return i;
    }
    
    public void write(int param1Int) throws IOException {
      WritableBuffer writableBuffer = this.current;
      if (writableBuffer != null && writableBuffer.writableBytes() > 0) {
        this.current.write((byte)param1Int);
        return;
      } 
      write(new byte[] { (byte)param1Int }, 0, 1);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      int i = param1Int1;
      int j = param1Int2;
      if (this.current == null) {
        this.current = MessageFramer.this.bufferAllocator.allocate(param1Int2);
        this.bufferList.add(this.current);
        j = param1Int2;
        i = param1Int1;
      } 
      while (j > 0) {
        param1Int1 = Math.min(j, this.current.writableBytes());
        if (param1Int1 == 0) {
          param1Int1 = Math.max(j, this.current.readableBytes() * 2);
          this.current = MessageFramer.this.bufferAllocator.allocate(param1Int1);
          this.bufferList.add(this.current);
          continue;
        } 
        this.current.write(param1ArrayOfbyte, i, param1Int1);
        i += param1Int1;
        j -= param1Int1;
      } 
    }
  }
  
  private class OutputStreamAdapter extends OutputStream {
    private OutputStreamAdapter() {}
    
    public void write(int param1Int) {
      write(new byte[] { (byte)param1Int }, 0, 1);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      MessageFramer.this.writeRaw(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
  
  public static interface Sink {
    void deliverFrame(@Nullable WritableBuffer param1WritableBuffer, boolean param1Boolean1, boolean param1Boolean2, int param1Int);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\MessageFramer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */