package com.google.gson;

import com.google.gson.internal.;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
  private static final Class<?>[] PRIMITIVE_TYPES = new Class[] { 
      int.class, long.class, short.class, float.class, double.class, byte.class, boolean.class, char.class, Integer.class, Long.class, 
      Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  
  private Object value;
  
  public JsonPrimitive(Boolean paramBoolean) {
    setValue(paramBoolean);
  }
  
  public JsonPrimitive(Character paramCharacter) {
    setValue(paramCharacter);
  }
  
  public JsonPrimitive(Number paramNumber) {
    setValue(paramNumber);
  }
  
  JsonPrimitive(Object paramObject) {
    setValue(paramObject);
  }
  
  public JsonPrimitive(String paramString) {
    setValue(paramString);
  }
  
  private static boolean isIntegral(JsonPrimitive paramJsonPrimitive) {
    Object object = paramJsonPrimitive.value;
    boolean bool = object instanceof Number;
    boolean bool1 = false;
    if (bool) {
      object = object;
      if (object instanceof BigInteger || object instanceof Long || object instanceof Integer || object instanceof Short || object instanceof Byte)
        bool1 = true; 
      return bool1;
    } 
    return false;
  }
  
  private static boolean isPrimitiveOrString(Object<?> paramObject) {
    if (paramObject instanceof String)
      return true; 
    paramObject = (Object<?>)paramObject.getClass();
    Class<?>[] arrayOfClass = PRIMITIVE_TYPES;
    int i = arrayOfClass.length;
    for (byte b = 0; b < i; b++) {
      if (arrayOfClass[b].isAssignableFrom((Class<?>)paramObject))
        return true; 
    } 
    return false;
  }
  
  JsonPrimitive deepCopy() {
    return this;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (this == paramObject)
      return true; 
    if (paramObject == null || getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    if (this.value == null) {
      if (((JsonPrimitive)paramObject).value != null)
        bool3 = false; 
      return bool3;
    } 
    if (isIntegral(this) && isIntegral((JsonPrimitive)paramObject)) {
      if (getAsNumber().longValue() == paramObject.getAsNumber().longValue()) {
        bool3 = bool1;
      } else {
        bool3 = false;
      } 
      return bool3;
    } 
    if (this.value instanceof Number && ((JsonPrimitive)paramObject).value instanceof Number) {
      double d1 = getAsNumber().doubleValue();
      double d2 = paramObject.getAsNumber().doubleValue();
      bool3 = bool2;
      if (d1 != d2)
        if (Double.isNaN(d1) && Double.isNaN(d2)) {
          bool3 = bool2;
        } else {
          bool3 = false;
        }  
      return bool3;
    } 
    return this.value.equals(((JsonPrimitive)paramObject).value);
  }
  
  public BigDecimal getAsBigDecimal() {
    Object object = this.value;
    if (object instanceof BigDecimal) {
      object = object;
    } else {
      object = new BigDecimal(object.toString());
    } 
    return (BigDecimal)object;
  }
  
  public BigInteger getAsBigInteger() {
    Object object = this.value;
    if (object instanceof BigInteger) {
      object = object;
    } else {
      object = new BigInteger(object.toString());
    } 
    return (BigInteger)object;
  }
  
  public boolean getAsBoolean() {
    return isBoolean() ? getAsBooleanWrapper().booleanValue() : Boolean.parseBoolean(getAsString());
  }
  
  Boolean getAsBooleanWrapper() {
    return (Boolean)this.value;
  }
  
  public byte getAsByte() {
    byte b;
    if (isNumber()) {
      byte b1 = getAsNumber().byteValue();
      b = b1;
    } else {
      byte b1 = Byte.parseByte(getAsString());
      b = b1;
    } 
    return b;
  }
  
  public char getAsCharacter() {
    return getAsString().charAt(0);
  }
  
  public double getAsDouble() {
    double d;
    if (isNumber()) {
      d = getAsNumber().doubleValue();
    } else {
      d = Double.parseDouble(getAsString());
    } 
    return d;
  }
  
  public float getAsFloat() {
    float f;
    if (isNumber()) {
      f = getAsNumber().floatValue();
    } else {
      f = Float.parseFloat(getAsString());
    } 
    return f;
  }
  
  public int getAsInt() {
    int i;
    if (isNumber()) {
      i = getAsNumber().intValue();
    } else {
      i = Integer.parseInt(getAsString());
    } 
    return i;
  }
  
  public long getAsLong() {
    long l;
    if (isNumber()) {
      l = getAsNumber().longValue();
    } else {
      l = Long.parseLong(getAsString());
    } 
    return l;
  }
  
  public Number getAsNumber() {
    Object object = this.value;
    if (object instanceof String) {
      object = new LazilyParsedNumber((String)object);
    } else {
      object = object;
    } 
    return (Number)object;
  }
  
  public short getAsShort() {
    short s;
    if (isNumber()) {
      short s1 = getAsNumber().shortValue();
      s = s1;
    } else {
      short s1 = Short.parseShort(getAsString());
      s = s1;
    } 
    return s;
  }
  
  public String getAsString() {
    return isNumber() ? getAsNumber().toString() : (isBoolean() ? getAsBooleanWrapper().toString() : (String)this.value);
  }
  
  public int hashCode() {
    if (this.value == null)
      return 31; 
    if (isIntegral(this)) {
      long l = getAsNumber().longValue();
      return (int)(l >>> 32L ^ l);
    } 
    Object object = this.value;
    if (object instanceof Number) {
      long l = Double.doubleToLongBits(getAsNumber().doubleValue());
      return (int)(l >>> 32L ^ l);
    } 
    return object.hashCode();
  }
  
  public boolean isBoolean() {
    return this.value instanceof Boolean;
  }
  
  public boolean isNumber() {
    return this.value instanceof Number;
  }
  
  public boolean isString() {
    return this.value instanceof String;
  }
  
  void setValue(Object paramObject) {
    if (paramObject instanceof Character) {
      this.value = String.valueOf(((Character)paramObject).charValue());
    } else {
      boolean bool;
      if (paramObject instanceof Number || isPrimitiveOrString(paramObject)) {
        bool = true;
      } else {
        bool = false;
      } 
      .Gson.Preconditions.checkArgument(bool);
      this.value = paramObject;
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\gson\JsonPrimitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */