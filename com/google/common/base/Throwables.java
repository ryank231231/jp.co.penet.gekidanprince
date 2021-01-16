package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Throwables {
  @GwtIncompatible
  private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
  
  @GwtIncompatible
  @VisibleForTesting
  static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
  
  @Nullable
  @GwtIncompatible
  private static final Method getStackTraceDepthMethod;
  
  @Nullable
  @GwtIncompatible
  private static final Method getStackTraceElementMethod;
  
  @Nullable
  @GwtIncompatible
  private static final Object jla = getJLA();
  
  static {
    Object object = jla;
    Object object1 = null;
    if (object == null) {
      object = null;
    } else {
      object = getGetMethod();
    } 
    getStackTraceElementMethod = (Method)object;
    if (jla == null) {
      object = object1;
    } else {
      object = getSizeMethod();
    } 
    getStackTraceDepthMethod = (Method)object;
  }
  
  @Beta
  public static List<Throwable> getCausalChain(Throwable paramThrowable) {
    Preconditions.checkNotNull(paramThrowable);
    ArrayList<Throwable> arrayList = new ArrayList(4);
    while (paramThrowable != null) {
      arrayList.add(paramThrowable);
      paramThrowable = paramThrowable.getCause();
    } 
    return Collections.unmodifiableList(arrayList);
  }
  
  @Nullable
  @GwtIncompatible
  private static Method getGetMethod() {
    return getJlaMethod("getStackTraceElement", new Class[] { Throwable.class, int.class });
  }
  
  @Nullable
  @GwtIncompatible
  private static Object getJLA() {
    try {
      return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
    } catch (ThreadDeath threadDeath) {
      throw threadDeath;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  @Nullable
  @GwtIncompatible
  private static Method getJlaMethod(String paramString, Class<?>... paramVarArgs) throws ThreadDeath {
    try {
      return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(paramString, paramVarArgs);
    } catch (ThreadDeath threadDeath) {
      throw threadDeath;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  public static Throwable getRootCause(Throwable paramThrowable) {
    while (true) {
      Throwable throwable = paramThrowable.getCause();
      if (throwable != null) {
        paramThrowable = throwable;
        continue;
      } 
      return paramThrowable;
    } 
  }
  
  @Nullable
  @GwtIncompatible
  private static Method getSizeMethod() {
    return getJlaMethod("getStackTraceDepth", new Class[] { Throwable.class });
  }
  
  @GwtIncompatible
  public static String getStackTraceAsString(Throwable paramThrowable) {
    StringWriter stringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(stringWriter));
    return stringWriter.toString();
  }
  
  @GwtIncompatible
  private static Object invokeAccessibleNonThrowingMethod(Method paramMethod, Object paramObject, Object... paramVarArgs) {
    try {
      return paramMethod.invoke(paramObject, paramVarArgs);
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException(illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw propagate(invocationTargetException.getCause());
    } 
  }
  
  @GwtIncompatible
  private static List<StackTraceElement> jlaStackTrace(final Throwable t) {
    Preconditions.checkNotNull(t);
    return new AbstractList<StackTraceElement>() {
        public StackTraceElement get(int param1Int) {
          return (StackTraceElement)Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceElementMethod, Throwables.jla, new Object[] { this.val$t, Integer.valueOf(param1Int) });
        }
        
        public int size() {
          return ((Integer)Throwables.invokeAccessibleNonThrowingMethod(Throwables.getStackTraceDepthMethod, Throwables.jla, new Object[] { this.val$t })).intValue();
        }
      };
  }
  
  @Beta
  @GwtIncompatible
  public static List<StackTraceElement> lazyStackTrace(Throwable paramThrowable) {
    List<StackTraceElement> list;
    if (lazyStackTraceIsLazy()) {
      list = jlaStackTrace(paramThrowable);
    } else {
      list = Collections.unmodifiableList(Arrays.asList(list.getStackTrace()));
    } 
    return list;
  }
  
  @Beta
  @GwtIncompatible
  public static boolean lazyStackTraceIsLazy() {
    boolean bool2;
    Method method = getStackTraceElementMethod;
    boolean bool1 = true;
    if (method != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (getStackTraceDepthMethod == null)
      bool1 = false; 
    return bool2 & bool1;
  }
  
  @Deprecated
  @GwtIncompatible
  @CanIgnoreReturnValue
  public static RuntimeException propagate(Throwable paramThrowable) {
    throwIfUnchecked(paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
  
  @Deprecated
  @GwtIncompatible
  public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable paramThrowable, Class<X> paramClass) throws X {
    if (paramThrowable != null)
      throwIfInstanceOf(paramThrowable, paramClass); 
  }
  
  @Deprecated
  @GwtIncompatible
  public static void propagateIfPossible(@Nullable Throwable paramThrowable) {
    if (paramThrowable != null)
      throwIfUnchecked(paramThrowable); 
  }
  
  @GwtIncompatible
  public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X> paramClass) throws X {
    propagateIfInstanceOf(paramThrowable, paramClass);
    propagateIfPossible(paramThrowable);
  }
  
  @GwtIncompatible
  public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1) throws X1, X2 {
    Preconditions.checkNotNull(paramClass1);
    propagateIfInstanceOf(paramThrowable, paramClass);
    propagateIfPossible(paramThrowable, paramClass1);
  }
  
  @GwtIncompatible
  public static <X extends Throwable> void throwIfInstanceOf(Throwable paramThrowable, Class<X> paramClass) throws X {
    Preconditions.checkNotNull(paramThrowable);
    if (!paramClass.isInstance(paramThrowable))
      return; 
    throw (X)paramClass.cast(paramThrowable);
  }
  
  public static void throwIfUnchecked(Throwable paramThrowable) {
    Preconditions.checkNotNull(paramThrowable);
    if (!(paramThrowable instanceof RuntimeException)) {
      if (!(paramThrowable instanceof Error))
        return; 
      throw (Error)paramThrowable;
    } 
    throw (RuntimeException)paramThrowable;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Throwables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */