package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;

@Internal
public abstract class ManagedChannelProvider {
  @VisibleForTesting
  static final Iterable<Class<?>> HARDCODED_CLASSES = new HardcodedClasses();
  
  private static final ManagedChannelProvider provider = ServiceProviders.<ManagedChannelProvider>load(ManagedChannelProvider.class, HARDCODED_CLASSES, ManagedChannelProvider.class.getClassLoader(), new ServiceProviders.PriorityAccessor<ManagedChannelProvider>() {
        public int getPriority(ManagedChannelProvider param1ManagedChannelProvider) {
          return param1ManagedChannelProvider.priority();
        }
        
        public boolean isAvailable(ManagedChannelProvider param1ManagedChannelProvider) {
          return param1ManagedChannelProvider.isAvailable();
        }
      });
  
  public static ManagedChannelProvider provider() {
    ManagedChannelProvider managedChannelProvider = provider;
    if (managedChannelProvider != null)
      return managedChannelProvider; 
    throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp or grpc-netty artifact");
  }
  
  protected abstract ManagedChannelBuilder<?> builderForAddress(String paramString, int paramInt);
  
  protected abstract ManagedChannelBuilder<?> builderForTarget(String paramString);
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
  
  private static final class HardcodedClasses implements Iterable<Class<?>> {
    private HardcodedClasses() {}
    
    public Iterator<Class<?>> iterator() {
      ArrayList<Class<?>> arrayList = new ArrayList();
      try {
        arrayList.add(Class.forName("io.grpc.okhttp.OkHttpChannelProvider"));
      } catch (ClassNotFoundException classNotFoundException) {}
      try {
        arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
      } catch (ClassNotFoundException classNotFoundException) {}
    }
  }
  
  public static final class ProviderNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public ProviderNotFoundException(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ManagedChannelProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */