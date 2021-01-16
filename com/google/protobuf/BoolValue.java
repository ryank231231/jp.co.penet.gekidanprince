package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class BoolValue extends GeneratedMessageLite<BoolValue, BoolValue.Builder> implements BoolValueOrBuilder {
  private static final BoolValue DEFAULT_INSTANCE = new BoolValue();
  
  private static volatile Parser<BoolValue> PARSER;
  
  public static final int VALUE_FIELD_NUMBER = 1;
  
  private boolean value_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearValue() {
    this.value_ = false;
  }
  
  public static BoolValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BoolValue paramBoolValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramBoolValue);
  }
  
  public static BoolValue parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BoolValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BoolValue parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BoolValue)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BoolValue parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BoolValue parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BoolValue parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BoolValue parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BoolValue parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<BoolValue>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BoolValue> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setValue(boolean paramBoolean) {
    this.value_ = paramBoolean;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/BoolValue$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 293, 2 -> 289, 3 -> 287, 4 -> 278, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/BoolValue
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/BoolValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BoolValue;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/BoolValue
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/BoolValue
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/BoolValue.PARSER : Lcom/google/protobuf/Parser;
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
    //   141: bipush #8
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
    //   163: invokevirtual readBool : ()Z
    //   166: putfield value_ : Z
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
    //   210: astore_2
    //   211: new java/lang/RuntimeException
    //   214: astore_1
    //   215: aload_1
    //   216: aload_2
    //   217: aload_0
    //   218: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   221: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   224: aload_1
    //   225: athrow
    //   226: aload_1
    //   227: athrow
    //   228: getstatic com/google/protobuf/BoolValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BoolValue;
    //   231: areturn
    //   232: aload_2
    //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   236: astore_1
    //   237: aload_3
    //   238: checkcast com/google/protobuf/BoolValue
    //   241: astore_2
    //   242: aload_0
    //   243: getfield value_ : Z
    //   246: istore #6
    //   248: aload_2
    //   249: getfield value_ : Z
    //   252: istore #7
    //   254: aload_0
    //   255: aload_1
    //   256: iload #6
    //   258: iload #6
    //   260: iload #7
    //   262: iload #7
    //   264: invokeinterface visitBoolean : (ZZZZ)Z
    //   269: putfield value_ : Z
    //   272: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   275: astore_1
    //   276: aload_0
    //   277: areturn
    //   278: new com/google/protobuf/BoolValue$Builder
    //   281: dup
    //   282: aconst_null
    //   283: invokespecial <init> : (Lcom/google/protobuf/BoolValue$1;)V
    //   286: areturn
    //   287: aconst_null
    //   288: areturn
    //   289: getstatic com/google/protobuf/BoolValue.DEFAULT_INSTANCE : Lcom/google/protobuf/BoolValue;
    //   292: areturn
    //   293: new com/google/protobuf/BoolValue
    //   296: dup
    //   297: invokespecial <init> : ()V
    //   300: areturn
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
    boolean bool = this.value_;
    if (bool)
      i = 0 + CodedOutputStream.computeBoolSize(1, bool); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean getValue() {
    return this.value_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    boolean bool = this.value_;
    if (bool)
      paramCodedOutputStream.writeBool(1, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BoolValue, Builder> implements BoolValueOrBuilder {
    private Builder() {
      super(BoolValue.DEFAULT_INSTANCE);
    }
    
    public Builder clearValue() {
      copyOnWrite();
      this.instance.clearValue();
      return this;
    }
    
    public boolean getValue() {
      return this.instance.getValue();
    }
    
    public Builder setValue(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setValue(param1Boolean);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\BoolValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */