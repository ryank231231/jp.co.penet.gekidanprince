package io.opencensus.trace.export;

import io.opencensus.trace.AttributeValue;
import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_SpanData_Attributes extends SpanData.Attributes {
  private final Map<String, AttributeValue> attributeMap;
  
  private final int droppedAttributesCount;
  
  AutoValue_SpanData_Attributes(Map<String, AttributeValue> paramMap, int paramInt) {
    if (paramMap != null) {
      this.attributeMap = paramMap;
      this.droppedAttributesCount = paramInt;
      return;
    } 
    throw new NullPointerException("Null attributeMap");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof SpanData.Attributes) {
      paramObject = paramObject;
      if (!this.attributeMap.equals(paramObject.getAttributeMap()) || this.droppedAttributesCount != paramObject.getDroppedAttributesCount())
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Map<String, AttributeValue> getAttributeMap() {
    return this.attributeMap;
  }
  
  public int getDroppedAttributesCount() {
    return this.droppedAttributesCount;
  }
  
  public int hashCode() {
    return (this.attributeMap.hashCode() ^ 0xF4243) * 1000003 ^ this.droppedAttributesCount;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Attributes{attributeMap=");
    stringBuilder.append(this.attributeMap);
    stringBuilder.append(", droppedAttributesCount=");
    stringBuilder.append(this.droppedAttributesCount);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\export\AutoValue_SpanData_Attributes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */