package io.opencensus.trace;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AttributeValue_AttributeValueBoolean extends AttributeValue.AttributeValueBoolean {
  private final Boolean booleanValue;
  
  AutoValue_AttributeValue_AttributeValueBoolean(Boolean paramBoolean) {
    if (paramBoolean != null) {
      this.booleanValue = paramBoolean;
      return;
    } 
    throw new NullPointerException("Null booleanValue");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AttributeValue.AttributeValueBoolean) {
      paramObject = paramObject;
      return this.booleanValue.equals(paramObject.getBooleanValue());
    } 
    return false;
  }
  
  Boolean getBooleanValue() {
    return this.booleanValue;
  }
  
  public int hashCode() {
    return this.booleanValue.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AttributeValueBoolean{booleanValue=");
    stringBuilder.append(this.booleanValue);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_AttributeValue_AttributeValueBoolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */