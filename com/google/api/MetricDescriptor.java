package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, MetricDescriptor.Builder> implements MetricDescriptorOrBuilder {
  private static final MetricDescriptor DEFAULT_INSTANCE = new MetricDescriptor();
  
  public static final int DESCRIPTION_FIELD_NUMBER = 6;
  
  public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
  
  public static final int LABELS_FIELD_NUMBER = 2;
  
  public static final int METRIC_KIND_FIELD_NUMBER = 3;
  
  public static final int NAME_FIELD_NUMBER = 1;
  
  private static volatile Parser<MetricDescriptor> PARSER;
  
  public static final int TYPE_FIELD_NUMBER = 8;
  
  public static final int UNIT_FIELD_NUMBER = 5;
  
  public static final int VALUE_TYPE_FIELD_NUMBER = 4;
  
  private int bitField0_;
  
  private String description_ = "";
  
  private String displayName_ = "";
  
  private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
  
  private int metricKind_;
  
  private String name_ = "";
  
  private String type_ = "";
  
  private String unit_ = "";
  
  private int valueType_;
  
  static {
    DEFAULT_INSTANCE.makeImmutable();
  }
  
  private void addAllLabels(Iterable<? extends LabelDescriptor> paramIterable) {
    ensureLabelsIsMutable();
    AbstractMessageLite.addAll(paramIterable, (Collection)this.labels_);
  }
  
  private void addLabels(int paramInt, LabelDescriptor.Builder paramBuilder) {
    ensureLabelsIsMutable();
    this.labels_.add(paramInt, paramBuilder.build());
  }
  
  private void addLabels(int paramInt, LabelDescriptor paramLabelDescriptor) {
    if (paramLabelDescriptor != null) {
      ensureLabelsIsMutable();
      this.labels_.add(paramInt, paramLabelDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void addLabels(LabelDescriptor.Builder paramBuilder) {
    ensureLabelsIsMutable();
    this.labels_.add(paramBuilder.build());
  }
  
  private void addLabels(LabelDescriptor paramLabelDescriptor) {
    if (paramLabelDescriptor != null) {
      ensureLabelsIsMutable();
      this.labels_.add(paramLabelDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void clearDescription() {
    this.description_ = getDefaultInstance().getDescription();
  }
  
  private void clearDisplayName() {
    this.displayName_ = getDefaultInstance().getDisplayName();
  }
  
  private void clearLabels() {
    this.labels_ = emptyProtobufList();
  }
  
  private void clearMetricKind() {
    this.metricKind_ = 0;
  }
  
  private void clearName() {
    this.name_ = getDefaultInstance().getName();
  }
  
  private void clearType() {
    this.type_ = getDefaultInstance().getType();
  }
  
  private void clearUnit() {
    this.unit_ = getDefaultInstance().getUnit();
  }
  
  private void clearValueType() {
    this.valueType_ = 0;
  }
  
  private void ensureLabelsIsMutable() {
    if (!this.labels_.isModifiable())
      this.labels_ = GeneratedMessageLite.mutableCopy(this.labels_); 
  }
  
  public static MetricDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  public static Builder newBuilder() {
    return (Builder)DEFAULT_INSTANCE.toBuilder();
  }
  
  public static Builder newBuilder(MetricDescriptor paramMetricDescriptor) {
    return (Builder)((Builder)DEFAULT_INSTANCE.toBuilder()).mergeFrom(paramMetricDescriptor);
  }
  
  public static MetricDescriptor parseDelimitedFrom(InputStream paramInputStream) throws IOException {
    return (MetricDescriptor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MetricDescriptor parseDelimitedFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricDescriptor)parseDelimitedFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(ByteString paramByteString) throws InvalidProtocolBufferException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString);
  }
  
  public static MetricDescriptor parseFrom(ByteString paramByteString, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramByteString, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(CodedInputStream paramCodedInputStream) throws IOException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream);
  }
  
  public static MetricDescriptor parseFrom(CodedInputStream paramCodedInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramCodedInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(InputStream paramInputStream) throws IOException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream);
  }
  
  public static MetricDescriptor parseFrom(InputStream paramInputStream, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramInputStream, paramExtensionRegistryLite);
  }
  
  public static MetricDescriptor parseFrom(byte[] paramArrayOfbyte) throws InvalidProtocolBufferException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte);
  }
  
  public static MetricDescriptor parseFrom(byte[] paramArrayOfbyte, ExtensionRegistryLite paramExtensionRegistryLite) throws InvalidProtocolBufferException {
    return (MetricDescriptor)GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, paramArrayOfbyte, paramExtensionRegistryLite);
  }
  
  public static Parser<MetricDescriptor> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
  
  private void removeLabels(int paramInt) {
    ensureLabelsIsMutable();
    this.labels_.remove(paramInt);
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
  
  private void setLabels(int paramInt, LabelDescriptor.Builder paramBuilder) {
    ensureLabelsIsMutable();
    this.labels_.set(paramInt, paramBuilder.build());
  }
  
  private void setLabels(int paramInt, LabelDescriptor paramLabelDescriptor) {
    if (paramLabelDescriptor != null) {
      ensureLabelsIsMutable();
      this.labels_.set(paramInt, paramLabelDescriptor);
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetricKind(MetricKind paramMetricKind) {
    if (paramMetricKind != null) {
      this.metricKind_ = paramMetricKind.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setMetricKindValue(int paramInt) {
    this.metricKind_ = paramInt;
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
  
  private void setType(String paramString) {
    if (paramString != null) {
      this.type_ = paramString;
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setTypeBytes(ByteString paramByteString) {
    if (paramByteString != null) {
      checkByteStringIsUtf8(paramByteString);
      this.type_ = paramByteString.toStringUtf8();
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
  
  private void setValueType(ValueType paramValueType) {
    if (paramValueType != null) {
      this.valueType_ = paramValueType.getNumber();
      return;
    } 
    throw new NullPointerException();
  }
  
  private void setValueTypeValue(int paramInt) {
    this.valueType_ = paramInt;
  }
  
  protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke paramMethodToInvoke, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: getstatic com/google/api/MetricDescriptor$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: istore #4
    //   10: iconst_0
    //   11: istore #5
    //   13: iconst_0
    //   14: istore #6
    //   16: iload #4
    //   18: tableswitch default -> 64, 1 -> 767, 2 -> 763, 3 -> 752, 4 -> 743, 5 -> 399, 6 -> 118, 7 -> 395, 8 -> 72
    //   64: new java/lang/UnsupportedOperationException
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: athrow
    //   72: getstatic com/google/api/MetricDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   75: ifnonnull -> 114
    //   78: ldc com/google/api/MetricDescriptor
    //   80: monitorenter
    //   81: getstatic com/google/api/MetricDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   84: ifnonnull -> 102
    //   87: new com/google/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser
    //   90: astore_1
    //   91: aload_1
    //   92: getstatic com/google/api/MetricDescriptor.DEFAULT_INSTANCE : Lcom/google/api/MetricDescriptor;
    //   95: invokespecial <init> : (Lcom/google/protobuf/GeneratedMessageLite;)V
    //   98: aload_1
    //   99: putstatic com/google/api/MetricDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   102: ldc com/google/api/MetricDescriptor
    //   104: monitorexit
    //   105: goto -> 114
    //   108: astore_1
    //   109: ldc com/google/api/MetricDescriptor
    //   111: monitorexit
    //   112: aload_1
    //   113: athrow
    //   114: getstatic com/google/api/MetricDescriptor.PARSER : Lcom/google/protobuf/Parser;
    //   117: areturn
    //   118: aload_2
    //   119: checkcast com/google/protobuf/CodedInputStream
    //   122: astore_1
    //   123: aload_3
    //   124: checkcast com/google/protobuf/ExtensionRegistryLite
    //   127: astore_2
    //   128: iload #6
    //   130: ifne -> 395
    //   133: aload_1
    //   134: invokevirtual readTag : ()I
    //   137: istore #4
    //   139: iload #4
    //   141: ifeq -> 339
    //   144: iload #4
    //   146: bipush #10
    //   148: if_icmpeq -> 328
    //   151: iload #4
    //   153: bipush #18
    //   155: if_icmpeq -> 281
    //   158: iload #4
    //   160: bipush #24
    //   162: if_icmpeq -> 270
    //   165: iload #4
    //   167: bipush #32
    //   169: if_icmpeq -> 259
    //   172: iload #4
    //   174: bipush #42
    //   176: if_icmpeq -> 248
    //   179: iload #4
    //   181: bipush #50
    //   183: if_icmpeq -> 237
    //   186: iload #4
    //   188: bipush #58
    //   190: if_icmpeq -> 226
    //   193: iload #4
    //   195: bipush #66
    //   197: if_icmpeq -> 215
    //   200: aload_1
    //   201: iload #4
    //   203: invokevirtual skipField : (I)Z
    //   206: ifne -> 128
    //   209: iconst_1
    //   210: istore #6
    //   212: goto -> 128
    //   215: aload_0
    //   216: aload_1
    //   217: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   220: putfield type_ : Ljava/lang/String;
    //   223: goto -> 128
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   231: putfield displayName_ : Ljava/lang/String;
    //   234: goto -> 128
    //   237: aload_0
    //   238: aload_1
    //   239: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   242: putfield description_ : Ljava/lang/String;
    //   245: goto -> 128
    //   248: aload_0
    //   249: aload_1
    //   250: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   253: putfield unit_ : Ljava/lang/String;
    //   256: goto -> 128
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual readEnum : ()I
    //   264: putfield valueType_ : I
    //   267: goto -> 128
    //   270: aload_0
    //   271: aload_1
    //   272: invokevirtual readEnum : ()I
    //   275: putfield metricKind_ : I
    //   278: goto -> 128
    //   281: aload_0
    //   282: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   285: invokeinterface isModifiable : ()Z
    //   290: ifne -> 304
    //   293: aload_0
    //   294: aload_0
    //   295: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   298: invokestatic mutableCopy : (Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   301: putfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   304: aload_0
    //   305: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   308: aload_1
    //   309: invokestatic parser : ()Lcom/google/protobuf/Parser;
    //   312: aload_2
    //   313: invokevirtual readMessage : (Lcom/google/protobuf/Parser;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite;
    //   316: checkcast com/google/api/LabelDescriptor
    //   319: invokeinterface add : (Ljava/lang/Object;)Z
    //   324: pop
    //   325: goto -> 128
    //   328: aload_0
    //   329: aload_1
    //   330: invokevirtual readStringRequireUtf8 : ()Ljava/lang/String;
    //   333: putfield name_ : Ljava/lang/String;
    //   336: goto -> 128
    //   339: iconst_1
    //   340: istore #6
    //   342: goto -> 128
    //   345: astore_1
    //   346: goto -> 393
    //   349: astore_3
    //   350: new java/lang/RuntimeException
    //   353: astore_1
    //   354: new com/google/protobuf/InvalidProtocolBufferException
    //   357: astore_2
    //   358: aload_2
    //   359: aload_3
    //   360: invokevirtual getMessage : ()Ljava/lang/String;
    //   363: invokespecial <init> : (Ljava/lang/String;)V
    //   366: aload_1
    //   367: aload_2
    //   368: aload_0
    //   369: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   372: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   375: aload_1
    //   376: athrow
    //   377: astore_1
    //   378: new java/lang/RuntimeException
    //   381: astore_2
    //   382: aload_2
    //   383: aload_1
    //   384: aload_0
    //   385: invokevirtual setUnfinishedMessage : (Lcom/google/protobuf/MessageLite;)Lcom/google/protobuf/InvalidProtocolBufferException;
    //   388: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   391: aload_2
    //   392: athrow
    //   393: aload_1
    //   394: athrow
    //   395: getstatic com/google/api/MetricDescriptor.DEFAULT_INSTANCE : Lcom/google/api/MetricDescriptor;
    //   398: areturn
    //   399: aload_2
    //   400: checkcast com/google/protobuf/GeneratedMessageLite$Visitor
    //   403: astore_1
    //   404: aload_3
    //   405: checkcast com/google/api/MetricDescriptor
    //   408: astore_2
    //   409: aload_0
    //   410: aload_1
    //   411: aload_0
    //   412: getfield name_ : Ljava/lang/String;
    //   415: invokevirtual isEmpty : ()Z
    //   418: iconst_1
    //   419: ixor
    //   420: aload_0
    //   421: getfield name_ : Ljava/lang/String;
    //   424: aload_2
    //   425: getfield name_ : Ljava/lang/String;
    //   428: invokevirtual isEmpty : ()Z
    //   431: iconst_1
    //   432: ixor
    //   433: aload_2
    //   434: getfield name_ : Ljava/lang/String;
    //   437: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   442: putfield name_ : Ljava/lang/String;
    //   445: aload_0
    //   446: aload_1
    //   447: aload_0
    //   448: getfield type_ : Ljava/lang/String;
    //   451: invokevirtual isEmpty : ()Z
    //   454: iconst_1
    //   455: ixor
    //   456: aload_0
    //   457: getfield type_ : Ljava/lang/String;
    //   460: aload_2
    //   461: getfield type_ : Ljava/lang/String;
    //   464: invokevirtual isEmpty : ()Z
    //   467: iconst_1
    //   468: ixor
    //   469: aload_2
    //   470: getfield type_ : Ljava/lang/String;
    //   473: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   478: putfield type_ : Ljava/lang/String;
    //   481: aload_0
    //   482: aload_1
    //   483: aload_0
    //   484: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   487: aload_2
    //   488: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   491: invokeinterface visitList : (Lcom/google/protobuf/Internal$ProtobufList;Lcom/google/protobuf/Internal$ProtobufList;)Lcom/google/protobuf/Internal$ProtobufList;
    //   496: putfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   499: aload_0
    //   500: getfield metricKind_ : I
    //   503: ifeq -> 512
    //   506: iconst_1
    //   507: istore #7
    //   509: goto -> 515
    //   512: iconst_0
    //   513: istore #7
    //   515: aload_0
    //   516: getfield metricKind_ : I
    //   519: istore #6
    //   521: aload_2
    //   522: getfield metricKind_ : I
    //   525: ifeq -> 534
    //   528: iconst_1
    //   529: istore #8
    //   531: goto -> 537
    //   534: iconst_0
    //   535: istore #8
    //   537: aload_0
    //   538: aload_1
    //   539: iload #7
    //   541: iload #6
    //   543: iload #8
    //   545: aload_2
    //   546: getfield metricKind_ : I
    //   549: invokeinterface visitInt : (ZIZI)I
    //   554: putfield metricKind_ : I
    //   557: aload_0
    //   558: getfield valueType_ : I
    //   561: ifeq -> 570
    //   564: iconst_1
    //   565: istore #7
    //   567: goto -> 573
    //   570: iconst_0
    //   571: istore #7
    //   573: aload_0
    //   574: getfield valueType_ : I
    //   577: istore #6
    //   579: iload #5
    //   581: istore #8
    //   583: aload_2
    //   584: getfield valueType_ : I
    //   587: ifeq -> 593
    //   590: iconst_1
    //   591: istore #8
    //   593: aload_0
    //   594: aload_1
    //   595: iload #7
    //   597: iload #6
    //   599: iload #8
    //   601: aload_2
    //   602: getfield valueType_ : I
    //   605: invokeinterface visitInt : (ZIZI)I
    //   610: putfield valueType_ : I
    //   613: aload_0
    //   614: aload_1
    //   615: aload_0
    //   616: getfield unit_ : Ljava/lang/String;
    //   619: invokevirtual isEmpty : ()Z
    //   622: iconst_1
    //   623: ixor
    //   624: aload_0
    //   625: getfield unit_ : Ljava/lang/String;
    //   628: aload_2
    //   629: getfield unit_ : Ljava/lang/String;
    //   632: invokevirtual isEmpty : ()Z
    //   635: iconst_1
    //   636: ixor
    //   637: aload_2
    //   638: getfield unit_ : Ljava/lang/String;
    //   641: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   646: putfield unit_ : Ljava/lang/String;
    //   649: aload_0
    //   650: aload_1
    //   651: aload_0
    //   652: getfield description_ : Ljava/lang/String;
    //   655: invokevirtual isEmpty : ()Z
    //   658: iconst_1
    //   659: ixor
    //   660: aload_0
    //   661: getfield description_ : Ljava/lang/String;
    //   664: aload_2
    //   665: getfield description_ : Ljava/lang/String;
    //   668: invokevirtual isEmpty : ()Z
    //   671: iconst_1
    //   672: ixor
    //   673: aload_2
    //   674: getfield description_ : Ljava/lang/String;
    //   677: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   682: putfield description_ : Ljava/lang/String;
    //   685: aload_0
    //   686: aload_1
    //   687: aload_0
    //   688: getfield displayName_ : Ljava/lang/String;
    //   691: invokevirtual isEmpty : ()Z
    //   694: iconst_1
    //   695: ixor
    //   696: aload_0
    //   697: getfield displayName_ : Ljava/lang/String;
    //   700: aload_2
    //   701: getfield displayName_ : Ljava/lang/String;
    //   704: invokevirtual isEmpty : ()Z
    //   707: iconst_1
    //   708: ixor
    //   709: aload_2
    //   710: getfield displayName_ : Ljava/lang/String;
    //   713: invokeinterface visitString : (ZLjava/lang/String;ZLjava/lang/String;)Ljava/lang/String;
    //   718: putfield displayName_ : Ljava/lang/String;
    //   721: aload_1
    //   722: getstatic com/google/protobuf/GeneratedMessageLite$MergeFromVisitor.INSTANCE : Lcom/google/protobuf/GeneratedMessageLite$MergeFromVisitor;
    //   725: if_acmpne -> 741
    //   728: aload_0
    //   729: aload_0
    //   730: getfield bitField0_ : I
    //   733: aload_2
    //   734: getfield bitField0_ : I
    //   737: ior
    //   738: putfield bitField0_ : I
    //   741: aload_0
    //   742: areturn
    //   743: new com/google/api/MetricDescriptor$Builder
    //   746: dup
    //   747: aconst_null
    //   748: invokespecial <init> : (Lcom/google/api/MetricDescriptor$1;)V
    //   751: areturn
    //   752: aload_0
    //   753: getfield labels_ : Lcom/google/protobuf/Internal$ProtobufList;
    //   756: invokeinterface makeImmutable : ()V
    //   761: aconst_null
    //   762: areturn
    //   763: getstatic com/google/api/MetricDescriptor.DEFAULT_INSTANCE : Lcom/google/api/MetricDescriptor;
    //   766: areturn
    //   767: new com/google/api/MetricDescriptor
    //   770: dup
    //   771: invokespecial <init> : ()V
    //   774: areturn
    // Exception table:
    //   from	to	target	type
    //   81	102	108	finally
    //   102	105	108	finally
    //   109	112	108	finally
    //   133	139	377	com/google/protobuf/InvalidProtocolBufferException
    //   133	139	349	java/io/IOException
    //   133	139	345	finally
    //   200	209	377	com/google/protobuf/InvalidProtocolBufferException
    //   200	209	349	java/io/IOException
    //   200	209	345	finally
    //   215	223	377	com/google/protobuf/InvalidProtocolBufferException
    //   215	223	349	java/io/IOException
    //   215	223	345	finally
    //   226	234	377	com/google/protobuf/InvalidProtocolBufferException
    //   226	234	349	java/io/IOException
    //   226	234	345	finally
    //   237	245	377	com/google/protobuf/InvalidProtocolBufferException
    //   237	245	349	java/io/IOException
    //   237	245	345	finally
    //   248	256	377	com/google/protobuf/InvalidProtocolBufferException
    //   248	256	349	java/io/IOException
    //   248	256	345	finally
    //   259	267	377	com/google/protobuf/InvalidProtocolBufferException
    //   259	267	349	java/io/IOException
    //   259	267	345	finally
    //   270	278	377	com/google/protobuf/InvalidProtocolBufferException
    //   270	278	349	java/io/IOException
    //   270	278	345	finally
    //   281	304	377	com/google/protobuf/InvalidProtocolBufferException
    //   281	304	349	java/io/IOException
    //   281	304	345	finally
    //   304	325	377	com/google/protobuf/InvalidProtocolBufferException
    //   304	325	349	java/io/IOException
    //   304	325	345	finally
    //   328	336	377	com/google/protobuf/InvalidProtocolBufferException
    //   328	336	349	java/io/IOException
    //   328	336	345	finally
    //   350	377	345	finally
    //   378	393	345	finally
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
  
  public LabelDescriptor getLabels(int paramInt) {
    return (LabelDescriptor)this.labels_.get(paramInt);
  }
  
  public int getLabelsCount() {
    return this.labels_.size();
  }
  
  public List<LabelDescriptor> getLabelsList() {
    return (List<LabelDescriptor>)this.labels_;
  }
  
  public LabelDescriptorOrBuilder getLabelsOrBuilder(int paramInt) {
    return (LabelDescriptorOrBuilder)this.labels_.get(paramInt);
  }
  
  public List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
    return (List)this.labels_;
  }
  
  public MetricKind getMetricKind() {
    MetricKind metricKind1 = MetricKind.forNumber(this.metricKind_);
    MetricKind metricKind2 = metricKind1;
    if (metricKind1 == null)
      metricKind2 = MetricKind.UNRECOGNIZED; 
    return metricKind2;
  }
  
  public int getMetricKindValue() {
    return this.metricKind_;
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
    boolean bool = this.name_.isEmpty();
    int j = 0;
    if (!bool) {
      i = CodedOutputStream.computeStringSize(1, getName()) + 0;
    } else {
      i = 0;
    } 
    while (j < this.labels_.size()) {
      i += CodedOutputStream.computeMessageSize(2, (MessageLite)this.labels_.get(j));
      j++;
    } 
    j = i;
    if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber())
      j = i + CodedOutputStream.computeEnumSize(3, this.metricKind_); 
    i = j;
    if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber())
      i = j + CodedOutputStream.computeEnumSize(4, this.valueType_); 
    j = i;
    if (!this.unit_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(5, getUnit()); 
    i = j;
    if (!this.description_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(6, getDescription()); 
    j = i;
    if (!this.displayName_.isEmpty())
      j = i + CodedOutputStream.computeStringSize(7, getDisplayName()); 
    i = j;
    if (!this.type_.isEmpty())
      i = j + CodedOutputStream.computeStringSize(8, getType()); 
    this.memoizedSerializedSize = i;
    return i;
  }
  
  public String getType() {
    return this.type_;
  }
  
  public ByteString getTypeBytes() {
    return ByteString.copyFromUtf8(this.type_);
  }
  
  public String getUnit() {
    return this.unit_;
  }
  
  public ByteString getUnitBytes() {
    return ByteString.copyFromUtf8(this.unit_);
  }
  
  public ValueType getValueType() {
    ValueType valueType1 = ValueType.forNumber(this.valueType_);
    ValueType valueType2 = valueType1;
    if (valueType1 == null)
      valueType2 = ValueType.UNRECOGNIZED; 
    return valueType2;
  }
  
  public int getValueTypeValue() {
    return this.valueType_;
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    if (!this.name_.isEmpty())
      paramCodedOutputStream.writeString(1, getName()); 
    for (byte b = 0; b < this.labels_.size(); b++)
      paramCodedOutputStream.writeMessage(2, (MessageLite)this.labels_.get(b)); 
    if (this.metricKind_ != MetricKind.METRIC_KIND_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(3, this.metricKind_); 
    if (this.valueType_ != ValueType.VALUE_TYPE_UNSPECIFIED.getNumber())
      paramCodedOutputStream.writeEnum(4, this.valueType_); 
    if (!this.unit_.isEmpty())
      paramCodedOutputStream.writeString(5, getUnit()); 
    if (!this.description_.isEmpty())
      paramCodedOutputStream.writeString(6, getDescription()); 
    if (!this.displayName_.isEmpty())
      paramCodedOutputStream.writeString(7, getDisplayName()); 
    if (!this.type_.isEmpty())
      paramCodedOutputStream.writeString(8, getType()); 
  }
  
  public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    private Builder() {
      super(MetricDescriptor.DEFAULT_INSTANCE);
    }
    
    public Builder addAllLabels(Iterable<? extends LabelDescriptor> param1Iterable) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).addAllLabels(param1Iterable);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).addLabels(param1Int, param1Builder);
      return this;
    }
    
    public Builder addLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).addLabels(param1Int, param1LabelDescriptor);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).addLabels(param1Builder);
      return this;
    }
    
    public Builder addLabels(LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).addLabels(param1LabelDescriptor);
      return this;
    }
    
    public Builder clearDescription() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearDescription();
      return this;
    }
    
    public Builder clearDisplayName() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearDisplayName();
      return this;
    }
    
    public Builder clearLabels() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearLabels();
      return this;
    }
    
    public Builder clearMetricKind() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearMetricKind();
      return this;
    }
    
    public Builder clearName() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearName();
      return this;
    }
    
    public Builder clearType() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearType();
      return this;
    }
    
    public Builder clearUnit() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearUnit();
      return this;
    }
    
    public Builder clearValueType() {
      copyOnWrite();
      ((MetricDescriptor)this.instance).clearValueType();
      return this;
    }
    
    public String getDescription() {
      return ((MetricDescriptor)this.instance).getDescription();
    }
    
    public ByteString getDescriptionBytes() {
      return ((MetricDescriptor)this.instance).getDescriptionBytes();
    }
    
    public String getDisplayName() {
      return ((MetricDescriptor)this.instance).getDisplayName();
    }
    
    public ByteString getDisplayNameBytes() {
      return ((MetricDescriptor)this.instance).getDisplayNameBytes();
    }
    
    public LabelDescriptor getLabels(int param1Int) {
      return ((MetricDescriptor)this.instance).getLabels(param1Int);
    }
    
    public int getLabelsCount() {
      return ((MetricDescriptor)this.instance).getLabelsCount();
    }
    
    public List<LabelDescriptor> getLabelsList() {
      return Collections.unmodifiableList(((MetricDescriptor)this.instance).getLabelsList());
    }
    
    public MetricDescriptor.MetricKind getMetricKind() {
      return ((MetricDescriptor)this.instance).getMetricKind();
    }
    
    public int getMetricKindValue() {
      return ((MetricDescriptor)this.instance).getMetricKindValue();
    }
    
    public String getName() {
      return ((MetricDescriptor)this.instance).getName();
    }
    
    public ByteString getNameBytes() {
      return ((MetricDescriptor)this.instance).getNameBytes();
    }
    
    public String getType() {
      return ((MetricDescriptor)this.instance).getType();
    }
    
    public ByteString getTypeBytes() {
      return ((MetricDescriptor)this.instance).getTypeBytes();
    }
    
    public String getUnit() {
      return ((MetricDescriptor)this.instance).getUnit();
    }
    
    public ByteString getUnitBytes() {
      return ((MetricDescriptor)this.instance).getUnitBytes();
    }
    
    public MetricDescriptor.ValueType getValueType() {
      return ((MetricDescriptor)this.instance).getValueType();
    }
    
    public int getValueTypeValue() {
      return ((MetricDescriptor)this.instance).getValueTypeValue();
    }
    
    public Builder removeLabels(int param1Int) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).removeLabels(param1Int);
      return this;
    }
    
    public Builder setDescription(String param1String) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setDescription(param1String);
      return this;
    }
    
    public Builder setDescriptionBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setDescriptionBytes(param1ByteString);
      return this;
    }
    
    public Builder setDisplayName(String param1String) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setDisplayName(param1String);
      return this;
    }
    
    public Builder setDisplayNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setDisplayNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor.Builder param1Builder) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setLabels(param1Int, param1Builder);
      return this;
    }
    
    public Builder setLabels(int param1Int, LabelDescriptor param1LabelDescriptor) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setLabels(param1Int, param1LabelDescriptor);
      return this;
    }
    
    public Builder setMetricKind(MetricDescriptor.MetricKind param1MetricKind) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setMetricKind(param1MetricKind);
      return this;
    }
    
    public Builder setMetricKindValue(int param1Int) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setMetricKindValue(param1Int);
      return this;
    }
    
    public Builder setName(String param1String) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setName(param1String);
      return this;
    }
    
    public Builder setNameBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setNameBytes(param1ByteString);
      return this;
    }
    
    public Builder setType(String param1String) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setType(param1String);
      return this;
    }
    
    public Builder setTypeBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setTypeBytes(param1ByteString);
      return this;
    }
    
    public Builder setUnit(String param1String) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setUnit(param1String);
      return this;
    }
    
    public Builder setUnitBytes(ByteString param1ByteString) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setUnitBytes(param1ByteString);
      return this;
    }
    
    public Builder setValueType(MetricDescriptor.ValueType param1ValueType) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setValueType(param1ValueType);
      return this;
    }
    
    public Builder setValueTypeValue(int param1Int) {
      copyOnWrite();
      ((MetricDescriptor)this.instance).setValueTypeValue(param1Int);
      return this;
    }
  }
  
  public enum MetricKind implements Internal.EnumLite {
    CUMULATIVE,
    DELTA,
    GAUGE,
    METRIC_KIND_UNSPECIFIED(0),
    UNRECOGNIZED(0);
    
    public static final int CUMULATIVE_VALUE = 3;
    
    public static final int DELTA_VALUE = 2;
    
    public static final int GAUGE_VALUE = 1;
    
    public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<MetricKind> internalValueMap;
    
    private final int value;
    
    static {
      DELTA = new MetricKind("DELTA", 2, 2);
      CUMULATIVE = new MetricKind("CUMULATIVE", 3, 3);
      UNRECOGNIZED = new MetricKind("UNRECOGNIZED", 4, -1);
      $VALUES = new MetricKind[] { METRIC_KIND_UNSPECIFIED, GAUGE, DELTA, CUMULATIVE, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<MetricKind>() {
          public MetricDescriptor.MetricKind findValueByNumber(int param2Int) {
            return MetricDescriptor.MetricKind.forNumber(param2Int);
          }
        };
    }
    
    MetricKind(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static MetricKind forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 3:
          return CUMULATIVE;
        case 2:
          return DELTA;
        case 1:
          return GAUGE;
        case 0:
          break;
      } 
      return METRIC_KIND_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<MetricKind> {
    public MetricDescriptor.MetricKind findValueByNumber(int param1Int) {
      return MetricDescriptor.MetricKind.forNumber(param1Int);
    }
  }
  
  public enum ValueType implements Internal.EnumLite {
    BOOL(0),
    DISTRIBUTION(0),
    DOUBLE(0),
    INT64(0),
    MONEY(0),
    STRING(0),
    UNRECOGNIZED(0),
    VALUE_TYPE_UNSPECIFIED(0);
    
    public static final int BOOL_VALUE = 1;
    
    public static final int DISTRIBUTION_VALUE = 5;
    
    public static final int DOUBLE_VALUE = 3;
    
    public static final int INT64_VALUE = 2;
    
    public static final int MONEY_VALUE = 6;
    
    public static final int STRING_VALUE = 4;
    
    public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
    
    private static final Internal.EnumLiteMap<ValueType> internalValueMap;
    
    private final int value;
    
    static {
      DOUBLE = new ValueType("DOUBLE", 3, 3);
      STRING = new ValueType("STRING", 4, 4);
      DISTRIBUTION = new ValueType("DISTRIBUTION", 5, 5);
      MONEY = new ValueType("MONEY", 6, 6);
      UNRECOGNIZED = new ValueType("UNRECOGNIZED", 7, -1);
      $VALUES = new ValueType[] { VALUE_TYPE_UNSPECIFIED, BOOL, INT64, DOUBLE, STRING, DISTRIBUTION, MONEY, UNRECOGNIZED };
      internalValueMap = new Internal.EnumLiteMap<ValueType>() {
          public MetricDescriptor.ValueType findValueByNumber(int param2Int) {
            return MetricDescriptor.ValueType.forNumber(param2Int);
          }
        };
    }
    
    ValueType(int param1Int1) {
      this.value = param1Int1;
    }
    
    public static ValueType forNumber(int param1Int) {
      switch (param1Int) {
        default:
          return null;
        case 6:
          return MONEY;
        case 5:
          return DISTRIBUTION;
        case 4:
          return STRING;
        case 3:
          return DOUBLE;
        case 2:
          return INT64;
        case 1:
          return BOOL;
        case 0:
          break;
      } 
      return VALUE_TYPE_UNSPECIFIED;
    }
    
    public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
      return internalValueMap;
    }
    
    public final int getNumber() {
      return this.value;
    }
  }
  
  class null implements Internal.EnumLiteMap<ValueType> {
    public MetricDescriptor.ValueType findValueByNumber(int param1Int) {
      return MetricDescriptor.ValueType.forNumber(param1Int);
    }
  }
}


/* Location:              Y:\classes-dex2jar.jar!\com\google\api\MetricDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */