package io.opencensus.trace;

import com.google.common.base.Preconditions;
import io.opencensus.common.Timestamp;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class NetworkEvent {
  public static Builder builder(Type paramType, long paramLong) {
    return (new AutoValue_NetworkEvent.Builder()).setType((Type)Preconditions.checkNotNull(paramType, "type")).setMessageId(paramLong).setUncompressedMessageSize(0L).setCompressedMessageSize(0L);
  }
  
  public abstract long getCompressedMessageSize();
  
  @Nullable
  public abstract Timestamp getKernelTimestamp();
  
  public abstract long getMessageId();
  
  @Deprecated
  public long getMessageSize() {
    return getUncompressedMessageSize();
  }
  
  public abstract Type getType();
  
  public abstract long getUncompressedMessageSize();
  
  public static abstract class Builder {
    public abstract NetworkEvent build();
    
    public abstract Builder setCompressedMessageSize(long param1Long);
    
    public abstract Builder setKernelTimestamp(@Nullable Timestamp param1Timestamp);
    
    abstract Builder setMessageId(long param1Long);
    
    @Deprecated
    public Builder setMessageSize(long param1Long) {
      return setUncompressedMessageSize(param1Long);
    }
    
    abstract Builder setType(NetworkEvent.Type param1Type);
    
    public abstract Builder setUncompressedMessageSize(long param1Long);
  }
  
  public enum Type {
    RECV, SENT;
    
    static {
      $VALUES = new Type[] { SENT, RECV };
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\NetworkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */