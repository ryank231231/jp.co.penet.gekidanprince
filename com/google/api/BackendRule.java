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

public final class BackendRule extends GeneratedMessageLite<BackendRule, BackendRule.Builder> implements BackendRuleOrBuilder {
  public static final int ADDRESS_FIELD_NUMBER = 2;
  
  public static final int DEADLINE_FIELD_NUMBER = 3;
  
  private static final BackendRule DEFAULT_INSTANCE = new BackendRule();
  
  private static volatile Parser<BackendRule> PARSER;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private String address_ = "";
  
  private double deadline_;
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAddress() {
    this.address_ = getDefaultInstance().getAddress();
  }
  
  private void clearDeadline() {
    this.deadline_ = 0.0D;
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  public static BackendRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(BackendRule paramBackendRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramBackendRule);
  }
  
  public static BackendRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (BackendRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BackendRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BackendRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static BackendRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static BackendRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(InputStream paramInputStream) throws IOException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static BackendRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static BackendRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static BackendRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (BackendRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<BackendRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAddress(String paramString) {
    if (paramString != null) {
      this.address_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setAddressBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.address_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDeadline(double paramDouble) {
    this.deadline_ = paramDouble;
  }
  
  private void setSelector(String paramString) {
    if (paramString != null) {
      this.selector_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSelectorBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.selector_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/BackendRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 434, 2 -> 430, 3 -> 428, 4 -> 419, 5 -> 269, 6 -> 114, 7 -> 265, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/api/BackendRule.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/api/BackendRule
    //   76: monitorenter
    //   77: getstatic com/google/api/BackendRule.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/api/BackendRule.DEFAULT_INSTANCE : Lcom/google/api/BackendRule;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/api/BackendRule.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/api/BackendRule
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/api/BackendRule
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/api/BackendRule.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 265
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: ifeq -> 209
    //   140: iload #4
    //   142: bipush #10
    //   144: if_icmpeq -> 198
    //   147: iload #4
    //   149: bipush #18
    //   151: if_icmpeq -> 187
    //   154: iload #4
    //   156: bipush #25
    //   158: if_icmpeq -> 176
    //   161: aload_1
    //   162: iload #4
    //   164: invokevirtual skipField : (I)Z
    //   167: ifne -> 124
    //   170: iconst_1
    //   171: istore #5
    //   173: goto -> 124
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual readDouble : ()D
    //   181: putfield deadline_ : D
    //   184: goto -> 124
    //   187: aload_0
    //   188: aload_1
    //   189: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   192: putfield address_ : Ljava/lang/String;
    //   195: goto -> 124
    //   198: aload_0
    //   199: aload_1
    //   200: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   203: putfield selector_ : Ljava/lang/String;
    //   206: goto -> 124
    //   209: iconst_1
    //   210: istore #5
    //   212: goto -> 124
    //   215: astore_1
    //   216: goto -> 263
    //   219: astore_2
    //   220: new java/lang/RuntimeException
    //   223: astore_1
    //   224: new com/google/protobuf/InvalidProtocolBufferException
    //   227: astore_3
    //   228: aload_3
    //   229: aload_2
    //   230: invokevirtual getMessage : ()Ljava/lang/String;
    //   233: invokespecial <init> : (Ljava/lang/String;)V
    //   236: aload_1
    //   237: aload_3
    //   238: aload_0
    //   239: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   242: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   245: aload_1
    //   246: athrow
    //   247: astore_1
    //   248: new java/lang/RuntimeException
    //   251: astore_2
    //   252: aload_2
    //   253: aload_1
    //   254: aload_0
    //   255: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   258: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   261: aload_2
    //   262: athrow
    //   263: aload_1
    //   264: athrow
    //   265: getstatic com/google/api/BackendRule.DEFAULT_INSTANCE : Lcom/google/api/BackendRule;
    //   268: areturn
    //   269: aload_2
    //   270: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   273: astore_1
    //   274: aload_3
    //   275: checkcast com/google/api/BackendRule
    //   278: astore_2
    //   279: aload_0
    //   280: aload_1
    //   281: aload_0
    //   282: getfield selector_ : Ljava/lang/String;
    //   285: invokevirtual isEmpty : ()Z
    //   288: iconst_1
    //   289: ixor
    //   290: aload_0
    //   291: getfield selector_ : Ljava/lang/String;
    //   294: aload_2
    //   295: getfield selector_ : Ljava/lang/String;
    //   298: invokevirtual isEmpty : ()Z
    //   301: iconst_1
    //   302: ixor
    //   303: aload_2
    //   304: getfield selector_ : Ljava/lang/String;
    //   307: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   312: putfield selector_ : Ljava/lang/String;
    //   315: aload_0
    //   316: aload_1
    //   317: aload_0
    //   318: getfield address_ : Ljava/lang/String;
    //   321: invokevirtual isEmpty : ()Z
    //   324: iconst_1
    //   325: ixor
    //   326: aload_0
    //   327: getfield address_ : Ljava/lang/String;
    //   330: aload_2
    //   331: getfield address_ : Ljava/lang/String;
    //   334: invokevirtual isEmpty : ()Z
    //   337: iconst_1
    //   338: ixor
    //   339: aload_2
    //   340: getfield address_ : Ljava/lang/String;
    //   343: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   348: putfield address_ : Ljava/lang/String;
    //   351: aload_0
    //   352: getfield deadline_ : D
    //   355: dconst_0
    //   356: dcmpl
    //   357: ifeq -> 366
    //   360: iconst_1
    //   361: istore #6
    //   363: goto -> 369
    //   366: iconst_0
    //   367: istore #6
    //   369: aload_0
    //   370: getfield deadline_ : D
    //   373: dstore #7
    //   375: aload_2
    //   376: getfield deadline_ : D
    //   379: dconst_0
    //   380: dcmpl
    //   381: ifeq -> 390
    //   384: iconst_1
    //   385: istore #9
    //   387: goto -> 393
    //   390: iconst_0
    //   391: istore #9
    //   393: aload_0
    //   394: aload_1
    //   395: iload #6
    //   397: dload #7
    //   399: iload #9
    //   401: aload_2
    //   402: getfield deadline_ : D
    //   405: invokeinterface visitDouble : (ZDZD)D
    //   410: putfield deadline_ : D
    //   413: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   416: astore_1
    //   417: aload_0
    //   418: areturn
    //   419: new com/google/api/BackendRule$Builder
    //   422: dup
    //   423: aconst_null
    //   424: invokespecial <init> : (Lcom/google/api/BackendRule$1;)V
    //   427: areturn
    //   428: aconst_null
    //   429: areturn
    //   430: getstatic com/google/api/BackendRule.DEFAULT_INSTANCE : Lcom/google/api/BackendRule;
    //   433: areturn
    //   434: new com/google/api/BackendRule
    //   437: dup
    //   438: invokespecial <init> : ()V
    //   441: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	247	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	219	java/io/IOException
    //   129	135	215	finally
    //   161	170	247	com/google/protobuf/InvalidProtocolBufferException
    //   161	170	219	java/io/IOException
    //   161	170	215	finally
    //   176	184	247	com/google/protobuf/InvalidProtocolBufferException
    //   176	184	219	java/io/IOException
    //   176	184	215	finally
    //   187	195	247	com/google/protobuf/InvalidProtocolBufferException
    //   187	195	219	java/io/IOException
    //   187	195	215	finally
    //   198	206	247	com/google/protobuf/InvalidProtocolBufferException
    //   198	206	219	java/io/IOException
    //   198	206	215	finally
    //   220	247	215	finally
    //   248	263	215	finally
  }
  
  public String getAddress() {
    return this.address_;
  }
  
  public ByteString getAddressBytes() {
    return ByteString.copyFromUtf8(this.address_);
  }
  
  public double getDeadline() {
    return this.deadline_;
  }
  
  public String getSelector() {
    return this.selector_;
  }
  
  public ByteString getSelectorBytes() {
    return ByteString.copyFromUtf8(this.selector_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.selector_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(1, getSelector()); 
    i = j;
    if (!this.address_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getAddress()); 
    double d = this.deadline_;
    j = i;
    if (d != 0.0D)
      j = i + CodedOutputStream.computeDoubleSize(3, d); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    if (!this.address_.isEmpty())
      paramCodedOutputStream.writeString(2, getAddress()); 
    double d = this.deadline_;
    if (d != 0.0D)
      paramCodedOutputStream.writeDouble(3, d); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
    private Builder() {
      super(BackendRule.DEFAULT_INSTANCE);
    }
    
    public Builder clearAddress() {
      copyOnWrite();
      ((BackendRule)this.instance).clearAddress();
      return this;
    }
    
    public Builder clearDeadline() {
      copyOnWrite();
      ((BackendRule)this.instance).clearDeadline();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((BackendRule)this.instance).clearSelector();
      return this;
    }
    
    public String getAddress() {
      return ((BackendRule)this.instance).getAddress();
    }
    
    public ByteString getAddressBytes() {
      return ((BackendRule)this.instance).getAddressBytes();
    }
    
    public double getDeadline() {
      return ((BackendRule)this.instance).getDeadline();
    }
    
    public String getSelector() {
      return ((BackendRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((BackendRule)this.instance).getSelectorBytes();
    }
    
    public Builder setAddress(String param1String) {
      copyOnWrite();
      ((BackendRule)this.instance).setAddress(param1String);
      return this;
    }
    
    public Builder setAddressBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BackendRule)this.instance).setAddressBytes(param1ByteString);
      return this;
    }
    
    public Builder setDeadline(double param1Double) {
      copyOnWrite();
      ((BackendRule)this.instance).setDeadline(param1Double);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((BackendRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((BackendRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\BackendRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */