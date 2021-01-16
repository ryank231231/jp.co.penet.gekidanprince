package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class TypeVisitor {
  private final Set<Type> visited = Sets.newHashSet();
  
  public final void visit(Type... paramVarArgs) {
    int i = paramVarArgs.length;
    for (byte b = 0; b < i; b++) {
      Type type = paramVarArgs[b];
      if (type != null && this.visited.add(type))
        try {
        
        } finally {
          this.visited.remove(type);
        }  
    } 
  }
  
  void visitClass(Class<?> paramClass) {}
  
  void visitGenericArrayType(GenericArrayType paramGenericArrayType) {}
  
  void visitParameterizedType(ParameterizedType paramParameterizedType) {}
  
  void visitTypeVariable(TypeVariable<?> paramTypeVariable) {}
  
  void visitWildcardType(WildcardType paramWildcardType) {}
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\TypeVisitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */