package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Api extends GeneratedMessageLite<Api, Api.Builder> implements ApiOrBuilder {
  private static final Api DEFAULT_INSTANCE = new Api();
  
  public static final int METHODS_FIELD_NUMBER = 2;
  
  public static final int MIXINS_FIELD_NUMBER = 6;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int OPTIONS_FIELD_NUMBER = 3;
  
  private static volatile Parser<Api> PARSER;
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  
  public static final int SYNTAX_FIELD_NUMBER = 7;
  
  public static final int VERSION_FIELD_NUMBER = 4;
  
  private int bitField0_;
  
  private Internal.ProtobufList<Method> methods_ = emptyProtobufList();
  
  private Internal.ProtobufList<Mixin> mixins_ = emptyProtobufList();
  
  private String name_ = "";
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  private String version_ = "";
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllMethods(Iterable<? extends Method> paramIterable) {
    ensureMethodsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.methods_);
  }
  
  private void addAllMixins(Iterable<? extends Mixin> paramIterable) {
    ensureMixinsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.mixins_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addMethods(int paramInt, Method.Builder paramBuilder) {
    ensureMethodsIsMutable();
    this.methods_.add(paramInt, paramBuilder.build());
  }
  
  private void addMethods(int paramInt, Method paramMethod) {
    if (paramMethod != null) {
      ensureMethodsIsMutable();
      this.methods_.add(paramInt, paramMethod);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMethods(Method.Builder paramBuilder) {
    ensureMethodsIsMutable();
    this.methods_.add(paramBuilder.build());
  }
  
  private void addMethods(Method paramMethod) {
    if (paramMethod != null) {
      ensureMethodsIsMutable();
      this.methods_.add(paramMethod);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMixins(int paramInt, Mixin.Builder paramBuilder) {
    ensureMixinsIsMutable();
    this.mixins_.add(paramInt, paramBuilder.build());
  }
  
  private void addMixins(int paramInt, Mixin paramMixin) {
    if (paramMixin != null) {
      ensureMixinsIsMutable();
      this.mixins_.add(paramInt, paramMixin);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addMixins(Mixin.Builder paramBuilder) {
    ensureMixinsIsMutable();
    this.mixins_.add(paramBuilder.build());
  }
  
  private void addMixins(Mixin paramMixin) {
    if (paramMixin != null) {
      ensureMixinsIsMutable();
      this.mixins_.add(paramMixin);
      return;
    } 
    throw new NullPointerException();
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
  
  private void clearMethods() {
    this.methods_ = emptyProtobufList();
  }
  
  private void clearMixins() {
    this.mixins_ = emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void clearSourceContext() {
    this.sourceContext_ = null;
  }
  
  private void clearSyntax() {
    this.syntax_ = 0;
  }
  
  private void clearVersion() {
    this.version_ = getDefaultInstance().getVersion();
  }
  
  private void ensureMethodsIsMutable() {
    if (!this.methods_.isModifiable())
      this.methods_ = GeneratedMessageLite.mutableCopy(this.methods_); 
  }
  
  private void ensureMixinsIsMutable() {
    if (!this.mixins_.isModifiable())
      this.mixins_ = GeneratedMessageLite.mutableCopy(this.mixins_); 
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Api getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeSourceContext(SourceContext paramSourceContext) {
    SourceContext sourceContext = this.sourceContext_;
    if (sourceContext != null && sourceContext != SourceContext.getDefaultInstance()) {
      this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(paramSourceContext).buildPartial();
    } else {
      this.sourceContext_ = paramSourceContext;
    } 
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Api paramApi) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramApi);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Api)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Api parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Api)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Api parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Api parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Api parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Api parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Api parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Api>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Api> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeMethods(int paramInt) {
    ensureMethodsIsMutable();
    this.methods_.remove(paramInt);
  }
  
  private void removeMixins(int paramInt) {
    ensureMixinsIsMutable();
    this.mixins_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setMethods(int paramInt, Method.Builder paramBuilder) {
    ensureMethodsIsMutable();
    this.methods_.set(paramInt, paramBuilder.build());
  }
  
  private void setMethods(int paramInt, Method paramMethod) {
    if (paramMethod != null) {
      ensureMethodsIsMutable();
      this.methods_.set(paramInt, paramMethod);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMixins(int paramInt, Mixin.Builder paramBuilder) {
    ensureMixinsIsMutable();
    this.mixins_.set(paramInt, paramBuilder.build());
  }
  
  private void setMixins(int paramInt, Mixin paramMixin) {
    if (paramMixin != null) {
      ensureMixinsIsMutable();
      this.mixins_.set(paramInt, paramMixin);
      return;
    } 
    throw new NullPointerException();
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
  
  private void setSourceContext(SourceContext.Builder paramBuilder) {
    this.sourceContext_ = paramBuilder.build();
  }
  
  private void setSourceContext(SourceContext paramSourceContext) {
    if (paramSourceContext != null) {
      this.sourceContext_ = paramSourceContext;
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
  
  private void setVersion(String paramString) {
    if (paramString != null) {
      this.version_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setVersionBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.version_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Api$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 780, 2 -> 776, 3 -> 747, 4 -> 738, 5 -> 507, 6 -> 118, 7 -> 503, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Api
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Api.DEFAULT_INSTANCE : Lcom/google/protobuf/Api;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Api
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Api
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Api.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 503
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 447
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 436
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 389
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 342
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 331
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 266
    //   179: iload #4
    //   181: bipush #50
    //   183: if_icmpeq -> 219
    //   186: iload #4
    //   188: bipush #56
    //   190: if_icmpeq -> 208
    //   193: aload_2
    //   194: iload #4
    //   196: invokevirtual skipField : (I)Z
    //   199: ifne -> 128
    //   202: iconst_1
    //   203: istore #6
    //   205: goto -> 128
    //   208: aload_0
    //   209: aload_2
    //   210: invokevirtual readEnum : ()I
    //   213: putfield syntax_ : I
    //   216: goto -> 128
    //   219: aload_0
    //   220: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   223: invokeinterface isModifiable : ()Z
    //   228: ifne -> 242
    //   231: aload_0
    //   232: aload_0
    //   233: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   236: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   239: putfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   242: aload_0
    //   243: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   246: aload_2
    //   247: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   250: aload_3
    //   251: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   254: checkcast com/google/protobuf/Mixin
    //   257: invokeinterface add : (Ljava/lang/Object;)Z
    //   262: pop
    //   263: goto -> 128
    //   266: aload_0
    //   267: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   270: ifnull -> 287
    //   273: aload_0
    //   274: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   277: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   280: checkcast com/google/protobuf/SourceContext$Builder
    //   283: astore_1
    //   284: goto -> 289
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_0
    //   290: aload_2
    //   291: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   294: aload_3
    //   295: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   298: checkcast com/google/protobuf/SourceContext
    //   301: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   304: aload_1
    //   305: ifnull -> 128
    //   308: aload_1
    //   309: aload_0
    //   310: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   313: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   316: pop
    //   317: aload_0
    //   318: aload_1
    //   319: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   322: checkcast com/google/protobuf/SourceContext
    //   325: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   328: goto -> 128
    //   331: aload_0
    //   332: aload_2
    //   333: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   336: putfield version_ : Ljava/lang/String;
    //   339: goto -> 128
    //   342: aload_0
    //   343: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   346: invokeinterface isModifiable : ()Z
    //   351: ifne -> 365
    //   354: aload_0
    //   355: aload_0
    //   356: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   359: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   362: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   365: aload_0
    //   366: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   369: aload_2
    //   370: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   373: aload_3
    //   374: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   377: checkcast com/google/protobuf/Option
    //   380: invokeinterface add : (Ljava/lang/Object;)Z
    //   385: pop
    //   386: goto -> 128
    //   389: aload_0
    //   390: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   393: invokeinterface isModifiable : ()Z
    //   398: ifne -> 412
    //   401: aload_0
    //   402: aload_0
    //   403: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   406: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   409: putfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   412: aload_0
    //   413: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   416: aload_2
    //   417: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   420: aload_3
    //   421: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   424: checkcast com/google/protobuf/Method
    //   427: invokeinterface add : (Ljava/lang/Object;)Z
    //   432: pop
    //   433: goto -> 128
    //   436: aload_0
    //   437: aload_2
    //   438: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   441: putfield name_ : Ljava/lang/String;
    //   444: goto -> 128
    //   447: iconst_1
    //   448: istore #6
    //   450: goto -> 128
    //   453: astore_1
    //   454: goto -> 501
    //   457: astore_2
    //   458: new java/lang/RuntimeException
    //   461: astore_3
    //   462: new com/google/protobuf/InvalidProtocolBufferException
    //   465: astore_1
    //   466: aload_1
    //   467: aload_2
    //   468: invokevirtual getMessage : ()Ljava/lang/String;
    //   471: invokespecial <init> : (Ljava/lang/String;)V
    //   474: aload_3
    //   475: aload_1
    //   476: aload_0
    //   477: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   480: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   483: aload_3
    //   484: athrow
    //   485: astore_2
    //   486: new java/lang/RuntimeException
    //   489: astore_1
    //   490: aload_1
    //   491: aload_2
    //   492: aload_0
    //   493: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   496: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   499: aload_1
    //   500: athrow
    //   501: aload_1
    //   502: athrow
    //   503: getstatic com/google/protobuf/Api.DEFAULT_INSTANCE : Lcom/google/protobuf/Api;
    //   506: areturn
    //   507: aload_2
    //   508: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   511: astore_1
    //   512: aload_3
    //   513: checkcast com/google/protobuf/Api
    //   516: astore_2
    //   517: aload_0
    //   518: aload_1
    //   519: aload_0
    //   520: getfield name_ : Ljava/lang/String;
    //   523: invokevirtual isEmpty : ()Z
    //   526: iconst_1
    //   527: ixor
    //   528: aload_0
    //   529: getfield name_ : Ljava/lang/String;
    //   532: aload_2
    //   533: getfield name_ : Ljava/lang/String;
    //   536: invokevirtual isEmpty : ()Z
    //   539: iconst_1
    //   540: ixor
    //   541: aload_2
    //   542: getfield name_ : Ljava/lang/String;
    //   545: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   550: putfield name_ : Ljava/lang/String;
    //   553: aload_0
    //   554: aload_1
    //   555: aload_0
    //   556: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   559: aload_2
    //   560: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   563: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   568: putfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   571: aload_0
    //   572: aload_1
    //   573: aload_0
    //   574: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   577: aload_2
    //   578: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   581: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   586: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   589: aload_0
    //   590: aload_1
    //   591: aload_0
    //   592: getfield version_ : Ljava/lang/String;
    //   595: invokevirtual isEmpty : ()Z
    //   598: iconst_1
    //   599: ixor
    //   600: aload_0
    //   601: getfield version_ : Ljava/lang/String;
    //   604: aload_2
    //   605: getfield version_ : Ljava/lang/String;
    //   608: invokevirtual isEmpty : ()Z
    //   611: iconst_1
    //   612: ixor
    //   613: aload_2
    //   614: getfield version_ : Ljava/lang/String;
    //   617: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   622: putfield version_ : Ljava/lang/String;
    //   625: aload_0
    //   626: aload_1
    //   627: aload_0
    //   628: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   631: aload_2
    //   632: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   635: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   640: checkcast com/google/protobuf/SourceContext
    //   643: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   646: aload_0
    //   647: aload_1
    //   648: aload_0
    //   649: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   652: aload_2
    //   653: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   656: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   661: putfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   664: aload_0
    //   665: getfield syntax_ : I
    //   668: ifeq -> 677
    //   671: iconst_1
    //   672: istore #7
    //   674: goto -> 680
    //   677: iconst_0
    //   678: istore #7
    //   680: aload_0
    //   681: getfield syntax_ : I
    //   684: istore #6
    //   686: aload_2
    //   687: getfield syntax_ : I
    //   690: ifeq -> 696
    //   693: iconst_1
    //   694: istore #5
    //   696: aload_0
    //   697: aload_1
    //   698: iload #7
    //   700: iload #6
    //   702: iload #5
    //   704: aload_2
    //   705: getfield syntax_ : I
    //   708: invokeinterface visitInt : (ZIZI)I
    //   713: putfield syntax_ : I
    //   716: aload_1
    //   717: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   720: if_acmpne -> 736
    //   723: aload_0
    //   724: aload_0
    //   725: getfield bitField0_ : I
    //   728: aload_2
    //   729: getfield bitField0_ : I
    //   732: ior
    //   733: putfield bitField0_ : I
    //   736: aload_0
    //   737: areturn
    //   738: new com/google/protobuf/Api$Builder
    //   741: dup
    //   742: aconst_null
    //   743: invokespecial <init> : (Lcom/google/protobuf/Api$1;)V
    //   746: areturn
    //   747: aload_0
    //   748: getfield methods_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   751: invokeinterface makeImmutable : ()V
    //   756: aload_0
    //   757: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   760: invokeinterface makeImmutable : ()V
    //   765: aload_0
    //   766: getfield mixins_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   769: invokeinterface makeImmutable : ()V
    //   774: aconst_null
    //   775: areturn
    //   776: getstatic com/google/protobuf/Api.DEFAULT_INSTANCE : Lcom/google/protobuf/Api;
    //   779: areturn
    //   780: new com/google/protobuf/Api
    //   783: dup
    //   784: invokespecial <init> : ()V
    //   787: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	485	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	457	java/io/IOException
    //   133	139	453	finally
    //   193	202	485	com/google/protobuf/InvalidProtocolBufferException
    //   193	202	457	java/io/IOException
    //   193	202	453	finally
    //   208	216	485	com/google/protobuf/InvalidProtocolBufferException
    //   208	216	457	java/io/IOException
    //   208	216	453	finally
    //   219	242	485	com/google/protobuf/InvalidProtocolBufferException
    //   219	242	457	java/io/IOException
    //   219	242	453	finally
    //   242	263	485	com/google/protobuf/InvalidProtocolBufferException
    //   242	263	457	java/io/IOException
    //   242	263	453	finally
    //   266	284	485	com/google/protobuf/InvalidProtocolBufferException
    //   266	284	457	java/io/IOException
    //   266	284	453	finally
    //   289	304	485	com/google/protobuf/InvalidProtocolBufferException
    //   289	304	457	java/io/IOException
    //   289	304	453	finally
    //   308	328	485	com/google/protobuf/InvalidProtocolBufferException
    //   308	328	457	java/io/IOException
    //   308	328	453	finally
    //   331	339	485	com/google/protobuf/InvalidProtocolBufferException
    //   331	339	457	java/io/IOException
    //   331	339	453	finally
    //   342	365	485	com/google/protobuf/InvalidProtocolBufferException
    //   342	365	457	java/io/IOException
    //   342	365	453	finally
    //   365	386	485	com/google/protobuf/InvalidProtocolBufferException
    //   365	386	457	java/io/IOException
    //   365	386	453	finally
    //   389	412	485	com/google/protobuf/InvalidProtocolBufferException
    //   389	412	457	java/io/IOException
    //   389	412	453	finally
    //   412	433	485	com/google/protobuf/InvalidProtocolBufferException
    //   412	433	457	java/io/IOException
    //   412	433	453	finally
    //   436	444	485	com/google/protobuf/InvalidProtocolBufferException
    //   436	444	457	java/io/IOException
    //   436	444	453	finally
    //   458	485	453	finally
    //   486	501	453	finally
  }
  
  public Method getMethods(int paramInt) {
    return this.methods_.get(paramInt);
  }
  
  public int getMethodsCount() {
    return this.methods_.size();
  }
  
  public List<Method> getMethodsList() {
    return this.methods_;
  }
  
  public MethodOrBuilder getMethodsOrBuilder(int paramInt) {
    return this.methods_.get(paramInt);
  }
  
  public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
    return (List)this.methods_;
  }
  
  public Mixin getMixins(int paramInt) {
    return this.mixins_.get(paramInt);
  }
  
  public int getMixinsCount() {
    return this.mixins_.size();
  }
  
  public List<Mixin> getMixinsList() {
    return this.mixins_;
  }
  
  public MixinOrBuilder getMixinsOrBuilder(int paramInt) {
    return this.mixins_.get(paramInt);
  }
  
  public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
    return (List)this.mixins_;
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
    int j;
    for (j = 0; j < this.methods_.size(); j++)
      i += CodedOutputStream.computeMessageSize(2, this.methods_.get(j)); 
    for (j = 0; j < this.options_.size(); j++)
      i += CodedOutputStream.computeMessageSize(3, this.options_.get(j)); 
    j = i;
    if (!this.version_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(4, getVersion()); 
    byte b2 = b1;
    i = j;
    if (this.sourceContext_ != null) {
      i = j + CodedOutputStream.computeMessageSize(5, getSourceContext());
      b2 = b1;
    } 
    while (b2 < this.mixins_.size()) {
      i += CodedOutputStream.computeMessageSize(6, this.mixins_.get(b2));
      b2++;
    } 
    j = i;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      j = i + CodedOutputStream.computeEnumSize(7, this.syntax_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public SourceContext getSourceContext() {
    SourceContext sourceContext1 = this.sourceContext_;
    SourceContext sourceContext2 = sourceContext1;
    if (sourceContext1 == null)
      sourceContext2 = SourceContext.getDefaultInstance(); 
    return sourceContext2;
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
  
  public String getVersion() {
    return this.version_;
  }
  
  public ByteString getVersionBytes() {
    return ByteString.copyFromUtf8(this.version_);
  }
  
  public boolean hasSourceContext() {
    boolean bool;
    if (this.sourceContext_ != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    boolean bool = false;
    byte b;
    for (b = 0; b < this.methods_.size(); b++)
      paramCodedOutputStream.writeMessage(2, this.methods_.get(b)); 
    for (b = 0; b < this.options_.size(); b++)
      paramCodedOutputStream.writeMessage(3, this.options_.get(b)); 
    if (!this.version_.isEmpty())
      paramCodedOutputStream.writeString(4, getVersion()); 
    b = bool;
    if (this.sourceContext_ != null) {
      paramCodedOutputStream.writeMessage(5, getSourceContext());
      b = bool;
    } 
    while (b < this.mixins_.size()) {
      paramCodedOutputStream.writeMessage(6, this.mixins_.get(b));
      b++;
    } 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(7, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
    private Builder() {
      super(Api.DEFAULT_INSTANCE);
    }
    
    public Builder addAllMethods(Iterable<? extends Method> param1Iterable) {
      copyOnWrite();
      this.instance.addAllMethods(param1Iterable);
      return this;
    }
    
    public Builder addAllMixins(Iterable<? extends Mixin> param1Iterable) {
      copyOnWrite();
      this.instance.addAllMixins(param1Iterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addMethods(int param1Int, Method.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMethods(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMethods(int param1Int, Method param1Method) {
      copyOnWrite();
      this.instance.addMethods(param1Int, param1Method);
      return this;
    }
    
    public Builder addMethods(Method.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMethods(param1Builder);
      return this;
    }
    
    public Builder addMethods(Method param1Method) {
      copyOnWrite();
      this.instance.addMethods(param1Method);
      return this;
    }
    
    public Builder addMixins(int param1Int, Mixin.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMixins(param1Int, param1Builder);
      return this;
    }
    
    public Builder addMixins(int param1Int, Mixin param1Mixin) {
      copyOnWrite();
      this.instance.addMixins(param1Int, param1Mixin);
      return this;
    }
    
    public Builder addMixins(Mixin.Builder param1Builder) {
      copyOnWrite();
      this.instance.addMixins(param1Builder);
      return this;
    }
    
    public Builder addMixins(Mixin param1Mixin) {
      copyOnWrite();
      this.instance.addMixins(param1Mixin);
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
    
    public Builder clearMethods() {
      copyOnWrite();
      this.instance.clearMethods();
      return this;
    }
    
    public Builder clearMixins() {
      copyOnWrite();
      this.instance.clearMixins();
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
    
    public Builder clearSourceContext() {
      copyOnWrite();
      this.instance.clearSourceContext();
      return this;
    }
    
    public Builder clearSyntax() {
      copyOnWrite();
      this.instance.clearSyntax();
      return this;
    }
    
    public Builder clearVersion() {
      copyOnWrite();
      this.instance.clearVersion();
      return this;
    }
    
    public Method getMethods(int param1Int) {
      return this.instance.getMethods(param1Int);
    }
    
    public int getMethodsCount() {
      return this.instance.getMethodsCount();
    }
    
    public List<Method> getMethodsList() {
      return Collections.unmodifiableList(this.instance.getMethodsList());
    }
    
    public Mixin getMixins(int param1Int) {
      return this.instance.getMixins(param1Int);
    }
    
    public int getMixinsCount() {
      return this.instance.getMixinsCount();
    }
    
    public List<Mixin> getMixinsList() {
      return Collections.unmodifiableList(this.instance.getMixinsList());
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
    
    public SourceContext getSourceContext() {
      return this.instance.getSourceContext();
    }
    
    public Syntax getSyntax() {
      return this.instance.getSyntax();
    }
    
    public int getSyntaxValue() {
      return this.instance.getSyntaxValue();
    }
    
    public String getVersion() {
      return this.instance.getVersion();
    }
    
    public ByteString getVersionBytes() {
      return this.instance.getVersionBytes();
    }
    
    public boolean hasSourceContext() {
      return this.instance.hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.mergeSourceContext(param1SourceContext);
      return this;
    }
    
    public Builder removeMethods(int param1Int) {
      copyOnWrite();
      this.instance.removeMethods(param1Int);
      return this;
    }
    
    public Builder removeMixins(int param1Int) {
      copyOnWrite();
      this.instance.removeMixins(param1Int);
      return this;
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setMethods(int param1Int, Method.Builder param1Builder) {
      copyOnWrite();
      this.instance.setMethods(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMethods(int param1Int, Method param1Method) {
      copyOnWrite();
      this.instance.setMethods(param1Int, param1Method);
      return this;
    }
    
    public Builder setMixins(int param1Int, Mixin.Builder param1Builder) {
      copyOnWrite();
      this.instance.setMixins(param1Int, param1Builder);
      return this;
    }
    
    public Builder setMixins(int param1Int, Mixin param1Mixin) {
      copyOnWrite();
      this.instance.setMixins(param1Int, param1Mixin);
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
    
    public Builder setSourceContext(SourceContext.Builder param1Builder) {
      copyOnWrite();
      this.instance.setSourceContext(param1Builder);
      return this;
    }
    
    public Builder setSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.setSourceContext(param1SourceContext);
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
    
    public Builder setVersion(String param1String) {
      copyOnWrite();
      this.instance.setVersion(param1String);
      return this;
    }
    
    public Builder setVersionBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setVersionBytes(param1ByteString);
      return this;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Api.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */