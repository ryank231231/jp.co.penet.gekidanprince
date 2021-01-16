package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
@GwtIncompatible
public final class FileBackedOutputStream extends OutputStream {
  private File file;
  
  private final int fileThreshold;
  
  private MemoryOutput memory;
  
  private OutputStream out;
  
  private final boolean resetOnFinalize;
  
  private final ByteSource source;
  
  public FileBackedOutputStream(int paramInt) {
    this(paramInt, false);
  }
  
  public FileBackedOutputStream(int paramInt, boolean paramBoolean) {
    this.fileThreshold = paramInt;
    this.resetOnFinalize = paramBoolean;
    this.memory = new MemoryOutput();
    this.out = this.memory;
    if (paramBoolean) {
      this.source = new ByteSource() {
          protected void finalize() {
            try {
              FileBackedOutputStream.this.reset();
            } catch (Throwable throwable) {
              throwable.printStackTrace(System.err);
            } 
          }
          
          public InputStream openStream() throws IOException {
            return FileBackedOutputStream.this.openInputStream();
          }
        };
    } else {
      this.source = new ByteSource() {
          public InputStream openStream() throws IOException {
            return FileBackedOutputStream.this.openInputStream();
          }
        };
    } 
  }
  
  private InputStream openInputStream() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield file : Ljava/io/File;
    //   6: ifnull -> 25
    //   9: new java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield file : Ljava/io/File;
    //   17: invokespecial <init> : (Ljava/io/File;)V
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: new java/io/ByteArrayInputStream
    //   28: dup
    //   29: aload_0
    //   30: getfield memory : Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   33: invokevirtual getBuffer : ()[B
    //   36: iconst_0
    //   37: aload_0
    //   38: getfield memory : Lcom/google/common/io/FileBackedOutputStream$MemoryOutput;
    //   41: invokevirtual getCount : ()I
    //   44: invokespecial <init> : ([BII)V
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: areturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	52	finally
    //   25	48	52	finally
  }
  
  private void update(int paramInt) throws IOException {
    if (this.file == null && this.memory.getCount() + paramInt > this.fileThreshold) {
      File file = File.createTempFile("FileBackedOutputStream", null);
      if (this.resetOnFinalize)
        file.deleteOnExit(); 
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
      fileOutputStream.flush();
      this.out = fileOutputStream;
      this.file = file;
      this.memory = null;
    } 
  }
  
  public ByteSource asByteSource() {
    return this.source;
  }
  
  public void close() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield out : Ljava/io/OutputStream;
    //   6: invokevirtual close : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void flush() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield out : Ljava/io/OutputStream;
    //   6: invokevirtual flush : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  @VisibleForTesting
  File getFile() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield file : Ljava/io/File;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void reset() throws IOException {
    File file;
    /* monitor enter ThisExpression{ObjectType{com/google/common/io/FileBackedOutputStream}} */
    try {
    
    } finally {
      StringBuilder stringBuilder;
      Exception exception = null;
      if (this.memory == null) {
        MemoryOutput memoryOutput = new MemoryOutput();
        this();
        this.memory = memoryOutput;
      } else {
        this.memory.reset();
      } 
      this.out = this.memory;
      if (this.file != null) {
        file = this.file;
        this.file = null;
        if (!file.delete()) {
          IOException iOException = new IOException();
          stringBuilder = new StringBuilder();
          this();
          stringBuilder.append("Could not delete: ");
          stringBuilder.append(file);
          this(stringBuilder.toString());
          throw iOException;
        } 
      } 
    } 
    /* monitor exit ThisExpression{ObjectType{com/google/common/io/FileBackedOutputStream}} */
    throw file;
  }
  
  public void write(int paramInt) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: invokespecial update : (I)V
    //   7: aload_0
    //   8: getfield out : Ljava/io/OutputStream;
    //   11: iload_1
    //   12: invokevirtual write : (I)V
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	18	finally
  }
  
  public void write(byte[] paramArrayOfbyte) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iconst_0
    //   5: aload_1
    //   6: arraylength
    //   7: invokevirtual write : ([BII)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_3
    //   4: invokespecial update : (I)V
    //   7: aload_0
    //   8: getfield out : Ljava/io/OutputStream;
    //   11: aload_1
    //   12: iload_2
    //   13: iload_3
    //   14: invokevirtual write : ([BII)V
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  private static class MemoryOutput extends ByteArrayOutputStream {
    private MemoryOutput() {}
    
    byte[] getBuffer() {
      return this.buf;
    }
    
    int getCount() {
      return this.count;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\FileBackedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */