package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.Nullable;

@GwtCompatible
public final class Objects extends ExtraObjectsMethodsForWeb {
  public static boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  @Deprecated
  public static <T> T firstNonNull(@Nullable T paramT1, @Nullable T paramT2) {
    return MoreObjects.firstNonNull(paramT1, paramT2);
  }
  
  public static int hashCode(@Nullable Object... paramVarArgs) {
    return Arrays.hashCode(paramVarArgs);
  }
  
  @Deprecated
  public static ToStringHelper toStringHelper(Class<?> paramClass) {
    return new ToStringHelper(paramClass.getSimpleName());
  }
  
  @Deprecated
  public static ToStringHelper toStringHelper(Object paramObject) {
    return new ToStringHelper(paramObject.getClass().getSimpleName());
  }
  
  @Deprecated
  public static ToStringHelper toStringHelper(String paramString) {
    return new ToStringHelper(paramString);
  }
  
  @Deprecated
  public static final class ToStringHelper {
    private final String className;
    
    private final ValueHolder holderHead = new ValueHolder();
    
    private ValueHolder holderTail = this.holderHead;
    
    private boolean omitNullValues = false;
    
    private ToStringHelper(String param1String) {
      this.className = Preconditions.<String>checkNotNull(param1String);
    }
    
    private ValueHolder addHolder() {
      ValueHolder valueHolder = new ValueHolder();
      this.holderTail.next = valueHolder;
      this.holderTail = valueHolder;
      return valueHolder;
    }
    
    private ToStringHelper addHolder(@Nullable Object param1Object) {
      (addHolder()).value = param1Object;
      return this;
    }
    
    private ToStringHelper addHolder(String param1String, @Nullable Object param1Object) {
      ValueHolder valueHolder = addHolder();
      valueHolder.value = param1Object;
      valueHolder.name = Preconditions.<String>checkNotNull(param1String);
      return this;
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, char param1Char) {
      return addHolder(param1String, String.valueOf(param1Char));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, double param1Double) {
      return addHolder(param1String, String.valueOf(param1Double));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, float param1Float) {
      return addHolder(param1String, String.valueOf(param1Float));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, int param1Int) {
      return addHolder(param1String, String.valueOf(param1Int));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, long param1Long) {
      return addHolder(param1String, String.valueOf(param1Long));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, @Nullable Object param1Object) {
      return addHolder(param1String, param1Object);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper add(String param1String, boolean param1Boolean) {
      return addHolder(param1String, String.valueOf(param1Boolean));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(char param1Char) {
      return addHolder(String.valueOf(param1Char));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(double param1Double) {
      return addHolder(String.valueOf(param1Double));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(float param1Float) {
      return addHolder(String.valueOf(param1Float));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(int param1Int) {
      return addHolder(String.valueOf(param1Int));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(long param1Long) {
      return addHolder(String.valueOf(param1Long));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(@Nullable Object param1Object) {
      return addHolder(param1Object);
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper addValue(boolean param1Boolean) {
      return addHolder(String.valueOf(param1Boolean));
    }
    
    @CanIgnoreReturnValue
    public ToStringHelper omitNullValues() {
      this.omitNullValues = true;
      return this;
    }
    
    public String toString() {
      // Byte code:
      //   0: aload_0
      //   1: getfield omitNullValues : Z
      //   4: istore_1
      //   5: ldc ''
      //   7: astore_2
      //   8: new java/lang/StringBuilder
      //   11: dup
      //   12: bipush #32
      //   14: invokespecial <init> : (I)V
      //   17: astore_3
      //   18: aload_3
      //   19: aload_0
      //   20: getfield className : Ljava/lang/String;
      //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: pop
      //   27: aload_3
      //   28: bipush #123
      //   30: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   33: pop
      //   34: aload_0
      //   35: getfield holderHead : Lcom/google/common/base/Objects$ToStringHelper$ValueHolder;
      //   38: getfield next : Lcom/google/common/base/Objects$ToStringHelper$ValueHolder;
      //   41: astore #4
      //   43: aload #4
      //   45: ifnull -> 121
      //   48: iload_1
      //   49: ifeq -> 63
      //   52: aload_2
      //   53: astore #5
      //   55: aload #4
      //   57: getfield value : Ljava/lang/Object;
      //   60: ifnull -> 108
      //   63: aload_3
      //   64: aload_2
      //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   68: pop
      //   69: ldc ', '
      //   71: astore #5
      //   73: aload #4
      //   75: getfield name : Ljava/lang/String;
      //   78: ifnull -> 98
      //   81: aload_3
      //   82: aload #4
      //   84: getfield name : Ljava/lang/String;
      //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: pop
      //   91: aload_3
      //   92: bipush #61
      //   94: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   97: pop
      //   98: aload_3
      //   99: aload #4
      //   101: getfield value : Ljava/lang/Object;
      //   104: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   107: pop
      //   108: aload #4
      //   110: getfield next : Lcom/google/common/base/Objects$ToStringHelper$ValueHolder;
      //   113: astore #4
      //   115: aload #5
      //   117: astore_2
      //   118: goto -> 43
      //   121: aload_3
      //   122: bipush #125
      //   124: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   127: pop
      //   128: aload_3
      //   129: invokevirtual toString : ()Ljava/lang/String;
      //   132: areturn
    }
    
    private static final class ValueHolder {
      String name;
      
      ValueHolder next;
      
      Object value;
      
      private ValueHolder() {}
    }
  }
  
  private static final class ValueHolder {
    String name;
    
    ValueHolder next;
    
    Object value;
    
    private ValueHolder() {}
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */