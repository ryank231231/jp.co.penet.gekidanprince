package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.NoSuchElementException;

@GwtCompatible
public abstract class DiscreteDomain<C extends Comparable> {
  public static DiscreteDomain<BigInteger> bigIntegers() {
    return BigIntegerDomain.INSTANCE;
  }
  
  public static DiscreteDomain<Integer> integers() {
    return IntegerDomain.INSTANCE;
  }
  
  public static DiscreteDomain<Long> longs() {
    return LongDomain.INSTANCE;
  }
  
  public abstract long distance(C paramC1, C paramC2);
  
  @CanIgnoreReturnValue
  public C maxValue() {
    throw new NoSuchElementException();
  }
  
  @CanIgnoreReturnValue
  public C minValue() {
    throw new NoSuchElementException();
  }
  
  public abstract C next(C paramC);
  
  public abstract C previous(C paramC);
  
  private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
    private static final BigIntegerDomain INSTANCE = new BigIntegerDomain();
    
    private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
    
    private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
    
    private static final long serialVersionUID = 0L;
    
    static {
    
    }
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    public long distance(BigInteger param1BigInteger1, BigInteger param1BigInteger2) {
      return param1BigInteger2.subtract(param1BigInteger1).max(MIN_LONG).min(MAX_LONG).longValue();
    }
    
    public BigInteger next(BigInteger param1BigInteger) {
      return param1BigInteger.add(BigInteger.ONE);
    }
    
    public BigInteger previous(BigInteger param1BigInteger) {
      return param1BigInteger.subtract(BigInteger.ONE);
    }
    
    public String toString() {
      return "DiscreteDomain.bigIntegers()";
    }
  }
  
  private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
    private static final IntegerDomain INSTANCE = new IntegerDomain();
    
    private static final long serialVersionUID = 0L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    public long distance(Integer param1Integer1, Integer param1Integer2) {
      return param1Integer2.intValue() - param1Integer1.intValue();
    }
    
    public Integer maxValue() {
      return Integer.valueOf(2147483647);
    }
    
    public Integer minValue() {
      return Integer.valueOf(-2147483648);
    }
    
    public Integer next(Integer param1Integer) {
      int i = param1Integer.intValue();
      if (i == Integer.MAX_VALUE) {
        param1Integer = null;
      } else {
        param1Integer = Integer.valueOf(i + 1);
      } 
      return param1Integer;
    }
    
    public Integer previous(Integer param1Integer) {
      int i = param1Integer.intValue();
      if (i == Integer.MIN_VALUE) {
        param1Integer = null;
      } else {
        param1Integer = Integer.valueOf(i - 1);
      } 
      return param1Integer;
    }
    
    public String toString() {
      return "DiscreteDomain.integers()";
    }
  }
  
  private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
    private static final LongDomain INSTANCE = new LongDomain();
    
    private static final long serialVersionUID = 0L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    public long distance(Long param1Long1, Long param1Long2) {
      long l = param1Long2.longValue() - param1Long1.longValue();
      return (param1Long2.longValue() > param1Long1.longValue() && l < 0L) ? Long.MAX_VALUE : ((param1Long2.longValue() < param1Long1.longValue() && l > 0L) ? Long.MIN_VALUE : l);
    }
    
    public Long maxValue() {
      return Long.valueOf(Long.MAX_VALUE);
    }
    
    public Long minValue() {
      return Long.valueOf(Long.MIN_VALUE);
    }
    
    public Long next(Long param1Long) {
      long l = param1Long.longValue();
      if (l == Long.MAX_VALUE) {
        param1Long = null;
      } else {
        param1Long = Long.valueOf(l + 1L);
      } 
      return param1Long;
    }
    
    public Long previous(Long param1Long) {
      long l = param1Long.longValue();
      if (l == Long.MIN_VALUE) {
        param1Long = null;
      } else {
        param1Long = Long.valueOf(l - 1L);
      } 
      return param1Long;
    }
    
    public String toString() {
      return "DiscreteDomain.longs()";
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\DiscreteDomain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */