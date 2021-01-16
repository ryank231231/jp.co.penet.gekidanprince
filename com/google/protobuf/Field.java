package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class Field extends GeneratedMessageLite<Field, Field.Builder> implements FieldOrBuilder {
  public static final int CARDINALITY_FIELD_NUMBER = 2;
  
  private static final Field DEFAULT_INSTANCE = new Field();
  
  public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
  
  public static final int JSON_NAME_FIELD_NUMBER = 10;
  
  public static final int KIND_FIELD_NUMBER = 1;
  
  public static final int NAME_FIELD_NUMBER = 4;
  
  public static final int NUMBER_FIELD_NUMBER = 3;
  
  public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
  
  public static final int OPTIONS_FIELD_NUMBER = 9;
  
  public static final int PACKED_FIELD_NUMBER = 8;
  
  private static volatile Parser<Field> PARSER;
  
  public static final int TYPE_URL_FIELD_NUMBER = 6;
  
  private int bitField0_;
  
  private int cardinality_;
  
  private String defaultValue_ = "";
  
  private String jsonName_ = "";
  
  private int kind_;
  
  private String name_ = "";
  
  private int number_;
  
  private int oneofIndex_;
  
  private Internal.ProtobufList<Option> options_ = emptyProtobufList();
  
  private boolean packed_;
  
  private String typeUrl_ = "";
  
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
  
  private void clearCardinality() {
    this.cardinality_ = 0;
  }
  
  private void clearDefaultValue() {
    this.defaultValue_ = getDefaultInstance().getDefaultValue();
  }
  
  private void clearJsonName() {
    this.jsonName_ = getDefaultInstance().getJsonName();
  }
  
  private void clearKind() {
    this.kind_ = 0;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearNumber() {
    this.number_ = 0;
  }
  
  private void clearOneofIndex() {
    this.oneofIndex_ = 0;
  }
  
  private void clearOptions() {
    this.options_ = emptyProtobufList();
  }
  
  private void clearPacked() {
    this.packed_ = false;
  }
  
  private void clearTypeUrl() {
    this.typeUrl_ = getDefaultInstance().getTypeUrl();
  }
  
  private void ensureOptionsIsMutable() {
    if (!this.options_.isModifiable())
      this.options_ = GeneratedMessageLite.mutableCopy(this.options_); 
  }
  
  public static Field getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Field paramField) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramField);
  }
  
  public static Field parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Field)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Field parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Field)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Field parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Field parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Field parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Field parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Field parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Field>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Field> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeOptions(int paramInt) {
    ensureOptionsIsMutable();
    this.options_.remove(paramInt);
  }
  
  private void setCardinality(Cardinality paramCardinality) {
    if (paramCardinality != null) {
      this.cardinality_ = paramCardinality.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setCardinalityValue(int paramInt) {
    this.cardinality_ = paramInt;
  }
  
  private void setDefaultValue(String paramString) {
    if (paramString != null) {
      this.defaultValue_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDefaultValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.defaultValue_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setJsonName(String paramString) {
    if (paramString != null) {
      this.jsonName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setJsonNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.jsonName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setKind(Kind paramKind) {
    if (paramKind != null) {
      this.kind_ = paramKind.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setKindValue(int paramInt) {
    this.kind_ = paramInt;
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
  
  private void setNumber(int paramInt) {
    this.number_ = paramInt;
  }
  
  private void setOneofIndex(int paramInt) {
    this.oneofIndex_ = paramInt;
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
  
  private void setPacked(boolean paramBoolean) {
    this.packed_ = paramBoolean;
  }
  
  private void setTypeUrl(String paramString) {
    if (paramString != null) {
      this.typeUrl_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTypeUrlBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.typeUrl_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Field$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 946, 2 -> 942, 3 -> 931, 4 -> 922, 5 -> 468, 6 -> 118, 7 -> 464, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/protobuf/Field.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/protobuf/Field
    //   80: monitorenter
    //   81: getstatic com/google/protobuf/Field.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/protobuf/Field.DEFAULT_INSTANCE : Lcom/google/protobuf/Field;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/protobuf/Field.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/protobuf/Field
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/protobuf/Field
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/protobuf/Field.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 464
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: lookupswitch default -> 240, 0 -> 397, 8 -> 386, 16 -> 375, 24 -> 364, 34 -> 353, 50 -> 342, 56 -> 331, 64 -> 320, 74 -> 273, 82 -> 262, 90 -> 251
    //   240: aload_1
    //   241: iload #4
    //   243: invokevirtual skipField : (I)Z
    //   246: istore #7
    //   248: goto -> 403
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   256: putfield defaultValue_ : Ljava/lang/String;
    //   259: goto -> 128
    //   262: aload_0
    //   263: aload_1
    //   264: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   267: putfield jsonName_ : Ljava/lang/String;
    //   270: goto -> 128
    //   273: aload_0
    //   274: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   277: invokeinterface isModifiable : ()Z
    //   282: ifne -> 296
    //   285: aload_0
    //   286: aload_0
    //   287: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   290: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   293: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   296: aload_0
    //   297: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   300: aload_1
    //   301: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   304: aload_2
    //   305: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   308: checkcast com/google/protobuf/Option
    //   311: invokeinterface add : (Ljava/lang/Object;)Z
    //   316: pop
    //   317: goto -> 128
    //   320: aload_0
    //   321: aload_1
    //   322: invokevirtual readBool : ()Z
    //   325: putfield packed_ : Z
    //   328: goto -> 128
    //   331: aload_0
    //   332: aload_1
    //   333: invokevirtual readInt32 : ()I
    //   336: putfield oneofIndex_ : I
    //   339: goto -> 128
    //   342: aload_0
    //   343: aload_1
    //   344: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   347: putfield typeUrl_ : Ljava/lang/String;
    //   350: goto -> 128
    //   353: aload_0
    //   354: aload_1
    //   355: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   358: putfield name_ : Ljava/lang/String;
    //   361: goto -> 128
    //   364: aload_0
    //   365: aload_1
    //   366: invokevirtual readInt32 : ()I
    //   369: putfield number_ : I
    //   372: goto -> 128
    //   375: aload_0
    //   376: aload_1
    //   377: invokevirtual readEnum : ()I
    //   380: putfield cardinality_ : I
    //   383: goto -> 128
    //   386: aload_0
    //   387: aload_1
    //   388: invokevirtual readEnum : ()I
    //   391: putfield kind_ : I
    //   394: goto -> 128
    //   397: iconst_1
    //   398: istore #6
    //   400: goto -> 128
    //   403: iload #7
    //   405: ifne -> 128
    //   408: iconst_1
    //   409: istore #6
    //   411: goto -> 128
    //   414: astore_1
    //   415: goto -> 462
    //   418: astore_1
    //   419: new java/lang/RuntimeException
    //   422: astore_2
    //   423: new com/google/protobuf/InvalidProtocolBufferException
    //   426: astore_3
    //   427: aload_3
    //   428: aload_1
    //   429: invokevirtual getMessage : ()Ljava/lang/String;
    //   432: invokespecial <init> : (Ljava/lang/String;)V
    //   435: aload_2
    //   436: aload_3
    //   437: aload_0
    //   438: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   441: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   444: aload_2
    //   445: athrow
    //   446: astore_1
    //   447: new java/lang/RuntimeException
    //   450: astore_2
    //   451: aload_2
    //   452: aload_1
    //   453: aload_0
    //   454: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   457: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   460: aload_2
    //   461: athrow
    //   462: aload_1
    //   463: athrow
    //   464: getstatic com/google/protobuf/Field.DEFAULT_INSTANCE : Lcom/google/protobuf/Field;
    //   467: areturn
    //   468: aload_2
    //   469: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   472: astore_1
    //   473: aload_3
    //   474: checkcast com/google/protobuf/Field
    //   477: astore_2
    //   478: aload_0
    //   479: getfield kind_ : I
    //   482: ifeq -> 491
    //   485: iconst_1
    //   486: istore #7
    //   488: goto -> 494
    //   491: iconst_0
    //   492: istore #7
    //   494: aload_0
    //   495: getfield kind_ : I
    //   498: istore #6
    //   500: aload_2
    //   501: getfield kind_ : I
    //   504: ifeq -> 513
    //   507: iconst_1
    //   508: istore #8
    //   510: goto -> 516
    //   513: iconst_0
    //   514: istore #8
    //   516: aload_0
    //   517: aload_1
    //   518: iload #7
    //   520: iload #6
    //   522: iload #8
    //   524: aload_2
    //   525: getfield kind_ : I
    //   528: invokeinterface visitInt : (ZIZI)I
    //   533: putfield kind_ : I
    //   536: aload_0
    //   537: getfield cardinality_ : I
    //   540: ifeq -> 549
    //   543: iconst_1
    //   544: istore #7
    //   546: goto -> 552
    //   549: iconst_0
    //   550: istore #7
    //   552: aload_0
    //   553: getfield cardinality_ : I
    //   556: istore #6
    //   558: aload_2
    //   559: getfield cardinality_ : I
    //   562: ifeq -> 571
    //   565: iconst_1
    //   566: istore #8
    //   568: goto -> 574
    //   571: iconst_0
    //   572: istore #8
    //   574: aload_0
    //   575: aload_1
    //   576: iload #7
    //   578: iload #6
    //   580: iload #8
    //   582: aload_2
    //   583: getfield cardinality_ : I
    //   586: invokeinterface visitInt : (ZIZI)I
    //   591: putfield cardinality_ : I
    //   594: aload_0
    //   595: getfield number_ : I
    //   598: ifeq -> 607
    //   601: iconst_1
    //   602: istore #7
    //   604: goto -> 610
    //   607: iconst_0
    //   608: istore #7
    //   610: aload_0
    //   611: getfield number_ : I
    //   614: istore #6
    //   616: aload_2
    //   617: getfield number_ : I
    //   620: ifeq -> 629
    //   623: iconst_1
    //   624: istore #8
    //   626: goto -> 632
    //   629: iconst_0
    //   630: istore #8
    //   632: aload_0
    //   633: aload_1
    //   634: iload #7
    //   636: iload #6
    //   638: iload #8
    //   640: aload_2
    //   641: getfield number_ : I
    //   644: invokeinterface visitInt : (ZIZI)I
    //   649: putfield number_ : I
    //   652: aload_0
    //   653: aload_1
    //   654: aload_0
    //   655: getfield name_ : Ljava/lang/String;
    //   658: invokevirtual isEmpty : ()Z
    //   661: iconst_1
    //   662: ixor
    //   663: aload_0
    //   664: getfield name_ : Ljava/lang/String;
    //   667: aload_2
    //   668: getfield name_ : Ljava/lang/String;
    //   671: invokevirtual isEmpty : ()Z
    //   674: iconst_1
    //   675: ixor
    //   676: aload_2
    //   677: getfield name_ : Ljava/lang/String;
    //   680: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   685: putfield name_ : Ljava/lang/String;
    //   688: aload_0
    //   689: aload_1
    //   690: aload_0
    //   691: getfield typeUrl_ : Ljava/lang/String;
    //   694: invokevirtual isEmpty : ()Z
    //   697: iconst_1
    //   698: ixor
    //   699: aload_0
    //   700: getfield typeUrl_ : Ljava/lang/String;
    //   703: aload_2
    //   704: getfield typeUrl_ : Ljava/lang/String;
    //   707: invokevirtual isEmpty : ()Z
    //   710: iconst_1
    //   711: ixor
    //   712: aload_2
    //   713: getfield typeUrl_ : Ljava/lang/String;
    //   716: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   721: putfield typeUrl_ : Ljava/lang/String;
    //   724: aload_0
    //   725: getfield oneofIndex_ : I
    //   728: ifeq -> 737
    //   731: iconst_1
    //   732: istore #7
    //   734: goto -> 740
    //   737: iconst_0
    //   738: istore #7
    //   740: aload_0
    //   741: getfield oneofIndex_ : I
    //   744: istore #6
    //   746: iload #5
    //   748: istore #8
    //   750: aload_2
    //   751: getfield oneofIndex_ : I
    //   754: ifeq -> 760
    //   757: iconst_1
    //   758: istore #8
    //   760: aload_0
    //   761: aload_1
    //   762: iload #7
    //   764: iload #6
    //   766: iload #8
    //   768: aload_2
    //   769: getfield oneofIndex_ : I
    //   772: invokeinterface visitInt : (ZIZI)I
    //   777: putfield oneofIndex_ : I
    //   780: aload_0
    //   781: getfield packed_ : Z
    //   784: istore #8
    //   786: aload_2
    //   787: getfield packed_ : Z
    //   790: istore #7
    //   792: aload_0
    //   793: aload_1
    //   794: iload #8
    //   796: iload #8
    //   798: iload #7
    //   800: iload #7
    //   802: invokeinterface visitBoolean : (ZZZZ)Z
    //   807: putfield packed_ : Z
    //   810: aload_0
    //   811: aload_1
    //   812: aload_0
    //   813: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   816: aload_2
    //   817: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   820: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   825: putfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   828: aload_0
    //   829: aload_1
    //   830: aload_0
    //   831: getfield jsonName_ : Ljava/lang/String;
    //   834: invokevirtual isEmpty : ()Z
    //   837: iconst_1
    //   838: ixor
    //   839: aload_0
    //   840: getfield jsonName_ : Ljava/lang/String;
    //   843: aload_2
    //   844: getfield jsonName_ : Ljava/lang/String;
    //   847: invokevirtual isEmpty : ()Z
    //   850: iconst_1
    //   851: ixor
    //   852: aload_2
    //   853: getfield jsonName_ : Ljava/lang/String;
    //   856: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   861: putfield jsonName_ : Ljava/lang/String;
    //   864: aload_0
    //   865: aload_1
    //   866: aload_0
    //   867: getfield defaultValue_ : Ljava/lang/String;
    //   870: invokevirtual isEmpty : ()Z
    //   873: iconst_1
    //   874: ixor
    //   875: aload_0
    //   876: getfield defaultValue_ : Ljava/lang/String;
    //   879: aload_2
    //   880: getfield defaultValue_ : Ljava/lang/String;
    //   883: invokevirtual isEmpty : ()Z
    //   886: iconst_1
    //   887: ixor
    //   888: aload_2
    //   889: getfield defaultValue_ : Ljava/lang/String;
    //   892: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   897: putfield defaultValue_ : Ljava/lang/String;
    //   900: aload_1
    //   901: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   904: if_acmpne -> 920
    //   907: aload_0
    //   908: aload_0
    //   909: getfield bitField0_ : I
    //   912: aload_2
    //   913: getfield bitField0_ : I
    //   916: ior
    //   917: putfield bitField0_ : I
    //   920: aload_0
    //   921: areturn
    //   922: new com/google/protobuf/Field$Builder
    //   925: dup
    //   926: aconst_null
    //   927: invokespecial <init> : (Lcom/google/protobuf/Field$1;)V
    //   930: areturn
    //   931: aload_0
    //   932: getfield options_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   935: invokeinterface makeImmutable : ()V
    //   940: aconst_null
    //   941: areturn
    //   942: getstatic com/google/protobuf/Field.DEFAULT_INSTANCE : Lcom/google/protobuf/Field;
    //   945: areturn
    //   946: new com/google/protobuf/Field
    //   949: dup
    //   950: invokespecial <init> : ()V
    //   953: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	446	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	418	java/io/IOException
    //   133	139	414	finally
    //   240	248	446	com/google/protobuf/InvalidProtocolBufferException
    //   240	248	418	java/io/IOException
    //   240	248	414	finally
    //   251	259	446	com/google/protobuf/InvalidProtocolBufferException
    //   251	259	418	java/io/IOException
    //   251	259	414	finally
    //   262	270	446	com/google/protobuf/InvalidProtocolBufferException
    //   262	270	418	java/io/IOException
    //   262	270	414	finally
    //   273	296	446	com/google/protobuf/InvalidProtocolBufferException
    //   273	296	418	java/io/IOException
    //   273	296	414	finally
    //   296	317	446	com/google/protobuf/InvalidProtocolBufferException
    //   296	317	418	java/io/IOException
    //   296	317	414	finally
    //   320	328	446	com/google/protobuf/InvalidProtocolBufferException
    //   320	328	418	java/io/IOException
    //   320	328	414	finally
    //   331	339	446	com/google/protobuf/InvalidProtocolBufferException
    //   331	339	418	java/io/IOException
    //   331	339	414	finally
    //   342	350	446	com/google/protobuf/InvalidProtocolBufferException
    //   342	350	418	java/io/IOException
    //   342	350	414	finally
    //   353	361	446	com/google/protobuf/InvalidProtocolBufferException
    //   353	361	418	java/io/IOException
    //   353	361	414	finally
    //   364	372	446	com/google/protobuf/InvalidProtocolBufferException
    //   364	372	418	java/io/IOException
    //   364	372	414	finally
    //   375	383	446	com/google/protobuf/InvalidProtocolBufferException
    //   375	383	418	java/io/IOException
    //   375	383	414	finally
    //   386	394	446	com/google/protobuf/InvalidProtocolBufferException
    //   386	394	418	java/io/IOException
    //   386	394	414	finally
    //   419	446	414	finally
    //   447	462	414	finally
  }
  
  public Cardinality getCardinality() {
    Cardinality cardinality1 = Cardinality.forNumber(this.cardinality_);
    Cardinality cardinality2 = cardinality1;
    if (cardinality1 == null)
      cardinality2 = Cardinality.UNRECOGNIZED; 
    return cardinality2;
  }
  
  public int getCardinalityValue() {
    return this.cardinality_;
  }
  
  public String getDefaultValue() {
    return this.defaultValue_;
  }
  
  public ByteString getDefaultValueBytes() {
    return ByteString.copyFromUtf8(this.defaultValue_);
  }
  
  public String getJsonName() {
    return this.jsonName_;
  }
  
  public ByteString getJsonNameBytes() {
    return ByteString.copyFromUtf8(this.jsonName_);
  }
  
  public Kind getKind() {
    Kind kind1 = Kind.forNumber(this.kind_);
    Kind kind2 = kind1;
    if (kind1 == null)
      kind2 = Kind.UNRECOGNIZED; 
    return kind2;
  }
  
  public int getKindValue() {
    return this.kind_;
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getNumber() {
    return this.number_;
  }
  
  public int getOneofIndex() {
    return this.oneofIndex_;
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
  
  public boolean getPacked() {
    return this.packed_;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = this.kind_;
    i = Kind.TYPE_UNKNOWN.getNumber();
    boolean bool = false;
    if (j != i) {
      j = CodedOutputStream.computeEnumSize(1, this.kind_) + 0;
    } else {
      j = 0;
    } 
    i = j;
    if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber())
      i = j + CodedOutputStream.computeEnumSize(2, this.cardinality_); 
    int k = this.number_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(3, k); 
    k = j;
    if (!this.name_.isEmpty())
      k = j + CodedOutputStream.computeStringSize(4, getName()); 
    i = k;
    if (!this.typeUrl_.isEmpty())
      i = k + CodedOutputStream.computeStringSize(6, getTypeUrl()); 
    k = this.oneofIndex_;
    j = i;
    if (k != 0)
      j = i + CodedOutputStream.computeInt32Size(7, k); 
    boolean bool1 = this.packed_;
    i = j;
    k = bool;
    if (bool1) {
      i = j + CodedOutputStream.computeBoolSize(8, bool1);
      k = bool;
    } 
    while (k < this.options_.size()) {
      i += CodedOutputStream.computeMessageSize(9, this.options_.get(k));
      k++;
    } 
    j = i;
    if (!this.jsonName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(10, getJsonName()); 
    i = j;
    if (!this.defaultValue_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(11, getDefaultValue()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getTypeUrl() {
    return this.typeUrl_;
  }
  
  public ByteString getTypeUrlBytes() {
    return ByteString.copyFromUtf8(this.typeUrl_);
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.kind_ != Kind.TYPE_UNKNOWN.getNumber())
      paramCodedOutputStream.writeEnum(1, this.kind_); 
    if (this.cardinality_ != Cardinality.CARDINALITY_UNKNOWN.getNumber())
      paramCodedOutputStream.writeEnum(2, this.cardinality_); 
    int i = this.number_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(3, i); 
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(4, getName()); 
    if (!this.typeUrl_.isEmpty())
      paramCodedOutputStream.writeString(6, getTypeUrl()); 
    i = this.oneofIndex_;
    if (i != 0)
      paramCodedOutputStream.writeInt32(7, i); 
    boolean bool = this.packed_;
    if (bool)
      paramCodedOutputStream.writeBool(8, bool); 
    for (i = 0; i < this.options_.size(); i++)
      paramCodedOutputStream.writeMessage(9, this.options_.get(i)); 
    if (!this.jsonName_.isEmpty())
      paramCodedOutputStream.writeString(10, getJsonName()); 
    if (!this.defaultValue_.isEmpty())
      paramCodedOutputStream.writeString(11, getDefaultValue()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Field, Builder> implements FieldOrBuilder {
    private Builder() {
      super(Field.DEFAULT_INSTANCE);
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
    
    public Builder clearCardinality() {
      copyOnWrite();
      this.instance.clearCardinality();
      return this;
    }
    
    public Builder clearDefaultValue() {
      copyOnWrite();
      this.instance.clearDefaultValue();
      return this;
    }
    
    public Builder clearJsonName() {
      copyOnWrite();
      this.instance.clearJsonName();
      return this;
    }
    
    public Builder clearKind() {
      copyOnWrite();
      this.instance.clearKind();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      this.instance.clearName();
      return this;
    }
    
    public Builder clearNumber() {
      copyOnWrite();
      this.instance.clearNumber();
      return this;
    }
    
    public Builder clearOneofIndex() {
      copyOnWrite();
      this.instance.clearOneofIndex();
      return this;
    }
    
    public Builder clearOptions() {
      copyOnWrite();
      this.instance.clearOptions();
      return this;
    }
    
    public Builder clearPacked() {
      copyOnWrite();
      this.instance.clearPacked();
      return this;
    }
    
    public Builder clearTypeUrl() {
      copyOnWrite();
      this.instance.clearTypeUrl();
      return this;
    }
    
    public Field.Cardinality getCardinality() {
      return this.instance.getCardinality();
    }
    
    public int getCardinalityValue() {
      return this.instance.getCardinalityValue();
    }
    
    public String getDefaultValue() {
      return this.instance.getDefaultValue();
    }
    
    public ByteString getDefaultValueBytes() {
      return this.instance.getDefaultValueBytes();
    }
    
    public String getJsonName() {
      return this.instance.getJsonName();
    }
    
    public ByteString getJsonNameBytes() {
      return this.instance.getJsonNameBytes();
    }
    
    public Field.Kind getKind() {
      return this.instance.getKind();
    }
    
    public int getKindValue() {
      return this.instance.getKindValue();
    }
    
    public String getName() {
      return this.instance.getName();
    }
    
    public ByteString getNameBytes() {
      return this.instance.getNameBytes();
    }
    
    public int getNumber() {
      return this.instance.getNumber();
    }
    
    public int getOneofIndex() {
      return this.instance.getOneofIndex();
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
    
    public boolean getPacked() {
      return this.instance.getPacked();
    }
    
    public String getTypeUrl() {
      return this.instance.getTypeUrl();
    }
    
    public ByteString getTypeUrlBytes() {
      return this.instance.getTypeUrlBytes();
    }
    
    public Builder removeOptions(int param1Int) {
      copyOnWrite();
      this.instance.removeOptions(param1Int);
      return this;
    }
    
    public Builder setCardinality(Field.Cardinality param1Cardinality) {
      copyOnWrite();
      this.instance.setCardinality(param1Cardinality);
      return this;
    }
    
    public Builder setCardinalityValue(int param1Int) {
      copyOnWrite();
      this.instance.setCardinalityValue(param1Int);
      return this;
    }
    
    public Builder setDefaultValue(String param1String) {
      copyOnWrite();
      this.instance.setDefaultValue(param1String);
      return this;
    }
    
    public Builder setDefaultValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setDefaultValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setJsonName(String param1String) {
      copyOnWrite();
      this.instance.setJsonName(param1String);
      return this;
    }
    
    public Builder setJsonNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setJsonNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setKind(Field.Kind param1Kind) {
      copyOnWrite();
      this.instance.setKind(param1Kind);
      return this;
    }
    
    public Builder setKindValue(int param1Int) {
      copyOnWrite();
      this.instance.setKindValue(param1Int);
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
    
    public Builder setNumber(int param1Int) {
      copyOnWrite();
      this.instance.setNumber(param1Int);
      return this;
    }
    
    public Builder setOneofIndex(int param1Int) {
      copyOnWrite();
      this.instance.setOneofIndex(param1Int);
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
    
    public Builder setPacked(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setPacked(param1Boolean);
      return this;
    }
    
    public Builder setTypeUrl(String param1String) {
      copyOnWrite();
      this.instance.setTypeUrl(param1String);
      return this;
    }
    
    public Builder setTypeUrlBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setTypeUrlBytes(param1ByteString);
      return this;
    }
  }
  
  public enum Cardinality implements Internal.EnumLite {
    CARDINALITY_OPTIONAL,
    CARDINALITY_REPEATED,
    CARDINALITY_REQUIRED,
    CARDINALITY_UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    
    public static final int CARDINALITY_UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Cardinality> internalValueMap;
    
    private final int value;
    
    static {
      CARDINALITY_REPEATED = new Cardinality("CARDINALITY_REPEATED", 3, 3);
      UNRECOGNIZED = new Cardinality("UNRECOGNIZED", 4, -1);
      $VALUES = new Cardinality[] { CARDINALITY_UNKNOWN, CARDINALITY_OPTIONAL, CARDINALITY_REQUIRED, CARDINALITY_REPEATED, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Cardinality>() {
          public Field.Cardinality findValueByNumber(int param2Int) {
            return Field.Cardinality.forNumber(param2Int);
          }
        };
    }
    
    Cardinality(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Cardinality forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 3:
          return CARDINALITY_REPEATED;
        case 2:
          return CARDINALITY_REQUIRED;
        case 1:
          return CARDINALITY_OPTIONAL;
        case 0:
          break;
      } 
      return CARDINALITY_UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<Cardinality> {
    public Field.Cardinality findValueByNumber(int param1Int) {
      return Field.Cardinality.forNumber(param1Int);
    }
  }
  
  public enum Kind implements Internal.EnumLite {
    TYPE_BOOL(0),
    TYPE_BYTES(0),
    TYPE_DOUBLE(0),
    TYPE_ENUM(0),
    TYPE_FIXED32(0),
    TYPE_FIXED64(0),
    TYPE_FLOAT(0),
    TYPE_GROUP(0),
    TYPE_INT32(0),
    TYPE_INT64(0),
    TYPE_MESSAGE(0),
    TYPE_SFIXED32(0),
    TYPE_SFIXED64(0),
    TYPE_SINT32(0),
    TYPE_SINT64(0),
    TYPE_STRING(0),
    TYPE_UINT32(0),
    TYPE_UINT64(0),
    TYPE_UNKNOWN(0),
    UNRECOGNIZED(0);
    
    public static final int TYPE_BOOL_VALUE = 8;
    
    public static final int TYPE_BYTES_VALUE = 12;
    
    public static final int TYPE_DOUBLE_VALUE = 1;
    
    public static final int TYPE_ENUM_VALUE = 14;
    
    public static final int TYPE_FIXED32_VALUE = 7;
    
    public static final int TYPE_FIXED64_VALUE = 6;
    
    public static final int TYPE_FLOAT_VALUE = 2;
    
    public static final int TYPE_GROUP_VALUE = 10;
    
    public static final int TYPE_INT32_VALUE = 5;
    
    public static final int TYPE_INT64_VALUE = 3;
    
    public static final int TYPE_MESSAGE_VALUE = 11;
    
    public static final int TYPE_SFIXED32_VALUE = 15;
    
    public static final int TYPE_SFIXED64_VALUE = 16;
    
    public static final int TYPE_SINT32_VALUE = 17;
    
    public static final int TYPE_SINT64_VALUE = 18;
    
    public static final int TYPE_STRING_VALUE = 9;
    
    public static final int TYPE_UINT32_VALUE = 13;
    
    public static final int TYPE_UINT64_VALUE = 4;
    
    public static final int TYPE_UNKNOWN_VALUE = 0;
    
    private static final Internal.EnumLiteMap<Kind> internalValueMap;
    
    private final int value;
    
    static {
      TYPE_INT32 = new Kind("TYPE_INT32", 5, 5);
      TYPE_FIXED64 = new Kind("TYPE_FIXED64", 6, 6);
      TYPE_FIXED32 = new Kind("TYPE_FIXED32", 7, 7);
      TYPE_BOOL = new Kind("TYPE_BOOL", 8, 8);
      TYPE_STRING = new Kind("TYPE_STRING", 9, 9);
      TYPE_GROUP = new Kind("TYPE_GROUP", 10, 10);
      TYPE_MESSAGE = new Kind("TYPE_MESSAGE", 11, 11);
      TYPE_BYTES = new Kind("TYPE_BYTES", 12, 12);
      TYPE_UINT32 = new Kind("TYPE_UINT32", 13, 13);
      TYPE_ENUM = new Kind("TYPE_ENUM", 14, 14);
      TYPE_SFIXED32 = new Kind("TYPE_SFIXED32", 15, 15);
      TYPE_SFIXED64 = new Kind("TYPE_SFIXED64", 16, 16);
      TYPE_SINT32 = new Kind("TYPE_SINT32", 17, 17);
      TYPE_SINT64 = new Kind("TYPE_SINT64", 18, 18);
      UNRECOGNIZED = new Kind("UNRECOGNIZED", 19, -1);
      $VALUES = new Kind[] { 
          TYPE_UNKNOWN, TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, 
          TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<Kind>() {
          public Field.Kind findValueByNumber(int param2Int) {
            return Field.Kind.forNumber(param2Int);
          }
        };
    }
    
    Kind(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static Kind forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 18:
          return TYPE_SINT64;
        case 17:
          return TYPE_SINT32;
        case 16:
          return TYPE_SFIXED64;
        case 15:
          return TYPE_SFIXED32;
        case 14:
          return TYPE_ENUM;
        case 13:
          return TYPE_UINT32;
        case 12:
          return TYPE_BYTES;
        case 11:
          return TYPE_MESSAGE;
        case 10:
          return TYPE_GROUP;
        case 9:
          return TYPE_STRING;
        case 8:
          return TYPE_BOOL;
        case 7:
          return TYPE_FIXED32;
        case 6:
          return TYPE_FIXED64;
        case 5:
          return TYPE_INT32;
        case 4:
          return TYPE_UINT64;
        case 3:
          return TYPE_INT64;
        case 2:
          return TYPE_FLOAT;
        case 1:
          return TYPE_DOUBLE;
        case 0:
          break;
      } 
      return TYPE_UNKNOWN;
    }
    
    public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<Kind> {
    public Field.Kind findValueByNumber(int param1Int) {
      return Field.Kind.forNumber(param1Int);
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */