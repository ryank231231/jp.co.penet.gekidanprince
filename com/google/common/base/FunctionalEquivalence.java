package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  private final Function<F, ? extends T> function;
  
  private final Equivalence<T> resultEquivalence;
  
  FunctionalEquivalence(Function<F, ? extends T> paramFunction, Equivalence<T> paramEquivalence) {
    this.function = Preconditions.<Function<F, ? extends T>>checkNotNull(paramFunction);
    this.resultEquivalence = Preconditions.<Equivalence<T>>checkNotNull(paramEquivalence);
  }
  
  protected boolean doEquivalent(F paramF1, F paramF2) {
    return this.resultEquivalence.equivalent(this.function.apply(paramF1), this.function.apply(paramF2));
  }
  
  protected int doHash(F paramF) {
    return this.resultEquivalence.hash(this.function.apply(paramF));
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof FunctionalEquivalence) {
      paramObject = paramObject;
      if (!this.function.equals(((FunctionalEquivalence)paramObject).function) || !this.resultEquivalence.equals(((FunctionalEquivalence)paramObject).resultEquivalence))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.function, this.resultEquivalence });
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.resultEquivalence);
    stringBuilder.append(".onResultOf(");
    stringBuilder.append(this.function);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\FunctionalEquivalence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */