package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible
public abstract class CharSource {
  public static CharSource concat(Iterable<? extends CharSource> paramIterable) {
    return new ConcatenatedCharSource(paramIterable);
  }
  
  public static CharSource concat(Iterator<? extends CharSource> paramIterator) {
    return concat((Iterable<? extends CharSource>)ImmutableList.copyOf(paramIterator));
  }
  
  public static CharSource concat(CharSource... paramVarArgs) {
    return concat((Iterable<? extends CharSource>)ImmutableList.copyOf((Object[])paramVarArgs));
  }
  
  private long countBySkipping(Reader paramReader) throws IOException {
    long l = 0L;
    while (true) {
      long l1 = paramReader.skip(Long.MAX_VALUE);
      if (l1 != 0L) {
        l += l1;
        continue;
      } 
      return l;
    } 
  }
  
  public static CharSource empty() {
    return EmptyCharSource.INSTANCE;
  }
  
  public static CharSource wrap(CharSequence paramCharSequence) {
    return new CharSequenceCharSource(paramCharSequence);
  }
  
  @Beta
  public ByteSource asByteSource(Charset paramCharset) {
    return new AsByteSource(paramCharset);
  }
  
  @CanIgnoreReturnValue
  public long copyTo(CharSink paramCharSink) throws IOException {
    Preconditions.checkNotNull(paramCharSink);
    Closer closer = Closer.create();
    try {
      long l = CharStreams.copy(closer.<Reader>register(openStream()), closer.<Writer>register(paramCharSink.openStream()));
      closer.close();
      return l;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramCharSink;
  }
  
  @CanIgnoreReturnValue
  public long copyTo(Appendable paramAppendable) throws IOException {
    Preconditions.checkNotNull(paramAppendable);
    Closer closer = Closer.create();
    try {
      long l = CharStreams.copy(closer.<Reader>register(openStream()), paramAppendable);
      closer.close();
      return l;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramAppendable;
  }
  
  public boolean isEmpty() throws IOException {
    Throwable throwable;
    Optional<Long> optional = lengthIfKnown();
    boolean bool = optional.isPresent();
    boolean bool1 = true;
    if (bool && ((Long)optional.get()).longValue() == 0L)
      return true; 
    Closer closer = Closer.create();
    try {
      int i = ((Reader)closer.<Reader>register(openStream())).read();
      if (i != -1)
        bool1 = false; 
      closer.close();
      return bool1;
    } catch (Throwable null) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw throwable;
  }
  
  @Beta
  public long length() throws IOException {
    Throwable throwable;
    Optional<Long> optional = lengthIfKnown();
    if (optional.isPresent())
      return ((Long)optional.get()).longValue(); 
    Closer closer = Closer.create();
    try {
      long l = countBySkipping(closer.<Reader>register(openStream()));
      closer.close();
      return l;
    } catch (Throwable null) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw throwable;
  }
  
  @Beta
  public Optional<Long> lengthIfKnown() {
    return Optional.absent();
  }
  
  public BufferedReader openBufferedStream() throws IOException {
    Reader reader = openStream();
    if (reader instanceof BufferedReader) {
      reader = reader;
    } else {
      reader = new BufferedReader(reader);
    } 
    return (BufferedReader)reader;
  }
  
  public abstract Reader openStream() throws IOException;
  
  public String read() throws IOException {
    Throwable throwable;
    Closer closer = Closer.create();
    try {
      String str = CharStreams.toString(closer.<Reader>register(openStream()));
      closer.close();
      return str;
    } catch (Throwable null) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw throwable;
  }
  
  @Nullable
  public String readFirstLine() throws IOException {
    Throwable throwable;
    Closer closer = Closer.create();
    try {
      String str = ((BufferedReader)closer.<BufferedReader>register(openBufferedStream())).readLine();
      closer.close();
      return str;
    } catch (Throwable null) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw throwable;
  }
  
  public ImmutableList<String> readLines() throws IOException {
    Throwable throwable;
    Closer closer = Closer.create();
    try {
      BufferedReader bufferedReader = closer.<BufferedReader>register(openBufferedStream());
      ArrayList<String> arrayList = Lists.newArrayList();
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          arrayList.add(str);
          continue;
        } 
        ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList);
        closer.close();
        return immutableList;
      } 
    } catch (Throwable null) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw throwable;
  }
  
  @Beta
  @CanIgnoreReturnValue
  public <T> T readLines(LineProcessor<T> paramLineProcessor) throws IOException {
    Preconditions.checkNotNull(paramLineProcessor);
    Closer closer = Closer.create();
    try {
      paramLineProcessor = CharStreams.readLines(closer.<Reader>register(openStream()), (LineProcessor)paramLineProcessor);
      closer.close();
      return (T)paramLineProcessor;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramLineProcessor;
  }
  
  private final class AsByteSource extends ByteSource {
    final Charset charset;
    
    AsByteSource(Charset param1Charset) {
      this.charset = (Charset)Preconditions.checkNotNull(param1Charset);
    }
    
    public CharSource asCharSource(Charset param1Charset) {
      return param1Charset.equals(this.charset) ? CharSource.this : super.asCharSource(param1Charset);
    }
    
    public InputStream openStream() throws IOException {
      return new ReaderInputStream(CharSource.this.openStream(), this.charset, 8192);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(CharSource.this.toString());
      stringBuilder.append(".asByteSource(");
      stringBuilder.append(this.charset);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class CharSequenceCharSource extends CharSource {
    private static final Splitter LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
    
    private final CharSequence seq;
    
    protected CharSequenceCharSource(CharSequence param1CharSequence) {
      this.seq = (CharSequence)Preconditions.checkNotNull(param1CharSequence);
    }
    
    private Iterable<String> lines() {
      return new Iterable<String>() {
          public Iterator<String> iterator() {
            return (Iterator<String>)new AbstractIterator<String>() {
                Iterator<String> lines = CharSource.CharSequenceCharSource.LINE_SPLITTER.split(CharSource.CharSequenceCharSource.this.seq).iterator();
                
                protected String computeNext() {
                  if (this.lines.hasNext()) {
                    String str = this.lines.next();
                    if (this.lines.hasNext() || !str.isEmpty())
                      return str; 
                  } 
                  return (String)endOfData();
                }
              };
          }
        };
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.seq.length() == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public long length() {
      return this.seq.length();
    }
    
    public Optional<Long> lengthIfKnown() {
      return Optional.of(Long.valueOf(this.seq.length()));
    }
    
    public Reader openStream() {
      return new CharSequenceReader(this.seq);
    }
    
    public String read() {
      return this.seq.toString();
    }
    
    public String readFirstLine() {
      Iterator<String> iterator = lines().iterator();
      if (iterator.hasNext()) {
        String str = iterator.next();
      } else {
        iterator = null;
      } 
      return (String)iterator;
    }
    
    public ImmutableList<String> readLines() {
      return ImmutableList.copyOf(lines());
    }
    
    public <T> T readLines(LineProcessor<T> param1LineProcessor) throws IOException {
      Iterator<String> iterator = lines().iterator();
      do {
      
      } while (iterator.hasNext() && param1LineProcessor.processLine(iterator.next()));
      return param1LineProcessor.getResult();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharSource.wrap(");
      stringBuilder.append(Ascii.truncate(this.seq, 30, "..."));
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  class null implements Iterable<String> {
    public Iterator<String> iterator() {
      return (Iterator<String>)new AbstractIterator<String>() {
          Iterator<String> lines = CharSource.CharSequenceCharSource.LINE_SPLITTER.split(this.this$1.this$0.seq).iterator();
          
          protected String computeNext() {
            if (this.lines.hasNext()) {
              String str = this.lines.next();
              if (this.lines.hasNext() || !str.isEmpty())
                return str; 
            } 
            return (String)endOfData();
          }
        };
    }
  }
  
  class null extends AbstractIterator<String> {
    Iterator<String> lines = CharSource.CharSequenceCharSource.LINE_SPLITTER.split(this.this$1.this$0.seq).iterator();
    
    protected String computeNext() {
      if (this.lines.hasNext()) {
        String str = this.lines.next();
        if (this.lines.hasNext() || !str.isEmpty())
          return str; 
      } 
      return (String)endOfData();
    }
  }
  
  private static final class ConcatenatedCharSource extends CharSource {
    private final Iterable<? extends CharSource> sources;
    
    ConcatenatedCharSource(Iterable<? extends CharSource> param1Iterable) {
      this.sources = (Iterable<? extends CharSource>)Preconditions.checkNotNull(param1Iterable);
    }
    
    public boolean isEmpty() throws IOException {
      Iterator<? extends CharSource> iterator = this.sources.iterator();
      while (iterator.hasNext()) {
        if (!((CharSource)iterator.next()).isEmpty())
          return false; 
      } 
      return true;
    }
    
    public long length() throws IOException {
      Iterator<? extends CharSource> iterator = this.sources.iterator();
      long l;
      for (l = 0L; iterator.hasNext(); l += ((CharSource)iterator.next()).length());
      return l;
    }
    
    public Optional<Long> lengthIfKnown() {
      Iterator<? extends CharSource> iterator = this.sources.iterator();
      long l;
      for (l = 0L; iterator.hasNext(); l += ((Long)optional.get()).longValue()) {
        Optional<Long> optional = ((CharSource)iterator.next()).lengthIfKnown();
        if (!optional.isPresent())
          return Optional.absent(); 
      } 
      return Optional.of(Long.valueOf(l));
    }
    
    public Reader openStream() throws IOException {
      return new MultiReader(this.sources.iterator());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharSource.concat(");
      stringBuilder.append(this.sources);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class EmptyCharSource extends CharSequenceCharSource {
    private static final EmptyCharSource INSTANCE = new EmptyCharSource();
    
    private EmptyCharSource() {
      super("");
    }
    
    public String toString() {
      return "CharSource.empty()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\CharSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */