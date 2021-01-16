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

public final class AuthRequirement extends GeneratedMessageLite<AuthRequirement, AuthRequirement.Builder> implements AuthRequirementOrBuilder {
  public static final int AUDIENCES_FIELD_NUMBER = 2;
  
  private static final AuthRequirement DEFAULT_INSTANCE = new AuthRequirement();
  
  private static volatile Parser<AuthRequirement> PARSER;
  
  public static final int PROVIDER_ID_FIELD_NUMBER = 1;
  
  private String audiences_ = "";
  
  private String providerId_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAudiences() {
    this.audiences_ = getDefaultInstance().getAudiences();
  }
  
  private void clearProviderId() {
    this.providerId_ = getDefaultInstance().getProviderId();
  }
  
  public static AuthRequirement getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthRequirement paramAuthRequirement) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuthRequirement);
  }
  
  public static AuthRequirement parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthRequirement)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthRequirement parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthRequirement)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static AuthRequirement parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static AuthRequirement parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthRequirement parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthRequirement parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static AuthRequirement parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthRequirement)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthRequirement> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAudiences(String paramString) {
    if (paramString != null) {
      this.audiences_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAudiencesBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.audiences_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProviderId(String paramString) {
    if (paramString != null) {
      this.providerId_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setProviderIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.providerId_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/AuthRequirement$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 353, 2 -> 349, 3 -> 347, 4 -> 338, 5 -> 250, 6 -> 110, 7 -> 246, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/AuthRequirement.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/AuthRequirement
    //   72: monitorenter
    //   73: getstatic com/google/api/AuthRequirement.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/AuthRequirement.DEFAULT_INSTANCE : Lcom/google/api/AuthRequirement;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/AuthRequirement.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/AuthRequirement
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/AuthRequirement
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/AuthRequirement.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 246
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 190
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 179
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 168
    //   153: aload_1
    //   154: iload #5
    //   156: invokevirtual skipField : (I)Z
    //   159: ifne -> 123
    //   162: iconst_1
    //   163: istore #4
    //   165: goto -> 123
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   173: putfield audiences_ : Ljava/lang/String;
    //   176: goto -> 123
    //   179: aload_0
    //   180: aload_1
    //   181: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   184: putfield providerId_ : Ljava/lang/String;
    //   187: goto -> 123
    //   190: iconst_1
    //   191: istore #4
    //   193: goto -> 123
    //   196: astore_1
    //   197: goto -> 244
    //   200: astore_2
    //   201: new java/lang/RuntimeException
    //   204: astore_1
    //   205: new com/google/protobuf/InvalidProtocolBufferException
    //   208: astore_3
    //   209: aload_3
    //   210: aload_2
    //   211: invokevirtual getMessage : ()Ljava/lang/String;
    //   214: invokespecial <init> : (Ljava/lang/String;)V
    //   217: aload_1
    //   218: aload_3
    //   219: aload_0
    //   220: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   223: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   226: aload_1
    //   227: athrow
    //   228: astore_2
    //   229: new java/lang/RuntimeException
    //   232: astore_1
    //   233: aload_1
    //   234: aload_2
    //   235: aload_0
    //   236: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   239: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   242: aload_1
    //   243: athrow
    //   244: aload_1
    //   245: athrow
    //   246: getstatic com/google/api/AuthRequirement.DEFAULT_INSTANCE : Lcom/google/api/AuthRequirement;
    //   249: areturn
    //   250: aload_2
    //   251: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   254: astore_1
    //   255: aload_3
    //   256: checkcast com/google/api/AuthRequirement
    //   259: astore_2
    //   260: aload_0
    //   261: aload_1
    //   262: aload_0
    //   263: getfield providerId_ : Ljava/lang/String;
    //   266: invokevirtual isEmpty : ()Z
    //   269: iconst_1
    //   270: ixor
    //   271: aload_0
    //   272: getfield providerId_ : Ljava/lang/String;
    //   275: aload_2
    //   276: getfield providerId_ : Ljava/lang/String;
    //   279: invokevirtual isEmpty : ()Z
    //   282: iconst_1
    //   283: ixor
    //   284: aload_2
    //   285: getfield providerId_ : Ljava/lang/String;
    //   288: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   293: putfield providerId_ : Ljava/lang/String;
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield audiences_ : Ljava/lang/String;
    //   302: invokevirtual isEmpty : ()Z
    //   305: iconst_1
    //   306: ixor
    //   307: aload_0
    //   308: getfield audiences_ : Ljava/lang/String;
    //   311: iconst_1
    //   312: aload_2
    //   313: getfield audiences_ : Ljava/lang/String;
    //   316: invokevirtual isEmpty : ()Z
    //   319: ixor
    //   320: aload_2
    //   321: getfield audiences_ : Ljava/lang/String;
    //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   329: putfield audiences_ : Ljava/lang/String;
    //   332: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   335: astore_1
    //   336: aload_0
    //   337: areturn
    //   338: new com/google/api/AuthRequirement$Builder
    //   341: dup
    //   342: aconst_null
    //   343: invokespecial <init> : (Lcom/google/api/AuthRequirement$1;)V
    //   346: areturn
    //   347: aconst_null
    //   348: areturn
    //   349: getstatic com/google/api/AuthRequirement.DEFAULT_INSTANCE : Lcom/google/api/AuthRequirement;
    //   352: areturn
    //   353: new com/google/api/AuthRequirement
    //   356: dup
    //   357: invokespecial <init> : ()V
    //   360: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	228	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	200	java/io/IOException
    //   128	134	196	finally
    //   153	162	228	com/google/protobuf/InvalidProtocolBufferException
    //   153	162	200	java/io/IOException
    //   153	162	196	finally
    //   168	176	228	com/google/protobuf/InvalidProtocolBufferException
    //   168	176	200	java/io/IOException
    //   168	176	196	finally
    //   179	187	228	com/google/protobuf/InvalidProtocolBufferException
    //   179	187	200	java/io/IOException
    //   179	187	196	finally
    //   201	228	196	finally
    //   229	244	196	finally
  }
  
  public String getAudiences() {
    return this.audiences_;
  }
  
  public ByteString getAudiencesBytes() {
    return ByteString.copyFromUtf8(this.audiences_);
  }
  
  public String getProviderId() {
    return this.providerId_;
  }
  
  public ByteString getProviderIdBytes() {
    return ByteString.copyFromUtf8(this.providerId_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.providerId_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getProviderId()); 
    int j = i;
    if (!this.audiences_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getAudiences()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.providerId_.isEmpty())
      paramCodedOutputStream.writeString(1, getProviderId()); 
    if (!this.audiences_.isEmpty())
      paramCodedOutputStream.writeString(2, getAudiences()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AuthRequirement, Builder> implements AuthRequirementOrBuilder {
    private Builder() {
      super(AuthRequirement.DEFAULT_INSTANCE);
    }
    
    public Builder clearAudiences() {
      copyOnWrite();
      ((AuthRequirement)this.instance).clearAudiences();
      return this;
    }
    
    public Builder clearProviderId() {
      copyOnWrite();
      ((AuthRequirement)this.instance).clearProviderId();
      return this;
    }
    
    public String getAudiences() {
      return ((AuthRequirement)this.instance).getAudiences();
    }
    
    public ByteString getAudiencesBytes() {
      return ((AuthRequirement)this.instance).getAudiencesBytes();
    }
    
    public String getProviderId() {
      return ((AuthRequirement)this.instance).getProviderId();
    }
    
    public ByteString getProviderIdBytes() {
      return ((AuthRequirement)this.instance).getProviderIdBytes();
    }
    
    public Builder setAudiences(String param1String) {
      copyOnWrite();
      ((AuthRequirement)this.instance).setAudiences(param1String);
      return this;
    }
    
    public Builder setAudiencesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthRequirement)this.instance).setAudiencesBytes(param1ByteString);
      return this;
    }
    
    public Builder setProviderId(String param1String) {
      copyOnWrite();
      ((AuthRequirement)this.instance).setProviderId(param1String);
      return this;
    }
    
    public Builder setProviderIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthRequirement)this.instance).setProviderIdBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */