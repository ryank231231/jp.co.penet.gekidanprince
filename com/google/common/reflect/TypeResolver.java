package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@Beta
public final class TypeResolver {
  private final TypeTable typeTable = new TypeTable();
  
  public TypeResolver() {}
  
  private TypeResolver(TypeTable paramTypeTable) {}
  
  static TypeResolver accordingTo(Type paramType) {
    return (new TypeResolver()).where((Map<TypeVariableKey, ? extends Type>)TypeMappingIntrospector.getTypeMappings(paramType));
  }
  
  private static <T> T expectArgument(Class<T> paramClass, Object paramObject) {
    try {
      return paramClass.cast(paramObject);
    } catch (ClassCastException classCastException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramObject);
      stringBuilder.append(" is not a ");
      stringBuilder.append(paramClass.getSimpleName());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  private static void populateTypeMappings(final Map<TypeVariableKey, Type> mappings, Type paramType1, final Type to) {
    if (paramType1.equals(to))
      return; 
    (new TypeVisitor() {
        void visitClass(Class<?> param1Class) {
          if (to instanceof WildcardType)
            return; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("No type mapping from ");
          stringBuilder.append(param1Class);
          stringBuilder.append(" to ");
          stringBuilder.append(to);
          throw new IllegalArgumentException(stringBuilder.toString());
        }
        
        void visitGenericArrayType(GenericArrayType param1GenericArrayType) {
          boolean bool;
          Type type = to;
          if (type instanceof WildcardType)
            return; 
          type = Types.getComponentType(type);
          if (type != null) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.checkArgument(bool, "%s is not an array type.", to);
          TypeResolver.populateTypeMappings(mappings, param1GenericArrayType.getGenericComponentType(), type);
        }
        
        void visitParameterizedType(ParameterizedType param1ParameterizedType) {
          boolean bool;
          Type type = to;
          if (type instanceof WildcardType)
            return; 
          ParameterizedType parameterizedType = (ParameterizedType)TypeResolver.expectArgument((Class)ParameterizedType.class, type);
          if (param1ParameterizedType.getOwnerType() != null && parameterizedType.getOwnerType() != null)
            TypeResolver.populateTypeMappings(mappings, param1ParameterizedType.getOwnerType(), parameterizedType.getOwnerType()); 
          Preconditions.checkArgument(param1ParameterizedType.getRawType().equals(parameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", param1ParameterizedType, to);
          Type[] arrayOfType1 = param1ParameterizedType.getActualTypeArguments();
          Type[] arrayOfType2 = parameterizedType.getActualTypeArguments();
          int i = arrayOfType1.length;
          int j = arrayOfType2.length;
          byte b = 0;
          if (i == j) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.checkArgument(bool, "%s not compatible with %s", param1ParameterizedType, parameterizedType);
          while (b < arrayOfType1.length) {
            TypeResolver.populateTypeMappings(mappings, arrayOfType1[b], arrayOfType2[b]);
            b++;
          } 
        }
        
        void visitTypeVariable(TypeVariable<?> param1TypeVariable) {
          mappings.put(new TypeResolver.TypeVariableKey(param1TypeVariable), to);
        }
        
        void visitWildcardType(WildcardType param1WildcardType) {
          boolean bool2;
          Type type = to;
          if (!(type instanceof WildcardType))
            return; 
          WildcardType wildcardType = (WildcardType)type;
          Type[] arrayOfType3 = param1WildcardType.getUpperBounds();
          Type[] arrayOfType1 = wildcardType.getUpperBounds();
          Type[] arrayOfType4 = param1WildcardType.getLowerBounds();
          Type[] arrayOfType2 = wildcardType.getLowerBounds();
          int i = arrayOfType3.length;
          int j = arrayOfType1.length;
          boolean bool1 = false;
          if (i == j && arrayOfType4.length == arrayOfType2.length) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          Preconditions.checkArgument(bool2, "Incompatible type: %s vs. %s", param1WildcardType, to);
          i = 0;
          while (true) {
            j = bool1;
            if (i < arrayOfType3.length) {
              TypeResolver.populateTypeMappings(mappings, arrayOfType3[i], arrayOfType1[i]);
              i++;
              continue;
            } 
            break;
          } 
          while (j < arrayOfType4.length) {
            TypeResolver.populateTypeMappings(mappings, arrayOfType4[j], arrayOfType2[j]);
            j++;
          } 
        }
      }).visit(new Type[] { paramType1 });
  }
  
  private Type resolveGenericArrayType(GenericArrayType paramGenericArrayType) {
    return Types.newArrayType(resolveType(paramGenericArrayType.getGenericComponentType()));
  }
  
  private ParameterizedType resolveParameterizedType(ParameterizedType paramParameterizedType) {
    Type type1 = paramParameterizedType.getOwnerType();
    if (type1 == null) {
      type1 = null;
    } else {
      type1 = resolveType(type1);
    } 
    Type type2 = resolveType(paramParameterizedType.getRawType());
    Type[] arrayOfType = resolveTypes(paramParameterizedType.getActualTypeArguments());
    return Types.newParameterizedTypeWithOwner(type1, (Class)type2, arrayOfType);
  }
  
  private Type[] resolveTypes(Type[] paramArrayOfType) {
    Type[] arrayOfType = new Type[paramArrayOfType.length];
    for (byte b = 0; b < paramArrayOfType.length; b++)
      arrayOfType[b] = resolveType(paramArrayOfType[b]); 
    return arrayOfType;
  }
  
  private WildcardType resolveWildcardType(WildcardType paramWildcardType) {
    Type[] arrayOfType2 = paramWildcardType.getLowerBounds();
    Type[] arrayOfType1 = paramWildcardType.getUpperBounds();
    return new Types.WildcardTypeImpl(resolveTypes(arrayOfType2), resolveTypes(arrayOfType1));
  }
  
  public Type resolveType(Type paramType) {
    Preconditions.checkNotNull(paramType);
    return (paramType instanceof TypeVariable) ? this.typeTable.resolve((TypeVariable)paramType) : ((paramType instanceof ParameterizedType) ? resolveParameterizedType((ParameterizedType)paramType) : ((paramType instanceof GenericArrayType) ? resolveGenericArrayType((GenericArrayType)paramType) : ((paramType instanceof WildcardType) ? resolveWildcardType((WildcardType)paramType) : paramType)));
  }
  
  public TypeResolver where(Type paramType1, Type paramType2) {
    HashMap<TypeVariableKey, Type> hashMap = Maps.newHashMap();
    populateTypeMappings(hashMap, (Type)Preconditions.checkNotNull(paramType1), (Type)Preconditions.checkNotNull(paramType2));
    return where(hashMap);
  }
  
  TypeResolver where(Map<TypeVariableKey, ? extends Type> paramMap) {
    return new TypeResolver(this.typeTable.where(paramMap));
  }
  
  private static final class TypeMappingIntrospector extends TypeVisitor {
    private static final TypeResolver.WildcardCapturer wildcardCapturer = new TypeResolver.WildcardCapturer();
    
    private final Map<TypeResolver.TypeVariableKey, Type> mappings = Maps.newHashMap();
    
    static ImmutableMap<TypeResolver.TypeVariableKey, Type> getTypeMappings(Type param1Type) {
      TypeMappingIntrospector typeMappingIntrospector = new TypeMappingIntrospector();
      typeMappingIntrospector.visit(new Type[] { wildcardCapturer.capture(param1Type) });
      return ImmutableMap.copyOf(typeMappingIntrospector.mappings);
    }
    
    private void map(TypeResolver.TypeVariableKey param1TypeVariableKey, Type param1Type) {
      if (this.mappings.containsKey(param1TypeVariableKey))
        return; 
      for (Type type = param1Type; type != null; type = this.mappings.get(TypeResolver.TypeVariableKey.forLookup(type))) {
        if (param1TypeVariableKey.equalsType(type)) {
          while (param1Type != null)
            param1Type = this.mappings.remove(TypeResolver.TypeVariableKey.forLookup(param1Type)); 
          return;
        } 
      } 
      this.mappings.put(param1TypeVariableKey, param1Type);
    }
    
    void visitClass(Class<?> param1Class) {
      visit(new Type[] { param1Class.getGenericSuperclass() });
      visit(param1Class.getGenericInterfaces());
    }
    
    void visitParameterizedType(ParameterizedType param1ParameterizedType) {
      boolean bool;
      Class clazz = (Class)param1ParameterizedType.getRawType();
      TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
      Type[] arrayOfType = param1ParameterizedType.getActualTypeArguments();
      if (arrayOfTypeVariable.length == arrayOfType.length) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      for (byte b = 0; b < arrayOfTypeVariable.length; b++)
        map(new TypeResolver.TypeVariableKey(arrayOfTypeVariable[b]), arrayOfType[b]); 
      visit(new Type[] { clazz });
      visit(new Type[] { param1ParameterizedType.getOwnerType() });
    }
    
    void visitTypeVariable(TypeVariable<?> param1TypeVariable) {
      visit(param1TypeVariable.getBounds());
    }
    
    void visitWildcardType(WildcardType param1WildcardType) {
      visit(param1WildcardType.getUpperBounds());
    }
  }
  
  private static class TypeTable {
    private final ImmutableMap<TypeResolver.TypeVariableKey, Type> map = ImmutableMap.of();
    
    TypeTable() {}
    
    private TypeTable(ImmutableMap<TypeResolver.TypeVariableKey, Type> param1ImmutableMap) {}
    
    final Type resolve(final TypeVariable<?> var) {
      return resolveInternal(var, new TypeTable() {
            public Type resolveInternal(TypeVariable<?> param2TypeVariable, TypeResolver.TypeTable param2TypeTable) {
              return param2TypeVariable.getGenericDeclaration().equals(var.getGenericDeclaration()) ? param2TypeVariable : unguarded.resolveInternal(param2TypeVariable, param2TypeTable);
            }
          });
    }
    
    Type resolveInternal(TypeVariable<?> param1TypeVariable, TypeTable param1TypeTable) {
      Type[] arrayOfType1;
      Type[] arrayOfType2;
      Type type = (Type)this.map.get(new TypeResolver.TypeVariableKey(param1TypeVariable));
      if (type == null) {
        arrayOfType2 = param1TypeVariable.getBounds();
        if (arrayOfType2.length == 0)
          return param1TypeVariable; 
        arrayOfType1 = (new TypeResolver(param1TypeTable)).resolveTypes(arrayOfType2);
        return (Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY && Arrays.equals((Object[])arrayOfType2, (Object[])arrayOfType1)) ? param1TypeVariable : Types.newArtificialTypeVariable((GenericDeclaration)param1TypeVariable.getGenericDeclaration(), param1TypeVariable.getName(), arrayOfType1);
      } 
      return (new TypeResolver((TypeTable)arrayOfType1)).resolveType((Type)arrayOfType2);
    }
    
    final TypeTable where(Map<TypeResolver.TypeVariableKey, ? extends Type> param1Map) {
      ImmutableMap.Builder builder = ImmutableMap.builder();
      builder.putAll((Map)this.map);
      for (Map.Entry<TypeResolver.TypeVariableKey, ? extends Type> entry : param1Map.entrySet()) {
        TypeResolver.TypeVariableKey typeVariableKey = (TypeResolver.TypeVariableKey)entry.getKey();
        Type type = (Type)entry.getValue();
        Preconditions.checkArgument(typeVariableKey.equalsType(type) ^ true, "Type variable %s bound to itself", typeVariableKey);
        builder.put(typeVariableKey, type);
      } 
      return new TypeTable(builder.build());
    }
  }
  
  class null extends TypeTable {
    public Type resolveInternal(TypeVariable<?> param1TypeVariable, TypeResolver.TypeTable param1TypeTable) {
      return param1TypeVariable.getGenericDeclaration().equals(var.getGenericDeclaration()) ? param1TypeVariable : unguarded.resolveInternal(param1TypeVariable, param1TypeTable);
    }
  }
  
  static final class TypeVariableKey {
    private final TypeVariable<?> var;
    
    TypeVariableKey(TypeVariable<?> param1TypeVariable) {
      this.var = (TypeVariable)Preconditions.checkNotNull(param1TypeVariable);
    }
    
    private boolean equalsTypeVariable(TypeVariable<?> param1TypeVariable) {
      boolean bool;
      if (this.var.getGenericDeclaration().equals(param1TypeVariable.getGenericDeclaration()) && this.var.getName().equals(param1TypeVariable.getName())) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    static TypeVariableKey forLookup(Type param1Type) {
      return (param1Type instanceof TypeVariable) ? new TypeVariableKey((TypeVariable)param1Type) : null;
    }
    
    public boolean equals(Object param1Object) {
      return (param1Object instanceof TypeVariableKey) ? equalsTypeVariable(((TypeVariableKey)param1Object).var) : false;
    }
    
    boolean equalsType(Type param1Type) {
      return (param1Type instanceof TypeVariable) ? equalsTypeVariable((TypeVariable)param1Type) : false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.var.getGenericDeclaration(), this.var.getName() });
    }
    
    public String toString() {
      return this.var.toString();
    }
  }
  
  private static final class WildcardCapturer {
    private final AtomicInteger id = new AtomicInteger();
    
    private WildcardCapturer() {}
    
    private Type[] capture(Type[] param1ArrayOfType) {
      Type[] arrayOfType = new Type[param1ArrayOfType.length];
      for (byte b = 0; b < param1ArrayOfType.length; b++)
        arrayOfType[b] = capture(param1ArrayOfType[b]); 
      return arrayOfType;
    }
    
    private Type captureNullable(@Nullable Type param1Type) {
      return (param1Type == null) ? null : capture(param1Type);
    }
    
    Type capture(Type param1Type) {
      Preconditions.checkNotNull(param1Type);
      if (param1Type instanceof Class)
        return param1Type; 
      if (param1Type instanceof TypeVariable)
        return param1Type; 
      if (param1Type instanceof GenericArrayType)
        return Types.newArrayType(capture(((GenericArrayType)param1Type).getGenericComponentType())); 
      if (param1Type instanceof ParameterizedType) {
        param1Type = param1Type;
        return Types.newParameterizedTypeWithOwner(captureNullable(param1Type.getOwnerType()), (Class)param1Type.getRawType(), capture(param1Type.getActualTypeArguments()));
      } 
      if (param1Type instanceof WildcardType) {
        StringBuilder stringBuilder;
        WildcardType wildcardType = (WildcardType)param1Type;
        if ((wildcardType.getLowerBounds()).length == 0) {
          Type[] arrayOfType = wildcardType.getUpperBounds();
          stringBuilder = new StringBuilder();
          stringBuilder.append("capture#");
          stringBuilder.append(this.id.incrementAndGet());
          stringBuilder.append("-of ? extends ");
          stringBuilder.append(Joiner.on('&').join((Object[])arrayOfType));
          return Types.newArtificialTypeVariable(WildcardCapturer.class, stringBuilder.toString(), wildcardType.getUpperBounds());
        } 
        return (Type)stringBuilder;
      } 
      throw new AssertionError("must have been one of the known types");
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\TypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */