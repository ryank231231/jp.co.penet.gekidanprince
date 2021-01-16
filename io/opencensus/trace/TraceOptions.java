package io.opencensus.trace;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class TraceOptions {
  public static final TraceOptions DEFAULT = new TraceOptions((byte)0);
  
  private static final byte DEFAULT_OPTIONS = 0;
  
  private static final byte IS_SAMPLED = 1;
  
  public static final int SIZE = 1;
  
  private final byte options;
  
  private TraceOptions(byte paramByte) {
    this.options = (byte)paramByte;
  }
  
  public static Builder builder() {
    return new Builder((byte)0);
  }
  
  public static Builder builder(TraceOptions paramTraceOptions) {
    return new Builder(paramTraceOptions.options);
  }
  
  public static TraceOptions fromBytes(byte[] paramArrayOfbyte) {
    boolean bool;
    Preconditions.checkNotNull(paramArrayOfbyte, "buffer");
    if (paramArrayOfbyte.length == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Invalid size: expected %s, got %s", new Object[] { Integer.valueOf(1), Integer.valueOf(paramArrayOfbyte.length) });
    return new TraceOptions(paramArrayOfbyte[0]);
  }
  
  public static TraceOptions fromBytes(byte[] paramArrayOfbyte, int paramInt) {
    Preconditions.checkElementIndex(paramInt, paramArrayOfbyte.length);
    return new TraceOptions(paramArrayOfbyte[paramInt]);
  }
  
  private boolean hasOption(int paramInt) {
    boolean bool;
    if ((paramInt & this.options) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void copyBytesTo(byte[] paramArrayOfbyte, int paramInt) {
    Preconditions.checkElementIndex(paramInt, paramArrayOfbyte.length);
    paramArrayOfbyte[paramInt] = (byte)this.options;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof TraceOptions))
      return false; 
    paramObject = paramObject;
    if (this.options != ((TraceOptions)paramObject).options)
      bool = false; 
    return bool;
  }
  
  public byte[] getBytes() {
    return new byte[] { this.options };
  }
  
  @VisibleForTesting
  byte getOptions() {
    return this.options;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Byte.valueOf(this.options) });
  }
  
  public boolean isSampled() {
    return hasOption(1);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("sampled", isSampled()).toString();
  }
  
  public static final class Builder {
    private byte options;
    
    private Builder(byte param1Byte) {
      this.options = (byte)param1Byte;
    }
    
    public TraceOptions build() {
      return new TraceOptions(this.options);
    }
    
    @Deprecated
    public Builder setIsSampled() {
      return setIsSampled(true);
    }
    
    public Builder setIsSampled(boolean param1Boolean) {
      if (param1Boolean) {
        this.options = (byte)(byte)(this.options | 0x1);
      } else {
        this.options = (byte)(byte)(this.options & 0xFFFFFFFE);
      } 
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\TraceOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */