package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public final class CallOptions {
  public static final CallOptions DEFAULT = new CallOptions();
  
  @Nullable
  private String authority;
  
  @Nullable
  private String compressorName;
  
  @Nullable
  private CallCredentials credentials;
  
  private Object[][] customOptions = new Object[0][2];
  
  private Deadline deadline;
  
  private Executor executor;
  
  @Nullable
  private Integer maxInboundMessageSize;
  
  @Nullable
  private Integer maxOutboundMessageSize;
  
  private List<ClientStreamTracer.Factory> streamTracerFactories = Collections.emptyList();
  
  private boolean waitForReady;
  
  private CallOptions() {}
  
  private CallOptions(CallOptions paramCallOptions) {
    this.deadline = paramCallOptions.deadline;
    this.authority = paramCallOptions.authority;
    this.credentials = paramCallOptions.credentials;
    this.executor = paramCallOptions.executor;
    this.compressorName = paramCallOptions.compressorName;
    this.customOptions = paramCallOptions.customOptions;
    this.waitForReady = paramCallOptions.waitForReady;
    this.maxInboundMessageSize = paramCallOptions.maxInboundMessageSize;
    this.maxOutboundMessageSize = paramCallOptions.maxOutboundMessageSize;
    this.streamTracerFactories = paramCallOptions.streamTracerFactories;
  }
  
  @Nullable
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1767")
  public String getAuthority() {
    return this.authority;
  }
  
  @Nullable
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public String getCompressor() {
    return this.compressorName;
  }
  
  @Nullable
  public CallCredentials getCredentials() {
    return this.credentials;
  }
  
  @Nullable
  public Deadline getDeadline() {
    return this.deadline;
  }
  
  @Nullable
  public Executor getExecutor() {
    return this.executor;
  }
  
  @Nullable
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
  public Integer getMaxInboundMessageSize() {
    return this.maxInboundMessageSize;
  }
  
  @Nullable
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
  public Integer getMaxOutboundMessageSize() {
    return this.maxOutboundMessageSize;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
  public <T> T getOption(Key<T> paramKey) {
    Preconditions.checkNotNull(paramKey, "key");
    byte b = 0;
    while (true) {
      Object[][] arrayOfObject = this.customOptions;
      if (b < arrayOfObject.length) {
        if (paramKey.equals(arrayOfObject[b][0]))
          return (T)this.customOptions[b][1]; 
        b++;
        continue;
      } 
      return paramKey.defaultValue;
    } 
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
  public List<ClientStreamTracer.Factory> getStreamTracerFactories() {
    return this.streamTracerFactories;
  }
  
  public boolean isWaitForReady() {
    return this.waitForReady;
  }
  
  public String toString() {
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.toStringHelper(this).add("deadline", this.deadline).add("authority", this.authority).add("callCredentials", this.credentials);
    Executor executor = this.executor;
    if (executor != null) {
      Class<?> clazz = executor.getClass();
    } else {
      executor = null;
    } 
    return toStringHelper.add("executor", executor).add("compressorName", this.compressorName).add("customOptions", Arrays.deepToString((Object[])this.customOptions)).add("waitForReady", isWaitForReady()).add("maxInboundMessageSize", this.maxInboundMessageSize).add("maxOutboundMessageSize", this.maxOutboundMessageSize).add("streamTracerFactories", this.streamTracerFactories).toString();
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1767")
  public CallOptions withAuthority(@Nullable String paramString) {
    CallOptions callOptions = new CallOptions(this);
    callOptions.authority = paramString;
    return callOptions;
  }
  
  public CallOptions withCallCredentials(@Nullable CallCredentials paramCallCredentials) {
    CallOptions callOptions = new CallOptions(this);
    callOptions.credentials = paramCallCredentials;
    return callOptions;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
  public CallOptions withCompression(@Nullable String paramString) {
    CallOptions callOptions = new CallOptions(this);
    callOptions.compressorName = paramString;
    return callOptions;
  }
  
  public CallOptions withDeadline(@Nullable Deadline paramDeadline) {
    CallOptions callOptions = new CallOptions(this);
    callOptions.deadline = paramDeadline;
    return callOptions;
  }
  
  public CallOptions withDeadlineAfter(long paramLong, TimeUnit paramTimeUnit) {
    return withDeadline(Deadline.after(paramLong, paramTimeUnit));
  }
  
  public CallOptions withExecutor(Executor paramExecutor) {
    CallOptions callOptions = new CallOptions(this);
    callOptions.executor = paramExecutor;
    return callOptions;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
  public CallOptions withMaxInboundMessageSize(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "invalid maxsize %s", paramInt);
    CallOptions callOptions = new CallOptions(this);
    callOptions.maxInboundMessageSize = Integer.valueOf(paramInt);
    return callOptions;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
  public CallOptions withMaxOutboundMessageSize(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "invalid maxsize %s", paramInt);
    CallOptions callOptions = new CallOptions(this);
    callOptions.maxOutboundMessageSize = Integer.valueOf(paramInt);
    return callOptions;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
  public <T> CallOptions withOption(Key<T> paramKey, T paramT) {
    byte b1;
    Preconditions.checkNotNull(paramKey, "key");
    Preconditions.checkNotNull(paramT, "value");
    CallOptions callOptions = new CallOptions(this);
    byte b = 0;
    while (true) {
      Object[][] arrayOfObject1 = this.customOptions;
      if (b < arrayOfObject1.length) {
        if (paramKey.equals(arrayOfObject1[b][0]))
          break; 
        b++;
        continue;
      } 
      b = -1;
      break;
    } 
    int i = this.customOptions.length;
    if (b == -1) {
      b1 = 1;
    } else {
      b1 = 0;
    } 
    callOptions.customOptions = new Object[i + b1][2];
    Object[][] arrayOfObject = this.customOptions;
    System.arraycopy(arrayOfObject, 0, callOptions.customOptions, 0, arrayOfObject.length);
    if (b == -1) {
      (new Object[2])[0] = paramKey;
      (new Object[2])[1] = paramT;
      callOptions.customOptions[this.customOptions.length] = new Object[2];
    } else {
      callOptions.customOptions[b][1] = paramT;
    } 
    return callOptions;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
  public CallOptions withStreamTracerFactory(ClientStreamTracer.Factory paramFactory) {
    CallOptions callOptions = new CallOptions(this);
    ArrayList<ClientStreamTracer.Factory> arrayList = new ArrayList(this.streamTracerFactories.size() + 1);
    arrayList.addAll(this.streamTracerFactories);
    arrayList.add(paramFactory);
    callOptions.streamTracerFactories = Collections.unmodifiableList(arrayList);
    return callOptions;
  }
  
  public CallOptions withWaitForReady() {
    CallOptions callOptions = new CallOptions(this);
    callOptions.waitForReady = true;
    return callOptions;
  }
  
  public CallOptions withoutWaitForReady() {
    CallOptions callOptions = new CallOptions(this);
    callOptions.waitForReady = false;
    return callOptions;
  }
  
  @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
  public static final class Key<T> {
    private final T defaultValue;
    
    private final String name;
    
    private Key(String param1String, T param1T) {
      this.name = param1String;
      this.defaultValue = param1T;
    }
    
    public static <T> Key<T> of(String param1String, T param1T) {
      Preconditions.checkNotNull(param1String, "name");
      return new Key<T>(param1String, param1T);
    }
    
    public T getDefault() {
      return this.defaultValue;
    }
    
    public String toString() {
      return this.name;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\CallOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */