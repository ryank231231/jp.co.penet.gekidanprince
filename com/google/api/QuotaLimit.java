package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public final class QuotaLimit extends GeneratedMessageLite<QuotaLimit, QuotaLimit.Builder> implements QuotaLimitOrBuilder {
  private static final QuotaLimit DEFAULT_INSTANCE = new QuotaLimit();
  
  public static final int DEFAULT_LIMIT_FIELD_NUMBER = 3;
  
  public static final int DESCRIPTION_FIELD_NUMBER = 2;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 12;
  
  public static final int DURATION_FIELD_NUMBER = 5;
  
  public static final int FREE_TIER_FIELD_NUMBER = 7;
  
  public static final int MAX_LIMIT_FIELD_NUMBER = 4;
  
  public static final int METRIC_FIELD_NUMBER = 8;
  
  public static final int NAME_FIELD_NUMBER = 6;
  
  private static volatile Parser<QuotaLimit> PARSER;
  
  public static final int UNIT_FIELD_NUMBER = 9;
  
  public static final int VALUES_FIELD_NUMBER = 10;
  
  private int bitField0_;
  
  private long defaultLimit_;
  
  private String description_ = "";
  
  private String displayName_ = "";
  
  private String duration_ = "";
  
  private long freeTier_;
  
  private long maxLimit_;
  
  private String metric_ = "";
  
  private String name_ = "";
  
  private String unit_ = "";
  
  private MapFieldLite<String, Long> values_ = MapFieldLite.emptyMapField();
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void clearDefaultLimit() {
    this.defaultLimit_ = 0L;
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearDisplayName() {
    this.displayName_ = getDefaultInstance().getDisplayName();
  }
  
  private void clearDuration() {
    this.duration_ = getDefaultInstance().getDuration();
  }
  
  private void clearFreeTier() {
    this.freeTier_ = 0L;
  }
  
  private void clearMaxLimit() {
    this.maxLimit_ = 0L;
  }
  
  private void clearMetric() {
    this.metric_ = getDefaultInstance().getMetric();
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearUnit() {
    this.unit_ = getDefaultInstance().getUnit();
  }
  
  public static QuotaLimit getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private Map<String, Long> getMutableValuesMap() {
    return (Map<String, Long>)internalGetMutableValues();
  }
  
  private MapFieldLite<String, Long> internalGetMutableValues() {
    if (!this.values_.isMutable())
      this.values_ = this.values_.mutableCopy(); 
    return this.values_;
  }
  
  private MapFieldLite<String, Long> internalGetValues() {
    return this.values_;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(QuotaLimit paramQuotaLimit) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramQuotaLimit);
  }
  
  public static QuotaLimit parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (QuotaLimit)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static QuotaLimit parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaLimit)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static QuotaLimit parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static QuotaLimit parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(InputStream paramInputStream) throws IOException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static QuotaLimit parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static QuotaLimit parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static QuotaLimit parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (QuotaLimit)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<QuotaLimit> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void setDefaultLimit(long paramLong) {
    this.defaultLimit_ = paramLong;
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
  
  private void setDisplayName(String paramString) {
    if (paramString != null) {
      this.displayName_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDisplayNameBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.displayName_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDuration(String paramString) {
    if (paramString != null) {
      this.duration_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setDurationBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.duration_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setFreeTier(long paramLong) {
    this.freeTier_ = paramLong;
  }
  
  private void setMaxLimit(long paramLong) {
    this.maxLimit_ = paramLong;
  }
  
  private void setMetric(String paramString) {
    if (paramString != null) {
      this.metric_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetricBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.metric_ = paramByteString.toStringUtf8();
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
  
  private void setUnit(String paramString) {
    if (paramString != null) {
      this.unit_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setUnitBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.unit_ = paramByteString.toStringUtf8();
      return;
    } 
    throw new NullPointerException();
  }
  
  public boolean containsValues(String paramString) {
    if (paramString != null)
      return internalGetValues().containsKey(paramString); 
    throw new NullPointerException();
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/QuotaLimit$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iload #4
    //   15: tableswitch default -> 60, 1 -> 927, 2 -> 923, 3 -> 914, 4 -> 905, 5 -> 453, 6 -> 114, 7 -> 449, 8 -> 68
    //   60: new java/lang/UnsupportedOperationException
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: athrow
    //   68: getstatic com/google/api/QuotaLimit.PARSER : Lcom/google/protobuf/Parser;
    //   71: ifnonnull -> 110
    //   74: ldc com/google/api/QuotaLimit
    //   76: monitorenter
    //   77: getstatic com/google/api/QuotaLimit.PARSER : Lcom/google/protobuf/Parser;
    //   80: ifnonnull -> 98
    //   83: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   86: astore_1
    //   87: aload_1
    //   88: getstatic com/google/api/QuotaLimit.DEFAULT_INSTANCE : Lcom/google/api/QuotaLimit;
    //   91: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   94: aload_1
    //   95: putstatic com/google/api/QuotaLimit.PARSER : Lcom/google/protobuf/Parser;
    //   98: ldc com/google/api/QuotaLimit
    //   100: monitorexit
    //   101: goto -> 110
    //   104: astore_1
    //   105: ldc com/google/api/QuotaLimit
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: getstatic com/google/api/QuotaLimit.PARSER : Lcom/google/protobuf/Parser;
    //   113: areturn
    //   114: aload_2
    //   115: checkcast com/google/protobuf/CodedInputStream
    //   118: astore_1
    //   119: aload_3
    //   120: checkcast com/google/protobuf/ExtensionRegistryLite
    //   123: astore_2
    //   124: iload #5
    //   126: ifne -> 449
    //   129: aload_1
    //   130: invokevirtual readTag : ()I
    //   133: istore #4
    //   135: iload #4
    //   137: lookupswitch default -> 236, 0 -> 382, 18 -> 371, 24 -> 360, 32 -> 349, 42 -> 338, 50 -> 327, 56 -> 316, 66 -> 305, 74 -> 294, 82 -> 258, 98 -> 247
    //   236: aload_1
    //   237: iload #4
    //   239: invokevirtual skipField : (I)Z
    //   242: istore #6
    //   244: goto -> 388
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   252: putfield displayName_ : Ljava/lang/String;
    //   255: goto -> 124
    //   258: aload_0
    //   259: getfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   262: invokevirtual isMutable : ()Z
    //   265: ifne -> 279
    //   268: aload_0
    //   269: aload_0
    //   270: getfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   273: invokevirtual mutableCopy : ()Lcom/google/protobuf/MapFieldLite;
    //   276: putfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   279: getstatic com/google/api/QuotaLimit$ValuesDefaultEntryHolder.defaultEntry : Lcom/google/protobuf/MapEntryLite;
    //   282: aload_0
    //   283: getfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   286: aload_1
    //   287: aload_2
    //   288: invokevirtual parseInto : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)V
    //   291: goto -> 124
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   299: putfield unit_ : Ljava/lang/String;
    //   302: goto -> 124
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   310: putfield metric_ : Ljava/lang/String;
    //   313: goto -> 124
    //   316: aload_0
    //   317: aload_1
    //   318: invokevirtual readInt64 : ()J
    //   321: putfield freeTier_ : J
    //   324: goto -> 124
    //   327: aload_0
    //   328: aload_1
    //   329: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   332: putfield name_ : Ljava/lang/String;
    //   335: goto -> 124
    //   338: aload_0
    //   339: aload_1
    //   340: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   343: putfield duration_ : Ljava/lang/String;
    //   346: goto -> 124
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual readInt64 : ()J
    //   354: putfield maxLimit_ : J
    //   357: goto -> 124
    //   360: aload_0
    //   361: aload_1
    //   362: invokevirtual readInt64 : ()J
    //   365: putfield defaultLimit_ : J
    //   368: goto -> 124
    //   371: aload_0
    //   372: aload_1
    //   373: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   376: putfield description_ : Ljava/lang/String;
    //   379: goto -> 124
    //   382: iconst_1
    //   383: istore #5
    //   385: goto -> 124
    //   388: iload #6
    //   390: ifne -> 124
    //   393: iconst_1
    //   394: istore #5
    //   396: goto -> 124
    //   399: astore_1
    //   400: goto -> 447
    //   403: astore_3
    //   404: new java/lang/RuntimeException
    //   407: astore_2
    //   408: new com/google/protobuf/InvalidProtocolBufferException
    //   411: astore_1
    //   412: aload_1
    //   413: aload_3
    //   414: invokevirtual getMessage : ()Ljava/lang/String;
    //   417: invokespecial <init> : (Ljava/lang/String;)V
    //   420: aload_2
    //   421: aload_1
    //   422: aload_0
    //   423: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   426: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   429: aload_2
    //   430: athrow
    //   431: astore_2
    //   432: new java/lang/RuntimeException
    //   435: astore_1
    //   436: aload_1
    //   437: aload_2
    //   438: aload_0
    //   439: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   442: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   445: aload_1
    //   446: athrow
    //   447: aload_1
    //   448: athrow
    //   449: getstatic com/google/api/QuotaLimit.DEFAULT_INSTANCE : Lcom/google/api/QuotaLimit;
    //   452: areturn
    //   453: aload_2
    //   454: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   457: astore_1
    //   458: aload_3
    //   459: checkcast com/google/api/QuotaLimit
    //   462: astore_2
    //   463: aload_0
    //   464: aload_1
    //   465: aload_0
    //   466: getfield name_ : Ljava/lang/String;
    //   469: invokevirtual isEmpty : ()Z
    //   472: iconst_1
    //   473: ixor
    //   474: aload_0
    //   475: getfield name_ : Ljava/lang/String;
    //   478: aload_2
    //   479: getfield name_ : Ljava/lang/String;
    //   482: invokevirtual isEmpty : ()Z
    //   485: iconst_1
    //   486: ixor
    //   487: aload_2
    //   488: getfield name_ : Ljava/lang/String;
    //   491: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   496: putfield name_ : Ljava/lang/String;
    //   499: aload_0
    //   500: aload_1
    //   501: aload_0
    //   502: getfield description_ : Ljava/lang/String;
    //   505: invokevirtual isEmpty : ()Z
    //   508: iconst_1
    //   509: ixor
    //   510: aload_0
    //   511: getfield description_ : Ljava/lang/String;
    //   514: aload_2
    //   515: getfield description_ : Ljava/lang/String;
    //   518: invokevirtual isEmpty : ()Z
    //   521: iconst_1
    //   522: ixor
    //   523: aload_2
    //   524: getfield description_ : Ljava/lang/String;
    //   527: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   532: putfield description_ : Ljava/lang/String;
    //   535: aload_0
    //   536: getfield defaultLimit_ : J
    //   539: lconst_0
    //   540: lcmp
    //   541: ifeq -> 550
    //   544: iconst_1
    //   545: istore #6
    //   547: goto -> 553
    //   550: iconst_0
    //   551: istore #6
    //   553: aload_0
    //   554: getfield defaultLimit_ : J
    //   557: lstore #7
    //   559: aload_2
    //   560: getfield defaultLimit_ : J
    //   563: lconst_0
    //   564: lcmp
    //   565: ifeq -> 574
    //   568: iconst_1
    //   569: istore #9
    //   571: goto -> 577
    //   574: iconst_0
    //   575: istore #9
    //   577: aload_0
    //   578: aload_1
    //   579: iload #6
    //   581: lload #7
    //   583: iload #9
    //   585: aload_2
    //   586: getfield defaultLimit_ : J
    //   589: invokeinterface visitLong : (ZJZJ)J
    //   594: putfield defaultLimit_ : J
    //   597: aload_0
    //   598: getfield maxLimit_ : J
    //   601: lconst_0
    //   602: lcmp
    //   603: ifeq -> 612
    //   606: iconst_1
    //   607: istore #6
    //   609: goto -> 615
    //   612: iconst_0
    //   613: istore #6
    //   615: aload_0
    //   616: getfield maxLimit_ : J
    //   619: lstore #7
    //   621: aload_2
    //   622: getfield maxLimit_ : J
    //   625: lconst_0
    //   626: lcmp
    //   627: ifeq -> 636
    //   630: iconst_1
    //   631: istore #9
    //   633: goto -> 639
    //   636: iconst_0
    //   637: istore #9
    //   639: aload_0
    //   640: aload_1
    //   641: iload #6
    //   643: lload #7
    //   645: iload #9
    //   647: aload_2
    //   648: getfield maxLimit_ : J
    //   651: invokeinterface visitLong : (ZJZJ)J
    //   656: putfield maxLimit_ : J
    //   659: aload_0
    //   660: getfield freeTier_ : J
    //   663: lconst_0
    //   664: lcmp
    //   665: ifeq -> 674
    //   668: iconst_1
    //   669: istore #6
    //   671: goto -> 677
    //   674: iconst_0
    //   675: istore #6
    //   677: aload_0
    //   678: getfield freeTier_ : J
    //   681: lstore #7
    //   683: aload_2
    //   684: getfield freeTier_ : J
    //   687: lconst_0
    //   688: lcmp
    //   689: ifeq -> 698
    //   692: iconst_1
    //   693: istore #9
    //   695: goto -> 701
    //   698: iconst_0
    //   699: istore #9
    //   701: aload_0
    //   702: aload_1
    //   703: iload #6
    //   705: lload #7
    //   707: iload #9
    //   709: aload_2
    //   710: getfield freeTier_ : J
    //   713: invokeinterface visitLong : (ZJZJ)J
    //   718: putfield freeTier_ : J
    //   721: aload_0
    //   722: aload_1
    //   723: aload_0
    //   724: getfield duration_ : Ljava/lang/String;
    //   727: invokevirtual isEmpty : ()Z
    //   730: iconst_1
    //   731: ixor
    //   732: aload_0
    //   733: getfield duration_ : Ljava/lang/String;
    //   736: aload_2
    //   737: getfield duration_ : Ljava/lang/String;
    //   740: invokevirtual isEmpty : ()Z
    //   743: iconst_1
    //   744: ixor
    //   745: aload_2
    //   746: getfield duration_ : Ljava/lang/String;
    //   749: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   754: putfield duration_ : Ljava/lang/String;
    //   757: aload_0
    //   758: aload_1
    //   759: aload_0
    //   760: getfield metric_ : Ljava/lang/String;
    //   763: invokevirtual isEmpty : ()Z
    //   766: iconst_1
    //   767: ixor
    //   768: aload_0
    //   769: getfield metric_ : Ljava/lang/String;
    //   772: aload_2
    //   773: getfield metric_ : Ljava/lang/String;
    //   776: invokevirtual isEmpty : ()Z
    //   779: iconst_1
    //   780: ixor
    //   781: aload_2
    //   782: getfield metric_ : Ljava/lang/String;
    //   785: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   790: putfield metric_ : Ljava/lang/String;
    //   793: aload_0
    //   794: aload_1
    //   795: aload_0
    //   796: getfield unit_ : Ljava/lang/String;
    //   799: invokevirtual isEmpty : ()Z
    //   802: iconst_1
    //   803: ixor
    //   804: aload_0
    //   805: getfield unit_ : Ljava/lang/String;
    //   808: aload_2
    //   809: getfield unit_ : Ljava/lang/String;
    //   812: invokevirtual isEmpty : ()Z
    //   815: iconst_1
    //   816: ixor
    //   817: aload_2
    //   818: getfield unit_ : Ljava/lang/String;
    //   821: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   826: putfield unit_ : Ljava/lang/String;
    //   829: aload_0
    //   830: aload_1
    //   831: aload_0
    //   832: getfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   835: aload_2
    //   836: invokespecial internalGetValues : ()Lcom/google/protobuf/MapFieldLite;
    //   839: invokeinterface visitMap : (Lcom/google/protobuf/MapFieldLite;Lcom/google/protobuf/MapFieldLite;)Lcom/google/protobuf/MapFieldLite;
    //   844: putfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   847: aload_0
    //   848: aload_1
    //   849: aload_0
    //   850: getfield displayName_ : Ljava/lang/String;
    //   853: invokevirtual isEmpty : ()Z
    //   856: iconst_1
    //   857: ixor
    //   858: aload_0
    //   859: getfield displayName_ : Ljava/lang/String;
    //   862: aload_2
    //   863: getfield displayName_ : Ljava/lang/String;
    //   866: invokevirtual isEmpty : ()Z
    //   869: iconst_1
    //   870: ixor
    //   871: aload_2
    //   872: getfield displayName_ : Ljava/lang/String;
    //   875: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   880: putfield displayName_ : Ljava/lang/String;
    //   883: aload_1
    //   884: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   887: if_acmpne -> 903
    //   890: aload_0
    //   891: aload_0
    //   892: getfield bitField0_ : I
    //   895: aload_2
    //   896: getfield bitField0_ : I
    //   899: ior
    //   900: putfield bitField0_ : I
    //   903: aload_0
    //   904: areturn
    //   905: new com/google/api/QuotaLimit$Builder
    //   908: dup
    //   909: aconst_null
    //   910: invokespecial <init> : (Lcom/google/api/QuotaLimit$1;)V
    //   913: areturn
    //   914: aload_0
    //   915: getfield values_ : Lcom/google/protobuf/MapFieldLite;
    //   918: invokevirtual makeImmutable : ()V
    //   921: aconst_null
    //   922: areturn
    //   923: getstatic com/google/api/QuotaLimit.DEFAULT_INSTANCE : Lcom/google/api/QuotaLimit;
    //   926: areturn
    //   927: new com/google/api/QuotaLimit
    //   930: dup
    //   931: invokespecial <init> : ()V
    //   934: areturn
    // Exception table:
    //   from	to	target	type
    //   77	98	104	finally
    //   98	101	104	finally
    //   105	108	104	finally
    //   129	135	431	com/google/protobuf/InvalidProtocolBufferException
    //   129	135	403	java/io/IOException
    //   129	135	399	finally
    //   236	244	431	com/google/protobuf/InvalidProtocolBufferException
    //   236	244	403	java/io/IOException
    //   236	244	399	finally
    //   247	255	431	com/google/protobuf/InvalidProtocolBufferException
    //   247	255	403	java/io/IOException
    //   247	255	399	finally
    //   258	279	431	com/google/protobuf/InvalidProtocolBufferException
    //   258	279	403	java/io/IOException
    //   258	279	399	finally
    //   279	291	431	com/google/protobuf/InvalidProtocolBufferException
    //   279	291	403	java/io/IOException
    //   279	291	399	finally
    //   294	302	431	com/google/protobuf/InvalidProtocolBufferException
    //   294	302	403	java/io/IOException
    //   294	302	399	finally
    //   305	313	431	com/google/protobuf/InvalidProtocolBufferException
    //   305	313	403	java/io/IOException
    //   305	313	399	finally
    //   316	324	431	com/google/protobuf/InvalidProtocolBufferException
    //   316	324	403	java/io/IOException
    //   316	324	399	finally
    //   327	335	431	com/google/protobuf/InvalidProtocolBufferException
    //   327	335	403	java/io/IOException
    //   327	335	399	finally
    //   338	346	431	com/google/protobuf/InvalidProtocolBufferException
    //   338	346	403	java/io/IOException
    //   338	346	399	finally
    //   349	357	431	com/google/protobuf/InvalidProtocolBufferException
    //   349	357	403	java/io/IOException
    //   349	357	399	finally
    //   360	368	431	com/google/protobuf/InvalidProtocolBufferException
    //   360	368	403	java/io/IOException
    //   360	368	399	finally
    //   371	379	431	com/google/protobuf/InvalidProtocolBufferException
    //   371	379	403	java/io/IOException
    //   371	379	399	finally
    //   404	431	399	finally
    //   432	447	399	finally
  }
  
  public long getDefaultLimit() {
    return this.defaultLimit_;
  }
  
  public String getDescription() {
    return this.description_;
  }
  
  public ByteString getDescriptionBytes() {
    return ByteString.copyFromUtf8(this.description_);
  }
  
  public String getDisplayName() {
    return this.displayName_;
  }
  
  public ByteString getDisplayNameBytes() {
    return ByteString.copyFromUtf8(this.displayName_);
  }
  
  public String getDuration() {
    return this.duration_;
  }
  
  public ByteString getDurationBytes() {
    return ByteString.copyFromUtf8(this.duration_);
  }
  
  public long getFreeTier() {
    return this.freeTier_;
  }
  
  public long getMaxLimit() {
    return this.maxLimit_;
  }
  
  public String getMetric() {
    return this.metric_;
  }
  
  public ByteString getMetricBytes() {
    return ByteString.copyFromUtf8(this.metric_);
  }
  
  public String getName() {
    return this.name_;
  }
  
  public ByteString getNameBytes() {
    return ByteString.copyFromUtf8(this.name_);
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    int j = 0;
    if (!this.description_.isEmpty())
      j = 0 + CodedOutputStream.computeStringSize(2, getDescription()); 
    long l = this.defaultLimit_;
    i = j;
    if (l != 0L)
      i = j + CodedOutputStream.computeInt64Size(3, l); 
    l = this.maxLimit_;
    int k = i;
    if (l != 0L)
      k = i + CodedOutputStream.computeInt64Size(4, l); 
    j = k;
    if (!this.duration_.isEmpty())
      j = k + CodedOutputStream.computeStringSize(5, getDuration()); 
    i = j;
    if (!this.name_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(6, getName()); 
    l = this.freeTier_;
    j = i;
    if (l != 0L)
      j = i + CodedOutputStream.computeInt64Size(7, l); 
    i = j;
    if (!this.metric_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(8, getMetric()); 
    j = i;
    if (!this.unit_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(9, getUnit()); 
    for (Map.Entry entry : internalGetValues().entrySet())
      j += ValuesDefaultEntryHolder.defaultEntry.computeMessageSize(10, entry.getKey(), entry.getValue()); 
    i = j;
    if (!this.displayName_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(12, getDisplayName()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getUnit() {
    return this.unit_;
  }
  
  public ByteString getUnitBytes() {
    return ByteString.copyFromUtf8(this.unit_);
  }
  
  @Deprecated
  public Map<String, Long> getValues() {
    return getValuesMap();
  }
  
  public int getValuesCount() {
    return internalGetValues().size();
  }
  
  public Map<String, Long> getValuesMap() {
    return Collections.unmodifiableMap((Map<? extends String, ? extends Long>)internalGetValues());
  }
  
  public long getValuesOrDefault(String paramString, long paramLong) {
    if (paramString != null) {
      MapFieldLite<String, Long> mapFieldLite = internalGetValues();
      if (mapFieldLite.containsKey(paramString))
        paramLong = ((Long)mapFieldLite.get(paramString)).longValue(); 
      return paramLong;
    } 
    throw new NullPointerException();
  }
  
  public long getValuesOrThrow(String paramString) {
    if (paramString != null) {
      MapFieldLite<String, Long> mapFieldLite = internalGetValues();
      if (mapFieldLite.containsKey(paramString))
        return ((Long)mapFieldLite.get(paramString)).longValue(); 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(2, getDescription()); 
    long l = this.defaultLimit_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(3, l); 
    l = this.maxLimit_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(4, l); 
    if (!this.duration_.isEmpty())
      paramCodedOutputStream.writeString(5, getDuration()); 
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(6, getName()); 
    l = this.freeTier_;
    if (l != 0L)
      paramCodedOutputStream.writeInt64(7, l); 
    if (!this.metric_.isEmpty())
      paramCodedOutputStream.writeString(8, getMetric()); 
    if (!this.unit_.isEmpty())
      paramCodedOutputStream.writeString(9, getUnit()); 
    for (Map.Entry entry : internalGetValues().entrySet())
      ValuesDefaultEntryHolder.defaultEntry.serializeTo(paramCodedOutputStream, 10, entry.getKey(), entry.getValue()); 
    if (!this.displayName_.isEmpty())
      paramCodedOutputStream.writeString(12, getDisplayName()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<QuotaLimit, Builder> implements QuotaLimitOrBuilder {
    private Builder() {
      super(QuotaLimit.DEFAULT_INSTANCE);
    }
    
    public Builder clearDefaultLimit() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearDefaultLimit();
      return this;
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearDisplayName() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearDisplayName();
      return this;
    }
    
    public Builder clearDuration() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearDuration();
      return this;
    }
    
    public Builder clearFreeTier() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearFreeTier();
      return this;
    }
    
    public Builder clearMaxLimit() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearMaxLimit();
      return this;
    }
    
    public Builder clearMetric() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearMetric();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearName();
      return this;
    }
    
    public Builder clearUnit() {
      copyOnWrite();
      ((QuotaLimit)this.instance).clearUnit();
      return this;
    }
    
    public Builder clearValues() {
      copyOnWrite();
      ((QuotaLimit)this.instance).getMutableValuesMap().clear();
      return this;
    }
    
    public boolean containsValues(String param1String) {
      if (param1String != null)
        return ((QuotaLimit)this.instance).getValuesMap().containsKey(param1String); 
      throw new NullPointerException();
    }
    
    public long getDefaultLimit() {
      return ((QuotaLimit)this.instance).getDefaultLimit();
    }
    
    public String getDescription() {
      return ((QuotaLimit)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((QuotaLimit)this.instance).getDescriptionBytes();
    }
    
    public String getDisplayName() {
      return ((QuotaLimit)this.instance).getDisplayName();
    }
    
    public ByteString getDisplayNameBytes() {
      return ((QuotaLimit)this.instance).getDisplayNameBytes();
    }
    
    public String getDuration() {
      return ((QuotaLimit)this.instance).getDuration();
    }
    
    public ByteString getDurationBytes() {
      return ((QuotaLimit)this.instance).getDurationBytes();
    }
    
    public long getFreeTier() {
      return ((QuotaLimit)this.instance).getFreeTier();
    }
    
    public long getMaxLimit() {
      return ((QuotaLimit)this.instance).getMaxLimit();
    }
    
    public String getMetric() {
      return ((QuotaLimit)this.instance).getMetric();
    }
    
    public ByteString getMetricBytes() {
      return ((QuotaLimit)this.instance).getMetricBytes();
    }
    
    public String getName() {
      return ((QuotaLimit)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((QuotaLimit)this.instance).getNameBytes();
    }
    
    public String getUnit() {
      return ((QuotaLimit)this.instance).getUnit();
    }
    
    public ByteString getUnitBytes() {
      return ((QuotaLimit)this.instance).getUnitBytes();
    }
    
    @Deprecated
    public Map<String, Long> getValues() {
      return getValuesMap();
    }
    
    public int getValuesCount() {
      return ((QuotaLimit)this.instance).getValuesMap().size();
    }
    
    public Map<String, Long> getValuesMap() {
      return Collections.unmodifiableMap(((QuotaLimit)this.instance).getValuesMap());
    }
    
    public long getValuesOrDefault(String param1String, long param1Long) {
      if (param1String != null) {
        Map<String, Long> map = ((QuotaLimit)this.instance).getValuesMap();
        if (map.containsKey(param1String))
          param1Long = ((Long)map.get(param1String)).longValue(); 
        return param1Long;
      } 
      throw new NullPointerException();
    }
    
    public long getValuesOrThrow(String param1String) {
      if (param1String != null) {
        Map<String, Long> map = ((QuotaLimit)this.instance).getValuesMap();
        if (map.containsKey(param1String))
          return ((Long)map.get(param1String)).longValue(); 
        throw new IllegalArgumentException();
      } 
      throw new NullPointerException();
    }
    
    public Builder putAllValues(Map<String, Long> param1Map) {
      copyOnWrite();
      ((QuotaLimit)this.instance).getMutableValuesMap().putAll(param1Map);
      return this;
    }
    
    public Builder putValues(String param1String, long param1Long) {
      if (param1String != null) {
        copyOnWrite();
        ((QuotaLimit)this.instance).getMutableValuesMap().put(param1String, Long.valueOf(param1Long));
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder removeValues(String param1String) {
      if (param1String != null) {
        copyOnWrite();
        ((QuotaLimit)this.instance).getMutableValuesMap().remove(param1String);
        return this;
      } 
      throw new NullPointerException();
    }
    
    public Builder setDefaultLimit(long param1Long) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDefaultLimit(param1Long);
      return this;
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setDisplayName(String param1String) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDisplayName(param1String);
      return this;
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDisplayNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setDuration(String param1String) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDuration(param1String);
      return this;
    }
    
    public Builder setDurationBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setDurationBytes(param1ByteString);
      return this;
    }
    
    public Builder setFreeTier(long param1Long) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setFreeTier(param1Long);
      return this;
    }
    
    public Builder setMaxLimit(long param1Long) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setMaxLimit(param1Long);
      return this;
    }
    
    public Builder setMetric(String param1String) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setMetric(param1String);
      return this;
    }
    
    public Builder setMetricBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setMetricBytes(param1ByteString);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setUnit(String param1String) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setUnit(param1String);
      return this;
    }
    
    public Builder setUnitBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((QuotaLimit)this.instance).setUnitBytes(param1ByteString);
      return this;
    }
  }
  
  private static final class ValuesDefaultEntryHolder {
    static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, Long.valueOf(0L));
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\QuotaLimit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */