package com.google.android.gms.common.util;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
  @KeepForSdk
  public static boolean isEmpty(@Nullable Collection<?> paramCollection) {
    return (paramCollection == null) ? true : paramCollection.isEmpty();
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf() {
    return Collections.emptyList();
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf(T paramT) {
    return Collections.singletonList(paramT);
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> List<T> listOf(T... paramVarArgs) {
    switch (paramVarArgs.length) {
      default:
        return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
      case 1:
        return listOf(paramVarArgs[0]);
      case 0:
        break;
    } 
    return listOf();
  }
  
  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3) {
    Map<?, ?> map = zzb(3, false);
    map.put(paramK1, paramV1);
    map.put(paramK2, paramV2);
    map.put(paramK3, paramV3);
    return Collections.unmodifiableMap((Map)map);
  }
  
  @KeepForSdk
  public static <K, V> Map<K, V> mapOf(K paramK1, V paramV1, K paramK2, V paramV2, K paramK3, V paramV3, K paramK4, V paramV4, K paramK5, V paramV5, K paramK6, V paramV6) {
    Map<?, ?> map = zzb(6, false);
    map.put(paramK1, paramV1);
    map.put(paramK2, paramV2);
    map.put(paramK3, paramV3);
    map.put(paramK4, paramV4);
    map.put(paramK5, paramV5);
    map.put(paramK6, paramV6);
    return Collections.unmodifiableMap((Map)map);
  }
  
  @KeepForSdk
  public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] paramArrayOfK, V[] paramArrayOfV) {
    if (paramArrayOfK.length == paramArrayOfV.length) {
      Map<?, ?> map;
      int k = paramArrayOfK.length;
      byte b = 0;
      switch (k) {
        default:
          map = zzb(paramArrayOfK.length, false);
          break;
        case 1:
          return Collections.singletonMap(paramArrayOfK[0], paramArrayOfV[0]);
        case 0:
          return Collections.emptyMap();
      } 
      while (b < paramArrayOfK.length) {
        map.put(paramArrayOfK[b], paramArrayOfV[b]);
        b++;
      } 
      return Collections.unmodifiableMap((Map)map);
    } 
    int i = paramArrayOfK.length;
    int j = paramArrayOfV.length;
    StringBuilder stringBuilder = new StringBuilder(66);
    stringBuilder.append("Key and values array lengths not equal: ");
    stringBuilder.append(i);
    stringBuilder.append(" != ");
    stringBuilder.append(j);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  @KeepForSdk
  public static <T> Set<T> mutableSetOfWithSize(int paramInt) {
    return (Set<T>)((paramInt == 0) ? new ArraySet() : zza(paramInt, true));
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> Set<T> setOf(T paramT1, T paramT2, T paramT3) {
    Set<?> set = zza(3, false);
    set.add(paramT1);
    set.add(paramT2);
    set.add(paramT3);
    return Collections.unmodifiableSet((Set)set);
  }
  
  @Deprecated
  @KeepForSdk
  public static <T> Set<T> setOf(T... paramVarArgs) {
    Set<?> set1;
    Set<?> set3;
    T t1;
    Set<?> set2;
    T t2;
    Set<?> set4;
    T t3;
    T t4;
    switch (paramVarArgs.length) {
      default:
        set3 = zza(paramVarArgs.length, false);
        Collections.addAll(set3, (Object[])paramVarArgs);
        return Collections.unmodifiableSet((Set)set3);
      case 4:
        t2 = paramVarArgs[0];
        t1 = paramVarArgs[1];
        t3 = paramVarArgs[2];
        t4 = paramVarArgs[3];
        set1 = zza(4, false);
        set1.add(t2);
        set1.add(t1);
        set1.add(t3);
        set1.add(t4);
        return Collections.unmodifiableSet((Set)set1);
      case 3:
        return setOf((T)set1[0], (T)set1[1], (T)set1[2]);
      case 2:
        set2 = set1[0];
        set4 = set1[1];
        set1 = zza(2, false);
        set1.add(set2);
        set1.add(set4);
        return Collections.unmodifiableSet((Set)set1);
      case 1:
        return Collections.singleton((T)set1[0]);
      case 0:
        break;
    } 
    return Collections.emptySet();
  }
  
  private static <T> Set<T> zza(int paramInt, boolean paramBoolean) {
    float f;
    char c;
    if (paramBoolean) {
      f = 0.75F;
    } else {
      f = 1.0F;
    } 
    if (paramBoolean) {
      c = '';
    } else {
      c = 'Ā';
    } 
    return (Set<T>)((paramInt <= c) ? new ArraySet(paramInt) : new HashSet<T>(paramInt, f));
  }
  
  private static <K, V> Map<K, V> zzb(int paramInt, boolean paramBoolean) {
    return (Map<K, V>)((paramInt <= 256) ? new ArrayMap(paramInt) : new HashMap<K, V>(paramInt, 1.0F));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\CollectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */