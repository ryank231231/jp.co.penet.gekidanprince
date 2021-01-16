package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class AsyncTimeout extends Timeout {
  private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
  
  private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
  
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  
  @Nullable
  static AsyncTimeout head;
  
  private boolean inQueue;
  
  @Nullable
  private AsyncTimeout next;
  
  private long timeoutAt;
  
  @Nullable
  static AsyncTimeout awaitTimeout() throws InterruptedException {
    AsyncTimeout asyncTimeout1 = head.next;
    AsyncTimeout asyncTimeout2 = null;
    if (asyncTimeout1 == null) {
      long l1 = System.nanoTime();
      AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
      asyncTimeout1 = asyncTimeout2;
      if (head.next == null) {
        asyncTimeout1 = asyncTimeout2;
        if (System.nanoTime() - l1 >= IDLE_TIMEOUT_NANOS)
          asyncTimeout1 = head; 
      } 
      return asyncTimeout1;
    } 
    long l = asyncTimeout1.remainingNanos(System.nanoTime());
    if (l > 0L) {
      long l1 = l / 1000000L;
      AsyncTimeout.class.wait(l1, (int)(l - 1000000L * l1));
      return null;
    } 
    head.next = asyncTimeout1.next;
    asyncTimeout1.next = null;
    return asyncTimeout1;
  }
  
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout) {
    // Byte code:
    //   0: ldc okio/AsyncTimeout
    //   2: monitorenter
    //   3: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 45
    //   11: aload_1
    //   12: getfield next : Lokio/AsyncTimeout;
    //   15: aload_0
    //   16: if_acmpne -> 37
    //   19: aload_1
    //   20: aload_0
    //   21: getfield next : Lokio/AsyncTimeout;
    //   24: putfield next : Lokio/AsyncTimeout;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield next : Lokio/AsyncTimeout;
    //   32: ldc okio/AsyncTimeout
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_1
    //   38: getfield next : Lokio/AsyncTimeout;
    //   41: astore_1
    //   42: goto -> 7
    //   45: ldc okio/AsyncTimeout
    //   47: monitorexit
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_0
    //   51: ldc okio/AsyncTimeout
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	50	finally
    //   11	32	50	finally
    //   37	42	50	finally
  }
  
  private long remainingNanos(long paramLong) {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: ldc okio/AsyncTimeout
    //   2: monitorenter
    //   3: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   6: ifnonnull -> 39
    //   9: new okio/AsyncTimeout
    //   12: astore #4
    //   14: aload #4
    //   16: invokespecial <init> : ()V
    //   19: aload #4
    //   21: putstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   24: new okio/AsyncTimeout$Watchdog
    //   27: astore #4
    //   29: aload #4
    //   31: invokespecial <init> : ()V
    //   34: aload #4
    //   36: invokevirtual start : ()V
    //   39: invokestatic nanoTime : ()J
    //   42: lstore #5
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: ifeq -> 75
    //   50: iload_3
    //   51: ifeq -> 75
    //   54: aload_0
    //   55: lload_1
    //   56: aload_0
    //   57: invokevirtual deadlineNanoTime : ()J
    //   60: lload #5
    //   62: lsub
    //   63: invokestatic min : (JJ)J
    //   66: lload #5
    //   68: ladd
    //   69: putfield timeoutAt : J
    //   72: goto -> 104
    //   75: lload_1
    //   76: lconst_0
    //   77: lcmp
    //   78: ifeq -> 92
    //   81: aload_0
    //   82: lload_1
    //   83: lload #5
    //   85: ladd
    //   86: putfield timeoutAt : J
    //   89: goto -> 104
    //   92: iload_3
    //   93: ifeq -> 184
    //   96: aload_0
    //   97: aload_0
    //   98: invokevirtual deadlineNanoTime : ()J
    //   101: putfield timeoutAt : J
    //   104: aload_0
    //   105: lload #5
    //   107: invokespecial remainingNanos : (J)J
    //   110: lstore_1
    //   111: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   114: astore #4
    //   116: aload #4
    //   118: getfield next : Lokio/AsyncTimeout;
    //   121: ifnull -> 152
    //   124: lload_1
    //   125: aload #4
    //   127: getfield next : Lokio/AsyncTimeout;
    //   130: lload #5
    //   132: invokespecial remainingNanos : (J)J
    //   135: lcmp
    //   136: ifge -> 142
    //   139: goto -> 152
    //   142: aload #4
    //   144: getfield next : Lokio/AsyncTimeout;
    //   147: astore #4
    //   149: goto -> 116
    //   152: aload_0
    //   153: aload #4
    //   155: getfield next : Lokio/AsyncTimeout;
    //   158: putfield next : Lokio/AsyncTimeout;
    //   161: aload #4
    //   163: aload_0
    //   164: putfield next : Lokio/AsyncTimeout;
    //   167: aload #4
    //   169: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   172: if_acmpne -> 180
    //   175: ldc okio/AsyncTimeout
    //   177: invokevirtual notify : ()V
    //   180: ldc okio/AsyncTimeout
    //   182: monitorexit
    //   183: return
    //   184: new java/lang/AssertionError
    //   187: astore_0
    //   188: aload_0
    //   189: invokespecial <init> : ()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_0
    //   195: ldc okio/AsyncTimeout
    //   197: monitorexit
    //   198: aload_0
    //   199: athrow
    // Exception table:
    //   from	to	target	type
    //   3	39	194	finally
    //   39	44	194	finally
    //   54	72	194	finally
    //   81	89	194	finally
    //   96	104	194	finally
    //   104	116	194	finally
    //   116	139	194	finally
    //   142	149	194	finally
    //   152	180	194	finally
    //   184	194	194	finally
  }
  
  public final void enter() {
    if (!this.inQueue) {
      long l = timeoutNanos();
      boolean bool = hasDeadline();
      if (l == 0L && !bool)
        return; 
      this.inQueue = true;
      scheduleTimeout(this, l, bool);
      return;
    } 
    throw new IllegalStateException("Unbalanced enter/exit");
  }
  
  final IOException exit(IOException paramIOException) throws IOException {
    return !exit() ? paramIOException : newTimeoutException(paramIOException);
  }
  
  final void exit(boolean paramBoolean) throws IOException {
    if (!exit() || !paramBoolean)
      return; 
    throw newTimeoutException(null);
  }
  
  public final boolean exit() {
    if (!this.inQueue)
      return false; 
    this.inQueue = false;
    return cancelScheduledTimeout(this);
  }
  
  protected IOException newTimeoutException(@Nullable IOException paramIOException) {
    InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null)
      interruptedIOException.initCause(paramIOException); 
    return interruptedIOException;
  }
  
  public final Sink sink(final Sink sink) {
    return new Sink() {
        public void close() throws IOException {
          Exception exception;
          AsyncTimeout.this.enter();
          try {
            sink.close();
            AsyncTimeout.this.exit(true);
            return;
          } catch (IOException null) {
            throw AsyncTimeout.this.exit(exception);
          } finally {}
          AsyncTimeout.this.exit(false);
          throw exception;
        }
        
        public void flush() throws IOException {
          Exception exception;
          AsyncTimeout.this.enter();
          try {
            sink.flush();
            AsyncTimeout.this.exit(true);
            return;
          } catch (IOException null) {
            throw AsyncTimeout.this.exit(exception);
          } finally {}
          AsyncTimeout.this.exit(false);
          throw exception;
        }
        
        public Timeout timeout() {
          return AsyncTimeout.this;
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("AsyncTimeout.sink(");
          stringBuilder.append(sink);
          stringBuilder.append(")");
          return stringBuilder.toString();
        }
        
        public void write(Buffer param1Buffer, long param1Long) throws IOException {
          Util.checkOffsetAndCount(param1Buffer.size, 0L, param1Long);
          while (true) {
            long l = 0L;
            if (param1Long > 0L) {
              long l1;
              Segment segment = param1Buffer.head;
              while (true) {
                l1 = l;
                if (l < 65536L) {
                  l += (param1Buffer.head.limit - param1Buffer.head.pos);
                  if (l >= param1Long) {
                    l1 = param1Long;
                    break;
                  } 
                  segment = segment.next;
                  continue;
                } 
                break;
              } 
              AsyncTimeout.this.enter();
              try {
                sink.write(param1Buffer, l1);
                param1Long -= l1;
                AsyncTimeout.this.exit(true);
                continue;
              } catch (IOException iOException) {
                throw AsyncTimeout.this.exit(iOException);
              } finally {}
              AsyncTimeout.this.exit(false);
              throw param1Buffer;
            } 
            break;
          } 
        }
      };
  }
  
  public final Source source(final Source source) {
    return new Source() {
        public void close() throws IOException {
          Exception exception;
          try {
            source.close();
            AsyncTimeout.this.exit(true);
            return;
          } catch (IOException null) {
            throw AsyncTimeout.this.exit(exception);
          } finally {}
          AsyncTimeout.this.exit(false);
          throw exception;
        }
        
        public long read(Buffer param1Buffer, long param1Long) throws IOException {
          AsyncTimeout.this.enter();
          try {
            param1Long = source.read(param1Buffer, param1Long);
            AsyncTimeout.this.exit(true);
            return param1Long;
          } catch (IOException iOException) {
            throw AsyncTimeout.this.exit(iOException);
          } finally {}
          AsyncTimeout.this.exit(false);
          throw param1Buffer;
        }
        
        public Timeout timeout() {
          return AsyncTimeout.this;
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("AsyncTimeout.source(");
          stringBuilder.append(source);
          stringBuilder.append(")");
          return stringBuilder.toString();
        }
      };
  }
  
  protected void timedOut() {}
  
  private static final class Watchdog extends Thread {
    Watchdog() {
      super("Okio Watchdog");
      setDaemon(true);
    }
    
    public void run() {
      // Byte code:
      //   0: ldc okio/AsyncTimeout
      //   2: monitorenter
      //   3: invokestatic awaitTimeout : ()Lokio/AsyncTimeout;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull -> 17
      //   11: ldc okio/AsyncTimeout
      //   13: monitorexit
      //   14: goto -> 0
      //   17: aload_1
      //   18: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
      //   21: if_acmpne -> 32
      //   24: aconst_null
      //   25: putstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
      //   28: ldc okio/AsyncTimeout
      //   30: monitorexit
      //   31: return
      //   32: ldc okio/AsyncTimeout
      //   34: monitorexit
      //   35: aload_1
      //   36: invokevirtual timedOut : ()V
      //   39: goto -> 0
      //   42: astore_1
      //   43: ldc okio/AsyncTimeout
      //   45: monitorexit
      //   46: aload_1
      //   47: athrow
      //   48: astore_1
      //   49: goto -> 0
      // Exception table:
      //   from	to	target	type
      //   0	3	48	java/lang/InterruptedException
      //   3	7	42	finally
      //   11	14	42	finally
      //   17	31	42	finally
      //   32	35	42	finally
      //   35	39	48	java/lang/InterruptedException
      //   43	46	42	finally
      //   46	48	48	java/lang/InterruptedException
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\okio\AsyncTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */