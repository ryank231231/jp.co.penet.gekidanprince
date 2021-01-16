package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public final class MoreObjects {
  public static <T> T firstNonNull(@Nullable T paramT1, @Nullable T paramT2) {
    if (paramT1 == null)
      paramT1 = Preconditions.checkNotNull(paramT2); 
    return paramT1;
  }
  
  public static ToStringHelper toStringHelper(Class<?> paramClass) {
    return new ToStringHelper(paramClass.getSimpleName());
  }
  
  public static ToStringHelper toStringHelper(Object paramObject) {
    return new ToStringHelper(paramObject.getClass().getSimpleName());
  }
  
  public static ToStringHelper toStringHelper(String paramString) {
    return new ToStringHelper(paramString);
  }
  
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
      //   35: getfield holderHead : Lcom/google/common/base/MoreObjects$ToStringHelper$ValueHolder;
      //   38: getfield next : Lcom/google/common/base/MoreObjects$ToStringHelper$ValueHolder;
      //   41: astore #4
      //   43: aload #4
      //   45: ifnull -> 167
      //   48: aload #4
      //   50: getfield value : Ljava/lang/Object;
      //   53: astore #5
      //   55: iload_1
      //   56: ifeq -> 67
      //   59: aload_2
      //   60: astore #6
      //   62: aload #5
      //   64: ifnull -> 154
      //   67: aload_3
      //   68: aload_2
      //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: pop
      //   73: ldc ', '
      //   75: astore #6
      //   77: aload #4
      //   79: getfield name : Ljava/lang/String;
      //   82: ifnull -> 102
      //   85: aload_3
      //   86: aload #4
      //   88: getfield name : Ljava/lang/String;
      //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   94: pop
      //   95: aload_3
      //   96: bipush #61
      //   98: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   101: pop
      //   102: aload #5
      //   104: ifnull -> 147
      //   107: aload #5
      //   109: invokevirtual getClass : ()Ljava/lang/Class;
      //   112: invokevirtual isArray : ()Z
      //   115: ifeq -> 147
      //   118: iconst_1
      //   119: anewarray java/lang/Object
      //   122: dup
      //   123: iconst_0
      //   124: aload #5
      //   126: aastore
      //   127: invokestatic deepToString : ([Ljava/lang/Object;)Ljava/lang/String;
      //   130: astore_2
      //   131: aload_3
      //   132: aload_2
      //   133: iconst_1
      //   134: aload_2
      //   135: invokevirtual length : ()I
      //   138: iconst_1
      //   139: isub
      //   140: invokevirtual append : (Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;
      //   143: pop
      //   144: goto -> 154
      //   147: aload_3
      //   148: aload #5
      //   150: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   153: pop
      //   154: aload #4
      //   156: getfield next : Lcom/google/common/base/MoreObjects$ToStringHelper$ValueHolder;
      //   159: astore #4
      //   161: aload #6
      //   163: astore_2
      //   164: goto -> 43
      //   167: aload_3
      //   168: bipush #125
      //   170: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   173: pop
      //   174: aload_3
      //   175: invokevirtual toString : ()Ljava/lang/String;
      //   178: areturn
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


/* Location:              Y:\classes-dex2jar.jar!\com\google\common\base\MoreObjects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */