package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@KeepForSdk
@Class(creator = "SafeParcelResponseCreator")
@VisibleForTesting
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
  @KeepForSdk
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
  
  private final String mClassName;
  
  @VersionField(getter = "getVersionCode", id = 1)
  private final int zale;
  
  @Field(getter = "getFieldMappingDictionary", id = 3)
  private final zak zapy;
  
  @Field(getter = "getParcel", id = 2)
  private final Parcel zara;
  
  private final int zarb;
  
  private int zarc;
  
  private int zard;
  
  @Constructor
  SafeParcelResponse(@Param(id = 1) int paramInt, @Param(id = 2) Parcel paramParcel, @Param(id = 3) zak paramzak) {
    this.zale = paramInt;
    this.zara = (Parcel)Preconditions.checkNotNull(paramParcel);
    this.zarb = 2;
    this.zapy = paramzak;
    zak zak1 = this.zapy;
    if (zak1 == null) {
      this.mClassName = null;
    } else {
      this.mClassName = zak1.zact();
    } 
    this.zarc = 2;
  }
  
  private SafeParcelResponse(SafeParcelable paramSafeParcelable, zak paramzak, String paramString) {
    this.zale = 1;
    this.zara = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.zara, 0);
    this.zarb = 1;
    this.zapy = (zak)Preconditions.checkNotNull(paramzak);
    this.mClassName = (String)Preconditions.checkNotNull(paramString);
    this.zarc = 2;
  }
  
  public SafeParcelResponse(zak paramzak, String paramString) {
    this.zale = 1;
    this.zara = Parcel.obtain();
    this.zarb = 0;
    this.zapy = (zak)Preconditions.checkNotNull(paramzak);
    this.mClassName = (String)Preconditions.checkNotNull(paramString);
    this.zarc = 0;
  }
  
  @KeepForSdk
  public static <T extends FastJsonResponse & SafeParcelable> SafeParcelResponse from(T paramT) {
    String str = paramT.getClass().getCanonicalName();
    zak zak1 = new zak((Class)paramT.getClass());
    zaa(zak1, (FastJsonResponse)paramT);
    zak1.zacs();
    zak1.zacr();
    return new SafeParcelResponse((SafeParcelable)paramT, zak1, str);
  }
  
  private static void zaa(zak paramzak, FastJsonResponse paramFastJsonResponse) {
    Class<?> clazz = paramFastJsonResponse.getClass();
    if (!paramzak.zaa((Class)clazz)) {
      Map<String, FastJsonResponse.Field<?, ?>> map = paramFastJsonResponse.getFieldMappings();
      paramzak.zaa((Class)clazz, map);
      Iterator<String> iterator = map.keySet().iterator();
      while (iterator.hasNext()) {
        FastJsonResponse.Field field = map.get(iterator.next());
        Class<? extends FastJsonResponse> clazz1 = field.zapw;
        if (clazz1 != null)
          try {
            zaa(paramzak, clazz1.newInstance());
          } catch (InstantiationException instantiationException) {
            String str = String.valueOf(field.zapw.getCanonicalName());
            if (str.length() != 0) {
              str = "Could not instantiate an object of type ".concat(str);
            } else {
              str = new String("Could not instantiate an object of type ");
            } 
            throw new IllegalStateException(str, instantiationException);
          } catch (IllegalAccessException illegalAccessException) {
            String str = String.valueOf(field.zapw.getCanonicalName());
            if (str.length() != 0) {
              str = "Could not access object of type ".concat(str);
            } else {
              str = new String("Could not access object of type ");
            } 
            throw new IllegalStateException(str, illegalAccessException);
          }  
      } 
    } 
  }
  
  private static void zaa(StringBuilder paramStringBuilder, int paramInt, Object paramObject) {
    switch (paramInt) {
      default:
        paramStringBuilder = new StringBuilder(26);
        paramStringBuilder.append("Unknown type = ");
        paramStringBuilder.append(paramInt);
        throw new IllegalArgumentException(paramStringBuilder.toString());
      case 11:
        throw new IllegalArgumentException("Method does not accept concrete type.");
      case 10:
        MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)paramObject);
        return;
      case 9:
        paramStringBuilder.append("\"");
        paramStringBuilder.append(Base64Utils.encodeUrlSafe((byte[])paramObject));
        paramStringBuilder.append("\"");
        return;
      case 8:
        paramStringBuilder.append("\"");
        paramStringBuilder.append(Base64Utils.encode((byte[])paramObject));
        paramStringBuilder.append("\"");
        return;
      case 7:
        paramStringBuilder.append("\"");
        paramStringBuilder.append(JsonUtils.escapeString(paramObject.toString()));
        paramStringBuilder.append("\"");
        return;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
        break;
    } 
    paramStringBuilder.append(paramObject);
  }
  
  private final void zaa(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel) {
    SparseArray sparseArray = new SparseArray();
    for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : paramMap.entrySet())
      sparseArray.put(((FastJsonResponse.Field)entry.getValue()).getSafeParcelableFieldId(), entry); 
    paramStringBuilder.append('{');
    int i = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    while (paramParcel.dataPosition() < i) {
      int k = SafeParcelReader.readHeader(paramParcel);
      Map.Entry entry = (Map.Entry)sparseArray.get(SafeParcelReader.getFieldId(k));
      if (entry != null) {
        if (j)
          paramStringBuilder.append(","); 
        String str = (String)entry.getKey();
        FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field)entry.getValue();
        paramStringBuilder.append("\"");
        paramStringBuilder.append(str);
        paramStringBuilder.append("\":");
        if (field.zacn()) {
          HashMap<Object, Object> hashMap;
          Bundle bundle;
          switch (field.zaps) {
            default:
              j = field.zaps;
              paramStringBuilder = new StringBuilder(36);
              paramStringBuilder.append("Unknown field out type = ");
              paramStringBuilder.append(j);
              throw new IllegalArgumentException(paramStringBuilder.toString());
            case 11:
              throw new IllegalArgumentException("Method does not accept concrete type.");
            case 10:
              bundle = SafeParcelReader.createBundle(paramParcel, k);
              hashMap = new HashMap<Object, Object>();
              for (String str1 : bundle.keySet())
                hashMap.put(str1, bundle.getString(str1)); 
              zab(paramStringBuilder, field, zab(field, hashMap));
              break;
            case 8:
            case 9:
              zab(paramStringBuilder, field, zab(field, SafeParcelReader.createByteArray(paramParcel, k)));
              break;
            case 7:
              zab(paramStringBuilder, field, zab(field, SafeParcelReader.createString(paramParcel, k)));
              break;
            case 6:
              zab(paramStringBuilder, field, zab(field, Boolean.valueOf(SafeParcelReader.readBoolean(paramParcel, k))));
              break;
            case 5:
              zab(paramStringBuilder, field, zab(field, SafeParcelReader.createBigDecimal(paramParcel, k)));
              break;
            case 4:
              zab(paramStringBuilder, field, zab(field, Double.valueOf(SafeParcelReader.readDouble(paramParcel, k))));
              break;
            case 3:
              zab(paramStringBuilder, field, zab(field, Float.valueOf(SafeParcelReader.readFloat(paramParcel, k))));
              break;
            case 2:
              zab(paramStringBuilder, field, zab(field, Long.valueOf(SafeParcelReader.readLong(paramParcel, k))));
              break;
            case 1:
              zab(paramStringBuilder, field, zab(field, SafeParcelReader.createBigInteger(paramParcel, k)));
              break;
            case 0:
              zab(paramStringBuilder, field, zab(field, Integer.valueOf(SafeParcelReader.readInt(paramParcel, k))));
              break;
          } 
        } else if (field.zapt) {
          Parcel[] arrayOfParcel;
          paramStringBuilder.append("[");
          switch (field.zaps) {
            default:
              throw new IllegalStateException("Unknown field type out.");
            case 11:
              arrayOfParcel = SafeParcelReader.createParcelArray(paramParcel, k);
              k = arrayOfParcel.length;
              for (j = 0; j < k; j++) {
                if (j > 0)
                  paramStringBuilder.append(","); 
                arrayOfParcel[j].setDataPosition(0);
                zaa(paramStringBuilder, field.zacq(), arrayOfParcel[j]);
              } 
              break;
            case 8:
            case 9:
            case 10:
              throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
            case 7:
              ArrayUtils.writeStringArray(paramStringBuilder, SafeParcelReader.createStringArray(paramParcel, k));
              break;
            case 6:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBooleanArray(paramParcel, k));
              break;
            case 5:
              ArrayUtils.writeArray(paramStringBuilder, (Object[])SafeParcelReader.createBigDecimalArray(paramParcel, k));
              break;
            case 4:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createDoubleArray(paramParcel, k));
              break;
            case 3:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createFloatArray(paramParcel, k));
              break;
            case 2:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createLongArray(paramParcel, k));
              break;
            case 1:
              ArrayUtils.writeArray(paramStringBuilder, (Object[])SafeParcelReader.createBigIntegerArray(paramParcel, k));
              break;
            case 0:
              ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createIntArray(paramParcel, k));
              break;
          } 
          paramStringBuilder.append("]");
        } else {
          Bundle bundle;
          byte[] arrayOfByte;
          String str1;
          Parcel parcel;
          Set set;
          Iterator<String> iterator;
          switch (field.zaps) {
            default:
              throw new IllegalStateException("Unknown field type out");
            case 11:
              parcel = SafeParcelReader.createParcel(paramParcel, k);
              parcel.setDataPosition(0);
              zaa(paramStringBuilder, field.zacq(), parcel);
              break;
            case 10:
              bundle = SafeParcelReader.createBundle(paramParcel, k);
              set = bundle.keySet();
              set.size();
              paramStringBuilder.append("{");
              iterator = set.iterator();
              for (j = 1; iterator.hasNext(); j = 0) {
                String str2 = iterator.next();
                if (j == 0)
                  paramStringBuilder.append(","); 
                paramStringBuilder.append("\"");
                paramStringBuilder.append(str2);
                paramStringBuilder.append("\"");
                paramStringBuilder.append(":");
                paramStringBuilder.append("\"");
                paramStringBuilder.append(JsonUtils.escapeString(bundle.getString(str2)));
                paramStringBuilder.append("\"");
              } 
              paramStringBuilder.append("}");
              break;
            case 9:
              arrayOfByte = SafeParcelReader.createByteArray(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(Base64Utils.encodeUrlSafe(arrayOfByte));
              paramStringBuilder.append("\"");
              break;
            case 8:
              arrayOfByte = SafeParcelReader.createByteArray(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(Base64Utils.encode(arrayOfByte));
              paramStringBuilder.append("\"");
              break;
            case 7:
              str1 = SafeParcelReader.createString(paramParcel, k);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(JsonUtils.escapeString(str1));
              paramStringBuilder.append("\"");
              break;
            case 6:
              paramStringBuilder.append(SafeParcelReader.readBoolean(paramParcel, k));
              break;
            case 5:
              paramStringBuilder.append(SafeParcelReader.createBigDecimal(paramParcel, k));
              break;
            case 4:
              paramStringBuilder.append(SafeParcelReader.readDouble(paramParcel, k));
              break;
            case 3:
              paramStringBuilder.append(SafeParcelReader.readFloat(paramParcel, k));
              break;
            case 2:
              paramStringBuilder.append(SafeParcelReader.readLong(paramParcel, k));
              break;
            case 1:
              paramStringBuilder.append(SafeParcelReader.createBigInteger(paramParcel, k));
              break;
            case 0:
              paramStringBuilder.append(SafeParcelReader.readInt(paramParcel, k));
              break;
          } 
        } 
        j = 1;
      } 
    } 
    if (paramParcel.dataPosition() == i) {
      paramStringBuilder.append('}');
      return;
    } 
    paramStringBuilder = new StringBuilder(37);
    paramStringBuilder.append("Overread allowed size end=");
    paramStringBuilder.append(i);
    throw new SafeParcelReader.ParseException(paramStringBuilder.toString(), paramParcel);
  }
  
  private final void zab(FastJsonResponse.Field<?, ?> paramField) {
    boolean bool;
    if (paramField.zapv != -1) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      Parcel parcel = this.zara;
      if (parcel != null) {
        switch (this.zarc) {
          default:
            throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
          case 2:
            throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
          case 1:
            return;
          case 0:
            break;
        } 
        this.zard = SafeParcelWriter.beginObjectHeader(parcel);
        this.zarc = 1;
        return;
      } 
      throw new IllegalStateException("Internal Parcel object is null.");
    } 
    throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
  }
  
  private final void zab(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject) {
    if (paramField.zapr) {
      paramObject = paramObject;
      paramStringBuilder.append("[");
      int i = paramObject.size();
      for (byte b = 0; b < i; b++) {
        if (b != 0)
          paramStringBuilder.append(","); 
        zaa(paramStringBuilder, paramField.zapq, paramObject.get(b));
      } 
      paramStringBuilder.append("]");
      return;
    } 
    zaa(paramStringBuilder, paramField.zapq, paramObject);
  }
  
  private final Parcel zacu() {
    switch (this.zarc) {
      default:
        return this.zara;
      case 0:
        this.zard = SafeParcelWriter.beginObjectHeader(this.zara);
        break;
      case 1:
        break;
    } 
    SafeParcelWriter.finishObjectHeader(this.zara, this.zard);
    this.zarc = 2;
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList) {
    zab(paramField);
    ArrayList<Parcel> arrayList = new ArrayList();
    paramArrayList.size();
    ArrayList<T> arrayList1 = paramArrayList;
    int i = arrayList1.size();
    byte b = 0;
    while (b < i) {
      paramArrayList = (ArrayList<T>)arrayList1.get(b);
      b++;
      arrayList.add(((SafeParcelResponse)paramArrayList).zacu());
    } 
    SafeParcelWriter.writeParcelList(this.zara, paramField.getSafeParcelableFieldId(), arrayList, true);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT) {
    zab(paramField);
    Parcel parcel = ((SafeParcelResponse)paramT).zacu();
    SafeParcelWriter.writeParcel(this.zara, paramField.getSafeParcelableFieldId(), parcel, true);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings() {
    zak zak1 = this.zapy;
    return (zak1 == null) ? null : zak1.zai(this.mClassName);
  }
  
  public Object getValueObject(String paramString) {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public boolean isPrimitiveFieldSet(String paramString) {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean) {
    zab(paramField);
    SafeParcelWriter.writeBoolean(this.zara, paramField.getSafeParcelableFieldId(), paramBoolean);
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfbyte) {
    zab(paramField);
    SafeParcelWriter.writeByteArray(this.zara, paramField.getSafeParcelableFieldId(), paramArrayOfbyte, true);
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt) {
    zab(paramField);
    SafeParcelWriter.writeInt(this.zara, paramField.getSafeParcelableFieldId(), paramInt);
  }
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong) {
    zab(paramField);
    SafeParcelWriter.writeLong(this.zara, paramField.getSafeParcelableFieldId(), paramLong);
  }
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2) {
    zab(paramField);
    SafeParcelWriter.writeString(this.zara, paramField.getSafeParcelableFieldId(), paramString2, true);
  }
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    String[] arrayOfString = new String[i];
    for (byte b = 0; b < i; b++)
      arrayOfString[b] = paramArrayList.get(b); 
    SafeParcelWriter.writeStringArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfString, true);
  }
  
  public String toString() {
    Preconditions.checkNotNull(this.zapy, "Cannot convert to JSON on client side.");
    Parcel parcel = zacu();
    parcel.setDataPosition(0);
    StringBuilder stringBuilder = new StringBuilder(100);
    zaa(stringBuilder, this.zapy.zai(this.mClassName), parcel);
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    StringBuilder stringBuilder;
    zak zak1;
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    SafeParcelWriter.writeParcel(paramParcel, 2, zacu(), false);
    int j = this.zarb;
    switch (j) {
      default:
        stringBuilder = new StringBuilder(34);
        stringBuilder.append("Invalid creation type: ");
        stringBuilder.append(j);
        throw new IllegalStateException(stringBuilder.toString());
      case 2:
        zak1 = this.zapy;
        break;
      case 1:
        zak1 = this.zapy;
        break;
      case 0:
        zak1 = null;
        break;
    } 
    SafeParcelWriter.writeParcelable((Parcel)stringBuilder, 3, (Parcelable)zak1, paramInt, false);
    SafeParcelWriter.finishObjectHeader((Parcel)stringBuilder, i);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble) {
    zab(paramField);
    SafeParcelWriter.writeDouble(this.zara, paramField.getSafeParcelableFieldId(), paramDouble);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat) {
    zab(paramField);
    SafeParcelWriter.writeFloat(this.zara, paramField.getSafeParcelableFieldId(), paramFloat);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal) {
    zab(paramField);
    SafeParcelWriter.writeBigDecimal(this.zara, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger) {
    zab(paramField);
    SafeParcelWriter.writeBigInteger(this.zara, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    int[] arrayOfInt = new int[i];
    for (byte b = 0; b < i; b++)
      arrayOfInt[b] = ((Integer)paramArrayList.get(b)).intValue(); 
    SafeParcelWriter.writeIntArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfInt, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap) {
    zab(paramField);
    Bundle bundle = new Bundle();
    for (String paramString : paramMap.keySet())
      bundle.putString(paramString, paramMap.get(paramString)); 
    SafeParcelWriter.writeBundle(this.zara, paramField.getSafeParcelableFieldId(), bundle, true);
  }
  
  protected final void zab(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    BigInteger[] arrayOfBigInteger = new BigInteger[i];
    for (byte b = 0; b < i; b++)
      arrayOfBigInteger[b] = paramArrayList.get(b); 
    SafeParcelWriter.writeBigIntegerArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfBigInteger, true);
  }
  
  protected final void zac(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    long[] arrayOfLong = new long[i];
    for (byte b = 0; b < i; b++)
      arrayOfLong[b] = ((Long)paramArrayList.get(b)).longValue(); 
    SafeParcelWriter.writeLongArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfLong, true);
  }
  
  protected final void zad(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    float[] arrayOfFloat = new float[i];
    for (byte b = 0; b < i; b++)
      arrayOfFloat[b] = ((Float)paramArrayList.get(b)).floatValue(); 
    SafeParcelWriter.writeFloatArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfFloat, true);
  }
  
  protected final void zae(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    double[] arrayOfDouble = new double[i];
    for (byte b = 0; b < i; b++)
      arrayOfDouble[b] = ((Double)paramArrayList.get(b)).doubleValue(); 
    SafeParcelWriter.writeDoubleArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfDouble, true);
  }
  
  protected final void zaf(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[i];
    for (byte b = 0; b < i; b++)
      arrayOfBigDecimal[b] = paramArrayList.get(b); 
    SafeParcelWriter.writeBigDecimalArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfBigDecimal, true);
  }
  
  protected final void zag(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList) {
    zab(paramField);
    int i = paramArrayList.size();
    boolean[] arrayOfBoolean = new boolean[i];
    for (byte b = 0; b < i; b++)
      arrayOfBoolean[b] = ((Boolean)paramArrayList.get(b)).booleanValue(); 
    SafeParcelWriter.writeBooleanArray(this.zara, paramField.getSafeParcelableFieldId(), arrayOfBoolean, true);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\server\response\SafeParcelResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */