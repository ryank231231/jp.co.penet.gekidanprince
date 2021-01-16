package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Predicates {
  private static final Joiner COMMA_JOINER = Joiner.on(',');
  
  @GwtCompatible(serializable = true)
  public static <T> Predicate<T> alwaysFalse() {
    return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Predicate<T> alwaysTrue() {
    return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
  }
  
  public static <T> Predicate<T> and(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
    return new AndPredicate<T>(asList(Preconditions.<Predicate>checkNotNull(paramPredicate1), Preconditions.<Predicate>checkNotNull(paramPredicate2)));
  }
  
  public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> paramIterable) {
    return new AndPredicate<T>(defensiveCopy(paramIterable));
  }
  
  public static <T> Predicate<T> and(Predicate<? super T>... paramVarArgs) {
    return new AndPredicate<T>(defensiveCopy(paramVarArgs));
  }
  
  private static <T> List<Predicate<? super T>> asList(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
    return Arrays.asList((Predicate<? super T>[])new Predicate[] { paramPredicate1, paramPredicate2 });
  }
  
  @Deprecated
  @Beta
  @GwtIncompatible
  public static Predicate<Class<?>> assignableFrom(Class<?> paramClass) {
    return subtypeOf(paramClass);
  }
  
  public static <A, B> Predicate<A> compose(Predicate<B> paramPredicate, Function<A, ? extends B> paramFunction) {
    return new CompositionPredicate<A, Object>(paramPredicate, paramFunction);
  }
  
  @GwtIncompatible("java.util.regex.Pattern")
  public static Predicate<CharSequence> contains(Pattern paramPattern) {
    return new ContainsPatternPredicate(new JdkPattern(paramPattern));
  }
  
  @GwtIncompatible
  public static Predicate<CharSequence> containsPattern(String paramString) {
    return new ContainsPatternFromStringPredicate(paramString);
  }
  
  static <T> List<T> defensiveCopy(Iterable<T> paramIterable) {
    ArrayList<T> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(Preconditions.checkNotNull(iterator.next())); 
    return arrayList;
  }
  
  private static <T> List<T> defensiveCopy(T... paramVarArgs) {
    return defensiveCopy(Arrays.asList(paramVarArgs));
  }
  
  public static <T> Predicate<T> equalTo(@Nullable T paramT) {
    Predicate<?> predicate;
    if (paramT == null) {
      predicate = isNull();
    } else {
      predicate = new IsEqualToPredicate(predicate);
    } 
    return (Predicate)predicate;
  }
  
  public static <T> Predicate<T> in(Collection<? extends T> paramCollection) {
    return new InPredicate<T>(paramCollection);
  }
  
  @GwtIncompatible
  public static Predicate<Object> instanceOf(Class<?> paramClass) {
    return new InstanceOfPredicate(paramClass);
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Predicate<T> isNull() {
    return ObjectPredicate.IS_NULL.withNarrowedType();
  }
  
  public static <T> Predicate<T> not(Predicate<T> paramPredicate) {
    return new NotPredicate<T>(paramPredicate);
  }
  
  @GwtCompatible(serializable = true)
  public static <T> Predicate<T> notNull() {
    return ObjectPredicate.NOT_NULL.withNarrowedType();
  }
  
  public static <T> Predicate<T> or(Predicate<? super T> paramPredicate1, Predicate<? super T> paramPredicate2) {
    return new OrPredicate<T>(asList(Preconditions.<Predicate>checkNotNull(paramPredicate1), Preconditions.<Predicate>checkNotNull(paramPredicate2)));
  }
  
  public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> paramIterable) {
    return new OrPredicate<T>(defensiveCopy(paramIterable));
  }
  
  public static <T> Predicate<T> or(Predicate<? super T>... paramVarArgs) {
    return new OrPredicate<T>(defensiveCopy(paramVarArgs));
  }
  
  @Beta
  @GwtIncompatible
  public static Predicate<Class<?>> subtypeOf(Class<?> paramClass) {
    return new SubtypeOfPredicate(paramClass);
  }
  
  private static class AndPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final List<? extends Predicate<? super T>> components;
    
    private AndPredicate(List<? extends Predicate<? super T>> param1List) {
      this.components = param1List;
    }
    
    public boolean apply(@Nullable T param1T) {
      for (byte b = 0; b < this.components.size(); b++) {
        if (!((Predicate<T>)this.components.get(b)).apply(param1T))
          return false; 
      } 
      return true;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof AndPredicate) {
        param1Object = param1Object;
        return this.components.equals(((AndPredicate)param1Object).components);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.components.hashCode() + 306654252;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.and(");
      stringBuilder.append(Predicates.COMMA_JOINER.join(this.components));
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Function<A, ? extends B> f;
    
    final Predicate<B> p;
    
    private CompositionPredicate(Predicate<B> param1Predicate, Function<A, ? extends B> param1Function) {
      this.p = Preconditions.<Predicate<B>>checkNotNull(param1Predicate);
      this.f = Preconditions.<Function<A, ? extends B>>checkNotNull(param1Function);
    }
    
    public boolean apply(@Nullable A param1A) {
      return this.p.apply(this.f.apply(param1A));
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof CompositionPredicate;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.f.equals(((CompositionPredicate)param1Object).f)) {
          bool = bool1;
          if (this.p.equals(((CompositionPredicate)param1Object).p))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.f.hashCode() ^ this.p.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.p);
      stringBuilder.append("(");
      stringBuilder.append(this.f);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  @GwtIncompatible
  private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
    private static final long serialVersionUID = 0L;
    
    ContainsPatternFromStringPredicate(String param1String) {
      super(Platform.compilePattern(param1String));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.containsPattern(");
      stringBuilder.append(this.pattern.pattern());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  @GwtIncompatible
  private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final CommonPattern pattern;
    
    ContainsPatternPredicate(CommonPattern param1CommonPattern) {
      this.pattern = Preconditions.<CommonPattern>checkNotNull(param1CommonPattern);
    }
    
    public boolean apply(CharSequence param1CharSequence) {
      return this.pattern.matcher(param1CharSequence).find();
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof ContainsPatternPredicate;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (Objects.equal(this.pattern.pattern(), ((ContainsPatternPredicate)param1Object).pattern.pattern())) {
          bool = bool1;
          if (this.pattern.flags() == ((ContainsPatternPredicate)param1Object).pattern.flags())
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.pattern.pattern(), Integer.valueOf(this.pattern.flags()) });
    }
    
    public String toString() {
      String str = MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.contains(");
      stringBuilder.append(str);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class InPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Collection<?> target;
    
    private InPredicate(Collection<?> param1Collection) {
      this.target = Preconditions.<Collection>checkNotNull(param1Collection);
    }
    
    public boolean apply(@Nullable T param1T) {
      try {
        return this.target.contains(param1T);
      } catch (NullPointerException nullPointerException) {
        return false;
      } catch (ClassCastException classCastException) {
        return false;
      } 
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof InPredicate) {
        param1Object = param1Object;
        return this.target.equals(((InPredicate)param1Object).target);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.target.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.in(");
      stringBuilder.append(this.target);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  @GwtIncompatible
  private static class InstanceOfPredicate implements Predicate<Object>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Class<?> clazz;
    
    private InstanceOfPredicate(Class<?> param1Class) {
      this.clazz = Preconditions.<Class<?>>checkNotNull(param1Class);
    }
    
    public boolean apply(@Nullable Object param1Object) {
      return this.clazz.isInstance(param1Object);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof InstanceOfPredicate;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        if (this.clazz == ((InstanceOfPredicate)param1Object).clazz)
          bool1 = true; 
        return bool1;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.clazz.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.instanceOf(");
      stringBuilder.append(this.clazz.getName());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final T target;
    
    private IsEqualToPredicate(T param1T) {
      this.target = param1T;
    }
    
    public boolean apply(T param1T) {
      return this.target.equals(param1T);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof IsEqualToPredicate) {
        param1Object = param1Object;
        return this.target.equals(((IsEqualToPredicate)param1Object).target);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.target.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.equalTo(");
      stringBuilder.append(this.target);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static class NotPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    final Predicate<T> predicate;
    
    NotPredicate(Predicate<T> param1Predicate) {
      this.predicate = Preconditions.<Predicate<T>>checkNotNull(param1Predicate);
    }
    
    public boolean apply(@Nullable T param1T) {
      return this.predicate.apply(param1T) ^ true;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof NotPredicate) {
        param1Object = param1Object;
        return this.predicate.equals(((NotPredicate)param1Object).predicate);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.predicate.hashCode() ^ 0xFFFFFFFF;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.not(");
      stringBuilder.append(this.predicate);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  enum ObjectPredicate implements Predicate<Object> {
    ALWAYS_FALSE,
    ALWAYS_TRUE {
      public boolean apply(@Nullable Object param2Object) {
        return true;
      }
      
      public String toString() {
        return "Predicates.alwaysTrue()";
      }
    },
    IS_NULL,
    NOT_NULL;
    
    static {
      $VALUES = new ObjectPredicate[] { ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL };
    }
    
    <T> Predicate<T> withNarrowedType() {
      return this;
    }
  }
  
  enum null {
    public boolean apply(@Nullable Object param1Object) {
      return true;
    }
    
    public String toString() {
      return "Predicates.alwaysTrue()";
    }
  }
  
  enum null {
    public boolean apply(@Nullable Object param1Object) {
      return false;
    }
    
    public String toString() {
      return "Predicates.alwaysFalse()";
    }
  }
  
  enum null {
    public boolean apply(@Nullable Object param1Object) {
      boolean bool;
      if (param1Object == null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public String toString() {
      return "Predicates.isNull()";
    }
  }
  
  enum null {
    public boolean apply(@Nullable Object param1Object) {
      boolean bool;
      if (param1Object != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public String toString() {
      return "Predicates.notNull()";
    }
  }
  
  private static class OrPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final List<? extends Predicate<? super T>> components;
    
    private OrPredicate(List<? extends Predicate<? super T>> param1List) {
      this.components = param1List;
    }
    
    public boolean apply(@Nullable T param1T) {
      for (byte b = 0; b < this.components.size(); b++) {
        if (((Predicate<T>)this.components.get(b)).apply(param1T))
          return true; 
      } 
      return false;
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof OrPredicate) {
        param1Object = param1Object;
        return this.components.equals(((OrPredicate)param1Object).components);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.components.hashCode() + 87855567;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.or(");
      stringBuilder.append(Predicates.COMMA_JOINER.join(this.components));
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  @GwtIncompatible
  private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
    private static final long serialVersionUID = 0L;
    
    private final Class<?> clazz;
    
    private SubtypeOfPredicate(Class<?> param1Class) {
      this.clazz = Preconditions.<Class<?>>checkNotNull(param1Class);
    }
    
    public boolean apply(Class<?> param1Class) {
      return this.clazz.isAssignableFrom(param1Class);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof SubtypeOfPredicate;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        if (this.clazz == ((SubtypeOfPredicate)param1Object).clazz)
          bool1 = true; 
        return bool1;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.clazz.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Predicates.subtypeOf(");
      stringBuilder.append(this.clazz.getName());
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Predicates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */