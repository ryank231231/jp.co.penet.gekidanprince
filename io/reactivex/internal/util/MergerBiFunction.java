package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
  final Comparator<? super T> comparator;
  
  public MergerBiFunction(Comparator<? super T> paramComparator) {
    this.comparator = paramComparator;
  }
  
  public List<T> apply(List<T> paramList1, List<T> paramList2) throws Exception {
    int i = paramList1.size() + paramList2.size();
    if (i == 0)
      return new ArrayList<T>(); 
    ArrayList<List<T>> arrayList = new ArrayList(i);
    Iterator<T> iterator1 = paramList1.iterator();
    Iterator<T> iterator2 = paramList2.iterator();
    if (iterator1.hasNext()) {
      paramList2 = (List<T>)iterator1.next();
    } else {
      paramList2 = null;
    } 
    if (iterator2.hasNext()) {
      paramList1 = (List<T>)iterator2.next();
    } else {
      paramList1 = null;
    } 
    while (paramList2 != null && paramList1 != null) {
      if (this.comparator.compare((T)paramList2, (T)paramList1) < 0) {
        arrayList.add(paramList2);
        if (iterator1.hasNext()) {
          paramList2 = (List<T>)iterator1.next();
          continue;
        } 
        paramList2 = null;
        continue;
      } 
      arrayList.add(paramList1);
      if (iterator2.hasNext()) {
        paramList1 = (List<T>)iterator2.next();
        continue;
      } 
      paramList1 = null;
    } 
    if (paramList2 != null) {
      arrayList.add(paramList2);
      while (iterator1.hasNext())
        arrayList.add((List<T>)iterator1.next()); 
    } else {
      arrayList.add(paramList1);
      while (iterator2.hasNext())
        arrayList.add((List<T>)iterator2.next()); 
    } 
    return (List)arrayList;
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\reactivex\interna\\util\MergerBiFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */