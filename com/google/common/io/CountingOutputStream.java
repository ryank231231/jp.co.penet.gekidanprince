package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
@GwtIncompatible
public final class CountingOutputStream extends FilterOutputStream {
  private long count;
  
  public CountingOutputStream(OutputStream paramOutputStream) {
    super((OutputStream)Preconditions.checkNotNull(paramOutputStream));
  }
  
  public void close() throws IOException {
    this.out.close();
  }
  
  public long getCount() {
    return this.count;
  }
  
  public void write(int paramInt) throws IOException {
    this.out.write(paramInt);
    this.count++;
  }
  
  public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
    this.count += paramInt2;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\CountingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */