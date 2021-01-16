package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;

public final class ServiceDescriptor {
  private final Collection<MethodDescriptor<?, ?>> methods;
  
  private final String name;
  
  private final Object schemaDescriptor;
  
  private ServiceDescriptor(Builder paramBuilder) {
    this.name = paramBuilder.name;
    validateMethodNames(this.name, paramBuilder.methods);
    this.methods = Collections.unmodifiableList(new ArrayList<MethodDescriptor<?, ?>>(paramBuilder.methods));
    this.schemaDescriptor = paramBuilder.schemaDescriptor;
  }
  
  public ServiceDescriptor(String paramString, Collection<MethodDescriptor<?, ?>> paramCollection) {
    this(newBuilder(paramString).addAllMethods((Collection)Preconditions.checkNotNull(paramCollection, "methods")));
  }
  
  public ServiceDescriptor(String paramString, MethodDescriptor<?, ?>... paramVarArgs) {
    this(paramString, Arrays.asList(paramVarArgs));
  }
  
  public static Builder newBuilder(String paramString) {
    return new Builder(paramString);
  }
  
  static void validateMethodNames(String paramString, Collection<MethodDescriptor<?, ?>> paramCollection) {
    HashSet<String> hashSet = new HashSet(paramCollection.size());
    for (MethodDescriptor<?, ?> methodDescriptor : paramCollection) {
      Preconditions.checkNotNull(methodDescriptor, "method");
      String str = MethodDescriptor.extractFullServiceName(methodDescriptor.getFullMethodName());
      Preconditions.checkArgument(paramString.equals(str), "service names %s != %s", str, paramString);
      Preconditions.checkArgument(hashSet.add(methodDescriptor.getFullMethodName()), "duplicate name %s", methodDescriptor.getFullMethodName());
    } 
  }
  
  public Collection<MethodDescriptor<?, ?>> getMethods() {
    return this.methods;
  }
  
  public String getName() {
    return this.name;
  }
  
  @Nullable
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
  public Object getSchemaDescriptor() {
    return this.schemaDescriptor;
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", this.name).add("schemaDescriptor", this.schemaDescriptor).add("methods", this.methods).omitNullValues().toString();
  }
  
  public static final class Builder {
    private List<MethodDescriptor<?, ?>> methods = new ArrayList<MethodDescriptor<?, ?>>();
    
    private String name;
    
    private Object schemaDescriptor;
    
    private Builder(String param1String) {
      setName(param1String);
    }
    
    private Builder addAllMethods(Collection<MethodDescriptor<?, ?>> param1Collection) {
      this.methods.addAll(param1Collection);
      return this;
    }
    
    public Builder addMethod(MethodDescriptor<?, ?> param1MethodDescriptor) {
      this.methods.add(Preconditions.checkNotNull(param1MethodDescriptor, "method"));
      return this;
    }
    
    public ServiceDescriptor build() {
      return new ServiceDescriptor(this);
    }
    
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2666")
    public Builder setName(String param1String) {
      this.name = (String)Preconditions.checkNotNull(param1String, "name");
      return this;
    }
    
    public Builder setSchemaDescriptor(@Nullable Object param1Object) {
      this.schemaDescriptor = param1Object;
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ServiceDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */