package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;

@Beta
@GwtIncompatible
public final class ByteStreams {
  private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
      public String toString() {
        return "ByteStreams.nullOutputStream()";
      }
      
      public void write(int param1Int) {}
      
      public void write(byte[] param1ArrayOfbyte) {
        Preconditions.checkNotNull(param1ArrayOfbyte);
      }
      
      public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
        Preconditions.checkNotNull(param1ArrayOfbyte);
      }
    };
  
  private static final int ZERO_COPY_CHUNK_SIZE = 524288;
  
  @CanIgnoreReturnValue
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = createBuffer();
    for (long l = 0L;; l += i) {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l; 
      paramOutputStream.write(arrayOfByte, 0, i);
    } 
  }
  
  @CanIgnoreReturnValue
  public static long copy(ReadableByteChannel paramReadableByteChannel, WritableByteChannel paramWritableByteChannel) throws IOException {
    Preconditions.checkNotNull(paramReadableByteChannel);
    Preconditions.checkNotNull(paramWritableByteChannel);
    boolean bool = paramReadableByteChannel instanceof java.nio.channels.FileChannel;
    long l = 0L;
    if (bool) {
      paramReadableByteChannel = paramReadableByteChannel;
      long l1 = paramReadableByteChannel.position();
      l = l1;
      while (true) {
        long l2 = paramReadableByteChannel.transferTo(l, 524288L, paramWritableByteChannel);
        long l3 = l + l2;
        paramReadableByteChannel.position(l3);
        l = l3;
        if (l2 <= 0L) {
          l = l3;
          if (l3 >= paramReadableByteChannel.size())
            return l3 - l1; 
        } 
      } 
    } 
    ByteBuffer byteBuffer = ByteBuffer.wrap(createBuffer());
    while (paramReadableByteChannel.read(byteBuffer) != -1) {
      byteBuffer.flip();
      while (byteBuffer.hasRemaining())
        l += paramWritableByteChannel.write(byteBuffer); 
      byteBuffer.clear();
    } 
    return l;
  }
  
  static byte[] createBuffer() {
    return new byte[8192];
  }
  
  @CanIgnoreReturnValue
  public static long exhaust(InputStream paramInputStream) throws IOException {
    byte[] arrayOfByte = createBuffer();
    long l = 0L;
    while (true) {
      long l1 = paramInputStream.read(arrayOfByte);
      if (l1 != -1L) {
        l += l1;
        continue;
      } 
      return l;
    } 
  }
  
  public static InputStream limit(InputStream paramInputStream, long paramLong) {
    return new LimitedInputStream(paramInputStream, paramLong);
  }
  
  public static ByteArrayDataInput newDataInput(ByteArrayInputStream paramByteArrayInputStream) {
    return new ByteArrayDataInputStream((ByteArrayInputStream)Preconditions.checkNotNull(paramByteArrayInputStream));
  }
  
  public static ByteArrayDataInput newDataInput(byte[] paramArrayOfbyte) {
    return newDataInput(new ByteArrayInputStream(paramArrayOfbyte));
  }
  
  public static ByteArrayDataInput newDataInput(byte[] paramArrayOfbyte, int paramInt) {
    Preconditions.checkPositionIndex(paramInt, paramArrayOfbyte.length);
    return newDataInput(new ByteArrayInputStream(paramArrayOfbyte, paramInt, paramArrayOfbyte.length - paramInt));
  }
  
  public static ByteArrayDataOutput newDataOutput() {
    return newDataOutput(new ByteArrayOutputStream());
  }
  
  public static ByteArrayDataOutput newDataOutput(int paramInt) {
    if (paramInt >= 0)
      return newDataOutput(new ByteArrayOutputStream(paramInt)); 
    throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream paramByteArrayOutputStream) {
    return new ByteArrayDataOutputStream((ByteArrayOutputStream)Preconditions.checkNotNull(paramByteArrayOutputStream));
  }
  
  public static OutputStream nullOutputStream() {
    return NULL_OUTPUT_STREAM;
  }
  
  @CanIgnoreReturnValue
  public static int read(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfbyte);
    if (paramInt2 >= 0) {
      int i;
      for (i = 0; i < paramInt2; i += j) {
        int j = paramInputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
        if (j == -1)
          break; 
      } 
      return i;
    } 
    throw new IndexOutOfBoundsException("len is negative");
  }
  
  @CanIgnoreReturnValue
  public static <T> T readBytes(InputStream paramInputStream, ByteProcessor<T> paramByteProcessor) throws IOException {
    int i;
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramByteProcessor);
    byte[] arrayOfByte = createBuffer();
    do {
      i = paramInputStream.read(arrayOfByte);
    } while (i != -1 && paramByteProcessor.processBytes(arrayOfByte, 0, i));
    return paramByteProcessor.getResult();
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte) throws IOException {
    readFully(paramInputStream, paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt1 = read(paramInputStream, paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt1 == paramInt2)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("reached end of stream after reading ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" bytes; ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" bytes expected");
    throw new EOFException(stringBuilder.toString());
  }
  
  public static void skipFully(InputStream paramInputStream, long paramLong) throws IOException {
    long l = skipUpTo(paramInputStream, paramLong);
    if (l >= paramLong)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("reached end of stream after skipping ");
    stringBuilder.append(l);
    stringBuilder.append(" bytes; ");
    stringBuilder.append(paramLong);
    stringBuilder.append(" bytes expected");
    throw new EOFException(stringBuilder.toString());
  }
  
  private static long skipSafely(InputStream paramInputStream, long paramLong) throws IOException {
    int i = paramInputStream.available();
    if (i == 0) {
      paramLong = 0L;
    } else {
      paramLong = paramInputStream.skip(Math.min(i, paramLong));
    } 
    return paramLong;
  }
  
  static long skipUpTo(InputStream paramInputStream, long paramLong) throws IOException {
    byte[] arrayOfByte = createBuffer();
    long l;
    for (l = 0L; l < paramLong; l += l3) {
      long l1 = paramLong - l;
      long l2 = skipSafely(paramInputStream, l1);
      long l3 = l2;
      if (l2 == 0L) {
        l2 = paramInputStream.read(arrayOfByte, 0, (int)Math.min(l1, arrayOfByte.length));
        l3 = l2;
        if (l2 == -1L)
          break; 
      } 
    } 
    return l;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(32, paramInputStream.available()));
    copy(paramInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  static byte[] toByteArray(InputStream paramInputStream, int paramInt) throws IOException {
    byte[] arrayOfByte2 = new byte[paramInt];
    for (int i = paramInt; i > 0; i -= k) {
      int j = paramInt - i;
      int k = paramInputStream.read(arrayOfByte2, j, i);
      if (k == -1)
        return Arrays.copyOf(arrayOfByte2, j); 
    } 
    paramInt = paramInputStream.read();
    if (paramInt == -1)
      return arrayOfByte2; 
    FastByteArrayOutputStream fastByteArrayOutputStream = new FastByteArrayOutputStream();
    fastByteArrayOutputStream.write(paramInt);
    copy(paramInputStream, fastByteArrayOutputStream);
    byte[] arrayOfByte1 = new byte[arrayOfByte2.length + fastByteArrayOutputStream.size()];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
    fastByteArrayOutputStream.writeTo(arrayOfByte1, arrayOfByte2.length);
    return arrayOfByte1;
  }
  
  private static class ByteArrayDataInputStream implements ByteArrayDataInput {
    final DataInput input;
    
    ByteArrayDataInputStream(ByteArrayInputStream param1ByteArrayInputStream) {
      this.input = new DataInputStream(param1ByteArrayInputStream);
    }
    
    public boolean readBoolean() {
      try {
        return this.input.readBoolean();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public byte readByte() {
      try {
        return this.input.readByte();
      } catch (EOFException eOFException) {
        throw new IllegalStateException(eOFException);
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public char readChar() {
      try {
        return this.input.readChar();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public double readDouble() {
      try {
        return this.input.readDouble();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public float readFloat() {
      try {
        return this.input.readFloat();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public void readFully(byte[] param1ArrayOfbyte) {
      try {
        this.input.readFully(param1ArrayOfbyte);
        return;
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public void readFully(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.input.readFully(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int readInt() {
      try {
        return this.input.readInt();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String readLine() {
      try {
        return this.input.readLine();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public long readLong() {
      try {
        return this.input.readLong();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public short readShort() {
      try {
        return this.input.readShort();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public String readUTF() {
      try {
        return this.input.readUTF();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int readUnsignedByte() {
      try {
        return this.input.readUnsignedByte();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int readUnsignedShort() {
      try {
        return this.input.readUnsignedShort();
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
    
    public int skipBytes(int param1Int) {
      try {
        return this.input.skipBytes(param1Int);
      } catch (IOException iOException) {
        throw new IllegalStateException(iOException);
      } 
    }
  }
  
  private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
    final ByteArrayOutputStream byteArrayOutputSteam;
    
    final DataOutput output;
    
    ByteArrayDataOutputStream(ByteArrayOutputStream param1ByteArrayOutputStream) {
      this.byteArrayOutputSteam = param1ByteArrayOutputStream;
      this.output = new DataOutputStream(param1ByteArrayOutputStream);
    }
    
    public byte[] toByteArray() {
      return this.byteArrayOutputSteam.toByteArray();
    }
    
    public void write(int param1Int) {
      try {
        this.output.write(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void write(byte[] param1ArrayOfbyte) {
      try {
        this.output.write(param1ArrayOfbyte);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      try {
        this.output.write(param1ArrayOfbyte, param1Int1, param1Int2);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeBoolean(boolean param1Boolean) {
      try {
        this.output.writeBoolean(param1Boolean);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeByte(int param1Int) {
      try {
        this.output.writeByte(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeBytes(String param1String) {
      try {
        this.output.writeBytes(param1String);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeChar(int param1Int) {
      try {
        this.output.writeChar(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeChars(String param1String) {
      try {
        this.output.writeChars(param1String);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeDouble(double param1Double) {
      try {
        this.output.writeDouble(param1Double);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeFloat(float param1Float) {
      try {
        this.output.writeFloat(param1Float);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeInt(int param1Int) {
      try {
        this.output.writeInt(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeLong(long param1Long) {
      try {
        this.output.writeLong(param1Long);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeShort(int param1Int) {
      try {
        this.output.writeShort(param1Int);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    public void writeUTF(String param1String) {
      try {
        this.output.writeUTF(param1String);
        return;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
  }
  
  private static final class FastByteArrayOutputStream extends ByteArrayOutputStream {
    private FastByteArrayOutputStream() {}
    
    void writeTo(byte[] param1ArrayOfbyte, int param1Int) {
      System.arraycopy(this.buf, 0, param1ArrayOfbyte, param1Int, this.count);
    }
  }
  
  private static final class LimitedInputStream extends FilterInputStream {
    private long left;
    
    private long mark;
    
    LimitedInputStream(InputStream param1InputStream, long param1Long) {
      super(param1InputStream);
      boolean bool;
      this.mark = -1L;
      Preconditions.checkNotNull(param1InputStream);
      if (param1Long >= 0L) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "limit must be non-negative");
      this.left = param1Long;
    }
    
    public int available() throws IOException {
      return (int)Math.min(this.in.available(), this.left);
    }
    
    public void mark(int param1Int) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield in : Ljava/io/InputStream;
      //   6: iload_1
      //   7: invokevirtual mark : (I)V
      //   10: aload_0
      //   11: aload_0
      //   12: getfield left : J
      //   15: putfield mark : J
      //   18: aload_0
      //   19: monitorexit
      //   20: return
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      // Exception table:
      //   from	to	target	type
      //   2	18	21	finally
    }
    
    public int read() throws IOException {
      if (this.left == 0L)
        return -1; 
      int i = this.in.read();
      if (i != -1)
        this.left--; 
      return i;
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      long l = this.left;
      if (l == 0L)
        return -1; 
      param1Int2 = (int)Math.min(param1Int2, l);
      param1Int1 = this.in.read(param1ArrayOfbyte, param1Int1, param1Int2);
      if (param1Int1 != -1)
        this.left -= param1Int1; 
      return param1Int1;
    }
    
    public void reset() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield in : Ljava/io/InputStream;
      //   6: invokevirtual markSupported : ()Z
      //   9: ifeq -> 53
      //   12: aload_0
      //   13: getfield mark : J
      //   16: ldc2_w -1
      //   19: lcmp
      //   20: ifeq -> 41
      //   23: aload_0
      //   24: getfield in : Ljava/io/InputStream;
      //   27: invokevirtual reset : ()V
      //   30: aload_0
      //   31: aload_0
      //   32: getfield mark : J
      //   35: putfield left : J
      //   38: aload_0
      //   39: monitorexit
      //   40: return
      //   41: new java/io/IOException
      //   44: astore_1
      //   45: aload_1
      //   46: ldc 'Mark not set'
      //   48: invokespecial <init> : (Ljava/lang/String;)V
      //   51: aload_1
      //   52: athrow
      //   53: new java/io/IOException
      //   56: astore_1
      //   57: aload_1
      //   58: ldc 'Mark not supported'
      //   60: invokespecial <init> : (Ljava/lang/String;)V
      //   63: aload_1
      //   64: athrow
      //   65: astore_1
      //   66: aload_0
      //   67: monitorexit
      //   68: aload_1
      //   69: athrow
      // Exception table:
      //   from	to	target	type
      //   2	38	65	finally
      //   41	53	65	finally
      //   53	65	65	finally
    }
    
    public long skip(long param1Long) throws IOException {
      param1Long = Math.min(param1Long, this.left);
      param1Long = this.in.skip(param1Long);
      this.left -= param1Long;
      return param1Long;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\ByteStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */