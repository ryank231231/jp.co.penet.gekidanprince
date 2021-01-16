package io.opencensus.trace;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AttributeValue_AttributeValueLong extends AttributeValue.AttributeValueLong {
  private final Long longValue;
  
  AutoValue_AttributeValue_AttributeValueLong(Long paramLong) {
    if (paramLong != null) {
      this.longValue = paramLong;
      return;
    } 
    throw new NullPointerException("Null longValue");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AttributeValue.AttributeValueLong) {
      paramObject = paramObject;
      return this.longValue.equals(paramObject.getLongValue());
    } 
    return false;
  }
  
  Long getLongValue() {
    return this.longValue;
  }
  
  public int hashCode() {
    return this.longValue.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AttributeValueLong{longValue=");
    stringBuilder.append(this.longValue);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_AttributeValue_AttributeValueLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */