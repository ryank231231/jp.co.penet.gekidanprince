package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.PrimitiveSink;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

@GwtIncompatible
public abstract class ByteSource {
  public static ByteSource concat(Iterable<? extends ByteSource> paramIterable) {
    return new ConcatenatedByteSource(paramIterable);
  }
  
  public static ByteSource concat(Iterator<? extends ByteSource> paramIterator) {
    return concat((Iterable<? extends ByteSource>)ImmutableList.copyOf(paramIterator));
  }
  
  public static ByteSource concat(ByteSource... paramVarArgs) {
    return concat((Iterable<? extends ByteSource>)ImmutableList.copyOf((Object[])paramVarArgs));
  }
  
  private long countBySkipping(InputStream paramInputStream) throws IOException {
    long l = 0L;
    while (true) {
      long l1 = ByteStreams.skipUpTo(paramInputStream, 2147483647L);
      if (l1 > 0L) {
        l += l1;
        continue;
      } 
      return l;
    } 
  }
  
  public static ByteSource empty() {
    return EmptyByteSource.INSTANCE;
  }
  
  public static ByteSource wrap(byte[] paramArrayOfbyte) {
    return new ByteArrayByteSource(paramArrayOfbyte);
  }
  
  public CharSource asCharSource(Charset paramCharset) {
    return new AsCharSource(paramCharset);
  }
  
  public boolean contentEquals(ByteSource paramByteSource) throws IOException {
    Preconditions.checkNotNull(paramByteSource);
    byte[] arrayOfByte1 = ByteStreams.createBuffer();
    byte[] arrayOfByte2 = ByteStreams.createBuffer();
    Closer closer = Closer.create();
    try {
      InputStream inputStream2 = closer.<InputStream>register(openStream());
      InputStream inputStream1 = closer.<InputStream>register(paramByteSource.openStream());
      while (true) {
        int i = ByteStreams.read(inputStream2, arrayOfByte1, 0, arrayOfByte1.length);
        if (i != ByteStreams.read(inputStream1, arrayOfByte2, 0, arrayOfByte2.length) || !Arrays.equals(arrayOfByte1, arrayOfByte2))
          break; 
        int j = arrayOfByte1.length;
        if (i != j) {
          closer.close();
          return true;
        } 
      } 
      closer.close();
      return false;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramByteSource;
  }
  
  @CanIgnoreReturnValue
  public long copyTo(ByteSink paramByteSink) throws IOException {
    Preconditions.checkNotNull(paramByteSink);
    Closer closer = Closer.create();
    try {
      long l = ByteStreams.copy(closer.<InputStream>register(openStream()), closer.<OutputStream>register(paramByteSink.openStream()));
      closer.close();
      return l;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramByteSink;
  }
  
  @CanIgnoreReturnValue
  public long copyTo(OutputStream paramOutputStream) throws IOException {
    Preconditions.checkNotNull(paramOutputStream);
    Closer closer = Closer.create();
    try {
      long l = ByteStreams.copy(closer.<InputStream>register(openStream()), paramOutputStream);
      closer.close();
      return l;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramOutputStream;
  }
  
  public HashCode hash(HashFunction paramHashFunction) throws IOException {
    Hasher hasher = paramHashFunction.newHasher();
    copyTo(Funnels.asOutputStream((PrimitiveSink)hasher));
    return hasher.hash();
  }
  
  public boolean isEmpty() throws IOException {
    Throwable throwable;
    Optional<Long> optional = sizeIfKnown();
    boolean bool = optional.isPresent();
    boolean bool1 = true;
    if (bool && ((Long)optional.get()).longValue() == 0L)
      return true; 
    Closer closer = Closer.create();
    try {
      int i = ((InputStream)closer.<InputStream>register(openStream())).read();
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
  
  public InputStream openBufferedStream() throws IOException {
    InputStream inputStream = openStream();
    if (inputStream instanceof BufferedInputStream) {
      inputStream = inputStream;
    } else {
      inputStream = new BufferedInputStream(inputStream);
    } 
    return inputStream;
  }
  
  public abstract InputStream openStream() throws IOException;
  
  @Beta
  @CanIgnoreReturnValue
  public <T> T read(ByteProcessor<T> paramByteProcessor) throws IOException {
    Preconditions.checkNotNull(paramByteProcessor);
    Closer closer = Closer.create();
    try {
      paramByteProcessor = ByteStreams.readBytes(closer.<InputStream>register(openStream()), (ByteProcessor)paramByteProcessor);
      closer.close();
      return (T)paramByteProcessor;
    } catch (Throwable throwable) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw paramByteProcessor;
  }
  
  public byte[] read() throws IOException {
    Throwable throwable;
    Closer closer = Closer.create();
    try {
      byte[] arrayOfByte = ByteStreams.toByteArray(closer.<InputStream>register(openStream()));
      closer.close();
      return arrayOfByte;
    } catch (Throwable null) {
      throw closer.rethrow(throwable);
    } finally {}
    closer.close();
    throw throwable;
  }
  
  public long size() throws IOException {
    Optional<Long> optional = sizeIfKnown();
    if (optional.isPresent())
      return ((Long)optional.get()).longValue(); 
    Closer closer = Closer.create();
    try {
      return countBySkipping(closer.<InputStream>register(openStream()));
    } catch (IOException iOException) {
      closer.close();
      closer = Closer.create();
      try {
        return ByteStreams.exhaust(closer.<InputStream>register(openStream()));
      } catch (Throwable throwable) {
        throw closer.rethrow(throwable);
      } finally {}
      closer.close();
      throw iOException;
    } finally {
      closer.close();
    } 
  }
  
  @Beta
  public Optional<Long> sizeIfKnown() {
    return Optional.absent();
  }
  
  public ByteSource slice(long paramLong1, long paramLong2) {
    return new SlicedByteSource(paramLong1, paramLong2);
  }
  
  private final class AsCharSource extends CharSource {
    final Charset charset;
    
    AsCharSource(Charset param1Charset) {
      this.charset = (Charset)Preconditions.checkNotNull(param1Charset);
    }
    
    public ByteSource asByteSource(Charset param1Charset) {
      return param1Charset.equals(this.charset) ? ByteSource.this : super.asByteSource(param1Charset);
    }
    
    public Reader openStream() throws IOException {
      return new InputStreamReader(ByteSource.this.openStream(), this.charset);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ByteSource.this.toString());
      stringBuilder.append(".asCharSource(");
      stringBuilder.append(this.charset);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class ByteArrayByteSource extends ByteSource {
    final byte[] bytes;
    
    final int length;
    
    final int offset;
    
    ByteArrayByteSource(byte[] param1ArrayOfbyte) {
      this(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
    }
    
    ByteArrayByteSource(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.bytes = param1ArrayOfbyte;
      this.offset = param1Int1;
      this.length = param1Int2;
    }
    
    public long copyTo(OutputStream param1OutputStream) throws IOException {
      param1OutputStream.write(this.bytes, this.offset, this.length);
      return this.length;
    }
    
    public HashCode hash(HashFunction param1HashFunction) throws IOException {
      return param1HashFunction.hashBytes(this.bytes, this.offset, this.length);
    }
    
    public boolean isEmpty() {
      boolean bool;
      if (this.length == 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public InputStream openBufferedStream() throws IOException {
      return openStream();
    }
    
    public InputStream openStream() {
      return new ByteArrayInputStream(this.bytes, this.offset, this.length);
    }
    
    public <T> T read(ByteProcessor<T> param1ByteProcessor) throws IOException {
      param1ByteProcessor.processBytes(this.bytes, this.offset, this.length);
      return param1ByteProcessor.getResult();
    }
    
    public byte[] read() {
      byte[] arrayOfByte = this.bytes;
      int i = this.offset;
      return Arrays.copyOfRange(arrayOfByte, i, this.length + i);
    }
    
    public long size() {
      return this.length;
    }
    
    public Optional<Long> sizeIfKnown() {
      return Optional.of(Long.valueOf(this.length));
    }
    
    public ByteSource slice(long param1Long1, long param1Long2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Long1 >= 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "offset (%s) may not be negative", param1Long1);
      if (param1Long2 >= 0L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "length (%s) may not be negative", param1Long2);
      param1Long1 = Math.min(param1Long1, this.length);
      param1Long2 = Math.min(param1Long2, this.length - param1Long1);
      int i = this.offset;
      int j = (int)param1Long1;
      return new ByteArrayByteSource(this.bytes, i + j, (int)param1Long2);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ByteSource.wrap(");
      stringBuilder.append(Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "..."));
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class ConcatenatedByteSource extends ByteSource {
    final Iterable<? extends ByteSource> sources;
    
    ConcatenatedByteSource(Iterable<? extends ByteSource> param1Iterable) {
      this.sources = (Iterable<? extends ByteSource>)Preconditions.checkNotNull(param1Iterable);
    }
    
    public boolean isEmpty() throws IOException {
      Iterator<? extends ByteSource> iterator = this.sources.iterator();
      while (iterator.hasNext()) {
        if (!((ByteSource)iterator.next()).isEmpty())
          return false; 
      } 
      return true;
    }
    
    public InputStream openStream() throws IOException {
      return new MultiInputStream(this.sources.iterator());
    }
    
    public long size() throws IOException {
      Iterator<? extends ByteSource> iterator = this.sources.iterator();
      long l;
      for (l = 0L; iterator.hasNext(); l += ((ByteSource)iterator.next()).size());
      return l;
    }
    
    public Optional<Long> sizeIfKnown() {
      Iterator<? extends ByteSource> iterator = this.sources.iterator();
      long l;
      for (l = 0L; iterator.hasNext(); l += ((Long)optional.get()).longValue()) {
        Optional<Long> optional = ((ByteSource)iterator.next()).sizeIfKnown();
        if (!optional.isPresent())
          return Optional.absent(); 
      } 
      return Optional.of(Long.valueOf(l));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ByteSource.concat(");
      stringBuilder.append(this.sources);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class EmptyByteSource extends ByteArrayByteSource {
    static final EmptyByteSource INSTANCE = new EmptyByteSource();
    
    EmptyByteSource() {
      super(new byte[0]);
    }
    
    public CharSource asCharSource(Charset param1Charset) {
      Preconditions.checkNotNull(param1Charset);
      return CharSource.empty();
    }
    
    public byte[] read() {
      return this.bytes;
    }
    
    public String toString() {
      return "ByteSource.empty()";
    }
  }
  
  private final class SlicedByteSource extends ByteSource {
    final long length;
    
    final long offset;
    
    SlicedByteSource(long param1Long1, long param1Long2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Long1 >= 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "offset (%s) may not be negative", param1Long1);
      if (param1Long2 >= 0L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "length (%s) may not be negative", param1Long2);
      this.offset = param1Long1;
      this.length = param1Long2;
    }
    
    private InputStream sliceStream(InputStream param1InputStream) throws IOException {
      long l = this.offset;
      if (l > 0L)
        try {
          l = ByteStreams.skipUpTo(param1InputStream, l);
          if (l < this.offset) {
            param1InputStream.close();
            return new ByteArrayInputStream(new byte[0]);
          } 
        } catch (Throwable throwable) {
          Closer closer = Closer.create();
          closer.register(param1InputStream);
          try {
            throw closer.rethrow(throwable);
          } finally {
            closer.close();
          } 
        }  
      return ByteStreams.limit(param1InputStream, this.length);
    }
    
    public boolean isEmpty() throws IOException {
      return (this.length == 0L || super.isEmpty());
    }
    
    public InputStream openBufferedStream() throws IOException {
      return sliceStream(ByteSource.this.openBufferedStream());
    }
    
    public InputStream openStream() throws IOException {
      return sliceStream(ByteSource.this.openStream());
    }
    
    public Optional<Long> sizeIfKnown() {
      Optional<Long> optional = ByteSource.this.sizeIfKnown();
      if (optional.isPresent()) {
        long l1 = ((Long)optional.get()).longValue();
        long l2 = Math.min(this.offset, l1);
        return Optional.of(Long.valueOf(Math.min(this.length, l1 - l2)));
      } 
      return Optional.absent();
    }
    
    public ByteSource slice(long param1Long1, long param1Long2) {
      boolean bool2;
      boolean bool1 = true;
      if (param1Long1 >= 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "offset (%s) may not be negative", param1Long1);
      if (param1Long2 >= 0L) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "length (%s) may not be negative", param1Long2);
      long l = this.length;
      return ByteSource.this.slice(this.offset + param1Long1, Math.min(param1Long2, l - param1Long1));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(ByteSource.this.toString());
      stringBuilder.append(".slice(");
      stringBuilder.append(this.offset);
      stringBuilder.append(", ");
      stringBuilder.append(this.length);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\ByteSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */