package io.opencensus.trace;

import io.opencensus.common.Timestamp;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_NetworkEvent extends NetworkEvent {
  private final long compressedMessageSize;
  
  private final Timestamp kernelTimestamp;
  
  private final long messageId;
  
  private final NetworkEvent.Type type;
  
  private final long uncompressedMessageSize;
  
  private AutoValue_NetworkEvent(@Nullable Timestamp paramTimestamp, NetworkEvent.Type paramType, long paramLong1, long paramLong2, long paramLong3) {
    this.kernelTimestamp = paramTimestamp;
    this.type = paramType;
    this.messageId = paramLong1;
    this.uncompressedMessageSize = paramLong2;
    this.compressedMessageSize = paramLong3;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof NetworkEvent) {
      NetworkEvent networkEvent = (NetworkEvent)paramObject;
      paramObject = this.kernelTimestamp;
      if (((paramObject == null) ? (networkEvent.getKernelTimestamp() == null) : paramObject.equals(networkEvent.getKernelTimestamp())) || !this.type.equals(networkEvent.getType()) || this.messageId != networkEvent.getMessageId() || this.uncompressedMessageSize != networkEvent.getUncompressedMessageSize() || this.compressedMessageSize != networkEvent.getCompressedMessageSize())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public long getCompressedMessageSize() {
    return this.compressedMessageSize;
  }
  
  @Nullable
  public Timestamp getKernelTimestamp() {
    return this.kernelTimestamp;
  }
  
  public long getMessageId() {
    return this.messageId;
  }
  
  public NetworkEvent.Type getType() {
    return this.type;
  }
  
  public long getUncompressedMessageSize() {
    return this.uncompressedMessageSize;
  }
  
  public int hashCode() {
    int i;
    Timestamp timestamp = this.kernelTimestamp;
    if (timestamp == null) {
      i = 0;
    } else {
      i = timestamp.hashCode();
    } 
    long l1 = (((i ^ 0xF4243) * 1000003 ^ this.type.hashCode()) * 1000003);
    long l2 = this.messageId;
    l1 = ((int)(l1 ^ l2 ^ l2 >>> 32L) * 1000003);
    l2 = this.uncompressedMessageSize;
    l2 = ((int)(l1 ^ l2 ^ l2 >>> 32L) * 1000003);
    l1 = this.compressedMessageSize;
    return (int)(l2 ^ l1 ^ l1 >>> 32L);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NetworkEvent{kernelTimestamp=");
    stringBuilder.append(this.kernelTimestamp);
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", messageId=");
    stringBuilder.append(this.messageId);
    stringBuilder.append(", uncompressedMessageSize=");
    stringBuilder.append(this.uncompressedMessageSize);
    stringBuilder.append(", compressedMessageSize=");
    stringBuilder.append(this.compressedMessageSize);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  static final class Builder extends NetworkEvent.Builder {
    private Long compressedMessageSize;
    
    private Timestamp kernelTimestamp;
    
    private Long messageId;
    
    private NetworkEvent.Type type;
    
    private Long uncompressedMessageSize;
    
    public NetworkEvent build() {
      String str1 = "";
      if (this.type == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("");
        stringBuilder1.append(" type");
        str1 = stringBuilder1.toString();
      } 
      String str2 = str1;
      if (this.messageId == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(" messageId");
        str2 = stringBuilder1.toString();
      } 
      str1 = str2;
      if (this.uncompressedMessageSize == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(" uncompressedMessageSize");
        str1 = stringBuilder1.toString();
      } 
      str2 = str1;
      if (this.compressedMessageSize == null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(" compressedMessageSize");
        str2 = stringBuilder1.toString();
      } 
      if (str2.isEmpty())
        return new AutoValue_NetworkEvent(this.kernelTimestamp, this.type, this.messageId.longValue(), this.uncompressedMessageSize.longValue(), this.compressedMessageSize.longValue()); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Missing required properties:");
      stringBuilder.append(str2);
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    public NetworkEvent.Builder setCompressedMessageSize(long param1Long) {
      this.compressedMessageSize = Long.valueOf(param1Long);
      return this;
    }
    
    public NetworkEvent.Builder setKernelTimestamp(@Nullable Timestamp param1Timestamp) {
      this.kernelTimestamp = param1Timestamp;
      return this;
    }
    
    NetworkEvent.Builder setMessageId(long param1Long) {
      this.messageId = Long.valueOf(param1Long);
      return this;
    }
    
    NetworkEvent.Builder setType(NetworkEvent.Type param1Type) {
      if (param1Type != null) {
        this.type = param1Type;
        return this;
      } 
      throw new NullPointerException("Null type");
    }
    
    public NetworkEvent.Builder setUncompressedMessageSize(long param1Long) {
      this.uncompressedMessageSize = Long.valueOf(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_NetworkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */