package io.grpc;

import java.net.URI;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
@ThreadSafe
public abstract class NameResolver {
  public abstract String getServiceAuthority();
  
  public void refresh() {}
  
  public abstract void shutdown();
  
  public abstract void start(Listener paramListener);
  
  public static abstract class Factory {
    public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = Attributes.Key.of("params-default-port");
    
    public abstract String getDefaultScheme();
    
    @Nullable
    public abstract NameResolver newNameResolver(URI param1URI, Attributes param1Attributes);
  }
  
  @ThreadSafe
  public static interface Listener {
    void onAddresses(List<EquivalentAddressGroup> param1List, Attributes param1Attributes);
    
    void onError(Status param1Status);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\NameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */