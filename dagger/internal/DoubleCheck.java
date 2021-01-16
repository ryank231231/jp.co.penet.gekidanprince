package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
  private static final Object UNINITIALIZED = new Object();
  
  private volatile Object instance = UNINITIALIZED;
  
  private volatile Provider<T> provider;
  
  private DoubleCheck(Provider<T> paramProvider) {
    this.provider = paramProvider;
  }
  
  public static <T> Lazy<T> lazy(Provider<T> paramProvider) {
    return (paramProvider instanceof Lazy) ? (Lazy<T>)paramProvider : new DoubleCheck<T>(Preconditions.<Provider<T>>checkNotNull(paramProvider));
  }
  
  public static <T> Provider<T> provider(Provider<T> paramProvider) {
    Preconditions.checkNotNull(paramProvider);
    return (paramProvider instanceof DoubleCheck) ? paramProvider : new DoubleCheck<T>(paramProvider);
  }
  
  public T get() {
    // Byte code:
    //   0: aload_0
    //   1: getfield instance : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: getstatic dagger/internal/DoubleCheck.UNINITIALIZED : Ljava/lang/Object;
    //   11: if_acmpne -> 138
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield instance : Ljava/lang/Object;
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: getstatic dagger/internal/DoubleCheck.UNINITIALIZED : Ljava/lang/Object;
    //   27: if_acmpne -> 128
    //   30: aload_0
    //   31: getfield provider : Ljavax/inject/Provider;
    //   34: invokeinterface get : ()Ljava/lang/Object;
    //   39: astore_2
    //   40: aload_0
    //   41: getfield instance : Ljava/lang/Object;
    //   44: astore_3
    //   45: aload_3
    //   46: getstatic dagger/internal/DoubleCheck.UNINITIALIZED : Ljava/lang/Object;
    //   49: if_acmpeq -> 118
    //   52: aload_3
    //   53: aload_2
    //   54: if_acmpne -> 60
    //   57: goto -> 118
    //   60: new java/lang/IllegalStateException
    //   63: astore #4
    //   65: new java/lang/StringBuilder
    //   68: astore_1
    //   69: aload_1
    //   70: invokespecial <init> : ()V
    //   73: aload_1
    //   74: ldc 'Scoped provider was invoked recursively returning different results: '
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: aload_3
    //   82: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: ldc ' & '
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: aload_2
    //   95: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_1
    //   100: ldc '. This is likely due to a circular dependency.'
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #4
    //   108: aload_1
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokespecial <init> : (Ljava/lang/String;)V
    //   115: aload #4
    //   117: athrow
    //   118: aload_0
    //   119: aload_2
    //   120: putfield instance : Ljava/lang/Object;
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield provider : Ljavax/inject/Provider;
    //   128: aload_0
    //   129: monitorexit
    //   130: goto -> 138
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: aload_2
    //   139: areturn
    // Exception table:
    //   from	to	target	type
    //   16	21	133	finally
    //   23	52	133	finally
    //   60	118	133	finally
    //   118	128	133	finally
    //   128	130	133	finally
    //   134	136	133	finally
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\DoubleCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */