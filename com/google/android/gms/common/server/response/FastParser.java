package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@KeepForSdk
@ShowFirstParty
public class FastParser<T extends FastJsonResponse> {
  private static final char[] zaqf = new char[] { 'u', 'l', 'l' };
  
  private static final char[] zaqg = new char[] { 'r', 'u', 'e' };
  
  private static final char[] zaqh = new char[] { 'r', 'u', 'e', '"' };
  
  private static final char[] zaqi = new char[] { 'a', 'l', 's', 'e' };
  
  private static final char[] zaqj = new char[] { 'a', 'l', 's', 'e', '"' };
  
  private static final char[] zaqk = new char[] { '\n' };
  
  private static final zaa<Integer> zaqm = new zaa();
  
  private static final zaa<Long> zaqn = new zab();
  
  private static final zaa<Float> zaqo = new zac();
  
  private static final zaa<Double> zaqp = new zad();
  
  private static final zaa<Boolean> zaqq = new zae();
  
  private static final zaa<String> zaqr = new zaf();
  
  private static final zaa<BigInteger> zaqs = new zag();
  
  private static final zaa<BigDecimal> zaqt = new zah();
  
  private final char[] zaqa = new char[1];
  
  private final char[] zaqb = new char[32];
  
  private final char[] zaqc = new char[1024];
  
  private final StringBuilder zaqd = new StringBuilder(32);
  
  private final StringBuilder zaqe = new StringBuilder(1024);
  
  private final Stack<Integer> zaql = new Stack<Integer>();
  
  private final int zaa(BufferedReader paramBufferedReader, char[] paramArrayOfchar) throws ParseException, IOException {
    char c = zaj(paramBufferedReader);
    if (c != '\000') {
      if (c != ',') {
        char c1;
        if (c == 'n') {
          zab(paramBufferedReader, zaqf);
          return 0;
        } 
        paramBufferedReader.mark(1024);
        if (c == '"') {
          c = Character.MIN_VALUE;
          int i = 0;
          while (true) {
            c1 = c;
            if (c < paramArrayOfchar.length) {
              c1 = c;
              if (paramBufferedReader.read(paramArrayOfchar, c, 1) != -1) {
                char c2 = paramArrayOfchar[c];
                if (!Character.isISOControl(c2)) {
                  if (c2 == '"' && !i) {
                    paramBufferedReader.reset();
                    paramBufferedReader.skip((c + 1));
                    return c;
                  } 
                  if (c2 == '\\') {
                    i ^= 0x1;
                  } else {
                    i = 0;
                  } 
                  c++;
                  continue;
                } 
                throw new ParseException("Unexpected control character while reading string");
              } 
            } 
            break;
          } 
        } else {
          paramArrayOfchar[0] = (char)c;
          c = '\001';
          while (true) {
            c1 = c;
            if (c < paramArrayOfchar.length) {
              c1 = c;
              if (paramBufferedReader.read(paramArrayOfchar, c, 1) != -1) {
                if (paramArrayOfchar[c] == '}' || paramArrayOfchar[c] == ',' || Character.isWhitespace(paramArrayOfchar[c]) || paramArrayOfchar[c] == ']') {
                  paramBufferedReader.reset();
                  paramBufferedReader.skip((c - 1));
                  paramArrayOfchar[c] = (char)Character.MIN_VALUE;
                  return c;
                } 
                c++;
                continue;
              } 
            } 
            break;
          } 
        } 
        if (c1 == paramArrayOfchar.length)
          throw new ParseException("Absurdly long value"); 
        throw new ParseException("Unexpected EOF");
      } 
      throw new ParseException("Missing value");
    } 
    throw new ParseException("Unexpected EOF");
  }
  
  private final String zaa(BufferedReader paramBufferedReader) throws ParseException, IOException {
    StringBuilder stringBuilder;
    this.zaql.push(Integer.valueOf(2));
    char c = zaj(paramBufferedReader);
    if (c != '"') {
      if (c != ']') {
        if (c == '}') {
          zak(2);
          return null;
        } 
        stringBuilder = new StringBuilder(19);
        stringBuilder.append("Unexpected token: ");
        stringBuilder.append(c);
        throw new ParseException(stringBuilder.toString());
      } 
      zak(2);
      zak(1);
      zak(5);
      return null;
    } 
    this.zaql.push(Integer.valueOf(3));
    String str = zab((BufferedReader)stringBuilder, this.zaqb, this.zaqd, null);
    zak(3);
    if (zaj((BufferedReader)stringBuilder) == ':')
      return str; 
    throw new ParseException("Expected key/value separator");
  }
  
  private final String zaa(BufferedReader paramBufferedReader, char[] paramArrayOfchar1, StringBuilder paramStringBuilder, char[] paramArrayOfchar2) throws ParseException, IOException {
    char c = zaj(paramBufferedReader);
    if (c != '"') {
      if (c == 'n') {
        zab(paramBufferedReader, zaqf);
        return null;
      } 
      throw new ParseException("Expected string");
    } 
    return zab(paramBufferedReader, paramArrayOfchar1, paramStringBuilder, paramArrayOfchar2);
  }
  
  private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField) throws ParseException, IOException {
    ArrayList<FastJsonResponse> arrayList = new ArrayList();
    char c = zaj(paramBufferedReader);
    if (c != ']') {
      StringBuilder stringBuilder;
      if (c != 'n') {
        if (c == '{') {
          this.zaql.push(Integer.valueOf(1));
          try {
            while (true) {
              FastJsonResponse fastJsonResponse = paramField.zacp();
              if (zaa(paramBufferedReader, fastJsonResponse)) {
                StringBuilder stringBuilder1;
                arrayList.add(fastJsonResponse);
                c = zaj(paramBufferedReader);
                if (c != ',') {
                  if (c == ']') {
                    zak(5);
                    return (ArrayList)arrayList;
                  } 
                  stringBuilder1 = new StringBuilder(19);
                  stringBuilder1.append("Unexpected token: ");
                  stringBuilder1.append(c);
                  throw new ParseException(stringBuilder1.toString());
                } 
                if (zaj((BufferedReader)stringBuilder1) == '{') {
                  this.zaql.push(Integer.valueOf(1));
                  continue;
                } 
                throw new ParseException("Expected start of next object in array");
              } 
              return (ArrayList)arrayList;
            } 
          } catch (InstantiationException instantiationException) {
            throw new ParseException("Error instantiating inner object", instantiationException);
          } catch (IllegalAccessException illegalAccessException) {
            throw new ParseException("Error instantiating inner object", illegalAccessException);
          } 
        } 
        stringBuilder = new StringBuilder(19);
        stringBuilder.append("Unexpected token: ");
        stringBuilder.append(c);
        throw new ParseException(stringBuilder.toString());
      } 
      zab((BufferedReader)stringBuilder, zaqf);
      zak(5);
      return null;
    } 
    zak(5);
    return (ArrayList)arrayList;
  }
  
  private final <O> ArrayList<O> zaa(BufferedReader paramBufferedReader, zaa<O> paramzaa) throws ParseException, IOException {
    char c = zaj(paramBufferedReader);
    if (c == 'n') {
      zab(paramBufferedReader, zaqf);
      return null;
    } 
    if (c == '[') {
      this.zaql.push(Integer.valueOf(5));
      ArrayList<O> arrayList = new ArrayList();
      while (true) {
        paramBufferedReader.mark(1024);
        c = zaj(paramBufferedReader);
        if (c != '\000') {
          if (c != ',') {
            if (c != ']') {
              paramBufferedReader.reset();
              arrayList.add(paramzaa.zah(this, paramBufferedReader));
              continue;
            } 
            zak(5);
            return arrayList;
          } 
          continue;
        } 
        throw new ParseException("Unexpected EOF");
      } 
    } 
    throw new ParseException("Expected start of array");
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse) throws ParseException, IOException {
    Map<String, FastJsonResponse.Field<?, ?>> map = paramFastJsonResponse.getFieldMappings();
    String str = zaa(paramBufferedReader);
    if (str == null) {
      zak(1);
      return false;
    } 
    while (str != null) {
      StringBuilder stringBuilder2;
      StringBuilder stringBuilder1;
      HashMap<Object, Object> hashMap;
      int i;
      FastJsonResponse.Field<?, ?> field = map.get(str);
      if (field == null) {
        str = zab(paramBufferedReader);
        continue;
      } 
      this.zaql.push(Integer.valueOf(4));
      switch (field.zapq) {
        default:
          i = field.zapq;
          stringBuilder2 = new StringBuilder(30);
          stringBuilder2.append("Invalid field type ");
          stringBuilder2.append(i);
          throw new ParseException(stringBuilder2.toString());
        case 11:
          if (field.zapr) {
            i = zaj((BufferedReader)stringBuilder2);
            if (i == 110) {
              zab((BufferedReader)stringBuilder2, zaqf);
              paramFastJsonResponse.addConcreteTypeArrayInternal(field, field.zapu, null);
              break;
            } 
            this.zaql.push(Integer.valueOf(5));
            if (i == 91) {
              paramFastJsonResponse.addConcreteTypeArrayInternal(field, field.zapu, zaa((BufferedReader)stringBuilder2, field));
              break;
            } 
            throw new ParseException("Expected array start");
          } 
          i = zaj((BufferedReader)stringBuilder2);
          if (i == 110) {
            zab((BufferedReader)stringBuilder2, zaqf);
            paramFastJsonResponse.addConcreteTypeInternal(field, field.zapu, null);
            break;
          } 
          this.zaql.push(Integer.valueOf(1));
          if (i == 123) {
            try {
              FastJsonResponse fastJsonResponse = field.zacp();
              zaa((BufferedReader)stringBuilder2, fastJsonResponse);
              paramFastJsonResponse.addConcreteTypeInternal(field, field.zapu, fastJsonResponse);
            } catch (InstantiationException instantiationException) {
              throw new ParseException("Error instantiating inner object", instantiationException);
            } catch (IllegalAccessException illegalAccessException) {
              throw new ParseException("Error instantiating inner object", illegalAccessException);
            } 
            break;
          } 
          throw new ParseException("Expected start of object");
        case 10:
          i = zaj((BufferedReader)illegalAccessException);
          if (i == 110) {
            zab((BufferedReader)illegalAccessException, zaqf);
            str = null;
          } else {
            if (i == 123) {
              this.zaql.push(Integer.valueOf(1));
              hashMap = new HashMap<Object, Object>();
              while (true) {
                i = zaj((BufferedReader)illegalAccessException);
                if (i != 0) {
                  String str2;
                  if (i != 34) {
                    if (i != 125)
                      continue; 
                    zak(1);
                    continue;
                  } 
                  String str3 = zab((BufferedReader)illegalAccessException, this.zaqb, this.zaqd, null);
                  if (zaj((BufferedReader)illegalAccessException) != ':') {
                    str2 = String.valueOf(str3);
                    if (str2.length() != 0) {
                      str2 = "No map value found for key ".concat(str2);
                    } else {
                      str2 = new String("No map value found for key ");
                    } 
                    throw new ParseException(str2);
                  } 
                  if (zaj((BufferedReader)str2) != '"') {
                    str2 = String.valueOf(str3);
                    if (str2.length() != 0) {
                      str2 = "Expected String value for key ".concat(str2);
                    } else {
                      str2 = new String("Expected String value for key ");
                    } 
                    throw new ParseException(str2);
                  } 
                  hashMap.put(str3, zab((BufferedReader)str2, this.zaqb, this.zaqd, null));
                  char c1 = zaj((BufferedReader)str2);
                  if (c1 != ',') {
                    if (c1 == '}') {
                      zak(1);
                    } else {
                      stringBuilder1 = new StringBuilder(48);
                      stringBuilder1.append("Unexpected character while parsing string map: ");
                      stringBuilder1.append(c1);
                      throw new ParseException(stringBuilder1.toString());
                    } 
                  } else {
                    continue;
                  } 
                } else {
                  throw new ParseException("Unexpected EOF");
                } 
                paramFastJsonResponse.zaa((FastJsonResponse.Field)field, (Map)hashMap);
                break;
              } 
            } 
            throw new ParseException("Expected start of a map object");
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, (Map)hashMap);
          break;
        case 9:
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, Base64Utils.decodeUrlSafe(zaa((BufferedReader)stringBuilder1, this.zaqc, this.zaqe, zaqk)));
          break;
        case 8:
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, Base64Utils.decode(zaa((BufferedReader)stringBuilder1, this.zaqc, this.zaqe, zaqk)));
          break;
        case 7:
          if (field.zapr) {
            paramFastJsonResponse.zah((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqr));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zac((BufferedReader)stringBuilder1));
          break;
        case 6:
          if (field.zapr) {
            paramFastJsonResponse.zag((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqq));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, false));
          break;
        case 5:
          if (field.zapr) {
            paramFastJsonResponse.zaf((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqt));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zai((BufferedReader)stringBuilder1));
          break;
        case 4:
          if (field.zapr) {
            paramFastJsonResponse.zae((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqp));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zah((BufferedReader)stringBuilder1));
          break;
        case 3:
          if (field.zapr) {
            paramFastJsonResponse.zad((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqo));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zag((BufferedReader)stringBuilder1));
          break;
        case 2:
          if (field.zapr) {
            paramFastJsonResponse.zac((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqn));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zae((BufferedReader)stringBuilder1));
          break;
        case 1:
          if (field.zapr) {
            paramFastJsonResponse.zab((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqs));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zaf((BufferedReader)stringBuilder1));
          break;
        case 0:
          if (field.zapr) {
            paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaqm));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zad((BufferedReader)stringBuilder1));
          break;
      } 
      zak(4);
      zak(2);
      char c = zaj((BufferedReader)stringBuilder1);
      if (c != ',') {
        if (c == '}') {
          hashMap = null;
          continue;
        } 
        stringBuilder1 = new StringBuilder(55);
        stringBuilder1.append("Expected end of object or field separator, but found: ");
        stringBuilder1.append(c);
        throw new ParseException(stringBuilder1.toString());
      } 
      String str1 = zaa((BufferedReader)stringBuilder1);
    } 
    zak(1);
    return true;
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, boolean paramBoolean) throws ParseException, IOException {
    while (true) {
      char c = zaj(paramBufferedReader);
      if (c != '"') {
        StringBuilder stringBuilder;
        char[] arrayOfChar;
        if (c != 'f') {
          if (c != 'n') {
            if (c == 't') {
              if (paramBoolean) {
                arrayOfChar = zaqh;
              } else {
                arrayOfChar = zaqg;
              } 
              zab(paramBufferedReader, arrayOfChar);
              return true;
            } 
            stringBuilder = new StringBuilder(19);
            stringBuilder.append("Unexpected token: ");
            stringBuilder.append(c);
            throw new ParseException(stringBuilder.toString());
          } 
          zab((BufferedReader)stringBuilder, zaqf);
          return false;
        } 
        if (paramBoolean) {
          arrayOfChar = zaqj;
        } else {
          arrayOfChar = zaqi;
        } 
        zab((BufferedReader)stringBuilder, arrayOfChar);
        return false;
      } 
      if (!paramBoolean) {
        paramBoolean = true;
        continue;
      } 
      throw new ParseException("No boolean value found in string");
    } 
  }
  
  private final String zab(BufferedReader paramBufferedReader) throws ParseException, IOException {
    // Byte code:
    //   0: aload_1
    //   1: sipush #1024
    //   4: invokevirtual mark : (I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   12: istore_2
    //   13: iload_2
    //   14: bipush #34
    //   16: if_icmpeq -> 378
    //   19: iload_2
    //   20: bipush #44
    //   22: if_icmpeq -> 368
    //   25: iconst_1
    //   26: istore_3
    //   27: iload_2
    //   28: bipush #91
    //   30: if_icmpeq -> 166
    //   33: iload_2
    //   34: bipush #123
    //   36: if_icmpeq -> 56
    //   39: aload_1
    //   40: invokevirtual reset : ()V
    //   43: aload_0
    //   44: aload_1
    //   45: aload_0
    //   46: getfield zaqc : [C
    //   49: invokespecial zaa : (Ljava/io/BufferedReader;[C)I
    //   52: pop
    //   53: goto -> 412
    //   56: aload_0
    //   57: getfield zaql : Ljava/util/Stack;
    //   60: iconst_1
    //   61: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   64: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   67: pop
    //   68: aload_1
    //   69: bipush #32
    //   71: invokevirtual mark : (I)V
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   79: istore #4
    //   81: iload #4
    //   83: bipush #125
    //   85: if_icmpne -> 96
    //   88: aload_0
    //   89: iconst_1
    //   90: invokespecial zak : (I)V
    //   93: goto -> 412
    //   96: iload #4
    //   98: bipush #34
    //   100: if_icmpne -> 129
    //   103: aload_1
    //   104: invokevirtual reset : ()V
    //   107: aload_0
    //   108: aload_1
    //   109: invokespecial zaa : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   112: pop
    //   113: aload_0
    //   114: aload_1
    //   115: invokespecial zab : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   118: ifnonnull -> 113
    //   121: aload_0
    //   122: iconst_1
    //   123: invokespecial zak : (I)V
    //   126: goto -> 412
    //   129: new java/lang/StringBuilder
    //   132: dup
    //   133: bipush #18
    //   135: invokespecial <init> : (I)V
    //   138: astore_1
    //   139: aload_1
    //   140: ldc_w 'Unexpected token '
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: iload #4
    //   150: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   157: dup
    //   158: aload_1
    //   159: invokevirtual toString : ()Ljava/lang/String;
    //   162: invokespecial <init> : (Ljava/lang/String;)V
    //   165: athrow
    //   166: aload_0
    //   167: getfield zaql : Ljava/util/Stack;
    //   170: iconst_5
    //   171: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   174: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: aload_1
    //   179: bipush #32
    //   181: invokevirtual mark : (I)V
    //   184: aload_0
    //   185: aload_1
    //   186: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   189: bipush #93
    //   191: if_icmpne -> 202
    //   194: aload_0
    //   195: iconst_5
    //   196: invokespecial zak : (I)V
    //   199: goto -> 412
    //   202: aload_1
    //   203: invokevirtual reset : ()V
    //   206: iconst_0
    //   207: istore_2
    //   208: iconst_0
    //   209: istore #5
    //   211: iload_3
    //   212: ifle -> 360
    //   215: aload_0
    //   216: aload_1
    //   217: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   220: istore #4
    //   222: iload #4
    //   224: ifeq -> 349
    //   227: iload #4
    //   229: invokestatic isISOControl : (C)Z
    //   232: ifne -> 338
    //   235: iload #5
    //   237: istore #6
    //   239: iload #4
    //   241: bipush #34
    //   243: if_icmpne -> 260
    //   246: iload #5
    //   248: istore #6
    //   250: iload_2
    //   251: ifne -> 260
    //   254: iload #5
    //   256: iconst_1
    //   257: ixor
    //   258: istore #6
    //   260: iload_3
    //   261: istore #5
    //   263: iload #4
    //   265: bipush #91
    //   267: if_icmpne -> 283
    //   270: iload_3
    //   271: istore #5
    //   273: iload #6
    //   275: ifne -> 283
    //   278: iload_3
    //   279: iconst_1
    //   280: iadd
    //   281: istore #5
    //   283: iload #5
    //   285: istore_3
    //   286: iload #4
    //   288: bipush #93
    //   290: if_icmpne -> 306
    //   293: iload #5
    //   295: istore_3
    //   296: iload #6
    //   298: ifne -> 306
    //   301: iload #5
    //   303: iconst_1
    //   304: isub
    //   305: istore_3
    //   306: iload #4
    //   308: bipush #92
    //   310: if_icmpne -> 329
    //   313: iload #6
    //   315: ifeq -> 329
    //   318: iload_2
    //   319: iconst_1
    //   320: ixor
    //   321: istore_2
    //   322: iload #6
    //   324: istore #5
    //   326: goto -> 211
    //   329: iconst_0
    //   330: istore_2
    //   331: iload #6
    //   333: istore #5
    //   335: goto -> 211
    //   338: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   341: dup
    //   342: ldc_w 'Unexpected control character while reading array'
    //   345: invokespecial <init> : (Ljava/lang/String;)V
    //   348: athrow
    //   349: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   352: dup
    //   353: ldc_w 'Unexpected EOF while parsing array'
    //   356: invokespecial <init> : (Ljava/lang/String;)V
    //   359: athrow
    //   360: aload_0
    //   361: iconst_5
    //   362: invokespecial zak : (I)V
    //   365: goto -> 412
    //   368: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   371: dup
    //   372: ldc 'Missing value'
    //   374: invokespecial <init> : (Ljava/lang/String;)V
    //   377: athrow
    //   378: aload_1
    //   379: aload_0
    //   380: getfield zaqa : [C
    //   383: invokevirtual read : ([C)I
    //   386: iconst_m1
    //   387: if_icmpeq -> 558
    //   390: aload_0
    //   391: getfield zaqa : [C
    //   394: iconst_0
    //   395: caload
    //   396: istore_3
    //   397: iconst_0
    //   398: istore_2
    //   399: iload_3
    //   400: bipush #34
    //   402: if_icmpne -> 488
    //   405: iload_2
    //   406: ifeq -> 412
    //   409: goto -> 488
    //   412: aload_0
    //   413: aload_1
    //   414: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   417: istore #4
    //   419: iload #4
    //   421: bipush #44
    //   423: if_icmpeq -> 477
    //   426: iload #4
    //   428: bipush #125
    //   430: if_icmpne -> 440
    //   433: aload_0
    //   434: iconst_2
    //   435: invokespecial zak : (I)V
    //   438: aconst_null
    //   439: areturn
    //   440: new java/lang/StringBuilder
    //   443: dup
    //   444: bipush #18
    //   446: invokespecial <init> : (I)V
    //   449: astore_1
    //   450: aload_1
    //   451: ldc_w 'Unexpected token '
    //   454: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload_1
    //   459: iload #4
    //   461: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   468: dup
    //   469: aload_1
    //   470: invokevirtual toString : ()Ljava/lang/String;
    //   473: invokespecial <init> : (Ljava/lang/String;)V
    //   476: athrow
    //   477: aload_0
    //   478: iconst_2
    //   479: invokespecial zak : (I)V
    //   482: aload_0
    //   483: aload_1
    //   484: invokespecial zaa : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   487: areturn
    //   488: iload_3
    //   489: bipush #92
    //   491: if_icmpne -> 501
    //   494: iload_2
    //   495: iconst_1
    //   496: ixor
    //   497: istore_2
    //   498: goto -> 503
    //   501: iconst_0
    //   502: istore_2
    //   503: aload_1
    //   504: aload_0
    //   505: getfield zaqa : [C
    //   508: invokevirtual read : ([C)I
    //   511: iconst_m1
    //   512: if_icmpeq -> 547
    //   515: aload_0
    //   516: getfield zaqa : [C
    //   519: iconst_0
    //   520: caload
    //   521: istore #4
    //   523: iload #4
    //   525: invokestatic isISOControl : (C)Z
    //   528: ifne -> 537
    //   531: iload #4
    //   533: istore_3
    //   534: goto -> 399
    //   537: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   540: dup
    //   541: ldc 'Unexpected control character while reading string'
    //   543: invokespecial <init> : (Ljava/lang/String;)V
    //   546: athrow
    //   547: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   550: dup
    //   551: ldc_w 'Unexpected EOF while parsing string'
    //   554: invokespecial <init> : (Ljava/lang/String;)V
    //   557: athrow
    //   558: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   561: dup
    //   562: ldc_w 'Unexpected EOF while parsing string'
    //   565: invokespecial <init> : (Ljava/lang/String;)V
    //   568: athrow
  }
  
  private static String zab(BufferedReader paramBufferedReader, char[] paramArrayOfchar1, StringBuilder paramStringBuilder, char[] paramArrayOfchar2) throws ParseException, IOException {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfchar1.length);
    int i = 0;
    int j = 0;
    while (true) {
      int k = paramBufferedReader.read(paramArrayOfchar1);
      if (k != -1) {
        int m = j;
        j = i;
        byte b = 0;
        i = m;
        label37: for (m = b; m < k; m++) {
          char c = paramArrayOfchar1[m];
          if (Character.isISOControl(c)) {
            if (paramArrayOfchar2 != null)
              for (b = 0; b < paramArrayOfchar2.length; b++) {
                if (paramArrayOfchar2[b] == c) {
                  b = 1;
                  continue label37;
                } 
              }  
            b = 0;
            if (b == 0)
              throw new ParseException("Unexpected control character while reading string"); 
          } 
          if (c == '"' && j == 0) {
            paramStringBuilder.append(paramArrayOfchar1, 0, m);
            paramBufferedReader.reset();
            paramBufferedReader.skip((m + 1));
            return (i != 0) ? JsonUtils.unescapeString(paramStringBuilder.toString()) : paramStringBuilder.toString();
          } 
          if (c == '\\') {
            j ^= 0x1;
            i = 1;
          } else {
            j = 0;
          } 
        } 
        paramStringBuilder.append(paramArrayOfchar1, 0, k);
        paramBufferedReader.mark(paramArrayOfchar1.length);
        m = j;
        j = i;
        i = m;
        continue;
      } 
      throw new ParseException("Unexpected EOF while parsing string");
    } 
  }
  
  private final void zab(BufferedReader paramBufferedReader, char[] paramArrayOfchar) throws ParseException, IOException {
    int i = 0;
    while (i < paramArrayOfchar.length) {
      int j = paramBufferedReader.read(this.zaqb, 0, paramArrayOfchar.length - i);
      if (j != -1) {
        byte b = 0;
        while (b < j) {
          if (paramArrayOfchar[b + i] == this.zaqb[b]) {
            b++;
            continue;
          } 
          throw new ParseException("Unexpected character");
        } 
        i += j;
        continue;
      } 
      throw new ParseException("Unexpected EOF");
    } 
  }
  
  private final String zac(BufferedReader paramBufferedReader) throws ParseException, IOException {
    return zaa(paramBufferedReader, this.zaqb, this.zaqd, null);
  }
  
  private final int zad(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0)
      return 0; 
    char[] arrayOfChar = this.zaqc;
    if (i > 0) {
      int j;
      boolean bool;
      int k;
      int m;
      if (arrayOfChar[0] == '-') {
        j = 1;
        bool = true;
        k = Integer.MIN_VALUE;
      } else {
        j = 0;
        bool = false;
        k = -2147483647;
      } 
      if (j < i) {
        m = j + 1;
        j = Character.digit(arrayOfChar[j], 10);
        if (j >= 0) {
          int n = -j;
          j = m;
          m = n;
        } else {
          throw new ParseException("Unexpected non-digit character");
        } 
      } else {
        m = 0;
      } 
      while (j < i) {
        int n = Character.digit(arrayOfChar[j], 10);
        if (n >= 0) {
          if (m >= -214748364) {
            m *= 10;
            if (m >= k + n) {
              m -= n;
              j++;
              continue;
            } 
            throw new ParseException("Number too large");
          } 
          throw new ParseException("Number too large");
        } 
        throw new ParseException("Unexpected non-digit character");
      } 
      if (bool) {
        if (j > 1)
          return m; 
        throw new ParseException("No digits to parse");
      } 
      return -m;
    } 
    throw new ParseException("No number to parse");
  }
  
  private final long zae(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zaqc);
    if (i == 0)
      return 0L; 
    char[] arrayOfChar = this.zaqc;
    if (i > 0) {
      long l1;
      boolean bool;
      long l2;
      int j = 0;
      if (arrayOfChar[0] == '-') {
        l1 = Long.MIN_VALUE;
        j = 1;
        bool = true;
      } else {
        l1 = -9223372036854775807L;
        bool = false;
      } 
      if (j < i) {
        int k = j + 1;
        j = Character.digit(arrayOfChar[j], 10);
        if (j >= 0) {
          l2 = -j;
          j = k;
        } else {
          throw new ParseException("Unexpected non-digit character");
        } 
      } else {
        l2 = 0L;
      } 
      while (j < i) {
        int k = Character.digit(arrayOfChar[j], 10);
        if (k >= 0) {
          if (l2 >= -922337203685477580L) {
            long l = l2 * 10L;
            l2 = k;
            if (l >= l1 + l2) {
              l2 = l - l2;
              j++;
              continue;
            } 
            throw new ParseException("Number too large");
          } 
          throw new ParseException("Number too large");
        } 
        throw new ParseException("Unexpected non-digit character");
      } 
      if (bool) {
        if (j > 1)
          return l2; 
        throw new ParseException("No digits to parse");
      } 
      return -l2;
    } 
    throw new ParseException("No number to parse");
  }
  
  private final BigInteger zaf(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zaqc);
    return (i == 0) ? null : new BigInteger(new String(this.zaqc, 0, i));
  }
  
  private final float zag(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zaqc);
    return (i == 0) ? 0.0F : Float.parseFloat(new String(this.zaqc, 0, i));
  }
  
  private final double zah(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zaqc);
    return (i == 0) ? 0.0D : Double.parseDouble(new String(this.zaqc, 0, i));
  }
  
  private final BigDecimal zai(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zaqc);
    return (i == 0) ? null : new BigDecimal(new String(this.zaqc, 0, i));
  }
  
  private final char zaj(BufferedReader paramBufferedReader) throws ParseException, IOException {
    if (paramBufferedReader.read(this.zaqa) == -1)
      return Character.MIN_VALUE; 
    while (Character.isWhitespace(this.zaqa[0])) {
      if (paramBufferedReader.read(this.zaqa) == -1)
        return Character.MIN_VALUE; 
    } 
    return this.zaqa[0];
  }
  
  private final void zak(int paramInt) throws ParseException {
    if (!this.zaql.isEmpty()) {
      int i = ((Integer)this.zaql.pop()).intValue();
      if (i == paramInt)
        return; 
      StringBuilder stringBuilder1 = new StringBuilder(46);
      stringBuilder1.append("Expected state ");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(" but had ");
      stringBuilder1.append(i);
      throw new ParseException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder(46);
    stringBuilder.append("Expected state ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" but had empty stack");
    throw new ParseException(stringBuilder.toString());
  }
  
  @KeepForSdk
  public void parse(InputStream paramInputStream, T paramT) throws ParseException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    try {
      this.zaql.push(Integer.valueOf(0));
      char c = zaj(bufferedReader);
      if (c != '\000') {
        StringBuilder stringBuilder;
        if (c != '[') {
          if (c == '{') {
            this.zaql.push(Integer.valueOf(1));
            zaa(bufferedReader, (FastJsonResponse)paramT);
          } else {
            ParseException parseException1 = new ParseException();
            stringBuilder = new StringBuilder();
            this(19);
            stringBuilder.append("Unexpected token: ");
            stringBuilder.append(c);
            this(stringBuilder.toString());
            throw parseException1;
          } 
        } else {
          this.zaql.push(Integer.valueOf(5));
          Map<String, FastJsonResponse.Field<?, ?>> map = stringBuilder.getFieldMappings();
          if (map.size() == 1) {
            FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field)((Map.Entry)map.entrySet().iterator().next()).getValue();
            ArrayList<FastJsonResponse> arrayList = zaa(bufferedReader, field);
            stringBuilder.addConcreteTypeArrayInternal(field, field.zapu, arrayList);
          } else {
            ParseException parseException1 = new ParseException();
            this("Object array response class must have a single Field");
            throw parseException1;
          } 
        } 
        zak(0);
        try {
          bufferedReader.close();
          return;
        } catch (IOException iOException) {
          Log.w("FastParser", "Failed to close reader while parsing.");
          return;
        } 
      } 
      ParseException parseException = new ParseException();
      this("No data to parse");
      throw parseException;
    } catch (IOException iOException1) {
      ParseException parseException = new ParseException();
      this(iOException1);
      throw parseException;
    } finally {}
    try {
      iOException.close();
    } catch (IOException iOException1) {
      Log.w("FastParser", "Failed to close reader while parsing.");
    } 
    throw paramT;
  }
  
  @KeepForSdk
  @ShowFirstParty
  public static class ParseException extends Exception {
    public ParseException(String param1String) {
      super(param1String);
    }
    
    public ParseException(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
    
    public ParseException(Throwable param1Throwable) {
      super(param1Throwable);
    }
  }
  
  private static interface zaa<O> {
    O zah(FastParser param1FastParser, BufferedReader param1BufferedReader) throws FastParser.ParseException, IOException;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\FastParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */