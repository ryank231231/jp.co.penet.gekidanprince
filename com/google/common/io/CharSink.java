package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

@GwtIncompatible
public abstract class CharSink {
  public Writer openBufferedStream() throws IOException {
    Writer writer = openStream();
    if (writer instanceof BufferedWriter) {
      writer = writer;
    } else {
      writer = new BufferedWriter(writer);
    } 
    return writer;
  }
  
  public abstract Writer openStream() throws IOException;
  
  public void write(CharSequence paramCharSequence) throws IOException {
    Preconditions.checkNotNull(paramCharSequence);
    Closer closer = Closer.create();
    try {
      Writer writer = closer.<Writer>register(openStream());
      writer.append(paramCharSequence);
      writer.flush();
      closer.close();
      return;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramCharSequence;
  }
  
  @CanIgnoreReturnValue
  public long writeFrom(Readable paramReadable) throws IOException {
    Preconditions.checkNotNull(paramReadable);
    Closer closer = Closer.create();
    try {
      Writer writer = closer.<Writer>register(openStream());
      long l = CharStreams.copy(paramReadable, writer);
      writer.flush();
      closer.close();
      return l;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramReadable;
  }
  
  public void writeLines(Iterable<? extends CharSequence> paramIterable) throws IOException {
    writeLines(paramIterable, System.getProperty("line.separator"));
  }
  
  public void writeLines(Iterable<? extends CharSequence> paramIterable, String paramString) throws IOException {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramString);
    Closer closer = Closer.create();
    try {
      Writer writer = closer.<Writer>register(openBufferedStream());
      Iterator<? extends CharSequence> iterator = paramIterable.iterator();
      while (iterator.hasNext())
        writer.append(iterator.next()).append(paramString); 
      writer.flush();
      closer.close();
      return;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramIterable;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\CharSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */