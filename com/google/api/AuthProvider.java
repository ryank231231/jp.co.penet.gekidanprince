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

public final class AuthProvider extends GeneratedMessageLite<AuthProvider, AuthProvider.Builder> implements AuthProviderOrBuilder {
  public static final int AUDIENCES_FIELD_NUMBER = 4;
  
  public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
  
  private static final AuthProvider DEFAULT_INSTANCE = new AuthProvider();
  
  public static final int ID_FIELD_NUMBER = 1;
  
  public static final int ISSUER_FIELD_NUMBER = 2;
  
  public static final int JWKS_URI_FIELD_NUMBER = 3;
  
  private static volatile Parser<AuthProvider> PARSER;
  
  private String audiences_ = "";
  
  private String authorizationUrl_ = "";
  
  private String id_ = "";
  
  private String issuer_ = "";
  
  private String jwksUri_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAudiences() {
    this.audiences_ = getDefaultInstance().getAudiences();
  }
  
  private void clearAuthorizationUrl() {
    this.authorizationUrl_ = getDefaultInstance().getAuthorizationUrl();
  }
  
  private void clearId() {
    this.id_ = getDefaultInstance().getId();
  }
  
  private void clearIssuer() {
    this.issuer_ = getDefaultInstance().getIssuer();
  }
  
  private void clearJwksUri() {
    this.jwksUri_ = getDefaultInstance().getJwksUri();
  }
  
  public static AuthProvider getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthProvider paramAuthProvider) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuthProvider);
  }
  
  public static AuthProvider parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthProvider)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthProvider parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthProvider)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static AuthProvider parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static AuthProvider parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthProvider parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthProvider parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static AuthProvider parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthProvider)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthProvider> parser() {
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
  
  private void setAuthorizationUrl(String paramString) {
    if (paramString != null) {
      this.authorizationUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAuthorizationUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.authorizationUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setId(String paramString) {
    if (paramString != null) {
      this.id_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setIdBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.id_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setIssuer(String paramString) {
    if (paramString != null) {
      this.issuer_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setIssuerBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.issuer_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setJwksUri(String paramString) {
    if (paramString != null) {
      this.jwksUri_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setJwksUriBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.jwksUri_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/AuthProvider$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 515, 2 -> 511, 3 -> 509, 4 -> 500, 5 -> 304, 6 -> 110, 7 -> 300, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/AuthProvider.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/AuthProvider
    //   72: monitorenter
    //   73: getstatic com/google/api/AuthProvider.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/AuthProvider.DEFAULT_INSTANCE : Lcom/google/api/AuthProvider;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/AuthProvider.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/AuthProvider
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/AuthProvider
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/AuthProvider.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 300
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 244
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 233
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 222
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 211
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 200
    //   167: iload #5
    //   169: bipush #42
    //   171: if_icmpeq -> 189
    //   174: aload_1
    //   175: iload #5
    //   177: invokevirtual skipField : (I)Z
    //   180: ifne -> 123
    //   183: iconst_1
    //   184: istore #4
    //   186: goto -> 123
    //   189: aload_0
    //   190: aload_1
    //   191: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   194: putfield authorizationUrl_ : Ljava/lang/String;
    //   197: goto -> 123
    //   200: aload_0
    //   201: aload_1
    //   202: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   205: putfield audiences_ : Ljava/lang/String;
    //   208: goto -> 123
    //   211: aload_0
    //   212: aload_1
    //   213: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   216: putfield jwksUri_ : Ljava/lang/String;
    //   219: goto -> 123
    //   222: aload_0
    //   223: aload_1
    //   224: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   227: putfield issuer_ : Ljava/lang/String;
    //   230: goto -> 123
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   238: putfield id_ : Ljava/lang/String;
    //   241: goto -> 123
    //   244: iconst_1
    //   245: istore #4
    //   247: goto -> 123
    //   250: astore_1
    //   251: goto -> 298
    //   254: astore_3
    //   255: new java/lang/RuntimeException
    //   258: astore_1
    //   259: new com/google/protobuf/InvalidProtocolBufferException
    //   262: astore_2
    //   263: aload_2
    //   264: aload_3
    //   265: invokevirtual getMessage : ()Ljava/lang/String;
    //   268: invokespecial <init> : (Ljava/lang/String;)V
    //   271: aload_1
    //   272: aload_2
    //   273: aload_0
    //   274: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   277: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   280: aload_1
    //   281: athrow
    //   282: astore_2
    //   283: new java/lang/RuntimeException
    //   286: astore_1
    //   287: aload_1
    //   288: aload_2
    //   289: aload_0
    //   290: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   293: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   296: aload_1
    //   297: athrow
    //   298: aload_1
    //   299: athrow
    //   300: getstatic com/google/api/AuthProvider.DEFAULT_INSTANCE : Lcom/google/api/AuthProvider;
    //   303: areturn
    //   304: aload_2
    //   305: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   308: astore_1
    //   309: aload_3
    //   310: checkcast com/google/api/AuthProvider
    //   313: astore_2
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield id_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield id_ : Ljava/lang/String;
    //   329: aload_2
    //   330: getfield id_ : Ljava/lang/String;
    //   333: invokevirtual isEmpty : ()Z
    //   336: iconst_1
    //   337: ixor
    //   338: aload_2
    //   339: getfield id_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield id_ : Ljava/lang/String;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield issuer_ : Ljava/lang/String;
    //   356: invokevirtual isEmpty : ()Z
    //   359: iconst_1
    //   360: ixor
    //   361: aload_0
    //   362: getfield issuer_ : Ljava/lang/String;
    //   365: aload_2
    //   366: getfield issuer_ : Ljava/lang/String;
    //   369: invokevirtual isEmpty : ()Z
    //   372: iconst_1
    //   373: ixor
    //   374: aload_2
    //   375: getfield issuer_ : Ljava/lang/String;
    //   378: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   383: putfield issuer_ : Ljava/lang/String;
    //   386: aload_0
    //   387: aload_1
    //   388: aload_0
    //   389: getfield jwksUri_ : Ljava/lang/String;
    //   392: invokevirtual isEmpty : ()Z
    //   395: iconst_1
    //   396: ixor
    //   397: aload_0
    //   398: getfield jwksUri_ : Ljava/lang/String;
    //   401: aload_2
    //   402: getfield jwksUri_ : Ljava/lang/String;
    //   405: invokevirtual isEmpty : ()Z
    //   408: iconst_1
    //   409: ixor
    //   410: aload_2
    //   411: getfield jwksUri_ : Ljava/lang/String;
    //   414: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   419: putfield jwksUri_ : Ljava/lang/String;
    //   422: aload_0
    //   423: aload_1
    //   424: aload_0
    //   425: getfield audiences_ : Ljava/lang/String;
    //   428: invokevirtual isEmpty : ()Z
    //   431: iconst_1
    //   432: ixor
    //   433: aload_0
    //   434: getfield audiences_ : Ljava/lang/String;
    //   437: aload_2
    //   438: getfield audiences_ : Ljava/lang/String;
    //   441: invokevirtual isEmpty : ()Z
    //   444: iconst_1
    //   445: ixor
    //   446: aload_2
    //   447: getfield audiences_ : Ljava/lang/String;
    //   450: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   455: putfield audiences_ : Ljava/lang/String;
    //   458: aload_0
    //   459: aload_1
    //   460: aload_0
    //   461: getfield authorizationUrl_ : Ljava/lang/String;
    //   464: invokevirtual isEmpty : ()Z
    //   467: iconst_1
    //   468: ixor
    //   469: aload_0
    //   470: getfield authorizationUrl_ : Ljava/lang/String;
    //   473: iconst_1
    //   474: aload_2
    //   475: getfield authorizationUrl_ : Ljava/lang/String;
    //   478: invokevirtual isEmpty : ()Z
    //   481: ixor
    //   482: aload_2
    //   483: getfield authorizationUrl_ : Ljava/lang/String;
    //   486: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   491: putfield authorizationUrl_ : Ljava/lang/String;
    //   494: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   497: astore_1
    //   498: aload_0
    //   499: areturn
    //   500: new com/google/api/AuthProvider$Builder
    //   503: dup
    //   504: aconst_null
    //   505: invokespecial <init> : (Lcom/google/api/AuthProvider$1;)V
    //   508: areturn
    //   509: aconst_null
    //   510: areturn
    //   511: getstatic com/google/api/AuthProvider.DEFAULT_INSTANCE : Lcom/google/api/AuthProvider;
    //   514: areturn
    //   515: new com/google/api/AuthProvider
    //   518: dup
    //   519: invokespecial <init> : ()V
    //   522: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	282	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	254	java/io/IOException
    //   128	134	250	finally
    //   174	183	282	com/google/protobuf/InvalidProtocolBufferException
    //   174	183	254	java/io/IOException
    //   174	183	250	finally
    //   189	197	282	com/google/protobuf/InvalidProtocolBufferException
    //   189	197	254	java/io/IOException
    //   189	197	250	finally
    //   200	208	282	com/google/protobuf/InvalidProtocolBufferException
    //   200	208	254	java/io/IOException
    //   200	208	250	finally
    //   211	219	282	com/google/protobuf/InvalidProtocolBufferException
    //   211	219	254	java/io/IOException
    //   211	219	250	finally
    //   222	230	282	com/google/protobuf/InvalidProtocolBufferException
    //   222	230	254	java/io/IOException
    //   222	230	250	finally
    //   233	241	282	com/google/protobuf/InvalidProtocolBufferException
    //   233	241	254	java/io/IOException
    //   233	241	250	finally
    //   255	282	250	finally
    //   283	298	250	finally
  }
  
  public String getAudiences() {
    return this.audiences_;
  }
  
  public ByteString getAudiencesBytes() {
    return ByteString.copyFromUtf8(this.audiences_);
  }
  
  public String getAuthorizationUrl() {
    return this.authorizationUrl_;
  }
  
  public ByteString getAuthorizationUrlBytes() {
    return ByteString.copyFromUtf8(this.authorizationUrl_);
  }
  
  public String getId() {
    return this.id_;
  }
  
  public ByteString getIdBytes() {
    return ByteString.copyFromUtf8(this.id_);
  }
  
  public String getIssuer() {
    return this.issuer_;
  }
  
  public ByteString getIssuerBytes() {
    return ByteString.copyFromUtf8(this.issuer_);
  }
  
  public String getJwksUri() {
    return this.jwksUri_;
  }
  
  public ByteString getJwksUriBytes() {
    return ByteString.copyFromUtf8(this.jwksUri_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.id_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getId()); 
    i = j;
    if (!this.issuer_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getIssuer()); 
    j = i;
    if (!this.jwksUri_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getJwksUri()); 
    i = j;
    if (!this.audiences_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(4, getAudiences()); 
    j = i;
    if (!this.authorizationUrl_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(5, getAuthorizationUrl()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.id_.isEmpty())
      paramCodedOutputStream.writeString(1, getId()); 
    if (!this.issuer_.isEmpty())
      paramCodedOutputStream.writeString(2, getIssuer()); 
    if (!this.jwksUri_.isEmpty())
      paramCodedOutputStream.writeString(3, getJwksUri()); 
    if (!this.audiences_.isEmpty())
      paramCodedOutputStream.writeString(4, getAudiences()); 
    if (!this.authorizationUrl_.isEmpty())
      paramCodedOutputStream.writeString(5, getAuthorizationUrl()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AuthProvider, Builder> implements AuthProviderOrBuilder {
    private Builder() {
      super(AuthProvider.DEFAULT_INSTANCE);
    }
    
    public Builder clearAudiences() {
      copyOnWrite();
      ((AuthProvider)this.instance).clearAudiences();
      return this;
    }
    
    public Builder clearAuthorizationUrl() {
      copyOnWrite();
      ((AuthProvider)this.instance).clearAuthorizationUrl();
      return this;
    }
    
    public Builder clearId() {
      copyOnWrite();
      ((AuthProvider)this.instance).clearId();
      return this;
    }
    
    public Builder clearIssuer() {
      copyOnWrite();
      ((AuthProvider)this.instance).clearIssuer();
      return this;
    }
    
    public Builder clearJwksUri() {
      copyOnWrite();
      ((AuthProvider)this.instance).clearJwksUri();
      return this;
    }
    
    public String getAudiences() {
      return ((AuthProvider)this.instance).getAudiences();
    }
    
    public ByteString getAudiencesBytes() {
      return ((AuthProvider)this.instance).getAudiencesBytes();
    }
    
    public String getAuthorizationUrl() {
      return ((AuthProvider)this.instance).getAuthorizationUrl();
    }
    
    public ByteString getAuthorizationUrlBytes() {
      return ((AuthProvider)this.instance).getAuthorizationUrlBytes();
    }
    
    public String getId() {
      return ((AuthProvider)this.instance).getId();
    }
    
    public ByteString getIdBytes() {
      return ((AuthProvider)this.instance).getIdBytes();
    }
    
    public String getIssuer() {
      return ((AuthProvider)this.instance).getIssuer();
    }
    
    public ByteString getIssuerBytes() {
      return ((AuthProvider)this.instance).getIssuerBytes();
    }
    
    public String getJwksUri() {
      return ((AuthProvider)this.instance).getJwksUri();
    }
    
    public ByteString getJwksUriBytes() {
      return ((AuthProvider)this.instance).getJwksUriBytes();
    }
    
    public Builder setAudiences(String param1String) {
      copyOnWrite();
      ((AuthProvider)this.instance).setAudiences(param1String);
      return this;
    }
    
    public Builder setAudiencesBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthProvider)this.instance).setAudiencesBytes(param1ByteString);
      return this;
    }
    
    public Builder setAuthorizationUrl(String param1String) {
      copyOnWrite();
      ((AuthProvider)this.instance).setAuthorizationUrl(param1String);
      return this;
    }
    
    public Builder setAuthorizationUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthProvider)this.instance).setAuthorizationUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setId(String param1String) {
      copyOnWrite();
      ((AuthProvider)this.instance).setId(param1String);
      return this;
    }
    
    public Builder setIdBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthProvider)this.instance).setIdBytes(param1ByteString);
      return this;
    }
    
    public Builder setIssuer(String param1String) {
      copyOnWrite();
      ((AuthProvider)this.instance).setIssuer(param1String);
      return this;
    }
    
    public Builder setIssuerBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthProvider)this.instance).setIssuerBytes(param1ByteString);
      return this;
    }
    
    public Builder setJwksUri(String param1String) {
      copyOnWrite();
      ((AuthProvider)this.instance).setJwksUri(param1String);
      return this;
    }
    
    public Builder setJwksUriBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthProvider)this.instance).setJwksUriBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\AuthProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */