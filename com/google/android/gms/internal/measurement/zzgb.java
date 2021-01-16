package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzgb<K, V> extends LinkedHashMap<K, V> {
  private static final zzgb zzaiv;
  
  private boolean zzabp = true;
  
  static {
    zzgb zzgb1 = new zzgb();
    zzaiv = zzgb1;
    zzgb1.zzabp = false;
  }
  
  private zzgb() {}
  
  private zzgb(Map<K, V> paramMap) {
    super(paramMap);
  }
  
  private static int zzl(Object paramObject) {
    if (paramObject instanceof byte[])
      return zzfb.hashCode((byte[])paramObject); 
    if (!(paramObject instanceof zzfc))
      return paramObject.hashCode(); 
    throw new UnsupportedOperationException();
  }
  
  public static <K, V> zzgb<K, V> zznm() {
    return zzaiv;
  }
  
  private final void zzno() {
    if (this.zzabp)
      return; 
    throw new UnsupportedOperationException();
  }
  
  public final void clear() {
    zzno();
    super.clear();
  }
  
  public final Set<Map.Entry<K, V>> entrySet() {
    return isEmpty() ? Collections.emptySet() : super.entrySet();
  }
  
  public final boolean equals(Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof java/util/Map
    //   4: ifeq -> 175
    //   7: aload_1
    //   8: checkcast java/util/Map
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: if_acmpeq -> 167
    //   17: aload_0
    //   18: invokeinterface size : ()I
    //   23: aload_1
    //   24: invokeinterface size : ()I
    //   29: if_icmpeq -> 37
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -> 169
    //   37: aload_0
    //   38: invokeinterface entrySet : ()Ljava/util/Set;
    //   43: invokeinterface iterator : ()Ljava/util/Iterator;
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface hasNext : ()Z
    //   55: ifeq -> 167
    //   58: aload_3
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: checkcast java/util/Map$Entry
    //   67: astore #4
    //   69: aload_1
    //   70: aload #4
    //   72: invokeinterface getKey : ()Ljava/lang/Object;
    //   77: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   82: ifne -> 90
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -> 169
    //   90: aload #4
    //   92: invokeinterface getValue : ()Ljava/lang/Object;
    //   97: astore #5
    //   99: aload_1
    //   100: aload #4
    //   102: invokeinterface getKey : ()Ljava/lang/Object;
    //   107: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   112: astore #4
    //   114: aload #5
    //   116: instanceof [B
    //   119: ifeq -> 148
    //   122: aload #4
    //   124: instanceof [B
    //   127: ifeq -> 148
    //   130: aload #5
    //   132: checkcast [B
    //   135: aload #4
    //   137: checkcast [B
    //   140: invokestatic equals : ([B[B)Z
    //   143: istore #6
    //   145: goto -> 157
    //   148: aload #5
    //   150: aload #4
    //   152: invokevirtual equals : (Ljava/lang/Object;)Z
    //   155: istore #6
    //   157: iload #6
    //   159: ifne -> 49
    //   162: iconst_0
    //   163: istore_2
    //   164: goto -> 169
    //   167: iconst_1
    //   168: istore_2
    //   169: iload_2
    //   170: ifeq -> 175
    //   173: iconst_1
    //   174: ireturn
    //   175: iconst_0
    //   176: ireturn
  }
  
  public final int hashCode() {
    Iterator<Map.Entry> iterator = super.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += zzl(entry.getValue()) ^ j) {
      Map.Entry entry = iterator.next();
      int j = zzl(entry.getKey());
    } 
    return i;
  }
  
  public final boolean isMutable() {
    return this.zzabp;
  }
  
  public final V put(K paramK, V paramV) {
    zzno();
    zzfb.checkNotNull(paramK);
    zzfb.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap) {
    zzno();
    for (K k : paramMap.keySet()) {
      zzfb.checkNotNull(k);
      zzfb.checkNotNull(paramMap.get(k));
    } 
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject) {
    zzno();
    return super.remove(paramObject);
  }
  
  public final void zza(zzgb<K, V> paramzzgb) {
    zzno();
    if (!paramzzgb.isEmpty())
      putAll(paramzzgb); 
  }
  
  public final void zzjz() {
    this.zzabp = false;
  }
  
  public final zzgb<K, V> zznn() {
    return isEmpty() ? new zzgb() : new zzgb(this);
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\measurement\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */