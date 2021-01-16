package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class HexDumpUtils {
  @KeepForSdk
  public static String dump(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 391
    //   4: aload_0
    //   5: arraylength
    //   6: ifeq -> 391
    //   9: iload_1
    //   10: iflt -> 391
    //   13: iload_2
    //   14: ifle -> 391
    //   17: iload_1
    //   18: iload_2
    //   19: iadd
    //   20: aload_0
    //   21: arraylength
    //   22: if_icmple -> 28
    //   25: goto -> 391
    //   28: bipush #57
    //   30: istore #4
    //   32: iload_3
    //   33: ifeq -> 40
    //   36: bipush #75
    //   38: istore #4
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: iload #4
    //   46: iload_2
    //   47: bipush #16
    //   49: iadd
    //   50: iconst_1
    //   51: isub
    //   52: bipush #16
    //   54: idiv
    //   55: imul
    //   56: invokespecial <init> : (I)V
    //   59: astore #5
    //   61: iload_2
    //   62: istore #4
    //   64: iconst_0
    //   65: istore #6
    //   67: iconst_0
    //   68: istore #7
    //   70: iload #4
    //   72: ifle -> 385
    //   75: iload #6
    //   77: ifne -> 139
    //   80: iload_2
    //   81: ldc 65536
    //   83: if_icmpge -> 111
    //   86: aload #5
    //   88: ldc '%04X:'
    //   90: iconst_1
    //   91: anewarray java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: iload_1
    //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: goto -> 133
    //   111: aload #5
    //   113: ldc '%08X:'
    //   115: iconst_1
    //   116: anewarray java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: iload_1
    //   122: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iload_1
    //   134: istore #8
    //   136: goto -> 162
    //   139: iload #7
    //   141: istore #8
    //   143: iload #6
    //   145: bipush #8
    //   147: if_icmpne -> 162
    //   150: aload #5
    //   152: ldc ' -'
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: iload #7
    //   160: istore #8
    //   162: aload #5
    //   164: ldc ' %02X'
    //   166: iconst_1
    //   167: anewarray java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_0
    //   173: iload_1
    //   174: baload
    //   175: sipush #255
    //   178: iand
    //   179: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: iload #4
    //   192: iconst_1
    //   193: isub
    //   194: istore #9
    //   196: iload #6
    //   198: iconst_1
    //   199: iadd
    //   200: istore #7
    //   202: iload_3
    //   203: ifeq -> 340
    //   206: iload #7
    //   208: bipush #16
    //   210: if_icmpeq -> 218
    //   213: iload #9
    //   215: ifne -> 340
    //   218: bipush #16
    //   220: iload #7
    //   222: isub
    //   223: istore #6
    //   225: iload #6
    //   227: ifle -> 254
    //   230: iconst_0
    //   231: istore #4
    //   233: iload #4
    //   235: iload #6
    //   237: if_icmpge -> 254
    //   240: aload #5
    //   242: ldc '   '
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: iinc #4, 1
    //   251: goto -> 233
    //   254: iload #6
    //   256: bipush #8
    //   258: if_icmplt -> 269
    //   261: aload #5
    //   263: ldc '  '
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload #5
    //   271: ldc '  '
    //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: iconst_0
    //   278: istore #4
    //   280: iload #4
    //   282: iload #7
    //   284: if_icmpge -> 340
    //   287: aload_0
    //   288: iload #8
    //   290: iload #4
    //   292: iadd
    //   293: baload
    //   294: i2c
    //   295: istore #6
    //   297: iload #6
    //   299: bipush #32
    //   301: if_icmplt -> 318
    //   304: iload #6
    //   306: bipush #126
    //   308: if_icmpgt -> 318
    //   311: iload #6
    //   313: istore #10
    //   315: goto -> 326
    //   318: bipush #46
    //   320: istore #6
    //   322: iload #6
    //   324: istore #10
    //   326: aload #5
    //   328: iload #10
    //   330: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: iinc #4, 1
    //   337: goto -> 280
    //   340: iload #7
    //   342: bipush #16
    //   344: if_icmpeq -> 356
    //   347: iload #7
    //   349: istore #4
    //   351: iload #9
    //   353: ifne -> 367
    //   356: aload #5
    //   358: bipush #10
    //   360: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: iconst_0
    //   365: istore #4
    //   367: iinc #1, 1
    //   370: iload #4
    //   372: istore #6
    //   374: iload #8
    //   376: istore #7
    //   378: iload #9
    //   380: istore #4
    //   382: goto -> 70
    //   385: aload #5
    //   387: invokevirtual toString : ()Ljava/lang/String;
    //   390: areturn
    //   391: aconst_null
    //   392: areturn
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\commo\\util\HexDumpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */