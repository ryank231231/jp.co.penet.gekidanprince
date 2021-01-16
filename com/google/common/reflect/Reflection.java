package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Beta
public final class Reflection {
  public static String getPackageName(Class<?> paramClass) {
    return getPackageName(paramClass.getName());
  }
  
  public static String getPackageName(String paramString) {
    int i = paramString.lastIndexOf('.');
    if (i < 0) {
      paramString = "";
    } else {
      paramString = paramString.substring(0, i);
    } 
    return paramString;
  }
  
  public static void initialize(Class<?>... paramVarArgs) {
    int i = paramVarArgs.length;
    byte b = 0;
    while (b < i) {
      Class<?> clazz = paramVarArgs[b];
      try {
        Class.forName(clazz.getName(), true, clazz.getClassLoader());
        b++;
      } catch (ClassNotFoundException classNotFoundException) {
        throw new AssertionError(classNotFoundException);
      } 
    } 
  }
  
  public static <T> T newProxy(Class<T> paramClass, InvocationHandler paramInvocationHandler) {
    Preconditions.checkNotNull(paramInvocationHandler);
    Preconditions.checkArgument(paramClass.isInterface(), "%s is not an interface", paramClass);
    return paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */