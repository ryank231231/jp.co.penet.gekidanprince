package io.opencensus.tags;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_TagKey extends TagKey {
  private final String name;
  
  AutoValue_TagKey(String paramString) {
    if (paramString != null) {
      this.name = paramString;
      return;
    } 
    throw new NullPointerException("Null name");
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof TagKey) {
      paramObject = paramObject;
      return this.name.equals(paramObject.getName());
    } 
    return false;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int hashCode() {
    return this.name.hashCode() ^ 0xF4243;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TagKey{name=");
    stringBuilder.append(this.name);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\AutoValue_TagKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */