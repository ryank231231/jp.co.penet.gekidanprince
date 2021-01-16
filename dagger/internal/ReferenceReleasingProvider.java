package dagger.internal;

import java.lang.ref.WeakReference;
import javax.inject.Provider;

@GwtIncompatible
public final class ReferenceReleasingProvider<T> implements Provider<T> {
  private static final Object NULL = new Object();
  
  private final Provider<T> provider;
  
  private volatile Object strongReference;
  
  private volatile WeakReference<T> weakReference;
  
  private ReferenceReleasingProvider(Provider<T> paramProvider) {
    this.provider = paramProvider;
  }
  
  public static <T> ReferenceReleasingProvider<T> create(Provider<T> paramProvider, ReferenceReleasingProviderManager paramReferenceReleasingProviderManager) {
    paramProvider = new ReferenceReleasingProvider<T>(Preconditions.<Provider<T>>checkNotNull(paramProvider));
    paramReferenceReleasingProviderManager.addProvider((ReferenceReleasingProvider<?>)paramProvider);
    return (ReferenceReleasingProvider<T>)paramProvider;
  }
  
  private Object currentValue() {
    Object object = this.strongReference;
    return (object != null) ? object : (Object)((this.weakReference != null) ? this.weakReference.get() : null);
  }
  
  public T get() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial currentValue : ()Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: ifnonnull -> 59
    //   11: aload_0
    //   12: monitorenter
    //   13: aload_0
    //   14: invokespecial currentValue : ()Ljava/lang/Object;
    //   17: astore_1
    //   18: aload_1
    //   19: astore_2
    //   20: aload_1
    //   21: ifnonnull -> 49
    //   24: aload_0
    //   25: getfield provider : Ljavax/inject/Provider;
    //   28: invokeinterface get : ()Ljava/lang/Object;
    //   33: astore_1
    //   34: aload_1
    //   35: astore_2
    //   36: aload_1
    //   37: ifnonnull -> 44
    //   40: getstatic dagger/internal/ReferenceReleasingProvider.NULL : Ljava/lang/Object;
    //   43: astore_2
    //   44: aload_0
    //   45: aload_2
    //   46: putfield strongReference : Ljava/lang/Object;
    //   49: aload_0
    //   50: monitorexit
    //   51: goto -> 59
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: getstatic dagger/internal/ReferenceReleasingProvider.NULL : Ljava/lang/Object;
    //   65: if_acmpne -> 70
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: areturn
    // Exception table:
    //   from	to	target	type
    //   13	18	54	finally
    //   24	34	54	finally
    //   40	44	54	finally
    //   44	49	54	finally
    //   49	51	54	finally
    //   55	57	54	finally
  }
  
  public void releaseStrongReference() {
    // Byte code:
    //   0: aload_0
    //   1: getfield strongReference : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull -> 47
    //   9: aload_1
    //   10: getstatic dagger/internal/ReferenceReleasingProvider.NULL : Ljava/lang/Object;
    //   13: if_acmpeq -> 47
    //   16: aload_0
    //   17: monitorenter
    //   18: new java/lang/ref/WeakReference
    //   21: astore_2
    //   22: aload_2
    //   23: aload_1
    //   24: invokespecial <init> : (Ljava/lang/Object;)V
    //   27: aload_0
    //   28: aload_2
    //   29: putfield weakReference : Ljava/lang/ref/WeakReference;
    //   32: aload_0
    //   33: aconst_null
    //   34: putfield strongReference : Ljava/lang/Object;
    //   37: aload_0
    //   38: monitorexit
    //   39: goto -> 47
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: return
    // Exception table:
    //   from	to	target	type
    //   18	39	42	finally
    //   43	45	42	finally
  }
  
  public void restoreStrongReference() {
    // Byte code:
    //   0: aload_0
    //   1: getfield strongReference : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_0
    //   6: getfield weakReference : Ljava/lang/ref/WeakReference;
    //   9: ifnull -> 66
    //   12: aload_1
    //   13: ifnonnull -> 66
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield strongReference : Ljava/lang/Object;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield weakReference : Ljava/lang/ref/WeakReference;
    //   27: ifnull -> 56
    //   30: aload_1
    //   31: ifnonnull -> 56
    //   34: aload_0
    //   35: getfield weakReference : Ljava/lang/ref/WeakReference;
    //   38: invokevirtual get : ()Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull -> 56
    //   46: aload_0
    //   47: aload_1
    //   48: putfield strongReference : Ljava/lang/Object;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield weakReference : Ljava/lang/ref/WeakReference;
    //   56: aload_0
    //   57: monitorexit
    //   58: goto -> 66
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: return
    // Exception table:
    //   from	to	target	type
    //   18	30	61	finally
    //   34	42	61	finally
    //   46	56	61	finally
    //   56	58	61	finally
    //   62	64	61	finally
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\ReferenceReleasingProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */