package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@GwtIncompatible
@CanIgnoreReturnValue
@ThreadSafe
public class CycleDetectingLockFactory {
  private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks;
  
  private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType = (new MapMaker()).weakKeys().makeMap();
  
  private static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
  
  final Policy policy;
  
  static {
    acquiredLocks = new ThreadLocal<ArrayList<LockGraphNode>>() {
        protected ArrayList<CycleDetectingLockFactory.LockGraphNode> initialValue() {
          return Lists.newArrayListWithCapacity(3);
        }
      };
  }
  
  private CycleDetectingLockFactory(Policy paramPolicy) {
    this.policy = (Policy)Preconditions.checkNotNull(paramPolicy);
  }
  
  private void aboutToAcquire(CycleDetectingLock paramCycleDetectingLock) {
    if (!paramCycleDetectingLock.isAcquiredByCurrentThread()) {
      ArrayList<LockGraphNode> arrayList = acquiredLocks.get();
      LockGraphNode lockGraphNode = paramCycleDetectingLock.getLockGraphNode();
      lockGraphNode.checkAcquiredLocks(this.policy, arrayList);
      arrayList.add(lockGraphNode);
    } 
  }
  
  @VisibleForTesting
  static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> paramClass) {
    EnumMap<Enum<?>, LockGraphNode> enumMap = Maps.newEnumMap(paramClass);
    Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
    int i = arrayOfEnum.length;
    ArrayList<LockGraphNode> arrayList = Lists.newArrayListWithCapacity(i);
    int j = arrayOfEnum.length;
    boolean bool = false;
    byte b;
    for (b = 0; b < j; b++) {
      Enum<?> enum_ = arrayOfEnum[b];
      LockGraphNode lockGraphNode = new LockGraphNode(getLockName(enum_));
      arrayList.add(lockGraphNode);
      enumMap.put(enum_, lockGraphNode);
    } 
    b = 1;
    while (true) {
      j = bool;
      if (b < i) {
        ((LockGraphNode)arrayList.get(b)).checkAcquiredLocks(Policies.THROW, arrayList.subList(0, b));
        b++;
        continue;
      } 
      break;
    } 
    while (j < i - 1) {
      LockGraphNode lockGraphNode = arrayList.get(j);
      Policies policies = Policies.DISABLED;
      lockGraphNode.checkAcquiredLocks(policies, arrayList.subList(++j, i));
    } 
    return Collections.unmodifiableMap((Map)enumMap);
  }
  
  private static String getLockName(Enum<?> paramEnum) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramEnum.getDeclaringClass().getSimpleName());
    stringBuilder.append(".");
    stringBuilder.append(paramEnum.name());
    return stringBuilder.toString();
  }
  
  private static Map<? extends Enum, LockGraphNode> getOrCreateNodes(Class<? extends Enum> paramClass) {
    Map<? extends Enum, LockGraphNode> map = lockGraphNodesPerType.get(paramClass);
    if (map != null)
      return map; 
    map = createNodes(paramClass);
    return (Map<? extends Enum, LockGraphNode>)MoreObjects.firstNonNull(lockGraphNodesPerType.putIfAbsent(paramClass, map), map);
  }
  
  private static void lockStateChanged(CycleDetectingLock paramCycleDetectingLock) {
    if (!paramCycleDetectingLock.isAcquiredByCurrentThread()) {
      ArrayList<LockGraphNode> arrayList = acquiredLocks.get();
      LockGraphNode lockGraphNode = paramCycleDetectingLock.getLockGraphNode();
      for (int i = arrayList.size() - 1; i >= 0; i--) {
        if (arrayList.get(i) == lockGraphNode) {
          arrayList.remove(i);
          break;
        } 
      } 
    } 
  }
  
  public static CycleDetectingLockFactory newInstance(Policy paramPolicy) {
    return new CycleDetectingLockFactory(paramPolicy);
  }
  
  public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> paramClass, Policy paramPolicy) {
    Preconditions.checkNotNull(paramClass);
    Preconditions.checkNotNull(paramPolicy);
    return new WithExplicitOrdering<E>(paramPolicy, (Map)getOrCreateNodes(paramClass));
  }
  
  public ReentrantLock newReentrantLock(String paramString) {
    return newReentrantLock(paramString, false);
  }
  
  public ReentrantLock newReentrantLock(String paramString, boolean paramBoolean) {
    ReentrantLock reentrantLock;
    if (this.policy == Policies.DISABLED) {
      reentrantLock = new ReentrantLock(paramBoolean);
    } else {
      reentrantLock = new CycleDetectingReentrantLock(new LockGraphNode((String)reentrantLock), paramBoolean);
    } 
    return reentrantLock;
  }
  
  public ReentrantReadWriteLock newReentrantReadWriteLock(String paramString) {
    return newReentrantReadWriteLock(paramString, false);
  }
  
  public ReentrantReadWriteLock newReentrantReadWriteLock(String paramString, boolean paramBoolean) {
    ReentrantReadWriteLock reentrantReadWriteLock;
    if (this.policy == Policies.DISABLED) {
      reentrantReadWriteLock = new ReentrantReadWriteLock(paramBoolean);
    } else {
      reentrantReadWriteLock = new CycleDetectingReentrantReadWriteLock(new LockGraphNode((String)reentrantReadWriteLock), paramBoolean);
    } 
    return reentrantReadWriteLock;
  }
  
  private static interface CycleDetectingLock {
    CycleDetectingLockFactory.LockGraphNode getLockGraphNode();
    
    boolean isAcquiredByCurrentThread();
  }
  
  final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
    private final CycleDetectingLockFactory.LockGraphNode lockGraphNode;
    
    private CycleDetectingReentrantLock(CycleDetectingLockFactory.LockGraphNode param1LockGraphNode, boolean param1Boolean) {
      super(param1Boolean);
      this.lockGraphNode = (CycleDetectingLockFactory.LockGraphNode)Preconditions.checkNotNull(param1LockGraphNode);
    }
    
    public CycleDetectingLockFactory.LockGraphNode getLockGraphNode() {
      return this.lockGraphNode;
    }
    
    public boolean isAcquiredByCurrentThread() {
      return isHeldByCurrentThread();
    }
    
    public void lock() {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try {
        super.lock();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this);
      } 
    }
    
    public void lockInterruptibly() throws InterruptedException {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try {
        super.lockInterruptibly();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this);
      } 
    }
    
    public boolean tryLock() {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try {
        return super.tryLock();
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this);
      } 
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      CycleDetectingLockFactory.this.aboutToAcquire(this);
      try {
        return super.tryLock(param1Long, param1TimeUnit);
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this);
      } 
    }
    
    public void unlock() {
      try {
        super.unlock();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this);
      } 
    }
  }
  
  private class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
    @Weak
    final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;
    
    CycleDetectingReentrantReadLock(CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock param1CycleDetectingReentrantReadWriteLock) {
      this.readWriteLock = param1CycleDetectingReentrantReadWriteLock;
    }
    
    public void lock() {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        super.lock();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public void lockInterruptibly() throws InterruptedException {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        super.lockInterruptibly();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public boolean tryLock() {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        return super.tryLock();
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        return super.tryLock(param1Long, param1TimeUnit);
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public void unlock() {
      try {
        super.unlock();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
  }
  
  final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
    private final CycleDetectingLockFactory.LockGraphNode lockGraphNode;
    
    private final CycleDetectingLockFactory.CycleDetectingReentrantReadLock readLock = new CycleDetectingLockFactory.CycleDetectingReentrantReadLock(this);
    
    private final CycleDetectingLockFactory.CycleDetectingReentrantWriteLock writeLock = new CycleDetectingLockFactory.CycleDetectingReentrantWriteLock(this);
    
    private CycleDetectingReentrantReadWriteLock(CycleDetectingLockFactory.LockGraphNode param1LockGraphNode, boolean param1Boolean) {
      super(param1Boolean);
      this.lockGraphNode = (CycleDetectingLockFactory.LockGraphNode)Preconditions.checkNotNull(param1LockGraphNode);
    }
    
    public CycleDetectingLockFactory.LockGraphNode getLockGraphNode() {
      return this.lockGraphNode;
    }
    
    public boolean isAcquiredByCurrentThread() {
      return (isWriteLockedByCurrentThread() || getReadHoldCount() > 0);
    }
    
    public ReentrantReadWriteLock.ReadLock readLock() {
      return this.readLock;
    }
    
    public ReentrantReadWriteLock.WriteLock writeLock() {
      return this.writeLock;
    }
  }
  
  private class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
    @Weak
    final CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock readWriteLock;
    
    CycleDetectingReentrantWriteLock(CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock param1CycleDetectingReentrantReadWriteLock) {
      this.readWriteLock = param1CycleDetectingReentrantReadWriteLock;
    }
    
    public void lock() {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        super.lock();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public void lockInterruptibly() throws InterruptedException {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        super.lockInterruptibly();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public boolean tryLock() {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        return super.tryLock();
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public boolean tryLock(long param1Long, TimeUnit param1TimeUnit) throws InterruptedException {
      CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
      try {
        return super.tryLock(param1Long, param1TimeUnit);
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
    
    public void unlock() {
      try {
        super.unlock();
        return;
      } finally {
        CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
      } 
    }
  }
  
  private static class ExampleStackTrace extends IllegalStateException {
    static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    
    static final Set<String> EXCLUDED_CLASS_NAMES = (Set<String>)ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), CycleDetectingLockFactory.LockGraphNode.class.getName());
    
    ExampleStackTrace(CycleDetectingLockFactory.LockGraphNode param1LockGraphNode1, CycleDetectingLockFactory.LockGraphNode param1LockGraphNode2) {
      super(stringBuilder.toString());
      StackTraceElement[] arrayOfStackTraceElement = getStackTrace();
      int i = arrayOfStackTraceElement.length;
      for (byte b = 0; b < i; b++) {
        if (CycleDetectingLockFactory.WithExplicitOrdering.class.getName().equals(arrayOfStackTraceElement[b].getClassName())) {
          setStackTrace(EMPTY_STACK_TRACE);
          break;
        } 
        if (!EXCLUDED_CLASS_NAMES.contains(arrayOfStackTraceElement[b].getClassName())) {
          setStackTrace(Arrays.<StackTraceElement>copyOfRange(arrayOfStackTraceElement, b, i));
          break;
        } 
      } 
    }
  }
  
  private static class LockGraphNode {
    final Map<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> allowedPriorLocks = (new MapMaker()).weakKeys().makeMap();
    
    final Map<LockGraphNode, CycleDetectingLockFactory.PotentialDeadlockException> disallowedPriorLocks = (new MapMaker()).weakKeys().makeMap();
    
    final String lockName;
    
    LockGraphNode(String param1String) {
      this.lockName = (String)Preconditions.checkNotNull(param1String);
    }
    
    @Nullable
    private CycleDetectingLockFactory.ExampleStackTrace findPathTo(LockGraphNode param1LockGraphNode, Set<LockGraphNode> param1Set) {
      if (!param1Set.add(this))
        return null; 
      CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = this.allowedPriorLocks.get(param1LockGraphNode);
      if (exampleStackTrace != null)
        return exampleStackTrace; 
      for (Map.Entry<LockGraphNode, CycleDetectingLockFactory.ExampleStackTrace> entry : this.allowedPriorLocks.entrySet()) {
        LockGraphNode lockGraphNode = (LockGraphNode)entry.getKey();
        exampleStackTrace = lockGraphNode.findPathTo(param1LockGraphNode, param1Set);
        if (exampleStackTrace != null) {
          CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace1 = new CycleDetectingLockFactory.ExampleStackTrace(lockGraphNode, this);
          exampleStackTrace1.setStackTrace(((CycleDetectingLockFactory.ExampleStackTrace)entry.getValue()).getStackTrace());
          exampleStackTrace1.initCause(exampleStackTrace);
          return exampleStackTrace1;
        } 
      } 
      return null;
    }
    
    void checkAcquiredLock(CycleDetectingLockFactory.Policy param1Policy, LockGraphNode param1LockGraphNode) {
      boolean bool;
      if (this != param1LockGraphNode) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.checkState(bool, "Attempted to acquire multiple locks with the same rank %s", param1LockGraphNode.getLockName());
      if (this.allowedPriorLocks.containsKey(param1LockGraphNode))
        return; 
      CycleDetectingLockFactory.PotentialDeadlockException potentialDeadlockException = this.disallowedPriorLocks.get(param1LockGraphNode);
      if (potentialDeadlockException != null) {
        param1Policy.handlePotentialDeadlock(new CycleDetectingLockFactory.PotentialDeadlockException(param1LockGraphNode, this, potentialDeadlockException.getConflictingStackTrace()));
        return;
      } 
      CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = param1LockGraphNode.findPathTo(this, Sets.newIdentityHashSet());
      if (exampleStackTrace == null) {
        this.allowedPriorLocks.put(param1LockGraphNode, new CycleDetectingLockFactory.ExampleStackTrace(param1LockGraphNode, this));
      } else {
        exampleStackTrace = new CycleDetectingLockFactory.PotentialDeadlockException(param1LockGraphNode, this, exampleStackTrace);
        this.disallowedPriorLocks.put(param1LockGraphNode, exampleStackTrace);
        param1Policy.handlePotentialDeadlock((CycleDetectingLockFactory.PotentialDeadlockException)exampleStackTrace);
      } 
    }
    
    void checkAcquiredLocks(CycleDetectingLockFactory.Policy param1Policy, List<LockGraphNode> param1List) {
      int i = param1List.size();
      for (byte b = 0; b < i; b++)
        checkAcquiredLock(param1Policy, param1List.get(b)); 
    }
    
    String getLockName() {
      return this.lockName;
    }
  }
  
  @Beta
  public enum Policies implements Policy {
    DISABLED,
    THROW {
      public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException param2PotentialDeadlockException) {
        throw param2PotentialDeadlockException;
      }
    },
    WARN {
      public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException param2PotentialDeadlockException) {
        CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", param2PotentialDeadlockException);
      }
    };
    
    static {
      $VALUES = new Policies[] { THROW, WARN, DISABLED };
    }
  }
  
  enum null {
    public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException) {
      throw param1PotentialDeadlockException;
    }
  }
  
  enum null {
    public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException) {
      CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", param1PotentialDeadlockException);
    }
  }
  
  enum null {
    public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException) {}
  }
  
  @Beta
  @ThreadSafe
  public static interface Policy {
    void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException param1PotentialDeadlockException);
  }
  
  @Beta
  public static final class PotentialDeadlockException extends ExampleStackTrace {
    private final CycleDetectingLockFactory.ExampleStackTrace conflictingStackTrace;
    
    private PotentialDeadlockException(CycleDetectingLockFactory.LockGraphNode param1LockGraphNode1, CycleDetectingLockFactory.LockGraphNode param1LockGraphNode2, CycleDetectingLockFactory.ExampleStackTrace param1ExampleStackTrace) {
      super(param1LockGraphNode1, param1LockGraphNode2);
      this.conflictingStackTrace = param1ExampleStackTrace;
      initCause(param1ExampleStackTrace);
    }
    
    public CycleDetectingLockFactory.ExampleStackTrace getConflictingStackTrace() {
      return this.conflictingStackTrace;
    }
    
    public String getMessage() {
      StringBuilder stringBuilder = new StringBuilder(super.getMessage());
      CycleDetectingLockFactory.ExampleStackTrace exampleStackTrace = this.conflictingStackTrace;
      while (exampleStackTrace != null) {
        stringBuilder.append(", ");
        stringBuilder.append(exampleStackTrace.getMessage());
        Throwable throwable = exampleStackTrace.getCause();
      } 
      return stringBuilder.toString();
    }
  }
  
  @Beta
  public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
    private final Map<E, CycleDetectingLockFactory.LockGraphNode> lockGraphNodes;
    
    @VisibleForTesting
    WithExplicitOrdering(CycleDetectingLockFactory.Policy param1Policy, Map<E, CycleDetectingLockFactory.LockGraphNode> param1Map) {
      super(param1Policy);
      this.lockGraphNodes = param1Map;
    }
    
    public ReentrantLock newReentrantLock(E param1E) {
      return newReentrantLock(param1E, false);
    }
    
    public ReentrantLock newReentrantLock(E param1E, boolean param1Boolean) {
      ReentrantLock reentrantLock;
      if (this.policy == CycleDetectingLockFactory.Policies.DISABLED) {
        reentrantLock = new ReentrantLock(param1Boolean);
      } else {
        reentrantLock = new CycleDetectingLockFactory.CycleDetectingReentrantLock(this.lockGraphNodes.get(reentrantLock), param1Boolean);
      } 
      return reentrantLock;
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(E param1E) {
      return newReentrantReadWriteLock(param1E, false);
    }
    
    public ReentrantReadWriteLock newReentrantReadWriteLock(E param1E, boolean param1Boolean) {
      ReentrantReadWriteLock reentrantReadWriteLock;
      if (this.policy == CycleDetectingLockFactory.Policies.DISABLED) {
        reentrantReadWriteLock = new ReentrantReadWriteLock(param1Boolean);
      } else {
        reentrantReadWriteLock = new CycleDetectingLockFactory.CycleDetectingReentrantReadWriteLock(this.lockGraphNodes.get(reentrantReadWriteLock), param1Boolean);
      } 
      return reentrantReadWriteLock;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\commo\\util\concurrent\CycleDetectingLockFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */