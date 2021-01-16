package com.google.firebase.components;

import android.support.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

class Lazy<T> implements Provider<T> {
  private static final Object UNINITIALIZED = new Object();
  
  private volatile Object instance = UNINITIALIZED;
  
  private volatile Provider<T> provider;
  
  Lazy(Provider<T> paramProvider) {
    this.provider = paramProvider;
  }
  
  Lazy(T paramT) {
    this.instance = paramT;
  }
  
  public T get() {
    // Byte code:
    //   0: aload_0
    //   1: getfield instance : Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_2
    //   7: aload_1
    //   8: getstatic com/google/firebase/components/Lazy.UNINITIALIZED : Ljava/lang/Object;
    //   11: if_acmpne -> 60
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield instance : Ljava/lang/Object;
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: getstatic com/google/firebase/components/Lazy.UNINITIALIZED : Ljava/lang/Object;
    //   27: if_acmpne -> 50
    //   30: aload_0
    //   31: getfield provider : Lcom/google/firebase/inject/Provider;
    //   34: invokeinterface get : ()Ljava/lang/Object;
    //   39: astore_2
    //   40: aload_0
    //   41: aload_2
    //   42: putfield instance : Ljava/lang/Object;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield provider : Lcom/google/firebase/inject/Provider;
    //   50: aload_0
    //   51: monitorexit
    //   52: goto -> 60
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    //   60: aload_2
    //   61: areturn
    // Exception table:
    //   from	to	target	type
    //   16	21	55	finally
    //   23	50	55	finally
    //   50	52	55	finally
    //   56	58	55	finally
  }
  
  @VisibleForTesting
  boolean isInitialized() {
    boolean bool;
    if (this.instance != UNINITIALIZED) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\Lazy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */