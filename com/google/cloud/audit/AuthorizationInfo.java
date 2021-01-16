package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class AuthorizationInfo extends GeneratedMessageLite<AuthorizationInfo, AuthorizationInfo.Builder> implements AuthorizationInfoOrBuilder {
  private static final AuthorizationInfo DEFAULT_INSTANCE = new AuthorizationInfo();
  
  public static final int GRANTED_FIELD_NUMBER = 3;
  
  private static volatile Parser<AuthorizationInfo> PARSER;
  
  public static final int PERMISSION_FIELD_NUMBER = 2;
  
  public static final int RESOURCE_FIELD_NUMBER = 1;
  
  private boolean granted_;
  
  private String permission_ = "";
  
  private String resource_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearGranted() {
    this.granted_ = false;
  }
  
  private void clearPermission() {
    this.permission_ = getDefaultInstance().getPermission();
  }
  
  private void clearResource() {
    this.resource_ = getDefaultInstance().getResource();
  }
  
  public static AuthorizationInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(AuthorizationInfo paramAuthorizationInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramAuthorizationInfo);
  }
  
  public static AuthorizationInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (AuthorizationInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthorizationInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static AuthorizationInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static AuthorizationInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static AuthorizationInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static AuthorizationInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static AuthorizationInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (AuthorizationInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<AuthorizationInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setGranted(boolean paramBoolean) {
    this.granted_ = paramBoolean;
  }
  
  private void setPermission(String paramString) {
    if (paramString != null) {
      this.permission_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setPermissionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.permission_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResource(String paramString) {
    if (paramString != null) {
      this.resource_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resource_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/cloud/audit/AuthorizationInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 401, 2 -> 397, 3 -> 395, 4 -> 386, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/cloud/audit/AuthorizationInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/cloud/audit/AuthorizationInfo
    //   72: monitorenter
    //   73: getstatic com/google/cloud/audit/AuthorizationInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/cloud/audit/AuthorizationInfo.DEFAULT_INSTANCE : Lcom/google/cloud/audit/AuthorizationInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/cloud/audit/AuthorizationInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/cloud/audit/AuthorizationInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/cloud/audit/AuthorizationInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/cloud/audit/AuthorizationInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 264
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 208
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 197
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 186
    //   153: iload #5
    //   155: bipush #24
    //   157: if_icmpeq -> 175
    //   160: aload_1
    //   161: iload #5
    //   163: invokevirtual skipField : (I)Z
    //   166: ifne -> 123
    //   169: iconst_1
    //   170: istore #4
    //   172: goto -> 123
    //   175: aload_0
    //   176: aload_1
    //   177: invokevirtual readBool : ()Z
    //   180: putfield granted_ : Z
    //   183: goto -> 123
    //   186: aload_0
    //   187: aload_1
    //   188: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   191: putfield permission_ : Ljava/lang/String;
    //   194: goto -> 123
    //   197: aload_0
    //   198: aload_1
    //   199: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   202: putfield resource_ : Ljava/lang/String;
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_1
    //   219: new java/lang/RuntimeException
    //   222: astore_2
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_3
    //   227: aload_3
    //   228: aload_1
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_2
    //   236: aload_3
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_2
    //   245: athrow
    //   246: astore_2
    //   247: new java/lang/RuntimeException
    //   250: astore_1
    //   251: aload_1
    //   252: aload_2
    //   253: aload_0
    //   254: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   257: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   260: aload_1
    //   261: athrow
    //   262: aload_1
    //   263: athrow
    //   264: getstatic com/google/cloud/audit/AuthorizationInfo.DEFAULT_INSTANCE : Lcom/google/cloud/audit/AuthorizationInfo;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/cloud/audit/AuthorizationInfo
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield resource_ : Ljava/lang/String;
    //   284: invokevirtual isEmpty : ()Z
    //   287: iconst_1
    //   288: ixor
    //   289: aload_0
    //   290: getfield resource_ : Ljava/lang/String;
    //   293: aload_2
    //   294: getfield resource_ : Ljava/lang/String;
    //   297: invokevirtual isEmpty : ()Z
    //   300: iconst_1
    //   301: ixor
    //   302: aload_2
    //   303: getfield resource_ : Ljava/lang/String;
    //   306: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   311: putfield resource_ : Ljava/lang/String;
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield permission_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield permission_ : Ljava/lang/String;
    //   329: iconst_1
    //   330: aload_2
    //   331: getfield permission_ : Ljava/lang/String;
    //   334: invokevirtual isEmpty : ()Z
    //   337: ixor
    //   338: aload_2
    //   339: getfield permission_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield permission_ : Ljava/lang/String;
    //   350: aload_0
    //   351: getfield granted_ : Z
    //   354: istore #6
    //   356: aload_2
    //   357: getfield granted_ : Z
    //   360: istore #7
    //   362: aload_0
    //   363: aload_1
    //   364: iload #6
    //   366: iload #6
    //   368: iload #7
    //   370: iload #7
    //   372: invokeinterface visitBoolean : (ZZZZ)Z
    //   377: putfield granted_ : Z
    //   380: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   383: astore_1
    //   384: aload_0
    //   385: areturn
    //   386: new com/google/cloud/audit/AuthorizationInfo$Builder
    //   389: dup
    //   390: aconst_null
    //   391: invokespecial <init> : (Lcom/google/cloud/audit/AuthorizationInfo$1;)V
    //   394: areturn
    //   395: aconst_null
    //   396: areturn
    //   397: getstatic com/google/cloud/audit/AuthorizationInfo.DEFAULT_INSTANCE : Lcom/google/cloud/audit/AuthorizationInfo;
    //   400: areturn
    //   401: new com/google/cloud/audit/AuthorizationInfo
    //   404: dup
    //   405: invokespecial <init> : ()V
    //   408: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	246	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	218	java/io/IOException
    //   128	134	214	finally
    //   160	169	246	com/google/protobuf/InvalidProtocolBufferException
    //   160	169	218	java/io/IOException
    //   160	169	214	finally
    //   175	183	246	com/google/protobuf/InvalidProtocolBufferException
    //   175	183	218	java/io/IOException
    //   175	183	214	finally
    //   186	194	246	com/google/protobuf/InvalidProtocolBufferException
    //   186	194	218	java/io/IOException
    //   186	194	214	finally
    //   197	205	246	com/google/protobuf/InvalidProtocolBufferException
    //   197	205	218	java/io/IOException
    //   197	205	214	finally
    //   219	246	214	finally
    //   247	262	214	finally
  }
  
  public boolean getGranted() {
    return this.granted_;
  }
  
  public String getPermission() {
    return this.permission_;
  }
  
  public ByteString getPermissionBytes() {
    return ByteString.copyFromUtf8(this.permission_);
  }
  
  public String getResource() {
    return this.resource_;
  }
  
  public ByteString getResourceBytes() {
    return ByteString.copyFromUtf8(this.resource_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.resource_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getResource()); 
    i = j;
    if (!this.permission_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getPermission()); 
    boolean bool = this.granted_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.resource_.isEmpty())
      paramCodedOutputStream.writeString(1, getResource()); 
    if (!this.permission_.isEmpty())
      paramCodedOutputStream.writeString(2, getPermission()); 
    boolean bool = this.granted_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
    private Builder() {
      super(AuthorizationInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearGranted() {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).clearGranted();
      return this;
    }
    
    public Builder clearPermission() {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).clearPermission();
      return this;
    }
    
    public Builder clearResource() {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).clearResource();
      return this;
    }
    
    public boolean getGranted() {
      return ((AuthorizationInfo)this.instance).getGranted();
    }
    
    public String getPermission() {
      return ((AuthorizationInfo)this.instance).getPermission();
    }
    
    public ByteString getPermissionBytes() {
      return ((AuthorizationInfo)this.instance).getPermissionBytes();
    }
    
    public String getResource() {
      return ((AuthorizationInfo)this.instance).getResource();
    }
    
    public ByteString getResourceBytes() {
      return ((AuthorizationInfo)this.instance).getResourceBytes();
    }
    
    public Builder setGranted(boolean param1Boolean) {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).setGranted(param1Boolean);
      return this;
    }
    
    public Builder setPermission(String param1String) {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).setPermission(param1String);
      return this;
    }
    
    public Builder setPermissionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).setPermissionBytes(param1ByteString);
      return this;
    }
    
    public Builder setResource(String param1String) {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).setResource(param1String);
      return this;
    }
    
    public Builder setResourceBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((AuthorizationInfo)this.instance).setResourceBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\cloud\audit\AuthorizationInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */