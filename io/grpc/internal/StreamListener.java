package io.grpc.internal;

import java.io.InputStream;
import javax.annotation.Nullable;

public interface StreamListener {
  void messagesAvailable(MessageProducer paramMessageProducer);
  
  void onReady();
  
  public static interface MessageProducer {
    @Nullable
    InputStream next();
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\StreamListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */