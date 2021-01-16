package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

@GwtIncompatible
public abstract class ByteSink {
  public CharSink asCharSink(Charset paramCharset) {
    return new AsCharSink(paramCharset);
  }
  
  public OutputStream openBufferedStream() throws IOException {
    OutputStream outputStream = openStream();
    if (outputStream instanceof BufferedOutputStream) {
      outputStream = outputStream;
    } else {
      outputStream = new BufferedOutputStream(outputStream);
    } 
    return outputStream;
  }
  
  public abstract OutputStream openStream() throws IOException;
  
  public void write(byte[] paramArrayOfbyte) throws IOException {
    Preconditions.checkNotNull(paramArrayOfbyte);
    Closer closer = Closer.create();
    try {
      OutputStream outputStream = closer.<OutputStream>register(openStream());
      outputStream.write(paramArrayOfbyte);
      outputStream.flush();
      closer.close();
      return;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramArrayOfbyte;
  }
  
  @CanIgnoreReturnValue
  public long writeFrom(InputStream paramInputStream) throws IOException {
    Preconditions.checkNotNull(paramInputStream);
    Closer closer = Closer.create();
    try {
      OutputStream outputStream = closer.<OutputStream>register(openStream());
      long l = ByteStreams.copy(paramInputStream, outputStream);
      outputStream.flush();
      closer.close();
      return l;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramInputStream;
  }
  
  private final class AsCharSink extends CharSink {
    private final Charset charset;
    
    private AsCharSink(Charset param1Charset) {
      this.charset = (Charset)Preconditions.checkNotNull(param1Charset);
    }
    
    public Writer openStream() throws IOException {
      return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ByteSink.this.toString());
      stringBuilder.append(".asCharSink(");
      stringBuilder.append(this.charset);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\ByteSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */