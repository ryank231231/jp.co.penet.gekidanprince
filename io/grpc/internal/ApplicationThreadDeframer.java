package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;

public class ApplicationThreadDeframer implements Deframer, MessageDeframer.Listener {
  private final MessageDeframer deframer;
  
  private final Queue<InputStream> messageReadQueue = new ArrayDeque<InputStream>();
  
  private final MessageDeframer.Listener storedListener;
  
  private final TransportExecutor transportExecutor;
  
  ApplicationThreadDeframer(MessageDeframer.Listener paramListener, TransportExecutor paramTransportExecutor, MessageDeframer paramMessageDeframer) {
    this.storedListener = (MessageDeframer.Listener)Preconditions.checkNotNull(paramListener, "listener");
    this.transportExecutor = (TransportExecutor)Preconditions.checkNotNull(paramTransportExecutor, "transportExecutor");
    paramMessageDeframer.setListener(this);
    this.deframer = paramMessageDeframer;
  }
  
  public void bytesRead(final int numBytes) {
    this.transportExecutor.runOnTransportThread(new Runnable() {
          public void run() {
            ApplicationThreadDeframer.this.storedListener.bytesRead(numBytes);
          }
        });
  }
  
  public void close() {
    this.deframer.stopDelivery();
    this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
              ApplicationThreadDeframer.this.deframer.close();
            }
          }));
  }
  
  public void closeWhenComplete() {
    this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
              ApplicationThreadDeframer.this.deframer.closeWhenComplete();
            }
          }));
  }
  
  public void deframe(final ReadableBuffer data) {
    this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
              try {
                ApplicationThreadDeframer.this.deframer.deframe(data);
              } catch (Throwable throwable) {
                ApplicationThreadDeframer.this.deframeFailed(throwable);
                ApplicationThreadDeframer.this.deframer.close();
              } 
            }
          }));
  }
  
  public void deframeFailed(final Throwable cause) {
    this.transportExecutor.runOnTransportThread(new Runnable() {
          public void run() {
            ApplicationThreadDeframer.this.storedListener.deframeFailed(cause);
          }
        });
  }
  
  public void deframerClosed(final boolean hasPartialMessage) {
    this.transportExecutor.runOnTransportThread(new Runnable() {
          public void run() {
            ApplicationThreadDeframer.this.storedListener.deframerClosed(hasPartialMessage);
          }
        });
  }
  
  public void messagesAvailable(StreamListener.MessageProducer paramMessageProducer) {
    while (true) {
      InputStream inputStream = paramMessageProducer.next();
      if (inputStream != null) {
        this.messageReadQueue.add(inputStream);
        continue;
      } 
      break;
    } 
  }
  
  public void request(final int numMessages) {
    this.storedListener.messagesAvailable(new InitializingMessageProducer(new Runnable() {
            public void run() {
              if (ApplicationThreadDeframer.this.deframer.isClosed())
                return; 
              try {
                ApplicationThreadDeframer.this.deframer.request(numMessages);
              } catch (Throwable throwable) {
                ApplicationThreadDeframer.this.storedListener.deframeFailed(throwable);
                ApplicationThreadDeframer.this.deframer.close();
              } 
            }
          }));
  }
  
  public void setDecompressor(Decompressor paramDecompressor) {
    this.deframer.setDecompressor(paramDecompressor);
  }
  
  public void setFullStreamDecompressor(GzipInflatingBuffer paramGzipInflatingBuffer) {
    this.deframer.setFullStreamDecompressor(paramGzipInflatingBuffer);
  }
  
  public void setMaxInboundMessageSize(int paramInt) {
    this.deframer.setMaxInboundMessageSize(paramInt);
  }
  
  private class InitializingMessageProducer implements StreamListener.MessageProducer {
    private boolean initialized = false;
    
    private final Runnable runnable;
    
    private InitializingMessageProducer(Runnable param1Runnable) {
      this.runnable = param1Runnable;
    }
    
    private void initialize() {
      if (!this.initialized) {
        this.runnable.run();
        this.initialized = true;
      } 
    }
    
    @Nullable
    public InputStream next() {
      initialize();
      return ApplicationThreadDeframer.this.messageReadQueue.poll();
    }
  }
  
  static interface TransportExecutor {
    void runOnTransportThread(Runnable param1Runnable);
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\internal\ApplicationThreadDeframer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */