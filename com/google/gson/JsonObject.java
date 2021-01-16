package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

public final class JsonObject extends JsonElement {
  private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();
  
  private JsonElement createJsonElement(Object paramObject) {
    if (paramObject == null) {
      paramObject = JsonNull.INSTANCE;
    } else {
      paramObject = new JsonPrimitive(paramObject);
    } 
    return (JsonElement)paramObject;
  }
  
  public void add(String paramString, JsonElement paramJsonElement) {
    JsonElement jsonElement = paramJsonElement;
    if (paramJsonElement == null)
      jsonElement = JsonNull.INSTANCE; 
    this.members.put(paramString, jsonElement);
  }
  
  public void addProperty(String paramString, Boolean paramBoolean) {
    add(paramString, createJsonElement(paramBoolean));
  }
  
  public void addProperty(String paramString, Character paramCharacter) {
    add(paramString, createJsonElement(paramCharacter));
  }
  
  public void addProperty(String paramString, Number paramNumber) {
    add(paramString, createJsonElement(paramNumber));
  }
  
  public void addProperty(String paramString1, String paramString2) {
    add(paramString1, createJsonElement(paramString2));
  }
  
  JsonObject deepCopy() {
    JsonObject jsonObject = new JsonObject();
    for (Map.Entry entry : this.members.entrySet())
      jsonObject.add((String)entry.getKey(), ((JsonElement)entry.getValue()).deepCopy()); 
    return jsonObject;
  }
  
  public Set<Map.Entry<String, JsonElement>> entrySet() {
    return this.members.entrySet();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject == this || (paramObject instanceof JsonObject && ((JsonObject)paramObject).members.equals(this.members)));
  }
  
  public JsonElement get(String paramString) {
    return (JsonElement)this.members.get(paramString);
  }
  
  public JsonArray getAsJsonArray(String paramString) {
    return (JsonArray)this.members.get(paramString);
  }
  
  public JsonObject getAsJsonObject(String paramString) {
    return (JsonObject)this.members.get(paramString);
  }
  
  public JsonPrimitive getAsJsonPrimitive(String paramString) {
    return (JsonPrimitive)this.members.get(paramString);
  }
  
  public boolean has(String paramString) {
    return this.members.containsKey(paramString);
  }
  
  public int hashCode() {
    return this.members.hashCode();
  }
  
  public JsonElement remove(String paramString) {
    return (JsonElement)this.members.remove(paramString);
  }
  
  public int size() {
    return this.members.size();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\JsonObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */