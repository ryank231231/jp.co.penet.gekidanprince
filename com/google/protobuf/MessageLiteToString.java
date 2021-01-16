package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class MessageLiteToString {
  private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
  
  private static final String BYTES_SUFFIX = "Bytes";
  
  private static final String LIST_SUFFIX = "List";
  
  private static final String camelCaseToSnakeCase(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (byte b = 0; b < paramString.length(); b++) {
      char c = paramString.charAt(b);
      if (Character.isUpperCase(c))
        stringBuilder.append("_"); 
      stringBuilder.append(Character.toLowerCase(c));
    } 
    return stringBuilder.toString();
  }
  
  private static boolean isDefaultValue(Object paramObject) {
    boolean bool = paramObject instanceof Boolean;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    if (bool)
      return ((Boolean)paramObject).booleanValue() ^ true; 
    if (paramObject instanceof Integer) {
      if (((Integer)paramObject).intValue() != 0)
        bool5 = false; 
      return bool5;
    } 
    if (paramObject instanceof Float) {
      if (((Float)paramObject).floatValue() == 0.0F) {
        bool5 = bool1;
      } else {
        bool5 = false;
      } 
      return bool5;
    } 
    if (paramObject instanceof Double) {
      if (((Double)paramObject).doubleValue() == 0.0D) {
        bool5 = bool2;
      } else {
        bool5 = false;
      } 
      return bool5;
    } 
    if (paramObject instanceof String)
      return paramObject.equals(""); 
    if (paramObject instanceof ByteString)
      return paramObject.equals(ByteString.EMPTY); 
    if (paramObject instanceof MessageLite) {
      if (paramObject == ((MessageLite)paramObject).getDefaultInstanceForType()) {
        bool5 = bool3;
      } else {
        bool5 = false;
      } 
      return bool5;
    } 
    if (paramObject instanceof java.lang.Enum) {
      if (((java.lang.Enum)paramObject).ordinal() == 0) {
        bool5 = bool4;
      } else {
        bool5 = false;
      } 
      return bool5;
    } 
    return false;
  }
  
  static final void printField(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject) {
    if (paramObject instanceof List) {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext())
        printField(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    paramStringBuilder.append('\n');
    boolean bool = false;
    byte b;
    for (b = 0; b < paramInt; b++)
      paramStringBuilder.append(' '); 
    paramStringBuilder.append(paramString);
    if (paramObject instanceof String) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.escapeText((String)paramObject));
      paramStringBuilder.append('"');
    } else if (paramObject instanceof ByteString) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.escapeBytes((ByteString)paramObject));
      paramStringBuilder.append('"');
    } else if (paramObject instanceof GeneratedMessageLite) {
      paramStringBuilder.append(" {");
      reflectivePrintWithIndent((GeneratedMessageLite)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      for (b = bool; b < paramInt; b++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
    } else {
      paramStringBuilder.append(": ");
      paramStringBuilder.append(paramObject.toString());
    } 
  }
  
  private static void reflectivePrintWithIndent(MessageLite paramMessageLite, StringBuilder paramStringBuilder, int paramInt) {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    TreeSet<String> treeSet = new TreeSet();
    for (Method method : paramMessageLite.getClass().getDeclaredMethods()) {
      hashMap2.put(method.getName(), method);
      if ((method.getParameterTypes()).length == 0) {
        hashMap1.put(method.getName(), method);
        if (method.getName().startsWith("get"))
          treeSet.add(method.getName()); 
      } 
    } 
    Iterator<String> iterator = treeSet.iterator();
    while (iterator.hasNext()) {
      String str1 = ((String)iterator.next()).replaceFirst("get", "");
      if (str1.endsWith("List") && !str1.endsWith("OrBuilderList")) {
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(str1.substring(0, 1).toLowerCase());
        stringBuilder4.append(str1.substring(1, str1.length() - 4));
        String str = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("get");
        stringBuilder5.append(str1);
        Method method = (Method)hashMap1.get(stringBuilder5.toString());
        if (method != null) {
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase(str), GeneratedMessageLite.invokeOrDie(method, paramMessageLite, new Object[0]));
          continue;
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("set");
      stringBuilder1.append(str1);
      if ((Method)hashMap2.get(stringBuilder1.toString()) == null)
        continue; 
      if (str1.endsWith("Bytes")) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(str1.substring(0, str1.length() - 5));
        if (hashMap1.containsKey(stringBuilder1.toString()))
          continue; 
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1.substring(0, 1).toLowerCase());
      stringBuilder1.append(str1.substring(1));
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(str1);
      Method method2 = (Method)hashMap1.get(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("has");
      stringBuilder3.append(str1);
      Method method1 = (Method)hashMap1.get(stringBuilder3.toString());
      if (method2 != null) {
        boolean bool;
        Object object = GeneratedMessageLite.invokeOrDie(method2, paramMessageLite, new Object[0]);
        if (method1 == null) {
          if (!isDefaultValue(object)) {
            bool = true;
          } else {
            bool = false;
          } 
        } else {
          bool = ((Boolean)GeneratedMessageLite.invokeOrDie(method1, paramMessageLite, new Object[0])).booleanValue();
        } 
        if (bool)
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase(str2), object); 
      } 
    } 
    if (paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage)
      for (Map.Entry entry : ((GeneratedMessageLite.ExtendableMessage)paramMessageLite).extensions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(((GeneratedMessageLite.ExtensionDescriptor)entry.getKey()).getNumber());
        stringBuilder.append("]");
        printField(paramStringBuilder, paramInt, stringBuilder.toString(), entry.getValue());
      }  
    paramMessageLite = paramMessageLite;
    if (((GeneratedMessageLite)paramMessageLite).unknownFields != null)
      ((GeneratedMessageLite)paramMessageLite).unknownFields.printWithIndent(paramStringBuilder, paramInt); 
  }
  
  static String toString(MessageLite paramMessageLite, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("# ");
    stringBuilder.append(paramString);
    reflectivePrintWithIndent(paramMessageLite, stringBuilder, 0);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\MessageLiteToString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */