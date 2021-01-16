package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@GwtIncompatible
abstract class LineBuffer {
  private StringBuilder line = new StringBuilder();
  
  private boolean sawReturn;
  
  @CanIgnoreReturnValue
  private boolean finishLine(boolean paramBoolean) throws IOException {
    String str;
    if (this.sawReturn) {
      if (paramBoolean) {
        str = "\r\n";
      } else {
        str = "\r";
      } 
    } else if (paramBoolean) {
      str = "\n";
    } else {
      str = "";
    } 
    handleLine(this.line.toString(), str);
    this.line = new StringBuilder();
    this.sawReturn = false;
    return paramBoolean;
  }
  
  protected void add(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield sawReturn : Z
    //   4: ifeq -> 45
    //   7: iload_3
    //   8: ifle -> 45
    //   11: aload_1
    //   12: iload_2
    //   13: caload
    //   14: bipush #10
    //   16: if_icmpne -> 25
    //   19: iconst_1
    //   20: istore #4
    //   22: goto -> 28
    //   25: iconst_0
    //   26: istore #4
    //   28: aload_0
    //   29: iload #4
    //   31: invokespecial finishLine : (Z)Z
    //   34: ifeq -> 45
    //   37: iload_2
    //   38: iconst_1
    //   39: iadd
    //   40: istore #5
    //   42: goto -> 48
    //   45: iload_2
    //   46: istore #5
    //   48: iload_2
    //   49: iload_3
    //   50: iadd
    //   51: istore #6
    //   53: iload #5
    //   55: istore_3
    //   56: iload #5
    //   58: istore_2
    //   59: iload_2
    //   60: iload #6
    //   62: if_icmpge -> 193
    //   65: aload_1
    //   66: iload_2
    //   67: caload
    //   68: istore #5
    //   70: iload #5
    //   72: bipush #10
    //   74: if_icmpeq -> 164
    //   77: iload #5
    //   79: bipush #13
    //   81: if_icmpeq -> 87
    //   84: goto -> 187
    //   87: aload_0
    //   88: getfield line : Ljava/lang/StringBuilder;
    //   91: aload_1
    //   92: iload_3
    //   93: iload_2
    //   94: iload_3
    //   95: isub
    //   96: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield sawReturn : Z
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore #5
    //   110: iload_2
    //   111: istore_3
    //   112: iload #5
    //   114: iload #6
    //   116: if_icmpge -> 151
    //   119: aload_1
    //   120: iload #5
    //   122: caload
    //   123: bipush #10
    //   125: if_icmpne -> 134
    //   128: iconst_1
    //   129: istore #4
    //   131: goto -> 137
    //   134: iconst_0
    //   135: istore #4
    //   137: iload_2
    //   138: istore_3
    //   139: aload_0
    //   140: iload #4
    //   142: invokespecial finishLine : (Z)Z
    //   145: ifeq -> 151
    //   148: iload #5
    //   150: istore_3
    //   151: iload_3
    //   152: iconst_1
    //   153: iadd
    //   154: istore #5
    //   156: iload_3
    //   157: istore_2
    //   158: iload #5
    //   160: istore_3
    //   161: goto -> 187
    //   164: aload_0
    //   165: getfield line : Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: iload_3
    //   170: iload_2
    //   171: iload_3
    //   172: isub
    //   173: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_0
    //   178: iconst_1
    //   179: invokespecial finishLine : (Z)Z
    //   182: pop
    //   183: iload_2
    //   184: iconst_1
    //   185: iadd
    //   186: istore_3
    //   187: iinc #2, 1
    //   190: goto -> 59
    //   193: aload_0
    //   194: getfield line : Ljava/lang/StringBuilder;
    //   197: aload_1
    //   198: iload_3
    //   199: iload #6
    //   201: iload_3
    //   202: isub
    //   203: invokevirtual append : ([CII)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: return
  }
  
  protected void finish() throws IOException {
    if (this.sawReturn || this.line.length() > 0)
      finishLine(false); 
  }
  
  protected abstract void handleLine(String paramString1, String paramString2) throws IOException;
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\io\LineBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */