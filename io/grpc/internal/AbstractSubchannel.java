package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import io.grpc.LoadBalancer;
import javax.annotation.Nullable;

abstract class AbstractSubchannel extends LoadBalancer.Subchannel {
  @VisibleForTesting
  abstract Instrumented<Channelz.ChannelStats> getInternalSubchannel();
  
  @Nullable
  abstract ClientTransport obtainActiveTransport();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\AbstractSubchannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */