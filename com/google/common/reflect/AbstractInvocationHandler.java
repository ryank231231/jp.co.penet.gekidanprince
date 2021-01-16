package com.google.common.reflect;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractInvocationHandler implements InvocationHandler {
  private static final Object[] NO_ARGS = new Object[0];
  
  private static boolean isProxyOfSameInterfaces(Object paramObject, Class<?> paramClass) {
    return (paramClass.isInstance(paramObject) || (Proxy.isProxyClass(paramObject.getClass()) && Arrays.equals((Object[])paramObject.getClass().getInterfaces(), (Object[])paramClass.getInterfaces())));
  }
  
  public boolean equals(Object paramObject) {
    return super.equals(paramObject);
  }
  
  protected abstract Object handleInvocation(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable;
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, @Nullable Object[] paramArrayOfObject) throws Throwable {
    Object object;
    Object[] arrayOfObject = paramArrayOfObject;
    if (paramArrayOfObject == null)
      arrayOfObject = NO_ARGS; 
    if (arrayOfObject.length == 0 && paramMethod.getName().equals("hashCode"))
      return Integer.valueOf(hashCode()); 
    int i = arrayOfObject.length;
    boolean bool = true;
    if (i == 1 && paramMethod.getName().equals("equals") && paramMethod.getParameterTypes()[0] == Object.class) {
      object = arrayOfObject[0];
      if (object == null)
        return Boolean.valueOf(false); 
      if (paramObject == object)
        return Boolean.valueOf(true); 
      if (!isProxyOfSameInterfaces(object, paramObject.getClass()) || !equals(Proxy.getInvocationHandler(object)))
        bool = false; 
      return Boolean.valueOf(bool);
    } 
    return (arrayOfObject.length == 0 && object.getName().equals("toString")) ? toString() : handleInvocation(paramObject, (Method)object, arrayOfObject);
  }
  
  public String toString() {
    return super.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\AbstractInvocationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */