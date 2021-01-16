package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import io.grpc.Status;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

final class CallCredentialsApplyingTransportFactory implements ClientTransportFactory {
  private final Executor appExecutor;
  
  private final ClientTransportFactory delegate;
  
  CallCredentialsApplyingTransportFactory(ClientTransportFactory paramClientTransportFactory, Executor paramExecutor) {
    this.delegate = (ClientTransportFactory)Preconditions.checkNotNull(paramClientTransportFactory, "delegate");
    this.appExecutor = (Executor)Preconditions.checkNotNull(paramExecutor, "appExecutor");
  }
  
  public void close() {
    this.delegate.close();
  }
  
  public ScheduledExecutorService getScheduledExecutorService() {
    return this.delegate.getScheduledExecutorService();
  }
  
  public ConnectionClientTransport newClientTransport(SocketAddress paramSocketAddress, String paramString1, @Nullable String paramString2, @Nullable ProxyParameters paramProxyParameters) {
    return new CallCredentialsApplyingTransport(this.delegate.newClientTransport(paramSocketAddress, paramString1, paramString2, paramProxyParameters), paramString1);
  }
  
  private class CallCredentialsApplyingTransport extends ForwardingConnectionClientTransport {
    private final String authority;
    
    private final ConnectionClientTransport delegate;
    
    CallCredentialsApplyingTransport(ConnectionClientTransport param1ConnectionClientTransport, String param1String) {
      this.delegate = (ConnectionClientTransport)Preconditions.checkNotNull(param1ConnectionClientTransport, "delegate");
      this.authority = (String)Preconditions.checkNotNull(param1String, "authority");
    }
    
    protected ConnectionClientTransport delegate() {
      return this.delegate;
    }
    
    public ClientStream newStream(MethodDescriptor<?, ?> param1MethodDescriptor, Metadata param1Metadata, CallOptions param1CallOptions) {
      MetadataApplierImpl metadataApplierImpl;
      CallCredentials callCredentials = param1CallOptions.getCredentials();
      if (callCredentials != null) {
        metadataApplierImpl = new MetadataApplierImpl((ClientTransport)this.delegate, param1MethodDescriptor, param1Metadata, param1CallOptions);
        Attributes.Builder builder = Attributes.newBuilder().set(CallCredentials.ATTR_AUTHORITY, this.authority).set(CallCredentials.ATTR_SECURITY_LEVEL, SecurityLevel.NONE).setAll(this.delegate.getAttributes());
        if (param1CallOptions.getAuthority() != null)
          builder.set(CallCredentials.ATTR_AUTHORITY, param1CallOptions.getAuthority()); 
        try {
          callCredentials.applyRequestMetadata(param1MethodDescriptor, builder.build(), (Executor)MoreObjects.firstNonNull(param1CallOptions.getExecutor(), CallCredentialsApplyingTransportFactory.this.appExecutor), metadataApplierImpl);
        } catch (Throwable throwable) {
          metadataApplierImpl.fail(Status.UNAUTHENTICATED.withDescription("Credentials should use fail() instead of throwing exceptions").withCause(throwable));
        } 
        return metadataApplierImpl.returnStream();
      } 
      return this.delegate.newStream((MethodDescriptor)throwable, (Metadata)metadataApplierImpl, param1CallOptions);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\CallCredentialsApplyingTransportFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */