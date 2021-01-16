package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

class Subscriber {
  @Weak
  private EventBus bus;
  
  private final Executor executor;
  
  private final Method method;
  
  @VisibleForTesting
  final Object target;
  
  private Subscriber(EventBus paramEventBus, Object paramObject, Method paramMethod) {
    this.bus = paramEventBus;
    this.target = Preconditions.checkNotNull(paramObject);
    this.method = paramMethod;
    paramMethod.setAccessible(true);
    this.executor = paramEventBus.executor();
  }
  
  private SubscriberExceptionContext context(Object paramObject) {
    return new SubscriberExceptionContext(this.bus, paramObject, this.target, this.method);
  }
  
  static Subscriber create(EventBus paramEventBus, Object paramObject, Method paramMethod) {
    Subscriber subscriber;
    if (isDeclaredThreadSafe(paramMethod)) {
      subscriber = new Subscriber(paramEventBus, paramObject, paramMethod);
    } else {
      subscriber = new SynchronizedSubscriber((EventBus)subscriber, paramObject, paramMethod);
    } 
    return subscriber;
  }
  
  private static boolean isDeclaredThreadSafe(Method paramMethod) {
    boolean bool;
    if (paramMethod.getAnnotation(AllowConcurrentEvents.class) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  final void dispatchEvent(final Object event) {
    this.executor.execute(new Runnable() {
          public void run() {
            try {
              Subscriber.this.invokeSubscriberMethod(event);
            } catch (InvocationTargetException invocationTargetException) {
              Subscriber.this.bus.handleSubscriberException(invocationTargetException.getCause(), Subscriber.this.context(event));
            } 
          }
        });
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Subscriber;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.target == ((Subscriber)paramObject).target) {
        bool = bool1;
        if (this.method.equals(((Subscriber)paramObject).method))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  public final int hashCode() {
    return (this.method.hashCode() + 31) * 31 + System.identityHashCode(this.target);
  }
  
  @VisibleForTesting
  void invokeSubscriberMethod(Object paramObject) throws InvocationTargetException {
    try {
      this.method.invoke(this.target, new Object[] { Preconditions.checkNotNull(paramObject) });
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method rejected target/argument: ");
      stringBuilder.append(paramObject);
      throw new Error(stringBuilder.toString(), illegalArgumentException);
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method became inaccessible: ");
      stringBuilder.append(paramObject);
      throw new Error(stringBuilder.toString(), illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      if (invocationTargetException.getCause() instanceof Error)
        throw (Error)invocationTargetException.getCause(); 
      throw invocationTargetException;
    } 
  }
  
  @VisibleForTesting
  static final class SynchronizedSubscriber extends Subscriber {
    private SynchronizedSubscriber(EventBus param1EventBus, Object param1Object, Method param1Method) {
      super(param1EventBus, param1Object, param1Method);
    }
    
    void invokeSubscriberMethod(Object param1Object) throws InvocationTargetException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_1
      //   4: invokespecial invokeSubscriberMethod : (Ljava/lang/Object;)V
      //   7: aload_0
      //   8: monitorexit
      //   9: return
      //   10: astore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: aload_1
      //   14: athrow
      // Exception table:
      //   from	to	target	type
      //   2	9	10	finally
      //   11	13	10	finally
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\eventbus\Subscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */