package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class SourceContext extends GeneratedMessageLite<SourceContext, SourceContext.Builder> implements SourceContextOrBuilder {
  private static final SourceContext DEFAULT_INSTANCE = new SourceContext();
  
  public static final int FILE_NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<SourceContext> PARSER;
  
  private String fileName_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearFileName() {
    this.fileName_ = getDefaultInstance().getFileName();
  }
  
  public static SourceContext getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(SourceContext paramSourceContext) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramSourceContext);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (SourceContext)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceContext parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (SourceContext)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static SourceContext parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static SourceContext parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static SourceContext parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static SourceContext parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<SourceContext>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<SourceContext> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setFileName(String paramString) {
    if (paramString != null) {
      this.fileName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFileNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.fileName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/SourceContext$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/protobuf/SourceContext
    //   72: monitorenter
    //   73: getstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/protobuf/SourceContext.DEFAULT_INSTANCE : Lcom/google/protobuf/SourceContext;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/protobuf/SourceContext
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/protobuf/SourceContext
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/protobuf/SourceContext.PARSER : Lcom/google/protobuf/Parser;
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
    //   166: putfield fileName_ : Ljava/lang/String;
    //   169: goto -> 123
    //   172: iconst_1
    //   173: istore #4
    //   175: goto -> 123
    //   178: astore_1
    //   179: goto -> 226
    //   182: astore_2
    //   183: new java/lang/RuntimeException
    //   186: astore_1
    //   187: new com/google/protobuf/InvalidProtocolBufferException
    //   190: astore_3
    //   191: aload_3
    //   192: aload_2
    //   193: invokevirtual getMessage : ()Ljava/lang/String;
    //   196: invokespecial <init> : (Ljava/lang/String;)V
    //   199: aload_1
    //   200: aload_3
    //   201: aload_0
    //   202: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   205: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   208: aload_1
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
    //   228: getstatic com/google/protobuf/SourceContext.DEFAULT_INSTANCE : Lcom/google/protobuf/SourceContext;
    //   231: areturn
    //   232: aload_2
    //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   236: astore_1
    //   237: aload_3
    //   238: checkcast com/google/protobuf/SourceContext
    //   241: astore_2
    //   242: aload_0
    //   243: aload_1
    //   244: aload_0
    //   245: getfield fileName_ : Ljava/lang/String;
    //   248: invokevirtual isEmpty : ()Z
    //   251: iconst_1
    //   252: ixor
    //   253: aload_0
    //   254: getfield fileName_ : Ljava/lang/String;
    //   257: iconst_1
    //   258: aload_2
    //   259: getfield fileName_ : Ljava/lang/String;
    //   262: invokevirtual isEmpty : ()Z
    //   265: ixor
    //   266: aload_2
    //   267: getfield fileName_ : Ljava/lang/String;
    //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   275: putfield fileName_ : Ljava/lang/String;
    //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   281: astore_1
    //   282: aload_0
    //   283: areturn
    //   284: new com/google/protobuf/SourceContext$Builder
    //   287: dup
    //   288: aconst_null
    //   289: invokespecial <init> : (Lcom/google/protobuf/SourceContext$1;)V
    //   292: areturn
    //   293: aconst_null
    //   294: areturn
    //   295: getstatic com/google/protobuf/SourceContext.DEFAULT_INSTANCE : Lcom/google/protobuf/SourceContext;
    //   298: areturn
    //   299: new com/google/protobuf/SourceContext
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
  
  public String getFileName() {
    return this.fileName_;
  }
  
  public ByteString getFileNameBytes() {
    return ByteString.copyFromUtf8(this.fileName_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.fileName_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getFileName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.fileName_.isEmpty())
      paramCodedOutputStream.writeString(1, getFileName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<SourceContext, Builder> implements SourceContextOrBuilder {
    private Builder() {
      super(SourceContext.DEFAULT_INSTANCE);
    }
    
    public Builder clearFileName() {
      copyOnWrite();
      this.instance.clearFileName();
      return this;
    }
    
    public String getFileName() {
      return this.instance.getFileName();
    }
    
    public ByteString getFileNameBytes() {
      return this.instance.getFileNameBytes();
    }
    
    public Builder setFileName(String param1String) {
      copyOnWrite();
      this.instance.setFileName(param1String);
      return this;
    }
    
    public Builder setFileNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setFileNameBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\SourceContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */