package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@GwtIncompatible
final class FuturesGetChecked {
  private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new Function<Constructor<?>, Boolean>() {
        public Boolean apply(Constructor<?> param1Constructor) {
          return Boolean.valueOf(Arrays.<Class<?>>asList(param1Constructor.getParameterTypes()).contains(String.class));
        }
      }).reverse();
  
  private static GetCheckedTypeValidator bestGetCheckedTypeValidator() {
    return GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
  }
  
  @VisibleForTesting
  static void checkExceptionClassValidity(Class<? extends Exception> paramClass) {
    Preconditions.checkArgument(isCheckedException(paramClass), "Futures.getChecked exception type (%s) must not be a RuntimeException", paramClass);
    Preconditions.checkArgument(hasConstructorUsableByGetChecked(paramClass), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", paramClass);
  }
  
  @VisibleForTesting
  static GetCheckedTypeValidator classValueValidator() {
    return GetCheckedTypeValidatorHolder.ClassValueValidator.INSTANCE;
  }
  
  @VisibleForTesting
  @CanIgnoreReturnValue
  static <V, X extends Exception> V getChecked(GetCheckedTypeValidator paramGetCheckedTypeValidator, Future<V> paramFuture, Class<X> paramClass) throws X {
    paramGetCheckedTypeValidator.validateClass(paramClass);
    try {
      return paramFuture.get();
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw newWithCause(paramClass, interruptedException);
    } catch (ExecutionException executionException) {
      wrapAndThrowExceptionOrError(executionException.getCause(), paramClass);
      throw (X)new AssertionError();
    } 
  }
  
  @CanIgnoreReturnValue
  static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass) throws X {
    return getChecked(bestGetCheckedTypeValidator(), paramFuture, paramClass);
  }
  
  @CanIgnoreReturnValue
  static <V, X extends Exception> V getChecked(Future<V> paramFuture, Class<X> paramClass, long paramLong, TimeUnit paramTimeUnit) throws X {
    bestGetCheckedTypeValidator().validateClass(paramClass);
    try {
      return paramFuture.get(paramLong, paramTimeUnit);
    } catch (InterruptedException interruptedException) {
      Thread.currentThread().interrupt();
      throw newWithCause(paramClass, interruptedException);
    } catch (TimeoutException timeoutException) {
      throw newWithCause(paramClass, timeoutException);
    } catch (ExecutionException executionException) {
      wrapAndThrowExceptionOrError(executionException.getCause(), paramClass);
      throw (X)new AssertionError();
    } 
  }
  
  private static boolean hasConstructorUsableByGetChecked(Class<? extends Exception> paramClass) {
    try {
      Exception exception = new Exception();
      this();
      newWithCause(paramClass, exception);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  @VisibleForTesting
  static boolean isCheckedException(Class<? extends Exception> paramClass) {
    return RuntimeException.class.isAssignableFrom(paramClass) ^ true;
  }
  
  @Nullable
  private static <X> X newFromConstructor(Constructor<X> paramConstructor, Throwable paramThrowable) {
    Class[] arrayOfClass = paramConstructor.getParameterTypes();
    Object[] arrayOfObject = new Object[arrayOfClass.length];
    for (byte b = 0; b < arrayOfClass.length; b++) {
      Class clazz = arrayOfClass[b];
      if (clazz.equals(String.class)) {
        arrayOfObject[b] = paramThrowable.toString();
      } else if (clazz.equals(Throwable.class)) {
        arrayOfObject[b] = paramThrowable;
      } else {
        return null;
      } 
    } 
    try {
      return paramConstructor.newInstance(arrayOfObject);
    } catch (IllegalArgumentException illegalArgumentException) {
      return null;
    } catch (InstantiationException instantiationException) {
      return null;
    } catch (IllegalAccessException illegalAccessException) {
      return null;
    } catch (InvocationTargetException invocationTargetException) {
      return null;
    } 
  }
  
  private static <X extends Exception> X newWithCause(Class<X> paramClass, Throwable paramThrowable) {
    Iterator<Constructor<Exception>> iterator = preferringStrings((List)Arrays.asList(paramClass.getConstructors())).iterator();
    while (iterator.hasNext()) {
      Exception exception = newFromConstructor(iterator.next(), paramThrowable);
      if (exception != null) {
        if (exception.getCause() == null)
          exception.initCause(paramThrowable); 
        return (X)exception;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No appropriate constructor for exception of type ");
    stringBuilder.append(paramClass);
    stringBuilder.append(" in response to chained exception");
    throw new IllegalArgumentException(stringBuilder.toString(), paramThrowable);
  }
  
  private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> paramList) {
    return WITH_STRING_PARAM_FIRST.sortedCopy(paramList);
  }
  
  @VisibleForTesting
  static GetCheckedTypeValidator weakSetValidator() {
    return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
  }
  
  private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable paramThrowable, Class<X> paramClass) throws X {
    if (!(paramThrowable instanceof Error)) {
      if (paramThrowable instanceof RuntimeException)
        throw (X)new UncheckedExecutionException(paramThrowable); 
      throw newWithCause(paramClass, paramThrowable);
    } 
    throw (X)new ExecutionError((Error)paramThrowable);
  }
  
  @VisibleForTesting
  static interface GetCheckedTypeValidator {
    void validateClass(Class<? extends Exception> param1Class);
  }
  
  @VisibleForTesting
  static class GetCheckedTypeValidatorHolder {
    static final FuturesGetChecked.GetCheckedTypeValidator BEST_VALIDATOR;
    
    static final String CLASS_VALUE_VALIDATOR_NAME;
    
    static {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(GetCheckedTypeValidatorHolder.class.getName());
      stringBuilder.append("$ClassValueValidator");
      CLASS_VALUE_VALIDATOR_NAME = stringBuilder.toString();
      BEST_VALIDATOR = getBestValidator();
    }
    
    static FuturesGetChecked.GetCheckedTypeValidator getBestValidator() {
      try {
        return (FuturesGetChecked.GetCheckedTypeValidator)Class.forName(CLASS_VALUE_VALIDATOR_NAME).getEnumConstants()[0];
      } catch (Throwable throwable) {
        return FuturesGetChecked.weakSetValidator();
      } 
    }
    
    @IgnoreJRERequirement
    enum ClassValueValidator implements FuturesGetChecked.GetCheckedTypeValidator {
      INSTANCE;
      
      private static final ClassValue<Boolean> isValidClass = new ClassValue<Boolean>() {
          protected Boolean computeValue(Class<?> param3Class) {
            FuturesGetChecked.checkExceptionClassValidity(param3Class.asSubclass(Exception.class));
            return Boolean.valueOf(true);
          }
        };
      
      static {
      
      }
      
      public void validateClass(Class<? extends Exception> param2Class) {
        isValidClass.get(param2Class);
      }
    }
    
    static final class null extends ClassValue<Boolean> {
      protected Boolean computeValue(Class<?> param2Class) {
        FuturesGetChecked.checkExceptionClassValidity(param2Class.asSubclass(Exception.class));
        return Boolean.valueOf(true);
      }
    }
    
    enum WeakSetValidator implements FuturesGetChecked.GetCheckedTypeValidator {
      INSTANCE;
      
      private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet<WeakReference<Class<? extends Exception>>>();
      
      static {
      
      }
      
      public void validateClass(Class<? extends Exception> param2Class) {
        Iterator<WeakReference<Class<? extends Exception>>> iterator = validClasses.iterator();
        while (iterator.hasNext()) {
          if (param2Class.equals(((WeakReference)iterator.next()).get()))
            return; 
        } 
        FuturesGetChecked.checkExceptionClassValidity(param2Class);
        if (validClasses.size() > 1000)
          validClasses.clear(); 
        validClasses.add(new WeakReference<Class<? extends Exception>>(param2Class));
      }
    }
  }
  
  @IgnoreJRERequirement
  enum ClassValueValidator implements GetCheckedTypeValidator {
    INSTANCE;
    
    private static final ClassValue<Boolean> isValidClass = new ClassValue<Boolean>() {
        protected Boolean computeValue(Class<?> param3Class) {
          FuturesGetChecked.checkExceptionClassValidity(param3Class.asSubclass(Exception.class));
          return Boolean.valueOf(true);
        }
      };
    
    static {
    
    }
    
    public void validateClass(Class<? extends Exception> param1Class) {
      isValidClass.get(param1Class);
    }
  }
  
  static final class null extends ClassValue<Boolean> {
    protected Boolean computeValue(Class<?> param1Class) {
      FuturesGetChecked.checkExceptionClassValidity(param1Class.asSubclass(Exception.class));
      return Boolean.valueOf(true);
    }
  }
  
  enum WeakSetValidator implements GetCheckedTypeValidator {
    INSTANCE;
    
    private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet<WeakReference<Class<? extends Exception>>>();
    
    static {
    
    }
    
    public void validateClass(Class<? extends Exception> param1Class) {
      Iterator<WeakReference<Class<? extends Exception>>> iterator = validClasses.iterator();
      while (iterator.hasNext()) {
        if (param1Class.equals(((WeakReference)iterator.next()).get()))
          return; 
      } 
      FuturesGetChecked.checkExceptionClassValidity(param1Class);
      if (validClasses.size() > 1000)
        validClasses.clear(); 
      validClasses.add(new WeakReference<Class<? extends Exception>>(param1Class));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\FuturesGetChecked.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */