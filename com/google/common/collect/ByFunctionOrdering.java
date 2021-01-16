package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
  private static final long serialVersionUID = 0L;
  
  final Function<F, ? extends T> function;
  
  final Ordering<T> ordering;
  
  ByFunctionOrdering(Function<F, ? extends T> paramFunction, Ordering<T> paramOrdering) {
    this.function = (Function<F, ? extends T>)Preconditions.checkNotNull(paramFunction);
    this.ordering = (Ordering<T>)Preconditions.checkNotNull(paramOrdering);
  }
  
  public int compare(F paramF1, F paramF2) {
    return this.ordering.compare((T)this.function.apply(paramF1), (T)this.function.apply(paramF2));
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = true;
    if (paramObject == this)
      return true; 
    if (paramObject instanceof ByFunctionOrdering) {
      paramObject = paramObject;
      if (!this.function.equals(((ByFunctionOrdering)paramObject).function) || !this.ordering.equals(((ByFunctionOrdering)paramObject).ordering))
        bool = false; 
      return bool;
    } 
    return false;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.function, this.ordering });
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.ordering);
    stringBuilder.append(".onResultOf(");
    stringBuilder.append(this.function);
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\ByFunctionOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */