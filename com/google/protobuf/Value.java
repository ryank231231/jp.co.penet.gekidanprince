package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public final class Value extends GeneratedMessageLite<Value, Value.Builder> implements ValueOrBuilder {
  public static final int BOOL_VALUE_FIELD_NUMBER = 4;
  
  private static final Value DEFAULT_INSTANCE = new Value();
  
  public static final int LIST_VALUE_FIELD_NUMBER = 6;
  
  public static final int NULL_VALUE_FIELD_NUMBER = 1;
  
  public static final int NUMBER_VALUE_FIELD_NUMBER = 2;
  
  private static volatile Parser<Value> PARSER;
  
  public static final int STRING_VALUE_FIELD_NUMBER = 3;
  
  public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
  
  private int kindCase_ = 0;
  
  private Object kind_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearBoolValue() {
    if (this.kindCase_ == 4) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearKind() {
    this.kindCase_ = 0;
    this.kind_ = null;
  }
  
  private void clearListValue() {
    if (this.kindCase_ == 6) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearNullValue() {
    if (this.kindCase_ == 1) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearNumberValue() {
    if (this.kindCase_ == 2) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearStringValue() {
    if (this.kindCase_ == 3) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  private void clearStructValue() {
    if (this.kindCase_ == 5) {
      this.kindCase_ = 0;
      this.kind_ = null;
    } 
  }
  
  public static Value getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private void mergeListValue(ListValue paramListValue) {
    if (this.kindCase_ == 6 && this.kind_ != ListValue.getDefaultInstance()) {
      this.kind_ = ListValue.newBuilder((ListValue)this.kind_).mergeFrom(paramListValue).buildPartial();
    } else {
      this.kind_ = paramListValue;
    } 
    this.kindCase_ = 6;
  }
  
  private void mergeStructValue(Struct paramStruct) {
    if (this.kindCase_ == 5 && this.kind_ != Struct.getDefaultInstance()) {
      this.kind_ = Struct.newBuilder((Struct)this.kind_).mergeFrom(paramStruct).buildPartial();
    } else {
      this.kind_ = paramStruct;
    } 
    this.kindCase_ = 5;
  }
  
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(Value paramValue) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(paramValue);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Value parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (Value)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static Value parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static Value parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(InputStream paramInputStream) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static Value parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static Value parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static Value parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return GeneratedMessageLite.<Value>parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<Value> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setBoolValue(boolean paramBoolean) {
    this.kindCase_ = 4;
    this.kind_ = Boolean.valueOf(paramBoolean);
  }
  
  private void setListValue(ListValue.Builder paramBuilder) {
    this.kind_ = paramBuilder.build();
    this.kindCase_ = 6;
  }
  
  private void setListValue(ListValue paramListValue) {
    if (paramListValue != null) {
      this.kind_ = paramListValue;
      this.kindCase_ = 6;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNullValue(NullValue paramNullValue) {
    if (paramNullValue != null) {
      this.kindCase_ = 1;
      this.kind_ = Integer.valueOf(paramNullValue.getNumber());
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setNullValueValue(int paramInt) {
    this.kindCase_ = 1;
    this.kind_ = Integer.valueOf(paramInt);
  }
  
  private void setNumberValue(double paramDouble) {
    this.kindCase_ = 2;
    this.kind_ = Double.valueOf(paramDouble);
  }
  
  private void setStringValue(String paramString) {
    if (paramString != null) {
      this.kindCase_ = 3;
      this.kind_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStringValueBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.kindCase_ = 3;
      this.kind_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setStructValue(Struct.Builder paramBuilder) {
    this.kind_ = paramBuilder.build();
    this.kindCase_ = 5;
  }
  
  private void setStructValue(Struct paramStruct) {
    if (paramStruct != null) {
      this.kind_ = paramStruct;
      this.kindCase_ = 5;
      return;
    } 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/protobuf/Value$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iconst_0
    //   17: istore #7
    //   19: iconst_0
    //   20: istore #8
    //   22: iconst_0
    //   23: istore #9
    //   25: iconst_0
    //   26: istore #10
    //   28: iconst_0
    //   29: istore #11
    //   31: iconst_0
    //   32: istore #12
    //   34: iload #4
    //   36: tableswitch default -> 84, 1 -> 859, 2 -> 855, 3 -> 853, 4 -> 844, 5 -> 504, 6 -> 138, 7 -> 500, 8 -> 92
    //   84: new java/lang/UnsupportedOperationException
    //   87: dup
    //   88: invokespecial <init> : ()V
    //   91: athrow
    //   92: getstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   95: ifnonnull -> 134
    //   98: ldc com/google/protobuf/Value
    //   100: monitorenter
    //   101: getstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   104: ifnonnull -> 122
    //   107: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   110: astore_1
    //   111: aload_1
    //   112: getstatic com/google/protobuf/Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Value;
    //   115: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   118: aload_1
    //   119: putstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   122: ldc com/google/protobuf/Value
    //   124: monitorexit
    //   125: goto -> 134
    //   128: astore_1
    //   129: ldc com/google/protobuf/Value
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: getstatic com/google/protobuf/Value.PARSER : Lcom/google/protobuf/Parser;
    //   137: areturn
    //   138: aload_2
    //   139: checkcast com/google/protobuf/CodedInputStream
    //   142: astore_2
    //   143: aload_3
    //   144: checkcast com/google/protobuf/ExtensionRegistryLite
    //   147: astore_3
    //   148: iload #12
    //   150: ifne -> 500
    //   153: aload_2
    //   154: invokevirtual readTag : ()I
    //   157: istore #4
    //   159: iload #4
    //   161: ifeq -> 444
    //   164: iload #4
    //   166: bipush #8
    //   168: if_icmpeq -> 421
    //   171: iload #4
    //   173: bipush #17
    //   175: if_icmpeq -> 402
    //   178: iload #4
    //   180: bipush #26
    //   182: if_icmpeq -> 384
    //   185: iload #4
    //   187: bipush #32
    //   189: if_icmpeq -> 365
    //   192: iload #4
    //   194: bipush #42
    //   196: if_icmpeq -> 294
    //   199: iload #4
    //   201: bipush #50
    //   203: if_icmpeq -> 221
    //   206: aload_2
    //   207: iload #4
    //   209: invokevirtual skipField : (I)Z
    //   212: ifne -> 148
    //   215: iconst_1
    //   216: istore #12
    //   218: goto -> 148
    //   221: aload_0
    //   222: getfield kindCase_ : I
    //   225: bipush #6
    //   227: if_icmpne -> 247
    //   230: aload_0
    //   231: getfield kind_ : Ljava/lang/Object;
    //   234: checkcast com/google/protobuf/ListValue
    //   237: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   240: checkcast com/google/protobuf/ListValue$Builder
    //   243: astore_1
    //   244: goto -> 249
    //   247: aconst_null
    //   248: astore_1
    //   249: aload_0
    //   250: aload_2
    //   251: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   254: aload_3
    //   255: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   258: putfield kind_ : Ljava/lang/Object;
    //   261: aload_1
    //   262: ifnull -> 285
    //   265: aload_1
    //   266: aload_0
    //   267: getfield kind_ : Ljava/lang/Object;
    //   270: checkcast com/google/protobuf/ListValue
    //   273: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   276: pop
    //   277: aload_0
    //   278: aload_1
    //   279: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   282: putfield kind_ : Ljava/lang/Object;
    //   285: aload_0
    //   286: bipush #6
    //   288: putfield kindCase_ : I
    //   291: goto -> 148
    //   294: aload_0
    //   295: getfield kindCase_ : I
    //   298: iconst_5
    //   299: if_icmpne -> 319
    //   302: aload_0
    //   303: getfield kind_ : Ljava/lang/Object;
    //   306: checkcast com/google/protobuf/Struct
    //   309: invokevirtual toBuilder : ()Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   312: checkcast com/google/protobuf/Struct$Builder
    //   315: astore_1
    //   316: goto -> 321
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_0
    //   322: aload_2
    //   323: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   326: aload_3
    //   327: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   330: putfield kind_ : Ljava/lang/Object;
    //   333: aload_1
    //   334: ifnull -> 357
    //   337: aload_1
    //   338: aload_0
    //   339: getfield kind_ : Ljava/lang/Object;
    //   342: checkcast com/google/protobuf/Struct
    //   345: invokevirtual mergeFrom : (Lcom/google/protobuf/GeneratedMessageLite;)Lcom/google/protobuf/GeneratedMessageLite$Builder;
    //   348: pop
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual buildPartial : ()Lcom/google/protobuf/GeneratedMessageLite;
    //   354: putfield kind_ : Ljava/lang/Object;
    //   357: aload_0
    //   358: iconst_5
    //   359: putfield kindCase_ : I
    //   362: goto -> 148
    //   365: aload_0
    //   366: iconst_4
    //   367: putfield kindCase_ : I
    //   370: aload_0
    //   371: aload_2
    //   372: invokevirtual readBool : ()Z
    //   375: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   378: putfield kind_ : Ljava/lang/Object;
    //   381: goto -> 148
    //   384: aload_2
    //   385: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   388: astore_1
    //   389: aload_0
    //   390: iconst_3
    //   391: putfield kindCase_ : I
    //   394: aload_0
    //   395: aload_1
    //   396: putfield kind_ : Ljava/lang/Object;
    //   399: goto -> 148
    //   402: aload_0
    //   403: iconst_2
    //   404: putfield kindCase_ : I
    //   407: aload_0
    //   408: aload_2
    //   409: invokevirtual readDouble : ()D
    //   412: invokestatic valueOf : (D)Ljava/lang/Double;
    //   415: putfield kind_ : Ljava/lang/Object;
    //   418: goto -> 148
    //   421: aload_2
    //   422: invokevirtual readEnum : ()I
    //   425: istore #4
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield kindCase_ : I
    //   432: aload_0
    //   433: iload #4
    //   435: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   438: putfield kind_ : Ljava/lang/Object;
    //   441: goto -> 148
    //   444: iconst_1
    //   445: istore #12
    //   447: goto -> 148
    //   450: astore_1
    //   451: goto -> 498
    //   454: astore_1
    //   455: new java/lang/RuntimeException
    //   458: astore_2
    //   459: new com/google/protobuf/InvalidProtocolBufferException
    //   462: astore_3
    //   463: aload_3
    //   464: aload_1
    //   465: invokevirtual getMessage : ()Ljava/lang/String;
    //   468: invokespecial <init> : (Ljava/lang/String;)V
    //   471: aload_2
    //   472: aload_3
    //   473: aload_0
    //   474: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   477: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   480: aload_2
    //   481: athrow
    //   482: astore_1
    //   483: new java/lang/RuntimeException
    //   486: astore_2
    //   487: aload_2
    //   488: aload_1
    //   489: aload_0
    //   490: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   493: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   496: aload_2
    //   497: athrow
    //   498: aload_1
    //   499: athrow
    //   500: getstatic com/google/protobuf/Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Value;
    //   503: areturn
    //   504: aload_2
    //   505: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   508: astore_1
    //   509: aload_3
    //   510: checkcast com/google/protobuf/Value
    //   513: astore_2
    //   514: getstatic com/google/protobuf/Value$1.$SwitchMap$com$google$protobuf$Value$KindCase : [I
    //   517: aload_2
    //   518: invokevirtual getKindCase : ()Lcom/google/protobuf/Value$KindCase;
    //   521: invokevirtual ordinal : ()I
    //   524: iaload
    //   525: tableswitch default -> 568, 1 -> 783, 2 -> 745, 3 -> 707, 4 -> 669, 5 -> 631, 6 -> 592, 7 -> 571
    //   568: goto -> 818
    //   571: aload_0
    //   572: getfield kindCase_ : I
    //   575: ifeq -> 581
    //   578: iconst_1
    //   579: istore #5
    //   581: aload_1
    //   582: iload #5
    //   584: invokeinterface visitOneofNotSet : (Z)V
    //   589: goto -> 818
    //   592: iload #6
    //   594: istore #5
    //   596: aload_0
    //   597: getfield kindCase_ : I
    //   600: bipush #6
    //   602: if_icmpne -> 608
    //   605: iconst_1
    //   606: istore #5
    //   608: aload_0
    //   609: aload_1
    //   610: iload #5
    //   612: aload_0
    //   613: getfield kind_ : Ljava/lang/Object;
    //   616: aload_2
    //   617: getfield kind_ : Ljava/lang/Object;
    //   620: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   625: putfield kind_ : Ljava/lang/Object;
    //   628: goto -> 818
    //   631: iload #7
    //   633: istore #5
    //   635: aload_0
    //   636: getfield kindCase_ : I
    //   639: iconst_5
    //   640: if_icmpne -> 646
    //   643: iconst_1
    //   644: istore #5
    //   646: aload_0
    //   647: aload_1
    //   648: iload #5
    //   650: aload_0
    //   651: getfield kind_ : Ljava/lang/Object;
    //   654: aload_2
    //   655: getfield kind_ : Ljava/lang/Object;
    //   658: invokeinterface visitOneofMessage : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   663: putfield kind_ : Ljava/lang/Object;
    //   666: goto -> 818
    //   669: iload #8
    //   671: istore #5
    //   673: aload_0
    //   674: getfield kindCase_ : I
    //   677: iconst_4
    //   678: if_icmpne -> 684
    //   681: iconst_1
    //   682: istore #5
    //   684: aload_0
    //   685: aload_1
    //   686: iload #5
    //   688: aload_0
    //   689: getfield kind_ : Ljava/lang/Object;
    //   692: aload_2
    //   693: getfield kind_ : Ljava/lang/Object;
    //   696: invokeinterface visitOneofBoolean : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   701: putfield kind_ : Ljava/lang/Object;
    //   704: goto -> 818
    //   707: iload #9
    //   709: istore #5
    //   711: aload_0
    //   712: getfield kindCase_ : I
    //   715: iconst_3
    //   716: if_icmpne -> 722
    //   719: iconst_1
    //   720: istore #5
    //   722: aload_0
    //   723: aload_1
    //   724: iload #5
    //   726: aload_0
    //   727: getfield kind_ : Ljava/lang/Object;
    //   730: aload_2
    //   731: getfield kind_ : Ljava/lang/Object;
    //   734: invokeinterface visitOneofString : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   739: putfield kind_ : Ljava/lang/Object;
    //   742: goto -> 818
    //   745: iload #10
    //   747: istore #5
    //   749: aload_0
    //   750: getfield kindCase_ : I
    //   753: iconst_2
    //   754: if_icmpne -> 760
    //   757: iconst_1
    //   758: istore #5
    //   760: aload_0
    //   761: aload_1
    //   762: iload #5
    //   764: aload_0
    //   765: getfield kind_ : Ljava/lang/Object;
    //   768: aload_2
    //   769: getfield kind_ : Ljava/lang/Object;
    //   772: invokeinterface visitOneofDouble : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   777: putfield kind_ : Ljava/lang/Object;
    //   780: goto -> 818
    //   783: iload #11
    //   785: istore #5
    //   787: aload_0
    //   788: getfield kindCase_ : I
    //   791: iconst_1
    //   792: if_icmpne -> 798
    //   795: iconst_1
    //   796: istore #5
    //   798: aload_0
    //   799: aload_1
    //   800: iload #5
    //   802: aload_0
    //   803: getfield kind_ : Ljava/lang/Object;
    //   806: aload_2
    //   807: getfield kind_ : Ljava/lang/Object;
    //   810: invokeinterface visitOneofInt : (ZLjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   815: putfield kind_ : Ljava/lang/Object;
    //   818: aload_1
    //   819: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   822: if_acmpne -> 842
    //   825: aload_2
    //   826: getfield kindCase_ : I
    //   829: istore #12
    //   831: iload #12
    //   833: ifeq -> 842
    //   836: aload_0
    //   837: iload #12
    //   839: putfield kindCase_ : I
    //   842: aload_0
    //   843: areturn
    //   844: new com/google/protobuf/Value$Builder
    //   847: dup
    //   848: aconst_null
    //   849: invokespecial <init> : (Lcom/google/protobuf/Value$1;)V
    //   852: areturn
    //   853: aconst_null
    //   854: areturn
    //   855: getstatic com/google/protobuf/Value.DEFAULT_INSTANCE : Lcom/google/protobuf/Value;
    //   858: areturn
    //   859: new com/google/protobuf/Value
    //   862: dup
    //   863: invokespecial <init> : ()V
    //   866: areturn
    // Exception table:
    //   from	to	target	type
    //   101	122	128	finally
    //   122	125	128	finally
    //   129	132	128	finally
    //   153	159	482	com/google/protobuf/InvalidProtocolBufferException
    //   153	159	454	java/io/IOException
    //   153	159	450	finally
    //   206	215	482	com/google/protobuf/InvalidProtocolBufferException
    //   206	215	454	java/io/IOException
    //   206	215	450	finally
    //   221	244	482	com/google/protobuf/InvalidProtocolBufferException
    //   221	244	454	java/io/IOException
    //   221	244	450	finally
    //   249	261	482	com/google/protobuf/InvalidProtocolBufferException
    //   249	261	454	java/io/IOException
    //   249	261	450	finally
    //   265	285	482	com/google/protobuf/InvalidProtocolBufferException
    //   265	285	454	java/io/IOException
    //   265	285	450	finally
    //   285	291	482	com/google/protobuf/InvalidProtocolBufferException
    //   285	291	454	java/io/IOException
    //   285	291	450	finally
    //   294	316	482	com/google/protobuf/InvalidProtocolBufferException
    //   294	316	454	java/io/IOException
    //   294	316	450	finally
    //   321	333	482	com/google/protobuf/InvalidProtocolBufferException
    //   321	333	454	java/io/IOException
    //   321	333	450	finally
    //   337	357	482	com/google/protobuf/InvalidProtocolBufferException
    //   337	357	454	java/io/IOException
    //   337	357	450	finally
    //   357	362	482	com/google/protobuf/InvalidProtocolBufferException
    //   357	362	454	java/io/IOException
    //   357	362	450	finally
    //   365	381	482	com/google/protobuf/InvalidProtocolBufferException
    //   365	381	454	java/io/IOException
    //   365	381	450	finally
    //   384	399	482	com/google/protobuf/InvalidProtocolBufferException
    //   384	399	454	java/io/IOException
    //   384	399	450	finally
    //   402	418	482	com/google/protobuf/InvalidProtocolBufferException
    //   402	418	454	java/io/IOException
    //   402	418	450	finally
    //   421	441	482	com/google/protobuf/InvalidProtocolBufferException
    //   421	441	454	java/io/IOException
    //   421	441	450	finally
    //   455	482	450	finally
    //   483	498	450	finally
  }
  
  public boolean getBoolValue() {
    return (this.kindCase_ == 4) ? ((Boolean)this.kind_).booleanValue() : false;
  }
  
  public KindCase getKindCase() {
    return KindCase.forNumber(this.kindCase_);
  }
  
  public ListValue getListValue() {
    return (this.kindCase_ == 6) ? (ListValue)this.kind_ : ListValue.getDefaultInstance();
  }
  
  public NullValue getNullValue() {
    if (this.kindCase_ == 1) {
      NullValue nullValue1 = NullValue.forNumber(((Integer)this.kind_).intValue());
      NullValue nullValue2 = nullValue1;
      if (nullValue1 == null)
        nullValue2 = NullValue.UNRECOGNIZED; 
      return nullValue2;
    } 
    return NullValue.NULL_VALUE;
  }
  
  public int getNullValueValue() {
    return (this.kindCase_ == 1) ? ((Integer)this.kind_).intValue() : 0;
  }
  
  public double getNumberValue() {
    return (this.kindCase_ == 2) ? ((Double)this.kind_).doubleValue() : 0.0D;
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (this.kindCase_ == 1)
      j = 0 + CodedOutputStream.computeEnumSize(1, ((Integer)this.kind_).intValue()); 
    i = j;
    if (this.kindCase_ == 2)
      i = j + CodedOutputStream.computeDoubleSize(2, ((Double)this.kind_).doubleValue()); 
    j = i;
    if (this.kindCase_ == 3)
      j = i + CodedOutputStream.computeStringSize(3, getStringValue()); 
    int k = j;
    if (this.kindCase_ == 4)
      k = j + CodedOutputStream.computeBoolSize(4, ((Boolean)this.kind_).booleanValue()); 
    i = k;
    if (this.kindCase_ == 5)
      i = k + CodedOutputStream.computeMessageSize(5, (Struct)this.kind_); 
    j = i;
    if (this.kindCase_ == 6)
      j = i + CodedOutputStream.computeMessageSize(6, (ListValue)this.kind_); 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public String getStringValue() {
    String str = "";
    if (this.kindCase_ == 3)
      str = (String)this.kind_; 
    return str;
  }
  
  public ByteString getStringValueBytes() {
    String str = "";
    if (this.kindCase_ == 3)
      str = (String)this.kind_; 
    return ByteString.copyFromUtf8(str);
  }
  
  public Struct getStructValue() {
    return (this.kindCase_ == 5) ? (Struct)this.kind_ : Struct.getDefaultInstance();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (this.kindCase_ == 1)
      paramCodedOutputStream.writeEnum(1, ((Integer)this.kind_).intValue()); 
    if (this.kindCase_ == 2)
      paramCodedOutputStream.writeDouble(2, ((Double)this.kind_).doubleValue()); 
    if (this.kindCase_ == 3)
      paramCodedOutputStream.writeString(3, getStringValue()); 
    if (this.kindCase_ == 4)
      paramCodedOutputStream.writeBool(4, ((Boolean)this.kind_).booleanValue()); 
    if (this.kindCase_ == 5)
      paramCodedOutputStream.writeMessage(5, (Struct)this.kind_); 
    if (this.kindCase_ == 6)
      paramCodedOutputStream.writeMessage(6, (ListValue)this.kind_); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
    private Builder() {
      super(Value.DEFAULT_INSTANCE);
    }
    
    public Builder clearBoolValue() {
      copyOnWrite();
      this.instance.clearBoolValue();
      return this;
    }
    
    public Builder clearKind() {
      copyOnWrite();
      this.instance.clearKind();
      return this;
    }
    
    public Builder clearListValue() {
      copyOnWrite();
      this.instance.clearListValue();
      return this;
    }
    
    public Builder clearNullValue() {
      copyOnWrite();
      this.instance.clearNullValue();
      return this;
    }
    
    public Builder clearNumberValue() {
      copyOnWrite();
      this.instance.clearNumberValue();
      return this;
    }
    
    public Builder clearStringValue() {
      copyOnWrite();
      this.instance.clearStringValue();
      return this;
    }
    
    public Builder clearStructValue() {
      copyOnWrite();
      this.instance.clearStructValue();
      return this;
    }
    
    public boolean getBoolValue() {
      return this.instance.getBoolValue();
    }
    
    public Value.KindCase getKindCase() {
      return this.instance.getKindCase();
    }
    
    public ListValue getListValue() {
      return this.instance.getListValue();
    }
    
    public NullValue getNullValue() {
      return this.instance.getNullValue();
    }
    
    public int getNullValueValue() {
      return this.instance.getNullValueValue();
    }
    
    public double getNumberValue() {
      return this.instance.getNumberValue();
    }
    
    public String getStringValue() {
      return this.instance.getStringValue();
    }
    
    public ByteString getStringValueBytes() {
      return this.instance.getStringValueBytes();
    }
    
    public Struct getStructValue() {
      return this.instance.getStructValue();
    }
    
    public Builder mergeListValue(ListValue param1ListValue) {
      copyOnWrite();
      this.instance.mergeListValue(param1ListValue);
      return this;
    }
    
    public Builder mergeStructValue(Struct param1Struct) {
      copyOnWrite();
      this.instance.mergeStructValue(param1Struct);
      return this;
    }
    
    public Builder setBoolValue(boolean param1Boolean) {
      copyOnWrite();
      this.instance.setBoolValue(param1Boolean);
      return this;
    }
    
    public Builder setListValue(ListValue.Builder param1Builder) {
      copyOnWrite();
      this.instance.setListValue(param1Builder);
      return this;
    }
    
    public Builder setListValue(ListValue param1ListValue) {
      copyOnWrite();
      this.instance.setListValue(param1ListValue);
      return this;
    }
    
    public Builder setNullValue(NullValue param1NullValue) {
      copyOnWrite();
      this.instance.setNullValue(param1NullValue);
      return this;
    }
    
    public Builder setNullValueValue(int param1Int) {
      copyOnWrite();
      this.instance.setNullValueValue(param1Int);
      return this;
    }
    
    public Builder setNumberValue(double param1Double) {
      copyOnWrite();
      this.instance.setNumberValue(param1Double);
      return this;
    }
    
    public Builder setStringValue(String param1String) {
      copyOnWrite();
      this.instance.setStringValue(param1String);
      return this;
    }
    
    public Builder setStringValueBytes(ByteString param1ByteString) {
      copyOnWrite();
      this.instance.setStringValueBytes(param1ByteString);
      return this;
    }
    
    public Builder setStructValue(Struct.Builder param1Builder) {
      copyOnWrite();
      this.instance.setStructValue(param1Builder);
      return this;
    }
    
    public Builder setStructValue(Struct param1Struct) {
      copyOnWrite();
      this.instance.setStructValue(param1Struct);
      return this;
    }
  }
  
  public enum KindCase implements Internal.EnumLite {
    BOOL_VALUE,
    KIND_NOT_SET,
    LIST_VALUE,
    NULL_VALUE(1),
    NUMBER_VALUE(2),
    STRING_VALUE(3),
    STRUCT_VALUE(3);
    
    private final int value;
    
    static {
      LIST_VALUE = new KindCase("LIST_VALUE", 5, 6);
      KIND_NOT_SET = new KindCase("KIND_NOT_SET", 6, 0);
      $VALUES = new KindCase[] { NULL_VALUE, NUMBER_VALUE, STRING_VALUE, BOOL_VALUE, STRUCT_VALUE, LIST_VALUE, KIND_NOT_SET };
    }
    
    KindCase(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static KindCase forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return LIST_VALUE;
        case 5:
          return STRUCT_VALUE;
        case 4:
          return BOOL_VALUE;
        case 3:
          return STRING_VALUE;
        case 2:
          return NUMBER_VALUE;
        case 1:
          return NULL_VALUE;
        case 0:
          break;
      } 
      return KIND_NOT_SET;
    }
    
    public int getNumber() {
      return this.value;
    }
  }
}


/* Location:              Y:\classes2-dex2jar.jar!\com\google\protobuf\Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */