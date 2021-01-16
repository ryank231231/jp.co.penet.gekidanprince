package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import javax.annotation.Nullable;

@Beta
public abstract class TypeParameter<T> extends TypeCapture<T> {
  final TypeVariable<?> typeVariable;
  
  protected TypeParameter() {
    Type type = capture();
    Preconditions.checkArgument(type instanceof TypeVariable, "%s should be a type variable.", type);
    this.typeVariable = (TypeVariable)type;
  }
  
  public final boolean equals(@Nullable Object paramObject) {
    if (paramObject instanceof TypeParameter) {
      paramObject = paramObject;
      return this.typeVariable.equals(((TypeParameter)paramObject).typeVariable);
    } 
    return false;
  }
  
  public final int hashCode() {
    return this.typeVariable.hashCode();
  }
  
  public String toString() {
    return this.typeVariable.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\TypeParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */