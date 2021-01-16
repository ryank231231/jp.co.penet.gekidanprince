package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.Nullable;
import okio.Buffer;

class OutboundFlowController {
  private final OutboundFlowState connectionState = new OutboundFlowState(0);
  
  private final FrameWriter frameWriter;
  
  private int initialWindowSize = 65535;
  
  private final OkHttpClientTransport transport;
  
  OutboundFlowController(OkHttpClientTransport paramOkHttpClientTransport, FrameWriter paramFrameWriter) {
    this.transport = (OkHttpClientTransport)Preconditions.checkNotNull(paramOkHttpClientTransport, "transport");
    this.frameWriter = (FrameWriter)Preconditions.checkNotNull(paramFrameWriter, "frameWriter");
  }
  
  private OutboundFlowState state(OkHttpClientStream paramOkHttpClientStream) {
    OutboundFlowState outboundFlowState1 = (OutboundFlowState)paramOkHttpClientStream.getOutboundFlowState();
    OutboundFlowState outboundFlowState2 = outboundFlowState1;
    if (outboundFlowState1 == null) {
      outboundFlowState2 = new OutboundFlowState(paramOkHttpClientStream);
      paramOkHttpClientStream.setOutboundFlowState(outboundFlowState2);
    } 
    return outboundFlowState2;
  }
  
  private void writeStreams() {
    int k;
    OkHttpClientStream[] arrayOfOkHttpClientStream = this.transport.getActiveStreams();
    int i = this.connectionState.window();
    int j = arrayOfOkHttpClientStream.length;
    while (true) {
      k = 0;
      byte b = 0;
      if (j > 0 && i > 0) {
        int m = (int)Math.ceil((i / j));
        for (k = 0; b < j && i > 0; k = n) {
          OkHttpClientStream okHttpClientStream = arrayOfOkHttpClientStream[b];
          OutboundFlowState outboundFlowState = state(okHttpClientStream);
          int n = Math.min(i, Math.min(outboundFlowState.unallocatedBytes(), m));
          int i1 = i;
          if (n > 0) {
            outboundFlowState.allocateBytes(n);
            i1 = i - n;
          } 
          n = k;
          if (outboundFlowState.unallocatedBytes() > 0) {
            arrayOfOkHttpClientStream[k] = okHttpClientStream;
            n = k + 1;
          } 
          b++;
          i = i1;
        } 
        j = k;
        continue;
      } 
      break;
    } 
    WriteStatus writeStatus = new WriteStatus();
    arrayOfOkHttpClientStream = this.transport.getActiveStreams();
    j = arrayOfOkHttpClientStream.length;
    while (k < j) {
      OutboundFlowState outboundFlowState = state(arrayOfOkHttpClientStream[k]);
      outboundFlowState.writeBytes(outboundFlowState.allocatedBytes(), writeStatus);
      outboundFlowState.clearAllocatedBytes();
      k++;
    } 
    if (writeStatus.hasWritten())
      flush(); 
  }
  
  void data(boolean paramBoolean1, int paramInt, Buffer paramBuffer, boolean paramBoolean2) {
    Preconditions.checkNotNull(paramBuffer, "source");
    OkHttpClientStream okHttpClientStream = this.transport.getStream(paramInt);
    if (okHttpClientStream == null)
      return; 
    OutboundFlowState outboundFlowState = state(okHttpClientStream);
    paramInt = outboundFlowState.writableWindow();
    boolean bool = outboundFlowState.hasFrame();
    OutboundFlowState.Frame frame = outboundFlowState.newFrame(paramBuffer, paramBoolean1);
    if (!bool && paramInt >= frame.size()) {
      frame.write();
      if (paramBoolean2)
        flush(); 
      return;
    } 
    frame.enqueue();
    if (bool || paramInt <= 0) {
      if (paramBoolean2)
        flush(); 
      return;
    } 
    frame.split(paramInt).write();
    if (paramBoolean2)
      flush(); 
  }
  
  void flush() {
    try {
      this.frameWriter.flush();
      return;
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  void initialOutboundWindowSize(int paramInt) {
    if (paramInt >= 0) {
      int i = paramInt - this.initialWindowSize;
      this.initialWindowSize = paramInt;
      OkHttpClientStream[] arrayOfOkHttpClientStream = this.transport.getActiveStreams();
      int j = arrayOfOkHttpClientStream.length;
      for (paramInt = 0; paramInt < j; paramInt++) {
        OkHttpClientStream okHttpClientStream = arrayOfOkHttpClientStream[paramInt];
        OutboundFlowState outboundFlowState = (OutboundFlowState)okHttpClientStream.getOutboundFlowState();
        if (outboundFlowState == null) {
          okHttpClientStream.setOutboundFlowState(new OutboundFlowState(okHttpClientStream));
        } else {
          outboundFlowState.incrementStreamWindow(i);
        } 
      } 
      if (i > 0)
        writeStreams(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid initial window size: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  int windowUpdate(@Nullable OkHttpClientStream paramOkHttpClientStream, int paramInt) {
    if (paramOkHttpClientStream == null) {
      paramInt = this.connectionState.incrementStreamWindow(paramInt);
      writeStreams();
    } else {
      OutboundFlowState outboundFlowState = state(paramOkHttpClientStream);
      paramInt = outboundFlowState.incrementStreamWindow(paramInt);
      WriteStatus writeStatus = new WriteStatus();
      outboundFlowState.writeBytes(outboundFlowState.writableWindow(), writeStatus);
      if (writeStatus.hasWritten())
        flush(); 
    } 
    return paramInt;
  }
  
  private final class OutboundFlowState {
    int allocatedBytes;
    
    final Queue<Frame> pendingWriteQueue;
    
    int queuedBytes;
    
    OkHttpClientStream stream;
    
    final int streamId;
    
    int window = OutboundFlowController.this.initialWindowSize;
    
    OutboundFlowState(int param1Int) {
      this.streamId = param1Int;
      this.pendingWriteQueue = new ArrayDeque<Frame>(2);
    }
    
    OutboundFlowState(OkHttpClientStream param1OkHttpClientStream) {
      this(param1OkHttpClientStream.id());
      this.stream = param1OkHttpClientStream;
    }
    
    private Frame peek() {
      return this.pendingWriteQueue.peek();
    }
    
    void allocateBytes(int param1Int) {
      this.allocatedBytes += param1Int;
    }
    
    int allocatedBytes() {
      return this.allocatedBytes;
    }
    
    void clearAllocatedBytes() {
      this.allocatedBytes = 0;
    }
    
    boolean hasFrame() {
      return this.pendingWriteQueue.isEmpty() ^ true;
    }
    
    int incrementStreamWindow(int param1Int) {
      if (param1Int <= 0 || Integer.MAX_VALUE - param1Int >= this.window) {
        this.window += param1Int;
        return this.window;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Window size overflow for stream: ");
      stringBuilder.append(this.streamId);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    Frame newFrame(Buffer param1Buffer, boolean param1Boolean) {
      return new Frame(param1Buffer, param1Boolean);
    }
    
    int streamableBytes() {
      return Math.max(0, Math.min(this.window, this.queuedBytes));
    }
    
    int unallocatedBytes() {
      return streamableBytes() - this.allocatedBytes;
    }
    
    int window() {
      return this.window;
    }
    
    int writableWindow() {
      return Math.min(this.window, OutboundFlowController.this.connectionState.window());
    }
    
    int writeBytes(int param1Int, OutboundFlowController.WriteStatus param1WriteStatus) {
      int i = Math.min(param1Int, writableWindow());
      int j = 0;
      while (hasFrame()) {
        Frame frame = peek();
        if (i >= frame.size()) {
          param1WriteStatus.incrementNumWrites();
          j += frame.size();
          frame.write();
        } else {
          if (i <= 0)
            break; 
          frame = frame.split(i);
          param1WriteStatus.incrementNumWrites();
          j += frame.size();
          frame.write();
        } 
        i = Math.min(param1Int - j, writableWindow());
      } 
      return j;
    }
    
    private final class Frame {
      final Buffer data;
      
      final boolean endStream;
      
      boolean enqueued;
      
      Frame(Buffer param2Buffer, boolean param2Boolean) {
        this.data = param2Buffer;
        this.endStream = param2Boolean;
      }
      
      void enqueue() {
        if (!this.enqueued) {
          this.enqueued = true;
          OutboundFlowController.OutboundFlowState.this.pendingWriteQueue.offer(this);
          OutboundFlowController.OutboundFlowState outboundFlowState = OutboundFlowController.OutboundFlowState.this;
          outboundFlowState.queuedBytes += size();
        } 
      }
      
      int size() {
        return (int)this.data.size();
      }
      
      Frame split(int param2Int) {
        param2Int = Math.min(param2Int, (int)this.data.size());
        Buffer buffer = new Buffer();
        buffer.write(this.data, param2Int);
        Frame frame = new Frame(buffer, false);
        if (this.enqueued) {
          OutboundFlowController.OutboundFlowState outboundFlowState = OutboundFlowController.OutboundFlowState.this;
          outboundFlowState.queuedBytes -= param2Int;
        } 
        return frame;
      }
      
      void write() {
        do {
          int i = size();
          int j = Math.min(i, OutboundFlowController.this.frameWriter.maxDataLength());
          if (j == i) {
            OutboundFlowController.OutboundFlowState outboundFlowState = OutboundFlowController.this.connectionState;
            j = -i;
            outboundFlowState.incrementStreamWindow(j);
            OutboundFlowController.OutboundFlowState.this.incrementStreamWindow(j);
            try {
              OutboundFlowController.this.frameWriter.data(this.endStream, OutboundFlowController.OutboundFlowState.this.streamId, this.data, i);
              OutboundFlowController.OutboundFlowState.this.stream.transportState().onSentBytes(i);
              if (this.enqueued) {
                outboundFlowState = OutboundFlowController.OutboundFlowState.this;
                outboundFlowState.queuedBytes -= i;
                OutboundFlowController.OutboundFlowState.this.pendingWriteQueue.remove(this);
              } 
              return;
            } catch (IOException iOException) {
              throw new RuntimeException(iOException);
            } 
          } 
          split(j).write();
        } while (size() > 0);
      }
    }
  }
  
  private final class Frame {
    final Buffer data;
    
    final boolean endStream;
    
    boolean enqueued;
    
    Frame(Buffer param1Buffer, boolean param1Boolean) {
      this.data = param1Buffer;
      this.endStream = param1Boolean;
    }
    
    void enqueue() {
      if (!this.enqueued) {
        this.enqueued = true;
        this.this$1.pendingWriteQueue.offer(this);
        OutboundFlowController.OutboundFlowState outboundFlowState = this.this$1;
        outboundFlowState.queuedBytes += size();
      } 
    }
    
    int size() {
      return (int)this.data.size();
    }
    
    Frame split(int param1Int) {
      param1Int = Math.min(param1Int, (int)this.data.size());
      Buffer buffer = new Buffer();
      buffer.write(this.data, param1Int);
      Frame frame = new Frame(buffer, false);
      if (this.enqueued) {
        OutboundFlowController.OutboundFlowState outboundFlowState = this.this$1;
        outboundFlowState.queuedBytes -= param1Int;
      } 
      return frame;
    }
    
    void write() {
      do {
        int i = size();
        int j = Math.min(i, OutboundFlowController.this.frameWriter.maxDataLength());
        if (j == i) {
          OutboundFlowController.OutboundFlowState outboundFlowState = OutboundFlowController.this.connectionState;
          j = -i;
          outboundFlowState.incrementStreamWindow(j);
          this.this$1.incrementStreamWindow(j);
          try {
            OutboundFlowController.this.frameWriter.data(this.endStream, this.this$1.streamId, this.data, i);
            this.this$1.stream.transportState().onSentBytes(i);
            if (this.enqueued) {
              outboundFlowState = this.this$1;
              outboundFlowState.queuedBytes -= i;
              this.this$1.pendingWriteQueue.remove(this);
            } 
            return;
          } catch (IOException iOException) {
            throw new RuntimeException(iOException);
          } 
        } 
        split(j).write();
      } while (size() > 0);
    }
  }
  
  private static final class WriteStatus {
    int numWrites;
    
    private WriteStatus() {}
    
    boolean hasWritten() {
      boolean bool;
      if (this.numWrites > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    void incrementNumWrites() {
      this.numWrites++;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\grpc\okhttp\OutboundFlowController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */