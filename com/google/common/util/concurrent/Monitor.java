package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.j2objc.annotations.Weak;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

@Beta
@GwtIncompatible
public final class Monitor {
  @GuardedBy("lock")
  private Guard activeGuards = null;
  
  private final boolean fair;
  
  private final ReentrantLock lock;
  
  public Monitor() {
    this(false);
  }
  
  public Monitor(boolean paramBoolean) {
    this.fair = paramBoolean;
    this.lock = new ReentrantLock(paramBoolean);
  }
  
  @GuardedBy("lock")
  private void await(Guard paramGuard, boolean paramBoolean) throws InterruptedException {
    if (paramBoolean)
      signalNextWaiter(); 
    beginWaitingFor(paramGuard);
    try {
      while (true) {
        paramGuard.condition.await();
        paramBoolean = paramGuard.isSatisfied();
        if (paramBoolean)
          return; 
      } 
    } finally {
      endWaitingFor(paramGuard);
    } 
  }
  
  @GuardedBy("lock")
  private boolean awaitNanos(Guard paramGuard, long paramLong, boolean paramBoolean) throws InterruptedException {
    // Byte code:
    //   0: iconst_1
    //   1: istore #5
    //   3: lload_2
    //   4: lconst_0
    //   5: lcmp
    //   6: ifgt -> 21
    //   9: iload #5
    //   11: ifne -> 19
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial endWaitingFor : (Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: iload #5
    //   23: istore #6
    //   25: iload #5
    //   27: ifeq -> 55
    //   30: iload #4
    //   32: ifeq -> 43
    //   35: iload #5
    //   37: istore #7
    //   39: aload_0
    //   40: invokespecial signalNextWaiter : ()V
    //   43: iload #5
    //   45: istore #7
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial beginWaitingFor : (Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   52: iconst_0
    //   53: istore #6
    //   55: iload #6
    //   57: istore #7
    //   59: aload_1
    //   60: getfield condition : Ljava/util/concurrent/locks/Condition;
    //   63: lload_2
    //   64: invokeinterface awaitNanos : (J)J
    //   69: lstore_2
    //   70: iload #6
    //   72: istore #7
    //   74: aload_1
    //   75: invokevirtual isSatisfied : ()Z
    //   78: istore #8
    //   80: iload #6
    //   82: istore #5
    //   84: iload #8
    //   86: ifeq -> 3
    //   89: iload #6
    //   91: ifne -> 99
    //   94: aload_0
    //   95: aload_1
    //   96: invokespecial endWaitingFor : (Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   99: iconst_1
    //   100: ireturn
    //   101: astore #9
    //   103: iload #7
    //   105: ifne -> 113
    //   108: aload_0
    //   109: aload_1
    //   110: invokespecial endWaitingFor : (Lcom/google/common/util/concurrent/Monitor$Guard;)V
    //   113: aload #9
    //   115: athrow
    // Exception table:
    //   from	to	target	type
    //   39	43	101	finally
    //   47	52	101	finally
    //   59	70	101	finally
    //   74	80	101	finally
  }
  
  @GuardedBy("lock")
  private void awaitUninterruptibly(Guard paramGuard, boolean paramBoolean) {
    if (paramBoolean)
      signalNextWaiter(); 
    beginWaitingFor(paramGuard);
    try {
      while (true) {
        paramGuard.condition.awaitUninterruptibly();
        paramBoolean = paramGuard.isSatisfied();
        if (paramBoolean)
          return; 
      } 
    } finally {
      endWaitingFor(paramGuard);
    } 
  }
  
  @GuardedBy("lock")
  private void beginWaitingFor(Guard paramGuard) {
    int i = paramGuard.waiterCount;
    paramGuard.waiterCount = i + 1;
    if (i == 0) {
      paramGuard.next = this.activeGuards;
      this.activeGuards = paramGuard;
    } 
  }
  
  @GuardedBy("lock")
  private void endWaitingFor(Guard paramGuard) {
    int i = paramGuard.waiterCount - 1;
    paramGuard.waiterCount = i;
    if (i == 0) {
      Guard guard1 = this.activeGuards;
      Guard guard2 = null;
      while (true) {
        if (guard1 == paramGuard) {
          if (guard2 == null) {
            this.activeGuards = guard1.next;
          } else {
            guard2.next = guard1.next;
          } 
          guard1.next = null;
          break;
        } 
        Guard guard = guard1.next;
        guard2 = guard1;
        guard1 = guard;
      } 
    } 
  }
  
  private static long initNanoTime(long paramLong) {
    if (paramLong <= 0L)
      return 0L; 
    long l = System.nanoTime();
    paramLong = l;
    if (l == 0L)
      paramLong = 1L; 
    return paramLong;
  }
  
  @GuardedBy("lock")
  private boolean isSatisfied(Guard paramGuard) {
    try {
      return paramGuard.isSatisfied();
    } catch (Throwable throwable) {
      signalAllWaiters();
      throw Throwables.propagate(throwable);
    } 
  }
  
  private static long remainingNanos(long paramLong1, long paramLong2) {
    long l = 0L;
    if (paramLong2 <= 0L) {
      paramLong1 = l;
    } else {
      paramLong1 = paramLong2 - System.nanoTime() - paramLong1;
    } 
    return paramLong1;
  }
  
  @GuardedBy("lock")
  private void signalAllWaiters() {
    for (Guard guard = this.activeGuards; guard != null; guard = guard.next)
      guard.condition.signalAll(); 
  }
  
  @GuardedBy("lock")
  private void signalNextWaiter() {
    for (Guard guard = this.activeGuards; guard != null; guard = guard.next) {
      if (isSatisfied(guard)) {
        guard.condition.signal();
        break;
      } 
    } 
  }
  
  private static long toSafeNanos(long paramLong, TimeUnit paramTimeUnit) {
    long l = paramTimeUnit.toNanos(paramLong);
    if (l <= 0L) {
      paramLong = 0L;
    } else {
      paramLong = l;
      if (l > 6917529027641081853L)
        paramLong = 6917529027641081853L; 
    } 
    return paramLong;
  }
  
  public void enter() {
    this.lock.lock();
  }
  
  public boolean enter(long paramLong, TimeUnit paramTimeUnit) {
    long l = toSafeNanos(paramLong, paramTimeUnit);
    ReentrantLock reentrantLock = this.lock;
    if (!this.fair && reentrantLock.tryLock())
      return true; 
    boolean bool1 = Thread.interrupted();
    boolean bool2 = bool1;
    try {
      long l1 = System.nanoTime();
      paramLong = l;
      while (true) {
        bool2 = bool1;
        try {
          boolean bool = reentrantLock.tryLock(paramLong, TimeUnit.NANOSECONDS);
          if (bool1)
            Thread.currentThread().interrupt(); 
          return bool;
        } catch (InterruptedException interruptedException) {
          try {
            paramLong = remainingNanos(l1, l);
            continue;
          } finally {
            interruptedException = null;
          } 
        } 
        if (bool2)
          Thread.currentThread().interrupt(); 
        throw interruptedException;
      } 
    } finally {}
    if (bool2)
      Thread.currentThread().interrupt(); 
    throw paramTimeUnit;
  }
  
  public boolean enterIf(Guard paramGuard) {
    if (paramGuard.monitor == this) {
      ReentrantLock reentrantLock = this.lock;
      reentrantLock.lock();
      try {
        boolean bool = paramGuard.isSatisfied();
        return bool;
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean enterIf(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit) {
    if (paramGuard.monitor == this) {
      if (!enter(paramLong, paramTimeUnit))
        return false; 
      try {
        boolean bool = paramGuard.isSatisfied();
        return bool;
      } finally {
        this.lock.unlock();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean enterIfInterruptibly(Guard paramGuard) throws InterruptedException {
    if (paramGuard.monitor == this) {
      ReentrantLock reentrantLock = this.lock;
      reentrantLock.lockInterruptibly();
      try {
        boolean bool = paramGuard.isSatisfied();
        return bool;
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean enterIfInterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    if (paramGuard.monitor == this) {
      ReentrantLock reentrantLock = this.lock;
      if (!reentrantLock.tryLock(paramLong, paramTimeUnit))
        return false; 
      try {
        boolean bool = paramGuard.isSatisfied();
        return bool;
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public void enterInterruptibly() throws InterruptedException {
    this.lock.lockInterruptibly();
  }
  
  public boolean enterInterruptibly(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return this.lock.tryLock(paramLong, paramTimeUnit);
  }
  
  public void enterWhen(Guard paramGuard) throws InterruptedException {
    if (paramGuard.monitor == this) {
      ReentrantLock reentrantLock = this.lock;
      boolean bool = reentrantLock.isHeldByCurrentThread();
      reentrantLock.lockInterruptibly();
      try {
        return;
      } finally {
        leave();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean enterWhen(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    // Byte code:
    //   0: lload_2
    //   1: aload #4
    //   3: invokestatic toSafeNanos : (JLjava/util/concurrent/TimeUnit;)J
    //   6: lstore #5
    //   8: aload_1
    //   9: getfield monitor : Lcom/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpne -> 178
    //   16: aload_0
    //   17: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
    //   20: astore #7
    //   22: aload #7
    //   24: invokevirtual isHeldByCurrentThread : ()Z
    //   27: istore #8
    //   29: aload_0
    //   30: getfield fair : Z
    //   33: istore #9
    //   35: iconst_0
    //   36: istore #10
    //   38: iload #9
    //   40: ifne -> 71
    //   43: invokestatic interrupted : ()Z
    //   46: ifne -> 63
    //   49: aload #7
    //   51: invokevirtual tryLock : ()Z
    //   54: ifeq -> 71
    //   57: lconst_0
    //   58: lstore #11
    //   60: goto -> 91
    //   63: new java/lang/InterruptedException
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: athrow
    //   71: lload #5
    //   73: invokestatic initNanoTime : (J)J
    //   76: lstore #11
    //   78: aload #7
    //   80: lload_2
    //   81: aload #4
    //   83: invokevirtual tryLock : (JLjava/util/concurrent/TimeUnit;)Z
    //   86: ifne -> 91
    //   89: iconst_0
    //   90: ireturn
    //   91: aload_1
    //   92: invokevirtual isSatisfied : ()Z
    //   95: ifne -> 134
    //   98: lload #11
    //   100: lconst_0
    //   101: lcmp
    //   102: ifne -> 111
    //   105: lload #5
    //   107: lstore_2
    //   108: goto -> 119
    //   111: lload #11
    //   113: lload #5
    //   115: invokestatic remainingNanos : (JJ)J
    //   118: lstore_2
    //   119: aload_0
    //   120: aload_1
    //   121: lload_2
    //   122: iload #8
    //   124: invokespecial awaitNanos : (Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   127: istore #9
    //   129: iload #9
    //   131: ifeq -> 137
    //   134: iconst_1
    //   135: istore #10
    //   137: iload #10
    //   139: ifne -> 147
    //   142: aload #7
    //   144: invokevirtual unlock : ()V
    //   147: iload #10
    //   149: ireturn
    //   150: astore_1
    //   151: iload #8
    //   153: ifne -> 171
    //   156: aload_0
    //   157: invokespecial signalNextWaiter : ()V
    //   160: goto -> 171
    //   163: astore_1
    //   164: aload #7
    //   166: invokevirtual unlock : ()V
    //   169: aload_1
    //   170: athrow
    //   171: aload #7
    //   173: invokevirtual unlock : ()V
    //   176: aload_1
    //   177: athrow
    //   178: new java/lang/IllegalMonitorStateException
    //   181: dup
    //   182: invokespecial <init> : ()V
    //   185: athrow
    // Exception table:
    //   from	to	target	type
    //   91	98	150	finally
    //   111	119	150	finally
    //   119	129	150	finally
    //   156	160	163	finally
  }
  
  public void enterWhenUninterruptibly(Guard paramGuard) {
    if (paramGuard.monitor == this) {
      ReentrantLock reentrantLock = this.lock;
      boolean bool = reentrantLock.isHeldByCurrentThread();
      reentrantLock.lock();
      try {
        return;
      } finally {
        leave();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean enterWhenUninterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit) {
    // Byte code:
    //   0: lload_2
    //   1: aload #4
    //   3: invokestatic toSafeNanos : (JLjava/util/concurrent/TimeUnit;)J
    //   6: lstore #5
    //   8: aload_1
    //   9: getfield monitor : Lcom/google/common/util/concurrent/Monitor;
    //   12: aload_0
    //   13: if_acmpne -> 285
    //   16: aload_0
    //   17: getfield lock : Ljava/util/concurrent/locks/ReentrantLock;
    //   20: astore #4
    //   22: aload #4
    //   24: invokevirtual isHeldByCurrentThread : ()Z
    //   27: istore #7
    //   29: invokestatic interrupted : ()Z
    //   32: istore #8
    //   34: iconst_1
    //   35: istore #9
    //   37: iload #8
    //   39: istore #10
    //   41: aload_0
    //   42: getfield fair : Z
    //   45: ifne -> 72
    //   48: iload #8
    //   50: istore #10
    //   52: aload #4
    //   54: invokevirtual tryLock : ()Z
    //   57: ifne -> 63
    //   60: goto -> 72
    //   63: lconst_0
    //   64: lstore_2
    //   65: iload #7
    //   67: istore #10
    //   69: goto -> 113
    //   72: iload #8
    //   74: istore #10
    //   76: lload #5
    //   78: invokestatic initNanoTime : (J)J
    //   81: lstore #11
    //   83: lload #5
    //   85: lstore_2
    //   86: iload #8
    //   88: istore #10
    //   90: aload #4
    //   92: lload_2
    //   93: getstatic java/util/concurrent/TimeUnit.NANOSECONDS : Ljava/util/concurrent/TimeUnit;
    //   96: invokevirtual tryLock : (JLjava/util/concurrent/TimeUnit;)Z
    //   99: istore #13
    //   101: iload #13
    //   103: ifeq -> 235
    //   106: lload #11
    //   108: lstore_2
    //   109: iload #7
    //   111: istore #10
    //   113: lload_2
    //   114: lstore #11
    //   116: aload_1
    //   117: invokevirtual isSatisfied : ()Z
    //   120: ifeq -> 126
    //   123: goto -> 177
    //   126: lload_2
    //   127: lconst_0
    //   128: lcmp
    //   129: ifne -> 148
    //   132: lload_2
    //   133: lstore #11
    //   135: lload #5
    //   137: invokestatic initNanoTime : (J)J
    //   140: lstore_2
    //   141: lload #5
    //   143: lstore #14
    //   145: goto -> 159
    //   148: lload_2
    //   149: lstore #11
    //   151: lload_2
    //   152: lload #5
    //   154: invokestatic remainingNanos : (JJ)J
    //   157: lstore #14
    //   159: lload_2
    //   160: lstore #11
    //   162: aload_0
    //   163: aload_1
    //   164: lload #14
    //   166: iload #10
    //   168: invokespecial awaitNanos : (Lcom/google/common/util/concurrent/Monitor$Guard;JZ)Z
    //   171: istore #10
    //   173: iload #10
    //   175: istore #9
    //   177: iload #9
    //   179: ifne -> 191
    //   182: iload #8
    //   184: istore #10
    //   186: aload #4
    //   188: invokevirtual unlock : ()V
    //   191: iload #8
    //   193: ifeq -> 202
    //   196: invokestatic currentThread : ()Ljava/lang/Thread;
    //   199: invokevirtual interrupt : ()V
    //   202: iload #9
    //   204: ireturn
    //   205: astore_1
    //   206: iload #8
    //   208: istore #10
    //   210: aload #4
    //   212: invokevirtual unlock : ()V
    //   215: iload #8
    //   217: istore #10
    //   219: aload_1
    //   220: athrow
    //   221: astore #16
    //   223: iconst_0
    //   224: istore #10
    //   226: iconst_1
    //   227: istore #8
    //   229: lload #11
    //   231: lstore_2
    //   232: goto -> 113
    //   235: iload #8
    //   237: ifeq -> 246
    //   240: invokestatic currentThread : ()Ljava/lang/Thread;
    //   243: invokevirtual interrupt : ()V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore #16
    //   250: lload #11
    //   252: lload #5
    //   254: invokestatic remainingNanos : (JJ)J
    //   257: lstore_2
    //   258: iconst_1
    //   259: istore #8
    //   261: goto -> 86
    //   264: astore_1
    //   265: iconst_1
    //   266: istore #10
    //   268: goto -> 272
    //   271: astore_1
    //   272: iload #10
    //   274: ifeq -> 283
    //   277: invokestatic currentThread : ()Ljava/lang/Thread;
    //   280: invokevirtual interrupt : ()V
    //   283: aload_1
    //   284: athrow
    //   285: new java/lang/IllegalMonitorStateException
    //   288: dup
    //   289: invokespecial <init> : ()V
    //   292: athrow
    // Exception table:
    //   from	to	target	type
    //   41	48	271	finally
    //   52	60	271	finally
    //   76	83	271	finally
    //   90	101	248	java/lang/InterruptedException
    //   90	101	271	finally
    //   116	123	221	java/lang/InterruptedException
    //   116	123	205	finally
    //   135	141	221	java/lang/InterruptedException
    //   135	141	205	finally
    //   151	159	221	java/lang/InterruptedException
    //   151	159	205	finally
    //   162	173	221	java/lang/InterruptedException
    //   162	173	205	finally
    //   186	191	271	finally
    //   210	215	271	finally
    //   219	221	271	finally
    //   250	258	264	finally
  }
  
  public int getOccupiedDepth() {
    return this.lock.getHoldCount();
  }
  
  public int getQueueLength() {
    return this.lock.getQueueLength();
  }
  
  public int getWaitQueueLength(Guard paramGuard) {
    if (paramGuard.monitor == this) {
      this.lock.lock();
      try {
        return paramGuard.waiterCount;
      } finally {
        this.lock.unlock();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean hasQueuedThread(Thread paramThread) {
    return this.lock.hasQueuedThread(paramThread);
  }
  
  public boolean hasQueuedThreads() {
    return this.lock.hasQueuedThreads();
  }
  
  public boolean hasWaiters(Guard paramGuard) {
    boolean bool;
    if (getWaitQueueLength(paramGuard) > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean isFair() {
    return this.fair;
  }
  
  public boolean isOccupied() {
    return this.lock.isLocked();
  }
  
  public boolean isOccupiedByCurrentThread() {
    return this.lock.isHeldByCurrentThread();
  }
  
  public void leave() {
    ReentrantLock reentrantLock = this.lock;
    try {
      if (reentrantLock.getHoldCount() == 1)
        signalNextWaiter(); 
      return;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public boolean tryEnter() {
    return this.lock.tryLock();
  }
  
  public boolean tryEnterIf(Guard paramGuard) {
    if (paramGuard.monitor == this) {
      ReentrantLock reentrantLock = this.lock;
      if (!reentrantLock.tryLock())
        return false; 
      try {
        boolean bool = paramGuard.isSatisfied();
        return bool;
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  public void waitFor(Guard paramGuard) throws InterruptedException {
    boolean bool;
    if (paramGuard.monitor == this) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool & this.lock.isHeldByCurrentThread()) {
      if (!paramGuard.isSatisfied())
        await(paramGuard, true); 
      return;
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean waitFor(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    boolean bool;
    paramLong = toSafeNanos(paramLong, paramTimeUnit);
    if (paramGuard.monitor == this) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool & this.lock.isHeldByCurrentThread()) {
      if (paramGuard.isSatisfied())
        return true; 
      if (!Thread.interrupted())
        return awaitNanos(paramGuard, paramLong, true); 
      throw new InterruptedException();
    } 
    throw new IllegalMonitorStateException();
  }
  
  public void waitForUninterruptibly(Guard paramGuard) {
    boolean bool;
    if (paramGuard.monitor == this) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool & this.lock.isHeldByCurrentThread()) {
      if (!paramGuard.isSatisfied())
        awaitUninterruptibly(paramGuard, true); 
      return;
    } 
    throw new IllegalMonitorStateException();
  }
  
  public boolean waitForUninterruptibly(Guard paramGuard, long paramLong, TimeUnit paramTimeUnit) {
    boolean bool1;
    long l = toSafeNanos(paramLong, paramTimeUnit);
    Monitor monitor = paramGuard.monitor;
    boolean bool = true;
    if (monitor == this) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1 & this.lock.isHeldByCurrentThread()) {
      if (paramGuard.isSatisfied())
        return true; 
      long l1 = initNanoTime(l);
      boolean bool2 = Thread.interrupted();
      paramLong = l;
      boolean bool3 = true;
      while (true) {
        try {
          bool3 = awaitNanos(paramGuard, paramLong, bool3);
          if (bool2)
            Thread.currentThread().interrupt(); 
          return bool3;
        } catch (InterruptedException interruptedException) {
          try {
            bool2 = paramGuard.isSatisfied();
            if (bool2)
              return true; 
            paramLong = remainingNanos(l1, l);
            bool3 = false;
            continue;
          } finally {
            paramGuard = null;
          } 
        } finally {}
        if (bool2)
          Thread.currentThread().interrupt(); 
        throw paramGuard;
      } 
    } 
    throw new IllegalMonitorStateException();
  }
  
  @Beta
  public static abstract class Guard {
    final Condition condition;
    
    @Weak
    final Monitor monitor;
    
    @GuardedBy("monitor.lock")
    Guard next;
    
    @GuardedBy("monitor.lock")
    int waiterCount = 0;
    
    protected Guard(Monitor param1Monitor) {
      this.monitor = (Monitor)Preconditions.checkNotNull(param1Monitor, "monitor");
      this.condition = param1Monitor.lock.newCondition();
    }
    
    public abstract boolean isSatisfied();
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\Monitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */