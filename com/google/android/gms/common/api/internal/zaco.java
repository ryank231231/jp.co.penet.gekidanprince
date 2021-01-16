package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zal;

final class zaco extends zal {
  public zaco(zacm paramzacm, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_1
    //   1: getfield what : I
    //   4: tableswitch default -> 28, 0 -> 119, 1 -> 67
    //   28: aload_1
    //   29: getfield what : I
    //   32: istore_2
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: bipush #70
    //   39: invokespecial <init> : (I)V
    //   42: astore_1
    //   43: aload_1
    //   44: ldc 'TransformationResultHandler received unknown message type: '
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: iload_2
    //   52: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 'TransformedResultImpl'
    //   58: aload_1
    //   59: invokevirtual toString : ()Ljava/lang/String;
    //   62: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   65: pop
    //   66: return
    //   67: aload_1
    //   68: getfield obj : Ljava/lang/Object;
    //   71: checkcast java/lang/RuntimeException
    //   74: astore_3
    //   75: aload_3
    //   76: invokevirtual getMessage : ()Ljava/lang/String;
    //   79: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual length : ()I
    //   87: ifeq -> 100
    //   90: ldc 'Runtime exception on the transformation worker thread: '
    //   92: aload_1
    //   93: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_1
    //   97: goto -> 110
    //   100: new java/lang/String
    //   103: dup
    //   104: ldc 'Runtime exception on the transformation worker thread: '
    //   106: invokespecial <init> : (Ljava/lang/String;)V
    //   109: astore_1
    //   110: ldc 'TransformedResultImpl'
    //   112: aload_1
    //   113: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   116: pop
    //   117: aload_3
    //   118: athrow
    //   119: aload_1
    //   120: getfield obj : Ljava/lang/Object;
    //   123: checkcast com/google/android/gms/common/api/PendingResult
    //   126: astore_3
    //   127: aload_0
    //   128: getfield zakv : Lcom/google/android/gms/common/api/internal/zacm;
    //   131: invokestatic zaf : (Lcom/google/android/gms/common/api/internal/zacm;)Ljava/lang/Object;
    //   134: astore_1
    //   135: aload_1
    //   136: monitorenter
    //   137: aload_3
    //   138: ifnonnull -> 172
    //   141: aload_0
    //   142: getfield zakv : Lcom/google/android/gms/common/api/internal/zacm;
    //   145: invokestatic zag : (Lcom/google/android/gms/common/api/internal/zacm;)Lcom/google/android/gms/common/api/internal/zacm;
    //   148: astore_3
    //   149: new com/google/android/gms/common/api/Status
    //   152: astore #4
    //   154: aload #4
    //   156: bipush #13
    //   158: ldc 'Transform returned null'
    //   160: invokespecial <init> : (ILjava/lang/String;)V
    //   163: aload_3
    //   164: aload #4
    //   166: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/zacm;Lcom/google/android/gms/common/api/Status;)V
    //   169: goto -> 210
    //   172: aload_3
    //   173: instanceof com/google/android/gms/common/api/internal/zacd
    //   176: ifeq -> 199
    //   179: aload_0
    //   180: getfield zakv : Lcom/google/android/gms/common/api/internal/zacm;
    //   183: invokestatic zag : (Lcom/google/android/gms/common/api/internal/zacm;)Lcom/google/android/gms/common/api/internal/zacm;
    //   186: aload_3
    //   187: checkcast com/google/android/gms/common/api/internal/zacd
    //   190: invokevirtual getStatus : ()Lcom/google/android/gms/common/api/Status;
    //   193: invokestatic zaa : (Lcom/google/android/gms/common/api/internal/zacm;Lcom/google/android/gms/common/api/Status;)V
    //   196: goto -> 210
    //   199: aload_0
    //   200: getfield zakv : Lcom/google/android/gms/common/api/internal/zacm;
    //   203: invokestatic zag : (Lcom/google/android/gms/common/api/internal/zacm;)Lcom/google/android/gms/common/api/internal/zacm;
    //   206: aload_3
    //   207: invokevirtual zaa : (Lcom/google/android/gms/common/api/PendingResult;)V
    //   210: aload_1
    //   211: monitorexit
    //   212: return
    //   213: astore_3
    //   214: aload_1
    //   215: monitorexit
    //   216: aload_3
    //   217: athrow
    // Exception table:
    //   from	to	target	type
    //   141	169	213	finally
    //   172	196	213	finally
    //   199	210	213	finally
    //   210	212	213	finally
    //   214	216	213	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\common\api\internal\zaco.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */