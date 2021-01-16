package com.squareup.okhttp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

public final class Dispatcher {
  private final Deque<Call> executedCalls = new ArrayDeque<Call>();
  
  private ExecutorService executorService;
  
  private int maxRequests = 64;
  
  private int maxRequestsPerHost = 5;
  
  private final Deque<Call.AsyncCall> readyCalls = new ArrayDeque<Call.AsyncCall>();
  
  private final Deque<Call.AsyncCall> runningCalls = new ArrayDeque<Call.AsyncCall>();
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService) {
    this.executorService = paramExecutorService;
  }
  
  private void promoteCalls() {
    if (this.runningCalls.size() >= this.maxRequests)
      return; 
    if (this.readyCalls.isEmpty())
      return; 
    Iterator<Call.AsyncCall> iterator = this.readyCalls.iterator();
    while (iterator.hasNext()) {
      Call.AsyncCall asyncCall = iterator.next();
      if (runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
        iterator.remove();
        this.runningCalls.add(asyncCall);
        getExecutorService().execute((Runnable)asyncCall);
      } 
      if (this.runningCalls.size() >= this.maxRequests)
        return; 
    } 
  }
  
  private int runningCallsForHost(Call.AsyncCall paramAsyncCall) {
    Iterator<Call.AsyncCall> iterator = this.runningCalls.iterator();
    byte b = 0;
    while (iterator.hasNext()) {
      if (((Call.AsyncCall)iterator.next()).host().equals(paramAsyncCall.host()))
        b++; 
    } 
    return b;
  }
  
  public void cancel(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readyCalls : Ljava/util/Deque;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 49
    //   21: aload_2
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/squareup/okhttp/Call$AsyncCall
    //   30: astore_3
    //   31: aload_1
    //   32: aload_3
    //   33: invokevirtual tag : ()Ljava/lang/Object;
    //   36: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   39: ifeq -> 12
    //   42: aload_3
    //   43: invokevirtual cancel : ()V
    //   46: goto -> 12
    //   49: aload_0
    //   50: getfield runningCalls : Ljava/util/Deque;
    //   53: invokeinterface iterator : ()Ljava/util/Iterator;
    //   58: astore_2
    //   59: aload_2
    //   60: invokeinterface hasNext : ()Z
    //   65: ifeq -> 116
    //   68: aload_2
    //   69: invokeinterface next : ()Ljava/lang/Object;
    //   74: checkcast com/squareup/okhttp/Call$AsyncCall
    //   77: astore_3
    //   78: aload_1
    //   79: aload_3
    //   80: invokevirtual tag : ()Ljava/lang/Object;
    //   83: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   86: ifeq -> 59
    //   89: aload_3
    //   90: invokevirtual get : ()Lcom/squareup/okhttp/Call;
    //   93: iconst_1
    //   94: putfield canceled : Z
    //   97: aload_3
    //   98: invokevirtual get : ()Lcom/squareup/okhttp/Call;
    //   101: getfield engine : Lcom/squareup/okhttp/internal/http/HttpEngine;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull -> 59
    //   109: aload_3
    //   110: invokevirtual cancel : ()V
    //   113: goto -> 59
    //   116: aload_0
    //   117: getfield executedCalls : Ljava/util/Deque;
    //   120: invokeinterface iterator : ()Ljava/util/Iterator;
    //   125: astore_3
    //   126: aload_3
    //   127: invokeinterface hasNext : ()Z
    //   132: ifeq -> 163
    //   135: aload_3
    //   136: invokeinterface next : ()Ljava/lang/Object;
    //   141: checkcast com/squareup/okhttp/Call
    //   144: astore_2
    //   145: aload_1
    //   146: aload_2
    //   147: invokevirtual tag : ()Ljava/lang/Object;
    //   150: invokestatic equal : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   153: ifeq -> 126
    //   156: aload_2
    //   157: invokevirtual cancel : ()V
    //   160: goto -> 126
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	166	finally
    //   12	46	166	finally
    //   49	59	166	finally
    //   59	105	166	finally
    //   109	113	166	finally
    //   116	126	166	finally
    //   126	160	166	finally
  }
  
  void enqueue(Call.AsyncCall paramAsyncCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: aload_0
    //   12: getfield maxRequests : I
    //   15: if_icmpge -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial runningCallsForHost : (Lcom/squareup/okhttp/Call$AsyncCall;)I
    //   23: aload_0
    //   24: getfield maxRequestsPerHost : I
    //   27: if_icmpge -> 54
    //   30: aload_0
    //   31: getfield runningCalls : Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface add : (Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual getExecutorService : ()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   51: goto -> 65
    //   54: aload_0
    //   55: getfield readyCalls : Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface add : (Ljava/lang/Object;)Z
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: return
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void executed(Call paramCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executedCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  void finished(Call.AsyncCall paramAsyncCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: ifeq -> 22
    //   15: aload_0
    //   16: invokespecial promoteCalls : ()V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: new java/lang/AssertionError
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 'AsyncCall wasn't running!'
    //   29: invokespecial <init> : (Ljava/lang/Object;)V
    //   32: aload_1
    //   33: athrow
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	34	finally
    //   22	34	34	finally
  }
  
  void finished(Call paramCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executedCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: new java/lang/AssertionError
    //   23: astore_1
    //   24: aload_1
    //   25: ldc 'Call wasn't in-flight!'
    //   27: invokespecial <init> : (Ljava/lang/Object;)V
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	32	finally
    //   20	32	32	finally
  }
  
  public ExecutorService getExecutorService() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executorService : Ljava/util/concurrent/ExecutorService;
    //   6: ifnonnull -> 48
    //   9: new java/util/concurrent/ThreadPoolExecutor
    //   12: astore_1
    //   13: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   16: astore_2
    //   17: new java/util/concurrent/SynchronousQueue
    //   20: astore_3
    //   21: aload_3
    //   22: invokespecial <init> : ()V
    //   25: aload_1
    //   26: iconst_0
    //   27: ldc 2147483647
    //   29: ldc2_w 60
    //   32: aload_2
    //   33: aload_3
    //   34: ldc 'OkHttp Dispatcher'
    //   36: iconst_0
    //   37: invokestatic threadFactory : (Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;
    //   40: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   43: aload_0
    //   44: aload_1
    //   45: putfield executorService : Ljava/util/concurrent/ExecutorService;
    //   48: aload_0
    //   49: getfield executorService : Ljava/util/concurrent/ExecutorService;
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: areturn
    //   57: astore_2
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	57	finally
    //   48	53	57	finally
  }
  
  public int getMaxRequests() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxRequests : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getMaxRequestsPerHost() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxRequestsPerHost : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getQueuedCallCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readyCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public int getRunningCallCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public void setMaxRequests(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmplt -> 23
    //   7: aload_0
    //   8: iload_1
    //   9: putfield maxRequests : I
    //   12: aload_0
    //   13: invokespecial promoteCalls : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: goto -> 58
    //   23: new java/lang/IllegalArgumentException
    //   26: astore_3
    //   27: new java/lang/StringBuilder
    //   30: astore_2
    //   31: aload_2
    //   32: invokespecial <init> : ()V
    //   35: aload_2
    //   36: ldc 'max < 1: '
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload_1
    //   44: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokespecial <init> : (Ljava/lang/String;)V
    //   56: aload_3
    //   57: athrow
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   7	16	19	finally
    //   23	58	19	finally
  }
  
  public void setMaxRequestsPerHost(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmplt -> 23
    //   7: aload_0
    //   8: iload_1
    //   9: putfield maxRequestsPerHost : I
    //   12: aload_0
    //   13: invokespecial promoteCalls : ()V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: goto -> 58
    //   23: new java/lang/IllegalArgumentException
    //   26: astore_2
    //   27: new java/lang/StringBuilder
    //   30: astore_3
    //   31: aload_3
    //   32: invokespecial <init> : ()V
    //   35: aload_3
    //   36: ldc 'max < 1: '
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: iload_1
    //   44: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_3
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokespecial <init> : (Ljava/lang/String;)V
    //   56: aload_2
    //   57: athrow
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   7	16	19	finally
    //   23	58	19	finally
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\squareup\okhttp\Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */