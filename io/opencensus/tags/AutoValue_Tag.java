package io.opencensus.tags;

import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_Tag extends Tag {
  private final TagKey key;
  
  private final TagValue value;
  
  AutoValue_Tag(TagKey paramTagKey, TagValue paramTagValue) {
    if (paramTagKey != null) {
      this.key = paramTagKey;
      if (paramTagValue != null) {
        this.value = paramTagValue;
        return;
      } 
      throw new NullPointerException("Null value");
    } 
    throw new NullPointerException("Null key");
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof Tag) {
      paramObject = paramObject;
      if (!this.key.equals(paramObject.getKey()) || !this.value.equals(paramObject.getValue()))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public TagKey getKey() {
    return this.key;
  }
  
  public TagValue getValue() {
    return this.value;
  }
  
  public int hashCode() {
    return (this.key.hashCode() ^ 0xF4243) * 1000003 ^ this.value.hashCode();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Tag{key=");
    stringBuilder.append(this.key);
    stringBuilder.append(", value=");
    stringBuilder.append(this.value);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\tags\AutoValue_Tag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */