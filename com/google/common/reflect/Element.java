package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import javax.annotation.Nullable;

class Element extends AccessibleObject implements Member {
  private final AccessibleObject accessibleObject;
  
  private final Member member;
  
  <M extends AccessibleObject & Member> Element(M paramM) {
    Preconditions.checkNotNull(paramM);
    this.accessibleObject = (AccessibleObject)paramM;
    this.member = (Member)paramM;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof Element;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (getOwnerType().equals(paramObject.getOwnerType())) {
        bool = bool1;
        if (this.member.equals(((Element)paramObject).member))
          bool = true; 
      } 
      return bool;
    } 
    return false;
  }
  
  public final <A extends Annotation> A getAnnotation(Class<A> paramClass) {
    return this.accessibleObject.getAnnotation(paramClass);
  }
  
  public final Annotation[] getAnnotations() {
    return this.accessibleObject.getAnnotations();
  }
  
  public final Annotation[] getDeclaredAnnotations() {
    return this.accessibleObject.getDeclaredAnnotations();
  }
  
  public Class<?> getDeclaringClass() {
    return this.member.getDeclaringClass();
  }
  
  public final int getModifiers() {
    return this.member.getModifiers();
  }
  
  public final String getName() {
    return this.member.getName();
  }
  
  public TypeToken<?> getOwnerType() {
    return TypeToken.of(getDeclaringClass());
  }
  
  public int hashCode() {
    return this.member.hashCode();
  }
  
  public final boolean isAbstract() {
    return Modifier.isAbstract(getModifiers());
  }
  
  public final boolean isAccessible() {
    return this.accessibleObject.isAccessible();
  }
  
  public final boolean isAnnotationPresent(Class<? extends Annotation> paramClass) {
    return this.accessibleObject.isAnnotationPresent(paramClass);
  }
  
  public final boolean isFinal() {
    return Modifier.isFinal(getModifiers());
  }
  
  public final boolean isNative() {
    return Modifier.isNative(getModifiers());
  }
  
  public final boolean isPackagePrivate() {
    boolean bool;
    if (!isPrivate() && !isPublic() && !isProtected()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isPrivate() {
    return Modifier.isPrivate(getModifiers());
  }
  
  public final boolean isProtected() {
    return Modifier.isProtected(getModifiers());
  }
  
  public final boolean isPublic() {
    return Modifier.isPublic(getModifiers());
  }
  
  public final boolean isStatic() {
    return Modifier.isStatic(getModifiers());
  }
  
  public final boolean isSynchronized() {
    return Modifier.isSynchronized(getModifiers());
  }
  
  public final boolean isSynthetic() {
    return this.member.isSynthetic();
  }
  
  final boolean isTransient() {
    return Modifier.isTransient(getModifiers());
  }
  
  final boolean isVolatile() {
    return Modifier.isVolatile(getModifiers());
  }
  
  public final void setAccessible(boolean paramBoolean) throws SecurityException {
    this.accessibleObject.setAccessible(paramBoolean);
  }
  
  public String toString() {
    return this.member.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\reflect\Element.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */