package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
  private final Type runtimeType;
  
  private transient TypeResolver typeResolver;
  
  protected TypeToken() {
    boolean bool;
    this.runtimeType = capture();
    if (!(this.runtimeType instanceof TypeVariable)) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
  }
  
  protected TypeToken(Class<?> paramClass) {
    Type type = capture();
    if (type instanceof Class) {
      this.runtimeType = type;
    } else {
      this.runtimeType = (of((Class)paramClass).resolveType(type)).runtimeType;
    } 
  }
  
  private TypeToken(Type paramType) {
    this.runtimeType = (Type)Preconditions.checkNotNull(paramType);
  }
  
  private static Bounds any(Type[] paramArrayOfType) {
    return new Bounds(paramArrayOfType, true);
  }
  
  @Nullable
  private TypeToken<? super T> boundAsSuperclass(Type paramType) {
    TypeToken<?> typeToken = of(paramType);
    return (TypeToken)(typeToken.getRawType().isInterface() ? null : typeToken);
  }
  
  private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] paramArrayOfType) {
    ImmutableList.Builder builder = ImmutableList.builder();
    int i = paramArrayOfType.length;
    for (byte b = 0; b < i; b++) {
      TypeToken<?> typeToken = of(paramArrayOfType[b]);
      if (typeToken.getRawType().isInterface())
        builder.add(typeToken); 
    } 
    return builder.build();
  }
  
  private static Bounds every(Type[] paramArrayOfType) {
    return new Bounds(paramArrayOfType, false);
  }
  
  private TypeToken<? extends T> getArraySubtype(Class<?> paramClass) {
    return (TypeToken)of(newArrayClassOrGenericArrayType((getComponentType().getSubtype(paramClass.getComponentType())).runtimeType));
  }
  
  private TypeToken<? super T> getArraySupertype(Class<? super T> paramClass) {
    return (TypeToken)of(newArrayClassOrGenericArrayType((((TypeToken)Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", paramClass, this)).getSupertype((Class)paramClass.getComponentType())).runtimeType));
  }
  
  @Nullable
  private Type getOwnerTypeIfPresent() {
    Type type = this.runtimeType;
    return (type instanceof ParameterizedType) ? ((ParameterizedType)type).getOwnerType() : ((type instanceof Class) ? ((Class)type).getEnclosingClass() : null);
  }
  
  private ImmutableSet<Class<? super T>> getRawTypes() {
    final ImmutableSet.Builder builder = ImmutableSet.builder();
    (new TypeVisitor() {
        void visitClass(Class<?> param1Class) {
          builder.add(param1Class);
        }
        
        void visitGenericArrayType(GenericArrayType param1GenericArrayType) {
          builder.add(Types.getArrayClass(TypeToken.of(param1GenericArrayType.getGenericComponentType()).getRawType()));
        }
        
        void visitParameterizedType(ParameterizedType param1ParameterizedType) {
          builder.add(param1ParameterizedType.getRawType());
        }
        
        void visitTypeVariable(TypeVariable<?> param1TypeVariable) {
          visit(param1TypeVariable.getBounds());
        }
        
        void visitWildcardType(WildcardType param1WildcardType) {
          visit(param1WildcardType.getUpperBounds());
        }
      }).visit(new Type[] { this.runtimeType });
    return builder.build();
  }
  
  private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> paramClass, Type[] paramArrayOfType) {
    if (paramArrayOfType.length > 0)
      return (TypeToken)of(paramArrayOfType[0]).getSubtype(paramClass); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramClass);
    stringBuilder.append(" isn't a subclass of ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> paramClass, Type[] paramArrayOfType) {
    int i = paramArrayOfType.length;
    for (byte b = 0; b < i; b++) {
      TypeToken<?> typeToken = of(paramArrayOfType[b]);
      if (typeToken.isSubtypeOf(paramClass))
        return (TypeToken)typeToken.getSupertype(paramClass); 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramClass);
    stringBuilder.append(" isn't a super type of ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private boolean is(Type paramType) {
    boolean bool = this.runtimeType.equals(paramType);
    boolean bool1 = true;
    if (bool)
      return true; 
    if (paramType instanceof WildcardType) {
      paramType = paramType;
      if (!every(paramType.getUpperBounds()).isSupertypeOf(this.runtimeType) || !every(paramType.getLowerBounds()).isSubtypeOf(this.runtimeType))
        bool1 = false; 
      return bool1;
    } 
    return false;
  }
  
  private boolean isOwnedBySubtypeOf(Type paramType) {
    Iterator<TypeToken> iterator = getTypes().iterator();
    while (iterator.hasNext()) {
      Type type = ((TypeToken)iterator.next()).getOwnerTypeIfPresent();
      if (type != null && of(type).isSubtypeOf(paramType))
        return true; 
    } 
    return false;
  }
  
  private boolean isSubtypeOfArrayType(GenericArrayType paramGenericArrayType) {
    Type type = this.runtimeType;
    if (type instanceof Class) {
      type = type;
      return !type.isArray() ? false : of(type.getComponentType()).isSubtypeOf(paramGenericArrayType.getGenericComponentType());
    } 
    return (type instanceof GenericArrayType) ? of(((GenericArrayType)type).getGenericComponentType()).isSubtypeOf(paramGenericArrayType.getGenericComponentType()) : false;
  }
  
  private boolean isSubtypeOfParameterizedType(ParameterizedType paramParameterizedType) {
    Class<?> clazz = of(paramParameterizedType).getRawType();
    boolean bool = someRawTypeIsSubclassOf(clazz);
    boolean bool1 = false;
    if (!bool)
      return false; 
    TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    for (byte b = 0; b < arrayOfTypeVariable.length; b++) {
      if (!resolveType(arrayOfTypeVariable[b]).is(arrayOfType[b]))
        return false; 
    } 
    if (Modifier.isStatic(((Class)paramParameterizedType.getRawType()).getModifiers()) || paramParameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(paramParameterizedType.getOwnerType()))
      bool1 = true; 
    return bool1;
  }
  
  private boolean isSupertypeOfArray(GenericArrayType paramGenericArrayType) {
    Type type = this.runtimeType;
    if (type instanceof Class) {
      type = type;
      return !type.isArray() ? type.isAssignableFrom(Object[].class) : of(paramGenericArrayType.getGenericComponentType()).isSubtypeOf(type.getComponentType());
    } 
    return (type instanceof GenericArrayType) ? of(paramGenericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType)this.runtimeType).getGenericComponentType()) : false;
  }
  
  private boolean isWrapper() {
    return Primitives.allWrapperTypes().contains(this.runtimeType);
  }
  
  private static Type newArrayClassOrGenericArrayType(Type paramType) {
    return Types.JavaVersion.JAVA7.newArrayType(paramType);
  }
  
  public static <T> TypeToken<T> of(Class<T> paramClass) {
    return new SimpleTypeToken<T>(paramClass);
  }
  
  public static TypeToken<?> of(Type paramType) {
    return new SimpleTypeToken(paramType);
  }
  
  private Type[] resolveInPlace(Type[] paramArrayOfType) {
    for (byte b = 0; b < paramArrayOfType.length; b++)
      paramArrayOfType[b] = resolveType(paramArrayOfType[b]).getType(); 
    return paramArrayOfType;
  }
  
  private TypeToken<?> resolveSupertype(Type paramType) {
    TypeToken<?> typeToken = resolveType(paramType);
    typeToken.typeResolver = this.typeResolver;
    return typeToken;
  }
  
  private Type resolveTypeArgsForSubclass(Class<?> paramClass) {
    if (this.runtimeType instanceof Class && ((paramClass.getTypeParameters()).length == 0 || (getRawType().getTypeParameters()).length != 0))
      return paramClass; 
    TypeToken<?> typeToken = toGenericType(paramClass);
    Type type = (typeToken.getSupertype(getRawType())).runtimeType;
    return (new TypeResolver()).where(type, this.runtimeType).resolveType(typeToken.runtimeType);
  }
  
  private boolean someRawTypeIsSubclassOf(Class<?> paramClass) {
    Iterator<Class<?>> iterator = getRawTypes().iterator();
    while (iterator.hasNext()) {
      if (paramClass.isAssignableFrom(iterator.next()))
        return true; 
    } 
    return false;
  }
  
  @VisibleForTesting
  static <T> TypeToken<? extends T> toGenericType(Class<T> paramClass) {
    Class clazz;
    if (paramClass.isArray())
      return (TypeToken)of(Types.newArrayType((toGenericType((Class)paramClass.getComponentType())).runtimeType)); 
    TypeVariable[] arrayOfTypeVariable = (TypeVariable[])paramClass.getTypeParameters();
    if (paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) {
      clazz = (Class)(toGenericType((Class)paramClass.getEnclosingClass())).runtimeType;
    } else {
      clazz = null;
    } 
    return (TypeToken)((arrayOfTypeVariable.length > 0 || (clazz != null && clazz != paramClass.getEnclosingClass())) ? of(Types.newParameterizedTypeWithOwner(clazz, paramClass, (Type[])arrayOfTypeVariable)) : of(paramClass));
  }
  
  public final Invokable<T, T> constructor(Constructor<?> paramConstructor) {
    boolean bool;
    if (paramConstructor.getDeclaringClass() == getRawType()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "%s not declared by %s", paramConstructor, getRawType());
    return new Invokable.ConstructorInvokable<T>(paramConstructor) {
        Type[] getGenericExceptionTypes() {
          return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
        }
        
        Type[] getGenericParameterTypes() {
          return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
        }
        
        Type getGenericReturnType() {
          return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
        }
        
        public TypeToken<T> getOwnerType() {
          return TypeToken.this;
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(getOwnerType());
          stringBuilder.append("(");
          stringBuilder.append(Joiner.on(", ").join((Object[])getGenericParameterTypes()));
          stringBuilder.append(")");
          return stringBuilder.toString();
        }
      };
  }
  
  public boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof TypeToken) {
      paramObject = paramObject;
      return this.runtimeType.equals(((TypeToken)paramObject).runtimeType);
    } 
    return false;
  }
  
  @Nullable
  public final TypeToken<?> getComponentType() {
    Type type = Types.getComponentType(this.runtimeType);
    return (type == null) ? null : of(type);
  }
  
  final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
    Type type = this.runtimeType;
    if (type instanceof TypeVariable)
      return boundsAsInterfaces(((TypeVariable)type).getBounds()); 
    if (type instanceof WildcardType)
      return boundsAsInterfaces(((WildcardType)type).getUpperBounds()); 
    ImmutableList.Builder builder = ImmutableList.builder();
    Type[] arrayOfType = getRawType().getGenericInterfaces();
    int i = arrayOfType.length;
    for (byte b = 0; b < i; b++)
      builder.add(resolveSupertype(arrayOfType[b])); 
    return builder.build();
  }
  
  @Nullable
  final TypeToken<? super T> getGenericSuperclass() {
    Type type = this.runtimeType;
    if (type instanceof TypeVariable)
      return boundAsSuperclass(((TypeVariable)type).getBounds()[0]); 
    if (type instanceof WildcardType)
      return boundAsSuperclass(((WildcardType)type).getUpperBounds()[0]); 
    type = getRawType().getGenericSuperclass();
    return (TypeToken)((type == null) ? null : resolveSupertype(type));
  }
  
  public final Class<? super T> getRawType() {
    return (Class<? super T>)getRawTypes().iterator().next();
  }
  
  public final TypeToken<? extends T> getSubtype(Class<?> paramClass) {
    boolean bool;
    if (!(this.runtimeType instanceof TypeVariable)) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "Cannot get subtype of type variable <%s>", this);
    Type type = this.runtimeType;
    if (type instanceof WildcardType)
      return getSubtypeFromLowerBounds(paramClass, ((WildcardType)type).getLowerBounds()); 
    if (isArray())
      return getArraySubtype(paramClass); 
    Preconditions.checkArgument(getRawType().isAssignableFrom(paramClass), "%s isn't a subclass of %s", paramClass, this);
    return (TypeToken)of(resolveTypeArgsForSubclass(paramClass));
  }
  
  public final TypeToken<? super T> getSupertype(Class<? super T> paramClass) {
    Preconditions.checkArgument(someRawTypeIsSubclassOf(paramClass), "%s is not a super class of %s", paramClass, this);
    Type type = this.runtimeType;
    return (TypeToken)((type instanceof TypeVariable) ? getSupertypeFromUpperBounds(paramClass, ((TypeVariable)type).getBounds()) : ((type instanceof WildcardType) ? getSupertypeFromUpperBounds(paramClass, ((WildcardType)type).getUpperBounds()) : (paramClass.isArray() ? getArraySupertype(paramClass) : resolveSupertype((toGenericType((Class)paramClass)).runtimeType))));
  }
  
  public final Type getType() {
    return this.runtimeType;
  }
  
  public final TypeSet getTypes() {
    return new TypeSet();
  }
  
  public int hashCode() {
    return this.runtimeType.hashCode();
  }
  
  public final boolean isArray() {
    boolean bool;
    if (getComponentType() != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isPrimitive() {
    boolean bool;
    Type type = this.runtimeType;
    if (type instanceof Class && ((Class)type).isPrimitive()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isSubtypeOf(TypeToken<?> paramTypeToken) {
    return isSubtypeOf(paramTypeToken.getType());
  }
  
  public final boolean isSubtypeOf(Type paramType) {
    Preconditions.checkNotNull(paramType);
    if (paramType instanceof WildcardType)
      return any(((WildcardType)paramType).getLowerBounds()).isSupertypeOf(this.runtimeType); 
    Type type = this.runtimeType;
    if (type instanceof WildcardType)
      return any(((WildcardType)type).getUpperBounds()).isSubtypeOf(paramType); 
    boolean bool = type instanceof TypeVariable;
    boolean bool1 = false;
    if (bool) {
      if (type.equals(paramType) || any(((TypeVariable)this.runtimeType).getBounds()).isSubtypeOf(paramType))
        bool1 = true; 
      return bool1;
    } 
    return (type instanceof GenericArrayType) ? of(paramType).isSupertypeOfArray((GenericArrayType)this.runtimeType) : ((paramType instanceof Class) ? someRawTypeIsSubclassOf((Class)paramType) : ((paramType instanceof ParameterizedType) ? isSubtypeOfParameterizedType((ParameterizedType)paramType) : ((paramType instanceof GenericArrayType) ? isSubtypeOfArrayType((GenericArrayType)paramType) : false)));
  }
  
  public final boolean isSupertypeOf(TypeToken<?> paramTypeToken) {
    return paramTypeToken.isSubtypeOf(getType());
  }
  
  public final boolean isSupertypeOf(Type paramType) {
    return of(paramType).isSubtypeOf(getType());
  }
  
  public final Invokable<T, Object> method(Method paramMethod) {
    Preconditions.checkArgument(someRawTypeIsSubclassOf(paramMethod.getDeclaringClass()), "%s not declared by %s", paramMethod, this);
    return new Invokable.MethodInvokable<T>(paramMethod) {
        Type[] getGenericExceptionTypes() {
          return TypeToken.this.resolveInPlace(super.getGenericExceptionTypes());
        }
        
        Type[] getGenericParameterTypes() {
          return TypeToken.this.resolveInPlace(super.getGenericParameterTypes());
        }
        
        Type getGenericReturnType() {
          return TypeToken.this.resolveType(super.getGenericReturnType()).getType();
        }
        
        public TypeToken<T> getOwnerType() {
          return TypeToken.this;
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(getOwnerType());
          stringBuilder.append(".");
          stringBuilder.append(super.toString());
          return stringBuilder.toString();
        }
      };
  }
  
  @CanIgnoreReturnValue
  final TypeToken<T> rejectTypeVariables() {
    (new TypeVisitor() {
        void visitGenericArrayType(GenericArrayType param1GenericArrayType) {
          visit(new Type[] { param1GenericArrayType.getGenericComponentType() });
        }
        
        void visitParameterizedType(ParameterizedType param1ParameterizedType) {
          visit(param1ParameterizedType.getActualTypeArguments());
          visit(new Type[] { param1ParameterizedType.getOwnerType() });
        }
        
        void visitTypeVariable(TypeVariable<?> param1TypeVariable) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(TypeToken.this.runtimeType);
          stringBuilder.append("contains a type variable and is not safe for the operation");
          throw new IllegalArgumentException(stringBuilder.toString());
        }
        
        void visitWildcardType(WildcardType param1WildcardType) {
          visit(param1WildcardType.getLowerBounds());
          visit(param1WildcardType.getUpperBounds());
        }
      }).visit(new Type[] { this.runtimeType });
    return this;
  }
  
  public final TypeToken<?> resolveType(Type paramType) {
    Preconditions.checkNotNull(paramType);
    TypeResolver typeResolver1 = this.typeResolver;
    TypeResolver typeResolver2 = typeResolver1;
    if (typeResolver1 == null) {
      typeResolver2 = TypeResolver.accordingTo(this.runtimeType);
      this.typeResolver = typeResolver2;
    } 
    return of(typeResolver2.resolveType(paramType));
  }
  
  public String toString() {
    return Types.toString(this.runtimeType);
  }
  
  public final TypeToken<T> unwrap() {
    return isWrapper() ? of(Primitives.unwrap((Class)this.runtimeType)) : this;
  }
  
  public final <X> TypeToken<T> where(TypeParameter<X> paramTypeParameter, TypeToken<X> paramTypeToken) {
    return new SimpleTypeToken<T>((new TypeResolver()).where((Map<TypeResolver.TypeVariableKey, ? extends Type>)ImmutableMap.of(new TypeResolver.TypeVariableKey(paramTypeParameter.typeVariable), paramTypeToken.runtimeType)).resolveType(this.runtimeType));
  }
  
  public final <X> TypeToken<T> where(TypeParameter<X> paramTypeParameter, Class<X> paramClass) {
    return where(paramTypeParameter, of(paramClass));
  }
  
  public final TypeToken<T> wrap() {
    return isPrimitive() ? of(Primitives.wrap((Class)this.runtimeType)) : this;
  }
  
  protected Object writeReplace() {
    return of((new TypeResolver()).resolveType(this.runtimeType));
  }
  
  private static class Bounds {
    private final Type[] bounds;
    
    private final boolean target;
    
    Bounds(Type[] param1ArrayOfType, boolean param1Boolean) {
      this.bounds = param1ArrayOfType;
      this.target = param1Boolean;
    }
    
    boolean isSubtypeOf(Type param1Type) {
      Type[] arrayOfType = this.bounds;
      int i = arrayOfType.length;
      for (byte b = 0; b < i; b++) {
        boolean bool1 = TypeToken.of(arrayOfType[b]).isSubtypeOf(param1Type);
        boolean bool2 = this.target;
        if (bool1 == bool2)
          return bool2; 
      } 
      return this.target ^ true;
    }
    
    boolean isSupertypeOf(Type param1Type) {
      TypeToken<?> typeToken = TypeToken.of(param1Type);
      Type[] arrayOfType = this.bounds;
      int i = arrayOfType.length;
      for (byte b = 0; b < i; b++) {
        boolean bool1 = typeToken.isSubtypeOf(arrayOfType[b]);
        boolean bool2 = this.target;
        if (bool1 == bool2)
          return bool2; 
      } 
      return this.target ^ true;
    }
  }
  
  private final class ClassSet extends TypeSet {
    private static final long serialVersionUID = 0L;
    
    private transient ImmutableSet<TypeToken<? super T>> classes;
    
    private ClassSet() {}
    
    private Object readResolve() {
      return TypeToken.this.getTypes().classes();
    }
    
    public TypeToken<T>.TypeSet classes() {
      return this;
    }
    
    protected Set<TypeToken<? super T>> delegate() {
      ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
      if (immutableSet == null) {
        immutableSet = FluentIterable.from((Iterable)TypeToken.TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes(TypeToken.this)).filter(TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
        this.classes = immutableSet;
        return (Set<TypeToken<? super T>>)immutableSet;
      } 
      return (Set<TypeToken<? super T>>)immutableSet;
    }
    
    public TypeToken<T>.TypeSet interfaces() {
      throw new UnsupportedOperationException("classes().interfaces() not supported.");
    }
    
    public Set<Class<? super T>> rawTypes() {
      return (Set<Class<? super T>>)ImmutableSet.copyOf((Collection)TypeToken.TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes((Iterable)TypeToken.this.getRawTypes()));
    }
  }
  
  private final class InterfaceSet extends TypeSet {
    private static final long serialVersionUID = 0L;
    
    private final transient TypeToken<T>.TypeSet allTypes;
    
    private transient ImmutableSet<TypeToken<? super T>> interfaces;
    
    InterfaceSet(TypeToken<T>.TypeSet param1TypeSet) {
      this.allTypes = param1TypeSet;
    }
    
    private Object readResolve() {
      return TypeToken.this.getTypes().interfaces();
    }
    
    public TypeToken<T>.TypeSet classes() {
      throw new UnsupportedOperationException("interfaces().classes() not supported.");
    }
    
    protected Set<TypeToken<? super T>> delegate() {
      ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
      if (immutableSet == null) {
        immutableSet = FluentIterable.from((Iterable)this.allTypes).filter(TypeToken.TypeFilter.INTERFACE_ONLY).toSet();
        this.interfaces = immutableSet;
        return (Set<TypeToken<? super T>>)immutableSet;
      } 
      return (Set<TypeToken<? super T>>)immutableSet;
    }
    
    public TypeToken<T>.TypeSet interfaces() {
      return this;
    }
    
    public Set<Class<? super T>> rawTypes() {
      return (Set<Class<? super T>>)FluentIterable.from((Iterable)TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes((Iterable<? extends Class<?>>)TypeToken.this.getRawTypes())).filter(new Predicate<Class<?>>() {
            public boolean apply(Class<?> param2Class) {
              return param2Class.isInterface();
            }
          }).toSet();
    }
  }
  
  class null implements Predicate<Class<?>> {
    public boolean apply(Class<?> param1Class) {
      return param1Class.isInterface();
    }
  }
  
  private static final class SimpleTypeToken<T> extends TypeToken<T> {
    private static final long serialVersionUID = 0L;
    
    SimpleTypeToken(Type param1Type) {
      super(param1Type);
    }
  }
  
  private static abstract class TypeCollector<K> {
    static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeCollector<TypeToken<?>>() {
        Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> param2TypeToken) {
          return (Iterable<? extends TypeToken<?>>)param2TypeToken.getGenericInterfaces();
        }
        
        Class<?> getRawType(TypeToken<?> param2TypeToken) {
          return param2TypeToken.getRawType();
        }
        
        @Nullable
        TypeToken<?> getSuperclass(TypeToken<?> param2TypeToken) {
          return param2TypeToken.getGenericSuperclass();
        }
      };
    
    static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeCollector<Class<?>>() {
        Iterable<? extends Class<?>> getInterfaces(Class<?> param2Class) {
          return Arrays.asList(param2Class.getInterfaces());
        }
        
        Class<?> getRawType(Class<?> param2Class) {
          return param2Class;
        }
        
        @Nullable
        Class<?> getSuperclass(Class<?> param2Class) {
          return param2Class.getSuperclass();
        }
      };
    
    private TypeCollector() {}
    
    @CanIgnoreReturnValue
    private int collectTypes(K param1K, Map<? super K, Integer> param1Map) {
      Integer integer = param1Map.get(param1K);
      if (integer != null)
        return integer.intValue(); 
      boolean bool = getRawType(param1K).isInterface();
      Iterator<? extends K> iterator = getInterfaces(param1K).iterator();
      while (iterator.hasNext())
        i = Math.max(bool, collectTypes(iterator.next(), param1Map)); 
      iterator = (Iterator<? extends K>)getSuperclass(param1K);
      int j = i;
      if (iterator != null)
        j = Math.max(i, collectTypes((K)iterator, param1Map)); 
      int i = j + 1;
      param1Map.put(param1K, Integer.valueOf(i));
      return i;
    }
    
    private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> map, final Comparator<? super V> valueComparator) {
      return (new Ordering<K>() {
          public int compare(K param2K1, K param2K2) {
            return valueComparator.compare(map.get(param2K1), map.get(param2K2));
          }
        }).immutableSortedCopy(map.keySet());
    }
    
    final TypeCollector<K> classesOnly() {
      return new ForwardingTypeCollector<K>(this) {
          ImmutableList<K> collectTypes(Iterable<? extends K> param2Iterable) {
            // Byte code:
            //   0: invokestatic builder : ()Lcom/google/common/collect/ImmutableList$Builder;
            //   3: astore_2
            //   4: aload_1
            //   5: invokeinterface iterator : ()Ljava/util/Iterator;
            //   10: astore_1
            //   11: aload_1
            //   12: invokeinterface hasNext : ()Z
            //   17: ifeq -> 47
            //   20: aload_1
            //   21: invokeinterface next : ()Ljava/lang/Object;
            //   26: astore_3
            //   27: aload_0
            //   28: aload_3
            //   29: invokevirtual getRawType : (Ljava/lang/Object;)Ljava/lang/Class;
            //   32: invokevirtual isInterface : ()Z
            //   35: ifne -> 11
            //   38: aload_2
            //   39: aload_3
            //   40: invokevirtual add : (Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
            //   43: pop
            //   44: goto -> 11
            //   47: aload_0
            //   48: aload_2
            //   49: invokevirtual build : ()Lcom/google/common/collect/ImmutableList;
            //   52: invokespecial collectTypes : (Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList;
            //   55: areturn
          }
          
          Iterable<? extends K> getInterfaces(K param2K) {
            return (Iterable<? extends K>)ImmutableSet.of();
          }
        };
    }
    
    ImmutableList<K> collectTypes(Iterable<? extends K> param1Iterable) {
      HashMap<? super K, Integer> hashMap = Maps.newHashMap();
      Iterator<? extends K> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        collectTypes(iterator.next(), hashMap); 
      return sortKeysByValue((Map)hashMap, (Comparator<? super Integer>)Ordering.natural().reverse());
    }
    
    final ImmutableList<K> collectTypes(K param1K) {
      return collectTypes((Iterable<? extends K>)ImmutableList.of(param1K));
    }
    
    abstract Iterable<? extends K> getInterfaces(K param1K);
    
    abstract Class<?> getRawType(K param1K);
    
    @Nullable
    abstract K getSuperclass(K param1K);
    
    private static class ForwardingTypeCollector<K> extends TypeCollector<K> {
      private final TypeToken.TypeCollector<K> delegate;
      
      ForwardingTypeCollector(TypeToken.TypeCollector<K> param2TypeCollector) {
        this.delegate = param2TypeCollector;
      }
      
      Iterable<? extends K> getInterfaces(K param2K) {
        return this.delegate.getInterfaces(param2K);
      }
      
      Class<?> getRawType(K param2K) {
        return this.delegate.getRawType(param2K);
      }
      
      K getSuperclass(K param2K) {
        return this.delegate.getSuperclass(param2K);
      }
    }
  }
  
  static final class null extends TypeCollector<TypeToken<?>> {
    Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> param1TypeToken) {
      return (Iterable<? extends TypeToken<?>>)param1TypeToken.getGenericInterfaces();
    }
    
    Class<?> getRawType(TypeToken<?> param1TypeToken) {
      return param1TypeToken.getRawType();
    }
    
    @Nullable
    TypeToken<?> getSuperclass(TypeToken<?> param1TypeToken) {
      return param1TypeToken.getGenericSuperclass();
    }
  }
  
  static final class null extends TypeCollector<Class<?>> {
    Iterable<? extends Class<?>> getInterfaces(Class<?> param1Class) {
      return Arrays.asList(param1Class.getInterfaces());
    }
    
    Class<?> getRawType(Class<?> param1Class) {
      return param1Class;
    }
    
    @Nullable
    Class<?> getSuperclass(Class<?> param1Class) {
      return param1Class.getSuperclass();
    }
  }
  
  class null extends TypeCollector.ForwardingTypeCollector<K> {
    null(TypeToken.TypeCollector<K> param1TypeCollector1) {}
    
    ImmutableList<K> collectTypes(Iterable<? extends K> param1Iterable) {
      // Byte code:
      //   0: invokestatic builder : ()Lcom/google/common/collect/ImmutableList$Builder;
      //   3: astore_2
      //   4: aload_1
      //   5: invokeinterface iterator : ()Ljava/util/Iterator;
      //   10: astore_1
      //   11: aload_1
      //   12: invokeinterface hasNext : ()Z
      //   17: ifeq -> 47
      //   20: aload_1
      //   21: invokeinterface next : ()Ljava/lang/Object;
      //   26: astore_3
      //   27: aload_0
      //   28: aload_3
      //   29: invokevirtual getRawType : (Ljava/lang/Object;)Ljava/lang/Class;
      //   32: invokevirtual isInterface : ()Z
      //   35: ifne -> 11
      //   38: aload_2
      //   39: aload_3
      //   40: invokevirtual add : (Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList$Builder;
      //   43: pop
      //   44: goto -> 11
      //   47: aload_0
      //   48: aload_2
      //   49: invokevirtual build : ()Lcom/google/common/collect/ImmutableList;
      //   52: invokespecial collectTypes : (Ljava/lang/Iterable;)Lcom/google/common/collect/ImmutableList;
      //   55: areturn
    }
    
    Iterable<? extends K> getInterfaces(K param1K) {
      return (Iterable<? extends K>)ImmutableSet.of();
    }
  }
  
  static final class null extends Ordering<K> {
    public int compare(K param1K1, K param1K2) {
      return valueComparator.compare(map.get(param1K1), map.get(param1K2));
    }
  }
  
  private static class ForwardingTypeCollector<K> extends TypeCollector<K> {
    private final TypeToken.TypeCollector<K> delegate;
    
    ForwardingTypeCollector(TypeToken.TypeCollector<K> param1TypeCollector) {
      this.delegate = param1TypeCollector;
    }
    
    Iterable<? extends K> getInterfaces(K param1K) {
      return this.delegate.getInterfaces(param1K);
    }
    
    Class<?> getRawType(K param1K) {
      return this.delegate.getRawType(param1K);
    }
    
    K getSuperclass(K param1K) {
      return this.delegate.getSuperclass(param1K);
    }
  }
  
  private enum TypeFilter implements Predicate<TypeToken<?>> {
    IGNORE_TYPE_VARIABLE_OR_WILDCARD {
      public boolean apply(TypeToken<?> param2TypeToken) {
        boolean bool;
        if (!(param2TypeToken.runtimeType instanceof TypeVariable) && !(param2TypeToken.runtimeType instanceof WildcardType)) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
    },
    INTERFACE_ONLY {
      public boolean apply(TypeToken<?> param2TypeToken) {
        return param2TypeToken.getRawType().isInterface();
      }
    };
    
    static {
    
    }
  }
  
  enum null {
    public boolean apply(TypeToken<?> param1TypeToken) {
      boolean bool;
      if (!(param1TypeToken.runtimeType instanceof TypeVariable) && !(param1TypeToken.runtimeType instanceof WildcardType)) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
  
  enum null {
    public boolean apply(TypeToken<?> param1TypeToken) {
      return param1TypeToken.getRawType().isInterface();
    }
  }
  
  public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    private transient ImmutableSet<TypeToken<? super T>> types;
    
    public TypeSet classes() {
      return new TypeToken.ClassSet();
    }
    
    protected Set<TypeToken<? super T>> delegate() {
      ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
      if (immutableSet == null) {
        immutableSet = FluentIterable.from((Iterable)TypeToken.TypeCollector.FOR_GENERIC_TYPE.collectTypes(TypeToken.this)).filter(TypeToken.TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
        this.types = immutableSet;
        return (Set<TypeToken<? super T>>)immutableSet;
      } 
      return (Set<TypeToken<? super T>>)immutableSet;
    }
    
    public TypeSet interfaces() {
      return new TypeToken.InterfaceSet(this);
    }
    
    public Set<Class<? super T>> rawTypes() {
      return (Set<Class<? super T>>)ImmutableSet.copyOf((Collection)TypeToken.TypeCollector.FOR_RAW_TYPE.collectTypes((Iterable<? extends Class<?>>)TypeToken.this.getRawTypes()));
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\TypeToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */