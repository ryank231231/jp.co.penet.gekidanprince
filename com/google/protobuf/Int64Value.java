package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Int64Value extends GeneratedMessageLite<Int64Value, Int64Value.Builder> implements Int64ValueOrBuilder {
  private static final Int64Value DEFAULT_INSTANCE = new Int64Value();
  
  private static volatile Parser<Int64Value> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private long value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = 0L;
  }
  
  public static Int64Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Int64Value paramInt64Value) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramInt64Value);
  }
  
  public static Int64Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Int64Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Int64Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Int64Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Int64Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Int64Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Int64Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Int64Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Int64Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Int64Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Int64Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(long paramLong) {
    this.value_ = paramLong;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Int64Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
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
    //   68: getstatic com/google/protobuf/Int64Value.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/protobuf/Int64Value
    //   76: monitorenter
    //   77: getstatic com/google/protobuf/Int64Value.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/protobuf/Int64Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int64Value;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/protobuf/Int64Value.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/protobuf/Int64Value
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/protobuf/Int64Value
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/protobuf/Int64Value.PARSER : Lcom/google/protobuf/Parser;
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
    //   142: bipush #8
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
    //   164: invokevirtual readInt64 : ()J
    //   167: putfield value_ : J
    //   170: goto -> 124
    //   173: iconst_1
    //   174: istore #5
    //   176: goto -> 124
    //   179: astore_1
    //   180: goto -> 227
    //   183: astore_2
    //   184: new java/lang/RuntimeException
    //   187: astore_3
    //   188: new com/google/protobuf/InvalidProtocolBufferException
    //   191: astore_1
    //   192: aload_1
    //   193: aload_2
    //   194: invokevirtual getMessage : ()Ljava/lang/String;
    //   197: invokespecial <init> : (Ljava/lang/String;)V
    //   200: aload_3
    //   201: aload_1
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
    //   229: getstatic com/google/protobuf/Int64Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int64Value;
    //   232: areturn
    //   233: aload_2
    //   234: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   237: astore_1
    //   238: aload_3
    //   239: checkcast com/google/protobuf/Int64Value
    //   242: astore_2
    //   243: aload_0
    //   244: getfield value_ : J
    //   247: lconst_0
    //   248: lcmp
    //   249: ifeq -> 258
    //   252: iconst_1
    //   253: istore #6
    //   255: goto -> 261
    //   258: iconst_0
    //   259: istore #6
    //   261: aload_0
    //   262: getfield value_ : J
    //   265: lstore #7
    //   267: aload_2
    //   268: getfield value_ : J
    //   271: lconst_0
    //   272: lcmp
    //   273: ifeq -> 282
    //   276: iconst_1
    //   277: istore #9
    //   279: goto -> 285
    //   282: iconst_0
    //   283: istore #9
    //   285: aload_0
    //   286: aload_1
    //   287: iload #6
    //   289: lload #7
    //   291: iload #9
    //   293: aload_2
    //   294: getfield value_ : J
    //   297: invokeinterface visitLong : (ZJZJ)J
    //   302: putfield value_ : J
    //   305: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   308: astore_1
    //   309: aload_0
    //   310: areturn
    //   311: new com/google/protobuf/Int64Value$Builder
    //   314: dup
    //   315: aconst_null
    //   316: invokespecial <init> : (Lcom/google/protobuf/Int64Value$1;)V
    //   319: areturn
    //   320: aconst_null
    //   321: areturn
    //   322: getstatic com/google/protobuf/Int64Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Int64Value;
    //   325: areturn
    //   326: new com/google/protobuf/Int64Value
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
    long l = this.value_;
    if (l != 0L)
      i = 0 + CodedOutputStream.computeInt64Size(1, l); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public long getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    long l = this.value_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(1, l); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Int64Value, Builder> implements Int64ValueOrBuilder {
    private Builder() {
      super(Int64Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public long getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(long param1Long) {
      copyOnWrite();
      this.instance.setValue(param1Long);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Int64Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */