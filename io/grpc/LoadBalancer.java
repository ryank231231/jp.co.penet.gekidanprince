package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
@NotThreadSafe
public abstract class LoadBalancer {
  public abstract void handleNameResolutionError(Status paramStatus);
  
  public abstract void handleResolvedAddressGroups(List<EquivalentAddressGroup> paramList, Attributes paramAttributes);
  
  public abstract void handleSubchannelState(Subchannel paramSubchannel, ConnectivityStateInfo paramConnectivityStateInfo);
  
  public abstract void shutdown();
  
  @ThreadSafe
  public static abstract class Factory {
    public abstract LoadBalancer newLoadBalancer(LoadBalancer.Helper param1Helper);
  }
  
  class LoadBalancer {}
  
  @Immutable
  public static final class PickResult {
    private static final PickResult NO_RESULT = new PickResult(null, null, Status.OK, false);
    
    private final boolean drop;
    
    private final Status status;
    
    @Nullable
    private final ClientStreamTracer.Factory streamTracerFactory;
    
    @Nullable
    private final LoadBalancer.Subchannel subchannel;
    
    private PickResult(@Nullable LoadBalancer.Subchannel param1Subchannel, @Nullable ClientStreamTracer.Factory param1Factory, Status param1Status, boolean param1Boolean) {
      this.subchannel = param1Subchannel;
      this.streamTracerFactory = param1Factory;
      this.status = (Status)Preconditions.checkNotNull(param1Status, "status");
      this.drop = param1Boolean;
    }
    
    public static PickResult withDrop(Status param1Status) {
      Preconditions.checkArgument(param1Status.isOk() ^ true, "drop status shouldn't be OK");
      return new PickResult(null, null, param1Status, true);
    }
    
    public static PickResult withError(Status param1Status) {
      Preconditions.checkArgument(param1Status.isOk() ^ true, "error status shouldn't be OK");
      return new PickResult(null, null, param1Status, false);
    }
    
    public static PickResult withNoResult() {
      return NO_RESULT;
    }
    
    public static PickResult withSubchannel(LoadBalancer.Subchannel param1Subchannel) {
      return withSubchannel(param1Subchannel, null);
    }
    
    public static PickResult withSubchannel(LoadBalancer.Subchannel param1Subchannel, @Nullable ClientStreamTracer.Factory param1Factory) {
      return new PickResult((LoadBalancer.Subchannel)Preconditions.checkNotNull(param1Subchannel, "subchannel"), param1Factory, Status.OK, false);
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof PickResult;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (Objects.equal(this.subchannel, ((PickResult)param1Object).subchannel)) {
        bool = bool1;
        if (Objects.equal(this.status, ((PickResult)param1Object).status)) {
          bool = bool1;
          if (Objects.equal(this.streamTracerFactory, ((PickResult)param1Object).streamTracerFactory)) {
            bool = bool1;
            if (this.drop == ((PickResult)param1Object).drop)
              bool = true; 
          } 
        } 
      } 
      return bool;
    }
    
    public Status getStatus() {
      return this.status;
    }
    
    @Nullable
    public ClientStreamTracer.Factory getStreamTracerFactory() {
      return this.streamTracerFactory;
    }
    
    @Nullable
    public LoadBalancer.Subchannel getSubchannel() {
      return this.subchannel;
    }
    
    public int hashCode() {
      return Objects.hashCode(new Object[] { this.subchannel, this.status, this.streamTracerFactory, Boolean.valueOf(this.drop) });
    }
    
    public boolean isDrop() {
      return this.drop;
    }
    
    public String toString() {
      return MoreObjects.toStringHelper(this).add("subchannel", this.subchannel).add("streamTracerFactory", this.streamTracerFactory).add("status", this.status).add("drop", this.drop).toString();
    }
  }
  
  public static abstract class PickSubchannelArgs {
    public abstract CallOptions getCallOptions();
    
    public abstract Metadata getHeaders();
    
    public abstract MethodDescriptor<?, ?> getMethodDescriptor();
  }
  
  @ThreadSafe
  public static abstract class Subchannel {
    public abstract EquivalentAddressGroup getAddresses();
    
    public abstract Attributes getAttributes();
    
    public abstract void requestConnection();
    
    public abstract void shutdown();
  }
  
  @ThreadSafe
  public static abstract class SubchannelPicker {
    public abstract LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs param1PickSubchannelArgs);
    
    public void requestConnection() {}
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\LoadBalancer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */