package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible
class MultiReader extends Reader {
  private Reader current;
  
  private final Iterator<? extends CharSource> it;
  
  MultiReader(Iterator<? extends CharSource> paramIterator) throws IOException {
    this.it = paramIterator;
    advance();
  }
  
  private void advance() throws IOException {
    close();
    if (this.it.hasNext())
      this.current = ((CharSource)this.it.next()).openStream(); 
  }
  
  public void close() throws IOException {
    Reader reader = this.current;
    if (reader != null)
      try {
        reader.close();
      } finally {
        this.current = null;
      }  
  }
  
  public int read(@Nullable char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    Reader reader = this.current;
    if (reader == null)
      return -1; 
    int i = reader.read(paramArrayOfchar, paramInt1, paramInt2);
    if (i == -1) {
      advance();
      return read(paramArrayOfchar, paramInt1, paramInt2);
    } 
    return i;
  }
  
  public boolean ready() throws IOException {
    boolean bool;
    Reader reader = this.current;
    if (reader != null && reader.ready()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public long skip(long paramLong) throws IOException {
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "n is negative");
    if (paramLong > 0L)
      while (true) {
        Reader reader = this.current;
        if (reader != null) {
          long l = reader.skip(paramLong);
          if (l > 0L)
            return l; 
          advance();
          continue;
        } 
        break;
      }  
    return 0L;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\MultiReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */