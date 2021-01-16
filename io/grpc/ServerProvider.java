package io.grpc;

import java.util.Collections;

@Internal
public abstract class ServerProvider {
  private static final ServerProvider provider = ServiceProviders.<ServerProvider>load(ServerProvider.class, Collections.emptyList(), ServerProvider.class.getClassLoader(), new ServiceProviders.PriorityAccessor<ServerProvider>() {
        public int getPriority(ServerProvider param1ServerProvider) {
          return param1ServerProvider.priority();
        }
        
        public boolean isAvailable(ServerProvider param1ServerProvider) {
          return param1ServerProvider.isAvailable();
        }
      });
  
  public static ServerProvider provider() {
    ServerProvider serverProvider = provider;
    if (serverProvider != null)
      return serverProvider; 
    throw new ManagedChannelProvider.ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty artifact");
  }
  
  protected abstract ServerBuilder<?> builderForPort(int paramInt);
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */