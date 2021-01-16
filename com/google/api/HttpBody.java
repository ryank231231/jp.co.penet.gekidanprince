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

public final class HttpBody extends GeneratedMessageLite<HttpBody, HttpBody.Builder> implements HttpBodyOrBuilder {
  public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
  
  public static final int DATA_FIELD_NUMBER = 2;
  
  private static final HttpBody DEFAULT_INSTANCE = new HttpBody();
  
  private static volatile Parser<HttpBody> PARSER;
  
  private String contentType_ = "";
  
  private ByteString data_ = ByteString.EMPTY;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearContentType() {
    this.contentType_ = getDefaultInstance().getContentType();
  }
  
  private void clearData() {
    this.data_ = getDefaultInstance().getData();
  }
  
  public static HttpBody getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(HttpBody paramHttpBody) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramHttpBody);
  }
  
  public static HttpBody parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (HttpBody)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpBody parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpBody)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static HttpBody parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static HttpBody parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(InputStream paramInputStream) throws IOException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static HttpBody parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static HttpBody parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static HttpBody parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (HttpBody)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<HttpBody> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setContentType(String paramString) {
    if (paramString != null) {
      this.contentType_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setContentTypeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.contentType_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setData(ByteString paramByteString) {
    if (paramByteString != null) {
      this.data_ = paramByteString;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/HttpBody$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 378, 2 -> 374, 3 -> 372, 4 -> 363, 5 -> 255, 6 -> 118, 7 -> 251, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/api/HttpBody.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/api/HttpBody
    //   80: monitorenter
    //   81: getstatic com/google/api/HttpBody.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/api/HttpBody.DEFAULT_INSTANCE : Lcom/google/api/HttpBody;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/api/HttpBody.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/api/HttpBody
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/api/HttpBody
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/api/HttpBody.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 251
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 195
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 184
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 173
    //   158: aload_1
    //   159: iload #4
    //   161: invokevirtual skipField : (I)Z
    //   164: ifne -> 128
    //   167: iconst_1
    //   168: istore #6
    //   170: goto -> 128
    //   173: aload_0
    //   174: aload_1
    //   175: invokevirtual readBytes : ()Lcom/google/protobuf/ByteString;
    //   178: putfield data_ : Lcom/google/protobuf/ByteString;
    //   181: goto -> 128
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   189: putfield contentType_ : Ljava/lang/String;
    //   192: goto -> 128
    //   195: iconst_1
    //   196: istore #6
    //   198: goto -> 128
    //   201: astore_1
    //   202: goto -> 249
    //   205: astore_3
    //   206: new java/lang/RuntimeException
    //   209: astore_1
    //   210: new com/google/protobuf/InvalidProtocolBufferException
    //   213: astore_2
    //   214: aload_2
    //   215: aload_3
    //   216: invokevirtual getMessage : ()Ljava/lang/String;
    //   219: invokespecial <init> : (Ljava/lang/String;)V
    //   222: aload_1
    //   223: aload_2
    //   224: aload_0
    //   225: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   228: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: new java/lang/RuntimeException
    //   237: astore_2
    //   238: aload_2
    //   239: aload_1
    //   240: aload_0
    //   241: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   244: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   247: aload_2
    //   248: athrow
    //   249: aload_1
    //   250: athrow
    //   251: getstatic com/google/api/HttpBody.DEFAULT_INSTANCE : Lcom/google/api/HttpBody;
    //   254: areturn
    //   255: aload_2
    //   256: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   259: astore_1
    //   260: aload_3
    //   261: checkcast com/google/api/HttpBody
    //   264: astore_2
    //   265: aload_0
    //   266: aload_1
    //   267: aload_0
    //   268: getfield contentType_ : Ljava/lang/String;
    //   271: invokevirtual isEmpty : ()Z
    //   274: iconst_1
    //   275: ixor
    //   276: aload_0
    //   277: getfield contentType_ : Ljava/lang/String;
    //   280: aload_2
    //   281: getfield contentType_ : Ljava/lang/String;
    //   284: invokevirtual isEmpty : ()Z
    //   287: iconst_1
    //   288: ixor
    //   289: aload_2
    //   290: getfield contentType_ : Ljava/lang/String;
    //   293: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   298: putfield contentType_ : Ljava/lang/String;
    //   301: aload_0
    //   302: getfield data_ : Lcom/google/protobuf/ByteString;
    //   305: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   308: if_acmpeq -> 317
    //   311: iconst_1
    //   312: istore #7
    //   314: goto -> 320
    //   317: iconst_0
    //   318: istore #7
    //   320: aload_0
    //   321: getfield data_ : Lcom/google/protobuf/ByteString;
    //   324: astore_3
    //   325: aload_2
    //   326: getfield data_ : Lcom/google/protobuf/ByteString;
    //   329: getstatic com/google/protobuf/ByteString.EMPTY : Lcom/google/protobuf/ByteString;
    //   332: if_acmpeq -> 338
    //   335: iconst_1
    //   336: istore #5
    //   338: aload_0
    //   339: aload_1
    //   340: iload #7
    //   342: aload_3
    //   343: iload #5
    //   345: aload_2
    //   346: getfield data_ : Lcom/google/protobuf/ByteString;
    //   349: invokeinterface visitByteString : (ZLcom/google/protobuf/ByteString;ZLcom/google/protobuf/ByteString;)Lcom/google/protobuf/ByteString;
    //   354: putfield data_ : Lcom/google/protobuf/ByteString;
    //   357: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   360: astore_1
    //   361: aload_0
    //   362: areturn
    //   363: new com/google/api/HttpBody$Builder
    //   366: dup
    //   367: aconst_null
    //   368: invokespecial <init> : (Lcom/google/api/HttpBody$1;)V
    //   371: areturn
    //   372: aconst_null
    //   373: areturn
    //   374: getstatic com/google/api/HttpBody.DEFAULT_INSTANCE : Lcom/google/api/HttpBody;
    //   377: areturn
    //   378: new com/google/api/HttpBody
    //   381: dup
    //   382: invokespecial <init> : ()V
    //   385: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	233	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	205	java/io/IOException
    //   133	139	201	finally
    //   158	167	233	com/google/protobuf/InvalidProtocolBufferException
    //   158	167	205	java/io/IOException
    //   158	167	201	finally
    //   173	181	233	com/google/protobuf/InvalidProtocolBufferException
    //   173	181	205	java/io/IOException
    //   173	181	201	finally
    //   184	192	233	com/google/protobuf/InvalidProtocolBufferException
    //   184	192	205	java/io/IOException
    //   184	192	201	finally
    //   206	233	201	finally
    //   234	249	201	finally
  }
  
  public String getContentType() {
    return this.contentType_;
  }
  
  public ByteString getContentTypeBytes() {
    return ByteString.copyFromUtf8(this.contentType_);
  }
  
  public ByteString getData() {
    return this.data_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    i = 0;
    if (!this.contentType_.isEmpty())
      i = 0 + CodedOutputStream.computeStringSize(1, getContentType()); 
    int j = i;
    if (!this.data_.isEmpty())
      j = i + CodedOutputStream.computeBytesSize(2, this.data_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.contentType_.isEmpty())
      paramCodedOutputStream.writeString(1, getContentType()); 
    if (!this.data_.isEmpty())
      paramCodedOutputStream.writeBytes(2, this.data_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<HttpBody, Builder> implements HttpBodyOrBuilder {
    private Builder() {
      super(HttpBody.DEFAULT_INSTANCE);
    }
    
    public Builder clearContentType() {
      copyOnWrite();
      ((HttpBody)this.instance).clearContentType();
      return this;
    }
    
    public Builder clearData() {
      copyOnWrite();
      ((HttpBody)this.instance).clearData();
      return this;
    }
    
    public String getContentType() {
      return ((HttpBody)this.instance).getContentType();
    }
    
    public ByteString getContentTypeBytes() {
      return ((HttpBody)this.instance).getContentTypeBytes();
    }
    
    public ByteString getData() {
      return ((HttpBody)this.instance).getData();
    }
    
    public Builder setContentType(String param1String) {
      copyOnWrite();
      ((HttpBody)this.instance).setContentType(param1String);
      return this;
    }
    
    public Builder setContentTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpBody)this.instance).setContentTypeBytes(param1ByteString);
      return this;
    }
    
    public Builder setData(ByteString param1ByteString) {
      copyOnWrite();
      ((HttpBody)this.instance).setData(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\HttpBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */