package io.grpc.internal;

import com.google.common.base.MoreObjects;
import io.grpc.Metadata;
import io.grpc.Status;

abstract class ForwardingClientStreamListener implements ClientStreamListener {
  public void closed(Status paramStatus, Metadata paramMetadata) {
    delegate().closed(paramStatus, paramMetadata);
  }
  
  public void closed(Status paramStatus, ClientStreamListener.RpcProgress paramRpcProgress, Metadata paramMetadata) {
    delegate().closed(paramStatus, paramRpcProgress, paramMetadata);
  }
  
  protected abstract ClientStreamListener delegate();
  
  public void headersRead(Metadata paramMetadata) {
    delegate().headersRead(paramMetadata);
  }
  
  public void messagesAvailable(StreamListener.MessageProducer paramMessageProducer) {
    delegate().messagesAvailable(paramMessageProducer);
  }
  
  public void onReady() {
    delegate().onReady();
  }
  
  public String toString() {
    return MoreObjects.toStringHelper(this).add("delegate", delegate()).toString();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ForwardingClientStreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */