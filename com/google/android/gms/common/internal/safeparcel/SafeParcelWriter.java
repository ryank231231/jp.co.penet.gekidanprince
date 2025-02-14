package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
  public static int beginObjectHeader(Parcel paramParcel) {
    return zza(paramParcel, 20293);
  }
  
  public static void finishObjectHeader(Parcel paramParcel, int paramInt) {
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBigDecimal(Parcel paramParcel, int paramInt, BigDecimal paramBigDecimal, boolean paramBoolean) {
    if (paramBigDecimal == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigDecimal.unscaledValue().toByteArray());
    paramParcel.writeInt(paramBigDecimal.scale());
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBigDecimalArray(Parcel paramParcel, int paramInt, BigDecimal[] paramArrayOfBigDecimal, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfBigDecimal == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfBigDecimal.length;
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeByteArray(paramArrayOfBigDecimal[paramInt].unscaledValue().toByteArray());
      paramParcel.writeInt(paramArrayOfBigDecimal[paramInt].scale());
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeBigInteger(Parcel paramParcel, int paramInt, BigInteger paramBigInteger, boolean paramBoolean) {
    if (paramBigInteger == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramBigInteger.toByteArray());
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBigIntegerArray(Parcel paramParcel, int paramInt, BigInteger[] paramArrayOfBigInteger, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfBigInteger == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfBigInteger.length;
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeByteArray(paramArrayOfBigInteger[paramInt].toByteArray()); 
    zzb(paramParcel, i);
  }
  
  public static void writeBoolean(Parcel paramParcel, int paramInt, boolean paramBoolean) {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramBoolean);
  }
  
  public static void writeBooleanArray(Parcel paramParcel, int paramInt, boolean[] paramArrayOfboolean, boolean paramBoolean) {
    if (paramArrayOfboolean == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBooleanArray(paramArrayOfboolean);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeBooleanList(Parcel paramParcel, int paramInt, List<Boolean> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeInt(((Boolean)paramList.get(paramInt)).booleanValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeBooleanObject(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1) {
    if (paramBoolean == null) {
      if (paramBoolean1)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramBoolean.booleanValue());
  }
  
  public static void writeBundle(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean) {
    if (paramBundle == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBundle(paramBundle);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeByte(Parcel paramParcel, int paramInt, byte paramByte) {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void writeByteArray(Parcel paramParcel, int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeByteArray(paramArrayOfbyte);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeByteArrayArray(Parcel paramParcel, int paramInt, byte[][] paramArrayOfbyte, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfbyte == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfbyte.length;
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeByteArray(paramArrayOfbyte[paramInt]); 
    zzb(paramParcel, i);
  }
  
  public static void writeByteArraySparseArray(Parcel paramParcel, int paramInt, SparseArray<byte[]> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeByteArray((byte[])paramSparseArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeChar(Parcel paramParcel, int paramInt, char paramChar) {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramChar);
  }
  
  public static void writeCharArray(Parcel paramParcel, int paramInt, char[] paramArrayOfchar, boolean paramBoolean) {
    if (paramArrayOfchar == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeCharArray(paramArrayOfchar);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeDouble(Parcel paramParcel, int paramInt, double paramDouble) {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void writeDoubleArray(Parcel paramParcel, int paramInt, double[] paramArrayOfdouble, boolean paramBoolean) {
    if (paramArrayOfdouble == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeDoubleArray(paramArrayOfdouble);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeDoubleList(Parcel paramParcel, int paramInt, List<Double> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeDouble(((Double)paramList.get(paramInt)).doubleValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeDoubleObject(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean) {
    if (paramDouble == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble.doubleValue());
  }
  
  public static void writeDoubleSparseArray(Parcel paramParcel, int paramInt, SparseArray<Double> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeDouble(((Double)paramSparseArray.valueAt(paramInt)).doubleValue());
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeFloat(Parcel paramParcel, int paramInt, float paramFloat) {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void writeFloatArray(Parcel paramParcel, int paramInt, float[] paramArrayOffloat, boolean paramBoolean) {
    if (paramArrayOffloat == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeFloatArray(paramArrayOffloat);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeFloatList(Parcel paramParcel, int paramInt, List<Float> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeFloat(((Float)paramList.get(paramInt)).floatValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeFloatObject(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean) {
    if (paramFloat == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat.floatValue());
  }
  
  public static void writeFloatSparseArray(Parcel paramParcel, int paramInt, SparseArray<Float> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeFloat(((Float)paramSparseArray.valueAt(paramInt)).floatValue());
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeIBinder(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean) {
    if (paramIBinder == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStrongBinder(paramIBinder);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIBinderArray(Parcel paramParcel, int paramInt, IBinder[] paramArrayOfIBinder, boolean paramBoolean) {
    if (paramArrayOfIBinder == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBinderArray(paramArrayOfIBinder);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIBinderList(Parcel paramParcel, int paramInt, List<IBinder> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeBinderList(paramList);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIBinderSparseArray(Parcel paramParcel, int paramInt, SparseArray<IBinder> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeStrongBinder((IBinder)paramSparseArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeInt(Parcel paramParcel, int paramInt1, int paramInt2) {
    zzb(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void writeIntArray(Parcel paramParcel, int paramInt, int[] paramArrayOfint, boolean paramBoolean) {
    if (paramArrayOfint == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeIntArray(paramArrayOfint);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeIntegerList(Parcel paramParcel, int paramInt, List<Integer> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeIntegerObject(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean) {
    if (paramInteger == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramInteger.intValue());
  }
  
  public static void writeList(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeList(paramList);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeLong(Parcel paramParcel, int paramInt, long paramLong) {
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void writeLongArray(Parcel paramParcel, int paramInt, long[] paramArrayOflong, boolean paramBoolean) {
    if (paramArrayOflong == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeLongArray(paramArrayOflong);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeLongList(Parcel paramParcel, int paramInt, List<Long> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++)
      paramParcel.writeLong(((Long)paramList.get(paramInt)).longValue()); 
    zzb(paramParcel, i);
  }
  
  public static void writeLongObject(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean) {
    if (paramLong == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    zzb(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong.longValue());
  }
  
  public static void writeParcel(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean) {
    if (paramParcel2 == null) {
      if (paramBoolean)
        zzb(paramParcel1, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel1, paramInt);
    paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
    zzb(paramParcel1, paramInt);
  }
  
  public static void writeParcelArray(Parcel paramParcel, int paramInt, Parcel[] paramArrayOfParcel, boolean paramBoolean) {
    if (paramArrayOfParcel == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramArrayOfParcel.length;
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcel parcel = paramArrayOfParcel[paramInt];
      if (parcel != null) {
        paramParcel.writeInt(parcel.dataSize());
        paramParcel.appendFrom(parcel, 0, parcel.dataSize());
      } else {
        paramParcel.writeInt(0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeParcelList(Parcel paramParcel, int paramInt, List<Parcel> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcel parcel = paramList.get(paramInt);
      if (parcel != null) {
        paramParcel.writeInt(parcel.dataSize());
        paramParcel.appendFrom(parcel, 0, parcel.dataSize());
      } else {
        paramParcel.writeInt(0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeParcelSparseArray(Parcel paramParcel, int paramInt, SparseArray<Parcel> paramSparseArray, boolean paramBoolean) {
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      Parcel parcel = (Parcel)paramSparseArray.valueAt(paramInt);
      if (parcel != null) {
        paramParcel.writeInt(parcel.dataSize());
        paramParcel.appendFrom(parcel, 0, parcel.dataSize());
      } else {
        paramParcel.writeInt(0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeParcelable(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean) {
    if (paramParcelable == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt1, 0); 
      return;
    } 
    paramInt1 = zza(paramParcel, paramInt1);
    paramParcelable.writeToParcel(paramParcel, paramInt2);
    zzb(paramParcel, paramInt1);
  }
  
  public static void writeShort(Parcel paramParcel, int paramInt, short paramShort) {
    zzb(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void writeSparseBooleanArray(Parcel paramParcel, int paramInt, SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean) {
    if (paramSparseBooleanArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeSparseBooleanArray(paramSparseBooleanArray);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeSparseIntArray(Parcel paramParcel, int paramInt, SparseIntArray paramSparseIntArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseIntArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseIntArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseIntArray.keyAt(paramInt));
      paramParcel.writeInt(paramSparseIntArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeSparseLongArray(Parcel paramParcel, int paramInt, SparseLongArray paramSparseLongArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseLongArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseLongArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseLongArray.keyAt(paramInt));
      paramParcel.writeLong(paramSparseLongArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean) {
    if (paramString == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeString(paramString);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeStringArray(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean) {
    if (paramArrayOfString == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStringArray(paramArrayOfString);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeStringList(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    paramInt = zza(paramParcel, paramInt);
    paramParcel.writeStringList(paramList);
    zzb(paramParcel, paramInt);
  }
  
  public static void writeStringSparseArray(Parcel paramParcel, int paramInt, SparseArray<String> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = bool; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      paramParcel.writeString((String)paramSparseArray.valueAt(paramInt));
    } 
    zzb(paramParcel, i);
  }
  
  public static <T extends Parcelable> void writeTypedArray(Parcel paramParcel, int paramInt1, T[] paramArrayOfT, int paramInt2, boolean paramBoolean) {
    if (paramArrayOfT == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt1, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt1);
    int j = paramArrayOfT.length;
    paramParcel.writeInt(j);
    for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
      T t = paramArrayOfT[paramInt1];
      if (t == null) {
        paramParcel.writeInt(0);
      } else {
        zza(paramParcel, t, paramInt2);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static <T extends Parcelable> void writeTypedList(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean) {
    if (paramList == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramList.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      Parcelable parcelable = (Parcelable)paramList.get(paramInt);
      if (parcelable == null) {
        paramParcel.writeInt(0);
      } else {
        zza(paramParcel, parcelable, 0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  public static <T extends Parcelable> void writeTypedSparseArray(Parcel paramParcel, int paramInt, SparseArray<T> paramSparseArray, boolean paramBoolean) {
    if (paramSparseArray == null) {
      if (paramBoolean)
        zzb(paramParcel, paramInt, 0); 
      return;
    } 
    int i = zza(paramParcel, paramInt);
    int j = paramSparseArray.size();
    paramParcel.writeInt(j);
    for (paramInt = 0; paramInt < j; paramInt++) {
      paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
      Parcelable parcelable = (Parcelable)paramSparseArray.valueAt(paramInt);
      if (parcelable == null) {
        paramParcel.writeInt(0);
      } else {
        zza(paramParcel, parcelable, 0);
      } 
    } 
    zzb(paramParcel, i);
  }
  
  private static int zza(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(paramInt | 0xFFFF0000);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static <T extends Parcelable> void zza(Parcel paramParcel, T paramT, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramT.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  private static void zzb(Parcel paramParcel, int paramInt1, int paramInt2) {
    if (paramInt2 >= 65535) {
      paramParcel.writeInt(paramInt1 | 0xFFFF0000);
      paramParcel.writeInt(paramInt2);
      return;
    } 
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\SafeParcelWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */