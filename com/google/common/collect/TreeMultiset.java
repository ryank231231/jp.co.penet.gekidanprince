package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
  @GwtIncompatible
  private static final long serialVersionUID = 1L;
  
  private final transient AvlNode<E> header;
  
  private final transient GeneralRange<E> range;
  
  private final transient Reference<AvlNode<E>> rootReference;
  
  TreeMultiset(Reference<AvlNode<E>> paramReference, GeneralRange<E> paramGeneralRange, AvlNode<E> paramAvlNode) {
    super(paramGeneralRange.comparator());
    this.rootReference = paramReference;
    this.range = paramGeneralRange;
    this.header = paramAvlNode;
  }
  
  TreeMultiset(Comparator<? super E> paramComparator) {
    super(paramComparator);
    this.range = GeneralRange.all(paramComparator);
    this.header = new AvlNode<E>(null, 1);
    AvlNode<E> avlNode = this.header;
    successor(avlNode, avlNode);
    this.rootReference = new Reference<AvlNode<E>>();
  }
  
  private long aggregateAboveRange(Aggregate paramAggregate, @Nullable AvlNode<E> paramAvlNode) {
    if (paramAvlNode == null)
      return 0L; 
    int i = comparator().compare(this.range.getUpperEndpoint(), paramAvlNode.elem);
    if (i > 0)
      return aggregateAboveRange(paramAggregate, paramAvlNode.right); 
    if (i == 0) {
      switch (this.range.getUpperBoundType()) {
        default:
          throw new AssertionError();
        case CLOSED:
          return paramAggregate.treeAggregate(paramAvlNode.right);
        case OPEN:
          break;
      } 
      return paramAggregate.nodeAggregate(paramAvlNode) + paramAggregate.treeAggregate(paramAvlNode.right);
    } 
    return paramAggregate.treeAggregate(paramAvlNode.right) + paramAggregate.nodeAggregate(paramAvlNode) + aggregateAboveRange(paramAggregate, paramAvlNode.left);
  }
  
  private long aggregateBelowRange(Aggregate paramAggregate, @Nullable AvlNode<E> paramAvlNode) {
    if (paramAvlNode == null)
      return 0L; 
    int i = comparator().compare(this.range.getLowerEndpoint(), paramAvlNode.elem);
    if (i < 0)
      return aggregateBelowRange(paramAggregate, paramAvlNode.left); 
    if (i == 0) {
      switch (this.range.getLowerBoundType()) {
        default:
          throw new AssertionError();
        case CLOSED:
          return paramAggregate.treeAggregate(paramAvlNode.left);
        case OPEN:
          break;
      } 
      return paramAggregate.nodeAggregate(paramAvlNode) + paramAggregate.treeAggregate(paramAvlNode.left);
    } 
    return paramAggregate.treeAggregate(paramAvlNode.left) + paramAggregate.nodeAggregate(paramAvlNode) + aggregateBelowRange(paramAggregate, paramAvlNode.right);
  }
  
  private long aggregateForEntries(Aggregate paramAggregate) {
    AvlNode<?> avlNode = this.rootReference.get();
    long l1 = paramAggregate.treeAggregate(avlNode);
    long l2 = l1;
    if (this.range.hasLowerBound())
      l2 = l1 - aggregateBelowRange(paramAggregate, (AvlNode)avlNode); 
    l1 = l2;
    if (this.range.hasUpperBound())
      l1 = l2 - aggregateAboveRange(paramAggregate, (AvlNode)avlNode); 
    return l1;
  }
  
  public static <E extends Comparable> TreeMultiset<E> create() {
    return new TreeMultiset<E>(Ordering.natural());
  }
  
  public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> paramIterable) {
    TreeMultiset<Comparable> treeMultiset = create();
    Iterables.addAll(treeMultiset, paramIterable);
    return (TreeMultiset)treeMultiset;
  }
  
  public static <E> TreeMultiset<E> create(@Nullable Comparator<? super E> paramComparator) {
    TreeMultiset<E> treeMultiset;
    if (paramComparator == null) {
      treeMultiset = new TreeMultiset(Ordering.natural());
    } else {
      treeMultiset = new TreeMultiset((Comparator<?>)treeMultiset);
    } 
    return treeMultiset;
  }
  
  static int distinctElements(@Nullable AvlNode<?> paramAvlNode) {
    int i;
    if (paramAvlNode == null) {
      i = 0;
    } else {
      i = paramAvlNode.distinctElements;
    } 
    return i;
  }
  
  @Nullable
  private AvlNode<E> firstNode() {
    AvlNode<E> avlNode;
    if ((AvlNode)this.rootReference.get() == null)
      return null; 
    if (this.range.hasLowerBound()) {
      E e = this.range.getLowerEndpoint();
      AvlNode<E> avlNode1 = ((AvlNode)this.rootReference.get()).ceiling(comparator(), e);
      if (avlNode1 == null)
        return null; 
      avlNode = avlNode1;
      if (this.range.getLowerBoundType() == BoundType.OPEN) {
        avlNode = avlNode1;
        if (comparator().compare(e, avlNode1.getElement()) == 0)
          avlNode = avlNode1.succ; 
      } 
    } else {
      avlNode = this.header.succ;
    } 
    if (avlNode != this.header) {
      AvlNode<E> avlNode1 = avlNode;
      return !this.range.contains(avlNode.getElement()) ? null : avlNode1;
    } 
    return null;
  }
  
  @Nullable
  private AvlNode<E> lastNode() {
    AvlNode<E> avlNode;
    if ((AvlNode)this.rootReference.get() == null)
      return null; 
    if (this.range.hasUpperBound()) {
      E e = this.range.getUpperEndpoint();
      AvlNode<E> avlNode1 = ((AvlNode)this.rootReference.get()).floor(comparator(), e);
      if (avlNode1 == null)
        return null; 
      avlNode = avlNode1;
      if (this.range.getUpperBoundType() == BoundType.OPEN) {
        avlNode = avlNode1;
        if (comparator().compare(e, avlNode1.getElement()) == 0)
          avlNode = avlNode1.pred; 
      } 
    } else {
      avlNode = this.header.pred;
    } 
    if (avlNode != this.header) {
      AvlNode<E> avlNode1 = avlNode;
      return !this.range.contains(avlNode.getElement()) ? null : avlNode1;
    } 
    return null;
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    Comparator<?> comparator = (Comparator)paramObjectInputStream.readObject();
    Serialization.<AbstractSortedMultiset>getFieldSetter(AbstractSortedMultiset.class, "comparator").set(this, comparator);
    Serialization.<TreeMultiset>getFieldSetter(TreeMultiset.class, "range").set(this, GeneralRange.all(comparator));
    Serialization.<TreeMultiset>getFieldSetter(TreeMultiset.class, "rootReference").set(this, new Reference());
    AvlNode<?> avlNode = new AvlNode(null, 1);
    Serialization.<TreeMultiset>getFieldSetter(TreeMultiset.class, "header").set(this, avlNode);
    successor(avlNode, avlNode);
    Serialization.populateMultiset(this, paramObjectInputStream);
  }
  
  private static <T> void successor(AvlNode<T> paramAvlNode1, AvlNode<T> paramAvlNode2) {
    AvlNode.access$902(paramAvlNode1, paramAvlNode2);
    AvlNode.access$1102(paramAvlNode2, paramAvlNode1);
  }
  
  private static <T> void successor(AvlNode<T> paramAvlNode1, AvlNode<T> paramAvlNode2, AvlNode<T> paramAvlNode3) {
    successor(paramAvlNode1, paramAvlNode2);
    successor(paramAvlNode2, paramAvlNode3);
  }
  
  private Multiset.Entry<E> wrapEntry(final AvlNode<E> baseEntry) {
    return new Multisets.AbstractEntry<E>() {
        public int getCount() {
          int i = baseEntry.getCount();
          return (i == 0) ? TreeMultiset.this.count(getElement()) : i;
        }
        
        public E getElement() {
          return baseEntry.getElement();
        }
      };
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(elementSet().comparator());
    Serialization.writeMultiset(this, paramObjectOutputStream);
  }
  
  @CanIgnoreReturnValue
  public int add(@Nullable E paramE, int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "occurrences");
    if (paramInt == 0)
      return count(paramE); 
    Preconditions.checkArgument(this.range.contains(paramE));
    AvlNode<E> avlNode2 = this.rootReference.get();
    if (avlNode2 == null) {
      comparator().compare(paramE, paramE);
      AvlNode<E> avlNode = new AvlNode<E>(paramE, paramInt);
      avlNode1 = this.header;
      successor(avlNode1, avlNode, avlNode1);
      this.rootReference.checkAndSet(avlNode2, avlNode);
      return 0;
    } 
    int[] arrayOfInt = new int[1];
    AvlNode<E> avlNode1 = avlNode2.add(comparator(), (E)avlNode1, paramInt, arrayOfInt);
    this.rootReference.checkAndSet(avlNode2, avlNode1);
    return arrayOfInt[0];
  }
  
  public int count(@Nullable Object paramObject) {
    try {
      AvlNode<Object> avlNode = (AvlNode)this.rootReference.get();
      return (!this.range.contains((E)paramObject) || avlNode == null) ? 0 : avlNode.count(comparator(), paramObject);
    } catch (ClassCastException classCastException) {
      return 0;
    } catch (NullPointerException nullPointerException) {
      return 0;
    } 
  }
  
  Iterator<Multiset.Entry<E>> descendingEntryIterator() {
    return (Iterator)new Iterator<Multiset.Entry<Multiset.Entry<E>>>() {
        TreeMultiset.AvlNode<E> current = TreeMultiset.this.lastNode();
        
        Multiset.Entry<E> prevEntry = null;
        
        public boolean hasNext() {
          if (this.current == null)
            return false; 
          if (TreeMultiset.this.range.tooLow(this.current.getElement())) {
            this.current = null;
            return false;
          } 
          return true;
        }
        
        public Multiset.Entry<E> next() {
          if (hasNext()) {
            Multiset.Entry<E> entry = TreeMultiset.this.wrapEntry(this.current);
            this.prevEntry = entry;
            if (this.current.pred == TreeMultiset.this.header) {
              this.current = null;
            } else {
              this.current = this.current.pred;
            } 
            return entry;
          } 
          throw new NoSuchElementException();
        }
        
        public void remove() {
          boolean bool;
          if (this.prevEntry != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.checkRemove(bool);
          TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
          this.prevEntry = null;
        }
      };
  }
  
  int distinctElements() {
    return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
  }
  
  Iterator<Multiset.Entry<E>> entryIterator() {
    return (Iterator)new Iterator<Multiset.Entry<Multiset.Entry<E>>>() {
        TreeMultiset.AvlNode<E> current = TreeMultiset.this.firstNode();
        
        Multiset.Entry<E> prevEntry;
        
        public boolean hasNext() {
          if (this.current == null)
            return false; 
          if (TreeMultiset.this.range.tooHigh(this.current.getElement())) {
            this.current = null;
            return false;
          } 
          return true;
        }
        
        public Multiset.Entry<E> next() {
          if (hasNext()) {
            Multiset.Entry<E> entry = TreeMultiset.this.wrapEntry(this.current);
            this.prevEntry = entry;
            if (this.current.succ == TreeMultiset.this.header) {
              this.current = null;
            } else {
              this.current = this.current.succ;
            } 
            return entry;
          } 
          throw new NoSuchElementException();
        }
        
        public void remove() {
          boolean bool;
          if (this.prevEntry != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.checkRemove(bool);
          TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
          this.prevEntry = null;
        }
      };
  }
  
  public SortedMultiset<E> headMultiset(@Nullable E paramE, BoundType paramBoundType) {
    return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), paramE, paramBoundType)), this.header);
  }
  
  @CanIgnoreReturnValue
  public int remove(@Nullable Object paramObject, int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "occurrences");
    if (paramInt == 0)
      return count(paramObject); 
    AvlNode<Object> avlNode = (AvlNode)this.rootReference.get();
    int[] arrayOfInt = new int[1];
    try {
      if (!this.range.contains((E)paramObject) || avlNode == null)
        return 0; 
      paramObject = avlNode.remove(comparator(), paramObject, paramInt, arrayOfInt);
      this.rootReference.checkAndSet(avlNode, paramObject);
      return arrayOfInt[0];
    } catch (ClassCastException classCastException) {
      return 0;
    } catch (NullPointerException nullPointerException) {
      return 0;
    } 
  }
  
  @CanIgnoreReturnValue
  public int setCount(@Nullable E paramE, int paramInt) {
    CollectPreconditions.checkNonnegative(paramInt, "count");
    boolean bool = this.range.contains(paramE);
    boolean bool1 = true;
    if (!bool) {
      if (paramInt != 0)
        bool1 = false; 
      Preconditions.checkArgument(bool1);
      return 0;
    } 
    AvlNode<E> avlNode2 = this.rootReference.get();
    if (avlNode2 == null) {
      if (paramInt > 0)
        add(paramE, paramInt); 
      return 0;
    } 
    int[] arrayOfInt = new int[1];
    AvlNode<E> avlNode1 = avlNode2.setCount(comparator(), paramE, paramInt, arrayOfInt);
    this.rootReference.checkAndSet(avlNode2, avlNode1);
    return arrayOfInt[0];
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(@Nullable E paramE, int paramInt1, int paramInt2) {
    CollectPreconditions.checkNonnegative(paramInt2, "newCount");
    CollectPreconditions.checkNonnegative(paramInt1, "oldCount");
    Preconditions.checkArgument(this.range.contains(paramE));
    AvlNode<E> avlNode2 = this.rootReference.get();
    boolean bool = false;
    if (avlNode2 == null) {
      if (paramInt1 == 0) {
        if (paramInt2 > 0)
          add(paramE, paramInt2); 
        return true;
      } 
      return false;
    } 
    int[] arrayOfInt = new int[1];
    AvlNode<E> avlNode1 = avlNode2.setCount(comparator(), paramE, paramInt1, paramInt2, arrayOfInt);
    this.rootReference.checkAndSet(avlNode2, avlNode1);
    if (arrayOfInt[0] == paramInt1)
      bool = true; 
    return bool;
  }
  
  public int size() {
    return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
  }
  
  public SortedMultiset<E> tailMultiset(@Nullable E paramE, BoundType paramBoundType) {
    return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), paramE, paramBoundType)), this.header);
  }
  
  private enum Aggregate {
    DISTINCT,
    SIZE {
      int nodeAggregate(TreeMultiset.AvlNode<?> param2AvlNode) {
        return param2AvlNode.elemCount;
      }
      
      long treeAggregate(@Nullable TreeMultiset.AvlNode<?> param2AvlNode) {
        long l;
        if (param2AvlNode == null) {
          l = 0L;
        } else {
          l = param2AvlNode.totalCount;
        } 
        return l;
      }
    };
    
    static {
      $VALUES = new Aggregate[] { SIZE, DISTINCT };
    }
    
    abstract int nodeAggregate(TreeMultiset.AvlNode<?> param1AvlNode);
    
    abstract long treeAggregate(@Nullable TreeMultiset.AvlNode<?> param1AvlNode);
  }
  
  enum null {
    int nodeAggregate(TreeMultiset.AvlNode<?> param1AvlNode) {
      return param1AvlNode.elemCount;
    }
    
    long treeAggregate(@Nullable TreeMultiset.AvlNode<?> param1AvlNode) {
      long l;
      if (param1AvlNode == null) {
        l = 0L;
      } else {
        l = param1AvlNode.totalCount;
      } 
      return l;
    }
  }
  
  enum null {
    int nodeAggregate(TreeMultiset.AvlNode<?> param1AvlNode) {
      return 1;
    }
    
    long treeAggregate(@Nullable TreeMultiset.AvlNode<?> param1AvlNode) {
      long l;
      if (param1AvlNode == null) {
        l = 0L;
      } else {
        l = param1AvlNode.distinctElements;
      } 
      return l;
    }
  }
  
  private static final class AvlNode<E> extends Multisets.AbstractEntry<E> {
    private int distinctElements;
    
    @Nullable
    private final E elem;
    
    private int elemCount;
    
    private int height;
    
    private AvlNode<E> left;
    
    private AvlNode<E> pred;
    
    private AvlNode<E> right;
    
    private AvlNode<E> succ;
    
    private long totalCount;
    
    AvlNode(@Nullable E param1E, int param1Int) {
      boolean bool;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      this.elem = param1E;
      this.elemCount = param1Int;
      this.totalCount = param1Int;
      this.distinctElements = 1;
      this.height = 1;
      this.left = null;
      this.right = null;
    }
    
    private AvlNode<E> addLeftChild(E param1E, int param1Int) {
      this.left = new AvlNode(param1E, param1Int);
      TreeMultiset.successor(this.pred, this.left, this);
      this.height = Math.max(2, this.height);
      this.distinctElements++;
      this.totalCount += param1Int;
      return this;
    }
    
    private AvlNode<E> addRightChild(E param1E, int param1Int) {
      this.right = new AvlNode(param1E, param1Int);
      TreeMultiset.successor(this, this.right, this.succ);
      this.height = Math.max(2, this.height);
      this.distinctElements++;
      this.totalCount += param1Int;
      return this;
    }
    
    private int balanceFactor() {
      return height(this.left) - height(this.right);
    }
    
    @Nullable
    private AvlNode<E> ceiling(Comparator<? super E> param1Comparator, E param1E) {
      AvlNode<E> avlNode1;
      int i = param1Comparator.compare(param1E, this.elem);
      if (i < 0) {
        AvlNode<E> avlNode = this.left;
        if (avlNode == null) {
          avlNode1 = this;
        } else {
          avlNode1 = (AvlNode)MoreObjects.firstNonNull(avlNode.ceiling((Comparator<? super E>)avlNode1, param1E), this);
        } 
        return avlNode1;
      } 
      if (i == 0)
        return this; 
      AvlNode<E> avlNode2 = this.right;
      if (avlNode2 == null) {
        param1Comparator = null;
      } else {
        avlNode1 = avlNode2.ceiling(param1Comparator, param1E);
      } 
      return avlNode1;
    }
    
    private AvlNode<E> deleteMe() {
      int i = this.elemCount;
      this.elemCount = 0;
      TreeMultiset.successor(this.pred, this.succ);
      AvlNode<E> avlNode1 = this.left;
      if (avlNode1 == null)
        return this.right; 
      AvlNode<E> avlNode2 = this.right;
      if (avlNode2 == null)
        return avlNode1; 
      if (avlNode1.height >= avlNode2.height) {
        avlNode2 = this.pred;
        avlNode2.left = avlNode1.removeMax(avlNode2);
        avlNode2.right = this.right;
        avlNode2.distinctElements = this.distinctElements - 1;
        avlNode2.totalCount = this.totalCount - i;
        return avlNode2.rebalance();
      } 
      avlNode1 = this.succ;
      avlNode1.right = avlNode2.removeMin(avlNode1);
      avlNode1.left = this.left;
      avlNode1.distinctElements = this.distinctElements - 1;
      avlNode1.totalCount = this.totalCount - i;
      return avlNode1.rebalance();
    }
    
    @Nullable
    private AvlNode<E> floor(Comparator<? super E> param1Comparator, E param1E) {
      AvlNode<E> avlNode1;
      int i = param1Comparator.compare(param1E, this.elem);
      if (i > 0) {
        AvlNode<E> avlNode = this.right;
        if (avlNode == null) {
          avlNode1 = this;
        } else {
          avlNode1 = (AvlNode)MoreObjects.firstNonNull(avlNode.floor((Comparator<? super E>)avlNode1, param1E), this);
        } 
        return avlNode1;
      } 
      if (i == 0)
        return this; 
      AvlNode<E> avlNode2 = this.left;
      if (avlNode2 == null) {
        param1Comparator = null;
      } else {
        avlNode1 = avlNode2.floor(param1Comparator, param1E);
      } 
      return avlNode1;
    }
    
    private static int height(@Nullable AvlNode<?> param1AvlNode) {
      int i;
      if (param1AvlNode == null) {
        i = 0;
      } else {
        i = param1AvlNode.height;
      } 
      return i;
    }
    
    private AvlNode<E> rebalance() {
      int i = balanceFactor();
      if (i != -2) {
        if (i != 2) {
          recomputeHeight();
          return this;
        } 
        if (this.left.balanceFactor() < 0)
          this.left = this.left.rotateLeft(); 
        return rotateRight();
      } 
      if (this.right.balanceFactor() > 0)
        this.right = this.right.rotateRight(); 
      return rotateLeft();
    }
    
    private void recompute() {
      recomputeMultiset();
      recomputeHeight();
    }
    
    private void recomputeHeight() {
      this.height = Math.max(height(this.left), height(this.right)) + 1;
    }
    
    private void recomputeMultiset() {
      this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
      this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
    }
    
    private AvlNode<E> removeMax(AvlNode<E> param1AvlNode) {
      AvlNode<E> avlNode = this.right;
      if (avlNode == null)
        return this.left; 
      this.right = avlNode.removeMax(param1AvlNode);
      this.distinctElements--;
      this.totalCount -= param1AvlNode.elemCount;
      return rebalance();
    }
    
    private AvlNode<E> removeMin(AvlNode<E> param1AvlNode) {
      AvlNode<E> avlNode = this.left;
      if (avlNode == null)
        return this.right; 
      this.left = avlNode.removeMin(param1AvlNode);
      this.distinctElements--;
      this.totalCount -= param1AvlNode.elemCount;
      return rebalance();
    }
    
    private AvlNode<E> rotateLeft() {
      boolean bool;
      if (this.right != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      AvlNode<E> avlNode = this.right;
      this.right = avlNode.left;
      avlNode.left = this;
      avlNode.totalCount = this.totalCount;
      avlNode.distinctElements = this.distinctElements;
      recompute();
      avlNode.recomputeHeight();
      return avlNode;
    }
    
    private AvlNode<E> rotateRight() {
      boolean bool;
      if (this.left != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      AvlNode<E> avlNode = this.left;
      this.left = avlNode.right;
      avlNode.right = this;
      avlNode.totalCount = this.totalCount;
      avlNode.distinctElements = this.distinctElements;
      recompute();
      avlNode.recomputeHeight();
      return avlNode;
    }
    
    private static long totalCount(@Nullable AvlNode<?> param1AvlNode) {
      long l;
      if (param1AvlNode == null) {
        l = 0L;
      } else {
        l = param1AvlNode.totalCount;
      } 
      return l;
    }
    
    AvlNode<E> add(Comparator<? super E> param1Comparator, @Nullable E param1E, int param1Int, int[] param1ArrayOfint) {
      AvlNode<E> avlNode;
      int i = param1Comparator.compare(param1E, this.elem);
      boolean bool = true;
      if (i < 0) {
        AvlNode<E> avlNode1 = this.left;
        if (avlNode1 == null) {
          param1ArrayOfint[0] = 0;
          return addLeftChild(param1E, param1Int);
        } 
        i = avlNode1.height;
        this.left = avlNode1.add(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] == 0)
          this.distinctElements++; 
        this.totalCount += param1Int;
        if (this.left.height == i) {
          avlNode = this;
        } else {
          avlNode = rebalance();
        } 
        return avlNode;
      } 
      if (i > 0) {
        AvlNode<E> avlNode1 = this.right;
        if (avlNode1 == null) {
          param1ArrayOfint[0] = 0;
          return addRightChild(param1E, param1Int);
        } 
        i = avlNode1.height;
        this.right = avlNode1.add((Comparator<? super E>)avlNode, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] == 0)
          this.distinctElements++; 
        this.totalCount += param1Int;
        if (this.right.height == i) {
          avlNode = this;
        } else {
          avlNode = rebalance();
        } 
        return avlNode;
      } 
      i = this.elemCount;
      param1ArrayOfint[0] = i;
      long l1 = i;
      long l2 = param1Int;
      if (l1 + l2 > 2147483647L)
        bool = false; 
      Preconditions.checkArgument(bool);
      this.elemCount += param1Int;
      this.totalCount += l2;
      return this;
    }
    
    public int count(Comparator<? super E> param1Comparator, E param1E) {
      int i = param1Comparator.compare(param1E, this.elem);
      boolean bool = false;
      int j = 0;
      if (i < 0) {
        AvlNode<E> avlNode = this.left;
        if (avlNode != null)
          j = avlNode.count(param1Comparator, param1E); 
        return j;
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.right;
        if (avlNode == null) {
          j = bool;
        } else {
          j = avlNode.count(param1Comparator, param1E);
        } 
        return j;
      } 
      return this.elemCount;
    }
    
    public int getCount() {
      return this.elemCount;
    }
    
    public E getElement() {
      return this.elem;
    }
    
    AvlNode<E> remove(Comparator<? super E> param1Comparator, @Nullable E param1E, int param1Int, int[] param1ArrayOfint) {
      AvlNode<E> avlNode;
      int i = param1Comparator.compare(param1E, this.elem);
      if (i < 0) {
        AvlNode<E> avlNode1 = this.left;
        if (avlNode1 == null) {
          param1ArrayOfint[0] = 0;
          return this;
        } 
        this.left = avlNode1.remove(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] > 0)
          if (param1Int >= param1ArrayOfint[0]) {
            this.distinctElements--;
            this.totalCount -= param1ArrayOfint[0];
          } else {
            this.totalCount -= param1Int;
          }  
        if (param1ArrayOfint[0] == 0) {
          avlNode = this;
        } else {
          avlNode = rebalance();
        } 
        return avlNode;
      } 
      if (i > 0) {
        AvlNode<E> avlNode1 = this.right;
        if (avlNode1 == null) {
          param1ArrayOfint[0] = 0;
          return this;
        } 
        this.right = avlNode1.remove((Comparator<? super E>)avlNode, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] > 0)
          if (param1Int >= param1ArrayOfint[0]) {
            this.distinctElements--;
            this.totalCount -= param1ArrayOfint[0];
          } else {
            this.totalCount -= param1Int;
          }  
        return rebalance();
      } 
      i = this.elemCount;
      param1ArrayOfint[0] = i;
      if (param1Int >= i)
        return deleteMe(); 
      this.elemCount = i - param1Int;
      this.totalCount -= param1Int;
      return this;
    }
    
    AvlNode<E> setCount(Comparator<? super E> param1Comparator, @Nullable E param1E, int param1Int1, int param1Int2, int[] param1ArrayOfint) {
      int i = param1Comparator.compare(param1E, this.elem);
      if (i < 0) {
        AvlNode<E> avlNode = this.left;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return (param1Int1 == 0 && param1Int2 > 0) ? addLeftChild(param1E, param1Int2) : this;
        } 
        this.left = avlNode.setCount(param1Comparator, param1E, param1Int1, param1Int2, param1ArrayOfint);
        if (param1ArrayOfint[0] == param1Int1) {
          if (param1Int2 == 0 && param1ArrayOfint[0] != 0) {
            this.distinctElements--;
          } else if (param1Int2 > 0 && param1ArrayOfint[0] == 0) {
            this.distinctElements++;
          } 
          this.totalCount += (param1Int2 - param1ArrayOfint[0]);
        } 
        return rebalance();
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.right;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return (param1Int1 == 0 && param1Int2 > 0) ? addRightChild(param1E, param1Int2) : this;
        } 
        this.right = avlNode.setCount(param1Comparator, param1E, param1Int1, param1Int2, param1ArrayOfint);
        if (param1ArrayOfint[0] == param1Int1) {
          if (param1Int2 == 0 && param1ArrayOfint[0] != 0) {
            this.distinctElements--;
          } else if (param1Int2 > 0 && param1ArrayOfint[0] == 0) {
            this.distinctElements++;
          } 
          this.totalCount += (param1Int2 - param1ArrayOfint[0]);
        } 
        return rebalance();
      } 
      i = this.elemCount;
      param1ArrayOfint[0] = i;
      if (param1Int1 == i) {
        if (param1Int2 == 0)
          return deleteMe(); 
        this.totalCount += (param1Int2 - i);
        this.elemCount = param1Int2;
      } 
      return this;
    }
    
    AvlNode<E> setCount(Comparator<? super E> param1Comparator, @Nullable E param1E, int param1Int, int[] param1ArrayOfint) {
      int i = param1Comparator.compare(param1E, this.elem);
      if (i < 0) {
        AvlNode<E> avlNode1;
        AvlNode<E> avlNode2 = this.left;
        if (avlNode2 == null) {
          param1ArrayOfint[0] = 0;
          if (param1Int > 0) {
            avlNode1 = addLeftChild(param1E, param1Int);
          } else {
            avlNode1 = this;
          } 
          return avlNode1;
        } 
        this.left = avlNode2.setCount((Comparator<? super E>)avlNode1, param1E, param1Int, param1ArrayOfint);
        if (param1Int == 0 && param1ArrayOfint[0] != 0) {
          this.distinctElements--;
        } else if (param1Int > 0 && param1ArrayOfint[0] == 0) {
          this.distinctElements++;
        } 
        this.totalCount += (param1Int - param1ArrayOfint[0]);
        return rebalance();
      } 
      if (i > 0) {
        AvlNode<E> avlNode1;
        AvlNode<E> avlNode2 = this.right;
        if (avlNode2 == null) {
          param1ArrayOfint[0] = 0;
          if (param1Int > 0) {
            avlNode1 = addRightChild(param1E, param1Int);
          } else {
            avlNode1 = this;
          } 
          return avlNode1;
        } 
        this.right = avlNode2.setCount((Comparator<? super E>)avlNode1, param1E, param1Int, param1ArrayOfint);
        if (param1Int == 0 && param1ArrayOfint[0] != 0) {
          this.distinctElements--;
        } else if (param1Int > 0 && param1ArrayOfint[0] == 0) {
          this.distinctElements++;
        } 
        this.totalCount += (param1Int - param1ArrayOfint[0]);
        return rebalance();
      } 
      i = this.elemCount;
      param1ArrayOfint[0] = i;
      if (param1Int == 0)
        return deleteMe(); 
      this.totalCount += (param1Int - i);
      this.elemCount = param1Int;
      return this;
    }
    
    public String toString() {
      return Multisets.<E>immutableEntry(getElement(), getCount()).toString();
    }
  }
  
  private static final class Reference<T> {
    @Nullable
    private T value;
    
    private Reference() {}
    
    public void checkAndSet(@Nullable T param1T1, T param1T2) {
      if (this.value == param1T1) {
        this.value = param1T2;
        return;
      } 
      throw new ConcurrentModificationException();
    }
    
    @Nullable
    public T get() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TreeMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */