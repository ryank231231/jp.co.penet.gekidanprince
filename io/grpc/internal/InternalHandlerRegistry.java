package io.grpc.internal;

import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class InternalHandlerRegistry {
  private final Map<String, ServerMethodDefinition<?, ?>> methods;
  
  private final List<ServerServiceDefinition> services;
  
  private InternalHandlerRegistry(List<ServerServiceDefinition> paramList, Map<String, ServerMethodDefinition<?, ?>> paramMap) {
    this.services = paramList;
    this.methods = paramMap;
  }
  
  public List<ServerServiceDefinition> getServices() {
    return this.services;
  }
  
  @Nullable
  ServerMethodDefinition<?, ?> lookupMethod(String paramString) {
    return this.methods.get(paramString);
  }
  
  static class Builder {
    private final HashMap<String, ServerServiceDefinition> services = new LinkedHashMap<String, ServerServiceDefinition>();
    
    Builder addService(ServerServiceDefinition param1ServerServiceDefinition) {
      this.services.put(param1ServerServiceDefinition.getServiceDescriptor().getName(), param1ServerServiceDefinition);
      return this;
    }
    
    InternalHandlerRegistry build() {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      Iterator<ServerServiceDefinition> iterator = this.services.values().iterator();
      while (iterator.hasNext()) {
        for (ServerMethodDefinition serverMethodDefinition : ((ServerServiceDefinition)iterator.next()).getMethods())
          hashMap.put(serverMethodDefinition.getMethodDescriptor().getFullMethodName(), serverMethodDefinition); 
      } 
      return new InternalHandlerRegistry(Collections.unmodifiableList(new ArrayList(this.services.values())), Collections.unmodifiableMap(hashMap));
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\InternalHandlerRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */