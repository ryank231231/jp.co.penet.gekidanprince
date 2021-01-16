package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
@GwtIncompatible
public final class CountingInputStream extends FilterInputStream {
  private long count;
  
  private long mark = -1L;
  
  public CountingInputStream(InputStream paramInputStream) {
    super((InputStream)Preconditions.checkNotNull(paramInputStream));
  }
  
  public long getCount() {
    return this.count;
  }
  
  public void mark(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield in : Ljava/io/InputStream;
    //   6: iload_1
    //   7: invokevirtual mark : (I)V
    //   10: aload_0
    //   11: aload_0
    //   12: getfield count : J
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
    int i = this.in.read();
    if (i != -1)
      this.count++; 
    return i;
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    paramInt1 = this.in.read(paramArrayOfbyte, paramInt1, paramInt2);
    if (paramInt1 != -1)
      this.count += paramInt1; 
    return paramInt1;
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
    //   35: putfield count : J
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
  
  public long skip(long paramLong) throws IOException {
    paramLong = this.in.skip(paramLong);
    this.count += paramLong;
    return paramLong;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\CountingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */