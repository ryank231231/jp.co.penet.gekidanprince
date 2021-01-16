package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Type extends GeneratedMessageLite<Type, Type.Builder> implements TypeOrBuilder {
  private static final Type DEFAULT_INSTANCE = new Type();
  
  public static final int FIELDS_FIELD_NUMBER = 2;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  public static final int ONEOFS_FIELD_NUMBER = 3;
  
  public static final int OPTIONS_FIELD_NUMBER = 4;
  
  private static volatile Parser<Type> PARSER;
  
  public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
  
  public static final int SYNTAX_FIELD_NUMBER = 6;
  
  private int bitField0_;
  
  private Internal.ProtobufList<Field> fields_ = emptyProtobufList();
  
  private String name_ = "";
  
  private Internal.ProtobufList<String> oneofs_ = GeneratedMessageLite.emptyProtobufList();
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private SourceContext sourceContext_;
  
  private int syntax_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllFields(Iterable<? extends Field> paramIterable) {
    ensureFieldsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.fields_);
  }
  
  private void addAllOneofs(Iterable<String> paramIterable) {
    ensureOneofsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.oneofs_);
  }
  
  private void addAllOptions(Iterable<? extends Option> paramIterable) {
    ensureOptionsIsMutable();
    AbstractMessageLite.addAll(paramIterable, this.options_);
  }
  
  private void addFields(int paramInt, Field.Builder paramBuilder) {
    ensureFieldsIsMutable();
    this.fields_.add(paramInt, paramBuilder.build());
  }
  
  private void addFields(int paramInt, Field paramField) {
    if (paramField != null) {
      ensureFieldsIsMutable();
      this.fields_.add(paramInt, paramField);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addFields(Field.Builder paramBuilder) {
    ensureFieldsIsMutable();
    this.fields_.add(paramBuilder.build());
  }
  
  private void addFields(Field paramField) {
    if (paramField != null) {
      ensureFieldsIsMutable();
      this.fields_.add(paramField);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOneofs(String paramString) {
    if (paramString != null) {
      ensureOneofsIsMutable();
      this.oneofs_.add(paramString);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addOneofsBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      ensureOneofsIsMutable();
      this.oneofs_.add(paramByteString.toStringUtf8());
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
  
  private void clearFields() {
    this.fields_ = emptyProtobufList();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearOneofs() {
    this.oneofs_ = GeneratedMessageLite.emptyProtobufList();
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
  
  private void ensureFieldsIsMutable() {
    if (!this.fields_.isModifiable())
      this.fields_ = GeneratedMessageLite.mutableCopy(this.fields_); 
  }
  
  private void ensureOneofsIsMutable() {
    if (!this.oneofs_.isModifiable())
      this.oneofs_ = GeneratedMessageLite.mutableCopy(this.oneofs_); 
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Type getDefaultInstance() {
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
  
  public static Builder newBuilder(Type paramType) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramType);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Type parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Type)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Type parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Type parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Type parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Type parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Type parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Type>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Type> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeFields(int paramInt) {
    ensureFieldsIsMutable();
    this.fields_.remove(paramInt);
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setFields(int paramInt, Field.Builder paramBuilder) {
    ensureFieldsIsMutable();
    this.fields_.set(paramInt, paramBuilder.build());
  }
  
  private void setFields(int paramInt, Field paramField) {
    if (paramField != null) {
      ensureFieldsIsMutable();
      this.fields_.set(paramInt, paramField);
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
  
  private void setOneofs(int paramInt, String paramString) {
    if (paramString != null) {
      ensureOneofsIsMutable();
      this.oneofs_.set(paramInt, paramString);
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
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Type$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 721, 2 -> 717, 3 -> 688, 4 -> 679, 5 -> 484, 6 -> 118, 7 -> 480, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Type
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Type.DEFAULT_INSTANCE : Lcom/google/protobuf/Type;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Type
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Type
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Type.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_2
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_3
    //   128: iload #6
    //   130: ifne -> 480
    //   133: aload_2
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 424
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 413
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 366
    //   158: iload #4
    //   160: bipush #26
    //   162: if_icmpeq -> 324
    //   165: iload #4
    //   167: bipush #34
    //   169: if_icmpeq -> 277
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 212
    //   179: iload #4
    //   181: bipush #48
    //   183: if_icmpeq -> 201
    //   186: aload_2
    //   187: iload #4
    //   189: invokevirtual skipField : (I)Z
    //   192: ifne -> 128
    //   195: iconst_1
    //   196: istore #6
    //   198: goto -> 128
    //   201: aload_0
    //   202: aload_2
    //   203: invokevirtual readEnum : ()I
    //   206: putfield syntax_ : I
    //   209: goto -> 128
    //   212: aload_0
    //   213: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   216: ifnull -> 233
    //   219: aload_0
    //   220: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   223: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   226: checkcast com/google/protobuf/SourceContext$Builder
    //   229: astore_1
    //   230: goto -> 235
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_0
    //   236: aload_2
    //   237: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   240: aload_3
    //   241: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   244: checkcast com/google/protobuf/SourceContext
    //   247: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   250: aload_1
    //   251: ifnull -> 128
    //   254: aload_1
    //   255: aload_0
    //   256: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   259: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   262: pop
    //   263: aload_0
    //   264: aload_1
    //   265: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   268: checkcast com/google/protobuf/SourceContext
    //   271: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   274: goto -> 128
    //   277: aload_0
    //   278: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   281: invokeinterface isModifiable : ()Z
    //   286: ifne -> 300
    //   289: aload_0
    //   290: aload_0
    //   291: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   294: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   297: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   300: aload_0
    //   301: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   304: aload_2
    //   305: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   308: aload_3
    //   309: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   312: checkcast com/google/protobuf/Option
    //   315: invokeinterface add : (Ljava/lang/Object;)Z
    //   320: pop
    //   321: goto -> 128
    //   324: aload_2
    //   325: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   328: astore_1
    //   329: aload_0
    //   330: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   333: invokeinterface isModifiable : ()Z
    //   338: ifne -> 352
    //   341: aload_0
    //   342: aload_0
    //   343: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   346: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   349: putfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   352: aload_0
    //   353: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   356: aload_1
    //   357: invokeinterface add : (Ljava/lang/Object;)Z
    //   362: pop
    //   363: goto -> 128
    //   366: aload_0
    //   367: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   370: invokeinterface isModifiable : ()Z
    //   375: ifne -> 389
    //   378: aload_0
    //   379: aload_0
    //   380: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   383: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   386: putfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   389: aload_0
    //   390: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   393: aload_2
    //   394: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   397: aload_3
    //   398: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   401: checkcast com/google/protobuf/Field
    //   404: invokeinterface add : (Ljava/lang/Object;)Z
    //   409: pop
    //   410: goto -> 128
    //   413: aload_0
    //   414: aload_2
    //   415: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   418: putfield name_ : Ljava/lang/String;
    //   421: goto -> 128
    //   424: iconst_1
    //   425: istore #6
    //   427: goto -> 128
    //   430: astore_1
    //   431: goto -> 478
    //   434: astore_1
    //   435: new java/lang/RuntimeException
    //   438: astore_3
    //   439: new com/google/protobuf/InvalidProtocolBufferException
    //   442: astore_2
    //   443: aload_2
    //   444: aload_1
    //   445: invokevirtual getMessage : ()Ljava/lang/String;
    //   448: invokespecial <init> : (Ljava/lang/String;)V
    //   451: aload_3
    //   452: aload_2
    //   453: aload_0
    //   454: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   457: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   460: aload_3
    //   461: athrow
    //   462: astore_2
    //   463: new java/lang/RuntimeException
    //   466: astore_1
    //   467: aload_1
    //   468: aload_2
    //   469: aload_0
    //   470: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   473: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   476: aload_1
    //   477: athrow
    //   478: aload_1
    //   479: athrow
    //   480: getstatic com/google/protobuf/Type.DEFAULT_INSTANCE : Lcom/google/protobuf/Type;
    //   483: areturn
    //   484: aload_2
    //   485: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   488: astore_1
    //   489: aload_3
    //   490: checkcast com/google/protobuf/Type
    //   493: astore_2
    //   494: aload_0
    //   495: aload_1
    //   496: aload_0
    //   497: getfield name_ : Ljava/lang/String;
    //   500: invokevirtual isEmpty : ()Z
    //   503: iconst_1
    //   504: ixor
    //   505: aload_0
    //   506: getfield name_ : Ljava/lang/String;
    //   509: aload_2
    //   510: getfield name_ : Ljava/lang/String;
    //   513: invokevirtual isEmpty : ()Z
    //   516: iconst_1
    //   517: ixor
    //   518: aload_2
    //   519: getfield name_ : Ljava/lang/String;
    //   522: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   527: putfield name_ : Ljava/lang/String;
    //   530: aload_0
    //   531: aload_1
    //   532: aload_0
    //   533: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   536: aload_2
    //   537: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   540: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   545: putfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   548: aload_0
    //   549: aload_1
    //   550: aload_0
    //   551: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   554: aload_2
    //   555: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   558: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   563: putfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   566: aload_0
    //   567: aload_1
    //   568: aload_0
    //   569: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   572: aload_2
    //   573: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   576: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   581: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   584: aload_0
    //   585: aload_1
    //   586: aload_0
    //   587: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   590: aload_2
    //   591: getfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   594: invokeinterface visitMessage : (Lcom/google/protobuf/MessageLite;Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/MessageLite;
    //   599: checkcast com/google/protobuf/SourceContext
    //   602: putfield sourceContext_ : Lcom/google/protobuf/SourceContext;
    //   605: aload_0
    //   606: getfield syntax_ : I
    //   609: ifeq -> 618
    //   612: iconst_1
    //   613: istore #7
    //   615: goto -> 621
    //   618: iconst_0
    //   619: istore #7
    //   621: aload_0
    //   622: getfield syntax_ : I
    //   625: istore #6
    //   627: aload_2
    //   628: getfield syntax_ : I
    //   631: ifeq -> 637
    //   634: iconst_1
    //   635: istore #5
    //   637: aload_0
    //   638: aload_1
    //   639: iload #7
    //   641: iload #6
    //   643: iload #5
    //   645: aload_2
    //   646: getfield syntax_ : I
    //   649: invokeinterface visitInt : (ZIZI)I
    //   654: putfield syntax_ : I
    //   657: aload_1
    //   658: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   661: if_acmpne -> 677
    //   664: aload_0
    //   665: aload_0
    //   666: getfield bitField0_ : I
    //   669: aload_2
    //   670: getfield bitField0_ : I
    //   673: ior
    //   674: putfield bitField0_ : I
    //   677: aload_0
    //   678: areturn
    //   679: new com/google/protobuf/Type$Builder
    //   682: dup
    //   683: aconst_null
    //   684: invokespecial <init> : (Lcom/google/protobuf/Type$1;)V
    //   687: areturn
    //   688: aload_0
    //   689: getfield fields_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   692: invokeinterface makeImmutable : ()V
    //   697: aload_0
    //   698: getfield oneofs_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   701: invokeinterface makeImmutable : ()V
    //   706: aload_0
    //   707: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   710: invokeinterface makeImmutable : ()V
    //   715: aconst_null
    //   716: areturn
    //   717: getstatic com/google/protobuf/Type.DEFAULT_INSTANCE : Lcom/google/protobuf/Type;
    //   720: areturn
    //   721: new com/google/protobuf/Type
    //   724: dup
    //   725: invokespecial <init> : ()V
    //   728: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	462	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	434	java/io/IOException
    //   133	139	430	finally
    //   186	195	462	com/google/protobuf/InvalidProtocolBufferException
    //   186	195	434	java/io/IOException
    //   186	195	430	finally
    //   201	209	462	com/google/protobuf/InvalidProtocolBufferException
    //   201	209	434	java/io/IOException
    //   201	209	430	finally
    //   212	230	462	com/google/protobuf/InvalidProtocolBufferException
    //   212	230	434	java/io/IOException
    //   212	230	430	finally
    //   235	250	462	com/google/protobuf/InvalidProtocolBufferException
    //   235	250	434	java/io/IOException
    //   235	250	430	finally
    //   254	274	462	com/google/protobuf/InvalidProtocolBufferException
    //   254	274	434	java/io/IOException
    //   254	274	430	finally
    //   277	300	462	com/google/protobuf/InvalidProtocolBufferException
    //   277	300	434	java/io/IOException
    //   277	300	430	finally
    //   300	321	462	com/google/protobuf/InvalidProtocolBufferException
    //   300	321	434	java/io/IOException
    //   300	321	430	finally
    //   324	352	462	com/google/protobuf/InvalidProtocolBufferException
    //   324	352	434	java/io/IOException
    //   324	352	430	finally
    //   352	363	462	com/google/protobuf/InvalidProtocolBufferException
    //   352	363	434	java/io/IOException
    //   352	363	430	finally
    //   366	389	462	com/google/protobuf/InvalidProtocolBufferException
    //   366	389	434	java/io/IOException
    //   366	389	430	finally
    //   389	410	462	com/google/protobuf/InvalidProtocolBufferException
    //   389	410	434	java/io/IOException
    //   389	410	430	finally
    //   413	421	462	com/google/protobuf/InvalidProtocolBufferException
    //   413	421	434	java/io/IOException
    //   413	421	430	finally
    //   435	462	430	finally
    //   463	478	430	finally
  }
  
  public Field getFields(int paramInt) {
    return this.fields_.get(paramInt);
  }
  
  public int getFieldsCount() {
    return this.fields_.size();
  }
  
  public List<Field> getFieldsList() {
    return this.fields_;
  }
  
  public FieldOrBuilder getFieldsOrBuilder(int paramInt) {
    return this.fields_.get(paramInt);
  }
  
  public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
    return (List)this.fields_;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public String getOneofs(int paramInt) {
    return this.oneofs_.get(paramInt);
  }
  
  public ByteString getOneofsBytes(int paramInt) {
    return ByteString.copyFromUtf8(this.oneofs_.get(paramInt));
  }
  
  public int getOneofsCount() {
    return this.oneofs_.size();
  }
  
  public List<String> getOneofsList() {
    return this.oneofs_;
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
    byte b = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    int j;
    for (j = 0; j < this.fields_.size(); j++)
      i += CodedOutputStream.computeMessageSize(2, this.fields_.get(j)); 
    j = 0;
    int k = 0;
    while (j < this.oneofs_.size()) {
      k += CodedOutputStream.computeStringSizeNoTag(this.oneofs_.get(j));
      j++;
    } 
    i = i + k + getOneofsList().size() * 1;
    for (j = b; j < this.options_.size(); j++)
      i += CodedOutputStream.computeMessageSize(4, this.options_.get(j)); 
    j = i;
    if (this.sourceContext_ != null)
      j = i + CodedOutputStream.computeMessageSize(5, getSourceContext()); 
    i = j;
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      i = j + CodedOutputStream.computeEnumSize(6, this.syntax_); 
    this.memoizedSerializedSize = i;
    return i;
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
    byte b3;
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    byte b1 = 0;
    byte b2;
    for (b2 = 0; b2 < this.fields_.size(); b2++)
      paramCodedOutputStream.writeMessage(2, this.fields_.get(b2)); 
    b2 = 0;
    while (true) {
      b3 = b1;
      if (b2 < this.oneofs_.size()) {
        paramCodedOutputStream.writeString(3, this.oneofs_.get(b2));
        b2++;
        continue;
      } 
      break;
    } 
    while (b3 < this.options_.size()) {
      paramCodedOutputStream.writeMessage(4, this.options_.get(b3));
      b3++;
    } 
    if (this.sourceContext_ != null)
      paramCodedOutputStream.writeMessage(5, getSourceContext()); 
    if (this.syntax_ != Syntax.SYNTAX_PROTO2.getNumber())
      paramCodedOutputStream.writeEnum(6, this.syntax_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Type, Builder> implements TypeOrBuilder {
    private Builder() {
      super(Type.DEFAULT_INSTANCE);
    }
    
    public Builder addAllFields(Iterable<? extends Field> param1Iterable) {
      copyOnWrite();
      this.instance.addAllFields(param1Iterable);
      return this;
    }
    
    public Builder addAllOneofs(Iterable<String> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOneofs(param1Iterable);
      return this;
    }
    
    public Builder addAllOptions(Iterable<? extends Option> param1Iterable) {
      copyOnWrite();
      this.instance.addAllOptions(param1Iterable);
      return this;
    }
    
    public Builder addFields(int param1Int, Field.Builder param1Builder) {
      copyOnWrite();
      this.instance.addFields(param1Int, param1Builder);
      return this;
    }
    
    public Builder addFields(int param1Int, Field param1Field) {
      copyOnWrite();
      this.instance.addFields(param1Int, param1Field);
      return this;
    }
    
    public Builder addFields(Field.Builder param1Builder) {
      copyOnWrite();
      this.instance.addFields(param1Builder);
      return this;
    }
    
    public Builder addFields(Field param1Field) {
      copyOnWrite();
      this.instance.addFields(param1Field);
      return this;
    }
    
    public Builder addOneofs(String param1String) {
      copyOnWrite();
      this.instance.addOneofs(param1String);
      return this;
    }
    
    public Builder addOneofsBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.addOneofsBytes(param1ByteString);
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
    
    public Builder clearFields() {
      copyOnWrite();
      this.instance.clearFields();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearOneofs() {
      copyOnWrite();
      this.instance.clearOneofs();
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
    
    public Field getFields(int param1Int) {
      return this.instance.getFields(param1Int);
    }
    
    public int getFieldsCount() {
      return this.instance.getFieldsCount();
    }
    
    public List<Field> getFieldsList() {
      return Collections.unmodifiableList(this.instance.getFieldsList());
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public String getOneofs(int param1Int) {
      return this.instance.getOneofs(param1Int);
    }
    
    public ByteString getOneofsBytes(int param1Int) {
      return this.instance.getOneofsBytes(param1Int);
    }
    
    public int getOneofsCount() {
      return this.instance.getOneofsCount();
    }
    
    public List<String> getOneofsList() {
      return Collections.unmodifiableList(this.instance.getOneofsList());
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
    
    public boolean hasSourceContext() {
      return this.instance.hasSourceContext();
    }
    
    public Builder mergeSourceContext(SourceContext param1SourceContext) {
      copyOnWrite();
      this.instance.mergeSourceContext(param1SourceContext);
      return this;
    }
    
    public Builder removeFields(int param1Int) {
      copyOnWrite();
      this.instance.removeFields(param1Int);
      return this;
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setFields(int param1Int, Field.Builder param1Builder) {
      copyOnWrite();
      this.instance.setFields(param1Int, param1Builder);
      return this;
    }
    
    public Builder setFields(int param1Int, Field param1Field) {
      copyOnWrite();
      this.instance.setFields(param1Int, param1Field);
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
    
    public Builder setOneofs(int param1Int, String param1String) {
      copyOnWrite();
      this.instance.setOneofs(param1Int, param1String);
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
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */