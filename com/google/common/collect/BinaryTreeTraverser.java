package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;
import java.util.Iterator;

@Beta
@GwtCompatible
public abstract class BinaryTreeTraverser<T> extends TreeTraverser<T> {
  private static <T> void pushIfPresent(Deque<T> paramDeque, Optional<T> paramOptional) {
    if (paramOptional.isPresent())
      paramDeque.addLast((T)paramOptional.get()); 
  }
  
  public final Iterable<T> children(final T root) {
    Preconditions.checkNotNull(root);
    return new FluentIterable<T>() {
        public Iterator<T> iterator() {
          return new AbstractIterator<T>() {
              boolean doneLeft;
              
              boolean doneRight;
              
              protected T computeNext() {
                if (!this.doneLeft) {
                  this.doneLeft = true;
                  Optional optional = BinaryTreeTraverser.this.leftChild(root);
                  if (optional.isPresent())
                    return (T)optional.get(); 
                } 
                if (!this.doneRight) {
                  this.doneRight = true;
                  Optional optional = BinaryTreeTraverser.this.rightChild(root);
                  if (optional.isPresent())
                    return (T)optional.get(); 
                } 
                return endOfData();
              }
            };
        }
      };
  }
  
  public final FluentIterable<T> inOrderTraversal(final T root) {
    Preconditions.checkNotNull(root);
    return new FluentIterable<T>() {
        public UnmodifiableIterator<T> iterator() {
          return new BinaryTreeTraverser.InOrderIterator((T)root);
        }
      };
  }
  
  public abstract Optional<T> leftChild(T paramT);
  
  UnmodifiableIterator<T> postOrderIterator(T paramT) {
    return new PostOrderIterator(paramT);
  }
  
  UnmodifiableIterator<T> preOrderIterator(T paramT) {
    return new PreOrderIterator(paramT);
  }
  
  public abstract Optional<T> rightChild(T paramT);
  
  private final class InOrderIterator extends AbstractIterator<T> {
    private final BitSet hasExpandedLeft = new BitSet();
    
    private final Deque<T> stack = new ArrayDeque<T>(8);
    
    InOrderIterator(T param1T) {
      this.stack.addLast(param1T);
    }
    
    protected T computeNext() {
      while (!this.stack.isEmpty()) {
        T t = this.stack.getLast();
        if (this.hasExpandedLeft.get(this.stack.size() - 1)) {
          this.stack.removeLast();
          this.hasExpandedLeft.clear(this.stack.size());
          BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(t));
          return t;
        } 
        this.hasExpandedLeft.set(this.stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(t));
      } 
      return endOfData();
    }
  }
  
  private final class PostOrderIterator extends UnmodifiableIterator<T> {
    private final BitSet hasExpanded;
    
    private final Deque<T> stack = new ArrayDeque<T>(8);
    
    PostOrderIterator(T param1T) {
      this.stack.addLast(param1T);
      this.hasExpanded = new BitSet();
    }
    
    public boolean hasNext() {
      return this.stack.isEmpty() ^ true;
    }
    
    public T next() {
      while (true) {
        T t = this.stack.getLast();
        if (this.hasExpanded.get(this.stack.size() - 1)) {
          this.stack.removeLast();
          this.hasExpanded.clear(this.stack.size());
          return t;
        } 
        this.hasExpanded.set(this.stack.size() - 1);
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(t));
        BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(t));
      } 
    }
  }
  
  private final class PreOrderIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
    private final Deque<T> stack = new ArrayDeque<T>(8);
    
    PreOrderIterator(T param1T) {
      this.stack.addLast(param1T);
    }
    
    public boolean hasNext() {
      return this.stack.isEmpty() ^ true;
    }
    
    public T next() {
      T t = this.stack.removeLast();
      BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.rightChild(t));
      BinaryTreeTraverser.pushIfPresent(this.stack, BinaryTreeTraverser.this.leftChild(t));
      return t;
    }
    
    public T peek() {
      return this.stack.getLast();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\BinaryTreeTraverser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */