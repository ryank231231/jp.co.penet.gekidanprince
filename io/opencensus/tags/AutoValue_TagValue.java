package io.opencensus.tags;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_TagValue extends TagValue {
  private final String asString;
  
  AutoValue_TagValue(String paramString) {
    if (paramString != null) {
      this.asString = paramString;
      return;
    } 
    throw new NullPointerException("Null asString");
  }
  
  public String asString() {
    return this.asString;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof TagValue) {
      paramObject = paramObject;
      return this.asString.equals(paramObject.asString());
    } 
    return false;
  }
  
  public int hashCode() {
    return this.asString.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TagValue{asString=");
    stringBuilder.append(this.asString);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\AutoValue_TagValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */