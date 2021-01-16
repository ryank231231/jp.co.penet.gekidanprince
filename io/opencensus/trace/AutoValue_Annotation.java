package io.opencensus.trace;

import java.util.Map;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Annotation extends Annotation {
  private final Map<String, AttributeValue> attributes;
  
  private final String description;
  
  AutoValue_Annotation(String paramString, Map<String, AttributeValue> paramMap) {
    if (paramString != null) {
      this.description = paramString;
      if (paramMap != null) {
        this.attributes = paramMap;
        return;
      } 
      throw new NullPointerException("Null attributes");
    } 
    throw new NullPointerException("Null description");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Annotation) {
      paramObject = paramObject;
      if (!this.description.equals(paramObject.getDescription()) || !this.attributes.equals(paramObject.getAttributes()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public Map<String, AttributeValue> getAttributes() {
    return this.attributes;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public int hashCode() {
    return (this.description.hashCode() ^ 0xF4243) * 1000003 ^ this.attributes.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Annotation{description=");
    stringBuilder.append(this.description);
    stringBuilder.append(", attributes=");
    stringBuilder.append(this.attributes);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AutoValue_Annotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */