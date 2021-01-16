package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

@Beta
@GwtIncompatible
public final class ServiceManager {
  private static final ListenerCallQueue.Callback<Listener> HEALTHY_CALLBACK;
  
  private static final ListenerCallQueue.Callback<Listener> STOPPED_CALLBACK;
  
  private static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
  
  private final ImmutableList<Service> services;
  
  private final ServiceManagerState state;
  
  static {
    HEALTHY_CALLBACK = new ListenerCallQueue.Callback<Listener>("healthy()") {
        void call(ServiceManager.Listener param1Listener) {
          param1Listener.healthy();
        }
      };
    STOPPED_CALLBACK = new ListenerCallQueue.Callback<Listener>("stopped()") {
        void call(ServiceManager.Listener param1Listener) {
          param1Listener.stopped();
        }
      };
  }
  
  public ServiceManager(Iterable<? extends Service> paramIterable) {
    ImmutableList<Service> immutableList2 = ImmutableList.copyOf(paramIterable);
    ImmutableList<Service> immutableList1 = immutableList2;
    if (immutableList2.isEmpty()) {
      logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning());
      immutableList1 = ImmutableList.of(new NoOpService());
    } 
    this.state = new ServiceManagerState((ImmutableCollection<Service>)immutableList1);
    this.services = immutableList1;
    WeakReference<ServiceManagerState> weakReference = new WeakReference<ServiceManagerState>(this.state);
    for (Service service : immutableList1) {
      boolean bool;
      service.addListener(new ServiceListener(service, weakReference), MoreExecutors.directExecutor());
      if (service.state() == Service.State.NEW) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool, "Can only manage NEW services, %s", service);
    } 
    this.state.markReady();
  }
  
  public void addListener(Listener paramListener) {
    this.state.addListener(paramListener, MoreExecutors.directExecutor());
  }
  
  public void addListener(Listener paramListener, Executor paramExecutor) {
    this.state.addListener(paramListener, paramExecutor);
  }
  
  public void awaitHealthy() {
    this.state.awaitHealthy();
  }
  
  public void awaitHealthy(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
    this.state.awaitHealthy(paramLong, paramTimeUnit);
  }
  
  public void awaitStopped() {
    this.state.awaitStopped();
  }
  
  public void awaitStopped(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
    this.state.awaitStopped(paramLong, paramTimeUnit);
  }
  
  public boolean isHealthy() {
    Iterator<Service> iterator = this.services.iterator();
    while (iterator.hasNext()) {
      if (!((Service)iterator.next()).isRunning())
        return false; 
    } 
    return true;
  }
  
  public ImmutableMultimap<Service.State, Service> servicesByState() {
    return this.state.servicesByState();
  }
  
  @CanIgnoreReturnValue
  public ServiceManager startAsync() {
    for (Service service : this.services) {
      boolean bool;
      Service.State state = service.state();
      if (state == Service.State.NEW) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Service %s is %s, cannot start it.", service, state);
    } 
    for (Service service : this.services) {
      try {
        this.state.tryStartTiming(service);
        service.startAsync();
      } catch (IllegalStateException illegalStateException) {
        Logger logger = logger;
        Level level = Level.WARNING;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to start Service ");
        stringBuilder.append(service);
        logger.log(level, stringBuilder.toString(), illegalStateException);
      } 
    } 
    return this;
  }
  
  public ImmutableMap<Service, Long> startupTimes() {
    return this.state.startupTimes();
  }
  
  @CanIgnoreReturnValue
  public ServiceManager stopAsync() {
    Iterator<Service> iterator = this.services.iterator();
    while (iterator.hasNext())
      ((Service)iterator.next()).stopAsync(); 
    return this;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter((Collection)this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
  }
  
  private static final class EmptyServiceManagerWarning extends Throwable {
    private EmptyServiceManagerWarning() {}
  }
  
  @Beta
  public static abstract class Listener {
    public void failure(Service param1Service) {}
    
    public void healthy() {}
    
    public void stopped() {}
  }
  
  private static final class NoOpService extends AbstractService {
    private NoOpService() {}
    
    protected void doStart() {
      notifyStarted();
    }
    
    protected void doStop() {
      notifyStopped();
    }
  }
  
  private static final class ServiceListener extends Service.Listener {
    final Service service;
    
    final WeakReference<ServiceManager.ServiceManagerState> state;
    
    ServiceListener(Service param1Service, WeakReference<ServiceManager.ServiceManagerState> param1WeakReference) {
      this.service = param1Service;
      this.state = param1WeakReference;
    }
    
    public void failed(Service.State param1State, Throwable param1Throwable) {
      ServiceManager.ServiceManagerState serviceManagerState = this.state.get();
      if (serviceManagerState != null) {
        boolean bool;
        if (!(this.service instanceof ServiceManager.NoOpService)) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          Logger logger = ServiceManager.logger;
          Level level = Level.SEVERE;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Service ");
          stringBuilder.append(this.service);
          stringBuilder.append(" has failed in the ");
          stringBuilder.append(param1State);
          stringBuilder.append(" state.");
          logger.log(level, stringBuilder.toString(), param1Throwable);
        } 
        serviceManagerState.transitionService(this.service, param1State, Service.State.FAILED);
      } 
    }
    
    public void running() {
      ServiceManager.ServiceManagerState serviceManagerState = this.state.get();
      if (serviceManagerState != null)
        serviceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING); 
    }
    
    public void starting() {
      ServiceManager.ServiceManagerState serviceManagerState = this.state.get();
      if (serviceManagerState != null) {
        serviceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
        if (!(this.service instanceof ServiceManager.NoOpService))
          ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service); 
      } 
    }
    
    public void stopping(Service.State param1State) {
      ServiceManager.ServiceManagerState serviceManagerState = this.state.get();
      if (serviceManagerState != null)
        serviceManagerState.transitionService(this.service, param1State, Service.State.STOPPING); 
    }
    
    public void terminated(Service.State param1State) {
      ServiceManager.ServiceManagerState serviceManagerState = this.state.get();
      if (serviceManagerState != null) {
        if (!(this.service instanceof ServiceManager.NoOpService))
          ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[] { this.service, param1State }); 
        serviceManagerState.transitionService(this.service, param1State, Service.State.TERMINATED);
      } 
    }
  }
  
  private static final class ServiceManagerState {
    final Monitor.Guard awaitHealthGuard = new AwaitHealthGuard();
    
    @GuardedBy("monitor")
    final List<ListenerCallQueue<ServiceManager.Listener>> listeners = Collections.synchronizedList(new ArrayList<ListenerCallQueue<ServiceManager.Listener>>());
    
    final Monitor monitor = new Monitor();
    
    final int numberOfServices;
    
    @GuardedBy("monitor")
    boolean ready;
    
    @GuardedBy("monitor")
    final SetMultimap<Service.State, Service> servicesByState = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
    
    @GuardedBy("monitor")
    final Map<Service, Stopwatch> startupTimers = Maps.newIdentityHashMap();
    
    @GuardedBy("monitor")
    final Multiset<Service.State> states = this.servicesByState.keys();
    
    final Monitor.Guard stoppedGuard = new StoppedGuard();
    
    @GuardedBy("monitor")
    boolean transitioned;
    
    ServiceManagerState(ImmutableCollection<Service> param1ImmutableCollection) {
      this.numberOfServices = param1ImmutableCollection.size();
      this.servicesByState.putAll(Service.State.NEW, (Iterable)param1ImmutableCollection);
    }
    
    void addListener(ServiceManager.Listener param1Listener, Executor param1Executor) {
      Preconditions.checkNotNull(param1Listener, "listener");
      Preconditions.checkNotNull(param1Executor, "executor");
      this.monitor.enter();
      try {
        if (!this.stoppedGuard.isSatisfied()) {
          List<ListenerCallQueue<ServiceManager.Listener>> list = this.listeners;
          ListenerCallQueue<ServiceManager.Listener> listenerCallQueue = new ListenerCallQueue();
          this((L)param1Listener, param1Executor);
          list.add(listenerCallQueue);
        } 
        return;
      } finally {
        this.monitor.leave();
      } 
    }
    
    void awaitHealthy() {
      this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
      try {
        checkHealthy();
        return;
      } finally {
        this.monitor.leave();
      } 
    }
    
    void awaitHealthy(long param1Long, TimeUnit param1TimeUnit) throws TimeoutException {
      this.monitor.enter();
      try {
        if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, param1Long, param1TimeUnit)) {
          checkHealthy();
          return;
        } 
        TimeoutException timeoutException = new TimeoutException();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Timeout waiting for the services to become healthy. The following services have not started: ");
        stringBuilder.append(Multimaps.filterKeys(this.servicesByState, Predicates.in((Collection)ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
        this(stringBuilder.toString());
        throw timeoutException;
      } finally {
        this.monitor.leave();
      } 
    }
    
    void awaitStopped() {
      this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
      this.monitor.leave();
    }
    
    void awaitStopped(long param1Long, TimeUnit param1TimeUnit) throws TimeoutException {
      this.monitor.enter();
      try {
        boolean bool = this.monitor.waitForUninterruptibly(this.stoppedGuard, param1Long, param1TimeUnit);
        if (bool)
          return; 
        TimeoutException timeoutException = new TimeoutException();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Timeout waiting for the services to stop. The following services have not stopped: ");
        stringBuilder.append(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
        this(stringBuilder.toString());
        throw timeoutException;
      } finally {
        this.monitor.leave();
      } 
    }
    
    @GuardedBy("monitor")
    void checkHealthy() {
      if (this.states.count(Service.State.RUNNING) == this.numberOfServices)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected to be healthy after starting. The following services are not running: ");
      stringBuilder.append(Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    void executeListeners() {
      Preconditions.checkState(this.monitor.isOccupiedByCurrentThread() ^ true, "It is incorrect to execute listeners with the monitor held.");
      for (byte b = 0; b < this.listeners.size(); b++)
        ((ListenerCallQueue)this.listeners.get(b)).execute(); 
    }
    
    @GuardedBy("monitor")
    void fireFailedListeners(final Service service) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("failed({service=");
      stringBuilder.append(service);
      stringBuilder.append("})");
      (new ListenerCallQueue.Callback<ServiceManager.Listener>(stringBuilder.toString()) {
          void call(ServiceManager.Listener param2Listener) {
            param2Listener.failure(service);
          }
        }).enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireHealthyListeners() {
      ServiceManager.HEALTHY_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    void fireStoppedListeners() {
      ServiceManager.STOPPED_CALLBACK.enqueueOn(this.listeners);
    }
    
    void markReady() {
      this.monitor.enter();
      try {
        if (!this.transitioned) {
          this.ready = true;
          return;
        } 
        ArrayList<Service> arrayList = Lists.newArrayList();
        for (Service service : servicesByState().values()) {
          if (service.state() != Service.State.NEW)
            arrayList.add(service); 
        } 
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("Services started transitioning asynchronously before the ServiceManager was constructed: ");
        stringBuilder.append(arrayList);
        this(stringBuilder.toString());
        throw illegalArgumentException;
      } finally {
        this.monitor.leave();
      } 
    }
    
    ImmutableMultimap<Service.State, Service> servicesByState() {
      ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
      this.monitor.enter();
      try {
        for (Map.Entry entry : this.servicesByState.entries()) {
          if (!(entry.getValue() instanceof ServiceManager.NoOpService))
            builder.put(entry); 
        } 
        return (ImmutableMultimap<Service.State, Service>)builder.build();
      } finally {
        this.monitor.leave();
      } 
    }
    
    ImmutableMap<Service, Long> startupTimes() {
      this.monitor.enter();
      try {
        ArrayList<Map.Entry> arrayList = Lists.newArrayListWithCapacity(this.startupTimers.size());
        for (Map.Entry<Service, Stopwatch> entry : this.startupTimers.entrySet()) {
          Service service = (Service)entry.getKey();
          Stopwatch stopwatch = (Stopwatch)entry.getValue();
          if (!stopwatch.isRunning() && !(service instanceof ServiceManager.NoOpService))
            arrayList.add(Maps.immutableEntry(service, Long.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS)))); 
        } 
        this.monitor.leave();
        return ImmutableMap.copyOf(arrayList);
      } finally {
        this.monitor.leave();
      } 
    }
    
    void transitionService(Service param1Service, Service.State param1State1, Service.State param1State2) {
      boolean bool;
      Preconditions.checkNotNull(param1Service);
      if (param1State1 != param1State2) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkArgument(bool);
      this.monitor.enter();
      try {
        this.transitioned = true;
        bool = this.ready;
        if (!bool)
          return; 
        Preconditions.checkState(this.servicesByState.remove(param1State1, param1Service), "Service %s not at the expected location in the state map %s", param1Service, param1State1);
        Preconditions.checkState(this.servicesByState.put(param1State2, param1Service), "Service %s in the state map unexpectedly at %s", param1Service, param1State2);
        Stopwatch stopwatch2 = this.startupTimers.get(param1Service);
        Stopwatch stopwatch1 = stopwatch2;
        if (stopwatch2 == null) {
          stopwatch1 = Stopwatch.createStarted();
          this.startupTimers.put(param1Service, stopwatch1);
        } 
        if (param1State2.compareTo(Service.State.RUNNING) >= 0 && stopwatch1.isRunning()) {
          stopwatch1.stop();
          if (!(param1Service instanceof ServiceManager.NoOpService))
            ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[] { param1Service, stopwatch1 }); 
        } 
        if (param1State2 == Service.State.FAILED)
          fireFailedListeners(param1Service); 
        if (this.states.count(Service.State.RUNNING) == this.numberOfServices) {
          fireHealthyListeners();
        } else if (this.states.count(Service.State.TERMINATED) + this.states.count(Service.State.FAILED) == this.numberOfServices) {
          fireStoppedListeners();
        } 
        return;
      } finally {
        this.monitor.leave();
        executeListeners();
      } 
    }
    
    void tryStartTiming(Service param1Service) {
      this.monitor.enter();
      try {
        if ((Stopwatch)this.startupTimers.get(param1Service) == null)
          this.startupTimers.put(param1Service, Stopwatch.createStarted()); 
        return;
      } finally {
        this.monitor.leave();
      } 
    }
    
    final class AwaitHealthGuard extends Monitor.Guard {
      public boolean isSatisfied() {
        return (ServiceManager.ServiceManagerState.this.states.count(Service.State.RUNNING) == ServiceManager.ServiceManagerState.this.numberOfServices || ServiceManager.ServiceManagerState.this.states.contains(Service.State.STOPPING) || ServiceManager.ServiceManagerState.this.states.contains(Service.State.TERMINATED) || ServiceManager.ServiceManagerState.this.states.contains(Service.State.FAILED));
      }
    }
    
    final class StoppedGuard extends Monitor.Guard {
      public boolean isSatisfied() {
        boolean bool;
        if (ServiceManager.ServiceManagerState.this.states.count(Service.State.TERMINATED) + ServiceManager.ServiceManagerState.this.states.count(Service.State.FAILED) == ServiceManager.ServiceManagerState.this.numberOfServices) {
          bool = true;
        } else {
          bool = false;
        } 
        return bool;
      }
    }
  }
  
  class null implements Function<Map.Entry<Service, Long>, Long> {
    public Long apply(Map.Entry<Service, Long> param1Entry) {
      return param1Entry.getValue();
    }
  }
  
  class null extends ListenerCallQueue.Callback<Listener> {
    null(String param1String) {
      super(param1String);
    }
    
    void call(ServiceManager.Listener param1Listener) {
      param1Listener.failure(service);
    }
  }
  
  final class AwaitHealthGuard extends Monitor.Guard {
    public boolean isSatisfied() {
      return (this.this$0.states.count(Service.State.RUNNING) == this.this$0.numberOfServices || this.this$0.states.contains(Service.State.STOPPING) || this.this$0.states.contains(Service.State.TERMINATED) || this.this$0.states.contains(Service.State.FAILED));
    }
  }
  
  final class StoppedGuard extends Monitor.Guard {
    public boolean isSatisfied() {
      boolean bool;
      if (this.this$0.states.count(Service.State.TERMINATED) + this.this$0.states.count(Service.State.FAILED) == this.this$0.numberOfServices) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\ServiceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */