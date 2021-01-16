package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

final class Types {
  private static final Joiner COMMA_JOINER;
  
  private static final Function<Type, String> TYPE_NAME = new Function<Type, String>() {
      public String apply(Type param1Type) {
        return Types.JavaVersion.CURRENT.typeName(param1Type);
      }
    };
  
  static {
    COMMA_JOINER = Joiner.on(", ").useForNull("null");
  }
  
  private static void disallowPrimitiveType(Type[] paramArrayOfType, String paramString) {
    int i = paramArrayOfType.length;
    for (byte b = 0; b < i; b++) {
      Type type = paramArrayOfType[b];
      if (type instanceof Class) {
        type = type;
        Preconditions.checkArgument(type.isPrimitive() ^ true, "Primitive type '%s' used as %s", type, paramString);
      } 
    } 
  }
  
  private static Iterable<Type> filterUpperBounds(Iterable<Type> paramIterable) {
    return Iterables.filter(paramIterable, Predicates.not(Predicates.equalTo(Object.class)));
  }
  
  static Class<?> getArrayClass(Class<?> paramClass) {
    return Array.newInstance(paramClass, 0).getClass();
  }
  
  @Nullable
  static Type getComponentType(Type paramType) {
    Preconditions.checkNotNull(paramType);
    final AtomicReference<Type> result = new AtomicReference();
    (new TypeVisitor() {
        void visitClass(Class<?> param1Class) {
          result.set(param1Class.getComponentType());
        }
        
        void visitGenericArrayType(GenericArrayType param1GenericArrayType) {
          result.set(param1GenericArrayType.getGenericComponentType());
        }
        
        void visitTypeVariable(TypeVariable<?> param1TypeVariable) {
          result.set(Types.subtypeOfComponentType(param1TypeVariable.getBounds()));
        }
        
        void visitWildcardType(WildcardType param1WildcardType) {
          result.set(Types.subtypeOfComponentType(param1WildcardType.getUpperBounds()));
        }
      }).visit(new Type[] { paramType });
    return atomicReference.get();
  }
  
  static Type newArrayType(Type paramType) {
    Type[] arrayOfType;
    if (paramType instanceof WildcardType) {
      boolean bool2;
      WildcardType wildcardType = (WildcardType)paramType;
      arrayOfType = wildcardType.getLowerBounds();
      int i = arrayOfType.length;
      boolean bool1 = true;
      if (i <= 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Wildcard cannot have more than one lower bounds.");
      if (arrayOfType.length == 1)
        return supertypeOf(newArrayType(arrayOfType[0])); 
      arrayOfType = wildcardType.getUpperBounds();
      if (arrayOfType.length == 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "Wildcard should have only one upper bound.");
      return subtypeOf(newArrayType(arrayOfType[0]));
    } 
    return JavaVersion.CURRENT.newArrayType((Type)arrayOfType);
  }
  
  static <D extends GenericDeclaration> TypeVariable<D> newArtificialTypeVariable(D paramD, String paramString, Type... paramVarArgs) {
    Type[] arrayOfType = paramVarArgs;
    if (paramVarArgs.length == 0) {
      arrayOfType = new Type[1];
      arrayOfType[0] = Object.class;
    } 
    return newTypeVariableImpl(paramD, paramString, arrayOfType);
  }
  
  static ParameterizedType newParameterizedType(Class<?> paramClass, Type... paramVarArgs) {
    return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(paramClass), paramClass, paramVarArgs);
  }
  
  static ParameterizedType newParameterizedTypeWithOwner(@Nullable Type paramType, Class<?> paramClass, Type... paramVarArgs) {
    boolean bool;
    if (paramType == null)
      return newParameterizedType(paramClass, paramVarArgs); 
    Preconditions.checkNotNull(paramVarArgs);
    if (paramClass.getEnclosingClass() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Owner type for unenclosed %s", paramClass);
    return new ParameterizedTypeImpl(paramType, paramClass, paramVarArgs);
  }
  
  private static <D extends GenericDeclaration> TypeVariable<D> newTypeVariableImpl(D paramD, String paramString, Type[] paramArrayOfType) {
    return Reflection.<TypeVariable<D>>newProxy((Class)TypeVariable.class, new TypeVariableInvocationHandler(new TypeVariableImpl(paramD, paramString, paramArrayOfType)));
  }
  
  @VisibleForTesting
  static WildcardType subtypeOf(Type paramType) {
    return new WildcardTypeImpl(new Type[0], new Type[] { paramType });
  }
  
  @Nullable
  private static Type subtypeOfComponentType(Type[] paramArrayOfType) {
    int i = paramArrayOfType.length;
    for (byte b = 0; b < i; b++) {
      Type type = getComponentType(paramArrayOfType[b]);
      if (type != null) {
        if (type instanceof Class) {
          Class clazz = (Class)type;
          if (clazz.isPrimitive())
            return clazz; 
        } 
        return subtypeOf(type);
      } 
    } 
    return null;
  }
  
  @VisibleForTesting
  static WildcardType supertypeOf(Type paramType) {
    return new WildcardTypeImpl(new Type[] { paramType }, new Type[] { Object.class });
  }
  
  private static Type[] toArray(Collection<Type> paramCollection) {
    return paramCollection.<Type>toArray(new Type[paramCollection.size()]);
  }
  
  static String toString(Type paramType) {
    String str;
    if (paramType instanceof Class) {
      str = ((Class)paramType).getName();
    } else {
      str = str.toString();
    } 
    return str;
  }
  
  private enum ClassOwnership {
    LOCAL_CLASS_HAS_NO_OWNER,
    OWNED_BY_ENCLOSING_CLASS {
      @Nullable
      Class<?> getOwnerType(Class<?> param2Class) {
        return param2Class.getEnclosingClass();
      }
    };
    
    static final ClassOwnership JVM_BEHAVIOR;
    
    static {
      $VALUES = new ClassOwnership[] { OWNED_BY_ENCLOSING_CLASS, LOCAL_CLASS_HAS_NO_OWNER };
      JVM_BEHAVIOR = detectJvmBehavior();
    }
    
    private static ClassOwnership detectJvmBehavior() {
      ParameterizedType parameterizedType = (ParameterizedType)(new LocalClass<String>() {
        
        }).getClass().getGenericSuperclass();
      for (ClassOwnership classOwnership : values()) {
        if (classOwnership.getOwnerType(LocalClass.class) == parameterizedType.getOwnerType())
          return classOwnership; 
      } 
      throw new AssertionError();
    }
    
    @Nullable
    abstract Class<?> getOwnerType(Class<?> param1Class);
  }
  
  enum null {
    @Nullable
    Class<?> getOwnerType(Class<?> param1Class) {
      return param1Class.getEnclosingClass();
    }
  }
  
  class LocalClass<T> {}
  
  enum null {
    @Nullable
    Class<?> getOwnerType(Class<?> param1Class) {
      return param1Class.isLocalClass() ? null : param1Class.getEnclosingClass();
    }
  }
  
  static final class null extends ClassOwnership.LocalClass<String> {}
  
  private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Type componentType;
    
    GenericArrayTypeImpl(Type param1Type) {
      this.componentType = Types.JavaVersion.CURRENT.usedInGenericType(param1Type);
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object instanceof GenericArrayType) {
        param1Object = param1Object;
        return Objects.equal(getGenericComponentType(), param1Object.getGenericComponentType());
      } 
      return false;
    }
    
    public Type getGenericComponentType() {
      return this.componentType;
    }
    
    public int hashCode() {
      return this.componentType.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Types.toString(this.componentType));
      stringBuilder.append("[]");
      return stringBuilder.toString();
    }
  }
  
  enum JavaVersion {
    JAVA6 {
      GenericArrayType newArrayType(Type param2Type) {
        return new Types.GenericArrayTypeImpl(param2Type);
      }
      
      Type usedInGenericType(Type param2Type) {
        Preconditions.checkNotNull(param2Type);
        if (param2Type instanceof Class) {
          Class clazz = (Class)param2Type;
          if (clazz.isArray())
            return new Types.GenericArrayTypeImpl(clazz.getComponentType()); 
        } 
        return param2Type;
      }
    },
    JAVA7 {
      Type newArrayType(Type param2Type) {
        return (Type)((param2Type instanceof Class) ? Types.getArrayClass((Class)param2Type) : new Types.GenericArrayTypeImpl(param2Type));
      }
      
      Type usedInGenericType(Type param2Type) {
        return (Type)Preconditions.checkNotNull(param2Type);
      }
    },
    JAVA8 {
      Type newArrayType(Type param2Type) {
        return JAVA7.newArrayType(param2Type);
      }
      
      String typeName(Type param2Type) {
        try {
          return (String)Type.class.getMethod("getTypeName", new Class[0]).invoke(param2Type, new Object[0]);
        } catch (NoSuchMethodException noSuchMethodException) {
          throw new AssertionError("Type.getTypeName should be available in Java 8");
        } catch (InvocationTargetException invocationTargetException) {
          throw new RuntimeException(invocationTargetException);
        } catch (IllegalAccessException illegalAccessException) {
          throw new RuntimeException(illegalAccessException);
        } 
      }
      
      Type usedInGenericType(Type param2Type) {
        return JAVA7.usedInGenericType(param2Type);
      }
    };
    
    static final JavaVersion CURRENT;
    
    static {
      if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
        CURRENT = JAVA8;
      } else if ((new TypeCapture<int[]>() {
        
        }).capture() instanceof Class) {
        CURRENT = JAVA7;
      } else {
        CURRENT = JAVA6;
      } 
    }
    
    abstract Type newArrayType(Type param1Type);
    
    String typeName(Type param1Type) {
      return Types.toString(param1Type);
    }
    
    final ImmutableList<Type> usedInGenericType(Type[] param1ArrayOfType) {
      ImmutableList.Builder builder = ImmutableList.builder();
      int i = param1ArrayOfType.length;
      for (byte b = 0; b < i; b++)
        builder.add(usedInGenericType(param1ArrayOfType[b])); 
      return builder.build();
    }
    
    abstract Type usedInGenericType(Type param1Type);
  }
  
  enum null {
    GenericArrayType newArrayType(Type param1Type) {
      return new Types.GenericArrayTypeImpl(param1Type);
    }
    
    Type usedInGenericType(Type param1Type) {
      Preconditions.checkNotNull(param1Type);
      if (param1Type instanceof Class) {
        Class clazz = (Class)param1Type;
        if (clazz.isArray())
          return new Types.GenericArrayTypeImpl(clazz.getComponentType()); 
      } 
      return param1Type;
    }
  }
  
  enum null {
    Type newArrayType(Type param1Type) {
      return (Type)((param1Type instanceof Class) ? Types.getArrayClass((Class)param1Type) : new Types.GenericArrayTypeImpl(param1Type));
    }
    
    Type usedInGenericType(Type param1Type) {
      return (Type)Preconditions.checkNotNull(param1Type);
    }
  }
  
  enum null {
    Type newArrayType(Type param1Type) {
      return JAVA7.newArrayType(param1Type);
    }
    
    String typeName(Type param1Type) {
      try {
        return (String)Type.class.getMethod("getTypeName", new Class[0]).invoke(param1Type, new Object[0]);
      } catch (NoSuchMethodException noSuchMethodException) {
        throw new AssertionError("Type.getTypeName should be available in Java 8");
      } catch (InvocationTargetException invocationTargetException) {
        throw new RuntimeException(invocationTargetException);
      } catch (IllegalAccessException illegalAccessException) {
        throw new RuntimeException(illegalAccessException);
      } 
    }
    
    Type usedInGenericType(Type param1Type) {
      return JAVA7.usedInGenericType(param1Type);
    }
  }
  
  static final class null extends TypeCapture<int[]> {}
  
  static final class NativeTypeVariableEquals<X> {
    static final boolean NATIVE_TYPE_VARIABLE_ONLY = NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.newArtificialTypeVariable(NativeTypeVariableEquals.class, "X", new Type[0])) ^ true;
  }
  
  private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final ImmutableList<Type> argumentsList;
    
    private final Type ownerType;
    
    private final Class<?> rawType;
    
    ParameterizedTypeImpl(@Nullable Type param1Type, Class<?> param1Class, Type[] param1ArrayOfType) {
      boolean bool;
      Preconditions.checkNotNull(param1Class);
      if (param1ArrayOfType.length == (param1Class.getTypeParameters()).length) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      Types.disallowPrimitiveType(param1ArrayOfType, "type parameter");
      this.ownerType = param1Type;
      this.rawType = param1Class;
      this.argumentsList = Types.JavaVersion.CURRENT.usedInGenericType(param1ArrayOfType);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof ParameterizedType;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (getRawType().equals(param1Object.getRawType())) {
        bool = bool1;
        if (Objects.equal(getOwnerType(), param1Object.getOwnerType())) {
          bool = bool1;
          if (Arrays.equals((Object[])getActualTypeArguments(), (Object[])param1Object.getActualTypeArguments()))
            bool = true; 
        } 
      } 
      return bool;
    }
    
    public Type[] getActualTypeArguments() {
      return Types.toArray((Collection<Type>)this.argumentsList);
    }
    
    public Type getOwnerType() {
      return this.ownerType;
    }
    
    public Type getRawType() {
      return this.rawType;
    }
    
    public int hashCode() {
      int i;
      Type type = this.ownerType;
      if (type == null) {
        i = 0;
      } else {
        i = type.hashCode();
      } 
      return i ^ this.argumentsList.hashCode() ^ this.rawType.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      if (this.ownerType != null) {
        stringBuilder.append(Types.JavaVersion.CURRENT.typeName(this.ownerType));
        stringBuilder.append('.');
      } 
      stringBuilder.append(this.rawType.getName());
      stringBuilder.append('<');
      stringBuilder.append(Types.COMMA_JOINER.join(Iterables.transform((Iterable)this.argumentsList, Types.TYPE_NAME)));
      stringBuilder.append('>');
      return stringBuilder.toString();
    }
  }
  
  private static final class TypeVariableImpl<D extends GenericDeclaration> {
    private final ImmutableList<Type> bounds;
    
    private final D genericDeclaration;
    
    private final String name;
    
    TypeVariableImpl(D param1D, String param1String, Type[] param1ArrayOfType) {
      Types.disallowPrimitiveType(param1ArrayOfType, "bound for type variable");
      this.genericDeclaration = (D)Preconditions.checkNotNull(param1D);
      this.name = (String)Preconditions.checkNotNull(param1String);
      this.bounds = ImmutableList.copyOf((Object[])param1ArrayOfType);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY;
      boolean bool1 = true;
      boolean bool2 = true;
      if (bool) {
        if (param1Object != null && Proxy.isProxyClass(param1Object.getClass()) && Proxy.getInvocationHandler(param1Object) instanceof Types.TypeVariableInvocationHandler) {
          param1Object = ((Types.TypeVariableInvocationHandler)Proxy.getInvocationHandler(param1Object)).typeVariableImpl;
          if (!this.name.equals(param1Object.getName()) || !this.genericDeclaration.equals(param1Object.getGenericDeclaration()) || !this.bounds.equals(((TypeVariableImpl)param1Object).bounds))
            bool2 = false; 
          return bool2;
        } 
        return false;
      } 
      if (param1Object instanceof TypeVariable) {
        param1Object = param1Object;
        if (this.name.equals(param1Object.getName()) && this.genericDeclaration.equals(param1Object.getGenericDeclaration())) {
          bool2 = bool1;
        } else {
          bool2 = false;
        } 
        return bool2;
      } 
      return false;
    }
    
    public Type[] getBounds() {
      return Types.toArray((Collection<Type>)this.bounds);
    }
    
    public D getGenericDeclaration() {
      return this.genericDeclaration;
    }
    
    public String getName() {
      return this.name;
    }
    
    public String getTypeName() {
      return this.name;
    }
    
    public int hashCode() {
      return this.genericDeclaration.hashCode() ^ this.name.hashCode();
    }
    
    public String toString() {
      return this.name;
    }
  }
  
  private static final class TypeVariableInvocationHandler implements InvocationHandler {
    private static final ImmutableMap<String, Method> typeVariableMethods;
    
    private final Types.TypeVariableImpl<?> typeVariableImpl;
    
    static {
      ImmutableMap.Builder builder = ImmutableMap.builder();
      Method[] arrayOfMethod = Types.TypeVariableImpl.class.getMethods();
      int i = arrayOfMethod.length;
      byte b = 0;
      while (true) {
        if (b < i) {
          Method method = arrayOfMethod[b];
          if (method.getDeclaringClass().equals(Types.TypeVariableImpl.class)) {
            try {
              method.setAccessible(true);
            } catch (AccessControlException accessControlException) {}
            builder.put(method.getName(), method);
          } 
          b++;
          continue;
        } 
        typeVariableMethods = builder.build();
        return;
      } 
    }
    
    TypeVariableInvocationHandler(Types.TypeVariableImpl<?> param1TypeVariableImpl) {
      this.typeVariableImpl = param1TypeVariableImpl;
    }
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
      param1Object = param1Method.getName();
      param1Method = (Method)typeVariableMethods.get(param1Object);
      if (param1Method != null)
        try {
          return param1Method.invoke(this.typeVariableImpl, param1ArrayOfObject);
        } catch (InvocationTargetException invocationTargetException) {
          throw invocationTargetException.getCause();
        }  
      throw new UnsupportedOperationException(invocationTargetException);
    }
  }
  
  static final class WildcardTypeImpl implements WildcardType, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final ImmutableList<Type> lowerBounds;
    
    private final ImmutableList<Type> upperBounds;
    
    WildcardTypeImpl(Type[] param1ArrayOfType1, Type[] param1ArrayOfType2) {
      Types.disallowPrimitiveType(param1ArrayOfType1, "lower bound for wildcard");
      Types.disallowPrimitiveType(param1ArrayOfType2, "upper bound for wildcard");
      this.lowerBounds = Types.JavaVersion.CURRENT.usedInGenericType(param1ArrayOfType1);
      this.upperBounds = Types.JavaVersion.CURRENT.usedInGenericType(param1ArrayOfType2);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof WildcardType;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.lowerBounds.equals(Arrays.asList(param1Object.getLowerBounds()))) {
          bool = bool1;
          if (this.upperBounds.equals(Arrays.asList(param1Object.getUpperBounds())))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public Type[] getLowerBounds() {
      return Types.toArray((Collection<Type>)this.lowerBounds);
    }
    
    public Type[] getUpperBounds() {
      return Types.toArray((Collection<Type>)this.upperBounds);
    }
    
    public int hashCode() {
      return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("?");
      for (Type type : this.lowerBounds) {
        stringBuilder.append(" super ");
        stringBuilder.append(Types.JavaVersion.CURRENT.typeName(type));
      } 
      for (Type type : Types.filterUpperBounds((Iterable<Type>)this.upperBounds)) {
        stringBuilder.append(" extends ");
        stringBuilder.append(Types.JavaVersion.CURRENT.typeName(type));
      } 
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */