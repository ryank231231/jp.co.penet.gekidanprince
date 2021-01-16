package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepForSdk
@ShowFirstParty
public abstract class FastJsonResponse {
  private final <I, O> void zaa(Field<I, O> paramField, I paramI) {
    StringBuilder stringBuilder;
    int i;
    String str = paramField.zapu;
    paramI = (I)paramField.convert(paramI);
    switch (paramField.zaps) {
      default:
        i = paramField.zaps;
        stringBuilder = new StringBuilder(44);
        stringBuilder.append("Unsupported type for conversion: ");
        stringBuilder.append(i);
        throw new IllegalStateException(stringBuilder.toString());
      case 8:
      case 9:
        if (zaa(str, paramI)) {
          setDecodedBytesInternal((Field<?, ?>)stringBuilder, str, (byte[])paramI);
          return;
        } 
        return;
      case 7:
        setStringInternal((Field<?, ?>)stringBuilder, str, (String)paramI);
        return;
      case 6:
        if (zaa(str, paramI)) {
          setBooleanInternal((Field<?, ?>)stringBuilder, str, ((Boolean)paramI).booleanValue());
          return;
        } 
        return;
      case 5:
        zaa((Field<?, ?>)stringBuilder, str, (BigDecimal)paramI);
        return;
      case 4:
        if (zaa(str, paramI)) {
          zaa((Field<?, ?>)stringBuilder, str, ((Double)paramI).doubleValue());
          return;
        } 
        return;
      case 2:
        if (zaa(str, paramI)) {
          setLongInternal((Field<?, ?>)stringBuilder, str, ((Long)paramI).longValue());
          return;
        } 
        return;
      case 1:
        zaa((Field<?, ?>)stringBuilder, str, (BigInteger)paramI);
        return;
      case 0:
        break;
    } 
    if (zaa(str, paramI)) {
      setIntegerInternal((Field<?, ?>)stringBuilder, str, ((Integer)paramI).intValue());
      return;
    } 
  }
  
  private static void zaa(StringBuilder paramStringBuilder, Field paramField, Object paramObject) {
    if (paramField.zapq == 11) {
      paramStringBuilder.append(((FastJsonResponse)paramField.zapw.cast(paramObject)).toString());
      return;
    } 
    if (paramField.zapq == 7) {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(JsonUtils.escapeString((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    } 
    paramStringBuilder.append(paramObject);
  }
  
  private static <O> boolean zaa(String paramString, O paramO) {
    if (paramO == null) {
      if (Log.isLoggable("FastJsonResponse", 6)) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 58);
        stringBuilder.append("Output field (");
        stringBuilder.append(paramString);
        stringBuilder.append(") has a null value, but expected a primitive");
        Log.e("FastJsonResponse", stringBuilder.toString());
      } 
      return false;
    } 
    return true;
  }
  
  protected static <O, I> I zab(Field<I, O> paramField, Object paramObject) {
    return (I)((Field.zaa(paramField) != null) ? (Object)paramField.convertBack((O)paramObject) : paramObject);
  }
  
  @KeepForSdk
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList) {
    throw new UnsupportedOperationException("Concrete type array not supported");
  }
  
  @KeepForSdk
  public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> paramField, String paramString, T paramT) {
    throw new UnsupportedOperationException("Concrete type not supported");
  }
  
  @KeepForSdk
  public abstract Map<String, Field<?, ?>> getFieldMappings();
  
  @KeepForSdk
  protected Object getFieldValue(Field paramField) {
    String str = paramField.zapu;
    if (paramField.zapw != null) {
      if (getValueObject(paramField.zapu) == null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.zapu });
      boolean bool = paramField.zapt;
      try {
        char c = Character.toUpperCase(str.charAt(0));
        String str1 = str.substring(1);
        int i = String.valueOf(str1).length();
        StringBuilder stringBuilder = new StringBuilder();
        this(i + 4);
        stringBuilder.append("get");
        stringBuilder.append(c);
        stringBuilder.append(str1);
        str1 = stringBuilder.toString();
        return getClass().getMethod(str1, new Class[0]).invoke(this, new Object[0]);
      } catch (Exception exception) {
        throw new RuntimeException(exception);
      } 
    } 
    return getValueObject(((Field)exception).zapu);
  }
  
  @KeepForSdk
  protected abstract Object getValueObject(String paramString);
  
  @KeepForSdk
  protected boolean isFieldSet(Field paramField) {
    String str;
    if (paramField.zaps == 11) {
      if (paramField.zapt) {
        str = paramField.zapu;
        throw new UnsupportedOperationException("Concrete type arrays not supported");
      } 
      str = ((Field)str).zapu;
      throw new UnsupportedOperationException("Concrete types not supported");
    } 
    return isPrimitiveFieldSet(((Field)str).zapu);
  }
  
  @KeepForSdk
  protected abstract boolean isPrimitiveFieldSet(String paramString);
  
  @KeepForSdk
  protected void setBooleanInternal(Field<?, ?> paramField, String paramString, boolean paramBoolean) {
    throw new UnsupportedOperationException("Boolean not supported");
  }
  
  @KeepForSdk
  protected void setDecodedBytesInternal(Field<?, ?> paramField, String paramString, byte[] paramArrayOfbyte) {
    throw new UnsupportedOperationException("byte[] not supported");
  }
  
  @KeepForSdk
  protected void setIntegerInternal(Field<?, ?> paramField, String paramString, int paramInt) {
    throw new UnsupportedOperationException("Integer not supported");
  }
  
  @KeepForSdk
  protected void setLongInternal(Field<?, ?> paramField, String paramString, long paramLong) {
    throw new UnsupportedOperationException("Long not supported");
  }
  
  @KeepForSdk
  protected void setStringInternal(Field<?, ?> paramField, String paramString1, String paramString2) {
    throw new UnsupportedOperationException("String not supported");
  }
  
  @KeepForSdk
  protected void setStringsInternal(Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList) {
    throw new UnsupportedOperationException("String list not supported");
  }
  
  @KeepForSdk
  public String toString() {
    Map<String, Field<?, ?>> map = getFieldMappings();
    StringBuilder stringBuilder = new StringBuilder(100);
    for (String str : map.keySet()) {
      Field<Object, ?> field = (Field)map.get(str);
      if (isFieldSet(field)) {
        ArrayList<String> arrayList = (ArrayList<String>)zab(field, getFieldValue(field));
        if (stringBuilder.length() == 0) {
          stringBuilder.append("{");
        } else {
          stringBuilder.append(",");
        } 
        stringBuilder.append("\"");
        stringBuilder.append(str);
        stringBuilder.append("\":");
        if (arrayList == null) {
          stringBuilder.append("null");
          continue;
        } 
        switch (field.zaps) {
          default:
            if (field.zapr) {
              arrayList = arrayList;
              stringBuilder.append("[");
              byte b = 0;
              int i = arrayList.size();
              while (b < i) {
                if (b > 0)
                  stringBuilder.append(","); 
                str = arrayList.get(b);
                if (str != null)
                  zaa(stringBuilder, field, str); 
                b++;
              } 
              stringBuilder.append("]");
              continue;
            } 
            break;
          case 10:
            MapUtils.writeStringMapToJson(stringBuilder, (HashMap)arrayList);
            continue;
          case 9:
            stringBuilder.append("\"");
            stringBuilder.append(Base64Utils.encodeUrlSafe((byte[])arrayList));
            stringBuilder.append("\"");
            continue;
          case 8:
            stringBuilder.append("\"");
            stringBuilder.append(Base64Utils.encode((byte[])arrayList));
            stringBuilder.append("\"");
            continue;
        } 
        zaa(stringBuilder, field, arrayList);
      } 
    } 
    if (stringBuilder.length() > 0) {
      stringBuilder.append("}");
    } else {
      stringBuilder.append("{}");
    } 
    return stringBuilder.toString();
  }
  
  public final <O> void zaa(Field<Double, O> paramField, double paramDouble) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, Double.valueOf(paramDouble));
      return;
    } 
    zaa(paramField, paramField.zapu, paramDouble);
  }
  
  public final <O> void zaa(Field<Float, O> paramField, float paramFloat) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, Float.valueOf(paramFloat));
      return;
    } 
    zaa(paramField, paramField.zapu, paramFloat);
  }
  
  public final <O> void zaa(Field<Integer, O> paramField, int paramInt) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, Integer.valueOf(paramInt));
      return;
    } 
    setIntegerInternal(paramField, paramField.zapu, paramInt);
  }
  
  public final <O> void zaa(Field<Long, O> paramField, long paramLong) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, Long.valueOf(paramLong));
      return;
    } 
    setLongInternal(paramField, paramField.zapu, paramLong);
  }
  
  public final <O> void zaa(Field<String, O> paramField, String paramString) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramString);
      return;
    } 
    setStringInternal(paramField, paramField.zapu, paramString);
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, double paramDouble) {
    throw new UnsupportedOperationException("Double not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, float paramFloat) {
    throw new UnsupportedOperationException("Float not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal) {
    throw new UnsupportedOperationException("BigDecimal not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, BigInteger paramBigInteger) {
    throw new UnsupportedOperationException("BigInteger not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList) {
    throw new UnsupportedOperationException("Integer list not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, Map<String, String> paramMap) {
    throw new UnsupportedOperationException("String map not supported");
  }
  
  public final <O> void zaa(Field<BigDecimal, O> paramField, BigDecimal paramBigDecimal) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramBigDecimal);
      return;
    } 
    zaa(paramField, paramField.zapu, paramBigDecimal);
  }
  
  public final <O> void zaa(Field<BigInteger, O> paramField, BigInteger paramBigInteger) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramBigInteger);
      return;
    } 
    zaa(paramField, paramField.zapu, paramBigInteger);
  }
  
  public final <O> void zaa(Field<ArrayList<Integer>, O> paramField, ArrayList<Integer> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zaa(paramField, paramField.zapu, paramArrayList);
  }
  
  public final <O> void zaa(Field<Map<String, String>, O> paramField, Map<String, String> paramMap) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramMap);
      return;
    } 
    zaa(paramField, paramField.zapu, paramMap);
  }
  
  public final <O> void zaa(Field<Boolean, O> paramField, boolean paramBoolean) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, Boolean.valueOf(paramBoolean));
      return;
    } 
    setBooleanInternal(paramField, paramField.zapu, paramBoolean);
  }
  
  public final <O> void zaa(Field<byte[], O> paramField, byte[] paramArrayOfbyte) {
    if (Field.zaa(paramField) != null) {
      zaa((Field)paramField, paramArrayOfbyte);
      return;
    } 
    setDecodedBytesInternal(paramField, paramField.zapu, paramArrayOfbyte);
  }
  
  protected void zab(Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList) {
    throw new UnsupportedOperationException("BigInteger list not supported");
  }
  
  public final <O> void zab(Field<ArrayList<BigInteger>, O> paramField, ArrayList<BigInteger> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zab(paramField, paramField.zapu, paramArrayList);
  }
  
  protected void zac(Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList) {
    throw new UnsupportedOperationException("Long list not supported");
  }
  
  public final <O> void zac(Field<ArrayList<Long>, O> paramField, ArrayList<Long> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zac(paramField, paramField.zapu, paramArrayList);
  }
  
  protected void zad(Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList) {
    throw new UnsupportedOperationException("Float list not supported");
  }
  
  public final <O> void zad(Field<ArrayList<Float>, O> paramField, ArrayList<Float> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zad(paramField, paramField.zapu, paramArrayList);
  }
  
  protected void zae(Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList) {
    throw new UnsupportedOperationException("Double list not supported");
  }
  
  public final <O> void zae(Field<ArrayList<Double>, O> paramField, ArrayList<Double> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zae(paramField, paramField.zapu, paramArrayList);
  }
  
  protected void zaf(Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList) {
    throw new UnsupportedOperationException("BigDecimal list not supported");
  }
  
  public final <O> void zaf(Field<ArrayList<BigDecimal>, O> paramField, ArrayList<BigDecimal> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zaf(paramField, paramField.zapu, paramArrayList);
  }
  
  protected void zag(Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList) {
    throw new UnsupportedOperationException("Boolean list not supported");
  }
  
  public final <O> void zag(Field<ArrayList<Boolean>, O> paramField, ArrayList<Boolean> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    zag(paramField, paramField.zapu, paramArrayList);
  }
  
  public final <O> void zah(Field<ArrayList<String>, O> paramField, ArrayList<String> paramArrayList) {
    if (Field.zaa(paramField) != null) {
      zaa(paramField, paramArrayList);
      return;
    } 
    setStringsInternal(paramField, paramField.zapu, paramArrayList);
  }
  
  @KeepForSdk
  @ShowFirstParty
  @Class(creator = "FieldCreator")
  @VisibleForTesting
  public static class Field<I, O> extends AbstractSafeParcelable {
    public static final zai CREATOR = new zai();
    
    @VersionField(getter = "getVersionCode", id = 1)
    private final int zale;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTypeIn", id = 2)
    protected final int zapq;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isTypeInArray", id = 3)
    protected final boolean zapr;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getTypeOut", id = 4)
    protected final int zaps;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
    protected final boolean zapt;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
    protected final String zapu;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
    protected final int zapv;
    
    protected final Class<? extends FastJsonResponse> zapw;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
    private final String zapx;
    
    private zak zapy;
    
    @com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
    private FastJsonResponse.FieldConverter<I, O> zapz;
    
    @Constructor
    Field(@Param(id = 1) int param1Int1, @Param(id = 2) int param1Int2, @Param(id = 3) boolean param1Boolean1, @Param(id = 4) int param1Int3, @Param(id = 5) boolean param1Boolean2, @Param(id = 6) String param1String1, @Param(id = 7) int param1Int4, @Param(id = 8) String param1String2, @Param(id = 9) zaa param1zaa) {
      this.zale = param1Int1;
      this.zapq = param1Int2;
      this.zapr = param1Boolean1;
      this.zaps = param1Int3;
      this.zapt = param1Boolean2;
      this.zapu = param1String1;
      this.zapv = param1Int4;
      if (param1String2 == null) {
        this.zapw = null;
        this.zapx = null;
      } else {
        this.zapw = (Class)SafeParcelResponse.class;
        this.zapx = param1String2;
      } 
      if (param1zaa == null) {
        this.zapz = null;
        return;
      } 
      this.zapz = param1zaa.zaci();
    }
    
    private Field(int param1Int1, boolean param1Boolean1, int param1Int2, boolean param1Boolean2, String param1String, int param1Int3, Class<? extends FastJsonResponse> param1Class, FastJsonResponse.FieldConverter<I, O> param1FieldConverter) {
      this.zale = 1;
      this.zapq = param1Int1;
      this.zapr = param1Boolean1;
      this.zaps = param1Int2;
      this.zapt = param1Boolean2;
      this.zapu = param1String;
      this.zapv = param1Int3;
      this.zapw = param1Class;
      if (param1Class == null) {
        this.zapx = null;
      } else {
        this.zapx = param1Class.getCanonicalName();
      } 
      this.zapz = param1FieldConverter;
    }
    
    @KeepForSdk
    @VisibleForTesting
    public static Field<byte[], byte[]> forBase64(String param1String, int param1Int) {
      return (Field)new Field<byte, byte>(8, false, 8, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static Field<Boolean, Boolean> forBoolean(String param1String, int param1Int) {
      return new Field<Boolean, Boolean>(6, false, 6, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String param1String, int param1Int, Class<T> param1Class) {
      return new Field<T, T>(11, false, 11, false, param1String, param1Int, param1Class, null);
    }
    
    @KeepForSdk
    public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String param1String, int param1Int, Class<T> param1Class) {
      return new Field<ArrayList<T>, ArrayList<T>>(11, true, 11, true, param1String, param1Int, param1Class, null);
    }
    
    @KeepForSdk
    public static Field<Double, Double> forDouble(String param1String, int param1Int) {
      return new Field<Double, Double>(4, false, 4, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static Field<Float, Float> forFloat(String param1String, int param1Int) {
      return new Field<Float, Float>(3, false, 3, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    @VisibleForTesting
    public static Field<Integer, Integer> forInteger(String param1String, int param1Int) {
      return new Field<Integer, Integer>(0, false, 0, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static Field<Long, Long> forLong(String param1String, int param1Int) {
      return new Field<Long, Long>(2, false, 2, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static Field<String, String> forString(String param1String, int param1Int) {
      return new Field<String, String>(7, false, 7, false, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static Field<ArrayList<String>, ArrayList<String>> forStrings(String param1String, int param1Int) {
      return new Field<ArrayList<String>, ArrayList<String>>(7, true, 7, true, param1String, param1Int, null, null);
    }
    
    @KeepForSdk
    public static Field withConverter(String param1String, int param1Int, FastJsonResponse.FieldConverter<?, ?> param1FieldConverter, boolean param1Boolean) {
      return new Field<Object, Object>(param1FieldConverter.zacj(), param1Boolean, param1FieldConverter.zack(), false, param1String, param1Int, null, param1FieldConverter);
    }
    
    private final String zacm() {
      String str = this.zapx;
      return (str == null) ? null : str;
    }
    
    private final zaa zaco() {
      FastJsonResponse.FieldConverter<I, O> fieldConverter = this.zapz;
      return (fieldConverter == null) ? null : zaa.zaa(fieldConverter);
    }
    
    public final O convert(I param1I) {
      return this.zapz.convert(param1I);
    }
    
    public final I convertBack(O param1O) {
      return this.zapz.convertBack(param1O);
    }
    
    @KeepForSdk
    public int getSafeParcelableFieldId() {
      return this.zapv;
    }
    
    public String toString() {
      Objects.ToStringHelper toStringHelper = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zale)).add("typeIn", Integer.valueOf(this.zapq)).add("typeInArray", Boolean.valueOf(this.zapr)).add("typeOut", Integer.valueOf(this.zaps)).add("typeOutArray", Boolean.valueOf(this.zapt)).add("outputFieldName", this.zapu).add("safeParcelFieldId", Integer.valueOf(this.zapv)).add("concreteTypeName", zacm());
      Class<? extends FastJsonResponse> clazz = this.zapw;
      if (clazz != null)
        toStringHelper.add("concreteType.class", clazz.getCanonicalName()); 
      FastJsonResponse.FieldConverter<I, O> fieldConverter = this.zapz;
      if (fieldConverter != null)
        toStringHelper.add("converterName", fieldConverter.getClass().getCanonicalName()); 
      return toStringHelper.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      int i = SafeParcelWriter.beginObjectHeader(param1Parcel);
      SafeParcelWriter.writeInt(param1Parcel, 1, this.zale);
      SafeParcelWriter.writeInt(param1Parcel, 2, this.zapq);
      SafeParcelWriter.writeBoolean(param1Parcel, 3, this.zapr);
      SafeParcelWriter.writeInt(param1Parcel, 4, this.zaps);
      SafeParcelWriter.writeBoolean(param1Parcel, 5, this.zapt);
      SafeParcelWriter.writeString(param1Parcel, 6, this.zapu, false);
      SafeParcelWriter.writeInt(param1Parcel, 7, getSafeParcelableFieldId());
      SafeParcelWriter.writeString(param1Parcel, 8, zacm(), false);
      SafeParcelWriter.writeParcelable(param1Parcel, 9, (Parcelable)zaco(), param1Int, false);
      SafeParcelWriter.finishObjectHeader(param1Parcel, i);
    }
    
    public final void zaa(zak param1zak) {
      this.zapy = param1zak;
    }
    
    public final Field<I, O> zacl() {
      return new Field(this.zale, this.zapq, this.zapr, this.zaps, this.zapt, this.zapu, this.zapv, this.zapx, zaco());
    }
    
    public final boolean zacn() {
      return (this.zapz != null);
    }
    
    public final FastJsonResponse zacp() throws InstantiationException, IllegalAccessException {
      Class<? extends FastJsonResponse> clazz = this.zapw;
      if (clazz == SafeParcelResponse.class) {
        Preconditions.checkNotNull(this.zapy, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
        return new SafeParcelResponse(this.zapy, this.zapx);
      } 
      return clazz.newInstance();
    }
    
    public final Map<String, Field<?, ?>> zacq() {
      Preconditions.checkNotNull(this.zapx);
      Preconditions.checkNotNull(this.zapy);
      return this.zapy.zai(this.zapx);
    }
  }
  
  @ShowFirstParty
  public static interface FieldConverter<I, O> {
    O convert(I param1I);
    
    I convertBack(O param1O);
    
    int zacj();
    
    int zack();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\FastJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */