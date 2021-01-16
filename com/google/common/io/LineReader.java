package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;

@Beta
@GwtIncompatible
public final class LineReader {
  private final char[] buf = this.cbuf.array();
  
  private final CharBuffer cbuf = CharStreams.createBuffer();
  
  private final LineBuffer lineBuf = new LineBuffer() {
      protected void handleLine(String param1String1, String param1String2) {
        LineReader.this.lines.add(param1String1);
      }
    };
  
  private final Queue<String> lines = new LinkedList<String>();
  
  private final Readable readable;
  
  private final Reader reader;
  
  public LineReader(Readable paramReadable) {
    this.readable = (Readable)Preconditions.checkNotNull(paramReadable);
    if (paramReadable instanceof Reader) {
      paramReadable = paramReadable;
    } else {
      paramReadable = null;
    } 
    this.reader = (Reader)paramReadable;
  }
  
  @CanIgnoreReturnValue
  public String readLine() throws IOException {
    while (this.lines.peek() == null) {
      int i;
      this.cbuf.clear();
      Reader reader = this.reader;
      if (reader != null) {
        char[] arrayOfChar = this.buf;
        i = reader.read(arrayOfChar, 0, arrayOfChar.length);
      } else {
        i = this.readable.read(this.cbuf);
      } 
      if (i == -1) {
        this.lineBuf.finish();
        break;
      } 
      this.lineBuf.add(this.buf, 0, i);
    } 
    return this.lines.poll();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\LineReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */