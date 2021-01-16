package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class AuthorizationConfig extends GeneratedMessageLite<AuthorizationConfig, AuthorizationConfig.Builder> implements AuthorizationConfigOrBuilder {
  private static final AuthorizationConfig DEFAULT_INSTANCE = new AuthorizationConfig();
  
  private static volatile Parser<AuthorizationConfig> PARSER;
  
  public static final int PROVIDER_FIELD_NUMBER = 1;
  
  private String provider_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearProvider() {
    this.provider_ = getDefaultInstance().getProvider();
  }
  
  public static AuthorizationConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthorizationConfig paramAuthorizationConfig) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuthorizationConfig);
  }
  
  public static AuthorizationConfig parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthorizationConfig)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthorizationConfig parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationConfig)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationConfig parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static AuthorizationConfig parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthorizationConfig parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static AuthorizationConfig parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationConfig parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthorizationConfig parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationConfig parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static AuthorizationConfig parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationConfig)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthorizationConfig> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setProvider(String paramString) {
    if (paramString != null) {
      this.provider_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProviderBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.provider_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/AuthorizationConfig$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 299, 2 -> 295, 3 -> 293, 4 -> 284, 5 -> 232, 6 -> 110, 7 -> 228, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/AuthorizationConfig.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/AuthorizationConfig
    //   72: monitorenter
    //   73: getstatic com/google/api/AuthorizationConfig.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/AuthorizationConfig.DEFAULT_INSTANCE : Lcom/google/api/AuthorizationConfig;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/AuthorizationConfig.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/AuthorizationConfig
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/AuthorizationConfig
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/AuthorizationConfig.PARSER : Lcom/google/protobuf/Parser;
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
    //   166: putfield provider_ : Ljava/lang/String;
    //   169: goto -> 123
    //   172: iconst_1
    //   173: istore #4
    //   175: goto -> 123
    //   178: astore_1
    //   179: goto -> 226
    //   182: astore_2
    //   183: new java/lang/RuntimeException
    //   186: astore_3
    //   187: new com/google/protobuf/InvalidProtocolBufferException
    //   190: astore_1
    //   191: aload_1
    //   192: aload_2
    //   193: invokevirtual getMessage : ()Ljava/lang/String;
    //   196: invokespecial <init> : (Ljava/lang/String;)V
    //   199: aload_3
    //   200: aload_1
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
    //   228: getstatic com/google/api/AuthorizationConfig.DEFAULT_INSTANCE : Lcom/google/api/AuthorizationConfig;
    //   231: areturn
    //   232: aload_2
    //   233: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   236: astore_1
    //   237: aload_3
    //   238: checkcast com/google/api/AuthorizationConfig
    //   241: astore_2
    //   242: aload_0
    //   243: aload_1
    //   244: aload_0
    //   245: getfield provider_ : Ljava/lang/String;
    //   248: invokevirtual isEmpty : ()Z
    //   251: iconst_1
    //   252: ixor
    //   253: aload_0
    //   254: getfield provider_ : Ljava/lang/String;
    //   257: iconst_1
    //   258: aload_2
    //   259: getfield provider_ : Ljava/lang/String;
    //   262: invokevirtual isEmpty : ()Z
    //   265: ixor
    //   266: aload_2
    //   267: getfield provider_ : Ljava/lang/String;
    //   270: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   275: putfield provider_ : Ljava/lang/String;
    //   278: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   281: astore_1
    //   282: aload_0
    //   283: areturn
    //   284: new com/google/api/AuthorizationConfig$Builder
    //   287: dup
    //   288: aconst_null
    //   289: invokespecial <init> : (Lcom/google/api/AuthorizationConfig$1;)V
    //   292: areturn
    //   293: aconst_null
    //   294: areturn
    //   295: getstatic com/google/api/AuthorizationConfig.DEFAULT_INSTANCE : Lcom/google/api/AuthorizationConfig;
    //   298: areturn
    //   299: new com/google/api/AuthorizationConfig
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
  
  public String getProvider() {
    return this.provider_;
  }
  
  public ByteString getProviderBytes() {
    return ByteString.copyFromUtf8(this.provider_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.provider_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getProvider()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.provider_.isEmpty())
      paramCodedOutputStream.writeString(1, getProvider()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationConfig, Builder> implements AuthorizationConfigOrBuilder {
    private Builder() {
      super(AuthorizationConfig.DEFAULT_INSTANCE);
    }
    
    public Builder clearProvider() {
      copyOnWrite();
      ((AuthorizationConfig)this.instance).clearProvider();
      return this;
    }
    
    public String getProvider() {
      return ((AuthorizationConfig)this.instance).getProvider();
    }
    
    public ByteString getProviderBytes() {
      return ((AuthorizationConfig)this.instance).getProviderBytes();
    }
    
    public Builder setProvider(String param1String) {
      copyOnWrite();
      ((AuthorizationConfig)this.instance).setProvider(param1String);
      return this;
    }
    
    public Builder setProviderBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthorizationConfig)this.instance).setProviderBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthorizationConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */