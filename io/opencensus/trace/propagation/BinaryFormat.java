package io.opencensus.trace.propagation;

import com.google.common.base.Preconditions;
import io.opencensus.trace.SpanContext;
import java.text.ParseException;

public abstract class BinaryFormat {
  static final NoopBinaryFormat NOOP_BINARY_FORMAT = new NoopBinaryFormat();
  
  static BinaryFormat getNoopBinaryFormat() {
    return NOOP_BINARY_FORMAT;
  }
  
  @Deprecated
  public SpanContext fromBinaryValue(byte[] paramArrayOfbyte) throws ParseException {
    try {
      return fromByteArray(paramArrayOfbyte);
    } catch (SpanContextParseException spanContextParseException) {
      throw new ParseException(spanContextParseException.toString(), 0);
    } 
  }
  
  public SpanContext fromByteArray(byte[] paramArrayOfbyte) throws SpanContextParseException {
    try {
      return fromBinaryValue(paramArrayOfbyte);
    } catch (ParseException parseException) {
      throw new SpanContextParseException("Error while parsing.", parseException);
    } 
  }
  
  @Deprecated
  public byte[] toBinaryValue(SpanContext paramSpanContext) {
    return toByteArray(paramSpanContext);
  }
  
  public byte[] toByteArray(SpanContext paramSpanContext) {
    return toBinaryValue(paramSpanContext);
  }
  
  private static final class NoopBinaryFormat extends BinaryFormat {
    private NoopBinaryFormat() {}
    
    public SpanContext fromByteArray(byte[] param1ArrayOfbyte) {
      Preconditions.checkNotNull(param1ArrayOfbyte, "bytes");
      return SpanContext.INVALID;
    }
    
    public byte[] toByteArray(SpanContext param1SpanContext) {
      Preconditions.checkNotNull(param1SpanContext, "spanContext");
      return new byte[0];
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\propagation\BinaryFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */