package io.grpc.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.EquivalentAddressGroup;
import io.grpc.ExperimentalApi;
import io.grpc.LoadBalancer;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import javax.annotation.Nullable;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
public final class RoundRobinLoadBalancerFactory extends LoadBalancer.Factory {
  private static final RoundRobinLoadBalancerFactory INSTANCE = new RoundRobinLoadBalancerFactory();
  
  public static RoundRobinLoadBalancerFactory getInstance() {
    return INSTANCE;
  }
  
  public LoadBalancer newLoadBalancer(LoadBalancer.Helper paramHelper) {
    return new RoundRobinLoadBalancer(paramHelper);
  }
  
  @VisibleForTesting
  static final class Picker extends LoadBalancer.SubchannelPicker {
    private static final AtomicIntegerFieldUpdater<Picker> indexUpdater = AtomicIntegerFieldUpdater.newUpdater(Picker.class, "index");
    
    private volatile int index = -1;
    
    private final List<LoadBalancer.Subchannel> list;
    
    @Nullable
    private final Status status;
    
    Picker(List<LoadBalancer.Subchannel> param1List, @Nullable Status param1Status) {
      this.list = param1List;
      this.status = param1Status;
    }
    
    private LoadBalancer.Subchannel nextSubchannel() {
      if (!this.list.isEmpty()) {
        int i = this.list.size();
        int j = indexUpdater.incrementAndGet(this);
        if (j >= i) {
          i = j % i;
          indexUpdater.compareAndSet(this, j, i);
          j = i;
        } 
        return this.list.get(j);
      } 
      throw new NoSuchElementException();
    }
    
    @VisibleForTesting
    List<LoadBalancer.Subchannel> getList() {
      return this.list;
    }
    
    @VisibleForTesting
    Status getStatus() {
      return this.status;
    }
    
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
      if (this.list.size() > 0)
        return LoadBalancer.PickResult.withSubchannel(nextSubchannel()); 
      Status status = this.status;
      return (status != null) ? LoadBalancer.PickResult.withError(status) : LoadBalancer.PickResult.withNoResult();
    }
  }
  
  @VisibleForTesting
  static final class Ref<T> {
    T value;
    
    Ref(T param1T) {
      this.value = param1T;
    }
  }
  
  @VisibleForTesting
  static final class RoundRobinLoadBalancer extends LoadBalancer {
    @VisibleForTesting
    static final Attributes.Key<RoundRobinLoadBalancerFactory.Ref<ConnectivityStateInfo>> STATE_INFO = Attributes.Key.of("state-info");
    
    private final LoadBalancer.Helper helper;
    
    private final Map<EquivalentAddressGroup, LoadBalancer.Subchannel> subchannels = new HashMap<EquivalentAddressGroup, LoadBalancer.Subchannel>();
    
    RoundRobinLoadBalancer(LoadBalancer.Helper param1Helper) {
      this.helper = (LoadBalancer.Helper)Preconditions.checkNotNull(param1Helper, "helper");
    }
    
    private static List<LoadBalancer.Subchannel> filterNonFailingSubchannels(Collection<LoadBalancer.Subchannel> param1Collection) {
      ArrayList<LoadBalancer.Subchannel> arrayList = new ArrayList(param1Collection.size());
      for (LoadBalancer.Subchannel subchannel : param1Collection) {
        if (((ConnectivityStateInfo)(getSubchannelStateInfoRef(subchannel)).value).getState() == ConnectivityState.READY)
          arrayList.add(subchannel); 
      } 
      return arrayList;
    }
    
    @Nullable
    private Status getAggregatedError() {
      Status status;
      Iterator<LoadBalancer.Subchannel> iterator = getSubchannels().iterator();
      ConnectivityStateInfo connectivityStateInfo = null;
      while (iterator.hasNext()) {
        connectivityStateInfo = (ConnectivityStateInfo)(getSubchannelStateInfoRef((LoadBalancer.Subchannel)iterator.next())).value;
        if (connectivityStateInfo.getState() != ConnectivityState.TRANSIENT_FAILURE)
          return null; 
        status = connectivityStateInfo.getStatus();
      } 
      return status;
    }
    
    private ConnectivityState getAggregatedState() {
      EnumSet<ConnectivityState> enumSet = EnumSet.noneOf(ConnectivityState.class);
      Iterator<LoadBalancer.Subchannel> iterator = getSubchannels().iterator();
      while (iterator.hasNext())
        enumSet.add(((ConnectivityStateInfo)(getSubchannelStateInfoRef((LoadBalancer.Subchannel)iterator.next())).value).getState()); 
      return enumSet.contains(ConnectivityState.READY) ? ConnectivityState.READY : (enumSet.contains(ConnectivityState.CONNECTING) ? ConnectivityState.CONNECTING : (enumSet.contains(ConnectivityState.IDLE) ? ConnectivityState.CONNECTING : ConnectivityState.TRANSIENT_FAILURE));
    }
    
    private static RoundRobinLoadBalancerFactory.Ref<ConnectivityStateInfo> getSubchannelStateInfoRef(LoadBalancer.Subchannel param1Subchannel) {
      return (RoundRobinLoadBalancerFactory.Ref<ConnectivityStateInfo>)Preconditions.checkNotNull(param1Subchannel.getAttributes().get(STATE_INFO), "STATE_INFO");
    }
    
    private static <T> Set<T> setsDifference(Set<T> param1Set1, Set<T> param1Set2) {
      param1Set1 = new HashSet<T>(param1Set1);
      param1Set1.removeAll(param1Set2);
      return param1Set1;
    }
    
    private static Set<EquivalentAddressGroup> stripAttrs(List<EquivalentAddressGroup> param1List) {
      HashSet<EquivalentAddressGroup> hashSet = new HashSet(param1List.size());
      Iterator<EquivalentAddressGroup> iterator = param1List.iterator();
      while (iterator.hasNext())
        hashSet.add(new EquivalentAddressGroup(((EquivalentAddressGroup)iterator.next()).getAddresses())); 
      return hashSet;
    }
    
    private void updateBalancingState(ConnectivityState param1ConnectivityState, Status param1Status) {
      List<LoadBalancer.Subchannel> list = filterNonFailingSubchannels(getSubchannels());
      this.helper.updateBalancingState(param1ConnectivityState, new RoundRobinLoadBalancerFactory.Picker(list, param1Status));
    }
    
    @VisibleForTesting
    Collection<LoadBalancer.Subchannel> getSubchannels() {
      return this.subchannels.values();
    }
    
    public void handleNameResolutionError(Status param1Status) {
      updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, param1Status);
    }
    
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> param1List, Attributes param1Attributes) {
      Set<EquivalentAddressGroup> set2 = this.subchannels.keySet();
      Set<EquivalentAddressGroup> set1 = stripAttrs(param1List);
      Set<EquivalentAddressGroup> set3 = setsDifference(set1, set2);
      set1 = setsDifference(set2, set1);
      for (EquivalentAddressGroup equivalentAddressGroup : set3) {
        Attributes attributes = Attributes.newBuilder().set(STATE_INFO, new RoundRobinLoadBalancerFactory.Ref<ConnectivityStateInfo>(ConnectivityStateInfo.forNonError(ConnectivityState.IDLE))).build();
        LoadBalancer.Subchannel subchannel = (LoadBalancer.Subchannel)Preconditions.checkNotNull(this.helper.createSubchannel(equivalentAddressGroup, attributes), "subchannel");
        this.subchannels.put(equivalentAddressGroup, subchannel);
        subchannel.requestConnection();
      } 
      for (EquivalentAddressGroup equivalentAddressGroup : set1)
        ((LoadBalancer.Subchannel)this.subchannels.remove(equivalentAddressGroup)).shutdown(); 
      updateBalancingState(getAggregatedState(), getAggregatedError());
    }
    
    public void handleSubchannelState(LoadBalancer.Subchannel param1Subchannel, ConnectivityStateInfo param1ConnectivityStateInfo) {
      if (this.subchannels.get(param1Subchannel.getAddresses()) != param1Subchannel)
        return; 
      if (param1ConnectivityStateInfo.getState() == ConnectivityState.IDLE)
        param1Subchannel.requestConnection(); 
      (getSubchannelStateInfoRef(param1Subchannel)).value = (T)param1ConnectivityStateInfo;
      updateBalancingState(getAggregatedState(), getAggregatedError());
    }
    
    public void shutdown() {
      Iterator<LoadBalancer.Subchannel> iterator = getSubchannels().iterator();
      while (iterator.hasNext())
        ((LoadBalancer.Subchannel)iterator.next()).shutdown(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grp\\util\RoundRobinLoadBalancerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */