package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class SetBuilder<T> {
  private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
  
  private final List<T> contributions;
  
  private SetBuilder(int paramInt) {
    this.contributions = new ArrayList<T>(paramInt);
  }
  
  public static <T> SetBuilder<T> newSetBuilder(int paramInt) {
    return new SetBuilder<T>(paramInt);
  }
  
  public SetBuilder<T> add(T paramT) {
    this.contributions.add(Preconditions.checkNotNull(paramT, "Set contributions cannot be null"));
    return this;
  }
  
  public SetBuilder<T> addAll(Collection<? extends T> paramCollection) {
    Iterator<? extends T> iterator = paramCollection.iterator();
    while (iterator.hasNext())
      Preconditions.checkNotNull(iterator.next(), "Set contributions cannot be null"); 
    this.contributions.addAll(paramCollection);
    return this;
  }
  
  public Set<T> build() {
    switch (this.contributions.size()) {
      default:
        return Collections.unmodifiableSet(new HashSet<T>(this.contributions));
      case 1:
        return Collections.singleton(this.contributions.get(0));
      case 0:
        break;
    } 
    return Collections.emptySet();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\SetBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */