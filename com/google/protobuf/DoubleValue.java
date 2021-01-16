package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class DoubleValue extends GeneratedMessageLite<DoubleValue, DoubleValue.Builder> implements DoubleValueOrBuilder {
  private static final DoubleValue DEFAULT_INSTANCE = new DoubleValue();
  
  private static volatile Parser<DoubleValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private double value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = 0.0D;
  }
  
  public static DoubleValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DoubleValue paramDoubleValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramDoubleValue);
  }
  
  public static DoubleValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DoubleValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DoubleValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DoubleValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DoubleValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DoubleValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DoubleValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DoubleValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DoubleValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<DoubleValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DoubleValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(double paramDouble) {
    this.value_ = paramDouble;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/DoubleValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 326, 2 -> 322, 3 -> 320, 4 -> 311, 5 -> 233, 6 -> 114, 7 -> 229, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/protobuf/DoubleValue.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/protobuf/DoubleValue
    //   76: monitorenter
    //   77: getstatic com/google/protobuf/DoubleValue.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/protobuf/DoubleValue.DEFAULT_INSTANCE : Lcom/google/protobuf/DoubleValue;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/protobuf/DoubleValue.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/protobuf/DoubleValue
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/protobuf/DoubleValue
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/protobuf/DoubleValue.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 229
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 173
    //   140: iload #4
    //   142: bipush #9
    //   144: if_icmpeq -> 162
    //   147: aload_1
    //   148: iload #4
    //   150: invokevirtual skipField : (I)Z
    //   153: ifne -> 124
    //   156: iconst_1
    //   157: istore #5
    //   159: goto -> 124
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual readDouble : ()D
    //   167: putfield value_ : D
    //   170: goto -> 124
    //   173: iconst_1
    //   174: istore #5
    //   176: goto -> 124
    //   179: astore_1
    //   180: goto -> 227
    //   183: astore_1
    //   184: new java/lang/RuntimeException
    //   187: astore_3
    //   188: new com/google/protobuf/InvalidProtocolBufferException
    //   191: astore_2
    //   192: aload_2
    //   193: aload_1
    //   194: invokevirtual getMessage : ()Ljava/lang/String;
    //   197: invokespecial <init> : (Ljava/lang/String;)V
    //   200: aload_3
    //   201: aload_2
    //   202: aload_0
    //   203: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   206: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   209: aload_3
    //   210: athrow
    //   211: astore_1
    //   212: new java/lang/RuntimeException
    //   215: astore_2
    //   216: aload_2
    //   217: aload_1
    //   218: aload_0
    //   219: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   222: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   225: aload_2
    //   226: athrow
    //   227: aload_1
    //   228: athrow
    //   229: getstatic com/google/protobuf/DoubleValue.DEFAULT_INSTANCE : Lcom/google/protobuf/DoubleValue;
    //   232: areturn
    //   233: aload_2
    //   234: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   237: astore_1
    //   238: aload_3
    //   239: checkcast com/google/protobuf/DoubleValue
    //   242: astore_2
    //   243: aload_0
    //   244: getfield value_ : D
    //   247: dconst_0
    //   248: dcmpl
    //   249: ifeq -> 258
    //   252: iconst_1
    //   253: istore #6
    //   255: goto -> 261
    //   258: iconst_0
    //   259: istore #6
    //   261: aload_0
    //   262: getfield value_ : D
    //   265: dstore #7
    //   267: aload_2
    //   268: getfield value_ : D
    //   271: dconst_0
    //   272: dcmpl
    //   273: ifeq -> 282
    //   276: iconst_1
    //   277: istore #9
    //   279: goto -> 285
    //   282: iconst_0
    //   283: istore #9
    //   285: aload_0
    //   286: aload_1
    //   287: iload #6
    //   289: dload #7
    //   291: iload #9
    //   293: aload_2
    //   294: getfield value_ : D
    //   297: invokeinterface visitDouble : (ZDZD)D
    //   302: putfield value_ : D
    //   305: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   308: astore_1
    //   309: aload_0
    //   310: areturn
    //   311: new com/google/protobuf/DoubleValue$Builder
    //   314: dup
    //   315: aconst_null
    //   316: invokespecial <init> : (Lcom/google/protobuf/DoubleValue$1;)V
    //   319: areturn
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/protobuf/DoubleValue.DEFAULT_INSTANCE : Lcom/google/protobuf/DoubleValue;
    //   325: areturn
    //   326: new com/google/protobuf/DoubleValue
    //   329: dup
    //   330: invokespecial <init> : ()V
    //   333: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	211	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	183	java/io/IOException
    //   129	135	179	finally
    //   147	156	211	com/google/protobuf/InvalidProtocolBufferException
    //   147	156	183	java/io/IOException
    //   147	156	179	finally
    //   162	170	211	com/google/protobuf/InvalidProtocolBufferException
    //   162	170	183	java/io/IOException
    //   162	170	179	finally
    //   184	211	179	finally
    //   212	227	179	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    double d = this.value_;
    if (d != 0.0D)
      i = 0 + CodedOutputStream.computeDoubleSize(1, d); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public double getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    double d = this.value_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(1, d); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DoubleValue, Builder> implements DoubleValueOrBuilder {
    private Builder() {
      super(DoubleValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public double getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(double param1Double) {
      copyOnWrite();
      this.instance.setValue(param1Double);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\DoubleValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */