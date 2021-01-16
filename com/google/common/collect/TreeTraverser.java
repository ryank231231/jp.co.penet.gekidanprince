package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

@Beta
@GwtCompatible
public abstract class TreeTraverser<T> {
  public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> nodeToChildrenFunction) {
    Preconditions.checkNotNull(nodeToChildrenFunction);
    return new TreeTraverser<T>() {
        public Iterable<T> children(T param1T) {
          return (Iterable<T>)nodeToChildrenFunction.apply(param1T);
        }
      };
  }
  
  public final FluentIterable<T> breadthFirstTraversal(final T root) {
    Preconditions.checkNotNull(root);
    return new FluentIterable<T>() {
        public UnmodifiableIterator<T> iterator() {
          return new TreeTraverser.BreadthFirstIterator((T)root);
        }
      };
  }
  
  public abstract Iterable<T> children(T paramT);
  
  UnmodifiableIterator<T> postOrderIterator(T paramT) {
    return new PostOrderIterator(paramT);
  }
  
  public final FluentIterable<T> postOrderTraversal(final T root) {
    Preconditions.checkNotNull(root);
    return new FluentIterable<T>() {
        public UnmodifiableIterator<T> iterator() {
          return TreeTraverser.this.postOrderIterator((T)root);
        }
      };
  }
  
  UnmodifiableIterator<T> preOrderIterator(T paramT) {
    return new PreOrderIterator(paramT);
  }
  
  public final FluentIterable<T> preOrderTraversal(final T root) {
    Preconditions.checkNotNull(root);
    return new FluentIterable<T>() {
        public UnmodifiableIterator<T> iterator() {
          return TreeTraverser.this.preOrderIterator((T)root);
        }
      };
  }
  
  private final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {
    private final Queue<T> queue = new ArrayDeque<T>();
    
    BreadthFirstIterator(T param1T) {
      this.queue.add(param1T);
    }
    
    public boolean hasNext() {
      return this.queue.isEmpty() ^ true;
    }
    
    public T next() {
      T t = this.queue.remove();
      Iterables.addAll(this.queue, TreeTraverser.this.children(t));
      return t;
    }
    
    public T peek() {
      return this.queue.element();
    }
  }
  
  private final class PostOrderIterator extends AbstractIterator<T> {
    private final ArrayDeque<TreeTraverser.PostOrderNode<T>> stack = new ArrayDeque<TreeTraverser.PostOrderNode<T>>();
    
    PostOrderIterator(T param1T) {
      this.stack.addLast(expand(param1T));
    }
    
    private TreeTraverser.PostOrderNode<T> expand(T param1T) {
      return new TreeTraverser.PostOrderNode<T>(param1T, TreeTraverser.this.children(param1T).iterator());
    }
    
    protected T computeNext() {
      while (!this.stack.isEmpty()) {
        TreeTraverser.PostOrderNode postOrderNode = this.stack.getLast();
        if (postOrderNode.childIterator.hasNext()) {
          postOrderNode = postOrderNode.childIterator.next();
          this.stack.addLast(expand((T)postOrderNode));
          continue;
        } 
        this.stack.removeLast();
        return postOrderNode.root;
      } 
      return endOfData();
    }
  }
  
  private static final class PostOrderNode<T> {
    final Iterator<T> childIterator;
    
    final T root;
    
    PostOrderNode(T param1T, Iterator<T> param1Iterator) {
      this.root = (T)Preconditions.checkNotNull(param1T);
      this.childIterator = (Iterator<T>)Preconditions.checkNotNull(param1Iterator);
    }
  }
  
  private final class PreOrderIterator extends UnmodifiableIterator<T> {
    private final Deque<Iterator<T>> stack = new ArrayDeque<Iterator<T>>();
    
    PreOrderIterator(T param1T) {
      this.stack.addLast(Iterators.singletonIterator((T)Preconditions.checkNotNull(param1T)));
    }
    
    public boolean hasNext() {
      return this.stack.isEmpty() ^ true;
    }
    
    public T next() {
      Iterator<T> iterator = this.stack.getLast();
      Object object = Preconditions.checkNotNull(iterator.next());
      if (!iterator.hasNext())
        this.stack.removeLast(); 
      iterator = TreeTraverser.this.children(object).iterator();
      if (iterator.hasNext())
        this.stack.addLast(iterator); 
      return (T)object;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\TreeTraverser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */