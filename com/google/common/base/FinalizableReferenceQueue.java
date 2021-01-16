package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtIncompatible
public class FinalizableReferenceQueue implements Closeable {
  private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
  
  private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
  
  private static final Method startFinalizer = getStartFinalizer(loadFinalizer(new FinalizerLoader[] { new SystemLoader(), new DecoupledLoader(), new DirectLoader() }));
  
  final PhantomReference<Object> frqRef = new PhantomReference(this, this.queue);
  
  final ReferenceQueue<Object> queue = new ReferenceQueue();
  
  final boolean threadStarted;
  
  public FinalizableReferenceQueue() {
    boolean bool = true;
    try {
      startFinalizer.invoke(null, new Object[] { FinalizableReference.class, this.queue, this.frqRef });
      this.threadStarted = bool;
      return;
    } catch (IllegalAccessException illegalAccessException) {
      throw new AssertionError(illegalAccessException);
    } catch (Throwable throwable) {
      logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", throwable);
      bool = false;
      this.threadStarted = bool;
      return;
    } 
  }
  
  static Method getStartFinalizer(Class<?> paramClass) {
    try {
      return paramClass.getMethod("startFinalizer", new Class[] { Class.class, ReferenceQueue.class, PhantomReference.class });
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new AssertionError(noSuchMethodException);
    } 
  }
  
  private static Class<?> loadFinalizer(FinalizerLoader... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      Class<?> clazz = paramVarArgs[b].loadFinalizer();
      if (clazz != null)
        return clazz; 
    } 
    throw new AssertionError();
  }
  
  void cleanUp() {
    if (this.threadStarted)
      return; 
    while (true) {
      Reference<?> reference = this.queue.poll();
      if (reference != null) {
        reference.clear();
        try {
          ((FinalizableReference)reference).finalizeReferent();
        } catch (Throwable throwable) {
          logger.log(Level.SEVERE, "Error cleaning up after reference.", throwable);
        } 
        continue;
      } 
      break;
    } 
  }
  
  public void close() {
    this.frqRef.enqueue();
    cleanUp();
  }
  
  static class DecoupledLoader implements FinalizerLoader {
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";
    
    URL getBaseUrl() throws IOException {
      StringBuilder stringBuilder2;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("com.google.common.base.internal.Finalizer".replace('.', '/'));
      stringBuilder1.append(".class");
      String str = stringBuilder1.toString();
      URL uRL = getClass().getClassLoader().getResource(str);
      if (uRL != null) {
        String str1 = uRL.toString();
        if (str1.endsWith(str))
          return new URL(uRL, str1.substring(0, str1.length() - str.length())); 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unsupported path style: ");
        stringBuilder2.append(str1);
        throw new IOException(stringBuilder2.toString());
      } 
      throw new FileNotFoundException(stringBuilder2);
    }
    
    @Nullable
    public Class<?> loadFinalizer() {
      try {
        return newLoader(getBaseUrl()).loadClass("com.google.common.base.internal.Finalizer");
      } catch (Exception exception) {
        FinalizableReferenceQueue.logger.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", exception);
        return null;
      } 
    }
    
    URLClassLoader newLoader(URL param1URL) {
      return new URLClassLoader(new URL[] { param1URL }, null);
    }
  }
  
  static class DirectLoader implements FinalizerLoader {
    public Class<?> loadFinalizer() {
      try {
        return Class.forName("com.google.common.base.internal.Finalizer");
      } catch (ClassNotFoundException classNotFoundException) {
        throw new AssertionError(classNotFoundException);
      } 
    }
  }
  
  static interface FinalizerLoader {
    @Nullable
    Class<?> loadFinalizer();
  }
  
  static class SystemLoader implements FinalizerLoader {
    @VisibleForTesting
    static boolean disabled;
    
    @Nullable
    public Class<?> loadFinalizer() {
      if (disabled)
        return null; 
      try {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        if (classLoader != null)
          try {
            return classLoader.loadClass("com.google.common.base.internal.Finalizer");
          } catch (ClassNotFoundException classNotFoundException) {
            return null;
          }  
        return null;
      } catch (SecurityException securityException) {
        FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
        return null;
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\FinalizableReferenceQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */