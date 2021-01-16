package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class StringValue extends GeneratedMessageLite<StringValue, StringValue.Builder> implements StringValueOrBuilder {
  private static final StringValue DEFAULT_INSTANCE = new StringValue();
  
  private static volatile Parser<StringValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private String value_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = getDefaultInstance().getValue();
  }
  
  public static StringValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(StringValue paramStringValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramStringValue);
  }
  
  public static StringValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (StringValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static StringValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (StringValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static StringValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static StringValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static StringValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static StringValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static StringValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<StringValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<StringValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(String paramString) {
    if (paramString != null) {
      this.value_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.value_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/StringValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/StringValue
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/StringValue.DEFAULT_INSTANCE : Lcom/google/protobuf/StringValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/StringValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/StringValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/StringValue.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_1
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_2
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 228
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 172
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 161
    //   146: aload_1
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: iconst_1
    //   156: istore #4
    //   158: goto -> 123
    //   161: aload_0
    //   162: aload_1
    //   163: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   166: putfield value_ : Ljava/lang/String;
    //   169: goto -> 123
    //   172: iconst_1
    //   173: istore #4
    //   175: goto -> 123
    //   178: astore_1
    //   179: goto -> 226
    //   182: astore_1
    //   183: new java/lang/RuntimeException
    //   186: astore_3
    //   187: new com/google/protobuf/InvalidProtocolBufferException
    //   190: astore_2
    //   191: aload_2
    //   192: aload_1
    //   193: invokevirtual getMessage : ()Ljava/lang/String;
    //   196: invokespecial <init> : (Ljava/lang/String;)V
    //   199: aload_3
    //   200: aload_2
    //   201: aload_0
    //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   208: aload_3
    //   209: athrow
    //   210: astore_1
    //   211: new java/lang/RuntimeException
    //   214: astore_2
    //   215: aload_2
    //   216: aload_1
    //   217: aload_0
    //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   224: aload_2
    //   225: athrow
    //   226: aload_1
    //   227: athrow
    //   228: getstatic com/google/protobuf/StringValue.DEFAULT_INSTANCE : Lcom/google/protobuf/StringValue;
    //   231: areturn
    //   232: aload_2
    //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   236: astore_1
    //   237: aload_3
    //   238: checkcast com/google/protobuf/StringValue
    //   241: astore_2
    //   242: aload_0
    //   243: aload_1
    //   244: aload_0
    //   245: getfield value_ : Ljava/lang/String;
    //   248: invokevirtual isEmpty : ()Z
    //   251: iconst_1
    //   252: ixor
    //   253: aload_0
    //   254: getfield value_ : Ljava/lang/String;
    //   257: iconst_1
    //   258: aload_2
    //   259: getfield value_ : Ljava/lang/String;
    //   262: invokevirtual isEmpty : ()Z
    //   265: ixor
    //   266: aload_2
    //   267: getfield value_ : Ljava/lang/String;
    //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   275: putfield value_ : Ljava/lang/String;
    //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   281: astore_1
    //   282: aload_0
    //   283: areturn
    //   284: new com/google/protobuf/StringValue$Builder
    //   287: dup
    //   288: aconst_null
    //   289: invokespecial <init> : (Lcom/google/protobuf/StringValue$1;)V
    //   292: areturn
    //   293: aconst_null
    //   294: areturn
    //   295: getstatic com/google/protobuf/StringValue.DEFAULT_INSTANCE : Lcom/google/protobuf/StringValue;
    //   298: areturn
    //   299: new com/google/protobuf/StringValue
    //   302: dup
    //   303: invokespecial <init> : ()V
    //   306: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	210	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	182	java/io/IOException
    //   128	134	178	finally
    //   146	155	210	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	182	java/io/IOException
    //   146	155	178	finally
    //   161	169	210	com/google/protobuf/InvalidProtocolBufferException
    //   161	169	182	java/io/IOException
    //   161	169	178	finally
    //   183	210	178	finally
    //   211	226	178	finally
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.value_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getValue()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getValue() {
    return this.value_;
  }
  
  public ByteString getValueBytes() {
    return ByteString.copyFromUtf8(this.value_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.value_.isEmpty())
      paramCodedOutputStream.writeString(1, getValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<StringValue, Builder> implements StringValueOrBuilder {
    private Builder() {
      super(StringValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public String getValue() {
      return this.instance.getValue();
    }
    
    public ByteString getValueBytes() {
      return this.instance.getValueBytes();
    }
    
    public Builder setValue(String param1String) {
      copyOnWrite();
      this.instance.setValue(param1String);
      return this;
    }
    
    public Builder setValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setValueBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\StringValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */