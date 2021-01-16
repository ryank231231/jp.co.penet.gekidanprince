package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
final class Constraints {
  private static <E> Collection<E> checkElements(Collection<E> paramCollection, Constraint<? super E> paramConstraint) {
    ArrayList<E> arrayList = Lists.newArrayList(paramCollection);
    Iterator<E> iterator = arrayList.iterator();
    while (iterator.hasNext())
      paramConstraint.checkElement(iterator.next()); 
    return arrayList;
  }
  
  public static <E> Collection<E> constrainedCollection(Collection<E> paramCollection, Constraint<? super E> paramConstraint) {
    return new ConstrainedCollection<E>(paramCollection, paramConstraint);
  }
  
  public static <E> List<E> constrainedList(List<E> paramList, Constraint<? super E> paramConstraint) {
    if (paramList instanceof RandomAccess) {
      paramList = new ConstrainedRandomAccessList<E>(paramList, paramConstraint);
    } else {
      paramList = new ConstrainedList<E>(paramList, paramConstraint);
    } 
    return paramList;
  }
  
  private static <E> ListIterator<E> constrainedListIterator(ListIterator<E> paramListIterator, Constraint<? super E> paramConstraint) {
    return new ConstrainedListIterator<E>(paramListIterator, paramConstraint);
  }
  
  public static <E> Set<E> constrainedSet(Set<E> paramSet, Constraint<? super E> paramConstraint) {
    return new ConstrainedSet<E>(paramSet, paramConstraint);
  }
  
  public static <E> SortedSet<E> constrainedSortedSet(SortedSet<E> paramSortedSet, Constraint<? super E> paramConstraint) {
    return new ConstrainedSortedSet<E>(paramSortedSet, paramConstraint);
  }
  
  static <E> Collection<E> constrainedTypePreservingCollection(Collection<E> paramCollection, Constraint<E> paramConstraint) {
    return (paramCollection instanceof SortedSet) ? constrainedSortedSet((SortedSet<E>)paramCollection, paramConstraint) : ((paramCollection instanceof Set) ? constrainedSet((Set<E>)paramCollection, paramConstraint) : ((paramCollection instanceof List) ? constrainedList((List<E>)paramCollection, paramConstraint) : constrainedCollection(paramCollection, paramConstraint)));
  }
  
  static class ConstrainedCollection<E> extends ForwardingCollection<E> {
    private final Constraint<? super E> constraint;
    
    private final Collection<E> delegate;
    
    public ConstrainedCollection(Collection<E> param1Collection, Constraint<? super E> param1Constraint) {
      this.delegate = (Collection<E>)Preconditions.checkNotNull(param1Collection);
      this.constraint = (Constraint<? super E>)Preconditions.checkNotNull(param1Constraint);
    }
    
    public boolean add(E param1E) {
      this.constraint.checkElement(param1E);
      return this.delegate.add(param1E);
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      return this.delegate.addAll(Constraints.checkElements((Collection)param1Collection, this.constraint));
    }
    
    protected Collection<E> delegate() {
      return this.delegate;
    }
  }
  
  @GwtCompatible
  private static class ConstrainedList<E> extends ForwardingList<E> {
    final Constraint<? super E> constraint;
    
    final List<E> delegate;
    
    ConstrainedList(List<E> param1List, Constraint<? super E> param1Constraint) {
      this.delegate = (List<E>)Preconditions.checkNotNull(param1List);
      this.constraint = (Constraint<? super E>)Preconditions.checkNotNull(param1Constraint);
    }
    
    public void add(int param1Int, E param1E) {
      this.constraint.checkElement(param1E);
      this.delegate.add(param1Int, param1E);
    }
    
    public boolean add(E param1E) {
      this.constraint.checkElement(param1E);
      return this.delegate.add(param1E);
    }
    
    public boolean addAll(int param1Int, Collection<? extends E> param1Collection) {
      return this.delegate.addAll(param1Int, Constraints.checkElements((Collection)param1Collection, this.constraint));
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      return this.delegate.addAll(Constraints.checkElements((Collection)param1Collection, this.constraint));
    }
    
    protected List<E> delegate() {
      return this.delegate;
    }
    
    public ListIterator<E> listIterator() {
      return Constraints.constrainedListIterator(this.delegate.listIterator(), this.constraint);
    }
    
    public ListIterator<E> listIterator(int param1Int) {
      return Constraints.constrainedListIterator(this.delegate.listIterator(param1Int), this.constraint);
    }
    
    public E set(int param1Int, E param1E) {
      this.constraint.checkElement(param1E);
      return this.delegate.set(param1Int, param1E);
    }
    
    public List<E> subList(int param1Int1, int param1Int2) {
      return Constraints.constrainedList(this.delegate.subList(param1Int1, param1Int2), this.constraint);
    }
  }
  
  static class ConstrainedListIterator<E> extends ForwardingListIterator<E> {
    private final Constraint<? super E> constraint;
    
    private final ListIterator<E> delegate;
    
    public ConstrainedListIterator(ListIterator<E> param1ListIterator, Constraint<? super E> param1Constraint) {
      this.delegate = param1ListIterator;
      this.constraint = param1Constraint;
    }
    
    public void add(E param1E) {
      this.constraint.checkElement(param1E);
      this.delegate.add(param1E);
    }
    
    protected ListIterator<E> delegate() {
      return this.delegate;
    }
    
    public void set(E param1E) {
      this.constraint.checkElement(param1E);
      this.delegate.set(param1E);
    }
  }
  
  static class ConstrainedRandomAccessList<E> extends ConstrainedList<E> implements RandomAccess {
    ConstrainedRandomAccessList(List<E> param1List, Constraint<? super E> param1Constraint) {
      super(param1List, param1Constraint);
    }
  }
  
  static class ConstrainedSet<E> extends ForwardingSet<E> {
    private final Constraint<? super E> constraint;
    
    private final Set<E> delegate;
    
    public ConstrainedSet(Set<E> param1Set, Constraint<? super E> param1Constraint) {
      this.delegate = (Set<E>)Preconditions.checkNotNull(param1Set);
      this.constraint = (Constraint<? super E>)Preconditions.checkNotNull(param1Constraint);
    }
    
    public boolean add(E param1E) {
      this.constraint.checkElement(param1E);
      return this.delegate.add(param1E);
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      return this.delegate.addAll(Constraints.checkElements((Collection)param1Collection, this.constraint));
    }
    
    protected Set<E> delegate() {
      return this.delegate;
    }
  }
  
  private static class ConstrainedSortedSet<E> extends ForwardingSortedSet<E> {
    final Constraint<? super E> constraint;
    
    final SortedSet<E> delegate;
    
    ConstrainedSortedSet(SortedSet<E> param1SortedSet, Constraint<? super E> param1Constraint) {
      this.delegate = (SortedSet<E>)Preconditions.checkNotNull(param1SortedSet);
      this.constraint = (Constraint<? super E>)Preconditions.checkNotNull(param1Constraint);
    }
    
    public boolean add(E param1E) {
      this.constraint.checkElement(param1E);
      return this.delegate.add(param1E);
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      return this.delegate.addAll(Constraints.checkElements((Collection)param1Collection, this.constraint));
    }
    
    protected SortedSet<E> delegate() {
      return this.delegate;
    }
    
    public SortedSet<E> headSet(E param1E) {
      return Constraints.constrainedSortedSet(this.delegate.headSet(param1E), this.constraint);
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return Constraints.constrainedSortedSet(this.delegate.subSet(param1E1, param1E2), this.constraint);
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return Constraints.constrainedSortedSet(this.delegate.tailSet(param1E), this.constraint);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Constraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */