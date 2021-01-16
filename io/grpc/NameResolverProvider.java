package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
public abstract class NameResolverProvider extends NameResolver.Factory {
  @VisibleForTesting
  static final Iterable<Class<?>> HARDCODED_CLASSES;
  
  public static final Attributes.Key<Integer> PARAMS_DEFAULT_PORT = NameResolver.Factory.PARAMS_DEFAULT_PORT;
  
  private static final NameResolver.Factory factory;
  
  private static final List<NameResolverProvider> providers;
  
  static {
    HARDCODED_CLASSES = new HardcodedClasses();
    providers = ServiceProviders.loadAll(NameResolverProvider.class, HARDCODED_CLASSES, NameResolverProvider.class.getClassLoader(), new ServiceProviders.PriorityAccessor<NameResolverProvider>() {
          public int getPriority(NameResolverProvider param1NameResolverProvider) {
            return param1NameResolverProvider.priority();
          }
          
          public boolean isAvailable(NameResolverProvider param1NameResolverProvider) {
            return param1NameResolverProvider.isAvailable();
          }
        });
    factory = new NameResolverFactory(providers);
  }
  
  public static NameResolver.Factory asFactory() {
    return factory;
  }
  
  @VisibleForTesting
  static NameResolver.Factory asFactory(List<NameResolverProvider> paramList) {
    return new NameResolverFactory(paramList);
  }
  
  public static List<NameResolverProvider> providers() {
    return providers;
  }
  
  protected abstract boolean isAvailable();
  
  protected abstract int priority();
  
  @VisibleForTesting
  static final class HardcodedClasses implements Iterable<Class<?>> {
    public Iterator<Class<?>> iterator() {
      ArrayList<Class<?>> arrayList = new ArrayList();
      try {
        arrayList.add(Class.forName("io.grpc.internal.DnsNameResolverProvider"));
      } catch (ClassNotFoundException classNotFoundException) {}
      return arrayList.iterator();
    }
  }
  
  private static class NameResolverFactory extends NameResolver.Factory {
    private final List<NameResolverProvider> providers;
    
    public NameResolverFactory(List<NameResolverProvider> param1List) {
      this.providers = param1List;
    }
    
    private void checkForProviders() {
      Preconditions.checkState(this.providers.isEmpty() ^ true, "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
    }
    
    public String getDefaultScheme() {
      checkForProviders();
      return ((NameResolverProvider)this.providers.get(0)).getDefaultScheme();
    }
    
    public NameResolver newNameResolver(URI param1URI, Attributes param1Attributes) {
      checkForProviders();
      Iterator<NameResolverProvider> iterator = this.providers.iterator();
      while (iterator.hasNext()) {
        NameResolver nameResolver = ((NameResolverProvider)iterator.next()).newNameResolver(param1URI, param1Attributes);
        if (nameResolver != null)
          return nameResolver; 
      } 
      return null;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\NameResolverProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */