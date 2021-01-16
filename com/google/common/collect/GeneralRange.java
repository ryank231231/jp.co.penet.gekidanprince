package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.Nullable;

@GwtCompatible(serializable = true)
final class GeneralRange<T> implements Serializable {
  private final Comparator<? super T> comparator;
  
  private final boolean hasLowerBound;
  
  private final boolean hasUpperBound;
  
  private final BoundType lowerBoundType;
  
  @Nullable
  private final T lowerEndpoint;
  
  private transient GeneralRange<T> reverse;
  
  private final BoundType upperBoundType;
  
  @Nullable
  private final T upperEndpoint;
  
  private GeneralRange(Comparator<? super T> paramComparator, boolean paramBoolean1, @Nullable T paramT1, BoundType paramBoundType1, boolean paramBoolean2, @Nullable T paramT2, BoundType paramBoundType2) {
    this.comparator = (Comparator<? super T>)Preconditions.checkNotNull(paramComparator);
    this.hasLowerBound = paramBoolean1;
    this.hasUpperBound = paramBoolean2;
    this.lowerEndpoint = paramT1;
    this.lowerBoundType = (BoundType)Preconditions.checkNotNull(paramBoundType1);
    this.upperEndpoint = paramT2;
    this.upperBoundType = (BoundType)Preconditions.checkNotNull(paramBoundType2);
    if (paramBoolean1)
      paramComparator.compare(paramT1, paramT1); 
    if (paramBoolean2)
      paramComparator.compare(paramT2, paramT2); 
    if (paramBoolean1 && paramBoolean2) {
      int i = paramComparator.compare(paramT1, paramT2);
      byte b = 1;
      if (i <= 0) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      } 
      Preconditions.checkArgument(paramBoolean1, "lowerEndpoint (%s) > upperEndpoint (%s)", paramT1, paramT2);
      if (i == 0) {
        if (paramBoundType1 != BoundType.OPEN) {
          i = 1;
        } else {
          i = 0;
        } 
        if (paramBoundType2 == BoundType.OPEN)
          b = 0; 
        Preconditions.checkArgument(i | b);
      } 
    } 
  }
  
  static <T> GeneralRange<T> all(Comparator<? super T> paramComparator) {
    return new GeneralRange<T>(paramComparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
  }
  
  static <T> GeneralRange<T> downTo(Comparator<? super T> paramComparator, @Nullable T paramT, BoundType paramBoundType) {
    return new GeneralRange<T>(paramComparator, true, paramT, paramBoundType, false, null, BoundType.OPEN);
  }
  
  static <T extends Comparable> GeneralRange<T> from(Range<T> paramRange) {
    T t2;
    BoundType boundType1;
    BoundType boundType2;
    boolean bool = paramRange.hasLowerBound();
    T t1 = null;
    if (bool) {
      T t = paramRange.lowerEndpoint();
    } else {
      t2 = null;
    } 
    if (paramRange.hasLowerBound()) {
      boundType1 = paramRange.lowerBoundType();
    } else {
      boundType1 = BoundType.OPEN;
    } 
    if (paramRange.hasUpperBound())
      t1 = paramRange.upperEndpoint(); 
    if (paramRange.hasUpperBound()) {
      boundType2 = paramRange.upperBoundType();
    } else {
      boundType2 = BoundType.OPEN;
    } 
    return new GeneralRange<T>(Ordering.natural(), paramRange.hasLowerBound(), t2, boundType1, paramRange.hasUpperBound(), t1, boundType2);
  }
  
  static <T> GeneralRange<T> range(Comparator<? super T> paramComparator, @Nullable T paramT1, BoundType paramBoundType1, @Nullable T paramT2, BoundType paramBoundType2) {
    return new GeneralRange<T>(paramComparator, true, paramT1, paramBoundType1, true, paramT2, paramBoundType2);
  }
  
  static <T> GeneralRange<T> upTo(Comparator<? super T> paramComparator, @Nullable T paramT, BoundType paramBoundType) {
    return new GeneralRange<T>(paramComparator, false, null, BoundType.OPEN, true, paramT, paramBoundType);
  }
  
  Comparator<? super T> comparator() {
    return this.comparator;
  }
  
  boolean contains(@Nullable T paramT) {
    boolean bool;
    if (!tooLow(paramT) && !tooHigh(paramT)) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public boolean equals(@Nullable Object paramObject) {
    boolean bool = paramObject instanceof GeneralRange;
    boolean bool1 = false;
    if (bool) {
      paramObject = paramObject;
      bool = bool1;
      if (this.comparator.equals(((GeneralRange)paramObject).comparator)) {
        bool = bool1;
        if (this.hasLowerBound == ((GeneralRange)paramObject).hasLowerBound) {
          bool = bool1;
          if (this.hasUpperBound == ((GeneralRange)paramObject).hasUpperBound) {
            bool = bool1;
            if (getLowerBoundType().equals(paramObject.getLowerBoundType())) {
              bool = bool1;
              if (getUpperBoundType().equals(paramObject.getUpperBoundType())) {
                bool = bool1;
                if (Objects.equal(getLowerEndpoint(), paramObject.getLowerEndpoint())) {
                  bool = bool1;
                  if (Objects.equal(getUpperEndpoint(), paramObject.getUpperEndpoint()))
                    bool = true; 
                } 
              } 
            } 
          } 
        } 
      } 
      return bool;
    } 
    return false;
  }
  
  BoundType getLowerBoundType() {
    return this.lowerBoundType;
  }
  
  T getLowerEndpoint() {
    return this.lowerEndpoint;
  }
  
  BoundType getUpperBoundType() {
    return this.upperBoundType;
  }
  
  T getUpperEndpoint() {
    return this.upperEndpoint;
  }
  
  boolean hasLowerBound() {
    return this.hasLowerBound;
  }
  
  boolean hasUpperBound() {
    return this.hasUpperBound;
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType() });
  }
  
  GeneralRange<T> intersect(GeneralRange<T> paramGeneralRange) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic checkNotNull : (Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: getfield comparator : Ljava/util/Comparator;
    //   9: aload_1
    //   10: getfield comparator : Ljava/util/Comparator;
    //   13: invokeinterface equals : (Ljava/lang/Object;)Z
    //   18: invokestatic checkArgument : (Z)V
    //   21: aload_0
    //   22: getfield hasLowerBound : Z
    //   25: istore_2
    //   26: aload_0
    //   27: invokevirtual getLowerEndpoint : ()Ljava/lang/Object;
    //   30: astore_3
    //   31: aload_0
    //   32: invokevirtual getLowerBoundType : ()Lcom/google/common/collect/BoundType;
    //   35: astore #4
    //   37: aload_0
    //   38: invokevirtual hasLowerBound : ()Z
    //   41: ifne -> 63
    //   44: aload_1
    //   45: getfield hasLowerBound : Z
    //   48: istore_2
    //   49: aload_1
    //   50: invokevirtual getLowerEndpoint : ()Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_1
    //   55: invokevirtual getLowerBoundType : ()Lcom/google/common/collect/BoundType;
    //   58: astore #4
    //   60: goto -> 123
    //   63: aload_1
    //   64: invokevirtual hasLowerBound : ()Z
    //   67: ifeq -> 123
    //   70: aload_0
    //   71: getfield comparator : Ljava/util/Comparator;
    //   74: aload_0
    //   75: invokevirtual getLowerEndpoint : ()Ljava/lang/Object;
    //   78: aload_1
    //   79: invokevirtual getLowerEndpoint : ()Ljava/lang/Object;
    //   82: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   87: istore #5
    //   89: iload #5
    //   91: iflt -> 109
    //   94: iload #5
    //   96: ifne -> 123
    //   99: aload_1
    //   100: invokevirtual getLowerBoundType : ()Lcom/google/common/collect/BoundType;
    //   103: getstatic com/google/common/collect/BoundType.OPEN : Lcom/google/common/collect/BoundType;
    //   106: if_acmpne -> 123
    //   109: aload_1
    //   110: invokevirtual getLowerEndpoint : ()Ljava/lang/Object;
    //   113: astore_3
    //   114: aload_1
    //   115: invokevirtual getLowerBoundType : ()Lcom/google/common/collect/BoundType;
    //   118: astore #4
    //   120: goto -> 123
    //   123: aload_0
    //   124: getfield hasUpperBound : Z
    //   127: istore #6
    //   129: aload_0
    //   130: invokevirtual getUpperEndpoint : ()Ljava/lang/Object;
    //   133: astore #7
    //   135: aload_0
    //   136: invokevirtual getUpperBoundType : ()Lcom/google/common/collect/BoundType;
    //   139: astore #8
    //   141: aload_0
    //   142: invokevirtual hasUpperBound : ()Z
    //   145: ifne -> 172
    //   148: aload_1
    //   149: getfield hasUpperBound : Z
    //   152: istore #6
    //   154: aload_1
    //   155: invokevirtual getUpperEndpoint : ()Ljava/lang/Object;
    //   158: astore #7
    //   160: aload_1
    //   161: invokevirtual getUpperBoundType : ()Lcom/google/common/collect/BoundType;
    //   164: astore #8
    //   166: aload #7
    //   168: astore_1
    //   169: goto -> 239
    //   172: aload_1
    //   173: invokevirtual hasUpperBound : ()Z
    //   176: ifeq -> 236
    //   179: aload_0
    //   180: getfield comparator : Ljava/util/Comparator;
    //   183: aload_0
    //   184: invokevirtual getUpperEndpoint : ()Ljava/lang/Object;
    //   187: aload_1
    //   188: invokevirtual getUpperEndpoint : ()Ljava/lang/Object;
    //   191: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   196: istore #5
    //   198: iload #5
    //   200: ifgt -> 218
    //   203: iload #5
    //   205: ifne -> 236
    //   208: aload_1
    //   209: invokevirtual getUpperBoundType : ()Lcom/google/common/collect/BoundType;
    //   212: getstatic com/google/common/collect/BoundType.OPEN : Lcom/google/common/collect/BoundType;
    //   215: if_acmpne -> 236
    //   218: aload_1
    //   219: invokevirtual getUpperEndpoint : ()Ljava/lang/Object;
    //   222: astore #7
    //   224: aload_1
    //   225: invokevirtual getUpperBoundType : ()Lcom/google/common/collect/BoundType;
    //   228: astore #8
    //   230: aload #7
    //   232: astore_1
    //   233: goto -> 239
    //   236: aload #7
    //   238: astore_1
    //   239: iload_2
    //   240: ifeq -> 305
    //   243: iload #6
    //   245: ifeq -> 305
    //   248: aload_0
    //   249: getfield comparator : Ljava/util/Comparator;
    //   252: aload_3
    //   253: aload_1
    //   254: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   259: istore #5
    //   261: iload #5
    //   263: ifgt -> 287
    //   266: iload #5
    //   268: ifne -> 305
    //   271: aload #4
    //   273: getstatic com/google/common/collect/BoundType.OPEN : Lcom/google/common/collect/BoundType;
    //   276: if_acmpne -> 305
    //   279: aload #8
    //   281: getstatic com/google/common/collect/BoundType.OPEN : Lcom/google/common/collect/BoundType;
    //   284: if_acmpne -> 305
    //   287: getstatic com/google/common/collect/BoundType.OPEN : Lcom/google/common/collect/BoundType;
    //   290: astore_3
    //   291: getstatic com/google/common/collect/BoundType.CLOSED : Lcom/google/common/collect/BoundType;
    //   294: astore #8
    //   296: aload_1
    //   297: astore #4
    //   299: aload_3
    //   300: astore #7
    //   302: goto -> 312
    //   305: aload #4
    //   307: astore #7
    //   309: aload_3
    //   310: astore #4
    //   312: new com/google/common/collect/GeneralRange
    //   315: dup
    //   316: aload_0
    //   317: getfield comparator : Ljava/util/Comparator;
    //   320: iload_2
    //   321: aload #4
    //   323: aload #7
    //   325: iload #6
    //   327: aload_1
    //   328: aload #8
    //   330: invokespecial <init> : (Ljava/util/Comparator;ZLjava/lang/Object;Lcom/google/common/collect/BoundType;ZLjava/lang/Object;Lcom/google/common/collect/BoundType;)V
    //   333: areturn
  }
  
  boolean isEmpty() {
    boolean bool;
    if ((hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  GeneralRange<T> reverse() {
    GeneralRange<T> generalRange = this.reverse;
    if (generalRange == null) {
      generalRange = new GeneralRange(Ordering.<T>from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
      generalRange.reverse = this;
      this.reverse = generalRange;
      return generalRange;
    } 
    return generalRange;
  }
  
  public String toString() {
    byte b;
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.comparator);
    stringBuilder.append(":");
    if (this.lowerBoundType == BoundType.CLOSED) {
      byte b1 = 91;
      b = b1;
    } else {
      byte b1 = 40;
      b = b1;
    } 
    stringBuilder.append(b);
    if (this.hasLowerBound) {
      T t = this.lowerEndpoint;
    } else {
      str = "-∞";
    } 
    stringBuilder.append(str);
    stringBuilder.append(',');
    if (this.hasUpperBound) {
      T t = this.upperEndpoint;
    } else {
      str = "∞";
    } 
    stringBuilder.append(str);
    if (this.upperBoundType == BoundType.CLOSED) {
      byte b1 = 93;
      b = b1;
    } else {
      byte b1 = 41;
      b = b1;
    } 
    stringBuilder.append(b);
    return stringBuilder.toString();
  }
  
  boolean tooHigh(@Nullable T paramT) {
    boolean bool;
    if (!hasUpperBound())
      return false; 
    T t = getUpperEndpoint();
    int i = this.comparator.compare(paramT, t);
    byte b = 1;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (getUpperBoundType() != BoundType.OPEN)
      b = 0; 
    return i & b | bool;
  }
  
  boolean tooLow(@Nullable T paramT) {
    boolean bool;
    if (!hasLowerBound())
      return false; 
    T t = getLowerEndpoint();
    int i = this.comparator.compare(paramT, t);
    byte b = 1;
    if (i < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    } 
    if (getLowerBoundType() != BoundType.OPEN)
      b = 0; 
    return i & b | bool;
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\collect\GeneralRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */