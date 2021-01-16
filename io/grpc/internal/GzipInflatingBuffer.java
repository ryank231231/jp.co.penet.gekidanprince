package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
class GzipInflatingBuffer implements Closeable {
  private static final int GZIP_HEADER_MIN_SIZE = 10;
  
  private static final int GZIP_MAGIC = 35615;
  
  private static final int GZIP_TRAILER_SIZE = 8;
  
  private static final int HEADER_COMMENT_FLAG = 16;
  
  private static final int HEADER_CRC_FLAG = 2;
  
  private static final int HEADER_EXTRA_FLAG = 4;
  
  private static final int HEADER_NAME_FLAG = 8;
  
  private static final int INFLATE_BUFFER_SIZE = 512;
  
  private static final int UNSIGNED_SHORT_SIZE = 2;
  
  private int bytesConsumed = 0;
  
  private boolean closed = false;
  
  private final CRC32 crc = new CRC32();
  
  private int deflatedBytesConsumed = 0;
  
  private long expectedGzipTrailerIsize;
  
  private int gzipHeaderFlag;
  
  private final GzipMetadataReader gzipMetadataReader = new GzipMetadataReader();
  
  private final CompositeReadableBuffer gzippedData = new CompositeReadableBuffer();
  
  private int headerExtraToRead;
  
  private Inflater inflater;
  
  private final byte[] inflaterInput = new byte[512];
  
  private int inflaterInputEnd;
  
  private int inflaterInputStart;
  
  private boolean isStalled = true;
  
  private State state = State.HEADER;
  
  private boolean fill() {
    boolean bool;
    if (this.inflater != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "inflater is null");
    if (this.inflaterInputStart == this.inflaterInputEnd) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "inflaterInput has unconsumed bytes");
    int i = Math.min(this.gzippedData.readableBytes(), 512);
    if (i == 0)
      return false; 
    this.inflaterInputStart = 0;
    this.inflaterInputEnd = i;
    this.gzippedData.readBytes(this.inflaterInput, this.inflaterInputStart, i);
    this.inflater.setInput(this.inflaterInput, this.inflaterInputStart, i);
    this.state = State.INFLATING;
    return true;
  }
  
  private int inflate(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws DataFormatException, ZipException {
    boolean bool;
    if (this.inflater != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "inflater is null");
    try {
      int i = this.inflater.getTotalIn();
      paramInt2 = this.inflater.inflate(paramArrayOfbyte, paramInt1, paramInt2);
      i = this.inflater.getTotalIn() - i;
      this.bytesConsumed += i;
      this.deflatedBytesConsumed += i;
      this.inflaterInputStart += i;
      this.crc.update(paramArrayOfbyte, paramInt1, paramInt2);
      if (this.inflater.finished()) {
        this.expectedGzipTrailerIsize = this.inflater.getBytesWritten() & 0xFFFFFFFFL;
        this.state = State.TRAILER;
      } else if (this.inflater.needsInput()) {
        this.state = State.INFLATER_NEEDS_INPUT;
      } 
      return paramInt2;
    } catch (DataFormatException dataFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Inflater data format exception: ");
      stringBuilder.append(dataFormatException.getMessage());
      throw new DataFormatException(stringBuilder.toString());
    } 
  }
  
  private boolean initializeInflater() {
    Inflater inflater = this.inflater;
    if (inflater == null) {
      this.inflater = new Inflater(true);
    } else {
      inflater.reset();
    } 
    this.crc.reset();
    int i = this.inflaterInputEnd;
    int j = this.inflaterInputStart;
    i -= j;
    if (i > 0) {
      this.inflater.setInput(this.inflaterInput, j, i);
      this.state = State.INFLATING;
    } else {
      this.state = State.INFLATER_NEEDS_INPUT;
    } 
    return true;
  }
  
  private boolean processHeader() throws ZipException {
    if (this.gzipMetadataReader.readableBytes() < 10)
      return false; 
    if (this.gzipMetadataReader.readUnsignedShort() == 35615) {
      if (this.gzipMetadataReader.readUnsignedByte() == 8) {
        this.gzipHeaderFlag = this.gzipMetadataReader.readUnsignedByte();
        this.gzipMetadataReader.skipBytes(6);
        this.state = State.HEADER_EXTRA_LEN;
        return true;
      } 
      throw new ZipException("Unsupported compression method");
    } 
    throw new ZipException("Not in GZIP format");
  }
  
  private boolean processHeaderComment() {
    if ((this.gzipHeaderFlag & 0x10) != 16) {
      this.state = State.HEADER_CRC;
      return true;
    } 
    if (!this.gzipMetadataReader.readBytesUntilZero())
      return false; 
    this.state = State.HEADER_CRC;
    return true;
  }
  
  private boolean processHeaderCrc() throws ZipException {
    if ((this.gzipHeaderFlag & 0x2) != 2) {
      this.state = State.INITIALIZE_INFLATER;
      return true;
    } 
    if (this.gzipMetadataReader.readableBytes() < 2)
      return false; 
    if ((0xFFFF & (int)this.crc.getValue()) == this.gzipMetadataReader.readUnsignedShort()) {
      this.state = State.INITIALIZE_INFLATER;
      return true;
    } 
    throw new ZipException("Corrupt GZIP header");
  }
  
  private boolean processHeaderExtra() {
    int i = this.gzipMetadataReader.readableBytes();
    int j = this.headerExtraToRead;
    if (i < j)
      return false; 
    this.gzipMetadataReader.skipBytes(j);
    this.state = State.HEADER_NAME;
    return true;
  }
  
  private boolean processHeaderExtraLen() {
    if ((this.gzipHeaderFlag & 0x4) != 4) {
      this.state = State.HEADER_NAME;
      return true;
    } 
    if (this.gzipMetadataReader.readableBytes() < 2)
      return false; 
    this.headerExtraToRead = this.gzipMetadataReader.readUnsignedShort();
    this.state = State.HEADER_EXTRA;
    return true;
  }
  
  private boolean processHeaderName() {
    if ((this.gzipHeaderFlag & 0x8) != 8) {
      this.state = State.HEADER_COMMENT;
      return true;
    } 
    if (!this.gzipMetadataReader.readBytesUntilZero())
      return false; 
    this.state = State.HEADER_COMMENT;
    return true;
  }
  
  private boolean processTrailer() throws ZipException {
    if (this.inflater != null && this.gzipMetadataReader.readableBytes() <= 18) {
      this.inflater.end();
      this.inflater = null;
    } 
    if (this.gzipMetadataReader.readableBytes() < 8)
      return false; 
    if (this.crc.getValue() == this.gzipMetadataReader.readUnsignedInt() && this.expectedGzipTrailerIsize == this.gzipMetadataReader.readUnsignedInt()) {
      this.crc.reset();
      this.state = State.HEADER;
      return true;
    } 
    throw new ZipException("Corrupt GZIP trailer");
  }
  
  void addGzippedBytes(ReadableBuffer paramReadableBuffer) {
    Preconditions.checkState(this.closed ^ true, "GzipInflatingBuffer is closed");
    this.gzippedData.addBuffer(paramReadableBuffer);
    this.isStalled = false;
  }
  
  public void close() {
    if (!this.closed) {
      this.closed = true;
      this.gzippedData.close();
      Inflater inflater = this.inflater;
      if (inflater != null) {
        inflater.end();
        this.inflater = null;
      } 
    } 
  }
  
  int getAndResetBytesConsumed() {
    int i = this.bytesConsumed;
    this.bytesConsumed = 0;
    return i;
  }
  
  int getAndResetDeflatedBytesConsumed() {
    int i = this.deflatedBytesConsumed;
    this.deflatedBytesConsumed = 0;
    return i;
  }
  
  boolean hasPartialData() {
    boolean bool = this.closed;
    boolean bool1 = true;
    Preconditions.checkState(bool ^ true, "GzipInflatingBuffer is closed");
    bool = bool1;
    if (this.gzipMetadataReader.readableBytes() == 0)
      if (this.state != State.HEADER) {
        bool = bool1;
      } else {
        bool = false;
      }  
    return bool;
  }
  
  int inflateBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws DataFormatException, ZipException {
    Preconditions.checkState(this.closed ^ true, "GzipInflatingBuffer is closed");
    boolean bool = false;
    boolean bool1 = true;
    int i = 0;
    while (bool1) {
      int j = paramInt2 - i;
      if (j > 0) {
        StringBuilder stringBuilder;
        switch (this.state) {
          default:
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid state: ");
            stringBuilder.append(this.state);
            throw new AssertionError(stringBuilder.toString());
          case TRAILER:
            bool1 = processTrailer();
            continue;
          case INFLATER_NEEDS_INPUT:
            bool1 = fill();
            continue;
          case INFLATING:
            i += inflate((byte[])stringBuilder, paramInt1 + i, j);
            if (this.state == State.TRAILER) {
              bool1 = processTrailer();
              continue;
            } 
            bool1 = true;
            continue;
          case INITIALIZE_INFLATER:
            bool1 = initializeInflater();
            continue;
          case HEADER_CRC:
            bool1 = processHeaderCrc();
            continue;
          case HEADER_COMMENT:
            bool1 = processHeaderComment();
            continue;
          case HEADER_NAME:
            bool1 = processHeaderName();
            continue;
          case HEADER_EXTRA:
            bool1 = processHeaderExtra();
            continue;
          case HEADER_EXTRA_LEN:
            bool1 = processHeaderExtraLen();
            continue;
          case HEADER:
            break;
        } 
        bool1 = processHeader();
      } 
    } 
    if (bool1) {
      bool1 = bool;
      if (this.state == State.HEADER) {
        bool1 = bool;
        if (this.gzipMetadataReader.readableBytes() < 10) {
          bool1 = true;
          this.isStalled = bool1;
          return i;
        } 
      } 
      this.isStalled = bool1;
      return i;
    } 
    bool1 = true;
    this.isStalled = bool1;
    return i;
  }
  
  boolean isStalled() {
    Preconditions.checkState(this.closed ^ true, "GzipInflatingBuffer is closed");
    return this.isStalled;
  }
  
  private class GzipMetadataReader {
    private GzipMetadataReader() {}
    
    private boolean readBytesUntilZero() {
      while (readableBytes() > 0) {
        if (readUnsignedByte() == 0)
          return true; 
      } 
      return false;
    }
    
    private int readUnsignedByte() {
      int i;
      if (GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart > 0) {
        i = GzipInflatingBuffer.this.inflaterInput[GzipInflatingBuffer.this.inflaterInputStart] & 0xFF;
        GzipInflatingBuffer.access$112(GzipInflatingBuffer.this, 1);
      } else {
        i = GzipInflatingBuffer.this.gzippedData.readUnsignedByte();
      } 
      GzipInflatingBuffer.this.crc.update(i);
      GzipInflatingBuffer.access$512(GzipInflatingBuffer.this, 1);
      return i;
    }
    
    private long readUnsignedInt() {
      return readUnsignedShort() | readUnsignedShort() << 16L;
    }
    
    private int readUnsignedShort() {
      return readUnsignedByte() | readUnsignedByte() << 8;
    }
    
    private int readableBytes() {
      return GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart + GzipInflatingBuffer.this.gzippedData.readableBytes();
    }
    
    private void skipBytes(int param1Int) {
      int i = GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart;
      if (i > 0) {
        i = Math.min(i, param1Int);
        GzipInflatingBuffer.this.crc.update(GzipInflatingBuffer.this.inflaterInput, GzipInflatingBuffer.this.inflaterInputStart, i);
        GzipInflatingBuffer.access$112(GzipInflatingBuffer.this, i);
        i = param1Int - i;
      } else {
        i = param1Int;
      } 
      if (i > 0) {
        byte[] arrayOfByte = new byte[512];
        int j;
        for (j = 0; j < i; j += k) {
          int k = Math.min(i - j, arrayOfByte.length);
          GzipInflatingBuffer.this.gzippedData.readBytes(arrayOfByte, 0, k);
          GzipInflatingBuffer.this.crc.update(arrayOfByte, 0, k);
        } 
      } 
      GzipInflatingBuffer.access$512(GzipInflatingBuffer.this, param1Int);
    }
  }
  
  private enum State {
    HEADER, HEADER_COMMENT, HEADER_CRC, HEADER_EXTRA, HEADER_EXTRA_LEN, HEADER_NAME, INFLATER_NEEDS_INPUT, INFLATING, INITIALIZE_INFLATER, TRAILER;
    
    static {
      HEADER_COMMENT = new State("HEADER_COMMENT", 4);
      HEADER_CRC = new State("HEADER_CRC", 5);
      INITIALIZE_INFLATER = new State("INITIALIZE_INFLATER", 6);
      INFLATING = new State("INFLATING", 7);
      INFLATER_NEEDS_INPUT = new State("INFLATER_NEEDS_INPUT", 8);
      TRAILER = new State("TRAILER", 9);
      $VALUES = new State[] { HEADER, HEADER_EXTRA_LEN, HEADER_EXTRA, HEADER_NAME, HEADER_COMMENT, HEADER_CRC, INITIALIZE_INFLATER, INFLATING, INFLATER_NEEDS_INPUT, TRAILER };
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\GzipInflatingBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */