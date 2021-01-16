package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible
final class MultiInputStream extends InputStream {
  private InputStream in;
  
  private Iterator<? extends ByteSource> it;
  
  public MultiInputStream(Iterator<? extends ByteSource> paramIterator) throws IOException {
    this.it = (Iterator<? extends ByteSource>)Preconditions.checkNotNull(paramIterator);
    advance();
  }
  
  private void advance() throws IOException {
    close();
    if (this.it.hasNext())
      this.in = ((ByteSource)this.it.next()).openStream(); 
  }
  
  public int available() throws IOException {
    InputStream inputStream = this.in;
    return (inputStream == null) ? 0 : inputStream.available();
  }
  
  public void close() throws IOException {
    InputStream inputStream = this.in;
    if (inputStream != null)
      try {
        inputStream.close();
      } finally {
        this.in = null;
      }  
  }
  
  public boolean markSupported() {
    return false;
  }
  
  public int read() throws IOException {
    InputStream inputStream = this.in;
    if (inputStream == null)
      return -1; 
    int i = inputStream.read();
    if (i == -1) {
      advance();
      return read();
    } 
    return i;
  }
  
  public int read(@Nullable byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    InputStream inputStream = this.in;
    if (inputStream == null)
      return -1; 
    int i = inputStream.read(paramArrayOfbyte, paramInt1, paramInt2);
    if (i == -1) {
      advance();
      return read(paramArrayOfbyte, paramInt1, paramInt2);
    } 
    return i;
  }
  
  public long skip(long paramLong) throws IOException {
    InputStream inputStream = this.in;
    if (inputStream == null || paramLong <= 0L)
      return 0L; 
    long l = inputStream.skip(paramLong);
    return (l != 0L) ? l : ((read() == -1) ? 0L : (this.in.skip(paramLong - 1L) + 1L));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\MultiInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */