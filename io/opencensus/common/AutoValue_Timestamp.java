package io.opencensus.common;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Timestamp extends Timestamp {
  private final int nanos;
  
  private final long seconds;
  
  AutoValue_Timestamp(long paramLong, int paramInt) {
    this.seconds = paramLong;
    this.nanos = paramInt;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Timestamp) {
      paramObject = paramObject;
      if (this.seconds != paramObject.getSeconds() || this.nanos != paramObject.getNanos())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int getNanos() {
    return this.nanos;
  }
  
  public long getSeconds() {
    return this.seconds;
  }
  
  public int hashCode() {
    long l1 = 1000003L;
    long l2 = this.seconds;
    int i = (int)(l1 ^ l2 ^ l2 >>> 32L);
    return this.nanos ^ i * 1000003;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Timestamp{seconds=");
    stringBuilder.append(this.seconds);
    stringBuilder.append(", nanos=");
    stringBuilder.append(this.nanos);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\common\AutoValue_Timestamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */