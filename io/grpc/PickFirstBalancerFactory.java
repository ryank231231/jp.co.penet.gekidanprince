package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
public final class PickFirstBalancerFactory extends LoadBalancer.Factory {
  private static final PickFirstBalancerFactory INSTANCE = new PickFirstBalancerFactory();
  
  public static PickFirstBalancerFactory getInstance() {
    return INSTANCE;
  }
  
  public LoadBalancer newLoadBalancer(LoadBalancer.Helper paramHelper) {
    return new PickFirstBalancer(paramHelper);
  }
  
  @VisibleForTesting
  static final class PickFirstBalancer extends LoadBalancer {
    private final LoadBalancer.Helper helper;
    
    private LoadBalancer.Subchannel subchannel;
    
    PickFirstBalancer(LoadBalancer.Helper param1Helper) {
      this.helper = (LoadBalancer.Helper)Preconditions.checkNotNull(param1Helper, "helper");
    }
    
    private static EquivalentAddressGroup flattenEquivalentAddressGroup(List<EquivalentAddressGroup> param1List) {
      ArrayList<SocketAddress> arrayList = new ArrayList();
      Iterator<EquivalentAddressGroup> iterator = param1List.iterator();
      while (iterator.hasNext())
        arrayList.addAll(((EquivalentAddressGroup)iterator.next()).getAddresses()); 
      return new EquivalentAddressGroup(arrayList);
    }
    
    public void handleNameResolutionError(Status param1Status) {
      LoadBalancer.Subchannel subchannel = this.subchannel;
      if (subchannel != null) {
        subchannel.shutdown();
        this.subchannel = null;
      } 
      this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new PickFirstBalancerFactory.Picker(LoadBalancer.PickResult.withError(param1Status)));
    }
    
    public void handleResolvedAddressGroups(List<EquivalentAddressGroup> param1List, Attributes param1Attributes) {
      EquivalentAddressGroup equivalentAddressGroup = flattenEquivalentAddressGroup(param1List);
      LoadBalancer.Subchannel subchannel = this.subchannel;
      if (subchannel == null) {
        this.subchannel = this.helper.createSubchannel(equivalentAddressGroup, Attributes.EMPTY);
        this.helper.updateBalancingState(ConnectivityState.CONNECTING, new PickFirstBalancerFactory.Picker(LoadBalancer.PickResult.withSubchannel(this.subchannel)));
        this.subchannel.requestConnection();
      } else {
        this.helper.updateSubchannelAddresses(subchannel, equivalentAddressGroup);
      } 
    }
    
    public void handleSubchannelState(LoadBalancer.Subchannel param1Subchannel, ConnectivityStateInfo param1ConnectivityStateInfo) {
      StringBuilder stringBuilder;
      LoadBalancer.PickResult pickResult;
      ConnectivityState connectivityState = param1ConnectivityStateInfo.getState();
      if (param1Subchannel != this.subchannel || connectivityState == ConnectivityState.SHUTDOWN)
        return; 
      switch (connectivityState) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Unsupported state:");
          stringBuilder.append(connectivityState);
          throw new IllegalArgumentException(stringBuilder.toString());
        case TRANSIENT_FAILURE:
          pickResult = LoadBalancer.PickResult.withError(param1ConnectivityStateInfo.getStatus());
          break;
        case READY:
        case IDLE:
          pickResult = LoadBalancer.PickResult.withSubchannel((LoadBalancer.Subchannel)pickResult);
          break;
        case CONNECTING:
          pickResult = LoadBalancer.PickResult.withNoResult();
          break;
      } 
      this.helper.updateBalancingState(connectivityState, new PickFirstBalancerFactory.Picker(pickResult));
    }
    
    public void shutdown() {
      LoadBalancer.Subchannel subchannel = this.subchannel;
      if (subchannel != null)
        subchannel.shutdown(); 
    }
  }
  
  @VisibleForTesting
  static final class Picker extends LoadBalancer.SubchannelPicker {
    private final LoadBalancer.PickResult result;
    
    Picker(LoadBalancer.PickResult param1PickResult) {
      this.result = (LoadBalancer.PickResult)Preconditions.checkNotNull(param1PickResult, "result");
    }
    
    public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs) {
      return this.result;
    }
    
    public void requestConnection() {
      LoadBalancer.Subchannel subchannel = this.result.getSubchannel();
      if (subchannel != null)
        subchannel.requestConnection(); 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\PickFirstBalancerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */