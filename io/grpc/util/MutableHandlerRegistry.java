package io.grpc.util;

import io.grpc.BindableService;
import io.grpc.ExperimentalApi;
import io.grpc.HandlerRegistry;
import io.grpc.MethodDescriptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/933")
@ThreadSafe
public final class MutableHandlerRegistry extends HandlerRegistry {
  private final ConcurrentMap<String, ServerServiceDefinition> services = new ConcurrentHashMap<String, ServerServiceDefinition>();
  
  @Nullable
  public ServerServiceDefinition addService(BindableService paramBindableService) {
    return addService(paramBindableService.bindService());
  }
  
  @Nullable
  public ServerServiceDefinition addService(ServerServiceDefinition paramServerServiceDefinition) {
    return this.services.put(paramServerServiceDefinition.getServiceDescriptor().getName(), paramServerServiceDefinition);
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
  public List<ServerServiceDefinition> getServices() {
    return Collections.unmodifiableList(new ArrayList<ServerServiceDefinition>(this.services.values()));
  }
  
  @Nullable
  public ServerMethodDefinition<?, ?> lookupMethod(String paramString1, @Nullable String paramString2) {
    paramString2 = MethodDescriptor.extractFullServiceName(paramString1);
    if (paramString2 == null)
      return null; 
    ServerServiceDefinition serverServiceDefinition = this.services.get(paramString2);
    return (serverServiceDefinition == null) ? null : serverServiceDefinition.getMethod(paramString1);
  }
  
  public boolean removeService(ServerServiceDefinition paramServerServiceDefinition) {
    return this.services.remove(paramServerServiceDefinition.getServiceDescriptor().getName(), paramServerServiceDefinition);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grp\\util\MutableHandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */