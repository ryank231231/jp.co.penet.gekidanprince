package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
  private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
  
  private RunningState runningState;
  
  private static boolean addCausalChain(Set<Throwable> paramSet, Throwable paramThrowable) {
    while (paramThrowable != null) {
      if (!paramSet.add(paramThrowable))
        return false; 
      paramThrowable = paramThrowable.getCause();
    } 
    return true;
  }
  
  protected final void afterDone() {
    super.afterDone();
    RunningState runningState = this.runningState;
    if (runningState != null) {
      boolean bool3;
      this.runningState = null;
      ImmutableCollection immutableCollection = runningState.futures;
      boolean bool1 = wasInterrupted();
      if (wasInterrupted())
        runningState.interruptTask(); 
      boolean bool2 = isCancelled();
      if (immutableCollection != null) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (bool2 & bool3) {
        Iterator<ListenableFuture> iterator = immutableCollection.iterator();
        while (iterator.hasNext())
          ((ListenableFuture)iterator.next()).cancel(bool1); 
      } 
    } 
  }
  
  final void init(RunningState paramRunningState) {
    this.runningState = paramRunningState;
    paramRunningState.init();
  }
  
  abstract class RunningState extends AggregateFutureState implements Runnable {
    private final boolean allMustSucceed;
    
    private final boolean collectsValues;
    
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;
    
    RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> param1ImmutableCollection, boolean param1Boolean1, boolean param1Boolean2) {
      super(param1ImmutableCollection.size());
      this.futures = (ImmutableCollection<? extends ListenableFuture<? extends InputT>>)Preconditions.checkNotNull(param1ImmutableCollection);
      this.allMustSucceed = param1Boolean1;
      this.collectsValues = param1Boolean2;
    }
    
    private void decrementCountAndMaybeComplete() {
      boolean bool;
      int i = decrementRemainingAndGet();
      if (i >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Less than 0 remaining futures");
      if (i == 0)
        processCompleted(); 
    }
    
    private void handleException(Throwable param1Throwable) {
      boolean bool;
      Preconditions.checkNotNull(param1Throwable);
      boolean bool1 = this.allMustSucceed;
      boolean bool2 = true;
      if (bool1) {
        bool = AggregateFuture.this.setException(param1Throwable);
        if (bool) {
          releaseResourcesAfterFailure();
          bool1 = true;
        } else {
          bool1 = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), param1Throwable);
        } 
      } else {
        bool = false;
        bool1 = true;
      } 
      boolean bool3 = param1Throwable instanceof Error;
      boolean bool4 = this.allMustSucceed;
      if (bool)
        bool2 = false; 
      if (bool4 & bool2 & bool1 | bool3) {
        String str;
        if (bool3) {
          str = "Input Future failed with Error";
        } else {
          str = "Got more than one input Future failure. Logging failures after the first";
        } 
        AggregateFuture.logger.log(Level.SEVERE, str, param1Throwable);
      } 
    }
    
    private void handleOneInputDone(int param1Int, Future<? extends InputT> param1Future) {
      boolean bool;
      if (this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled()) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Future was done before all dependencies completed");
      try {
        Preconditions.checkState(param1Future.isDone(), "Tried to set value from future which is not done");
        if (this.allMustSucceed) {
          if (param1Future.isCancelled()) {
            AggregateFuture.access$602(AggregateFuture.this, (RunningState)null);
            AggregateFuture.this.cancel(false);
          } else {
            param1Future = Futures.getDone((Future)param1Future);
            if (this.collectsValues)
              collectOneValue(this.allMustSucceed, param1Int, (InputT)param1Future); 
          } 
        } else if (this.collectsValues && !param1Future.isCancelled()) {
          collectOneValue(this.allMustSucceed, param1Int, Futures.getDone((Future)param1Future));
        } 
      } catch (ExecutionException executionException) {
        handleException(executionException.getCause());
      } catch (Throwable throwable) {
        handleException(throwable);
      } 
    }
    
    private void init() {
      if (this.futures.isEmpty()) {
        handleAllCompleted();
        return;
      } 
      if (this.allMustSucceed) {
        final byte index = 0;
        for (ListenableFuture<? extends InputT> listenableFuture : this.futures) {
          listenableFuture.addListener(new Runnable() {
                public void run() {
                  try {
                    AggregateFuture.RunningState.this.handleOneInputDone(index, listenable);
                    return;
                  } finally {
                    AggregateFuture.RunningState.this.decrementCountAndMaybeComplete();
                  } 
                }
              }MoreExecutors.directExecutor());
          b++;
        } 
      } else {
        Iterator<ListenableFuture> iterator = this.futures.iterator();
        while (iterator.hasNext())
          ((ListenableFuture)iterator.next()).addListener(this, MoreExecutors.directExecutor()); 
      } 
    }
    
    private void processCompleted() {
      if ((this.collectsValues & (this.allMustSucceed ^ true)) != 0) {
        byte b = 0;
        Iterator<ListenableFuture> iterator = this.futures.iterator();
        while (iterator.hasNext()) {
          handleOneInputDone(b, iterator.next());
          b++;
        } 
      } 
      handleAllCompleted();
    }
    
    final void addInitialException(Set<Throwable> param1Set) {
      if (!AggregateFuture.this.isCancelled())
        AggregateFuture.addCausalChain(param1Set, AggregateFuture.this.trustedGetException()); 
    }
    
    abstract void collectOneValue(boolean param1Boolean, int param1Int, @Nullable InputT param1InputT);
    
    abstract void handleAllCompleted();
    
    void interruptTask() {}
    
    void releaseResourcesAfterFailure() {
      this.futures = null;
    }
    
    public final void run() {
      decrementCountAndMaybeComplete();
    }
  }
  
  class null implements Runnable {
    public void run() {
      try {
        this.this$1.handleOneInputDone(index, listenable);
        return;
      } finally {
        this.this$1.decrementCountAndMaybeComplete();
      } 
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AggregateFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */