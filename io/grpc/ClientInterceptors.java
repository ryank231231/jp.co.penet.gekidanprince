package io.grpc;

import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ClientInterceptors {
  private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() {
      public void cancel(String param1String, Throwable param1Throwable) {}
      
      public void halfClose() {}
      
      public boolean isReady() {
        return false;
      }
      
      public void request(int param1Int) {}
      
      public void sendMessage(Object param1Object) {}
      
      public void start(ClientCall.Listener<Object> param1Listener, Metadata param1Metadata) {}
    };
  
  public static Channel intercept(Channel paramChannel, List<? extends ClientInterceptor> paramList) {
    Preconditions.checkNotNull(paramChannel, "channel");
    Iterator<? extends ClientInterceptor> iterator = paramList.iterator();
    while (iterator.hasNext())
      paramChannel = new InterceptorChannel(paramChannel, iterator.next()); 
    return paramChannel;
  }
  
  public static Channel intercept(Channel paramChannel, ClientInterceptor... paramVarArgs) {
    return intercept(paramChannel, Arrays.asList(paramVarArgs));
  }
  
  public static Channel interceptForward(Channel paramChannel, List<? extends ClientInterceptor> paramList) {
    paramList = new ArrayList<ClientInterceptor>(paramList);
    Collections.reverse(paramList);
    return intercept(paramChannel, paramList);
  }
  
  public static Channel interceptForward(Channel paramChannel, ClientInterceptor... paramVarArgs) {
    return interceptForward(paramChannel, Arrays.asList(paramVarArgs));
  }
  
  static <WReqT, WRespT> ClientInterceptor wrapClientInterceptor(final ClientInterceptor interceptor, final MethodDescriptor$Marshaller<WReqT> reqMarshaller, final MethodDescriptor$Marshaller<WRespT> respMarshaller) {
    return new ClientInterceptor() {
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(final MethodDescriptor<ReqT, RespT> method, CallOptions param1CallOptions, Channel param1Channel) {
          MethodDescriptor methodDescriptor = method.toBuilder(reqMarshaller, respMarshaller).build();
          return new PartialForwardingClientCall<ReqT, RespT>() {
              protected ClientCall<?, ?> delegate() {
                return wrappedCall;
              }
              
              public void sendMessage(ReqT param2ReqT) {
                InputStream inputStream = method.getRequestMarshaller().stream(param2ReqT);
                inputStream = reqMarshaller.parse(inputStream);
                wrappedCall.sendMessage(inputStream);
              }
              
              public void start(final ClientCall.Listener<RespT> responseListener, Metadata param2Metadata) {
                wrappedCall.start(new PartialForwardingClientCallListener() {
                      protected ClientCall.Listener<?> delegate() {
                        return responseListener;
                      }
                      
                      public void onMessage(WRespT param3WRespT) {
                        InputStream inputStream = respMarshaller.stream(param3WRespT);
                        inputStream = method.getResponseMarshaller().parse(inputStream);
                        responseListener.onMessage(inputStream);
                      }
                    },  param2Metadata);
              }
            };
        }
      };
  }
  
  public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
    private ClientCall<ReqT, RespT> delegate;
    
    protected CheckedForwardingClientCall(ClientCall<ReqT, RespT> param1ClientCall) {
      this.delegate = param1ClientCall;
    }
    
    protected abstract void checkedStart(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) throws Exception;
    
    protected final ClientCall<ReqT, RespT> delegate() {
      return this.delegate;
    }
    
    public final void start(ClientCall.Listener<RespT> param1Listener, Metadata param1Metadata) {
      try {
        checkedStart(param1Listener, param1Metadata);
      } catch (Exception exception) {
        this.delegate = (ClientCall)ClientInterceptors.NOOP_CALL;
        param1Listener.onClose(Status.fromThrowable(exception), new Metadata());
      } 
    }
  }
  
  private static class InterceptorChannel extends Channel {
    private final Channel channel;
    
    private final ClientInterceptor interceptor;
    
    private InterceptorChannel(Channel param1Channel, ClientInterceptor param1ClientInterceptor) {
      this.channel = param1Channel;
      this.interceptor = (ClientInterceptor)Preconditions.checkNotNull(param1ClientInterceptor, "interceptor");
    }
    
    public String authority() {
      return this.channel.authority();
    }
    
    public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> param1MethodDescriptor, CallOptions param1CallOptions) {
      return this.interceptor.interceptCall(param1MethodDescriptor, param1CallOptions, this.channel);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\ClientInterceptors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */