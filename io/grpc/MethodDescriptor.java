package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class MethodDescriptor<ReqT, RespT> {
  private final String fullMethodName;
  
  private final boolean idempotent;
  
  private final AtomicReferenceArray<Object> rawMethodNames;
  
  private final Marshaller<ReqT> requestMarshaller;
  
  private final Marshaller<RespT> responseMarshaller;
  
  private final boolean safe;
  
  private final boolean sampledToLocalTracing;
  
  @Nullable
  private final Object schemaDescriptor;
  
  private final MethodType type;
  
  private MethodDescriptor(MethodType paramMethodType, String paramString, Marshaller<ReqT> paramMarshaller, Marshaller<RespT> paramMarshaller1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    boolean bool = true;
    this.rawMethodNames = new AtomicReferenceArray(1);
    this.type = (MethodType)Preconditions.checkNotNull(paramMethodType, "type");
    this.fullMethodName = (String)Preconditions.checkNotNull(paramString, "fullMethodName");
    this.requestMarshaller = (Marshaller<ReqT>)Preconditions.checkNotNull(paramMarshaller, "requestMarshaller");
    this.responseMarshaller = (Marshaller<RespT>)Preconditions.checkNotNull(paramMarshaller1, "responseMarshaller");
    this.schemaDescriptor = paramObject;
    this.idempotent = paramBoolean1;
    this.safe = paramBoolean2;
    this.sampledToLocalTracing = paramBoolean3;
    paramBoolean1 = bool;
    if (paramBoolean2)
      if (paramMethodType == MethodType.UNARY) {
        paramBoolean1 = bool;
      } else {
        paramBoolean1 = false;
      }  
    Preconditions.checkArgument(paramBoolean1, "Only unary methods can be specified safe");
  }
  
  @Deprecated
  public static <RequestT, ResponseT> MethodDescriptor<RequestT, ResponseT> create(MethodType paramMethodType, String paramString, Marshaller<RequestT> paramMarshaller, Marshaller<ResponseT> paramMarshaller1) {
    return new MethodDescriptor(paramMethodType, paramString, paramMarshaller, paramMarshaller1, null, false, false, false);
  }
  
  @Nullable
  public static String extractFullServiceName(String paramString) {
    int i = ((String)Preconditions.checkNotNull(paramString, "fullMethodName")).lastIndexOf('/');
    return (i == -1) ? null : paramString.substring(0, i);
  }
  
  public static String generateFullMethodName(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((String)Preconditions.checkNotNull(paramString1, "fullServiceName"));
    stringBuilder.append("/");
    stringBuilder.append((String)Preconditions.checkNotNull(paramString2, "methodName"));
    return stringBuilder.toString();
  }
  
  @CheckReturnValue
  public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder() {
    return newBuilder(null, null);
  }
  
  @CheckReturnValue
  public static <ReqT, RespT> Builder<ReqT, RespT> newBuilder(Marshaller<ReqT> paramMarshaller, Marshaller<RespT> paramMarshaller1) {
    return (new Builder<ReqT, RespT>()).setRequestMarshaller(paramMarshaller).setResponseMarshaller(paramMarshaller1);
  }
  
  public String getFullMethodName() {
    return this.fullMethodName;
  }
  
  final Object getRawMethodName(int paramInt) {
    return this.rawMethodNames.get(paramInt);
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2592")
  public Marshaller<ReqT> getRequestMarshaller() {
    return this.requestMarshaller;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2592")
  public Marshaller<RespT> getResponseMarshaller() {
    return this.responseMarshaller;
  }
  
  @Nullable
  public Object getSchemaDescriptor() {
    return this.schemaDescriptor;
  }
  
  public MethodType getType() {
    return this.type;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
  public boolean isIdempotent() {
    return this.idempotent;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
  public boolean isSafe() {
    return this.safe;
  }
  
  public boolean isSampledToLocalTracing() {
    return this.sampledToLocalTracing;
  }
  
  public ReqT parseRequest(InputStream paramInputStream) {
    return (ReqT)this.requestMarshaller.parse(paramInputStream);
  }
  
  public RespT parseResponse(InputStream paramInputStream) {
    return (RespT)this.responseMarshaller.parse(paramInputStream);
  }
  
  final void setRawMethodName(int paramInt, Object paramObject) {
    this.rawMethodNames.lazySet(paramInt, paramObject);
  }
  
  public InputStream streamRequest(ReqT paramReqT) {
    return this.requestMarshaller.stream(paramReqT);
  }
  
  public InputStream streamResponse(RespT paramRespT) {
    return this.responseMarshaller.stream(paramRespT);
  }
  
  @CheckReturnValue
  public Builder<ReqT, RespT> toBuilder() {
    return toBuilder(this.requestMarshaller, this.responseMarshaller);
  }
  
  @CheckReturnValue
  public <NewReqT, NewRespT> Builder<NewReqT, NewRespT> toBuilder(Marshaller<NewReqT> paramMarshaller, Marshaller<NewRespT> paramMarshaller1) {
    return newBuilder().setRequestMarshaller(paramMarshaller).setResponseMarshaller(paramMarshaller1).setType(this.type).setFullMethodName(this.fullMethodName).setIdempotent(this.idempotent).setSafe(this.safe).setSampledToLocalTracing(this.sampledToLocalTracing).setSchemaDescriptor(this.schemaDescriptor);
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("fullMethodName", this.fullMethodName).add("type", this.type).add("idempotent", this.idempotent).add("safe", this.safe).add("sampledToLocalTracing", this.sampledToLocalTracing).add("requestMarshaller", this.requestMarshaller).add("responseMarshaller", this.responseMarshaller).add("schemaDescriptor", this.schemaDescriptor).omitNullValues().toString();
  }
  
  public static final class Builder<ReqT, RespT> {
    private String fullMethodName;
    
    private boolean idempotent;
    
    private MethodDescriptor.Marshaller<ReqT> requestMarshaller;
    
    private MethodDescriptor.Marshaller<RespT> responseMarshaller;
    
    private boolean safe;
    
    private boolean sampledToLocalTracing;
    
    private Object schemaDescriptor;
    
    private MethodDescriptor.MethodType type;
    
    private Builder() {}
    
    @CheckReturnValue
    public MethodDescriptor<ReqT, RespT> build() {
      return new MethodDescriptor(this.type, this.fullMethodName, this.requestMarshaller, this.responseMarshaller, this.schemaDescriptor, this.idempotent, this.safe, this.sampledToLocalTracing);
    }
    
    public Builder<ReqT, RespT> setFullMethodName(String param1String) {
      this.fullMethodName = param1String;
      return this;
    }
    
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
    public Builder<ReqT, RespT> setIdempotent(boolean param1Boolean) {
      this.idempotent = param1Boolean;
      return this;
    }
    
    public Builder<ReqT, RespT> setRequestMarshaller(MethodDescriptor.Marshaller<ReqT> param1Marshaller) {
      this.requestMarshaller = param1Marshaller;
      return this;
    }
    
    public Builder<ReqT, RespT> setResponseMarshaller(MethodDescriptor.Marshaller<RespT> param1Marshaller) {
      this.responseMarshaller = param1Marshaller;
      return this;
    }
    
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1775")
    public Builder<ReqT, RespT> setSafe(boolean param1Boolean) {
      this.safe = param1Boolean;
      return this;
    }
    
    public Builder<ReqT, RespT> setSampledToLocalTracing(boolean param1Boolean) {
      this.sampledToLocalTracing = param1Boolean;
      return this;
    }
    
    public Builder<ReqT, RespT> setSchemaDescriptor(@Nullable Object param1Object) {
      this.schemaDescriptor = param1Object;
      return this;
    }
    
    public Builder<ReqT, RespT> setType(MethodDescriptor.MethodType param1MethodType) {
      this.type = param1MethodType;
      return this;
    }
  }
  
  class MethodDescriptor {}
  
  class MethodDescriptor {}
  
  class MethodDescriptor {}
  
  class MethodDescriptor {}
}


/* Location:              Y:\classes-dex2jar.jar!\io\grpc\MethodDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */