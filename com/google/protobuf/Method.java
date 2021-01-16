package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Method extends GeneratedMessageLite<Method, Method.Builder> implements MethodOrBuilder {
  private static final Method DEFAULT_INSTANCE = new Method();
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 6;
  
  private static volatile Parser<Method> PARSER;
  
  public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
  
  public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
  
  public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
  
  public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
  
  public static final int SYNTAX_FIELD_NUMBER = 7;
  
  private int bitField0_;
  
  private String name_ = "";
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private boolean requestStreaming_;
  
  private String requestTypeUrl_ = "";
  
  private boolean responseStreaming_;
  
  private String responseTypeUrl_ = "";
  
  private int syntax_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramInt, paramBuilder.build());
  }
  
  private void addOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOptions(Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.add(paramBuilder.build());
  }
  
  private void addOptions(Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.add(paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void clearRequestStreaming() {
    this.requestStreaming_ = false;
  }
  
  private void clearRequestTypeUrl() {
    this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
  }
  
  private void clearResponseStreaming() {
    this.responseStreaming_ = false;
  }
  
  private void clearResponseTypeUrl() {
    this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
  }
  
  private void clearSyntax() {
    this.syntax_ = 0;
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Method getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Method paramMethod) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramMethod);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Method)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Method parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Method)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Method parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Method parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Method parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Method parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Method parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Method>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Method> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setName(String paramString) {
    if (paramString != null) {
      this.name_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.name_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setOptions(int paramInt, Option.Builder paramBuilder) {
    ensureOptionsIsMutable();
    this.options_.set(paramInt, paramBuilder.build());
  }
  
  private void setOptions(int paramInt, Option paramOption) {
    if (paramOption != null) {
      ensureOptionsIsMutable();
      this.options_.set(paramInt, paramOption);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestStreaming(boolean paramBoolean) {
    this.requestStreaming_ = paramBoolean;
  }
  
  private void setRequestTypeUrl(String paramString) {
    if (paramString != null) {
      this.requestTypeUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setRequestTypeUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.requestTypeUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponseStreaming(boolean paramBoolean) {
    this.responseStreaming_ = paramBoolean;
  }
  
  private void setResponseTypeUrl(String paramString) {
    if (paramString != null) {
      this.responseTypeUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setResponseTypeUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.responseTypeUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSyntax(Syntax paramSyntax) {
    if (paramSyntax != null) {
      this.syntax_ = paramSyntax.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setSyntaxValue(int paramInt) {
    this.syntax_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Method$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 675, 2 -> 671, 3 -> 660, 4 -> 651, 5 -> 381, 6 -> 118, 7 -> 377, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Method
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Method.DEFAULT_INSTANCE : Lcom/google/protobuf/Method;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Method
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Method
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Method.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 377
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 321
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 310
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 299
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 288
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 277
    //   172: iload #4
    //   174: bipush #40
    //   176: if_icmpeq -> 266
    //   179: iload #4
    //   181: bipush #50
    //   183: if_icmpeq -> 219
    //   186: iload #4
    //   188: bipush #56
    //   190: if_icmpeq -> 208
    //   193: aload_1
    //   194: iload #4
    //   196: invokevirtual skipField : (I)Z
    //   199: ifne -> 128
    //   202: iconst_1
    //   203: istore #6
    //   205: goto -> 128
    //   208: aload_0
    //   209: aload_1
    //   210: invokevirtual readEnum : ()I
    //   213: putfield syntax_ : I
    //   216: goto -> 128
    //   219: aload_0
    //   220: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   223: invokeinterface isModifiable : ()Z
    //   228: ifne -> 242
    //   231: aload_0
    //   232: aload_0
    //   233: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   236: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   239: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: aload_0
    //   243: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   246: aload_1
    //   247: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   250: aload_2
    //   251: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   254: checkcast com/google/protobuf/Option
    //   257: invokeinterface add : (Ljava/lang/Object;)Z
    //   262: pop
    //   263: goto -> 128
    //   266: aload_0
    //   267: aload_1
    //   268: invokevirtual readBool : ()Z
    //   271: putfield responseStreaming_ : Z
    //   274: goto -> 128
    //   277: aload_0
    //   278: aload_1
    //   279: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   282: putfield responseTypeUrl_ : Ljava/lang/String;
    //   285: goto -> 128
    //   288: aload_0
    //   289: aload_1
    //   290: invokevirtual readBool : ()Z
    //   293: putfield requestStreaming_ : Z
    //   296: goto -> 128
    //   299: aload_0
    //   300: aload_1
    //   301: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   304: putfield requestTypeUrl_ : Ljava/lang/String;
    //   307: goto -> 128
    //   310: aload_0
    //   311: aload_1
    //   312: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   315: putfield name_ : Ljava/lang/String;
    //   318: goto -> 128
    //   321: iconst_1
    //   322: istore #6
    //   324: goto -> 128
    //   327: astore_1
    //   328: goto -> 375
    //   331: astore_1
    //   332: new java/lang/RuntimeException
    //   335: astore_3
    //   336: new com/google/protobuf/InvalidProtocolBufferException
    //   339: astore_2
    //   340: aload_2
    //   341: aload_1
    //   342: invokevirtual getMessage : ()Ljava/lang/String;
    //   345: invokespecial <init> : (Ljava/lang/String;)V
    //   348: aload_3
    //   349: aload_2
    //   350: aload_0
    //   351: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   354: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   357: aload_3
    //   358: athrow
    //   359: astore_1
    //   360: new java/lang/RuntimeException
    //   363: astore_2
    //   364: aload_2
    //   365: aload_1
    //   366: aload_0
    //   367: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   370: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   373: aload_2
    //   374: athrow
    //   375: aload_1
    //   376: athrow
    //   377: getstatic com/google/protobuf/Method.DEFAULT_INSTANCE : Lcom/google/protobuf/Method;
    //   380: areturn
    //   381: aload_2
    //   382: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   385: astore_1
    //   386: aload_3
    //   387: checkcast com/google/protobuf/Method
    //   390: astore_2
    //   391: aload_0
    //   392: aload_1
    //   393: aload_0
    //   394: getfield name_ : Ljava/lang/String;
    //   397: invokevirtual isEmpty : ()Z
    //   400: iconst_1
    //   401: ixor
    //   402: aload_0
    //   403: getfield name_ : Ljava/lang/String;
    //   406: aload_2
    //   407: getfield name_ : Ljava/lang/String;
    //   410: invokevirtual isEmpty : ()Z
    //   413: iconst_1
    //   414: ixor
    //   415: aload_2
    //   416: getfield name_ : Ljava/lang/String;
    //   419: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   424: putfield name_ : Ljava/lang/String;
    //   427: aload_0
    //   428: aload_1
    //   429: aload_0
    //   430: getfield requestTypeUrl_ : Ljava/lang/String;
    //   433: invokevirtual isEmpty : ()Z
    //   436: iconst_1
    //   437: ixor
    //   438: aload_0
    //   439: getfield requestTypeUrl_ : Ljava/lang/String;
    //   442: aload_2
    //   443: getfield requestTypeUrl_ : Ljava/lang/String;
    //   446: invokevirtual isEmpty : ()Z
    //   449: iconst_1
    //   450: ixor
    //   451: aload_2
    //   452: getfield requestTypeUrl_ : Ljava/lang/String;
    //   455: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   460: putfield requestTypeUrl_ : Ljava/lang/String;
    //   463: aload_0
    //   464: getfield requestStreaming_ : Z
    //   467: istore #7
    //   469: aload_2
    //   470: getfield requestStreaming_ : Z
    //   473: istore #8
    //   475: aload_0
    //   476: aload_1
    //   477: iload #7
    //   479: iload #7
    //   481: iload #8
    //   483: iload #8
    //   485: invokeinterface visitBoolean : (ZZZZ)Z
    //   490: putfield requestStreaming_ : Z
    //   493: aload_0
    //   494: aload_1
    //   495: aload_0
    //   496: getfield responseTypeUrl_ : Ljava/lang/String;
    //   499: invokevirtual isEmpty : ()Z
    //   502: iconst_1
    //   503: ixor
    //   504: aload_0
    //   505: getfield responseTypeUrl_ : Ljava/lang/String;
    //   508: aload_2
    //   509: getfield responseTypeUrl_ : Ljava/lang/String;
    //   512: invokevirtual isEmpty : ()Z
    //   515: iconst_1
    //   516: ixor
    //   517: aload_2
    //   518: getfield responseTypeUrl_ : Ljava/lang/String;
    //   521: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   526: putfield responseTypeUrl_ : Ljava/lang/String;
    //   529: aload_0
    //   530: getfield responseStreaming_ : Z
    //   533: istore #8
    //   535: aload_2
    //   536: getfield responseStreaming_ : Z
    //   539: istore #7
    //   541: aload_0
    //   542: aload_1
    //   543: iload #8
    //   545: iload #8
    //   547: iload #7
    //   549: iload #7
    //   551: invokeinterface visitBoolean : (ZZZZ)Z
    //   556: putfield responseStreaming_ : Z
    //   559: aload_0
    //   560: aload_1
    //   561: aload_0
    //   562: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   565: aload_2
    //   566: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   569: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   574: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   577: aload_0
    //   578: getfield syntax_ : I
    //   581: ifeq -> 590
    //   584: iconst_1
    //   585: istore #8
    //   587: goto -> 593
    //   590: iconst_0
    //   591: istore #8
    //   593: aload_0
    //   594: getfield syntax_ : I
    //   597: istore #6
    //   599: aload_2
    //   600: getfield syntax_ : I
    //   603: ifeq -> 609
    //   606: iconst_1
    //   607: istore #5
    //   609: aload_0
    //   610: aload_1
    //   611: iload #8
    //   613: iload #6
    //   615: iload #5
    //   617: aload_2
    //   618: getfield syntax_ : I
    //   621: invokeinterface visitInt : (ZIZI)I
    //   626: putfield syntax_ : I
    //   629: aload_1
    //   630: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   633: if_acmpne -> 649
    //   636: aload_0
    //   637: aload_0
    //   638: getfield bitField0_ : I
    //   641: aload_2
    //   642: getfield bitField0_ : I
    //   645: ior
    //   646: putfield bitField0_ : I
    //   649: aload_0
    //   650: areturn
    //   651: new com/google/protobuf/Method$Builder
    //   654: dup
    //   655: aconst_null
    //   656: invokespecial <init> : (Lcom/google/protobuf/Method$1;)V
    //   659: areturn
    //   660: aload_0
    //   661: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   664: invokeinterface makeImmutable : ()V
    //   669: aconst_null
    //   670: areturn
    //   671: getstatic com/google/protobuf/Method.DEFAULT_INSTANCE : Lcom/google/protobuf/Method;
    //   674: areturn
    //   675: new com/google/protobuf/Method
    //   678: dup
    //   679: invokespecial <init> : ()V
    //   682: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	359	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	331	java/io/IOException
    //   133	139	327	finally
    //   193	202	359	com/google/protobuf/InvalidProtocolBufferException
    //   193	202	331	java/io/IOException
    //   193	202	327	finally
    //   208	216	359	com/google/protobuf/InvalidProtocolBufferException
    //   208	216	331	java/io/IOException
    //   208	216	327	finally
    //   219	242	359	com/google/protobuf/InvalidProtocolBufferException
    //   219	242	331	java/io/IOException
    //   219	242	327	finally
    //   242	263	359	com/google/protobuf/InvalidProtocolBufferException
    //   242	263	331	java/io/IOException
    //   242	263	327	finally
    //   266	274	359	com/google/protobuf/InvalidProtocolBufferException
    //   266	274	331	java/io/IOException
    //   266	274	327	finally
    //   277	285	359	com/google/protobuf/InvalidProtocolBufferException
    //   277	285	331	java/io/IOException
    //   277	285	327	finally
    //   288	296	359	com/google/protobuf/InvalidProtocolBufferException
    //   288	296	331	java/io/IOException
    //   288	296	327	finally
    //   299	307	359	com/google/protobuf/InvalidProtocolBufferException
    //   299	307	331	java/io/IOException
    //   299	307	327	finally
    //   310	318	359	com/google/protobuf/InvalidProtocolBufferException
    //   310	318	331	java/io/IOException
    //   310	318	327	finally
    //   332	359	327	finally
    //   360	375	327	finally
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public Option getOptions(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public int getOptionsCount() {
    return this.options_.size();
  }
  
  public List<Option> getOptionsList() {
    return this.options_;
  }
  
  public OptionOrBuilder getOptionsOrBuilder(int paramInt) {
    return this.options_.get(paramInt);
  }
  
  public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
    return (List)this.options_;
  }
  
  public boolean getRequestStreaming() {
    return this.requestStreaming_;
  }
  
  public String getRequestTypeUrl() {
    return this.requestTypeUrl_;
  }
  
  public ByteString getRequestTypeUrlBytes() {
    return ByteString.copyFromUtf8(this.requestTypeUrl_);
  }
  
  public boolean getResponseStreaming() {
    return this.responseStreaming_;
  }
  
  public String getResponseTypeUrl() {
    return this.responseTypeUrl_;
  }
  
  public ByteString getResponseTypeUrlBytes() {
    return ByteString.copyFromUtf8(this.responseTypeUrl_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    boolean bool = this.name_.isEmpty();
    byte b1 = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    int j = i;
    if (!this.requestTypeUrl_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(2, getRequestTypeUrl()); 
    bool = this.requestStreaming_;
    i = j;
    if (bool)
      i = j + CodedOutputStream.computeBoolSize(3, bool); 
    j = i;
    if (!this.responseTypeUrl_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getResponseTypeUrl()); 
    bool = this.responseStreaming_;
    i = j;
    byte b2 = b1;
    if (bool) {
      i = j + CodedOutputStream.computeBoolSize(5, bool);
      b2 = b1;
    } 
    while (b2 < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(6, this.options_.get(b2));
      b2++;
    } 
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public Syntax getSyntax() {
    Syntax syntax1 = Syntax.forNumber(this.syntax_);
    Syntax syntax2 = syntax1;
    if (syntax1 == null)
      syntax2 = Syntax.UNRECOGNIZED; 
    return syntax2;
  }
  
  public int getSyntaxValue() {
    return this.syntax_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    if (!this.requestTypeUrl_.isEmpty())
      paramCodedOutputStream.writeString(2, getRequestTypeUrl()); 
    boolean bool = this.requestStreaming_;
    if (bool)
      paramCodedOutputStream.writeBool(3, bool); 
    if (!this.responseTypeUrl_.isEmpty())
      paramCodedOutputStream.writeString(4, getResponseTypeUrl()); 
    bool = this.responseStreaming_;
    if (bool)
      paramCodedOutputStream.writeBool(5, bool); 
    for (byte b = 0; b < this.options_.size(); b++)
      paramCodedOutputStream.writeMessage(6, this.options_.get(b)); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(7, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
    private Builder() {
      super(Method.DEFAULT_INSTANCE);
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder addOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder addOptions(Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.addOptions(param1Builder);
      return this;
    }
    
    public Builder addOptions(Option param1Option) {
      copyOnWrite();
      this.instance.addOptions(param1Option);
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      this.instance.clearOptions();
      return this;
    }
    
    public Builder clearRequestStreaming() {
      copyOnWrite();
      this.instance.clearRequestStreaming();
      return this;
    }
    
    public Builder clearRequestTypeUrl() {
      copyOnWrite();
      this.instance.clearRequestTypeUrl();
      return this;
    }
    
    public Builder clearResponseStreaming() {
      copyOnWrite();
      this.instance.clearResponseStreaming();
      return this;
    }
    
    public Builder clearResponseTypeUrl() {
      copyOnWrite();
      this.instance.clearResponseTypeUrl();
      return this;
    }
    
    public Builder clearSyntax() {
      copyOnWrite();
      this.instance.clearSyntax();
      return this;
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public Option getOptions(int param1Int) {
      return this.instance.getOptions(param1Int);
    }
    
    public int getOptionsCount() {
      return this.instance.getOptionsCount();
    }
    
    public List<Option> getOptionsList() {
      return Collections.unmodifiableList(this.instance.getOptionsList());
    }
    
    public boolean getRequestStreaming() {
      return this.instance.getRequestStreaming();
    }
    
    public String getRequestTypeUrl() {
      return this.instance.getRequestTypeUrl();
    }
    
    public ByteString getRequestTypeUrlBytes() {
      return this.instance.getRequestTypeUrlBytes();
    }
    
    public boolean getResponseStreaming() {
      return this.instance.getResponseStreaming();
    }
    
    public String getResponseTypeUrl() {
      return this.instance.getResponseTypeUrl();
    }
    
    public ByteString getResponseTypeUrlBytes() {
      return this.instance.getResponseTypeUrlBytes();
    }
    
    public Syntax getSyntax() {
      return this.instance.getSyntax();
    }
    
    public int getSyntaxValue() {
      return this.instance.getSyntaxValue();
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      this.instance.setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option.Builder param1Builder) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Builder);
      return this;
    }
    
    public Builder setOptions(int param1Int, Option param1Option) {
      copyOnWrite();
      this.instance.setOptions(param1Int, param1Option);
      return this;
    }
    
    public Builder setRequestStreaming(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setRequestStreaming(param1Boolean);
      return this;
    }
    
    public Builder setRequestTypeUrl(String param1String) {
      copyOnWrite();
      this.instance.setRequestTypeUrl(param1String);
      return this;
    }
    
    public Builder setRequestTypeUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setRequestTypeUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setResponseStreaming(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setResponseStreaming(param1Boolean);
      return this;
    }
    
    public Builder setResponseTypeUrl(String param1String) {
      copyOnWrite();
      this.instance.setResponseTypeUrl(param1String);
      return this;
    }
    
    public Builder setResponseTypeUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setResponseTypeUrlBytes(param1ByteString);
      return this;
    }
    
    public Builder setSyntax(Syntax param1Syntax) {
      copyOnWrite();
      this.instance.setSyntax(param1Syntax);
      return this;
    }
    
    public Builder setSyntaxValue(int param1Int) {
      copyOnWrite();
      this.instance.setSyntaxValue(param1Int);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Method.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */