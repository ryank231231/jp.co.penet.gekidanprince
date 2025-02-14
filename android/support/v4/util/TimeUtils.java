package android.support.v4.util;

import android.support.annotation.RestrictTo;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TimeUtils {
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  
  private static final int SECONDS_PER_DAY = 86400;
  
  private static final int SECONDS_PER_HOUR = 3600;
  
  private static final int SECONDS_PER_MINUTE = 60;
  
  private static char[] sFormatStr;
  
  private static final Object sFormatSync = new Object();
  
  static {
    sFormatStr = new char[24];
  }
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3) {
    return (paramInt1 > 99 || (paramBoolean && paramInt3 >= 3)) ? (paramInt2 + 3) : ((paramInt1 > 9 || (paramBoolean && paramInt3 >= 2)) ? (paramInt2 + 2) : ((paramBoolean || paramInt1 > 0) ? (paramInt2 + 1) : 0));
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter) {
    if (paramLong1 == 0L) {
      paramPrintWriter.print("--");
      return;
    } 
    formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter) {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt) {
    synchronized (sFormatSync) {
      paramInt = formatDurationLocked(paramLong, paramInt);
      String str = new String();
      this(sFormatStr, 0, paramInt);
      paramPrintWriter.print(str);
      return;
    } 
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder) {
    synchronized (sFormatSync) {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    } 
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt) {
    boolean bool1;
    int i1;
    boolean bool2;
    byte b;
    if (sFormatStr.length < paramInt)
      sFormatStr = new char[paramInt]; 
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L) {
      while (paramInt - 1 > 0)
        arrayOfChar[0] = (char)' '; 
      arrayOfChar[0] = (char)'0';
      return 1;
    } 
    if (paramLong > 0L) {
      i = 43;
    } else {
      i = 45;
      paramLong = -paramLong;
    } 
    int j = (int)(paramLong % 1000L);
    int k = (int)Math.floor((paramLong / 1000L));
    if (k > 86400) {
      m = k / 86400;
      k -= 86400 * m;
    } else {
      m = 0;
    } 
    if (k > 3600) {
      n = k / 3600;
      k -= n * 3600;
    } else {
      n = 0;
    } 
    if (k > 60) {
      bool1 = k / 60;
      i1 = k - bool1 * 60;
    } else {
      bool1 = false;
      i1 = k;
    } 
    if (paramInt != 0) {
      k = accumField(m, 1, false, 0);
      if (k > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      k += accumField(n, 1, bool2, 2);
      if (k > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      k += accumField(bool1, 1, bool2, 2);
      if (k > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      int i2 = k + accumField(i1, 1, bool2, 2);
      if (i2 > 0) {
        k = 3;
      } else {
        k = 0;
      } 
      i2 += accumField(j, 2, true, k) + 1;
      k = 0;
      while (true) {
        b = k;
        if (i2 < paramInt) {
          arrayOfChar[k] = (char)' ';
          k++;
          i2++;
          continue;
        } 
        break;
      } 
    } else {
      b = 0;
    } 
    arrayOfChar[b] = (char)i;
    int i = b + 1;
    if (paramInt != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    int m = printField(arrayOfChar, m, 'd', i, false, 0);
    if (m != i) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramInt != 0) {
      k = 2;
    } else {
      k = 0;
    } 
    int n = printField(arrayOfChar, n, 'h', m, bool2, k);
    if (n != i) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramInt != 0) {
      k = 2;
    } else {
      k = 0;
    } 
    n = printField(arrayOfChar, bool1, 'm', n, bool2, k);
    if (n != i) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramInt != 0) {
      k = 2;
    } else {
      k = 0;
    } 
    k = printField(arrayOfChar, i1, 's', n, bool2, k);
    if (paramInt != 0 && k != i) {
      paramInt = 3;
    } else {
      paramInt = 0;
    } 
    paramInt = printField(arrayOfChar, j, 'm', k, true, paramInt);
    arrayOfChar[paramInt] = (char)'s';
    return paramInt + 1;
  }
  
  private static int printField(char[] paramArrayOfchar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3) {
    // Byte code:
    //   0: iload #4
    //   2: ifne -> 12
    //   5: iload_3
    //   6: istore #6
    //   8: iload_1
    //   9: ifle -> 149
    //   12: iload #4
    //   14: ifeq -> 23
    //   17: iload #5
    //   19: iconst_3
    //   20: if_icmpge -> 29
    //   23: iload_1
    //   24: bipush #99
    //   26: if_icmple -> 61
    //   29: iload_1
    //   30: bipush #100
    //   32: idiv
    //   33: istore #7
    //   35: aload_0
    //   36: iload_3
    //   37: iload #7
    //   39: bipush #48
    //   41: iadd
    //   42: i2c
    //   43: i2c
    //   44: castore
    //   45: iload_3
    //   46: iconst_1
    //   47: iadd
    //   48: istore #6
    //   50: iload_1
    //   51: iload #7
    //   53: bipush #100
    //   55: imul
    //   56: isub
    //   57: istore_1
    //   58: goto -> 64
    //   61: iload_3
    //   62: istore #6
    //   64: iload #4
    //   66: ifeq -> 75
    //   69: iload #5
    //   71: iconst_2
    //   72: if_icmpge -> 94
    //   75: iload_1
    //   76: bipush #9
    //   78: if_icmpgt -> 94
    //   81: iload #6
    //   83: istore #7
    //   85: iload_1
    //   86: istore #5
    //   88: iload_3
    //   89: iload #6
    //   91: if_icmpeq -> 123
    //   94: iload_1
    //   95: bipush #10
    //   97: idiv
    //   98: istore_3
    //   99: aload_0
    //   100: iload #6
    //   102: iload_3
    //   103: bipush #48
    //   105: iadd
    //   106: i2c
    //   107: i2c
    //   108: castore
    //   109: iload #6
    //   111: iconst_1
    //   112: iadd
    //   113: istore #7
    //   115: iload_1
    //   116: iload_3
    //   117: bipush #10
    //   119: imul
    //   120: isub
    //   121: istore #5
    //   123: aload_0
    //   124: iload #7
    //   126: iload #5
    //   128: bipush #48
    //   130: iadd
    //   131: i2c
    //   132: i2c
    //   133: castore
    //   134: iload #7
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: aload_0
    //   140: iload_1
    //   141: iload_2
    //   142: i2c
    //   143: castore
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore #6
    //   149: iload #6
    //   151: ireturn
  }
}


/* Location:              Y:\classes-dex2jar.jar!\android\support\v\\util\TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */