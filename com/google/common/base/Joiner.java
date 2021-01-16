package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner {
  private final String separator;
  
  private Joiner(Joiner paramJoiner) {
    this.separator = paramJoiner.separator;
  }
  
  private Joiner(String paramString) {
    this.separator = Preconditions.<String>checkNotNull(paramString);
  }
  
  private static Iterable<Object> iterable(final Object first, final Object second, final Object[] rest) {
    Preconditions.checkNotNull(rest);
    return new AbstractList() {
        public Object get(int param1Int) {
          switch (param1Int) {
            default:
              return rest[param1Int - 2];
            case 1:
              return second;
            case 0:
              break;
          } 
          return first;
        }
        
        public int size() {
          return rest.length + 2;
        }
      };
  }
  
  public static Joiner on(char paramChar) {
    return new Joiner(String.valueOf(paramChar));
  }
  
  public static Joiner on(String paramString) {
    return new Joiner(paramString);
  }
  
  @CanIgnoreReturnValue
  public <A extends Appendable> A appendTo(A paramA, Iterable<?> paramIterable) throws IOException {
    return appendTo(paramA, paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public final <A extends Appendable> A appendTo(A paramA, @Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs) throws IOException {
    return appendTo(paramA, iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public <A extends Appendable> A appendTo(A paramA, Iterator<?> paramIterator) throws IOException {
    Preconditions.checkNotNull(paramA);
    if (paramIterator.hasNext()) {
      paramA.append(toString(paramIterator.next()));
      while (paramIterator.hasNext()) {
        paramA.append(this.separator);
        paramA.append(toString(paramIterator.next()));
      } 
    } 
    return paramA;
  }
  
  @CanIgnoreReturnValue
  public final <A extends Appendable> A appendTo(A paramA, Object[] paramArrayOfObject) throws IOException {
    return appendTo(paramA, Arrays.asList(paramArrayOfObject));
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterable<?> paramIterable) {
    return appendTo(paramStringBuilder, paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, @Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs) {
    return appendTo(paramStringBuilder, iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Iterator<?> paramIterator) {
    try {
      appendTo(paramStringBuilder, paramIterator);
      return paramStringBuilder;
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
  
  @CanIgnoreReturnValue
  public final StringBuilder appendTo(StringBuilder paramStringBuilder, Object[] paramArrayOfObject) {
    return appendTo(paramStringBuilder, Arrays.asList(paramArrayOfObject));
  }
  
  public final String join(Iterable<?> paramIterable) {
    return join(paramIterable.iterator());
  }
  
  public final String join(@Nullable Object paramObject1, @Nullable Object paramObject2, Object... paramVarArgs) {
    return join(iterable(paramObject1, paramObject2, paramVarArgs));
  }
  
  public final String join(Iterator<?> paramIterator) {
    return appendTo(new StringBuilder(), paramIterator).toString();
  }
  
  public final String join(Object[] paramArrayOfObject) {
    return join(Arrays.asList(paramArrayOfObject));
  }
  
  public Joiner skipNulls() {
    return new Joiner(this) {
        public <A extends Appendable> A appendTo(A param1A, Iterator<?> param1Iterator) throws IOException {
          Preconditions.checkNotNull(param1A, "appendable");
          Preconditions.checkNotNull(param1Iterator, "parts");
          while (param1Iterator.hasNext()) {
            Object object = param1Iterator.next();
            if (object != null) {
              param1A.append(Joiner.this.toString(object));
              break;
            } 
          } 
          while (param1Iterator.hasNext()) {
            Object object = param1Iterator.next();
            if (object != null) {
              param1A.append(Joiner.this.separator);
              param1A.append(Joiner.this.toString(object));
            } 
          } 
          return param1A;
        }
        
        public Joiner useForNull(String param1String) {
          throw new UnsupportedOperationException("already specified skipNulls");
        }
        
        public Joiner.MapJoiner withKeyValueSeparator(String param1String) {
          throw new UnsupportedOperationException("can't use .skipNulls() with maps");
        }
      };
  }
  
  CharSequence toString(Object paramObject) {
    Preconditions.checkNotNull(paramObject);
    if (paramObject instanceof CharSequence) {
      paramObject = paramObject;
    } else {
      paramObject = paramObject.toString();
    } 
    return (CharSequence)paramObject;
  }
  
  public Joiner useForNull(final String nullText) {
    Preconditions.checkNotNull(nullText);
    return new Joiner(this) {
        public Joiner skipNulls() {
          throw new UnsupportedOperationException("already specified useForNull");
        }
        
        CharSequence toString(@Nullable Object param1Object) {
          if (param1Object == null) {
            param1Object = nullText;
          } else {
            param1Object = Joiner.this.toString(param1Object);
          } 
          return (CharSequence)param1Object;
        }
        
        public Joiner useForNull(String param1String) {
          throw new UnsupportedOperationException("already specified useForNull");
        }
      };
  }
  
  public MapJoiner withKeyValueSeparator(char paramChar) {
    return withKeyValueSeparator(String.valueOf(paramChar));
  }
  
  public MapJoiner withKeyValueSeparator(String paramString) {
    return new MapJoiner(this, paramString);
  }
  
  public static final class MapJoiner {
    private final Joiner joiner;
    
    private final String keyValueSeparator;
    
    private MapJoiner(Joiner param1Joiner, String param1String) {
      this.joiner = param1Joiner;
      this.keyValueSeparator = Preconditions.<String>checkNotNull(param1String);
    }
    
    @Beta
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A param1A, Iterable<? extends Map.Entry<?, ?>> param1Iterable) throws IOException {
      return appendTo(param1A, param1Iterable.iterator());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A param1A, Iterator<? extends Map.Entry<?, ?>> param1Iterator) throws IOException {
      Preconditions.checkNotNull(param1A);
      if (param1Iterator.hasNext()) {
        Map.Entry entry = param1Iterator.next();
        param1A.append(this.joiner.toString(entry.getKey()));
        param1A.append(this.keyValueSeparator);
        param1A.append(this.joiner.toString(entry.getValue()));
        while (param1Iterator.hasNext()) {
          param1A.append(this.joiner.separator);
          entry = param1Iterator.next();
          param1A.append(this.joiner.toString(entry.getKey()));
          param1A.append(this.keyValueSeparator);
          param1A.append(this.joiner.toString(entry.getValue()));
        } 
      } 
      return param1A;
    }
    
    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A param1A, Map<?, ?> param1Map) throws IOException {
      return appendTo(param1A, param1Map.entrySet());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public StringBuilder appendTo(StringBuilder param1StringBuilder, Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
      return appendTo(param1StringBuilder, param1Iterable.iterator());
    }
    
    @Beta
    @CanIgnoreReturnValue
    public StringBuilder appendTo(StringBuilder param1StringBuilder, Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
      try {
        appendTo(param1StringBuilder, param1Iterator);
        return param1StringBuilder;
      } catch (IOException iOException) {
        throw new AssertionError(iOException);
      } 
    }
    
    @CanIgnoreReturnValue
    public StringBuilder appendTo(StringBuilder param1StringBuilder, Map<?, ?> param1Map) {
      return appendTo(param1StringBuilder, param1Map.entrySet());
    }
    
    @Beta
    public String join(Iterable<? extends Map.Entry<?, ?>> param1Iterable) {
      return join(param1Iterable.iterator());
    }
    
    @Beta
    public String join(Iterator<? extends Map.Entry<?, ?>> param1Iterator) {
      return appendTo(new StringBuilder(), param1Iterator).toString();
    }
    
    public String join(Map<?, ?> param1Map) {
      return join(param1Map.entrySet());
    }
    
    public MapJoiner useForNull(String param1String) {
      return new MapJoiner(this.joiner.useForNull(param1String), this.keyValueSeparator);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Joiner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */