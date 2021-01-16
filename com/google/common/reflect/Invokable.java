package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public abstract class Invokable<T, R> extends Element implements GenericDeclaration {
  <M extends java.lang.reflect.AccessibleObject & java.lang.reflect.Member> Invokable(M paramM) {
    super(paramM);
  }
  
  public static <T> Invokable<T, T> from(Constructor<T> paramConstructor) {
    return new ConstructorInvokable<T>(paramConstructor);
  }
  
  public static Invokable<?, Object> from(Method paramMethod) {
    return new MethodInvokable(paramMethod);
  }
  
  public final Class<? super T> getDeclaringClass() {
    return (Class)super.getDeclaringClass();
  }
  
  public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
    ImmutableList.Builder builder = ImmutableList.builder();
    Type[] arrayOfType = getGenericExceptionTypes();
    int i = arrayOfType.length;
    for (byte b = 0; b < i; b++)
      builder.add(TypeToken.of(arrayOfType[b])); 
    return builder.build();
  }
  
  abstract Type[] getGenericExceptionTypes();
  
  abstract Type[] getGenericParameterTypes();
  
  abstract Type getGenericReturnType();
  
  public TypeToken<T> getOwnerType() {
    return TypeToken.of((Class)getDeclaringClass());
  }
  
  abstract Annotation[][] getParameterAnnotations();
  
  public final ImmutableList<Parameter> getParameters() {
    Type[] arrayOfType = getGenericParameterTypes();
    Annotation[][] arrayOfAnnotation = getParameterAnnotations();
    ImmutableList.Builder builder = ImmutableList.builder();
    for (byte b = 0; b < arrayOfType.length; b++)
      builder.add(new Parameter(this, b, TypeToken.of(arrayOfType[b]), arrayOfAnnotation[b])); 
    return builder.build();
  }
  
  public final TypeToken<? extends R> getReturnType() {
    return (TypeToken)TypeToken.of(getGenericReturnType());
  }
  
  @CanIgnoreReturnValue
  public final R invoke(@Nullable T paramT, Object... paramVarArgs) throws InvocationTargetException, IllegalAccessException {
    return (R)invokeInternal(paramT, (Object[])Preconditions.checkNotNull(paramVarArgs));
  }
  
  abstract Object invokeInternal(@Nullable Object paramObject, Object[] paramArrayOfObject) throws InvocationTargetException, IllegalAccessException;
  
  public abstract boolean isOverridable();
  
  public abstract boolean isVarArgs();
  
  public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> paramTypeToken) {
    if (paramTypeToken.isSupertypeOf(getReturnType()))
      return this; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invokable is known to return ");
    stringBuilder.append(getReturnType());
    stringBuilder.append(", not ");
    stringBuilder.append(paramTypeToken);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final <R1 extends R> Invokable<T, R1> returning(Class<R1> paramClass) {
    return returning(TypeToken.of(paramClass));
  }
  
  static class ConstructorInvokable<T> extends Invokable<T, T> {
    final Constructor<?> constructor;
    
    ConstructorInvokable(Constructor<?> param1Constructor) {
      super(param1Constructor);
      this.constructor = param1Constructor;
    }
    
    private boolean mayNeedHiddenThis() {
      Class<?> clazz = this.constructor.getDeclaringClass();
      Constructor<?> constructor = clazz.getEnclosingConstructor();
      boolean bool = true;
      if (constructor != null)
        return true; 
      Method method = clazz.getEnclosingMethod();
      if (method != null)
        return Modifier.isStatic(method.getModifiers()) ^ true; 
      if (clazz.getEnclosingClass() == null || Modifier.isStatic(clazz.getModifiers()))
        bool = false; 
      return bool;
    }
    
    Type[] getGenericExceptionTypes() {
      return this.constructor.getGenericExceptionTypes();
    }
    
    Type[] getGenericParameterTypes() {
      Type[] arrayOfType = this.constructor.getGenericParameterTypes();
      if (arrayOfType.length > 0 && mayNeedHiddenThis()) {
        Class[] arrayOfClass = this.constructor.getParameterTypes();
        if (arrayOfType.length == arrayOfClass.length && arrayOfClass[0] == getDeclaringClass().getEnclosingClass())
          return Arrays.<Type>copyOfRange(arrayOfType, 1, arrayOfType.length); 
      } 
      return arrayOfType;
    }
    
    Type getGenericReturnType() {
      Class<? super T> clazz = getDeclaringClass();
      TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
      return (Type)((arrayOfTypeVariable.length > 0) ? Types.newParameterizedType(clazz, (Type[])arrayOfTypeVariable) : clazz);
    }
    
    final Annotation[][] getParameterAnnotations() {
      return this.constructor.getParameterAnnotations();
    }
    
    public final TypeVariable<?>[] getTypeParameters() {
      TypeVariable[] arrayOfTypeVariable1 = (TypeVariable[])getDeclaringClass().getTypeParameters();
      TypeVariable[] arrayOfTypeVariable2 = (TypeVariable[])this.constructor.getTypeParameters();
      TypeVariable[] arrayOfTypeVariable3 = new TypeVariable[arrayOfTypeVariable1.length + arrayOfTypeVariable2.length];
      System.arraycopy(arrayOfTypeVariable1, 0, arrayOfTypeVariable3, 0, arrayOfTypeVariable1.length);
      System.arraycopy(arrayOfTypeVariable2, 0, arrayOfTypeVariable3, arrayOfTypeVariable1.length, arrayOfTypeVariable2.length);
      return (TypeVariable<?>[])arrayOfTypeVariable3;
    }
    
    final Object invokeInternal(@Nullable Object param1Object, Object[] param1ArrayOfObject) throws InvocationTargetException, IllegalAccessException {
      try {
        return this.constructor.newInstance(param1ArrayOfObject);
      } catch (InstantiationException instantiationException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.constructor);
        stringBuilder.append(" failed.");
        throw new RuntimeException(stringBuilder.toString(), instantiationException);
      } 
    }
    
    public final boolean isOverridable() {
      return false;
    }
    
    public final boolean isVarArgs() {
      return this.constructor.isVarArgs();
    }
  }
  
  static class MethodInvokable<T> extends Invokable<T, Object> {
    final Method method;
    
    MethodInvokable(Method param1Method) {
      super(param1Method);
      this.method = param1Method;
    }
    
    Type[] getGenericExceptionTypes() {
      return this.method.getGenericExceptionTypes();
    }
    
    Type[] getGenericParameterTypes() {
      return this.method.getGenericParameterTypes();
    }
    
    Type getGenericReturnType() {
      return this.method.getGenericReturnType();
    }
    
    final Annotation[][] getParameterAnnotations() {
      return this.method.getParameterAnnotations();
    }
    
    public final TypeVariable<?>[] getTypeParameters() {
      return (TypeVariable<?>[])this.method.getTypeParameters();
    }
    
    final Object invokeInternal(@Nullable Object param1Object, Object[] param1ArrayOfObject) throws InvocationTargetException, IllegalAccessException {
      return this.method.invoke(param1Object, param1ArrayOfObject);
    }
    
    public final boolean isOverridable() {
      boolean bool;
      if (!isFinal() && !isPrivate() && !isStatic() && !Modifier.isFinal(getDeclaringClass().getModifiers())) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public final boolean isVarArgs() {
      return this.method.isVarArgs();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\Invokable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */