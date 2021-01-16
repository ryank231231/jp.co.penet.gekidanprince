package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class JsonParser {
  private static final Logger logger = Logger.getLogger(JsonParser.class.getName());
  
  public static Object parse(String paramString) throws IOException {
    JsonReader jsonReader = new JsonReader(new StringReader(paramString));
    try {
      return parseRecursive(jsonReader);
    } finally {
      try {
        iOException.close();
      } catch (IOException iOException1) {
        logger.log(Level.WARNING, "Failed to close", iOException1);
      } 
    } 
  }
  
  private static List<Object> parseJsonArray(JsonReader paramJsonReader) throws IOException {
    boolean bool;
    paramJsonReader.beginArray();
    ArrayList<Object> arrayList = new ArrayList();
    while (paramJsonReader.hasNext())
      arrayList.add(parseRecursive(paramJsonReader)); 
    if (paramJsonReader.peek() == JsonToken.END_ARRAY) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad token: ");
    stringBuilder.append(paramJsonReader.getPath());
    Preconditions.checkState(bool, stringBuilder.toString());
    paramJsonReader.endArray();
    return Collections.unmodifiableList(arrayList);
  }
  
  private static Void parseJsonNull(JsonReader paramJsonReader) throws IOException {
    paramJsonReader.nextNull();
    return null;
  }
  
  private static Map<String, Object> parseJsonObject(JsonReader paramJsonReader) throws IOException {
    boolean bool;
    paramJsonReader.beginObject();
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    while (paramJsonReader.hasNext())
      linkedHashMap.put(paramJsonReader.nextName(), parseRecursive(paramJsonReader)); 
    if (paramJsonReader.peek() == JsonToken.END_OBJECT) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Bad token: ");
    stringBuilder.append(paramJsonReader.getPath());
    Preconditions.checkState(bool, stringBuilder.toString());
    paramJsonReader.endObject();
    return (Map)Collections.unmodifiableMap(linkedHashMap);
  }
  
  private static Object parseRecursive(JsonReader paramJsonReader) throws IOException {
    StringBuilder stringBuilder;
    Preconditions.checkState(paramJsonReader.hasNext(), "unexpected end of JSON");
    switch (paramJsonReader.peek()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Bad token: ");
        stringBuilder.append(paramJsonReader.getPath());
        throw new IllegalStateException(stringBuilder.toString());
      case NULL:
        return parseJsonNull(paramJsonReader);
      case BOOLEAN:
        return Boolean.valueOf(paramJsonReader.nextBoolean());
      case NUMBER:
        return Double.valueOf(paramJsonReader.nextDouble());
      case STRING:
        return paramJsonReader.nextString();
      case BEGIN_OBJECT:
        return parseJsonObject(paramJsonReader);
      case BEGIN_ARRAY:
        break;
    } 
    return parseJsonArray(paramJsonReader);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */