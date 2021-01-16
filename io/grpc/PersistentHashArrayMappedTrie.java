package io.grpc;

import java.util.Arrays;

final class PersistentHashArrayMappedTrie<K, V> {
  private final Node<K, V> root;
  
  PersistentHashArrayMappedTrie() {
    this(null);
  }
  
  private PersistentHashArrayMappedTrie(Node<K, V> paramNode) {
    this.root = paramNode;
  }
  
  public V get(K paramK) {
    Node<K, V> node = this.root;
    return (node == null) ? null : node.get(paramK, paramK.hashCode(), 0);
  }
  
  public PersistentHashArrayMappedTrie<K, V> put(K paramK, V paramV) {
    Node<K, V> node = this.root;
    return (node == null) ? new PersistentHashArrayMappedTrie(new Leaf<K, V>(paramK, paramV)) : new PersistentHashArrayMappedTrie(node.put(paramK, paramV, paramK.hashCode(), 0));
  }
  
  public int size() {
    Node<K, V> node = this.root;
    return (node == null) ? 0 : node.size();
  }
  
  static final class CollisionLeaf<K, V> implements Node<K, V> {
    private final K[] keys;
    
    private final V[] values;
    
    CollisionLeaf(K param1K1, V param1V1, K param1K2, V param1V2) {
      this((K[])new Object[] { param1K1, param1K2 }, (V[])new Object[] { param1V1, param1V2 });
    }
    
    private CollisionLeaf(K[] param1ArrayOfK, V[] param1ArrayOfV) {
      this.keys = param1ArrayOfK;
      this.values = param1ArrayOfV;
    }
    
    private int indexOfKey(K param1K) {
      byte b = 0;
      while (true) {
        K[] arrayOfK = this.keys;
        if (b < arrayOfK.length) {
          if (arrayOfK[b] == param1K)
            return b; 
          b++;
          continue;
        } 
        return -1;
      } 
    }
    
    public V get(K param1K, int param1Int1, int param1Int2) {
      param1Int1 = 0;
      while (true) {
        K[] arrayOfK = this.keys;
        if (param1Int1 < arrayOfK.length) {
          if (arrayOfK[param1Int1] == param1K)
            return this.values[param1Int1]; 
          param1Int1++;
          continue;
        } 
        return null;
      } 
    }
    
    public PersistentHashArrayMappedTrie.Node<K, V> put(K param1K, V param1V, int param1Int1, int param1Int2) {
      int i = this.keys[0].hashCode();
      if (i != param1Int1)
        return PersistentHashArrayMappedTrie.CompressedIndex.combine(new PersistentHashArrayMappedTrie.Leaf<K, V>(param1K, param1V), param1Int1, this, i, param1Int2); 
      param1Int1 = indexOfKey(param1K);
      if (param1Int1 != -1) {
        K[] arrayOfK = this.keys;
        Object[] arrayOfObject1 = Arrays.copyOf((Object[])arrayOfK, arrayOfK.length);
        arrayOfK = Arrays.copyOf((K[])this.values, this.keys.length);
        arrayOfObject1[param1Int1] = param1K;
        arrayOfK[param1Int1] = (K)param1V;
        return new CollisionLeaf((K[])arrayOfObject1, (V[])arrayOfK);
      } 
      K[] arrayOfK1 = this.keys;
      arrayOfK1 = Arrays.copyOf(arrayOfK1, arrayOfK1.length + 1);
      Object[] arrayOfObject = Arrays.copyOf((Object[])this.values, this.keys.length + 1);
      K[] arrayOfK2 = this.keys;
      arrayOfK1[arrayOfK2.length] = param1K;
      arrayOfObject[arrayOfK2.length] = param1V;
      return new CollisionLeaf(arrayOfK1, (V[])arrayOfObject);
    }
    
    public int size() {
      return this.values.length;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CollisionLeaf(");
      for (byte b = 0; b < this.values.length; b++) {
        stringBuilder.append("(key=");
        stringBuilder.append(this.keys[b]);
        stringBuilder.append(" value=");
        stringBuilder.append(this.values[b]);
        stringBuilder.append(") ");
      } 
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class CompressedIndex<K, V> implements Node<K, V> {
    private static final int BITS = 5;
    
    private static final int BITS_MASK = 31;
    
    final int bitmap;
    
    private final int size;
    
    final PersistentHashArrayMappedTrie.Node<K, V>[] values;
    
    private CompressedIndex(int param1Int1, PersistentHashArrayMappedTrie.Node<K, V>[] param1ArrayOfNode, int param1Int2) {
      this.bitmap = param1Int1;
      this.values = param1ArrayOfNode;
      this.size = param1Int2;
    }
    
    static <K, V> PersistentHashArrayMappedTrie.Node<K, V> combine(PersistentHashArrayMappedTrie.Node<K, V> param1Node1, int param1Int1, PersistentHashArrayMappedTrie.Node<K, V> param1Node2, int param1Int2, int param1Int3) {
      int i = indexBit(param1Int1, param1Int3);
      int j = indexBit(param1Int2, param1Int3);
      if (i == j) {
        param1Node1 = combine(param1Node1, param1Int1, param1Node2, param1Int2, param1Int3 + 5);
        param1Int1 = param1Node1.size();
        return new CompressedIndex<K, V>(i, (PersistentHashArrayMappedTrie.Node<K, V>[])new PersistentHashArrayMappedTrie.Node[] { param1Node1 }, param1Int1);
      } 
      PersistentHashArrayMappedTrie.Node<K, V> node1 = param1Node1;
      PersistentHashArrayMappedTrie.Node<K, V> node2 = param1Node2;
      if (uncompressedIndex(param1Int1, param1Int3) > uncompressedIndex(param1Int2, param1Int3)) {
        node2 = param1Node1;
        node1 = param1Node2;
      } 
      param1Int2 = node1.size();
      param1Int1 = node2.size();
      return new CompressedIndex<K, V>(i | j, (PersistentHashArrayMappedTrie.Node<K, V>[])new PersistentHashArrayMappedTrie.Node[] { node1, node2 }, param1Int2 + param1Int1);
    }
    
    private int compressedIndex(int param1Int) {
      return Integer.bitCount(param1Int - 1 & this.bitmap);
    }
    
    private static int indexBit(int param1Int1, int param1Int2) {
      return 1 << uncompressedIndex(param1Int1, param1Int2);
    }
    
    private static int uncompressedIndex(int param1Int1, int param1Int2) {
      return param1Int1 >>> param1Int2 & 0x1F;
    }
    
    public V get(K param1K, int param1Int1, int param1Int2) {
      int i = indexBit(param1Int1, param1Int2);
      if ((this.bitmap & i) == 0)
        return null; 
      i = compressedIndex(i);
      return this.values[i].get(param1K, param1Int1, param1Int2 + 5);
    }
    
    public PersistentHashArrayMappedTrie.Node<K, V> put(K param1K, V param1V, int param1Int1, int param1Int2) {
      PersistentHashArrayMappedTrie.Node<K, V>[] arrayOfNode1;
      int i = indexBit(param1Int1, param1Int2);
      int j = compressedIndex(i);
      int k = this.bitmap;
      if ((k & i) == 0) {
        PersistentHashArrayMappedTrie.Node<K, V>[] arrayOfNode3 = this.values;
        PersistentHashArrayMappedTrie.Node[] arrayOfNode4 = new PersistentHashArrayMappedTrie.Node[arrayOfNode3.length + 1];
        System.arraycopy(arrayOfNode3, 0, arrayOfNode4, 0, j);
        arrayOfNode4[j] = new PersistentHashArrayMappedTrie.Leaf<K, V>(param1K, param1V);
        arrayOfNode1 = this.values;
        System.arraycopy(arrayOfNode1, j, arrayOfNode4, j + 1, arrayOfNode1.length - j);
        return new CompressedIndex(k | i, (PersistentHashArrayMappedTrie.Node<K, V>[])arrayOfNode4, size() + 1);
      } 
      PersistentHashArrayMappedTrie.Node<K, V>[] arrayOfNode2 = this.values;
      PersistentHashArrayMappedTrie.Node[] arrayOfNode = Arrays.<PersistentHashArrayMappedTrie.Node>copyOf((PersistentHashArrayMappedTrie.Node[])arrayOfNode2, arrayOfNode2.length);
      arrayOfNode[j] = this.values[j].put((K)arrayOfNode1, param1V, param1Int1, param1Int2 + 5);
      param1Int1 = size();
      param1Int2 = arrayOfNode[j].size();
      j = this.values[j].size();
      return new CompressedIndex(this.bitmap, (PersistentHashArrayMappedTrie.Node<K, V>[])arrayOfNode, param1Int1 + param1Int2 - j);
    }
    
    public int size() {
      return this.size;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CompressedIndex(");
      String str = Integer.toBinaryString(this.bitmap);
      byte b = 0;
      stringBuilder.append(String.format("bitmap=%s ", new Object[] { str }));
      PersistentHashArrayMappedTrie.Node<K, V>[] arrayOfNode = this.values;
      int i = arrayOfNode.length;
      while (b < i) {
        stringBuilder.append(arrayOfNode[b]);
        stringBuilder.append(" ");
        b++;
      } 
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class Leaf<K, V> implements Node<K, V> {
    private final K key;
    
    private final V value;
    
    public Leaf(K param1K, V param1V) {
      this.key = param1K;
      this.value = param1V;
    }
    
    public V get(K param1K, int param1Int1, int param1Int2) {
      return (this.key == param1K) ? this.value : null;
    }
    
    public PersistentHashArrayMappedTrie.Node<K, V> put(K param1K, V param1V, int param1Int1, int param1Int2) {
      int i = this.key.hashCode();
      if (i != param1Int1)
        return PersistentHashArrayMappedTrie.CompressedIndex.combine(new Leaf(param1K, param1V), param1Int1, this, i, param1Int2); 
      K k = this.key;
      return (PersistentHashArrayMappedTrie.Node<K, V>)((k == param1K) ? new Leaf(param1K, param1V) : new PersistentHashArrayMappedTrie.CollisionLeaf<K, V>(k, this.value, param1K, param1V));
    }
    
    public int size() {
      return 1;
    }
    
    public String toString() {
      return String.format("Leaf(key=%s value=%s)", new Object[] { this.key, this.value });
    }
  }
  
  static interface Node<K, V> {
    V get(K param1K, int param1Int1, int param1Int2);
    
    Node<K, V> put(K param1K, V param1V, int param1Int1, int param1Int2);
    
    int size();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\PersistentHashArrayMappedTrie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */