package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Converter<A, B> implements Function<A, B> {
  private final boolean handleNullAutomatically;
  
  @LazyInit
  private transient Converter<B, A> reverse;
  
  protected Converter() {
    this(true);
  }
  
  Converter(boolean paramBoolean) {
    this.handleNullAutomatically = paramBoolean;
  }
  
  public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> paramFunction, Function<? super B, ? extends A> paramFunction1) {
    return new FunctionBasedConverter<A, B>(paramFunction, paramFunction1);
  }
  
  public static <T> Converter<T, T> identity() {
    return IdentityConverter.INSTANCE;
  }
  
  public final <C> Converter<A, C> andThen(Converter<B, C> paramConverter) {
    return doAndThen(paramConverter);
  }
  
  @Deprecated
  @Nullable
  @CanIgnoreReturnValue
  public final B apply(@Nullable A paramA) {
    return convert(paramA);
  }
  
  @Nullable
  @CanIgnoreReturnValue
  public final B convert(@Nullable A paramA) {
    return correctedDoForward(paramA);
  }
  
  @CanIgnoreReturnValue
  public Iterable<B> convertAll(final Iterable<? extends A> fromIterable) {
    Preconditions.checkNotNull(fromIterable, "fromIterable");
    return new Iterable<B>() {
        public Iterator<B> iterator() {
          return new Iterator<B>() {
              private final Iterator<? extends A> fromIterator = fromIterable.iterator();
              
              public boolean hasNext() {
                return this.fromIterator.hasNext();
              }
              
              public B next() {
                return (B)Converter.this.convert(this.fromIterator.next());
              }
              
              public void remove() {
                this.fromIterator.remove();
              }
            };
        }
      };
  }
  
  @Nullable
  A correctedDoBackward(@Nullable B paramB) {
    if (this.handleNullAutomatically) {
      if (paramB == null) {
        paramB = null;
      } else {
        paramB = Preconditions.checkNotNull((B)doBackward(paramB));
      } 
      return (A)paramB;
    } 
    return doBackward(paramB);
  }
  
  @Nullable
  B correctedDoForward(@Nullable A paramA) {
    if (this.handleNullAutomatically) {
      if (paramA == null) {
        paramA = null;
      } else {
        paramA = Preconditions.checkNotNull((A)doForward(paramA));
      } 
      return (B)paramA;
    } 
    return doForward(paramA);
  }
  
  <C> Converter<A, C> doAndThen(Converter<B, C> paramConverter) {
    return new ConverterComposition<A, Object, C>(this, Preconditions.<Converter<?, C>>checkNotNull(paramConverter));
  }
  
  protected abstract A doBackward(B paramB);
  
  protected abstract B doForward(A paramA);
  
  public boolean equals(@Nullable Object paramObject) {
    return super.equals(paramObject);
  }
  
  @CanIgnoreReturnValue
  public Converter<B, A> reverse() {
    Converter<B, A> converter1 = this.reverse;
    Converter<B, A> converter2 = converter1;
    if (converter1 == null) {
      converter2 = new ReverseConverter<A, B>(this);
      this.reverse = converter2;
    } 
    return converter2;
  }
  
  private static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Converter<A, B> first;
    
    final Converter<B, C> second;
    
    ConverterComposition(Converter<A, B> param1Converter, Converter<B, C> param1Converter1) {
      this.first = param1Converter;
      this.second = param1Converter1;
    }
    
    @Nullable
    A correctedDoBackward(@Nullable C param1C) {
      return this.first.correctedDoBackward(this.second.correctedDoBackward(param1C));
    }
    
    @Nullable
    C correctedDoForward(@Nullable A param1A) {
      return this.second.correctedDoForward(this.first.correctedDoForward(param1A));
    }
    
    protected A doBackward(C param1C) {
      throw new AssertionError();
    }
    
    protected C doForward(A param1A) {
      throw new AssertionError();
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof ConverterComposition;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.first.equals(((ConverterComposition)param1Object).first)) {
          bool = bool1;
          if (this.second.equals(((ConverterComposition)param1Object).second))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.first.hashCode() * 31 + this.second.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.first);
      stringBuilder.append(".andThen(");
      stringBuilder.append(this.second);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
    private final Function<? super B, ? extends A> backwardFunction;
    
    private final Function<? super A, ? extends B> forwardFunction;
    
    private FunctionBasedConverter(Function<? super A, ? extends B> param1Function, Function<? super B, ? extends A> param1Function1) {
      this.forwardFunction = Preconditions.<Function<? super A, ? extends B>>checkNotNull(param1Function);
      this.backwardFunction = Preconditions.<Function<? super B, ? extends A>>checkNotNull(param1Function1);
    }
    
    protected A doBackward(B param1B) {
      return this.backwardFunction.apply(param1B);
    }
    
    protected B doForward(A param1A) {
      return this.forwardFunction.apply(param1A);
    }
    
    public boolean equals(@Nullable Object param1Object) {
      boolean bool = param1Object instanceof FunctionBasedConverter;
      boolean bool1 = false;
      if (bool) {
        param1Object = param1Object;
        bool = bool1;
        if (this.forwardFunction.equals(((FunctionBasedConverter)param1Object).forwardFunction)) {
          bool = bool1;
          if (this.backwardFunction.equals(((FunctionBasedConverter)param1Object).backwardFunction))
            bool = true; 
        } 
        return bool;
      } 
      return false;
    }
    
    public int hashCode() {
      return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Converter.from(");
      stringBuilder.append(this.forwardFunction);
      stringBuilder.append(", ");
      stringBuilder.append(this.backwardFunction);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  private static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
    static final IdentityConverter INSTANCE = new IdentityConverter();
    
    private static final long serialVersionUID = 0L;
    
    private Object readResolve() {
      return INSTANCE;
    }
    
    <S> Converter<T, S> doAndThen(Converter<T, S> param1Converter) {
      return Preconditions.<Converter<T, S>>checkNotNull(param1Converter, "otherConverter");
    }
    
    protected T doBackward(T param1T) {
      return param1T;
    }
    
    protected T doForward(T param1T) {
      return param1T;
    }
    
    public IdentityConverter<T> reverse() {
      return this;
    }
    
    public String toString() {
      return "Converter.identity()";
    }
  }
  
  private static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
    private static final long serialVersionUID = 0L;
    
    final Converter<A, B> original;
    
    ReverseConverter(Converter<A, B> param1Converter) {
      this.original = param1Converter;
    }
    
    @Nullable
    B correctedDoBackward(@Nullable A param1A) {
      return this.original.correctedDoForward(param1A);
    }
    
    @Nullable
    A correctedDoForward(@Nullable B param1B) {
      return this.original.correctedDoBackward(param1B);
    }
    
    protected B doBackward(A param1A) {
      throw new AssertionError();
    }
    
    protected A doForward(B param1B) {
      throw new AssertionError();
    }
    
    public boolean equals(@Nullable Object param1Object) {
      if (param1Object instanceof ReverseConverter) {
        param1Object = param1Object;
        return this.original.equals(((ReverseConverter)param1Object).original);
      } 
      return false;
    }
    
    public int hashCode() {
      return this.original.hashCode() ^ 0xFFFFFFFF;
    }
    
    public Converter<A, B> reverse() {
      return this.original;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.original);
      stringBuilder.append(".reverse()");
      return stringBuilder.toString();
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Converter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */