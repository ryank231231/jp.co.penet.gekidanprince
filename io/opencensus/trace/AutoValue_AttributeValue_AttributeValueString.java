package io.opencensus.trace;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_AttributeValue_AttributeValueString extends AttributeValue.AttributeValueString {
  private final String stringValue;
  
  AutoValue_AttributeValue_AttributeValueString(String paramString) {
    if (paramString != null) {
      this.stringValue = paramString;
      return;
    } 
    throw new NullPointerException("Null stringValue");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof AttributeValue.AttributeValueString) {
      paramObject = paramObject;
      return this.stringValue.equals(paramObject.getStringValue());
    } 
    return false;
  }
  
  String getStringValue() {
    return this.stringValue;
  }
  
  public int hashCode() {
    return this.stringValue.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AttributeValueString{stringValue=");
    stringBuilder.append(this.stringValue);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_AttributeValue_AttributeValueString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */