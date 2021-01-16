package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {
  abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
    private List<Optional<V>> values;
    
    CollectionFutureRunningState(ImmutableCollection<? extends ListenableFuture<? extends V>> param1ImmutableCollection, boolean param1Boolean) {
      super(param1ImmutableCollection, param1Boolean, true);
      ArrayList<Optional<V>> arrayList;
      if (param1ImmutableCollection.isEmpty()) {
        ImmutableList immutableList = ImmutableList.of();
      } else {
        arrayList = Lists.newArrayListWithCapacity(param1ImmutableCollection.size());
      } 
      this.values = arrayList;
      for (byte b = 0; b < param1ImmutableCollection.size(); b++)
        this.values.add(null); 
    }
    
    final void collectOneValue(boolean param1Boolean, int param1Int, @Nullable V param1V) {
      List<Optional<V>> list = this.values;
      if (list != null) {
        list.set(param1Int, Optional.fromNullable(param1V));
      } else {
        if (param1Boolean || CollectionFuture.this.isCancelled()) {
          param1Boolean = true;
        } else {
          param1Boolean = false;
        } 
        Preconditions.checkState(param1Boolean, "Future was done before all dependencies completed");
      } 
    }
    
    abstract C combine(List<Optional<V>> param1List);
    
    final void handleAllCompleted() {
      List<Optional<V>> list = this.values;
      if (list != null) {
        CollectionFuture.this.set(combine(list));
      } else {
        Preconditions.checkState(CollectionFuture.this.isDone());
      } 
    }
    
    void releaseResourcesAfterFailure() {
      super.releaseResourcesAfterFailure();
      this.values = null;
    }
  }
  
  static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
    ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> param1ImmutableCollection, boolean param1Boolean) {
      init(new ListFutureRunningState(param1ImmutableCollection, param1Boolean));
    }
    
    private final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
      ListFutureRunningState(ImmutableCollection<? extends ListenableFuture<? extends V>> param2ImmutableCollection, boolean param2Boolean) {
        super(param2ImmutableCollection, param2Boolean);
      }
      
      public List<V> combine(List<Optional<V>> param2List) {
        ArrayList<Optional> arrayList = Lists.newArrayListWithCapacity(param2List.size());
        for (Optional<V> optional : param2List) {
          if (optional != null) {
            Object object = optional.orNull();
          } else {
            optional = null;
          } 
          arrayList.add(optional);
        } 
        return Collections.unmodifiableList((List)arrayList);
      }
    }
  }
  
  private final class ListFutureRunningState extends CollectionFutureRunningState {
    ListFutureRunningState(ImmutableCollection<? extends ListenableFuture<? extends V>> param1ImmutableCollection, boolean param1Boolean) {
      super(param1ImmutableCollection, param1Boolean);
    }
    
    public List<V> combine(List<Optional<V>> param1List) {
      ArrayList<Optional> arrayList = Lists.newArrayListWithCapacity(param1List.size());
      for (Optional<V> optional : param1List) {
        if (optional != null) {
          Object object = optional.orNull();
        } else {
          optional = null;
        } 
        arrayList.add(optional);
      } 
      return Collections.unmodifiableList((List)arrayList);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\CollectionFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */