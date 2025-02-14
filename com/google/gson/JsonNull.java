package com.google.gson;

public final class JsonNull extends JsonElement {
  public static final JsonNull INSTANCE = new JsonNull();
  
  JsonNull deepCopy() {
    return INSTANCE;
  }
  
  public boolean equals(Object paramObject) {
    return (this == paramObject || paramObject instanceof JsonNull);
  }
  
  public int hashCode() {
    return JsonNull.class.hashCode();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\JsonNull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */