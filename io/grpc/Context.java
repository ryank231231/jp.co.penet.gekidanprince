package io.grpc;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {
  static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
  
  private static final PersistentHashArrayMappedTrie<Key<?>, Object> EMPTY_ENTRIES;
  
  public static final Context ROOT;
  
  private static final Logger log = Logger.getLogger(Context.class.getName());
  
  private static final AtomicReference<Storage> storage;
  
  final CancellableContext cancellableAncestor;
  
  final int generation;
  
  final PersistentHashArrayMappedTrie<Key<?>, Object> keyValueEntries;
  
  private ArrayList<ExecutableListener> listeners;
  
  private CancellationListener parentListener;
  
  static {
    EMPTY_ENTRIES = new PersistentHashArrayMappedTrie<Key<?>, Object>();
    ROOT = new Context(null, EMPTY_ENTRIES);
    storage = new AtomicReference<Storage>();
  }
  
  private Context(Context paramContext, PersistentHashArrayMappedTrie<Key<?>, Object> paramPersistentHashArrayMappedTrie) {
    int i;
    this.parentListener = new ParentListener();
    this.cancellableAncestor = cancellableAncestor(paramContext);
    this.keyValueEntries = paramPersistentHashArrayMappedTrie;
    if (paramContext == null) {
      i = 0;
    } else {
      i = paramContext.generation + 1;
    } 
    this.generation = i;
    validateGeneration(this.generation);
  }
  
  private Context(PersistentHashArrayMappedTrie<Key<?>, Object> paramPersistentHashArrayMappedTrie, int paramInt) {
    this.parentListener = new ParentListener();
    this.cancellableAncestor = null;
    this.keyValueEntries = paramPersistentHashArrayMappedTrie;
    this.generation = paramInt;
    validateGeneration(paramInt);
  }
  
  static CancellableContext cancellableAncestor(Context paramContext) {
    return (paramContext == null) ? null : ((paramContext instanceof CancellableContext) ? (CancellableContext)paramContext : paramContext.cancellableAncestor);
  }
  
  private static <T> T checkNotNull(T paramT, Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  private static Storage createStorage() {
    try {
      Storage storage = Class.forName("io.grpc.override.ContextStorageOverride").getConstructor(new Class[0]).newInstance(new Object[0]);
      storage.compareAndSet(null, storage);
    } catch (ClassNotFoundException classNotFoundException) {
      ThreadLocalContextStorage threadLocalContextStorage = new ThreadLocalContextStorage();
      if (storage.compareAndSet(null, threadLocalContextStorage))
        log.log(Level.FINE, "Storage override doesn't exist. Using default", classNotFoundException); 
    } catch (Exception exception) {
      throw new RuntimeException("Storage override failed to initialize", exception);
    } 
    return storage.get();
  }
  
  public static Context current() {
    Context context = storage().current();
    return (context == null) ? ROOT : context;
  }
  
  public static Executor currentContextExecutor(final Executor e) {
    class CurrentContextExecutor implements Executor {
      public void execute(Runnable param1Runnable) {
        e.execute(Context.current().wrap(param1Runnable));
      }
    };
    return new CurrentContextExecutor();
  }
  
  public static <T> Key<T> key(String paramString) {
    return new Key<T>(paramString);
  }
  
  public static <T> Key<T> keyWithDefault(String paramString, T paramT) {
    return new Key<T>(paramString, paramT);
  }
  
  private Object lookup(Key<?> paramKey) {
    return this.keyValueEntries.get(paramKey);
  }
  
  static Storage storage() {
    Storage storage1 = storage.get();
    Storage storage2 = storage1;
    if (storage1 == null)
      storage2 = createStorage(); 
    return storage2;
  }
  
  private static void validateGeneration(int paramInt) {
    if (paramInt == 1000)
      log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", new Exception()); 
  }
  
  public void addListener(CancellationListener paramCancellationListener, Executor paramExecutor) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'cancellationListener'
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: ldc 'executor'
    //   10: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_0
    //   15: invokevirtual canBeCancelled : ()Z
    //   18: ifeq -> 121
    //   21: new io/grpc/Context$ExecutableListener
    //   24: dup
    //   25: aload_0
    //   26: aload_2
    //   27: aload_1
    //   28: aconst_null
    //   29: invokespecial <init> : (Lio/grpc/Context;Ljava/util/concurrent/Executor;Lio/grpc/Context$CancellationListener;Lio/grpc/Context$1;)V
    //   32: astore_1
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: invokevirtual isCancelled : ()Z
    //   39: ifeq -> 49
    //   42: aload_1
    //   43: invokestatic access$400 : (Lio/grpc/Context$ExecutableListener;)V
    //   46: goto -> 111
    //   49: aload_0
    //   50: getfield listeners : Ljava/util/ArrayList;
    //   53: ifnonnull -> 102
    //   56: new java/util/ArrayList
    //   59: astore_2
    //   60: aload_2
    //   61: invokespecial <init> : ()V
    //   64: aload_0
    //   65: aload_2
    //   66: putfield listeners : Ljava/util/ArrayList;
    //   69: aload_0
    //   70: getfield listeners : Ljava/util/ArrayList;
    //   73: aload_1
    //   74: invokevirtual add : (Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload_0
    //   79: getfield cancellableAncestor : Lio/grpc/Context$CancellableContext;
    //   82: ifnull -> 111
    //   85: aload_0
    //   86: getfield cancellableAncestor : Lio/grpc/Context$CancellableContext;
    //   89: aload_0
    //   90: getfield parentListener : Lio/grpc/Context$CancellationListener;
    //   93: getstatic io/grpc/Context$DirectExecutor.INSTANCE : Lio/grpc/Context$DirectExecutor;
    //   96: invokevirtual addListener : (Lio/grpc/Context$CancellationListener;Ljava/util/concurrent/Executor;)V
    //   99: goto -> 111
    //   102: aload_0
    //   103: getfield listeners : Ljava/util/ArrayList;
    //   106: aload_1
    //   107: invokevirtual add : (Ljava/lang/Object;)Z
    //   110: pop
    //   111: aload_0
    //   112: monitorexit
    //   113: goto -> 121
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    //   121: return
    // Exception table:
    //   from	to	target	type
    //   35	46	116	finally
    //   49	99	116	finally
    //   102	111	116	finally
    //   111	113	116	finally
    //   117	119	116	finally
  }
  
  public Context attach() {
    Context context = storage().doAttach(this);
    return (context == null) ? ROOT : context;
  }
  
  public <V> V call(Callable<V> paramCallable) throws Exception {
    Context context = attach();
    try {
      paramCallable = (Callable<V>)paramCallable.call();
      return (V)paramCallable;
    } finally {
      detach(context);
    } 
  }
  
  boolean canBeCancelled() {
    boolean bool;
    if (this.cancellableAncestor != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public Throwable cancellationCause() {
    CancellableContext cancellableContext = this.cancellableAncestor;
    return (cancellableContext == null) ? null : cancellableContext.cancellationCause();
  }
  
  public void detach(Context paramContext) {
    checkNotNull(paramContext, "toAttach");
    storage().detach(this, paramContext);
  }
  
  public Executor fixedContextExecutor(final Executor e) {
    class FixedContextExecutor implements Executor {
      public void execute(Runnable param1Runnable) {
        e.execute(Context.this.wrap(param1Runnable));
      }
    };
    return new FixedContextExecutor();
  }
  
  public Context fork() {
    return new Context(this.keyValueEntries, this.generation + 1);
  }
  
  public Deadline getDeadline() {
    CancellableContext cancellableContext = this.cancellableAncestor;
    return (cancellableContext == null) ? null : cancellableContext.getDeadline();
  }
  
  public boolean isCancelled() {
    CancellableContext cancellableContext = this.cancellableAncestor;
    return (cancellableContext == null) ? false : cancellableContext.isCancelled();
  }
  
  boolean isCurrent() {
    boolean bool;
    if (current() == this) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  int listenerCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield listeners : Ljava/util/ArrayList;
    //   6: ifnonnull -> 14
    //   9: iconst_0
    //   10: istore_1
    //   11: goto -> 22
    //   14: aload_0
    //   15: getfield listeners : Ljava/util/ArrayList;
    //   18: invokevirtual size : ()I
    //   21: istore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	26	finally
    //   14	22	26	finally
    //   22	24	26	finally
    //   27	29	26	finally
  }
  
  void notifyAndClearListeners() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual canBeCancelled : ()Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield listeners : Ljava/util/ArrayList;
    //   14: ifnonnull -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield listeners : Ljava/util/ArrayList;
    //   24: astore_1
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield listeners : Ljava/util/ArrayList;
    //   30: aload_0
    //   31: monitorexit
    //   32: iconst_0
    //   33: istore_2
    //   34: iconst_0
    //   35: istore_3
    //   36: iload_2
    //   37: istore #4
    //   39: iload_3
    //   40: aload_1
    //   41: invokevirtual size : ()I
    //   44: if_icmpge -> 81
    //   47: aload_1
    //   48: iload_3
    //   49: invokevirtual get : (I)Ljava/lang/Object;
    //   52: checkcast io/grpc/Context$ExecutableListener
    //   55: invokestatic access$500 : (Lio/grpc/Context$ExecutableListener;)Lio/grpc/Context$CancellationListener;
    //   58: instanceof io/grpc/Context$ParentListener
    //   61: ifne -> 75
    //   64: aload_1
    //   65: iload_3
    //   66: invokevirtual get : (I)Ljava/lang/Object;
    //   69: checkcast io/grpc/Context$ExecutableListener
    //   72: invokestatic access$400 : (Lio/grpc/Context$ExecutableListener;)V
    //   75: iinc #3, 1
    //   78: goto -> 36
    //   81: iload #4
    //   83: aload_1
    //   84: invokevirtual size : ()I
    //   87: if_icmpge -> 126
    //   90: aload_1
    //   91: iload #4
    //   93: invokevirtual get : (I)Ljava/lang/Object;
    //   96: checkcast io/grpc/Context$ExecutableListener
    //   99: invokestatic access$500 : (Lio/grpc/Context$ExecutableListener;)Lio/grpc/Context$CancellationListener;
    //   102: instanceof io/grpc/Context$ParentListener
    //   105: ifeq -> 120
    //   108: aload_1
    //   109: iload #4
    //   111: invokevirtual get : (I)Ljava/lang/Object;
    //   114: checkcast io/grpc/Context$ExecutableListener
    //   117: invokestatic access$400 : (Lio/grpc/Context$ExecutableListener;)V
    //   120: iinc #4, 1
    //   123: goto -> 81
    //   126: aload_0
    //   127: getfield cancellableAncestor : Lio/grpc/Context$CancellableContext;
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull -> 143
    //   135: aload_1
    //   136: aload_0
    //   137: getfield parentListener : Lio/grpc/Context$CancellationListener;
    //   140: invokevirtual removeListener : (Lio/grpc/Context$CancellationListener;)V
    //   143: return
    //   144: astore_1
    //   145: aload_0
    //   146: monitorexit
    //   147: aload_1
    //   148: athrow
    // Exception table:
    //   from	to	target	type
    //   10	19	144	finally
    //   20	32	144	finally
    //   145	147	144	finally
  }
  
  public void removeListener(CancellationListener paramCancellationListener) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual canBeCancelled : ()Z
    //   4: ifne -> 8
    //   7: return
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield listeners : Ljava/util/ArrayList;
    //   14: ifnull -> 100
    //   17: aload_0
    //   18: getfield listeners : Ljava/util/ArrayList;
    //   21: invokevirtual size : ()I
    //   24: iconst_1
    //   25: isub
    //   26: istore_2
    //   27: iload_2
    //   28: iflt -> 67
    //   31: aload_0
    //   32: getfield listeners : Ljava/util/ArrayList;
    //   35: iload_2
    //   36: invokevirtual get : (I)Ljava/lang/Object;
    //   39: checkcast io/grpc/Context$ExecutableListener
    //   42: invokestatic access$500 : (Lio/grpc/Context$ExecutableListener;)Lio/grpc/Context$CancellationListener;
    //   45: aload_1
    //   46: if_acmpne -> 61
    //   49: aload_0
    //   50: getfield listeners : Ljava/util/ArrayList;
    //   53: iload_2
    //   54: invokevirtual remove : (I)Ljava/lang/Object;
    //   57: pop
    //   58: goto -> 67
    //   61: iinc #2, -1
    //   64: goto -> 27
    //   67: aload_0
    //   68: getfield listeners : Ljava/util/ArrayList;
    //   71: invokevirtual isEmpty : ()Z
    //   74: ifeq -> 100
    //   77: aload_0
    //   78: getfield cancellableAncestor : Lio/grpc/Context$CancellableContext;
    //   81: ifnull -> 95
    //   84: aload_0
    //   85: getfield cancellableAncestor : Lio/grpc/Context$CancellableContext;
    //   88: aload_0
    //   89: getfield parentListener : Lio/grpc/Context$CancellationListener;
    //   92: invokevirtual removeListener : (Lio/grpc/Context$CancellationListener;)V
    //   95: aload_0
    //   96: aconst_null
    //   97: putfield listeners : Ljava/util/ArrayList;
    //   100: aload_0
    //   101: monitorexit
    //   102: return
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   10	27	103	finally
    //   31	58	103	finally
    //   67	95	103	finally
    //   95	100	103	finally
    //   100	102	103	finally
    //   104	106	103	finally
  }
  
  public void run(Runnable paramRunnable) {
    Context context = attach();
    try {
      paramRunnable.run();
      return;
    } finally {
      detach(context);
    } 
  }
  
  public CancellableContext withCancellation() {
    return new CancellableContext(this);
  }
  
  public CancellableContext withDeadline(Deadline paramDeadline, ScheduledExecutorService paramScheduledExecutorService) {
    checkNotNull(paramDeadline, "deadline");
    checkNotNull(paramScheduledExecutorService, "scheduler");
    return new CancellableContext(this, paramDeadline, paramScheduledExecutorService);
  }
  
  public CancellableContext withDeadlineAfter(long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService) {
    return withDeadline(Deadline.after(paramLong, paramTimeUnit), paramScheduledExecutorService);
  }
  
  public <V> Context withValue(Key<V> paramKey, V paramV) {
    return new Context(this, this.keyValueEntries.put(paramKey, paramV));
  }
  
  public <V1, V2> Context withValues(Key<V1> paramKey, V1 paramV1, Key<V2> paramKey1, V2 paramV2) {
    return new Context(this, this.keyValueEntries.put(paramKey, paramV1).put(paramKey1, paramV2));
  }
  
  public <V1, V2, V3> Context withValues(Key<V1> paramKey, V1 paramV1, Key<V2> paramKey1, V2 paramV2, Key<V3> paramKey2, V3 paramV3) {
    return new Context(this, this.keyValueEntries.put(paramKey, paramV1).put(paramKey1, paramV2).put(paramKey2, paramV3));
  }
  
  public <V1, V2, V3, V4> Context withValues(Key<V1> paramKey, V1 paramV1, Key<V2> paramKey1, V2 paramV2, Key<V3> paramKey2, V3 paramV3, Key<V4> paramKey3, V4 paramV4) {
    return new Context(this, this.keyValueEntries.put(paramKey, paramV1).put(paramKey1, paramV2).put(paramKey2, paramV3).put(paramKey3, paramV4));
  }
  
  public Runnable wrap(final Runnable r) {
    return new Runnable() {
        public void run() {
          Context context = Context.this.attach();
          try {
            r.run();
            return;
          } finally {
            Context.this.detach(context);
          } 
        }
      };
  }
  
  public <C> Callable<C> wrap(final Callable<C> c) {
    return new Callable<C>() {
        public C call() throws Exception {
          Context context = Context.this.attach();
          try {
            return (C)c.call();
          } finally {
            Context.this.detach(context);
          } 
        }
      };
  }
  
  public static final class CancellableContext extends Context implements Closeable {
    private Throwable cancellationCause;
    
    private boolean cancelled;
    
    private final Deadline deadline;
    
    private ScheduledFuture<?> pendingDeadline;
    
    private final Context uncancellableSurrogate;
    
    private CancellableContext(Context param1Context) {
      super(param1Context, param1Context.keyValueEntries);
      this.deadline = param1Context.getDeadline();
      this.uncancellableSurrogate = new Context(this, this.keyValueEntries);
    }
    
    private CancellableContext(Context param1Context, Deadline param1Deadline, ScheduledExecutorService param1ScheduledExecutorService) {
      super(param1Context, param1Context.keyValueEntries);
      Deadline deadline = param1Context.getDeadline();
      if (deadline != null && deadline.compareTo(param1Deadline) <= 0) {
        param1Deadline = deadline;
      } else if (!param1Deadline.isExpired()) {
        this.pendingDeadline = param1Deadline.runOnExpiration(new Runnable() {
              public void run() {
                try {
                  Context.CancellableContext cancellableContext = Context.CancellableContext.this;
                  TimeoutException timeoutException = new TimeoutException();
                  this("context timed out");
                  cancellableContext.cancel(timeoutException);
                } catch (Throwable throwable) {
                  Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", throwable);
                } 
              }
            }param1ScheduledExecutorService);
      } else {
        cancel(new TimeoutException("context timed out"));
      } 
      this.deadline = param1Deadline;
      this.uncancellableSurrogate = new Context(this, this.keyValueEntries);
    }
    
    public Context attach() {
      return this.uncancellableSurrogate.attach();
    }
    
    boolean canBeCancelled() {
      return true;
    }
    
    public boolean cancel(Throwable param1Throwable) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield cancelled : Z
      //   6: istore_2
      //   7: iconst_1
      //   8: istore_3
      //   9: iload_2
      //   10: ifne -> 49
      //   13: aload_0
      //   14: iconst_1
      //   15: putfield cancelled : Z
      //   18: aload_0
      //   19: getfield pendingDeadline : Ljava/util/concurrent/ScheduledFuture;
      //   22: ifnull -> 41
      //   25: aload_0
      //   26: getfield pendingDeadline : Ljava/util/concurrent/ScheduledFuture;
      //   29: iconst_0
      //   30: invokeinterface cancel : (Z)Z
      //   35: pop
      //   36: aload_0
      //   37: aconst_null
      //   38: putfield pendingDeadline : Ljava/util/concurrent/ScheduledFuture;
      //   41: aload_0
      //   42: aload_1
      //   43: putfield cancellationCause : Ljava/lang/Throwable;
      //   46: goto -> 51
      //   49: iconst_0
      //   50: istore_3
      //   51: aload_0
      //   52: monitorexit
      //   53: iload_3
      //   54: ifeq -> 61
      //   57: aload_0
      //   58: invokevirtual notifyAndClearListeners : ()V
      //   61: iload_3
      //   62: ireturn
      //   63: astore_1
      //   64: aload_0
      //   65: monitorexit
      //   66: aload_1
      //   67: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	63	finally
      //   13	41	63	finally
      //   41	46	63	finally
      //   51	53	63	finally
      //   64	66	63	finally
    }
    
    public Throwable cancellationCause() {
      return isCancelled() ? this.cancellationCause : null;
    }
    
    public void close() {
      cancel((Throwable)null);
    }
    
    public void detach(Context param1Context) {
      this.uncancellableSurrogate.detach(param1Context);
    }
    
    public void detachAndCancel(Context param1Context, Throwable param1Throwable) {
      try {
        detach(param1Context);
        return;
      } finally {
        cancel(param1Throwable);
      } 
    }
    
    public Deadline getDeadline() {
      return this.deadline;
    }
    
    public boolean isCancelled() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield cancelled : Z
      //   6: ifeq -> 13
      //   9: aload_0
      //   10: monitorexit
      //   11: iconst_1
      //   12: ireturn
      //   13: aload_0
      //   14: monitorexit
      //   15: aload_0
      //   16: invokespecial isCancelled : ()Z
      //   19: ifeq -> 33
      //   22: aload_0
      //   23: aload_0
      //   24: invokespecial cancellationCause : ()Ljava/lang/Throwable;
      //   27: invokevirtual cancel : (Ljava/lang/Throwable;)Z
      //   30: pop
      //   31: iconst_1
      //   32: ireturn
      //   33: iconst_0
      //   34: ireturn
      //   35: astore_1
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: athrow
      // Exception table:
      //   from	to	target	type
      //   2	11	35	finally
      //   13	15	35	finally
      //   36	38	35	finally
    }
    
    @Deprecated
    public boolean isCurrent() {
      return this.uncancellableSurrogate.isCurrent();
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        Context.CancellableContext cancellableContext = this.this$0;
        TimeoutException timeoutException = new TimeoutException();
        this("context timed out");
        cancellableContext.cancel(timeoutException);
      } catch (Throwable throwable) {
        Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", throwable);
      } 
    }
  }
  
  public static interface CancellationListener {
    void cancelled(Context param1Context);
  }
  
  private enum DirectExecutor implements Executor {
    INSTANCE;
    
    static {
    
    }
    
    public void execute(Runnable param1Runnable) {
      param1Runnable.run();
    }
    
    public String toString() {
      return "Context.DirectExecutor";
    }
  }
  
  private class ExecutableListener implements Runnable {
    private final Executor executor;
    
    private final Context.CancellationListener listener;
    
    private ExecutableListener(Executor param1Executor, Context.CancellationListener param1CancellationListener) {
      this.executor = param1Executor;
      this.listener = param1CancellationListener;
    }
    
    private void deliver() {
      try {
        this.executor.execute(this);
      } catch (Throwable throwable) {
        Context.log.log(Level.INFO, "Exception notifying context listener", throwable);
      } 
    }
    
    public void run() {
      this.listener.cancelled(Context.this);
    }
  }
  
  public static final class Key<T> {
    private final T defaultValue;
    
    private final String name;
    
    Key(String param1String) {
      this(param1String, null);
    }
    
    Key(String param1String, T param1T) {
      this.name = (String)Context.checkNotNull((T)param1String, "name");
      this.defaultValue = param1T;
    }
    
    public T get() {
      return get(Context.current());
    }
    
    public T get(Context param1Context) {
      Object object2 = param1Context.lookup(this);
      Object object1 = object2;
      if (object2 == null)
        object1 = this.defaultValue; 
      return (T)object1;
    }
    
    public String toString() {
      return this.name;
    }
  }
  
  private class ParentListener implements CancellationListener {
    private ParentListener() {}
    
    public void cancelled(Context param1Context) {
      Context context = Context.this;
      if (context instanceof Context.CancellableContext) {
        ((Context.CancellableContext)context).cancel(param1Context.cancellationCause());
      } else {
        context.notifyAndClearListeners();
      } 
    }
  }
  
  public static abstract class Storage {
    @Deprecated
    public void attach(Context param1Context) {
      throw new UnsupportedOperationException("Deprecated. Do not call.");
    }
    
    public abstract Context current();
    
    public abstract void detach(Context param1Context1, Context param1Context2);
    
    public Context doAttach(Context param1Context) {
      Context context = current();
      attach(param1Context);
      return context;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */