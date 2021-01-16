package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public final class Headers {
  private final String[] namesAndValues;
  
  private Headers(Builder paramBuilder) {
    this.namesAndValues = (String[])paramBuilder.namesAndValues.toArray((Object[])new String[paramBuilder.namesAndValues.size()]);
  }
  
  private Headers(String[] paramArrayOfString) {
    this.namesAndValues = paramArrayOfString;
  }
  
  private static String get(String[] paramArrayOfString, String paramString) {
    for (int i = paramArrayOfString.length - 2; i >= 0; i -= 2) {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i]))
        return paramArrayOfString[i + 1]; 
    } 
    return null;
  }
  
  public static Headers of(Map<String, String> paramMap) {
    if (paramMap != null) {
      StringBuilder stringBuilder;
      String[] arrayOfString = new String[paramMap.size() * 2];
      Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
      byte b = 0;
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (entry.getKey() != null && entry.getValue() != null) {
          String str1 = ((String)entry.getKey()).trim();
          String str2 = ((String)entry.getValue()).trim();
          if (str1.length() != 0 && str1.indexOf(false) == -1 && str2.indexOf(false) == -1) {
            arrayOfString[b] = str1;
            arrayOfString[b + 1] = str2;
            b += 2;
            continue;
          } 
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unexpected header: ");
          stringBuilder.append(str1);
          stringBuilder.append(": ");
          stringBuilder.append(str2);
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
        throw new IllegalArgumentException("Headers cannot be null");
      } 
      return new Headers((String[])stringBuilder);
    } 
    throw new IllegalArgumentException("Expected map with header names and values");
  }
  
  public static Headers of(String... paramVarArgs) {
    if (paramVarArgs != null && paramVarArgs.length % 2 == 0) {
      StringBuilder stringBuilder;
      String[] arrayOfString = (String[])paramVarArgs.clone();
      byte b = 0;
      while (b < arrayOfString.length) {
        if (arrayOfString[b] != null) {
          arrayOfString[b] = arrayOfString[b].trim();
          b++;
          continue;
        } 
        throw new IllegalArgumentException("Headers cannot be null");
      } 
      b = 0;
      while (b < arrayOfString.length) {
        String str2 = arrayOfString[b];
        String str1 = arrayOfString[b + 1];
        if (str2.length() != 0 && str2.indexOf(false) == -1 && str1.indexOf(false) == -1) {
          b += 2;
          continue;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected header: ");
        stringBuilder.append(str2);
        stringBuilder.append(": ");
        stringBuilder.append(str1);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      return new Headers((String[])stringBuilder);
    } 
    throw new IllegalArgumentException("Expected alternating header names and values");
  }
  
  public String get(String paramString) {
    return get(this.namesAndValues, paramString);
  }
  
  public Date getDate(String paramString) {
    paramString = get(paramString);
    if (paramString != null) {
      Date date = HttpDate.parse(paramString);
    } else {
      paramString = null;
    } 
    return (Date)paramString;
  }
  
  public String name(int paramInt) {
    paramInt *= 2;
    if (paramInt >= 0) {
      String[] arrayOfString = this.namesAndValues;
      if (paramInt < arrayOfString.length)
        return arrayOfString[paramInt]; 
    } 
    return null;
  }
  
  public Set<String> names() {
    TreeSet<String> treeSet = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    int i = size();
    for (byte b = 0; b < i; b++)
      treeSet.add(name(b)); 
    return Collections.unmodifiableSet(treeSet);
  }
  
  public Builder newBuilder() {
    Builder builder = new Builder();
    Collections.addAll(builder.namesAndValues, this.namesAndValues);
    return builder;
  }
  
  public int size() {
    return this.namesAndValues.length / 2;
  }
  
  public Map<String, List<String>> toMultimap() {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    int i = size();
    for (byte b = 0; b < i; b++) {
      String str = name(b);
      List<String> list1 = (List)linkedHashMap.get(str);
      List<String> list2 = list1;
      if (list1 == null) {
        list2 = new ArrayList(2);
        linkedHashMap.put(str, list2);
      } 
      list2.add(value(b));
    } 
    return (Map)linkedHashMap;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    int i = size();
    for (byte b = 0; b < i; b++) {
      stringBuilder.append(name(b));
      stringBuilder.append(": ");
      stringBuilder.append(value(b));
      stringBuilder.append("\n");
    } 
    return stringBuilder.toString();
  }
  
  public String value(int paramInt) {
    paramInt = paramInt * 2 + 1;
    if (paramInt >= 0) {
      String[] arrayOfString = this.namesAndValues;
      if (paramInt < arrayOfString.length)
        return arrayOfString[paramInt]; 
    } 
    return null;
  }
  
  public List<String> values(String paramString) {
    List<?> list;
    int i = size();
    ArrayList<String> arrayList = null;
    byte b = 0;
    while (b < i) {
      ArrayList<String> arrayList1 = arrayList;
      if (paramString.equalsIgnoreCase(name(b))) {
        arrayList1 = arrayList;
        if (arrayList == null)
          arrayList1 = new ArrayList(2); 
        arrayList1.add(value(b));
      } 
      b++;
      arrayList = arrayList1;
    } 
    if (arrayList != null) {
      list = Collections.unmodifiableList(arrayList);
    } else {
      list = Collections.emptyList();
    } 
    return (List)list;
  }
  
  public static final class Builder {
    private final List<String> namesAndValues = new ArrayList<String>(20);
    
    private void checkNameAndValue(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (!param1String1.isEmpty()) {
          int i = param1String1.length();
          byte b = 0;
          while (b < i) {
            char c = param1String1.charAt(b);
            if (c > '\037' && c < '') {
              b++;
              continue;
            } 
            throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(c), Integer.valueOf(b), param1String1 }));
          } 
          if (param1String2 != null) {
            i = param1String2.length();
            b = 0;
            while (b < i) {
              char c = param1String2.charAt(b);
              if (c > '\037' && c < '') {
                b++;
                continue;
              } 
              throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", new Object[] { Integer.valueOf(c), Integer.valueOf(b), param1String2 }));
            } 
            return;
          } 
          throw new IllegalArgumentException("value == null");
        } 
        throw new IllegalArgumentException("name is empty");
      } 
      throw new IllegalArgumentException("name == null");
    }
    
    public Builder add(String param1String) {
      int i = param1String.indexOf(":");
      if (i != -1)
        return add(param1String.substring(0, i).trim(), param1String.substring(i + 1)); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected header: ");
      stringBuilder.append(param1String);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder add(String param1String1, String param1String2) {
      checkNameAndValue(param1String1, param1String2);
      return addLenient(param1String1, param1String2);
    }
    
    Builder addLenient(String param1String) {
      int i = param1String.indexOf(":", 1);
      return (i != -1) ? addLenient(param1String.substring(0, i), param1String.substring(i + 1)) : (param1String.startsWith(":") ? addLenient("", param1String.substring(1)) : addLenient("", param1String));
    }
    
    Builder addLenient(String param1String1, String param1String2) {
      this.namesAndValues.add(param1String1);
      this.namesAndValues.add(param1String2.trim());
      return this;
    }
    
    public Headers build() {
      return new Headers(this);
    }
    
    public String get(String param1String) {
      for (int i = this.namesAndValues.size() - 2; i >= 0; i -= 2) {
        if (param1String.equalsIgnoreCase(this.namesAndValues.get(i)))
          return this.namesAndValues.get(i + 1); 
      } 
      return null;
    }
    
    public Builder removeAll(String param1String) {
      for (int i = 0; i < this.namesAndValues.size(); i = j + 2) {
        int j = i;
        if (param1String.equalsIgnoreCase(this.namesAndValues.get(i))) {
          this.namesAndValues.remove(i);
          this.namesAndValues.remove(i);
          j = i - 2;
        } 
      } 
      return this;
    }
    
    public Builder set(String param1String1, String param1String2) {
      checkNameAndValue(param1String1, param1String2);
      removeAll(param1String1);
      addLenient(param1String1, param1String2);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */