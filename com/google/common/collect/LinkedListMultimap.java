package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
  @GwtIncompatible
  private static final long serialVersionUID = 0L;
  
  private transient Node<K, V> head;
  
  private transient Map<K, KeyList<K, V>> keyToKeyList = Maps.newHashMap();
  
  private transient int modCount;
  
  private transient int size;
  
  private transient Node<K, V> tail;
  
  LinkedListMultimap() {}
  
  private LinkedListMultimap(int paramInt) {}
  
  private LinkedListMultimap(Multimap<? extends K, ? extends V> paramMultimap) {
    this(paramMultimap.keySet().size());
    putAll(paramMultimap);
  }
  
  @CanIgnoreReturnValue
  private Node<K, V> addNode(@Nullable K paramK, @Nullable V paramV, @Nullable Node<K, V> paramNode) {
    Node<K, V> node = new Node<K, V>(paramK, paramV);
    if (this.head == null) {
      this.tail = node;
      this.head = node;
      this.keyToKeyList.put(paramK, new KeyList<K, V>(node));
      this.modCount++;
    } else {
      Node<K, V> node1;
      KeyList keyList;
      if (paramNode == null) {
        paramNode = this.tail;
        paramNode.next = node;
        node.previous = paramNode;
        this.tail = node;
        keyList = this.keyToKeyList.get(paramK);
        if (keyList == null) {
          this.keyToKeyList.put(paramK, new KeyList<K, V>(node));
          this.modCount++;
        } else {
          keyList.count++;
          node1 = keyList.tail;
          node1.nextSibling = node;
          node.previousSibling = node1;
          keyList.tail = node;
        } 
      } else {
        KeyList keyList1 = this.keyToKeyList.get(node1);
        keyList1.count++;
        node.previous = ((Node)keyList).previous;
        node.previousSibling = ((Node)keyList).previousSibling;
        node.next = (Node<K, V>)keyList;
        node.nextSibling = (Node<K, V>)keyList;
        if (((Node)keyList).previousSibling == null) {
          ((KeyList)this.keyToKeyList.get(node1)).head = node;
        } else {
          ((Node)keyList).previousSibling.nextSibling = node;
        } 
        if (((Node)keyList).previous == null) {
          this.head = node;
        } else {
          ((Node)keyList).previous.next = node;
        } 
        ((Node)keyList).previous = node;
        ((Node)keyList).previousSibling = node;
      } 
    } 
    this.size++;
    return node;
  }
  
  private static void checkElement(@Nullable Object paramObject) {
    if (paramObject != null)
      return; 
    throw new NoSuchElementException();
  }
  
  public static <K, V> LinkedListMultimap<K, V> create() {
    return new LinkedListMultimap<K, V>();
  }
  
  public static <K, V> LinkedListMultimap<K, V> create(int paramInt) {
    return new LinkedListMultimap<K, V>(paramInt);
  }
  
  public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> paramMultimap) {
    return new LinkedListMultimap<K, V>(paramMultimap);
  }
  
  private List<V> getCopy(@Nullable Object paramObject) {
    return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(paramObject)));
  }
  
  @GwtIncompatible
  private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
    paramObjectInputStream.defaultReadObject();
    this.keyToKeyList = Maps.newLinkedHashMap();
    int i = paramObjectInputStream.readInt();
    for (byte b = 0; b < i; b++)
      put((K)paramObjectInputStream.readObject(), (V)paramObjectInputStream.readObject()); 
  }
  
  private void removeAllNodes(@Nullable Object paramObject) {
    Iterators.clear(new ValueForKeyIterator(paramObject));
  }
  
  private void removeNode(Node<K, V> paramNode) {
    if (paramNode.previous != null) {
      paramNode.previous.next = paramNode.next;
    } else {
      this.head = paramNode.next;
    } 
    if (paramNode.next != null) {
      paramNode.next.previous = paramNode.previous;
    } else {
      this.tail = paramNode.previous;
    } 
    if (paramNode.previousSibling == null && paramNode.nextSibling == null) {
      ((KeyList)this.keyToKeyList.remove(paramNode.key)).count = 0;
      this.modCount++;
    } else {
      KeyList keyList = this.keyToKeyList.get(paramNode.key);
      keyList.count--;
      if (paramNode.previousSibling == null) {
        keyList.head = paramNode.nextSibling;
      } else {
        paramNode.previousSibling.nextSibling = paramNode.nextSibling;
      } 
      if (paramNode.nextSibling == null) {
        keyList.tail = paramNode.previousSibling;
      } else {
        paramNode.nextSibling.previousSibling = paramNode.previousSibling;
      } 
    } 
    this.size--;
  }
  
  @GwtIncompatible
  private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(size());
    for (Map.Entry<K, V> entry : entries()) {
      paramObjectOutputStream.writeObject(entry.getKey());
      paramObjectOutputStream.writeObject(entry.getValue());
    } 
  }
  
  public void clear() {
    this.head = null;
    this.tail = null;
    this.keyToKeyList.clear();
    this.size = 0;
    this.modCount++;
  }
  
  public boolean containsKey(@Nullable Object paramObject) {
    return this.keyToKeyList.containsKey(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject) {
    return values().contains(paramObject);
  }
  
  Map<K, Collection<V>> createAsMap() {
    return new Multimaps.AsMap<K, V>(this);
  }
  
  List<Map.Entry<K, V>> createEntries() {
    class EntriesImpl extends AbstractSequentialList<Map.Entry<K, V>> {
      public ListIterator<Map.Entry<K, V>> listIterator(int param1Int) {
        return new LinkedListMultimap.NodeIterator(param1Int);
      }
      
      public int size() {
        return LinkedListMultimap.this.size;
      }
    };
    return new EntriesImpl();
  }
  
  Set<K> createKeySet() {
    class KeySetImpl extends Sets.ImprovedAbstractSet<K> {
      public boolean contains(Object param1Object) {
        return LinkedListMultimap.this.containsKey(param1Object);
      }
      
      public Iterator<K> iterator() {
        return new LinkedListMultimap.DistinctKeyIterator();
      }
      
      public boolean remove(Object param1Object) {
        return LinkedListMultimap.this.removeAll(param1Object).isEmpty() ^ true;
      }
      
      public int size() {
        return LinkedListMultimap.this.keyToKeyList.size();
      }
    };
    return new KeySetImpl();
  }
  
  List<V> createValues() {
    class ValuesImpl extends AbstractSequentialList<V> {
      public ListIterator<V> listIterator(int param1Int) {
        final LinkedListMultimap.NodeIterator nodeItr = new LinkedListMultimap.NodeIterator(param1Int);
        return new TransformedListIterator<Map.Entry<K, V>, V>(nodeIterator) {
            public void set(V param2V) {
              nodeItr.setValue(param2V);
            }
            
            V transform(Map.Entry<K, V> param2Entry) {
              return param2Entry.getValue();
            }
          };
      }
      
      public int size() {
        return LinkedListMultimap.this.size;
      }
    };
    return new ValuesImpl();
  }
  
  public List<Map.Entry<K, V>> entries() {
    return (List<Map.Entry<K, V>>)super.entries();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator() {
    throw new AssertionError("should never be called");
  }
  
  public List<V> get(@Nullable final K key) {
    return new AbstractSequentialList<V>() {
        public ListIterator<V> listIterator(int param1Int) {
          return new LinkedListMultimap.ValueForKeyIterator(key, param1Int);
        }
        
        public int size() {
          int i;
          LinkedListMultimap.KeyList keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.this.keyToKeyList.get(key);
          if (keyList == null) {
            i = 0;
          } else {
            i = keyList.count;
          } 
          return i;
        }
      };
  }
  
  public boolean isEmpty() {
    boolean bool;
    if (this.head == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  @CanIgnoreReturnValue
  public boolean put(@Nullable K paramK, @Nullable V paramV) {
    addNode(paramK, paramV, null);
    return true;
  }
  
  @CanIgnoreReturnValue
  public List<V> removeAll(@Nullable Object paramObject) {
    List<V> list = getCopy(paramObject);
    removeAllNodes(paramObject);
    return list;
  }
  
  @CanIgnoreReturnValue
  public List<V> replaceValues(@Nullable K paramK, Iterable<? extends V> paramIterable) {
    List<V> list = getCopy(paramK);
    ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(paramK);
    Iterator<? extends V> iterator = paramIterable.iterator();
    while (valueForKeyIterator.hasNext() && iterator.hasNext()) {
      valueForKeyIterator.next();
      valueForKeyIterator.set(iterator.next());
    } 
    while (valueForKeyIterator.hasNext()) {
      valueForKeyIterator.next();
      valueForKeyIterator.remove();
    } 
    while (iterator.hasNext())
      valueForKeyIterator.add(iterator.next()); 
    return list;
  }
  
  public int size() {
    return this.size;
  }
  
  public List<V> values() {
    return (List<V>)super.values();
  }
  
  private class DistinctKeyIterator implements Iterator<K> {
    LinkedListMultimap.Node<K, V> current;
    
    int expectedModCount = LinkedListMultimap.this.modCount;
    
    LinkedListMultimap.Node<K, V> next = LinkedListMultimap.this.head;
    
    final Set<K> seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
    
    private DistinctKeyIterator() {}
    
    private void checkForConcurrentModification() {
      if (LinkedListMultimap.this.modCount == this.expectedModCount)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext() {
      boolean bool;
      checkForConcurrentModification();
      if (this.next != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public K next() {
      LinkedListMultimap.Node<K, V> node;
      checkForConcurrentModification();
      LinkedListMultimap.checkElement(this.next);
      this.current = this.next;
      this.seenKeys.add(this.current.key);
      do {
        this.next = this.next.next;
        node = this.next;
      } while (node != null && !this.seenKeys.add(node.key));
      return this.current.key;
    }
    
    public void remove() {
      boolean bool;
      checkForConcurrentModification();
      if (this.current != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.checkRemove(bool);
      LinkedListMultimap.this.removeAllNodes(this.current.key);
      this.current = null;
      this.expectedModCount = LinkedListMultimap.this.modCount;
    }
  }
  
  private static class KeyList<K, V> {
    int count;
    
    LinkedListMultimap.Node<K, V> head;
    
    LinkedListMultimap.Node<K, V> tail;
    
    KeyList(LinkedListMultimap.Node<K, V> param1Node) {
      this.head = param1Node;
      this.tail = param1Node;
      param1Node.previousSibling = null;
      param1Node.nextSibling = null;
      this.count = 1;
    }
  }
  
  private static final class Node<K, V> extends AbstractMapEntry<K, V> {
    final K key;
    
    Node<K, V> next;
    
    Node<K, V> nextSibling;
    
    Node<K, V> previous;
    
    Node<K, V> previousSibling;
    
    V value;
    
    Node(@Nullable K param1K, @Nullable V param1V) {
      this.key = param1K;
      this.value = param1V;
    }
    
    public K getKey() {
      return this.key;
    }
    
    public V getValue() {
      return this.value;
    }
    
    public V setValue(@Nullable V param1V) {
      V v = this.value;
      this.value = param1V;
      return v;
    }
  }
  
  private class NodeIterator implements ListIterator<Map.Entry<K, V>> {
    LinkedListMultimap.Node<K, V> current;
    
    int expectedModCount = LinkedListMultimap.this.modCount;
    
    LinkedListMultimap.Node<K, V> next;
    
    int nextIndex;
    
    LinkedListMultimap.Node<K, V> previous;
    
    NodeIterator(int param1Int) {
      int i = LinkedListMultimap.this.size();
      Preconditions.checkPositionIndex(param1Int, i);
      if (param1Int >= i / 2) {
        this.previous = LinkedListMultimap.this.tail;
        this.nextIndex = i;
        while (param1Int < i) {
          previous();
          param1Int++;
        } 
      } else {
        this.next = LinkedListMultimap.this.head;
        while (param1Int > 0) {
          next();
          param1Int--;
        } 
      } 
      this.current = null;
    }
    
    private void checkForConcurrentModification() {
      if (LinkedListMultimap.this.modCount == this.expectedModCount)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public void add(Map.Entry<K, V> param1Entry) {
      throw new UnsupportedOperationException();
    }
    
    public boolean hasNext() {
      boolean bool;
      checkForConcurrentModification();
      if (this.next != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPrevious() {
      boolean bool;
      checkForConcurrentModification();
      if (this.previous != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @CanIgnoreReturnValue
    public LinkedListMultimap.Node<K, V> next() {
      checkForConcurrentModification();
      LinkedListMultimap.checkElement(this.next);
      LinkedListMultimap.Node<K, V> node = this.next;
      this.current = node;
      this.previous = node;
      this.next = node.next;
      this.nextIndex++;
      return this.current;
    }
    
    public int nextIndex() {
      return this.nextIndex;
    }
    
    @CanIgnoreReturnValue
    public LinkedListMultimap.Node<K, V> previous() {
      checkForConcurrentModification();
      LinkedListMultimap.checkElement(this.previous);
      LinkedListMultimap.Node<K, V> node = this.previous;
      this.current = node;
      this.next = node;
      this.previous = node.previous;
      this.nextIndex--;
      return this.current;
    }
    
    public int previousIndex() {
      return this.nextIndex - 1;
    }
    
    public void remove() {
      boolean bool;
      checkForConcurrentModification();
      if (this.current != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.checkRemove(bool);
      LinkedListMultimap.Node<K, V> node = this.current;
      if (node != this.next) {
        this.previous = node.previous;
        this.nextIndex--;
      } else {
        this.next = node.next;
      } 
      LinkedListMultimap.this.removeNode(this.current);
      this.current = null;
      this.expectedModCount = LinkedListMultimap.this.modCount;
    }
    
    public void set(Map.Entry<K, V> param1Entry) {
      throw new UnsupportedOperationException();
    }
    
    void setValue(V param1V) {
      boolean bool;
      if (this.current != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      this.current.value = param1V;
    }
  }
  
  private class ValueForKeyIterator implements ListIterator<V> {
    LinkedListMultimap.Node<K, V> current;
    
    final Object key;
    
    LinkedListMultimap.Node<K, V> next;
    
    int nextIndex;
    
    LinkedListMultimap.Node<K, V> previous;
    
    ValueForKeyIterator(Object param1Object) {
      LinkedListMultimap.Node<K, V> node;
      this.key = param1Object;
      LinkedListMultimap.KeyList keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.this.keyToKeyList.get(param1Object);
      if (keyList == null) {
        keyList = null;
      } else {
        node = keyList.head;
      } 
      this.next = node;
    }
    
    public ValueForKeyIterator(Object param1Object, int param1Int) {
      LinkedListMultimap.Node<K, V> node;
      int i;
      LinkedListMultimap.KeyList keyList = (LinkedListMultimap.KeyList)LinkedListMultimap.this.keyToKeyList.get(param1Object);
      if (keyList == null) {
        i = 0;
      } else {
        i = keyList.count;
      } 
      Preconditions.checkPositionIndex(param1Int, i);
      if (param1Int >= i / 2) {
        if (keyList == null) {
          keyList = null;
        } else {
          node = keyList.tail;
        } 
        this.previous = node;
        this.nextIndex = i;
        while (param1Int < i) {
          previous();
          param1Int++;
        } 
      } else {
        if (node == null) {
          node = null;
        } else {
          node = ((LinkedListMultimap.KeyList)node).head;
        } 
        this.next = node;
        while (param1Int > 0) {
          next();
          param1Int--;
        } 
      } 
      this.key = param1Object;
      this.current = null;
    }
    
    public void add(V param1V) {
      this.previous = LinkedListMultimap.this.addNode((K)this.key, param1V, this.next);
      this.nextIndex++;
      this.current = null;
    }
    
    public boolean hasNext() {
      boolean bool;
      if (this.next != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    public boolean hasPrevious() {
      boolean bool;
      if (this.previous != null) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    @CanIgnoreReturnValue
    public V next() {
      LinkedListMultimap.checkElement(this.next);
      LinkedListMultimap.Node<K, V> node = this.next;
      this.current = node;
      this.previous = node;
      this.next = node.nextSibling;
      this.nextIndex++;
      return this.current.value;
    }
    
    public int nextIndex() {
      return this.nextIndex;
    }
    
    @CanIgnoreReturnValue
    public V previous() {
      LinkedListMultimap.checkElement(this.previous);
      LinkedListMultimap.Node<K, V> node = this.previous;
      this.current = node;
      this.next = node;
      this.previous = node.previousSibling;
      this.nextIndex--;
      return this.current.value;
    }
    
    public int previousIndex() {
      return this.nextIndex - 1;
    }
    
    public void remove() {
      boolean bool;
      if (this.current != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.checkRemove(bool);
      LinkedListMultimap.Node<K, V> node = this.current;
      if (node != this.next) {
        this.previous = node.previousSibling;
        this.nextIndex--;
      } else {
        this.next = node.nextSibling;
      } 
      LinkedListMultimap.this.removeNode(this.current);
      this.current = null;
    }
    
    public void set(V param1V) {
      boolean bool;
      if (this.current != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool);
      this.current.value = param1V;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\LinkedListMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */