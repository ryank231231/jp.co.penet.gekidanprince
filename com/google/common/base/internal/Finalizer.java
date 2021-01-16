package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public class Finalizer implements Runnable {
  private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
  
  private static final Field inheritableThreadLocals;
  
  private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
  
  private final WeakReference<Class<?>> finalizableReferenceClassReference;
  
  private final PhantomReference<Object> frqReference;
  
  private final ReferenceQueue<Object> queue;
  
  static {
    inheritableThreadLocals = getInheritableThreadLocalsField();
  }
  
  private Finalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference) {
    this.queue = paramReferenceQueue;
    this.finalizableReferenceClassReference = new WeakReference<Class<?>>(paramClass);
    this.frqReference = paramPhantomReference;
  }
  
  private boolean cleanUp(Reference<?> paramReference) {
    Method method = getFinalizeReferentMethod();
    if (method == null)
      return false; 
    while (true) {
      paramReference.clear();
      if (paramReference == this.frqReference)
        return false; 
      try {
        method.invoke(paramReference, new Object[0]);
      } catch (Throwable throwable) {
        logger.log(Level.SEVERE, "Error cleaning up after reference.", throwable);
      } 
      Reference<?> reference = this.queue.poll();
      paramReference = reference;
      if (reference == null)
        return true; 
    } 
  }
  
  @Nullable
  private Method getFinalizeReferentMethod() {
    Class clazz = this.finalizableReferenceClassReference.get();
    if (clazz == null)
      return null; 
    try {
      return clazz.getMethod("finalizeReferent", new Class[0]);
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new AssertionError(noSuchMethodException);
    } 
  }
  
  @Nullable
  public static Field getInheritableThreadLocalsField() {
    try {
      Field field = Thread.class.getDeclaredField("inheritableThreadLocals");
      field.setAccessible(true);
      return field;
    } catch (Throwable throwable) {
      logger.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
      return null;
    } 
  }
  
  public static void startFinalizer(Class<?> paramClass, ReferenceQueue<Object> paramReferenceQueue, PhantomReference<Object> paramPhantomReference) {
    if (paramClass.getName().equals("com.google.common.base.FinalizableReference")) {
      Thread thread = new Thread(new Finalizer(paramClass, paramReferenceQueue, paramPhantomReference));
      thread.setName(Finalizer.class.getName());
      thread.setDaemon(true);
      try {
        if (inheritableThreadLocals != null)
          inheritableThreadLocals.set(thread, (Object)null); 
      } catch (Throwable throwable) {
        logger.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", throwable);
      } 
      thread.start();
      return;
    } 
    throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
  }
  
  public void run() {
    while (true) {
      try {
        boolean bool;
        do {
          bool = cleanUp(this.queue.remove());
        } while (bool);
        return;
      } catch (InterruptedException interruptedException) {}
    } 
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\internal\Finalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */