package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;

@Beta
@GwtIncompatible
public abstract class AbstractService implements Service {
  private static final ListenerCallQueue.Callback<Service.Listener> RUNNING_CALLBACK;
  
  private static final ListenerCallQueue.Callback<Service.Listener> STARTING_CALLBACK = new ListenerCallQueue.Callback<Service.Listener>("starting()") {
      void call(Service.Listener param1Listener) {
        param1Listener.starting();
      }
    };
  
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_RUNNING_CALLBACK;
  
  private static final ListenerCallQueue.Callback<Service.Listener> STOPPING_FROM_STARTING_CALLBACK;
  
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_NEW_CALLBACK;
  
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_RUNNING_CALLBACK;
  
  private static final ListenerCallQueue.Callback<Service.Listener> TERMINATED_FROM_STOPPING_CALLBACK;
  
  private final Monitor.Guard hasReachedRunning = new HasReachedRunningGuard();
  
  private final Monitor.Guard isStartable = new IsStartableGuard();
  
  private final Monitor.Guard isStoppable = new IsStoppableGuard();
  
  private final Monitor.Guard isStopped = new IsStoppedGuard();
  
  @GuardedBy("monitor")
  private final List<ListenerCallQueue<Service.Listener>> listeners = Collections.synchronizedList(new ArrayList<ListenerCallQueue<Service.Listener>>());
  
  private final Monitor monitor = new Monitor();
  
  @GuardedBy("monitor")
  private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);
  
  static {
    RUNNING_CALLBACK = new ListenerCallQueue.Callback<Service.Listener>("running()") {
        void call(Service.Listener param1Listener) {
          param1Listener.running();
        }
      };
    STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service.State.STARTING);
    STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service.State.RUNNING);
    TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service.State.NEW);
    TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service.State.RUNNING);
    TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service.State.STOPPING);
  }
  
  @GuardedBy("monitor")
  private void checkCurrentState(Service.State paramState) {
    Service.State state = state();
    if (state != paramState) {
      if (state == Service.State.FAILED) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Expected the service ");
        stringBuilder1.append(this);
        stringBuilder1.append(" to be ");
        stringBuilder1.append(paramState);
        stringBuilder1.append(", but the service has FAILED");
        throw new IllegalStateException(stringBuilder1.toString(), failureCause());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected the service ");
      stringBuilder.append(this);
      stringBuilder.append(" to be ");
      stringBuilder.append(paramState);
      stringBuilder.append(", but was ");
      stringBuilder.append(state);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  private void executeListeners() {
    if (!this.monitor.isOccupiedByCurrentThread())
      for (byte b = 0; b < this.listeners.size(); b++)
        ((ListenerCallQueue)this.listeners.get(b)).execute();  
  }
  
  @GuardedBy("monitor")
  private void failed(final Service.State from, final Throwable cause) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("failed({from = ");
    stringBuilder.append(from);
    stringBuilder.append(", cause = ");
    stringBuilder.append(cause);
    stringBuilder.append("})");
    (new ListenerCallQueue.Callback<Service.Listener>(stringBuilder.toString()) {
        void call(Service.Listener param1Listener) {
          param1Listener.failed(from, cause);
        }
      }).enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void running() {
    RUNNING_CALLBACK.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void starting() {
    STARTING_CALLBACK.enqueueOn(this.listeners);
  }
  
  @GuardedBy("monitor")
  private void stopping(Service.State paramState) {
    if (paramState == Service.State.STARTING) {
      STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
    } else {
      if (paramState == Service.State.RUNNING) {
        STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
        return;
      } 
      throw new AssertionError();
    } 
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> stoppingCallback(final Service.State from) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopping({from = ");
    stringBuilder.append(from);
    stringBuilder.append("})");
    return new ListenerCallQueue.Callback<Service.Listener>(stringBuilder.toString()) {
        void call(Service.Listener param1Listener) {
          param1Listener.stopping(from);
        }
      };
  }
  
  @GuardedBy("monitor")
  private void terminated(Service.State paramState) {
    int i = null.$SwitchMap$com$google$common$util$concurrent$Service$State[paramState.ordinal()];
    if (i != 1) {
      switch (i) {
        default:
          throw new AssertionError();
        case 4:
          TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
          return;
        case 3:
          break;
      } 
      TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
    } else {
      TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
    } 
  }
  
  private static ListenerCallQueue.Callback<Service.Listener> terminatedCallback(final Service.State from) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("terminated({from = ");
    stringBuilder.append(from);
    stringBuilder.append("})");
    return new ListenerCallQueue.Callback<Service.Listener>(stringBuilder.toString()) {
        void call(Service.Listener param1Listener) {
          param1Listener.terminated(from);
        }
      };
  }
  
  public final void addListener(Service.Listener paramListener, Executor paramExecutor) {
    Preconditions.checkNotNull(paramListener, "listener");
    Preconditions.checkNotNull(paramExecutor, "executor");
    this.monitor.enter();
    try {
      if (!state().isTerminal()) {
        List<ListenerCallQueue<Service.Listener>> list = this.listeners;
        ListenerCallQueue<Service.Listener> listenerCallQueue = new ListenerCallQueue();
        this((L)paramListener, paramExecutor);
        list.add(listenerCallQueue);
      } 
      return;
    } finally {
      this.monitor.leave();
    } 
  }
  
  public final void awaitRunning() {
    this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
    try {
      checkCurrentState(Service.State.RUNNING);
      return;
    } finally {
      this.monitor.leave();
    } 
  }
  
  public final void awaitRunning(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
    if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, paramLong, paramTimeUnit))
      try {
        checkCurrentState(Service.State.RUNNING);
        return;
      } finally {
        this.monitor.leave();
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Timed out waiting for ");
    stringBuilder.append(this);
    stringBuilder.append(" to reach the RUNNING state.");
    throw new TimeoutException(stringBuilder.toString());
  }
  
  public final void awaitTerminated() {
    this.monitor.enterWhenUninterruptibly(this.isStopped);
    try {
      checkCurrentState(Service.State.TERMINATED);
      return;
    } finally {
      this.monitor.leave();
    } 
  }
  
  public final void awaitTerminated(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
    if (this.monitor.enterWhenUninterruptibly(this.isStopped, paramLong, paramTimeUnit))
      try {
        checkCurrentState(Service.State.TERMINATED);
        return;
      } finally {
        this.monitor.leave();
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Timed out waiting for ");
    stringBuilder.append(this);
    stringBuilder.append(" to reach a terminal state. ");
    stringBuilder.append("Current state: ");
    stringBuilder.append(state());
    throw new TimeoutException(stringBuilder.toString());
  }
  
  protected abstract void doStart();
  
  protected abstract void doStop();
  
  public final Throwable failureCause() {
    return this.snapshot.failureCause();
  }
  
  public final boolean isRunning() {
    boolean bool;
    if (state() == Service.State.RUNNING) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected final void notifyFailed(Throwable paramThrowable) {
    Preconditions.checkNotNull(paramThrowable);
    this.monitor.enter();
    try {
      StringBuilder stringBuilder1;
      AssertionError assertionError;
      StateSnapshot stateSnapshot;
      Service.State state = state();
      switch (state) {
        default:
          assertionError = new AssertionError();
          stringBuilder1 = new StringBuilder();
          this();
          stringBuilder1.append("Unexpected state: ");
          stringBuilder1.append(state);
          this(stringBuilder1.toString());
          throw assertionError;
        case STARTING:
        case RUNNING:
        case STOPPING:
          stateSnapshot = new StateSnapshot();
          this(Service.State.FAILED, false, (Throwable)stringBuilder1);
          this.snapshot = stateSnapshot;
          failed(state, (Throwable)stringBuilder1);
        case FAILED:
          return;
        case NEW:
        case TERMINATED:
          break;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      StringBuilder stringBuilder2 = new StringBuilder();
      this();
      stringBuilder2.append("Failed while in state:");
      stringBuilder2.append(state);
      this(stringBuilder2.toString(), (Throwable)stringBuilder1);
      throw illegalStateException;
    } finally {
      this.monitor.leave();
      executeListeners();
    } 
  }
  
  protected final void notifyStarted() {
    this.monitor.enter();
    try {
      if (this.snapshot.state == Service.State.STARTING) {
        if (this.snapshot.shutdownWhenStartupFinishes) {
          StateSnapshot stateSnapshot = new StateSnapshot();
          this(Service.State.STOPPING);
          this.snapshot = stateSnapshot;
          doStop();
        } else {
          StateSnapshot stateSnapshot = new StateSnapshot();
          this(Service.State.RUNNING);
          this.snapshot = stateSnapshot;
          running();
        } 
        return;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Cannot notifyStarted() when the service is ");
      stringBuilder.append(this.snapshot.state);
      this(stringBuilder.toString());
      notifyFailed(illegalStateException);
      throw illegalStateException;
    } finally {
      this.monitor.leave();
      executeListeners();
    } 
  }
  
  protected final void notifyStopped() {
    this.monitor.enter();
    try {
      Service.State state = this.snapshot.state;
      if (state == Service.State.STOPPING || state == Service.State.RUNNING) {
        StateSnapshot stateSnapshot = new StateSnapshot();
        this(Service.State.TERMINATED);
        this.snapshot = stateSnapshot;
        terminated(state);
        return;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("Cannot notifyStopped() when the service is ");
      stringBuilder.append(state);
      this(stringBuilder.toString());
      notifyFailed(illegalStateException);
      throw illegalStateException;
    } finally {
      this.monitor.leave();
      executeListeners();
    } 
  }
  
  @CanIgnoreReturnValue
  public final Service startAsync() {
    if (this.monitor.enterIf(this.isStartable)) {
      try {
        StateSnapshot stateSnapshot = new StateSnapshot();
        this(Service.State.STARTING);
        this.snapshot = stateSnapshot;
        starting();
        doStart();
      } catch (Throwable throwable) {
        notifyFailed(throwable);
      } finally {
        Exception exception;
      } 
      this.monitor.leave();
      executeListeners();
      return this;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Service ");
    stringBuilder.append(this);
    stringBuilder.append(" has already been started");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public final Service.State state() {
    return this.snapshot.externalState();
  }
  
  @CanIgnoreReturnValue
  public final Service stopAsync() {
    if (this.monitor.enterIf(this.isStoppable)) {
      try {
        StateSnapshot stateSnapshot;
        AssertionError assertionError;
        StringBuilder stringBuilder;
        Service.State state = state();
        switch (state) {
          default:
            assertionError = new AssertionError();
            stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("Unexpected state: ");
            stringBuilder.append(state);
            this(stringBuilder.toString());
            throw assertionError;
          case STOPPING:
          case TERMINATED:
          case FAILED:
            assertionError = new AssertionError();
            stringBuilder = new StringBuilder();
            this();
            stringBuilder.append("isStoppable is incorrectly implemented, saw: ");
            stringBuilder.append(state);
            this(stringBuilder.toString());
            throw assertionError;
          case RUNNING:
            stateSnapshot = new StateSnapshot();
            this(Service.State.STOPPING);
            this.snapshot = stateSnapshot;
            stopping(Service.State.RUNNING);
            doStop();
            break;
          case STARTING:
            stateSnapshot = new StateSnapshot();
            this(Service.State.STARTING, true, null);
            this.snapshot = stateSnapshot;
            stopping(Service.State.STARTING);
            break;
          case NEW:
            stateSnapshot = new StateSnapshot();
            this(Service.State.TERMINATED);
            this.snapshot = stateSnapshot;
            terminated(Service.State.NEW);
            break;
        } 
      } catch (Throwable throwable) {
        notifyFailed(throwable);
      } finally {
        Exception exception;
      } 
      this.monitor.leave();
      executeListeners();
    } 
    return this;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(" [");
    stringBuilder.append(state());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private final class HasReachedRunningGuard extends Monitor.Guard {
    public boolean isSatisfied() {
      boolean bool;
      if (AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
  
  private final class IsStartableGuard extends Monitor.Guard {
    public boolean isSatisfied() {
      boolean bool;
      if (AbstractService.this.state() == Service.State.NEW) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
  
  private final class IsStoppableGuard extends Monitor.Guard {
    public boolean isSatisfied() {
      boolean bool;
      if (AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
  
  private final class IsStoppedGuard extends Monitor.Guard {
    public boolean isSatisfied() {
      return AbstractService.this.state().isTerminal();
    }
  }
  
  @Immutable
  private static final class StateSnapshot {
    @Nullable
    final Throwable failure;
    
    final boolean shutdownWhenStartupFinishes;
    
    final Service.State state;
    
    StateSnapshot(Service.State param1State) {
      this(param1State, false, null);
    }
    
    StateSnapshot(Service.State param1State, boolean param1Boolean, @Nullable Throwable param1Throwable) {
      boolean bool3;
      boolean bool4;
      boolean bool1 = false;
      if (!param1Boolean || param1State == Service.State.STARTING) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      Preconditions.checkArgument(bool2, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", param1State);
      if (param1Throwable != null) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (param1State == Service.State.FAILED) {
        bool4 = true;
      } else {
        bool4 = false;
      } 
      boolean bool2 = bool1;
      if ((bool3 ^ bool4) == 0)
        bool2 = true; 
      Preconditions.checkArgument(bool2, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", param1State, param1Throwable);
      this.state = param1State;
      this.shutdownWhenStartupFinishes = param1Boolean;
      this.failure = param1Throwable;
    }
    
    Service.State externalState() {
      return (this.shutdownWhenStartupFinishes && this.state == Service.State.STARTING) ? Service.State.STOPPING : this.state;
    }
    
    Throwable failureCause() {
      boolean bool;
      if (this.state == Service.State.FAILED) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "failureCause() is only valid if the service has failed, service is %s", this.state);
      return this.failure;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\AbstractService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */