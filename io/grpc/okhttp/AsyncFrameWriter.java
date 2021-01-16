package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;

class AsyncFrameWriter implements FrameWriter {
  private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
  
  private final SerializingExecutor executor;
  
  private FrameWriter frameWriter;
  
  private Socket socket;
  
  private final OkHttpClientTransport transport;
  
  public AsyncFrameWriter(OkHttpClientTransport paramOkHttpClientTransport, SerializingExecutor paramSerializingExecutor) {
    this.transport = paramOkHttpClientTransport;
    this.executor = paramSerializingExecutor;
  }
  
  public void ackSettings(final Settings peerSettings) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.ackSettings(peerSettings);
          }
        });
  }
  
  void becomeConnected(FrameWriter paramFrameWriter, Socket paramSocket) {
    boolean bool;
    if (this.frameWriter == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool, "AsyncFrameWriter's setFrameWriter() should only be called once.");
    this.frameWriter = (FrameWriter)Preconditions.checkNotNull(paramFrameWriter, "frameWriter");
    this.socket = (Socket)Preconditions.checkNotNull(paramSocket, "socket");
  }
  
  public void close() {
    this.executor.execute(new Runnable() {
          public void run() {
            if (AsyncFrameWriter.this.frameWriter != null)
              try {
                AsyncFrameWriter.this.frameWriter.close();
                AsyncFrameWriter.this.socket.close();
              } catch (IOException iOException) {
                AsyncFrameWriter.log.log(Level.WARNING, "Failed closing connection", iOException);
              }  
          }
        });
  }
  
  public void connectionPreface() {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.connectionPreface();
          }
        });
  }
  
  public void data(final boolean outFinished, final int streamId, final Buffer source, final int byteCount) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.data(outFinished, streamId, source, byteCount);
          }
        });
  }
  
  public void flush() {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.flush();
          }
        });
  }
  
  public void goAway(final int lastGoodStreamId, final ErrorCode errorCode, final byte[] debugData) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.goAway(lastGoodStreamId, errorCode, debugData);
            AsyncFrameWriter.this.frameWriter.flush();
          }
        });
  }
  
  public void headers(final int streamId, final List<Header> headerBlock) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.headers(streamId, headerBlock);
          }
        });
  }
  
  public int maxDataLength() {
    int i;
    FrameWriter frameWriter = this.frameWriter;
    if (frameWriter == null) {
      i = 16384;
    } else {
      i = frameWriter.maxDataLength();
    } 
    return i;
  }
  
  public void ping(final boolean ack, final int payload1, final int payload2) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.ping(ack, payload1, payload2);
          }
        });
  }
  
  public void pushPromise(final int streamId, final int promisedStreamId, final List<Header> requestHeaders) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.pushPromise(streamId, promisedStreamId, requestHeaders);
          }
        });
  }
  
  public void rstStream(final int streamId, final ErrorCode errorCode) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.rstStream(streamId, errorCode);
          }
        });
  }
  
  public void settings(final Settings okHttpSettings) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.settings(okHttpSettings);
          }
        });
  }
  
  public void synReply(final boolean outFinished, final int streamId, final List<Header> headerBlock) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.synReply(outFinished, streamId, headerBlock);
          }
        });
  }
  
  public void synStream(final boolean outFinished, final boolean inFinished, final int streamId, final int associatedStreamId, final List<Header> headerBlock) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.synStream(outFinished, inFinished, streamId, associatedStreamId, headerBlock);
          }
        });
  }
  
  public void windowUpdate(final int streamId, final long windowSizeIncrement) {
    this.executor.execute(new WriteRunnable() {
          public void doRun() throws IOException {
            AsyncFrameWriter.this.frameWriter.windowUpdate(streamId, windowSizeIncrement);
          }
        });
  }
  
  private abstract class WriteRunnable implements Runnable {
    private WriteRunnable() {}
    
    public abstract void doRun() throws IOException;
    
    public final void run() {
      try {
        if (AsyncFrameWriter.this.frameWriter != null) {
          doRun();
        } else {
          IOException iOException = new IOException();
          this("Unable to perform write due to unavailable frameWriter.");
          throw iOException;
        } 
      } catch (RuntimeException runtimeException) {
        AsyncFrameWriter.this.transport.onException(runtimeException);
      } catch (Exception exception) {
        AsyncFrameWriter.this.transport.onException(exception);
      } 
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\AsyncFrameWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */