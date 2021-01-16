package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;

public final class ResourceInfo extends GeneratedMessageLite<ResourceInfo, ResourceInfo.Builder> implements ResourceInfoOrBuilder {
  private static final ResourceInfo DEFAULT_INSTANCE = new ResourceInfo();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 4;
  
  public static final int OWNER_FIELD_NUMBER = 3;
  
  private static volatile Parser<ResourceInfo> PARSER;
  
  public static final int RESOURCE_NAME_FIELD_NUMBER = 2;
  
  public static final int RESOURCE_TYPE_FIELD_NUMBER = 1;
  
  private String description_ = "";
  
  private String owner_ = "";
  
  private String resourceName_ = "";
  
  private String resourceType_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearOwner() {
    this.owner_ = getDefaultInstance().getOwner();
  }
  
  private void clearResourceName() {
    this.resourceName_ = getDefaultInstance().getResourceName();
  }
  
  private void clearResourceType() {
    this.resourceType_ = getDefaultInstance().getResourceType();
  }
  
  public static ResourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(ResourceInfo paramResourceInfo) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramResourceInfo);
  }
  
  public static ResourceInfo parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (ResourceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ResourceInfo parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static ResourceInfo parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static ResourceInfo parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(InputStream paramInputStream) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static ResourceInfo parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static ResourceInfo parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static ResourceInfo parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (ResourceInfo)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<ResourceInfo> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDescription(String paramString) {
    if (paramString != null) {
      this.description_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDescriptionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.description_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOwner(String paramString) {
    if (paramString != null) {
      this.owner_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOwnerBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.owner_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceName(String paramString) {
    if (paramString != null) {
      this.resourceName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resourceName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceType(String paramString) {
    if (paramString != null) {
      this.resourceType_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResourceTypeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.resourceType_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/rpc/ResourceInfo$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 461, 2 -> 457, 3 -> 455, 4 -> 446, 5 -> 286, 6 -> 110, 7 -> 282, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/rpc/ResourceInfo
    //   72: monitorenter
    //   73: getstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/rpc/ResourceInfo.DEFAULT_INSTANCE : Lcom/google/rpc/ResourceInfo;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/rpc/ResourceInfo
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/rpc/ResourceInfo
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/rpc/ResourceInfo.PARSER : Lcom/google/protobuf/Parser;
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
    //   125: ifne -> 282
    //   128: aload_1
    //   129: invokevirtual readTag : ()I
    //   132: istore #5
    //   134: iload #5
    //   136: ifeq -> 226
    //   139: iload #5
    //   141: bipush #10
    //   143: if_icmpeq -> 215
    //   146: iload #5
    //   148: bipush #18
    //   150: if_icmpeq -> 204
    //   153: iload #5
    //   155: bipush #26
    //   157: if_icmpeq -> 193
    //   160: iload #5
    //   162: bipush #34
    //   164: if_icmpeq -> 182
    //   167: aload_1
    //   168: iload #5
    //   170: invokevirtual skipField : (I)Z
    //   173: ifne -> 123
    //   176: iconst_1
    //   177: istore #4
    //   179: goto -> 123
    //   182: aload_0
    //   183: aload_1
    //   184: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   187: putfield description_ : Ljava/lang/String;
    //   190: goto -> 123
    //   193: aload_0
    //   194: aload_1
    //   195: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   198: putfield owner_ : Ljava/lang/String;
    //   201: goto -> 123
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   209: putfield resourceName_ : Ljava/lang/String;
    //   212: goto -> 123
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   220: putfield resourceType_ : Ljava/lang/String;
    //   223: goto -> 123
    //   226: iconst_1
    //   227: istore #4
    //   229: goto -> 123
    //   232: astore_1
    //   233: goto -> 280
    //   236: astore_2
    //   237: new java/lang/RuntimeException
    //   240: astore_1
    //   241: new com/google/protobuf/InvalidProtocolBufferException
    //   244: astore_3
    //   245: aload_3
    //   246: aload_2
    //   247: invokevirtual getMessage : ()Ljava/lang/String;
    //   250: invokespecial <init> : (Ljava/lang/String;)V
    //   253: aload_1
    //   254: aload_3
    //   255: aload_0
    //   256: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   259: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   262: aload_1
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
    //   282: getstatic com/google/rpc/ResourceInfo.DEFAULT_INSTANCE : Lcom/google/rpc/ResourceInfo;
    //   285: areturn
    //   286: aload_2
    //   287: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   290: astore_1
    //   291: aload_3
    //   292: checkcast com/google/rpc/ResourceInfo
    //   295: astore_2
    //   296: aload_0
    //   297: aload_1
    //   298: aload_0
    //   299: getfield resourceType_ : Ljava/lang/String;
    //   302: invokevirtual isEmpty : ()Z
    //   305: iconst_1
    //   306: ixor
    //   307: aload_0
    //   308: getfield resourceType_ : Ljava/lang/String;
    //   311: aload_2
    //   312: getfield resourceType_ : Ljava/lang/String;
    //   315: invokevirtual isEmpty : ()Z
    //   318: iconst_1
    //   319: ixor
    //   320: aload_2
    //   321: getfield resourceType_ : Ljava/lang/String;
    //   324: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   329: putfield resourceType_ : Ljava/lang/String;
    //   332: aload_0
    //   333: aload_1
    //   334: aload_0
    //   335: getfield resourceName_ : Ljava/lang/String;
    //   338: invokevirtual isEmpty : ()Z
    //   341: iconst_1
    //   342: ixor
    //   343: aload_0
    //   344: getfield resourceName_ : Ljava/lang/String;
    //   347: aload_2
    //   348: getfield resourceName_ : Ljava/lang/String;
    //   351: invokevirtual isEmpty : ()Z
    //   354: iconst_1
    //   355: ixor
    //   356: aload_2
    //   357: getfield resourceName_ : Ljava/lang/String;
    //   360: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   365: putfield resourceName_ : Ljava/lang/String;
    //   368: aload_0
    //   369: aload_1
    //   370: aload_0
    //   371: getfield owner_ : Ljava/lang/String;
    //   374: invokevirtual isEmpty : ()Z
    //   377: iconst_1
    //   378: ixor
    //   379: aload_0
    //   380: getfield owner_ : Ljava/lang/String;
    //   383: aload_2
    //   384: getfield owner_ : Ljava/lang/String;
    //   387: invokevirtual isEmpty : ()Z
    //   390: iconst_1
    //   391: ixor
    //   392: aload_2
    //   393: getfield owner_ : Ljava/lang/String;
    //   396: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   401: putfield owner_ : Ljava/lang/String;
    //   404: aload_0
    //   405: aload_1
    //   406: aload_0
    //   407: getfield description_ : Ljava/lang/String;
    //   410: invokevirtual isEmpty : ()Z
    //   413: iconst_1
    //   414: ixor
    //   415: aload_0
    //   416: getfield description_ : Ljava/lang/String;
    //   419: iconst_1
    //   420: aload_2
    //   421: getfield description_ : Ljava/lang/String;
    //   424: invokevirtual isEmpty : ()Z
    //   427: ixor
    //   428: aload_2
    //   429: getfield description_ : Ljava/lang/String;
    //   432: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   437: putfield description_ : Ljava/lang/String;
    //   440: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   443: astore_1
    //   444: aload_0
    //   445: areturn
    //   446: new com/google/rpc/ResourceInfo$Builder
    //   449: dup
    //   450: aconst_null
    //   451: invokespecial <init> : (Lcom/google/rpc/ResourceInfo$1;)V
    //   454: areturn
    //   455: aconst_null
    //   456: areturn
    //   457: getstatic com/google/rpc/ResourceInfo.DEFAULT_INSTANCE : Lcom/google/rpc/ResourceInfo;
    //   460: areturn
    //   461: new com/google/rpc/ResourceInfo
    //   464: dup
    //   465: invokespecial <init> : ()V
    //   468: areturn
    // Exception table:
    //   from	to	target	type
    //   73	94	100	finally
    //   94	97	100	finally
    //   101	104	100	finally
    //   128	134	264	com/google/protobuf/InvalidProtocolBufferException
    //   128	134	236	java/io/IOException
    //   128	134	232	finally
    //   167	176	264	com/google/protobuf/InvalidProtocolBufferException
    //   167	176	236	java/io/IOException
    //   167	176	232	finally
    //   182	190	264	com/google/protobuf/InvalidProtocolBufferException
    //   182	190	236	java/io/IOException
    //   182	190	232	finally
    //   193	201	264	com/google/protobuf/InvalidProtocolBufferException
    //   193	201	236	java/io/IOException
    //   193	201	232	finally
    //   204	212	264	com/google/protobuf/InvalidProtocolBufferException
    //   204	212	236	java/io/IOException
    //   204	212	232	finally
    //   215	223	264	com/google/protobuf/InvalidProtocolBufferException
    //   215	223	236	java/io/IOException
    //   215	223	232	finally
    //   237	264	232	finally
    //   265	280	232	finally
  }
  
  public String getDescription() {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes() {
    return ByteString.copyFromUtf8(this.description_);
  }
  
  public String getOwner() {
    return this.owner_;
  }
  
  public ByteString getOwnerBytes() {
    return ByteString.copyFromUtf8(this.owner_);
  }
  
  public String getResourceName() {
    return this.resourceName_;
  }
  
  public ByteString getResourceNameBytes() {
    return ByteString.copyFromUtf8(this.resourceName_);
  }
  
  public String getResourceType() {
    return this.resourceType_;
  }
  
  public ByteString getResourceTypeBytes() {
    return ByteString.copyFromUtf8(this.resourceType_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.resourceType_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getResourceType()); 
    int j = i;
    if (!this.resourceName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getResourceName()); 
    i = j;
    if (!this.owner_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(3, getOwner()); 
    j = i;
    if (!this.description_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getDescription()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.resourceType_.isEmpty())
      paramCodedOutputStream.writeString(1, getResourceType()); 
    if (!this.resourceName_.isEmpty())
      paramCodedOutputStream.writeString(2, getResourceName()); 
    if (!this.owner_.isEmpty())
      paramCodedOutputStream.writeString(3, getOwner()); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(4, getDescription()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<ResourceInfo, Builder> implements ResourceInfoOrBuilder {
    private Builder() {
      super(ResourceInfo.DEFAULT_INSTANCE);
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearOwner() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearOwner();
      return this;
    }
    
    public Builder clearResourceName() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearResourceName();
      return this;
    }
    
    public Builder clearResourceType() {
      copyOnWrite();
      ((ResourceInfo)this.instance).clearResourceType();
      return this;
    }
    
    public String getDescription() {
      return ((ResourceInfo)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((ResourceInfo)this.instance).getDescriptionBytes();
    }
    
    public String getOwner() {
      return ((ResourceInfo)this.instance).getOwner();
    }
    
    public ByteString getOwnerBytes() {
      return ((ResourceInfo)this.instance).getOwnerBytes();
    }
    
    public String getResourceName() {
      return ((ResourceInfo)this.instance).getResourceName();
    }
    
    public ByteString getResourceNameBytes() {
      return ((ResourceInfo)this.instance).getResourceNameBytes();
    }
    
    public String getResourceType() {
      return ((ResourceInfo)this.instance).getResourceType();
    }
    
    public ByteString getResourceTypeBytes() {
      return ((ResourceInfo)this.instance).getResourceTypeBytes();
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setOwner(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setOwner(param1String);
      return this;
    }
    
    public Builder setOwnerBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setOwnerBytes(param1ByteString);
      return this;
    }
    
    public Builder setResourceName(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceName(param1String);
      return this;
    }
    
    public Builder setResourceNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setResourceType(String param1String) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceType(param1String);
      return this;
    }
    
    public Builder setResourceTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((ResourceInfo)this.instance).setResourceTypeBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\rpc\ResourceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */