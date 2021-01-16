package io.grpc.internal;

import com.google.common.base.Objects;
import io.grpc.Attributes;
import io.grpc.MethodDescriptor;
import io.grpc.ServerStreamTracer;
import javax.annotation.Nullable;

final class ServerCallInfoImpl<ReqT, RespT> extends ServerStreamTracer.ServerCallInfo<ReqT, RespT> {
  private final Attributes attributes;
  
  private final String authority;
  
  private final MethodDescriptor<ReqT, RespT> methodDescriptor;
  
  ServerCallInfoImpl(MethodDescriptor<ReqT, RespT> paramMethodDescriptor, Attributes paramAttributes, @Nullable String paramString) {
    this.methodDescriptor = paramMethodDescriptor;
    this.attributes = paramAttributes;
    this.authority = paramString;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof ServerCallInfoImpl;
    boolean bool1 = false;
    if (!bool)
      return false; 
    paramObject = paramObject;
    bool = bool1;
    if (Objects.equal(this.methodDescriptor, ((ServerCallInfoImpl)paramObject).methodDescriptor)) {
      bool = bool1;
      if (Objects.equal(this.attributes, ((ServerCallInfoImpl)paramObject).attributes)) {
        bool = bool1;
        if (Objects.equal(this.authority, ((ServerCallInfoImpl)paramObject).authority))
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public Attributes getAttributes() {
    return this.attributes;
  }
  
  @Nullable
  public String getAuthority() {
    return this.authority;
  }
  
  public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
    return this.methodDescriptor;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.methodDescriptor, this.attributes, this.authority });
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ServerCallInfoImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */