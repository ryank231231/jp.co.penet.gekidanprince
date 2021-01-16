package io.opencensus.trace;

import com.google.common.base.Preconditions;
import io.opencensus.common.Function;
import io.opencensus.internal.CheckerFrameworkUtils;
import javax.annotation.concurrent.Immutable;

@Immutable
public abstract class AttributeValue {
  public static AttributeValue booleanAttributeValue(boolean paramBoolean) {
    return AttributeValueBoolean.create(Boolean.valueOf(paramBoolean));
  }
  
  public static AttributeValue longAttributeValue(long paramLong) {
    return AttributeValueLong.create(Long.valueOf(paramLong));
  }
  
  public static AttributeValue stringAttributeValue(String paramString) {
    return AttributeValueString.create(paramString);
  }
  
  public abstract <T> T match(Function<? super String, T> paramFunction, Function<? super Boolean, T> paramFunction1, Function<? super Long, T> paramFunction2, Function<Object, T> paramFunction3);
  
  @Immutable
  static abstract class AttributeValueBoolean extends AttributeValue {
    static AttributeValue create(Boolean param1Boolean) {
      return new AutoValue_AttributeValue_AttributeValueBoolean((Boolean)Preconditions.checkNotNull(param1Boolean, "stringValue"));
    }
    
    abstract Boolean getBooleanValue();
    
    public final <T> T match(Function<? super String, T> param1Function, Function<? super Boolean, T> param1Function1, Function<? super Long, T> param1Function2, Function<Object, T> param1Function3) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function1).apply(getBooleanValue());
    }
  }
  
  @Immutable
  static abstract class AttributeValueLong extends AttributeValue {
    static AttributeValue create(Long param1Long) {
      return new AutoValue_AttributeValue_AttributeValueLong((Long)Preconditions.checkNotNull(param1Long, "stringValue"));
    }
    
    abstract Long getLongValue();
    
    public final <T> T match(Function<? super String, T> param1Function, Function<? super Boolean, T> param1Function1, Function<? super Long, T> param1Function2, Function<Object, T> param1Function3) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function2).apply(getLongValue());
    }
  }
  
  @Immutable
  static abstract class AttributeValueString extends AttributeValue {
    static AttributeValue create(String param1String) {
      return new AutoValue_AttributeValue_AttributeValueString((String)Preconditions.checkNotNull(param1String, "stringValue"));
    }
    
    abstract String getStringValue();
    
    public final <T> T match(Function<? super String, T> param1Function, Function<? super Boolean, T> param1Function1, Function<? super Long, T> param1Function2, Function<Object, T> param1Function3) {
      return (T)CheckerFrameworkUtils.removeSuperFromFunctionParameterType(param1Function).apply(getStringValue());
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\io\opencensus\trace\AttributeValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */