package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@GwtCompatible
abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
  private static final long serialVersionUID = 0L;
  
  final C endpoint;
  
  Cut(@Nullable C paramC) {
    this.endpoint = paramC;
  }
  
  static <C extends Comparable> Cut<C> aboveAll() {
    return AboveAll.INSTANCE;
  }
  
  static <C extends Comparable> Cut<C> aboveValue(C paramC) {
    return new AboveValue<C>(paramC);
  }
  
  static <C extends Comparable> Cut<C> belowAll() {
    return BelowAll.INSTANCE;
  }
  
  static <C extends Comparable> Cut<C> belowValue(C paramC) {
    return new BelowValue<C>(paramC);
  }
  
  Cut<C> canonical(DiscreteDomain<C> paramDiscreteDomain) {
    return this;
  }
  
  public int compareTo(Cut<C> paramCut) {
    if (paramCut == belowAll())
      return 1; 
    if (paramCut == aboveAll())
      return -1; 
    int i = Range.compareOrThrow((Comparable)this.endpoint, (Comparable)paramCut.endpoint);
    return (i != 0) ? i : Booleans.compare(this instanceof AboveValue, paramCut instanceof AboveValue);
  }
  
  abstract void describeAsLowerBound(StringBuilder paramStringBuilder);
  
  abstract void describeAsUpperBound(StringBuilder paramStringBuilder);
  
  C endpoint() {
    return this.endpoint;
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof Cut;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      try {
        int i = compareTo((Cut<C>)paramObject);
        if (i == 0)
          bool1 = true; 
        return bool1;
      } catch (ClassCastException classCastException) {}
    } 
    return false;
  }
  
  abstract C greatestValueBelow(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract boolean isLessThan(C paramC);
  
  abstract C leastValueAbove(DiscreteDomain<C> paramDiscreteDomain);
  
  abstract BoundType typeAsLowerBound();
  
  abstract BoundType typeAsUpperBound();
  
  abstract Cut<C> withLowerBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  abstract Cut<C> withUpperBoundType(BoundType paramBoundType, DiscreteDomain<C> paramDiscreteDomain);
  
  private static final class AboveAll extends Cut<Comparable<?>> {
    private static final AboveAll INSTANCE = new AboveAll();
    
    private static final long serialVersionUID = 0L;
    
    private AboveAll() {
      super(null);
    }
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    public int compareTo(Cut<Comparable<?>> param1Cut) {
      boolean bool;
      if (param1Cut == this) {
        bool = false;
      } else {
        bool = true;
      } 
      return bool;
    }
    
    void describeAsLowerBound(StringBuilder param1StringBuilder) {
      throw new AssertionError();
    }
    
    void describeAsUpperBound(StringBuilder param1StringBuilder) {
      param1StringBuilder.append("+∞)");
    }
    
    Comparable<?> endpoint() {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      return param1DiscreteDomain.maxValue();
    }
    
    boolean isLessThan(Comparable<?> param1Comparable) {
      return false;
    }
    
    Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError();
    }
    
    public String toString() {
      return "+∞";
    }
    
    BoundType typeAsLowerBound() {
      throw new AssertionError("this statement should be unreachable");
    }
    
    BoundType typeAsUpperBound() {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> withLowerBoundType(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> withUpperBoundType(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new IllegalStateException();
    }
  }
  
  private static final class AboveValue<C extends Comparable> extends Cut<C> {
    private static final long serialVersionUID = 0L;
    
    AboveValue(C param1C) {
      super((C)Preconditions.checkNotNull(param1C));
    }
    
    Cut<C> canonical(DiscreteDomain<C> param1DiscreteDomain) {
      Cut<Comparable> cut;
      param1DiscreteDomain = (DiscreteDomain<C>)leastValueAbove(param1DiscreteDomain);
      if (param1DiscreteDomain != null) {
        cut = belowValue((C)param1DiscreteDomain);
      } else {
        cut = Cut.aboveAll();
      } 
      return (Cut)cut;
    }
    
    void describeAsLowerBound(StringBuilder param1StringBuilder) {
      param1StringBuilder.append('(');
      param1StringBuilder.append(this.endpoint);
    }
    
    void describeAsUpperBound(StringBuilder param1StringBuilder) {
      param1StringBuilder.append(this.endpoint);
      param1StringBuilder.append(']');
    }
    
    C greatestValueBelow(DiscreteDomain<C> param1DiscreteDomain) {
      return this.endpoint;
    }
    
    public int hashCode() {
      return this.endpoint.hashCode() ^ 0xFFFFFFFF;
    }
    
    boolean isLessThan(C param1C) {
      boolean bool;
      if (Range.compareOrThrow((Comparable)this.endpoint, (Comparable)param1C) < 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    C leastValueAbove(DiscreteDomain<C> param1DiscreteDomain) {
      return param1DiscreteDomain.next(this.endpoint);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/");
      stringBuilder.append(this.endpoint);
      stringBuilder.append("\\");
      return stringBuilder.toString();
    }
    
    BoundType typeAsLowerBound() {
      return BoundType.OPEN;
    }
    
    BoundType typeAsUpperBound() {
      return BoundType.CLOSED;
    }
    
    Cut<C> withLowerBoundType(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      Cut<Comparable> cut;
      switch (param1BoundType) {
        default:
          throw new AssertionError();
        case OPEN:
          return this;
        case CLOSED:
          break;
      } 
      param1BoundType = (BoundType)param1DiscreteDomain.next(this.endpoint);
      if (param1BoundType == null) {
        cut = Cut.belowAll();
      } else {
        cut = belowValue((C)cut);
      } 
      return (Cut)cut;
    }
    
    Cut<C> withUpperBoundType(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      Cut<Comparable> cut;
      switch (param1BoundType) {
        default:
          throw new AssertionError();
        case OPEN:
          param1BoundType = (BoundType)param1DiscreteDomain.next(this.endpoint);
          if (param1BoundType == null) {
            cut = Cut.aboveAll();
          } else {
            cut = belowValue((C)cut);
          } 
          return (Cut)cut;
        case CLOSED:
          break;
      } 
      return this;
    }
  }
  
  private static final class BelowAll extends Cut<Comparable<?>> {
    private static final BelowAll INSTANCE = new BelowAll();
    
    private static final long serialVersionUID = 0L;
    
    private BelowAll() {
      super(null);
    }
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      try {
        return (Cut)Cut.belowValue(param1DiscreteDomain.minValue());
      } catch (NoSuchElementException noSuchElementException) {
        return this;
      } 
    }
    
    public int compareTo(Cut<Comparable<?>> param1Cut) {
      byte b;
      if (param1Cut == this) {
        b = 0;
      } else {
        b = -1;
      } 
      return b;
    }
    
    void describeAsLowerBound(StringBuilder param1StringBuilder) {
      param1StringBuilder.append("(-∞");
    }
    
    void describeAsUpperBound(StringBuilder param1StringBuilder) {
      throw new AssertionError();
    }
    
    Comparable<?> endpoint() {
      throw new IllegalStateException("range unbounded on this side");
    }
    
    Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError();
    }
    
    boolean isLessThan(Comparable<?> param1Comparable) {
      return true;
    }
    
    Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      return param1DiscreteDomain.minValue();
    }
    
    public String toString() {
      return "-∞";
    }
    
    BoundType typeAsLowerBound() {
      throw new IllegalStateException();
    }
    
    BoundType typeAsUpperBound() {
      throw new AssertionError("this statement should be unreachable");
    }
    
    Cut<Comparable<?>> withLowerBoundType(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new IllegalStateException();
    }
    
    Cut<Comparable<?>> withUpperBoundType(BoundType param1BoundType, DiscreteDomain<Comparable<?>> param1DiscreteDomain) {
      throw new AssertionError("this statement should be unreachable");
    }
  }
  
  private static final class BelowValue<C extends Comparable> extends Cut<C> {
    private static final long serialVersionUID = 0L;
    
    BelowValue(C param1C) {
      super((C)Preconditions.checkNotNull(param1C));
    }
    
    void describeAsLowerBound(StringBuilder param1StringBuilder) {
      param1StringBuilder.append('[');
      param1StringBuilder.append(this.endpoint);
    }
    
    void describeAsUpperBound(StringBuilder param1StringBuilder) {
      param1StringBuilder.append(this.endpoint);
      param1StringBuilder.append(')');
    }
    
    C greatestValueBelow(DiscreteDomain<C> param1DiscreteDomain) {
      return param1DiscreteDomain.previous(this.endpoint);
    }
    
    public int hashCode() {
      return this.endpoint.hashCode();
    }
    
    boolean isLessThan(C param1C) {
      boolean bool;
      if (Range.compareOrThrow((Comparable)this.endpoint, (Comparable)param1C) <= 0) {
        bool = true;
      } else {
        bool = false;
      } 
      return bool;
    }
    
    C leastValueAbove(DiscreteDomain<C> param1DiscreteDomain) {
      return this.endpoint;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("\\");
      stringBuilder.append(this.endpoint);
      stringBuilder.append("/");
      return stringBuilder.toString();
    }
    
    BoundType typeAsLowerBound() {
      return BoundType.CLOSED;
    }
    
    BoundType typeAsUpperBound() {
      return BoundType.OPEN;
    }
    
    Cut<C> withLowerBoundType(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      Cut<Comparable> cut;
      switch (param1BoundType) {
        default:
          throw new AssertionError();
        case OPEN:
          param1BoundType = (BoundType)param1DiscreteDomain.previous(this.endpoint);
          if (param1BoundType == null) {
            cut = Cut.belowAll();
          } else {
            cut = new Cut.AboveValue<Comparable>(cut);
          } 
          return (Cut)cut;
        case CLOSED:
          break;
      } 
      return this;
    }
    
    Cut<C> withUpperBoundType(BoundType param1BoundType, DiscreteDomain<C> param1DiscreteDomain) {
      Cut<Comparable> cut;
      switch (param1BoundType) {
        default:
          throw new AssertionError();
        case OPEN:
          return this;
        case CLOSED:
          break;
      } 
      param1BoundType = (BoundType)param1DiscreteDomain.previous(this.endpoint);
      if (param1BoundType == null) {
        cut = Cut.aboveAll();
      } else {
        cut = new Cut.AboveValue<Comparable>(cut);
      } 
      return (Cut)cut;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\Cut.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */