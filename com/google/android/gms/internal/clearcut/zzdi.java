package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzdi<K, V> extends LinkedHashMap<K, V> {
  private static final zzdi zzme;
  
  private boolean zzfa = true;
  
  static {
    zzdi zzdi1 = new zzdi();
    zzme = zzdi1;
    zzdi1.zzfa = false;
  }
  
  private zzdi() {}
  
  private zzdi(Map<K, V> paramMap) {
    super(paramMap);
  }
  
  public static <K, V> zzdi<K, V> zzbz() {
    return zzme;
  }
  
  private final void zzcb() {
    if (this.zzfa)
      return; 
    throw new UnsupportedOperationException();
  }
  
  private static int zzf(Object paramObject) {
    if (paramObject instanceof byte[])
      return zzci.hashCode((byte[])paramObject); 
    if (!(paramObject instanceof zzcj))
      return paramObject.hashCode(); 
    throw new UnsupportedOperationException();
  }
  
  public final void clear() {
    zzcb();
    super.clear();
  }
  
  public final Set<Map.Entry<K, V>> entrySet() {
    return isEmpty() ? Collections.emptySet() : super.entrySet();
  }
  
  public final boolean equals(Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: instanceof java/util/Map
    //   4: ifeq -> 171
    //   7: aload_1
    //   8: checkcast java/util/Map
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: if_acmpeq -> 163
    //   17: aload_0
    //   18: invokeinterface size : ()I
    //   23: aload_1
    //   24: invokeinterface size : ()I
    //   29: if_icmpeq -> 37
    //   32: iconst_0
    //   33: istore_2
    //   34: goto -> 165
    //   37: aload_0
    //   38: invokeinterface entrySet : ()Ljava/util/Set;
    //   43: invokeinterface iterator : ()Ljava/util/Iterator;
    //   48: astore_3
    //   49: aload_3
    //   50: invokeinterface hasNext : ()Z
    //   55: ifeq -> 163
    //   58: aload_3
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: checkcast java/util/Map$Entry
    //   67: astore #4
    //   69: aload_1
    //   70: aload #4
    //   72: invokeinterface getKey : ()Ljava/lang/Object;
    //   77: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   82: ifne -> 88
    //   85: goto -> 32
    //   88: aload #4
    //   90: invokeinterface getValue : ()Ljava/lang/Object;
    //   95: astore #5
    //   97: aload_1
    //   98: aload #4
    //   100: invokeinterface getKey : ()Ljava/lang/Object;
    //   105: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   110: astore #4
    //   112: aload #5
    //   114: instanceof [B
    //   117: ifeq -> 146
    //   120: aload #4
    //   122: instanceof [B
    //   125: ifeq -> 146
    //   128: aload #5
    //   130: checkcast [B
    //   133: aload #4
    //   135: checkcast [B
    //   138: invokestatic equals : ([B[B)Z
    //   141: istore #6
    //   143: goto -> 155
    //   146: aload #5
    //   148: aload #4
    //   150: invokevirtual equals : (Ljava/lang/Object;)Z
    //   153: istore #6
    //   155: iload #6
    //   157: ifne -> 49
    //   160: goto -> 32
    //   163: iconst_1
    //   164: istore_2
    //   165: iload_2
    //   166: ifeq -> 171
    //   169: iconst_1
    //   170: ireturn
    //   171: iconst_0
    //   172: ireturn
  }
  
  public final int hashCode() {
    Iterator<Map.Entry> iterator = super.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += zzf(entry.getValue()) ^ j) {
      Map.Entry entry = iterator.next();
      int j = zzf(entry.getKey());
    } 
    return i;
  }
  
  public final boolean isMutable() {
    return this.zzfa;
  }
  
  public final V put(K paramK, V paramV) {
    zzcb();
    zzci.checkNotNull(paramK);
    zzci.checkNotNull(paramV);
    return super.put(paramK, paramV);
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap) {
    zzcb();
    for (K k : paramMap.keySet()) {
      zzci.checkNotNull(k);
      zzci.checkNotNull(paramMap.get(k));
    } 
    super.putAll(paramMap);
  }
  
  public final V remove(Object paramObject) {
    zzcb();
    return super.remove(paramObject);
  }
  
  public final void zza(zzdi<K, V> paramzzdi) {
    zzcb();
    if (!paramzzdi.isEmpty())
      putAll(paramzzdi); 
  }
  
  public final zzdi<K, V> zzca() {
    return isEmpty() ? new zzdi() : new zzdi(this);
  }
  
  public final void zzv() {
    this.zzfa = false;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\android\gms\internal\clearcut\zzdi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */