package io.grpc.internal;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public final class SharedResourceHolder {
  static final long DESTROY_DELAY_SECONDS = 1L;
  
  private static final SharedResourceHolder holder = new SharedResourceHolder(new ScheduledExecutorFactory() {
        public ScheduledExecutorService createScheduledExecutor() {
          return Executors.newSingleThreadScheduledExecutor(GrpcUtil.getThreadFactory("grpc-shared-destroyer-%d", true));
        }
      });
  
  private ScheduledExecutorService destroyer;
  
  private final ScheduledExecutorFactory destroyerFactory;
  
  private final IdentityHashMap<Resource<?>, Instance> instances = new IdentityHashMap<Resource<?>, Instance>();
  
  SharedResourceHolder(ScheduledExecutorFactory paramScheduledExecutorFactory) {
    this.destroyerFactory = paramScheduledExecutorFactory;
  }
  
  public static <T> T get(Resource<T> paramResource) {
    return holder.getInternal(paramResource);
  }
  
  public static <T> T release(Resource<T> paramResource, T paramT) {
    return holder.releaseInternal(paramResource, paramT);
  }
  
  <T> T getInternal(Resource<T> paramResource) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/IdentityHashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast io/grpc/internal/SharedResourceHolder$Instance
    //   13: astore_2
    //   14: aload_2
    //   15: astore_3
    //   16: aload_2
    //   17: ifnonnull -> 44
    //   20: new io/grpc/internal/SharedResourceHolder$Instance
    //   23: astore_3
    //   24: aload_3
    //   25: aload_1
    //   26: invokeinterface create : ()Ljava/lang/Object;
    //   31: invokespecial <init> : (Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield instances : Ljava/util/IdentityHashMap;
    //   38: aload_1
    //   39: aload_3
    //   40: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_3
    //   45: getfield destroyTask : Ljava/util/concurrent/ScheduledFuture;
    //   48: ifnull -> 67
    //   51: aload_3
    //   52: getfield destroyTask : Ljava/util/concurrent/ScheduledFuture;
    //   55: iconst_0
    //   56: invokeinterface cancel : (Z)Z
    //   61: pop
    //   62: aload_3
    //   63: aconst_null
    //   64: putfield destroyTask : Ljava/util/concurrent/ScheduledFuture;
    //   67: aload_3
    //   68: aload_3
    //   69: getfield refcount : I
    //   72: iconst_1
    //   73: iadd
    //   74: putfield refcount : I
    //   77: aload_3
    //   78: getfield payload : Ljava/lang/Object;
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: areturn
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	86	finally
    //   20	44	86	finally
    //   44	67	86	finally
    //   67	82	86	finally
  }
  
  <T> T releaseInternal(Resource<T> paramResource, T paramT) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield instances : Ljava/util/IdentityHashMap;
    //   6: aload_1
    //   7: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast io/grpc/internal/SharedResourceHolder$Instance
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -> 208
    //   18: aload_3
    //   19: getfield payload : Ljava/lang/Object;
    //   22: astore #4
    //   24: iconst_0
    //   25: istore #5
    //   27: aload_2
    //   28: aload #4
    //   30: if_acmpne -> 39
    //   33: iconst_1
    //   34: istore #6
    //   36: goto -> 42
    //   39: iconst_0
    //   40: istore #6
    //   42: iload #6
    //   44: ldc 'Releasing the wrong instance'
    //   46: invokestatic checkArgument : (ZLjava/lang/Object;)V
    //   49: aload_3
    //   50: getfield refcount : I
    //   53: ifle -> 62
    //   56: iconst_1
    //   57: istore #6
    //   59: goto -> 65
    //   62: iconst_0
    //   63: istore #6
    //   65: iload #6
    //   67: ldc 'Refcount has already reached zero'
    //   69: invokestatic checkState : (ZLjava/lang/Object;)V
    //   72: aload_3
    //   73: aload_3
    //   74: getfield refcount : I
    //   77: iconst_1
    //   78: isub
    //   79: putfield refcount : I
    //   82: aload_3
    //   83: getfield refcount : I
    //   86: ifne -> 204
    //   89: getstatic io/grpc/internal/GrpcUtil.IS_RESTRICTED_APPENGINE : Z
    //   92: ifeq -> 114
    //   95: aload_1
    //   96: aload_2
    //   97: invokeinterface close : (Ljava/lang/Object;)V
    //   102: aload_0
    //   103: getfield instances : Ljava/util/IdentityHashMap;
    //   106: aload_1
    //   107: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   110: pop
    //   111: goto -> 204
    //   114: iload #5
    //   116: istore #6
    //   118: aload_3
    //   119: getfield destroyTask : Ljava/util/concurrent/ScheduledFuture;
    //   122: ifnonnull -> 128
    //   125: iconst_1
    //   126: istore #6
    //   128: iload #6
    //   130: ldc 'Destroy task already scheduled'
    //   132: invokestatic checkState : (ZLjava/lang/Object;)V
    //   135: aload_0
    //   136: getfield destroyer : Ljava/util/concurrent/ScheduledExecutorService;
    //   139: ifnonnull -> 155
    //   142: aload_0
    //   143: aload_0
    //   144: getfield destroyerFactory : Lio/grpc/internal/SharedResourceHolder$ScheduledExecutorFactory;
    //   147: invokeinterface createScheduledExecutor : ()Ljava/util/concurrent/ScheduledExecutorService;
    //   152: putfield destroyer : Ljava/util/concurrent/ScheduledExecutorService;
    //   155: aload_0
    //   156: getfield destroyer : Ljava/util/concurrent/ScheduledExecutorService;
    //   159: astore #4
    //   161: new io/grpc/internal/LogExceptionRunnable
    //   164: astore #7
    //   166: new io/grpc/internal/SharedResourceHolder$2
    //   169: astore #8
    //   171: aload #8
    //   173: aload_0
    //   174: aload_3
    //   175: aload_1
    //   176: aload_2
    //   177: invokespecial <init> : (Lio/grpc/internal/SharedResourceHolder;Lio/grpc/internal/SharedResourceHolder$Instance;Lio/grpc/internal/SharedResourceHolder$Resource;Ljava/lang/Object;)V
    //   180: aload #7
    //   182: aload #8
    //   184: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   187: aload_3
    //   188: aload #4
    //   190: aload #7
    //   192: lconst_1
    //   193: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   196: invokeinterface schedule : (Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   201: putfield destroyTask : Ljava/util/concurrent/ScheduledFuture;
    //   204: aload_0
    //   205: monitorexit
    //   206: aconst_null
    //   207: areturn
    //   208: new java/lang/IllegalArgumentException
    //   211: astore_3
    //   212: new java/lang/StringBuilder
    //   215: astore_2
    //   216: aload_2
    //   217: invokespecial <init> : ()V
    //   220: aload_2
    //   221: ldc 'No cached instance found for '
    //   223: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_2
    //   228: aload_1
    //   229: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: aload_2
    //   235: invokevirtual toString : ()Ljava/lang/String;
    //   238: invokespecial <init> : (Ljava/lang/String;)V
    //   241: aload_3
    //   242: athrow
    //   243: astore_1
    //   244: aload_0
    //   245: monitorexit
    //   246: aload_1
    //   247: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	243	finally
    //   18	24	243	finally
    //   42	56	243	finally
    //   65	111	243	finally
    //   118	125	243	finally
    //   128	155	243	finally
    //   155	204	243	finally
    //   208	243	243	finally
  }
  
  private static class Instance {
    ScheduledFuture<?> destroyTask;
    
    final Object payload;
    
    int refcount;
    
    Instance(Object param1Object) {
      this.payload = param1Object;
    }
  }
  
  public static interface Resource<T> {
    void close(T param1T);
    
    T create();
  }
  
  static interface ScheduledExecutorFactory {
    ScheduledExecutorService createScheduledExecutor();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\SharedResourceHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */