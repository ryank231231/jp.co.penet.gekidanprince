package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.Nullable;

@Beta
public final class Parameter implements AnnotatedElement {
  private final ImmutableList<Annotation> annotations;
  
  private final Invokable<?, ?> declaration;
  
  private final int position;
  
  private final TypeToken<?> type;
  
  Parameter(Invokable<?, ?> paramInvokable, int paramInt, TypeToken<?> paramTypeToken, Annotation[] paramArrayOfAnnotation) {
    this.declaration = paramInvokable;
    this.position = paramInt;
    this.type = paramTypeToken;
    this.annotations = ImmutableList.copyOf((Object[])paramArrayOfAnnotation);
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Parameter;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.position == ((Parameter)paramObject).position) {
        bool = bool1;
        if (this.declaration.equals(((Parameter)paramObject).declaration))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  @Nullable
  public <A extends Annotation> A getAnnotation(Class<A> paramClass) {
    Preconditions.checkNotNull(paramClass);
    for (Annotation annotation : this.annotations) {
      if (paramClass.isInstance(annotation))
        return paramClass.cast(annotation); 
    } 
    return null;
  }
  
  public Annotation[] getAnnotations() {
    return getDeclaredAnnotations();
  }
  
  public <A extends Annotation> A[] getAnnotationsByType(Class<A> paramClass) {
    return getDeclaredAnnotationsByType(paramClass);
  }
  
  @Nullable
  public <A extends Annotation> A getDeclaredAnnotation(Class<A> paramClass) {
    Preconditions.checkNotNull(paramClass);
    return (A)FluentIterable.from((Iterable)this.annotations).filter(paramClass).first().orNull();
  }
  
  public Annotation[] getDeclaredAnnotations() {
    ImmutableList<Annotation> immutableList = this.annotations;
    return (Annotation[])immutableList.toArray((Object[])new Annotation[immutableList.size()]);
  }
  
  public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> paramClass) {
    return (A[])FluentIterable.from((Iterable)this.annotations).filter(paramClass).toArray(paramClass);
  }
  
  public Invokable<?, ?> getDeclaringInvokable() {
    return this.declaration;
  }
  
  public TypeToken<?> getType() {
    return this.type;
  }
  
  public int hashCode() {
    return this.position;
  }
  
  public boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
    boolean bool;
    if (getAnnotation(paramClass) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.type);
    stringBuilder.append(" arg");
    stringBuilder.append(this.position);
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\Parameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */