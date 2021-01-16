package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

@Beta
public final class Funnels {
  public static OutputStream asOutputStream(PrimitiveSink paramPrimitiveSink) {
    return new SinkAsStream(paramPrimitiveSink);
  }
  
  public static Funnel<byte[]> byteArrayFunnel() {
    return ByteArrayFunnel.INSTANCE;
  }
  
  public static Funnel<Integer> integerFunnel() {
    return IntegerFunnel.INSTANCE;
  }
  
  public static Funnel<Long> longFunnel() {
    return LongFunnel.INSTANCE;
  }
  
  public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> paramFunnel) {
    return new SequentialFunnel<E>(paramFunnel);
  }
  
  public static Funnel<CharSequence> stringFunnel(Charset paramCharset) {
    return new StringCharsetFunnel(paramCharset);
  }
  
  public static Funnel<CharSequence> unencodedCharsFunnel() {
    return UnencodedCharsFunnel.INSTANCE;
  }
  
  private enum ByteArrayFunnel implements Funnel<byte[]> {
    INSTANCE;
    
    static {
    
    }
    
    public void funnel(byte[] param1ArrayOfbyte, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.putBytes(param1ArrayOfbyte);
    }
    
    public String toString() {
      return "Funnels.byteArrayFunnel()";
    }
  }
  
  private enum IntegerFunnel implements Funnel<Integer> {
    INSTANCE;
    
    static {
    
    }
    
    public void funnel(Integer param1Integer, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.putInt(param1Integer.intValue());
    }
    
    public String toString() {
      return "Funnels.integerFunnel()";
    }
  }
  
  private enum LongFunnel implements Funnel<Long> {
    INSTANCE;
    
    static {
    
    }
    
    public void funnel(Long param1Long, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.putLong(param1Long.longValue());
    }
    
    public String toString() {
      return "Funnels.longFunnel()";
    }
  }
  
  private static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
    private final Funnel<E> elementFunnel;
    
    SequentialFunnel(Funnel<E> param1Funnel) {
      this.elementFunnel = (Funnel<E>)Preconditions.checkNotNull(param1Funnel);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof SequentialFunnel) {
        param1Object = param1Object;
        return this.elementFunnel.equals(((SequentialFunnel)param1Object).elementFunnel);
      } 
      return false;
    }
    
    public void funnel(Iterable<? extends E> param1Iterable, PrimitiveSink param1PrimitiveSink) {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface iterator : ()Ljava/util/Iterator;
      //   6: astore_1
      //   7: aload_1
      //   8: invokeinterface hasNext : ()Z
      //   13: ifeq -> 37
      //   16: aload_1
      //   17: invokeinterface next : ()Ljava/lang/Object;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield elementFunnel : Lcom/google/common/hash/Funnel;
      //   27: aload_3
      //   28: aload_2
      //   29: invokeinterface funnel : (Ljava/lang/Object;Lcom/google/common/hash/PrimitiveSink;)V
      //   34: goto -> 7
      //   37: return
    }
    
    public int hashCode() {
      return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Funnels.sequentialFunnel(");
      stringBuilder.append(this.elementFunnel);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class SinkAsStream extends OutputStream {
    final PrimitiveSink sink;
    
    SinkAsStream(PrimitiveSink param1PrimitiveSink) {
      this.sink = (PrimitiveSink)Preconditions.checkNotNull(param1PrimitiveSink);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Funnels.asOutputStream(");
      stringBuilder.append(this.sink);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
    
    public void write(int param1Int) {
      this.sink.putByte((byte)param1Int);
    }
    
    public void write(byte[] param1ArrayOfbyte) {
      this.sink.putBytes(param1ArrayOfbyte);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      this.sink.putBytes(param1ArrayOfbyte, param1Int1, param1Int2);
    }
  }
  
  private static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
    private final Charset charset;
    
    StringCharsetFunnel(Charset param1Charset) {
      this.charset = (Charset)Preconditions.checkNotNull(param1Charset);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof StringCharsetFunnel) {
        param1Object = param1Object;
        return this.charset.equals(((StringCharsetFunnel)param1Object).charset);
      } 
      return false;
    }
    
    public void funnel(CharSequence param1CharSequence, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.putString(param1CharSequence, this.charset);
    }
    
    public int hashCode() {
      return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Funnels.stringFunnel(");
      stringBuilder.append(this.charset.name());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
    
    Object writeReplace() {
      return new SerializedForm(this.charset);
    }
    
    private static class SerializedForm implements Serializable {
      private static final long serialVersionUID = 0L;
      
      private final String charsetCanonicalName;
      
      SerializedForm(Charset param2Charset) {
        this.charsetCanonicalName = param2Charset.name();
      }
      
      private Object readResolve() {
        return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
      }
    }
  }
  
  private static class SerializedForm implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private final String charsetCanonicalName;
    
    SerializedForm(Charset param1Charset) {
      this.charsetCanonicalName = param1Charset.name();
    }
    
    private Object readResolve() {
      return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
    }
  }
  
  private enum UnencodedCharsFunnel implements Funnel<CharSequence> {
    INSTANCE;
    
    static {
    
    }
    
    public void funnel(CharSequence param1CharSequence, PrimitiveSink param1PrimitiveSink) {
      param1PrimitiveSink.putUnencodedChars(param1CharSequence);
    }
    
    public String toString() {
      return "Funnels.unencodedCharsFunnel()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\hash\Funnels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */