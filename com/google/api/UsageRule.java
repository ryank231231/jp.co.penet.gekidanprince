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

public final class UsageRule extends GeneratedMessageLite<UsageRule, UsageRule.Builder> implements UsageRuleOrBuilder {
  public static final int ALLOW_UNREGISTERED_CALLS_FIELD_NUMBER = 2;
  
  private static final UsageRule DEFAULT_INSTANCE = new UsageRule();
  
  private static volatile Parser<UsageRule> PARSER;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  public static final int SKIP_SERVICE_CONTROL_FIELD_NUMBER = 3;
  
  private boolean allowUnregisteredCalls_;
  
  private String selector_ = "";
  
  private boolean skipServiceControl_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearAllowUnregisteredCalls() {
    this.allowUnregisteredCalls_ = false;
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  private void clearSkipServiceControl() {
    this.skipServiceControl_ = false;
  }
  
  public static UsageRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(UsageRule paramUsageRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramUsageRule);
  }
  
  public static UsageRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (UsageRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UsageRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UsageRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static UsageRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static UsageRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(InputStream paramInputStream) throws IOException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static UsageRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static UsageRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static UsageRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (UsageRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<UsageRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setAllowUnregisteredCalls(boolean paramBoolean) {
    this.allowUnregisteredCalls_ = paramBoolean;
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
  
  private void setSkipServiceControl(boolean paramBoolean) {
    this.skipServiceControl_ = paramBoolean;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/UsageRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 395, 2 -> 391, 3 -> 389, 4 -> 380, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/UsageRule.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/UsageRule
    //   72: monitorenter
    //   73: getstatic com/google/api/UsageRule.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/UsageRule.DEFAULT_INSTANCE : Lcom/google/api/UsageRule;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/UsageRule.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/UsageRule
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/UsageRule
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/UsageRule.PARSER : Lcom/google/protobuf/Parser;
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
    //   148: bipush #16
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
    //   180: putfield skipServiceControl_ : Z
    //   183: goto -> 123
    //   186: aload_0
    //   187: aload_1
    //   188: invokevirtual readBool : ()Z
    //   191: putfield allowUnregisteredCalls_ : Z
    //   194: goto -> 123
    //   197: aload_0
    //   198: aload_1
    //   199: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   202: putfield selector_ : Ljava/lang/String;
    //   205: goto -> 123
    //   208: iconst_1
    //   209: istore #4
    //   211: goto -> 123
    //   214: astore_1
    //   215: goto -> 262
    //   218: astore_3
    //   219: new java/lang/RuntimeException
    //   222: astore_1
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_2
    //   227: aload_2
    //   228: aload_3
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_1
    //   236: aload_2
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_1
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
    //   264: getstatic com/google/api/UsageRule.DEFAULT_INSTANCE : Lcom/google/api/UsageRule;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/api/UsageRule
    //   277: astore_2
    //   278: aload_0
    //   279: aload_1
    //   280: aload_0
    //   281: getfield selector_ : Ljava/lang/String;
    //   284: invokevirtual isEmpty : ()Z
    //   287: iconst_1
    //   288: ixor
    //   289: aload_0
    //   290: getfield selector_ : Ljava/lang/String;
    //   293: iconst_1
    //   294: aload_2
    //   295: getfield selector_ : Ljava/lang/String;
    //   298: invokevirtual isEmpty : ()Z
    //   301: ixor
    //   302: aload_2
    //   303: getfield selector_ : Ljava/lang/String;
    //   306: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   311: putfield selector_ : Ljava/lang/String;
    //   314: aload_0
    //   315: getfield allowUnregisteredCalls_ : Z
    //   318: istore #6
    //   320: aload_2
    //   321: getfield allowUnregisteredCalls_ : Z
    //   324: istore #7
    //   326: aload_0
    //   327: aload_1
    //   328: iload #6
    //   330: iload #6
    //   332: iload #7
    //   334: iload #7
    //   336: invokeinterface visitBoolean : (ZZZZ)Z
    //   341: putfield allowUnregisteredCalls_ : Z
    //   344: aload_0
    //   345: getfield skipServiceControl_ : Z
    //   348: istore #6
    //   350: aload_2
    //   351: getfield skipServiceControl_ : Z
    //   354: istore #7
    //   356: aload_0
    //   357: aload_1
    //   358: iload #6
    //   360: iload #6
    //   362: iload #7
    //   364: iload #7
    //   366: invokeinterface visitBoolean : (ZZZZ)Z
    //   371: putfield skipServiceControl_ : Z
    //   374: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   377: astore_1
    //   378: aload_0
    //   379: areturn
    //   380: new com/google/api/UsageRule$Builder
    //   383: dup
    //   384: aconst_null
    //   385: invokespecial <init> : (Lcom/google/api/UsageRule$1;)V
    //   388: areturn
    //   389: aconst_null
    //   390: areturn
    //   391: getstatic com/google/api/UsageRule.DEFAULT_INSTANCE : Lcom/google/api/UsageRule;
    //   394: areturn
    //   395: new com/google/api/UsageRule
    //   398: dup
    //   399: invokespecial <init> : ()V
    //   402: areturn
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
  
  public boolean getAllowUnregisteredCalls() {
    return this.allowUnregisteredCalls_;
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
    boolean bool = this.allowUnregisteredCalls_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(2, bool); 
    bool = this.skipServiceControl_;
    j = i;
    if (bool)
      j = i + CodedOutputStream.computeBoolSize(3, bool); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public boolean getSkipServiceControl() {
    return this.skipServiceControl_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    boolean bool = this.allowUnregisteredCalls_;
    if (bool)
      paramCodedOutputStream.writeBool(2, bool); 
    bool = this.skipServiceControl_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<UsageRule, Builder> implements UsageRuleOrBuilder {
    private Builder() {
      super(UsageRule.DEFAULT_INSTANCE);
    }
    
    public Builder clearAllowUnregisteredCalls() {
      copyOnWrite();
      ((UsageRule)this.instance).clearAllowUnregisteredCalls();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((UsageRule)this.instance).clearSelector();
      return this;
    }
    
    public Builder clearSkipServiceControl() {
      copyOnWrite();
      ((UsageRule)this.instance).clearSkipServiceControl();
      return this;
    }
    
    public boolean getAllowUnregisteredCalls() {
      return ((UsageRule)this.instance).getAllowUnregisteredCalls();
    }
    
    public String getSelector() {
      return ((UsageRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((UsageRule)this.instance).getSelectorBytes();
    }
    
    public boolean getSkipServiceControl() {
      return ((UsageRule)this.instance).getSkipServiceControl();
    }
    
    public Builder setAllowUnregisteredCalls(boolean param1Boolean) {
      copyOnWrite();
      ((UsageRule)this.instance).setAllowUnregisteredCalls(param1Boolean);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((UsageRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((UsageRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
    
    public Builder setSkipServiceControl(boolean param1Boolean) {
      copyOnWrite();
      ((UsageRule)this.instance).setSkipServiceControl(param1Boolean);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\UsageRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */