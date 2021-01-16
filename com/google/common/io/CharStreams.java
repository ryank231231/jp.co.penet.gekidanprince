package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

@Beta
@GwtIncompatible
public final class CharStreams {
  public static Writer asWriter(Appendable paramAppendable) {
    return (paramAppendable instanceof Writer) ? (Writer)paramAppendable : new AppendableWriter(paramAppendable);
  }
  
  @CanIgnoreReturnValue
  public static long copy(Readable paramReadable, Appendable paramAppendable) throws IOException {
    Preconditions.checkNotNull(paramReadable);
    Preconditions.checkNotNull(paramAppendable);
    CharBuffer charBuffer = createBuffer();
    long l = 0L;
    while (paramReadable.read(charBuffer) != -1) {
      charBuffer.flip();
      paramAppendable.append(charBuffer);
      l += charBuffer.remaining();
      charBuffer.clear();
    } 
    return l;
  }
  
  static CharBuffer createBuffer() {
    return CharBuffer.allocate(2048);
  }
  
  @CanIgnoreReturnValue
  public static long exhaust(Readable paramReadable) throws IOException {
    CharBuffer charBuffer = createBuffer();
    long l = 0L;
    while (true) {
      long l1 = paramReadable.read(charBuffer);
      if (l1 != -1L) {
        l += l1;
        charBuffer.clear();
        continue;
      } 
      return l;
    } 
  }
  
  public static Writer nullWriter() {
    return NullWriter.INSTANCE;
  }
  
  @CanIgnoreReturnValue
  public static <T> T readLines(Readable paramReadable, LineProcessor<T> paramLineProcessor) throws IOException {
    String str;
    Preconditions.checkNotNull(paramReadable);
    Preconditions.checkNotNull(paramLineProcessor);
    LineReader lineReader = new LineReader(paramReadable);
    do {
      str = lineReader.readLine();
    } while (str != null && paramLineProcessor.processLine(str));
    return paramLineProcessor.getResult();
  }
  
  public static List<String> readLines(Readable paramReadable) throws IOException {
    ArrayList<String> arrayList = new ArrayList();
    LineReader lineReader = new LineReader(paramReadable);
    while (true) {
      String str = lineReader.readLine();
      if (str != null) {
        arrayList.add(str);
        continue;
      } 
      return arrayList;
    } 
  }
  
  public static void skipFully(Reader paramReader, long paramLong) throws IOException {
    Preconditions.checkNotNull(paramReader);
    while (paramLong > 0L) {
      long l = paramReader.skip(paramLong);
      if (l != 0L) {
        paramLong -= l;
        continue;
      } 
      throw new EOFException();
    } 
  }
  
  public static String toString(Readable paramReadable) throws IOException {
    return toStringBuilder(paramReadable).toString();
  }
  
  private static StringBuilder toStringBuilder(Readable paramReadable) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    copy(paramReadable, stringBuilder);
    return stringBuilder;
  }
  
  private static final class NullWriter extends Writer {
    private static final NullWriter INSTANCE = new NullWriter();
    
    public Writer append(char param1Char) {
      return this;
    }
    
    public Writer append(CharSequence param1CharSequence) {
      Preconditions.checkNotNull(param1CharSequence);
      return this;
    }
    
    public Writer append(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2, param1CharSequence.length());
      return this;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public String toString() {
      return "CharStreams.nullWriter()";
    }
    
    public void write(int param1Int) {}
    
    public void write(String param1String) {
      Preconditions.checkNotNull(param1String);
    }
    
    public void write(String param1String, int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2 + param1Int1, param1String.length());
    }
    
    public void write(char[] param1ArrayOfchar) {
      Preconditions.checkNotNull(param1ArrayOfchar);
    }
    
    public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      Preconditions.checkPositionIndexes(param1Int1, param1Int2 + param1Int1, param1ArrayOfchar.length);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\CharStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */