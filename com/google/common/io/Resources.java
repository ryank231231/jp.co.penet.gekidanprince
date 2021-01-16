package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

@Beta
@GwtIncompatible
public final class Resources {
  public static ByteSource asByteSource(URL paramURL) {
    return new UrlByteSource(paramURL);
  }
  
  public static CharSource asCharSource(URL paramURL, Charset paramCharset) {
    return asByteSource(paramURL).asCharSource(paramCharset);
  }
  
  public static void copy(URL paramURL, OutputStream paramOutputStream) throws IOException {
    asByteSource(paramURL).copyTo(paramOutputStream);
  }
  
  public static URL getResource(Class<?> paramClass, String paramString) {
    boolean bool;
    URL uRL = paramClass.getResource(paramString);
    if (uRL != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "resource %s relative to %s not found.", paramString, paramClass.getName());
    return uRL;
  }
  
  @CanIgnoreReturnValue
  public static URL getResource(String paramString) {
    boolean bool;
    URL uRL = ((ClassLoader)MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(paramString);
    if (uRL != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "resource %s not found.", paramString);
    return uRL;
  }
  
  @CanIgnoreReturnValue
  public static <T> T readLines(URL paramURL, Charset paramCharset, LineProcessor<T> paramLineProcessor) throws IOException {
    return asCharSource(paramURL, paramCharset).readLines(paramLineProcessor);
  }
  
  public static List<String> readLines(URL paramURL, Charset paramCharset) throws IOException {
    return readLines(paramURL, paramCharset, new LineProcessor<List<String>>() {
          final List<String> result = Lists.newArrayList();
          
          public List<String> getResult() {
            return this.result;
          }
          
          public boolean processLine(String param1String) {
            this.result.add(param1String);
            return true;
          }
        });
  }
  
  public static byte[] toByteArray(URL paramURL) throws IOException {
    return asByteSource(paramURL).read();
  }
  
  public static String toString(URL paramURL, Charset paramCharset) throws IOException {
    return asCharSource(paramURL, paramCharset).read();
  }
  
  private static final class UrlByteSource extends ByteSource {
    private final URL url;
    
    private UrlByteSource(URL param1URL) {
      this.url = (URL)Preconditions.checkNotNull(param1URL);
    }
    
    public InputStream openStream() throws IOException {
      return this.url.openStream();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Resources.asByteSource(");
      stringBuilder.append(this.url);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\Resources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */