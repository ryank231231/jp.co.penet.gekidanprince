package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory<T> implements Factory<Set<T>> {
  private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
  
  private final List<Provider<Collection<T>>> collectionProviders;
  
  private final List<Provider<T>> individualProviders;
  
  private SetFactory(List<Provider<T>> paramList, List<Provider<Collection<T>>> paramList1) {
    this.individualProviders = paramList;
    this.collectionProviders = paramList1;
  }
  
  public static <T> Builder<T> builder(int paramInt1, int paramInt2) {
    return new Builder<T>(paramInt1, paramInt2);
  }
  
  public static <T> Factory<Set<T>> empty() {
    return (Factory)EMPTY_FACTORY;
  }
  
  public Set<T> get() {
    int i = this.individualProviders.size();
    ArrayList<Collection> arrayList = new ArrayList(this.collectionProviders.size());
    int j = this.collectionProviders.size();
    boolean bool = false;
    byte b;
    for (b = 0; b < j; b++) {
      Collection collection = (Collection)((Provider)this.collectionProviders.get(b)).get();
      i += collection.size();
      arrayList.add(collection);
    } 
    HashSet<?> hashSet = DaggerCollections.newHashSetWithExpectedSize(i);
    i = this.individualProviders.size();
    for (b = 0; b < i; b++)
      hashSet.add(Preconditions.checkNotNull(((Provider)this.individualProviders.get(b)).get())); 
    i = arrayList.size();
    for (b = bool; b < i; b++) {
      Iterator iterator = ((Collection)arrayList.get(b)).iterator();
      while (iterator.hasNext())
        hashSet.add(Preconditions.checkNotNull(iterator.next())); 
    } 
    return Collections.unmodifiableSet((Set)hashSet);
  }
  
  public static final class Builder<T> {
    private final List<Provider<Collection<T>>> collectionProviders;
    
    private final List<Provider<T>> individualProviders;
    
    private Builder(int param1Int1, int param1Int2) {
      this.individualProviders = DaggerCollections.presizedList(param1Int1);
      this.collectionProviders = DaggerCollections.presizedList(param1Int2);
    }
    
    public Builder<T> addCollectionProvider(Provider<? extends Collection<? extends T>> param1Provider) {
      this.collectionProviders.add(param1Provider);
      return this;
    }
    
    public Builder<T> addProvider(Provider<? extends T> param1Provider) {
      this.individualProviders.add(param1Provider);
      return this;
    }
    
    public SetFactory<T> build() {
      return new SetFactory<T>(this.individualProviders, this.collectionProviders);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\dagger\internal\SetFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */