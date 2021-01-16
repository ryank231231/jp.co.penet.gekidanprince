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

public final class DocumentationRule extends GeneratedMessageLite<DocumentationRule, DocumentationRule.Builder> implements DocumentationRuleOrBuilder {
  private static final DocumentationRule DEFAULT_INSTANCE = new DocumentationRule();
  
  public static final int DEPRECATION_DESCRIPTION_FIELD_NUMBER = 3;
  
  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  
  private static volatile Parser<DocumentationRule> PARSER;
  
  public static final int SELECTOR_FIELD_NUMBER = 1;
  
  private String deprecationDescription_ = "";
  
  private String description_ = "";
  
  private String selector_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDeprecationDescription() {
    this.deprecationDescription_ = getDefaultInstance().getDeprecationDescription();
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearSelector() {
    this.selector_ = getDefaultInstance().getSelector();
  }
  
  public static DocumentationRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(DocumentationRule paramDocumentationRule) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramDocumentationRule);
  }
  
  public static DocumentationRule parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (DocumentationRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentationRule parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentationRule)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static DocumentationRule parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static DocumentationRule parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(InputStream paramInputStream) throws IOException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static DocumentationRule parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static DocumentationRule parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static DocumentationRule parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (DocumentationRule)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<DocumentationRule> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDeprecationDescription(String paramString) {
    if (paramString != null) {
      this.deprecationDescription_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDeprecationDescriptionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.deprecationDescription_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
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
    //   0: getstatic com/google/api/DocumentationRule$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 56, 1 -> 407, 2 -> 403, 3 -> 401, 4 -> 392, 5 -> 268, 6 -> 110, 7 -> 264, 8 -> 64
    //   56: new java/lang/UnsupportedOperationException
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: athrow
    //   64: getstatic com/google/api/DocumentationRule.PARSER : Lcom/google/protobuf/Parser;
    //   67: ifnonnull -> 106
    //   70: ldc com/google/api/DocumentationRule
    //   72: monitorenter
    //   73: getstatic com/google/api/DocumentationRule.PARSER : Lcom/google/protobuf/Parser;
    //   76: ifnonnull -> 94
    //   79: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   82: astore_1
    //   83: aload_1
    //   84: getstatic com/google/api/DocumentationRule.DEFAULT_INSTANCE : Lcom/google/api/DocumentationRule;
    //   87: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   90: aload_1
    //   91: putstatic com/google/api/DocumentationRule.PARSER : Lcom/google/protobuf/Parser;
    //   94: ldc com/google/api/DocumentationRule
    //   96: monitorexit
    //   97: goto -> 106
    //   100: astore_1
    //   101: ldc com/google/api/DocumentationRule
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: getstatic com/google/api/DocumentationRule.PARSER : Lcom/google/protobuf/Parser;
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
    //   155: bipush #26
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
    //   177: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   180: putfield deprecationDescription_ : Ljava/lang/String;
    //   183: goto -> 123
    //   186: aload_0
    //   187: aload_1
    //   188: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   191: putfield description_ : Ljava/lang/String;
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
    //   218: astore_2
    //   219: new java/lang/RuntimeException
    //   222: astore_3
    //   223: new com/google/protobuf/InvalidProtocolBufferException
    //   226: astore_1
    //   227: aload_1
    //   228: aload_2
    //   229: invokevirtual getMessage : ()Ljava/lang/String;
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: aload_3
    //   236: aload_1
    //   237: aload_0
    //   238: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   241: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   244: aload_3
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
    //   264: getstatic com/google/api/DocumentationRule.DEFAULT_INSTANCE : Lcom/google/api/DocumentationRule;
    //   267: areturn
    //   268: aload_2
    //   269: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   272: astore_1
    //   273: aload_3
    //   274: checkcast com/google/api/DocumentationRule
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
    //   293: aload_2
    //   294: getfield selector_ : Ljava/lang/String;
    //   297: invokevirtual isEmpty : ()Z
    //   300: iconst_1
    //   301: ixor
    //   302: aload_2
    //   303: getfield selector_ : Ljava/lang/String;
    //   306: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   311: putfield selector_ : Ljava/lang/String;
    //   314: aload_0
    //   315: aload_1
    //   316: aload_0
    //   317: getfield description_ : Ljava/lang/String;
    //   320: invokevirtual isEmpty : ()Z
    //   323: iconst_1
    //   324: ixor
    //   325: aload_0
    //   326: getfield description_ : Ljava/lang/String;
    //   329: aload_2
    //   330: getfield description_ : Ljava/lang/String;
    //   333: invokevirtual isEmpty : ()Z
    //   336: iconst_1
    //   337: ixor
    //   338: aload_2
    //   339: getfield description_ : Ljava/lang/String;
    //   342: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   347: putfield description_ : Ljava/lang/String;
    //   350: aload_0
    //   351: aload_1
    //   352: aload_0
    //   353: getfield deprecationDescription_ : Ljava/lang/String;
    //   356: invokevirtual isEmpty : ()Z
    //   359: iconst_1
    //   360: ixor
    //   361: aload_0
    //   362: getfield deprecationDescription_ : Ljava/lang/String;
    //   365: iconst_1
    //   366: aload_2
    //   367: getfield deprecationDescription_ : Ljava/lang/String;
    //   370: invokevirtual isEmpty : ()Z
    //   373: ixor
    //   374: aload_2
    //   375: getfield deprecationDescription_ : Ljava/lang/String;
    //   378: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   383: putfield deprecationDescription_ : Ljava/lang/String;
    //   386: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   389: astore_1
    //   390: aload_0
    //   391: areturn
    //   392: new com/google/api/DocumentationRule$Builder
    //   395: dup
    //   396: aconst_null
    //   397: invokespecial <init> : (Lcom/google/api/DocumentationRule$1;)V
    //   400: areturn
    //   401: aconst_null
    //   402: areturn
    //   403: getstatic com/google/api/DocumentationRule.DEFAULT_INSTANCE : Lcom/google/api/DocumentationRule;
    //   406: areturn
    //   407: new com/google/api/DocumentationRule
    //   410: dup
    //   411: invokespecial <init> : ()V
    //   414: areturn
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
  
  public String getDeprecationDescription() {
    return this.deprecationDescription_;
  }
  
  public ByteString getDeprecationDescriptionBytes() {
    return ByteString.copyFromUtf8(this.deprecationDescription_);
  }
  
  public String getDescription() {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes() {
    return ByteString.copyFromUtf8(this.description_);
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
    if (!this.description_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(2, getDescription()); 
    j = i;
    if (!this.deprecationDescription_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(3, getDeprecationDescription()); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.selector_.isEmpty())
      paramCodedOutputStream.writeString(1, getSelector()); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(2, getDescription()); 
    if (!this.deprecationDescription_.isEmpty())
      paramCodedOutputStream.writeString(3, getDeprecationDescription()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<DocumentationRule, Builder> implements DocumentationRuleOrBuilder {
    private Builder() {
      super(DocumentationRule.DEFAULT_INSTANCE);
    }
    
    public Builder clearDeprecationDescription() {
      copyOnWrite();
      ((DocumentationRule)this.instance).clearDeprecationDescription();
      return this;
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((DocumentationRule)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearSelector() {
      copyOnWrite();
      ((DocumentationRule)this.instance).clearSelector();
      return this;
    }
    
    public String getDeprecationDescription() {
      return ((DocumentationRule)this.instance).getDeprecationDescription();
    }
    
    public ByteString getDeprecationDescriptionBytes() {
      return ((DocumentationRule)this.instance).getDeprecationDescriptionBytes();
    }
    
    public String getDescription() {
      return ((DocumentationRule)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((DocumentationRule)this.instance).getDescriptionBytes();
    }
    
    public String getSelector() {
      return ((DocumentationRule)this.instance).getSelector();
    }
    
    public ByteString getSelectorBytes() {
      return ((DocumentationRule)this.instance).getSelectorBytes();
    }
    
    public Builder setDeprecationDescription(String param1String) {
      copyOnWrite();
      ((DocumentationRule)this.instance).setDeprecationDescription(param1String);
      return this;
    }
    
    public Builder setDeprecationDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DocumentationRule)this.instance).setDeprecationDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((DocumentationRule)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DocumentationRule)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setSelector(String param1String) {
      copyOnWrite();
      ((DocumentationRule)this.instance).setSelector(param1String);
      return this;
    }
    
    public Builder setSelectorBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((DocumentationRule)this.instance).setSelectorBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\DocumentationRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */