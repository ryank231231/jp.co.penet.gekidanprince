package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class Preconditions {
  private static String badElementIndex(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 < 0)
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
    if (paramInt2 >= 0)
      return format("%s (%s) must be less than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("negative size: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static String badPositionIndex(int paramInt1, int paramInt2, String paramString) {
    if (paramInt1 < 0)
      return format("%s (%s) must not be negative", new Object[] { paramString, Integer.valueOf(paramInt1) }); 
    if (paramInt2 >= 0)
      return format("%s (%s) must not be greater than size (%s)", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("negative size: ");
    stringBuilder.append(paramInt2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private static String badPositionIndexes(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 < 0 || paramInt1 > paramInt3) ? badPositionIndex(paramInt1, paramInt3, "start index") : ((paramInt2 < 0 || paramInt2 > paramInt3) ? badPositionIndex(paramInt2, paramInt3, "end index") : format("end index (%s) must not be less than start index (%s)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
  }
  
  public static void checkArgument(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException();
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar1, char paramChar2) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, char paramChar, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt1, int paramInt2) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, int paramInt, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong1, long paramLong2) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, long paramLong, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
  }
  
  public static void checkArgument(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(format(paramString, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public static int checkElementIndex(int paramInt1, int paramInt2) {
    return checkElementIndex(paramInt1, paramInt2, "index");
  }
  
  @CanIgnoreReturnValue
  public static int checkElementIndex(int paramInt1, int paramInt2, @Nullable String paramString) {
    if (paramInt1 >= 0 && paramInt1 < paramInt2)
      return paramInt1; 
    throw new IndexOutOfBoundsException(badElementIndex(paramInt1, paramInt2, paramString));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar1, char paramChar2) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar, int paramInt) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar, long paramLong) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, char paramChar, @Nullable Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt, char paramChar) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt1, int paramInt2) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt, long paramLong) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, int paramInt, @Nullable Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong, char paramChar) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong, int paramInt) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong1, long paramLong2) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, long paramLong, @Nullable Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject, char paramChar) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject, int paramInt) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject, long paramLong) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
  }
  
  @CanIgnoreReturnValue
  public static <T> T checkNotNull(T paramT, @Nullable String paramString, @Nullable Object... paramVarArgs) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(format(paramString, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public static int checkPositionIndex(int paramInt1, int paramInt2) {
    return checkPositionIndex(paramInt1, paramInt2, "index");
  }
  
  @CanIgnoreReturnValue
  public static int checkPositionIndex(int paramInt1, int paramInt2, @Nullable String paramString) {
    if (paramInt1 >= 0 && paramInt1 <= paramInt2)
      return paramInt1; 
    throw new IndexOutOfBoundsException(badPositionIndex(paramInt1, paramInt2, paramString));
  }
  
  public static void checkPositionIndexes(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0 && paramInt2 >= paramInt1 && paramInt2 <= paramInt3)
      return; 
    throw new IndexOutOfBoundsException(badPositionIndexes(paramInt1, paramInt2, paramInt3));
  }
  
  public static void checkState(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void checkState(boolean paramBoolean, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar1, char paramChar2) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar1), Character.valueOf(paramChar2) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar), Integer.valueOf(paramInt) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar), Long.valueOf(paramLong) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, char paramChar, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Character.valueOf(paramChar), paramObject }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt), Character.valueOf(paramChar) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt1, int paramInt2) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, int paramInt, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Integer.valueOf(paramInt), paramObject }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong), Character.valueOf(paramChar) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong1, long paramLong2) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, long paramLong, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { Long.valueOf(paramLong), paramObject }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, char paramChar) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject, Character.valueOf(paramChar) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, int paramInt) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject, Integer.valueOf(paramInt) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject, long paramLong) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject, Long.valueOf(paramLong) }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject1, paramObject2 }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3 }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 }));
  }
  
  public static void checkState(boolean paramBoolean, @Nullable String paramString, @Nullable Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(format(paramString, paramVarArgs));
  }
  
  static String format(String paramString, @Nullable Object... paramVarArgs) {
    String str = String.valueOf(paramString);
    StringBuilder stringBuilder = new StringBuilder(str.length() + paramVarArgs.length * 16);
    int i = 0;
    int j = 0;
    while (i < paramVarArgs.length) {
      int k = str.indexOf("%s", j);
      if (k == -1)
        break; 
      stringBuilder.append(str, j, k);
      stringBuilder.append(paramVarArgs[i]);
      j = k + 2;
      i++;
    } 
    stringBuilder.append(str, j, str.length());
    if (i < paramVarArgs.length) {
      stringBuilder.append(" [");
      j = i + 1;
      stringBuilder.append(paramVarArgs[i]);
      for (i = j; i < paramVarArgs.length; i++) {
        stringBuilder.append(", ");
        stringBuilder.append(paramVarArgs[i]);
      } 
      stringBuilder.append(']');
    } 
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */