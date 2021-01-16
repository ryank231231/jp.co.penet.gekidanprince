package com.google.firebase.components;

import android.support.annotation.GuardedBy;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class EventBus implements Subscriber, Publisher {
  private final Executor defaultExecutor;
  
  @GuardedBy("this")
  private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> handlerMap = new HashMap<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>>();
  
  @GuardedBy("this")
  private Queue<Event<?>> pendingEvents = new ArrayDeque<Event<?>>();
  
  EventBus(Executor paramExecutor) {
    this.defaultExecutor = paramExecutor;
  }
  
  private Set<Map.Entry<EventHandler<Object>, Executor>> getHandlers(Event<?> paramEvent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield handlerMap : Ljava/util/Map;
    //   6: aload_1
    //   7: invokevirtual getType : ()Ljava/lang/Class;
    //   10: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast java/util/Map
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull -> 30
    //   23: invokestatic emptySet : ()Ljava/util/Set;
    //   26: astore_1
    //   27: goto -> 37
    //   30: aload_1
    //   31: invokeinterface entrySet : ()Ljava/util/Set;
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	41	finally
    //   23	27	41	finally
    //   30	37	41	finally
  }
  
  void enablePublishingAndFlushPending() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield pendingEvents : Ljava/util/Queue;
    //   6: ifnull -> 22
    //   9: aload_0
    //   10: getfield pendingEvents : Ljava/util/Queue;
    //   13: astore_1
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield pendingEvents : Ljava/util/Queue;
    //   19: goto -> 24
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: ifnull -> 62
    //   30: aload_1
    //   31: invokeinterface iterator : ()Ljava/util/Iterator;
    //   36: astore_1
    //   37: aload_1
    //   38: invokeinterface hasNext : ()Z
    //   43: ifeq -> 62
    //   46: aload_0
    //   47: aload_1
    //   48: invokeinterface next : ()Ljava/lang/Object;
    //   53: checkcast com/google/firebase/events/Event
    //   56: invokevirtual publish : (Lcom/google/firebase/events/Event;)V
    //   59: goto -> 37
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	63	finally
    //   24	26	63	finally
    //   64	66	63	finally
  }
  
  public void publish(Event<?> paramEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield pendingEvents : Ljava/util/Queue;
    //   11: ifnull -> 28
    //   14: aload_0
    //   15: getfield pendingEvents : Ljava/util/Queue;
    //   18: aload_1
    //   19: invokeinterface add : (Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial getHandlers : (Lcom/google/firebase/events/Event;)Ljava/util/Set;
    //   35: invokeinterface iterator : ()Ljava/util/Iterator;
    //   40: astore_2
    //   41: aload_2
    //   42: invokeinterface hasNext : ()Z
    //   47: ifeq -> 82
    //   50: aload_2
    //   51: invokeinterface next : ()Ljava/lang/Object;
    //   56: checkcast java/util/Map$Entry
    //   59: astore_3
    //   60: aload_3
    //   61: invokeinterface getValue : ()Ljava/lang/Object;
    //   66: checkcast java/util/concurrent/Executor
    //   69: aload_3
    //   70: aload_1
    //   71: invokestatic lambdaFactory$ : (Ljava/util/Map$Entry;Lcom/google/firebase/events/Event;)Ljava/lang/Runnable;
    //   74: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   79: goto -> 41
    //   82: return
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Exception table:
    //   from	to	target	type
    //   7	27	83	finally
    //   28	30	83	finally
    //   84	86	83	finally
  }
  
  public <T> void subscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler) {
    subscribe(paramClass, this.defaultExecutor, paramEventHandler);
  }
  
  public <T> void subscribe(Class<T> paramClass, Executor paramExecutor, EventHandler<? super T> paramEventHandler) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_3
    //   8: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_2
    //   13: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: aload_0
    //   18: getfield handlerMap : Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   27: ifne -> 57
    //   30: aload_0
    //   31: getfield handlerMap : Ljava/util/Map;
    //   34: astore #4
    //   36: new java/util/concurrent/ConcurrentHashMap
    //   39: astore #5
    //   41: aload #5
    //   43: invokespecial <init> : ()V
    //   46: aload #4
    //   48: aload_1
    //   49: aload #5
    //   51: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   56: pop
    //   57: aload_0
    //   58: getfield handlerMap : Ljava/util/Map;
    //   61: aload_1
    //   62: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast java/util/concurrent/ConcurrentHashMap
    //   70: aload_3
    //   71: aload_2
    //   72: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	57	79	finally
    //   57	76	79	finally
  }
  
  public <T> void unsubscribe(Class<T> paramClass, EventHandler<? super T> paramEventHandler) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   11: pop
    //   12: aload_0
    //   13: getfield handlerMap : Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifne -> 30
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield handlerMap : Ljava/util/Map;
    //   34: aload_1
    //   35: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast java/util/concurrent/ConcurrentHashMap
    //   43: astore #4
    //   45: aload #4
    //   47: aload_2
    //   48: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   51: pop
    //   52: aload #4
    //   54: invokevirtual isEmpty : ()Z
    //   57: ifeq -> 71
    //   60: aload_0
    //   61: getfield handlerMap : Ljava/util/Map;
    //   64: aload_1
    //   65: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   70: pop
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	23	74	finally
    //   30	71	74	finally
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\firebase\components\EventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */