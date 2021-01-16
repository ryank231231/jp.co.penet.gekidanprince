package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ServerServiceDefinition {
  private final Map<String, ServerMethodDefinition<?, ?>> methods;
  
  private final ServiceDescriptor serviceDescriptor;
  
  private ServerServiceDefinition(ServiceDescriptor paramServiceDescriptor, Map<String, ServerMethodDefinition<?, ?>> paramMap) {
    this.serviceDescriptor = (ServiceDescriptor)Preconditions.checkNotNull(paramServiceDescriptor, "serviceDescriptor");
    this.methods = Collections.unmodifiableMap(new HashMap<String, ServerMethodDefinition<?, ?>>(paramMap));
  }
  
  public static Builder builder(ServiceDescriptor paramServiceDescriptor) {
    return new Builder(paramServiceDescriptor);
  }
  
  public static Builder builder(String paramString) {
    return new Builder(paramString);
  }
  
  @Internal
  public ServerMethodDefinition<?, ?> getMethod(String paramString) {
    return this.methods.get(paramString);
  }
  
  public Collection<ServerMethodDefinition<?, ?>> getMethods() {
    return this.methods.values();
  }
  
  public ServiceDescriptor getServiceDescriptor() {
    return this.serviceDescriptor;
  }
  
  public static final class Builder {
    private final Map<String, ServerMethodDefinition<?, ?>> methods = new HashMap<String, ServerMethodDefinition<?, ?>>();
    
    private final ServiceDescriptor serviceDescriptor;
    
    private final String serviceName;
    
    private Builder(ServiceDescriptor param1ServiceDescriptor) {
      this.serviceDescriptor = (ServiceDescriptor)Preconditions.checkNotNull(param1ServiceDescriptor, "serviceDescriptor");
      this.serviceName = param1ServiceDescriptor.getName();
    }
    
    private Builder(String param1String) {
      this.serviceName = (String)Preconditions.checkNotNull(param1String, "serviceName");
      this.serviceDescriptor = null;
    }
    
    public <ReqT, RespT> Builder addMethod(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, ServerCallHandler<ReqT, RespT> param1ServerCallHandler) {
      return addMethod(ServerMethodDefinition.create((MethodDescriptor<?, ?>)Preconditions.checkNotNull(param1MethodDescriptor, "method must not be null"), (ServerCallHandler<?, ?>)Preconditions.checkNotNull(param1ServerCallHandler, "handler must not be null")));
    }
    
    public <ReqT, RespT> Builder addMethod(ServerMethodDefinition<ReqT, RespT> param1ServerMethodDefinition) {
      MethodDescriptor<ReqT, RespT> methodDescriptor = param1ServerMethodDefinition.getMethodDescriptor();
      Preconditions.checkArgument(this.serviceName.equals(MethodDescriptor.extractFullServiceName(methodDescriptor.getFullMethodName())), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", this.serviceName, methodDescriptor.getFullMethodName());
      String str = methodDescriptor.getFullMethodName();
      Preconditions.checkState(this.methods.containsKey(str) ^ true, "Method by same name already registered: %s", str);
      this.methods.put(str, param1ServerMethodDefinition);
      return this;
    }
    
    public ServerServiceDefinition build() {
      ServiceDescriptor serviceDescriptor1 = this.serviceDescriptor;
      ServiceDescriptor serviceDescriptor2 = serviceDescriptor1;
      if (serviceDescriptor1 == null) {
        ArrayList<MethodDescriptor<?, ?>> arrayList = new ArrayList(this.methods.size());
        Iterator<ServerMethodDefinition> iterator = this.methods.values().iterator();
        while (iterator.hasNext())
          arrayList.add(((ServerMethodDefinition)iterator.next()).getMethodDescriptor()); 
        serviceDescriptor2 = new ServiceDescriptor(this.serviceName, arrayList);
      } 
      HashMap<String, ServerMethodDefinition<?, ?>> hashMap = new HashMap<String, ServerMethodDefinition<?, ?>>(this.methods);
      for (MethodDescriptor<ReqT, RespT> methodDescriptor : serviceDescriptor2.getMethods()) {
        ServerMethodDefinition<ReqT, RespT> serverMethodDefinition = (ServerMethodDefinition)hashMap.remove(methodDescriptor.getFullMethodName());
        if (serverMethodDefinition != null) {
          if (serverMethodDefinition.getMethodDescriptor() == methodDescriptor)
            continue; 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Bound method for ");
          stringBuilder1.append(methodDescriptor.getFullMethodName());
          stringBuilder1.append(" not same instance as method in service descriptor");
          throw new IllegalStateException(stringBuilder1.toString());
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("No method bound for descriptor entry ");
        stringBuilder.append(methodDescriptor.getFullMethodName());
        throw new IllegalStateException(stringBuilder.toString());
      } 
      if (hashMap.size() <= 0)
        return new ServerServiceDefinition((ServiceDescriptor)stringBuilder, this.methods); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No entry in descriptor matching bound method ");
      stringBuilder.append(((ServerMethodDefinition<ReqT, RespT>)hashMap.values().iterator().next()).getMethodDescriptor().getFullMethodName());
      throw new IllegalStateException(stringBuilder.toString());
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServerServiceDefinition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */