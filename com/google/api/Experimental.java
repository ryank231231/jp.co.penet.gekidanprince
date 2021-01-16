package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class Experimental extends GeneratedMessageLite<Experimental, Experimental.Builder> implements ExperimentalOrBuilder {
  public static final int AUTHORIZATION_FIELD_NUMBER = 8;
  
  private static final Experimental DEFAULT_INSTANCE = new Experimental();
  
  private static volatile Parser<Experimental> PARSER;
  
  private AuthorizationConfig authorization_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAuthorization() {
    this.authorization_ = null;
  }
  
  public static Experimental getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeAuthorization(AuthorizationConfig paramAuthorizationConfig) {
    AuthorizationConfig authorizationConfig = this.authorization_;
    if (authorizationConfig != null && authorizationConfig != AuthorizationConfig.getDefaultInstance()) {
      this.authorization_ = (AuthorizationConfig)((AuthorizationConfig.Builder)AuthorizationConfig.newBuilder(this.authorization_).mergeFrom(paramAuthorizationConfig)).buildPartial();
    } else {
      this.authorization_ = paramAuthorizationConfig;
    } 
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Experimental paramExperimental) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramExperimental);
  }
  
  public static Experimental parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Experimental)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Experimental parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Experimental)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Experimental parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Experimental parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Experimental parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Experimental parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Experimental parseFrom(InputStream paramInputStream) throws IOException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Experimental parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Experimental parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Experimental parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (Experimental)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Experimental> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAuthorization(AuthorizationConfig.Builder paramBuilder) {
    this.authorization_ = (AuthorizationConfig)paramBuilder.build();
  }
  
  private void setAuthorization(AuthorizationConfig paramAuthorizationConfig) {
    if (paramAuthorizationConfig != null) {
      this.authorization_ = paramAuthorizationConfig;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/Experimental$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 338, 2 -> 334, 3 -> 332, 4 -> 323, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/Experimental.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/Experimental
    //   72: monitorenter
    //   73: getstatic com/google/api/Experimental.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/Experimental.DEFAULT_INSTANCE : Lcom/google/api/Experimental;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/Experimental.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/Experimental
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/Experimental
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/Experimental.PARSER : Lcom/google/protobuf/Parser;
    //   109: areturn
    //   110: aload_2
    //   111: checkcast com/google/protobuf/CodedInputStream
    //   114: astore_2
    //   115: aload_3
    //   116: checkcast com/google/protobuf/ExtensionRegistryLite
    //   119: astore_3
    //   120: iconst_0
    //   121: istore #4
    //   123: iload #4
    //   125: ifne -> 282
    //   128: aload_2
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 226
    //   139: iload #5
    //   141: bipush #66
    //   143: if_icmpeq -> 161
    //   146: aload_2
    //   147: iload #5
    //   149: invokevirtual skipField : (I)Z
    //   152: ifne -> 123
    //   155: iconst_1
    //   156: istore #4
    //   158: goto -> 123
    //   161: aload_0
    //   162: getfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   165: ifnull -> 182
    //   168: aload_0
    //   169: getfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   172: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   175: checkcast com/google/api/AuthorizationConfig$Builder
    //   178: astore_1
    //   179: goto -> 184
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_0
    //   185: aload_2
    //   186: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   189: aload_3
    //   190: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   193: checkcast com/google/api/AuthorizationConfig
    //   196: putfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   199: aload_1
    //   200: ifnull -> 123
    //   203: aload_1
    //   204: aload_0
    //   205: getfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   208: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   211: pop
    //   212: aload_0
    //   213: aload_1
    //   214: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   217: checkcast com/google/api/AuthorizationConfig
    //   220: putfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   223: goto -> 123
    //   226: iconst_1
    //   227: istore #4
    //   229: goto -> 123
    //   232: astore_1
    //   233: goto -> 280
    //   236: astore_2
    //   237: new java/lang/RuntimeException
    //   240: astore_3
    //   241: new com/google/protobuf/InvalidProtocolBufferException
    //   244: astore_1
    //   245: aload_1
    //   246: aload_2
    //   247: invokevirtual getMessage : ()Ljava/lang/String;
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: aload_3
    //   254: aload_1
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_3
    //   263: athrow
    //   264: astore_2
    //   265: new java/lang/RuntimeException
    //   268: astore_1
    //   269: aload_1
    //   270: aload_2
    //   271: aload_0
    //   272: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   275: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   278: aload_1
    //   279: athrow
    //   280: aload_1
    //   281: athrow
    //   282: getstatic com/google/api/Experimental.DEFAULT_INSTANCE : Lcom/google/api/Experimental;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/api/Experimental
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   302: aload_2
    //   303: getfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   306: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   311: checkcast com/google/api/AuthorizationConfig
    //   314: putfield authorization_ : Lcom/google/api/AuthorizationConfig;
    //   317: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   320: astore_1
    //   321: aload_0
    //   322: areturn
    //   323: new com/google/api/Experimental$Builder
    //   326: dup
    //   327: aconst_null
    //   328: invokespecial <init> : (Lcom/google/api/Experimental$1;)V
    //   331: areturn
    //   332: aconst_null
    //   333: areturn
    //   334: getstatic com/google/api/Experimental.DEFAULT_INSTANCE : Lcom/google/api/Experimental;
    //   337: areturn
    //   338: new com/google/api/Experimental
    //   341: dup
    //   342: invokespecial <init> : ()V
    //   345: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	236	java/io/IOException
    //   128	134	232	finally
    //   146	155	264	com/google/protobuf/InvalidProtocolBufferException
    //   146	155	236	java/io/IOException
    //   146	155	232	finally
    //   161	179	264	com/google/protobuf/InvalidProtocolBufferException
    //   161	179	236	java/io/IOException
    //   161	179	232	finally
    //   184	199	264	com/google/protobuf/InvalidProtocolBufferException
    //   184	199	236	java/io/IOException
    //   184	199	232	finally
    //   203	223	264	com/google/protobuf/InvalidProtocolBufferException
    //   203	223	236	java/io/IOException
    //   203	223	232	finally
    //   237	264	232	finally
    //   265	280	232	finally
  }
  
  public AuthorizationConfig getAuthorization() {
    AuthorizationConfig authorizationConfig1 = this.authorization_;
    AuthorizationConfig authorizationConfig2 = authorizationConfig1;
    if (authorizationConfig1 == null)
      authorizationConfig2 = AuthorizationConfig.getDefaultInstance(); 
    return authorizationConfig2;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (this.authorization_ != null)
      i = 0 + CodedOutputStream.computeMessageSize(8, (MessageLite)getAuthorization()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public boolean hasAuthorization() {
    boolean bool;
    if (this.authorization_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.authorization_ != null)
      paramCodedOutputStream.writeMessage(8, (MessageLite)getAuthorization()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Experimental, Builder> implements ExperimentalOrBuilder {
    private Builder() {
      super(Experimental.DEFAULT_INSTANCE);
    }
    
    public Builder clearAuthorization() {
      copyOnWrite();
      ((Experimental)this.instance).clearAuthorization();
      return this;
    }
    
    public AuthorizationConfig getAuthorization() {
      return ((Experimental)this.instance).getAuthorization();
    }
    
    public boolean hasAuthorization() {
      return ((Experimental)this.instance).hasAuthorization();
    }
    
    public Builder mergeAuthorization(AuthorizationConfig param1AuthorizationConfig) {
      copyOnWrite();
      ((Experimental)this.instance).mergeAuthorization(param1AuthorizationConfig);
      return this;
    }
    
    public Builder setAuthorization(AuthorizationConfig.Builder param1Builder) {
      copyOnWrite();
      ((Experimental)this.instance).setAuthorization(param1Builder);
      return this;
    }
    
    public Builder setAuthorization(AuthorizationConfig param1AuthorizationConfig) {
      copyOnWrite();
      ((Experimental)this.instance).setAuthorization(param1AuthorizationConfig);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\Experimental.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */